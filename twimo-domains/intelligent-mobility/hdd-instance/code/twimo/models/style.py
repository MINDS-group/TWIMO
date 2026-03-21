from __future__ import annotations

from dataclasses import dataclass
from typing import Dict, List, Tuple

import numpy as np
from sklearn.cluster import KMeans


@dataclass
class StyleProfile:
    session_id: str
    features: Dict[str, float]
    cluster: int
    label: str


def compute_style_features(X: np.ndarray, feature_names: List[str]) -> Dict[str, float]:
    def g(name):
        try:
            return X[:, feature_names.index(name)]
        except ValueError:
            return None

    steer = g("steer.steer_angle")
    steer_speed = g("steer.steer_speed")
    accel = g("accel_pedal.pedalangle")
    brake = g("brake_pedal.pedalpressure")
    vel = g("vel.speed")

    out = {}
    if accel is not None:
        out["accel_mean"] = float(np.mean(accel))
        out["accel_p95"] = float(np.percentile(accel, 95))
    if brake is not None:
        out["brake_mean"] = float(np.mean(brake))
        out["brake_p95"] = float(np.percentile(brake, 95))
    if steer is not None:
        out["steer_std"] = float(np.std(steer))
    if steer_speed is not None:
        out["steer_speed_p95"] = float(np.percentile(np.abs(steer_speed), 95))
    if vel is not None:
        out["vel_mean"] = float(np.mean(vel))
        out["vel_p95"] = float(np.percentile(vel, 95))

    # A compact aggressiveness score
    out["aggr_score"] = float(
        0.0
        + out.get("accel_p95", 0.0) / 100.0
        + out.get("brake_p95", 0.0) / 200.0
        + out.get("steer_speed_p95", 0.0) / 50.0
        + out.get("vel_p95", 0.0) / 50.0
    )
    return out


def cluster_styles(style_feats: List[Dict[str, float]], k: int = 3, seed: int = 7):
    keys = sorted({k for d in style_feats for k in d.keys()})
    X = np.array([[d.get(k, 0.0) for k in keys] for d in style_feats], dtype=np.float32)
    km = KMeans(n_clusters=k, random_state=seed, n_init='auto')
    c = km.fit_predict(X)
    return c, keys, km


def name_clusters(centroids: np.ndarray, keys: List[str]) -> Dict[int, str]:
    # Use aggressiveness score if present
    if "aggr_score" in keys:
        idx = keys.index("aggr_score")
        scores = centroids[:, idx]
        order = np.argsort(scores)
        mapping = {}
        mapping[int(order[0])] = "prudent"
        mapping[int(order[1])] = "smooth"
        mapping[int(order[2])] = "aggressive"
        return mapping
    return {i: f"style_{i}" for i in range(centroids.shape[0])}
