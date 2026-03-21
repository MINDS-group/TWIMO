#!/usr/bin/env python
"""Two-stage EAF pipeline: improved detection features × multi-model support.

Combines the improved detection feature strategies from two_stage_yolo_improved.py
with the full multi-model zoo from two_stage_yolo_multi_model.py, plus
multi-horizon evaluation and profiling (CodeCarbon).

Strategies (compatible with all model families):
  1a  Skip Stage 1 entirely; Stage 2 is trained on ALL windows.
      At inference, Stage 2 always runs; event = (goal != background).
  1b  Soft Stage-1 threshold: fire when P(event) >= --stage1-threshold (0.30).
  2   Zone-based detection features (+12 cols, needs improved det cache).
  3   Majority-vote label assignment per window (more labelled windows).
  5   Motion features (+5 cols, needs improved det cache).
  6   Top-K vehicle tracking (+9 cols, needs improved det cache).
  7   10-second window instead of 5 seconds.

Additional strategy for transformer only (via two_stage_yolo_improved):
  4   Inverse-frequency class weights in Stage 2.

Notes
-----
* 1a and 1b are mutually exclusive (1a takes precedence).
* 2/5/6 require running ``extract-improved`` first.
* Strategy 4 is applied only when --model transformer
  (delegated to two_stage_yolo_improved.cmd_train).
* For --model transformer, this module delegates training to
  two_stage_yolo_improved.cmd_train and then runs multi-horizon evaluation.

Available models:
  xgboost, lightgbm, random_forest, gru, lstm, tcn,
  mlp_mean, mlp_max, mlp_concat, transformer

Commands (run in order):
  extract-improved   Build improved 39-dim detection cache (delegates to
                     two_stage_yolo_improved extract-improved)
  train              Train with chosen model + strategies
  evaluate           Evaluate a trained model

Usage examples:
  # 1) Extract improved detection features (once)
  python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model extract-improved \\
      --manifest ./artifacts/manifest.jsonl \\
      --det-cache-dir ./artifacts/det_cache_imp \\
      --yolo-model yolov8n.pt --sample-hz 3

  # 2a) Train XGBoost with zone + majority-vote strategies
  python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \\
      --model xgboost \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/sensor_npy \\
      --det-cache-dir ./artifacts/det_cache_imp \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/imp_mm/xgboost_s23 \\
      --strategies 2 3

  # 2b) Train GRU with soft threshold + zone + majority-vote
  python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \\
      --model gru --strategies 1b 2 3 \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/sensor_npy \\
      --det-cache-dir ./artifacts/det_cache_imp \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/imp_mm/gru_s1b23

  # 2c) Transformer with all strategies (delegates to two_stage_yolo_improved)
  python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \\
      --model transformer --strategies 1b 2 3 4 \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/sensor_npy \\
      --det-cache-dir ./artifacts/det_cache_imp \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/imp_mm/transformer_s1b234

  # 3) Evaluate
  python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model evaluate \\
      --manifest ./artifacts/manifest.jsonl \\
      --prealigned-sensors-dir ./artifacts/sensor_npy \\
      --det-cache-dir ./artifacts/det_cache_imp \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --model-dir ./artifacts/imp_mm/xgboost_s23 \\
      --outdir ./artifacts/imp_mm/xgboost_s23/eval
"""
from __future__ import annotations

import argparse
import json
import sys
from dataclasses import dataclass, field
from pathlib import Path
from typing import Any, Dict, List, Optional, Tuple

import numpy as np

from twimo.utils.profiling import TrainingProfiler

# ---------------------------------------------------------------------------
# Imports from existing modules (not modified here)
# ---------------------------------------------------------------------------

# Improved detection feature utilities
from twimo.strategies_eaf.two_stage_yolo_improved import (
    FEAT_BLOCKS,
    DET_FEATURE_NAMES_IMP,
    _load_det,
    _label_vectors as _label_vectors_imp,
    _majority,
    _load_improved_models,
    cmd_extract_improved,
)

# Ordered names of the 8 prealigned sensor columns (from generate_sensor_npy.py)
SENSOR_FEATURE_NAMES: List[str] = [
    "steer_angle", "steer_speed", "accel", "brake",
    "lturn", "rturn", "speed", "yaw_rate",
]

# RTK GPS-derived feature names (computed from rtk_pos.csv + rtk_track.csv)
GPS_RTK_FEATURE_NAMES: List[str] = [
    "rtk_heading",           # compass heading (°, 0–360)
    "rtk_heading_delta",     # heading change rate (°/s, signed: + = left turn)
    "rtk_heading_delta_abs", # |heading change rate| (°/s)
    "rtk_curvature",         # curvature proxy = |Δheading_rad|/speed (1/m)
    "rtk_gps_speed",         # GPS-derived speed (m/s)
    "rtk_lateral_v",         # lateral velocity = speed × sin(Δheading_rad) (m/s)
]

# Multi-model training / prediction machinery
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

# YOLO shared helpers
from twimo.strategies_eaf.two_stage_yolo import (
    _eaf_map,
    _load_vocab,
    _load_eaf_json,
)

# Normalisation helper (fit on train, apply to all)
from twimo.strategies_eaf.two_stage_yolo_multi_model import _normalize

from twimo.data.manifest import load_manifest

# ---------------------------------------------------------------------------
# Constants
# ---------------------------------------------------------------------------

_TRANSFORMER = "transformer"
_ALL_MODELS  = ALL_MODELS | {_TRANSFORMER}


# ---------------------------------------------------------------------------
# Configuration
# ---------------------------------------------------------------------------

