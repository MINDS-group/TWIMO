#!/usr/bin/env python
"""Two-stage EAF pipeline with YOLO features and TRUE multi-horizon training.

For each prediction horizon h (steps), a SEPARATE Stage1+Stage2 model is trained
on labels shifted h timesteps into the future (point label):

    label_at_step_t  =  ground_truth[ window_end + h ]

This gives an apples-to-apples comparison across prediction horizons:

    h=0  → majority class INSIDE the window (backward-compatible behaviour)
    h=1  → predict 1 step  (~0.33 s at 3 Hz) ahead
    h=3  → predict 1 s ahead
    h=6  → predict 2 s ahead
    h=9  → predict 3 s ahead
    h=12 → predict 4 s ahead
    h=15 → predict 5 s ahead

All horizons use windows with a UNIFORM count: the loop bound is shifted back by
max(horizons) steps so that every label index falls inside the timeline regardless
of h (via the `max_horizon` margin of `create_windows`).

Models saved to:   {outdir}/horizon_{h}/
Summary table:     {outdir}/metrics_all_horizons.json

Subcommands:
  extract   – Extract YOLO detection features (delegates to two_stage_yolo)
  train     – Train Stage1+Stage2 for each horizon in one pass
  evaluate  – Load trained models, evaluate, and print comparison table

Usage:
  python -m twimo.strategies_eaf.two_stage_yolo_multi_horizon train \\
      --model xgboost \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/eaf/sensors/sensor \\
      --det-cache-dir ./artifacts/eaf/det_cache \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/two_stage_mh \\
      --horizons 0 1 2 3 6 9 12 15

  python -m twimo.strategies_eaf.two_stage_yolo_multi_horizon evaluate \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/eaf/sensors/sensor \\
      --det-cache-dir ./artifacts/eaf/det_cache \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --model-dir ./artifacts/two_stage_mh \\
      --outdir ./artifacts/two_stage_mh/eval \\
      --horizons 0 1 2 3 6 9 12 15
"""
from __future__ import annotations

import argparse
import json
import sys
from dataclasses import asdict, fields
from pathlib import Path
from typing import Any, Dict, List, Optional, Tuple

import numpy as np

# ---------------------------------------------------------------------------
# Imports from existing modules (NOT modified)
# ---------------------------------------------------------------------------

# YOLO extraction command (delegates entirely to two_stage_yolo)
from twimo.strategies_eaf.two_stage_yolo import cmd_extract

# Multi-model training / prediction / windowing helpers
from twimo.strategies_eaf.two_stage_multi_model import (
    ALL_MODELS,
    MultiModelConfig,
    NEURAL_MODELS,
    TREE_MODELS,
    balance_windows,
    create_windows,
    _train_neural_s1,
    _train_neural_s2,
    _train_tree_s1,
    _train_tree_s2,
)

# Session loading, day split, normalisation, and cascade evaluation from the
# YOLO multi-model script (avoids code duplication; private functions are
# still importable in Python).
from twimo.strategies_eaf.two_stage_yolo_multi_model import (
    _collect_sessions,
    _day_split,
    _evaluate_cascade,
    _normalize,
)

# ---------------------------------------------------------------------------
# Constants
# ---------------------------------------------------------------------------

_ALL_MODELS = ALL_MODELS   # gru, lstm, tcn, mlp_*, xgboost, lightgbm, random_forest


# ---------------------------------------------------------------------------
# Horizon-aware windowed splits
# ---------------------------------------------------------------------------

