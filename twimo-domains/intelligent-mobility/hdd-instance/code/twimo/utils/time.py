from __future__ import annotations

from dataclasses import dataclass
from datetime import datetime
from typing import Optional


def parse_video_start_from_filename(filename: str) -> Optional[datetime]:
    """Parse HDD-style filenames like '2017-02-27-10-17-27_new_0.75.mp4'.

    Returns naive datetime if parse succeeds, else None.
    """
    base = filename.rsplit('/', 1)[-1].rsplit('\\', 1)[-1]
    parts = base.split('_', 1)[0].split('-')
    if len(parts) < 6:
        return None
    try:
        y, mo, d, hh, mm, ss = map(int, parts[:6])
        return datetime(y, mo, d, hh, mm, ss)
    except Exception:
        return None
