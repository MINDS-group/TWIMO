#!/usr/bin/env python
"""Two-stage EAF model with YOLOv8 – IMPROVED version.

Strategies (select any combination via --strategies):
  1a  Remove Stage 1 entirely.  Stage 2 is trained on ALL windows using
      class-0 ("unknown") as the implicit no-event label.  At inference
      the model always runs Stage 2; "no event" is when Goal=unknown.
  1b  Weaken Stage 1 (soft threshold).  Event detection fires when
      P(event) >= --stage1-threshold (default 0.30) instead of argmax.
  2   Zone-based detection features (+12 features).  The frame is divided
      into semantic zones (ego-lane, adjacent, oncoming, sidewalk) so the
      model can distinguish a pedestrian in the road from one on the
      pavement, or a car ahead from one in the oncoming lane.
  3   Better label assignment.  Instead of taking only the label at the
      window mid-point, majority-vote over all labeled timesteps in the
      window is used.  This creates many more labelled examples per event.
  4   Class weighting in Stage 2.  Inverse-frequency loss weights are
      applied to all four classification heads to handle rare classes.
  5   Motion features (+5 features).  Vehicle approach speed, pedestrian
      movement, lateral vehicle motion, TTC proxy, and scene motion are
      estimated from consecutive frames during extract-improved.
  6   Top-K vehicle tracking (+9 features).  The 3 closest vehicles are
      tracked individually with (cx, cy, size) so the model can distinguish
      one car ahead from two side-by-side cars at an intersection.
  7   Longer window.  Uses a 10-second window instead of 5 seconds.

  Notes
  -----
  * Strategies 1a and 1b are mutually exclusive (1a takes precedence).
  * Strategies 2, 5, 6 require running ``extract-improved`` first to
    build the extended detection cache (shape T×39).
  * Strategies 1a/1b/3/4/7 only modify training and can reuse the
    original 13-dim detection cache.

Commands (run in order):
  extract-improved   Run YOLOv8 on videos, cache extended (T, 39) .npy files
  train              Train with selected strategies
  evaluate           Evaluate trained model and print per-head metrics

Example usage:
  # 1) Extract improved detection features (once)
  python twimo/strategies_eaf/two_stage_yolo_improved.py extract-improved \\
      --manifest ./artifacts/manifest.jsonl \\
      --det-cache-dir ./artifacts/eaf/det_cache_imp \\
      --yolo-model yolov8n.pt --sample-hz 3

  # 2) Train with strategies 1a + 2 + 3 + 4
  python twimo/strategies_eaf/two_stage_yolo_improved.py train \\
      --manifest ./artifacts/manifest.jsonl \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --det-cache-dir ./artifacts/eaf/det_cache_imp \\
      --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/eaf/improved_1a234 \\
      --strategies 1a 2 3 4 --epochs 40

  # 3) Evaluate
  python twimo/strategies_eaf/two_stage_yolo_improved.py evaluate \\
      --manifest ./artifacts/manifest.jsonl \\
      --model-dir ./artifacts/eaf/improved_1a234 \\
      --eaf-parsed-dir ./artifacts/eaf/parsed \\
      --det-cache-dir ./artifacts/eaf/det_cache_imp \\
      --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
      --vocab-dir ./artifacts/eaf/vocabs \\
      --outdir ./artifacts/eaf/eval_improved_1a234
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
from dataclasses import dataclass, field
from pathlib import Path
from typing import Any, Dict, List, Optional, Tuple

sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import cv2
import time
import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F
from tqdm import tqdm

from twimo.utils.profiling import TrainingProfiler

# ── Re-use shared utilities from the base module ──────────────────────────────
from twimo.strategies_eaf.two_stage_yolo import (
    COCO_PERSON, COCO_BICYCLE, COCO_MOTORCYCLE,
    COCO_CAR, COCO_BUS, COCO_TRUCK,
    COCO_TRAFFIC_LIGHT, COCO_STOP_SIGN,
    VEHICLE_IDS, HEAVY_IDS,
    _classify_tl_color,
    _load_vocab, _map_raw, _load_eaf_json, _eaf_map, _get_tier, _label_at,
    _compute_sensor_video_offset,
    _EventNet, _ClassifyNet, _AttentionPool,
)

# ──────────────────────────────────────────────────────────────────────────────
# Extended detection feature layout  (D_IMP = 39)
# ──────────────────────────────────────────────────────────────────────────────

D_IMP = 39  # full improved detection vector dimension

# Feature blocks: which column indices belong to each strategy
FEAT_BLOCKS: Dict[str, List[int]] = {
    "base":   list(range(0,  13)),   # original 13 features  (always included)
    "zones":  list(range(13, 25)),   # +12 zone features     (strategy 2)
    "motion": list(range(25, 30)),   # +5  motion features   (strategy 5)
    "topk":   list(range(30, 39)),   # +9  top-K vehicles    (strategy 6)
}

DET_FEATURE_NAMES_IMP: List[str] = [
    # ── Base (0–12) — identical to original ───────────────────────────────────
    "tl_red", "tl_yellow", "tl_green",
    "stop_sign",
    "pedestrian_near",
    "vehicle_ahead", "vehicle_cross", "vehicle_parked",
    "bicycle", "motorcycle", "heavy_vehicle",
    "vehicle_count", "congestion",
    # ── Zone features (13–24) — strategy 2 ───────────────────────────────────
    "vehicle_ego_lane",     # vehicle in ego lane  (cx 0.30–0.70, not far away)
    "vehicle_ego_close",    # vehicle very close   (cx 0.30–0.70, cy > 0.65)
    "vehicle_adj_left",     # vehicle left lane    (cx 0.10–0.30)
    "vehicle_adj_right",    # vehicle right lane   (cx 0.70–0.90)
    "vehicle_oncoming",     # oncoming vehicle     (cx 0.25–0.75, cy < 0.35)
    "pedestrian_ego_lane",  # pedestrian in road   (cx 0.25–0.75, cy > 0.40)
    "pedestrian_sidewalk",  # pedestrian on edge   (cx < 0.20 or cx > 0.80)
    "pedestrian_crossing",  # pedestrian crossing  (center horiz, mid height)
    "tl_ego_center",        # traffic light ahead  (cx 0.30–0.70)
    "bicycle_in_lane",      # bicycle in ego lane  (cx 0.25–0.75)
    "motorcycle_in_lane",   # moto in ego lane     (cx 0.25–0.75)
    "heavy_in_ego",         # bus/truck in ego     (cx 0.30–0.70)
    # ── Motion features (25–29) — strategy 5 ─────────────────────────────────
    "vehicle_approaching",  # vehicle size growth  (approaching ego)
    "pedestrian_moving",    # pedestrian centroid  delta between frames
    "vehicle_lateral_move", # vehicle cx delta     (lane change / cut-in)
    "ttc_proxy",            # time-to-contact      proxy (inverted, clipped)
    "scene_motion",         # frame-diff on ROI    (overall scene motion)
    # ── Top-K vehicles (30–38) — strategy 6 ──────────────────────────────────
    "v1_cx", "v1_cy", "v1_size",   # closest vehicle position + relative size
    "v2_cx", "v2_cy", "v2_size",   # 2nd vehicle
    "v3_cx", "v3_cy", "v3_size",   # 3rd vehicle
]

# Extended cause → detection feature mapping (includes zone features)
CAUSE_TO_DET_IMP: Dict[str, List[int]] = {
    "red_light":                    [0, 8 + 5],       # tl_red, tl_ego_center (idx 21)
    "yellow_light":                 [1, 8 + 5],
    "sign":                         [3],
    "crossing_pedestrian":          [4, 18, 20],      # near + ego_lane + crossing
    "pedestrian_near_ego_lane":     [4, 18],
    "crossing_vehicle":             [5, 6, 13, 17],   # ahead + cross + ego_lane + oncoming
    "cut-in":                       [6, 15, 16],      # cross + adj_left + adj_right
    "merging_vehicle":              [6, 15, 16],
    "turning_vehicle":              [6, 17],
    "parked_vehicle":               [7],
    "on-road_bicyclist":            [8, 22],          # bicycle + bicycle_in_lane
    "on-road_motorcyclist":         [9, 23],
    "congestion":                   [11, 12, 13, 14], # count + area + ego + close
    "road_work":                    [],
    "park":                         [],
}


# ──────────────────────────────────────────────────────────────────────────────
# Improved configuration dataclass
# ──────────────────────────────────────────────────────────────────────────────

@dataclass
class ImpConfig:
    """Extended configuration with strategy flags."""
    # ── Shared with YoloStageConfig ───────────────────────────────────────────
    window_sec:           float = 5.0
    sample_hz:            float = 3.0
    d_model:              int   = 128
    nhead:                int   = 4
    num_layers:           int   = 3
    dim_ff:               int   = 256
    dropout:              float = 0.1
    batch_size:           int   = 32
    epochs:               int   = 30
    lr:                   float = 1e-4
    n_goal_classes:       int   = 14
    n_stimuli_classes:    int   = 9
    n_cause_classes:      int   = 17
    n_attention_classes:  int   = 17
    sensor_dim:           int   = 8
    device:               str   = ""
    # ── New fields ────────────────────────────────────────────────────────────
    strategies:           List[str] = field(default_factory=list)
    stage1_threshold:     float     = 0.30   # used by strategy 1b
    rtk_dim:              int       = 0      # 6 when RTK features are used

    def __post_init__(self):
        if not self.device:
            self.device = "cuda" if torch.cuda.is_available() else "cpu"
        # 1a takes precedence over 1b
        if "1a" in self.strategies and "1b" in self.strategies:
            self.strategies = [s for s in self.strategies if s != "1b"]
        # Strategy 7: extend window to 10 seconds
        if "7" in self.strategies:
            self.window_sec = 10.0

    # ── Computed properties (not stored as dataclass fields) ──────────────────

    @property
    def uses_improved_det(self) -> bool:
        return any(s in self.strategies for s in ("2", "5", "6"))

    def active_det_cols(self) -> List[int]:
        """Column indices from improved det vector to include in model input."""
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
    def input_dim(self) -> int:
        return self.sensor_dim + self.det_dim + self.rtk_dim

    @property
    def window_len(self) -> int:
        return int(self.window_sec * self.sample_hz)


def _imp_config_to_dict(cfg: ImpConfig) -> dict:
    """Serialize ImpConfig to a JSON-compatible dict (includes computed values)."""
    d = {k: getattr(cfg, k) for k in cfg.__dataclass_fields__}
    d["det_dim"]   = cfg.det_dim    # informational
    d["input_dim"] = cfg.input_dim  # informational
    return d


def _imp_config_from_dict(d: dict) -> ImpConfig:
    """Load ImpConfig from a JSON dict; ignores computed keys."""
    allowed = set(ImpConfig.__dataclass_fields__.keys())
    return ImpConfig(**{k: v for k, v in d.items() if k in allowed})


# ──────────────────────────────────────────────────────────────────────────────
# Extended detection feature extraction  (produces D_IMP = 39 features)
# ──────────────────────────────────────────────────────────────────────────────

def _extract_det_features_imp(
    result,
    frame_bgr:       np.ndarray,
    prev_veh_boxes:  Optional[List[Tuple]] = None,  # (cx,cy,area_norm) per vehicle
    prev_ped_boxes:  Optional[List[Tuple]] = None,  # (cx,cy) per pedestrian
    prev_roi:        Optional[np.ndarray]  = None,  # bottom-half gray ROI prev frame
) -> Tuple[np.ndarray, List[Tuple], List[Tuple], np.ndarray]:
    """Convert one YOLO result into a (D_IMP=39,) detection feature vector.

    Returns
    -------
    feat          : (39,) float32 feature vector
    curr_veh_boxes: (cx, cy, area_norm) for each vehicle in this frame
    curr_ped_boxes: (cx, cy) for each pedestrian in this frame
    curr_roi      : bottom-half grayscale ROI for next-frame motion computation
    """
    feat = np.zeros(D_IMP, dtype=np.float32)
    fh, fw = frame_bgr.shape[:2]
    frame_area = float(fh * fw)

    # ── Scene motion (index 29) – computed regardless of detections ───────────
    roi_start   = fh // 2
    curr_roi_bgr = frame_bgr[roi_start:]
    curr_roi    = cv2.cvtColor(curr_roi_bgr, cv2.COLOR_BGR2GRAY).astype(np.float32)
    if prev_roi is not None and prev_roi.shape == curr_roi.shape:
        scene_motion = float(np.mean(np.abs(curr_roi - prev_roi))) / 255.0
        feat[29] = min(1.0, scene_motion * 6.0)   # amplify subtle motion

    curr_veh_boxes: List[Tuple] = []
    curr_ped_boxes: List[Tuple] = []

    if result is None or result.boxes is None or len(result.boxes) == 0:
        return feat, curr_veh_boxes, curr_ped_boxes, curr_roi

    vehicle_count = 0
    vehicle_area  = 0.0
    vehicle_dets: List[Tuple] = []   # (cx, cy, size_norm, conf, cls_id)

    for box in result.boxes:
        cls_id    = int(box.cls[0])
        conf      = float(box.conf[0])
        x1, y1, x2, y2 = box.xyxy[0].tolist()
        bbox_area = (x2 - x1) * (y2 - y1)
        cx_norm   = (x1 + x2) / (2.0 * fw)    # 0=left, 1=right
        cy_norm   = (y1 + y2) / (2.0 * fh)    # 0=top,  1=bottom (larger=closer)
        size_norm = bbox_area / frame_area

        # ── Traffic light ────────────────────────────────────────────────────
        if cls_id == COCO_TRAFFIC_LIGHT:
            color = _classify_tl_color(frame_bgr, (x1, y1, x2, y2))
            if color == "red":
                feat[0] = max(feat[0], conf)
            elif color == "yellow":
                feat[1] = max(feat[1], conf)
            elif color == "green":
                feat[2] = max(feat[2], conf)
            # Zone: traffic light centered → affects ego vehicle
            if 0.30 <= cx_norm <= 0.70:
                feat[21] = max(feat[21], conf)   # tl_ego_center

        # ── Stop sign ────────────────────────────────────────────────────────
        elif cls_id == COCO_STOP_SIGN:
            feat[3] = max(feat[3], conf)

        # ── Pedestrian ───────────────────────────────────────────────────────
        elif cls_id == COCO_PERSON:
            # Base: proximity-weighted confidence (original formula)
            prox = cy_norm * min(1.0, size_norm * 50.0)
            feat[4] = max(feat[4], conf * min(1.0, prox))

            curr_ped_boxes.append((cx_norm, cy_norm))

            # Zone features (strategy 2)
            in_ego_h   = 0.25 <= cx_norm <= 0.75
            on_sidewalk = cx_norm < 0.20 or cx_norm > 0.80
            in_road_v  = cy_norm > 0.40

            if in_ego_h and in_road_v:
                feat[18] = max(feat[18], conf)                 # pedestrian_ego_lane
            if on_sidewalk:
                feat[19] = max(feat[19], conf)                 # pedestrian_sidewalk
            # Crossing zone: centre horizontal + mid-frame height
            if 0.20 <= cx_norm <= 0.80 and 0.30 <= cy_norm <= 0.70:
                feat[20] = max(feat[20], conf)                 # pedestrian_crossing

        # ── Vehicle (car / bus / truck) ───────────────────────────────────────
        elif cls_id in VEHICLE_IDS:
            vehicle_count += 1
            vehicle_area  += bbox_area
            side_dist      = abs(cx_norm - 0.5) * 2.0

            curr_veh_boxes.append((cx_norm, cy_norm, size_norm))
            vehicle_dets.append((cx_norm, cy_norm, size_norm, conf, cls_id))

            # Base features (original)
            if side_dist < 0.35:
                feat[5] = max(feat[5], conf)             # vehicle_ahead
            else:
                feat[6] = max(feat[6], conf)             # vehicle_cross
            if cy_norm > 0.80 and size_norm < 0.04:
                feat[7] = max(feat[7], conf * 0.6)      # vehicle_parked
            if cls_id in HEAVY_IDS:
                feat[10] = max(feat[10], conf)           # heavy_vehicle

            # Zone features (strategy 2)
            in_ego   = 0.30 <= cx_norm <= 0.70
            adj_left = 0.10 <= cx_norm <  0.30
            adj_right= 0.70 <  cx_norm <= 0.90
            close    = cy_norm > 0.65
            far      = cy_norm < 0.35

            if in_ego and cy_norm > 0.35:
                feat[13] = max(feat[13], conf)           # vehicle_ego_lane
            if in_ego and close:
                feat[14] = max(feat[14], conf)           # vehicle_ego_close
            if adj_left:
                feat[15] = max(feat[15], conf)           # vehicle_adj_left
            if adj_right:
                feat[16] = max(feat[16], conf)           # vehicle_adj_right
            if 0.25 <= cx_norm <= 0.75 and far:
                feat[17] = max(feat[17], conf)           # vehicle_oncoming
            if cls_id in HEAVY_IDS and in_ego:
                feat[24] = max(feat[24], conf)           # heavy_in_ego

        # ── Bicycle ───────────────────────────────────────────────────────────
        elif cls_id == COCO_BICYCLE:
            feat[8] = max(feat[8], conf)
            if 0.25 <= cx_norm <= 0.75:
                feat[22] = max(feat[22], conf)           # bicycle_in_lane

        # ── Motorcycle ────────────────────────────────────────────────────────
        elif cls_id == COCO_MOTORCYCLE:
            feat[9] = max(feat[9], conf)
            if 0.25 <= cx_norm <= 0.75:
                feat[23] = max(feat[23], conf)           # motorcycle_in_lane

    # ── Aggregate vehicle stats (base) ────────────────────────────────────────
    feat[11] = min(1.0, vehicle_count / 10.0)
    feat[12] = min(1.0, vehicle_area  / (frame_area * 0.5))

    # ── Motion features (strategy 5) — indices 25–29 ─────────────────────────
    if curr_veh_boxes and prev_veh_boxes:
        max_approach = 0.0
        max_lateral  = 0.0
        best_ttc     = 0.0
        for cx_c, cy_c, sz_c in curr_veh_boxes:
            # Find best-matching vehicle in previous frame (nearest centroid)
            best_dist  = float("inf")
            best_prev  = None
            for cx_p, cy_p, sz_p in prev_veh_boxes:
                d = (cx_c - cx_p) ** 2 + (cy_c - cy_p) ** 2
                if d < best_dist:
                    best_dist = d
                    best_prev = (cx_p, cy_p, sz_p)
            if best_prev is None or best_dist > 0.10:   # > ~31% of frame
                continue
            cx_p, cy_p, sz_p = best_prev
            delta_size    = sz_c - sz_p                 # positive = approaching
            delta_lateral = abs(cx_c - cx_p)
            if delta_size > 0:
                max_approach = max(max_approach, min(1.0, delta_size / 0.005))
                ttc = sz_c / max(delta_size, 1e-6)
                # Normalize: ttc < 20 frames is dangerous
                best_ttc = max(best_ttc, min(1.0, 2.0 / max(ttc, 2.0)))
            max_lateral = max(max_lateral, min(1.0, delta_lateral / 0.08))
        feat[25] = max_approach                         # vehicle_approaching
        feat[27] = max_lateral                          # vehicle_lateral_move
        feat[28] = best_ttc                             # ttc_proxy

    if curr_ped_boxes and prev_ped_boxes:
        max_ped_move = 0.0
        for cx_c, cy_c in curr_ped_boxes:
            best_d = float("inf")
            for cx_p, cy_p in prev_ped_boxes:
                d = (cx_c - cx_p) ** 2 + (cy_c - cy_p) ** 2
                if d < best_d:
                    best_d = d
            if best_d < 0.10:
                max_ped_move = max(max_ped_move, min(1.0, best_d ** 0.5 / 0.05))
        feat[26] = max_ped_move                         # pedestrian_moving

    # ── Top-K vehicles (strategy 6) — indices 30–38 ──────────────────────────
    # Sort by size descending (largest = closest = most relevant)
    vehicle_dets_sorted = sorted(vehicle_dets, key=lambda x: x[2], reverse=True)
    for ki, (vcx, vcy, vsz, _vc, _cls) in enumerate(vehicle_dets_sorted[:3]):
        base        = 30 + ki * 3
        feat[base]     = vcx
        feat[base + 1] = vcy
        feat[base + 2] = min(1.0, vsz * 15.0)   # scale: 1.0 at ~7% frame area

    return feat, curr_veh_boxes, curr_ped_boxes, curr_roi


# ──────────────────────────────────────────────────────────────────────────────
# Label building  (strategy 3 support)
# ──────────────────────────────────────────────────────────────────────────────

def _label_vectors(
    T: int, sample_hz: float,
    tiers: Dict[str, List[dict]],
    goal_lmap,  goal_vocab,
    stim_lmap,  stim_vocab,
    cause_lmap, cause_vocab,
    att_lmap,   att_vocab,
    t_offset_s: float = 0.0,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Build per-timestep (T,) label arrays for ev/goal/stim/cause/attn.
    Identical to the original – strategy-3 logic lives in _build_windows_improved.
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
            continue
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


def _majority(arr: np.ndarray) -> int:
    """Return the most frequent non-negative label, or -1 if none."""
    valid = arr[arr >= 0]
    if len(valid) == 0:
        return -1
    return int(np.bincount(valid.astype(np.intp)).argmax())


def _build_windows_improved(
    X:          np.ndarray,
    mean:       np.ndarray,
    std:        np.ndarray,
    goal_vec:   np.ndarray,
    stim_vec:   np.ndarray,
    ev_vec:     np.ndarray,
    cause_vec:  np.ndarray,
    att_vec:    np.ndarray,
    window_len: int,
    stride:     int  = 1,
    strategy3:  bool = False,
    strategy1a: bool = False,
) -> Tuple[np.ndarray, ...]:
    """Slide window over X; return (wins, ev, goal, stim, cause, att) arrays.

    Strategy 3  – Instead of the midpoint label, use majority-vote over all
                  labelled timesteps in the window → more labelled examples.
    Strategy 1a – Replace remaining -1 (unlabelled) labels with 0 (unknown),
                  so Stage 2 learns to predict "unknown" for quiet periods.
    """
    Xn   = (X - mean) / std
    T    = X.shape[0]
    wins, ev_l, go_l, st_l, ca_l, at_l = [], [], [], [], [], []

    for k in range(0, T - window_len + 1, stride):
        wins.append(Xn[k: k + window_len])

        if not strategy3:
            mid = k + window_len // 2
            ev_l.append(int(ev_vec[mid]))
            go_l.append(int(goal_vec[mid]))
            st_l.append(int(stim_vec[mid]))
            ca_l.append(int(cause_vec[mid]))
            at_l.append(int(att_vec[mid]))
        else:
            # Strategy 3: look at the entire window span
            w_ev = ev_vec[k: k + window_len]
            ev_l.append(int(w_ev.max()))                       # event if any step is labelled
            go_l.append(_majority(goal_vec[k: k + window_len]))
            st_l.append(_majority(stim_vec[k: k + window_len]))
            ca_l.append(_majority(cause_vec[k: k + window_len]))
            at_l.append(_majority(att_vec[k: k + window_len]))

    if not wins:
        empty = np.empty(0, dtype=np.int64)
        return (np.empty((0, window_len, X.shape[1]), dtype=np.float32),
                empty, empty, empty, empty, empty)

    ev_arr = np.array(ev_l,  dtype=np.int64)
    go_arr = np.array(go_l,  dtype=np.int64)
    st_arr = np.array(st_l,  dtype=np.int64)
    ca_arr = np.array(ca_l,  dtype=np.int64)
    at_arr = np.array(at_l,  dtype=np.int64)

    # Strategy 1a: substitute -1 with 0 (unknown) so the model learns
    # to output "unknown" when there is no annotation.
    if strategy1a:
        go_arr = np.where(go_arr == -1, 0, go_arr)
        st_arr = np.where(st_arr == -1, 0, st_arr)
        ca_arr = np.where(ca_arr == -1, 0, ca_arr)
        at_arr = np.where(at_arr == -1, 0, at_arr)

    return (np.stack(wins).astype(np.float32),
            ev_arr, go_arr, st_arr, ca_arr, at_arr)


# ──────────────────────────────────────────────────────────────────────────────
# Class weight helper  (strategy 4)
# ──────────────────────────────────────────────────────────────────────────────

def _class_weights(labels: np.ndarray, n_classes: int,
                   device: torch.device) -> Optional[torch.Tensor]:
    """Inverse-frequency class weights, clipped to [0.1, 10]."""
    valid = labels[labels >= 0]
    if len(valid) == 0:
        return None
    counts = np.bincount(valid, minlength=n_classes).astype(np.float32)
    counts = np.maximum(counts, 1.0)
    weights = len(valid) / (n_classes * counts)
    weights = np.clip(weights, 0.1, 10.0).astype(np.float32)
    return torch.from_numpy(weights).to(device)


# ──────────────────────────────────────────────────────────────────────────────
# Inference helper  (all strategy combinations)
# ──────────────────────────────────────────────────────────────────────────────

def _predict_improved(
    X_full: np.ndarray,
    mean:   np.ndarray,
    std:    np.ndarray,
    s1:     Optional[nn.Module],
    s2:     nn.Module,
    cfg:    ImpConfig,
    bs:     int = 64,
) -> Tuple[np.ndarray, ...]:
    """Batch inference for all windows.

    Returns
    -------
    ev_p   : (N,) int  event flag
    g_p    : (N,) int  goal class
    g_pr   : (N,) f32  goal confidence
    s_p    : (N,) int  stimuli class
    s_pr   : (N,) f32  stimuli confidence
    c_p    : (N,) int  cause class
    c_pr   : (N,) f32  cause confidence
    a_p    : (N,) int  attention class
    a_pr   : (N,) f32  attention confidence
    ev_prb : (N,) f32  Stage-1 event probability (for 1b display)
    """
    T, _ = X_full.shape
    wl    = cfg.window_len
    N     = max(0, T - wl + 1)

    ev_p  = np.zeros(N, dtype=np.int64)
    ev_prb= np.zeros(N, dtype=np.float32)
    g_p   = np.zeros(N, dtype=np.int64);  g_pr = np.zeros(N, dtype=np.float32)
    s_p   = np.zeros(N, dtype=np.int64);  s_pr = np.zeros(N, dtype=np.float32)
    c_p   = np.zeros(N, dtype=np.int64);  c_pr = np.zeros(N, dtype=np.float32)
    a_p   = np.zeros(N, dtype=np.int64);  a_pr = np.zeros(N, dtype=np.float32)

    if N == 0:
        return ev_p, g_p, g_pr, s_p, s_pr, c_p, c_pr, a_p, a_pr, ev_prb

    Xn          = (X_full - mean) / std
    strategies  = cfg.strategies
    use_1a      = "1a" in strategies
    use_1b      = "1b" in strategies

    # Determine device from whichever model is available
    _ref_model = s1 if s1 is not None else s2
    _dev = next(_ref_model.parameters()).device

    with torch.no_grad():
        # ── Stage 1 ───────────────────────────────────────────────────────────
        if not use_1a and s1 is not None:
            for st in range(0, N, bs):
                en  = min(st + bs, N)
                bx  = torch.from_numpy(np.stack([Xn[k: k + wl] for k in range(st, en)])).to(_dev)
                lg  = s1(bx)                    # (B, 2)
                prb = torch.softmax(lg, 1)
                ev_prb[st:en] = prb[:, 1].cpu().numpy()
                if use_1b:
                    ev_p[st:en] = (ev_prb[st:en] >= cfg.stage1_threshold).astype(np.int64)
                else:
                    ev_p[st:en] = lg.argmax(1).cpu().numpy()
            run_idx = np.where(ev_p == 1)[0]
        else:
            # Strategy 1a: run Stage 2 on every window
            ev_p[:]  = 1
            ev_prb[:] = 1.0
            run_idx  = np.arange(N)

        # ── Stage 2 ───────────────────────────────────────────────────────────
        for i in range(0, len(run_idx), bs):
            chunk = run_idx[i: i + bs]
            bx    = torch.from_numpy(np.stack([Xn[k: k + wl] for k in chunk])).to(_dev)
            gl, sl, cl, al = s2(bx)
            gpr = torch.softmax(gl, 1); spr = torch.softmax(sl, 1)
            cpr = torch.softmax(cl, 1); apr = torch.softmax(al, 1)
            g_p[chunk] = gpr.argmax(1).cpu().numpy(); g_pr[chunk] = gpr.max(1).values.cpu().numpy()
            s_p[chunk] = spr.argmax(1).cpu().numpy(); s_pr[chunk] = spr.max(1).values.cpu().numpy()
            c_p[chunk] = cpr.argmax(1).cpu().numpy(); c_pr[chunk] = cpr.max(1).values.cpu().numpy()
            a_p[chunk] = apr.argmax(1).cpu().numpy(); a_pr[chunk] = apr.max(1).values.cpu().numpy()

        # Strategy 1a post-process: event = goal != unknown (class 0)
        if use_1a:
            ev_p[:] = (g_p != 0).astype(np.int64)

    return ev_p, g_p, g_pr, s_p, s_pr, c_p, c_pr, a_p, a_pr, ev_prb


# ──────────────────────────────────────────────────────────────────────────────
# Helper: load features from det cache (original or improved)
# ──────────────────────────────────────────────────────────────────────────────

def _load_det(det_cache_dir: Optional[Path], sid: str,
              T: int, cfg: ImpConfig) -> np.ndarray:
    """Load and select detection columns based on active strategies.

    If the improved cache exists (T × 39) use it and select columns.
    Otherwise fall back to the original 13-dim cache.
    Falls back to zeros if neither exists.
    """
    if det_cache_dir is None:
        return np.zeros((T, cfg.det_dim), dtype=np.float32)

    imp_path = det_cache_dir / f"{sid}_det_imp.npy"
    org_path = det_cache_dir / f"{sid}_det.npy"

    if imp_path.exists():
        arr = np.load(imp_path).astype(np.float32)
        if arr.shape[0] != T:
            arr = np.resize(arr, (T, D_IMP))
        cols = cfg.active_det_cols()
        return arr[:, cols]

    if org_path.exists():
        arr = np.load(org_path).astype(np.float32)
        if arr.shape[0] != T:
            arr = np.resize(arr, (T, 13))
        if cfg.det_dim > 13:
            print(f"  [WARN] strategies 2/5/6 need improved cache for {sid}; padding with zeros")
            pad = np.zeros((T, cfg.det_dim - 13), dtype=np.float32)
            return np.concatenate([arr, pad], axis=1)
        return arr[:, :cfg.det_dim]

    return np.zeros((T, cfg.det_dim), dtype=np.float32)


# ──────────────────────────────────────────────────────────────────────────────
# Post-training evaluation helpers
# ──────────────────────────────────────────────────────────────────────────────

def _day_split_imp(
    sessions:  List[Tuple],   # (day_id, X, ev, goal, stim, cause, att)
    val_frac:  float = 0.15,
    test_frac: float = 0.15,
) -> Tuple[set, set]:
    """Chronological day split. Returns (test_days, val_days)."""
    all_days = sorted({day for day, *_ in sessions})
    n        = len(all_days)
    n_test   = max(1, round(n * test_frac))
    n_val    = max(1, round(n * val_frac))
    test_days = set(all_days[-n_test:])
    val_days  = set(all_days[-(n_test + n_val): -n_test])
    return test_days, val_days


def _head_metrics(
    y_true: List[int], y_pred: List[int], labels: List[str],
) -> Dict[str, Any]:
    """Per-class F1 + aggregate metrics for one classification head."""
    from sklearn.metrics import (accuracy_score, f1_score,
                                  precision_score, recall_score)
    if not y_true:
        return {"error": "no labelled windows"}
    yt      = np.array(y_true)
    yp      = np.array(y_pred)
    present = sorted(set(yt.tolist()) | set(yp.tolist()))
    pnames  = [labels[i] if i < len(labels) else str(i) for i in present]
    pcf1    = f1_score(yt, yp, labels=present, average=None, zero_division=0)
    return {
        "accuracy":        round(float(accuracy_score(yt, yp)), 4),
        "f1_macro":        round(float(f1_score(yt, yp, average="macro",    zero_division=0)), 4),
        "f1_weighted":     round(float(f1_score(yt, yp, average="weighted", zero_division=0)), 4),
        "precision_macro": round(float(precision_score(yt, yp, average="macro", zero_division=0)), 4),
        "recall_macro":    round(float(recall_score(yt, yp, average="macro",    zero_division=0)), 4),
        "n_windows":       int(len(yt)),
        "per_class_f1":    {n: round(float(v), 4) for n, v in zip(pnames, pcf1)},
    }


def _eval_sessions_imp(
    sessions:     List[Tuple],   # (day_id, X_raw, ev_vec, goal_vec, stim_vec, cause_vec, att_vec)
    s1:           Optional[nn.Module],
    s2:           nn.Module,
    cfg:          ImpConfig,
    mean:         np.ndarray,
    std:          np.ndarray,
    goal_labels:  List[str],
    stim_labels:  List[str],
    cause_labels: List[str],
    att_labels:   List[str],
) -> Dict[str, Any]:
    """Evaluate model on a list of sessions; returns full metrics for all heads."""
    from sklearn.metrics import accuracy_score, f1_score, precision_score, recall_score

    ev_true_all, ev_pred_all = [], []
    go_true_all, go_pred_all = [], []
    st_true_all, st_pred_all = [], []
    ca_true_all, ca_pred_all = [], []
    at_true_all, at_pred_all = [], []

    wl     = cfg.window_len
    stride = max(1, wl // 3)

    _infer_total_sec  = 0.0
    _infer_total_wins = 0

    for _day, X, ev_vec, goal_vec, stim_vec, cause_vec, att_vec in sessions:
        if X.shape[0] < wl:
            continue
        _t_inf = time.perf_counter()
        ev_p, g_p, _gpr, s_p, _spr, c_p, _cpr, a_p, _apr, _epr = \
            _predict_improved(X, mean, std, s1, s2, cfg)
        _infer_total_sec  += time.perf_counter() - _t_inf
        _infer_total_wins += max(0, (X.shape[0] - wl) // stride + 1)

        for k in range(0, X.shape[0] - wl + 1, stride):
            mid    = k + wl // 2
            pred_k = k
            if pred_k >= len(ev_p):
                break
            ev_true_all.append(int(ev_vec[mid]))
            ev_pred_all.append(int(ev_p[pred_k]))
            if goal_vec[mid]  >= 0:
                go_true_all.append(int(goal_vec[mid]));  go_pred_all.append(int(g_p[pred_k]))
            if stim_vec[mid]  >= 0:
                st_true_all.append(int(stim_vec[mid]));  st_pred_all.append(int(s_p[pred_k]))
            if cause_vec[mid] >= 0:
                ca_true_all.append(int(cause_vec[mid])); ca_pred_all.append(int(c_p[pred_k]))
            if att_vec[mid]   >= 0:
                at_true_all.append(int(att_vec[mid]));   at_pred_all.append(int(a_p[pred_k]))

    if not ev_true_all:
        return {"error": "no evaluation data"}

    _infer_samp_per_sec = _infer_total_wins / max(_infer_total_sec, 1e-9)

    ev_true = np.array(ev_true_all)
    ev_pred = np.array(ev_pred_all)
    s1_met  = {
        "accuracy":        round(float(accuracy_score(ev_true, ev_pred)), 4),
        "f1_macro":        round(float(f1_score(ev_true, ev_pred, average="macro",    zero_division=0)), 4),
        "f1_weighted":     round(float(f1_score(ev_true, ev_pred, average="weighted", zero_division=0)), 4),
        "f1_event":        round(float(f1_score(ev_true, ev_pred, labels=[1], average="macro", zero_division=0)), 4),
        "f1_no_event":     round(float(f1_score(ev_true, ev_pred, labels=[0], average="macro", zero_division=0)), 4),
        "precision_macro": round(float(precision_score(ev_true, ev_pred, average="macro", zero_division=0)), 4),
        "recall_macro":    round(float(recall_score(ev_true, ev_pred, average="macro",    zero_division=0)), 4),
        "n_windows":       int(len(ev_true)),
        "n_event_windows": int(ev_true.sum()),
        "strategies":      cfg.strategies,
    }
    return {
        "stage1":                  s1_met,
        "goal":                    _head_metrics(go_true_all, go_pred_all, goal_labels),
        "stimuli":                 _head_metrics(st_true_all, st_pred_all, stim_labels),
        "cause":                   _head_metrics(ca_true_all, ca_pred_all, cause_labels),
        "attention":               _head_metrics(at_true_all, at_pred_all, att_labels),
        "inference_samp_per_sec":  round(_infer_samp_per_sec, 2),
        "inference_total_sec":     round(_infer_total_sec, 3),
        "inference_total_windows": _infer_total_wins,
    }


def _batch_inference_imp(
    X_w:  np.ndarray,              # (N, W, D) already normalized
    s1:   Optional[nn.Module],
    s2:   nn.Module,
    cfg:  ImpConfig,
    bs:   int = 64,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Batch inference on pre-built windows. Returns (ev_p, g_p, s_p, c_p, a_p)."""
    dev    = torch.device(cfg.device)
    N      = len(X_w)
    use_1a = "1a" in cfg.strategies
    use_1b = "1b" in cfg.strategies
    thr    = cfg.stage1_threshold if use_1b else 0.5

    ev_pred = np.zeros(N, dtype=np.int64)
    g_pred  = np.zeros(N, dtype=np.int64)
    s_pred  = np.zeros(N, dtype=np.int64)
    c_pred  = np.zeros(N, dtype=np.int64)
    a_pred  = np.zeros(N, dtype=np.int64)

    s1_d = s1.to(dev) if s1 is not None else None
    s2_d = s2.to(dev)

    with torch.no_grad():
        if not use_1a and s1_d is not None:
            for st in range(0, N, bs):
                en  = min(st + bs, N)
                bx  = torch.from_numpy(X_w[st:en]).to(dev)
                prb = torch.softmax(s1_d(bx), 1)[:, 1].cpu().numpy()
                ev_pred[st:en] = (prb >= thr).astype(np.int64)
        else:
            ev_pred[:] = 1

        run_idx = np.where(ev_pred == 1)[0]
        for i in range(0, len(run_idx), bs):
            chunk = run_idx[i: i + bs]
            bx    = torch.from_numpy(X_w[chunk]).to(dev)
            gl, sl, cl, al = s2_d(bx)
            g_pred[chunk] = gl.argmax(1).cpu().numpy()
            s_pred[chunk] = sl.argmax(1).cpu().numpy()
            c_pred[chunk] = cl.argmax(1).cpu().numpy()
            a_pred[chunk] = al.argmax(1).cpu().numpy()

        if use_1a:
            ev_pred[:] = (g_pred != 0).astype(np.int64)

    return ev_pred, g_pred, s_pred, c_pred, a_pred