def _make_splits_horizon(
    sessions: List[Tuple[str, np.ndarray, np.ndarray, np.ndarray]],
    window_len: int,
    stride_len: int,
    test_days: set,
    val_days: set,
    horizon_steps: int = 0,
    max_horizon: int = 0,
) -> Dict[str, Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]]:
    """Build train / val / test splits for one prediction horizon.

    Passes `horizon_steps` and `max_horizon` through to `create_windows` so that:
    * horizon_steps > 0  → point label at ``goal[window_end + horizon_steps]``
    * max_horizon        → shrinks the loop bound so every horizon uses the
                           same set of window start positions (fair comparison).
    """
    buckets: Dict[str, List] = {"train": [], "val": [], "test": []}
    input_dim = sessions[0][1].shape[1] if sessions else 1

    for day_id, X, goal_vec, stim_vec in sessions:
        X_w, ev_w, g_w, s_w = create_windows(
            X, goal_vec, stim_vec, window_len, stride_len,
            horizon_steps=horizon_steps,
            max_horizon=max_horizon,
        )
        if len(X_w) == 0:
            continue
        key = "test" if day_id in test_days else "val" if day_id in val_days else "train"
        buckets[key].append((X_w, ev_w, g_w, s_w))

    result: Dict[str, Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]] = {}
    for key, bucket in buckets.items():
        if bucket:
            result[key] = (
                np.concatenate([b[0] for b in bucket]),
                np.concatenate([b[1] for b in bucket]),
                np.concatenate([b[2] for b in bucket]),
                np.concatenate([b[3] for b in bucket]),
            )
        else:
            result[key] = (
                np.zeros((0, window_len, input_dim), dtype=np.float32),
                np.zeros(0, dtype=np.int64),
                np.zeros(0, dtype=np.int64),
                np.zeros(0, dtype=np.int64),
            )
    return result


# ---------------------------------------------------------------------------
# Pretty-print summary table
# ---------------------------------------------------------------------------

def _print_summary_table(summary: Dict[str, Any], sample_hz: float) -> None:
    """Print a formatted multi-horizon comparison table to stdout."""
    if not summary:
        print("[!] No horizon results to summarize.")
        return

    col_w = (
        f"{'h':>4}  {'Time':>6}  {'N_test':>7}  {'Pred_ev':>7}  "
        f"{'S1_F1':>6}  {'Goal_F1':>7}  {'Stim_F1':>7}  "
        f"{'G_Oracle':>8}  {'S_Oracle':>8}"
    )
    sep = "─" * len(col_w)

    print()
    print("┌" + sep + "┐")
    print("│  MULTI-HORIZON TEST METRICS" + " " * (len(sep) - 28) + "│")
    print("├" + sep + "┤")
    print("│  " + col_w + "  │")
    print("├" + sep + "┤")

    for h_str in sorted(summary.keys(), key=int):
        m = summary[h_str]
        h   = m["horizon_steps"]
        t_s = m["horizon_sec"]
        row = (
            f"{h:>4}  {t_s:>5.2f}s  "
            f"{m['n_test']:>7d}  {m['n_predicted_events']:>7d}  "
            f"{m['stage1_f1']:>6.3f}  {m['goal_f1']:>7.3f}  "
            f"{m['stimuli_f1']:>7.3f}  "
            f"{m['goal_oracle_f1']:>8.3f}  {m['stimuli_oracle_f1']:>8.3f}"
        )
        print("│  " + row + "  │")

    print("└" + sep + "┘")


# ---------------------------------------------------------------------------
# CLI commands
# ---------------------------------------------------------------------------

