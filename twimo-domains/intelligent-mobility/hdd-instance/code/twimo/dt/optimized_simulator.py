"""Optimized Digital Twin simulator with parameter calibration and drift correction.

This module provides improved trajectory simulation compared to the basic kinematic
bicycle model by:
1. Auto-calibrating vehicle parameters (wheelbase, speed scale, steering scale)
2. Periodic position reset to RTK GPS (reduces accumulated drift)
3. Better initial state estimation
4. Adaptive correction based on RTK feedback
"""

from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Dict, Optional, Tuple

import numpy as np
import pandas as pd
from scipy.optimize import minimize

from .simulator import (
    as_numpy,
    latlng_to_local_xy,
    local_xy_to_latlng,
    _heading_to_yaw_east_axis,
)


@dataclass
class OptimizedDTConfig:
    """Configuration for optimized DT simulation."""

    # Vehicle model parameters
    wheelbase_m: float = 2.7
    speed_scale: float = 1.0
    steer_scale: float = 1.0

    # Optimization settings
    calibrate_params: bool = True
    optimize_wheelbase: bool = True
    optimize_speed_scale: bool = True
    optimize_steer_scale: bool = True

    # Drift correction settings
    use_position_reset: bool = True
    reset_interval_steps: int = 30  # Reset every N timesteps (e.g., every 10 seconds at 3 Hz)

    # Initial state estimation
    use_multi_sample_init: bool = True
    init_samples: int = 10  # Use first N samples to estimate initial velocity/heading


def estimate_initial_state(
    df: pd.DataFrame,
    n_samples: int = 10,
) -> Tuple[float, float, float, float]:
    """Estimate initial state (x, y, yaw, v) from first N RTK samples.

    Returns:
        x, y, yaw (rad), v (m/s)
    """
    # Get first n_samples with valid RTK
    lat = as_numpy(df['lat'].astype(float))
    lng = as_numpy(df['lng'].astype(float))
    valid = np.isfinite(lat) & np.isfinite(lng)

    if valid.sum() < 2:
        return 0.0, 0.0, 0.0, 0.0

    # Find first valid index
    i0 = int(np.argmax(valid))

    # Reference point
    ref_lat = float(lat[i0])
    ref_lng = float(lng[i0])

    # Convert to local coords
    x_rtk, y_rtk = latlng_to_local_xy(lat, lng, ref_lat, ref_lng)

    # Use first valid samples to estimate heading and velocity
    n = min(n_samples, valid.sum())
    indices = np.where(valid)[0][:n]

    if len(indices) < 2:
        return 0.0, 0.0, 0.0, 0.0

    # Estimate heading from position delta
    dx = x_rtk[indices[-1]] - x_rtk[indices[0]]
    dy = y_rtk[indices[-1]] - y_rtk[indices[0]]
    yaw_est = float(np.arctan2(dy, dx))

    # Estimate velocity from position delta and time
    if 't' in df.columns:
        t = as_numpy(df['t'].astype(float))
        dt = t[indices[-1]] - t[indices[0]]
    else:
        dt = (len(indices) - 1) / 3.0  # Assume 3 Hz

    dist = float(np.sqrt(dx**2 + dy**2))
    v_est = dist / max(dt, 0.1)

    return 0.0, 0.0, yaw_est, v_est


