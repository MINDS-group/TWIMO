#!/usr/bin/env python
"""Annotate driving video(s) with EAF two-stage predictions (always-on panel).

Panel layout – always visible on every frame:
┌──────────────────────┬──────────────────────────────┬──────────────────┐
│  EAF LABELS (GT)     │  PREDICTIONS (multi-horizon) │  SENSORS         │
│  Cause:  red_light   │  Horiz │ Event │ Goal │ Stim  │  Spd  45.2 km/h │
│  Attn:   red_light   │  1 s   │  ●    │ left │ stop4 │  Str  +2.1 deg  │
│  Goal:   left_turn   │  3 s   │  ●    │ left │ stop4 │  Brk  450 kPa   │
│  Stim:   stop_4_lt   │  5 s   │  ○    │  –   │  –    │  Acc  5 %       │
│                      │  WHY: Due to red light …     │  Yaw  +0.3      │
└──────────────────────┴──────────────────────────────┴──────────────────┘

Two-stage EAF pipeline
----------------------
• Stage 1 (EventTransformer)     – binary: event / no-event
• Stage 2 (ClassificationTransformer) – Goal (14 cls) + Stimuli (9 cls)

Multi-horizon prediction:
  For horizon h s, the model reads the sensor window that ENDS at the sensor
  step h seconds ahead of the current frame.  All windows are pre-computed
  in batch at the start, so per-frame look-up is O(1).

Ground-truth EAF labels (left column):
  Loaded from parsed EAF JSON files (--eaf-parsed-dir).
  Tiers used: Cause, Attention, Goal, Stimuli.
  Shows the annotator-labelled value at the current video timestamp.

Requirements: ffmpeg on PATH, OpenCV, PyTorch, numpy.

Usage
-----
python twimo/plots/annotate_video_eaf.py \\
    --manifest ./artifacts/manifest.jsonl \\
    --stage1-model ./artifacts/eaf/two_stage/stage1_event/stage1.pt \\
    --stage2-model ./artifacts/eaf/two_stage/stage2_classify/stage2.pt \\
    --data-dir     ./artifacts/eaf/two_stage/data \\
    --vocab-dir    ./artifacts/eaf/vocabs \\
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
    --eaf-parsed-dir ./artifacts/eaf/parsed \\
    --outdir   ./artifacts/annotated_eaf \\
    --session  201702271017
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
from dataclasses import dataclass
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent.parent.parent))

from typing import Dict, List, Optional, Tuple

import cv2
import numpy as np
import pandas as pd
import torch
import torch.nn as nn
import torch.nn.functional as F

from twimo.strategies_eaf.two_stage_yolo import _compute_sensor_video_offset
from twimo.utils.profiling import TrainingProfiler


# ──────────────────────────────────────────────────────────────────────────────
# Model definitions (self-contained copy from two_stage_transformer.py)
# ──────────────────────────────────────────────────────────────────────────────

@dataclass
class TwoStageConfig:
    window_sec:        float = 5.0
    stride_sec:        float = 1.0
    sample_hz:         float = 3.0
    d_model:           int   = 128
    nhead:             int   = 4
    num_layers:        int   = 3
    dim_ff:            int   = 256
    dropout:           float = 0.1
    batch_size:        int   = 32
    epochs:            int   = 30
    lr:                float = 1e-4
    focal_gamma:       float = 2.0
    focal_alpha:       float = 0.75
    event_ratio:       float = 0.7
    n_goal_classes:    int   = 14
    n_stimuli_classes: int   = 9
    input_dim:         int   = 8
    window_len:        int   = 15
    stride_len:        int   = 3
    device:            str   = ""

    def __post_init__(self):
        self.window_len = int(self.window_sec * self.sample_hz)
        self.stride_len = int(self.stride_sec * self.sample_hz)
        if not self.device:
            self.device = "cuda" if torch.cuda.is_available() else "cpu"


class _AttentionPooling(nn.Module):
    def __init__(self, d: int):
        super().__init__()
        self.query = nn.Parameter(torch.randn(d))

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        w = F.softmax(torch.einsum("btd,d->bt", x, self.query), dim=1).unsqueeze(-1)
        return (x * w).sum(dim=1)


class _EventTransformer(nn.Module):
    def __init__(self, input_dim: int, cfg: TwoStageConfig):
        super().__init__()
        self.proj    = nn.Linear(input_dim, cfg.d_model)
        self.pos_emb = nn.Embedding(cfg.window_len, cfg.d_model)
        enc          = nn.TransformerEncoderLayer(
            d_model=cfg.d_model, nhead=cfg.nhead,
            dim_feedforward=cfg.dim_ff, dropout=cfg.dropout, batch_first=True)
        self.encoder = nn.TransformerEncoder(enc, num_layers=cfg.num_layers)
        self.pool    = _AttentionPooling(cfg.d_model)
        self.head    = nn.Sequential(nn.LayerNorm(cfg.d_model),
                                     nn.Linear(cfg.d_model, 2))

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        B, T, _ = x.shape
        pos = torch.arange(T, device=x.device).unsqueeze(0).expand(B, -1)
        return self.head(self.pool(self.encoder(self.proj(x) + self.pos_emb(pos))))


class _ClassificationTransformer(nn.Module):
    def __init__(self, input_dim: int, cfg: TwoStageConfig):
        super().__init__()
        self.proj         = nn.Linear(input_dim, cfg.d_model)
        self.pos_emb      = nn.Embedding(cfg.window_len, cfg.d_model)
        enc               = nn.TransformerEncoderLayer(
            d_model=cfg.d_model, nhead=cfg.nhead,
            dim_feedforward=cfg.dim_ff, dropout=cfg.dropout, batch_first=True)
        self.encoder      = nn.TransformerEncoder(enc, num_layers=cfg.num_layers)
        self.pool         = _AttentionPooling(cfg.d_model)
        self.norm         = nn.LayerNorm(cfg.d_model)
        self.goal_head    = nn.Linear(cfg.d_model, cfg.n_goal_classes)
        self.stimuli_head = nn.Linear(cfg.d_model, cfg.n_stimuli_classes)

    def forward(self, x: torch.Tensor) -> Tuple[torch.Tensor, torch.Tensor]:
        B, T, _ = x.shape
        pos = torch.arange(T, device=x.device).unsqueeze(0).expand(B, -1)
        h   = self.norm(self.pool(self.encoder(self.proj(x) + self.pos_emb(pos))))
        return self.goal_head(h), self.stimuli_head(h)


# ──────────────────────────────────────────────────────────────────────────────
# Colour palette (BGR)
# ──────────────────────────────────────────────────────────────────────────────

_GOAL_C: Dict[str, Tuple[int, int, int]] = {
    "unknown":              (110, 110, 110),
    "crosswalk_passing":    ( 50, 200, 200),
    "intersection_passing": ( 30, 200,  30),
    "left_lane_branch":     (200,  90,  30),
    "left_lane_change":     (220, 100,  20),
    "left_turn":            (220,  70,  20),
    "merge":                (160,  30, 180),
    "park":                 ( 80, 120,  60),
    "park_park":            ( 70, 110,  50),
    "railroad_passing":     (200, 180,   0),
    "right_lane_branch":    ( 20, 100, 220),
    "right_lane_change":    ( 30, 120, 220),
    "right_turn":           ( 20, 100, 220),
    "u-turn":               (  0, 200, 200),
}
_STIM_C: Dict[str, Tuple[int, int, int]] = {
    "unknown":                        (110, 110, 110),
    "avoid_parked_car":               (220, 130,  30),
    "avoid_pedestrian_near_ego_lane": (180,  40, 180),
    "avoid_tp":                       (200, 180,   0),
    "stop_4_congestion":              (  0, 120, 220),
    "stop_4_light":                   ( 30,  30, 220),
    "stop_4_pedestrian":              (180,  30, 180),
    "stop_4_sign":                    ( 60,  60, 200),
    "stop_for_others":                (100,  70, 200),
}
_CAUSE_C: Dict[str, Tuple[int, int, int]] = {
    "unknown":                         (110, 110, 110),
    "congestion":                      (  0, 140, 220),
    "crossing_pedestrian":             (180,  40, 180),
    "crossing_vehicle":                (200, 140,  20),
    "cut-in":                          (  0, 200, 200),
    "merging_vehicle":                 (160,  30, 180),
    "on-road_bicyclist":               ( 30, 180,  80),
    "on-road_motorcyclist":            ( 40, 160,  80),
    "park":                            ( 80, 120,  60),
    "parked_vehicle":                  (200, 110,  30),
    "pedestrian_near_ego_lane":        (160,  30, 160),
    "red_light":                       ( 30,  30, 220),
    "road_work":                       ( 50, 180, 200),
    "sign":                            ( 80, 200, 200),
    "turning_vehicle":                 (200, 160,  20),
    "vehicle_passing_with_lane_departure": (180, 180, 30),
    "yellow_light":                    ( 30, 200, 220),
}
_DEF_C = (180, 180, 180)

# Dot colour for event indicator
_EVT_DOT  = ( 30, 210,  30)   # green  → event
_NOEVT_DOT= (110, 110, 110)   # grey   → no event


def _fmt(s: str) -> str:
    """'left_turn' → 'Left Turn'"""
    return s.replace("_", " ").replace("-", " ").title()


def _short(s: str, n: int = 10) -> str:
    """Shorten a label to n chars for tight columns."""
    f = _fmt(s)
    return f if len(f) <= n else f[:n - 1] + "."


# ──────────────────────────────────────────────────────────────────────────────
# Explanation templates
# ──────────────────────────────────────────────────────────────────────────────

_STIM_VERB = {
    "stop_4_light":                   "stopping for traffic light",
    "stop_4_sign":                    "stopping for road sign",
    "stop_4_congestion":              "stopping for congestion",
    "stop_4_pedestrian":              "stopping for pedestrian",
    "stop_for_others":                "stopping for other road users",
    "avoid_parked_car":               "avoiding a parked car",
    "avoid_pedestrian_near_ego_lane": "avoiding nearby pedestrian",
    "avoid_tp":                       "avoiding traffic participant",
}
_GOAL_VERB = {
    "left_turn":            "execute a left turn",
    "right_turn":           "execute a right turn",
    "intersection_passing": "pass through intersection",
    "crosswalk_passing":    "pass through crosswalk",
    "left_lane_change":     "change to left lane",
    "right_lane_change":    "change to right lane",
    "left_lane_branch":     "take left branch",
    "right_lane_branch":    "take right branch",
    "merge":                "merge with traffic",
    "park":                 "park the vehicle",
    "park_park":            "park in parking area",
    "railroad_passing":     "pass railroad crossing",
    "u-turn":               "perform U-turn",
}
_CAUSE_DESC = {
    "red_light": "red light", "yellow_light": "yellow light",
    "sign": "road sign", "congestion": "traffic congestion",
    "crossing_pedestrian": "crossing pedestrian",
    "crossing_vehicle": "crossing vehicle",
    "merging_vehicle": "merging vehicle", "cut-in": "cut-in vehicle",
    "parked_vehicle": "parked vehicle",
    "pedestrian_near_ego_lane": "nearby pedestrian",
    "on-road_bicyclist": "on-road bicyclist",
    "on-road_motorcyclist": "on-road motorcyclist",
    "road_work": "road works", "turning_vehicle": "turning vehicle",
    "vehicle_passing_with_lane_departure": "departing vehicle",
    "park": "parking maneuver",
}


def _explain(goal: str, stimuli: str, cause: str, attn: str) -> str:
    sv   = _STIM_VERB.get(stimuli,  f"reacting ({_fmt(stimuli)})")
    gv   = _GOAL_VERB.get(goal,     f"completing {_fmt(goal)}")
    ctx  = _CAUSE_DESC.get(cause, "")  or  _CAUSE_DESC.get(attn, "")
    parts: List[str] = []
    if ctx:
        parts.append(f"Due to {ctx}")
    if stimuli and stimuli not in ("unknown", ""):
        parts.append(f"driver is {sv}")
    if goal and goal not in ("unknown", ""):
        parts.append(f"to {gv}")
    if not parts:
        return "Monitoring traffic conditions."
    return ". ".join(p[0].upper() + p[1:] for p in parts[:2]) + "."


# ──────────────────────────────────────────────────────────────────────────────
# Vocabulary helpers
# ──────────────────────────────────────────────────────────────────────────────

def _load_vocab(path: Path) -> Tuple[List[str], Dict[str, str], Dict[str, int]]:
    with open(path, encoding="utf-8") as f:
        d = json.load(f)
    vocab = d["vocab"]          # {name: int_id}
    lmap  = d.get("label_map", {})
    labels = [""] * len(vocab)
    for nm, idx in vocab.items():
        labels[idx] = nm
    return labels, lmap, vocab


def _map_raw(raw: str, lmap: Dict[str, str], vocab: Dict[str, int]) -> str:
    raw = raw.strip()
    m   = lmap.get(raw)
    if m and m in vocab:
        return m
    eng = " ".join(
        p for p in raw.split()
        if p.replace("-", "").replace("_", "").isascii()
    ).strip().lower().replace(" ", "_")
    return eng if eng in vocab else "unknown"


# ──────────────────────────────────────────────────────────────────────────────
# Model loading
# ──────────────────────────────────────────────────────────────────────────────

def _load_models(stage1_pt: Path, stage2_pt: Path, data_dir: Path):
    with open(data_dir / "config.json", encoding="utf-8") as f:
        cfg = TwoStageConfig(**{k: v for k, v in json.load(f).items()
                                if k in TwoStageConfig.__dataclass_fields__})
    cfg.device = "cpu"

    mean = np.load(data_dir / "norm_mean.npy").astype(np.float32)
    std  = np.load(data_dir / "norm_std.npy").astype(np.float32)
    std[std < 1e-8] = 1.0

    ck1 = torch.load(stage1_pt, map_location="cpu", weights_only=False)
    s1  = _EventTransformer(cfg.input_dim, cfg)
    s1.load_state_dict(ck1["model_state"])
    s1.eval()

    ck2 = torch.load(stage2_pt, map_location="cpu", weights_only=False)
    s2  = _ClassificationTransformer(cfg.input_dim, cfg)
    s2.load_state_dict(ck2["model_state"])
    s2.eval()

    return s1, s2, cfg, mean, std


# ──────────────────────────────────────────────────────────────────────────────
# Batch prediction (all stride-1 windows)
# ──────────────────────────────────────────────────────────────────────────────

def _predict_all(X, mean, std, s1, s2, cfg, bs=64):
    """Pre-compute ev/goal/stim for every stride-1 window of session X."""
    T, D  = X.shape
    wl    = cfg.window_len
    N     = max(0, T - wl + 1)

    ev_p  = np.zeros(N, dtype=np.int64)
    g_p   = np.zeros(N, dtype=np.int64)
    g_pr  = np.zeros(N, dtype=np.float32)
    s_p   = np.zeros(N, dtype=np.int64)
    s_pr  = np.zeros(N, dtype=np.float32)

    if N == 0:
        return ev_p, g_p, g_pr, s_p, s_pr

    Xn = (X - mean) / std

    with torch.no_grad():
        for st in range(0, N, bs):
            en  = min(st + bs, N)
            bx  = torch.from_numpy(np.stack([Xn[k:k+wl] for k in range(st, en)]))
            ev_p[st:en] = s1(bx).argmax(1).numpy()

        ev_idx = np.where(ev_p == 1)[0]
        for i in range(0, len(ev_idx), bs):
            chunk = ev_idx[i:i+bs]
            bx    = torch.from_numpy(np.stack([Xn[k:k+wl] for k in chunk]))
            gl, sl = s2(bx)
            gpr = torch.softmax(gl, 1);  spr = torch.softmax(sl, 1)
            g_p[chunk]  = gpr.argmax(1).numpy()
            g_pr[chunk] = gpr.max(1).values.numpy()
            s_p[chunk]  = spr.argmax(1).numpy()
            s_pr[chunk] = spr.max(1).values.numpy()

    return ev_p, g_p, g_pr, s_p, s_pr


# ──────────────────────────────────────────────────────────────────────────────
# EAF ground-truth tier loading
# ──────────────────────────────────────────────────────────────────────────────

def _load_eaf_tiers(
    eaf_json:  Path,
    cause_lmap: Dict[str, str], cause_vocab: Dict[str, int],
    att_lmap:   Dict[str, str], att_vocab:   Dict[str, int],
    goal_lmap:  Dict[str, str], goal_vocab:  Dict[str, int],
    stim_lmap:  Dict[str, str], stim_vocab:  Dict[str, int],
) -> Tuple[List[dict], List[dict], List[dict], List[dict]]:
    """Return (cause_anns, att_anns, goal_gt_anns, stim_gt_anns)."""
    if not eaf_json.exists():
        return [], [], [], []
    with open(eaf_json, encoding="utf-8") as f:
        data = json.load(f)
    tiers = data.get("tiers_grouped", {})

    cause_a, att_a, goal_a, stim_a = [], [], [], []
    for tier_name, anns in tiers.items():
        tl = tier_name.lower()
        if "cause" in tl:
            cause_a.extend(anns)
        elif "attention" in tl:
            att_a.extend(anns)
        elif "goal" in tl:
            goal_a.extend(anns)
        elif "stimuli" in tl or "stimulus" in tl:
            stim_a.extend(anns)

    return cause_a, att_a, goal_a, stim_a


def _at(anns: List[dict], t_ms: float,
        lmap: Dict[str, str], vocab: Dict[str, int]) -> str:
    """Return vocab key of active annotation at t_ms, else 'unknown'."""
    for a in anns:
        if a["start_ms"] <= t_ms <= a["end_ms"]:
            return _map_raw(a["label"], lmap, vocab)
    return "unknown"


# ──────────────────────────────────────────────────────────────────────────────
# RTK position helper
# ──────────────────────────────────────────────────────────────────────────────

def _load_rtk_pos(
    csv_dir: Optional[Path],
    t_rel: np.ndarray,
) -> Tuple[Optional[np.ndarray], Optional[np.ndarray]]:
    """Resample rtk_pos.csv (lng, lat) onto the sensor relative-time grid t_rel (seconds)."""
    if csv_dir is None or not csv_dir.exists():
        return None, None
    rtk_path = csv_dir / "rtk_pos.csv"
    if not rtk_path.exists():
        return None, None
    try:
        df = pd.read_csv(rtk_path)
        ts_col = df.columns[0]
        for c in ["timestamp", "unix_timestamp", "time", "t"]:
            if c in df.columns:
                ts_col = c
                break
        df = df.rename(columns={ts_col: "timestamp"}).sort_values("timestamp")
        ts     = df["timestamp"].to_numpy(dtype=np.float64)
        ts_rel = ts - ts[0]
        lngs = np.interp(t_rel, ts_rel, df["lng"].to_numpy()).astype(np.float32)
        lats = np.interp(t_rel, ts_rel, df["lat"].to_numpy()).astype(np.float32)
        return lngs, lats
    except Exception as e:
        print(f"  RTK pos load failed: {e}")
        return None, None


# ──────────────────────────────────────────────────────────────────────────────
# ffprobe helper
# ──────────────────────────────────────────────────────────────────────────────

def _video_info(p: Path) -> Tuple[float, int, int]:
    cmd  = ["ffprobe", "-v", "quiet", "-print_format", "json",
             "-show_streams", str(p)]
    data = json.loads(subprocess.check_output(cmd, stderr=subprocess.DEVNULL))
    for s in data.get("streams", []):
        if s.get("codec_type") == "video":
            n, d = s["r_frame_rate"].split("/")
            return float(n) / float(d), int(s["width"]), int(s["height"])
    raise RuntimeError(f"No video stream in {p}")


# ──────────────────────────────────────────────────────────────────────────────
# Drawing – always-on three-column panel
# ──────────────────────────────────────────────────────────────────────────────

def _draw_panel(
    frame:         np.ndarray,
    # EAF ground-truth labels at current time
    gt_cause:      str,
    gt_attention:  str,
    gt_goal:       str,
    gt_stimuli:    str,
    # multi-horizon predictions: [(h_s, is_event, goal_str, stim_str, goal_prob, stim_prob)]
    horizon_rows:  List[Tuple[float, bool, str, str, float, float]],
    # explanation text (from most imminent event horizon, or "")
    explanation:   str,
    # sensor values
    speed_kmh:     float,
    steer_deg:     float,
    brake_kpa:     float,
    accel_pct:     float,
    yaw:           float,
    # optional GPS overlay
    rtk_lng:       Optional[float] = None,
    rtk_lat:       Optional[float] = None,
) -> np.ndarray:

    out  = frame.copy()
    fh, fw = out.shape[:2]

    aa   = cv2.LINE_AA
    font = cv2.FONT_HERSHEY_SIMPLEX

    # ── GPS overlay – top-right corner ───────────────────────────────────────
    if rtk_lng is not None and rtk_lat is not None:
        gps_sc   = max(0.58, min(0.78, fw / 1920.0 * 0.80))
        gps_lines = [f"Lng {rtk_lng:.6f}", f"Lat {rtk_lat:.6f}"]
        for gi, gl in enumerate(gps_lines):
            tw = cv2.getTextSize(gl, font, gps_sc, 1)[0][0]
            gx = fw - tw - 12
            gy = 24 + gi * 22
            cv2.putText(out, gl, (gx + 1, gy + 1), font, gps_sc, (0, 0, 0),       2, aa)
            cv2.putText(out, gl, (gx,     gy),     font, gps_sc, (160, 230, 160), 1, aa)

    # ── Bottom panel background ───────────────────────────────────────────────
    panel_h   = min(290, fh // 3 + 30)
    panel_top = fh - panel_h

    ov = out.copy()
    cv2.rectangle(ov, (0, panel_top), (fw, fh), (10, 10, 14), -1)
    cv2.addWeighted(ov, 0.72, out, 0.28, 0, out)
    cv2.line(out, (0, panel_top), (fw, panel_top), (60, 60, 70), 1)

    # ── Font scales (larger) ─────────────────────────────────────────────────
    scm = max(0.52, min(0.72, fw / 1920.0 * 0.72))   # section headers
    scs = max(0.46, scm - 0.06)                        # value text
    sct = max(0.40, scm - 0.12)                        # label / small text

    # ── Non-equal column widths:  left 22% | middle 54% | right 24% ─────────
    left_w = fw * 22 // 100
    mid_w  = fw * 54 // 100
    # right_w = fw - left_w - mid_w  (≈24 %)

    c0 = 8                      # EAF labels text start
    c1 = left_w + 8             # Predictions text start
    c2 = left_w + mid_w + 8    # Sensors text start
    y0 = panel_top + 22

    cv2.line(out, (left_w,         panel_top), (left_w,         fh), (55, 55, 65), 1)
    cv2.line(out, (left_w + mid_w, panel_top), (left_w + mid_w, fh), (55, 55, 65), 1)

    # ── LEFT: EAF Ground-Truth Labels ────────────────────────────────────────
    cv2.putText(out, "EAF LABELS", (c0, y0), font, scm, (170, 210, 210), 1, aa)

    rows_gt = [
        ("Cause",   gt_cause,     _CAUSE_C),
        ("Attn",    gt_attention, _CAUSE_C),
        ("Goal",    gt_goal,      _GOAL_C),
        ("Stimuli", gt_stimuli,   _STIM_C),
    ]
    lbl_x   = c0
    val_x   = c0 + 62
    for i, (lbl, val, cdict) in enumerate(rows_gt):
        y   = y0 + 26 + i * 24
        col = cdict.get(val, _DEF_C)
        cv2.putText(out, f"{lbl}:", (lbl_x, y), font, sct, (150, 150, 150), 1, aa)
        cv2.putText(out, _short(val, 16),  (val_x, y), font, sct, col,           1, aa)

    # ── MIDDLE: Multi-horizon Predictions ────────────────────────────────────
    cv2.putText(out, "PREDICTIONS", (c1, y0), font, scm, (200, 200, 140), 1, aa)

    # Sub-column layout proportional to mid_w so bars never overlap text:
    #   [h:9%] [dot:11%] [goal_text:20%] [goal_bar:9%] [gap:3%] [stim_text:20%] [stim_bar:9%]
    off_h  = 0
    off_dot = mid_w *  9 // 100
    off_g   = mid_w * 20 // 100   # goal text
    off_gb  = mid_w * 40 // 100   # goal bar  (after goal text area)
    bar_bw  = mid_w *  9 // 100   # bar pixel width
    off_s   = mid_w * 58 // 100   # stimuli text  (gap gives room for goal % label)
    off_sb  = mid_w * 78 // 100   # stimuli bar

    hx_h   = c1 + off_h
    hx_dot = c1 + off_dot
    hx_g   = c1 + off_g
    hx_gb  = c1 + off_gb
    hx_s   = c1 + off_s
    hx_sb  = c1 + off_sb

    # Header row
    y_hdr = y0 + 16
    cv2.putText(out, "h",       (hx_h,   y_hdr), font, sct, (140, 140, 140), 1, aa)
    cv2.putText(out, "Evt",     (hx_dot, y_hdr), font, sct, (140, 140, 140), 1, aa)
    cv2.putText(out, "Goal",    (hx_g,   y_hdr), font, sct, (140, 140, 140), 1, aa)
    cv2.putText(out, "Stimuli", (hx_s,   y_hdr), font, sct, (140, 140, 140), 1, aa)

    expl_src = ""

    pct_sc = max(0.30, sct - 0.10)   # smaller font for confidence %

    for ri, (h_s, is_event, goal_str, stim_str, g_prob, s_prob) in enumerate(horizon_rows):
        yr = y0 + 46 + ri * 28       # pushed down to clear sub-header

        cv2.putText(out, f"{h_s:.0f}s", (hx_h, yr), font, scs, (200, 200, 200), 1, aa)

        dot_c = _EVT_DOT if is_event else _NOEVT_DOT
        cv2.circle(out, (hx_dot + 10, yr - 8), 7, dot_c, -1, aa)

        if is_event:
            # Goal text
            gc = _GOAL_C.get(goal_str, _DEF_C)
            cv2.putText(out, _short(goal_str, 14), (hx_g, yr), font, sct, gc, 1, aa)
            # Goal bar (starts at hx_gb, entirely before hx_s)
            cv2.rectangle(out, (hx_gb, yr - 12), (hx_gb + bar_bw,                          yr + 1), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_gb, yr - 12), (hx_gb + int(bar_bw * max(0.0, min(1.0, g_prob))), yr + 1), gc, -1)
            # Goal confidence %
            cv2.putText(out, f"{g_prob * 100:.0f}%", (hx_gb + bar_bw + 4, yr), font, pct_sc, gc, 1, aa)

            # Stimuli text
            sc2 = _STIM_C.get(stim_str, _DEF_C)
            cv2.putText(out, _short(stim_str, 14), (hx_s, yr), font, sct, sc2, 1, aa)
            # Stimuli bar (starts at hx_sb)
            cv2.rectangle(out, (hx_sb, yr - 12), (hx_sb + bar_bw,                           yr + 1), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_sb, yr - 12), (hx_sb + int(bar_bw * max(0.0, min(1.0, s_prob))), yr + 1), sc2, -1)
            # Stimuli confidence %
            cv2.putText(out, f"{s_prob * 100:.0f}%", (hx_sb + bar_bw + 4, yr), font, pct_sc, sc2, 1, aa)

            if not expl_src:
                expl_src = explanation
        else:
            cv2.putText(out, "-", (hx_g, yr), font, sct, (90, 90, 90), 1, aa)
            cv2.putText(out, "-", (hx_s, yr), font, sct, (90, 90, 90), 1, aa)

    # Explanation text (below horizon rows)
    if expl_src:
        y_ex  = y0 + 46 + len(horizon_rows) * 28 + 8
        limit = max(20, mid_w // max(1, int(sct * 12)))
        words = expl_src.split()
        lines: List[str] = []
        ln = ""
        for w in words:
            if len(ln) + len(w) + 1 <= limit:
                ln = (ln + " " + w).strip()
            else:
                if ln:
                    lines.append(ln)
                ln = w
        if ln:
            lines.append(ln)
        for j, l in enumerate(lines[:2]):
            yj = y_ex + j * 18
            if yj >= fh - 8:
                break
            cv2.putText(out, l, (c1, yj), font, max(0.34, sct - 0.04), (190, 190, 190), 1, aa)

    # ── RIGHT: Sensor Readout ─────────────────────────────────────────────────
    cv2.putText(out, "SENSORS", (c2, y0), font, scm, (140, 200, 140), 1, aa)

    sensor_rows = [
        ("Speed", f"{speed_kmh:6.1f} km/h"),
        ("Steer", f"{steer_deg:+6.1f} deg"),
        ("Brake", f"{brake_kpa:6.0f} kPa"),
        ("Accel", f"{accel_pct:6.1f} %"),
        ("Yaw",   f"{yaw:+6.2f}"),
    ]
    val_off = 54
    for i, (lbl, val) in enumerate(sensor_rows):
        y = y0 + 24 + i * 26
        cv2.putText(out, f"{lbl}:", (c2,           y), font, sct, (140, 140, 140), 1, aa)
        cv2.putText(out, val,       (c2 + val_off, y), font, scs, (210, 230, 210), 1, aa)

    return out


# ──────────────────────────────────────────────────────────────────────────────
# Core annotation – single session
# ──────────────────────────────────────────────────────────────────────────────

def annotate_session_eaf(
    session_id:    str,
    video_path:    Path,
    prealigned:    Optional[Path],
    csv_dir:       Optional[Path],
    s1:            _EventTransformer,
    s2:            _ClassificationTransformer,
    cfg:           TwoStageConfig,
    mean:          np.ndarray,
    std:           np.ndarray,
    goal_labels:   List[str],
    stim_labels:   List[str],
    cause_lmap:    Dict[str, str], cause_vocab: Dict[str, int],
    att_lmap:      Dict[str, str], att_vocab:   Dict[str, int],
    goal_lmap:     Dict[str, str], goal_vocab:  Dict[str, int],
    stim_lmap:     Dict[str, str], stim_vocab:  Dict[str, int],
    cause_anns:    List[dict],
    att_anns:      List[dict],
    goal_gt_anns:  List[dict],
    stim_gt_anns:  List[dict],
    outdir:        Path,
    sample_hz:     float,
    horizons_s:    List[float],
    max_seconds:   Optional[float] = None,
) -> None:

    from twimo.data.csv_session import load_sensors_from_csv_dir, resample_sensors

    print(f"\n[annotate_eaf] {session_id}")

    # ── 1. Sensor loading ─────────────────────────────────────────────────────
    X: Optional[np.ndarray]        = None
    t_sensor: Optional[np.ndarray] = None
    X_csv: Optional[np.ndarray]    = None
    csv_names: List[str]           = []

    # CSV pre-load: save t_sensor_csv so we don't load twice
    t_sensor_csv: Optional[np.ndarray] = None
    if csv_dir is not None and csv_dir.exists():
        try:
            fr                           = load_sensors_from_csv_dir(csv_dir)
            t_sensor_csv, X_csv, csv_names = resample_sensors(fr, sample_hz=sample_hz)
        except Exception:
            X_csv = None

    # t_csv_offset_s: offset used for the CSV sensor display lookup.
    t_csv_offset_s: float = 0.0

    if prealigned is not None and prealigned.exists():
        Xp       = np.load(prealigned).astype(np.float32)
        t_sensor = np.arange(Xp.shape[0], dtype=np.float32) / float(sample_hz)
        X        = Xp
        # Prealigned arrays are already time-aligned to video/EAF: no offset needed
        # for model prediction.
        t_offset_s = 0.0
        print("  Prealigned: %d steps x %d features, %.1fs" % (X.shape[0], X.shape[1], t_sensor[-1]))
        # For the sensor readout panel (CSV display), compute the real offset so
        # that displayed values match the video frame (not sensor recording start).
        if X_csv is not None:
            t_csv_offset_s = _compute_sensor_video_offset(session_id, csv_dir, video_path)
            if t_csv_offset_s != 0.0:
                print("  CSV display offset: %.3fs" % t_csv_offset_s)
    elif X_csv is not None:
        t_sensor  = t_sensor_csv
        X         = X_csv
        # CSV sensors: compute offset using video filename (second-precision) or sid.
        t_offset_s = _compute_sensor_video_offset(session_id, csv_dir, video_path)
        t_csv_offset_s = t_offset_s
        if t_offset_s != 0.0:
            desc = "sensor after video" if t_offset_s < 0 else "sensor before video"
            print("  Sensor-video offset: %.3fs  (%s)" % (t_offset_s, desc))
        else:
            print("  Sensor-video offset: 0.0s (could not compute)")
        print("  CSV: %d steps, %.1fs" % (X.shape[0], float(t_sensor[-1]-t_sensor[0])))
    else:
        print("  WARNING: no sensor data – skip"); return

    if X is None or X.shape[0] == 0:
        return

    t_rel        = t_sensor - t_sensor[0]
    sensor_dur_s = float(t_rel[-1])

    # Precompute CSV relative timeline for display lookups (used inside frame loop).
    t_rel_csv: Optional[np.ndarray] = None
    if X_csv is not None and t_sensor_csv is not None:
        t_rel_csv = t_sensor_csv - t_sensor_csv[0]

    # ── 2b. RTK position (for GPS overlay) ───────────────────────────────────
    rtk_lngs, rtk_lats = _load_rtk_pos(csv_dir, t_rel)
    if rtk_lngs is not None:
        print(f"  RTK position loaded: {len(rtk_lngs)} steps")

    # ── 2. Batch prediction ───────────────────────────────────────────────────
    print("  Running two-stage prediction …")
    ev_p, g_p, g_pr, s_p, s_pr = _predict_all(X, mean, std, s1, s2, cfg)
    N  = len(ev_p)
    wl = cfg.window_len
    print(f"  Windows: {N}  | Events: {int(ev_p.sum())} ({100*ev_p.mean():.1f}%)")

    # ── 3. Video info ─────────────────────────────────────────────────────────
    fps, vw, vh = _video_info(video_path)
    print(f"  Video: {vw}×{vh} @ {fps:.2f} fps")

    out_path = outdir / f"annotated_eaf_{session_id}.mp4"
    outdir.mkdir(parents=True, exist_ok=True)

    max_f = int(max_seconds * fps) if max_seconds else None

    if max_f:
        dec = ["ffmpeg","-hide_banner","-loglevel","error",
               "-i",str(video_path),"-vframes",str(max_f),
               "-f","rawvideo","-pix_fmt","bgr24","pipe:1"]
    else:
        dec = ["ffmpeg","-hide_banner","-loglevel","error",
               "-i",str(video_path),
               "-f","rawvideo","-pix_fmt","bgr24","pipe:1"]

    enc = ["ffmpeg","-hide_banner","-loglevel","error","-y",
           "-f","rawvideo","-pix_fmt","bgr24",
           "-r",str(fps),"-s",f"{vw}x{vh}","-i","pipe:0",
           "-c:v","libx264","-crf","23","-preset","fast",
           "-pix_fmt","yuv420p", str(out_path)]

    decoder = subprocess.Popen(dec, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    encoder = subprocess.Popen(enc, stdin=subprocess.PIPE,  stderr=subprocess.PIPE)

    fb  = vw * vh * 3
    fi  = 0

    # Horizon step offsets (how many sensor steps ahead per horizon)
    hz_offsets = [int(round(h * sample_hz)) for h in horizons_s]

    print(f"  Horizons: {horizons_s}s → offsets {hz_offsets} steps")
    print(f"  Annotating → {out_path}")

    try:
        while True:
            raw = decoder.stdout.read(fb)
            if not raw or len(raw) < fb:
                break

            t_fr = fi / fps
            i_s  = int(np.argmin(np.abs(t_rel - (t_fr + t_offset_s))))
            frame = np.frombuffer(raw, np.uint8).reshape(vh, vw, 3).copy()

            # ── Ground-truth EAF labels at current time ────────────────────
            t_ms       = t_fr * 1000.0
            gt_cause   = _at(cause_anns,   t_ms, cause_lmap, cause_vocab)
            gt_attn    = _at(att_anns,     t_ms, att_lmap,   att_vocab)
            gt_goal    = _at(goal_gt_anns, t_ms, goal_lmap,  goal_vocab)
            gt_stim    = _at(stim_gt_anns, t_ms, stim_lmap,  stim_vocab)

            # ── Multi-horizon model predictions ────────────────────────────
            horizon_rows: List[Tuple[float, bool, str, str, float, float]] = []
            expl = ""
            for h_s, off in zip(horizons_s, hz_offsets):
                future_is = i_s + off
                pred_k    = future_is - wl + 1   # window ending at future_is
                if 0 <= pred_k < N:
                    is_ev  = bool(ev_p[pred_k])
                    goal_s = goal_labels[int(g_p[pred_k])] if is_ev and int(g_p[pred_k]) < len(goal_labels) else "unknown"
                    stim_s = stim_labels[int(s_p[pred_k])] if is_ev and int(s_p[pred_k]) < len(stim_labels) else "unknown"
                    gpr    = float(g_pr[pred_k]) if is_ev else 0.0
                    spr    = float(s_pr[pred_k]) if is_ev else 0.0
                else:
                    is_ev  = False
                    goal_s = "unknown"
                    stim_s = "unknown"
                    gpr    = spr = 0.0

                if is_ev and not expl:
                    expl = _explain(goal_s, stim_s, gt_cause, gt_attn)

                horizon_rows.append((h_s, is_ev, goal_s, stim_s, gpr, spr))

            # ── Sensor values from CSV ─────────────────────────────────────
            speed = steer = brake = accel = yaw = 0.0
            if X_csv is not None and t_rel_csv is not None:
                row = int(np.argmin(np.abs(t_rel_csv - (t_fr + t_csv_offset_s))))
                row = min(row, X_csv.shape[0] - 1)
                for ci, fn in enumerate(csv_names):
                    if ci >= X_csv.shape[1]:
                        break
                    v   = float(X_csv[row, ci])
                    fnl = fn.lower()
                    if "speed" in fnl or fn.endswith(".speed"):
                        speed = v
                    elif "steer_angle" in fnl:
                        steer = v
                    elif "pedalpressure" in fnl:
                        brake = v
                    elif "pedalangle" in fnl:
                        accel = v
                    elif ".yaw" in fnl:
                        yaw = v

            rtk_lng = float(rtk_lngs[min(i_s, len(rtk_lngs) - 1)]) if rtk_lngs is not None else None
            rtk_lat = float(rtk_lats[min(i_s, len(rtk_lats) - 1)]) if rtk_lats is not None else None

            annotated = _draw_panel(
                frame,
                gt_cause=gt_cause, gt_attention=gt_attn,
                gt_goal=gt_goal,   gt_stimuli=gt_stim,
                horizon_rows=horizon_rows,
                explanation=expl,
                speed_kmh=speed, steer_deg=steer,
                brake_kpa=brake, accel_pct=accel, yaw=yaw,
                rtk_lng=rtk_lng,  rtk_lat=rtk_lat,
            )
            encoder.stdin.write(annotated.tobytes())
            fi += 1

            if fi % 300 == 0:
                pct = min(100.0, t_fr / max(sensor_dur_s, 1e-6) * 100)
                any_ev = any(r[1] for r in horizon_rows)
                print(f"    … {fi/fps:.0f}s | {pct:.0f}% sensor | "
                      f"i_s={i_s}/{X.shape[0]-1} | "
                      f"event={'YES' if any_ev else 'no'}")

    except BrokenPipeError:
        pass
    finally:
        try: decoder.stdout.close()
        except: pass
        decoder.terminate()
        try: encoder.stdin.close()
        except: pass
        encoder.wait()

    print(f"  Done → {out_path}  ({fi} frames)")


# ──────────────────────────────────────────────────────────────────────────────
# EAF JSON map  (session_id → parsed JSON path)
# ──────────────────────────────────────────────────────────────────────────────

def _eaf_map(parsed_dir: Optional[Path]) -> Dict[str, Path]:
    if not parsed_dir or not parsed_dir.exists():
        return {}
    m: Dict[str, Path] = {}
    for p in parsed_dir.glob("*.json"):
        if p.name == "summary.json":
            continue
        m[p.stem.replace("-", "")[:12]] = p
    return m


# ──────────────────────────────────────────────────────────────────────────────
# CLI
# ──────────────────────────────────────────────────────────────────────────────

def main() -> None:
    pa = argparse.ArgumentParser(
        description="Annotate video with EAF two-stage model. "
                    "Always-on panel: EAF labels | multi-horizon predictions | sensors.")
    pa.add_argument("--manifest",               required=True,  type=Path)
    pa.add_argument("--stage1-model",           required=True,  type=Path,
                    help="stage1.pt  (EventTransformer)")
    pa.add_argument("--stage2-model",           required=True,  type=Path,
                    help="stage2.pt  (ClassificationTransformer)")
    pa.add_argument("--data-dir",               required=True,  type=Path,
                    help="Dir with config.json + norm_mean/std.npy")
    pa.add_argument("--vocab-dir",              required=True,  type=Path,
                    help="Dir with vocab_*.json files")
    pa.add_argument("--prealigned-sensors-dir", default=None,   type=Path)
    pa.add_argument("--eaf-parsed-dir",         default=None,   type=Path,
                    help="Dir with parsed EAF JSONs for GT Cause/Attention/Goal/Stimuli")
    pa.add_argument("--outdir",                 required=True,  type=Path)
    pa.add_argument("--session",                default=None,   type=str)
    pa.add_argument("--sample-hz",              default=3.0,    type=float)
    pa.add_argument("--horizons",               default=[1.0, 3.0, 5.0],
                    type=float, nargs="+",
                    help="Prediction horizons in seconds (default: 1 3 5)")
    pa.add_argument("--max-seconds",            default=None,   type=float)
    args = pa.parse_args()

    # Manifest
    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    if args.session:
        records = [r for r in records if r.get("session_id") == args.session]
        if not records:
            print(f"ERROR: session '{args.session}' not found.", file=sys.stderr)
            sys.exit(1)

    vids: List[dict] = []
    for r in records:
        vd = r.get("video_dir")
        if vd:
            mp4s = list(Path(vd).glob("*.mp4"))
            if mp4s:
                r["_vp"] = mp4s[0]; vids.append(r)
    if not vids:
        print("No sessions with video found.", file=sys.stderr); sys.exit(1)

    print(f"Sessions with video: {len(vids)}")

    # Models
    print("\nLoading EAF two-stage models …")
    s1, s2, cfg, mean, std = _load_models(args.stage1_model, args.stage2_model, args.stage1_model.parent)
    print(f"  Stage1: EventTransformer  input={cfg.input_dim} window={cfg.window_len}steps={cfg.window_sec}s")
    print(f"  Stage2: ClassifyTransformer  goals={cfg.n_goal_classes} stimuli={cfg.n_stimuli_classes}")

    # Vocabularies
    goal_labels,  goal_lmap,  goal_vocab  = _load_vocab(args.vocab_dir / "vocab_goal.json")
    stim_labels,  stim_lmap,  stim_vocab  = _load_vocab(args.vocab_dir / "vocab_stimuli.json")
    cause_labels, cause_lmap, cause_vocab = _load_vocab(args.vocab_dir / "vocab_cause.json")
    att_labels,   att_lmap,   att_vocab   = _load_vocab(args.vocab_dir / "vocab_attention.json")
    print(f"  Goals:   {goal_labels}")
    print(f"  Stimuli: {stim_labels}")

    # EAF parsed map
    em = _eaf_map(args.eaf_parsed_dir)
    print(f"  EAF parsed JSONs: {len(em)} found" if em else
          "  EAF parsed dir not given – GT labels will show 'unknown'")

    args.outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="annotate_video_eaf", output_dir=args.outdir, use_codecarbon=True)
    _profiler.__enter__()

    for r in vids:
        sid     = r["session_id"]
        csv_dir = Path(r["csv_dir"]) if r.get("csv_dir") else None
        vp      = r["_vp"]

        pre: Optional[Path] = None
        if args.prealigned_sensors_dir:
            c = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
            if c.exists():
                pre = c

        if pre is None and (csv_dir is None or not csv_dir.exists()):
            print(f"[SKIP] {sid}: no sensor data"); continue

        # Load EAF GT tiers
        cause_a = att_a = goal_gt = stim_gt = []
        if sid in em:
            cause_a, att_a, goal_gt, stim_gt = _load_eaf_tiers(
                em[sid],
                cause_lmap, cause_vocab,
                att_lmap,   att_vocab,
                goal_lmap,  goal_vocab,
                stim_lmap,  stim_vocab,
            )
            print(f"  EAF {sid}: cause={len(cause_a)} att={len(att_a)} "
                  f"goal={len(goal_gt)} stim={len(stim_gt)} annotations")

        try:
            annotate_session_eaf(
                session_id   = sid,
                video_path   = vp,
                prealigned   = pre,
                csv_dir      = csv_dir,
                s1=s1, s2=s2, cfg=cfg, mean=mean, std=std,
                goal_labels  = goal_labels,
                stim_labels  = stim_labels,
                cause_lmap=cause_lmap, cause_vocab=cause_vocab,
                att_lmap=att_lmap,     att_vocab=att_vocab,
                goal_lmap=goal_lmap,   goal_vocab=goal_vocab,
                stim_lmap=stim_lmap,   stim_vocab=stim_vocab,
                cause_anns   = cause_a,
                att_anns     = att_a,
                goal_gt_anns = goal_gt,
                stim_gt_anns = stim_gt,
                outdir       = args.outdir,
                sample_hz    = args.sample_hz,
                horizons_s   = args.horizons,
                max_seconds  = args.max_seconds,
            )
        except Exception as e:
            print(f"[ERROR] {sid}: {e}", file=sys.stderr)
            import traceback; traceback.print_exc()

    _profiler.__exit__(None, None, None)
    print("\nAll done.")


if __name__ == "__main__":
    main()