def cmd_train(args: argparse.Namespace) -> None:
    """Train Stage1 + Stage2 separately for each prediction horizon."""
    outdir      = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    sample_hz    = float(args.sample_hz)
    window_sec   = float(args.window_sec)
    stride_sec   = float(getattr(args, "stride_sec", 1.0))
    horizons     = sorted(set(args.horizons))
    max_horizon  = max(horizons)
    threshold    = float(getattr(args, "event_threshold", 0.5))
    balance_ratio = getattr(args, "balance_ratio", None)

    print(f"=== Two-Stage YOLO Multi-Horizon: {args.model} ===")
    print(f"Horizons : {horizons}")
    print(f"Max margin: {max_horizon} steps  ({max_horizon / sample_hz:.2f} s)")
    print(f"Window   : {window_sec} s  Stride: {stride_sec} s  Hz: {sample_hz}")

    # ------------------------------------------------------------------
    # Load all sessions once (shared across every horizon)
    # ------------------------------------------------------------------
    sessions, goal_labels, stim_labels = _collect_sessions(
        Path(args.manifest),
        Path(args.prealigned_sensors_dir),
        Path(args.det_cache_dir),
        Path(args.eaf_parsed_dir) if getattr(args, "eaf_parsed_dir", None) else None,
        Path(args.vocab_dir),
        sample_hz,
    )
    if not sessions:
        print("[!] No valid sessions loaded. Aborting.")
        return

    n_goal    = len(goal_labels)
    n_stim    = len(stim_labels)
    input_dim = sessions[0][1].shape[1]
    print(f"Input dim: {input_dim}  Goal classes: {n_goal}  Stimuli classes: {n_stim}")

    # Day split — shared so all horizons see the same train/val/test sessions
    test_days, val_days = _day_split(sessions)
    n_train_sess = sum(1 for d, *_ in sessions if d not in test_days and d not in val_days)
    print(f"Sessions → train: {n_train_sess}  val/test: {len(val_days)}/{len(test_days)}")
    print(f"Test  days: {sorted(test_days)}")
    print(f"Val   days: {sorted(val_days)}")

    # Base config (same for all horizons)
    cfg_base = MultiModelConfig(
        model_type        = args.model,
        window_sec        = window_sec,
        stride_sec        = stride_sec,
        sample_hz         = sample_hz,
        n_goal_classes    = n_goal,
        n_stimuli_classes = n_stim,
        input_dim         = input_dim,
        epochs            = int(getattr(args, "epochs",     30)),
        lr                = float(getattr(args, "lr",       1e-4)),
        batch_size        = int(getattr(args, "batch_size", 64)),
        d_model           = int(getattr(args, "d_model",    128)),
        num_layers        = int(getattr(args, "num_layers", 2)),
        dropout           = float(getattr(args, "dropout",  0.1)),
    )

    summary: Dict[str, Any] = {}

    # ==================================================================
    # Per-horizon training loop
    # ==================================================================
    for h in horizons:
        print(f"\n{'='*64}")
        print(f"  HORIZON  h={h}  ({h / sample_hz:.2f} s ahead)  —  {args.model}")
        print(f"{'='*64}")

        h_outdir = outdir / f"horizon_{h}"
        h_outdir.mkdir(parents=True, exist_ok=True)

        # Build windowed train / val / test for this horizon ----------
        splits = _make_splits_horizon(
            sessions, cfg_base.window_len, cfg_base.stride_len,
            test_days, val_days,
            horizon_steps=h,
            max_horizon=max_horizon,
        )
        X_train, ev_train, g_train, s_train = splits["train"]
        X_val,   ev_val,   g_val,   s_val   = splits["val"]
        X_test,  ev_test,  g_test,  s_test  = splits["test"]

        print(f"  Windows — train: {len(X_train)}  val: {len(X_val)}  test: {len(X_test)}")
        if len(X_train) == 0:
            print(f"  [!] No training data for h={h}. Skipping.")
            continue
        print(f"  Train events: {int(ev_train.sum())}/{len(ev_train)} "
              f"({100.0 * ev_train.mean():.1f}%)")

        # Normalize (fit on this horizon's training split) ------------
        X_train, X_val, X_test, mean, std = _normalize(X_train, X_val, X_test)

        # Optional class-balance undersampling ------------------------
        if balance_ratio is not None:
            X_train, ev_train, g_train, s_train = balance_windows(
                X_train, ev_train, g_train, s_train,
                target_event_ratio=float(balance_ratio),
            )
            print(f"  After balancing: {len(X_train)} windows, "
                  f"{int(ev_train.sum())} events ({100.0 * ev_train.mean():.1f}%)")

        # Clone config (same hyper-params, different model file path) -
        cfg = MultiModelConfig(
            **{f.name: getattr(cfg_base, f.name) for f in fields(MultiModelConfig)}
        )

        # Save config + normalisation stats ---------------------------
        cfg_out: Dict[str, Any] = {
            **asdict(cfg),
            "goal_labels":    goal_labels,
            "stimuli_labels": stim_labels,
            "input_dim":      input_dim,
            "horizon_steps":  h,
            "horizon_sec":    round(h / sample_hz, 3),
            "max_horizon":    max_horizon,
            "all_horizons":   horizons,
        }
        (h_outdir / "config.json").write_text(json.dumps(cfg_out, indent=2))
        np.save(str(h_outdir / "norm_mean.npy"), mean)
        np.save(str(h_outdir / "norm_std.npy"),  std)

        # Stage 1 — Event Detection -----------------------------------
        print(f"\n  --- Stage 1: Event Detection (h={h}) ---")
        if args.model in NEURAL_MODELS:
            _train_neural_s1(X_train, ev_train, X_val, ev_val, cfg, h_outdir)
        else:
            _train_tree_s1(X_train, ev_train, X_val, ev_val, cfg, h_outdir)

        # Stage 2 — Goal + Stimuli Classification ---------------------
        print(f"\n  --- Stage 2: Goal + Stimuli (h={h}) ---")
        if args.model in NEURAL_MODELS:
            _train_neural_s2(
                X_train, ev_train, g_train, s_train,
                X_val,   ev_val,   g_val,   s_val,
                cfg, h_outdir, goal_labels, stim_labels,
            )
        else:
            _train_tree_s2(
                X_train, ev_train, g_train, s_train,
                X_val,   ev_val,   g_val,   s_val,
                cfg, h_outdir, goal_labels, stim_labels,
            )

        # Test evaluation ---------------------------------------------
        print(f"\n  --- Test Evaluation (threshold={threshold}) ---")
        if len(X_test) == 0:
            print(f"  [!] No test windows for h={h}.")
            continue

        results = _evaluate_cascade(
            X_test, ev_test, g_test, s_test,
            cfg, h_outdir, goal_labels, stim_labels, threshold,
        )
        (h_outdir / "test_metrics.json").write_text(
            json.dumps(results, indent=2, default=float)
        )
        print(
            f"  h={h:>2d} | S1={results['stage1_f1']:.3f}  "
            f"Goal={results['goal_f1']:.3f}  "
            f"Stim={results['stimuli_f1']:.3f}  "
            f"G-Oracle={results['goal_oracle_f1']:.3f}  "
            f"S-Oracle={results['stimuli_oracle_f1']:.3f}"
        )

        summary[str(h)] = {
            "horizon_steps":      h,
            "horizon_sec":        round(h / sample_hz, 3),
            "n_test":             results["n_test"],
            "n_predicted_events": results["n_predicted_events"],
            "stage1_f1":          float(results["stage1_f1"]),
            "goal_f1":            float(results["goal_f1"]),
            "stimuli_f1":         float(results["stimuli_f1"]),
            "goal_oracle_f1":     float(results["goal_oracle_f1"]),
            "stimuli_oracle_f1":  float(results["stimuli_oracle_f1"]),
        }

    # Final summary -------------------------------------------------------
    _print_summary_table(summary, sample_hz)
    summary_path = outdir / "metrics_all_horizons.json"
    summary_path.write_text(json.dumps(summary, indent=2, default=float))
    print(f"\nAll-horizons summary → {summary_path}")


