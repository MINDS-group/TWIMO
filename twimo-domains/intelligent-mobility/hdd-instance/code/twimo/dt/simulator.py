from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Dict, Optional, Tuple

import numpy as np
import pandas as pd


def as_numpy(x):
    """
    Convert pandas Series/DataFrame to numpy array if needed.
    If already numpy-like, return a numpy array.
    """
    if isinstance(x, np.ndarray):
        return x
    if hasattr(x, "to_numpy"):
        return x.to_numpy()
    return np.asarray(x)


@dataclass
class KinematicState:
    x: float
    y: float
    yaw: float  # radians (0 = +X / East, pi/2 = +Y / North)
    v: float


def _heading_to_yaw_east_axis(heading_deg: float) -> float:
    """
    Convert GPS heading (deg clockwise from North)
    to yaw in ENU frame (rad, 0 = East).
    """
    return float(np.deg2rad(90.0 - float(heading_deg)))


def latlng_to_local_xy(
    lat: np.ndarray,
    lng: np.ndarray,
    ref_lat: float,
    ref_lng: float,
) -> Tuple[np.ndarray, np.ndarray]:
    """Equirectangular projection (local meters)."""
    R = 6378137.0
    lat0 = np.deg2rad(ref_lat)
    dlat = np.deg2rad(lat - ref_lat)
    dlng = np.deg2rad(lng - ref_lng)
    x = R * dlng * np.cos(lat0)
    y = R * dlat
    return x, y


def local_xy_to_latlng(
    x_m: np.ndarray,
    y_m: np.ndarray,
    ref_lat: float,
    ref_lng: float,
) -> Tuple[np.ndarray, np.ndarray]:
    R = 6378137.0
    lat0 = np.deg2rad(ref_lat)
    lat = ref_lat + np.rad2deg(y_m / R)
    lng = ref_lng + np.rad2deg(x_m / (R * np.cos(lat0)))
    return lat, lng


def simulate_kinematic_bicycle(
    df: pd.DataFrame,
    hz: float,
    wheelbase_m: float = 2.7,
    speed_scale: float = 1.0,
) -> pd.DataFrame:
    """
    Simulate a kinematic bicycle model from aligned sensor data.

    Required columns:
    - steer_angle (deg)
    - speed (m/s after scaling)

    Optional:
    - GPS_Yaw(heading) or GPS_course (deg, clockwise from North)
    """
    dt = 1.0 / float(hz)

    steer_deg = as_numpy(
        df.get("steer_angle", pd.Series(np.zeros(len(df))))
        .astype(float)
        .fillna(0.0)
    )

    v = as_numpy(
        df.get("speed", pd.Series(np.zeros(len(df))))
        .astype(float)
        .fillna(0.0)
    ) * float(speed_scale)

    # Initial yaw
    yaw = 0.0
    if "GPS_Yaw(heading)" in df.columns and df["GPS_Yaw(heading)"].notna().any():
        yaw = _heading_to_yaw_east_axis(float(df["GPS_Yaw(heading)"].dropna().iloc[0]))
    elif "GPS_course" in df.columns and df["GPS_course"].notna().any():
        yaw = _heading_to_yaw_east_axis(float(df["GPS_course"].dropna().iloc[0]))

    x, y = 0.0, 0.0
    xs, ys, yaws = [], [], []

    for i in range(len(df)):
        delta = np.deg2rad(float(steer_deg[i]))
        beta = np.arctan(0.5 * np.tan(delta))

        x += float(v[i] * np.cos(yaw + beta) * dt)
        y += float(v[i] * np.sin(yaw + beta) * dt)
        yaw += float((v[i] / max(1e-6, wheelbase_m)) * np.sin(beta) * dt)

        xs.append(x)
        ys.append(y)
        yaws.append(yaw)

    out = df.copy()
    out["x_sim_m"] = np.asarray(xs)
    out["y_sim_m"] = np.asarray(ys)
    out["yaw_sim_rad"] = np.asarray(yaws)
    return out


