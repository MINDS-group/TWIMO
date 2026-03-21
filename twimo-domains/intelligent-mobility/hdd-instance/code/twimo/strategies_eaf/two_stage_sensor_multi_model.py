#!/usr/bin/env python
"""Two-stage EAF pipeline: sensor-only × multi-model.

Identical to two_stage_yolo_improved_multi_model but uses ONLY the 8
prealigned sensor features.  No YOLO detection cache required.

Supported strategies:
  1a  Skip Stage 1 entirely; Stage 2 trained on ALL windows.
      At inference event = (goal != background class 0).
  1b  Soft Stage-1 threshold: fire when P(event) >= --stage1-threshold (0.30).
  3   Majority-vote label assignment per window.
  4   Inverse-frequency class weights (transformer only, via delegation).
  7   10-second observation window instead of 5 seconds.

Strategies 2 / 5 / 6 need YOLO detection features and are NOT supported here.
Use two_stage_yolo_improved_multi_model.py for those.

Available models:
  xgboost, lightgbm, random_forest, gru, lstm, tcn,
  mlp_mean, mlp_max, mlp_concat, transformer

Commands:
  train     Train Stage1 + Stage2 with chosen model + strategies
  evaluate  Evaluate a trained model (train/val/test splits + multi-horizon)

Usage examples:
  # XGBoost, soft Stage-1 + majority-vote labels
  python -m twimo.strategies_eaf.two_stage_sensor_multi_model train \\
      --model xgboost \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/sensor_mm/xgboost_1b3 \\
      --strategies 1b 3

  # Evaluate
  python -m twimo.strategies_eaf.two_stage_sensor_multi_model evaluate \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --model-dir ./artifacts/sensor_mm/xgboost_1b3 \\
      --outdir ./artifacts/sensor_mm/xgboost_1b3/eval
"""
from __future__ import annotations

import argparse
import json
import sys
from dataclasses import dataclass, field, asdict
from pathlib import Path
from typing import Any, Dict, List, Optional, Tuple

import numpy as np

from twimo.utils.profiling import TrainingProfiler
from twimo.strategies_eaf.two_stage_yolo import (
    _load_vocab, _eaf_map, _load_eaf_json, _label_vectors,
)
from twimo.strategies_eaf.two_stage_multi_model import (
    ALL_MODELS, MultiModelConfig, NEURAL_MODELS, TREE_MODELS,
    _train_neural_s1, _train_neural_s2, _train_tree_s1, _train_tree_s2,
    _predict_neural_s1_probs, _predict_neural_s2,
    _predict_tree_s1_probs, _predict_tree_s2,
    compute_metrics, balance_windows, create_windows,
)

_TRANSFORMER = "transformer"
_UNSUPPORTED_STRATEGIES = {"2", "5", "6"}

SENSOR_FEATURE_NAMES: List[str] = [
    "steer_angle", "steer_speed", "accel", "brake",
    "lturn", "rturn", "speed", "yaw_rate",
]

# ---------------------------------------------------------------------------
# Config
# ---------------------------------------------------------------------------

@dataclass
class SensorMultiConfig:
    model_type:        str   = "xgboost"
    window_sec:        float = 5.0
    stride_sec:        float = 1.0
    sample_hz:         float = 3.0
    d_model:           int   = 64
    num_layers:        int   = 2
    dropout:           float = 0.1
    epochs:            int   = 30
    lr:                float = 1e-4
    batch_size:        int   = 64
    n_goal_classes:    int   = 14
    n_stimuli_classes: int   = 10
    input_dim:         int   = 8
    strategies:        List[str] = field(default_factory=list)
    stage1_threshold:  float = 0.30
    sensor_dim:        int   = 8
    device:            str   = ""

    def __post_init__(self) -> None:
        bad = _UNSUPPORTED_STRATEGIES & set(self.strategies)
        if bad:
            raise ValueError(
                f"Strategies {sorted(bad)} require YOLO detection features. "
                f"Use two_stage_yolo_improved_multi_model.py instead."
            )
        if "1a" in self.strategies and "1b" in self.strategies:
            self.strategies = [s for s in self.strategies if s != "1b"]
        if not self.device:
            import torch
            self.device = "cuda" if torch.cuda.is_available() else "cpu"

    @property
    def window_len(self) -> int:
        wl = int(self.window_sec * self.sample_hz)
        return wl * 2 if "7" in self.strategies else wl

    @property
    def stride_len(self) -> int:
        return max(1, int(self.stride_sec * self.sample_hz))