def simulate_with_reset(
    df: pd.DataFrame,
    hz: float,
    config: OptimizedDTConfig,
) -> pd.DataFrame:
    """Simulate kinematic bicycle with periodic position reset to RTK.

    Args:
        df: DataFrame with steer_angle, speed, lat, lng
        hz: Sample rate
        config: Simulation configuration

    Returns:
        DataFrame with simulated trajectory
    """
    dt = 1.0 / float(hz)

    # Extract inputs
    steer_deg = as_numpy(
        df.get("steer_angle", pd.Series(np.zeros(len(df))))
        .astype(float)
        .fillna(0.0)
    ) * float(config.steer_scale)

    v = as_numpy(
        df.get("speed", pd.Series(np.zeros(len(df))))
        .astype(float)
        .fillna(0.0)
    ) * float(config.speed_scale)

    # Get RTK positions
    lat = as_numpy(df['lat'].astype(float))
    lng = as_numpy(df['lng'].astype(float))
    valid_rtk = np.isfinite(lat) & np.isfinite(lng)

    if valid_rtk.sum() < 5:
        # Fallback to basic simulation
        return simulate_kinematic_bicycle_optimized(df, hz, config)

    # Reference point
    i0 = int(np.argmax(valid_rtk))
    ref_lat = float(lat[i0])
    ref_lng = float(lng[i0])
    x_rtk, y_rtk = latlng_to_local_xy(lat, lng, ref_lat, ref_lng)

    # Initial state
    if config.use_multi_sample_init:
        x, y, yaw, v_init = estimate_initial_state(df, config.init_samples)
    else:
        yaw = 0.0
        if "GPS_Yaw(heading)" in df.columns and df["GPS_Yaw(heading)"].notna().any():
            yaw = _heading_to_yaw_east_axis(float(df["GPS_Yaw(heading)"].dropna().iloc[0]))
        elif "GPS_course" in df.columns and df["GPS_course"].notna().any():
            yaw = _heading_to_yaw_east_axis(float(df["GPS_course"].dropna().iloc[0]))
        x, y = 0.0, 0.0

    xs, ys, yaws = [], [], []
    reset_count = 0

    for i in range(len(df)):
        # Periodic position reset to RTK
        if (config.use_position_reset and
            valid_rtk[i] and
            i % config.reset_interval_steps == 0 and
            i > 0):
            # Reset position to RTK
            x = float(x_rtk[i])
            y = float(y_rtk[i])
            reset_count += 1

            # Optionally reset heading from velocity direction
            if i + 5 < len(df) and valid_rtk[i:i+5].sum() >= 3:
                future_idx = i + 5
                dx = x_rtk[future_idx] - x_rtk[i]
                dy = y_rtk[future_idx] - y_rtk[i]
                if np.sqrt(dx**2 + dy**2) > 1.0:  # At least 1m movement
                    yaw = float(np.arctan2(dy, dx))

        # Kinematic bicycle step
        delta = np.deg2rad(float(steer_deg[i]))
        beta = np.arctan(0.5 * np.tan(delta))

        x += float(v[i] * np.cos(yaw + beta) * dt)
        y += float(v[i] * np.sin(yaw + beta) * dt)
        yaw += float((v[i] / max(1e-6, config.wheelbase_m)) * np.sin(beta) * dt)

        xs.append(x)
        ys.append(y)
        yaws.append(yaw)

    out = df.copy()
    out["x_sim_m"] = np.asarray(xs)
    out["y_sim_m"] = np.asarray(ys)
    out["yaw_sim_rad"] = np.asarray(yaws)
    out.attrs['reset_count'] = reset_count

    return out


def simulate_kinematic_bicycle_optimized(
    df: pd.DataFrame,
    hz: float,
    config: OptimizedDTConfig,
) -> pd.DataFrame:
    """Simulate kinematic bicycle with optimized parameters (no position reset).

    Args:
        df: DataFrame with steer_angle, speed
        hz: Sample rate
        config: Simulation configuration

    Returns:
        DataFrame with simulated trajectory
    """
    dt = 1.0 / float(hz)

    steer_deg = as_numpy(
        df.get("steer_angle", pd.Series(np.zeros(len(df))))
        .astype(float)
        .fillna(0.0)
    ) * float(config.steer_scale)

    v = as_numpy(
        df.get("speed", pd.Series(np.zeros(len(df))))
        .astype(float)
        .fillna(0.0)
    ) * float(config.speed_scale)

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
        yaw += float((v[i] / max(1e-6, config.wheelbase_m)) * np.sin(beta) * dt)

        xs.append(x)
        ys.append(y)
        yaws.append(yaw)

    out = df.copy()
    out["x_sim_m"] = np.asarray(xs)
    out["y_sim_m"] = np.asarray(ys)
    out["yaw_sim_rad"] = np.asarray(yaws)

    return out


