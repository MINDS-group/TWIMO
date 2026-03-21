#!/usr/bin/env python
"""two_stage_multi_model.py
==========================
Self-contained Two-Stage pipeline for multiple model families:
  - Neural:      GRU, LSTM, TCN, MLP (mean / max / concat pooling)
  - Tree-based:  XGBoost, LightGBM, Random Forest

Stage 1: Binary event detection  (event vs no-event window)
Stage 2: Goal + Stimuli multi-class classification (event windows only)

Data preparation is fully compatible with two_stage_transformer.py.
You can reuse the same prepared data directory across both pipelines.

Usage:
  # 1. Prepare data (identical output to two_stage_transformer prepare)
  python -m twimo.strategies_eaf.two_stage_multi_model prepare \\
      --sensor-dir  ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --vocab-dir   ./artifacts/eaf/vocabs \\
      --output-dir  ./artifacts/eaf/two_stage/data

  # 2. Train Stage 1  (event detection)
  python -m twimo.strategies_eaf.two_stage_multi_model train-stage1 \\
      --model gru \\
      --data-dir ./artifacts/eaf/two_stage/data \\
      --outdir   ./artifacts/eaf/two_stage/gru/stage1

  # 3. Train Stage 2  (Goal / Stimuli classification)
  python -m twimo.strategies_eaf.two_stage_multi_model train-stage2 \\
      --model gru \\
      --data-dir    ./artifacts/eaf/two_stage/data \\
      --stage1-model ./artifacts/eaf/two_stage/gru/stage1/stage1.pt \\
      --outdir      ./artifacts/eaf/two_stage/gru/stage2

  # 4. End-to-end prediction + evaluation
  python -m twimo.strategies_eaf.two_stage_multi_model predict \\
      --model gru \\
      --data-dir     ./artifacts/eaf/two_stage/data \\
      --stage1-model ./artifacts/eaf/two_stage/gru/stage1/stage1.pt \\
      --stage2-model ./artifacts/eaf/two_stage/gru/stage2/stage2.pt \\
      --outdir       ./artifacts/eaf/two_stage/gru/predictions

Available models:
  Neural:     gru, lstm, tcn, mlp_mean, mlp_max, mlp_concat
  Tree-based: xgboost, lightgbm, random_forest
"""
from __future__ import annotations

import argparse
import json
import sys
from collections import Counter
from dataclasses import asdict, dataclass
from pathlib import Path
from typing import Any, Dict, List, Optional, Tuple

import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F
from torch.optim.lr_scheduler import CosineAnnealingLR
from torch.utils.data import DataLoader, TensorDataset

# ---------------------------------------------------------------------------
# Constants
# ---------------------------------------------------------------------------

NEURAL_MODELS = frozenset({"gru", "lstm", "tcn", "mlp_mean", "mlp_max", "mlp_concat"})
TREE_MODELS   = frozenset({"xgboost", "lightgbm", "random_forest"})
ALL_MODELS    = NEURAL_MODELS | TREE_MODELS
AREA_NAMES    = ["unknown", "downtown", "freeway", "tunnel"]


# ---------------------------------------------------------------------------
# Configuration
# ---------------------------------------------------------------------------

@dataclass
class MultiModelConfig:
    """Shared configuration for all multi-model two-stage pipelines."""
    model_type: str        = "gru"
    window_sec: float      = 5.0
    stride_sec: float      = 1.0
    sample_hz: float       = 3.0
    d_model: int           = 128
    num_layers: int        = 2
    dim_ff: int            = 256
    dropout: float         = 0.1
    kernel_size: int       = 3       # TCN kernel size
    epochs: int            = 30
    lr: float              = 1e-4
    batch_size: int        = 64
    focal_gamma: float     = 2.0
    focal_alpha: float     = 0.75
    event_ratio: float     = 0.7
    n_goal_classes: int    = 0
    n_stimuli_classes: int = 0
    input_dim: int         = 0
    window_len: int        = 0       # auto-computed in __post_init__
    stride_len: int        = 0       # auto-computed in __post_init__
    device: str            = ""

    def __post_init__(self):
        self.window_len = int(self.window_sec * self.sample_hz)
        self.stride_len = max(1, int(self.stride_sec * self.sample_hz))
        if not self.device:
            self.device = "cuda" if torch.cuda.is_available() else "cpu"


# ---------------------------------------------------------------------------
# EAF utilities  (self-contained: not imported from two_stage_transformer)
# ---------------------------------------------------------------------------

def normalize_session_id(eaf_stem: str) -> str:
    """Convert '2017-02-27-10-17-27' -> '201702271017'."""
    return eaf_stem.replace("-", "")[:12]


def load_vocab(vocab_path: Path) -> Tuple[List[str], Dict[str, str], Dict[str, int]]:
    """Return (labels_list, label_map, vocab_dict) from a vocab JSON."""
    with open(vocab_path, encoding="utf-8") as f:
        data = json.load(f)
    vocab  = data["vocab"]
    labels = [""] * len(vocab)
    for name, idx in vocab.items():
        labels[idx] = name
    return labels, data.get("label_map", {}), vocab


def map_annotations_to_timeline(
    annotations: List[dict],
    T: int,
    sample_hz: float,
    label_map: Dict[str, str],
    vocab: Dict[str, int],
) -> np.ndarray:
    """Map EAF tier annotations to an integer label array of length T."""
    labels   = np.zeros(T, dtype=np.int64)
    ms_per_t = 1000.0 / sample_hz
    for ann in annotations:
        raw    = ann["label"].strip()
        mapped = label_map.get(raw)
        if mapped and mapped in vocab:
            idx = vocab[mapped]
        else:
            eng = " ".join(
                p for p in raw.split()
                if p.replace("-", "").replace("_", "").isascii()
            ).strip().lower().replace(" ", "_")
            idx = vocab.get(eng, 0)
        i0 = max(0, min(int(ann["start_ms"] / ms_per_t), T))
        i1 = max(0, min(int(ann["end_ms"]   / ms_per_t), T))
        if i0 < i1:
            labels[i0:i1] = idx
    return labels


def load_and_align_session(
    sensor_npy: Path,
    eaf_json: Path,
    goal_labels, goal_label_map, goal_vocab,
    stimuli_labels, stimuli_label_map, stimuli_vocab,
    sample_hz: float,
) -> Optional[Tuple[np.ndarray, np.ndarray, np.ndarray]]:
    """Return (sensors, target_goal, target_stimuli) or None."""
    sensors = np.load(sensor_npy).astype(np.float32)
    if sensors.ndim != 2:
        return None
    T = sensors.shape[0]

    with open(eaf_json, encoding="utf-8") as f:
        eaf_data = json.load(f)
    tiers = eaf_data.get("tiers_grouped", {})

    goal_key = stimuli_key = None
    for k in tiers:
        tl = k.lower()
        if "goal" in tl:
            goal_key = k
        elif "stimuli" in tl or "stimulus" in tl:
            stimuli_key = k

    if not goal_key or not stimuli_key:
        print(f"  [SKIP] Missing Goal/Stimuli tiers in {eaf_json.name}")
        return None

    tg = map_annotations_to_timeline(tiers[goal_key],    T, sample_hz, goal_label_map,    goal_vocab)
    ts = map_annotations_to_timeline(tiers[stimuli_key], T, sample_hz, stimuli_label_map, stimuli_vocab)
    return sensors, tg, ts


# ---------------------------------------------------------------------------
# Windowing & balancing
# ---------------------------------------------------------------------------