@dataclass
class ImpMultiConfig:
    """Merged config: multi-model architecture + strategy/detection flags."""
    # Model selection
    model_type:        str   = "gru"
    # Window geometry
    window_sec:        float = 5.0
    stride_sec:        float = 1.0
    sample_hz:         float = 3.0
    # Neural architecture (for GRU/LSTM/TCN/MLP families)
    d_model:           int   = 128
    num_layers:        int   = 2
    dropout:           float = 0.1
    # Training
    epochs:            int   = 30
    lr:                float = 1e-4
    batch_size:        int   = 64
    # Classes (set after loading vocabs)
    n_goal_classes:    int   = 14
    n_stimuli_classes: int   = 9
    # Input dimension (set after loading data)
    input_dim:         int   = 1
    # Strategy flags
    strategies:        List[str] = field(default_factory=list)
    stage1_threshold:  float     = 0.30   # P(event) threshold for strategy 1b
    sensor_dim:        int       = 8
    device:            str       = ""
    # RTK GPS features
    use_rtk:           bool      = False
    rtk_dim:           int       = 0

    def __post_init__(self):
        import torch
        if not self.device:
            self.device = "cuda" if torch.cuda.is_available() else "cpu"
        # 1a takes precedence over 1b
        if "1a" in self.strategies and "1b" in self.strategies:
            self.strategies = [s for s in self.strategies if s != "1b"]
        # Strategy 7: extend window to 10 seconds
        if "7" in self.strategies:
            self.window_sec = 10.0

    # ── Detection column selection (mirrors ImpConfig.active_det_cols) ────────

    def active_det_cols(self) -> List[int]:
        cols: List[int] = list(FEAT_BLOCKS["base"])
        if "2" in self.strategies:
            cols.extend(FEAT_BLOCKS["zones"])
        if "5" in self.strategies:
            cols.extend(FEAT_BLOCKS["motion"])
        if "6" in self.strategies:
            cols.extend(FEAT_BLOCKS["topk"])
        return cols

    @property
    def det_dim(self) -> int:
        return len(self.active_det_cols())

    @property
    def window_len(self) -> int:
        return int(self.window_sec * self.sample_hz)

    @property
    def stride_len(self) -> int:
        return max(1, int(self.stride_sec * self.sample_hz))


def _cfg_to_dict(cfg: ImpMultiConfig) -> dict:
    d = {k: getattr(cfg, k) for k in cfg.__dataclass_fields__}
    d["det_dim"]    = cfg.det_dim
    d["window_len"] = cfg.window_len
    return d


def _cfg_from_dict(d: dict) -> ImpMultiConfig:
    allowed = set(ImpMultiConfig.__dataclass_fields__.keys())
    return ImpMultiConfig(**{k: v for k, v in d.items() if k in allowed})


def _to_mm_cfg(cfg: ImpMultiConfig) -> MultiModelConfig:
    """Build a MultiModelConfig from ImpMultiConfig for duck-typing with
    _train_neural_s1 / _train_neural_s2 / _predict_* helpers."""
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


# ---------------------------------------------------------------------------
# Data loading helpers
# ---------------------------------------------------------------------------

def _extract_rtk_features(csv_dir: Path, T: int, sample_hz: float) -> np.ndarray:
    """Compute 6 RTK GPS features from rtk_pos.csv + rtk_track.csv.

    Returns (T, 6) float32 array, zeros on any error.
    HDD quirk: rtk_pos.csv header says 'lng,lat' but values are (lat, lng).
    """
    import pandas as pd
    N = len(GPS_RTK_FEATURE_NAMES)
    zeros = np.zeros((T, N), dtype=np.float32)

    pos_path = csv_dir / "rtk_pos.csv"
    trk_path = csv_dir / "rtk_track.csv"
    if not pos_path.exists() or not trk_path.exists():
        return zeros

    try:
        # HDD CSVs have header like "# unix_timestamp,iso_timestamp,lng,lat"
        # Do NOT use comment='#' — it would skip the header row entirely.
        # Read normally, then strip the leading '# ' from column names.
        pos = pd.read_csv(pos_path)
        trk = pd.read_csv(trk_path)
        pos.columns = [c.lstrip("# ") for c in pos.columns]
        trk.columns = [c.lstrip("# ") for c in trk.columns]

        ts = "unix_timestamp"
        pos = pos.sort_values(ts).reset_index(drop=True)
        trk = trk.sort_values(ts).reset_index(drop=True)

        # Build uniform T-step grid from RTK start time
        t0 = float(pos[ts].iloc[0])
        dt = 1.0 / sample_hz
        t_grid = t0 + np.arange(T) * dt

        # HDD quirk: column labeled 'lng' is actually latitude, 'lat' is longitude
        # Columns 2 and 3 (0-indexed after timestamp, iso) hold the coordinates
        col2, col3 = pos.columns[2], pos.columns[3]
        lat_vals = np.interp(t_grid, pos[ts].values, pos[col2].values)  # ~37° N
        lng_vals = np.interp(t_grid, pos[ts].values, pos[col3].values)  # ~-122° W

        # Heading
        hdg_col = ("GPS_Yaw(heading)" if "GPS_Yaw(heading)" in trk.columns
                   else "GPS_course" if "GPS_course" in trk.columns else None)
        if hdg_col is None:
            return zeros
        hdg_vals = np.interp(t_grid, trk[ts].values, trk[hdg_col].values)

        # GPS speed from successive lat/lng differences
        R = 6_371_000.0
        dlat = np.diff(lat_vals) * (np.pi / 180.0)
        dlng = np.diff(lng_vals) * (np.pi / 180.0)
        lat_m = lat_vals[:-1] * (np.pi / 180.0)
        dx = dlng * np.cos(lat_m) * R  # East (m)
        dy = dlat * R                   # North (m)
        dist = np.sqrt(dx ** 2 + dy ** 2)
        gps_speed = np.concatenate([[dist[0] * sample_hz], dist * sample_hz])  # m/s

        # Heading change rate (°/s, signed; wrap-around safe)
        d_hdg = np.diff(hdg_vals)
        d_hdg = ((d_hdg + 180.0) % 360.0) - 180.0
        heading_delta = np.concatenate([[0.0], d_hdg * sample_hz])
        heading_delta_abs = np.abs(heading_delta)

        # Curvature = |omega_rad| / speed  (1/m); capped at 1.0 (r = 1 m, very tight)
        omega_rad = heading_delta_abs * (np.pi / 180.0)
        curvature = omega_rad / np.maximum(gps_speed, 0.5)
        curvature = np.clip(curvature, 0.0, 1.0)

        # Lateral velocity proxy = speed × sin(heading_delta_rad)
        lateral_v = gps_speed * np.sin(heading_delta * (np.pi / 180.0))

        return np.stack(
            [hdg_vals, heading_delta, heading_delta_abs, curvature, gps_speed, lateral_v],
            axis=1,
        ).astype(np.float32)

    except Exception:
        return zeros