def _build_windows_horizon_imp(
    X_norm:    np.ndarray,   # (T, D) already normalized
    ev_vec:    np.ndarray,
    goal_vec:  np.ndarray,
    stim_vec:  np.ndarray,
    cause_vec: np.ndarray,
    att_vec:   np.ndarray,
    window_len: int,
    stride:     int,
    h_steps:    int,
    max_h:      int,
) -> Tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    """Build windows where labels are taken h_steps after the window end."""
    T = X_norm.shape[0]
    wins, ev_l, go_l, st_l, ca_l, at_l = [], [], [], [], [], []
    for k in range(0, T - window_len - max_h + 1, stride):
        label_idx = k + window_len - 1 + h_steps
        wins.append(X_norm[k: k + window_len])
        ev_l.append(int(ev_vec[label_idx]))
        go_l.append(int(goal_vec[label_idx]))
        st_l.append(int(stim_vec[label_idx]))
        ca_l.append(int(cause_vec[label_idx]))
        at_l.append(int(att_vec[label_idx]))

    if not wins:
        empty = np.empty(0, dtype=np.int64)
        return (np.empty((0, window_len, X_norm.shape[1]), dtype=np.float32),
                empty, empty, empty, empty, empty)
    return (np.stack(wins).astype(np.float32),
            np.array(ev_l, dtype=np.int64),
            np.array(go_l, dtype=np.int64),
            np.array(st_l, dtype=np.int64),
            np.array(ca_l, dtype=np.int64),
            np.array(at_l, dtype=np.int64))