def calibrate_parameters(
    df: pd.DataFrame,
    hz: float,
    config: OptimizedDTConfig,
) -> OptimizedDTConfig:
    """Calibrate vehicle parameters to minimize RMSE against RTK.

    Args:
        df: DataFrame with steer_angle, speed, lat, lng
        hz: Sample rate
        config: Initial configuration

    Returns:
        Optimized configuration
    """
    # Check if RTK is available
    if not {'lat', 'lng'}.issubset(df.columns):
        return config

    lat = as_numpy(df['lat'].astype(float))
    lng = as_numpy(df['lng'].astype(float))
    valid = np.isfinite(lat) & np.isfinite(lng)

    if valid.sum() < 10:
        return config

    # Reference point
    i0 = int(np.argmax(valid))
    ref_lat = float(lat[i0])
    ref_lng = float(lng[i0])
    x_rtk, y_rtk = latlng_to_local_xy(lat, lng, ref_lat, ref_lng)

    # Optimization function
    def objective(params):
        """RMSE between simulated and RTK trajectory."""
        wheelbase, speed_scale, steer_scale = params

        # Create temp config
        temp_config = OptimizedDTConfig(
            wheelbase_m=wheelbase,
            speed_scale=speed_scale,
            steer_scale=steer_scale,
            use_position_reset=False,  # No reset during calibration
            calibrate_params=False,
        )

        # Simulate
        sim = simulate_kinematic_bicycle_optimized(df, hz, temp_config)

        x_sim = as_numpy(sim["x_sim_m"].astype(float))
        y_sim = as_numpy(sim["y_sim_m"].astype(float))

        # Align to first RTK point
        x_sim = x_sim - x_sim[i0]
        y_sim = y_sim - y_sim[i0]

        # Compute RMSE on valid points
        dx = (x_sim - x_rtk)[valid]
        dy = (y_sim - y_rtk)[valid]
        rmse = float(np.sqrt(np.mean(dx**2 + dy**2)))

        return rmse

    # Initial guess
    x0 = [
        config.wheelbase_m if config.optimize_wheelbase else 2.7,
        config.speed_scale if config.optimize_speed_scale else 1.0,
        config.steer_scale if config.optimize_steer_scale else 1.0,
    ]

    # Bounds
    bounds = [
        (1.5, 4.0) if config.optimize_wheelbase else (config.wheelbase_m, config.wheelbase_m),
        (0.5, 1.5) if config.optimize_speed_scale else (config.speed_scale, config.speed_scale),
        (0.5, 1.5) if config.optimize_steer_scale else (config.steer_scale, config.steer_scale),
    ]

    # Optimize
    try:
        result = minimize(
            objective,
            x0,
            method='L-BFGS-B',
            bounds=bounds,
            options={'maxiter': 50, 'ftol': 1e-4},
        )

        if result.success:
            wheelbase_opt, speed_scale_opt, steer_scale_opt = result.x

            # Update config
            optimized_config = OptimizedDTConfig(
                wheelbase_m=float(wheelbase_opt),
                speed_scale=float(speed_scale_opt),
                steer_scale=float(steer_scale_opt),
                calibrate_params=False,  # Already calibrated
                use_position_reset=config.use_position_reset,
                reset_interval_steps=config.reset_interval_steps,
                use_multi_sample_init=config.use_multi_sample_init,
                init_samples=config.init_samples,
            )

            return optimized_config
    except Exception:
        pass

    return config


def evaluate_optimized_simulation(
    aligned_df: pd.DataFrame,
    sim_df: pd.DataFrame,
) -> Tuple[Dict[str, Any], Optional[pd.DataFrame]]:
    """Evaluate optimized simulation against RTK (same metrics as basic simulator).

    Args:
        aligned_df: Original DataFrame with RTK data
        sim_df: Simulated DataFrame with x_sim_m, y_sim_m

    Returns:
        metrics dict, trajectory DataFrame
    """
    # Use the same evaluation as basic simulator
    from .simulator import evaluate_simulation

    metrics, traj = evaluate_simulation(aligned_df, sim_df)

    # Add reset count if available
    if 'reset_count' in sim_df.attrs:
        metrics['reset_count'] = sim_df.attrs['reset_count']

    return metrics, traj


def simulate_and_evaluate_optimized(
    df: pd.DataFrame,
    hz: float,
    config: Optional[OptimizedDTConfig] = None,
) -> Tuple[pd.DataFrame, Dict[str, Any], Optional[pd.DataFrame]]:
    """Complete pipeline: calibrate, simulate, evaluate.

    Args:
        df: DataFrame with steer_angle, speed, lat, lng
        hz: Sample rate
        config: Configuration (uses defaults if None)

    Returns:
        sim_df, metrics, trajectory
    """
    if config is None:
        config = OptimizedDTConfig()

    # Step 1: Calibrate parameters if requested
    if config.calibrate_params:
        config = calibrate_parameters(df, hz, config)

    # Step 2: Simulate with optimized parameters
    if config.use_position_reset:
        sim_df = simulate_with_reset(df, hz, config)
    else:
        sim_df = simulate_kinematic_bicycle_optimized(df, hz, config)

    # Step 3: Evaluate
    metrics, traj = evaluate_optimized_simulation(df, sim_df)

    # Add config to metrics
    metrics['config'] = {
        'wheelbase_m': config.wheelbase_m,
        'speed_scale': config.speed_scale,
        'steer_scale': config.steer_scale,
        'use_position_reset': config.use_position_reset,
        'reset_interval_steps': config.reset_interval_steps,
    }

    return sim_df, metrics, traj
