#!/usr/bin/env python
"""Annotate driving video(s) with maneuver predictions and rule-based explanations.

For each video frame the script overlays:
  - Predicted next action at three horizons (default: 1 s, 3 s, 5 s)
    with a colour-coded probability bar
  - Rule-based explanation (WHY panel)
  - Live sensor readout (speed, steer, brake)

The annotation reads the sensor CSV files at runtime, resamples them to the model
frequency, and runs the trained model on the full session – so no pre-computed
prediction file is needed.

Requirements: ffmpeg on PATH, OpenCV (cv2), numpy, the trained model artefacts.

Usage examples
--------------
# Single session by session_id
python twimo/plots/annotate_video.py \\
    --manifest ./artifacts/manifest.jsonl \\
    --modeldir ./artifacts/maneuver_proxy/maneuver_transformer \\
    --outdir  ./artifacts/annotated_videos \\
    --session 201702271017

# All sessions that have a video
python twimo/plots/annotate_video.py \\
    --manifest ./artifacts/manifest.jsonl \\
    --modeldir ./artifacts/maneuver_proxy/maneuver_transformer \\
    --outdir  ./artifacts/annotated_videos

# Limit to the first N seconds of each video (useful for quick tests)
python twimo/plots/annotate_video.py \\
    --manifest ./artifacts/manifest.jsonl \\
    --modeldir ./artifacts/maneuver_proxy/maneuver_transformer \\
    --outdir  ./artifacts/annotated_videos \\
    --session 201702271017 \\
    --max-seconds 60
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

from twimo.utils.profiling import TrainingProfiler


# ──────────────────────────────────────────────────────────────────────────────
# Colour palette per class  (BGR for OpenCV)
# ──────────────────────────────────────────────────────────────────────────────
CLASS_COLORS_BGR: Dict[str, Tuple[int, int, int]] = {
    "STRAIGHT":   (160, 160, 160),
    "TURN_LEFT":  (220,  80,  20),   # orange-ish
    "TURN_RIGHT": ( 20, 120, 220),   # blue-ish
    "BRAKE":      ( 30,  30, 220),   # red
    "ACCEL":      ( 30, 180,  30),   # green
    "STOP":       (180,  30, 180),   # purple
}
DEFAULT_COLOR_BGR = (200, 200, 200)
DEFAULT_LABELS    = ["STRAIGHT", "TURN_LEFT", "TURN_RIGHT", "BRAKE", "ACCEL", "STOP"]


# ──────────────────────────────────────────────────────────────────────────────
# ffprobe helper – get native FPS and frame size
# ──────────────────────────────────────────────────────────────────────────────

def _video_info(video_path: Path) -> Tuple[float, int, int]:
    """Return (fps, width, height) via ffprobe."""
    cmd = [
        "ffprobe", "-v", "quiet",
        "-print_format", "json",
        "-show_streams",
        str(video_path),
    ]
    out = subprocess.check_output(cmd, stderr=subprocess.DEVNULL)
    data = json.loads(out)
    for s in data.get("streams", []):
        if s.get("codec_type") == "video":
            r_num, r_den = s["r_frame_rate"].split("/")
            fps = float(r_num) / float(r_den)
            return fps, int(s["width"]), int(s["height"])
    raise RuntimeError(f"No video stream found in {video_path}")


# ──────────────────────────────────────────────────────────────────────────────
# Model loading helpers
# ──────────────────────────────────────────────────────────────────────────────

def _load_model_and_config(modeldir: Path):
    """Load checkpoint, config, feature names, label map from modeldir."""
    kind = (modeldir / "model_kind.txt").read_text(encoding="utf-8").strip()
    cfg_dict = json.loads((modeldir / "config.json").read_text(encoding="utf-8"))
    feat_names = json.loads((modeldir / "feature_names.json").read_text(encoding="utf-8"))
    label_map  = json.loads((modeldir / "label_map.json").read_text(encoding="utf-8"))

    from twimo.models.maneuver_transformer import ManeuverConfig
    cfg = ManeuverConfig(**{k: v for k, v in cfg_dict.items() if k in ManeuverConfig.__dataclass_fields__})

    if kind == "transformer":
        import torch
        ckpt = torch.load(modeldir / "maneuver_transformer.pt", map_location="cpu", weights_only=False)
    elif kind in ("gru", "lstm"):
        import torch
        pt_file = modeldir / f"{kind}.pt"
        ckpt = torch.load(pt_file, map_location="cpu", weights_only=False)
    elif kind == "tcn":
        import torch
        ckpt = torch.load(modeldir / "tcn.pt", map_location="cpu", weights_only=False)
    elif kind.startswith("mlp_"):
        import torch
        ckpt = torch.load(modeldir / f"{kind}.pt", map_location="cpu", weights_only=False)
    elif kind == "xgboost":
        import joblib
        ckpt = joblib.load(modeldir / "xgboost.joblib")
    elif kind == "lightgbm":
        import joblib
        ckpt = joblib.load(modeldir / "lightgbm.joblib")
    elif kind == "random_forest":
        import joblib
        ckpt = joblib.load(modeldir / "random_forest.joblib")
    elif kind == "baseline":
        import joblib
        ckpt = joblib.load(modeldir / "baseline.joblib")
    else:
        raise ValueError(f"Unknown model kind: {kind}")

    return kind, cfg, ckpt, feat_names, label_map


def _predict_session(kind: str, ckpt, X: np.ndarray, cfg) -> Dict[int, np.ndarray]:
    """Run model prediction on the full session, return probs_by_steps."""
    from twimo.models.maneuver_transformer import (
        predict_transformer_multihead,
    )
    from twimo.models.gru_lstm_model    import predict_gru_lstm_multihead
    from twimo.models.tcn_model         import predict_tcn_multihead
    from twimo.models.mlp_pooling_model import predict_mlp_pooling_multihead
    from twimo.models.xgboost_model     import predict_xgboost_multihead
    from twimo.models.lightgbm_model    import predict_lightgbm_multihead
    from twimo.models.random_forest_model import predict_random_forest_multihead
    from twimo.models.baseline_window   import predict_baseline_multihead

    dispatch = {
        "transformer":  predict_transformer_multihead,
        "gru":          lambda ck, x, c: predict_gru_lstm_multihead(ck, x, c),
        "lstm":         lambda ck, x, c: predict_gru_lstm_multihead(ck, x, c),
        "tcn":          predict_tcn_multihead,
        "mlp_mean":     predict_mlp_pooling_multihead,
        "mlp_max":      predict_mlp_pooling_multihead,
        "mlp_concat":   predict_mlp_pooling_multihead,
        "xgboost":      predict_xgboost_multihead,
        "lightgbm":     predict_lightgbm_multihead,
        "random_forest":predict_random_forest_multihead,
        "baseline":     predict_baseline_multihead,
    }
    fn = dispatch[kind]
    return fn(ckpt, X, cfg)


# ──────────────────────────────────────────────────────────────────────────────
# Drawing helpers
# ──────────────────────────────────────────────────────────────────────────────

def _draw_panel(
    frame: np.ndarray,
    predictions: List[Tuple[float, str, float]],   # [(horizon_s, label, prob), ...]
    explanation: str,
    sensor_vals: Dict[str, float],
    label_names: List[str],
) -> np.ndarray:
    """Overlay prediction + explanation panel on a BGR frame (in-place copy)."""
    out = frame.copy()
    h, w = out.shape[:2]

    # Panel dimensions
    panel_h    = min(220, h // 3)
    panel_top  = h - panel_h
    alpha      = 0.65

    # Dark semi-transparent background
    overlay = out.copy()
    cv2.rectangle(overlay, (0, panel_top), (w, h), (20, 20, 20), -1)
    cv2.addWeighted(overlay, alpha, out, 1 - alpha, 0, out)

    # Thin divider line
    cv2.line(out, (0, panel_top), (w, panel_top), (80, 80, 80), 1)

    font       = cv2.FONT_HERSHEY_SIMPLEX
    small      = 0.42
    medium     = 0.52
    bold       = cv2.LINE_AA

    col_left   = 10
    col_mid    = w // 2 + 10
    y0         = panel_top + 18

    # ── LEFT: NEXT ACTION predictions ─────────────────────────────────────────
    cv2.putText(out, "NEXT ACTION", (col_left, y0), font, medium,
                (180, 180, 180), 1, bold)

    bar_w    = min(160, w // 5)
    row_h    = (panel_h - 30) // max(len(predictions), 1)
    row_h    = min(row_h, 40)

    for i, (h_sec, lbl, prob) in enumerate(predictions):
        y = y0 + 20 + i * row_h
        color = CLASS_COLORS_BGR.get(lbl, DEFAULT_COLOR_BGR)

        # Horizon label
        cv2.putText(out, f"{h_sec:.0f}s:", (col_left, y), font, small,
                    (220, 220, 220), 1, bold)

        # Action label (colour-coded)
        cv2.putText(out, lbl, (col_left + 38, y), font, small,
                    color, 1, bold)

        # Probability bar background
        bx = col_left + 150
        cv2.rectangle(out, (bx, y - 11), (bx + bar_w, y + 2), (60, 60, 60), -1)
        # Filled portion
        fill_w = int(bar_w * prob)
        cv2.rectangle(out, (bx, y - 11), (bx + fill_w, y + 2), color, -1)
        # Prob text
        cv2.putText(out, f"{prob*100:.0f}%", (bx + bar_w + 5, y), font, small,
                    (200, 200, 200), 1, bold)

    # ── RIGHT: WHY + sensor values ─────────────────────────────────────────────
    cv2.putText(out, "WHY", (col_mid, y0), font, medium, (180, 180, 180), 1, bold)

    # Wrap explanation text into lines (max ~45 chars per line)
    words  = explanation.split()
    lines  = []
    line   = ""
    limit  = max(30, (w // 2 - 30) // 8)
    for word in words:
        if len(line) + len(word) + 1 <= limit:
            line = (line + " " + word).strip()
        else:
            if line:
                lines.append(line)
            line = word
    if line:
        lines.append(line)

    for j, ln in enumerate(lines[:4]):
        cv2.putText(out, ln, (col_mid, y0 + 20 + j * 16), font, small,
                    (210, 210, 210), 1, bold)

    # Sensor readout at bottom of right column
    speed = sensor_vals.get("speed", sensor_vals.get("vel.speed", 0.0))
    steer = sensor_vals.get("steer_angle", sensor_vals.get("steer.steer_angle", 0.0))
    brake = sensor_vals.get("pedalpressure", sensor_vals.get("brake_pedal.pedalpressure", 0.0))
    sensor_str = f"Speed {speed:.1f} km/h  |  Steer {steer:+.1f} deg  |  Brake {brake:.1f} kPa"
    cv2.putText(out, sensor_str, (col_mid, h - 10), font, small,
                (160, 200, 160), 1, bold)

    return out


# ──────────────────────────────────────────────────────────────────────────────
# Core annotation function for a single session
# ──────────────────────────────────────────────────────────────────────────────

def annotate_session(
    session_id:          str,
    video_path:          Path,
    csv_dir:             Optional[Path],
    kind:                str,
    cfg,
    ckpt,
    feat_names:          List[str],
    label_map:           Dict[str, int],
    horizons_s:          List[float],
    outdir:              Path,
    sample_hz:           float,
    max_seconds:         Optional[float] = None,
    prealigned_sensor:   Optional[Path] = None,
) -> None:
    """Annotate one session video and write the result to outdir."""
    from twimo.data.csv_session import load_sensors_from_csv_dir, resample_sensors
    from twimo.xai.rules import explain_with_rules
    from twimo.models.maneuver_transformer import horizon_steps, unique_horizon_steps
    from twimo.strategies_eaf.two_stage_yolo import _compute_sensor_video_offset

    print(f"\n[annotate] Session: {session_id}")
    print(f"           Video  : {video_path}")

    # ── 1. Sensor loading & resampling ────────────────────────────────────────
    # Prefer prealigned .npy (same feature space as training, full coverage).
    # CSV data is always loaded separately when available: it provides correctly
    # named features for the sensor readout display panel.
    X: Optional[np.ndarray] = None
    loaded_names: List[str] = []
    t_sensor: Optional[np.ndarray] = None

    # CSV data for display (speed, steer, brake readout) — loaded unconditionally.
    # t_sensor_csv is stored so we can compute the video-to-sensor offset for display.
    X_csv: Optional[np.ndarray] = None
    t_sensor_csv: Optional[np.ndarray] = None
    csv_names: List[str] = []
    if csv_dir is not None and csv_dir.exists():
        try:
            frames_csv = load_sensors_from_csv_dir(csv_dir)
            t_sensor_csv, X_csv, csv_names = resample_sensors(frames_csv, sample_hz=sample_hz)
        except Exception:
            X_csv = None  # non-fatal; display will show 0.0

    # t_csv_offset_s: seconds from sensor-start to video-start (for CSV display lookup).
    # t_pred_offset_s: offset applied when computing i_s for model predictions.
    #   - prealigned: t_sensor starts at 0 = video-start, no prediction offset needed.
    #   - CSV-only:   t_sensor starts at sensor-start, need t_csv_offset_s to shift.
    t_csv_offset_s: float = 0.0
    t_pred_offset_s: float = 0.0

    if prealigned_sensor is not None and prealigned_sensor.exists():
        print(f"  Loading prealigned sensor: {prealigned_sensor}")
        X_pre = np.load(prealigned_sensor).astype(np.float32)
        T_pre = X_pre.shape[0]
        # Build a uniform time grid (session-relative seconds at sample_hz)
        t_sensor = np.arange(T_pre, dtype=np.float32) / float(sample_hz)
        # Use generic names so predictions feed the correct column indices;
        # the CSV data (X_csv / csv_names) is used for the display panel.
        loaded_names = [f"sensor_{i}" for i in range(X_pre.shape[1])]
        X = X_pre
        print(f"  Prealigned: {X.shape[0]} samples, {t_sensor[-1]:.1f}s @ {sample_hz}Hz, {X.shape[1]} features")
        # t_pred_offset_s stays 0.0 (prealigned is already video-aligned).
        # For CSV display: compute offset so displayed values align with video frame.
        if X_csv is not None:
            t_csv_offset_s = _compute_sensor_video_offset(session_id, csv_dir, video_path)
            if t_csv_offset_s != 0.0:
                print(f"  CSV display offset: {t_csv_offset_s:.3f}s")
    elif X_csv is not None:
        # No prealigned data — use the CSV array directly for predictions too
        print("  Loading sensors from CSV …")
        frames = load_sensors_from_csv_dir(csv_dir)
        t_sensor, X, loaded_names = resample_sensors(frames, sample_hz=sample_hz)
        # X_csv already loaded above; keep in sync
        X_csv = X
        t_sensor_csv = t_sensor
        csv_names = loaded_names
        # Compute offset so both predictions and display align with video frame.
        t_csv_offset_s  = _compute_sensor_video_offset(session_id, csv_dir, video_path)
        t_pred_offset_s = t_csv_offset_s   # also shift prediction i_s for CSV
        if t_csv_offset_s != 0.0:
            print(f"  Sensor-video offset: {t_csv_offset_s:.3f}s  (sensor before video)")
        print(f"  CSV sensors: {X.shape[0]} samples, {float(t_sensor[-1] - t_sensor[0]):.1f}s @ {sample_hz}Hz, {X.shape[1]} features")
    else:
        print("  WARNING: no sensor source available (no prealigned npy and no csv_dir), skipping.")
        return

    if X is None or X.shape[0] == 0:
        print("  WARNING: no sensor data, skipping.")
        return

    # t_sensor relative to its own start (seconds, starting at 0).
    # For prealigned: starts at 0 = video start (offset=0 correct for predictions).
    # For CSV-only: starts at 0 = sensor start; predictions use t_csv_offset_s.
    t_sensor_rel = t_sensor - t_sensor[0]

    # Precompute CSV relative timeline for the display panel lookup.
    t_rel_csv: Optional[np.ndarray] = None
    if X_csv is not None and t_sensor_csv is not None:
        t_rel_csv = t_sensor_csv - t_sensor_csv[0]

    # For the display panel, prefer CSV names (correct units & labels).
    # For predictions, X uses loaded_names column ordering.
    display_names = csv_names if X_csv is not None else loaded_names

    if loaded_names != feat_names and len(loaded_names) != len(feat_names):
        # Feature mismatch: warn but continue (predictions may be wrong)
        print(f"  WARNING: feature mismatch — model expects {len(feat_names)} features, "
              f"got {len(loaded_names)}. Predictions may be incorrect.")

    # ── 2. Run model predictions ──────────────────────────────────────────────
    print("  Running model predictions …")
    from sklearn.preprocessing import LabelEncoder
    enc = LabelEncoder()
    enc.classes_ = np.array(sorted(int(v) for v in label_map.values()), dtype=np.int64)
    n_classes = len(enc.classes_)

    # Build label name list (remapped index → original label name)
    lbl_names: List[str] = []
    for i in range(n_classes):
        orig = int(enc.classes_[i])
        lbl_names.append(DEFAULT_LABELS[orig] if orig < len(DEFAULT_LABELS) else f"class_{orig}")

    probs_by_steps = _predict_session(kind, ckpt, X, cfg)

    # steps_list (unique, same order as training)
    steps_list = unique_horizon_steps(cfg)
    # Map horizon_seconds → step
    all_steps  = horizon_steps(cfg)
    sec_to_step: Dict[float, int] = {h: s for h, s in zip(cfg.horizons_seconds, all_steps)}

    # window used internally by make_windows (must match predict functions)
    window_steps = int(np.ceil(cfg.window_seconds * cfg.sample_hz))

    # Resolve requested horizons to available steps
    resolved: List[Tuple[float, int]] = []   # (h_sec_requested, actual_step)
    for h_req in sorted(set(horizons_s)):
        # Find closest available horizon in cfg
        best_h  = min(cfg.horizons_seconds, key=lambda x: abs(x - h_req))
        step    = sec_to_step[best_h]
        if step in probs_by_steps and probs_by_steps[step] is not None and len(probs_by_steps[step]) > 0:
            resolved.append((h_req, step))
        else:
            print(f"  WARNING: horizon {h_req}s (step {step}) not in predictions or empty, skipping.")
    if not resolved:
        print("  No valid horizons, skipping session.")
        return

    # Diagnostics: show prediction coverage
    T = X.shape[0]
    max_step = max(s for _, s in resolved)
    valid_start = window_steps        # first sensor index with predictions
    valid_end   = T - max_step - 1   # last sensor index with predictions (for longest horizon)
    valid_start_s = valid_start / float(cfg.sample_hz)
    valid_end_s   = max(0, valid_end) / float(cfg.sample_hz)
    sensor_dur_s  = float(t_sensor_rel[-1])
    print(f"  Window: {window_steps} steps ({cfg.window_seconds}s), classes: {lbl_names}")
    print(f"  Probs array sizes: { {k: len(v) for k, v in probs_by_steps.items() if v is not None} }")
    print(f"  Resolved horizons: {[(h, s) for h, s in resolved]}")
    print(f"  Sensor duration: {sensor_dur_s:.1f}s ({T} samples @ {cfg.sample_hz}Hz)")
    print(f"  Valid prediction range: {valid_start_s:.1f}s – {valid_end_s:.1f}s of sensor time")

    if valid_end <= valid_start:
        print("  WARNING: sensor data too short for any predictions — "
              "check that sensor CSVs cover the full session or use --prealigned-sensors-dir")

    # ── 3. Video info ─────────────────────────────────────────────────────────
    print("  Reading video metadata …")
    video_fps, vid_w, vid_h = _video_info(video_path)
    print(f"  Video: {vid_w}×{vid_h} @ {video_fps:.2f} fps")

    out_path = outdir / f"annotated_{session_id}.mp4"
    outdir.mkdir(parents=True, exist_ok=True)

    # ── 4. FFmpeg decode pipe (full resolution) ───────────────────────────────
    max_frames_total = None
    if max_seconds is not None:
        max_frames_total = int(max_seconds * video_fps)

    decode_cmd = [
        "ffmpeg", "-hide_banner", "-loglevel", "error",
        "-i", str(video_path),
        "-f", "rawvideo", "-pix_fmt", "bgr24",
        "pipe:1",
    ]
    if max_frames_total is not None:
        # Trim via -vframes
        decode_cmd = [
            "ffmpeg", "-hide_banner", "-loglevel", "error",
            "-i", str(video_path),
            "-vframes", str(max_frames_total),
            "-f", "rawvideo", "-pix_fmt", "bgr24",
            "pipe:1",
        ]

    encode_cmd = [
        "ffmpeg", "-hide_banner", "-loglevel", "error",
        "-y",
        "-f", "rawvideo", "-pix_fmt", "bgr24",
        "-r", str(video_fps),
        "-s", f"{vid_w}x{vid_h}",
        "-i", "pipe:0",
        "-c:v", "libx264", "-crf", "23", "-preset", "fast",
        "-pix_fmt", "yuv420p",
        str(out_path),
    ]

    decoder = subprocess.Popen(decode_cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    encoder = subprocess.Popen(encode_cmd, stdin=subprocess.PIPE,  stderr=subprocess.PIPE)

    frame_bytes = vid_w * vid_h * 3
    frame_idx   = 0
    _first_pred_frame_logged = False

    print(f"  Annotating → {out_path}")
    try:
        while True:
            raw = decoder.stdout.read(frame_bytes)
            if not raw or len(raw) < frame_bytes:
                break

            # Current time in the video (seconds from video frame 0).
            t_frame_rel = frame_idx / video_fps

            # Nearest sensor index for model predictions.
            # For prealigned: t_pred_offset_s=0 (prealigned starts at video start).
            # For CSV-only:   t_pred_offset_s=t_csv_offset_s (shift sensor timeline).
            i_s = int(np.argmin(np.abs(t_sensor_rel - (t_frame_rel + t_pred_offset_s))))

            frame = np.frombuffer(raw, dtype=np.uint8).reshape(vid_h, vid_w, 3)
            frame = frame.copy()

            # Build predictions for requested horizons.
            # probs[k] uses window X[k : k+window] which covers sensor indices k..k+window-1.
            # At sensor index i_s the appropriate window index is: k = i_s - window_steps + 1
            preds_panel: List[Tuple[float, str, float]] = []
            pred_idx = i_s - window_steps + 1   # corrected (was off-by-one)
            if pred_idx >= 0:
                for h_req, step in resolved:
                    p_arr = probs_by_steps[step]
                    if pred_idx < len(p_arr):
                        prob_vec = p_arr[pred_idx]
                        pred_cls = int(np.argmax(prob_vec))
                        prob_val = float(prob_vec[pred_cls])
                        lbl      = lbl_names[pred_cls] if pred_cls < len(lbl_names) else f"cls{pred_cls}"
                        preds_panel.append((h_req, lbl, prob_val))
                        if not _first_pred_frame_logged:
                            print(f"  First prediction at frame {frame_idx} "
                                  f"(t={t_frame_rel:.1f}s, i_s={i_s}, pred_idx={pred_idx})")
                            _first_pred_frame_logged = True

            if not preds_panel:
                # Use "N/A" — OpenCV can't render Unicode ellipsis "…"
                preds_panel = [(h, "N/A", 0.0) for h, _ in resolved]

            # Explanation from current sensor window
            expl_text = "Accumulating sensor history..."
            if pred_idx >= 0:
                w_start = max(0, i_s - window_steps + 1)
                window_data = X[w_start: i_s + 1]
                if len(preds_panel) > 0 and preds_panel[0][1] not in ("N/A", ""):
                    best_pred_cls = lbl_names.index(preds_panel[0][1]) if preds_panel[0][1] in lbl_names else 0
                    try:
                        result = explain_with_rules(window_data, best_pred_cls, lbl_names)
                        expl_text = result.text
                    except Exception:
                        expl_text = "Explanation unavailable."
                elif t_frame_rel > sensor_dur_s:
                    expl_text = "Beyond sensor data range."

            # Current sensor values (last sample in valid range).
            # Always look up in CSV with t_csv_offset_s so the display matches the
            # video frame regardless of whether prealigned is used for predictions.
            sensor_vals: Dict[str, float] = {}
            if X_csv is not None and t_rel_csv is not None:
                i_s_disp = int(np.argmin(np.abs(t_rel_csv - (t_frame_rel + t_csv_offset_s))))
                i_s_disp = min(i_s_disp, X_csv.shape[0] - 1)
                names_disp = display_names
                for fi, fname in enumerate(names_disp):
                    sensor_vals[fname] = float(X_csv[i_s_disp, fi]) if fi < X_csv.shape[1] else 0.0
            elif X is not None:
                i_s_disp = min(i_s, X.shape[0] - 1)
                for fi, fname in enumerate(loaded_names):
                    sensor_vals[fname] = float(X[i_s_disp, fi]) if fi < X.shape[1] else 0.0

            # Draw panel
            annotated = _draw_panel(frame, preds_panel, expl_text, sensor_vals, lbl_names)

            encoder.stdin.write(annotated.tobytes())
            frame_idx += 1

            if frame_idx % 300 == 0:
                elapsed = frame_idx / video_fps
                pct_sensor = min(100.0, t_frame_rel / max(sensor_dur_s, 1e-6) * 100)
                print(f"    … {elapsed:.0f}s video / {t_frame_rel:.0f}s sensor "
                      f"({pct_sensor:.0f}% sensor coverage) | i_s={i_s}/{T-1} | "
                      f"pred_idx={pred_idx} / {len(probs_by_steps.get(resolved[0][1], [])) if resolved else 0}")

    except BrokenPipeError:
        pass
    finally:
        try:
            decoder.stdout.close()
        except Exception:
            pass
        decoder.terminate()
        try:
            encoder.stdin.close()
        except Exception:
            pass
        encoder.wait()

    print(f"  Done → {out_path}  ({frame_idx} frames)")


# ──────────────────────────────────────────────────────────────────────────────
# CLI
# ──────────────────────────────────────────────────────────────────────────────

def main():
    parser = argparse.ArgumentParser(
        description="Annotate driving video(s) with maneuver predictions and explanations."
    )
    parser.add_argument("--manifest",   type=Path, required=True,
                        help="Path to manifest.jsonl")
    parser.add_argument("--modeldir",   type=Path, required=True,
                        help="Directory with trained model artefacts (config.json, model.pt, …)")
    parser.add_argument("--outdir",     type=Path, required=True,
                        help="Output directory for annotated videos")
    parser.add_argument("--session",    type=str, default=None,
                        help="Process a single session_id. If omitted, all sessions with video are processed.")
    parser.add_argument("--horizons",   type=float, nargs="+", default=[1.0, 3.0, 5.0],
                        help="Prediction horizons to display in seconds (default: 1 3 5)")
    parser.add_argument("--sample-hz",  type=float, default=3.0,
                        help="Sensor resample frequency used during training (default: 3)")
    parser.add_argument("--max-seconds", type=float, default=None,
                        help="Limit each video to the first N seconds (useful for quick tests)")
    parser.add_argument("--prealigned-sensors-dir", type=Path, default=None,
                        help="Directory containing prealigned sensor .npy files "
                             "(e.g. assets/hdd_prealigned/20200710_sensors/sensor). "
                             "When provided, uses the same feature space as training. "
                             "Recommended when the model was trained with prealigned assets.")
    args = parser.parse_args()

    # Load manifest
    records = []
    with open(args.manifest) as f:
        for line in f:
            line = line.strip()
            if line:
                records.append(json.loads(line))

    # Filter by session
    if args.session:
        records = [r for r in records if r.get("session_id") == args.session]
        if not records:
            print(f"ERROR: session '{args.session}' not found in manifest.", file=sys.stderr)
            sys.exit(1)

    # Keep only records with a video
    video_records = []
    for r in records:
        vdir = r.get("video_dir")
        if vdir:
            vdir_path = Path(vdir)
            mp4s = list(vdir_path.glob("*.mp4"))
            if mp4s:
                r["_video_path"] = mp4s[0]
                video_records.append(r)

    if not video_records:
        print("No sessions with video found. Check manifest video_dir fields.", file=sys.stderr)
        sys.exit(1)

    print(f"Found {len(video_records)} session(s) with video.")

    # Load model once (shared across all sessions)
    print(f"\nLoading model from {args.modeldir} …")
    kind, cfg, ckpt, feat_names, label_map = _load_model_and_config(args.modeldir)
    print(f"  Model kind : {kind}")
    print(f"  Horizons   : {cfg.horizons_seconds}")
    print(f"  Features   : {len(feat_names)}")

    args.outdir.mkdir(parents=True, exist_ok=True)
    _profiler = TrainingProfiler(model_name="annotate_video", output_dir=args.outdir, use_codecarbon=True)
    _profiler.__enter__()

    for r in video_records:
        sid      = r["session_id"]
        csv_dir  = Path(r["csv_dir"]) if r.get("csv_dir") else None
        vid_path = r["_video_path"]

        # Prealigned sensor path (preferred over CSV when available)
        prealigned_sensor: Optional[Path] = None
        if args.prealigned_sensors_dir is not None:
            candidate = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
            if candidate.exists():
                prealigned_sensor = candidate

        # Skip session only if BOTH data sources are missing
        if prealigned_sensor is None and (csv_dir is None or not csv_dir.exists()):
            print(f"[SKIP] {sid}: no sensor data (no prealigned .npy and no csv_dir).")
            continue

        try:
            annotate_session(
                session_id         = sid,
                video_path         = vid_path,
                csv_dir            = csv_dir,
                kind               = kind,
                cfg                = cfg,
                ckpt               = ckpt,
                feat_names         = feat_names,
                label_map          = label_map,
                horizons_s         = args.horizons,
                outdir             = args.outdir,
                sample_hz          = args.sample_hz,
                max_seconds        = args.max_seconds,
                prealigned_sensor  = prealigned_sensor,
            )
        except Exception as exc:
            print(f"[ERROR] {sid}: {exc}", file=sys.stderr)
            import traceback
            traceback.print_exc()

    _profiler.__exit__(None, None, None)
    print("\nAll done.")


if __name__ == "__main__":
    main()
