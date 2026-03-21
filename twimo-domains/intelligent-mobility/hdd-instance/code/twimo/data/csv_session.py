from __future__ import annotations

import re
import numpy as np
import pandas as pd
from pathlib import Path
from typing import Dict, List, Tuple

# Columns we use for driver behavior modeling
# Column names must match the *normalized* CSV headers (after stripping units).
SENSOR_SPECS = {
    "steer": ("steer_angle", "steer_speed"),
    "accel_pedal": ("pedalangle",),
    "brake_pedal": ("pedalpressure",),
    "vel": ("speed",),
    "yaw": ("yaw",),
    "turn_signal": ("lturn", "rturn"),
}


def _norm_col(c: str) -> str:
    """Normalize CSV column name: strip '#', whitespace, and unit suffixes like (percent), (kPa)."""
    s = str(c).strip().lstrip('#').strip()
    # Remove unit suffixes in parentheses, e.g. "pedalangle(percent)" → "pedalangle"
    s = re.sub(r'\(.*?\)', '', s).strip()
    return s


def _read_csv(path: Path, desired_cols: Tuple[str, ...]) -> pd.DataFrame:
    """Read only the columns we need.

    The sample CSVs in this repo can be relatively large; loading only the
    timestamp + a handful of channels makes the quickstart much faster.
    """
    # Header-only read (cheap) to determine the timestamp column name.
    header = pd.read_csv(path, nrows=0)
    orig_cols = list(header.columns)
    norm_cols = [_norm_col(c) for c in orig_cols]

    ts_candidates = {"timestamp", "unix_timestamp", "time", "t"}
    ts_norm = None
    for o, n in zip(orig_cols, norm_cols):
        if n in ts_candidates:
            ts_norm = n
            break
    if ts_norm is None:
        raise ValueError(f"No timestamp column found in {path.name}")

    keep_norm = {ts_norm, *desired_cols}
    keep_orig = [o for o, n in zip(orig_cols, norm_cols) if n in keep_norm]

    df = pd.read_csv(path, usecols=keep_orig)
    df.columns = [_norm_col(c) for c in df.columns]
    # Normalize to 't'
    if ts_norm != "t":
        df = df.rename(columns={ts_norm: "t"})

    df = df.sort_values("t")
    return df


def load_sensors_from_csv_dir(csv_dir: Path) -> Dict[str, pd.DataFrame]:
    csv_dir = csv_dir.expanduser().resolve()
    out: Dict[str, pd.DataFrame] = {}
    for name in SENSOR_SPECS.keys():
        p = csv_dir / f"{name}.csv"
        if p.exists():
            out[name] = _read_csv(p, SENSOR_SPECS.get(name, tuple()))
    if not out:
        raise FileNotFoundError(f"No known sensor CSVs found in {csv_dir}")
    return out


def resample_sensors(
    sensor_frames: Dict[str, pd.DataFrame],
    sample_hz: float,
    t0: float | None = None,
    t1: float | None = None,
) -> Tuple[np.ndarray, np.ndarray, List[str]]:
    """Resample heterogeneous sensor csvs to a common uniform grid.

    Returns:
      t_grid: shape (T,), seconds
      X: shape (T, D)
      feature_names: list of length D

    Notes:
      - numeric channels: linear interpolation
      - binary channels (turn signals): nearest neighbor
    """
    # Build global time bounds
    all_ts = []
    for df in sensor_frames.values():
        all_ts.append(df["t"].to_numpy())
    t_min = float(min(ts[0] for ts in all_ts))
    t_max = float(max(ts[-1] for ts in all_ts))

    if t0 is not None:
        t_min = max(t_min, float(t0))
    if t1 is not None:
        t_max = min(t_max, float(t1))

    dt = 1.0 / float(sample_hz)
    # Include end by small epsilon
    t_grid = np.arange(t_min, t_max + 0.5 * dt, dt, dtype=np.float64)

    cols = []
    names: List[str] = []

    for sensor_name, df in sensor_frames.items():
        spec_cols = SENSOR_SPECS.get(sensor_name, tuple())
        for c in spec_cols:
            if c not in df.columns:
                continue
            t = df["t"].to_numpy(dtype=np.float64)
            y = df[c].to_numpy(dtype=np.float64)
            if sensor_name == "turn_signal":
                # nearest neighbor
                idx = np.searchsorted(t, t_grid, side='left')
                idx = np.clip(idx, 0, len(t)-1)
                y_grid = y[idx]
            else:
                # linear interp
                y_grid = np.interp(t_grid, t, y)
            cols.append(y_grid.astype(np.float32))
            names.append(f"{sensor_name}.{c}")

    X = np.stack(cols, axis=1) if cols else np.empty((len(t_grid), 0), dtype=np.float32)
    # Return t_grid as float64: Unix timestamps from 2017 (~1.49e9) lose ~128 s
    # precision when cast to float32 (only 7 significant digits), making
    # sensor-to-video alignment completely wrong. X stays float32 for models.
    return t_grid, X, names


def derive_proxy_actions(X: np.ndarray, feature_names: List[str]) -> np.ndarray:
    """Create *proxy* maneuver labels from sensors only.

    This is used ONLY for the included CSV-only example so that training can run
    without precomputed HDD target arrays.

    Labels:
      0 STRAIGHT
      1 TURN_LEFT
      2 TURN_RIGHT
      3 BRAKE
      4 ACCEL
      5 STOP

    The rules are intentionally simple and conservative.
    """
    def col(name: str):
        try:
            return X[:, feature_names.index(name)]
        except ValueError:
            return None

    steer = col("steer.steer_angle")
    steer_speed = col("steer.steer_speed")
    accel = col("accel_pedal.pedalangle")
    brake = col("brake_pedal.pedalpressure")
    vel = col("vel.speed")

    T = X.shape[0]
    y = np.zeros((T,), dtype=np.int64)

    # Heuristic thresholds
    if vel is None:
        vel = np.zeros((T,), dtype=np.float32)
    if steer is None:
        steer = np.zeros((T,), dtype=np.float32)
    if accel is None:
        accel = np.zeros((T,), dtype=np.float32)
    if brake is None:
        brake = np.zeros((T,), dtype=np.float32)

    stop = vel < 0.5
    y[stop] = 5

    # Turn detection by steer angle
    left = steer < -3.0
    right = steer > 3.0
    y[left] = 1
    y[right] = 2

    # Brake / accel override if strong
    y[brake > 20.0] = 3
    y[accel > 20.0] = 4

    return y
