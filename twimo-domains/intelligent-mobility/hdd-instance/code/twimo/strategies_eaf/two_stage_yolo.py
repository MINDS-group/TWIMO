#!/usr/bin/env python
"""Two-stage EAF model with YOLOv8 visual detection features.

Pipeline (4 subcommands, run in order):
  1. extract        – run YOLOv8 on each session video, cache det features (.npy)
  2. train          – retrain Stage1 + Stage2 with sensor[8] + detection[D] input
  3. validate       – compute EAF annotation agreement scores (detection ↔ labels)
  4. filter-retrain – remove low-agreement annotations and retrain

Detection feature vector (D=13)
--------------------------------
  0  tl_red           traffic light → red
  1  tl_yellow        traffic light → yellow
  2  tl_green         traffic light → green
  3  stop_sign        stop sign confidence
  4  pedestrian_near  pedestrian (proximity-weighted confidence)
  5  vehicle_ahead    vehicle in centre of frame (large bbox)
  6  vehicle_cross    vehicle at frame sides (crossing / cut-in pattern)
  7  vehicle_parked   vehicle on roadside (small, bottom-of-frame)
  8  bicycle          cyclist / bicycle
  9  motorcycle       motorcyclist
  10 heavy_vehicle    bus or truck
  11 vehicle_count    normalised vehicle count (clipped at 10)
  12 congestion       vehicle area / frame area (clipped at 0.5)

Requirements
------------
  pip install ultralytics          # YOLOv8
  pip install opencv-python torch numpy pandas tqdm

Usage
-----
python twimo/strategies_eaf/two_stage_yolo.py extract \\
    --manifest ./artifacts/manifest.jsonl \\
    --det-cache-dir ./artifacts/eaf/det_cache \\
    --yolo-model yolov8n.pt --sample-hz 3

python twimo/strategies_eaf/two_stage_yolo.py train \\
    --manifest ./artifacts/manifest.jsonl \\
    --eaf-parsed-dir ./artifacts/eaf/parsed \\
    --det-cache-dir ./artifacts/eaf/det_cache \\
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
    --vocab-dir ./artifacts/eaf/vocabs \\
    --outdir ./artifacts/eaf/two_stage_yolo

python twimo/strategies_eaf/two_stage_yolo.py validate \\
    --manifest ./artifacts/manifest.jsonl \\
    --eaf-parsed-dir ./artifacts/eaf/parsed \\
    --det-cache-dir ./artifacts/eaf/det_cache \\
    --vocab-dir ./artifacts/eaf/vocabs \\
    --outdir ./artifacts/eaf/validation

python twimo/strategies_eaf/two_stage_yolo.py filter-retrain \\
    --validation-dir ./artifacts/eaf/validation \\
    --min-agreement 0.30 \\
    --manifest ./artifacts/manifest.jsonl \\
    --eaf-parsed-dir ./artifacts/eaf/parsed \\
    --det-cache-dir ./artifacts/eaf/det_cache \\
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
    --vocab-dir ./artifacts/eaf/vocabs \\
    --outdir ./artifacts/eaf/two_stage_yolo_filtered
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
from dataclasses import dataclass, field
from pathlib import Path
from typing import Dict, List, Optional, Tuple

sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import cv2
import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F
from tqdm import tqdm

from twimo.utils.profiling import TrainingProfiler


# ──────────────────────────────────────────────────────────────────────────────
# Detection constants
# ──────────────────────────────────────────────────────────────────────────────

# COCO class IDs used by YOLOv8
COCO_PERSON        = 0
COCO_BICYCLE       = 1
COCO_CAR           = 2
COCO_MOTORCYCLE    = 3
COCO_BUS           = 5
COCO_TRUCK         = 7
COCO_TRAFFIC_LIGHT = 9
COCO_STOP_SIGN     = 11

VEHICLE_IDS = {COCO_CAR, COCO_BUS, COCO_TRUCK}
HEAVY_IDS   = {COCO_BUS, COCO_TRUCK}

D = 13  # number of detection features
DET_FEATURE_NAMES = [
    "tl_red", "tl_yellow", "tl_green",
    "stop_sign",
    "pedestrian_near",
    "vehicle_ahead", "vehicle_cross", "vehicle_parked",
    "bicycle", "motorcycle", "heavy_vehicle",
    "vehicle_count", "congestion",
]

# Maps Cause/Attention vocab keys to detection feature indices
# (used in EAF validation)
CAUSE_TO_DET: Dict[str, List[int]] = {
    "red_light":                    [0],
    "yellow_light":                 [1],
    "sign":                         [3],
    "crossing_pedestrian":          [4],
    "pedestrian_near_ego_lane":     [4],
    "crossing_vehicle":             [5, 6],
    "cut-in":                       [6],
    "merging_vehicle":              [6],
    "turning_vehicle":              [6],
    "parked_vehicle":               [7],
    "on-road_bicyclist":            [8],
    "on-road_motorcyclist":         [9],
    "congestion":                   [11, 12],
    "road_work":                    [],     # no COCO mapping – skip in validation
    "park":                         [],
}


# ──────────────────────────────────────────────────────────────────────────────
# Model (self-contained copy; same architecture as two_stage_transformer.py
#        but input_dim is runtime-configurable so it accepts 8+D features)
# ──────────────────────────────────────────────────────────────────────────────

@dataclass
class YoloStageConfig:
    window_sec:        float = 5.0
    sample_hz:         float = 3.0
    d_model:           int   = 128
    nhead:             int   = 4
    num_layers:        int   = 3
    dim_ff:            int   = 256
    dropout:           float = 0.1
    batch_size:        int   = 32
    epochs:            int   = 30
    lr:                float = 1e-4
    n_goal_classes:      int   = 14
    n_stimuli_classes:   int   = 9
    n_cause_classes:     int   = 17
    n_attention_classes: int   = 17
    sensor_dim:          int   = 8
    det_dim:           int   = D
    device:            str   = ""

    @property
    def input_dim(self) -> int:
        return self.sensor_dim + self.det_dim

    @property
    def window_len(self) -> int:
        return int(self.window_sec * self.sample_hz)

    def __post_init__(self):
        if not self.device:
            self.device = "cuda" if torch.cuda.is_available() else "cpu"


class _AttentionPool(nn.Module):
    def __init__(self, d: int):
        super().__init__()
        self.query = nn.Parameter(torch.randn(d))

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        w = F.softmax(torch.einsum("btd,d->bt", x, self.query), dim=1).unsqueeze(-1)
        return (x * w).sum(1)


class _EventNet(nn.Module):
    def __init__(self, cfg: YoloStageConfig):
        super().__init__()
        self.proj    = nn.Linear(cfg.input_dim, cfg.d_model)
        self.pos_emb = nn.Embedding(cfg.window_len, cfg.d_model)
        enc          = nn.TransformerEncoderLayer(
            cfg.d_model, cfg.nhead, cfg.dim_ff, cfg.dropout, batch_first=True)
        self.encoder = nn.TransformerEncoder(enc, cfg.num_layers)
        self.pool    = _AttentionPool(cfg.d_model)
        self.head    = nn.Sequential(nn.LayerNorm(cfg.d_model),
                                     nn.Linear(cfg.d_model, 2))

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        B, T, _ = x.shape
        pos = torch.arange(T, device=x.device).unsqueeze(0).expand(B, -1)
        return self.head(self.pool(self.encoder(self.proj(x) + self.pos_emb(pos))))


class _ClassifyNet(nn.Module):
    """Stage-2 classifier: shared Transformer trunk with 4 prediction heads.

    Heads:
      goal_head    → goal class  (what manoeuvre)
      stimuli_head → stimuli class (why: behaviour trigger)
      cause_head   → cause class  (what external object caused it)
      attn_head    → attention class (where driver attention was directed)
    """

    def __init__(self, cfg: YoloStageConfig):
        super().__init__()
        self.proj         = nn.Linear(cfg.input_dim, cfg.d_model)
        self.pos_emb      = nn.Embedding(cfg.window_len, cfg.d_model)
        enc               = nn.TransformerEncoderLayer(
            cfg.d_model, cfg.nhead, cfg.dim_ff, cfg.dropout, batch_first=True)
        self.encoder      = nn.TransformerEncoder(enc, cfg.num_layers)
        self.pool         = _AttentionPool(cfg.d_model)
        self.norm         = nn.LayerNorm(cfg.d_model)
        self.goal_head    = nn.Linear(cfg.d_model, cfg.n_goal_classes)
        self.stimuli_head = nn.Linear(cfg.d_model, cfg.n_stimuli_classes)
        self.cause_head   = nn.Linear(cfg.d_model, cfg.n_cause_classes)
        self.attn_head    = nn.Linear(cfg.d_model, cfg.n_attention_classes)

    def forward(self, x: torch.Tensor
                ) -> Tuple[torch.Tensor, torch.Tensor, torch.Tensor, torch.Tensor]:
        B, T, _ = x.shape
        pos = torch.arange(T, device=x.device).unsqueeze(0).expand(B, -1)
        h   = self.norm(self.pool(self.encoder(self.proj(x) + self.pos_emb(pos))))
        return self.goal_head(h), self.stimuli_head(h), self.cause_head(h), self.attn_head(h)


# ──────────────────────────────────────────────────────────────────────────────
# Detection extraction helpers
# ──────────────────────────────────────────────────────────────────────────────

def _classify_tl_color(frame_bgr: np.ndarray, box: Tuple[float, float, float, float]) -> str:
    """Return 'red' | 'yellow' | 'green' | 'unknown' for a traffic-light bbox."""
    x1, y1, x2, y2 = map(int, box)
    crop = frame_bgr[max(0, y1):max(0, y2), max(0, x1):max(0, x2)]
    if crop.size == 0:
        return "unknown"
    hsv = cv2.cvtColor(crop, cv2.COLOR_BGR2HSV)
    h = hsv.shape[0]
    thirds = [hsv[:max(1, h // 3)], hsv[h // 3: 2 * h // 3], hsv[2 * h // 3:]]
    scores = {"red": 0, "yellow": 0, "green": 0}
    for t in thirds:
        if t.size == 0:
            continue
        scores["red"]    += (cv2.inRange(t, (0,  120, 100), (10,  255, 255)) |
                             cv2.inRange(t, (170, 120, 100), (180, 255, 255))).sum()
        scores["yellow"] += cv2.inRange(t, (20,  120, 100), (35,  255, 255)).sum()
        scores["green"]  += cv2.inRange(t, (40,  120, 100), (80,  255, 255)).sum()
    best = max(scores, key=scores.get)
    return best if scores[best] > 0 else "unknown"


def _extract_det_features(result, frame_bgr: np.ndarray) -> np.ndarray:
    """Convert one YOLO result into a (D,) detection feature vector."""
    feat = np.zeros(D, dtype=np.float32)
    boxes = result.boxes
    if boxes is None or len(boxes) == 0:
        return feat

    fh, fw = frame_bgr.shape[:2]
    frame_area = float(fh * fw)
    vehicle_count = 0
    vehicle_area  = 0.0

    for box in boxes:
        cls_id = int(box.cls[0])
        conf   = float(box.conf[0])
        x1, y1, x2, y2 = box.xyxy[0].tolist()
        bbox_area   = (x2 - x1) * (y2 - y1)
        cx_norm     = (x1 + x2) / (2.0 * fw)   # 0=left, 1=right
        cy_norm     = (y1 + y2) / (2.0 * fh)   # higher = lower in frame = closer

        if cls_id == COCO_TRAFFIC_LIGHT:
            color = _classify_tl_color(frame_bgr, (x1, y1, x2, y2))
            if color == "red":
                feat[0] = max(feat[0], conf)
            elif color == "yellow":
                feat[1] = max(feat[1], conf)
            elif color == "green":
                feat[2] = max(feat[2], conf)

        elif cls_id == COCO_STOP_SIGN:
            feat[3] = max(feat[3], conf)

        elif cls_id == COCO_PERSON:
            prox = cy_norm * min(1.0, bbox_area / frame_area * 50.0)
            feat[4] = max(feat[4], conf * min(1.0, prox))

        elif cls_id in VEHICLE_IDS:
            vehicle_count += 1
            vehicle_area  += bbox_area
            side_dist = abs(cx_norm - 0.5) * 2.0   # 0=centre, 1=edge
            size_rel  = bbox_area / frame_area

            if side_dist < 0.35:
                feat[5] = max(feat[5], conf)        # ahead
            else:
                feat[6] = max(feat[6], conf)        # crossing / cut-in

            if cy_norm > 0.80 and size_rel < 0.04:
                feat[7] = max(feat[7], conf * 0.6)  # parked (roadside, small)

            if cls_id in HEAVY_IDS:
                feat[10] = max(feat[10], conf)

        elif cls_id == COCO_BICYCLE:
            feat[8] = max(feat[8], conf)

        elif cls_id == COCO_MOTORCYCLE:
            feat[9] = max(feat[9], conf)

    feat[11] = min(1.0, vehicle_count / 10.0)
    feat[12] = min(1.0, vehicle_area  / (frame_area * 0.5))
    return feat


# ──────────────────────────────────────────────────────────────────────────────
# EAF / vocab helpers
# ──────────────────────────────────────────────────────────────────────────────

def _load_vocab(path: Path) -> Tuple[List[str], Dict[str, str], Dict[str, int]]:
    with open(path, encoding="utf-8") as f:
        d = json.load(f)
    vocab  = d["vocab"]
    lmap   = d.get("label_map", {})
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


def _load_eaf_json(eaf_json: Path) -> Dict[str, List[dict]]:
    if not eaf_json.exists():
        return {}
    with open(eaf_json, encoding="utf-8") as f:
        data = json.load(f)
    return data.get("tiers_grouped", {})


def _eaf_map(parsed_dir: Optional[Path]) -> Dict[str, Path]:
    if not parsed_dir or not parsed_dir.exists():
        return {}
    m = {}
    for p in parsed_dir.glob("*.json"):
        if p.name == "summary.json":
            continue
        m[p.stem.replace("-", "")[:12]] = p
    return m


def _get_tier(tiers: Dict[str, List[dict]], key: str) -> List[dict]:
    for tname, anns in tiers.items():
        if key in tname.lower():
            return anns
    return []


def _label_at(anns: List[dict], t_ms: float,
               lmap: Dict[str, str], vocab: Dict[str, int]) -> str:
    for a in anns:
        if a["start_ms"] <= t_ms <= a["end_ms"]:
            return _map_raw(a["label"], lmap, vocab)
    return "unknown"


# ──────────────────────────────────────────────────────────────────────────────
# Step 1 – extract
# ──────────────────────────────────────────────────────────────────────────────

def cmd_extract(args: argparse.Namespace) -> None:
    """Run YOLOv8 on each session video, cache (T, D) detection feature arrays."""
    try:
        from ultralytics import YOLO
    except ImportError:
        print("ERROR: ultralytics not installed.  pip install ultralytics", file=sys.stderr)
        sys.exit(1)

    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    det_dir = Path(args.det_cache_dir)
    det_dir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_extract", output_dir=det_dir, use_codecarbon=True)
    _profiler.__enter__()

    model = YOLO(args.yolo_model)
    print(f"Loaded YOLOv8 from {args.yolo_model}")

    step_sec = 1.0 / args.sample_hz

    for r in tqdm(records, desc="sessions"):
        sid    = r["session_id"]
        out_npy = det_dir / f"{sid}_det.npy"
        if out_npy.exists() and not args.overwrite:
            continue

        # Support both manifest conventions:
        #   video_path  – direct path to .mp4 file  (current manifest schema)
        #   video_dir   – directory containing .mp4 files  (legacy schema)
        vd = r.get("video_dir")
        vp_direct = r.get("video_path")
        if vp_direct and Path(vp_direct).exists():
            vp = Path(vp_direct)
        elif vd:
            mp4s = list(Path(vd).glob("*.mp4"))
            if not mp4s:
                continue
            vp = mp4s[0]
        else:
            continue

        # ── get total frames & fps ──────────────────────────────────────────
        probe = subprocess.check_output(
            ["ffprobe", "-v", "quiet", "-print_format", "json", "-show_streams", str(vp)],
            stderr=subprocess.DEVNULL)
        data  = json.loads(probe)
        fps   = 30.0
        for s in data.get("streams", []):
            if s.get("codec_type") == "video":
                n, d = s["r_frame_rate"].split("/")
                fps  = float(n) / float(d)
                break

        # ── determine how many sensor steps ─────────────────────────────────
        if args.prealigned_sensors_dir:
            pre = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
            if pre.exists():
                T = int(np.load(pre, mmap_mode="r").shape[0])
            else:
                T = None
        else:
            T = None

        if T is None:
            # estimate from video duration
            dur_cmd = ["ffprobe", "-v", "quiet", "-show_entries",
                       "format=duration", "-of", "default=nw=1:nk=1", str(vp)]
            try:
                dur = float(subprocess.check_output(dur_cmd, stderr=subprocess.DEVNULL))
                T   = int(dur * args.sample_hz)
            except Exception:
                continue

        # ── decode one frame per sensor step & run YOLO ─────────────────────
        feats = np.zeros((T, D), dtype=np.float32)
        frame_size = None

        for i_s in tqdm(range(T), desc=sid, leave=False):
            t_s = i_s * step_sec
            frame_idx = int(t_s * fps)
            dec = ["ffmpeg", "-hide_banner", "-loglevel", "error",
                   "-ss", f"{t_s:.4f}", "-i", str(vp),
                   "-vframes", "1", "-f", "rawvideo", "-pix_fmt", "bgr24", "pipe:1"]
            try:
                raw = subprocess.check_output(dec, stderr=subprocess.DEVNULL)
            except Exception:
                continue
            if frame_size is None:
                # probe resolution once
                for s in data.get("streams", []):
                    if s.get("codec_type") == "video":
                        frame_size = (int(s["height"]), int(s["width"]))
                        break
            if frame_size is None or len(raw) != frame_size[0] * frame_size[1] * 3:
                continue
            frame = np.frombuffer(raw, np.uint8).reshape(frame_size[0], frame_size[1], 3)
            results = model(frame, verbose=False)
            if results:
                feats[i_s] = _extract_det_features(results[0], frame)

        np.save(out_npy, feats)
        print(f"  {sid}: saved {out_npy} shape={feats.shape}")

    print("Extraction done.")
    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# Step 2 – train
# ──────────────────────────────────────────────────────────────────────────────

def _build_windows(
    X: np.ndarray,             # (T, input_dim)
    mean: np.ndarray, std: np.ndarray,
    goal_vec:  np.ndarray,     # (T,) int goal labels    (-1 = no label)
    stim_vec:  np.ndarray,     # (T,) int stimuli labels (-1 = no label)
    ev_vec:    np.ndarray,     # (T,) int 0/1 event label
    cause_vec: np.ndarray,     # (T,) int cause labels   (-1 = no label)
    att_vec:   np.ndarray,     # (T,) int attention labels (-1 = no label)
    window_len: int,
    stride: int = 1,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Slide window over X; return (windows, ev, goal, stim, cause, att) label arrays."""
    Xn   = (X - mean) / std
    T    = X.shape[0]
    wins, ev_l, go_l, st_l, ca_l, at_l = [], [], [], [], [], []
    for k in range(0, T - window_len + 1, stride):
        mid = k + window_len // 2
        wins.append(Xn[k: k + window_len])
        ev_l.append(int(ev_vec[mid]))
        go_l.append(int(goal_vec[mid]))
        st_l.append(int(stim_vec[mid]))
        ca_l.append(int(cause_vec[mid]))
        at_l.append(int(att_vec[mid]))
    if not wins:
        empty = np.empty(0, dtype=np.int64)
        return (np.empty((0, window_len, X.shape[1]), dtype=np.float32),
                empty, empty, empty, empty, empty)
    return (np.stack(wins).astype(np.float32),
            np.array(ev_l,  dtype=np.int64),
            np.array(go_l,  dtype=np.int64),
            np.array(st_l,  dtype=np.int64),
            np.array(ca_l,  dtype=np.int64),
            np.array(at_l,  dtype=np.int64))