def _to_mm_cfg(cfg: SensorMultiConfig) -> MultiModelConfig:
    return MultiModelConfig(
        model_type        = cfg.model_type,
        window_sec        = cfg.window_sec,
        stride_sec        = cfg.stride_sec,
        sample_hz         = cfg.sample_hz,
        n_goal_classes    = cfg.n_goal_classes,
        n_stimuli_classes = cfg.n_stimuli_classes,
        input_dim         = cfg.input_dim,
        epochs            = cfg.epochs,
        lr                = cfg.lr,
        batch_size        = cfg.batch_size,
        d_model           = cfg.d_model,
        num_layers        = cfg.num_layers,
        dropout           = cfg.dropout,
    )


def _cfg_to_dict(cfg: SensorMultiConfig) -> dict:
    d = asdict(cfg)
    d["window_len"] = cfg.window_len
    d["stride_len"] = cfg.stride_len
    return d


def _cfg_from_dict(d: dict) -> SensorMultiConfig:
    allowed = set(SensorMultiConfig.__dataclass_fields__.keys())
    return SensorMultiConfig(**{k: v for k, v in d.items() if k in allowed})


# ---------------------------------------------------------------------------
# Data loading
# ---------------------------------------------------------------------------

def _load_vocabs(vocab_dir: Path):
    g_l, g_lm, g_v = _load_vocab(vocab_dir / "vocab_goal.json")
    s_l, s_lm, s_v = _load_vocab(vocab_dir / "vocab_stimuli.json")
    return g_l, g_lm, g_v, s_l, s_lm, s_v