def _load_rtk_npy(rtk_dir: Path, sid: str, T: int) -> np.ndarray:
    """Load pre-extracted RTK .npy file for session sid. Returns (T, 6) zeros if missing."""
    N = len(GPS_RTK_FEATURE_NAMES)
    for name in (sid, normalize_session_id(sid)):
        p = rtk_dir / f"{name}_rtk.npy"
        if p.exists():
            arr = np.load(str(p)).astype(np.float32)
            if arr.shape[0] > T:
                return arr[:T]
            if arr.shape[0] < T:
                pad = np.zeros((T - arr.shape[0], N), dtype=np.float32)
                return np.concatenate([arr, pad], axis=0)
            return arr
    return np.zeros((T, N), dtype=np.float32)


def _load_vocabs_all(vocab_dir: Path):
    g_l, g_lm, g_v = _load_vocab(vocab_dir / "vocab_goal.json")
    s_l, s_lm, s_v = _load_vocab(vocab_dir / "vocab_stimuli.json")
    c_l, c_lm, c_v = _load_vocab(vocab_dir / "vocab_cause.json")
    a_l, a_lm, a_v = _load_vocab(vocab_dir / "vocab_attention.json")
    return g_l, g_lm, g_v, s_l, s_lm, s_v, c_l, c_lm, c_v, a_l, a_lm, a_v


def _collect_sessions_imp(
    manifest_path:  Path,
    sensor_dir:     Path,
    det_cache_dir:  Optional[Path],
    eaf_parsed_dir: Optional[Path],
    vocab_dir:      Path,
    cfg:            ImpMultiConfig,
    rtk_dir:        Optional[Path] = None,
) -> Tuple[List[Tuple[str, np.ndarray, np.ndarray, np.ndarray, np.ndarray]],
           List[str], List[str]]:
    """Load all sessions as raw per-timestep arrays (unnormalized).

    Returns
    -------
    sessions     : list of (day_id, X, ev_vec, goal_vec, stim_vec)
                   X        : (T, sensor_dim + det_dim) float32
                   ev_vec   : (T,) int64  0/1
                   goal_vec : (T,) int64  >=0  (-1 remapped to 0)
                   stim_vec : (T,) int64  >=0
    goal_labels  : class name list
    stim_labels  : class name list
    """
    g_l, g_lm, g_v, s_l, s_lm, s_v, c_l, c_lm, c_v, a_l, a_lm, a_v = \
        _load_vocabs_all(vocab_dir)

    eaf_map: Dict[str, Path] = {}
    if eaf_parsed_dir is not None and eaf_parsed_dir.is_dir():
        eaf_map = _eaf_map(eaf_parsed_dir)

    records  = load_manifest(manifest_path)
    sessions: List[Tuple] = []
    n_ok = n_skip = 0

    for rec in records:
        sid      = rec.session_id
        sid_norm = normalize_session_id(sid)

        spt = sensor_dir / f"{sid}.npy"
        if not spt.exists():
            spt = sensor_dir / f"{sid_norm}.npy"
        if not spt.exists():
            n_skip += 1
            continue

        eaf_path = eaf_map.get(sid) or eaf_map.get(sid_norm)
        if eaf_path is None:
            n_skip += 1
            continue

        try:
            sensors = np.load(str(spt)).astype(np.float32)
            T       = len(sensors)
            if T < 30:
                n_skip += 1
                continue

            X_det = _load_det(det_cache_dir, sid, T, cfg)  # (T, det_dim)
            X     = np.concatenate([sensors, X_det], axis=1)
            if rtk_dir is not None:
                X = np.concatenate([X, _load_rtk_npy(rtk_dir, sid, T)], axis=1)

            tiers = _load_eaf_json(eaf_path)
            if not tiers:
                n_skip += 1
                continue

            ev_vec, goal_raw, stim_raw, _, _ = _label_vectors_imp(
                T, cfg.sample_hz, tiers,
                g_lm, g_v, s_lm, s_v, c_lm, c_v, a_lm, a_v,
                t_offset_s=0.0,
            )
            # Map -1 (unlabelled) to 0 (background class)
            goal_vec = np.maximum(goal_raw, 0).astype(np.int64)
            stim_vec = np.maximum(stim_raw, 0).astype(np.int64)

            day_id = str(rec.day_id or sid[:8])
            sessions.append((day_id, X, ev_vec, goal_vec, stim_vec))
            n_ok += 1

        except Exception as exc:
            print(f"  [!] {sid}: {exc}")
            n_skip += 1

    print(f"Sessions loaded: {n_ok} ok, {n_skip} skipped")
    return sessions, g_l, s_l


# ---------------------------------------------------------------------------
# Day split (works with 5-tuple sessions)
# ---------------------------------------------------------------------------

def _day_split_imp(
    sessions:  List[Tuple],
    val_frac:  float = 0.15,
    test_frac: float = 0.15,
) -> Tuple[set, set]:
    """Chronological day-based split. Returns (test_days, val_days)."""
    all_days = sorted({day for day, *_ in sessions})
    n        = len(all_days)
    n_test   = max(1, round(n * test_frac))
    n_val    = max(1, round(n * val_frac))
    test_days = set(all_days[-n_test:])
    val_days  = set(all_days[-(n_test + n_val): -n_test])
    return test_days, val_days


# ---------------------------------------------------------------------------
# Windowing with strategy-3 support
# ---------------------------------------------------------------------------

def _build_windows_s3(
    X:          np.ndarray,    # (T, D) unnormalized
    goal_vec:   np.ndarray,    # (T,) int64 >= 0
    stim_vec:   np.ndarray,
    ev_vec:     np.ndarray,
    window_len: int,
    stride:     int,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Majority-vote windowing (strategy 3).  Returns (X_w, ev_w, goal_w, stim_w)."""
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
    X:             np.ndarray,
    ev_vec:        np.ndarray,
    goal_vec:      np.ndarray,
    stim_vec:      np.ndarray,
    window_len:    int,
    stride_len:    int,
    strategy3:     bool,
    horizon_steps: int = 0,
    max_horizon:   int = 0,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Window a single session. strategy3 applies only at horizon=0 (training)."""
    if strategy3 and horizon_steps == 0:
        return _build_windows_s3(X, goal_vec, stim_vec, ev_vec, window_len, stride_len)
    else:
        return create_windows(
            X, goal_vec, stim_vec, window_len, stride_len,
            horizon_steps=horizon_steps, max_horizon=max_horizon,
        )


def _make_splits_imp(
    sessions:   List[Tuple],   # (day_id, X, ev_vec, goal_vec, stim_vec)
    window_len: int,
    stride_len: int,
    test_days:  set,
    val_days:   set,
    strategy3:  bool,
) -> Dict[str, Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]]:
    input_dim = sessions[0][1].shape[1] if sessions else 1
    buckets: Dict[str, List] = {"train": [], "val": [], "test": []}

    for day_id, X, ev_vec, goal_vec, stim_vec in sessions:
        X_w, ev_w, go_w, st_w = _window_session(
            X, ev_vec, goal_vec, stim_vec,
            window_len, stride_len, strategy3,
        )
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


