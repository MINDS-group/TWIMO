from __future__ import annotations

from typing import Dict, List, Optional, Tuple

import numpy as np

# Explanation is the canonical type defined in the DTE framework layer.
# DTE Mapping: explainability.Explanation
# Field mapping (JSONL output -> Explanation):
#   JSONL 'text'        -> content
#   JSONL 'probability' -> confidence
from twimo.framework.twimo_objects import Explanation  # noqa: F401  # re-exported for callers


def simple_explain(
    probs: np.ndarray,
    t_index: int,
    label_names: List[str],
    sensor_window: Optional[np.ndarray] = None,
    feature_names: Optional[List[str]] = None,
) -> str:
    """heuristic explanation (feature saliency).

    Kept for backwards compatibility.
    """
    pred = int(np.argmax(probs))
    p = float(probs[pred])
    name = label_names[pred] if pred < len(label_names) else f"label_{pred}"

    cues = []
    if sensor_window is not None and feature_names is not None and sensor_window.size:
        last = sensor_window[-1]
        mean = sensor_window.mean(axis=0)
        delta = last - mean
        top = np.argsort(np.abs(delta))[-3:][::-1]
        for j in top:
            cues.append(f"{feature_names[j]} changed by {delta[j]:.2f}")

    if cues:
        return f"Predicted '{name}' (p={p:.2f}) because: " + "; ".join(cues) + "."
    return f"Predicted '{name}' (p={p:.2f}) based on the recent driving context."


def _find_feature(feature_names: List[str], needles: List[str], avoid: List[str] | None = None) -> Optional[int]:
    avoid = avoid or []
    lowered = [n.lower() for n in feature_names]
    needles_l = [n.lower() for n in needles]
    avoid_l = [a.lower() for a in avoid]

    # 1) exact-ish hits
    for i, name in enumerate(lowered):
        if any(n in name for n in needles_l) and not any(a in name for a in avoid_l):
            return i
    return None


def cod1_style_explain(
    x_now: np.ndarray,
    x_fut: Optional[np.ndarray],
    feature_names: List[str],
    steering_turn_thresh_deg: float = 30.0,
    steering_lane_thresh_deg: float = 8.0,
    brake_thresh: float = 0.2,
) -> Tuple[str, Dict]:
    """Rule-based explanation.

    Returns (text, semantics).

    Notes
    -----
    - This is *heuristic* and intended as a transparent baseline.
    - If some required sensor is missing, the rule degrades gracefully.
    """

    # Try to locate common fields in HDD / CAN-like exports
    i_speed = _find_feature(feature_names, ["veh_speed", "vehicle_speed", "speed"], avoid=["steer_speed"])
    i_steer = _find_feature(feature_names, ["steer_angle", "steering_angle", "steer.steer_angle", "steer"], avoid=["speed"])
    i_brake = _find_feature(feature_names, ["brake", "pedalpressure", "pedal_pressure", "brake_pedal", "brake_pressure"], avoid=[])

    # Positional fallback for prealigned sensor_N names (HDD column order):
    # [steer_angle, steer_speed, accel, brake, lturn, rturn, vel, yaw]
    if all(n.startswith("sensor_") for n in feature_names) and len(feature_names) >= 7:
        if i_steer is None:
            i_steer = 0  # steer_angle
        if i_brake is None:
            i_brake = 3  # brake_pedal
        if i_speed is None:
            i_speed = 6  # vel (km/h)

    speed = float(x_now[i_speed]) if i_speed is not None else None
    steer_now = float(x_now[i_steer]) if i_steer is not None else None
    brake_now = float(x_now[i_brake]) if i_brake is not None else None

    steer_fut = float(x_fut[i_steer]) if (x_fut is not None and i_steer is not None) else None
    brake_fut = float(x_fut[i_brake]) if (x_fut is not None and i_brake is not None) else None

    parts: List[str] = []
    semantics: Dict = {}

    # Braking likelihood (use future if available, else current)
    b = brake_fut if brake_fut is not None else brake_now
    if b is not None and b > brake_thresh:
        parts.append("The vehicle slows down due to a braking action inferred from sensor signals.")
        semantics["braking"] = True

    # Turning vs lane-level (use future if available, else current)
    s = steer_fut if steer_fut is not None else steer_now
    if s is not None:
        if abs(s) >= steering_turn_thresh_deg:
            parts.append("A turning maneuver is likely, as the steering angle becomes large.")
            semantics["turning"] = True
        elif abs(s) >= steering_lane_thresh_deg:
            parts.append("A lane-level maneuver is likely, as the steering angle changes.")
            semantics["lane_change"] = True

    if not parts:
        parts.append("The vehicle is expected to maintain its current motion, with no strong stimulus detected.")
        semantics["straight"] = True

    return " ".join(parts), semantics