def _sensor_first_move_seconds(csv_dir: Path,
                                speed_thresh: float = 0.5) -> Optional[float]:
    """Return seconds (from sensor start) when speed first exceeds threshold.

    Reads vel.csv; the first column is the unix timestamp.
    Returns None if vel.csv is missing or car never moves.
    """
    try:
        import pandas as pd
        vel_path = csv_dir / "vel.csv"
        if not vel_path.exists():
            return None
        df = pd.read_csv(vel_path)
        t_arr = df.iloc[:, 0].to_numpy(float)
        spd   = df.iloc[:, 2].to_numpy(float)   # 'speed' column
        idx   = np.where(spd > speed_thresh)[0]
        if not len(idx):
            return None
        return float(t_arr[idx[0]] - t_arr[0])
    except Exception:
        return None


def _detect_video_motion_onset(video_path: Path,
                                max_search_seconds: float = 90.0) -> Optional[float]:
    """Detect the video file-second when the car first starts moving.

    Extracts low-resolution 5 fps grayscale frames via ffmpeg and computes
    frame-to-frame absolute differences on the BOTTOM HALF of each frame
    (road texture near the car is most sensitive to slow initial motion).
    Uses a rolling-mean baseline (skipping the first 6 s of camera-setup
    noise) and detects the first sustained crossing of a low threshold.

    Returns the video second (float) of motion onset, or None if the car
    appears to already be moving at the start (no stationary baseline) or
    ffmpeg fails.
    """
    import subprocess as _sp

    W, H, FPS_EX  = 80, 45, 5          # tiny frames, 5 fps
    fb             = W * H
    t_extract      = float(max_search_seconds)  # no hard cap; caller decides
    SKIP_S         = 6.0               # skip first 6 s (camera noise + convolution bleed)
    WIN            = 5                 # smoothing window
    ROW_START      = H // 2            # bottom-half ROI (road texture, more sensitive)

    cmd = ["ffmpeg", "-hide_banner", "-loglevel", "error",
           "-i", str(video_path),
           "-vf", "fps=%d,scale=%d:%d" % (FPS_EX, W, H),
           "-t", str(t_extract),
           "-f", "rawvideo", "-pix_fmt", "gray", "pipe:1"]
    try:
        proc = _sp.run(cmd, capture_output=True, timeout=max(60, int(t_extract) + 30))
    except Exception:
        return None
    if proc.returncode != 0 or len(proc.stdout) < fb * 8:
        return None

    raw      = proc.stdout
    n_frames = len(raw) // fb

    # Compute diffs on bottom half only (more sensitive to slow vehicle creep)
    roi_start = ROW_START * W
    diffs = np.array([
        float(np.mean(np.abs(
            np.frombuffer(raw[(i + 1) * fb + roi_start:(i + 2) * fb], np.uint8).astype(np.float32) -
            np.frombuffer(raw[i * fb + roi_start:(i + 1) * fb], np.uint8).astype(np.float32)
        )))
        for i in range(n_frames - 1)
    ])

    skip_n = int(SKIP_S * FPS_EX)
    if len(diffs) < skip_n + WIN + 2:
        return None

    # Rolling-mean smoothing
    kernel = np.ones(WIN) / WIN
    smooth = np.convolve(diffs, kernel, mode="same")

    # Baseline and peak from the post-skip window
    baseline = float(np.min(smooth[skip_n:]))
    peak_90  = float(np.percentile(diffs[skip_n:], 90))

    # If no clear separation between stationary and moving, bail
    if peak_90 < baseline * 2.5 or peak_90 < 2.0:
        return None

    # Low threshold (10 %) to catch the very beginning of slow initial creep;
    # minimum 1.5 to avoid noise triggers on stable stationary video.
    threshold = baseline + (peak_90 - baseline) * 0.10
    threshold = max(threshold, 1.5)

    # First pair of consecutive smoothed values above threshold (after skip)
    for i in range(skip_n, len(smooth) - 1):
        if smooth[i] > threshold and smooth[i + 1] > threshold:
            return float(i + 1) / FPS_EX
    # Single-frame fallback
    for i in range(skip_n, len(smooth)):
        if smooth[i] > threshold:
            return float(i + 1) / FPS_EX
    return None