# ---------------------------------------------------------------------------
# Cascade evaluation with strategy 1a / 1b support
# ---------------------------------------------------------------------------

def _evaluate_cascade_imp(
    X_test:      np.ndarray,
    ev_test:     np.ndarray,
    g_test:      np.ndarray,
    s_test:      np.ndarray,
    cfg:         ImpMultiConfig,
    model_dir:   Path,
    goal_labels: List[str],
    stim_labels: List[str],
) -> Dict[str, Any]:
    """Run Stage1 → Stage2 cascade and return a metrics dict."""
    mm_cfg    = _to_mm_cfg(cfg)
    is_neural = cfg.model_type in NEURAL_MODELS
    use_1a    = "1a" in cfg.strategies
    threshold = cfg.stage1_threshold if "1b" in cfg.strategies else 0.5

    n_g = cfg.n_goal_classes    or (int(g_test.max()) + 1 if len(g_test) else len(goal_labels))
    n_s = cfg.n_stimuli_classes or (int(s_test.max()) + 1 if len(s_test) else len(stim_labels))

    # ── Stage 1 ──────────────────────────────────────────────────────────────
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

    # ── Stage 2 ──────────────────────────────────────────────────────────────
    g_pred = np.zeros(len(X_test), dtype=np.int64)
    s_pred = np.zeros(len(X_test), dtype=np.int64)
    s2_path = model_dir / ("stage2.pt" if is_neural else "stage2_tree.joblib")

    if ev_mask.sum() > 0:
        X_ev = X_test[ev_mask]
        if is_neural:
            g_ev, s_ev = _predict_neural_s2(X_ev, mm_cfg, s2_path)
        else:
            g_ev, s_ev = _predict_tree_s2(X_ev, s2_path)
        g_pred[ev_mask] = g_ev
        s_pred[ev_mask] = s_ev

    # Strategy 1a post-process: event = goal != background (class 0)
    if use_1a:
        ev_pred[:] = (g_pred != 0).astype(np.int64)

    # ── Oracle Stage-2 on ground-truth events ─────────────────────────────────
    ev_gt_mask = ev_test == 1
    g_oracle_m: Dict[str, Any] = {}
    s_oracle_m: Dict[str, Any] = {}

    if ev_gt_mask.sum() > 0:
        X_ev_gt = X_test[ev_gt_mask]
        g_or, s_or = (_predict_neural_s2(X_ev_gt, mm_cfg, s2_path)
                      if is_neural else _predict_tree_s2(X_ev_gt, s2_path))
        g_names = goal_labels or [str(i) for i in range(n_g)]
        s_names = stim_labels or [str(i) for i in range(n_s)]
        g_oracle_m = compute_metrics(g_or, g_test[ev_gt_mask], n_g, g_names)
        s_oracle_m = compute_metrics(s_or, s_test[ev_gt_mask], n_s, s_names)

    # ── Metrics ───────────────────────────────────────────────────────────────
    g_names = goal_labels or [str(i) for i in range(n_g)]
    s_names = stim_labels or [str(i) for i in range(n_s)]
    ev_m = compute_metrics(ev_pred, ev_test, 2, ["no_event", "event"])
    g_m  = compute_metrics(g_pred,  g_test,  n_g, g_names)
    s_m  = compute_metrics(s_pred,  s_test,  n_s, s_names)

    return {
        "n_test":                    int(len(X_test)),
        "n_predicted_events":        int(ev_mask.sum()),
        "n_actual_events":           int(ev_gt_mask.sum()),
        "stage1_f1":                 float(ev_m.get("macro_f1", 0.0)),
        "stage1_weighted_f1":        float(ev_m.get("weighted_f1", 0.0)),
        "goal_f1":                   float(g_m.get("macro_f1", 0.0)),
        "goal_weighted_f1":          float(g_m.get("weighted_f1", 0.0)),
        "stimuli_f1":                float(s_m.get("macro_f1", 0.0)),
        "stimuli_weighted_f1":       float(s_m.get("weighted_f1", 0.0)),
        "goal_oracle_f1":            float(g_oracle_m.get("macro_f1", 0.0)),
        "goal_oracle_weighted_f1":   float(g_oracle_m.get("weighted_f1", 0.0)),
        "stimuli_oracle_f1":         float(s_oracle_m.get("macro_f1", 0.0)),
        "stimuli_oracle_weighted_f1":float(s_oracle_m.get("weighted_f1", 0.0)),
        "event_metrics":             ev_m,
        "goal_metrics":              g_m,
        "stimuli_metrics":           s_m,
        "goal_oracle_metrics":       g_oracle_m,
        "stimuli_oracle_metrics":    s_oracle_m,
    }


# ---------------------------------------------------------------------------
# Multi-horizon evaluation for transformer (trained by two_stage_yolo_improved)
# ---------------------------------------------------------------------------

