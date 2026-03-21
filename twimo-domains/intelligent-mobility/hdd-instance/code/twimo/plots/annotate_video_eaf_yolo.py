#!/usr/bin/env python
"""Annotate driving video with EAF two-stage predictions + YOLOv8 object detection.

Extends annotate_video_eaf.py with:
  • Bounding boxes drawn on the video frame for every detected object
  • Each bbox is coloured and labelled according to the Cause/Attention taxonomy
  • Supports both the original sensor-only model (stage1.pt/stage2.pt with input_dim=8)
    and the new sensor+detection model (from two_stage_yolo.py, input_dim=21)

Usage
-----
python twimo/plots/annotate_video_eaf_yolo.py \\
    --manifest ./artifacts/manifest.jsonl \\
    --stage1-model ./artifacts/eaf/two_stage_yolo/stage1.pt \\
    --stage2-model ./artifacts/eaf/two_stage_yolo/stage2.pt \\
    --data-dir     ./artifacts/eaf/two_stage_yolo \\
    --vocab-dir    ./artifacts/eaf/vocabs \\
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
    --det-cache-dir ./artifacts/eaf/det_cache \\
    --eaf-parsed-dir ./artifacts/eaf/parsed \\
    --outdir ./artifacts/annotated_eaf_yolo \\
    --session 201702271017 \\
    --max-seconds 120

You can also point at the original sensor-only model (input_dim=8) and omit
--det-cache-dir – detection features will default to zeros so predictions work
but bbox overlays still appear (they run a live YOLO pass on each frame).
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

# ── Import everything from the existing EAF annotation script ─────────────────
from twimo.plots.annotate_video_eaf import (
    TwoStageConfig,
    _EventTransformer,
    _ClassificationTransformer,
    _load_models,
    _predict_all,
    _load_vocab,
    _map_raw,
    _load_eaf_tiers,
    _at,
    _load_rtk_pos,
    _video_info,
    _draw_panel,
    _eaf_map,
    _explain,
    _short,
    _GOAL_C, _STIM_C, _CAUSE_C, _DEF_C,
    _EVT_DOT, _NOEVT_DOT,
)

# ── Detection feature builder (mirrors two_stage_yolo.py, kept self-contained) ─
from twimo.strategies_eaf.two_stage_yolo import (
    D as DET_DIM,
    YoloStageConfig,
    _EventNet,
    _ClassifyNet,
    _classify_tl_color,
    _extract_det_features,
    _compute_sensor_video_offset,
    COCO_TRAFFIC_LIGHT, COCO_STOP_SIGN,
    COCO_PERSON, COCO_BICYCLE, COCO_MOTORCYCLE,
    COCO_CAR, COCO_BUS, COCO_TRUCK,
    VEHICLE_IDS, HEAVY_IDS,
)


def _load_yolo_models(stage1_pt: Path, stage2_pt: Path):
    """Load Stage1+Stage2 trained by two_stage_yolo.py (input_dim=21)."""
    model_dir = stage1_pt.parent
    with open(model_dir / "config.json", encoding="utf-8") as f:
        cfg_dict = json.load(f)
    cfg = YoloStageConfig(**{k: v for k, v in cfg_dict.items()
                             if k in YoloStageConfig.__dataclass_fields__})
    cfg.device = "cpu"

    mean = np.load(model_dir / "norm_mean.npy").astype(np.float32)
    std  = np.load(model_dir / "norm_std.npy").astype(np.float32)
    std[std < 1e-8] = 1.0

    ck1 = torch.load(stage1_pt, map_location="cpu", weights_only=False)
    s1  = _EventNet(cfg)
    s1.load_state_dict(ck1["model_state"])
    s1.eval()

    ck2 = torch.load(stage2_pt, map_location="cpu", weights_only=False)
    ck2_keys = set(ck2["model_state"].keys())
    is_4head = "cause_head.weight" in ck2_keys
    # Build with full arch (safe: cfg already has n_cause_classes default)
    s2 = _ClassifyNet(cfg)
    s2.load_state_dict(ck2["model_state"], strict=is_4head)
    s2.eval()
    # Zero out so _has_4heads → False for old 2-head checkpoints
    if not is_4head:
        cfg.n_cause_classes = 0
        cfg.n_attention_classes = 0

    return s1, s2, cfg, mean, std


# ──────────────────────────────────────────────────────────────────────────────
# Batch prediction for 4-head YOLO model
# ──────────────────────────────────────────────────────────────────────────────

def _predict_all_yolo(X, mean, std, s1, s2, cfg, bs: int = 64):
    """Pre-compute (ev, goal, stim, cause, attn) for every stride-1 window.

    Returns 9 arrays: ev_p, g_p, g_pr, s_p, s_pr, c_p, c_pr, a_p, a_pr
    """
    T, D = X.shape
    wl   = cfg.window_len
    N    = max(0, T - wl + 1)

    ev_p = np.zeros(N, dtype=np.int64)
    g_p  = np.zeros(N, dtype=np.int64);  g_pr = np.zeros(N, dtype=np.float32)
    s_p  = np.zeros(N, dtype=np.int64);  s_pr = np.zeros(N, dtype=np.float32)
    c_p  = np.zeros(N, dtype=np.int64);  c_pr = np.zeros(N, dtype=np.float32)
    a_p  = np.zeros(N, dtype=np.int64);  a_pr = np.zeros(N, dtype=np.float32)

    if N == 0:
        return ev_p, g_p, g_pr, s_p, s_pr, c_p, c_pr, a_p, a_pr

    Xn = (X - mean) / std

    with torch.no_grad():
        for st in range(0, N, bs):
            en  = min(st + bs, N)
            bx  = torch.from_numpy(np.stack([Xn[k: k + wl] for k in range(st, en)]))
            ev_p[st:en] = s1(bx).argmax(1).numpy()

        ev_idx = np.where(ev_p == 1)[0]
        for i in range(0, len(ev_idx), bs):
            chunk = ev_idx[i: i + bs]
            bx    = torch.from_numpy(np.stack([Xn[k: k + wl] for k in chunk]))
            gl, sl, cl, al = s2(bx)
            gpr = torch.softmax(gl, 1); spr = torch.softmax(sl, 1)
            cpr = torch.softmax(cl, 1); apr = torch.softmax(al, 1)
            g_p[chunk] = gpr.argmax(1).numpy(); g_pr[chunk] = gpr.max(1).values.numpy()
            s_p[chunk] = spr.argmax(1).numpy(); s_pr[chunk] = spr.max(1).values.numpy()
            c_p[chunk] = cpr.argmax(1).numpy(); c_pr[chunk] = cpr.max(1).values.numpy()
            a_p[chunk] = apr.argmax(1).numpy(); a_pr[chunk] = apr.max(1).values.numpy()

    return ev_p, g_p, g_pr, s_p, s_pr, c_p, c_pr, a_p, a_pr


# ──────────────────────────────────────────────────────────────────────────────
# Extended drawing panel (adds Cause + Attention prediction columns)
# ──────────────────────────────────────────────────────────────────────────────

def _draw_panel_yolo(
    frame:        np.ndarray,
    gt_cause:     str, gt_attention: str,
    gt_goal:      str, gt_stimuli:   str,
    # 10-tuple: (h_s, is_ev, goal, stim, g_pr, s_pr, cause, c_pr, attn, a_pr)
    horizon_rows: List[Tuple],
    explanation:  str,
    speed_kmh:    float, steer_deg: float,
    brake_kpa:    float, accel_pct: float, yaw: float,
    rtk_lng:      Optional[float] = None,
    rtk_lat:      Optional[float] = None,
) -> np.ndarray:
    """Like _draw_panel but with two extra prediction columns: Cause and Attention."""
    out  = frame.copy()
    fh, fw = out.shape[:2]
    aa   = cv2.LINE_AA
    font = cv2.FONT_HERSHEY_SIMPLEX

    # GPS overlay
    if rtk_lng is not None and rtk_lat is not None:
        gps_sc = max(0.58, min(0.78, fw / 1920.0 * 0.80))
        for gi, gl in enumerate([f"Lng {rtk_lng:.6f}", f"Lat {rtk_lat:.6f}"]):
            tw = cv2.getTextSize(gl, font, gps_sc, 1)[0][0]
            gx = fw - tw - 12; gy = 24 + gi * 22
            cv2.putText(out, gl, (gx + 1, gy + 1), font, gps_sc, (0, 0, 0),       2, aa)
            cv2.putText(out, gl, (gx,     gy),     font, gps_sc, (160, 230, 160), 1, aa)

    panel_h   = min(290, fh // 3 + 30)
    panel_top = fh - panel_h
    ov = out.copy()
    cv2.rectangle(ov, (0, panel_top), (fw, fh), (10, 10, 14), -1)
    cv2.addWeighted(ov, 0.72, out, 0.28, 0, out)
    cv2.line(out, (0, panel_top), (fw, panel_top), (60, 60, 70), 1)

    scm = max(0.52, min(0.72, fw / 1920.0 * 0.72))
    scs = max(0.46, scm - 0.06)
    sct = max(0.40, scm - 0.12)
    pct_sc = max(0.30, sct - 0.10)

    # Column widths: left 18% | middle 58% | right 24%
    left_w = fw * 18 // 100
    mid_w  = fw * 58 // 100

    c0 = 8; c1 = left_w + 8; c2 = left_w + mid_w + 8
    y0 = panel_top + 22

    cv2.line(out, (left_w,         panel_top), (left_w,         fh), (55, 55, 65), 1)
    cv2.line(out, (left_w + mid_w, panel_top), (left_w + mid_w, fh), (55, 55, 65), 1)

    # LEFT: GT labels
    cv2.putText(out, "EAF LABELS", (c0, y0), font, scm, (170, 210, 210), 1, aa)
    for i, (lbl, val, cdict) in enumerate([
        ("Cause",   gt_cause,     _CAUSE_C),
        ("Attn",    gt_attention, _CAUSE_C),
        ("Goal",    gt_goal,      _GOAL_C),
        ("Stimuli", gt_stimuli,   _STIM_C),
    ]):
        y   = y0 + 26 + i * 24
        col = cdict.get(val, _DEF_C)
        cv2.putText(out, f"{lbl}:", (c0,      y), font, sct, (150, 150, 150), 1, aa)
        cv2.putText(out, _short(val, 14), (c0 + 56, y), font, sct, col,       1, aa)

    # MIDDLE: Predictions  (compact 6-sub-column layout)
    # h(8%) | dot(9%) | goal_txt(17%) | goal_bar(8%) | stim_txt(16%) | stim_bar(7%)
    # | cause_txt(15%) | attn_txt(rest)
    cv2.putText(out, "PREDICTIONS", (c1, y0), font, scm, (200, 200, 140), 1, aa)

    bw = mid_w * 7 // 100   # bar width
    hx_h   = c1
    hx_dot = c1 + mid_w *  8 // 100
    hx_g   = c1 + mid_w * 17 // 100
    hx_gb  = c1 + mid_w * 34 // 100
    hx_s   = c1 + mid_w * 44 // 100
    hx_sb  = c1 + mid_w * 60 // 100
    hx_c   = c1 + mid_w * 69 // 100
    hx_a   = c1 + mid_w * 84 // 100

    y_hdr = y0 + 16
    for x, lbl in [(hx_h, "h"), (hx_dot, "Evt"), (hx_g, "Goal"),
                   (hx_s, "Stimuli"), (hx_c, "Cause"), (hx_a, "Attn")]:
        cv2.putText(out, lbl, (x, y_hdr), font, sct, (140, 140, 140), 1, aa)

    expl_src = ""
    for ri, row in enumerate(horizon_rows):
        h_s, is_ev, goal_s, stim_s, g_prob, s_prob = row[:6]
        cause_s = row[6] if len(row) > 6 else "unknown"
        c_prob  = float(row[7]) if len(row) > 7 else 0.0
        attn_s  = row[8] if len(row) > 8 else "unknown"
        a_prob  = float(row[9]) if len(row) > 9 else 0.0

        yr = y0 + 46 + ri * 28

        cv2.putText(out, f"{h_s:.0f}s", (hx_h, yr), font, scs, (200, 200, 200), 1, aa)
        dot_c = _EVT_DOT if is_ev else _NOEVT_DOT
        cv2.circle(out, (hx_dot + 10, yr - 8), 7, dot_c, -1, aa)

        if is_ev:
            # Goal
            gc = _GOAL_C.get(goal_s, _DEF_C)
            cv2.putText(out, _short(goal_s, 10), (hx_g, yr), font, sct, gc, 1, aa)
            cv2.rectangle(out, (hx_gb, yr - 12), (hx_gb + bw, yr + 1), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_gb, yr - 12),
                          (hx_gb + int(bw * max(0.0, min(1.0, g_prob))), yr + 1), gc, -1)
            cv2.putText(out, f"{g_prob*100:.0f}%", (hx_gb + bw + 3, yr),
                        font, pct_sc, gc, 1, aa)
            # Stimuli
            sc2 = _STIM_C.get(stim_s, _DEF_C)
            cv2.putText(out, _short(stim_s, 10), (hx_s, yr), font, sct, sc2, 1, aa)
            cv2.rectangle(out, (hx_sb, yr - 12), (hx_sb + bw, yr + 1), (45, 45, 45), -1)
            cv2.rectangle(out, (hx_sb, yr - 12),
                          (hx_sb + int(bw * max(0.0, min(1.0, s_prob))), yr + 1), sc2, -1)
            cv2.putText(out, f"{s_prob*100:.0f}%", (hx_sb + bw + 3, yr),
                        font, pct_sc, sc2, 1, aa)
            # Cause
            cc = _CAUSE_C.get(cause_s, _DEF_C)
            cv2.putText(out, _short(cause_s, 10), (hx_c, yr), font, sct, cc, 1, aa)
            cv2.putText(out, f"{c_prob*100:.0f}%", (hx_c, yr + 14),
                        font, pct_sc, cc, 1, aa)
            # Attention
            ac = _CAUSE_C.get(attn_s, _DEF_C)
            cv2.putText(out, _short(attn_s, 10), (hx_a, yr), font, sct, ac, 1, aa)
            cv2.putText(out, f"{a_prob*100:.0f}%", (hx_a, yr + 14),
                        font, pct_sc, ac, 1, aa)

            if not expl_src:
                expl_src = explanation
        else:
            for x in (hx_g, hx_s, hx_c, hx_a):
                cv2.putText(out, "-", (x, yr), font, sct, (90, 90, 90), 1, aa)

    # Explanation
    if expl_src:
        y_ex  = y0 + 46 + len(horizon_rows) * 28 + 8
        limit = max(20, mid_w // max(1, int(sct * 12)))
        words = expl_src.split(); lines: List[str] = []; ln = ""
        for w in words:
            if len(ln) + len(w) + 1 <= limit:
                ln = (ln + " " + w).strip()
            else:
                if ln: lines.append(ln)
                ln = w
        if ln: lines.append(ln)
        for j, l in enumerate(lines[:2]):
            yj = y_ex + j * 18
            if yj >= fh - 8: break
            cv2.putText(out, l, (c1, yj), font, max(0.34, sct - 0.04),
                        (190, 190, 190), 1, aa)

    # RIGHT: Sensors
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
# COCO class → Cause/Attention label + display colour
# ──────────────────────────────────────────────────────────────────────────────

# For each COCO class id that we monitor, define:
#   display_label : human-readable string shown on the bbox
#   cause_key     : key into _CAUSE_C for colour
COCO_OVERLAY: Dict[int, Dict] = {
    COCO_TRAFFIC_LIGHT: {"label": "Traffic Light",   "cause_key": "red_light"},
    COCO_STOP_SIGN:     {"label": "Stop Sign",        "cause_key": "sign"},
    COCO_PERSON:        {"label": "Pedestrian",       "cause_key": "crossing_pedestrian"},
    COCO_BICYCLE:       {"label": "Cyclist",          "cause_key": "on-road_bicyclist"},
    COCO_MOTORCYCLE:    {"label": "Motorcyclist",     "cause_key": "on-road_motorcyclist"},
    COCO_CAR:           {"label": "Vehicle",          "cause_key": "crossing_vehicle"},
    COCO_BUS:           {"label": "Bus",              "cause_key": "crossing_vehicle"},
    COCO_TRUCK:         {"label": "Truck",            "cause_key": "crossing_vehicle"},
}

# Traffic-light-specific colour override per detected colour
TL_COLOR_CAUSE = {
    "red":     "red_light",
    "yellow":  "yellow_light",
    "green":   "crossing_vehicle",  # nearest neutral key that has a colour
    "unknown": "red_light",
}


# ──────────────────────────────────────────────────────────────────────────────
# YOLOv8 wrapper
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

    def infer(self, frame_bgr: np.ndarray):
        """Run inference and return (result, det_feat D-vector)."""
        results = self.model(frame_bgr, verbose=False, conf=self.conf)
        r       = results[0] if results else None
        feat    = _extract_det_features(r, frame_bgr) if r is not None \
                  else np.zeros(DET_DIM, dtype=np.float32)
        return r, feat


# ──────────────────────────────────────────────────────────────────────────────
# Bbox drawing
# ──────────────────────────────────────────────────────────────────────────────

def _draw_detections(frame: np.ndarray, result, conf_thr: float = 0.30) -> np.ndarray:
    """Draw bounding boxes coloured by Cause/Attention taxonomy on the frame."""
    if result is None or result.boxes is None or len(result.boxes) == 0:
        return frame

    out  = frame  # in-place on the already-copied frame
    aa   = cv2.LINE_AA
    font = cv2.FONT_HERSHEY_SIMPLEX
    fh, fw = out.shape[:2]
    sc   = max(0.35, min(0.55, fw / 1920.0 * 0.55))

    for box in result.boxes:
        cls_id = int(box.cls[0])
        conf   = float(box.conf[0])
        if conf < conf_thr:
            continue
        if cls_id not in COCO_OVERLAY:
            continue

        x1, y1, x2, y2 = map(int, box.xyxy[0].tolist())

        info      = COCO_OVERLAY[cls_id]
        cause_key = info["cause_key"]
        disp_lbl  = info["label"]

        # Refine traffic-light colour
        if cls_id == COCO_TRAFFIC_LIGHT:
            tl_col    = _classify_tl_color(frame, (x1, y1, x2, y2))
            cause_key = TL_COLOR_CAUSE.get(tl_col, cause_key)
            disp_lbl  = f"TL {tl_col.capitalize()}"

        bgr = _CAUSE_C.get(cause_key, _DEF_C)

        # Bounding box
        cv2.rectangle(out, (x1, y1), (x2, y2), bgr, 2, aa)

        # Label background + text
        label_txt = f"{disp_lbl} {conf:.0%}"
        (tw, th), _ = cv2.getTextSize(label_txt, font, sc, 1)
        lx = x1
        ly = max(th + 4, y1 - 4)
        cv2.rectangle(out, (lx, ly - th - 4), (lx + tw + 4, ly + 2), bgr, -1)
        cv2.putText(out, label_txt, (lx + 2, ly - 1),
                    font, sc, (10, 10, 10), 1, aa)

    return out


# ──────────────────────────────────────────────────────────────────────────────
# Core annotation loop
# ──────────────────────────────────────────────────────────────────────────────

def annotate_session_eaf_yolo(
    session_id:    str,
    video_path:    Path,
    prealigned:    Optional[Path],
    csv_dir:       Optional[Path],
    det_cache:     Optional[Path],          # precomputed (T, D) detection cache
    yolo:          Optional[YoloDetector],  # live YOLO (used if no cache)
    s1:            _EventTransformer,
    s2:            _ClassificationTransformer,
    cfg:           TwoStageConfig,
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
    yolo_conf:     float = 0.30,
    max_seconds:   Optional[float] = None,
) -> None:

    from twimo.data.csv_session import load_sensors_from_csv_dir, resample_sensors

    print(f"\n[annotate_eaf_yolo] {session_id}")

    # ── 1. Sensor loading ─────────────────────────────────────────────────────
    X: Optional[np.ndarray]       = None
    t_sensor: Optional[np.ndarray]= None
    X_csv: Optional[np.ndarray]   = None
    csv_names: List[str]          = []

    t_sensor_csv: Optional[np.ndarray] = None
    if csv_dir is not None and csv_dir.exists():
        try:
            fr                       = load_sensors_from_csv_dir(csv_dir)
            t_sensor_csv, X_csv, csv_names = resample_sensors(fr, sample_hz=sample_hz)
        except Exception:
            X_csv = None

    # t_csv_offset_s: offset used for the CSV sensor display lookup.
    # This is always the motion-calibrated video-to-sensor offset (seconds from
    # sensor start to video start), so that displayed values match what the driver
    # is actually doing at each video frame.
    t_csv_offset_s: float = 0.0

    if prealigned is not None and prealigned.exists():
        Xp       = np.load(prealigned).astype(np.float32)
        t_sensor = np.arange(Xp.shape[0], dtype=np.float32) / float(sample_hz)
        X        = Xp
        # Prealigned arrays are already time-aligned to video/EAF: no offset needed
        # for model prediction.
        t_offset_s = 0.0
        print("  Prealigned: %s @ %g Hz" % (X.shape, sample_hz))
        # For the sensor readout panel (CSV display), still compute the real offset
        # so that X_csv is indexed correctly.  Without this, i_s = t_fr * hz would
        # map video frame time directly to sensor-start time, causing ~10 s display lag.
        if X_csv is not None:
            t_csv_offset_s = _compute_sensor_video_offset(session_id, csv_dir, video_path)
            if t_csv_offset_s != 0.0:
                print("  CSV display offset: %.3fs" % t_csv_offset_s)
    elif X_csv is not None:
        t_sensor = t_sensor_csv
        X        = X_csv
        # CSV sensors: compute offset between sensor power-on and video start.
        # Uses video filename (second-precision) when available, falls back to sid.
        t_offset_s = _compute_sensor_video_offset(session_id, csv_dir, video_path)
        t_csv_offset_s = t_offset_s
        if t_offset_s != 0.0:
            sign_desc = "sensor after video" if t_offset_s < 0 else "sensor before video"
            print("  Sensor-video offset: %.3fs  (%s)" % (t_offset_s, sign_desc))
        else:
            print("  Sensor-video offset: 0.0s (could not compute)")
    else:
        print("  WARNING: no sensor data – skip"); return

    if X is None or X.shape[0] == 0:
        return

    T = X.shape[0]
    t_rel        = t_sensor - t_sensor[0]
    sensor_dur_s = float(t_rel[-1])

    # Precompute CSV relative timeline for display lookups (used inside frame loop).
    t_rel_csv: Optional[np.ndarray] = None
    if X_csv is not None and t_sensor_csv is not None:
        t_rel_csv = t_sensor_csv - t_sensor_csv[0]

    # ── 2. Detection features ─────────────────────────────────────────────────
    X_det: Optional[np.ndarray] = None
    if det_cache is not None and det_cache.exists():
        X_det = np.load(det_cache).astype(np.float32)
        if X_det.shape[0] != T:
            X_det = np.resize(X_det, (T, DET_DIM))
        print(f"  Detection cache loaded: {X_det.shape}")
    elif yolo is None:
        X_det = np.zeros((T, DET_DIM), dtype=np.float32)
        print("  No detection cache and no live YOLO – det features = 0")

    # If input_dim of the model > 8, model expects sensor + detection features.
    # When X_det is None (live YOLO active but no cache), pad with zeros so
    # predictions still work; bboxes are still drawn from the live YOLO pass.
    model_input_dim = cfg.input_dim if hasattr(cfg, "input_dim") else 8
    if model_input_dim > 8:
        if X_det is None:
            X_det = np.zeros((T, DET_DIM), dtype=np.float32)
            print("  Live YOLO mode: det features for prediction = 0 (bbox overlay still active)")
        X_full = np.concatenate([X, X_det], axis=1)
    else:
        X_full = X  # sensor-only model (old _ClassificationTransformer)

    # ── 3. RTK position ───────────────────────────────────────────────────────
    rtk_lngs, rtk_lats = _load_rtk_pos(csv_dir, t_rel)

    # ── 4. Batch predictions ──────────────────────────────────────────────────
    print("  Running two-stage prediction …")
    # YOLO models (_ClassifyNet) always return 4 tensors from Stage 2.
    # Use _predict_all_yolo for all YOLO models (input_dim > 8).
    # For old sensor-only models (_ClassificationTransformer, input_dim=8), use _predict_all.
    # _has_4heads controls panel display only (whether to show cause/attn columns).
    _has_4heads = getattr(cfg, "n_cause_classes", 0) > 0
    if model_input_dim > 8:
        ev_p, g_p, g_pr, s_p, s_pr, c_p, c_pr, a_p, a_pr = \
            _predict_all_yolo(X_full, mean, std, s1, s2, cfg)
    else:
        ev_p, g_p, g_pr, s_p, s_pr = _predict_all(X_full, mean, std, s1, s2, cfg)
        c_p = a_p = np.zeros(len(ev_p), dtype=np.int64)
        c_pr = a_pr = np.zeros(len(ev_p), dtype=np.float32)
    N  = len(ev_p)
    wl = cfg.window_len
    print(f"  Windows={N}  Events={int(ev_p.sum())} ({100*ev_p.mean():.1f}%)")

    # ── 5. Video setup ────────────────────────────────────────────────────────
    fps, vw, vh = _video_info(video_path)
    out_path    = outdir / f"annotated_eaf_yolo_{session_id}.mp4"
    outdir.mkdir(parents=True, exist_ok=True)
    max_f = int(max_seconds * fps) if max_seconds else None

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

    decoder = subprocess.Popen(dec_cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    encoder = subprocess.Popen(enc_cmd, stdin=subprocess.PIPE,  stderr=subprocess.PIPE)

    fb              = vw * vh * 3
    fi              = 0
    hz_offsets      = [int(round(h * sample_hz)) for h in horizons_s]
    last_yolo_result = None

    print("  Annotating -> %s" % out_path)

    try:
        while True:
            raw = decoder.stdout.read(fb)
            if not raw or len(raw) < fb:
                break

            t_fr  = fi / fps
            # Map video frame time → sensor step accounting for recording offset.
            # Video frame at t_fr corresponds to absolute time video_start + t_fr,
            # which is sensor_start + t_offset_s + t_fr → t_rel = t_offset_s + t_fr.
            i_s   = int(np.argmin(np.abs(t_rel - (t_fr + t_offset_s))))
            frame = np.frombuffer(raw, np.uint8).reshape(vh, vw, 3).copy()

            # ── YOLO detection overlay ────────────────────────────────────────
            live_feat = None
            if yolo is not None:
                # Run live inference every N frames (sample_hz cadence)
                if fi % max(1, int(fps / sample_hz)) == 0:
                    last_yolo_result, live_feat = yolo.infer(frame)
                # Redraw last result on every frame so bboxes persist between samples
                if last_yolo_result is not None:
                    frame = _draw_detections(frame, last_yolo_result, yolo_conf)

            # ── EAF ground-truth labels ───────────────────────────────────────
            t_ms     = t_fr * 1000.0
            gt_cause = _at(cause_anns, t_ms, cause_lmap, cause_vocab)
            gt_attn  = _at(att_anns,  t_ms, att_lmap,   att_vocab)
            gt_goal  = _at(goal_gt_anns, t_ms, goal_lmap, goal_vocab)
            gt_stim  = _at(stim_gt_anns, t_ms, stim_lmap, stim_vocab)

            # ── Multi-horizon predictions ─────────────────────────────────────
            horizon_rows: List[Tuple] = []
            expl = ""
            for h_s, off in zip(horizons_s, hz_offsets):
                future_is = i_s + off
                pred_k    = future_is - wl + 1
                if 0 <= pred_k < N:
                    is_ev   = bool(ev_p[pred_k])
                    goal_s  = goal_labels[int(g_p[pred_k])] \
                              if is_ev and int(g_p[pred_k]) < len(goal_labels) else "unknown"
                    stim_s  = stim_labels[int(s_p[pred_k])] \
                              if is_ev and int(s_p[pred_k]) < len(stim_labels) else "unknown"
                    cause_s = cause_labels[int(c_p[pred_k])] \
                              if is_ev and int(c_p[pred_k]) < len(cause_labels) else "unknown"
                    attn_s  = att_labels[int(a_p[pred_k])] \
                              if is_ev and int(a_p[pred_k]) < len(att_labels) else "unknown"
                    gpr     = float(g_pr[pred_k]) if is_ev else 0.0
                    spr     = float(s_pr[pred_k]) if is_ev else 0.0
                    cpr     = float(c_pr[pred_k]) if is_ev else 0.0
                    apr     = float(a_pr[pred_k]) if is_ev else 0.0
                else:
                    is_ev   = False
                    goal_s  = stim_s = cause_s = attn_s = "unknown"
                    gpr     = spr = cpr = apr = 0.0

                if is_ev and not expl:
                    expl = _explain(goal_s, stim_s, gt_cause, gt_attn)

                horizon_rows.append(
                    (h_s, is_ev, goal_s, stim_s, gpr, spr, cause_s, cpr, attn_s, apr)
                )

            # ── Sensor readout ────────────────────────────────────────────────
            speed = steer = brake = accel = yaw = 0.0
            if X_csv is not None and t_rel_csv is not None:
                # Use t_rel_csv + t_csv_offset_s so the display is always
                # aligned to the video frame regardless of whether prealigned
                # data is used for model prediction.
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

            rtk_lng = float(rtk_lngs[min(i_s, len(rtk_lngs) - 1)]) \
                      if rtk_lngs is not None else None
            rtk_lat = float(rtk_lats[min(i_s, len(rtk_lats) - 1)]) \
                      if rtk_lats is not None else None

            # ── Draw panel ────────────────────────────────────────────────────
            annotated = _draw_panel_yolo(
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
                print(f"    … {t_fr:.0f}s | {pct:.0f}% | i_s={i_s}/{T-1}")

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
        description="Annotate video with EAF predictions + YOLOv8 bbox overlay.")
    pa.add_argument("--manifest",               required=True,  type=Path)
    pa.add_argument("--stage1-model",           required=True,  type=Path)
    pa.add_argument("--stage2-model",           required=True,  type=Path)
    pa.add_argument("--data-dir",               required=True,  type=Path,
                    help="Dir with config.json + norm_mean/std.npy")
    pa.add_argument("--vocab-dir",              required=True,  type=Path)
    pa.add_argument("--prealigned-sensors-dir", default=None,   type=Path)
    pa.add_argument("--det-cache-dir",          default=None,   type=Path,
                    help="Dir with {session}_det.npy from two_stage_yolo.py extract")
    pa.add_argument("--eaf-parsed-dir",         default=None,   type=Path)
    pa.add_argument("--outdir",                 required=True,  type=Path)
    pa.add_argument("--session",                default=None,   type=str)
    pa.add_argument("--sample-hz",              default=3.0,    type=float)
    pa.add_argument("--horizons",               default=[1.0, 3.0, 5.0],
                    type=float, nargs="+")
    pa.add_argument("--max-seconds",            default=None,   type=float)
    pa.add_argument("--yolo-model",             default=None,   type=str,
                    help="YOLOv8 model name for live detection overlay "
                         "(e.g. yolov8n.pt). If omitted, only cached det used.")
    pa.add_argument("--yolo-conf",              default=0.30,   type=float,
                    help="YOLO detection confidence threshold for bbox display")
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

    # ── Load EAF models ───────────────────────────────────────────────────────
    print("\nLoading EAF two-stage models …")
    # Auto-detect model type: YOLO config has 'det_dim', original EAF config does not
    _cfg_path = args.stage1_model.parent / "config.json"
    with open(_cfg_path, encoding="utf-8") as _f:
        _cfg_probe = json.load(_f)
    if "det_dim" in _cfg_probe:
        s1, s2, cfg, mean, std = _load_yolo_models(args.stage1_model, args.stage2_model)
        print("  Detected YOLO model (input_dim=21)")
    else:
        s1, s2, cfg, mean, std = _load_models(args.stage1_model, args.stage2_model,
                                              args.stage1_model.parent)
        print("  Detected sensor-only model (input_dim=8)")
    print(f"  input_dim={cfg.input_dim}  window={cfg.window_len} steps")

    # ── Vocabularies ──────────────────────────────────────────────────────────
    goal_labels,  goal_lmap,  goal_vocab  = _load_vocab(args.vocab_dir / "vocab_goal.json")
    stim_labels,  stim_lmap,  stim_vocab  = _load_vocab(args.vocab_dir / "vocab_stimuli.json")
    cause_labels, cause_lmap, cause_vocab = _load_vocab(args.vocab_dir / "vocab_cause.json")
    att_labels,   att_lmap,   att_vocab   = _load_vocab(args.vocab_dir / "vocab_attention.json")

    # ── EAF parsed map ────────────────────────────────────────────────────────
    em = _eaf_map(args.eaf_parsed_dir)
    print(f"  EAF JSONs: {len(em)}" if em else
          "  EAF parsed dir not given – GT labels will show 'unknown'")

    # ── Optional live YOLO ────────────────────────────────────────────────────
    yolo: Optional[YoloDetector] = None
    if args.yolo_model:
        yolo = YoloDetector(model_name=args.yolo_model, conf=args.yolo_conf)

    args.outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="annotate_video_eaf_yolo", output_dir=args.outdir, use_codecarbon=True)
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

        det_cache: Optional[Path] = None
        if args.det_cache_dir:
            dc = Path(args.det_cache_dir) / f"{sid}_det.npy"
            if dc.exists():
                det_cache = dc

        # EAF GT tiers
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
            annotate_session_eaf_yolo(
                session_id   = sid,
                video_path   = vp,
                prealigned   = pre,
                csv_dir      = csv_dir,
                det_cache    = det_cache,
                yolo         = yolo,
                s1=s1, s2=s2, cfg=cfg, mean=mean, std=std,
                goal_labels  = goal_labels,
                stim_labels  = stim_labels,
                cause_labels = cause_labels,
                att_labels   = att_labels,
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
                yolo_conf    = args.yolo_conf,
                max_seconds  = args.max_seconds,
            )
        except Exception as e:
            print(f"[ERROR] {sid}: {e}", file=sys.stderr)
            import traceback; traceback.print_exc()

    _profiler.__exit__(None, None, None)
    print("\nAll done.")


if __name__ == "__main__":
    main()