def _video_unix_from_filename(video_path: Path) -> Optional[float]:
    """Extract Unix timestamp from HDD video filename.

    HDD filenames follow the pattern: YYYY-MM-DD-HH-MM-SS_*.mp4
    The timestamp is in local UTC-8 (Pacific Standard Time).

    Returns None if filename doesn't match the expected pattern.
    """
    import re, datetime
    m = re.match(r"(\d{4})-(\d{2})-(\d{2})-(\d{2})-(\d{2})-(\d{2})", video_path.stem)
    if not m:
        return None
    try:
        y, mo, d, h, mi, s = (int(x) for x in m.groups())
        dt = datetime.datetime(y, mo, d, h, mi, s,
                               tzinfo=datetime.timezone(datetime.timedelta(hours=-8)))
        return dt.timestamp()
    except ValueError:
        return None


def _compute_sensor_video_offset(sid: str, csv_dir: Optional[Path],
                                  video_path: Optional[Path] = None) -> float:
    """Return t_offset_s: the number of seconds to add to video frame time
    to get the corresponding sensor relative time.

        i_s = argmin |t_rel − (t_fr + t_offset_s)|

    Positive offset  → sensor was recording before video content starts
                        (common in HDD: sensor starts a few seconds earlier)
    Negative offset  → sensor started after video content begins (unusual)

    EAF annotations are in ms from video start; sensor CSVs use Unix seconds.

    Priority:
      1. Motion calibration via frame-differences (most accurate, ~1-frame
         precision at 2 fps extraction).  Requires the video to have a
         stationary period at the start before the car drives away.
      2. Video filename timestamp (YYYY-MM-DD-HH-MM-SS, UTC-8, second precision).
         Works when the video is NOT trimmed from the original recording.
      3. Session ID (YYYYMMDDHHMI, UTC-8, minute precision – last resort).

    Returns 0.0 when the offset cannot be determined.
    """
    if csv_dir is None or not csv_dir.exists():
        return 0.0
    try:
        import pandas as pd

        steer_path = csv_dir / "steer.csv"
        if not steer_path.exists():
            return 0.0
        df = pd.read_csv(steer_path)
        sensor_start = float(df.iloc[0, 0])

        # ── Method 1: motion calibration (video frame-diff + sensor vel) ─────
        if video_path is not None:
            sensor_move_t = _sensor_first_move_seconds(csv_dir)
            # Extend video search window to cover sessions where the car parks
            # for a long time before moving (up to 200 s max to keep it fast).
            search_window = 90.0
            if sensor_move_t is not None and sensor_move_t > 70.0:
                search_window = min(sensor_move_t + 30.0, 200.0)
            video_move_t = _detect_video_motion_onset(video_path,
                                                      max_search_seconds=search_window)
            if video_move_t is not None and sensor_move_t is not None:
                off = sensor_move_t - video_move_t
                if -300.0 <= off <= 600.0:
                    print("  [%s] offset via motion calibration: %.2fs  "
                          "(video_move=%.1fs, sensor_move=%.1fs)"
                          % (sid, off, video_move_t, sensor_move_t))
                    return off

        # ── Method 2: video filename (second-precision) ───────────────────────
        video_unix: Optional[float] = None
        if video_path is not None:
            video_unix = _video_unix_from_filename(video_path)

        # ── Method 3: session ID (minute-precision fallback) ──────────────────
        if video_unix is None and len(sid) >= 12:
            import datetime
            y, mo, d = int(sid[:4]), int(sid[4:6]), int(sid[6:8])
            h, mi    = int(sid[8:10]), int(sid[10:12])
            for tz_h in [-8, 0, 9, -9]:
                dt = datetime.datetime(y, mo, d, h, mi, 0,
                                       tzinfo=datetime.timezone(
                                           datetime.timedelta(hours=tz_h)))
                candidate = dt.timestamp()
                if -300.0 <= candidate - sensor_start <= 600.0:
                    video_unix = candidate
                    break

        if video_unix is not None:
            return video_unix - sensor_start

        print(f"  [{sid}] WARNING: could not determine sensor-video offset "
              f"(sensor_start={sensor_start:.0f}) – using 0.0")
        return 0.0

    except Exception as e:
        print(f"  WARNING: sensor-video offset computation failed: {e}")
        return 0.0