def _compute_multihorizon_imp(
    test_sessions: List[Tuple],   # (day_id, X_raw, ev_vec, goal_vec, stim_vec, cause_vec, att_vec)
    s1:            Optional[nn.Module],
    s2:            nn.Module,
    cfg:           ImpConfig,
    mean:          np.ndarray,
    std:           np.ndarray,
    goal_labels:   List[str],
    stim_labels:   List[str],
    cause_labels:  List[str],
    att_labels:    List[str],
    sample_hz:     float,
) -> Dict[str, Any]:
    """Multi-horizon evaluation on test sessions. Returns metrics_all_horizons dict."""
    horizons_steps = [1, 2, 3, 6, 9, 12, 15]
    max_h_steps    = max(horizons_steps)
    wl             = cfg.window_len
    stride         = max(1, wl // 3)
    metrics_all_h: Dict[str, Any] = {}

    for h_steps in horizons_steps:
        h_s   = h_steps / sample_hz
        h_key = f"{h_s:.3f}s"

        bkts: List[Tuple] = []
        for _day, X, ev_vec, goal_vec, stim_vec, cause_vec, att_vec in test_sessions:
            X_norm = (X - mean) / std
            Xw, evw, gw, sw, cw, aw = _build_windows_horizon_imp(
                X_norm, ev_vec, goal_vec, stim_vec, cause_vec, att_vec,
                wl, stride, h_steps, max_h_steps,
            )
            if len(Xw) > 0:
                bkts.append((Xw, evw, gw, sw, cw, aw))

        if not bkts:
            continue

        Xh  = np.concatenate([b[0] for b in bkts])
        evh = np.concatenate([b[1] for b in bkts])
        gh  = np.concatenate([b[2] for b in bkts])
        sh  = np.concatenate([b[3] for b in bkts])
        ch  = np.concatenate([b[4] for b in bkts])
        ah  = np.concatenate([b[5] for b in bkts])

        ev_p, g_p, s_p, c_p, a_p = _batch_inference_imp(Xh, s1, s2, cfg)

        ev_m  = _head_metrics(evh.tolist(), ev_p.tolist(), ["no_event", "event"])
        g_vld = gh >= 0
        go_m  = _head_metrics(gh[g_vld].tolist(), g_p[g_vld].tolist(), goal_labels)
        s_vld = sh >= 0
        st_m  = _head_metrics(sh[s_vld].tolist(), s_p[s_vld].tolist(), stim_labels)
        c_vld = ch >= 0
        ca_m  = _head_metrics(ch[c_vld].tolist(), c_p[c_vld].tolist(), cause_labels)
        a_vld = ah >= 0
        at_m  = _head_metrics(ah[a_vld].tolist(), a_p[a_vld].tolist(), att_labels)

        metrics_all_h[h_key] = {
            "n_test":           int(len(Xh)),
            "stage1_f1":        float(ev_m.get("f1_macro",  0.0)),
            "goal_f1":          float(go_m.get("f1_macro",  0.0)),
            "stimuli_f1":       float(st_m.get("f1_macro",  0.0)),
            "cause_f1":         float(ca_m.get("f1_macro",  0.0)),
            "attention_f1":     float(at_m.get("f1_macro",  0.0)),
            "event_metrics":    ev_m,
            "goal_metrics":     go_m,
            "stimuli_metrics":  st_m,
            "cause_metrics":    ca_m,
            "attention_metrics": at_m,
        }
        print(
            f"  h={h_key:<8}  n={len(Xh):>6}  "
            f"S1={metrics_all_h[h_key]['stage1_f1']:.3f}  "
            f"Goal={metrics_all_h[h_key]['goal_f1']:.3f}  "
            f"Stim={metrics_all_h[h_key]['stimuli_f1']:.3f}"
        )

    return metrics_all_h


# ──────────────────────────────────────────────────────────────────────────────
# Step 1 – extract-improved
# ──────────────────────────────────────────────────────────────────────────────

def cmd_extract_improved(args: argparse.Namespace) -> None:
    """Run YOLOv8 on videos; cache improved (T, 39) detection arrays."""
    try:
        from ultralytics import YOLO
    except ImportError:
        print("ERROR: ultralytics not installed.  pip install ultralytics",
              file=sys.stderr)
        sys.exit(1)

    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    det_dir = Path(args.det_cache_dir)
    det_dir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_improved_extract", output_dir=det_dir, use_codecarbon=True)
    _profiler.__enter__()

    model    = YOLO(args.yolo_model)
    step_sec = 1.0 / args.sample_hz
    print(f"Loaded YOLOv8: {args.yolo_model}  |  extracting {D_IMP}-dim features")

    for r in tqdm(records, desc="sessions"):
        sid     = r["session_id"]
        out_npy = det_dir / f"{sid}_det_imp.npy"
        if out_npy.exists() and not args.overwrite:
            continue

        # Support both video_path (direct file) and video_dir (directory)
        vp = None
        vpath = r.get("video_path")
        if vpath and Path(vpath).exists():
            vp = Path(vpath)
        else:
            vd = r.get("video_dir")
            if vd:
                mp4s = list(Path(vd).glob("*.mp4"))
                if mp4s:
                    vp = mp4s[0]
        if vp is None:
            continue

        # ── probe video ──────────────────────────────────────────────────────
        probe = subprocess.check_output(
            ["ffprobe", "-v", "quiet", "-print_format", "json",
             "-show_streams", str(vp)], stderr=subprocess.DEVNULL)
        data  = json.loads(probe)
        fps   = 30.0
        frame_size = None
        for s in data.get("streams", []):
            if s.get("codec_type") == "video":
                n, d = s["r_frame_rate"].split("/")
                fps  = float(n) / float(d)
                frame_size = (int(s["height"]), int(s["width"]))
                break

        # ── determine T ──────────────────────────────────────────────────────
        T = None
        if args.prealigned_sensors_dir:
            pre = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
            if pre.exists():
                T = int(np.load(pre, mmap_mode="r").shape[0])
        if T is None:
            try:
                dur_cmd = ["ffprobe", "-v", "quiet", "-show_entries",
                           "format=duration", "-of", "default=nw=1:nk=1", str(vp)]
                T = int(float(subprocess.check_output(
                    dur_cmd, stderr=subprocess.DEVNULL)) * args.sample_hz)
            except Exception:
                continue

        # ── decode & run YOLO ─────────────────────────────────────────────────
        feats           = np.zeros((T, D_IMP), dtype=np.float32)
        prev_veh_boxes  = None
        prev_ped_boxes  = None
        prev_roi        = None

        for i_s in tqdm(range(T), desc=sid, leave=False):
            t_s = i_s * step_sec
            dec = ["ffmpeg", "-hide_banner", "-loglevel", "error",
                   "-ss", f"{t_s:.4f}", "-i", str(vp),
                   "-vframes", "1", "-f", "rawvideo", "-pix_fmt", "bgr24", "pipe:1"]
            try:
                raw = subprocess.check_output(dec, stderr=subprocess.DEVNULL)
            except Exception:
                prev_veh_boxes = prev_ped_boxes = None
                continue

            if frame_size is None or len(raw) != frame_size[0] * frame_size[1] * 3:
                prev_veh_boxes = prev_ped_boxes = None
                continue

            frame   = np.frombuffer(raw, np.uint8).reshape(
                frame_size[0], frame_size[1], 3)
            results = model(frame, verbose=False)
            res     = results[0] if results else None

            feat, curr_veh, curr_ped, curr_roi = _extract_det_features_imp(
                res, frame, prev_veh_boxes, prev_ped_boxes, prev_roi)
            feats[i_s]     = feat
            prev_veh_boxes = curr_veh
            prev_ped_boxes = curr_ped
            prev_roi       = curr_roi

        np.save(out_npy, feats)
        print(f"  {sid}: saved {out_npy.name}  shape={feats.shape}")

    print("Extraction done.")
    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# Step 2 – train
# ──────────────────────────────────────────────────────────────────────────────

def cmd_train(args: argparse.Namespace) -> None:
    """Train Stage1 + Stage2 with the selected strategy combination."""
    import torch.optim as optim

    strategies = args.strategies or []
    print(f"\nActive strategies: {strategies if strategies else ['none (baseline)']}")

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_improved_train", output_dir=outdir, use_codecarbon=True)
    _profiler.__enter__()

    rtk_dir = Path(args.rtk_dir) if getattr(args, "rtk_dir", None) else None
    cfg = ImpConfig(
        window_sec   = args.window_sec,
        sample_hz    = args.sample_hz,
        epochs       = args.epochs,
        lr           = args.lr,
        batch_size   = args.batch_size,
        strategies   = strategies,
        stage1_threshold = args.stage1_threshold,
        rtk_dim      = 6 if rtk_dir is not None else 0,
    )
    print(f"Config: window={cfg.window_sec}s  det_dim={cfg.det_dim}  rtk_dim={cfg.rtk_dim}  input_dim={cfg.input_dim}")

    # ── Load vocabularies ─────────────────────────────────────────────────────
    vd = Path(args.vocab_dir)
    goal_labels,  goal_lmap,  goal_vocab   = _load_vocab(vd / "vocab_goal.json")
    stim_labels,  stim_lmap,  stim_vocab   = _load_vocab(vd / "vocab_stimuli.json")
    cause_labels, cause_lmap, cause_vocab  = _load_vocab(vd / "vocab_cause.json")
    att_labels,   att_lmap,   att_vocab    = _load_vocab(vd / "vocab_attention.json")
    cfg.n_goal_classes      = len(goal_labels)
    cfg.n_stimuli_classes   = len(stim_labels)
    cfg.n_cause_classes     = len(cause_labels)
    cfg.n_attention_classes = len(att_labels)

    # ── Load records ──────────────────────────────────────────────────────────
    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    em = _eaf_map(Path(args.eaf_parsed_dir) if args.eaf_parsed_dir else None)

    # ── Build dataset ─────────────────────────────────────────────────────────
    all_day_ids: List[str] = []
    all_X, all_ev, all_go, all_st, all_ca, all_at = [], [], [], [], [], []
    det_dir = Path(args.det_cache_dir) if args.det_cache_dir else None
    pre_dir = Path(args.prealigned_sensors_dir)

    n_skip_sensor = 0
    n_skip_eaf    = 0
    n_skip_tiers  = 0
    n_loaded      = 0

    for r in tqdm(records, desc="loading"):
        sid = r["session_id"]
        pre = pre_dir / f"{sid}.npy"
        if not pre.exists():
            n_skip_sensor += 1
            continue
        X_sensor = np.load(pre).astype(np.float32)   # (T, 8)
        T = X_sensor.shape[0]

        X_det = _load_det(det_dir, sid, T, cfg)       # (T, det_dim)
        X     = np.concatenate([X_sensor, X_det], axis=1)  # (T, sensor+det)
        if rtk_dir is not None:
            rtk_path = rtk_dir / f"{sid}_rtk.npy"
            if rtk_path.exists():
                rtk_feat = np.load(str(rtk_path)).astype(np.float32)
                if rtk_feat.shape[0] != T:
                    rtk_feat = np.zeros((T, 6), dtype=np.float32)
            else:
                rtk_feat = np.zeros((T, 6), dtype=np.float32)
            X = np.concatenate([X, rtk_feat], axis=1)

        if sid not in em:
            n_skip_eaf += 1
            continue
        tiers = _load_eaf_json(em[sid])
        if not tiers:
            n_skip_tiers += 1
            continue

        ev_vec, goal_vec, stim_vec, cause_vec, att_vec = _label_vectors(
            T, cfg.sample_hz, tiers,
            goal_lmap, goal_vocab, stim_lmap, stim_vocab,
            cause_lmap, cause_vocab, att_lmap, att_vocab,
            t_offset_s=0.0)   # prealigned: t=0 = video start

        all_day_ids.append(sid[:8])
        all_X.append(X)
        all_ev.append(ev_vec)
        all_go.append(goal_vec)
        all_st.append(stim_vec)
        all_ca.append(cause_vec)
        all_at.append(att_vec)
        n_loaded += 1

    print(f"Sessions loaded: {n_loaded} / {len(records)}"
          f"  (skipped: {n_skip_sensor} no-sensor-npy"
          f", {n_skip_eaf} no-eaf"
          f", {n_skip_tiers} empty-tiers)")

    if n_skip_sensor:
        # Print the first missing path to help the user fix it
        for r in records:
            p = pre_dir / f"{r['session_id']}.npy"
            if not p.exists():
                print(f"  [MISSING sensor] {p}")
                break
    if n_skip_eaf:
        for r in records:
            sid2 = r["session_id"]
            p2   = pre_dir / f"{sid2}.npy"
            if p2.exists() and sid2 not in em:
                print(f"  [MISSING eaf] session_id={sid2!r}  eaf_parsed_dir={Path(args.eaf_parsed_dir) if args.eaf_parsed_dir else 'None'}")
                break

    if not all_X:
        print("ERROR: no data found."); sys.exit(1)

    # ── Fit normalisation ─────────────────────────────────────────────────────
    X_all  = np.concatenate(all_X, axis=0)
    mean   = X_all.mean(0).astype(np.float32)
    std    = X_all.std(0).astype(np.float32)
    std[std < 1e-8] = 1.0
    np.save(outdir / "norm_mean.npy", mean)
    np.save(outdir / "norm_std.npy",  std)

    # ── Build windows ─────────────────────────────────────────────────────────
    wl      = cfg.window_len
    stride  = max(1, wl // 3)
    s3      = "3" in strategies
    s1a     = "1a" in strategies

    Xw, ev_l, go_l, st_l, ca_l, at_l = [], [], [], [], [], []
    for X, ev, go, st, ca, at in zip(all_X, all_ev, all_go, all_st, all_ca, all_at):
        xw, el, gl, sl, cl, al = _build_windows_improved(
            X, mean, std, go, st, ev, ca, at, wl, stride,
            strategy3=s3, strategy1a=s1a)
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
          f"w/goal: {(go_l>=0).sum()}  w/cause: {(ca_l>=0).sum()}")

    Xt = torch.from_numpy(Xw)
    Et = torch.from_numpy(ev_l)
    Gt = torch.from_numpy(go_l)
    St = torch.from_numpy(st_l)
    Ct = torch.from_numpy(ca_l)
    At = torch.from_numpy(at_l)

    dev = torch.device(cfg.device)
    bs  = cfg.batch_size

    # ── Stage 1 ───────────────────────────────────────────────────────────────
    if "1a" not in strategies:
        print("\n-- Stage 1: EventNet --")
        n_pos = int((ev_l == 1).sum())
        n_neg = int((ev_l == 0).sum())
        if n_pos > 0:
            pos_w   = float(n_neg) / float(n_pos)
            w1      = torch.tensor([1.0, pos_w], device=dev)
            print(f"  class weights: no_event=1.0  event={pos_w:.2f}  "
                  f"(pos={n_pos} neg={n_neg})")
        else:
            w1 = None
            print("  WARNING: no event windows found")

        s1 = _EventNet(cfg).to(dev)
        o1 = optim.AdamW(s1.parameters(), lr=cfg.lr)
        _s1_t0 = time.perf_counter()
        for epoch in range(cfg.epochs):
            s1.train()
            idx = torch.randperm(len(Xt))
            tot = 0.0
            for i in range(0, len(Xt), bs):
                b = idx[i: i + bs]
                bx = Xt[b].to(dev); by = Et[b].to(dev)
                loss = F.cross_entropy(s1(bx), by, weight=w1)
                o1.zero_grad(); loss.backward(); o1.step()
                tot += loss.item() * len(b)
            if (epoch + 1) % 5 == 0:
                print(f"  epoch {epoch+1}/{cfg.epochs}  loss={tot/len(Xt):.4f}")
        _s1_train_sec = time.perf_counter() - _s1_t0
        _s1_samp_per_sec = (len(Xt) * cfg.epochs) / max(_s1_train_sec, 1e-9)
        print(f"  Stage1 train throughput: {_s1_samp_per_sec:.1f} samp/s  "
              f"({_s1_train_sec:.1f}s total)")

        torch.save({"model_state": s1.state_dict(), "config": _imp_config_to_dict(cfg)},
                   outdir / "stage1.pt")
        print(f"  Stage1 -> {outdir/'stage1.pt'}")
    else:
        print("\n-- Stage 1: SKIPPED (strategy 1a active) --")
        # Save a placeholder so the inference script knows there's no Stage 1
        (outdir / "stage1_skip.flag").write_text("strategy_1a")

    # ── Stage 2 ───────────────────────────────────────────────────────────────
    print("\n-- Stage 2: ClassifyNet (goal / stimuli / cause / attention) --")

    if "1a" in strategies:
        # Train on ALL windows (strategy 1a: unknown=class-0 for no-event)
        Xw2 = Xt; Gw2 = Gt; Sw2 = St; Cw2 = Ct; Aw2 = At
        print(f"  All windows for Stage 2: {len(Xw2)}")
    else:
        ev_mask = ev_l == 1
        Xw2 = Xt[ev_mask]; Gw2 = Gt[ev_mask]; Sw2 = St[ev_mask]
        Cw2 = Ct[ev_mask]; Aw2 = At[ev_mask]
        if len(Xw2) == 0:
            print("  No event windows – skip Stage 2"); return
        print(f"  Event windows for Stage 2: {len(Xw2)}")

    # Strategy 4: inverse-frequency class weights
    s4 = "4" in strategies
    wg  = _class_weights(Gw2.numpy(), cfg.n_goal_classes,      dev) if s4 else None
    wst = _class_weights(Sw2.numpy(), cfg.n_stimuli_classes,   dev) if s4 else None
    wc  = _class_weights(Cw2.numpy(), cfg.n_cause_classes,     dev) if s4 else None
    wa  = _class_weights(Aw2.numpy(), cfg.n_attention_classes,  dev) if s4 else None
    if s4:
        print("  Class weighting enabled (strategy 4)")

    s2 = _ClassifyNet(cfg).to(dev)
    o2 = optim.AdamW(s2.parameters(), lr=cfg.lr)

    _s2_t0 = time.perf_counter()
    for epoch in range(cfg.epochs):
        s2.train()
        idx = torch.randperm(len(Xw2))
        tot = 0.0
        for i in range(0, len(Xw2), bs):
            b   = idx[i: i + bs]
            bx  = Xw2[b].to(dev)
            bg  = Gw2[b].to(dev);  bst = Sw2[b].to(dev)
            bc  = Cw2[b].to(dev);  bat = Aw2[b].to(dev)
            vg  = bg  >= 0; vst = bst >= 0; vc = bc >= 0; va = bat >= 0
            gl, sl, cl, al = s2(bx)
            loss = torch.tensor(0.0, device=dev)
            if vg.any():
                loss = loss + F.cross_entropy(gl[vg],   bg[vg],   weight=wg)
            if vst.any():
                loss = loss + F.cross_entropy(sl[vst],  bst[vst], weight=wst)
            if vc.any():
                loss = loss + F.cross_entropy(cl[vc],   bc[vc],   weight=wc)
            if va.any():
                loss = loss + F.cross_entropy(al[va],   bat[va],  weight=wa)
            if loss.item() > 0:
                o2.zero_grad(); loss.backward(); o2.step()
                tot += loss.item() * len(b)
        if (epoch + 1) % 5 == 0:
            print(f"  epoch {epoch+1}/{cfg.epochs}  "
                  f"loss={tot/max(1,len(Xw2)):.4f}")
    _s2_train_sec = time.perf_counter() - _s2_t0
    _s2_samp_per_sec = (len(Xw2) * cfg.epochs) / max(_s2_train_sec, 1e-9)
    print(f"  Stage2 train throughput: {_s2_samp_per_sec:.1f} samp/s  "
          f"({_s2_train_sec:.1f}s total)")

    torch.save({"model_state": s2.state_dict(), "config": _imp_config_to_dict(cfg)},
               outdir / "stage2.pt")
    print(f"  Stage2 -> {outdir/'stage2.pt'}")

    # ── Save artefacts ────────────────────────────────────────────────────────
    with open(outdir / "config.json", "w") as f:
        json.dump(_imp_config_to_dict(cfg), f, indent=2)
    with open(outdir / "det_feature_names.json", "w") as f:
        cols = cfg.active_det_cols()
        names = [DET_FEATURE_NAMES_IMP[c] for c in cols]
        json.dump(names, f, indent=2)
    with open(outdir / "strategies.json", "w") as f:
        json.dump({"strategies": strategies,
                   "det_cols": cfg.active_det_cols(),
                   "input_dim": cfg.input_dim,
                   "window_sec": cfg.window_sec}, f, indent=2)
    _thr = {
        "stage1_train_samp_per_sec": round(_s1_samp_per_sec, 2) if "1a" not in strategies else None,
        "stage1_train_total_sec":    round(_s1_train_sec,    2) if "1a" not in strategies else None,
        "stage1_n_samples":          int(len(Xt)) if "1a" not in strategies else None,
        "stage2_train_samp_per_sec": round(_s2_samp_per_sec, 2),
        "stage2_train_total_sec":    round(_s2_train_sec,    2),
        "stage2_n_samples":          int(len(Xw2)),
        "epochs":                    cfg.epochs,
    }
    with open(outdir / "throughput_train.json", "w") as f:
        json.dump(_thr, f, indent=2)
    print(f"\nAll artefacts -> {outdir}")
    print(f"Strategies: {strategies}")
    print(f"input_dim={cfg.input_dim}  window={cfg.window_sec}s  "
          f"det_dim={cfg.det_dim}")

    # ── Post-training metrics (train / val / test + multi-horizon) ────────────
    print("\n-- Computing post-training metrics --")
    sessions_all = list(zip(all_day_ids, all_X, all_ev, all_go, all_st, all_ca, all_at))
    test_days, val_days = _day_split_imp(sessions_all)
    train_sessions = [(d, X, e, g, s, c, a) for d, X, e, g, s, c, a in sessions_all
                      if d not in test_days and d not in val_days]
    val_sessions   = [(d, X, e, g, s, c, a) for d, X, e, g, s, c, a in sessions_all
                      if d in val_days]
    test_sessions  = [(d, X, e, g, s, c, a) for d, X, e, g, s, c, a in sessions_all
                      if d in test_days]
    print(f"  train={len(train_sessions)} sess  val={len(val_sessions)}  test={len(test_sessions)}")

    s1_eval = s1 if "1a" not in strategies else None
    for split_name, split_sess in [("train", train_sessions),
                                   ("val",   val_sessions),
                                   ("test",  test_sessions)]:
        if not split_sess:
            print(f"  [{split_name}] no sessions – skipping")
            continue
        print(f"  evaluating {split_name}…")
        met = _eval_sessions_imp(split_sess, s1_eval, s2, cfg, mean, std,
                                 goal_labels, stim_labels, cause_labels, att_labels)
        fpath = outdir / f"metrics_{split_name}.json"
        with open(fpath, "w") as f:
            json.dump(met, f, indent=2)
        s1f = met.get("stage1", {}).get("f1_macro", "n/a")
        gf  = met.get("goal",   {}).get("f1_macro", "n/a")
        print(f"    stage1 F1={s1f}  goal F1={gf} -> {fpath}")

    if test_sessions:
        print("  computing multi-horizon metrics on test sessions…")
        mh = _compute_multihorizon_imp(
            test_sessions, s1_eval, s2, cfg, mean, std,
            goal_labels, stim_labels, cause_labels, att_labels,
            sample_hz=cfg.sample_hz,
        )
        mh_path = outdir / "metrics_all_horizons.json"
        with open(mh_path, "w") as f:
            json.dump(mh, f, indent=2)
        print(f"  metrics_all_horizons.json -> {mh_path}")
    else:
        print("  [multi-horizon] no test sessions – skipping")

    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# Step 3 – evaluate
# ──────────────────────────────────────────────────────────────────────────────

def _load_improved_models(model_dir: Path):
    """Load ImpConfig + Stage1/Stage2 from a trained outdir."""
    with open(model_dir / "config.json", encoding="utf-8") as f:
        cfg_dict = json.load(f)
    cfg = _imp_config_from_dict(cfg_dict)

    mean = np.load(model_dir / "norm_mean.npy").astype(np.float32)
    std  = np.load(model_dir / "norm_std.npy").astype(np.float32)
    std[std < 1e-8] = 1.0

    s1_path = model_dir / "stage1.pt"
    if s1_path.exists():
        ck1 = torch.load(s1_path, map_location="cpu", weights_only=False)
        s1  = _EventNet(cfg)
        s1.load_state_dict(ck1["model_state"])
        s1.eval()
    else:
        s1 = None   # strategy 1a: no Stage 1

    ck2 = torch.load(model_dir / "stage2.pt", map_location="cpu", weights_only=False)
    s2  = _ClassifyNet(cfg)
    s2.load_state_dict(ck2["model_state"])
    s2.eval()

    return s1, s2, cfg, mean, std


def cmd_evaluate(args: argparse.Namespace) -> None:
    """Evaluate improved model: train/val/test splits + multi-horizon metrics."""
    model_dir = Path(args.model_dir)
    outdir    = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="two_stage_yolo_improved_evaluate",
                                 output_dir=outdir, use_codecarbon=True)
    _profiler.__enter__()

    s1, s2, cfg, mean, std = _load_improved_models(model_dir)
    print(f"Loaded model from {model_dir}")
    print(f"Strategies: {cfg.strategies}  input_dim={cfg.input_dim}  "
          f"window={cfg.window_sec}s")

    # ── Vocabularies ──────────────────────────────────────────────────────────
    vd = Path(args.vocab_dir)
    goal_labels,  goal_lmap,  goal_vocab  = _load_vocab(vd / "vocab_goal.json")
    stim_labels,  stim_lmap,  stim_vocab  = _load_vocab(vd / "vocab_stimuli.json")
    cause_labels, cause_lmap, cause_vocab = _load_vocab(vd / "vocab_cause.json")
    att_labels,   att_lmap,   att_vocab   = _load_vocab(vd / "vocab_attention.json")

    # ── Load sessions ─────────────────────────────────────────────────────────
    records: List[dict] = []
    with open(args.manifest, encoding="utf-8") as f:
        for ln in f:
            ln = ln.strip()
            if ln:
                records.append(json.loads(ln))

    em          = _eaf_map(Path(args.eaf_parsed_dir) if args.eaf_parsed_dir else None)
    det_dir     = Path(args.det_cache_dir) if args.det_cache_dir else None
    pre_dir     = Path(args.prealigned_sensors_dir)
    rtk_dir_ev  = Path(args.rtk_dir) if getattr(args, "rtk_dir", None) else None

    sessions_all: List[Tuple] = []
    for r in tqdm(records, desc="loading"):
        sid = r["session_id"]
        pre = pre_dir / f"{sid}.npy"
        if not pre.exists():
            continue
        X_sensor = np.load(pre).astype(np.float32)
        T = X_sensor.shape[0]
        X_det = _load_det(det_dir, sid, T, cfg)
        X     = np.concatenate([X_sensor, X_det], axis=1)
        if rtk_dir_ev is not None and cfg.rtk_dim > 0:
            rtk_path = rtk_dir_ev / f"{sid}_rtk.npy"
            if rtk_path.exists():
                rtk_feat = np.load(str(rtk_path)).astype(np.float32)
                if rtk_feat.shape[0] != T:
                    rtk_feat = np.zeros((T, cfg.rtk_dim), dtype=np.float32)
            else:
                rtk_feat = np.zeros((T, cfg.rtk_dim), dtype=np.float32)
            X = np.concatenate([X, rtk_feat], axis=1)
        if sid not in em:
            continue
        tiers = _load_eaf_json(em[sid])
        if not tiers:
            continue
        ev_vec, goal_vec, stim_vec, cause_vec, att_vec = _label_vectors(
            T, cfg.sample_hz, tiers,
            goal_lmap, goal_vocab, stim_lmap, stim_vocab,
            cause_lmap, cause_vocab, att_lmap, att_vocab,
            t_offset_s=0.0)
        sessions_all.append((sid[:8], X, ev_vec, goal_vec, stim_vec, cause_vec, att_vec))

    if not sessions_all:
        print("ERROR: no evaluation data."); return

    # ── Day split ─────────────────────────────────────────────────────────────
    test_days, val_days = _day_split_imp(sessions_all)
    train_sessions = [(d, X, e, g, s, c, a) for d, X, e, g, s, c, a in sessions_all
                      if d not in test_days and d not in val_days]
    val_sessions   = [(d, X, e, g, s, c, a) for d, X, e, g, s, c, a in sessions_all
                      if d in val_days]
    test_sessions  = [(d, X, e, g, s, c, a) for d, X, e, g, s, c, a in sessions_all
                      if d in test_days]
    print(f"Sessions: train={len(train_sessions)}  val={len(val_sessions)}  "
          f"test={len(test_sessions)}")

    s1_eval = s1 if "1a" not in cfg.strategies else None

    # ── Per-split metrics ─────────────────────────────────────────────────────
    for split_name, split_sess in [("train", train_sessions),
                                   ("val",   val_sessions),
                                   ("test",  test_sessions)]:
        if not split_sess:
            print(f"  [{split_name}] no sessions – skipping")
            continue
        print(f"\n-- {split_name} --")
        met = _eval_sessions_imp(split_sess, s1_eval, s2, cfg, mean, std,
                                 goal_labels, stim_labels, cause_labels, att_labels)
        fpath = outdir / f"metrics_{split_name}.json"
        with open(fpath, "w") as f:
            json.dump(met, f, indent=2)
        for head in ("stage1", "goal", "stimuli", "cause", "attention"):
            fm = met.get(head, {}).get("f1_macro",    "n/a")
            fw = met.get(head, {}).get("f1_weighted", "n/a")
            print(f"  {head:<12} F1(macro)={fm}  F1(weighted)={fw}")
        print(f"  saved -> {fpath}")

    # ── Multi-horizon on test ─────────────────────────────────────────────────
    if test_sessions:
        print("\n-- Multi-horizon (test) --")
        mh = _compute_multihorizon_imp(
            test_sessions, s1_eval, s2, cfg, mean, std,
            goal_labels, stim_labels, cause_labels, att_labels,
            sample_hz=cfg.sample_hz,
        )
        mh_path = outdir / "metrics_all_horizons.json"
        with open(mh_path, "w") as f:
            json.dump(mh, f, indent=2)
        print(f"  metrics_all_horizons.json -> {mh_path}")
    else:
        print("  [multi-horizon] no test sessions – skipping")

    print(f"\nAll metrics -> {outdir}")
    _profiler.__exit__(None, None, None)


