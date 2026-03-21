#!/usr/bin/env python
"""Annotate driving video with IMPROVED two-stage EAF predictions + YOLOv8 bboxes.

Uses models trained by two_stage_yolo_improved.py (supports all strategy
combinations: 1a, 1b, 2, 3, 4, 5, 6, 7).

Visual differences vs annotate_video_eaf_yolo.py:
  • Active strategies shown in panel header
  • Strategy 1b: Stage-1 confidence % replaces the plain event/no-event dot
  • Strategy 2: Zone-aware bbox colours (ego-lane vehicles in red, adjacent
    in orange, oncoming in magenta, pedestrians-in-road in yellow)
  • Strategy 5/6: Detection tooltip shows "approaching" indicator on bboxes

Usage
-----
python twimo/plots/annotate_video_eaf_yolo_improved.py \\
    --manifest ./artifacts/manifest.jsonl \\
    --model-dir ./artifacts/eaf/improved_1a234 \\
    --vocab-dir ./artifacts/eaf/vocabs \\
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
    --det-cache-dir ./artifacts/eaf/det_cache_imp \\
    --eaf-parsed-dir ./artifacts/eaf/parsed \\
    --outdir ./artifacts/annotated_eaf_improved \\
    --yolo-model yolov8n.pt \\
    --session 201702271123
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent.parent.parent))

from typing import Dict, List, Optional, Tuple

import cv2
import numpy as np
import torch

from twimo.utils.profiling import TrainingProfiler

# ── Display utilities from original annotate script ──────────────────────────
from twimo.plots.annotate_video_eaf import (
    _load_vocab,
    _map_raw,
    _load_eaf_tiers,
    _at,
    _load_rtk_pos,
    _video_info,
    _eaf_map,
    _explain,
    _GOAL_C, _STIM_C, _CAUSE_C, _DEF_C,
    _EVT_DOT, _NOEVT_DOT,
)

# ── YOLO utilities (detection drawing, bbox colours) ─────────────────────────
from twimo.strategies_eaf.two_stage_yolo import (
    COCO_TRAFFIC_LIGHT, COCO_STOP_SIGN,
    COCO_PERSON, COCO_BICYCLE, COCO_MOTORCYCLE,
    COCO_CAR, COCO_BUS, COCO_TRUCK,
    VEHICLE_IDS, HEAVY_IDS,
    _classify_tl_color,
)

# ── Improved model & features ─────────────────────────────────────────────────
from twimo.strategies_eaf.two_stage_yolo_improved import (
    D_IMP,
    FEAT_BLOCKS,
    DET_FEATURE_NAMES_IMP,
    ImpConfig,
    _imp_config_from_dict,
    _imp_config_to_dict,
    _extract_det_features_imp,
    _predict_improved,
    _load_improved_models,
    _compute_sensor_video_offset,
)


# ──────────────────────────────────────────────────────────────────────────────
# COCO class → zone-aware colour mapping
# ──────────────────────────────────────────────────────────────────────────────

def _zone_cause_key(cls_id: int, cx_norm: float, cy_norm: float) -> str:
    """Return a cause-key for bbox colour based on object class and zone."""
    if cls_id == COCO_TRAFFIC_LIGHT:
        return "red_light"
    if cls_id == COCO_STOP_SIGN:
        return "sign"
    if cls_id == COCO_PERSON:
        in_lane = 0.25 <= cx_norm <= 0.75 and cy_norm > 0.40
        return "crossing_pedestrian" if in_lane else "parked_vehicle"
    if cls_id in VEHICLE_IDS:
        in_ego    = 0.30 <= cx_norm <= 0.70
        oncoming  = in_ego and cy_norm < 0.35
        adj_left  = 0.10 <= cx_norm <  0.30
        adj_right = 0.70 <  cx_norm <= 0.90
        if oncoming:
            return "crossing_vehicle"       # magenta
        if in_ego:
            return "congestion"             # red/orange (vehicle ahead in ego lane)
        if adj_left or adj_right:
            return "cut-in"                 # orange (adjacent lane)
        return "parked_vehicle"             # dim (far edge)
    if cls_id == COCO_BICYCLE:
        return "on-road_bicyclist"
    if cls_id == COCO_MOTORCYCLE:
        return "on-road_motorcyclist"
    return "unknown"


# ──────────────────────────────────────────────────────────────────────────────
# YOLOv8 live detector
# ──────────────────────────────────────────────────────────────────────────────

class YoloDetector:
    """Thin wrapper around ultralytics YOLO for per-frame inference."""

    def __init__(self, model_name: str = "yolov8n.pt", conf: float = 0.30):
        try:
            from ultralytics import YOLO
        except ImportError:
            print("ERROR: ultralytics not installed.  pip install ultralytics",
                  file=sys.stderr)
            sys.exit(1)
        self.model = YOLO(model_name)
        self.conf  = conf
        print(f"  YOLOv8 loaded: {model_name}")

    def infer(self, frame_bgr: np.ndarray,
              prev_veh=None, prev_ped=None, prev_roi=None):
        """Run inference and return (result, feat_imp, curr_veh, curr_ped, curr_roi)."""
        results = self.model(frame_bgr, verbose=False, conf=self.conf)
        r = results[0] if results else None
        feat, cv, cp, cr = _extract_det_features_imp(
            r, frame_bgr, prev_veh, prev_ped, prev_roi)
        return r, feat, cv, cp, cr


# ──────────────────────────────────────────────────────────────────────────────
# Zone-aware bbox drawing
# ──────────────────────────────────────────────────────────────────────────────

def _draw_detections_improved(frame: np.ndarray, result,
                               conf_thr: float = 0.30,
                               show_zones: bool = True) -> np.ndarray:
    """Draw zone-coloured bounding boxes on the frame."""
    MONITORED = {COCO_TRAFFIC_LIGHT, COCO_STOP_SIGN, COCO_PERSON,
                 COCO_BICYCLE, COCO_MOTORCYCLE, COCO_CAR, COCO_BUS, COCO_TRUCK}

    if result is None or result.boxes is None or len(result.boxes) == 0:
        return frame

    out  = frame
    aa   = cv2.LINE_AA
    font = cv2.FONT_HERSHEY_SIMPLEX
    fh, fw = out.shape[:2]
    sc   = max(0.34, min(0.52, fw / 1920.0 * 0.52))

    for box in result.boxes:
        cls_id = int(box.cls[0])
        conf   = float(box.conf[0])
        if conf < conf_thr or cls_id not in MONITORED:
            continue

        x1, y1, x2, y2 = map(int, box.xyxy[0].tolist())
        cx_norm = (x1 + x2) / (2.0 * fw)
        cy_norm = (y1 + y2) / (2.0 * fh)

        # Choose zone-aware colour
        if cls_id == COCO_TRAFFIC_LIGHT:
            tl_col    = _classify_tl_color(frame, (x1, y1, x2, y2))
            cause_key = {"red": "red_light", "yellow": "yellow_light",
                         "green": "crossing_vehicle"}.get(tl_col, "red_light")
            disp_lbl  = f"TL {tl_col.capitalize()}"
        else:
            cause_key = _zone_cause_key(cls_id, cx_norm, cy_norm) \
                if show_zones else "crossing_vehicle"
            labels_map = {
                COCO_PERSON:     "Person",
                COCO_BICYCLE:    "Cyclist",
                COCO_MOTORCYCLE: "Moto",
                COCO_CAR:        "Car",
                COCO_BUS:        "Bus",
                COCO_TRUCK:      "Truck",
                COCO_STOP_SIGN:  "StopSign",
            }
            disp_lbl = labels_map.get(cls_id, str(cls_id))

        bgr = _CAUSE_C.get(cause_key, _DEF_C)
        cv2.rectangle(out, (x1, y1), (x2, y2), bgr, 2, aa)

        label_txt = f"{disp_lbl} {conf:.0%}"
        (tw, th), _ = cv2.getTextSize(label_txt, font, sc, 1)
        lx = x1
        ly = max(th + 4, y1 - 4)
        cv2.rectangle(out, (lx, ly - th - 4), (lx + tw + 4, ly + 2), bgr, -1)
        cv2.putText(out, label_txt, (lx + 2, ly - 1),
                    font, sc, (10, 10, 10), 1, aa)

    return out


# ──────────────────────────────────────────────────────────────────────────────
# Text helper: draw text at the largest scale that fits within max_w pixels
# ──────────────────────────────────────────────────────────────────────────────

def _autofit_text(
    out:    np.ndarray,
    text:   str,
    x: int, y: int,
    max_w:  int,
    max_sc: float,
    color:  tuple,
    aa:     int,
    min_sc: float = 0.28,
) -> None:
    """Draw `text` at (x, y), reducing font scale until it fits within max_w px."""
    font = cv2.FONT_HERSHEY_SIMPLEX
    sc = max_sc
    while sc >= min_sc:
        if cv2.getTextSize(text, font, sc, 1)[0][0] <= max_w:
            break
        sc = round(sc - 0.04, 4)
    cv2.putText(out, text, (x, y), font, sc, color, 1, aa)


# ──────────────────────────────────────────────────────────────────────────────
# Improved panel drawing
# ──────────────────────────────────────────────────────────────────────────────

def _draw_panel_improved(
    frame:         np.ndarray,
    gt_cause:      str, gt_attention: str,
    gt_goal:       str, gt_stimuli:   str,
    horizon_rows:  List[Tuple],           # (h_s, is_ev, goal, stim, g_pr, s_pr, cause, c_pr, attn, a_pr, ev_prob)
    explanation:   str,
    speed_kmh:     float, steer_deg:  float,
    brake_kpa:     float, accel_pct:  float, yaw: float,
    strategies:    List[str],
    use_1b:        bool = False,
    rtk_lng:       Optional[float] = None,
    rtk_lat:       Optional[float] = None,
) -> np.ndarray:
    """Panel with two sub-tables in the center:
       Top:    h | P1 | Goal  [bar %] | Stimuli  [bar %]
       Bottom: h | P1 | Cause [bar %] | Attention[bar %]
       Then: explanation text.
    """
    out  = frame.copy()
    fh, fw = out.shape[:2]
    aa   = cv2.LINE_AA
    font = cv2.FONT_HERSHEY_SIMPLEX

    # ── GPS overlay (top-right) ────────────────────────────────────────────────
    if rtk_lng is not None and rtk_lat is not None:
        gps_sc = max(0.58, min(0.78, fw / 1920.0 * 0.80))
        for gi, gl in enumerate([f"Lng {rtk_lng:.6f}", f"Lat {rtk_lat:.6f}"]):
            tw = cv2.getTextSize(gl, font, gps_sc, 1)[0][0]
            gx = fw - tw - 12; gy = 24 + gi * 22
            cv2.putText(out, gl, (gx + 1, gy + 1), font, gps_sc, (0, 0, 0),      2, aa)
            cv2.putText(out, gl, (gx,     gy),     font, gps_sc, (160, 230, 160), 1, aa)

    # ── Panel geometry ────────────────────────────────────────────────────────
    N      = len(horizon_rows)
    row_h  = 26   # pixels per data row
    hdr_h  = 18   # pixels for column-header text
    sep_h  = 10   # gap between the two sub-tables
    expl_h = 38   # space reserved for explanation text (2 lines)
    # total height = top_pad + title + sub-table-1 + sep + sub-table-2 + expl + bot_pad
    needed    = 16 + 16 + (hdr_h + N * row_h) + sep_h + (hdr_h + N * row_h) + expl_h + 6
    panel_h   = min(needed, fh * 45 // 100)
    panel_top = fh - panel_h

    ov = out.copy()
    cv2.rectangle(ov, (0, panel_top), (fw, fh), (10, 10, 14), -1)
    cv2.addWeighted(ov, 0.72, out, 0.28, 0, out)
    cv2.line(out, (0, panel_top), (fw, panel_top), (60, 60, 70), 1)

    scm    = max(0.62, min(0.88, fw / 1920.0 * 0.88))
    scs    = max(0.56, scm - 0.06)
    sct    = max(0.50, scm - 0.12)
    pct_sc = max(0.40, sct - 0.10)

    left_w = fw * 20 // 100
    mid_w  = fw * 56 // 100

    c0 = 8; c1 = left_w + 8; c2 = left_w + mid_w + 8
    y0 = panel_top + 20

    cv2.line(out, (left_w,         panel_top), (left_w,         fh), (55, 55, 65), 1)
    cv2.line(out, (left_w + mid_w, panel_top), (left_w + mid_w, fh), (55, 55, 65), 1)

    # max widths (pixels) for auto-fitting label text
    lbl_prefix_w = 56   # width reserved for "Goal:" / "Cause:" prefix on left panel
    left_val_w   = max(30, left_w - c0 - lbl_prefix_w - 8)   # remaining width for value
    pred_lbl_w   = mid_w * 20 // 100 - 4                      # width per prediction label cell

    # ── LEFT: EAF GT labels ───────────────────────────────────────────────────
    cv2.putText(out, "EAF LABELS", (c0, y0), font, scm, (170, 210, 210), 1, aa)
    for i, (lbl, val, cdict) in enumerate([
        ("Goal",    gt_goal,      _GOAL_C),
        ("Stimuli", gt_stimuli,   _STIM_C),
        ("Cause",   gt_cause,     _CAUSE_C),
        ("Attn",    gt_attention, _CAUSE_C),
    ]):
        y   = y0 + 24 + i * 24
        col = cdict.get(val, _DEF_C)
        cv2.putText(out, f"{lbl}:", (c0, y), font, sct, (150, 150, 150), 1, aa)
        _autofit_text(out, val, c0 + lbl_prefix_w, y, left_val_w, sct, col, aa)

    strat_str = "S:" + "+".join(strategies) if strategies else "S:base"
    cv2.putText(out, strat_str,
                (c0, y0 + 24 + 4 * 24 + 6),
                font, max(0.30, sct - 0.08), (120, 200, 255), 1, aa)

    # ── MIDDLE: shared column x-positions ─────────────────────────────────────
    # Layout per sub-table: h | P1/Evt | Label1 [bar %] | Label2 [bar %]
    bw     = mid_w * 12 // 100   # bar width
    hx_h   = c1
    hx_dot = c1 + mid_w *  7 // 100
    hx_l1  = c1 + mid_w * 17 // 100   # Goal label  / Cause label
    hx_b1  = c1 + mid_w * 37 // 100   # Goal bar    / Cause bar
    hx_l2  = c1 + mid_w * 56 // 100   # Stimuli label / Attention label
    hx_b2  = c1 + mid_w * 76 // 100   # Stimuli bar / Attention bar

    hdr_txt = "P1" if use_1b else "Evt"
    cv2.putText(out, "PREDICTIONS", (c1, y0), font, scm, (200, 200, 140), 1, aa)

    expl_src = ""

    # ── Sub-table 1: Goal + Stimuli ───────────────────────────────────────────
    y_hdr1 = y0 + 18
    for x, lbl in [(hx_h, "h"), (hx_dot, hdr_txt), (hx_l1, "Goal"), (hx_l2, "Stimuli")]:
        cv2.putText(out, lbl, (x, y_hdr1), font, sct, (140, 140, 140), 1, aa)

    for ri, row in enumerate(horizon_rows):
        h_s, is_ev, goal_s, stim_s, g_prob, s_prob = row[:6]
        ev_prob = float(row[10]) if len(row) > 10 else (1.0 if is_ev else 0.0)
        yr = y_hdr1 + hdr_h + ri * row_h

        cv2.putText(out, f"{h_s:.0f}s", (hx_h, yr), font, scs, (200, 200, 200), 1, aa)

        if use_1b:
            pct_col = (0, int(ev_prob * 255), int((1 - ev_prob) * 180))
            cv2.putText(out, f"{ev_prob*100:.0f}%",
                        (hx_dot, yr), font, pct_sc, pct_col, 1, aa)
        else:
            dot_c = _EVT_DOT if is_ev else _NOEVT_DOT
            cv2.circle(out, (hx_dot + 10, yr - 8), 7, dot_c, -1, aa)

        if is_ev:
            gc = _GOAL_C.get(goal_s, _DEF_C)
            _autofit_text(out, goal_s, hx_l1, yr, pred_lbl_w, sct, gc, aa)
            cv2.rectangle(out, (hx_b1, yr - 12), (hx_b1 + bw, yr + 2), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_b1, yr - 12),
                          (hx_b1 + int(bw * max(0.0, min(1.0, g_prob))), yr + 2), gc, -1)
            cv2.putText(out, f"{g_prob*100:.0f}%", (hx_b1 + bw + 4, yr),
                        font, pct_sc, gc, 1, aa)

            sc2 = _STIM_C.get(stim_s, _DEF_C)
            _autofit_text(out, stim_s, hx_l2, yr, pred_lbl_w, sct, sc2, aa)
            cv2.rectangle(out, (hx_b2, yr - 12), (hx_b2 + bw, yr + 2), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_b2, yr - 12),
                          (hx_b2 + int(bw * max(0.0, min(1.0, s_prob))), yr + 2), sc2, -1)
            cv2.putText(out, f"{s_prob*100:.0f}%", (hx_b2 + bw + 4, yr),
                        font, pct_sc, sc2, 1, aa)

            if not expl_src:
                expl_src = explanation
        else:
            for x in (hx_l1, hx_l2):
                cv2.putText(out, "-", (x, yr), font, sct, (90, 90, 90), 1, aa)

    # ── Separator line ────────────────────────────────────────────────────────
    y_sep  = y_hdr1 + hdr_h + N * row_h + 4
    cv2.line(out, (c1, y_sep), (c1 + mid_w - 16, y_sep), (55, 55, 65), 1)

    # ── Sub-table 2: Cause + Attention ────────────────────────────────────────
    y_hdr2 = y_sep + sep_h
    for x, lbl in [(hx_h, "h"), (hx_dot, hdr_txt), (hx_l1, "Cause"), (hx_l2, "Attention")]:
        cv2.putText(out, lbl, (x, y_hdr2), font, sct, (140, 140, 140), 1, aa)

    for ri, row in enumerate(horizon_rows):
        h_s, is_ev = row[0], row[1]
        cause_s = row[6] if len(row) > 6  else "unknown"
        c_prob  = float(row[7]) if len(row) > 7 else 0.0
        attn_s  = row[8] if len(row) > 8  else "unknown"
        a_prob  = float(row[9]) if len(row) > 9 else 0.0
        ev_prob = float(row[10]) if len(row) > 10 else (1.0 if is_ev else 0.0)
        yr = y_hdr2 + hdr_h + ri * row_h

        cv2.putText(out, f"{h_s:.0f}s", (hx_h, yr), font, scs, (200, 200, 200), 1, aa)

        if use_1b:
            pct_col = (0, int(ev_prob * 255), int((1 - ev_prob) * 180))
            cv2.putText(out, f"{ev_prob*100:.0f}%",
                        (hx_dot, yr), font, pct_sc, pct_col, 1, aa)
        else:
            dot_c = _EVT_DOT if is_ev else _NOEVT_DOT
            cv2.circle(out, (hx_dot + 10, yr - 8), 7, dot_c, -1, aa)

        if is_ev:
            cc = _CAUSE_C.get(cause_s, _DEF_C)
            _autofit_text(out, cause_s, hx_l1, yr, pred_lbl_w, sct, cc, aa)
            cv2.rectangle(out, (hx_b1, yr - 12), (hx_b1 + bw, yr + 2), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_b1, yr - 12),
                          (hx_b1 + int(bw * max(0.0, min(1.0, c_prob))), yr + 2), cc, -1)
            cv2.putText(out, f"{c_prob*100:.0f}%", (hx_b1 + bw + 4, yr),
                        font, pct_sc, cc, 1, aa)

            ac = _CAUSE_C.get(attn_s, _DEF_C)
            _autofit_text(out, attn_s, hx_l2, yr, pred_lbl_w, sct, ac, aa)
            cv2.rectangle(out, (hx_b2, yr - 12), (hx_b2 + bw, yr + 2), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_b2, yr - 12),
                          (hx_b2 + int(bw * max(0.0, min(1.0, a_prob))), yr + 2), ac, -1)
            cv2.putText(out, f"{a_prob*100:.0f}%", (hx_b2 + bw + 4, yr),
                        font, pct_sc, ac, 1, aa)
        else:
            for x in (hx_l1, hx_l2):
                cv2.putText(out, "-", (x, yr), font, sct, (90, 90, 90), 1, aa)

    # ── Explanation text ──────────────────────────────────────────────────────
    if expl_src:
        y_ex  = y_hdr2 + hdr_h + N * row_h + 8
        limit = max(20, mid_w // max(1, int(sct * 12)))
        words = expl_src.split(); lines_ex: List[str] = []; ln_b = ""
        for w in words:
            if len(ln_b) + len(w) + 1 <= limit:
                ln_b = (ln_b + " " + w).strip()
            else:
                if ln_b: lines_ex.append(ln_b)
                ln_b = w
        if ln_b: lines_ex.append(ln_b)
        for j, l in enumerate(lines_ex[:2]):
            yj = y_ex + j * 18
            if yj >= fh - 6: break
            cv2.putText(out, l, (c1, yj), font, max(0.34, sct - 0.04),
                        (190, 190, 190), 1, aa)

    # ── RIGHT: Sensors ────────────────────────────────────────────────────────
    cv2.putText(out, "SENSORS", (c2, y0), font, scm, (140, 200, 140), 1, aa)
    for i, (lbl, val) in enumerate([
        ("Speed", f"{speed_kmh:6.1f} km/h"),
        ("Steer", f"{steer_deg:+6.1f} deg"),
        ("Brake", f"{brake_kpa:6.0f} kPa"),
        ("Accel", f"{accel_pct:6.1f} %"),
        ("Yaw",   f"{yaw:+6.2f}"),
    ]):
        y = y0 + 24 + i * 26
        cv2.putText(out, f"{lbl}:", (c2,      y), font, sct, (140, 140, 140), 1, aa)
        cv2.putText(out, val,       (c2 + 54, y), font, scs, (210, 230, 210), 1, aa)

    return out


# ──────────────────────────────────────────────────────────────────────────────
# Helper: get detection features for current frame from cache or live YOLO
# ──────────────────────────────────────────────────────────────────────────────

def _get_det_feat_for_step(
    i_s:            int,
    X_det_cache:    Optional[np.ndarray],   # (T, det_dim) pre-selected columns
    live_feat:      Optional[np.ndarray],   # (D_IMP,) from live YOLO pass
    cfg:            ImpConfig,
) -> np.ndarray:
    """Return the det feature vector for sensor step i_s."""
    if X_det_cache is not None and i_s < X_det_cache.shape[0]:
        return X_det_cache[i_s]
    if live_feat is not None:
        cols = cfg.active_det_cols()
        return live_feat[cols]
    return np.zeros(cfg.det_dim, dtype=np.float32)


# ──────────────────────────────────────────────────────────────────────────────
# Core annotation loop
# ──────────────────────────────────────────────────────────────────────────────

def annotate_session_improved(
    session_id:    str,
    video_path:    Path,
    prealigned:    Optional[Path],
    csv_dir:       Optional[Path],
    det_cache_imp: Optional[Path],   # full improved (T, 39) npy cache
    det_cache_org: Optional[Path],   # fallback original (T, 13) npy cache
    yolo:          Optional[YoloDetector],
    s1:            Optional[torch.nn.Module],
    s2:            torch.nn.Module,
    cfg:           ImpConfig,
    mean:          np.ndarray,
    std:           np.ndarray,
    goal_labels:   List[str],
    stim_labels:   List[str],
    cause_labels:  List[str],
    att_labels:    List[str],
    cause_lmap:    Dict, cause_vocab: Dict,
    att_lmap:      Dict, att_vocab:   Dict,
    goal_lmap:     Dict, goal_vocab:  Dict,
    stim_lmap:     Dict, stim_vocab:  Dict,
    cause_anns:    List[dict],
    att_anns:      List[dict],
    goal_gt_anns:  List[dict],
    stim_gt_anns:  List[dict],
    outdir:        Path,
    sample_hz:     float,
    horizons_s:    List[float],
    yolo_conf:     float    = 0.30,
    show_zones:    bool     = True,
    max_seconds:   Optional[float] = None,
) -> None:
    from twimo.data.csv_session import load_sensors_from_csv_dir, resample_sensors

    print(f"\n[annotate_improved] {session_id}  strategies={cfg.strategies}")

    # ── 1. Sensor loading ─────────────────────────────────────────────────────
    X:              Optional[np.ndarray] = None
    t_sensor:       Optional[np.ndarray] = None
    X_csv:          Optional[np.ndarray] = None
    csv_names:      List[str]            = []
    t_sensor_csv:   Optional[np.ndarray] = None
    t_offset_s:     float                = 0.0
    t_csv_offset_s: float                = 0.0

    if csv_dir is not None and csv_dir.exists():
        try:
            fr = load_sensors_from_csv_dir(csv_dir)
            t_sensor_csv, X_csv, csv_names = resample_sensors(fr, sample_hz=sample_hz)
        except Exception:
            X_csv = None

    if prealigned is not None and prealigned.exists():
        Xp       = np.load(prealigned).astype(np.float32)
        t_sensor = np.arange(Xp.shape[0], dtype=np.float32) / float(sample_hz)
        X        = Xp
        t_offset_s = 0.0
        print("  Prealigned: %s @ %g Hz" % (X.shape, sample_hz))
        if X_csv is not None:
            t_csv_offset_s = _compute_sensor_video_offset(
                session_id, csv_dir, video_path)
            if t_csv_offset_s != 0.0:
                print("  CSV display offset: %.3fs" % t_csv_offset_s)
    elif X_csv is not None:
        t_sensor       = t_sensor_csv
        X              = X_csv
        t_offset_s     = _compute_sensor_video_offset(
            session_id, csv_dir, video_path)
        t_csv_offset_s = t_offset_s
    else:
        print("  WARNING: no sensor data – skip"); return

    if X is None or X.shape[0] == 0:
        return

    T            = X.shape[0]
    t_rel        = t_sensor - t_sensor[0]
    sensor_dur_s = float(t_rel[-1])

    t_rel_csv: Optional[np.ndarray] = None
    if X_csv is not None and t_sensor_csv is not None:
        t_rel_csv = t_sensor_csv - t_sensor_csv[0]

    # ── 2. Detection features ─────────────────────────────────────────────────
    X_det_full: Optional[np.ndarray] = None   # (T, D_IMP) improved cache
    X_det_cols: Optional[np.ndarray] = None   # (T, det_dim) selected columns

    if det_cache_imp is not None and det_cache_imp.exists():
        arr = np.load(det_cache_imp).astype(np.float32)
        if arr.shape[0] != T:
            arr = np.resize(arr, (T, D_IMP))
        X_det_full = arr
        cols = cfg.active_det_cols()
        X_det_cols = arr[:, cols]
        print(f"  Improved det cache: {X_det_full.shape} -> cols {len(cols)}")
    elif det_cache_org is not None and det_cache_org.exists():
        arr = np.load(det_cache_org).astype(np.float32)
        if arr.shape[0] != T:
            arr = np.resize(arr, (T, 13))
        pad_needed = cfg.det_dim - 13
        if pad_needed > 0:
            pad = np.zeros((T, pad_needed), dtype=np.float32)
            X_det_cols = np.concatenate([arr, pad], axis=1)
            print(f"  Original det cache (padded to {cfg.det_dim})")
        else:
            X_det_cols = arr[:, :cfg.det_dim]
            print(f"  Original det cache: {arr.shape}")
    elif yolo is None:
        X_det_cols = np.zeros((T, cfg.det_dim), dtype=np.float32)
        print("  No det cache and no live YOLO – det features = 0")

    # Build full input matrix for batch prediction
    if X_det_cols is not None:
        X_full = np.concatenate([X, X_det_cols], axis=1)
    else:
        # Live YOLO: we'll build X_full lazily per-frame during annotation
        X_full = np.concatenate(
            [X, np.zeros((T, cfg.det_dim), dtype=np.float32)], axis=1)

    # ── 3. RTK ────────────────────────────────────────────────────────────────
    rtk_lngs, rtk_lats = _load_rtk_pos(csv_dir, t_rel)

    # ── 4. Batch predictions ──────────────────────────────────────────────────
    print("  Running predictions …")
    ev_p, g_p, g_pr, s_p, s_pr, c_p, c_pr, a_p, a_pr, ev_prb = \
        _predict_improved(X_full, mean, std, s1, s2, cfg)
    N  = len(ev_p)
    wl = cfg.window_len
    print(f"  Windows={N}  Events={int(ev_p.sum())} ({100*ev_p.mean():.1f}%)")

    # ── 5. Video pipeline ─────────────────────────────────────────────────────
    fps, vw, vh = _video_info(video_path)
    out_path    = outdir / f"annotated_improved_{session_id}.mp4"
    outdir.mkdir(parents=True, exist_ok=True)
    max_f       = int(max_seconds * fps) if max_seconds else None

    dec_cmd = ["ffmpeg", "-hide_banner", "-loglevel", "error",
                "-i", str(video_path)]
    if max_f:
        dec_cmd += ["-vframes", str(max_f)]
    dec_cmd += ["-f", "rawvideo", "-pix_fmt", "bgr24", "pipe:1"]

    enc_cmd = ["ffmpeg", "-hide_banner", "-loglevel", "error", "-y",
               "-f", "rawvideo", "-pix_fmt", "bgr24",
               "-r", str(fps), "-s", f"{vw}x{vh}", "-i", "pipe:0",
               "-c:v", "libx264", "-crf", "23", "-preset", "fast",
               "-pix_fmt", "yuv420p", str(out_path)]

    decoder = subprocess.Popen(dec_cmd, stdout=subprocess.PIPE,
                               stderr=subprocess.PIPE)
    encoder = subprocess.Popen(enc_cmd, stdin=subprocess.PIPE,
                               stderr=subprocess.PIPE)

    fb              = vw * vh * 3
    fi              = 0
    hz_offsets      = [int(round(h * sample_hz)) for h in horizons_s]
    last_yolo_result = None
    live_imp_feat    = None
    prev_veh_boxes   = None
    prev_ped_boxes   = None
    prev_roi_live    = None
    use_1b           = "1b" in cfg.strategies

    print("  Annotating -> %s" % out_path)

    try:
        while True:
            raw = decoder.stdout.read(fb)
            if not raw or len(raw) < fb:
                break

            t_fr   = fi / fps
            i_s    = int(np.argmin(np.abs(t_rel - (t_fr + t_offset_s))))
            frame  = np.frombuffer(raw, np.uint8).reshape(vh, vw, 3).copy()

            # ── Live YOLO pass ────────────────────────────────────────────────
            if yolo is not None:
                if fi % max(1, int(fps / sample_hz)) == 0:
                    (last_yolo_result, live_imp_feat,
                     prev_veh_boxes, prev_ped_boxes,
                     prev_roi_live) = yolo.infer(
                        frame, prev_veh_boxes, prev_ped_boxes, prev_roi_live)
                if last_yolo_result is not None:
                    frame = _draw_detections_improved(
                        frame, last_yolo_result, yolo_conf, show_zones)

            # ── GT labels ────────────────────────────────────────────────────
            t_ms     = t_fr * 1000.0
            gt_cause = _at(cause_anns, t_ms, cause_lmap, cause_vocab)
            gt_attn  = _at(att_anns,   t_ms, att_lmap,   att_vocab)
            gt_goal  = _at(goal_gt_anns, t_ms, goal_lmap, goal_vocab)
            gt_stim  = _at(stim_gt_anns, t_ms, stim_lmap, stim_vocab)

            # ── Multi-horizon predictions ─────────────────────────────────────
            t_frame_rel    = t_fr
            horizon_rows: List[Tuple] = []
            expl = ""

            for h_s, off in zip(horizons_s, hz_offsets):
                future_is = i_s + off
                pred_k    = future_is - wl + 1
                if 0 <= pred_k < N:
                    is_ev   = bool(ev_p[pred_k])
                    ep      = float(ev_prb[pred_k])
                    goal_s  = goal_labels[int(g_p[pred_k])] \
                              if is_ev and int(g_p[pred_k]) < len(goal_labels) \
                              else "unknown"
                    stim_s  = stim_labels[int(s_p[pred_k])] \
                              if is_ev and int(s_p[pred_k]) < len(stim_labels) \
                              else "unknown"
                    cause_s = cause_labels[int(c_p[pred_k])] \
                              if is_ev and int(c_p[pred_k]) < len(cause_labels) \
                              else "unknown"
                    attn_s  = att_labels[int(a_p[pred_k])] \
                              if is_ev and int(a_p[pred_k]) < len(att_labels) \
                              else "unknown"
                    gpr     = float(g_pr[pred_k]) if is_ev else 0.0
                    spr     = float(s_pr[pred_k]) if is_ev else 0.0
                    cpr     = float(c_pr[pred_k]) if is_ev else 0.0
                    apr     = float(a_pr[pred_k]) if is_ev else 0.0
                else:
                    is_ev   = False; ep = 0.0
                    goal_s  = stim_s = cause_s = attn_s = "unknown"
                    gpr     = spr = cpr = apr = 0.0

                if is_ev and not expl:
                    expl = _explain(goal_s, stim_s, gt_cause, gt_attn)

                horizon_rows.append(
                    (h_s, is_ev, goal_s, stim_s, gpr, spr,
                     cause_s, cpr, attn_s, apr, ep))

            # ── Sensor readout ────────────────────────────────────────────────
            speed = steer = brake = accel = yaw = 0.0
            if X_csv is not None and t_rel_csv is not None:
                row = int(np.argmin(
                    np.abs(t_rel_csv - (t_frame_rel + t_csv_offset_s))))
                row = min(row, X_csv.shape[0] - 1)
                for ci, fn in enumerate(csv_names):
                    if ci >= X_csv.shape[1]: break
                    v   = float(X_csv[row, ci])
                    fnl = fn.lower()
                    if "speed" in fnl or fn.endswith(".speed"):  speed = v
                    elif "steer_angle" in fnl:                   steer = v
                    elif "pedalpressure" in fnl:                  brake = v
                    elif "pedalangle" in fnl:                     accel = v
                    elif ".yaw" in fnl:                           yaw   = v

            rtk_lng = float(rtk_lngs[min(i_s, len(rtk_lngs) - 1)]) \
                      if rtk_lngs is not None else None
            rtk_lat = float(rtk_lats[min(i_s, len(rtk_lats) - 1)]) \
                      if rtk_lats is not None else None

            # ── Draw panel ────────────────────────────────────────────────────
            annotated = _draw_panel_improved(
                frame,
                gt_cause=gt_cause, gt_attention=gt_attn,
                gt_goal=gt_goal,   gt_stimuli=gt_stim,
                horizon_rows=horizon_rows,
                explanation=expl,
                speed_kmh=speed, steer_deg=steer,
                brake_kpa=brake, accel_pct=accel, yaw=yaw,
                strategies=cfg.strategies,
                use_1b=use_1b,
                rtk_lng=rtk_lng, rtk_lat=rtk_lat,
            )
            encoder.stdin.write(annotated.tobytes())
            fi += 1

            if fi % 300 == 0:
                pct = min(100.0, t_fr / max(sensor_dur_s, 1e-6) * 100)
                print(f"    ... {t_fr:.0f}s | {pct:.0f}% | i_s={i_s}/{T-1}")

    except BrokenPipeError:
        pass
    finally:
        try: decoder.stdout.close()
        except: pass
        decoder.terminate()
        try: encoder.stdin.close()
        except: pass
        encoder.wait()

    print("  Done -> %s  (%d frames)" % (out_path, fi))


# ──────────────────────────────────────────────────────────────────────────────
# CLI
# ──────────────────────────────────────────────────────────────────────────────

def main() -> None:
    pa = argparse.ArgumentParser(
        description="Annotate video with improved EAF predictions + YOLOv8 bboxes.")
    pa.add_argument("--manifest",               required=True,  type=Path)
    pa.add_argument("--model-dir",              required=True,  type=Path,
                    help="Dir with stage1.pt, stage2.pt, config.json from train")
    pa.add_argument("--vocab-dir",              required=True,  type=Path)
    pa.add_argument("--prealigned-sensors-dir", default=None,   type=Path)
    pa.add_argument("--det-cache-dir",          default=None,   type=Path,
                    help="Dir with {sid}_det_imp.npy (improved) or {sid}_det.npy")
    pa.add_argument("--eaf-parsed-dir",         default=None,   type=Path)
    pa.add_argument("--outdir",                 required=True,  type=Path)
    pa.add_argument("--session",                default=None,   type=str)
    pa.add_argument("--sample-hz",              default=3.0,    type=float)
    pa.add_argument("--horizons",               default=[1.0, 3.0, 5.0],
                    type=float, nargs="+")
    pa.add_argument("--max-seconds",            default=None,   type=float)
    pa.add_argument("--yolo-model",             default=None,   type=str,
                    help="YOLOv8 model for live bbox overlay (e.g. yolov8n.pt)")
    pa.add_argument("--yolo-conf",              default=0.30,   type=float)
    pa.add_argument("--no-zone-colours",        action="store_true",
                    help="Disable zone-aware bbox colouring (use flat colours)")
    args = pa.parse_args()

    # ── Manifest ──────────────────────────────────────────────────────────────
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

    vids = []
    for r in records:
        vd = r.get("video_dir")
        if vd:
            mp4s = list(Path(vd).glob("*.mp4"))
            if mp4s:
                r["_vp"] = mp4s[0]; vids.append(r)
    if not vids:
        print("No sessions with video found.", file=sys.stderr); sys.exit(1)
    print(f"Sessions with video: {len(vids)}")

    # ── Load improved model ───────────────────────────────────────────────────
    print("\nLoading improved model …")
    s1, s2, cfg, mean, std = _load_improved_models(args.model_dir)
    print(f"  Strategies: {cfg.strategies}")
    print(f"  input_dim={cfg.input_dim}  window={cfg.window_sec}s  "
          f"det_dim={cfg.det_dim}")

    # ── Vocabularies ──────────────────────────────────────────────────────────
    goal_labels,  goal_lmap,  goal_vocab  = _load_vocab(
        args.vocab_dir / "vocab_goal.json")
    stim_labels,  stim_lmap,  stim_vocab  = _load_vocab(
        args.vocab_dir / "vocab_stimuli.json")
    cause_labels, cause_lmap, cause_vocab = _load_vocab(
        args.vocab_dir / "vocab_cause.json")
    att_labels,   att_lmap,   att_vocab   = _load_vocab(
        args.vocab_dir / "vocab_attention.json")

    # ── EAF map ───────────────────────────────────────────────────────────────
    em = _eaf_map(args.eaf_parsed_dir)

    # ── Optional live YOLO ────────────────────────────────────────────────────
    yolo: Optional[YoloDetector] = None
    if args.yolo_model:
        yolo = YoloDetector(model_name=args.yolo_model, conf=args.yolo_conf)

    args.outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="annotate_video_eaf_yolo_improved", output_dir=args.outdir, use_codecarbon=True)
    _profiler.__enter__()

    # ── Per-session loop ──────────────────────────────────────────────────────
    for r in vids:
        sid     = r["session_id"]
        csv_dir = Path(r["csv_dir"]) if r.get("csv_dir") else None
        vp      = r["_vp"]

        pre: Optional[Path] = None
        if args.prealigned_sensors_dir:
            c = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
            if c.exists():
                pre = c

        det_imp: Optional[Path] = None
        det_org: Optional[Path] = None
        if args.det_cache_dir:
            dc_imp = Path(args.det_cache_dir) / f"{sid}_det_imp.npy"
            dc_org = Path(args.det_cache_dir) / f"{sid}_det.npy"
            if dc_imp.exists():
                det_imp = dc_imp
            elif dc_org.exists():
                det_org = dc_org

        cause_a = att_a = goal_gt = stim_gt = []
        if sid in em:
            cause_a, att_a, goal_gt, stim_gt = _load_eaf_tiers(
                em[sid],
                cause_lmap, cause_vocab,
                att_lmap,   att_vocab,
                goal_lmap,  goal_vocab,
                stim_lmap,  stim_vocab,
            )

        try:
            annotate_session_improved(
                session_id    = sid,
                video_path    = vp,
                prealigned    = pre,
                csv_dir       = csv_dir,
                det_cache_imp = det_imp,
                det_cache_org = det_org,
                yolo          = yolo,
                s1=s1, s2=s2, cfg=cfg, mean=mean, std=std,
                goal_labels   = goal_labels,
                stim_labels   = stim_labels,
                cause_labels  = cause_labels,
                att_labels    = att_labels,
                cause_lmap=cause_lmap, cause_vocab=cause_vocab,
                att_lmap=att_lmap,     att_vocab=att_vocab,
                goal_lmap=goal_lmap,   goal_vocab=goal_vocab,
                stim_lmap=stim_lmap,   stim_vocab=stim_vocab,
                cause_anns    = cause_a,
                att_anns      = att_a,
                goal_gt_anns  = goal_gt,
                stim_gt_anns  = stim_gt,
                outdir        = args.outdir,
                sample_hz     = args.sample_hz,
                horizons_s    = args.horizons,
                yolo_conf     = args.yolo_conf,
                show_zones    = not args.no_zone_colours,
                max_seconds   = args.max_seconds,
            )
        except Exception as e:
            print(f"[ERROR] {sid}: {e}", file=sys.stderr)
            import traceback; traceback.print_exc()

    _profiler.__exit__(None, None, None)
    print("\nAll done.")


if __name__ == "__main__":
    main()
