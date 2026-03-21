from __future__ import annotations

from pathlib import Path
from typing import Iterator, Optional

from twimo.data.manifest import SessionRecord


def scan_csv_bundle(root: Path, session_id: Optional[str] = None) -> Iterator[SessionRecord]:
    """Create a single SessionRecord for a directory containing a CSV bundle.

    This is the "CSV-only" fallback used by the Quickstart under example_data/.
    The directory is expected to contain one or more *.csv files.

    Targets/labels are optional: if no labels are present, TWIMO will generate
    proxy targets from the sensors (see twimo/data/proxy_targets.py).
    """

    root = Path(root)
    if not root.is_dir():
        return

    # Common layout for the included example: <root>/csv/*.csv
    csv_root = root / 'csv' if (root / 'csv').is_dir() else root

    csvs = sorted(csv_root.glob('*.csv'))
    if len(csvs) == 0:
        return

    sid = session_id or root.name
    yield SessionRecord(
        session_id=sid,
        day_id='csv',
        csv_dir=str(csv_root),
        video_path=None,
        prealigned_sensor_npy=None,
        prealigned_target_npy=None,
    )
