"""Generate prealigned sensor .npy arrays from CSV session data.

For each session in a manifest, reads the raw CSV signal files, resamples
them to a uniform grid at the requested frequency, and saves a (T, 8) array:

  [steer_angle, steer_speed, accel_pedal, brake_pedal, lturn, rturn, vel, yaw_rate]

Use this script when you do NOT have prealigned .npy files from the HDD
dataset (i.e. CSV-only mode) and need to feed the YOLO pipeline train step.

Usage
-----
python twimo/data/generate_sensor_npy.py \\
    --manifest ./artifacts/manifest.jsonl \\
    --outdir   ./artifacts/sensor_npy \\
    --sample-hz 3
"""
from __future__ import annotations

import argparse
import json
from pathlib import Path
import sys
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import numpy as np
import pandas as pd
from tqdm import tqdm

from twimo.utils.profiling import TrainingProfiler


def _read_csv(path: Path) -> pd.DataFrame:
    df = pd.read_csv(path)
    df = df.rename(columns={df.columns[0]: "timestamp"})
    for c in df.columns:
        if c != "timestamp":
            df[c] = pd.to_numeric(df[c], errors="coerce")
    return df.sort_values("timestamp").dropna(subset=["timestamp"])


def _interp(grid: np.ndarray, df: pd.DataFrame, col: str) -> np.ndarray:
    s = df[["timestamp", col]].dropna()
    return np.interp(
        grid, s.timestamp.to_numpy(float), s[col].to_numpy(float)
    ).astype(np.float32)


def _nearest(grid: np.ndarray, df: pd.DataFrame, col: str) -> np.ndarray:
    s = df[["timestamp", col]].dropna()
    ts = s.timestamp.to_numpy(float)
    vals = s[col].to_numpy(float)
    idx = np.clip(np.searchsorted(ts, grid), 0, len(ts) - 1)
    return vals[idx].astype(np.float32)


def _first_col(df: pd.DataFrame, *hints: str) -> str:
    """Return the first column whose name contains any of the hint substrings."""
    for hint in hints:
        for c in df.columns:
            if hint in c.lower():
                return c
    return [c for c in df.columns if c != "timestamp"][0]


def generate(manifest: Path, outdir: Path, sample_hz: float) -> None:
    outdir.mkdir(parents=True, exist_ok=True)

    records: list[dict] = []
    with open(manifest, encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if line:
                records.append(json.loads(line))

    base = manifest.parent.parent  # project root (two levels up from artifacts/)

    for r in tqdm(records, desc="sessions"):
        sid = r["session_id"]
        csv_dir = Path(r["csv_dir"])
        if not csv_dir.is_absolute():
            csv_dir = base / csv_dir

        try:
            steer  = _read_csv(csv_dir / "steer.csv")
            accel  = _read_csv(csv_dir / "accel_pedal.csv")
            brake  = _read_csv(csv_dir / "brake_pedal.csv")
            tsig   = _read_csv(csv_dir / "turn_signal.csv")
            vel_df = _read_csv(csv_dir / "vel.csv")
            yaw_df = _read_csv(csv_dir / "yaw.csv")
        except FileNotFoundError as e:
            print(f"  [SKIP] {sid}: {e}")
            continue

        t0   = float(steer.timestamp.iloc[0])
        t1   = float(steer.timestamp.iloc[-1])
        grid = np.arange(t0, t1, 1.0 / sample_hz, dtype=np.float64)

        accel_col = _first_col(accel,  "pedal", "angle")
        brake_col = _first_col(brake,  "pedal", "pressure")
        vel_col   = _first_col(vel_df, "vel",   "speed")
        yaw_col   = _first_col(yaw_df, "yaw",   "rate")

        X = np.stack([
            _interp(grid, steer,  "steer_angle"),
            _interp(grid, steer,  "steer_speed"),
            _interp(grid, accel,  accel_col),
            _interp(grid, brake,  brake_col),
            _nearest(grid, tsig,  "lturn"),
            _nearest(grid, tsig,  "rturn"),
            _interp(grid, vel_df, vel_col),
            _interp(grid, yaw_df, yaw_col),
        ], axis=1)  # (T, 8)

        out = outdir / f"{sid}.npy"
        np.save(out, X)
        tqdm.write(f"  {sid}: saved {out}  shape={X.shape}")

    print(f"\nDone. Arrays saved to {outdir}")


def main() -> None:
    parser = argparse.ArgumentParser(
        description="Generate (T, 8) sensor .npy arrays from CSV sessions."
    )
    parser.add_argument("--manifest",  required=True, type=Path,
                        help="Path to manifest.jsonl")
    parser.add_argument("--outdir",    required=True, type=Path,
                        help="Output directory for .npy files")
    parser.add_argument("--sample-hz", default=3.0, type=float,
                        help="Resampling frequency in Hz (default: 3)")
    args = parser.parse_args()
    args.outdir.mkdir(parents=True, exist_ok=True)
    with TrainingProfiler(model_name="generate_sensor_npy", output_dir=args.outdir, use_codecarbon=True):
        generate(args.manifest, args.outdir, args.sample_hz)


if __name__ == "__main__":
    main()