def evaluate_simulation(
    aligned_df: pd.DataFrame,
    sim_df: pd.DataFrame,
) -> Tuple[Dict[str, Any], Optional[pd.DataFrame]]:
    """
    Compare simulated trajectory vs RTK ground truth (lat/lng).
    """
    if not {"lat", "lng"}.issubset(aligned_df.columns):
        return {
            "has_rtk": False,
            "rmse_x_m": None,
            "rmse_y_m": None,
            "rmse_xy_m": None,
            "mae_x_m": None,
            "mae_y_m": None,
            "mae_xy_m": None,
            "mape_xy_percent": None,
            "nrmse_mean": None,
            "nrmse_range": None,
            "n": int(len(aligned_df)),
            "mean_rtk_distance_m": None,
            "trajectory_range_m": None,
            "note": "Missing RTK lat/lng columns",
        }, None

    lat = as_numpy(aligned_df["lat"].astype(float))
    lng = as_numpy(aligned_df["lng"].astype(float))

    valid = np.isfinite(lat) & np.isfinite(lng)
    if valid.sum() < 5:
        return {
            "has_rtk": False,
            "rmse_x_m": None,
            "rmse_y_m": None,
            "rmse_xy_m": None,
            "mae_x_m": None,
            "mae_y_m": None,
            "mae_xy_m": None,
            "mape_xy_percent": None,
            "nrmse_mean": None,
            "nrmse_range": None,
            "n": int(len(aligned_df)),
            "mean_rtk_distance_m": None,
            "trajectory_range_m": None,
            "note": "Not enough valid RTK samples",
        }, None

    i0 = int(np.argmax(valid))
    ref_lat = float(lat[i0])
    ref_lng = float(lng[i0])

    x_rtk, y_rtk = latlng_to_local_xy(lat, lng, ref_lat, ref_lng)

    x_sim = as_numpy(sim_df["x_sim_m"].astype(float))
    y_sim = as_numpy(sim_df["y_sim_m"].astype(float))

    x_sim = x_sim - x_sim[i0]
    y_sim = y_sim - y_sim[i0]

    dx = (x_sim - x_rtk)[valid]
    dy = (y_sim - y_rtk)[valid]

    # Euclidean distance errors
    dist_errors = np.sqrt(dx ** 2 + dy ** 2)

    # RMSE (Root Mean Squared Error)
    rmse_x = float(np.sqrt(np.mean(dx ** 2)))
    rmse_y = float(np.sqrt(np.mean(dy ** 2)))
    rmse_xy = float(np.sqrt(np.mean(dx ** 2 + dy ** 2)))

    # MAE (Mean Absolute Error)
    mae_x = float(np.mean(np.abs(dx)))
    mae_y = float(np.mean(np.abs(dy)))
    mae_xy = float(np.mean(dist_errors))

    # MAPE (Mean Absolute Percentage Error)
    # For position, we use distance from origin as reference
    rtk_distances = np.sqrt(x_rtk[valid] ** 2 + y_rtk[valid] ** 2)
    # Avoid division by zero: use distance > 1m as threshold
    valid_for_mape = rtk_distances > 1.0
    if valid_for_mape.sum() > 0:
        mape_xy = float(100.0 * np.mean(dist_errors[valid_for_mape] / rtk_distances[valid_for_mape]))
    else:
        mape_xy = None

    # NRMSE (Normalized RMSE) - normalized by mean
    mean_rtk_distance = float(np.mean(rtk_distances))
    if mean_rtk_distance > 0:
        nrmse_mean = float(rmse_xy / mean_rtk_distance)
    else:
        nrmse_mean = None

    # NRMSE (Normalized RMSE) - normalized by range
    range_x = float(x_rtk[valid].max() - x_rtk[valid].min())
    range_y = float(y_rtk[valid].max() - y_rtk[valid].min())
    range_xy = float(np.sqrt(range_x ** 2 + range_y ** 2))
    if range_xy > 0:
        nrmse_range = float(rmse_xy / range_xy)
    else:
        nrmse_range = None

    t = as_numpy(aligned_df.get("t", np.arange(len(aligned_df), dtype=float)))

    # Calculate session duration
    t_valid = t[valid]
    if len(t_valid) > 1:
        duration_s = float(t_valid[-1] - t_valid[0])
    else:
        duration_s = 0.0

    traj = pd.DataFrame(
        {
            "t": t,
            "x_sim_m": x_sim,
            "y_sim_m": y_sim,
            "x_rtk_m": x_rtk,
            "y_rtk_m": y_rtk,
        }
    )

    metrics = {
        "has_rtk": True,
        # RMSE metrics
        "rmse_x_m": rmse_x,
        "rmse_y_m": rmse_y,
        "rmse_xy_m": rmse_xy,
        # MAE metrics
        "mae_x_m": mae_x,
        "mae_y_m": mae_y,
        "mae_xy_m": mae_xy,
        # MAPE metric
        "mape_xy_percent": mape_xy,
        # NRMSE metrics
        "nrmse_mean": nrmse_mean,
        "nrmse_range": nrmse_range,
        # Sample info
        "n": int(valid.sum()),
        "duration_s": duration_s,
        "mean_rtk_distance_m": mean_rtk_distance,
        "trajectory_range_m": range_xy,
        "note": "",
    }
    return metrics, traj