from __future__ import annotations

import subprocess
from dataclasses import dataclass
from pathlib import Path
from typing import Generator, Optional

import numpy as np


@dataclass
class FFMpegFrames:
    frames: np.ndarray  # (T, H, W, 3) uint8
    fps: float
    width: int
    height: int


def iter_frames_ffmpeg(
    video_path: Path,
    fps: float,
    size: int = 224,
    batch_size: int = 128,
    max_frames: Optional[int] = None,
) -> Generator[np.ndarray, None, None]:
    """Stream-sample frames using ffmpeg and yield batches as numpy arrays.

    Yields:
      batch: (B, size, size, 3) uint8

    This avoids loading the whole video in memory (important for long HDD sessions).
    """
    video_path = video_path.expanduser().resolve()
    vf = f"fps={fps},scale={size}:{size}"
    cmd = [
        "ffmpeg",
        "-hide_banner",
        "-loglevel",
        "error",
        "-i",
        str(video_path),
        "-vf",
        vf,
        "-f",
        "rawvideo",
        "-pix_fmt",
        "rgb24",
        "pipe:1",
    ]

    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    assert p.stdout is not None

    frame_size = size * size * 3
    buf_list = []
    n = 0
    try:
        while True:
            if max_frames is not None and n >= int(max_frames):
                break
            buf = p.stdout.read(frame_size)
            if not buf or len(buf) < frame_size:
                break
            buf_list.append(np.frombuffer(buf, dtype=np.uint8))
            n += 1
            if len(buf_list) >= int(batch_size):
                batch = np.stack(buf_list, axis=0).reshape(-1, size, size, 3)
                yield batch
                buf_list.clear()
    finally:
        try:
            p.stdout.close()
        except Exception:
            pass
        p.terminate()

    if buf_list:
        batch = np.stack(buf_list, axis=0).reshape(-1, size, size, 3)
        yield batch


def read_frames_ffmpeg(
    video_path: Path,
    fps: float,
    size: int = 224,
    max_frames: Optional[int] = None,
) -> FFMpegFrames:
    """Fast frame sampling using ffmpeg -> rawvideo pipe.

    Works well on HDD where videos are long: sample low fps (e.g., 3-5).
    """
    video_path = video_path.expanduser().resolve()
    vf = f"fps={fps},scale={size}:{size}"
    cmd = [
        "ffmpeg",
        "-hide_banner",
        "-loglevel",
        "error",
        "-i",
        str(video_path),
        "-vf",
        vf,
        "-f",
        "rawvideo",
        "-pix_fmt",
        "rgb24",
        "pipe:1",
    ]

    # Convenience wrapper when you *do* want everything in memory.
    batches = list(iter_frames_ffmpeg(video_path, fps=fps, size=size, batch_size=1024, max_frames=max_frames))
    if not batches:
        raise RuntimeError(f"No frames decoded from {video_path}. Is ffmpeg installed?")
    frames = np.concatenate(batches, axis=0)
    return FFMpegFrames(frames=frames, fps=float(fps), width=size, height=size)
