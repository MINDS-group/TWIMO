from __future__ import annotations

from dataclasses import dataclass
from pathlib import Path
from typing import Dict, Tuple

import numpy as np
import pandas as pd


@dataclass
class SensorStreams:
    """Raw sensor streams loaded from CSVs."""

    steer: pd.DataFrame
    accel: pd.DataFrame
    brake: pd.DataFrame
    turn_signal: pd.DataFrame
    vel: pd.DataFrame
    yaw: pd.DataFrame
    rtk_pos: pd.DataFrame
    rtk_track: pd.DataFrame


def _read_csv(path: Path) -> pd.DataFrame:
    df = pd.read_csv(path)
    # HDD style: first column is timestamp (Unix seconds)
    # but we don't assume the name. We try common ones.
    ts_col = None
    for c in ["timestamp", "unix_timestamp", "time", "t"]:
        if c in df.columns:
            ts_col = c
            break
    if ts_col is None:
        # fallback: first column
        ts_col = df.columns[0]
    df = df.rename(columns={ts_col: "timestamp"})
    df = df.sort_values("timestamp")
    return df


def load_sensor_streams(csv_dir: Path) -> SensorStreams:
    csv_dir = Path(csv_dir)
    return SensorStreams(
        steer=_read_csv(csv_dir / "steer.csv"),
        accel=_read_csv(csv_dir / "accel_pedal.csv"),
        brake=_read_csv(csv_dir / "brake_pedal.csv"),
        turn_signal=_read_csv(csv_dir / "turn_signal.csv"),
        vel=_read_csv(csv_dir / "vel.csv"),
        yaw=_read_csv(csv_dir / "yaw.csv"),
        rtk_pos=_read_csv(csv_dir / "rtk_pos.csv"),
        rtk_track=_read_csv(csv_dir / "rtk_track.csv"),
    )


def resample_streams(streams: SensorStreams, sample_hz: float) -> Tuple[np.ndarray, np.ndarray]:
    """Resample key signals to a uniform grid.

    Returns
      t: shape (T,) timestamps (seconds)
      x: shape (T, D) where D=8: [steer_angle, steer_speed, accel_pedal, brake_pedal, lturn, rturn, vel, yaw_rate]

    Notes
    - Turn signals are treated as step-wise categorical (nearest).
    - Continuous signals are interpolated.
    """
    # choose a shared interval based on steer (usually highest freq)
    t0 = float(streams.steer.timestamp.iloc[0])
    t1 = float(streams.steer.timestamp.iloc[-1])
    dt = 1.0 / float(sample_hz)
    grid = np.arange(t0, t1, dt, dtype=np.float64)

    def interp(df: pd.DataFrame, col: str) -> np.ndarray:
        s = df[["timestamp", col]].dropna()
        return np.interp(grid, s.timestamp.to_numpy(), s[col].to_numpy()).astype(np.float32)

    def nearest(df: pd.DataFrame, col: str) -> np.ndarray:
        s = df[["timestamp", col]].dropna()
        ts = s.timestamp.to_numpy()
        vals = s[col].to_numpy()
        idx = np.searchsorted(ts, grid, side="left")
        idx = np.clip(idx, 0, len(ts) - 1)
        return vals[idx].astype(np.float32)

    steer_angle = interp(streams.steer, "steer_angle") if "steer_angle" in streams.steer.columns else interp(streams.steer, streams.steer.columns[1])
    steer_speed = interp(streams.steer, "steer_speed") if "steer_speed" in streams.steer.columns else interp(streams.steer, streams.steer.columns[2])

    accel = interp(streams.accel, "pedalangle") if "pedalangle" in streams.accel.columns else interp(streams.accel, streams.accel.columns[1])
    brake = interp(streams.brake, "pedalpressure") if "pedalpressure" in streams.brake.columns else interp(streams.brake, streams.brake.columns[1])

    lturn = nearest(streams.turn_signal, "lturn") if "lturn" in streams.turn_signal.columns else nearest(streams.turn_signal, streams.turn_signal.columns[1])
    rturn = nearest(streams.turn_signal, "rturn") if "rturn" in streams.turn_signal.columns else nearest(streams.turn_signal, streams.turn_signal.columns[2])

    vel = interp(streams.vel, "vel") if "vel" in streams.vel.columns else interp(streams.vel, streams.vel.columns[1])
    yaw_rate = interp(streams.yaw, "yaw") if "yaw" in streams.yaw.columns else interp(streams.yaw, streams.yaw.columns[1])

    x = np.stack([steer_angle, steer_speed, accel, brake, lturn, rturn, vel, yaw_rate], axis=1)
    return grid.astype(np.float64), x


def derive_synthetic_action_labels(t: np.ndarray, x: np.ndarray) -> np.ndarray:
    """Create simple maneuver labels from signals.

    This is ONLY for the CSV-only quickstart where precomputed HDD target arrays are not available.

    Labels:
      0: keep_lane
      1: turn_left
      2: turn_right
      3: brake
      4: accelerate
      5: stop

    The logic is intentionally simple and deterministic.
    """
    steer = x[:, 0]
    steer_speed = x[:, 1]
    accel = x[:, 2]
    brake = x[:, 3]
    vel = x[:, 6]

    y = np.zeros(len(t), dtype=np.int64)
    # turns
    y[steer < -5.0] = 1
    y[steer > 5.0] = 2
    # braking and acceleration
    y[brake > 20.0] = 3
    y[accel > 20.0] = 4
    # stop overrides
    y[vel < 0.3] = 5
    return y