def cmd_evaluate(args: argparse.Namespace) -> None:
    """Evaluate trained multi-horizon models and print a comparison table.

    Loads the model from each {model_dir}/horizon_{h}/ and re-creates the same
    day-based test split used during training.  Results are written per-horizon
    to {outdir}/horizon_{h}/eval_metrics.json and summarised in
    {outdir}/metrics_all_horizons.json.
    """
    base_dir  = Path(args.model_dir)
    outdir    = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    sample_hz = float(args.sample_hz)

    # Determine which horizons to evaluate -----------------------------------
    horizons: List[int] = list(getattr(args, "horizons", None) or [])
    if not horizons:
        # Auto-discover from existing horizon_* subdirectories
        found = []
        for p in base_dir.iterdir():
            if p.is_dir() and p.name.startswith("horizon_"):
                tail = p.name[len("horizon_"):]
                if tail.isdigit():
                    found.append(int(tail))
        horizons = sorted(found)
        if not horizons:
            print("[!] No horizon_* directories found in --model-dir. "
                  "Pass --horizons explicitly.")
            return
        print(f"Auto-discovered horizons: {horizons}")

    max_horizon = max(horizons)
    summary: Dict[str, Any] = {}

    for h in sorted(horizons):
        h_dir = base_dir / f"horizon_{h}"
        if not h_dir.is_dir():
            print(f"[!] {h_dir} not found — skipping h={h}.")
            continue

        cfg_path = h_dir / "config.json"
        if not cfg_path.exists():
            print(f"[!] config.json missing in {h_dir} — skipping h={h}.")
            continue

        # Load saved config --------------------------------------------------
        cfg_dict    = json.loads(cfg_path.read_text())
        goal_labels = cfg_dict.get("goal_labels", [])
        stim_labels = cfg_dict.get("stimuli_labels", [])
        hz          = float(cfg_dict.get("sample_hz", sample_hz))

        cfg_field_names = {f.name for f in fields(MultiModelConfig)}
        cfg = MultiModelConfig(
            **{k: v for k, v in cfg_dict.items() if k in cfg_field_names}
        )

        # Load normalisation stats -------------------------------------------
        mean = np.load(str(h_dir / "norm_mean.npy"))
        std  = np.load(str(h_dir / "norm_std.npy"))

        # Load sessions (same manifest) --------------------------------------
        sessions, _, _ = _collect_sessions(
            Path(args.manifest),
            Path(args.prealigned_sensors_dir),
            Path(args.det_cache_dir),
            Path(args.eaf_parsed_dir) if getattr(args, "eaf_parsed_dir", None) else None,
            Path(args.vocab_dir),
            hz,
        )
        if not sessions:
            print(f"[!] No sessions loaded — skipping h={h}.")
            continue

        # Reproduce the same chronological day split -------------------------
        test_days, val_days = _day_split(sessions)

        # Build test windows for this horizon --------------------------------
        splits = _make_splits_horizon(
            sessions, cfg.window_len, cfg.stride_len,
            test_days, val_days,
            horizon_steps=h,
            max_horizon=max_horizon,
        )
        X_test, ev_test, g_test, s_test = splits["test"]

        if len(X_test) == 0:
            print(f"[!] No test windows for h={h}.")
            continue

        X_test = (X_test - mean) / std
        threshold = float(getattr(args, "event_threshold", 0.5))

        results = _evaluate_cascade(
            X_test, ev_test, g_test, s_test,
            cfg, h_dir, goal_labels, stim_labels, threshold,
        )

        h_out = outdir / f"horizon_{h}"
        h_out.mkdir(parents=True, exist_ok=True)
        (h_out / "eval_metrics.json").write_text(
            json.dumps(results, indent=2, default=float)
        )

        print(
            f"h={h:>2d} | S1={results['stage1_f1']:.3f}  "
            f"Goal={results['goal_f1']:.3f}  "
            f"Stim={results['stimuli_f1']:.3f}  "
            f"G-Oracle={results['goal_oracle_f1']:.3f}  "
            f"S-Oracle={results['stimuli_oracle_f1']:.3f}"
        )

        summary[str(h)] = {
            "horizon_steps":      h,
            "horizon_sec":        round(h / hz, 3),
            "n_test":             results["n_test"],
            "n_predicted_events": results["n_predicted_events"],
            "stage1_f1":          float(results["stage1_f1"]),
            "goal_f1":            float(results["goal_f1"]),
            "stimuli_f1":         float(results["stimuli_f1"]),
            "goal_oracle_f1":     float(results["goal_oracle_f1"]),
            "stimuli_oracle_f1":  float(results["stimuli_oracle_f1"]),
        }

    _print_summary_table(summary, sample_hz)
    summary_path = outdir / "metrics_all_horizons.json"
    summary_path.write_text(json.dumps(summary, indent=2, default=float))
    print(f"\nAll-horizons summary → {summary_path}")


