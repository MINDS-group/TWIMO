from __future__ import annotations

from dataclasses import dataclass
from pathlib import Path
from typing import Optional


@dataclass(frozen=True)
class SessionRecord:
    """One driving session (a run) discovered by `scan` and stored in the manifest."""

    session_id: str
    day_id: str
    csv_dir: Path
    video_path: Optional[Path] = None

    # Optional HDD prealigned data (same sampling freq across modalities)
    prealigned_sensor_npy: Optional[Path] = None
    prealigned_target_npy: Optional[Path] = None

    # Optional cached video features
    video_feature_npy: Optional[Path] = None

    @staticmethod
    def from_json(d: dict) -> "SessionRecord":
        # Resolve video_path: use explicit video_path, or find .mp4 in video_dir
        video_path = None
        if d.get("video_path"):
            video_path = Path(d["video_path"])
        elif d.get("video_dir"):
            vdir = Path(d["video_dir"])
            if vdir.is_dir():
                mp4s = list(vdir.glob("*.mp4"))
                if mp4s:
                    video_path = mp4s[0]

        return SessionRecord(
            session_id=str(d["session_id"]),
            day_id=str(d.get("day_id") or d.get("scenario", "unknown")),
            csv_dir=Path(d["csv_dir"]),
            video_path=video_path,
            prealigned_sensor_npy=Path(d["prealigned_sensor_npy"]) if d.get("prealigned_sensor_npy") else None,
            prealigned_target_npy=Path(d["prealigned_target_npy"]) if d.get("prealigned_target_npy") else None,
            video_feature_npy=Path(d["video_feature_npy"]) if d.get("video_feature_npy") else None,
        )

    def to_json(self) -> dict:
        return {
            "session_id": self.session_id,
            "day_id": self.day_id,
            "csv_dir": str(self.csv_dir),
            "video_path": str(self.video_path) if self.video_path else None,
            "prealigned_sensor_npy": str(self.prealigned_sensor_npy) if self.prealigned_sensor_npy else None,
            "prealigned_target_npy": str(self.prealigned_target_npy) if self.prealigned_target_npy else None,
            "video_feature_npy": str(self.video_feature_npy) if self.video_feature_npy else None,
        }