def _collect_sessions(
    manifest_path:  Path,
    sensor_dir:     Path,
    eaf_parsed_dir: Path,
    vocab_dir:      Path,
    cfg:            SensorMultiConfig,
) -> Tuple[List[Tuple], List[str], List[str]]:
    """Load sessions as (day_id, X_sensor, ev_vec, goal_vec, stim_vec) tuples."""
    g_l, g_lm, g_v, s_l, s_lm, s_v = _load_vocabs(vocab_dir)

    # stub cause/attention vocabs (needed by _label_vectors signature)
    cause_lmap:  Dict[str, str] = {}
    cause_vocab: Dict[str, int] = {"unknown": 0}
    att_lmap:    Dict[str, str] = {}
    att_vocab:   Dict[str, int] = {"unknown": 0}

    em = _eaf_map(eaf_parsed_dir) if eaf_parsed_dir and eaf_parsed_dir.is_dir() else {}

    records = []
    with open(manifest_path, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    sessions: List[Tuple] = []
    n_ok = n_skip = 0

    for rec in records:
        sid = rec.get("session_id", "")
        spt = sensor_dir / f"{sid}.npy"
        if not spt.exists():
            n_skip += 1
            continue

        eaf_path = em.get(sid)
        if eaf_path is None:
            n_skip += 1
            continue

        try:
            sensors = np.load(str(spt)).astype(np.float32)
            T = len(sensors)
            if T < 30:
                n_skip += 1
                continue

            tiers = _load_eaf_json(eaf_path)
            if not tiers:
                n_skip += 1
                continue

            ev_vec, goal_raw, stim_raw, _, _ = _label_vectors(
                T, cfg.sample_hz, tiers,
                g_lm, g_v, s_lm, s_v,
                cause_lmap, cause_vocab,
                att_lmap, att_vocab,
                t_offset_s=0.0,
            )
            goal_vec = np.maximum(goal_raw, 0).astype(np.int64)
            stim_vec = np.maximum(stim_raw, 0).astype(np.int64)

            day_id = str(rec.get("day_id") or sid[:8])
            sessions.append((day_id, sensors, ev_vec, goal_vec, stim_vec))
            n_ok += 1

        except Exception as exc:
            print(f"  [!] {sid}: {exc}")
            n_skip += 1

    print(f"Sessions loaded: {n_ok} ok, {n_skip} skipped")
    return sessions, g_l, s_l


# ---------------------------------------------------------------------------
# Day split
# ---------------------------------------------------------------------------

def _day_split(
    sessions:  List[Tuple],
    val_frac:  float = 0.15,
    test_frac: float = 0.15,
) -> Tuple[set, set]:
    all_days = sorted({day for day, *_ in sessions})
    n        = len(all_days)
    n_test   = max(1, round(n * test_frac))
    n_val    = max(1, round(n * val_frac))
    test_days = set(all_days[-n_test:])
    val_days  = set(all_days[-(n_test + n_val): -n_test])
    return test_days, val_days


# ---------------------------------------------------------------------------
# Windowing
# ---------------------------------------------------------------------------

def _majority(arr: np.ndarray) -> int:
    arr = arr[arr > 0]
    if len(arr) == 0:
        return 0
    vals, counts = np.unique(arr, return_counts=True)
    return int(vals[counts.argmax()])


def _build_windows_s3(
    X:          np.ndarray,
    goal_vec:   np.ndarray,
    stim_vec:   np.ndarray,
    ev_vec:     np.ndarray,
    window_len: int,
    stride:     int,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Majority-vote windowing (strategy 3)."""
    T = X.shape[0]
    wins, ev_l, go_l, st_l = [], [], [], []
    for k in range(0, T - window_len + 1, stride):
        wins.append(X[k: k + window_len])
        ev_l.append(int(ev_vec[k: k + window_len].max()))
        go_l.append(max(0, _majority(goal_vec[k: k + window_len])))
        st_l.append(max(0, _majority(stim_vec[k: k + window_len])))
    if not wins:
        empty = np.zeros(0, dtype=np.int64)
        return (np.zeros((0, window_len, X.shape[1]), dtype=np.float32),
                empty, empty, empty)
    return (np.stack(wins).astype(np.float32),
            np.array(ev_l, dtype=np.int64),
            np.array(go_l, dtype=np.int64),
            np.array(st_l, dtype=np.int64))


def _window_session(
    X: np.ndarray, ev_vec: np.ndarray, goal_vec: np.ndarray, stim_vec: np.ndarray,
    window_len: int, stride_len: int, strategy3: bool,
    horizon_steps: int = 0, max_horizon: int = 0,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    if strategy3 and horizon_steps == 0:
        return _build_windows_s3(X, goal_vec, stim_vec, ev_vec, window_len, stride_len)
    return create_windows(
        X, goal_vec, stim_vec, window_len, stride_len,
        horizon_steps=horizon_steps, max_horizon=max_horizon,
    )


def _make_splits(
    sessions:   List[Tuple],
    window_len: int,
    stride_len: int,
    test_days:  set,
    val_days:   set,
    strategy3:  bool,
) -> Dict[str, Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]]:
    input_dim = sessions[0][1].shape[1] if sessions else 8
    buckets: Dict[str, List] = {"train": [], "val": [], "test": []}
    for day_id, X, ev_vec, goal_vec, stim_vec in sessions:
        X_w, ev_w, go_w, st_w = _window_session(
            X, ev_vec, goal_vec, stim_vec, window_len, stride_len, strategy3)
        if len(X_w) == 0:
            continue
        key = "test" if day_id in test_days else "val" if day_id in val_days else "train"
        buckets[key].append((X_w, ev_w, go_w, st_w))
    result: Dict[str, Tuple] = {}
    for key, bkt in buckets.items():
        if bkt:
            result[key] = (
                np.concatenate([b[0] for b in bkt]),
                np.concatenate([b[1] for b in bkt]),
                np.concatenate([b[2] for b in bkt]),
                np.concatenate([b[3] for b in bkt]),
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
    X_train: np.ndarray, X_val: np.ndarray, X_test: np.ndarray,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    mean = X_train.mean(axis=(0, 1)).astype(np.float32)
    std  = X_train.std(axis=(0, 1)).astype(np.float32)
    std[std < 1e-8] = 1.0
    return ((X_train - mean) / std, (X_val  - mean) / std,
            (X_test  - mean) / std, mean, std)


# ---------------------------------------------------------------------------
# Cascade evaluation
# ---------------------------------------------------------------------------

def _evaluate_cascade(
    X_test:      np.ndarray,
    ev_test:     np.ndarray,
    g_test:      np.ndarray,
    s_test:      np.ndarray,
    cfg:         SensorMultiConfig,
    model_dir:   Path,
    goal_labels: List[str],
    stim_labels: List[str],
) -> Dict[str, Any]:
    mm_cfg    = _to_mm_cfg(cfg)
    is_neural = cfg.model_type in NEURAL_MODELS
    use_1a    = "1a" in cfg.strategies
    threshold = cfg.stage1_threshold if "1b" in cfg.strategies else 0.5

    n_g = cfg.n_goal_classes    or (int(g_test.max()) + 1 if len(g_test) else len(goal_labels))
    n_s = cfg.n_stimuli_classes or (int(s_test.max()) + 1 if len(s_test) else len(stim_labels))
    g_names = goal_labels or [str(i) for i in range(n_g)]
    s_names = stim_labels or [str(i) for i in range(n_s)]

    if use_1a:
        ev_pred = np.ones(len(X_test), dtype=np.int64)
        ev_mask = np.ones(len(X_test), dtype=bool)
    else:
        if is_neural:
            ev_probs = _predict_neural_s1_probs(X_test, mm_cfg, model_dir / "stage1.pt")
        else:
            ev_probs = _predict_tree_s1_probs(X_test, model_dir / "stage1_tree.joblib")
        ev_pred = (ev_probs >= threshold).astype(np.int64)
        ev_mask = ev_pred == 1

    g_pred = np.zeros(len(X_test), dtype=np.int64)
    s_pred = np.zeros(len(X_test), dtype=np.int64)
    s2_path = model_dir / ("stage2.pt" if is_neural else "stage2_tree.joblib")

    if ev_mask.sum() > 0:
        X_ev = X_test[ev_mask]
        g_ev, s_ev = (_predict_neural_s2(X_ev, mm_cfg, s2_path) if is_neural
                      else _predict_tree_s2(X_ev, s2_path))
        g_pred[ev_mask] = g_ev
        s_pred[ev_mask] = s_ev

    if use_1a:
        ev_pred[:] = (g_pred != 0).astype(np.int64)
        ev_mask = ev_pred == 1

    ev_gt_mask = ev_test == 1
    g_oracle_m: Dict[str, Any] = {}
    s_oracle_m: Dict[str, Any] = {}
    if ev_gt_mask.sum() > 0:
        X_ev_gt = X_test[ev_gt_mask]
        g_or, s_or = (_predict_neural_s2(X_ev_gt, mm_cfg, s2_path) if is_neural
                      else _predict_tree_s2(X_ev_gt, s2_path))
        g_oracle_m = compute_metrics(g_or, g_test[ev_gt_mask], n_g, g_names)
        s_oracle_m = compute_metrics(s_or, s_test[ev_gt_mask], n_s, s_names)

    ev_m = compute_metrics(ev_pred, ev_test, 2, ["no_event", "event"])
    g_m  = compute_metrics(g_pred,  g_test,  n_g, g_names)
    s_m  = compute_metrics(s_pred,  s_test,  n_s, s_names)

    return {
        "n_windows":              int(len(X_test)),
        "n_predicted_events":     int(ev_mask.sum()),
        "n_actual_events":        int(ev_gt_mask.sum()),
        "stage1_f1":              float(ev_m.get("macro_f1",    0.0)),
        "stage1_weighted_f1":     float(ev_m.get("weighted_f1", 0.0)),
        "goal_f1":                float(g_m.get("macro_f1",    0.0)),
        "goal_weighted_f1":       float(g_m.get("weighted_f1", 0.0)),
        "stimuli_f1":             float(s_m.get("macro_f1",    0.0)),
        "stimuli_weighted_f1":    float(s_m.get("weighted_f1", 0.0)),
        "goal_oracle_f1":         float(g_oracle_m.get("macro_f1",    0.0)),
        "stimuli_oracle_f1":      float(s_oracle_m.get("macro_f1",    0.0)),
        "event_metrics":          ev_m,
        "goal_metrics":           g_m,
        "stimuli_metrics":        s_m,
        "goal_oracle_metrics":    g_oracle_m,
        "stimuli_oracle_metrics": s_oracle_m,
        "strategies":             cfg.strategies,
    }


# ---------------------------------------------------------------------------
# CLI commands
# ---------------------------------------------------------------------------

def cmd_train(args: argparse.Namespace) -> None:
    outdir     = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    strategies = list(getattr(args, "strategies", []) or [])
    sample_hz  = float(args.sample_hz)

    # ── Transformer: delegate to two_stage_yolo_improved ─────────────────────
    if args.model == _TRANSFORMER:
        from twimo.strategies_eaf.two_stage_yolo_improved import cmd_train as imp_train
        from twimo.strategies_eaf.two_stage_yolo_improved_multi_model import (
            _multihorizon_transformer_imp, ImpMultiConfig, _collect_sessions_imp,
            _day_split_imp,
        )
        profiler = TrainingProfiler(
            model_name="two_stage_sensor_transformer",
            output_dir=outdir, use_codecarbon=True,
        )
        with profiler:
            profiler.begin_phase("training")
            imp_train(args)
            profiler.end_phase("training")
            profiler.begin_phase("multihorizon_eval")
            try:
                cfg_proxy = ImpMultiConfig(strategies=strategies, sample_hz=sample_hz)
                sessions, goal_labels, stim_labels = _collect_sessions_imp(
                    Path(args.manifest),
                    Path(args.prealigned_sensors_dir),
                    None,   # no det cache
                    Path(args.eaf_parsed_dir),
                    Path(args.vocab_dir),
                    cfg_proxy,
                )
                test_days, _ = _day_split_imp(sessions)
                _multihorizon_transformer_imp(
                    outdir, sessions, test_days,
                    goal_labels, stim_labels, sample_hz,
                )
            except Exception as exc:
                print(f"[!] Multi-horizon eval failed: {exc}")
            profiler.end_phase("multihorizon_eval")
        return

    # ── All other models ──────────────────────────────────────────────────────
    print(f"=== Sensor-Only Multi-Model: {args.model}  strategies={strategies} ===")

    profiler = TrainingProfiler(
        model_name=f"two_stage_sensor_{args.model}",
        output_dir=outdir, use_codecarbon=True,
    )

    with profiler:
        cfg = SensorMultiConfig(
            model_type       = args.model,
            window_sec       = float(getattr(args, "window_sec", 5.0)),
            stride_sec       = float(getattr(args, "stride_sec", 1.0)),
            sample_hz        = sample_hz,
            epochs           = int(getattr(args, "epochs", 30)),
            lr               = float(getattr(args, "lr", 1e-4)),
            batch_size       = int(getattr(args, "batch_size", 64)),
            strategies       = strategies,
            stage1_threshold = float(getattr(args, "stage1_threshold", 0.30)),
        )

        vd = Path(args.vocab_dir)
        g_l, g_lm, g_v, s_l, s_lm, s_v = _load_vocabs(vd)
        cfg.n_goal_classes    = len(g_l)
        cfg.n_stimuli_classes = len(s_l)
        cfg.input_dim         = cfg.sensor_dim

        sessions, goal_labels, stim_labels = _collect_sessions(
            Path(args.manifest),
            Path(args.prealigned_sensors_dir),
            Path(args.eaf_parsed_dir),
            vd, cfg,
        )
        if not sessions:
            print("[!] No sessions loaded. Aborting.")
            return

        print(f"Input dim: {cfg.input_dim}  Goal: {cfg.n_goal_classes}  "
              f"Stimuli: {cfg.n_stimuli_classes}")

        test_days, val_days = _day_split(sessions)
        strategy3 = "3" in strategies
        splits = _make_splits(
            sessions, cfg.window_len, cfg.stride_len, test_days, val_days, strategy3)
        X_train, ev_train, g_train, s_train = splits["train"]
        X_val,   ev_val,   g_val,   s_val   = splits["val"]
        X_test,  ev_test,  g_test,  s_test  = splits["test"]

        print(f"Windows - train: {len(X_train)}  val: {len(X_val)}  test: {len(X_test)}")
        if len(X_train) == 0:
            print("[!] No training data. Aborting.")
            return
        print(f"Train events: {int(ev_train.sum())}/{len(ev_train)} "
              f"({100*ev_train.mean():.1f}%)")

        X_train, X_val, X_test, mean, std = _normalize(X_train, X_val, X_test)
        np.save(str(outdir / "norm_mean.npy"), mean)
        np.save(str(outdir / "norm_std.npy"),  std)

        balance_ratio = getattr(args, "balance_ratio", None)
        if balance_ratio and float(balance_ratio) > 0 and ev_train.sum() > 0:
            X_train, ev_train, g_train, s_train = balance_windows(
                X_train, ev_train, g_train, s_train,
                event_ratio=float(balance_ratio),
            )
            print(f"After balancing: {len(X_train)} windows")

        use_1a = "1a" in strategies
        mm_cfg = _to_mm_cfg(cfg)

        # ── Stage 1 ──────────────────────────────────────────────────────────
        if use_1a:
            print("\n-- Stage 1: SKIPPED (strategy 1a) --")
            (outdir / "stage1_skip.flag").write_text("strategy_1a")
        else:
            print("\n-- Stage 1: Event Detection --")
            profiler.begin_phase("stage1_train", n_samples=int(len(X_train)))
            if cfg.model_type in NEURAL_MODELS:
                _train_neural_s1(X_train, ev_train, X_val, ev_val, mm_cfg, outdir)
            else:
                _train_tree_s1(X_train, ev_train, X_val, ev_val, mm_cfg, outdir)
            profiler.end_phase("stage1_train")

        # ── Stage 2 ──────────────────────────────────────────────────────────
        print("\n-- Stage 2: Goal + Stimuli Classification --")
        ev_train_s2 = np.ones(len(X_train), dtype=np.int64) if use_1a else ev_train
        ev_val_s2   = np.ones(len(X_val),   dtype=np.int64) if use_1a else ev_val
        n_stage2 = int((ev_train_s2 == 1).sum())
        print(f"  Stage 2 training windows: {n_stage2}")
        if n_stage2 == 0:
            print("[!] No Stage-2 training windows. Aborting.")
            return

        profiler.begin_phase("stage2_train", n_samples=n_stage2)
        if cfg.model_type in NEURAL_MODELS:
            _train_neural_s2(
                X_train, ev_train_s2, g_train, s_train,
                X_val,   ev_val_s2,   g_val,   s_val,
                mm_cfg, outdir, goal_labels, stim_labels,
            )
        else:
            _train_tree_s2(
                X_train, ev_train_s2, g_train, s_train,
                X_val,   ev_val_s2,   g_val,   s_val,
                mm_cfg, outdir, goal_labels, stim_labels,
            )
        profiler.end_phase("stage2_train")

        # ── Save config + feature names ───────────────────────────────────────
        with open(outdir / "config.json", "w") as f:
            json.dump(_cfg_to_dict(cfg), f, indent=2)
        with open(outdir / "strategies.json", "w") as f:
            json.dump({
                "strategies": strategies,
                "input_dim":  cfg.input_dim,
                "window_sec": cfg.window_sec,
            }, f, indent=2)
        with open(outdir / "feature_names.json", "w") as f:
            json.dump({
                "sensor":    SENSOR_FEATURE_NAMES[:cfg.sensor_dim],
                "detection": [],
                "all":       SENSOR_FEATURE_NAMES[:cfg.sensor_dim],
                "input_dim": cfg.sensor_dim,
            }, f, indent=2)

        # ── Train / Val / Test evaluation ─────────────────────────────────────
        profiler.begin_phase("inference", n_samples=int(len(X_test)))
        for split_name, Xs, evs, gs, ss in [
            ("train", X_train, ev_train, g_train, s_train),
            ("val",   X_val,   ev_val,   g_val,   s_val),
            ("test",  X_test,  ev_test,  g_test,  s_test),
        ]:
            if len(Xs) == 0:
                print(f"[!] No {split_name} data.")
                continue
            res = _evaluate_cascade(Xs, evs, gs, ss, cfg, outdir, goal_labels, stim_labels)
            (outdir / f"metrics_{split_name}.json").write_text(
                json.dumps(res, indent=2, default=float))
            print(f"\n{split_name.capitalize()}: S1={res['stage1_f1']:.3f}  "
                  f"Goal={res['goal_f1']:.3f}  Stim={res['stimuli_f1']:.3f}")
        profiler.end_phase("inference")

        # ── Multi-horizon evaluation ──────────────────────────────────────────
        test_sessions = [(d, X, ev, g, s) for d, X, ev, g, s in sessions
                         if d in test_days]
        if test_sessions:
            print(f"\n--- Multi-Horizon Evaluation ---")
            horizons_steps = [1, 2, 3, 6, 9, 12, 15]
            max_h_steps    = max(horizons_steps)
            metrics_all_h: Dict[str, Any] = {}
            for h_steps in horizons_steps:
                h_key = f"{h_steps / sample_hz:.3f}s"
                bkts: List = []
                for _day, X_s, ev_s, g_s, s_s in test_sessions:
                    Xw, evw, gw, sw = create_windows(
                        X_s, g_s, s_s, cfg.window_len, cfg.stride_len,
                        horizon_steps=h_steps, max_horizon=max_h_steps,
                    )
                    if len(Xw) > 0:
                        bkts.append((Xw, evw, gw, sw))
                if not bkts:
                    continue
                Xh  = (np.concatenate([b[0] for b in bkts]) - mean) / std
                evh = np.concatenate([b[1] for b in bkts])
                gh  = np.concatenate([b[2] for b in bkts])
                sh  = np.concatenate([b[3] for b in bkts])
                res_h = _evaluate_cascade(Xh, evh, gh, sh, cfg, outdir,
                                          goal_labels, stim_labels)
                metrics_all_h[h_key] = res_h
                print(f"  h={h_key:<8}  n={len(Xh):>6}  "
                      f"S1={res_h['stage1_f1']:.3f}  "
                      f"Goal={res_h['goal_f1']:.3f}  "
                      f"Stim={res_h['stimuli_f1']:.3f}")
            if metrics_all_h:
                p = outdir / "metrics_all_horizons.json"
                p.write_text(json.dumps(metrics_all_h, indent=2, default=float))
                print(f"Multi-horizon metrics -> {p}")

    print(f"\nAll artifacts saved to {outdir}")


def cmd_evaluate(args: argparse.Namespace) -> None:
    """Evaluate a trained sensor-only model: train/val/test + multi-horizon."""
    outdir    = Path(args.outdir)
    model_dir = Path(args.model_dir)
    outdir.mkdir(parents=True, exist_ok=True)

    with open(model_dir / "config.json", encoding="utf-8") as f:
        cfg = _cfg_from_dict(json.load(f))

    mean      = np.load(str(model_dir / "norm_mean.npy"))
    std       = np.load(str(model_dir / "norm_std.npy"))
    sample_hz = cfg.sample_hz

    sessions, goal_labels, stim_labels = _collect_sessions(
        Path(args.manifest),
        Path(args.prealigned_sensors_dir),
        Path(args.eaf_parsed_dir),
        Path(args.vocab_dir),
        cfg,
    )
    if not sessions:
        print("[!] No sessions loaded.")
        return

    test_days, val_days = _day_split(sessions)
    strategy3 = "3" in cfg.strategies

    def _window_split(sess_subset):
        all_X, all_ev, all_g, all_s = [], [], [], []
        for _day, X, ev_vec, goal_vec, stim_vec in sess_subset:
            X_w, ev_w, go_w, st_w = _window_session(
                X, ev_vec, goal_vec, stim_vec,
                cfg.window_len, cfg.stride_len, strategy3,
            )
            if len(X_w) > 0:
                all_X.append(X_w); all_ev.append(ev_w)
                all_g.append(go_w); all_s.append(st_w)
        if not all_X:
            return None, None, None, None
        Xn = (np.concatenate(all_X) - mean) / std
        return Xn, np.concatenate(all_ev), np.concatenate(all_g), np.concatenate(all_s)

    train_sess = [(d, X, e, g, s) for d, X, e, g, s in sessions
                  if d not in test_days and d not in val_days]
    val_sess   = [(d, X, e, g, s) for d, X, e, g, s in sessions if d in val_days]
    test_sess  = [(d, X, e, g, s) for d, X, e, g, s in sessions if d in test_days]
    print(f"Sessions: train={len(train_sess)}  val={len(val_sess)}  test={len(test_sess)}")

    for split_name, split_sess in [("train", train_sess),
                                   ("val",   val_sess),
                                   ("test",  test_sess)]:
        Xs, evs, gs, ss = _window_split(split_sess)
        if Xs is None:
            print(f"  [{split_name}] no windows – skipping")
            continue
        res = _evaluate_cascade(Xs, evs, gs, ss, cfg, model_dir, goal_labels, stim_labels)
        fpath = outdir / f"metrics_{split_name}.json"
        fpath.write_text(json.dumps(res, indent=2, default=float))
        print(f"\n{split_name.capitalize()}: S1={res['stage1_f1']:.3f}  "
              f"Goal={res['goal_f1']:.3f}  Stim={res['stimuli_f1']:.3f}  -> {fpath}")

    if test_sess:
        print(f"\n--- Multi-Horizon Evaluation ---")
        horizons_steps = [1, 2, 3, 6, 9, 12, 15]
        max_h_steps    = max(horizons_steps)
        metrics_all_h: Dict[str, Any] = {}
        for h_steps in horizons_steps:
            h_key = f"{h_steps / sample_hz:.3f}s"
            bkts: List = []
            for _day, X_s, ev_s, g_s, s_s in test_sess:
                Xw, evw, gw, sw = create_windows(
                    X_s, g_s, s_s, cfg.window_len, cfg.stride_len,
                    horizon_steps=h_steps, max_horizon=max_h_steps,
                )
                if len(Xw) > 0:
                    bkts.append((Xw, evw, gw, sw))
            if not bkts:
                continue
            Xh  = (np.concatenate([b[0] for b in bkts]) - mean) / std
            evh = np.concatenate([b[1] for b in bkts])
            gh  = np.concatenate([b[2] for b in bkts])
            sh  = np.concatenate([b[3] for b in bkts])
            res_h = _evaluate_cascade(Xh, evh, gh, sh, cfg, model_dir, goal_labels, stim_labels)
            metrics_all_h[h_key] = res_h
            print(f"  h={h_key:<8}  n={len(Xh):>6}  "
                  f"S1={res_h['stage1_f1']:.3f}  "
                  f"Goal={res_h['goal_f1']:.3f}  "
                  f"Stim={res_h['stimuli_f1']:.3f}")
        if metrics_all_h:
            p = outdir / "metrics_all_horizons.json"
            p.write_text(json.dumps(metrics_all_h, indent=2, default=float))
            print(f"Multi-horizon metrics -> {p}")
    else:
        print("[!] No test sessions for multi-horizon eval.")

    print(f"\nAll metrics -> {outdir}")


# ---------------------------------------------------------------------------
# CLI
# ---------------------------------------------------------------------------

STRATEGIES_HELP = (
    "1a (skip Stage1), 1b (soft threshold), 3 (majority-vote labels), "
    "7 (10s window). Strategies 2/5/6 require YOLO features and are not supported here."
)


def _add_data_args(p: argparse.ArgumentParser) -> None:
    p.add_argument("--manifest",               required=True, type=Path)
    p.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p.add_argument("--eaf-parsed-dir",         required=True, type=Path)
    p.add_argument("--vocab-dir",              required=True, type=Path)
    p.add_argument("--sample-hz",              default=3.0,   type=float)


def main() -> None:
    pa  = argparse.ArgumentParser(
        description="Sensor-only multi-model two-stage EAF pipeline"
    )
    sub = pa.add_subparsers(dest="cmd", required=True)

    # ── train ─────────────────────────────────────────────────────────────────
    p_tr = sub.add_parser("train", help="Train with chosen model + strategies")
    _add_data_args(p_tr)
    p_tr.add_argument("--outdir",            required=True, type=Path)
    p_tr.add_argument("--model",             required=True,
                      choices=sorted(ALL_MODELS),
                      help="Model: " + ", ".join(sorted(ALL_MODELS)))
    p_tr.add_argument("--strategies",        default=[], nargs="*",
                      help=STRATEGIES_HELP)
    p_tr.add_argument("--stage1-threshold",  default=0.30, type=float)
    p_tr.add_argument("--window-sec",        default=5.0,  type=float)
    p_tr.add_argument("--stride-sec",        default=1.0,  type=float)
    p_tr.add_argument("--epochs",            default=30,   type=int)
    p_tr.add_argument("--lr",                default=1e-4, type=float)
    p_tr.add_argument("--batch-size",        default=64,   type=int)
    p_tr.add_argument("--balance-ratio",     default=None, type=float)

    # ── evaluate ──────────────────────────────────────────────────────────────
    p_ev = sub.add_parser("evaluate", help="Evaluate trained model")
    _add_data_args(p_ev)
    p_ev.add_argument("--model-dir",  required=True, type=Path)
    p_ev.add_argument("--outdir",     required=True, type=Path)

    args = pa.parse_args()
    {"train": cmd_train, "evaluate": cmd_evaluate}[args.cmd](args)


if __name__ == "__main__":
    main()
