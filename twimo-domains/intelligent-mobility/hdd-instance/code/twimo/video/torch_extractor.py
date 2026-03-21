from __future__ import annotations

from dataclasses import dataclass
from pathlib import Path
from typing import Literal, Optional

import numpy as np


@dataclass
class VideoFeatures:
    features: np.ndarray  # (T, F)
    fps: float


def _torch_available() -> bool:
    try:
        import torch  # noqa
        import torchvision  # noqa
        return True
    except Exception:
        return False


def extract_video_features_torch(
    video_path: Path,
    fps: float = 3.0,
    backbone: Literal["mobilenet_v3_small", "resnet18"] = "mobilenet_v3_small",
    batch_size: int = 64,
    cache_path: Optional[Path] = None,
    max_frames: Optional[int] = None,
    log_every: Optional[int] = 1000,
) -> VideoFeatures:
    """Extract per-frame embeddings from a video using torchvision pretrained models.

    - Uses ffmpeg for fast sampling and resizing.
    - Batches frames on GPU if available.
    - Saves/loads .npy cache if cache_path is provided.

    This is the recommended path for HDD-scale videos: low fps + caching.
    """
    # 0) Cache load (supports both TWIMO naming and a legacy naming)
    candidate_cache_paths = []
    if cache_path is not None:
        candidate_cache_paths.append(cache_path)
        # Legacy pipelines sometimes save <session_id>.npy next to the desired cache
        candidate_cache_paths.append(cache_path.parent / f"{cache_path.stem.replace('rgb_', '')}.npy")

    for cp in candidate_cache_paths:
        if cp is not None and cp.exists():
            arr = np.load(cp)
            # Some pipelines store spatial feature maps (T,H,W,C); pool to (T,C)
            if arr.ndim == 4:
                arr = arr.mean(axis=(1, 2))
            if arr.ndim != 2:
                raise ValueError(f"Unsupported cached video feature shape {arr.shape} in {cp}")
            return VideoFeatures(features=arr.astype(np.float32, copy=False), fps=fps)

    if not _torch_available():
        raise RuntimeError(
            "Torch/Torchvision not available. Install them or run without --use-video."
        )

    import torch
    import torch.nn as nn
    import torchvision

    from twimo.video.ffmpeg_reader import iter_frames_ffmpeg

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

    if backbone == "mobilenet_v3_small":
        m = torchvision.models.mobilenet_v3_small(weights=torchvision.models.MobileNet_V3_Small_Weights.DEFAULT)
        feat = nn.Sequential(m.features, nn.AdaptiveAvgPool2d(1), nn.Flatten())
    elif backbone == "resnet18":
        m = torchvision.models.resnet18(weights=torchvision.models.ResNet18_Weights.DEFAULT)
        feat = nn.Sequential(*list(m.children())[:-1], nn.Flatten())
    else:
        raise ValueError(f"Unknown backbone: {backbone}")

    feat = feat.to(device).eval()

    # Normalize with ImageNet stats (move to device once)
    mean = torch.tensor([0.485, 0.456, 0.406], device=device).view(1, 3, 1, 1)
    std = torch.tensor([0.229, 0.224, 0.225], device=device).view(1, 3, 1, 1)

    outs = []
    n_frames = 0
    with torch.no_grad():
        for batch in iter_frames_ffmpeg(video_path, fps=fps, size=224, batch_size=batch_size, max_frames=max_frames):
            # (B,224,224,3) uint8 -> (B,3,224,224) float
            xb = torch.from_numpy(batch).permute(0, 3, 1, 2).to(device).float() / 255.0
            xb = (xb - mean) / std
            yb = feat(xb)
            outs.append(yb.detach().cpu().numpy().astype(np.float16))
            n_frames += batch.shape[0]
            if log_every is not None and n_frames % int(log_every) < batch.shape[0]:
                print(f"[video] processed {n_frames} frames from {video_path.name} (fps={fps})")

    if n_frames == 0:
        arr = np.zeros((0, 1), dtype=np.float32)
    else:
        arr = np.concatenate(outs, axis=0)
    if cache_path is not None:
        cache_path.parent.mkdir(parents=True, exist_ok=True)
        np.save(cache_path, arr)

    return VideoFeatures(features=arr, fps=fps)
