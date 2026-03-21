from __future__ import annotations

from dataclasses import dataclass
from pathlib import Path
from typing import Any, Dict, Iterable, Iterator, Optional

from twimo.utils.io import read_jsonl, write_jsonl


@dataclass
class SessionRecord:
    session_id: str
    day_id: Optional[str]
    csv_dir: Optional[str]
    video_path: Optional[str]
    # Optional pre-aligned arrays (HDD pre-processing)
    prealigned_sensor_npy: Optional[str] = None
    prealigned_target_npy: Optional[str] = None

    def to_json(self) -> Dict[str, Any]:
        return {
            "session_id": self.session_id,
            "day_id": self.day_id,
            "csv_dir": self.csv_dir,
            "video_path": self.video_path,
            "prealigned_sensor_npy": self.prealigned_sensor_npy,
            "prealigned_target_npy": self.prealigned_target_npy,
        }

    @staticmethod
    def from_json(d: Dict[str, Any]) -> "SessionRecord":
        # Resolve video_path: use explicit video_path, or find .mp4 in video_dir
        video_path = d.get("video_path")
        if not video_path and d.get("video_dir"):
            vdir = Path(d["video_dir"])
            if vdir.is_dir():
                mp4s = list(vdir.glob("*.mp4"))
                if mp4s:
                    video_path = str(mp4s[0])

        return SessionRecord(
            session_id=str(d.get("session_id")),
            day_id=d.get("day_id") or d.get("scenario"),
            csv_dir=d.get("csv_dir"),
            video_path=video_path,
            prealigned_sensor_npy=d.get("prealigned_sensor_npy"),
            prealigned_target_npy=d.get("prealigned_target_npy"),
        )


def load_manifest(path: Path) -> list[SessionRecord]:
    return [SessionRecord.from_json(r) for r in read_jsonl(path)]


def save_manifest(path: Path, records: Iterable[SessionRecord]) -> None:
    write_jsonl(path, [r.to_json() for r in records])


# Alias for backwards compatibility
write_manifest = save_manifest