# ---------------------------------------------------------------------------
# Argument-parser helpers
# ---------------------------------------------------------------------------

def _add_data_args(p: argparse.ArgumentParser) -> None:
    p.add_argument("--manifest",               required=True,  type=Path,
                   help="Path to manifest.jsonl")
    p.add_argument("--prealigned-sensors-dir", required=True,  type=Path,
                   help="Directory with prealigned sensor .npy files")
    p.add_argument("--det-cache-dir",          required=True,  type=Path,
                   help="Directory with YOLO detection cache .npy files")
    p.add_argument("--eaf-parsed-dir",         default=None,   type=Path,
                   help="Directory with parsed EAF .json files (optional)")
    p.add_argument("--vocab-dir",              required=True,  type=Path,
                   help="Directory with goal/stimuli vocab .json files")
    p.add_argument("--outdir",                 required=True,  type=Path,
                   help="Output directory")


# ---------------------------------------------------------------------------
# CLI entry point
# ---------------------------------------------------------------------------

def main() -> None:
    parser = argparse.ArgumentParser(
        description=(
            "Two-stage EAF + YOLO pipeline with TRUE multi-horizon training. "
            "Trains a separate Stage1+Stage2 model for each prediction horizon."
        )
    )
    sub = parser.add_subparsers(dest="command", required=True)

    # ---- extract (delegates to two_stage_yolo cmd_extract) ----
    # cmd_extract expects args.det_cache_dir  (not args.outdir)
    p_ext = sub.add_parser(
        "extract",
        help="Extract YOLO detection features from videos (delegates to two_stage_yolo)",
    )
    p_ext.add_argument("--manifest",                required=True, type=Path)
    p_ext.add_argument("--det-cache-dir",           required=True, type=Path,
                       help="Output directory for detection cache .npy files")
    p_ext.add_argument("--prealigned-sensors-dir",  default=None,  type=Path,
                       help="Optional: prealigned sensor .npy dir (used to determine T)")
    p_ext.add_argument("--sample-hz",               type=float, default=3.0)
    p_ext.add_argument("--yolo-model",              type=str,   default="yolov8n.pt")
    p_ext.add_argument("--max-sessions",            type=int,   default=None)
    p_ext.add_argument("--overwrite",               action="store_true",
                       help="Re-extract even if cache file already exists")
    p_ext.set_defaults(func=cmd_extract)

    # ---- train ----
    p_tr = sub.add_parser(
        "train",
        help="Train Stage1+Stage2 for each prediction horizon in one pass",
    )
    _add_data_args(p_tr)
    p_tr.add_argument(
        "--model", required=True, choices=sorted(_ALL_MODELS),
        help="Model family (gru|lstm|tcn|mlp_*|xgboost|lightgbm|random_forest)",
    )
    p_tr.add_argument(
        "--horizons", nargs="+", type=int, default=[0], metavar="H",
        help=(
            "Prediction horizons in timesteps (default: 0). "
            "E.g. --horizons 0 1 2 3 6 9 12 15"
        ),
    )
    p_tr.add_argument("--sample-hz",       type=float, default=3.0,
                      help="Timeline sampling rate (default: 3 Hz)")
    p_tr.add_argument("--window-sec",      type=float, default=5.0,
                      help="Observation window length in seconds (default: 5)")
    p_tr.add_argument("--stride-sec",      type=float, default=1.0,
                      help="Stride between windows in seconds (default: 1)")
    p_tr.add_argument("--epochs",          type=int,   default=30)
    p_tr.add_argument("--lr",              type=float, default=1e-4)
    p_tr.add_argument("--batch-size",      type=int,   default=64)
    p_tr.add_argument("--d-model",         type=int,   default=128)
    p_tr.add_argument("--num-layers",      type=int,   default=2)
    p_tr.add_argument("--dropout",         type=float, default=0.1)
    p_tr.add_argument(
        "--balance-ratio", type=float, default=None,
        help="Target event ratio after undersampling (default: no balancing)",
    )
    p_tr.add_argument(
        "--event-threshold", type=float, default=0.5,
        help="Stage1 probability threshold for event gate (default: 0.5)",
    )
    p_tr.set_defaults(func=cmd_train)

    # ---- evaluate ----
    p_ev = sub.add_parser(
        "evaluate",
        help="Evaluate trained multi-horizon models and print comparison table",
    )
    p_ev.add_argument("--manifest",               required=True, type=Path)
    p_ev.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p_ev.add_argument("--det-cache-dir",          required=True, type=Path)
    p_ev.add_argument("--eaf-parsed-dir",         default=None,  type=Path)
    p_ev.add_argument("--vocab-dir",              required=True, type=Path)
    p_ev.add_argument(
        "--model-dir", required=True, type=Path,
        help="Base directory containing horizon_*/ subdirectories",
    )
    p_ev.add_argument("--outdir",                 required=True, type=Path)
    p_ev.add_argument(
        "--horizons", nargs="+", type=int, default=None, metavar="H",
        help=(
            "Horizons to evaluate (default: auto-discover from horizon_*/ dirs). "
            "E.g. --horizons 0 1 2 3 6 9 12 15"
        ),
    )
    p_ev.add_argument("--sample-hz",              type=float, default=3.0)
    p_ev.add_argument("--event-threshold",        type=float, default=0.5)
    p_ev.set_defaults(func=cmd_evaluate)

    args = parser.parse_args()
    args.func(args)


if __name__ == "__main__":
    main()
