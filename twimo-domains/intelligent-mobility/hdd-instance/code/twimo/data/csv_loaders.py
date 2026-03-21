from __future__ import annotations
from dataclasses import dataclass
from pathlib import Path
from typing import Dict, Optional, Tuple
import zipfile
import pandas as pd
import numpy as np

SENSOR_FILES = {
    "steer": ("steer.csv", ["steer_angle", "steer_speed"]),
    "accel": ("accel_pedal.csv", ["pedalangle(percent)"]),
    "brake": ("brake_pedal.csv", ["pedalpressure(kPa)"]),
    "turn": ("turn_signal.csv", ["lturn", "rturn"]),
    "vel": ("vel.csv", ["speed"]),
    "yaw": ("yaw.csv", ["yaw(degree/s)"]),
    "rtk_pos": ("rtk_pos.csv", ["lng", "lat"]),
    "rtk_track": ("rtk_track.csv", ["GPS_course", "GPS_Yaw(heading)", "GPS_Pitch", "GPS_Roll"]),
}

def _standardize_columns(df: pd.DataFrame) -> pd.DataFrame:
    # normalize timestamp column
    cols = list(df.columns)
    if "# unix_timestamp" in cols:
        df = df.rename(columns={"# unix_timestamp": "unix_timestamp"})
    elif "unix_timestamp" not in cols:
        # try to find a timestamp-like column
        for c in cols:
            if "unix" in c and "timestamp" in c:
                df = df.rename(columns={c: "unix_timestamp"})
                break
    return df

def _read_csv_maybe_zip(csv_dir_or_general: Path, filename: str) -> pd.DataFrame:
    """
    Read <general>/csv/<filename> or <general>/csv.zip (containing csv/<filename>).
    """
    csv_dir = csv_dir_or_general
    # If the provided dir is ".../general", expect ".../general/csv" or ".../general/csv.zip"
    if csv_dir.name == "general":
        if (csv_dir / "csv" / filename).exists():
            csv_dir = csv_dir / "csv"

    direct = csv_dir / filename
    if direct.exists():
        df = pd.read_csv(direct)
        return _standardize_columns(df)

    zip_path = (csv_dir / "csv.zip") if csv_dir.name == "general" else (csv_dir.parent / "csv.zip")
    if zip_path.exists():
        with zipfile.ZipFile(zip_path, "r") as z:
            # typical path inside zip: csv/<filename>
            inner = f"csv/{filename}"
            with z.open(inner) as f:
                df = pd.read_csv(f)
                return _standardize_columns(df)

    raise FileNotFoundError(f"Could not find {filename} in {csv_dir_or_general}")

def load_run_sensors(general_or_csv_dir: Path) -> Dict[str, pd.DataFrame]:
    """
    Returns a dict sensor_name -> dataframe with unix_timestamp and sensor columns.
    """
    out: Dict[str, pd.DataFrame] = {}
    base = general_or_csv_dir
    for key, (fname, cols) in SENSOR_FILES.items():
        try:
            df = _read_csv_maybe_zip(base, fname)
        except FileNotFoundError:
            continue

        # keep only needed columns + unix_timestamp
        keep = ["unix_timestamp"] + [c for c in cols if c in df.columns]
        df = df[keep].copy()
        df["unix_timestamp"] = df["unix_timestamp"].astype(float)

        # Sort for merge_asof
        df = df.sort_values("unix_timestamp")
        out[key] = df
    return out

def align_sensors_to_grid(sensors: Dict[str, pd.DataFrame], hz: float = 10.0) -> pd.DataFrame:
    """
    Merge all sensors on a uniform time grid using merge_asof.
    """
    # pick a reference timeline (vel if present, else steer, else any)
    if "vel" in sensors:
        ref = sensors["vel"][["unix_timestamp"]].copy()
    elif "steer" in sensors:
        ref = sensors["steer"][["unix_timestamp"]].copy()
    else:
        any_key = next(iter(sensors.keys()))
        ref = sensors[any_key][["unix_timestamp"]].copy()

    t0, t1 = float(ref["unix_timestamp"].min()), float(ref["unix_timestamp"].max())
    if t1 <= t0:
        t1 = t0 + 1.0

    step = 1.0 / float(hz)
    grid = np.arange(t0, t1 + 1e-9, step, dtype=float)
    df = pd.DataFrame({"unix_timestamp": grid})

    for key, sdf in sensors.items():
        # merge_asof requires sorted
        sdf = sdf.sort_values("unix_timestamp")
        df = pd.merge_asof(df, sdf, on="unix_timestamp", direction="nearest", tolerance=step/2)

    # fix GPS lat/lon swap if needed
    if "lat" in df.columns and "lng" in df.columns:
        lat = df["lat"].astype(float)
        lng = df["lng"].astype(float)
        # if lat values look like longitude (abs > 90), swap
        swap_mask = lat.abs() > 90
        if swap_mask.any():
            df.loc[:, ["lat", "lng"]] = df.loc[:, ["lng", "lat"]].values

    return df
