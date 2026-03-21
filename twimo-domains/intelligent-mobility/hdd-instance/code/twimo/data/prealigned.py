from __future__ import annotations

from dataclasses import dataclass
from pathlib import Path
from typing import Optional, Tuple

import numpy as np


@dataclass
class PrealignedSession:
    session_id: str
    sensor: np.ndarray  # (T, D)
    target: np.ndarray  # (T,)


def load_prealigned(sensor_npy: Path, target_npy: Path) -> PrealignedSession:
    sid = sensor_npy.stem
    if target_npy.stem != sid:
        # Still allow, but keep sensor stem as session_id
        pass
    sensor = np.load(sensor_npy)
    target = np.load(target_npy)
    if sensor.ndim != 2:
        raise ValueError(f"Expected sensor to be 2D (T,D). Got {sensor.shape}")
    if target.ndim != 1:
        raise ValueError(f"Expected target to be 1D (T,). Got {target.shape}")
    T = min(sensor.shape[0], target.shape[0])
    return PrealignedSession(session_id=sid, sensor=sensor[:T], target=target[:T])


def maybe_load_prealigned(sensor_npy: Optional[str], target_npy: Optional[str]) -> Optional[PrealignedSession]:
    if not sensor_npy or not target_npy:
        return None
    p1 = Path(sensor_npy)
    p2 = Path(target_npy)
    if not p1.exists() or not p2.exists():
        return None
    return load_prealigned(p1, p2)
