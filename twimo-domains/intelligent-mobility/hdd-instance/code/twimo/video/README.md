# twimo.video

This package implements the **PerceptionService** part of TWIMO for the HDD use case.

## Fast video feature extraction

Video fusion is optional and enabled via:

```bash
python -m twimo.cli train-maneuver --use-video --video-extractor mobilenet_v3_small
```

The pipeline:

1. Uses **ffmpeg** to decode and resize frames efficiently.
2. Samples frames at a low FPS (default: equals `--sample-hz`, recommended: 3 Hz).
3. Runs a **torchvision pretrained backbone** (MobileNetV3 or ResNet18) on batches of frames.
4. Writes a cache file per session: `video_cache/rgb_<SESSION_ID>.npy`.

After the first run, training becomes much faster because cached features are reused.

## Requirements

- `ffmpeg` must be available on PATH.
- `torch` + `torchvision`.
