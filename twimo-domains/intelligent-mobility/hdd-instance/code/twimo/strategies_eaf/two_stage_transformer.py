#!/usr/bin/env python
"""Two-Stage Transformer for Event Detection + Goal/Stimuli Classification.

Self-contained script. Uses prealigned sensors (.npy) and EAF annotations.

Commands:
    prepare       Build windowed dataset from prealigned sensors + EAF
    train-stage1  Train Event Detection Transformer (binary)
    train-stage2  Train Goal/Stimuli Classification Transformer
    predict       End-to-end prediction pipeline

Usage:
    python two_stage_transformer.py prepare --sensor-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor --eaf-parsed-dir ./artifacts/eaf/parsed --vocab-dir ./artifacts/eaf/vocabs --output-dir ./artifacts/eaf/two_stage/data
    python two_stage_transformer.py train-stage1 --data-dir ./artifacts/eaf/two_stage/data --outdir ./artifacts/eaf/two_stage/stage1_event --epochs 30
    python two_stage_transformer.py train-stage2 --data-dir ./artifacts/eaf/two_stage/data --stage1-model ./artifacts/eaf/two_stage/stage1_event/stage1.pt --outdir ./artifacts/eaf/two_stage/stage2_classify --epochs 30
    python two_stage_transformer.py predict --data-dir ./artifacts/eaf/two_stage/data --stage1-model ./artifacts/eaf/two_stage/stage1_event/stage1.pt --stage2-model ./artifacts/eaf/two_stage/stage2_classify/stage2.pt --outdir ./artifacts/eaf/two_stage/predictions
"""
from __future__ import annotations

import argparse
import json
import math
import sys
from collections import Counter
from dataclasses import asdict, dataclass
from pathlib import Path
from typing import Dict, List, Optional, Tuple

import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F
from torch.optim.lr_scheduler import CosineAnnealingLR
from torch.utils.data import DataLoader, Dataset, TensorDataset

# ---------------------------------------------------------------------------
# Configuration
# ---------------------------------------------------------------------------

@dataclass
class TwoStageConfig:
    window_sec: float = 5.0
    stride_sec: float = 1.0
    sample_hz: float = 3.0
    d_model: int = 128
    nhead: int = 4
    num_layers: int = 3
    dim_ff: int = 256
    dropout: float = 0.1
    batch_size: int = 32
    epochs: int = 30
    lr: float = 1e-4
    focal_gamma: float = 2.0
    focal_alpha: float = 0.75
    event_ratio: float = 0.7  # target ratio of event windows
    n_goal_classes: int = 14
    n_stimuli_classes: int = 9
    input_dim: int = 0  # auto-detected
    window_len: int = 0  # auto-computed
    stride_len: int = 0  # auto-computed
    device: str = ""

    def __post_init__(self):
        self.window_len = int(self.window_sec * self.sample_hz)
        self.stride_len = int(self.stride_sec * self.sample_hz)
        if not self.device:
            self.device = "cuda" if torch.cuda.is_available() else "cpu"


# ---------------------------------------------------------------------------
# Data: EAF parsing & alignment
# ---------------------------------------------------------------------------

def normalize_session_id(eaf_stem: str) -> str:
    """Convert '2017-02-27-10-17-27' -> '201702271017'."""
    parts = eaf_stem.replace("-", "")
    return parts[:12]


def load_vocab(vocab_path: Path) -> Tuple[List[str], Dict[str, int]]:
    """Load a vocabulary JSON and return (labels_list, label_map)."""
    with open(vocab_path, encoding="utf-8") as f:
        data = json.load(f)
    vocab = data["vocab"]  # {"label_eng": int_id, ...}
    labels = [""] * len(vocab)
    for name, idx in vocab.items():
        labels[idx] = name
    label_map = data.get("label_map", {})
    return labels, label_map, vocab


def map_annotations_to_timeline(
    annotations: List[dict],
    T: int,
    sample_hz: float,
    label_map: Dict[str, str],
    vocab: Dict[str, int],
) -> np.ndarray:
    """Map EAF tier annotations to integer label array of length T."""
    labels = np.zeros(T, dtype=np.int64)
    ms_per_step = 1000.0 / sample_hz

    for ann in annotations:
        start_ms = ann["start_ms"]
        end_ms = ann["end_ms"]
        label_raw = ann["label"].strip()

        # Try label_map first (Chinese+English -> English key)
        mapped = label_map.get(label_raw)
        if mapped and mapped in vocab:
            label_idx = vocab[mapped]
        else:
            # Try extracting English part
            eng = " ".join(
                p for p in label_raw.split()
                if p.replace("-", "").replace("_", "").isascii()
            ).strip().lower().replace(" ", "_")
            label_idx = vocab.get(eng, 0)

        # Map to timeline indices
        i_start = int(start_ms / ms_per_step)
        i_end = int(end_ms / ms_per_step)
        i_start = max(0, min(i_start, T))
        i_end = max(0, min(i_end, T))
        if i_start < i_end:
            labels[i_start:i_end] = label_idx

    return labels


def load_and_align_session(
    sensor_npy: Path,
    eaf_json: Path,
    goal_labels: List[str],
    goal_label_map: Dict[str, str],
    goal_vocab: Dict[str, int],
    stimuli_labels: List[str],
    stimuli_label_map: Dict[str, str],
    stimuli_vocab: Dict[str, int],
    sample_hz: float,
) -> Optional[Tuple[np.ndarray, np.ndarray, np.ndarray]]:
    """Load prealigned sensors and map EAF annotations.

    Returns (sensors, target_goal, target_stimuli) or None.
    """
    sensors = np.load(sensor_npy).astype(np.float32)
    if sensors.ndim != 2:
        return None
    T, D = sensors.shape

    with open(eaf_json, encoding="utf-8") as f:
        eaf_data = json.load(f)

    tiers = eaf_data.get("tiers_grouped", {})

    goal_key = None
    stimuli_key = None
    for tier_name in tiers:
        tl = tier_name.lower()
        if "goal" in tl:
            goal_key = tier_name
        elif "stimuli" in tl or "stimulus" in tl:
            stimuli_key = tier_name

    if not goal_key or not stimuli_key:
        print(f"  [SKIP] Missing Goal/Stimuli tiers in {eaf_json.name}")
        return None

    target_goal = map_annotations_to_timeline(
        tiers[goal_key], T, sample_hz, goal_label_map, goal_vocab
    )
    target_stimuli = map_annotations_to_timeline(
        tiers[stimuli_key], T, sample_hz, stimuli_label_map, stimuli_vocab
    )

    return sensors, target_goal, target_stimuli


# ---------------------------------------------------------------------------
# Data: windowing & balancing
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
    """Sliding window extraction.

    Returns (X_windows, event_flags, goal_classes, stimuli_classes).
    When horizon_steps > 0, labels are point labels at end + horizon_steps.
    max_horizon enforces a safety margin so all horizons yield the same N windows.
    """
    T = sensors.shape[0]
    X_list, ev_list, g_list, s_list = [], [], [], []

    loop_bound = (T - window_len - max_horizon + 1) if max_horizon > 0 else (T - window_len + 1)
    for start in range(0, loop_bound, stride_len):
        end = start + window_len
        x_win = sensors[start:end]

        if horizon_steps == 0:
            g_win = goal[start:end]
            s_win = stimuli[start:end]

            has_goal = np.any(g_win != 0)
            has_stimuli = np.any(s_win != 0)
            event_flag = 1 if (has_goal or has_stimuli) else 0

            # Majority non-zero class (or 0 if all zero)
            g_nonzero = g_win[g_win != 0]
            goal_cls = int(Counter(g_nonzero.tolist()).most_common(1)[0][0]) if len(g_nonzero) > 0 else 0

            s_nonzero = s_win[s_win != 0]
            stimuli_cls = int(Counter(s_nonzero.tolist()).most_common(1)[0][0]) if len(s_nonzero) > 0 else 0
        else:
            # Point label at exactly end + horizon_steps
            goal_cls = int(goal[end + horizon_steps])
            stimuli_cls = int(stimuli[end + horizon_steps])
            event_flag = 1 if (goal_cls != 0 or stimuli_cls != 0) else 0

        X_list.append(x_win)
        ev_list.append(event_flag)
        g_list.append(goal_cls)
        s_list.append(stimuli_cls)

    if not X_list:
        return (
            np.empty((0, window_len, sensors.shape[1]), dtype=np.float32),
            np.empty(0, dtype=np.int64),
            np.empty(0, dtype=np.int64),
            np.empty(0, dtype=np.int64),
        )

    return (
        np.array(X_list, dtype=np.float32),
        np.array(ev_list, dtype=np.int64),
        np.array(g_list, dtype=np.int64),
        np.array(s_list, dtype=np.int64),
    )


