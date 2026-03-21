#!/usr/bin/env python
"""Two-stage EAF pipeline with YOLO visual features and multi-model support.

Combines prealigned sensor .npy files with pre-extracted YOLO detection .npy
files and supports all model families: gru, lstm, tcn, mlp_mean/max/concat,
xgboost, lightgbm, random_forest, and transformer (delegated to two_stage_yolo).

Subcommands (run in order):
  extract   – Extract YOLO detection features (delegates to two_stage_yolo)
  train     – Train Stage1 + Stage2 with chosen model
  evaluate  – Evaluate a trained model on a manifest

Input:
  sensor  : prealigned .npy  (T, SENSOR_DIM)    -- e.g. 8 features
  det     : YOLO cache .npy  (T, D=13)          -- from cmd_extract
  combined: (T, SENSOR_DIM + 13) = (T, 21)

Usage:
  # Extract YOLO features (same as two_stage_yolo.py extract)
  python -m twimo.strategies_eaf.two_stage_yolo_multi_model extract \\
      --manifest ./artifacts/manifest.jsonl \\
      --outdir ./artifacts/eaf/det_cache \\
      --sample-hz 3

  # Train with XGBoost
  python -m twimo.strategies_eaf.two_stage_yolo_multi_model train \\
      --model xgboost \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \\
      --det-cache-dir ./artifacts/eaf/det_cache \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/two_stage_yolo_xgb \\
      --balance-ratio 0.5

  # Train with GRU
  python -m twimo.strategies_eaf.two_stage_yolo_multi_model train \\
      --model gru \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \\
      --det-cache-dir ./artifacts/eaf/det_cache \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/two_stage_yolo_gru

  # Evaluate
  python -m twimo.strategies_eaf.two_stage_yolo_multi_model evaluate \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \\
      --det-cache-dir ./artifacts/eaf/det_cache \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --model-dir ./artifacts/two_stage_yolo_xgb \\
      --outdir ./artifacts/two_stage_yolo_xgb/eval
"""
from __future__ import annotations

import argparse
import json
import sys
from dataclasses import asdict, fields
from pathlib import Path
from typing import Any, Dict, List, Optional, Tuple

import numpy as np

from twimo.utils.profiling import TrainingProfiler, measure_inference_time, save_combined_metrics

# ---------------------------------------------------------------------------
# Imports from existing modules (NOT modified)
# ---------------------------------------------------------------------------

# YOLO-specific components from two_stage_yolo.py
from twimo.strategies_eaf.two_stage_yolo import (
    D,
    DET_FEATURE_NAMES,
    YoloStageConfig,
    _EventNet,
    _ClassifyNet,
    _eaf_map,
    _label_vectors,
    _load_eaf_json,
    _load_vocab,
    cmd_extract,
)

# Multi-model training machinery from two_stage_multi_model.py
from twimo.strategies_eaf.two_stage_multi_model import (
    ALL_MODELS,
    MultiModelConfig,
    NEURAL_MODELS,
    TREE_MODELS,
    _predict_neural_s1_probs,
    _predict_neural_s2,
    _predict_tree_s1_probs,
    _predict_tree_s2,
    _train_neural_s1,
    _train_neural_s2,
    _train_tree_s1,
    _train_tree_s2,
    balance_windows,
    compute_metrics,
    create_windows,
    normalize_session_id,
)

from twimo.data.manifest import load_manifest

# ---------------------------------------------------------------------------
# Constants
# ---------------------------------------------------------------------------

DET_DIM = D          # 13 YOLO detection features
_TRANSFORMER = "transformer"
_ALL_MODELS = ALL_MODELS | {_TRANSFORMER}


# ---------------------------------------------------------------------------
# Internal helpers
# ---------------------------------------------------------------------------

def _load_vocabs(
    vocab_dir: Path,
) -> Tuple[
    List[str], Dict[str, str], Dict[str, int],  # goal
    List[str], Dict[str, str], Dict[str, int],  # stimuli
    List[str], Dict[str, str], Dict[str, int],  # cause
    List[str], Dict[str, str], Dict[str, int],  # attention
]:
    """Load goal, stimuli, cause, attention vocabs from vocab_dir."""
    def _try(name: str):
        p = vocab_dir / name
        if p.exists():
            try:
                return _load_vocab(p)
            except Exception:
                pass
        return [], {}, {}

    # Support both naming conventions: vocab_goal.json  OR  goal_vocab.json
    def _try2(a: str, b: str):
        r = _try(a)
        return r if r[0] else _try(b)

    g_l, g_lm, g_v = _try2("vocab_goal.json",     "goal_vocab.json")
    s_l, s_lm, s_v = _try2("vocab_stimuli.json",  "stimuli_vocab.json")
    c_l, c_lm, c_v = _try2("vocab_cause.json",    "cause_vocab.json")
    a_l, a_lm, a_v = _try2("vocab_attention.json", "attention_vocab.json")
    return g_l, g_lm, g_v, s_l, s_lm, s_v, c_l, c_lm, c_v, a_l, a_lm, a_v