def _label_vectors(
    T: int, sample_hz: float,
    tiers: Dict[str, List[dict]],
    goal_lmap,  goal_vocab,
    stim_lmap,  stim_vocab,
    cause_lmap, cause_vocab,
    att_lmap,   att_vocab,
    t_offset_s: float = 0.0,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Build per-step (T,) label arrays for event / goal / stimuli / cause / attention.

    t_offset_s: seconds from sensor step-0 to video/EAF t=0.
    EAF time for sensor step i = (i/sample_hz - t_offset_s) * 1000 ms.
    Steps before video start (t_eaf < 0) are left unlabelled.
    """
    ev_vec    = np.zeros(T, dtype=np.int64)
    goal_vec  = np.full(T, -1, dtype=np.int64)
    stim_vec  = np.full(T, -1, dtype=np.int64)
    cause_vec = np.full(T, -1, dtype=np.int64)
    att_vec   = np.full(T, -1, dtype=np.int64)

    goal_anns  = _get_tier(tiers, "goal")
    stim_anns  = _get_tier(tiers, "stimuli") or _get_tier(tiers, "stimulus")
    cause_anns = _get_tier(tiers, "cause")
    att_anns   = _get_tier(tiers, "attention")

    for i in range(T):
        t_ms = (i / sample_hz - t_offset_s) * 1000.0
        if t_ms < 0:
            continue   # before video / EAF start
        g = _label_at(goal_anns,  t_ms, goal_lmap,  goal_vocab)
        s = _label_at(stim_anns,  t_ms, stim_lmap,  stim_vocab)
        c = _label_at(cause_anns, t_ms, cause_lmap, cause_vocab)
        a = _label_at(att_anns,   t_ms, att_lmap,   att_vocab)
        if g != "unknown":
            ev_vec[i]    = 1
            goal_vec[i]  = goal_vocab.get(g, -1)
        if s != "unknown":
            stim_vec[i]  = stim_vocab.get(s, -1)
        if c != "unknown":
            cause_vec[i] = cause_vocab.get(c, -1)
        if a != "unknown":
            att_vec[i]   = att_vocab.get(a, -1)

    return ev_vec, goal_vec, stim_vec, cause_vec, att_vec


def cmd_train(args: argparse.Namespace) -> None:
    """Train Stage1 (event detection) and Stage2 (goal+stimuli) with sensor+detection features."""
    import torch.optim as optim

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_train", output_dir=outdir, use_codecarbon=True)
    _profiler.__enter__()

    cfg = YoloStageConfig(
        window_sec=args.window_sec,
        sample_hz=args.sample_hz,
        epochs=args.epochs,
        lr=args.lr,
        batch_size=args.batch_size,
    )

    # ── Load vocabularies ────────────────────────────────────────────────────
    vd = Path(args.vocab_dir)
    goal_labels,  goal_lmap,  goal_vocab   = _load_vocab(vd / "vocab_goal.json")
    stim_labels,  stim_lmap,  stim_vocab   = _load_vocab(vd / "vocab_stimuli.json")
    cause_labels, cause_lmap, cause_vocab  = _load_vocab(vd / "vocab_cause.json")
    att_labels,   att_lmap,   att_vocab    = _load_vocab(vd / "vocab_attention.json")
    cfg.n_goal_classes      = len(goal_labels)
    cfg.n_stimuli_classes   = len(stim_labels)
    cfg.n_cause_classes     = len(cause_labels)
    cfg.n_attention_classes = len(att_labels)

    # ── Load records ─────────────────────────────────────────────────────────
    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    em = _eaf_map(Path(args.eaf_parsed_dir) if args.eaf_parsed_dir else None)

    # ── Build dataset ────────────────────────────────────────────────────────
    all_X, all_ev, all_go, all_st, all_ca, all_at = [], [], [], [], [], []
    sensor_dim = cfg.sensor_dim  # 8
    det_dim    = cfg.det_dim     # 13

    for r in tqdm(records, desc="loading data"):
        sid = r["session_id"]

        # sensor
        pre = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
        if not pre.exists():
            continue
        X_sensor = np.load(pre).astype(np.float32)   # (T, 8)
        T = X_sensor.shape[0]

        # detection
        det_path = Path(args.det_cache_dir) / f"{sid}_det.npy"
        if det_path.exists():
            X_det = np.load(det_path).astype(np.float32)
            if X_det.shape[0] != T:
                X_det = np.resize(X_det, (T, det_dim))
        else:
            X_det = np.zeros((T, det_dim), dtype=np.float32)

        X = np.concatenate([X_sensor, X_det], axis=1)  # (T, 21)

        # labels from EAF
        if sid not in em:
            continue
        tiers = _load_eaf_json(em[sid])
        if not tiers:
            continue

        # Prealigned sensor arrays are already time-aligned to video/EAF (step 0 = t=0ms)
        t_offset_s = 0.0

        ev_vec, goal_vec, stim_vec, cause_vec, att_vec = _label_vectors(
            T, cfg.sample_hz, tiers,
            goal_lmap, goal_vocab, stim_lmap, stim_vocab,
            cause_lmap, cause_vocab, att_lmap, att_vocab,
            t_offset_s=t_offset_s)

        all_X.append(X)
        all_ev.append(ev_vec)
        all_go.append(goal_vec)
        all_st.append(stim_vec)
        all_ca.append(cause_vec)
        all_at.append(att_vec)

    if not all_X:
        print("ERROR: no data found."); sys.exit(1)

    # ── Fit normalisation on all sensor+det data ─────────────────────────────
    X_all = np.concatenate(all_X, axis=0)
    mean  = X_all.mean(0).astype(np.float32)
    std   = X_all.std(0).astype(np.float32)
    std[std < 1e-8] = 1.0
    np.save(outdir / "norm_mean.npy", mean)
    np.save(outdir / "norm_std.npy",  std)

    # ── Build windowed dataset ────────────────────────────────────────────────
    wl     = cfg.window_len
    stride = max(1, wl // 3)
    Xw, ev_l, go_l, st_l, ca_l, at_l = [], [], [], [], [], []
    for X, ev, go, st, ca, at in zip(all_X, all_ev, all_go, all_st, all_ca, all_at):
        xw, el, gl, sl, cl, al = _build_windows(X, mean, std, go, st, ev, ca, at, wl, stride)
        if len(xw):
            Xw.append(xw); ev_l.append(el); go_l.append(gl)
            st_l.append(sl); ca_l.append(cl); at_l.append(al)

    Xw   = np.concatenate(Xw,   axis=0)
    ev_l = np.concatenate(ev_l, axis=0)
    go_l = np.concatenate(go_l, axis=0)
    st_l = np.concatenate(st_l, axis=0)
    ca_l = np.concatenate(ca_l, axis=0)
    at_l = np.concatenate(at_l, axis=0)
    print(f"Windows: {len(Xw)}  events: {ev_l.sum()}  "
          f"w/cause: {(ca_l>=0).sum()}  w/attn: {(at_l>=0).sum()}")

    Xt = torch.from_numpy(Xw)
    Et = torch.from_numpy(ev_l)
    Gt = torch.from_numpy(go_l)
    St = torch.from_numpy(st_l)
    Ct = torch.from_numpy(ca_l)
    At = torch.from_numpy(at_l)

    dev = torch.device(cfg.device)
    bs  = cfg.batch_size

    # ── Stage 1: event detection ──────────────────────────────────────────────
    print("\n── Stage 1: training EventNet ──")
    # Class-weighted cross-entropy to handle event/no-event imbalance.
    # Without weighting the model learns to always predict "no event".
    n_pos = int((ev_l == 1).sum())
    n_neg = int((ev_l == 0).sum())
    if n_pos > 0:
        pos_w    = float(n_neg) / float(n_pos)
        weight1  = torch.tensor([1.0, pos_w], device=dev)
        print(f"  class weights: no_event=1.0  event={pos_w:.2f}  "
              f"(pos={n_pos}, neg={n_neg})")
    else:
        weight1 = None
        print("  WARNING: no event windows found – Stage1 will predict all zeros")

    s1 = _EventNet(cfg).to(dev)
    opt1 = optim.AdamW(s1.parameters(), lr=cfg.lr)
    for epoch in range(cfg.epochs):
        s1.train()
        idx = torch.randperm(len(Xt))
        tot_loss = 0.0
        for i in range(0, len(Xt), bs):
            b  = idx[i: i + bs]
            bx = Xt[b].to(dev); by = Et[b].to(dev)
            loss = F.cross_entropy(s1(bx), by, weight=weight1)
            opt1.zero_grad(); loss.backward(); opt1.step()
            tot_loss += loss.item() * len(b)
        if (epoch + 1) % 5 == 0:
            print(f"  epoch {epoch+1}/{cfg.epochs}  loss={tot_loss/len(Xt):.4f}")

    ck1 = {"model_state": s1.state_dict(), "config": vars(cfg)}
    torch.save(ck1, outdir / "stage1.pt")
    print(f"  Stage1 saved → {outdir/'stage1.pt'}")

    # ── Stage 2: goal + stimuli + cause + attention classification ───────────
    print("\n── Stage 2: training ClassifyNet (goal / stimuli / cause / attention) ──")
    ev_mask = ev_l == 1
    Xw2 = Xt[ev_mask]
    Gw2 = Gt[ev_mask]; Sw2 = St[ev_mask]
    Cw2 = Ct[ev_mask]; Aw2 = At[ev_mask]
    if len(Xw2) == 0:
        print("  No event windows – skip Stage2"); return
    print(f"  Event windows for Stage2: {len(Xw2)}")

    s2 = _ClassifyNet(cfg).to(dev)
    opt2 = optim.AdamW(s2.parameters(), lr=cfg.lr)
    for epoch in range(cfg.epochs):
        s2.train()
        idx = torch.randperm(len(Xw2))
        tot_loss = 0.0
        for i in range(0, len(Xw2), bs):
            b   = idx[i: i + bs]
            bx  = Xw2[b].to(dev)
            bg  = Gw2[b].to(dev);  bst = Sw2[b].to(dev)
            bc  = Cw2[b].to(dev);  bat = Aw2[b].to(dev)
            valid_g  = bg  >= 0;   valid_st = bst >= 0
            valid_c  = bc  >= 0;   valid_at = bat >= 0
            gl, sl, cl, al = s2(bx)
            loss = torch.tensor(0.0, device=dev)
            if valid_g.any():
                loss = loss + F.cross_entropy(gl[valid_g],  bg[valid_g])
            if valid_st.any():
                loss = loss + F.cross_entropy(sl[valid_st], bst[valid_st])
            if valid_c.any():
                loss = loss + F.cross_entropy(cl[valid_c],  bc[valid_c])
            if valid_at.any():
                loss = loss + F.cross_entropy(al[valid_at], bat[valid_at])
            if loss.item() > 0:
                opt2.zero_grad(); loss.backward(); opt2.step()
                tot_loss += loss.item() * len(b)
        if (epoch + 1) % 5 == 0:
            print(f"  epoch {epoch+1}/{cfg.epochs}  loss={tot_loss/max(1,len(Xw2)):.4f}")

    ck2 = {"model_state": s2.state_dict(), "config": vars(cfg)}
    torch.save(ck2, outdir / "stage2.pt")
    print(f"  Stage2 saved → {outdir/'stage2.pt'}")

    # Save config for inference
    with open(outdir / "config.json", "w") as f:
        json.dump(vars(cfg), f, indent=2)
    with open(outdir / "det_feature_names.json", "w") as f:
        json.dump(DET_FEATURE_NAMES, f, indent=2)
    print(f"\nAll artefacts saved to {outdir}")
    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# Step 3 – validate EAF annotations
# ──────────────────────────────────────────────────────────────────────────────

def _agreement_score(
    det_feat:  np.ndarray,   # (T, D)
    anns:      List[dict],
    lmap:      Dict[str, str],
    vocab:     Dict[str, int],
    sample_hz: float,
    threshold: float = 0.15,
) -> Dict[str, float]:
    """Compute per-annotation agreement between EAF label and detection feature."""
    results = []
    for a in anns:
        raw   = a["label"]
        label = _map_raw(raw, lmap, vocab)
        feat_idx = CAUSE_TO_DET.get(label, [])
        if not feat_idx:
            # No detection mapping for this label – skip (not flagged as error)
            results.append({"label": label, "raw": raw,
                            "start_ms": a["start_ms"], "end_ms": a["end_ms"],
                            "agreement": None, "det_indices": []})
            continue

        i0 = max(0, int(a["start_ms"] / 1000.0 * sample_hz))
        i1 = min(det_feat.shape[0] - 1, int(a["end_ms"] / 1000.0 * sample_hz))
        if i0 > i1:
            results.append({"label": label, "raw": raw,
                            "start_ms": a["start_ms"], "end_ms": a["end_ms"],
                            "agreement": 0.0, "det_indices": feat_idx})
            continue

        segment  = det_feat[i0: i1 + 1, :][:, feat_idx]   # (steps, n_feat)
        detected = (segment > threshold).any(axis=1)        # (steps,) bool
        score    = float(detected.mean())
        results.append({"label": label, "raw": raw,
                        "start_ms": a["start_ms"], "end_ms": a["end_ms"],
                        "agreement": round(score, 4),
                        "det_indices": feat_idx})
    return results


def cmd_validate(args: argparse.Namespace) -> None:
    """Compute EAF annotation agreement scores for all sessions."""
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_validate", output_dir=outdir, use_codecarbon=True)
    _profiler.__enter__()

    vd = Path(args.vocab_dir)
    _, cause_lmap, cause_vocab = _load_vocab(vd / "vocab_cause.json")
    _, att_lmap,   att_vocab   = _load_vocab(vd / "vocab_attention.json")

    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    em = _eaf_map(Path(args.eaf_parsed_dir) if args.eaf_parsed_dir else None)
    det_dir = Path(args.det_cache_dir)

    summary = []
    for r in tqdm(records, desc="validating"):
        sid = r["session_id"]
        if sid not in em:
            continue
        det_path = det_dir / f"{sid}_det.npy"
        if not det_path.exists():
            print(f"  [WARN] no det cache for {sid} – skipping")
            continue
        det_feat = np.load(det_path).astype(np.float32)
        tiers    = _load_eaf_json(em[sid])

        cause_anns = _get_tier(tiers, "cause")
        att_anns   = _get_tier(tiers, "attention")

        cause_results = _agreement_score(det_feat, cause_anns, cause_lmap, cause_vocab,
                                         args.sample_hz, args.threshold)
        att_results   = _agreement_score(det_feat, att_anns,   att_lmap,   att_vocab,
                                         args.sample_hz, args.threshold)

        sid_out = {"session_id": sid,
                   "cause_annotations": cause_results,
                   "attention_annotations": att_results}
        summary.append(sid_out)

        with open(outdir / f"validation_{sid}.json", "w", encoding="utf-8") as f:
            json.dump(sid_out, f, indent=2, ensure_ascii=False)

    # Global summary: flag low-agreement annotations
    low_count = 0
    for s in summary:
        for a in s["cause_annotations"] + s["attention_annotations"]:
            if a["agreement"] is not None and a["agreement"] < args.min_agreement:
                low_count += 1

    global_summary = {
        "n_sessions": len(summary),
        "min_agreement_threshold": args.min_agreement,
        "low_agreement_count": low_count,
        "sessions": [{"session_id": s["session_id"],
                      "cause_low":  sum(1 for a in s["cause_annotations"]
                                        if a["agreement"] is not None
                                        and a["agreement"] < args.min_agreement),
                      "attention_low": sum(1 for a in s["attention_annotations"]
                                          if a["agreement"] is not None
                                          and a["agreement"] < args.min_agreement)}
                     for s in summary],
    }
    with open(outdir / "validation_summary.json", "w", encoding="utf-8") as f:
        json.dump(global_summary, f, indent=2)
    print(f"\nValidation done.  Low-agreement annotations: {low_count}")
    print(f"Results → {outdir}")
    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# Step 4 – filter low-agreement annotations and retrain
# ──────────────────────────────────────────────────────────────────────────────

def cmd_filter_retrain(args: argparse.Namespace) -> None:
    """Filter EAF annotations with low detection agreement, then retrain."""
    val_dir = Path(args.validation_dir)
    parsed_dir_orig = Path(args.eaf_parsed_dir)
    filtered_dir    = Path(args.outdir) / "eaf_filtered"
    filtered_dir.mkdir(parents=True, exist_ok=True)
    _profiler_outdir = Path(args.outdir)
    _profiler_outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_filter_retrain", output_dir=_profiler_outdir, use_codecarbon=True)
    _profiler.__enter__()

    n_removed = 0
    for val_file in val_dir.glob("validation_*.json"):
        if val_file.name == "validation_summary.json":
            continue
        with open(val_file, encoding="utf-8") as f:
            val = json.load(f)
        sid = val["session_id"]

        # Load original parsed EAF
        orig_path = parsed_dir_orig / f"{sid}.json"
        if not orig_path.exists():
            # Try with date format
            for p in parsed_dir_orig.glob("*.json"):
                if p.stem.replace("-", "")[:12] == sid:
                    orig_path = p
                    break

        if not orig_path.exists():
            continue
        with open(orig_path, encoding="utf-8") as f:
            eaf_data = json.load(f)

        # Build set of annotation intervals to remove (low agreement)
        to_remove: set = set()
        for tier_key in ("cause_annotations", "attention_annotations"):
            for a in val.get(tier_key, []):
                if a["agreement"] is not None and a["agreement"] < args.min_agreement:
                    to_remove.add((a["start_ms"], a["end_ms"], a["raw"]))
                    n_removed += 1

        # Filter tiers_grouped
        tiers_filtered = {}
        for tname, anns in eaf_data.get("tiers_grouped", {}).items():
            filtered = [a for a in anns
                        if (a["start_ms"], a["end_ms"], a["label"]) not in to_remove]
            tiers_filtered[tname] = filtered
        eaf_data["tiers_grouped"] = tiers_filtered

        out_path = filtered_dir / orig_path.name
        with open(out_path, "w", encoding="utf-8") as f:
            json.dump(eaf_data, f, indent=2, ensure_ascii=False)

    print(f"Filtered {n_removed} low-agreement annotations → {filtered_dir}")

    # Re-run training with filtered annotations
    print("\nRetraining with filtered annotations …")
    train_args = argparse.Namespace(
        manifest=args.manifest,
        eaf_parsed_dir=str(filtered_dir),
        det_cache_dir=args.det_cache_dir,
        prealigned_sensors_dir=args.prealigned_sensors_dir,
        vocab_dir=args.vocab_dir,
        outdir=args.outdir,
        window_sec=args.window_sec,
        sample_hz=args.sample_hz,
        epochs=args.epochs,
        lr=args.lr,
        batch_size=args.batch_size,
    )
    cmd_train(train_args)
    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# Step 5 – evaluate
# ──────────────────────────────────────────────────────────────────────────────

def cmd_evaluate(args: argparse.Namespace) -> None:
    """Run Stage1 + Stage2 on a manifest and save classification metrics."""
    from sklearn.metrics import (
        accuracy_score, f1_score, precision_score, recall_score,
        classification_report,
    )

    model_dir = Path(args.model_dir)
    outdir    = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_evaluate", output_dir=outdir, use_codecarbon=True)
    _profiler.__enter__()

    # ── Load config & models ──────────────────────────────────────────────────
    with open(model_dir / "config.json", encoding="utf-8") as f:
        cfg_dict = json.load(f)
    cfg = YoloStageConfig(**{k: v for k, v in cfg_dict.items()
                             if k in YoloStageConfig.__dataclass_fields__})

    mean = np.load(model_dir / "norm_mean.npy")
    std  = np.load(model_dir / "norm_std.npy")

    dev = torch.device(cfg.device)

    ck1 = torch.load(model_dir / "stage1.pt", map_location=dev)
    s1  = _EventNet(cfg).to(dev)
    s1.load_state_dict(ck1["model_state"])
    s1.eval()

    ck2 = torch.load(model_dir / "stage2.pt", map_location=dev)
    s2  = _ClassifyNet(cfg).to(dev)
    s2.load_state_dict(ck2["model_state"])
    s2.eval()

    # ── Load vocabularies ────────────────────────────────────────────────────
    vd = Path(args.vocab_dir)
    goal_labels,  goal_lmap,  goal_vocab  = _load_vocab(vd / "vocab_goal.json")
    stim_labels,  stim_lmap,  stim_vocab  = _load_vocab(vd / "vocab_stimuli.json")
    cause_labels, cause_lmap, cause_vocab = _load_vocab(vd / "vocab_cause.json")
    att_labels,   att_lmap,   att_vocab   = _load_vocab(vd / "vocab_attention.json")

    # ── Load records ─────────────────────────────────────────────────────────
    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    em = _eaf_map(Path(args.eaf_parsed_dir) if args.eaf_parsed_dir else None)

    # ── Collect predictions ──────────────────────────────────────────────────
    ev_true_all, ev_pred_all   = [], []
    go_true_all, go_pred_all   = [], []
    st_true_all, st_pred_all   = [], []
    ca_true_all, ca_pred_all   = [], []
    at_true_all, at_pred_all   = [], []

    wl     = cfg.window_len
    stride = max(1, wl // 3)

    for r in tqdm(records, desc="evaluating"):
        sid = r["session_id"]

        pre = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
        if not pre.exists():
            continue
        X_sensor = np.load(pre).astype(np.float32)
        T = X_sensor.shape[0]

        det_path = Path(args.det_cache_dir) / f"{sid}_det.npy"
        if det_path.exists():
            X_det = np.load(det_path).astype(np.float32)
            if X_det.shape[0] != T:
                X_det = np.resize(X_det, (T, cfg.det_dim))
        else:
            X_det = np.zeros((T, cfg.det_dim), dtype=np.float32)

        X = np.concatenate([X_sensor, X_det], axis=1)

        if sid not in em:
            continue
        tiers = _load_eaf_json(em[sid])
        if not tiers:
            continue

        # Prealigned sensor arrays are already time-aligned to video/EAF (step 0 = t=0ms)
        t_offset_s = 0.0

        ev_vec, goal_vec, stim_vec, cause_vec, att_vec = _label_vectors(
            T, cfg.sample_hz, tiers,
            goal_lmap, goal_vocab, stim_lmap, stim_vocab,
            cause_lmap, cause_vocab, att_lmap, att_vocab,
            t_offset_s=t_offset_s)

        Xn = (X - mean) / std

        for k in range(0, T - wl + 1, stride):
            mid = k + wl // 2
            win = torch.from_numpy(Xn[k: k + wl]).unsqueeze(0).to(dev)

            with torch.no_grad():
                ev_logit                    = s1(win)
                ev_p                        = int(ev_logit.argmax(1).item())
                go_logit, st_logit, ca_logit, at_logit = s2(win)
                go_p = int(go_logit.argmax(1).item())
                st_p = int(st_logit.argmax(1).item())
                ca_p = int(ca_logit.argmax(1).item())
                at_p = int(at_logit.argmax(1).item())

            ev_true_all.append(int(ev_vec[mid]))
            ev_pred_all.append(ev_p)

            if goal_vec[mid] >= 0:
                go_true_all.append(int(goal_vec[mid]))
                go_pred_all.append(go_p)

            if stim_vec[mid] >= 0:
                st_true_all.append(int(stim_vec[mid]))
                st_pred_all.append(st_p)

            if cause_vec[mid] >= 0:
                ca_true_all.append(int(cause_vec[mid]))
                ca_pred_all.append(ca_p)

            if att_vec[mid] >= 0:
                at_true_all.append(int(att_vec[mid]))
                at_pred_all.append(at_p)

    if not ev_true_all:
        print("ERROR: no evaluation data found.")
        return

    # ── Stage 1 metrics ───────────────────────────────────────────────────────
    ev_true = np.array(ev_true_all)
    ev_pred = np.array(ev_pred_all)

    s1_metrics = {
        "accuracy":          round(float(accuracy_score(ev_true, ev_pred)), 4),
        "f1_macro":          round(float(f1_score(ev_true, ev_pred, average="macro",  zero_division=0)), 4),
        "f1_no_event":       round(float(f1_score(ev_true, ev_pred, labels=[0], average="macro", zero_division=0)), 4),
        "f1_event":          round(float(f1_score(ev_true, ev_pred, labels=[1], average="macro", zero_division=0)), 4),
        "precision_macro":   round(float(precision_score(ev_true, ev_pred, average="macro", zero_division=0)), 4),
        "recall_macro":      round(float(recall_score(ev_true, ev_pred, average="macro",    zero_division=0)), 4),
        "n_windows":         int(len(ev_true)),
        "n_event_windows":   int(ev_true.sum()),
        "report":            classification_report(ev_true, ev_pred,
                                 target_names=["no_event", "event"],
                                 zero_division=0),
    }

    out1 = outdir / "metrics_stage1.json"
    with open(out1, "w", encoding="utf-8") as f:
        json.dump({k: v for k, v in s1_metrics.items() if k != "report"}, f, indent=2)
    print(f"\n── Stage 1 (event detection) ──")
    print(s1_metrics["report"])
    print(f"Saved → {out1}")

    # ── Stage 2 metrics ───────────────────────────────────────────────────────
    s2_metrics: dict = {}

    for name, y_true_list, y_pred_list, labels in [
        ("goal",      go_true_all, go_pred_all, goal_labels),
        ("stimuli",   st_true_all, st_pred_all, stim_labels),
        ("cause",     ca_true_all, ca_pred_all, cause_labels),
        ("attention", at_true_all, at_pred_all, att_labels),
    ]:
        if not y_true_list:
            s2_metrics[name] = {"error": "no labelled windows"}
            continue

        yt = np.array(y_true_list)
        yp = np.array(y_pred_list)
        present = sorted(set(yt.tolist()) | set(yp.tolist()))
        present_names = [labels[i] if i < len(labels) else str(i) for i in present]

        per_class_f1 = f1_score(yt, yp, labels=present, average=None, zero_division=0)

        s2_metrics[name] = {
            "accuracy":        round(float(accuracy_score(yt, yp)), 4),
            "f1_macro":        round(float(f1_score(yt, yp, average="macro",  zero_division=0)), 4),
            "f1_weighted":     round(float(f1_score(yt, yp, average="weighted", zero_division=0)), 4),
            "precision_macro": round(float(precision_score(yt, yp, average="macro", zero_division=0)), 4),
            "recall_macro":    round(float(recall_score(yt, yp, average="macro",    zero_division=0)), 4),
            "n_windows":       int(len(yt)),
            "per_class_f1":    {n: round(float(v), 4)
                                for n, v in zip(present_names, per_class_f1)},
            "report":          classification_report(yt, yp,
                                   labels=present, target_names=present_names,
                                   zero_division=0),
        }

    out2 = outdir / "metrics_stage2.json"
    with open(out2, "w", encoding="utf-8") as f:
        json.dump(
            {k: {m: v for m, v in d.items() if m != "report"}
             for k, d in s2_metrics.items()},
            f, indent=2,
        )
    for head in ("goal", "stimuli", "cause", "attention"):
        print(f"\n── Stage 2 ({head}) ──")
        if "report" in s2_metrics.get(head, {}):
            print(s2_metrics[head]["report"])
    print(f"Saved → {out2}")
    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# CLI
# ──────────────────────────────────────────────────────────────────────────────

def _add_common(p: argparse.ArgumentParser) -> None:
    p.add_argument("--sample-hz",   default=3.0,   type=float)
    p.add_argument("--window-sec",  default=5.0,   type=float)
    p.add_argument("--epochs",      default=30,    type=int)
    p.add_argument("--lr",          default=1e-4,  type=float)
    p.add_argument("--batch-size",  default=32,    type=int)


def main() -> None:
    pa  = argparse.ArgumentParser(description="Two-stage EAF + YOLOv8 pipeline")
    sub = pa.add_subparsers(dest="cmd", required=True)

    # ── extract ──────────────────────────────────────────────────────────────
    p_ext = sub.add_parser("extract", help="Run YOLOv8 on videos, cache .npy features")
    p_ext.add_argument("--manifest",               required=True, type=Path)
    p_ext.add_argument("--det-cache-dir",           required=True, type=Path)
    p_ext.add_argument("--yolo-model",             default="yolov8n.pt", type=str)
    p_ext.add_argument("--prealigned-sensors-dir", default=None,  type=Path)
    p_ext.add_argument("--overwrite",              action="store_true")
    p_ext.add_argument("--sample-hz",              default=3.0,   type=float)

    # ── train ─────────────────────────────────────────────────────────────────
    p_tr = sub.add_parser("train", help="Train Stage1+Stage2 with sensor+detection")
    p_tr.add_argument("--manifest",               required=True, type=Path)
    p_tr.add_argument("--eaf-parsed-dir",         required=True, type=Path)
    p_tr.add_argument("--det-cache-dir",           required=True, type=Path)
    p_tr.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p_tr.add_argument("--vocab-dir",              required=True, type=Path)
    p_tr.add_argument("--outdir",                 required=True, type=Path)
    _add_common(p_tr)

    # ── validate ──────────────────────────────────────────────────────────────
    p_val = sub.add_parser("validate", help="Compute EAF annotation agreement scores")
    p_val.add_argument("--manifest",         required=True, type=Path)
    p_val.add_argument("--eaf-parsed-dir",   required=True, type=Path)
    p_val.add_argument("--det-cache-dir",    required=True, type=Path)
    p_val.add_argument("--vocab-dir",        required=True, type=Path)
    p_val.add_argument("--outdir",           required=True, type=Path)
    p_val.add_argument("--sample-hz",        default=3.0,   type=float)
    p_val.add_argument("--threshold",        default=0.15,  type=float,
                       help="Detection confidence threshold to count as 'detected'")
    p_val.add_argument("--min-agreement",    default=0.30,  type=float,
                       help="Agreement score below which annotation is flagged")

    # ── filter-retrain ────────────────────────────────────────────────────────
    p_fr = sub.add_parser("filter-retrain",
                           help="Remove low-agreement EAF annotations and retrain")
    p_fr.add_argument("--validation-dir",          required=True, type=Path)
    p_fr.add_argument("--min-agreement",           default=0.30,  type=float)
    p_fr.add_argument("--manifest",               required=True, type=Path)
    p_fr.add_argument("--eaf-parsed-dir",         required=True, type=Path)
    p_fr.add_argument("--det-cache-dir",           required=True, type=Path)
    p_fr.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p_fr.add_argument("--vocab-dir",              required=True, type=Path)
    p_fr.add_argument("--outdir",                 required=True, type=Path)
    _add_common(p_fr)

    # ── evaluate ──────────────────────────────────────────────────────────────
    p_ev = sub.add_parser("evaluate", help="Evaluate Stage1+Stage2 and save metrics")
    p_ev.add_argument("--manifest",               required=True, type=Path)
    p_ev.add_argument("--model-dir",              required=True, type=Path,
                      help="Directory with stage1.pt, stage2.pt, config.json (train outdir)")
    p_ev.add_argument("--eaf-parsed-dir",         required=True, type=Path)
    p_ev.add_argument("--det-cache-dir",          required=True, type=Path)
    p_ev.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p_ev.add_argument("--vocab-dir",              required=True, type=Path)
    p_ev.add_argument("--outdir",                 required=True, type=Path)
    p_ev.add_argument("--sample-hz",              default=3.0,   type=float)

    args = pa.parse_args()
    {
        "extract":        cmd_extract,
        "train":          cmd_train,
        "validate":       cmd_validate,
        "filter-retrain": cmd_filter_retrain,
        "evaluate":       cmd_evaluate,
    }[args.cmd](args)


if __name__ == "__main__":
    main()
