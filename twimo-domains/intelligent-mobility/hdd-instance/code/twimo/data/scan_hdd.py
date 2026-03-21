from __future__ import annotations

import re
from pathlib import Path
from typing import Dict, Iterator, Optional

from twimo.data.manifest import SessionRecord


RE_SESSION_ID = re.compile(r"^\d{12}$")


def _find_csv_dir(session_dir: Path) -> Optional[Path]:
    # HDD layout: <session>/general/csv/*.csv
    cand = session_dir / 'general' / 'csv'
    if cand.exists() and any(cand.glob('*.csv')):
        return cand
    # fallback: sometimes present directly
    if any(session_dir.glob('*.csv')):
        return session_dir
    return None


def _find_video(session_dir: Path) -> Optional[Path]:
    # HDD layout: <session>/camera/center/*.mp4
    center = session_dir / 'camera' / 'center'
    if center.exists():
        mp4s = sorted(center.glob('*.mp4'))
        if mp4s:
            return mp4s[0]
    # fallback: any mp4
    mp4s = sorted(session_dir.rglob('*.mp4'))
    return mp4s[0] if mp4s else None


def scan_hdd_release(
    root: Path,
    prealigned_labels_dir: Optional[Path] = None,
    prealigned_sensors_dir: Optional[Path] = None,
) -> Iterator[SessionRecord]:
    """Scan a Honda HDD-like release folder and yield SessionRecord.

    Expected structure (example):
      <root>/<DAY_ID>/<SESSION_ID>/general/csv/*.csv
      <root>/<DAY_ID>/<SESSION_ID>/camera/center/*.mp4

    Where DAY_ID can be '2017_02_27_ITS1', SESSION_ID can be '201702271017'.

    If *prealigned* dirs are provided (containing <SESSION_ID>.npy files),
    records will link those arrays when available.
    """
    root = root.expanduser().resolve()

    for day_dir in sorted([p for p in root.iterdir() if p.is_dir()]):
        day_id = day_dir.name
        for session_dir in sorted([p for p in day_dir.iterdir() if p.is_dir()]):
            if not RE_SESSION_ID.match(session_dir.name):
                continue
            session_id = session_dir.name

            csv_dir = _find_csv_dir(session_dir)
            video = _find_video(session_dir)

            pre_s = None
            pre_t = None
            if prealigned_sensors_dir is not None:
                cand = prealigned_sensors_dir / f"{session_id}.npy"
                if cand.exists():
                    pre_s = str(cand)
            if prealigned_labels_dir is not None:
                cand = prealigned_labels_dir / f"{session_id}.npy"
                if cand.exists():
                    pre_t = str(cand)

            yield SessionRecord(
                session_id=session_id,
                day_id=day_id,
                csv_dir=str(csv_dir) if csv_dir else None,
                video_path=str(video) if video else None,
                prealigned_sensor_npy=pre_s,
                prealigned_target_npy=pre_t,
            )