def _collect_sessions(
    manifest_path: Path,
    sensor_dir: Path,
    det_cache_dir: Path,
    eaf_parsed_dir: Optional[Path],
    vocab_dir: Path,
    sample_hz: float,
) -> Tuple[
    List[Tuple[str, np.ndarray, np.ndarray, np.ndarray]],
    List[str],
    List[str],
]:
    """Load all sessions.

    Returns:
        sessions    : list of (day_id, X, goal_vec, stim_vec)
                      X        : (T, sensor_dim + D) float32
                      goal_vec : (T,) int64  ≥0  (0 = background)
                      stim_vec : (T,) int64  ≥0
        goal_labels : class names list
        stim_labels : class names list
    """
    g_l, g_lm, g_v, s_l, s_lm, s_v, c_l, c_lm, c_v, a_l, a_lm, a_v = _load_vocabs(vocab_dir)

    eaf_map: Dict[str, Path] = {}
    if eaf_parsed_dir is not None and eaf_parsed_dir.is_dir():
        eaf_map = _eaf_map(eaf_parsed_dir)

    records = load_manifest(manifest_path)
    sessions: List[Tuple[str, np.ndarray, np.ndarray, np.ndarray]] = []
    n_ok = n_skip = 0

    for rec in records:
        sid      = rec.session_id
        sid_norm = normalize_session_id(sid)

        # Locate sensor .npy
        sensor_path = sensor_dir / f"{sid}.npy"
        if not sensor_path.exists():
            sensor_path = sensor_dir / f"{sid_norm}.npy"

        # Locate detection .npy  (written by cmd_extract as  <sid>_det.npy)
        det_path = det_cache_dir / f"{sid}_det.npy"
        if not det_path.exists():
            det_path = det_cache_dir / f"{sid_norm}_det.npy"

        if not sensor_path.exists() or not det_path.exists():
            n_skip += 1
            continue

        # Locate EAF annotation
        eaf_path = eaf_map.get(sid) or eaf_map.get(sid_norm)
        if eaf_path is None:
            n_skip += 1
            continue

        try:
            sensors = np.load(str(sensor_path)).astype(np.float32)   # (T_s, n_s)
            det     = np.load(str(det_path)).astype(np.float32)       # (T_d, D)
            T       = min(len(sensors), len(det))
            if T < 30:
                n_skip += 1
                continue

            X = np.concatenate([sensors[:T], det[:T]], axis=1)        # (T, n_s+D)

            tiers = _load_eaf_json(eaf_path)
            _ev_vec, goal_raw, stim_raw, _c, _a = _label_vectors(
                T, sample_hz, tiers,
                g_lm, g_v,
                s_lm, s_v,
                c_lm, c_v,
                a_lm, a_v,
                t_offset_s=0.0,   # prealigned sensors: no offset
            )

            # _label_vectors uses -1 for "unlabelled"; convert to 0 (background)
            goal_vec = np.maximum(goal_raw, 0).astype(np.int64)
            stim_vec = np.maximum(stim_raw, 0).astype(np.int64)

            day_id = str(rec.day_id or sid[:8])
            sessions.append((day_id, X, goal_vec, stim_vec))
            n_ok += 1

        except Exception as exc:
            print(f"  [!] {sid}: {exc}")
            n_skip += 1

    print(f"Sessions loaded: {n_ok} ok, {n_skip} skipped")
    return sessions, g_l, s_l


def _day_split(
    sessions: List[Tuple[str, np.ndarray, np.ndarray, np.ndarray]],
    val_frac: float = 0.15,
    test_frac: float = 0.15,
) -> Tuple[set, set]:
    """Chronological day-based split. Returns (test_days, val_days)."""
    all_days = sorted({day for day, _, _, _ in sessions})
    n = len(all_days)
    n_test = max(1, round(n * test_frac))
    n_val  = max(1, round(n * val_frac))
    test_days = set(all_days[-n_test:])
    val_days  = set(all_days[-(n_test + n_val) : -n_test])
    return test_days, val_days