# ──────────────────────────────────────────────────────────────────────────────
# CLI
# ──────────────────────────────────────────────────────────────────────────────

STRATEGIES_HELP = (
    "Active strategies: 1a (remove Stage1), 1b (weaken Stage1), "
    "2 (zones), 3 (better labels), 4 (class weights), "
    "5 (motion feats, needs extract-improved), "
    "6 (top-K vehicles, needs extract-improved), "
    "7 (10s window)."
)


def main() -> None:
    pa  = argparse.ArgumentParser(
        description="Improved two-stage EAF + YOLOv8 pipeline")
    sub = pa.add_subparsers(dest="cmd", required=True)

    # ── extract-improved ──────────────────────────────────────────────────────
    p_ext = sub.add_parser("extract-improved",
                           help="Run YOLOv8 and cache 39-dim improved features")
    p_ext.add_argument("--manifest",               required=True, type=Path)
    p_ext.add_argument("--det-cache-dir",          required=True, type=Path)
    p_ext.add_argument("--yolo-model",             default="yolov8n.pt", type=str)
    p_ext.add_argument("--prealigned-sensors-dir", default=None, type=Path)
    p_ext.add_argument("--overwrite",              action="store_true")
    p_ext.add_argument("--sample-hz",              default=3.0,  type=float)

    # ── train ─────────────────────────────────────────────────────────────────
    p_tr = sub.add_parser("train",
                          help="Train with selected strategies")
    p_tr.add_argument("--manifest",               required=True, type=Path)
    p_tr.add_argument("--eaf-parsed-dir",         required=True, type=Path)
    p_tr.add_argument("--det-cache-dir",          default=None,  type=Path,
                      help="Dir with {sid}_det_imp.npy (improved) or {sid}_det.npy (original)")
    p_tr.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p_tr.add_argument("--vocab-dir",              required=True, type=Path)
    p_tr.add_argument("--outdir",                 required=True, type=Path)
    p_tr.add_argument("--strategies",             default=[], nargs="*",
                      help=STRATEGIES_HELP)
    p_tr.add_argument("--stage1-threshold",       default=0.30, type=float,
                      help="Event prob threshold for strategy 1b (default 0.30)")
    p_tr.add_argument("--sample-hz",              default=3.0,  type=float)
    p_tr.add_argument("--window-sec",             default=5.0,  type=float)
    p_tr.add_argument("--epochs",                 default=40,   type=int)
    p_tr.add_argument("--lr",                     default=1e-4, type=float)
    p_tr.add_argument("--batch-size",             default=32,   type=int)

    # ── evaluate ──────────────────────────────────────────────────────────────
    p_ev = sub.add_parser("evaluate", help="Evaluate improved model, save metrics")
    p_ev.add_argument("--manifest",               required=True, type=Path)
    p_ev.add_argument("--model-dir",              required=True, type=Path)
    p_ev.add_argument("--eaf-parsed-dir",         required=True, type=Path)
    p_ev.add_argument("--det-cache-dir",          default=None,  type=Path)
    p_ev.add_argument("--prealigned-sensors-dir", required=True, type=Path)
    p_ev.add_argument("--vocab-dir",              required=True, type=Path)
    p_ev.add_argument("--outdir",                 required=True, type=Path)
    p_ev.add_argument("--sample-hz",              default=3.0,  type=float)

    args = pa.parse_args()
    {"extract-improved": cmd_extract_improved,
     "train":            cmd_train,
     "evaluate":         cmd_evaluate}[args.cmd](args)


if __name__ == "__main__":
    main()