def balance_windows(
    X: np.ndarray,
    event: np.ndarray,
    goal: np.ndarray,
    stimuli: np.ndarray,
    event_ratio: float = 0.7,
    rng: np.random.Generator | None = None,
    return_indices: bool = False,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Undersample no-event windows to achieve target event_ratio."""
    if rng is None:
        rng = np.random.default_rng(42)

    event_idx = np.where(event == 1)[0]
    noevent_idx = np.where(event == 0)[0]

    n_event = len(event_idx)
    if n_event == 0:
        if return_indices:
            return X, event, goal, stimuli, np.arange(len(X))
        return X, event, goal, stimuli

    # Target: n_event / (n_event + n_noevent_keep) = event_ratio
    n_noevent_keep = int(n_event * (1 - event_ratio) / event_ratio)
    n_noevent_keep = max(1, min(n_noevent_keep, len(noevent_idx)))

    noevent_sampled = rng.choice(noevent_idx, size=n_noevent_keep, replace=False)
    keep = np.sort(np.concatenate([event_idx, noevent_sampled]))

    if return_indices:
        return X[keep], event[keep], goal[keep], stimuli[keep], keep
    return X[keep], event[keep], goal[keep], stimuli[keep]


# ---------------------------------------------------------------------------
# Models
# ---------------------------------------------------------------------------

class FocalLoss(nn.Module):
    """Focal Loss for imbalanced binary/multi-class classification."""

    def __init__(self, gamma: float = 2.0, alpha: Optional[float] = None, reduction: str = "mean"):
        super().__init__()
        self.gamma = gamma
        self.alpha = alpha
        self.reduction = reduction

    def forward(self, logits: torch.Tensor, targets: torch.Tensor) -> torch.Tensor:
        ce = F.cross_entropy(logits, targets, reduction="none")
        pt = torch.exp(-ce)
        focal = ((1 - pt) ** self.gamma) * ce

        if self.alpha is not None:
            alpha_t = torch.where(targets == 1, self.alpha, 1 - self.alpha)
            focal = alpha_t * focal

        if self.reduction == "mean":
            return focal.mean()
        elif self.reduction == "sum":
            return focal.sum()
        return focal


class AttentionPooling(nn.Module):
    """Learned attention pooling over sequence dimension."""

    def __init__(self, d_model: int):
        super().__init__()
        self.query = nn.Parameter(torch.randn(d_model))

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        # x: (B, T, D)
        scores = torch.einsum("btd,d->bt", x, self.query)  # (B, T)
        weights = F.softmax(scores, dim=1).unsqueeze(-1)  # (B, T, 1)
        return (x * weights).sum(dim=1)  # (B, D)


class EventTransformer(nn.Module):
    """Stage 1: Binary event detection Transformer."""

    def __init__(self, input_dim: int, cfg: TwoStageConfig):
        super().__init__()
        self.proj = nn.Linear(input_dim, cfg.d_model)
        self.pos_emb = nn.Embedding(cfg.window_len, cfg.d_model)
        encoder_layer = nn.TransformerEncoderLayer(
            d_model=cfg.d_model,
            nhead=cfg.nhead,
            dim_feedforward=cfg.dim_ff,
            dropout=cfg.dropout,
            batch_first=True,
        )
        self.encoder = nn.TransformerEncoder(encoder_layer, num_layers=cfg.num_layers)
        self.pool = AttentionPooling(cfg.d_model)
        self.head = nn.Sequential(
            nn.LayerNorm(cfg.d_model),
            nn.Linear(cfg.d_model, 2),
        )

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        B, T, _ = x.shape
        positions = torch.arange(T, device=x.device).unsqueeze(0).expand(B, -1)
        h = self.proj(x) + self.pos_emb(positions)
        h = self.encoder(h)
        h = self.pool(h)
        return self.head(h)  # (B, 2)

    def get_features(self, x: torch.Tensor) -> torch.Tensor:
        """Get pooled features (for transfer to Stage 2)."""
        B, T, _ = x.shape
        positions = torch.arange(T, device=x.device).unsqueeze(0).expand(B, -1)
        h = self.proj(x) + self.pos_emb(positions)
        h = self.encoder(h)
        return self.pool(h)  # (B, d_model)


class ClassificationTransformer(nn.Module):
    """Stage 2: Multi-task Goal + Stimuli classification Transformer."""

    def __init__(self, input_dim: int, cfg: TwoStageConfig):
        super().__init__()
        self.proj = nn.Linear(input_dim, cfg.d_model)
        self.pos_emb = nn.Embedding(cfg.window_len, cfg.d_model)
        encoder_layer = nn.TransformerEncoderLayer(
            d_model=cfg.d_model,
            nhead=cfg.nhead,
            dim_feedforward=cfg.dim_ff,
            dropout=cfg.dropout,
            batch_first=True,
        )
        self.encoder = nn.TransformerEncoder(encoder_layer, num_layers=cfg.num_layers)
        self.pool = AttentionPooling(cfg.d_model)
        self.norm = nn.LayerNorm(cfg.d_model)
        self.goal_head = nn.Linear(cfg.d_model, cfg.n_goal_classes)
        self.stimuli_head = nn.Linear(cfg.d_model, cfg.n_stimuli_classes)

    def forward(self, x: torch.Tensor) -> Tuple[torch.Tensor, torch.Tensor]:
        B, T, _ = x.shape
        positions = torch.arange(T, device=x.device).unsqueeze(0).expand(B, -1)
        h = self.proj(x) + self.pos_emb(positions)
        h = self.encoder(h)
        h = self.pool(h)
        h = self.norm(h)
        return self.goal_head(h), self.stimuli_head(h)


# ---------------------------------------------------------------------------
# Area breakdown utilities
# ---------------------------------------------------------------------------

AREA_NAMES = ["unknown", "downtown", "freeway", "tunnel"]


def load_area_vocab(vocab_dir: Path) -> Dict[str, int]:
    """Load area vocabulary, extending with tunnel if missing."""
    vocab_path = vocab_dir / "vocab_area.json"
    if not vocab_path.exists():
        return {"unknown": 0, "downtown": 1, "freeway": 2, "tunnel": 3}
    with open(vocab_path, encoding="utf-8") as f:
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
    """Reconstruct per-window area labels for test set windows.

    Replays the same windowing logic as prepare, but only for test-day
    sessions, and extracts the Area tier instead of Goal/Stimuli.
    """
    area_vocab = load_area_vocab(vocab_dir)
    area_label_map_path = vocab_dir / "vocab_area.json"
    area_label_map: Dict[str, str] = {}
    if area_label_map_path.exists():
        with open(area_label_map_path, encoding="utf-8") as f:
            area_label_map = json.load(f).get("label_map", {})

    # Build eaf mapping
    eaf_files = sorted(eaf_parsed_dir.glob("*.json"))
    eaf_map: Dict[str, Path] = {}
    for ef in eaf_files:
        if ef.name == "summary.json":
            continue
        eaf_map[normalize_session_id(ef.stem)] = ef

    # Process test-day sessions in sorted order (same as prepare)
    all_area = []
    for sf in sorted(sensor_dir.glob("*.npy")):
        sid = sf.stem
        if not sid.startswith(test_day):
            continue
        if sid not in eaf_map:
            continue

        sensors = np.load(sf)
        T = sensors.shape[0]

        # Load EAF data
        with open(eaf_map[sid], encoding="utf-8") as f:
            eaf_data = json.load(f)
        tiers = eaf_data.get("tiers_grouped", {})

        # Skip sessions without Goal/Stimuli tiers (same filter as prepare)
        has_goal = any("goal" in k.lower() for k in tiers)
        has_stimuli = any("stimuli" in k.lower() or "stimulus" in k.lower() for k in tiers)
        if not has_goal or not has_stimuli:
            continue

        area_key = None
        for k in tiers:
            if "area" in k.lower():
                area_key = k
                break

        area_timeline = np.zeros(T, dtype=np.int64)
        if area_key:
            area_timeline = map_annotations_to_timeline(
                tiers[area_key], T, sample_hz, area_label_map, area_vocab
            )

        # Create windows (same logic as create_windows)
        for start in range(0, T - window_len + 1, stride_len):
            end = start + window_len
            a_win = area_timeline[start:end]
            # Majority area in window (excluding unknown if possible)
            nonzero = a_win[a_win != 0]
            if len(nonzero) > 0:
                area_cls = int(Counter(nonzero.tolist()).most_common(1)[0][0])
            else:
                area_cls = 0
            all_area.append(area_cls)

    return np.array(all_area, dtype=np.int64) if all_area else np.array([], dtype=np.int64)


# ---------------------------------------------------------------------------
# Training utilities
# ---------------------------------------------------------------------------

def compute_class_weights(labels: np.ndarray, n_classes: int) -> torch.Tensor:
    """Inverse frequency class weights."""
    counts = np.bincount(labels, minlength=n_classes).astype(np.float32)
    counts = np.maximum(counts, 1.0)
    weights = 1.0 / counts
    weights /= weights.sum()
    weights *= n_classes
    return torch.from_numpy(weights)


def compute_metrics(
    preds: np.ndarray, targets: np.ndarray, n_classes: int, label_names: Optional[List[str]] = None
) -> dict:
    """Compute accuracy, macro-F1, per-class precision/recall/F1."""
    from collections import defaultdict

    metrics = {}
    metrics["accuracy"] = float((preds == targets).mean())

    per_class = {}
    f1s = []
    for c in range(n_classes):
        tp = int(((preds == c) & (targets == c)).sum())
        fp = int(((preds == c) & (targets != c)).sum())
        fn = int(((preds != c) & (targets == c)).sum())
        prec = tp / (tp + fp) if (tp + fp) > 0 else 0.0
        rec = tp / (tp + fn) if (tp + fn) > 0 else 0.0
        f1 = 2 * prec * rec / (prec + rec) if (prec + rec) > 0 else 0.0
        name = label_names[c] if label_names and c < len(label_names) else f"class_{c}"
        per_class[name] = {"precision": round(prec, 4), "recall": round(rec, 4), "f1": round(f1, 4), "support": int((targets == c).sum())}
        if (targets == c).sum() > 0:
            f1s.append(f1)

    metrics["macro_f1"] = round(float(np.mean(f1s)) if f1s else 0.0, 4)
    metrics["per_class"] = per_class
    return metrics


# ---------------------------------------------------------------------------
# Command: prepare
# ---------------------------------------------------------------------------

def cmd_prepare(args: argparse.Namespace) -> None:
    horizons: List[int] = sorted(set(getattr(args, "horizons", None) or [0]))
    max_horizon = max(horizons)

    cfg = TwoStageConfig(
        window_sec=args.window_sec,
        stride_sec=args.stride_sec,
        sample_hz=args.sample_hz,
    )
    sensor_dir = Path(args.sensor_dir)
    eaf_dir = Path(args.eaf_parsed_dir)
    vocab_dir = Path(args.vocab_dir)
    outdir = Path(args.output_dir)
    outdir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("TWO-STAGE TRANSFORMER - Dataset Preparation")
    print("=" * 70)
    print(f"Sensor dir:      {sensor_dir}")
    print(f"EAF parsed dir:  {eaf_dir}")
    print(f"Vocab dir:       {vocab_dir}")
    print(f"Output dir:      {outdir}")
    print(f"Window:          {cfg.window_sec}s ({cfg.window_len} steps)")
    print(f"Stride:          {cfg.stride_sec}s ({cfg.stride_len} steps)")
    print(f"Sample Hz:       {cfg.sample_hz}")
    print(f"Horizons:        {horizons}")
    print()

    # Load vocabularies
    goal_labels, goal_label_map, goal_vocab = load_vocab(vocab_dir / "vocab_goal.json")
    stimuli_labels, stimuli_label_map, stimuli_vocab = load_vocab(vocab_dir / "vocab_stimuli.json")
    cfg.n_goal_classes = len(goal_labels)
    cfg.n_stimuli_classes = len(stimuli_labels)
    print(f"Goal classes:    {cfg.n_goal_classes} {goal_labels[:5]}...")
    print(f"Stimuli classes: {cfg.n_stimuli_classes} {stimuli_labels[:5]}...")
    print()

    # Match sensor files to EAF parsed files
    sensor_files = sorted(sensor_dir.glob("*.npy"))
    eaf_files = sorted(eaf_dir.glob("*.json"))
    eaf_files = [f for f in eaf_files if f.name != "summary.json"]

    # Build mapping: normalized_id -> eaf_path
    eaf_map: Dict[str, Path] = {}
    for ef in eaf_files:
        norm_id = normalize_session_id(ef.stem)
        eaf_map[norm_id] = ef

    print(f"Sensor files:    {len(sensor_files)}")
    print(f"EAF files:       {len(eaf_files)}")

    # Process sessions — collect X + per-horizon labels in one pass
    all_X: List[np.ndarray] = []
    all_days: List[np.ndarray] = []
    horizon_data: Dict[int, Dict[str, List[np.ndarray]]] = {
        h: {"ev": [], "g": [], "s": []} for h in horizons
    }
    matched = 0

    for sf in sensor_files:
        sid = sf.stem  # e.g. "201702271017"
        if sid not in eaf_map:
            print(f"  [SKIP] No EAF for {sid}")
            continue

        result = load_and_align_session(
            sf, eaf_map[sid],
            goal_labels, goal_label_map, goal_vocab,
            stimuli_labels, stimuli_label_map, stimuli_vocab,
            cfg.sample_hz,
        )
        if result is None:
            continue

        sensors, tg, ts = result

        # h=0: extract X windows + h=0 labels (with max_horizon margin)
        X_w, ev_w, g_w, s_w = create_windows(
            sensors, tg, ts, cfg.window_len, cfg.stride_len,
            horizon_steps=0, max_horizon=max_horizon,
        )
        if X_w.shape[0] == 0:
            continue

        n_windows = X_w.shape[0]
        day_id = sid[:8]  # YYYYMMDD
        all_X.append(X_w)
        all_days.append(np.full(n_windows, day_id, dtype="U8"))
        horizon_data[0]["ev"].append(ev_w)
        horizon_data[0]["g"].append(g_w)
        horizon_data[0]["s"].append(s_w)

        # h>0: extract only labels (same X windows due to max_horizon)
        for h in horizons:
            if h == 0:
                continue
            _, ev_h, g_h, s_h = create_windows(
                sensors, tg, ts, cfg.window_len, cfg.stride_len,
                horizon_steps=h, max_horizon=max_horizon,
            )
            horizon_data[h]["ev"].append(ev_h)
            horizon_data[h]["g"].append(g_h)
            horizon_data[h]["s"].append(s_h)

        matched += 1
        n_ev = int(ev_w.sum())
        print(f"  [OK] {sid}: {n_windows} windows ({n_ev} event, {n_windows-n_ev} no-event), sensors={sensors.shape}")

    if matched == 0:
        print("\n[ERROR] No sessions matched. Check paths.")
        sys.exit(1)

    X_all = np.concatenate(all_X)
    days_all = np.concatenate(all_days)

    # Concatenate per-horizon labels
    ev_h0 = np.concatenate(horizon_data[0]["ev"])
    g_h0 = np.concatenate(horizon_data[0]["g"])
    s_h0 = np.concatenate(horizon_data[0]["s"])
    horizon_arrays: Dict[int, Dict[str, np.ndarray]] = {
        h: {
            "ev": np.concatenate(horizon_data[h]["ev"]),
            "g": np.concatenate(horizon_data[h]["g"]),
            "s": np.concatenate(horizon_data[h]["s"]),
        }
        for h in horizons
    }

    cfg.input_dim = X_all.shape[2]

    print(f"\nTotal windows: {X_all.shape[0]}")
    print(f"  Event (h=0): {int(ev_h0.sum())} ({100*ev_h0.mean():.1f}%)")
    print(f"  No-event:    {int((ev_h0==0).sum())} ({100*(1-ev_h0.mean()):.1f}%)")
    print(f"  Input dim:   {cfg.input_dim}")

    # Split by day: use last day as test
    unique_days = sorted(set(days_all.tolist()))
    print(f"\nDays found: {unique_days}")

    if len(unique_days) < 2:
        print("[WARN] Only 1 day found. Using random 80/20 split.")
        rng = np.random.default_rng(42)
        n = len(X_all)
        idx = rng.permutation(n)
        split = int(0.8 * n)
        train_mask = np.zeros(n, dtype=bool)
        train_mask[idx[:split]] = True
        test_mask = ~train_mask
        test_day = "random"
    else:
        test_day = unique_days[-1]
        test_mask = days_all == test_day
        train_mask = ~test_mask

    print(f"Test day: {test_day}")
    print(f"Train: {train_mask.sum()} windows, Test: {test_mask.sum()} windows")

    # Balance training set using h=0 labels, capturing indices
    X_train_raw = X_all[train_mask]
    ev_train_raw_h0 = ev_h0[train_mask]
    g_train_raw_h0 = g_h0[train_mask]
    s_train_raw_h0 = s_h0[train_mask]

    X_train, ev_train_h0, g_train_h0, s_train_h0, balance_keep = balance_windows(
        X_train_raw, ev_train_raw_h0, g_train_raw_h0, s_train_raw_h0,
        event_ratio=cfg.event_ratio,
        return_indices=True,
    )

    print(f"\nAfter balancing train:")
    print(f"  Total:    {len(ev_train_h0)}")
    print(f"  Event:    {int(ev_train_h0.sum())} ({100*ev_train_h0.mean():.1f}%)")
    print(f"  No-event: {int((ev_train_h0==0).sum())} ({100*(1-ev_train_h0.mean()):.1f}%)")

    # Validation split (10% of balanced train)
    rng = np.random.default_rng(42)
    n_train = len(X_train)
    idx = rng.permutation(n_train)
    n_val = max(1, int(0.1 * n_train))
    val_idx = idx[:n_val]
    train_idx = idx[n_val:]

    # Normalize features (fit on train, apply to val/test)
    mean = X_train[train_idx].reshape(-1, cfg.input_dim).mean(axis=0)
    std = X_train[train_idx].reshape(-1, cfg.input_dim).std(axis=0)
    std[std < 1e-8] = 1.0

    X_train_norm = (X_train - mean) / std
    X_test_norm = (X_all[test_mask] - mean) / std

    # Save X (shared across all horizons)
    np.save(outdir / "X_train.npy", X_train_norm[train_idx])
    np.save(outdir / "X_val.npy",   X_train_norm[val_idx])
    np.save(outdir / "X_test.npy",  X_test_norm)
    np.save(outdir / "norm_mean.npy", mean)
    np.save(outdir / "norm_std.npy",  std)

    # Save per-horizon labels applying the same indices: train_mask → balance_keep → train_idx/val_idx
    def _save_horizon_labels(h: int, ev_all_h: np.ndarray, g_all_h: np.ndarray, s_all_h: np.ndarray) -> None:
        ev_tr_raw = ev_all_h[train_mask][balance_keep]
        g_tr_raw  = g_all_h[train_mask][balance_keep]
        s_tr_raw  = s_all_h[train_mask][balance_keep]

        suffix = "" if h == 0 else f"_h{h}"
        np.save(outdir / f"ev_train{suffix}.npy", ev_tr_raw[train_idx])
        np.save(outdir / f"g_train{suffix}.npy",  g_tr_raw[train_idx])
        np.save(outdir / f"s_train{suffix}.npy",  s_tr_raw[train_idx])
        np.save(outdir / f"ev_val{suffix}.npy",   ev_tr_raw[val_idx])
        np.save(outdir / f"g_val{suffix}.npy",    g_tr_raw[val_idx])
        np.save(outdir / f"s_val{suffix}.npy",    s_tr_raw[val_idx])
        np.save(outdir / f"ev_test{suffix}.npy",  ev_all_h[test_mask])
        np.save(outdir / f"g_test{suffix}.npy",   g_all_h[test_mask])
        np.save(outdir / f"s_test{suffix}.npy",   s_all_h[test_mask])

    for h in horizons:
        ha = horizon_arrays[h]
        _save_horizon_labels(h, ha["ev"], ha["g"], ha["s"])
        suf = "" if h == 0 else f"_h{h}"
        print(f"  Saved labels for h={h} (suffix='{suf}')")

    with open(outdir / "horizons_prepared.json", "w") as f:
        json.dump(horizons, f)

    # Save config and stats
    with open(outdir / "config.json", "w") as f:
        json.dump(asdict(cfg), f, indent=2)

    ev_train_final = np.load(outdir / "ev_train.npy")
    ev_val_final   = np.load(outdir / "ev_val.npy")
    ev_test_final  = np.load(outdir / "ev_test.npy")
    X_train_final  = np.load(outdir / "X_train.npy")
    X_val_final    = np.load(outdir / "X_val.npy")
    X_test_final   = np.load(outdir / "X_test.npy")

    stats = {
        "matched_sessions": matched,
        "total_windows_before_balance": int(X_all.shape[0]),
        "train": {"total": len(ev_train_final), "event": int(ev_train_final.sum()), "noevent": int((ev_train_final == 0).sum())},
        "val":   {"total": len(ev_val_final),   "event": int(ev_val_final.sum()),   "noevent": int((ev_val_final   == 0).sum())},
        "test":  {"total": len(ev_test_final),  "event": int(ev_test_final.sum()),  "noevent": int((ev_test_final  == 0).sum())},
        "test_day": test_day,
        "input_dim": cfg.input_dim,
        "horizons_prepared": horizons,
        "goal_distribution": {goal_labels[i]: int(c) for i, c in enumerate(np.bincount(g_h0, minlength=cfg.n_goal_classes))},
        "stimuli_distribution": {stimuli_labels[i]: int(c) for i, c in enumerate(np.bincount(s_h0, minlength=cfg.n_stimuli_classes))},
        "goal_labels": goal_labels,
        "stimuli_labels": stimuli_labels,
        "sensor_dir": str(sensor_dir.resolve()),
        "eaf_parsed_dir": str(eaf_dir.resolve()),
        "vocab_dir": str(vocab_dir.resolve()),
    }
    with open(outdir / "dataset_stats.json", "w") as f:
        json.dump(stats, f, indent=2)

    print(f"\nSaved to {outdir}/")
    print(f"  X_train: {X_train_final.shape}, X_val: {X_val_final.shape}, X_test: {X_test_final.shape}")
    print(f"  Horizons: {horizons}")
    print("\n[OK] Dataset preparation complete!")


# ---------------------------------------------------------------------------
# Command: train-stage1
# ---------------------------------------------------------------------------

def cmd_train_stage1(args: argparse.Namespace) -> None:
    data_dir = Path(args.data_dir)
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    with open(data_dir / "config.json") as f:
        cfg_dict = json.load(f)
    cfg = TwoStageConfig(**{k: v for k, v in cfg_dict.items() if k in TwoStageConfig.__dataclass_fields__})
    cfg.epochs = args.epochs
    cfg.lr = args.lr
    cfg.batch_size = args.batch_size

    # Parse horizon steps
    _hs_raw = getattr(args, "horizon_steps", None)
    if isinstance(_hs_raw, list):
        horizons = sorted(set(int(h) for h in _hs_raw)) if _hs_raw else [0]
    elif _hs_raw is not None:
        horizons = [int(_hs_raw)]
    else:
        horizons = [0]

    print("=" * 70)
    print("STAGE 1: Event Detection Transformer")
    print("=" * 70)
    print(f"Device: {cfg.device}")
    print(f"Epochs: {cfg.epochs}, LR: {cfg.lr}, Batch: {cfg.batch_size}")
    print(f"Horizons: {horizons}")
    print()

    with open(outdir / "config.json", "w") as f:
        json.dump(asdict(cfg), f, indent=2)

    device = torch.device(cfg.device)

    # Load sensor windows ONCE (same for all horizons)
    X_train_base = torch.from_numpy(np.load(data_dir / "X_train.npy"))
    X_val_base   = torch.from_numpy(np.load(data_dir / "X_val.npy"))

    # Collect event labels for each horizon
    ev_train_parts, ev_val_parts = [], []
    for h in horizons:
        suffix = "" if h == 0 else f"_h{h}"
        ev_train_parts.append(torch.from_numpy(np.load(data_dir / f"ev_train{suffix}.npy")))
        ev_val_parts.append(torch.from_numpy(np.load(data_dir / f"ev_val{suffix}.npy")))

    if len(horizons) == 1:
        X_train  = X_train_base
        ev_train = ev_train_parts[0]
        X_val    = X_val_base
        ev_val   = ev_val_parts[0]
    else:
        X_train  = torch.cat([X_train_base] * len(horizons), dim=0)
        ev_train = torch.cat(ev_train_parts)
        X_val    = torch.cat([X_val_base]   * len(horizons), dim=0)
        ev_val   = torch.cat(ev_val_parts)
        perm = torch.randperm(len(X_train), generator=torch.Generator().manual_seed(42))
        X_train  = X_train[perm]
        ev_train = ev_train[perm]

    print(f"Train: {X_train.shape[0]} windows, Val: {X_val.shape[0]} windows")
    print(f"Train event ratio: {ev_train.float().mean():.2%}")

    # Optional: resample training set to a target event ratio.
    balance_ratio = getattr(args, "balance_ratio", None)
    if balance_ratio is not None:
        target = float(balance_ratio)
        ev_idx  = torch.where(ev_train == 1)[0]
        nev_idx = torch.where(ev_train == 0)[0]
        n_ev  = len(ev_idx)
        n_nev = len(nev_idx)
        n_nev_if_ev_kept  = int(n_ev  * (1.0 - target) / max(target, 1e-9))
        n_ev_if_nev_kept  = int(n_nev * target          / max(1.0 - target, 1e-9))
        if n_nev_if_ev_kept <= n_nev:
            n_ev_sampled  = n_ev
            n_nev_sampled = n_nev_if_ev_kept
        else:
            n_nev_sampled = n_nev
            n_ev_sampled  = min(n_ev, n_ev_if_nev_kept)
        perm_ev  = torch.randperm(n_ev,  generator=torch.Generator().manual_seed(42))
        perm_nev = torch.randperm(n_nev, generator=torch.Generator().manual_seed(42))
        ev_sampled  = ev_idx[perm_ev[:n_ev_sampled]]
        nev_sampled = nev_idx[perm_nev[:n_nev_sampled]]
        all_idx = torch.cat([ev_sampled, nev_sampled])
        all_idx = all_idx[torch.randperm(len(all_idx), generator=torch.Generator().manual_seed(42))]
        X_train  = X_train[all_idx]
        ev_train = ev_train[all_idx]
        print(f"Rebalanced train: {len(X_train)} windows, event ratio: {ev_train.float().mean():.2%}")

    model = EventTransformer(cfg.input_dim, cfg).to(device)
    optimizer = torch.optim.AdamW(model.parameters(), lr=cfg.lr, weight_decay=1e-4)
    scheduler = CosineAnnealingLR(optimizer, T_max=cfg.epochs)
    criterion = FocalLoss(gamma=cfg.focal_gamma, alpha=cfg.focal_alpha)

    train_ds = TensorDataset(X_train, ev_train)
    val_ds = TensorDataset(X_val, ev_val)
    train_dl = DataLoader(train_ds, batch_size=cfg.batch_size, shuffle=True, drop_last=False)
    val_dl = DataLoader(val_ds, batch_size=cfg.batch_size, shuffle=False)

    best_f1 = 0.0
    best_state = None

    for epoch in range(1, cfg.epochs + 1):
        model.train()
        total_loss = 0.0
        n_batches = 0
        for xb, yb in train_dl:
            xb, yb = xb.to(device), yb.to(device)
            logits = model(xb)
            loss = criterion(logits, yb)
            optimizer.zero_grad()
            loss.backward()
            nn.utils.clip_grad_norm_(model.parameters(), 1.0)
            optimizer.step()
            total_loss += loss.item()
            n_batches += 1
        scheduler.step()

        model.eval()
        all_preds, all_targets = [], []
        with torch.no_grad():
            for xb, yb in val_dl:
                xb = xb.to(device)
                logits = model(xb)
                preds = logits.argmax(dim=1).cpu().numpy()
                all_preds.append(preds)
                all_targets.append(yb.numpy())

        preds = np.concatenate(all_preds)
        targets = np.concatenate(all_targets)
        metrics = compute_metrics(preds, targets, 2, ["no_event", "event"])
        avg_loss = total_loss / max(n_batches, 1)
        print(f"  Epoch {epoch:3d}/{cfg.epochs} | Loss: {avg_loss:.4f} | Acc: {metrics['accuracy']:.4f} | F1: {metrics['macro_f1']:.4f}")

        if metrics["macro_f1"] > best_f1:
            best_f1 = metrics["macro_f1"]
            best_state = {k: v.cpu().clone() for k, v in model.state_dict().items()}

    if best_state:
        model.load_state_dict(best_state)

    checkpoint = {
        "model_state": model.state_dict(),
        "config": asdict(cfg),
        "best_val_f1": best_f1,
    }
    model_fname = "stage1.pt" if h == 0 else f"stage1_h{h}.pt"
    torch.save(checkpoint, outdir / model_fname)

    # Final evaluation on val
    model.eval()
    all_preds, all_targets = [], []
    with torch.no_grad():
        for xb, yb in val_dl:
            xb = xb.to(device)
            preds = model(xb).argmax(dim=1).cpu().numpy()
            all_preds.append(preds)
            all_targets.append(yb.numpy())

    final_metrics = compute_metrics(
        np.concatenate(all_preds), np.concatenate(all_targets),
        2, ["no_event", "event"],
    )
    metrics_fname = "metrics_stage1.json" if h == 0 else f"metrics_stage1_h{h}.json"
    with open(outdir / metrics_fname, "w") as f:
        json.dump(final_metrics, f, indent=2)

    print(f"  Best val F1: {best_f1:.4f}  → {model_fname}")

    print(f"\nSaved to {outdir}/")
    print("[OK] Stage 1 training complete!")


# ---------------------------------------------------------------------------
# Command: train-stage2
# ---------------------------------------------------------------------------

def cmd_train_stage2(args: argparse.Namespace) -> None:
    data_dir = Path(args.data_dir)
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    with open(data_dir / "config.json") as f:
        cfg_dict = json.load(f)
    cfg = TwoStageConfig(**{k: v for k, v in cfg_dict.items() if k in TwoStageConfig.__dataclass_fields__})
    cfg.epochs = args.epochs
    cfg.lr = args.lr
    cfg.batch_size = args.batch_size

    # Parse horizon steps
    _hs_raw = getattr(args, "horizon_steps", None)
    if isinstance(_hs_raw, list):
        horizons = sorted(set(int(h) for h in _hs_raw)) if _hs_raw else [0]
    elif _hs_raw is not None:
        horizons = [int(_hs_raw)]
    else:
        horizons = [0]

    # Load dataset stats for label names
    with open(data_dir / "dataset_stats.json") as f:
        stats = json.load(f)
    goal_labels = stats.get("goal_labels", [f"goal_{i}" for i in range(cfg.n_goal_classes)])
    stimuli_labels = stats.get("stimuli_labels", [f"stim_{i}" for i in range(cfg.n_stimuli_classes)])

    print("=" * 70)
    print("STAGE 2: Goal/Stimuli Classification Transformer")
    print("=" * 70)
    print(f"Device: {cfg.device}")
    print(f"Epochs: {cfg.epochs}, LR: {cfg.lr}, Batch: {cfg.batch_size}")
    print(f"Horizons: {horizons}")
    print()

    with open(outdir / "config.json", "w") as f:
        json.dump(asdict(cfg), f, indent=2)

    device = torch.device(cfg.device)

    # Load sensor windows ONCE
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

    # Filter to event windows only (Stage 2 trains only on events)
    train_event_mask = ev_train == 1
    val_event_mask = ev_val == 1

    X_train_ev = X_train[train_event_mask]
    g_train_ev = g_train[train_event_mask]
    s_train_ev = s_train[train_event_mask]
    X_val_ev = X_val[val_event_mask]
    g_val_ev = g_val[val_event_mask]
    s_val_ev = s_val[val_event_mask]

    print(f"Train event windows: {len(X_train_ev)} / {len(X_train)}")
    print(f"Val event windows:   {len(X_val_ev)} / {len(X_val)}")

    if len(X_train_ev) == 0:
        print(f"[WARN] No event windows — skipping Stage 2 training")
        return

    goal_weights = compute_class_weights(g_train_ev, cfg.n_goal_classes)
    stimuli_weights = compute_class_weights(s_train_ev, cfg.n_stimuli_classes)

    model = ClassificationTransformer(cfg.input_dim, cfg).to(device)
    optimizer = torch.optim.AdamW(model.parameters(), lr=cfg.lr, weight_decay=1e-4)
    scheduler = CosineAnnealingLR(optimizer, T_max=cfg.epochs)

    goal_criterion = nn.CrossEntropyLoss(weight=goal_weights.to(device), reduction="none")
    stimuli_criterion = nn.CrossEntropyLoss(weight=stimuli_weights.to(device), reduction="none")

    X_train_t = torch.from_numpy(X_train_ev)
    g_train_t = torch.from_numpy(g_train_ev)
    s_train_t = torch.from_numpy(s_train_ev)
    X_val_t = torch.from_numpy(X_val_ev)
    g_val_t = torch.from_numpy(g_val_ev)
    s_val_t = torch.from_numpy(s_val_ev)

    train_ds = TensorDataset(X_train_t, g_train_t, s_train_t)
    val_ds = TensorDataset(X_val_t, g_val_t, s_val_t)
    train_dl = DataLoader(train_ds, batch_size=cfg.batch_size, shuffle=True, drop_last=False)
    val_dl = DataLoader(val_ds, batch_size=cfg.batch_size, shuffle=False)

    best_f1 = 0.0
    best_state = None

    for epoch in range(1, cfg.epochs + 1):
        model.train()
        total_loss = 0.0
        n_batches = 0

        for xb, gb, sb in train_dl:
            xb, gb, sb = xb.to(device), gb.to(device), sb.to(device)
            goal_logits, stimuli_logits = model(xb)

            goal_loss_raw = goal_criterion(goal_logits, gb)
            stimuli_loss_raw = stimuli_criterion(stimuli_logits, sb)

            goal_mask = gb != 0
            stimuli_mask = sb != 0

            goal_loss = goal_loss_raw[goal_mask].mean() if goal_mask.any() else torch.tensor(0.0, device=device)
            stimuli_loss = stimuli_loss_raw[stimuli_mask].mean() if stimuli_mask.any() else torch.tensor(0.0, device=device)
            goal_loss_bg = goal_loss_raw[~goal_mask].mean() if (~goal_mask).any() else torch.tensor(0.0, device=device)
            stimuli_loss_bg = stimuli_loss_raw[~stimuli_mask].mean() if (~stimuli_mask).any() else torch.tensor(0.0, device=device)

            loss = goal_loss + stimuli_loss + 0.1 * (goal_loss_bg + stimuli_loss_bg)

            optimizer.zero_grad()
            loss.backward()
            nn.utils.clip_grad_norm_(model.parameters(), 1.0)
            optimizer.step()
            total_loss += loss.item()
            n_batches += 1

        scheduler.step()

        model.eval()
        g_preds, g_targets, s_preds, s_targets = [], [], [], []
        with torch.no_grad():
            for xb, gb, sb in val_dl:
                xb = xb.to(device)
                gl, sl = model(xb)
                g_preds.append(gl.argmax(1).cpu().numpy())
                s_preds.append(sl.argmax(1).cpu().numpy())
                g_targets.append(gb.numpy())
                s_targets.append(sb.numpy())

        g_preds = np.concatenate(g_preds) if g_preds else np.array([])
        g_targets = np.concatenate(g_targets) if g_targets else np.array([])
        s_preds = np.concatenate(s_preds) if s_preds else np.array([])
        s_targets = np.concatenate(s_targets) if s_targets else np.array([])

        g_metrics = compute_metrics(g_preds, g_targets, cfg.n_goal_classes, goal_labels) if len(g_targets) > 0 else {"macro_f1": 0.0}
        s_metrics = compute_metrics(s_preds, s_targets, cfg.n_stimuli_classes, stimuli_labels) if len(s_targets) > 0 else {"macro_f1": 0.0}

        combined_f1 = (g_metrics["macro_f1"] + s_metrics["macro_f1"]) / 2
        avg_loss = total_loss / max(n_batches, 1)
        print(f"  Epoch {epoch:3d}/{cfg.epochs} | Loss: {avg_loss:.4f} | Goal-F1: {g_metrics['macro_f1']:.4f} | Stim-F1: {s_metrics['macro_f1']:.4f} | Avg-F1: {combined_f1:.4f}")

        if combined_f1 > best_f1:
            best_f1 = combined_f1
            best_state = {k: v.cpu().clone() for k, v in model.state_dict().items()}

    if best_state:
        model.load_state_dict(best_state)

    checkpoint = {
        "model_state": model.state_dict(),
        "config": asdict(cfg),
        "best_val_f1": best_f1,
    }
    model_fname2 = "stage2.pt" if h == 0 else f"stage2_h{h}.pt"
    torch.save(checkpoint, outdir / model_fname2)

    # Final metrics
    model.eval()
    g_preds, g_targets, s_preds, s_targets = [], [], [], []
    with torch.no_grad():
        for xb, gb, sb in val_dl:
            xb = xb.to(device)
            gl, sl = model(xb)
            g_preds.append(gl.argmax(1).cpu().numpy())
            s_preds.append(sl.argmax(1).cpu().numpy())
            g_targets.append(gb.numpy())
            s_targets.append(sb.numpy())

    g_preds = np.concatenate(g_preds) if g_preds else np.array([])
    g_targets = np.concatenate(g_targets) if g_targets else np.array([])
    s_preds = np.concatenate(s_preds) if s_preds else np.array([])
    s_targets = np.concatenate(s_targets) if s_targets else np.array([])

    final_metrics = {
        "goal": compute_metrics(g_preds, g_targets, cfg.n_goal_classes, goal_labels) if len(g_targets) > 0 else {},
        "stimuli": compute_metrics(s_preds, s_targets, cfg.n_stimuli_classes, stimuli_labels) if len(s_targets) > 0 else {},
        "combined_f1": best_f1,
    }
    metrics_fname2 = "metrics_stage2.json" if h == 0 else f"metrics_stage2_h{h}.json"
    with open(outdir / metrics_fname2, "w") as f:
        json.dump(final_metrics, f, indent=2)

    print(f"  Best combined F1: {best_f1:.4f}  → {model_fname2}")

    print(f"\nSaved to {outdir}/")
    print("[OK] Stage 2 training complete!")



# ---------------------------------------------------------------------------
# Command: predict
# ---------------------------------------------------------------------------

def cmd_predict(args: argparse.Namespace) -> None:
    data_dir = Path(args.data_dir)
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    with open(data_dir / "config.json") as f:
        cfg_dict = json.load(f)
    cfg = TwoStageConfig(**{k: v for k, v in cfg_dict.items() if k in TwoStageConfig.__dataclass_fields__})

    with open(data_dir / "dataset_stats.json") as f:
        stats = json.load(f)
    goal_labels = stats.get("goal_labels", [f"goal_{i}" for i in range(cfg.n_goal_classes)])
    stimuli_labels = stats.get("stimuli_labels", [f"stim_{i}" for i in range(cfg.n_stimuli_classes)])

    device = torch.device(cfg.device)
    event_threshold = getattr(args, "event_threshold", 0.5)
    horizons_arg = getattr(args, "horizons", None)

    # ---- Multi-horizon mode ----
    # ONE model is loaded; inference runs ONCE; GT labels are swapped per horizon.
    if horizons_arg:
        horizons = sorted(set(horizons_arg))
        print("=" * 70)
        print("TWO-STAGE TRANSFORMER - Multi-Horizon Evaluation")
        print("=" * 70)
        print(f"Model S1: {args.stage1_model}")
        print(f"Model S2: {args.stage2_model}")
        print(f"Horizons:        {horizons}")
        print(f"Event threshold: {event_threshold}")
        print()

        # Load Stage 1 model ONCE
        s1_ckpt = torch.load(args.stage1_model, map_location=device, weights_only=False)
        s1_model = EventTransformer(cfg.input_dim, cfg).to(device)
        s1_model.load_state_dict(s1_ckpt["model_state"])
        s1_model.eval()

        # Load Stage 2 model ONCE
        s2_ckpt = torch.load(args.stage2_model, map_location=device, weights_only=False)
        s2_model = ClassificationTransformer(cfg.input_dim, cfg).to(device)
        s2_model.load_state_dict(s2_ckpt["model_state"])
        s2_model.eval()

        # Load X_test ONCE
        X_test_np = np.load(data_dir / "X_test.npy")
        X_test = torch.from_numpy(X_test_np)
        test_dl = DataLoader(TensorDataset(X_test), batch_size=cfg.batch_size, shuffle=False)

        # Run Stage 1 inference ONCE
        ev_probs_list: List[np.ndarray] = []
        with torch.no_grad():
            for (xb,) in test_dl:
                xb = xb.to(device)
                logits = s1_model(xb)
                probs = torch.softmax(logits, dim=1)[:, 1]
                ev_probs_list.append(probs.cpu().numpy())
        ev_probs = np.concatenate(ev_probs_list)
        ev_preds = (ev_probs >= event_threshold).astype(np.int64)

        # Run Stage 2 on predicted events ONCE
        event_mask = ev_preds == 1
        n_pred = int(event_mask.sum())
        if n_pred > 0:
            X_ev = X_test[event_mask]
            event_dl = DataLoader(TensorDataset(X_ev), batch_size=cfg.batch_size, shuffle=False)
            g_ev_list: List[np.ndarray] = []
            s_ev_list: List[np.ndarray] = []
            with torch.no_grad():
                for (xb,) in event_dl:
                    xb = xb.to(device)
                    gl, sl = s2_model(xb)
                    g_ev_list.append(gl.argmax(1).cpu().numpy())
                    s_ev_list.append(sl.argmax(1).cpu().numpy())
            g_preds_ev = np.concatenate(g_ev_list)
            s_preds_ev = np.concatenate(s_ev_list)
        else:
            g_preds_ev = s_preds_ev = np.array([], dtype=np.int64)

        # Run Stage 2 on ALL test windows ONCE (for oracle evaluation per horizon)
        all_dl = DataLoader(TensorDataset(X_test), batch_size=cfg.batch_size, shuffle=False)
        g_all_list: List[np.ndarray] = []
        s_all_list: List[np.ndarray] = []
        with torch.no_grad():
            for (xb,) in all_dl:
                xb = xb.to(device)
                gl, sl = s2_model(xb)
                g_all_list.append(gl.argmax(1).cpu().numpy())
                s_all_list.append(sl.argmax(1).cpu().numpy())
        g_preds_all = np.concatenate(g_all_list)
        s_preds_all = np.concatenate(s_all_list)

        all_results: Dict[str, dict] = {}
        print(f"\n{'Horizon':>8} | {'GT events':>9} | {'S1 F1':>6} | {'Goal F1':>7} | {'Stim F1':>7} | {'G Oracle':>8} | {'S Oracle':>8}")
        print("-" * 75)

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
                g_oracle: dict = {}
                s_oracle: dict = {}

            result = {
                "horizon_steps":               h,
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
            all_results[str(h)] = result
            with open(outdir / f"metrics_combined_h{h}.json", "w") as f:
                json.dump(result, f, indent=2)

            s1f1 = ev_metrics["macro_f1"]
            gf1  = g_metrics["macro_f1"]
            sf1  = s_metrics["macro_f1"]
            gora = g_oracle.get("macro_f1", 0.0) if g_oracle else 0.0
            sora = s_oracle.get("macro_f1", 0.0) if s_oracle else 0.0
            print(f"{h:>8} | {int(gt_mask.sum()):>9} | {s1f1:>6.4f} | {gf1:>7.4f} | {sf1:>7.4f} | {gora:>8.4f} | {sora:>8.4f}")

        with open(outdir / "metrics_all_horizons.json", "w") as f:
            json.dump(all_results, f, indent=2)

        print(f"\nSaved to {outdir}/")
        print("[OK] Multi-horizon evaluation complete!")
        return

    # ---- Single-horizon mode (original behavior) ----
    print("=" * 70)
    print("TWO-STAGE PREDICTION (End-to-End)")
    print("=" * 70)

    # Load models
    s1_ckpt = torch.load(args.stage1_model, map_location=device, weights_only=False)
    s1_model = EventTransformer(cfg.input_dim, cfg).to(device)
    s1_model.load_state_dict(s1_ckpt["model_state"])
    s1_model.eval()

    s2_ckpt = torch.load(args.stage2_model, map_location=device, weights_only=False)
    s2_model = ClassificationTransformer(cfg.input_dim, cfg).to(device)
    s2_model.load_state_dict(s2_ckpt["model_state"])
    s2_model.eval()

    # Load test data
    X_test = torch.from_numpy(np.load(data_dir / "X_test.npy"))
    ev_test = np.load(data_dir / "ev_test.npy")
    g_test = np.load(data_dir / "g_test.npy")
    s_test = np.load(data_dir / "s_test.npy")

    print(f"Test windows: {len(X_test)}")
    print(f"Test event ratio: {ev_test.mean():.2%}")

    # Stage 1: event detection
    print("\n--- Stage 1: Event Detection ---")
    if event_threshold != 0.5:
        print(f"  [event-threshold={event_threshold:.2f}  (weakened gate)]")
    test_dl = DataLoader(TensorDataset(X_test), batch_size=cfg.batch_size, shuffle=False)

    ev_probs_list = []
    with torch.no_grad():
        for (xb,) in test_dl:
            xb = xb.to(device)
            logits = s1_model(xb)
            probs = torch.softmax(logits, dim=1)[:, 1]   # P(event)
            ev_probs_list.append(probs.cpu().numpy())
    ev_probs = np.concatenate(ev_probs_list)
    ev_preds = (ev_probs >= event_threshold).astype(np.int64)

    ev_metrics = compute_metrics(ev_preds, ev_test, 2, ["no_event", "event"])
    print(f"Event detection: Acc={ev_metrics['accuracy']:.4f}, F1={ev_metrics['macro_f1']:.4f}")
    print(f"  Per-class: {json.dumps(ev_metrics['per_class'], indent=2)}")

    # Stage 2: classification on predicted events
    print("\n--- Stage 2: Goal/Stimuli Classification ---")
    event_mask = ev_preds == 1
    n_predicted_events = event_mask.sum()
    print(f"Predicted events: {n_predicted_events} / {len(ev_preds)}")

    if n_predicted_events > 0:
        X_events = X_test[event_mask]
        g_events_gt = g_test[event_mask]
        s_events_gt = s_test[event_mask]

        event_dl = DataLoader(TensorDataset(X_events), batch_size=cfg.batch_size, shuffle=False)
        g_preds, s_preds = [], []
        with torch.no_grad():
            for (xb,) in event_dl:
                xb = xb.to(device)
                gl, sl = s2_model(xb)
                g_preds.append(gl.argmax(1).cpu().numpy())
                s_preds.append(sl.argmax(1).cpu().numpy())

        g_preds = np.concatenate(g_preds)
        s_preds = np.concatenate(s_preds)

        g_metrics = compute_metrics(g_preds, g_events_gt, cfg.n_goal_classes, goal_labels)
        s_metrics = compute_metrics(s_preds, s_events_gt, cfg.n_stimuli_classes, stimuli_labels)

        print(f"\nGoal classification (on predicted events):")
        print(f"  Acc: {g_metrics['accuracy']:.4f}, Macro-F1: {g_metrics['macro_f1']:.4f}")
        print(f"\nStimuli classification (on predicted events):")
        print(f"  Acc: {s_metrics['accuracy']:.4f}, Macro-F1: {s_metrics['macro_f1']:.4f}")
    else:
        g_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}
        s_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}
        print("  No events predicted - skipping Stage 2 evaluation")

    # Also evaluate on ground-truth events (oracle upper bound)
    print("\n--- Oracle: Stage 2 on ground-truth events ---")
    gt_event_mask = ev_test == 1
    if gt_event_mask.sum() > 0:
        X_gt_events = X_test[gt_event_mask]
        g_gt = g_test[gt_event_mask]
        s_gt = s_test[gt_event_mask]

        oracle_dl = DataLoader(TensorDataset(X_gt_events), batch_size=cfg.batch_size, shuffle=False)
        g_oracle, s_oracle = [], []
        with torch.no_grad():
            for (xb,) in oracle_dl:
                xb = xb.to(device)
                gl, sl = s2_model(xb)
                g_oracle.append(gl.argmax(1).cpu().numpy())
                s_oracle.append(sl.argmax(1).cpu().numpy())

        g_oracle = np.concatenate(g_oracle)
        s_oracle = np.concatenate(s_oracle)
        g_oracle_metrics = compute_metrics(g_oracle, g_gt, cfg.n_goal_classes, goal_labels)
        s_oracle_metrics = compute_metrics(s_oracle, s_gt, cfg.n_stimuli_classes, stimuli_labels)
        print(f"  Goal (oracle):    Macro-F1: {g_oracle_metrics['macro_f1']:.4f}")
        print(f"  Stimuli (oracle): Macro-F1: {s_oracle_metrics['macro_f1']:.4f}")
    else:
        g_oracle_metrics = {}
        s_oracle_metrics = {}

    # Save results
    combined = {
        "event_detection": ev_metrics,
        "goal_on_predicted_events": g_metrics,
        "stimuli_on_predicted_events": s_metrics,
        "goal_oracle": g_oracle_metrics,
        "stimuli_oracle": s_oracle_metrics,
        "n_test_windows": len(ev_test),
        "n_predicted_events": int(n_predicted_events),
        "n_gt_events": int(gt_event_mask.sum()),
        "event_threshold": event_threshold,
    }

    # --- Area breakdown (optional) ---
    if getattr(args, "breakdown_by_area", False):
        # Resolve paths: CLI args override, else fall back to dataset_stats
        sensor_dir_str = args.sensor_dir or stats.get("sensor_dir")
        eaf_parsed_dir_str = args.eaf_parsed_dir or stats.get("eaf_parsed_dir")
        vocab_dir_str = args.vocab_dir or stats.get("vocab_dir")

        if not sensor_dir_str or not eaf_parsed_dir_str or not vocab_dir_str:
            print("\n[WARN] --breakdown-by-area requires sensor_dir, eaf_parsed_dir, vocab_dir.")
            print("       Re-run prepare to save paths, or pass them explicitly.")
        else:
            print("\n--- Area Breakdown ---")
            area_labels = build_area_labels_for_test(
                sensor_dir=Path(sensor_dir_str),
                eaf_parsed_dir=Path(eaf_parsed_dir_str),
                vocab_dir=Path(vocab_dir_str),
                test_day=stats.get("test_day", ""),
                sample_hz=cfg.sample_hz,
                window_len=cfg.window_len,
                stride_len=cfg.stride_len,
            )

            if len(area_labels) != len(ev_test):
                print(f"  [WARN] Area labels ({len(area_labels)}) != test windows ({len(ev_test)}). Skipping breakdown.")
            else:
                per_area = {}
                for area_idx, area_name in enumerate(AREA_NAMES):
                    mask = area_labels == area_idx
                    n_windows = int(mask.sum())
                    if n_windows == 0:
                        per_area[area_name] = {"n_windows": 0, "note": "no windows for this area"}
                        continue

                    area_ev_preds = ev_preds[mask]
                    area_ev_gt = ev_test[mask]
                    area_g_gt = g_test[mask]
                    area_s_gt = s_test[mask]

                    area_ev_metrics = compute_metrics(area_ev_preds, area_ev_gt, 2, ["no_event", "event"])

                    # Stage 2 on predicted events within this area
                    area_event_mask = area_ev_preds == 1
                    area_n_pred_events = int(area_event_mask.sum())

                    if area_n_pred_events > 0:
                        X_area_events = X_test[mask][area_event_mask]
                        g_area_gt = area_g_gt[area_event_mask]
                        s_area_gt = area_s_gt[area_event_mask]

                        area_event_dl = DataLoader(TensorDataset(X_area_events), batch_size=cfg.batch_size, shuffle=False)
                        g_a_preds, s_a_preds = [], []
                        with torch.no_grad():
                            for (xb,) in area_event_dl:
                                xb = xb.to(device)
                                gl, sl = s2_model(xb)
                                g_a_preds.append(gl.argmax(1).cpu().numpy())
                                s_a_preds.append(sl.argmax(1).cpu().numpy())
                        g_a_preds = np.concatenate(g_a_preds)
                        s_a_preds = np.concatenate(s_a_preds)

                        g_area_metrics = compute_metrics(g_a_preds, g_area_gt, cfg.n_goal_classes, goal_labels)
                        s_area_metrics = compute_metrics(s_a_preds, s_area_gt, cfg.n_stimuli_classes, stimuli_labels)
                    else:
                        g_area_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}
                        s_area_metrics = {"accuracy": 0, "macro_f1": 0, "per_class": {}}

                    per_area[area_name] = {
                        "n_windows": n_windows,
                        "n_events_gt": int(area_ev_gt.sum()),
                        "n_events_predicted": area_n_pred_events,
                        "event_detection": area_ev_metrics,
                        "goal": g_area_metrics,
                        "stimuli": s_area_metrics,
                    }

                    print(f"\n  [{area_name.upper()}] ({n_windows} windows, {int(area_ev_gt.sum())} GT events)")
                    print(f"    Event F1: {area_ev_metrics['macro_f1']:.4f}")
                    if area_n_pred_events > 0:
                        print(f"    Goal Macro-F1:    {g_area_metrics['macro_f1']:.4f}")
                        print(f"    Stimuli Macro-F1: {s_area_metrics['macro_f1']:.4f}")

                combined["per_area"] = per_area

    with open(outdir / "metrics_combined.json", "w") as f:
        json.dump(combined, f, indent=2)

    print(f"\nSaved to {outdir}/metrics_combined.json")
    print("[OK] Prediction complete!")


# ---------------------------------------------------------------------------
# Command: run  (full pipeline in one shot)
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# CLI
# ---------------------------------------------------------------------------

def main():
    parser = argparse.ArgumentParser(
        description="Two-Stage Transformer: Event Detection + Goal/Stimuli Classification"
    )
    sub = parser.add_subparsers(dest="cmd")

    # prepare
    p = sub.add_parser("prepare", help="Build windowed dataset from prealigned sensors + EAF")
    p.add_argument("--sensor-dir", required=True, help="Dir with prealigned sensor .npy files")
    p.add_argument("--eaf-parsed-dir", required=True, help="Dir with parsed EAF .json files")
    p.add_argument("--vocab-dir", required=True, help="Dir with vocab_goal.json and vocab_stimuli.json")
    p.add_argument("--output-dir", required=True, help="Output directory")
    p.add_argument("--sample-hz", type=float, default=3.0)
    p.add_argument("--window-sec", type=float, default=5.0)
    p.add_argument("--stride-sec", type=float, default=1.0)
    p.add_argument("--event-ratio", type=float, default=0.7, help="Target event ratio after balancing")
    p.add_argument("--horizons", nargs="+", type=int, default=[0], metavar="H",
                   help="Prediction horizons in steps (e.g. 0 1 2 3 6 9 12 15). Default: [0].")
    p.set_defaults(func=cmd_prepare)

    # train-stage1
    p = sub.add_parser("train-stage1", help="Train Event Detection Transformer")
    p.add_argument("--data-dir", required=True, help="Prepared dataset directory")
    p.add_argument("--outdir", required=True, help="Output directory for model")
    p.add_argument("--epochs", type=int, default=30)
    p.add_argument("--lr", type=float, default=1e-4)
    p.add_argument("--batch-size", type=int, default=32)
    p.add_argument("--balance-ratio", type=float, default=None, metavar="R",
                   help="Resample training windows to this event ratio (e.g. 0.5 for 50/50). "
                        "Undersamples no-event windows deterministically. Default: no resampling.")
    p.add_argument("--horizon-steps", nargs="+", type=int, default=[0], metavar="H",
                   help="Horizon(s) in steps ahead. One model trained on all combined. "
                        "E.g.: --horizon-steps 0 1 2 3 6 9 12 15. Default: 0.")
    p.set_defaults(func=cmd_train_stage1)

    # train-stage2
    p = sub.add_parser("train-stage2", help="Train Goal/Stimuli Classification Transformer")
    p.add_argument("--data-dir", required=True, help="Prepared dataset directory")
    p.add_argument("--stage1-model", required=True, help="Path to stage1.pt (not used for training, kept for API consistency)")
    p.add_argument("--outdir", required=True, help="Output directory for model")
    p.add_argument("--epochs", type=int, default=30)
    p.add_argument("--lr", type=float, default=1e-4)
    p.add_argument("--batch-size", type=int, default=32)
    p.add_argument("--horizon-steps", nargs="+", type=int, default=[0], metavar="H",
                   help="Horizon(s) in steps ahead. One model trained on all combined. "
                        "E.g.: --horizon-steps 0 1 2 3 6 9 12 15. Default: 0.")
    p.set_defaults(func=cmd_train_stage2)

    # predict
    p = sub.add_parser("predict", help="End-to-end two-stage prediction")
    p.add_argument("--data-dir", required=True, help="Prepared dataset directory")
    p.add_argument("--stage1-model", required=True, help="Path to stage1.pt")
    p.add_argument("--stage2-model", required=True, help="Path to stage2.pt")
    p.add_argument("--outdir", required=True, help="Output directory for predictions")
    p.add_argument("--breakdown-by-area", action="store_true", help="Compute per-area metrics (downtown/freeway/tunnel)")
    p.add_argument("--sensor-dir", default=None, help="Dir with prealigned sensor .npy files (required for --breakdown-by-area)")
    p.add_argument("--eaf-parsed-dir", default=None, help="Dir with parsed EAF .json files (required for --breakdown-by-area)")
    p.add_argument("--vocab-dir", default=None, help="Dir with vocab_area.json (required for --breakdown-by-area)")
    p.add_argument("--event-threshold", type=float, default=0.5, metavar="T",
                   help="P(event) threshold for Stage 1 gate (default: 0.5 = argmax). "
                        "Lower values (e.g. 0.30) weaken the gate and pass more windows to Stage 2.")
    p.add_argument("--horizons", nargs="+", type=int, default=None, metavar="H",
                   help="Multi-horizon evaluation: list of steps (e.g. 0 1 2 3 6 9 12 15). "
                        "If given, runs eval for each h and prints a summary table.")
    p.set_defaults(func=cmd_predict)

    args = parser.parse_args()
    if not hasattr(args, "func"):
        parser.print_help()
        sys.exit(1)
    args.func(args)


if __name__ == "__main__":
    main()
