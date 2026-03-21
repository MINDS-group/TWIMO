from __future__ import annotations

from dataclasses import dataclass
from typing import Dict, Optional

import numpy as np


@dataclass
class ExplanationResult:
    predicted_action: int
    text: str
    evidence: Dict[str, float]


def explain_with_rules(x_window: np.ndarray, pred_action: int, class_names: list[str]) -> ExplanationResult:
    """Fast, deterministic explanations from sensor patterns.

    This is NOT a full causal model. It is a pragmatic baseline:
    - helps debugging
    - provides human-readable rationale
    - can be replaced with SHAP / attention visualization later
    """
    # x_window: (W, D)
    last = x_window[-1]
    steer_angle, steer_speed, accel, brake, lturn, rturn, vel, yaw = last.tolist()

    evidence = {
        "steer_angle": float(steer_angle),
        "steer_speed": float(steer_speed),
        "accel": float(accel),
        "brake": float(brake),
        "lturn": float(lturn),
        "rturn": float(rturn),
        "vel": float(vel),
        "yaw": float(yaw),
    }

    name = class_names[pred_action] if 0 <= pred_action < len(class_names) else f"class_{pred_action}"

    reasons = []
    if brake > 20.0 and vel > 1.0:
        reasons.append("strong brake pressure")
    if accel > 20.0:
        reasons.append("high accelerator pedal")
    if steer_angle < -5.0 or lturn > 0.5:
        reasons.append("left steering / left indicator")
    if steer_angle > 5.0 or rturn > 0.5:
        reasons.append("right steering / right indicator")
    if vel < 0.3:
        reasons.append("very low speed")

    if not reasons:
        reasons.append("stable steering and moderate controls")

    text = f"Predicted action: {name}. Key evidence: " + ", ".join(reasons) + "."
    return ExplanationResult(predicted_action=pred_action, text=text, evidence=evidence)