def create_windows(
    sensors: np.ndarray,
    goal: np.ndarray,
    stimuli: np.ndarray,
    window_len: int,
    stride_len: int,
    horizon_steps: int = 0,
    max_horizon: int = 0,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Sliding window extraction → (X, event_flags, goal_cls, stimuli_cls).

    horizon_steps=0 (default): label = majority non-zero class inside [start:end].
    horizon_steps>0: point label at goal[end + horizon_steps] (predict ahead),
        following the same convention as make_windows() in maneuver_transformer.py.
    max_horizon: safety margin — loop stops at T - window_len - max_horizon so that
        windows at every horizon up to max_horizon have a valid future label.
        When max_horizon=0 the original loop bound (T - window_len + 1) is used.
    """
    T = sensors.shape[0]
    X_list, ev_list, g_list, s_list = [], [], [], []

    loop_bound = (T - window_len - max_horizon) if max_horizon > 0 else (T - window_len + 1)

    for start in range(0, loop_bound, stride_len):
        end   = start + window_len
        if horizon_steps == 0:
            g_win = goal[start:end]
            s_win = stimuli[start:end]
            g_nz  = g_win[g_win != 0]
            s_nz  = s_win[s_win != 0]
            event_flag = 1 if (len(g_nz) > 0 or len(s_nz) > 0) else 0
            goal_cls   = int(Counter(g_nz.tolist()).most_common(1)[0][0]) if len(g_nz) > 0 else 0
            stim_cls   = int(Counter(s_nz.tolist()).most_common(1)[0][0]) if len(s_nz) > 0 else 0
        else:
            goal_cls   = int(goal[end + horizon_steps])
            stim_cls   = int(stimuli[end + horizon_steps])
            event_flag = 1 if (goal_cls != 0 or stim_cls != 0) else 0
        X_list.append(sensors[start:end])
        ev_list.append(event_flag)
        g_list.append(goal_cls)
        s_list.append(stim_cls)

    if not X_list:
        return (
            np.empty((0, window_len, sensors.shape[1]), dtype=np.float32),
            np.empty(0, dtype=np.int64),
            np.empty(0, dtype=np.int64),
            np.empty(0, dtype=np.int64),
        )
    return (
        np.array(X_list,  dtype=np.float32),
        np.array(ev_list, dtype=np.int64),
        np.array(g_list,  dtype=np.int64),
        np.array(s_list,  dtype=np.int64),
    )


def balance_windows(
    X: np.ndarray,
    event: np.ndarray,
    goal: np.ndarray,
    stimuli: np.ndarray,
    event_ratio: float = 0.7,
    rng: Optional[np.random.Generator] = None,
    return_indices: bool = False,
) -> Tuple:
    """Undersample no-event windows to reach target event_ratio.

    If return_indices=True, also returns the kept indices array as the last element.
    """
    if rng is None:
        rng = np.random.default_rng(42)
    ev_idx  = np.where(event == 1)[0]
    nev_idx = np.where(event == 0)[0]
    n_ev    = len(ev_idx)
    if n_ev == 0:
        keep = np.arange(len(event))
        if return_indices:
            return X, event, goal, stimuli, keep
        return X, event, goal, stimuli
    n_nev_keep  = max(1, min(int(n_ev * (1 - event_ratio) / event_ratio), len(nev_idx)))
    nev_sampled = rng.choice(nev_idx, size=n_nev_keep, replace=False)
    keep        = np.sort(np.concatenate([ev_idx, nev_sampled]))
    if return_indices:
        return X[keep], event[keep], goal[keep], stimuli[keep], keep
    return X[keep], event[keep], goal[keep], stimuli[keep]


# ---------------------------------------------------------------------------
# Metrics
# ---------------------------------------------------------------------------

def compute_class_weights(labels: np.ndarray, n_classes: int) -> torch.Tensor:
    counts = np.bincount(labels, minlength=n_classes).astype(np.float32)
    counts = np.maximum(counts, 1.0)
    w = 1.0 / counts
    w /= w.sum()
    w *= n_classes
    return torch.from_numpy(w)


def compute_metrics(
    preds: np.ndarray,
    targets: np.ndarray,
    n_classes: int,
    label_names: Optional[List[str]] = None,
) -> Dict[str, Any]:
    metrics: Dict[str, Any] = {"accuracy": float((preds == targets).mean())}
    per_class: Dict[str, Any] = {}
    f1s: List[float] = []
    for c in range(n_classes):
        tp   = int(((preds == c) & (targets == c)).sum())
        fp   = int(((preds == c) & (targets != c)).sum())
        fn   = int(((preds != c) & (targets == c)).sum())
        prec = tp / (tp + fp) if (tp + fp) > 0 else 0.0
        rec  = tp / (tp + fn) if (tp + fn) > 0 else 0.0
        f1   = 2 * prec * rec / (prec + rec) if (prec + rec) > 0 else 0.0
        name = label_names[c] if label_names and c < len(label_names) else f"class_{c}"
        per_class[name] = {
            "precision": round(prec, 4),
            "recall":    round(rec, 4),
            "f1":        round(f1, 4),
            "support":   int((targets == c).sum()),
        }
        if (targets == c).sum() > 0:
            f1s.append(f1)
    supports = np.array([(targets == c).sum() for c in range(n_classes)], dtype=np.float64)
    total_sup = supports.sum()
    f1_arr    = np.array([per_class[label_names[c] if label_names and c < len(label_names) else f"class_{c}"]["f1"]
                          for c in range(n_classes)], dtype=np.float64)
    weighted_f1 = float(np.dot(f1_arr, supports) / total_sup) if total_sup > 0 else 0.0
    metrics["macro_f1"]    = round(float(np.mean(f1s)) if f1s else 0.0, 4)
    metrics["weighted_f1"] = round(weighted_f1, 4)
    metrics["per_class"]   = per_class
    return metrics


# ---------------------------------------------------------------------------
# Area-breakdown utilities
# ---------------------------------------------------------------------------

def load_area_vocab(vocab_dir: Path) -> Dict[str, int]:
    p = vocab_dir / "vocab_area.json"
    if not p.exists():
        return {"unknown": 0, "downtown": 1, "freeway": 2, "tunnel": 3}
    with open(p, encoding="utf-8") as f:
        data = json.load(f)
    vocab = dict(data["vocab"])
    if "tunnel" not in vocab:
        vocab["tunnel"] = max(vocab.values()) + 1
    return vocab


def build_area_labels_for_test(
    sensor_dir: Path,
    eaf_parsed_dir: Path,
    vocab_dir: Path,
    test_day: str,
    sample_hz: float,
    window_len: int,
    stride_len: int,
) -> np.ndarray:
    area_vocab     = load_area_vocab(vocab_dir)
    area_label_map: Dict[str, str] = {}
    p = vocab_dir / "vocab_area.json"
    if p.exists():
        with open(p, encoding="utf-8") as f:
            area_label_map = json.load(f).get("label_map", {})

    eaf_map: Dict[str, Path] = {}
    for ef in sorted(eaf_parsed_dir.glob("*.json")):
        if ef.name == "summary.json":
            continue
        eaf_map[normalize_session_id(ef.stem)] = ef

    all_area: List[int] = []
    for sf in sorted(sensor_dir.glob("*.npy")):
        sid = sf.stem
        if not sid.startswith(test_day) or sid not in eaf_map:
            continue
        sensors = np.load(sf)
        T = sensors.shape[0]
        with open(eaf_map[sid], encoding="utf-8") as f:
            eaf_data = json.load(f)
        tiers = eaf_data.get("tiers_grouped", {})
        has_goal    = any("goal"    in k.lower() for k in tiers)
        has_stimuli = any("stimuli" in k.lower() or "stimulus" in k.lower() for k in tiers)
        if not has_goal or not has_stimuli:
            continue
        area_key      = next((k for k in tiers if "area" in k.lower()), None)
        area_timeline = np.zeros(T, dtype=np.int64)
        if area_key:
            area_timeline = map_annotations_to_timeline(
                tiers[area_key], T, sample_hz, area_label_map, area_vocab
            )
        for start in range(0, T - window_len + 1, stride_len):
            a_win = area_timeline[start:start + window_len]
            nz    = a_win[a_win != 0]
            all_area.append(int(Counter(nz.tolist()).most_common(1)[0][0]) if len(nz) > 0 else 0)
    return np.array(all_area, dtype=np.int64) if all_area else np.array([], dtype=np.int64)


# ---------------------------------------------------------------------------
# Neural: shared components
# ---------------------------------------------------------------------------

class _FocalLoss(nn.Module):
    """Focal Loss for imbalanced binary classification (Stage 1)."""
    def __init__(self, gamma: float = 2.0, alpha: Optional[float] = None):
        super().__init__()
        self.gamma = gamma
        self.alpha = alpha

    def forward(self, logits: torch.Tensor, targets: torch.Tensor) -> torch.Tensor:
        ce    = F.cross_entropy(logits, targets, reduction="none")
        pt    = torch.exp(-ce)
        focal = (1 - pt) ** self.gamma * ce
        if self.alpha is not None:
            alpha_t = torch.where(targets == 1, self.alpha, 1 - self.alpha)
            focal   = alpha_t * focal
        return focal.mean()


# ---------------------------------------------------------------------------
# Neural: GRU / LSTM
# ---------------------------------------------------------------------------

class EventRNN(nn.Module):
    """Stage 1 binary event detector using GRU or LSTM."""
    def __init__(self, input_dim: int, cfg: MultiModelConfig):
        super().__init__()
        rnn_cls  = nn.GRU if cfg.model_type == "gru" else nn.LSTM
        self.rnn = rnn_cls(
            input_dim, cfg.d_model, cfg.num_layers,
            batch_first=True,
            dropout=cfg.dropout if cfg.num_layers > 1 else 0.0,
        )
        self.head = nn.Sequential(
            nn.LayerNorm(cfg.d_model),
            nn.Dropout(cfg.dropout),
            nn.Linear(cfg.d_model, 2),
        )

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        _, h   = self.rnn(x)
        h_last = h[-1] if isinstance(h, torch.Tensor) else h[0][-1]
        return self.head(h_last)


class ClassificationRNN(nn.Module):
    """Stage 2 Goal + Stimuli classifier using GRU or LSTM."""
    def __init__(self, input_dim: int, cfg: MultiModelConfig):
        super().__init__()
        rnn_cls  = nn.GRU if cfg.model_type == "gru" else nn.LSTM
        self.rnn = rnn_cls(
            input_dim, cfg.d_model, cfg.num_layers,
            batch_first=True,
            dropout=cfg.dropout if cfg.num_layers > 1 else 0.0,
        )
        self.norm         = nn.LayerNorm(cfg.d_model)
        self.goal_head    = nn.Linear(cfg.d_model, cfg.n_goal_classes)
        self.stimuli_head = nn.Linear(cfg.d_model, cfg.n_stimuli_classes)

    def forward(self, x: torch.Tensor) -> Tuple[torch.Tensor, torch.Tensor]:
        _, h   = self.rnn(x)
        h_last = h[-1] if isinstance(h, torch.Tensor) else h[0][-1]
        h_last = self.norm(h_last)
        return self.goal_head(h_last), self.stimuli_head(h_last)


# ---------------------------------------------------------------------------
# Neural: TCN
# ---------------------------------------------------------------------------

class _TCNBlock(nn.Module):
    """Dilated causal residual block."""
    def __init__(self, n_in: int, n_out: int, kernel_size: int, dilation: int, dropout: float):
        super().__init__()
        pad        = (kernel_size - 1) * dilation
        self.conv1 = nn.Conv1d(n_in,  n_out, kernel_size, padding=pad, dilation=dilation)
        self.conv2 = nn.Conv1d(n_out, n_out, kernel_size, padding=pad, dilation=dilation)
        self.norm1 = nn.BatchNorm1d(n_out)
        self.norm2 = nn.BatchNorm1d(n_out)
        self.drop  = nn.Dropout(dropout)
        self.down  = nn.Conv1d(n_in, n_out, 1) if n_in != n_out else None

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        T   = x.size(2)
        out = F.gelu(self.norm1(self.conv1(x)[..., :T]))
        out = self.drop(out)
        out = F.gelu(self.norm2(self.conv2(out)[..., :T]))
        out = self.drop(out)
        res = x if self.down is None else self.down(x)
        return F.gelu(out + res)


def _build_tcn(input_dim: int, cfg: MultiModelConfig) -> nn.Sequential:
    layers: List[nn.Module] = []
    in_c = input_dim
    for i in range(cfg.num_layers):
        layers.append(_TCNBlock(in_c, cfg.d_model, cfg.kernel_size, dilation=2 ** i, dropout=cfg.dropout))
        in_c = cfg.d_model
    return nn.Sequential(*layers)


class EventTCN(nn.Module):
    """Stage 1 binary event detector using TCN."""
    def __init__(self, input_dim: int, cfg: MultiModelConfig):
        super().__init__()
        self.tcn  = _build_tcn(input_dim, cfg)
        self.head = nn.Sequential(
            nn.LayerNorm(cfg.d_model),
            nn.Dropout(cfg.dropout),
            nn.Linear(cfg.d_model, 2),
        )

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        h = self.tcn(x.transpose(1, 2)).mean(dim=2)   # (B, d_model)
        return self.head(h)


class ClassificationTCN(nn.Module):
    """Stage 2 Goal + Stimuli classifier using TCN."""
    def __init__(self, input_dim: int, cfg: MultiModelConfig):
        super().__init__()
        self.tcn          = _build_tcn(input_dim, cfg)
        self.norm         = nn.LayerNorm(cfg.d_model)
        self.goal_head    = nn.Linear(cfg.d_model, cfg.n_goal_classes)
        self.stimuli_head = nn.Linear(cfg.d_model, cfg.n_stimuli_classes)

    def forward(self, x: torch.Tensor) -> Tuple[torch.Tensor, torch.Tensor]:
        h = self.norm(self.tcn(x.transpose(1, 2)).mean(dim=2))
        return self.goal_head(h), self.stimuli_head(h)


# ---------------------------------------------------------------------------
# Neural: MLP with pooling
# ---------------------------------------------------------------------------

def _pool(x: torch.Tensor, pooling: str) -> torch.Tensor:
    """(B, T, D) -> (B, feat_dim)."""
    if pooling == "mean":
        return x.mean(dim=1)
    elif pooling == "max":
        return x.max(dim=1)[0]
    else:   # concat: mean + max + first + last  ->  4*D
        return torch.cat([x.mean(1), x.max(1)[0], x[:, 0], x[:, -1]], dim=-1)


def _pool_dim(input_dim: int, pooling: str) -> int:
    return input_dim * 4 if pooling == "concat" else input_dim


class EventMLP(nn.Module):
    """Stage 1 binary event detector using MLP with pooling."""
    def __init__(self, input_dim: int, cfg: MultiModelConfig, pooling: str):
        super().__init__()
        self.pooling = pooling
        in_d         = _pool_dim(input_dim, pooling)
        self.mlp  = nn.Sequential(
            nn.Linear(in_d, cfg.d_model),      nn.GELU(), nn.Dropout(cfg.dropout),
            nn.Linear(cfg.d_model, cfg.d_model // 2), nn.GELU(), nn.Dropout(cfg.dropout),
        )
        self.head = nn.Linear(cfg.d_model // 2, 2)

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        return self.head(self.mlp(_pool(x, self.pooling)))


class ClassificationMLP(nn.Module):
    """Stage 2 Goal + Stimuli classifier using MLP with pooling."""
    def __init__(self, input_dim: int, cfg: MultiModelConfig, pooling: str):
        super().__init__()
        self.pooling = pooling
        in_d         = _pool_dim(input_dim, pooling)
        self.mlp  = nn.Sequential(
            nn.Linear(in_d, cfg.d_model),      nn.GELU(), nn.Dropout(cfg.dropout),
            nn.Linear(cfg.d_model, cfg.d_model // 2), nn.GELU(),
        )
        self.goal_head    = nn.Linear(cfg.d_model // 2, cfg.n_goal_classes)
        self.stimuli_head = nn.Linear(cfg.d_model // 2, cfg.n_stimuli_classes)

    def forward(self, x: torch.Tensor) -> Tuple[torch.Tensor, torch.Tensor]:
        h = self.mlp(_pool(x, self.pooling))
        return self.goal_head(h), self.stimuli_head(h)


# ---------------------------------------------------------------------------
# Neural model factory
# ---------------------------------------------------------------------------

def _make_stage1_neural(input_dim: int, cfg: MultiModelConfig) -> nn.Module:
    if cfg.model_type in ("gru", "lstm"):
        return EventRNN(input_dim, cfg)
    elif cfg.model_type == "tcn":
        return EventTCN(input_dim, cfg)
    else:
        return EventMLP(input_dim, cfg, pooling=cfg.model_type.replace("mlp_", ""))


def _make_stage2_neural(input_dim: int, cfg: MultiModelConfig) -> nn.Module:
    if cfg.model_type in ("gru", "lstm"):
        return ClassificationRNN(input_dim, cfg)
    elif cfg.model_type == "tcn":
        return ClassificationTCN(input_dim, cfg)
    else:
        return ClassificationMLP(input_dim, cfg, pooling=cfg.model_type.replace("mlp_", ""))


# ---------------------------------------------------------------------------
# Tree-based: feature extraction
# ---------------------------------------------------------------------------

def _window_stats(W: np.ndarray) -> np.ndarray:
    """(T, D) -> (6*D,)  [mean, std, min, max, delta, n_transitions].

    n_transitions counts how many times each feature changes value between
    consecutive timesteps. Especially informative for binary YOLO features
    (e.g. tl_red, vehicle_ahead) where it captures detection activity.
    """
    transitions = (np.diff(W, axis=0) != 0).sum(axis=0).astype(np.float32)
    return np.concatenate([W.mean(0), W.std(0), W.min(0), W.max(0), W[-1] - W[0], transitions])


def _flat_features(X_windows: np.ndarray) -> np.ndarray:
    """(N, T, D) -> (N, 6*D) window statistics."""
    return np.stack([_window_stats(w) for w in X_windows]).astype(np.float32)


def _as_df(X: np.ndarray):
    """Wrap in DataFrame with named columns to avoid sklearn feature-name warnings."""
    import pandas as pd
    return pd.DataFrame(X, columns=[f"f{i}" for i in range(X.shape[1])])


# ---------------------------------------------------------------------------
# Tree-based: model factories
# ---------------------------------------------------------------------------

def _make_tree_binary(model_type: str):
    """Binary classifier for Stage 1 event detection."""
    if model_type == "xgboost":
        try:
            import xgboost as xgb
        except ImportError:
            raise RuntimeError("XGBoost not installed. pip install xgboost")
        return xgb.XGBClassifier(
            objective="binary:logistic", n_estimators=500, max_depth=6,
            learning_rate=0.05, subsample=0.7, colsample_bytree=0.6,
            reg_lambda=2.0, reg_alpha=0.1, min_child_weight=5,
            n_jobs=-1, random_state=42, eval_metric="logloss",
        )
    elif model_type == "lightgbm":
        try:
            import lightgbm as lgb
        except ImportError:
            raise RuntimeError("LightGBM not installed. pip install lightgbm")
        return lgb.LGBMClassifier(
            objective="binary", n_estimators=500, max_depth=5,
            learning_rate=0.05, subsample=0.7, colsample_bytree=0.6,
            reg_lambda=5.0, reg_alpha=0.5, min_child_samples=50,
            n_jobs=-1, random_state=42, verbose=-1,
        )
    elif model_type == "random_forest":
        from sklearn.ensemble import RandomForestClassifier
        return RandomForestClassifier(
            n_estimators=200, max_depth=6, min_samples_split=20,
            min_samples_leaf=50, n_jobs=-1, random_state=42,
        )
    else:
        raise ValueError(f"Unknown tree model: {model_type}")


def _make_tree_multiclass(model_type: str, n_classes: int):
    """Multi-class classifier for Stage 2 Goal / Stimuli."""
    if model_type == "xgboost":
        import xgboost as xgb
        return xgb.XGBClassifier(
            objective="multi:softmax", num_class=n_classes,
            n_estimators=500, max_depth=6, learning_rate=0.05,
            subsample=0.7, colsample_bytree=0.6, reg_lambda=2.0, reg_alpha=0.1,
            min_child_weight=5, n_jobs=-1, random_state=42, eval_metric="mlogloss",
        )
    elif model_type == "lightgbm":
        import lightgbm as lgb
        return lgb.LGBMClassifier(
            objective="multiclass", num_class=n_classes,
            n_estimators=500, max_depth=5, learning_rate=0.05,
            subsample=0.7, colsample_bytree=0.6, reg_lambda=5.0, reg_alpha=0.5,
            min_child_samples=50, n_jobs=-1, random_state=42, verbose=-1,
        )
    elif model_type == "random_forest":
        from sklearn.ensemble import RandomForestClassifier
        return RandomForestClassifier(
            n_estimators=200, max_depth=6, min_samples_split=20,
            min_samples_leaf=50, n_jobs=-1, random_state=42,
        )
    else:
        raise ValueError(f"Unknown tree model: {model_type}")


# ---------------------------------------------------------------------------
# Neural training: Stage 1
# ---------------------------------------------------------------------------

def _train_neural_s1(
    X_train: np.ndarray, ev_train: np.ndarray,
    X_val:   np.ndarray, ev_val:   np.ndarray,
    cfg: MultiModelConfig, outdir: Path,
) -> float:
    device    = torch.device(cfg.device)
    model     = _make_stage1_neural(cfg.input_dim, cfg).to(device)
    optimizer = torch.optim.AdamW(model.parameters(), lr=cfg.lr, weight_decay=1e-4)
    scheduler = CosineAnnealingLR(optimizer, T_max=cfg.epochs)
    criterion = _FocalLoss(gamma=cfg.focal_gamma, alpha=cfg.focal_alpha)

    train_dl = DataLoader(
        TensorDataset(torch.from_numpy(X_train), torch.from_numpy(ev_train)),
        batch_size=cfg.batch_size, shuffle=True,
    )
    val_dl = DataLoader(
        TensorDataset(torch.from_numpy(X_val), torch.from_numpy(ev_val)),
        batch_size=cfg.batch_size,
    )

    best_f1, best_state = 0.0, None
    final_preds = final_targets = np.array([])

    for epoch in range(1, cfg.epochs + 1):
        model.train()
        total_loss, n_b = 0.0, 0
        for xb, yb in train_dl:
            xb, yb = xb.to(device), yb.to(device)
            loss   = criterion(model(xb), yb)
            optimizer.zero_grad()
            loss.backward()
            nn.utils.clip_grad_norm_(model.parameters(), 1.0)
            optimizer.step()
            total_loss += loss.item()
            n_b += 1
        scheduler.step()

        model.eval()
        all_p, all_t = [], []
        with torch.no_grad():
            for xb, yb in val_dl:
                all_p.append(model(xb.to(device)).argmax(1).cpu().numpy())
                all_t.append(yb.numpy())
        final_preds   = np.concatenate(all_p)
        final_targets = np.concatenate(all_t)
        m = compute_metrics(final_preds, final_targets, 2, ["no_event", "event"])
        print(f"  Epoch {epoch:3d}/{cfg.epochs} | Loss: {total_loss/max(n_b,1):.4f} "
              f"| Acc: {m['accuracy']:.4f} | F1: {m['macro_f1']:.4f}")
        if m["macro_f1"] > best_f1:
            best_f1    = m["macro_f1"]
            best_state = {k: v.cpu().clone() for k, v in model.state_dict().items()}

    if best_state:
        model.load_state_dict(best_state)
    torch.save({"model_state": model.state_dict(), "config": asdict(cfg), "best_val_f1": best_f1},
               outdir / "stage1.pt")
    final_m = compute_metrics(final_preds, final_targets, 2, ["no_event", "event"])
    with open(outdir / "metrics_stage1.json", "w") as f:
        json.dump(final_m, f, indent=2)
    print(f"\n  Best val F1: {best_f1:.4f}")
    return best_f1


# ---------------------------------------------------------------------------
# Neural training: Stage 2
# ---------------------------------------------------------------------------

def _train_neural_s2(
    X_train: np.ndarray, ev_train: np.ndarray, g_train: np.ndarray, s_train: np.ndarray,
    X_val:   np.ndarray, ev_val:   np.ndarray, g_val:   np.ndarray, s_val:   np.ndarray,
    cfg: MultiModelConfig, outdir: Path,
    goal_labels: List[str], stimuli_labels: List[str],
) -> float:
    # Filter to event windows only
    X_tr_ev = X_train[ev_train == 1]; g_tr = g_train[ev_train == 1]; s_tr = s_train[ev_train == 1]
    X_va_ev = X_val[ev_val   == 1]; g_va = g_val[ev_val   == 1]; s_va = s_val[ev_val   == 1]
    print(f"  Train event windows: {len(X_tr_ev)} / {len(X_train)}")
    print(f"  Val   event windows: {len(X_va_ev)} / {len(X_val)}")
    if len(X_tr_ev) == 0:
        print("[ERROR] No event windows in training set!")
        sys.exit(1)

    gw     = compute_class_weights(g_tr, cfg.n_goal_classes)
    sw     = compute_class_weights(s_tr, cfg.n_stimuli_classes)
    device = torch.device(cfg.device)
    model  = _make_stage2_neural(cfg.input_dim, cfg).to(device)
    optimizer = torch.optim.AdamW(model.parameters(), lr=cfg.lr, weight_decay=1e-4)
    scheduler = CosineAnnealingLR(optimizer, T_max=cfg.epochs)
    g_crit = nn.CrossEntropyLoss(weight=gw.to(device), reduction="none")
    s_crit = nn.CrossEntropyLoss(weight=sw.to(device), reduction="none")

    train_dl = DataLoader(
        TensorDataset(torch.from_numpy(X_tr_ev), torch.from_numpy(g_tr), torch.from_numpy(s_tr)),
        batch_size=cfg.batch_size, shuffle=True,
    )
    val_dl = DataLoader(
        TensorDataset(torch.from_numpy(X_va_ev), torch.from_numpy(g_va), torch.from_numpy(s_va)),
        batch_size=cfg.batch_size,
    )

    best_f1, best_state = 0.0, None
    gp_last = sp_last = gt_last = st_last = np.array([])

    for epoch in range(1, cfg.epochs + 1):
        model.train()
        total_loss, n_b = 0.0, 0
        for xb, gb, sb in train_dl:
            xb, gb, sb = xb.to(device), gb.to(device), sb.to(device)
            gl, sl     = model(xb)
            gl_raw     = g_crit(gl, gb)
            sl_raw     = s_crit(sl, sb)
            gm = gb != 0; sm = sb != 0
            g_loss = gl_raw[gm].mean()   if gm.any()   else torch.tensor(0., device=device)
            s_loss = sl_raw[sm].mean()   if sm.any()   else torch.tensor(0., device=device)
            g_bg   = gl_raw[~gm].mean()  if (~gm).any() else torch.tensor(0., device=device)
            s_bg   = sl_raw[~sm].mean()  if (~sm).any() else torch.tensor(0., device=device)
            loss   = g_loss + s_loss + 0.1 * (g_bg + s_bg)
            optimizer.zero_grad()
            loss.backward()
            nn.utils.clip_grad_norm_(model.parameters(), 1.0)
            optimizer.step()
            total_loss += loss.item(); n_b += 1
        scheduler.step()

        model.eval()
        gp, sp, gt, st = [], [], [], []
        with torch.no_grad():
            for xb, gb, sb in val_dl:
                gl, sl = model(xb.to(device))
                gp.append(gl.argmax(1).cpu().numpy()); gt.append(gb.numpy())
                sp.append(sl.argmax(1).cpu().numpy()); st.append(sb.numpy())
        gp_last = np.concatenate(gp) if gp else np.array([])
        sp_last = np.concatenate(sp) if sp else np.array([])
        gt_last = np.concatenate(gt) if gt else np.array([])
        st_last = np.concatenate(st) if st else np.array([])

        gm_ = compute_metrics(gp_last, gt_last, cfg.n_goal_classes, goal_labels) if len(gt_last) > 0 else {"macro_f1": 0.0}
        sm_ = compute_metrics(sp_last, st_last, cfg.n_stimuli_classes, stimuli_labels) if len(st_last) > 0 else {"macro_f1": 0.0}
        combined = (gm_["macro_f1"] + sm_["macro_f1"]) / 2
        print(f"  Epoch {epoch:3d}/{cfg.epochs} | Loss: {total_loss/max(n_b,1):.4f} "
              f"| Goal-F1: {gm_['macro_f1']:.4f} | Stim-F1: {sm_['macro_f1']:.4f} | Avg: {combined:.4f}")
        if combined > best_f1:
            best_f1    = combined
            best_state = {k: v.cpu().clone() for k, v in model.state_dict().items()}

    if best_state:
        model.load_state_dict(best_state)
    torch.save({"model_state": model.state_dict(), "config": asdict(cfg), "best_val_f1": best_f1},
               outdir / "stage2.pt")
    final = {
        "goal":    compute_metrics(gp_last, gt_last, cfg.n_goal_classes, goal_labels) if len(gt_last) > 0 else {},
        "stimuli": compute_metrics(sp_last, st_last, cfg.n_stimuli_classes, stimuli_labels) if len(st_last) > 0 else {},
        "combined_f1": best_f1,
    }
    with open(outdir / "metrics_stage2.json", "w") as f:
        json.dump(final, f, indent=2)
    print(f"\n  Best combined F1: {best_f1:.4f}")
    return best_f1


# ---------------------------------------------------------------------------
# Tree training: Stage 1
# ---------------------------------------------------------------------------

def _train_tree_s1(
    X_train: np.ndarray, ev_train: np.ndarray,
    X_val:   np.ndarray, ev_val:   np.ndarray,
    cfg: MultiModelConfig, outdir: Path,
) -> float:
    import joblib
    print("  Building window stats features (train)...")
    Xf_tr = _as_df(_flat_features(X_train))
    Xf_va = _as_df(_flat_features(X_val))
    clf   = _make_tree_binary(cfg.model_type)
    clf.fit(Xf_tr, ev_train)
    preds = clf.predict(Xf_va).astype(np.int64)
    m     = compute_metrics(preds, ev_val, 2, ["no_event", "event"])
    print(f"  Val: Acc={m['accuracy']:.4f}, Macro-F1={m['macro_f1']:.4f}")
    joblib.dump({"model": clf, "config": asdict(cfg)}, outdir / "stage1_tree.joblib")
    with open(outdir / "metrics_stage1.json", "w") as f:
        json.dump(m, f, indent=2)
    return m["macro_f1"]


# ---------------------------------------------------------------------------
# Tree training: Stage 2
# ---------------------------------------------------------------------------

def _train_tree_s2(
    X_train: np.ndarray, ev_train: np.ndarray, g_train: np.ndarray, s_train: np.ndarray,
    X_val:   np.ndarray, ev_val:   np.ndarray, g_val:   np.ndarray, s_val:   np.ndarray,
    cfg: MultiModelConfig, outdir: Path,
    goal_labels: List[str], stimuli_labels: List[str],
) -> float:
    import joblib
    X_tr_ev = X_train[ev_train == 1]; g_tr = g_train[ev_train == 1]; s_tr = s_train[ev_train == 1]
    X_va_ev = X_val[ev_val   == 1]; g_va = g_val[ev_val   == 1]; s_va = s_val[ev_val   == 1]
    print(f"  Train event windows: {len(X_tr_ev)} / {len(X_train)}")
    print(f"  Val   event windows: {len(X_va_ev)} / {len(X_val)}")
    if len(X_tr_ev) == 0:
        print("[ERROR] No event windows!"); sys.exit(1)

    from sklearn.preprocessing import LabelEncoder

    print("  Building window stats features...")
    Xf_tr = _as_df(_flat_features(X_tr_ev))
    Xf_va = _as_df(_flat_features(X_va_ev))

    # LabelEncoder ensures consecutive 0..k-1 labels even when some classes
    # are absent from the event windows (XGBoost/sklearn require this).
    le_g = LabelEncoder().fit(g_tr)
    le_s = LabelEncoder().fit(s_tr)

    def _safe_enc(le: LabelEncoder, arr: np.ndarray) -> np.ndarray:
        """Transform labels; map unseen values to the first known class."""
        known = set(le.classes_.tolist())
        return le.transform(
            np.array([x if x in known else le.classes_[0] for x in arr])
        )

    clf_g = _make_tree_multiclass(cfg.model_type, len(le_g.classes_))
    clf_g.fit(Xf_tr, le_g.transform(g_tr))
    g_enc_va = _safe_enc(le_g, g_va) if len(g_va) > 0 else np.array([], dtype=np.int64)
    g_preds_enc = clf_g.predict(Xf_va).astype(np.int64) if len(Xf_va) > 0 else np.array([], dtype=np.int64)
    g_preds = le_g.inverse_transform(g_preds_enc).astype(np.int64) if len(g_preds_enc) > 0 else g_preds_enc
    g_va_orig = le_g.inverse_transform(g_enc_va).astype(np.int64) if len(g_enc_va) > 0 else g_va
    gm = compute_metrics(g_preds, g_va_orig, cfg.n_goal_classes, goal_labels) if len(g_va_orig) > 0 else {"macro_f1": 0.0}
    print(f"  Goal   Val: Acc={gm.get('accuracy',0):.4f}, Macro-F1={gm['macro_f1']:.4f}")

    clf_s = _make_tree_multiclass(cfg.model_type, len(le_s.classes_))
    clf_s.fit(Xf_tr, le_s.transform(s_tr))
    s_enc_va = _safe_enc(le_s, s_va) if len(s_va) > 0 else np.array([], dtype=np.int64)
    s_preds_enc = clf_s.predict(Xf_va).astype(np.int64) if len(Xf_va) > 0 else np.array([], dtype=np.int64)
    s_preds = le_s.inverse_transform(s_preds_enc).astype(np.int64) if len(s_preds_enc) > 0 else s_preds_enc
    s_va_orig = le_s.inverse_transform(s_enc_va).astype(np.int64) if len(s_enc_va) > 0 else s_va
    sm = compute_metrics(s_preds, s_va_orig, cfg.n_stimuli_classes, stimuli_labels) if len(s_va_orig) > 0 else {"macro_f1": 0.0}
    print(f"  Stimuli Val: Acc={sm.get('accuracy',0):.4f}, Macro-F1={sm['macro_f1']:.4f}")

    combined = (gm["macro_f1"] + sm["macro_f1"]) / 2
    print(f"  Combined F1: {combined:.4f}")
    joblib.dump({"model_goal": clf_g, "model_stimuli": clf_s,
                 "le_goal": le_g, "le_stimuli": le_s,
                 "config": asdict(cfg)},
                outdir / "stage2_tree.joblib")
    final = {"goal": gm, "stimuli": sm, "combined_f1": combined}
    with open(outdir / "metrics_stage2.json", "w") as f:
        json.dump(final, f, indent=2)
    return combined


# ---------------------------------------------------------------------------
# Prediction helpers
# ---------------------------------------------------------------------------

def _predict_neural_s1(X_test: np.ndarray, cfg: MultiModelConfig, path: Path) -> np.ndarray:
    device = torch.device(cfg.device)
    ckpt   = torch.load(path, map_location=device, weights_only=False)
    model  = _make_stage1_neural(cfg.input_dim, cfg).to(device)
    model.load_state_dict(ckpt["model_state"])
    model.eval()
    dl     = DataLoader(TensorDataset(torch.from_numpy(X_test)), batch_size=cfg.batch_size)
    preds  = []
    with torch.no_grad():
        for (xb,) in dl:
            preds.append(model(xb.to(device)).argmax(1).cpu().numpy())
    return np.concatenate(preds)


def _predict_neural_s2(
    X_events: np.ndarray, cfg: MultiModelConfig, path: Path
) -> Tuple[np.ndarray, np.ndarray]:
    device = torch.device(cfg.device)
    ckpt   = torch.load(path, map_location=device, weights_only=False)
    model  = _make_stage2_neural(cfg.input_dim, cfg).to(device)
    model.load_state_dict(ckpt["model_state"])
    model.eval()
    dl     = DataLoader(TensorDataset(torch.from_numpy(X_events)), batch_size=cfg.batch_size)
    gp, sp = [], []
    with torch.no_grad():
        for (xb,) in dl:
            gl, sl = model(xb.to(device))
            gp.append(gl.argmax(1).cpu().numpy())
            sp.append(sl.argmax(1).cpu().numpy())
    return np.concatenate(gp), np.concatenate(sp)


def _predict_neural_s1_probs(X_test: np.ndarray, cfg: MultiModelConfig, path: Path) -> np.ndarray:
    """Return P(event) for each window using softmax."""
    device = torch.device(cfg.device)
    ckpt   = torch.load(path, map_location=device, weights_only=False)
    model  = _make_stage1_neural(cfg.input_dim, cfg).to(device)
    model.load_state_dict(ckpt["model_state"])
    model.eval()
    dl     = DataLoader(TensorDataset(torch.from_numpy(X_test)), batch_size=cfg.batch_size)
    probs  = []
    with torch.no_grad():
        for (xb,) in dl:
            p = torch.softmax(model(xb.to(device)), dim=1)[:, 1]
            probs.append(p.cpu().numpy())
    return np.concatenate(probs)


def _predict_tree_s1(X_test: np.ndarray, path: Path) -> np.ndarray:
    import joblib
    ckpt  = joblib.load(path)
    return ckpt["model"].predict(_as_df(_flat_features(X_test))).astype(np.int64)


def _predict_tree_s1_probs(X_test: np.ndarray, path: Path) -> np.ndarray:
    """Return P(event) for each window using predict_proba."""
    import joblib
    ckpt  = joblib.load(path)
    return ckpt["model"].predict_proba(_as_df(_flat_features(X_test)))[:, 1].astype(np.float32)


def _predict_tree_s2(X_events: np.ndarray, path: Path) -> Tuple[np.ndarray, np.ndarray]:
    import joblib
    ckpt  = joblib.load(path)
    Xf    = _as_df(_flat_features(X_events))
    g_enc = ckpt["model_goal"].predict(Xf).astype(np.int64)
    s_enc = ckpt["model_stimuli"].predict(Xf).astype(np.int64)
    le_g  = ckpt.get("le_goal")
    le_s  = ckpt.get("le_stimuli")
    g_pred = le_g.inverse_transform(g_enc).astype(np.int64) if le_g is not None else g_enc
    s_pred = le_s.inverse_transform(s_enc).astype(np.int64) if le_s is not None else s_enc
    return g_pred, s_pred


# ---------------------------------------------------------------------------
# Config loading helper
# ---------------------------------------------------------------------------

def _load_cfg(data_dir: Path, model_type: str, args: argparse.Namespace) -> MultiModelConfig:
    """Load config.json from data_dir and overlay CLI arguments."""
    with open(data_dir / "config.json") as f:
        raw = json.load(f)
    fields = MultiModelConfig.__dataclass_fields__
    filtered = {k: v for k, v in raw.items() if k in fields}
    cfg = MultiModelConfig(**filtered)
    cfg.model_type = model_type
    if hasattr(args, "epochs")     and args.epochs     is not None: cfg.epochs     = args.epochs
    if hasattr(args, "lr")         and args.lr         is not None: cfg.lr         = args.lr
    if hasattr(args, "batch_size") and args.batch_size is not None: cfg.batch_size = args.batch_size
    if hasattr(args, "d_model")    and args.d_model    is not None: cfg.d_model    = args.d_model
    if hasattr(args, "num_layers") and args.num_layers is not None: cfg.num_layers = args.num_layers
    if hasattr(args, "dropout")    and args.dropout    is not None: cfg.dropout    = args.dropout
    # Re-run __post_init__ to refresh computed fields
    cfg.__post_init__()
    return cfg


# ---------------------------------------------------------------------------
# Command: prepare   (identical logic to two_stage_transformer)
# ---------------------------------------------------------------------------

def cmd_prepare(args: argparse.Namespace) -> None:
    sensor_dir = Path(args.sensor_dir)
    eaf_dir    = Path(args.eaf_parsed_dir)
    vocab_dir  = Path(args.vocab_dir)
    outdir     = Path(args.output_dir)
    outdir.mkdir(parents=True, exist_ok=True)

    window_len = int(args.window_sec * args.sample_hz)
    stride_len = max(1, int(args.stride_sec * args.sample_hz))

    print("=" * 70)
    print("TWO-STAGE MULTI-MODEL - Dataset Preparation")
    print("=" * 70)
    print(f"Sensor dir:      {sensor_dir}")
    print(f"EAF parsed dir:  {eaf_dir}")
    print(f"Vocab dir:       {vocab_dir}")
    print(f"Output dir:      {outdir}")
    print(f"Window:          {args.window_sec}s ({window_len} steps)")
    print(f"Stride:          {args.stride_sec}s ({stride_len} steps)")
    print(f"Sample Hz:       {args.sample_hz}")
    print()

    goal_labels, goal_label_map, goal_vocab         = load_vocab(vocab_dir / "vocab_goal.json")
    stimuli_labels, stimuli_label_map, stimuli_vocab = load_vocab(vocab_dir / "vocab_stimuli.json")
    n_goal_classes    = len(goal_labels)
    n_stimuli_classes = len(stimuli_labels)
    print(f"Goal classes:    {n_goal_classes} {goal_labels[:5]}...")
    print(f"Stimuli classes: {n_stimuli_classes} {stimuli_labels[:5]}...")
    print()

    sensor_files = sorted(sensor_dir.glob("*.npy"))
    eaf_files    = [f for f in sorted(eaf_dir.glob("*.json")) if f.name != "summary.json"]
    eaf_map: Dict[str, Path] = {normalize_session_id(ef.stem): ef for ef in eaf_files}
    print(f"Sensor files:    {len(sensor_files)}")
    print(f"EAF files:       {len(eaf_files)}")

    horizons     = sorted(set(getattr(args, 'horizons', None) or [0]))
    max_horizon  = max(horizons)

    all_X, all_days = [], []
    all_labels: Dict[int, Dict[str, list]] = {h: {"ev": [], "g": [], "s": []} for h in horizons}
    matched = 0

    for sf in sensor_files:
        sid = sf.stem
        if sid not in eaf_map:
            print(f"  [SKIP] No EAF for {sid}")
            continue
        result = load_and_align_session(
            sf, eaf_map[sid],
            goal_labels, goal_label_map, goal_vocab,
            stimuli_labels, stimuli_label_map, stimuli_vocab,
            args.sample_hz,
        )
        if result is None:
            continue
        sensors, tg, ts = result
        # h=0: X (shared for all horizons) + h=0 labels
        X_w, ev_w0, g_w0, s_w0 = create_windows(
            sensors, tg, ts, window_len, stride_len,
            horizon_steps=0, max_horizon=max_horizon,
        )
        if X_w.shape[0] == 0:
            continue
        N = X_w.shape[0]
        all_X.append(X_w)
        all_labels[0]["ev"].append(ev_w0)
        all_labels[0]["g"].append(g_w0)
        all_labels[0]["s"].append(s_w0)
        # h>0: point labels only (X is the same)
        for h in horizons:
            if h == 0:
                continue
            _, ev_wh, g_wh, s_wh = create_windows(
                sensors, tg, ts, window_len, stride_len,
                horizon_steps=h, max_horizon=max_horizon,
            )
            all_labels[h]["ev"].append(ev_wh[:N])
            all_labels[h]["g"].append(g_wh[:N])
            all_labels[h]["s"].append(s_wh[:N])
        all_days.append(np.full(N, sid[:8], dtype="U8"))
        matched += 1
        n_ev = int(ev_w0.sum())
        print(f"  [OK] {sid}: {N} windows ({n_ev} event, {N-n_ev} no-event)")

    if matched == 0:
        print("\n[ERROR] No sessions matched."); sys.exit(1)

    X_all    = np.concatenate(all_X)
    days_all = np.concatenate(all_days)
    input_dim = X_all.shape[2]
    labels_all = {h: {k: np.concatenate(v) for k, v in d.items()} for h, d in all_labels.items()}
    ev_all   = labels_all[0]["ev"]   # h=0 event flags for stats/printing

    print(f"\nTotal windows: {X_all.shape[0]}")
    print(f"  Event (h=0): {int(ev_all.sum())} ({100*ev_all.mean():.1f}%)")
    print(f"  No-event:    {int((ev_all==0).sum())} ({100*(1-ev_all.mean()):.1f}%)")
    print(f"  Input dim:   {input_dim}")
    print(f"  Horizons:    {horizons}")

    unique_days = sorted(set(days_all.tolist()))
    print(f"\nDays found: {unique_days}")
    if len(unique_days) < 2:
        print("[WARN] Only 1 day found. Using random 80/20 split.")
        rng   = np.random.default_rng(42)
        idx   = rng.permutation(len(X_all))
        split = int(0.8 * len(X_all))
        train_mask = np.zeros(len(X_all), dtype=bool)
        train_mask[idx[:split]] = True
        test_mask  = ~train_mask
        test_day   = "random"
    else:
        test_day   = unique_days[-1]
        test_mask  = days_all == test_day
        train_mask = ~test_mask

    print(f"Test day: {test_day}")
    print(f"Train: {train_mask.sum()} windows, Test: {test_mask.sum()} windows")

    # Balance using h=0 labels; capture keep indices to apply to all horizons
    X_train_raw = X_all[train_mask]
    ev0_tr_raw  = labels_all[0]["ev"][train_mask]
    g0_tr_raw   = labels_all[0]["g"][train_mask]
    s0_tr_raw   = labels_all[0]["s"][train_mask]
    X_train, ev_train0, g_train0, s_train0, balance_keep = balance_windows(
        X_train_raw, ev0_tr_raw, g0_tr_raw, s0_tr_raw,
        event_ratio=args.event_ratio, return_indices=True,
    )
    print(f"\nAfter balancing train (h=0):")
    print(f"  Total:    {len(ev_train0)}")
    print(f"  Event:    {int(ev_train0.sum())} ({100*ev_train0.mean():.1f}%)")
    print(f"  No-event: {int((ev_train0==0).sum())} ({100*(1-ev_train0.mean()):.1f}%)")

    # Val split (same permutation for all horizons)
    rng   = np.random.default_rng(42)
    n_val = max(1, int(0.1 * len(X_train)))
    idx   = rng.permutation(len(X_train))
    val_i = idx[:n_val]; tr_i = idx[n_val:]

    # Normalize X (same for all horizons)
    X_tr = X_train[tr_i]; X_va = X_train[val_i]
    mean = X_tr.reshape(-1, input_dim).mean(axis=0)
    std  = X_tr.reshape(-1, input_dim).std(axis=0)
    std[std < 1e-8] = 1.0
    np.save(outdir / "X_train.npy",   (X_tr - mean) / std)
    np.save(outdir / "X_val.npy",     (X_va - mean) / std)
    np.save(outdir / "X_test.npy",    (X_all[test_mask] - mean) / std)
    np.save(outdir / "norm_mean.npy", mean)
    np.save(outdir / "norm_std.npy",  std)

    # Save labels for each horizon
    for h in horizons:
        suffix = "" if h == 0 else f"_h{h}"
        lh = labels_all[h]
        # Train raw → balance → val/train split
        ev_tr_raw = lh["ev"][train_mask][balance_keep]
        g_tr_raw  = lh["g"][train_mask][balance_keep]
        s_tr_raw  = lh["s"][train_mask][balance_keep]
        np.save(outdir / f"ev_train{suffix}.npy", ev_tr_raw[tr_i])
        np.save(outdir / f"g_train{suffix}.npy",  g_tr_raw[tr_i])
        np.save(outdir / f"s_train{suffix}.npy",  s_tr_raw[tr_i])
        np.save(outdir / f"ev_val{suffix}.npy",   ev_tr_raw[val_i])
        np.save(outdir / f"g_val{suffix}.npy",    g_tr_raw[val_i])
        np.save(outdir / f"s_val{suffix}.npy",    s_tr_raw[val_i])
        np.save(outdir / f"ev_test{suffix}.npy",  lh["ev"][test_mask])
        np.save(outdir / f"g_test{suffix}.npy",   lh["g"][test_mask])
        np.save(outdir / f"s_test{suffix}.npy",   lh["s"][test_mask])

    # Save config and stats (use h=0 labels for stats)
    ev_train_h0 = labels_all[0]["ev"][train_mask][balance_keep][tr_i]
    ev_val_h0   = labels_all[0]["ev"][train_mask][balance_keep][val_i]
    ev_test_h0  = labels_all[0]["ev"][test_mask]
    cfg_save = {
        "window_sec": args.window_sec, "stride_sec": args.stride_sec,
        "sample_hz":  args.sample_hz,  "event_ratio": args.event_ratio,
        "window_len": window_len,       "stride_len":  stride_len,
        "n_goal_classes": n_goal_classes, "n_stimuli_classes": n_stimuli_classes,
        "input_dim": input_dim,
    }
    with open(outdir / "config.json", "w") as f:
        json.dump(cfg_save, f, indent=2)
    with open(outdir / "horizons_prepared.json", "w") as f:
        json.dump({"horizons": horizons, "max_horizon": max_horizon}, f, indent=2)

    g_all_h0 = labels_all[0]["g"]
    s_all_h0 = labels_all[0]["s"]
    stats = {
        "matched_sessions": matched,
        "total_windows_before_balance": int(X_all.shape[0]),
        "horizons": horizons,
        "train": {"total": int(ev_train_h0.shape[0]), "event": int(ev_train_h0.sum()), "noevent": int((ev_train_h0==0).sum())},
        "val":   {"total": int(ev_val_h0.shape[0]),   "event": int(ev_val_h0.sum()),   "noevent": int((ev_val_h0==0).sum())},
        "test":  {"total": int(ev_test_h0.shape[0]),  "event": int(ev_test_h0.sum()),  "noevent": int((ev_test_h0==0).sum())},
        "test_day": test_day, "input_dim": input_dim,
        "goal_labels":    goal_labels, "stimuli_labels": stimuli_labels,
        "goal_distribution":    {goal_labels[i]: int(c) for i, c in enumerate(np.bincount(g_all_h0, minlength=n_goal_classes))},
        "stimuli_distribution": {stimuli_labels[i]: int(c) for i, c in enumerate(np.bincount(s_all_h0, minlength=n_stimuli_classes))},
        "sensor_dir": str(sensor_dir.resolve()),
        "eaf_parsed_dir": str(eaf_dir.resolve()),
        "vocab_dir": str(vocab_dir.resolve()),
    }
    with open(outdir / "dataset_stats.json", "w") as f:
        json.dump(stats, f, indent=2)

    X_tr_shape = np.load(outdir / "X_train.npy").shape
    X_va_shape = np.load(outdir / "X_val.npy").shape
    X_te_shape = np.load(outdir / "X_test.npy").shape
    print(f"\nSaved to {outdir}/")
    print(f"  X_train: {X_tr_shape}, X_val: {X_va_shape}, X_test: {X_te_shape}")
    print(f"  Label files saved for horizons: {horizons}")
    print("\n[OK] Dataset preparation complete!")


# ---------------------------------------------------------------------------
# Command: train-stage1
# ---------------------------------------------------------------------------

def cmd_train_stage1(args: argparse.Namespace) -> None:
    data_dir = Path(args.data_dir)
    outdir   = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    cfg = _load_cfg(data_dir, args.model, args)

    with open(data_dir / "dataset_stats.json") as f:
        stats = json.load(f)

    print("=" * 70)
    print(f"STAGE 1: Event Detection  [{cfg.model_type.upper()}]")
    print("=" * 70)
    print(f"Model:    {cfg.model_type}")
    if cfg.model_type in NEURAL_MODELS:
        print(f"Device:   {cfg.device}")
        print(f"Epochs:   {cfg.epochs}, LR: {cfg.lr}, Batch: {cfg.batch_size}")
        print(f"d_model:  {cfg.d_model}, num_layers: {cfg.num_layers}, dropout: {cfg.dropout}")
    print()

    # Parse horizon steps: single int or list → always a sorted list
    _hs_raw = getattr(args, "horizon_steps", None)
    if isinstance(_hs_raw, list):
        horizons = sorted(set(int(h) for h in _hs_raw)) if _hs_raw else [0]
    elif _hs_raw is not None:
        horizons = [int(_hs_raw)]
    else:
        horizons = [0]

    with open(outdir / "config.json", "w") as f:
        json.dump(asdict(cfg), f, indent=2)

    # Load X_train ONCE (sensor windows are identical across all horizons)
    X_train_base = np.load(data_dir / "X_train.npy")
    X_val_base   = np.load(data_dir / "X_val.npy")

    # Collect event labels for each horizon
    ev_train_parts, ev_val_parts = [], []
    for h in horizons:
        suffix = "" if h == 0 else f"_h{h}"
        ev_train_parts.append(np.load(data_dir / f"ev_train{suffix}.npy"))
        ev_val_parts.append(np.load(data_dir / f"ev_val{suffix}.npy"))

    if len(horizons) == 1:
        X_train  = X_train_base
        ev_train = ev_train_parts[0]
        X_val    = X_val_base
        ev_val   = ev_val_parts[0]
    else:
        # Augment: same sensor windows, different future-horizon labels
        X_train  = np.concatenate([X_train_base] * len(horizons), axis=0)
        ev_train = np.concatenate(ev_train_parts)
        X_val    = np.concatenate([X_val_base]   * len(horizons), axis=0)
        ev_val   = np.concatenate(ev_val_parts)
        rng = np.random.default_rng(42)
        idx = rng.permutation(len(X_train))
        X_train  = X_train[idx]
        ev_train = ev_train[idx]

    print(f"Horizons: {horizons}")
    print(f"Train: {X_train.shape[0]} windows, Val: {X_val.shape[0]} windows")
    print(f"Train event ratio: {ev_train.mean():.2%}")

    # Optional rebalancing: undersample to reach target event ratio
    balance_ratio = getattr(args, "balance_ratio", None)
    if balance_ratio is not None:
        target = float(balance_ratio)
        ev_idx  = np.where(ev_train == 1)[0]
        nev_idx = np.where(ev_train == 0)[0]
        n_ev  = len(ev_idx)
        n_nev = len(nev_idx)
        n_nev_if_ev_kept = int(n_ev  * (1.0 - target) / max(target, 1e-9))
        n_ev_if_nev_kept = int(n_nev * target          / max(1.0 - target, 1e-9))
        rng = np.random.default_rng(42)
        if n_nev_if_ev_kept <= n_nev:
            ev_sampled  = ev_idx
            nev_sampled = rng.choice(nev_idx, size=n_nev_if_ev_kept, replace=False)
        else:
            nev_sampled = nev_idx
            ev_sampled  = rng.choice(ev_idx, size=min(n_ev, n_ev_if_nev_kept), replace=False)
        all_idx = rng.permutation(np.concatenate([ev_sampled, nev_sampled]))
        X_train  = X_train[all_idx]
        ev_train = ev_train[all_idx]
        print(f"Rebalanced train: {len(X_train)} windows, event ratio: {ev_train.mean():.2%}")

    if cfg.model_type in NEURAL_MODELS:
        _train_neural_s1(X_train, ev_train, X_val, ev_val, cfg, outdir)
    else:
        _train_tree_s1(X_train, ev_train, X_val, ev_val, cfg, outdir)

    print(f"\nSaved to {outdir}/")
    print("[OK] Stage 1 training complete!")


# ---------------------------------------------------------------------------
# Command: train-stage2
# ---------------------------------------------------------------------------

def cmd_train_stage2(args: argparse.Namespace) -> None:
    data_dir = Path(args.data_dir)
    outdir   = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    cfg = _load_cfg(data_dir, args.model, args)

    with open(data_dir / "dataset_stats.json") as f:
        stats = json.load(f)
    goal_labels    = stats.get("goal_labels",    [f"goal_{i}"  for i in range(cfg.n_goal_classes)])
    stimuli_labels = stats.get("stimuli_labels", [f"stim_{i}"  for i in range(cfg.n_stimuli_classes)])

    print("=" * 70)
    print(f"STAGE 2: Goal/Stimuli Classification  [{cfg.model_type.upper()}]")
    print("=" * 70)
    print(f"Model:    {cfg.model_type}")
    if cfg.model_type in NEURAL_MODELS:
        print(f"Device:   {cfg.device}")
        print(f"Epochs:   {cfg.epochs}, LR: {cfg.lr}, Batch: {cfg.batch_size}")
    print()

    # Parse horizon steps
    _hs_raw = getattr(args, "horizon_steps", None)
    if isinstance(_hs_raw, list):
        horizons = sorted(set(int(h) for h in _hs_raw)) if _hs_raw else [0]
    elif _hs_raw is not None:
        horizons = [int(_hs_raw)]
    else:
        horizons = [0]

    with open(outdir / "config.json", "w") as f:
        json.dump(asdict(cfg), f, indent=2)

    print(f"Horizons: {horizons}")

    # Load X_train ONCE
    X_train_base = np.load(data_dir / "X_train.npy")
    X_val_base   = np.load(data_dir / "X_val.npy")

    ev_train_parts, g_train_parts, s_train_parts = [], [], []
    ev_val_parts,   g_val_parts,   s_val_parts   = [], [], []
    for h in horizons:
        suffix = "" if h == 0 else f"_h{h}"
        ev_train_parts.append(np.load(data_dir / f"ev_train{suffix}.npy"))
        g_train_parts.append(np.load(data_dir / f"g_train{suffix}.npy"))
        s_train_parts.append(np.load(data_dir / f"s_train{suffix}.npy"))
        ev_val_parts.append(np.load(data_dir / f"ev_val{suffix}.npy"))
        g_val_parts.append(np.load(data_dir / f"g_val{suffix}.npy"))
        s_val_parts.append(np.load(data_dir / f"s_val{suffix}.npy"))

    if len(horizons) == 1:
        X_train  = X_train_base
        ev_train = ev_train_parts[0]
        g_train  = g_train_parts[0]
        s_train  = s_train_parts[0]
        X_val    = X_val_base
        ev_val   = ev_val_parts[0]
        g_val    = g_val_parts[0]
        s_val    = s_val_parts[0]
    else:
        X_train  = np.concatenate([X_train_base] * len(horizons), axis=0)
        ev_train = np.concatenate(ev_train_parts)
        g_train  = np.concatenate(g_train_parts)
        s_train  = np.concatenate(s_train_parts)
        X_val    = np.concatenate([X_val_base]   * len(horizons), axis=0)
        ev_val   = np.concatenate(ev_val_parts)
        g_val    = np.concatenate(g_val_parts)
        s_val    = np.concatenate(s_val_parts)
        rng = np.random.default_rng(42)
        idx = rng.permutation(len(X_train))
        X_train  = X_train[idx]
        ev_train = ev_train[idx]
        g_train  = g_train[idx]
        s_train  = s_train[idx]

    if cfg.model_type in NEURAL_MODELS:
        _train_neural_s2(
            X_train, ev_train, g_train, s_train,
            X_val, ev_val, g_val, s_val,
            cfg, outdir, goal_labels, stimuli_labels,
        )
    else:
        _train_tree_s2(
            X_train, ev_train, g_train, s_train,
            X_val, ev_val, g_val, s_val,
            cfg, outdir, goal_labels, stimuli_labels,
        )

    print(f"\nSaved to {outdir}/")
    print("[OK] Stage 2 training complete!")


# ---------------------------------------------------------------------------
# Command: predict
# ---------------------------------------------------------------------------

def cmd_predict(args: argparse.Namespace) -> None:
    data_dir = Path(args.data_dir)
    outdir   = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    cfg = _load_cfg(data_dir, args.model, args)

    with open(data_dir / "dataset_stats.json") as f:
        stats = json.load(f)
    goal_labels    = stats.get("goal_labels",    [f"goal_{i}" for i in range(cfg.n_goal_classes)])
    stimuli_labels = stats.get("stimuli_labels", [f"stim_{i}" for i in range(cfg.n_stimuli_classes)])

    stage1_path = Path(args.stage1_model)
    stage2_path = Path(args.stage2_model)
    is_neural   = cfg.model_type in NEURAL_MODELS
    event_threshold = float(getattr(args, "event_threshold", 0.5))

    # --- Multi-horizon mode ---
    # ONE model is loaded; inference runs ONCE; GT labels are swapped per horizon.
    horizons = getattr(args, "horizons", None)
    if horizons:
        horizons = sorted(set(int(h) for h in horizons))
        print("=" * 70)
        print(f"TWO-STAGE MULTI-HORIZON PREDICTION  [{cfg.model_type.upper()}]")
        print("=" * 70)
        print(f"Model S1: {stage1_path}")
        print(f"Model S2: {stage2_path}")
        print(f"Horizons: {horizons}  |  Event threshold: {event_threshold}")
        print()

        # Load X_test ONCE
        X_test = np.load(data_dir / "X_test.npy")

        # Run Stage 1 inference ONCE
        if is_neural:
            ev_probs = _predict_neural_s1_probs(X_test, cfg, stage1_path)
        else:
            ev_probs = _predict_tree_s1_probs(X_test, stage1_path)
        ev_preds = (ev_probs >= event_threshold).astype(np.int64)

        # Run Stage 2 on predicted events ONCE
        event_mask = ev_preds == 1
        n_pred = int(event_mask.sum())
        if n_pred > 0:
            X_ev = X_test[event_mask]
            if is_neural:
                g_preds_ev, s_preds_ev = _predict_neural_s2(X_ev, cfg, stage2_path)
            else:
                g_preds_ev, s_preds_ev = _predict_tree_s2(X_ev, stage2_path)
        else:
            g_preds_ev = s_preds_ev = np.array([], dtype=np.int64)

        # Run Stage 2 on ALL test windows ONCE (for oracle evaluation per horizon)
        if is_neural:
            g_preds_all, s_preds_all = _predict_neural_s2(X_test, cfg, stage2_path)
        else:
            g_preds_all, s_preds_all = _predict_tree_s2(X_test, stage2_path)

        all_h_metrics: Dict[str, Dict] = {}
        header = f"{'Horizon':>8} | {'GT events':>9} | {'S1 F1':>6} | {'Goal F1':>7} | {'Stim F1':>7} | {'G Oracle':>8} | {'S Oracle':>8}"
        print(header)
        print("-" * len(header))

        for h in horizons:
            suffix  = "" if h == 0 else f"_h{h}"
            ev_test = np.load(data_dir / f"ev_test{suffix}.npy")
            g_test  = np.load(data_dir / f"g_test{suffix}.npy")
            s_test  = np.load(data_dir / f"s_test{suffix}.npy")

            ev_metrics = compute_metrics(ev_preds, ev_test, 2, ["no_event", "event"])

            if n_pred > 0:
                g_metrics = compute_metrics(g_preds_ev, g_test[event_mask], cfg.n_goal_classes, goal_labels)
                s_metrics = compute_metrics(s_preds_ev, s_test[event_mask], cfg.n_stimuli_classes, stimuli_labels)
            else:
                g_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}
                s_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}

            gt_mask = ev_test == 1
            if gt_mask.sum() > 0:
                g_oracle = compute_metrics(g_preds_all[gt_mask], g_test[gt_mask], cfg.n_goal_classes, goal_labels)
                s_oracle = compute_metrics(s_preds_all[gt_mask], s_test[gt_mask], cfg.n_stimuli_classes, stimuli_labels)
            else:
                g_oracle = s_oracle = {}

            m = {
                "horizon_steps":               h,
                "model":                       cfg.model_type,
                "event_threshold":             event_threshold,
                "event_detection":             ev_metrics,
                "goal_on_predicted_events":    g_metrics,
                "stimuli_on_predicted_events": s_metrics,
                "goal_oracle":                 g_oracle,
                "stimuli_oracle":              s_oracle,
                "n_test_windows":              len(ev_test),
                "n_predicted_events":          n_pred,
                "n_gt_events":                 int(gt_mask.sum()),
            }
            key = f"h{h}"
            all_h_metrics[key] = m
            s1f1 = ev_metrics["macro_f1"]
            gf1  = g_metrics["macro_f1"]
            sf1  = s_metrics["macro_f1"]
            gora = g_oracle.get("macro_f1", 0.0) if g_oracle else 0.0
            sora = s_oracle.get("macro_f1", 0.0) if s_oracle else 0.0
            print(f"{h:>8} | {int(gt_mask.sum()):>9} | {s1f1:>6.4f} | {gf1:>7.4f} | {sf1:>7.4f} | {gora:>8.4f} | {sora:>8.4f}")
            with open(outdir / f"metrics_combined_h{h}.json", "w") as f:
                json.dump(m, f, indent=2)

        with open(outdir / "metrics_all_horizons.json", "w") as f:
            json.dump(all_h_metrics, f, indent=2)
        print(f"\nSaved to {outdir}/metrics_all_horizons.json")
        print("[OK] Multi-horizon prediction complete!")
        return

    # --- Single-horizon mode (original behaviour) ---
    print("=" * 70)
    print(f"TWO-STAGE PREDICTION  [{cfg.model_type.upper()}]")
    print("=" * 70)

    X_test  = np.load(data_dir / "X_test.npy")
    ev_test = np.load(data_dir / "ev_test.npy")
    g_test  = np.load(data_dir / "g_test.npy")
    s_test  = np.load(data_dir / "s_test.npy")

    print(f"Test windows: {len(X_test)}")
    print(f"Test event ratio: {ev_test.mean():.2%}")

    # ---- Stage 1: event detection ----
    print("\n--- Stage 1: Event Detection ---")
    if event_threshold != 0.5:
        print(f"  [event-threshold={event_threshold:.2f}  (weakened gate)]")
    if is_neural:
        ev_probs = _predict_neural_s1_probs(X_test, cfg, stage1_path)
        ev_preds = (ev_probs >= event_threshold).astype(np.int64)
    else:
        ev_probs = _predict_tree_s1_probs(X_test, stage1_path)
        ev_preds = (ev_probs >= event_threshold).astype(np.int64)

    ev_metrics = compute_metrics(ev_preds, ev_test, 2, ["no_event", "event"])
    print(f"Event detection: Acc={ev_metrics['accuracy']:.4f}, F1={ev_metrics['macro_f1']:.4f}")
    for cls, cm in ev_metrics["per_class"].items():
        print(f"  {cls}: P={cm['precision']:.3f} R={cm['recall']:.3f} F1={cm['f1']:.3f} n={cm['support']}")

    # ---- Stage 2: classification on predicted events ----
    print("\n--- Stage 2: Goal/Stimuli on Predicted Events ---")
    event_mask       = ev_preds == 1
    n_pred_events    = int(event_mask.sum())
    print(f"Predicted events: {n_pred_events} / {len(ev_preds)}")

    if n_pred_events > 0:
        X_events   = X_test[event_mask]
        g_events   = g_test[event_mask]
        s_events   = s_test[event_mask]
        if is_neural:
            g_preds, s_preds = _predict_neural_s2(X_events, cfg, stage2_path)
        else:
            g_preds, s_preds = _predict_tree_s2(X_events, stage2_path)
        g_metrics = compute_metrics(g_preds, g_events, cfg.n_goal_classes, goal_labels)
        s_metrics = compute_metrics(s_preds, s_events, cfg.n_stimuli_classes, stimuli_labels)
        print(f"Goal    (on pred events): Acc={g_metrics['accuracy']:.4f}, Macro-F1={g_metrics['macro_f1']:.4f}")
        print(f"Stimuli (on pred events): Acc={s_metrics['accuracy']:.4f}, Macro-F1={s_metrics['macro_f1']:.4f}")
    else:
        g_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}
        s_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}
        print("  No events predicted — skipping Stage 2 evaluation")

    # ---- Oracle: Stage 2 on ground-truth events ----
    print("\n--- Oracle: Stage 2 on Ground-Truth Events ---")
    gt_event_mask = ev_test == 1
    if gt_event_mask.sum() > 0:
        X_gt = X_test[gt_event_mask]
        if is_neural:
            g_or, s_or = _predict_neural_s2(X_gt, cfg, stage2_path)
        else:
            g_or, s_or = _predict_tree_s2(X_gt, stage2_path)
        g_oracle = compute_metrics(g_or, g_test[gt_event_mask], cfg.n_goal_classes, goal_labels)
        s_oracle = compute_metrics(s_or, s_test[gt_event_mask], cfg.n_stimuli_classes, stimuli_labels)
        print(f"  Goal (oracle):    Macro-F1={g_oracle['macro_f1']:.4f}")
        print(f"  Stimuli (oracle): Macro-F1={s_oracle['macro_f1']:.4f}")
    else:
        g_oracle = s_oracle = {}

    combined = {
        "model": cfg.model_type,
        "event_threshold":               event_threshold,
        "event_detection":               ev_metrics,
        "goal_on_predicted_events":      g_metrics,
        "stimuli_on_predicted_events":   s_metrics,
        "goal_oracle":                   g_oracle,
        "stimuli_oracle":                s_oracle,
        "n_test_windows":                len(ev_test),
        "n_predicted_events":            n_pred_events,
        "n_gt_events":                   int(gt_event_mask.sum()),
    }

    # ---- Optional area breakdown ----
    if getattr(args, "breakdown_by_area", False):
        sensor_dir_str     = args.sensor_dir     or stats.get("sensor_dir")
        eaf_parsed_dir_str = args.eaf_parsed_dir or stats.get("eaf_parsed_dir")
        vocab_dir_str      = args.vocab_dir      or stats.get("vocab_dir")

        if not sensor_dir_str or not eaf_parsed_dir_str or not vocab_dir_str:
            print("\n[WARN] --breakdown-by-area requires sensor_dir, eaf_parsed_dir, vocab_dir.")
        else:
            print("\n--- Area Breakdown ---")
            area_labels = build_area_labels_for_test(
                sensor_dir     = Path(sensor_dir_str),
                eaf_parsed_dir = Path(eaf_parsed_dir_str),
                vocab_dir      = Path(vocab_dir_str),
                test_day       = stats.get("test_day", ""),
                sample_hz      = cfg.sample_hz,
                window_len     = cfg.window_len,
                stride_len     = cfg.stride_len,
            )
            if len(area_labels) != len(ev_test):
                print(f"  [WARN] Area labels ({len(area_labels)}) != test windows ({len(ev_test)}). Skipping.")
            else:
                per_area: Dict[str, Any] = {}
                for area_idx, area_name in enumerate(AREA_NAMES):
                    mask     = area_labels == area_idx
                    n_win    = int(mask.sum())
                    if n_win == 0:
                        per_area[area_name] = {"n_windows": 0, "note": "no windows"}
                        continue
                    a_ev_preds = ev_preds[mask]
                    a_ev_gt    = ev_test[mask]
                    a_ev_m     = compute_metrics(a_ev_preds, a_ev_gt, 2, ["no_event", "event"])
                    a_ev_mask  = a_ev_preds == 1
                    n_a_pred   = int(a_ev_mask.sum())
                    if n_a_pred > 0:
                        X_a = X_test[mask][a_ev_mask]
                        if is_neural:
                            g_a, s_a = _predict_neural_s2(X_a, cfg, stage2_path)
                        else:
                            g_a, s_a = _predict_tree_s2(X_a, stage2_path)
                        g_am = compute_metrics(g_a, g_test[mask][a_ev_mask], cfg.n_goal_classes, goal_labels)
                        s_am = compute_metrics(s_a, s_test[mask][a_ev_mask], cfg.n_stimuli_classes, stimuli_labels)
                    else:
                        g_am = s_am = {"accuracy": 0, "macro_f1": 0, "per_class": {}}
                    per_area[area_name] = {
                        "n_windows": n_win, "n_events_gt": int(a_ev_gt.sum()),
                        "n_events_predicted": n_a_pred,
                        "event_detection": a_ev_m, "goal": g_am, "stimuli": s_am,
                    }
                    print(f"\n  [{area_name.upper()}] ({n_win} windows, {int(a_ev_gt.sum())} GT events)")
                    print(f"    Event F1:    {a_ev_m['macro_f1']:.4f}")
                    if n_a_pred > 0:
                        print(f"    Goal F1:    {g_am['macro_f1']:.4f}")
                        print(f"    Stimuli F1: {s_am['macro_f1']:.4f}")
                combined["per_area"] = per_area

    with open(outdir / "metrics_combined.json", "w") as f:
        json.dump(combined, f, indent=2)
    print(f"\nSaved to {outdir}/metrics_combined.json")
    print("[OK] Prediction complete!")


# ---------------------------------------------------------------------------
# CLI
# ---------------------------------------------------------------------------

def main() -> None:
    parser = argparse.ArgumentParser(
        description="Two-Stage Multi-Model: Event Detection + Goal/Stimuli Classification"
    )
    sub = parser.add_subparsers(dest="cmd")

    # --- prepare ---
    p = sub.add_parser("prepare", help="Build windowed dataset from prealigned sensors + EAF")
    p.add_argument("--sensor-dir",      required=True)
    p.add_argument("--eaf-parsed-dir",  required=True)
    p.add_argument("--vocab-dir",       required=True)
    p.add_argument("--output-dir",      required=True)
    p.add_argument("--sample-hz",       type=float, default=3.0)
    p.add_argument("--window-sec",      type=float, default=5.0)
    p.add_argument("--stride-sec",      type=float, default=1.0)
    p.add_argument("--event-ratio",     type=float, default=0.7)
    p.add_argument("--horizons",        nargs="+",  type=int, default=[0],
                   help="Prediction horizons in steps (e.g. 0 1 2 3 6 9 12 15). "
                        "h=0 = label inside window (default). h>0 = point label h steps ahead.")
    p.set_defaults(func=cmd_prepare)

    # --- train-stage1 ---
    p = sub.add_parser("train-stage1", help="Train Stage 1 event detector")
    p.add_argument("--model",          required=True, choices=sorted(ALL_MODELS))
    p.add_argument("--data-dir",       required=True)
    p.add_argument("--outdir",         required=True)
    p.add_argument("--epochs",         type=int,   default=None)
    p.add_argument("--lr",             type=float, default=None)
    p.add_argument("--batch-size",     type=int,   default=None)
    p.add_argument("--d-model",        type=int,   default=None)
    p.add_argument("--num-layers",     type=int,   default=None)
    p.add_argument("--dropout",        type=float, default=None)
    p.add_argument("--balance-ratio",  type=float, default=None,
                   help="Target event ratio after undersampling no-events (e.g. 0.5). "
                        "Default: no rebalancing.")
    p.add_argument("--horizon-steps",  nargs="+", type=int, default=[0],
                   help="Horizon(s) in steps ahead. One model trained on all combined. "
                        "E.g.: --horizon-steps 0 1 2 3 6 9 12 15. Default: 0.")
    p.set_defaults(func=cmd_train_stage1)

    # --- train-stage2 ---
    p = sub.add_parser("train-stage2", help="Train Stage 2 Goal/Stimuli classifier")
    p.add_argument("--model",          required=True, choices=sorted(ALL_MODELS))
    p.add_argument("--data-dir",       required=True)
    p.add_argument("--stage1-model",   required=True,
                   help="Path to stage1.pt or stage1_tree.joblib (not used for tree training)")
    p.add_argument("--outdir",         required=True)
    p.add_argument("--epochs",         type=int,   default=None)
    p.add_argument("--lr",             type=float, default=None)
    p.add_argument("--batch-size",     type=int,   default=None)
    p.add_argument("--d-model",        type=int,   default=None)
    p.add_argument("--num-layers",     type=int,   default=None)
    p.add_argument("--dropout",        type=float, default=None)
    p.add_argument("--horizon-steps",  nargs="+", type=int, default=[0],
                   help="Horizon(s) in steps ahead. One model trained on all combined. "
                        "E.g.: --horizon-steps 0 1 2 3 6 9 12 15. Default: 0.")
    p.set_defaults(func=cmd_train_stage2)

    # --- predict ---
    p = sub.add_parser("predict", help="End-to-end two-stage prediction + evaluation")
    p.add_argument("--model",             required=True, choices=sorted(ALL_MODELS))
    p.add_argument("--data-dir",          required=True)
    p.add_argument("--stage1-model",      required=True)
    p.add_argument("--stage2-model",      required=True)
    p.add_argument("--outdir",            required=True)
    p.add_argument("--breakdown-by-area", action="store_true")
    p.add_argument("--sensor-dir",        default=None)
    p.add_argument("--eaf-parsed-dir",    default=None)
    p.add_argument("--vocab-dir",         default=None)
    p.add_argument("--event-threshold",   type=float, default=0.5,
                   help="P(event) threshold for Stage 1 gate (default: 0.5 = argmax). "
                        "Lower values (e.g. 0.3) pass more windows to Stage 2.")
    p.add_argument("--horizons",          nargs="+",  type=int, default=None,
                   help="Evaluate multiple horizons at once (e.g. 0 1 2 3 6 9 12 15). "
                        "Stage1/Stage2 model paths are used as base paths; horizon suffix "
                        "is appended automatically (e.g. stage1_tree_h3.joblib). "
                        "Produces metrics_all_horizons.json summary table.")
    p.set_defaults(func=cmd_predict)

    args = parser.parse_args()
    if not hasattr(args, "func"):
        parser.print_help()
        sys.exit(1)
    args.func(args)


if __name__ == "__main__":
    main()