def _multihorizon_transformer_imp(
    outdir:      Path,
    sessions:    List[Tuple],   # (day_id, X, ev_vec, goal_vec, stim_vec)
    test_days:   set,
    goal_labels: List[str],
    stim_labels: List[str],
    sample_hz:   float,
) -> None:
    """Multi-horizon evaluation for the transformer trained by two_stage_yolo_improved."""
    import torch
    from torch.utils.data import DataLoader, TensorDataset

    try:
        s1, s2, imp_cfg, mean, std = _load_improved_models(outdir)
    except Exception as exc:
        print(f"[!] Could not load improved transformer models: {exc}")
        return

    dev    = torch.device(imp_cfg.device)
    s1_dev = s1.to(dev) if s1 is not None else None
    s2_dev = s2.to(dev)
    wl     = imp_cfg.window_len
    bs     = imp_cfg.batch_size
    use_1a = "1a" in imp_cfg.strategies
    use_1b = "1b" in imp_cfg.strategies
    thr    = imp_cfg.stage1_threshold if use_1b else 0.5
    n_g    = imp_cfg.n_goal_classes
    n_s    = imp_cfg.n_stimuli_classes
    g_names = goal_labels or [str(i) for i in range(n_g)]
    s_names = stim_labels or [str(i) for i in range(n_s)]
    stride  = max(1, wl // 3)

    test_sessions = [(d, X, ev, g, s) for d, X, ev, g, s in sessions if d in test_days]
    if not test_sessions:
        print("[!] No test sessions for transformer multi-horizon evaluation.")
        return

    def _s1_probs(X_np: np.ndarray) -> np.ndarray:
        if use_1a or s1_dev is None:
            return np.ones(len(X_np), dtype=np.float32)
        dl = DataLoader(TensorDataset(torch.from_numpy(X_np)), batch_size=bs)
        probs: List[np.ndarray] = []
        with torch.no_grad():
            for (xb,) in dl:
                p = torch.softmax(s1_dev(xb.to(dev)), dim=1)[:, 1]
                probs.append(p.cpu().numpy())
        return np.concatenate(probs)

    def _s2_preds(X_np: np.ndarray) -> Tuple[np.ndarray, np.ndarray]:
        dl = DataLoader(TensorDataset(torch.from_numpy(X_np)), batch_size=bs)
        gp: List[np.ndarray] = []
        sp: List[np.ndarray] = []
        with torch.no_grad():
            for (xb,) in dl:
                gl, sl, _, _ = s2_dev(xb.to(dev))
                gp.append(gl.argmax(1).cpu().numpy())
                sp.append(sl.argmax(1).cpu().numpy())
        return np.concatenate(gp), np.concatenate(sp)

    horizons_steps = [1, 2, 3, 6, 9, 12, 15]
    max_h_steps    = max(horizons_steps)
    metrics_all_h: Dict[str, Any] = {}

    print(f"\n--- Transformer Multi-Horizon Evaluation ({len(horizons_steps)} horizons) ---")

    for h_steps in horizons_steps:
        h_s   = h_steps / sample_hz
        h_key = f"{h_s:.3f}s"

        bkts: List = []
        for _day, X_s, ev_s, g_s, s_s in test_sessions:
            Xw, evw, gw, sw = create_windows(
                X_s, g_s, s_s, wl, stride,
                horizon_steps=h_steps, max_horizon=max_h_steps,
            )
            if len(Xw) > 0:
                bkts.append((Xw, evw, gw, sw))

        if not bkts:
            continue

        Xh  = np.concatenate([b[0] for b in bkts])
        evh = np.concatenate([b[1] for b in bkts])
        gh  = np.concatenate([b[2] for b in bkts])
        sh  = np.concatenate([b[3] for b in bkts])
        Xh_n = (Xh - mean) / std

        ev_probs = _s1_probs(Xh_n)
        ev_pred  = (ev_probs >= thr).astype(np.int64)
        ev_mask  = ev_pred == 1

        g_pred = np.zeros(len(Xh_n), dtype=np.int64)
        s_pred = np.zeros(len(Xh_n), dtype=np.int64)
        if ev_mask.sum() > 0:
            g_pred[ev_mask], s_pred[ev_mask] = _s2_preds(Xh_n[ev_mask])

        if use_1a:
            ev_pred[:] = (g_pred != 0).astype(np.int64)
            ev_mask = ev_pred == 1

        ev_gt_mask = evh == 1
        g_oracle_m: Dict[str, Any] = {}
        s_oracle_m: Dict[str, Any] = {}
        if ev_gt_mask.sum() > 0:
            g_or, s_or = _s2_preds(Xh_n[ev_gt_mask])
            g_oracle_m = compute_metrics(g_or, gh[ev_gt_mask], n_g, g_names)
            s_oracle_m = compute_metrics(s_or, sh[ev_gt_mask], n_s, s_names)

        ev_m = compute_metrics(ev_pred, evh, 2, ["no_event", "event"])
        g_m  = compute_metrics(g_pred,  gh,  n_g, g_names)
        s_m  = compute_metrics(s_pred,  sh,  n_s, s_names)

        res_h: Dict[str, Any] = {
            "n_test":               int(len(Xh_n)),
            "n_predicted_events":   int(ev_mask.sum()),
            "n_actual_events":      int(ev_gt_mask.sum()),
            "stage1_f1":            float(ev_m.get("macro_f1", 0.0)),
            "goal_f1":              float(g_m.get("macro_f1", 0.0)),
            "stimuli_f1":           float(s_m.get("macro_f1", 0.0)),
            "goal_oracle_f1":       float(g_oracle_m.get("macro_f1", 0.0)),
            "stimuli_oracle_f1":    float(s_oracle_m.get("macro_f1", 0.0)),
            "event_metrics":        ev_m,
            "goal_metrics":         g_m,
            "stimuli_metrics":      s_m,
            "goal_oracle_metrics":  g_oracle_m,
            "stimuli_oracle_metrics": s_oracle_m,
        }
        metrics_all_h[h_key] = res_h
        print(
            f"  h={h_key:<8}  n={len(Xh_n):>6}  "
            f"S1={res_h['stage1_f1']:.3f}  "
            f"Goal={res_h['goal_f1']:.3f}  "
            f"Stim={res_h['stimuli_f1']:.3f}"
        )

    if metrics_all_h:
        p = outdir / "metrics_all_horizons.json"
        p.write_text(json.dumps(metrics_all_h, indent=2, default=float))
        print(f"Multi-horizon metrics saved to {p}")


# ---------------------------------------------------------------------------
# CLI commands
# ---------------------------------------------------------------------------

def cmd_train(args: argparse.Namespace) -> None:
    """Train Stage1 + Stage2 with improved detection features and chosen model."""
    outdir     = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    strategies = list(getattr(args, "strategies", []) or [])
    sample_hz  = float(args.sample_hz)

    # ── Transformer: delegate to two_stage_yolo_improved, then multi-horizon ─
    if args.model == _TRANSFORMER:
        from twimo.strategies_eaf.two_stage_yolo_improved import cmd_train as imp_train
        profiler = TrainingProfiler(
            model_name="two_stage_yolo_improved_transformer",
            output_dir=outdir,
            use_codecarbon=True,
        )
        rtk_dir = Path(args.rtk_dir) if getattr(args, "rtk_dir", None) else None
        with profiler:
            profiler.begin_phase("training")
            imp_train(args)
            profiler.end_phase("training")

            profiler.begin_phase("multihorizon_eval")
            try:
                cfg_proxy = ImpMultiConfig(
                    strategies=strategies,
                    sample_hz=sample_hz,
                    sensor_dim=int(getattr(args, "sensor_dim", 8)),
                    use_rtk=rtk_dir is not None,
                    rtk_dim=6 if rtk_dir is not None else 0,
                )
                sessions, goal_labels, stim_labels = _collect_sessions_imp(
                    Path(args.manifest),
                    Path(args.prealigned_sensors_dir),
                    Path(args.det_cache_dir) if getattr(args, "det_cache_dir", None) else None,
                    Path(args.eaf_parsed_dir) if getattr(args, "eaf_parsed_dir", None) else None,
                    Path(args.vocab_dir),
                    cfg_proxy,
                    rtk_dir=rtk_dir,
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
    print(f"=== Improved Multi-Model: {args.model}  strategies={strategies} ===")

    profiler = TrainingProfiler(
        model_name=f"two_stage_yolo_improved_{args.model}",
        output_dir=outdir,
        use_codecarbon=True,
    )

    with profiler:
        # Build config
        cfg = ImpMultiConfig(
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

        # Load vocabularies
        vd = Path(args.vocab_dir)
        g_l, g_lm, g_v, s_l, s_lm, s_v, c_l, c_lm, c_v, a_l, a_lm, a_v = \
            _load_vocabs_all(vd)
        cfg.n_goal_classes    = len(g_l)
        cfg.n_stimuli_classes = len(s_l)

        # Load sessions (optionally with RTK GPS features)
        rtk_dir = Path(args.rtk_dir) if getattr(args, "rtk_dir", None) else None
        cfg.use_rtk = rtk_dir is not None
        cfg.rtk_dim = len(GPS_RTK_FEATURE_NAMES) if cfg.use_rtk else 0
        sessions, goal_labels, stim_labels = _collect_sessions_imp(
            Path(args.manifest),
            Path(args.prealigned_sensors_dir),
            Path(args.det_cache_dir) if getattr(args, "det_cache_dir", None) else None,
            Path(args.eaf_parsed_dir) if getattr(args, "eaf_parsed_dir", None) else None,
            vd, cfg,
            rtk_dir=rtk_dir,
        )
        if not sessions:
            print("[!] No sessions loaded. Aborting.")
            return

        cfg.input_dim = sessions[0][1].shape[1]
        print(f"Input dim: {cfg.input_dim}  Goal: {cfg.n_goal_classes}  "
              f"Stimuli: {cfg.n_stimuli_classes}  det_dim: {cfg.det_dim}")

        # Day split + windowing
        test_days, val_days = _day_split_imp(sessions)
        strategy3 = "3" in strategies
        splits    = _make_splits_imp(
            sessions, cfg.window_len, cfg.stride_len,
            test_days, val_days, strategy3,
        )
        X_train, ev_train, g_train, s_train = splits["train"]
        X_val,   ev_val,   g_val,   s_val   = splits["val"]
        X_test,  ev_test,  g_test,  s_test  = splits["test"]

        print(f"Windows - train: {len(X_train)}  val: {len(X_val)}  test: {len(X_test)}")
        if len(X_train) == 0:
            print("[!] No training data. Aborting.")
            return
        print(f"Train events: {int(ev_train.sum())}/{len(ev_train)} "
              f"({100*ev_train.mean():.1f}%)")

        # Normalize
        X_train, X_val, X_test, mean, std = _normalize(X_train, X_val, X_test)
        np.save(str(outdir / "norm_mean.npy"), mean)
        np.save(str(outdir / "norm_std.npy"),  std)

        # Optional window balancing
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

        # For strategy 1a, train Stage 2 on ALL windows; otherwise event windows only
        if use_1a:
            ev_train_s2 = np.ones(len(X_train), dtype=np.int64)
            ev_val_s2   = np.ones(len(X_val),   dtype=np.int64)
        else:
            ev_train_s2 = ev_train
            ev_val_s2   = ev_val

        n_stage2_train = int((ev_train_s2 == 1).sum())
        print(f"  Stage 2 training windows: {n_stage2_train}")
        if n_stage2_train == 0:
            print("[!] No Stage-2 training windows. Aborting.")
            return

        profiler.begin_phase("stage2_train", n_samples=n_stage2_train)
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

        # ── Save config ───────────────────────────────────────────────────────
        with open(outdir / "config.json", "w") as f:
            json.dump(_cfg_to_dict(cfg), f, indent=2)
        with open(outdir / "strategies.json", "w") as f:
            json.dump({
                "strategies": strategies,
                "det_cols":   cfg.active_det_cols(),
                "input_dim":  cfg.input_dim,
                "window_sec": cfg.window_sec,
            }, f, indent=2)
        det_names = [DET_FEATURE_NAMES_IMP[c] for c in cfg.active_det_cols()]
        rtk_names = GPS_RTK_FEATURE_NAMES if cfg.use_rtk else []
        feature_names = SENSOR_FEATURE_NAMES[:cfg.sensor_dim] + det_names + rtk_names
        with open(outdir / "feature_names.json", "w") as f:
            json.dump({
                "sensor":    SENSOR_FEATURE_NAMES[:cfg.sensor_dim],
                "detection": det_names,
                "rtk":       rtk_names,
                "all":       feature_names,
                "input_dim": len(feature_names),
            }, f, indent=2)

        # ── Train / Val / Test evaluation ────────────────────────────────────
        profiler.begin_phase("inference", n_samples=int(len(X_test)))
        for split_name, Xs, evs, gs, ss in [
            ("train", X_train, ev_train, g_train, s_train),
            ("val",   X_val,   ev_val,   g_val,   s_val),
            ("test",  X_test,  ev_test,  g_test,  s_test),
        ]:
            if len(Xs) == 0:
                print(f"[!] No {split_name} data for evaluation.")
                continue
            res = _evaluate_cascade_imp(
                Xs, evs, gs, ss, cfg, outdir, goal_labels, stim_labels,
            )
            (outdir / f"metrics_{split_name}.json").write_text(
                json.dumps(res, indent=2, default=float))
            print(f"\n{split_name.capitalize()}: "
                  f"S1={res['stage1_f1']:.3f}(w={res['stage1_weighted_f1']:.3f})  "
                  f"Goal={res['goal_f1']:.3f}(w={res['goal_weighted_f1']:.3f})  "
                  f"Stim={res['stimuli_f1']:.3f}(w={res['stimuli_weighted_f1']:.3f})")
        profiler.end_phase("inference")

        # ── Multi-horizon evaluation ──────────────────────────────────────────
        test_sessions = [
            (d, X, ev, g, s) for d, X, ev, g, s in sessions if d in test_days
        ]
        if test_sessions:
            print(f"\n--- Multi-Horizon Evaluation ({7} horizons) ---")
            horizons_steps = [1, 2, 3, 6, 9, 12, 15]
            max_h_steps    = max(horizons_steps)
            metrics_all_h: Dict[str, Any] = {}

            for h_steps in horizons_steps:
                h_s   = h_steps / sample_hz
                h_key = f"{h_s:.3f}s"

                bkts: List = []
                for _day, X_s, ev_s, g_s, s_s in test_sessions:
                    Xw, evw, gw, sw = create_windows(
                        X_s, g_s, s_s,
                        cfg.window_len, cfg.stride_len,
                        horizon_steps=h_steps, max_horizon=max_h_steps,
                    )
                    if len(Xw) > 0:
                        bkts.append((Xw, evw, gw, sw))

                if not bkts:
                    continue

                Xh  = np.concatenate([b[0] for b in bkts])
                evh = np.concatenate([b[1] for b in bkts])
                gh  = np.concatenate([b[2] for b in bkts])
                sh  = np.concatenate([b[3] for b in bkts])
                Xh  = (Xh - mean) / std

                res_h = _evaluate_cascade_imp(
                    Xh, evh, gh, sh, cfg, outdir, goal_labels, stim_labels,
                )
                metrics_all_h[h_key] = res_h
                print(
                    f"  h={h_key:<8}  n={len(Xh):>6}  "
                    f"S1={res_h['stage1_f1']:.3f}  "
                    f"Goal={res_h['goal_f1']:.3f}  "
                    f"Stim={res_h['stimuli_f1']:.3f}"
                )

            if metrics_all_h:
                p = outdir / "metrics_all_horizons.json"
                p.write_text(json.dumps(metrics_all_h, indent=2, default=float))
                print(f"Multi-horizon metrics saved to {p}")

    print(f"\nAll artifacts saved to {outdir}")


def cmd_evaluate(args: argparse.Namespace) -> None:
    """Evaluate a trained model: train/val/test splits + multi-horizon metrics."""
    outdir    = Path(args.outdir)
    model_dir = Path(args.model_dir)
    outdir.mkdir(parents=True, exist_ok=True)

    with open(model_dir / "config.json", encoding="utf-8") as f:
        cfg_dict = json.load(f)

    # Transformer models (trained by two_stage_yolo_improved) don't have
    # model_type in config — delegate to the original evaluate function.
    if "model_type" not in cfg_dict:
        from twimo.strategies_eaf.two_stage_yolo_improved import cmd_evaluate as imp_evaluate
        imp_evaluate(args)
        return

    cfg = _cfg_from_dict(cfg_dict)

    mean = np.load(str(model_dir / "norm_mean.npy"))
    std  = np.load(str(model_dir / "norm_std.npy"))
    sample_hz = cfg.sample_hz

    sessions, goal_labels, stim_labels = _collect_sessions_imp(
        Path(args.manifest),
        Path(args.prealigned_sensors_dir),
        Path(args.det_cache_dir) if getattr(args, "det_cache_dir", None) else None,
        Path(args.eaf_parsed_dir) if getattr(args, "eaf_parsed_dir", None) else None,
        Path(args.vocab_dir),
        cfg,
        rtk_dir=Path(args.rtk_dir) if getattr(args, "rtk_dir", None) else None,
    )
    if not sessions:
        print("[!] No sessions loaded.")
        return

    # ── Day split ─────────────────────────────────────────────────────────────
    test_days, val_days = _day_split_imp(sessions)
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

    # ── Per-split metrics ─────────────────────────────────────────────────────
    for split_name, split_sess in [("train", train_sess),
                                   ("val",   val_sess),
                                   ("test",  test_sess)]:
        Xs, evs, gs, ss = _window_split(split_sess)
        if Xs is None:
            print(f"  [{split_name}] no windows – skipping")
            continue
        res = _evaluate_cascade_imp(Xs, evs, gs, ss, cfg, model_dir,
                                    goal_labels, stim_labels)
        fpath = outdir / f"metrics_{split_name}.json"
        fpath.write_text(json.dumps(res, indent=2, default=float))
        print(f"\n{split_name.capitalize()}: S1={res['stage1_f1']:.3f}  "
              f"Goal={res['goal_f1']:.3f}  Stim={res['stimuli_f1']:.3f}"
              f"  -> {fpath}")

    # ── Multi-horizon on test ─────────────────────────────────────────────────
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
                    X_s, g_s, s_s,
                    cfg.window_len, cfg.stride_len,
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
            res_h = _evaluate_cascade_imp(Xh, evh, gh, sh, cfg, model_dir,
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
    else:
        print("[!] No test sessions for multi-horizon eval.")

    print(f"\nAll metrics -> {outdir}")


# ---------------------------------------------------------------------------
# CLI
# ---------------------------------------------------------------------------

STRATEGIES_HELP = (
    "Active strategies: 1a (skip Stage1), 1b (soft Stage1 threshold), "
    "2 (zone features), 3 (majority-vote labels), "
    "5 (motion features, needs extract-improved), "
    "6 (top-K vehicles, needs extract-improved), "
    "7 (10s window). "
    "Strategy 4 (class weights) applies only for --model transformer."
)


def _add_data_args(p: argparse.ArgumentParser) -> None:
    p.add_argument("--manifest",               required=True,  type=Path)
    p.add_argument("--prealigned-sensors-dir", required=True,  type=Path)
    p.add_argument("--det-cache-dir",          default=None,   type=Path,
                   help="Dir with {sid}_det_imp.npy or {sid}_det.npy")
    p.add_argument("--eaf-parsed-dir",         required=True,  type=Path)
    p.add_argument("--vocab-dir",              required=True,  type=Path)
    p.add_argument("--sample-hz",              default=3.0,    type=float)


def cmd_extract_rtk(args: argparse.Namespace) -> None:
    """Extract RTK GPS features from HDD session folders and save as {sid}_rtk.npy."""
    hdd_root   = Path(args.hdd_root)
    out_dir    = Path(args.out_dir)
    sensor_dir = Path(args.prealigned_sensors_dir)
    sample_hz  = float(getattr(args, "sample_hz", 3.0))
    out_dir.mkdir(parents=True, exist_ok=True)

    records = load_manifest(Path(args.manifest))
    n_ok = n_skip = 0

    for rec in records:
        sid      = rec.session_id
        sid_norm = normalize_session_id(sid)

        # Get T from prealigned sensor .npy
        spt = sensor_dir / f"{sid}.npy"
        if not spt.exists():
            spt = sensor_dir / f"{sid_norm}.npy"
        if not spt.exists():
            n_skip += 1
            continue
        T = len(np.load(str(spt), mmap_mode="r"))

        # Find session CSV dir: {hdd_root}/{day_id}/{session_id}/general/csv
        day_id  = rec.day_id or ""
        csv_dir = hdd_root / day_id / sid / "general" / "csv"
        if not csv_dir.exists():
            csv_dir = hdd_root / day_id / sid_norm / "general" / "csv"
        if not csv_dir.exists() and rec.csv_dir:
            csv_dir = Path(rec.csv_dir)
        if not csv_dir.exists():
            n_skip += 1
            continue

        feat     = _extract_rtk_features(csv_dir, T, sample_hz)
        out_path = out_dir / f"{sid_norm}_rtk.npy"
        np.save(str(out_path), feat)
        n_ok += 1
        print(f"  [{n_ok}] {sid_norm}  T={T}  -> {out_path.name}")

    print(f"\nDone: {n_ok} ok, {n_skip} skipped  -> {out_dir}")


def main() -> None:
    pa  = argparse.ArgumentParser(
        description="Improved detection features x multi-model two-stage EAF pipeline"
    )
    sub = pa.add_subparsers(dest="cmd", required=True)

    # ── extract-improved ──────────────────────────────────────────────────────
    p_ext = sub.add_parser(
        "extract-improved",
        help="Build 39-dim improved detection cache (delegates to two_stage_yolo_improved)"
    )
    p_ext.add_argument("--manifest",               required=True,  type=Path)
    p_ext.add_argument("--det-cache-dir",          required=True,  type=Path)
    p_ext.add_argument("--yolo-model",             default="yolov8n.pt", type=str)
    p_ext.add_argument("--prealigned-sensors-dir", default=None,   type=Path)
    p_ext.add_argument("--overwrite",              action="store_true")
    p_ext.add_argument("--sample-hz",              default=3.0,    type=float)

    # ── train ─────────────────────────────────────────────────────────────────
    p_tr = sub.add_parser("train", help="Train with chosen model + strategies")
    _add_data_args(p_tr)
    p_tr.add_argument("--outdir",            required=True, type=Path)
    p_tr.add_argument("--model",             required=True,
                      choices=sorted(_ALL_MODELS),
                      help="Model: " + ", ".join(sorted(_ALL_MODELS)))
    p_tr.add_argument("--strategies",        default=[], nargs="*",
                      help=STRATEGIES_HELP)
    p_tr.add_argument("--stage1-threshold",  default=0.30, type=float,
                      help="P(event) threshold for strategy 1b (default 0.30)")
    p_tr.add_argument("--window-sec",        default=5.0,  type=float)
    p_tr.add_argument("--stride-sec",        default=1.0,  type=float)
    p_tr.add_argument("--epochs",            default=30,   type=int)
    p_tr.add_argument("--lr",               default=1e-4,  type=float)
    p_tr.add_argument("--batch-size",        default=64,   type=int)
    p_tr.add_argument("--balance-ratio",     default=None, type=float,
                      help="If set, balance Stage-1 training to this event ratio.")
    p_tr.add_argument("--rtk-dir",          default=None, type=Path,
                      help="Dir with {sid}_rtk.npy files (from extract-rtk). "
                           "Adds 6 RTK GPS features to the input.")

    # ── evaluate ──────────────────────────────────────────────────────────────
    p_ev = sub.add_parser("evaluate", help="Evaluate a trained model")
    _add_data_args(p_ev)
    p_ev.add_argument("--model-dir", required=True, type=Path)
    p_ev.add_argument("--outdir",    required=True, type=Path)
    p_ev.add_argument("--rtk-dir",   default=None,  type=Path,
                      help="Dir with {sid}_rtk.npy files (must match training config).")

    # ── extract-rtk ───────────────────────────────────────────────────────────
    p_rtk = sub.add_parser(
        "extract-rtk",
        help="Compute RTK GPS features from HDD CSVs and save as {sid}_rtk.npy"
    )
    p_rtk.add_argument("--manifest",               required=True, type=Path)
    p_rtk.add_argument("--prealigned-sensors-dir", required=True, type=Path,
                       help="Used to determine T (length) for each session.")
    p_rtk.add_argument("--hdd-root",               required=True, type=Path,
                       help="Root of HDD data: {hdd-root}/{day_id}/{session_id}/general/csv/")
    p_rtk.add_argument("--out-dir",                required=True, type=Path,
                       help="Output dir for {sid}_rtk.npy files.")
    p_rtk.add_argument("--sample-hz",              default=3.0,   type=float)

    args = pa.parse_args()
    {
        "extract-improved": cmd_extract_improved,
        "extract-rtk":      cmd_extract_rtk,
        "train":            cmd_train,
        "evaluate":         cmd_evaluate,
    }[args.cmd](args)


if __name__ == "__main__":
    main()