def _make_splits(
    sessions: List[Tuple[str, np.ndarray, np.ndarray, np.ndarray]],
    window_len: int,
    stride_len: int,
    test_days: set,
    val_days: set,
) -> Dict[str, Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]]:
    """Build windowed train / val / test splits."""
    buckets: Dict[str, List] = {"train": [], "val": [], "test": []}

    for day_id, X, goal_vec, stim_vec in sessions:
        X_w, ev_w, g_w, s_w = create_windows(X, goal_vec, stim_vec, window_len, stride_len)
        if len(X_w) == 0:
            continue
        key = "test" if day_id in test_days else "val" if day_id in val_days else "train"
        buckets[key].append((X_w, ev_w, g_w, s_w))

    result: Dict[str, Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]] = {}
    input_dim = sessions[0][1].shape[1] if sessions else 1
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


def _normalize(
    X_train: np.ndarray,
    X_val: np.ndarray,
    X_test: np.ndarray,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Fit normalization on training data, apply to all splits."""
    mean = X_train.mean(axis=(0, 1))
    std  = X_train.std(axis=(0, 1)) + 1e-8
    return (
        (X_train - mean) / std,
        (X_val   - mean) / std,
        (X_test  - mean) / std,
        mean, std,
    )


def _evaluate_cascade(
    X_test: np.ndarray,
    ev_test: np.ndarray,
    g_test: np.ndarray,
    s_test: np.ndarray,
    cfg: MultiModelConfig,
    model_dir: Path,
    goal_labels: List[str],
    stim_labels: List[str],
    threshold: float = 0.5,
) -> Dict[str, Any]:
    """Run Stage1 → Stage2 cascade and return full metrics dict."""
    model_type = cfg.model_type
    n_g = cfg.n_goal_classes    or (max(int(g_test.max()), 0) + 1 if len(g_test) > 0 else len(goal_labels))
    n_s = cfg.n_stimuli_classes or (max(int(s_test.max()), 0) + 1 if len(s_test) > 0 else len(stim_labels))
    is_neural = model_type in NEURAL_MODELS

    # Stage 1 ----------------------------------------------------------------
    if is_neural:
        ev_probs = _predict_neural_s1_probs(X_test, cfg, model_dir / "stage1.pt")
    else:
        ev_probs = _predict_tree_s1_probs(X_test, model_dir / "stage1_tree.joblib")
    ev_pred  = (ev_probs >= threshold).astype(np.int64)
    ev_mask  = ev_pred == 1

    # Stage 2 ----------------------------------------------------------------
    g_pred = np.zeros(len(X_test), dtype=np.int64)
    s_pred = np.zeros(len(X_test), dtype=np.int64)

    s2_path = model_dir / ("stage2.pt" if is_neural else "stage2_tree.joblib")

    if ev_mask.sum() > 0:
        X_events = X_test[ev_mask]
        if is_neural:
            g_ev, s_ev = _predict_neural_s2(X_events, cfg, s2_path)
        else:
            g_ev, s_ev = _predict_tree_s2(X_events, s2_path)
        g_pred[ev_mask] = g_ev
        s_pred[ev_mask] = s_ev

    # Oracle (Stage2 on ground-truth event windows) --------------------------
    ev_gt_mask = ev_test == 1
    g_oracle_metrics: Dict[str, Any] = {}
    s_oracle_metrics: Dict[str, Any] = {}

    if ev_gt_mask.sum() > 0:
        X_ev_gt = X_test[ev_gt_mask]
        if is_neural:
            g_or, s_or = _predict_neural_s2(X_ev_gt, cfg, s2_path)
        else:
            g_or, s_or = _predict_tree_s2(X_ev_gt, s2_path)
        g_names = goal_labels or [str(i) for i in range(n_g)]
        s_names = stim_labels or [str(i) for i in range(n_s)]
        g_oracle_metrics = compute_metrics(g_or, g_test[ev_gt_mask], n_g, g_names)
        s_oracle_metrics = compute_metrics(s_or, s_test[ev_gt_mask], n_s, s_names)

    # Metrics ----------------------------------------------------------------
    g_names = goal_labels or [str(i) for i in range(n_g)]
    s_names = stim_labels or [str(i) for i in range(n_s)]

    ev_metrics = compute_metrics(ev_pred, ev_test, 2, ["no_event", "event"])
    g_metrics  = compute_metrics(g_pred,  g_test,  n_g, g_names)
    s_metrics  = compute_metrics(s_pred,  s_test,  n_s, s_names)

    return {
        "n_test":                 int(len(X_test)),
        "n_predicted_events":     int(ev_mask.sum()),
        "n_actual_events":        int(ev_gt_mask.sum()),
        "stage1_f1":              float(ev_metrics.get("macro_f1", 0.0)),
        "goal_f1":                float(g_metrics.get("macro_f1", 0.0)),
        "stimuli_f1":             float(s_metrics.get("macro_f1", 0.0)),
        "goal_oracle_f1":         float(g_oracle_metrics.get("macro_f1", 0.0)),
        "stimuli_oracle_f1":      float(s_oracle_metrics.get("macro_f1", 0.0)),
        "event_metrics":          ev_metrics,
        "goal_metrics":           g_metrics,
        "stimuli_metrics":        s_metrics,
        "goal_oracle_metrics":    g_oracle_metrics,
        "stimuli_oracle_metrics": s_oracle_metrics,
    }


# ---------------------------------------------------------------------------
# Transformer multi-horizon evaluation helper
# ---------------------------------------------------------------------------

def _run_transformer_multihorizon(args: argparse.Namespace, outdir: Path) -> None:
    """Run multi-horizon evaluation for the transformer model after yolo_train completes."""
    import torch
    from torch.utils.data import DataLoader, TensorDataset

    # Load saved config
    cfg_path = outdir / "config.json"
    if not cfg_path.exists():
        print("[!] config.json not found — skipping multi-horizon evaluation.")
        return

    with open(cfg_path, encoding="utf-8") as f:
        cfg_dict = json.load(f)
    cfg = YoloStageConfig(**{k: v for k, v in cfg_dict.items()
                              if k in YoloStageConfig.__dataclass_fields__})

    mean = np.load(str(outdir / "norm_mean.npy"))
    std  = np.load(str(outdir / "norm_std.npy"))

    dev = torch.device(cfg.device)
    s1  = _EventNet(cfg).to(dev)
    s1.load_state_dict(torch.load(str(outdir / "stage1.pt"), map_location=dev, weights_only=False)["model_state"])
    s1.eval()

    s2  = _ClassifyNet(cfg).to(dev)
    s2.load_state_dict(torch.load(str(outdir / "stage2.pt"), map_location=dev, weights_only=False)["model_state"])
    s2.eval()

    # Load sessions (same pipeline as cmd_train)
    sample_hz = float(getattr(args, "sample_hz", cfg.sample_hz))
    sessions, goal_labels, stim_labels = _collect_sessions(
        Path(args.manifest),
        Path(args.prealigned_sensors_dir),
        Path(args.det_cache_dir),
        Path(args.eaf_parsed_dir) if getattr(args, "eaf_parsed_dir", None) else None,
        Path(args.vocab_dir),
        sample_hz,
    )
    if not sessions:
        print("[!] No sessions loaded for multi-horizon evaluation.")
        return

    test_days, _ = _day_split(sessions)
    test_sessions = [(d, X, g, s) for d, X, g, s in sessions if d in test_days]
    if not test_sessions:
        print("[!] No test sessions for multi-horizon evaluation.")
        return

    horizons_steps = [1, 2, 3, 6, 9, 12, 15]
    max_h_steps    = max(horizons_steps)
    batch_size     = int(getattr(args, "batch_size", cfg.batch_size if hasattr(cfg, "batch_size") else 64))

    def _predict_s1_probs(X: np.ndarray) -> np.ndarray:
        dl = DataLoader(TensorDataset(torch.from_numpy(X)), batch_size=batch_size)
        probs: List[np.ndarray] = []
        with torch.no_grad():
            for (xb,) in dl:
                p = torch.softmax(s1(xb.to(dev)), dim=1)[:, 1]
                probs.append(p.cpu().numpy())
        return np.concatenate(probs)

    def _predict_s2(X: np.ndarray) -> Tuple[np.ndarray, np.ndarray]:
        dl = DataLoader(TensorDataset(torch.from_numpy(X)), batch_size=batch_size)
        gp: List[np.ndarray] = []
        sp: List[np.ndarray] = []
        with torch.no_grad():
            for (xb,) in dl:
                g_l, s_l, _, _ = s2(xb.to(dev))
                gp.append(g_l.argmax(1).cpu().numpy())
                sp.append(s_l.argmax(1).cpu().numpy())
        return np.concatenate(gp), np.concatenate(sp)

    print(f"\n--- Transformer Multi-Horizon Evaluation ({len(horizons_steps)} horizons) ---")
    metrics_all_h: Dict[str, Any] = {}

    for h_steps in horizons_steps:
        h_s   = h_steps / sample_hz
        h_key = f"{h_s:.3f}s"

        stride = max(1, cfg.window_len // 3)
        buckets: List = []
        for _day, X_s, g_s, s_s in test_sessions:
            Xw, evw, gw, sw = create_windows(
                X_s, g_s, s_s,
                cfg.window_len, stride,
                horizon_steps=h_steps,
                max_horizon=max_h_steps,
            )
            if len(Xw) > 0:
                buckets.append((Xw, evw, gw, sw))

        if not buckets:
            continue

        Xh  = np.concatenate([b[0] for b in buckets])
        evh = np.concatenate([b[1] for b in buckets])
        gh  = np.concatenate([b[2] for b in buckets])
        sh  = np.concatenate([b[3] for b in buckets])

        Xh = (Xh - mean) / std

        # Stage1
        ev_probs = _predict_s1_probs(Xh)
        ev_pred  = (ev_probs >= 0.5).astype(np.int64)
        ev_mask  = ev_pred == 1

        # Stage2 on predicted events
        g_pred = np.zeros(len(Xh), dtype=np.int64)
        s_pred = np.zeros(len(Xh), dtype=np.int64)
        if ev_mask.sum() > 0:
            gp, sp = _predict_s2(Xh[ev_mask])
            g_pred[ev_mask] = gp
            s_pred[ev_mask] = sp

        # Oracle Stage2 on ground-truth events
        ev_gt_mask = evh == 1
        g_oracle_metrics: Dict[str, Any] = {}
        s_oracle_metrics: Dict[str, Any] = {}
        if ev_gt_mask.sum() > 0:
            n_g = int(gh.max()) + 1 if len(gh) > 0 else len(goal_labels)
            n_s = int(sh.max()) + 1 if len(sh) > 0 else len(stim_labels)
            g_names = goal_labels or [str(i) for i in range(n_g)]
            s_names = stim_labels or [str(i) for i in range(n_s)]
            g_or, s_or = _predict_s2(Xh[ev_gt_mask])
            g_oracle_metrics = compute_metrics(g_or, gh[ev_gt_mask], n_g, g_names)
            s_oracle_metrics = compute_metrics(s_or, sh[ev_gt_mask], n_s, s_names)

        n_g = int(gh.max()) + 1 if len(gh) > 0 else len(goal_labels)
        n_s = int(sh.max()) + 1 if len(sh) > 0 else len(stim_labels)
        g_names = goal_labels or [str(i) for i in range(n_g)]
        s_names = stim_labels or [str(i) for i in range(n_s)]

        ev_metrics = compute_metrics(ev_pred, evh, 2, ["no_event", "event"])
        g_metrics  = compute_metrics(g_pred,  gh,  n_g, g_names)
        s_metrics  = compute_metrics(s_pred,  sh,  n_s, s_names)

        res_h: Dict[str, Any] = {
            "n_test":                int(len(Xh)),
            "n_predicted_events":    int(ev_mask.sum()),
            "n_actual_events":       int(ev_gt_mask.sum()),
            "stage1_f1":             float(ev_metrics.get("macro_f1", 0.0)),
            "goal_f1":               float(g_metrics.get("macro_f1", 0.0)),
            "stimuli_f1":            float(s_metrics.get("macro_f1", 0.0)),
            "goal_oracle_f1":        float(g_oracle_metrics.get("macro_f1", 0.0)),
            "stimuli_oracle_f1":     float(s_oracle_metrics.get("macro_f1", 0.0)),
            "event_metrics":         ev_metrics,
            "goal_metrics":          g_metrics,
            "stimuli_metrics":       s_metrics,
            "goal_oracle_metrics":   g_oracle_metrics,
            "stimuli_oracle_metrics": s_oracle_metrics,
        }
        metrics_all_h[h_key] = res_h
        print(
            f"  h={h_key:<8}  n={len(Xh):>6}  "
            f"S1={res_h['stage1_f1']:.3f}  "
            f"Goal={res_h['goal_f1']:.3f}  "
            f"Stim={res_h['stimuli_f1']:.3f}"
        )

    if metrics_all_h:
        mh_path = outdir / "metrics_all_horizons.json"
        mh_path.write_text(json.dumps(metrics_all_h, indent=2, default=float))
        print(f"Multi-horizon metrics saved to {mh_path}")


# ---------------------------------------------------------------------------
# CLI commands
# ---------------------------------------------------------------------------

def cmd_train(args: argparse.Namespace) -> None:
    """Train Stage1 + Stage2 with sensor + YOLO detection features."""
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    # Delegate transformer training to original yolo pipeline, then run multi-horizon eval
    if args.model == _TRANSFORMER:
        from twimo.strategies_eaf.two_stage_yolo import cmd_train as yolo_train
        profiler = TrainingProfiler(
            model_name="two_stage_yolo_transformer",
            output_dir=outdir,
            use_codecarbon=True,
        )
        with profiler:
            profiler.begin_phase("training")
            yolo_train(args)
            profiler.end_phase("training")
            profiler.begin_phase("multihorizon_eval")
            _run_transformer_multihorizon(args, outdir)
            profiler.end_phase("multihorizon_eval")
        return

    sample_hz  = float(args.sample_hz)
    window_sec = float(args.window_sec)
    stride_sec = float(getattr(args, "stride_sec", 1.0))

    print(f"=== Two-Stage YOLO Multi-Model: {args.model} ===")

    profiler = TrainingProfiler(
        model_name=f"two_stage_yolo_{args.model}",
        output_dir=outdir,
        use_codecarbon=True,
    )

    with profiler:
        # Load sessions -------------------------------------------------------
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

        # Build config --------------------------------------------------------
        cfg = MultiModelConfig(
            model_type=args.model,
            window_sec=window_sec,
            stride_sec=stride_sec,
            sample_hz=sample_hz,
            n_goal_classes=n_goal,
            n_stimuli_classes=n_stim,
            input_dim=input_dim,
            epochs=int(getattr(args, "epochs", 30)),
            lr=float(getattr(args, "lr", 1e-4)),
            batch_size=int(getattr(args, "batch_size", 64)),
            d_model=int(getattr(args, "d_model", 128)),
            num_layers=int(getattr(args, "num_layers", 2)),
            dropout=float(getattr(args, "dropout", 0.1)),
        )

        # Day split + windowing -----------------------------------------------
        test_days, val_days = _day_split(sessions)
        splits = _make_splits(sessions, cfg.window_len, cfg.stride_len, test_days, val_days)

        X_train, ev_train, g_train, s_train = splits["train"]
        X_val,   ev_val,   g_val,   s_val   = splits["val"]
        X_test,  ev_test,  g_test,  s_test  = splits["test"]

        print(f"Windows — train: {len(X_train)}  val: {len(X_val)}  test: {len(X_test)}")
        if len(X_train) == 0:
            print("[!] No training data. Aborting.")
            return
        print(f"Train events: {int(ev_train.sum())}/{len(ev_train)} ({100*ev_train.mean():.1f}%)")

        # Normalize -----------------------------------------------------------
        X_train, X_val, X_test, mean, std = _normalize(X_train, X_val, X_test)

        # Optional balancing --------------------------------------------------
        balance_ratio = getattr(args, "balance_ratio", None)
        if balance_ratio is not None:
            X_train, ev_train, g_train, s_train = balance_windows(
                X_train, ev_train, g_train, s_train,
                event_ratio=float(balance_ratio),
            )
            print(f"After balancing: {len(X_train)} windows, "
                  f"{int(ev_train.sum())} events ({100*ev_train.mean():.1f}%)")

        # Save config + normalisation stats -----------------------------------
        cfg_out: Dict[str, Any] = {
            **asdict(cfg),
            "goal_labels":    goal_labels,
            "stimuli_labels": stim_labels,
            "input_dim":      input_dim,
        }
        (outdir / "config.json").write_text(json.dumps(cfg_out, indent=2))
        np.save(str(outdir / "norm_mean.npy"), mean)
        np.save(str(outdir / "norm_std.npy"),  std)

        # Train Stage 1 -------------------------------------------------------
        print("\n--- Stage 1: Event Detection ---")
        profiler.begin_phase("stage1_train", n_samples=int(len(X_train)))
        if args.model in NEURAL_MODELS:
            _train_neural_s1(X_train, ev_train, X_val, ev_val, cfg, outdir)
        else:
            _train_tree_s1(X_train, ev_train, X_val, ev_val, cfg, outdir)
        profiler.end_phase("stage1_train")

        # Train Stage 2 -------------------------------------------------------
        print("\n--- Stage 2: Goal + Stimuli Classification ---")
        profiler.begin_phase("stage2_train", n_samples=int(ev_train.sum()))
        if args.model in NEURAL_MODELS:
            _train_neural_s2(
                X_train, ev_train, g_train, s_train,
                X_val,   ev_val,   g_val,   s_val,
                cfg, outdir, goal_labels, stim_labels,
            )
        else:
            _train_tree_s2(
                X_train, ev_train, g_train, s_train,
                X_val,   ev_val,   g_val,   s_val,
                cfg, outdir, goal_labels, stim_labels,
            )
        profiler.end_phase("stage2_train")

        # Test evaluation (horizon=0) -----------------------------------------
        threshold = float(getattr(args, "event_threshold", 0.5))
        print(f"\n--- Test Evaluation (threshold={threshold}) ---")

        if len(X_test) > 0:
            profiler.begin_phase("inference", n_samples=int(len(X_test)))
            results = _evaluate_cascade(
                X_test, ev_test, g_test, s_test,
                cfg, outdir, goal_labels, stim_labels, threshold,
            )
            profiler.end_phase("inference")
            out_path = outdir / "test_metrics.json"
            out_path.write_text(json.dumps(results, indent=2, default=float))
            print(
                f"Stage1 F1={results['stage1_f1']:.3f}  "
                f"Goal F1={results['goal_f1']:.3f}  "
                f"Stimuli F1={results['stimuli_f1']:.3f}  "
                f"Goal Oracle={results['goal_oracle_f1']:.3f}  "
                f"Stimuli Oracle={results['stimuli_oracle_f1']:.3f}"
            )
            print(f"Metrics saved to {out_path}")
        else:
            print("[!] No test data available for evaluation.")

        # Multi-horizon evaluation --------------------------------------------
        horizons_s = [1/sample_hz * h for h in [1, 2, 3, 6, 9, 12, 15]]
        test_sessions = [(d, X, g, s) for d, X, g, s in sessions if d in test_days]
        if test_sessions:
            print(f"\n--- Multi-Horizon Evaluation ({len(horizons_s)} horizons) ---")
            max_h_steps = int(max(horizons_s) * sample_hz)
            metrics_all_h: Dict[str, Any] = {}

            for h_s in horizons_s:
                h_steps = max(1, int(round(h_s * sample_hz)))
                h_key   = f"{h_s:.3f}s"

                # Re-window test sessions at this horizon
                buckets: List = []
                for day_id, X_s, g_s, s_s in test_sessions:
                    Xw, evw, gw, sw = create_windows(
                        X_s, g_s, s_s,
                        cfg.window_len, cfg.stride_len,
                        horizon_steps=h_steps,
                        max_horizon=max_h_steps,
                    )
                    if len(Xw) > 0:
                        buckets.append((Xw, evw, gw, sw))

                if not buckets:
                    continue

                Xh  = np.concatenate([b[0] for b in buckets])
                evh = np.concatenate([b[1] for b in buckets])
                gh  = np.concatenate([b[2] for b in buckets])
                sh  = np.concatenate([b[3] for b in buckets])

                # Apply same normalization
                Xh = (Xh - mean) / std

                res_h = _evaluate_cascade(
                    Xh, evh, gh, sh,
                    cfg, outdir, goal_labels, stim_labels, threshold,
                )
                metrics_all_h[h_key] = res_h
                print(
                    f"  h={h_key:<8}  n={len(Xh):>6}  "
                    f"S1={res_h['stage1_f1']:.3f}  "
                    f"Goal={res_h['goal_f1']:.3f}  "
                    f"Stim={res_h['stimuli_f1']:.3f}"
                )

            if metrics_all_h:
                mh_path = outdir / "metrics_all_horizons.json"
                mh_path.write_text(json.dumps(metrics_all_h, indent=2, default=float))
                print(f"Multi-horizon metrics saved to {mh_path}")


def cmd_evaluate(args: argparse.Namespace) -> None:
    """Evaluate a trained model on all sessions in a manifest."""
    outdir    = Path(args.outdir)
    model_dir = Path(args.model_dir)
    outdir.mkdir(parents=True, exist_ok=True)

    # Load saved config ------------------------------------------------------
    cfg_dict    = json.loads((model_dir / "config.json").read_text())
    goal_labels = cfg_dict.get("goal_labels", [])
    stim_labels = cfg_dict.get("stimuli_labels", [])

    cfg_field_names = {f.name for f in fields(MultiModelConfig)}
    cfg = MultiModelConfig(**{k: v for k, v in cfg_dict.items() if k in cfg_field_names})

    # Load normalisation stats -----------------------------------------------
    mean = np.load(str(model_dir / "norm_mean.npy"))
    std  = np.load(str(model_dir / "norm_std.npy"))

    # Collect sessions -------------------------------------------------------
    sessions, _, _ = _collect_sessions(
        Path(args.manifest),
        Path(args.prealigned_sensors_dir),
        Path(args.det_cache_dir),
        Path(args.eaf_parsed_dir) if getattr(args, "eaf_parsed_dir", None) else None,
        Path(args.vocab_dir),
        cfg.sample_hz,
    )
    if not sessions:
        print("[!] No valid sessions loaded.")
        return

    # Create windows for all sessions ----------------------------------------
    all_X, all_ev, all_g, all_s = [], [], [], []
    for _day, X, goal_vec, stim_vec in sessions:
        X_w, ev_w, g_w, s_w = create_windows(X, goal_vec, stim_vec, cfg.window_len, cfg.stride_len)
        if len(X_w) > 0:
            all_X.append(X_w); all_ev.append(ev_w)
            all_g.append(g_w); all_s.append(s_w)

    if not all_X:
        print("[!] No windows created.")
        return

    X_all  = (np.concatenate(all_X)  - mean) / std
    ev_all = np.concatenate(all_ev)
    g_all  = np.concatenate(all_g)
    s_all  = np.concatenate(all_s)

    threshold = float(getattr(args, "event_threshold", 0.5))
    results = _evaluate_cascade(
        X_all, ev_all, g_all, s_all,
        cfg, model_dir, goal_labels, stim_labels, threshold,
    )

    out_path = outdir / "eval_metrics.json"
    out_path.write_text(json.dumps(results, indent=2, default=float))
    print(
        f"Stage1 F1={results['stage1_f1']:.3f}  "
        f"Goal F1={results['goal_f1']:.3f}  "
        f"Stimuli F1={results['stimuli_f1']:.3f}  "
        f"Goal Oracle={results['goal_oracle_f1']:.3f}"
    )
    print(f"Metrics saved to {out_path}")


# ---------------------------------------------------------------------------
# CLI entry point
# ---------------------------------------------------------------------------

def _add_data_args(p: argparse.ArgumentParser) -> None:
    p.add_argument("--manifest",               required=True, type=Path,
                   help="Path to manifest.jsonl")
    p.add_argument("--prealigned-sensors-dir", required=True, type=Path,
                   help="Directory with prealigned sensor .npy files")
    p.add_argument("--det-cache-dir",          required=True, type=Path,
                   help="Directory with YOLO detection cache .npy files")
    p.add_argument("--eaf-parsed-dir",         default=None,  type=Path,
                   help="Directory with parsed EAF .json files")
    p.add_argument("--vocab-dir",              required=True, type=Path,
                   help="Directory with vocab .json files")
    p.add_argument("--outdir",                 required=True, type=Path,
                   help="Output directory")


def main() -> None:
    parser = argparse.ArgumentParser(
        description="Two-stage EAF + YOLO multi-model pipeline"
    )
    sub = parser.add_subparsers(dest="command", required=True)

    # ---- extract (delegates to two_stage_yolo) ----
    p_ext = sub.add_parser("extract", help="Extract YOLO detection features from videos")
    p_ext.add_argument("--manifest",     required=True, type=Path)
    p_ext.add_argument("--outdir",       required=True, type=Path)
    p_ext.add_argument("--sample-hz",    type=float, default=3.0)
    p_ext.add_argument("--yolo-model",   type=str,   default="yolov8n.pt")
    p_ext.add_argument("--max-sessions", type=int,   default=None)
    p_ext.set_defaults(func=cmd_extract)

    # ---- train ----
    p_tr = sub.add_parser("train", help="Train Stage1 + Stage2 with chosen model")
    _add_data_args(p_tr)
    p_tr.add_argument("--model",           required=True, choices=sorted(_ALL_MODELS),
                      help="Model type")
    p_tr.add_argument("--sample-hz",       type=float, default=3.0)
    p_tr.add_argument("--window-sec",      type=float, default=5.0)
    p_tr.add_argument("--stride-sec",      type=float, default=1.0)
    p_tr.add_argument("--epochs",          type=int,   default=30)
    p_tr.add_argument("--lr",              type=float, default=1e-4)
    p_tr.add_argument("--batch-size",      type=int,   default=64)
    p_tr.add_argument("--d-model",         type=int,   default=128)
    p_tr.add_argument("--num-layers",      type=int,   default=2)
    p_tr.add_argument("--dropout",         type=float, default=0.1)
    p_tr.add_argument("--balance-ratio",   type=float, default=None,
                      help="Target event ratio after undersampling (default: no balancing)")
    p_tr.add_argument("--event-threshold", type=float, default=0.5,
                      help="P(event) threshold for Stage1 gate during test evaluation")
    p_tr.set_defaults(func=cmd_train)

    # ---- evaluate ----
    p_ev = sub.add_parser("evaluate", help="Evaluate a trained model on a manifest")
    p_ev.add_argument("--manifest",               required=True, type=Path)
    p_ev.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p_ev.add_argument("--det-cache-dir",          required=True, type=Path)
    p_ev.add_argument("--eaf-parsed-dir",         default=None,  type=Path)
    p_ev.add_argument("--vocab-dir",              required=True, type=Path)
    p_ev.add_argument("--model-dir",              required=True, type=Path,
                      help="Directory with config.json + trained model files")
    p_ev.add_argument("--outdir",                 required=True, type=Path)
    p_ev.add_argument("--event-threshold",        type=float, default=0.5)
    p_ev.set_defaults(func=cmd_evaluate)

    args = parser.parse_args()
    args.func(args)


if __name__ == "__main__":
    main()
