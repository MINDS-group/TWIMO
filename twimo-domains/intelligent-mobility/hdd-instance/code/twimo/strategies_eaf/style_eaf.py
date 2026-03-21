#!/usr/bin/env python3
"""
Area-aware driving style clustering using prealigned sensors + EAF annotations.

Segments sensor data by EAF Area tier (downtown/freeway/tunnel), computes
driving style features per (session, area) pair, then clusters globally
into prudent / smooth / aggressive.

Usage:
    python style_eaf.py cluster \
        --sensor-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
        --eaf-parsed-dir ./eaf_parsed \
        --vocab-dir ./vocabs \
        --outdir ./artifacts/style_eaf \
        --k 3
"""
from __future__ import annotations

import argparse
import json
import sys
from collections import Counter
from dataclasses import asdict, dataclass
from pathlib import Path
from typing import Dict, List, Optional, Tuple

import numpy as np
from sklearn.cluster import KMeans

# ---------------------------------------------------------------------------
# Prealigned channel mapping (from sensor README)
# ---------------------------------------------------------------------------
PREALIGNED_CHANNELS = {
    0: "steer.steer_angle",
    1: "steer.steer_speed",
    2: "accel_pedal.pedalangle",
    3: "brake_pedal.pedalpressure",
    4: "vel.vel",
    5: "yaw.yaw",
    6: "turn_signal.lturn",
    7: "turn_signal.rturn",
}

AREA_NAMES = ["unknown", "downtown", "freeway", "tunnel"]

MIN_SEGMENT_FRAMES = 30  # minimum frames for a valid segment (~10s at 3Hz)


# ---------------------------------------------------------------------------
# Utilities (same patterns as two_stage_transformer.py)
# ---------------------------------------------------------------------------

def normalize_session_id(eaf_stem: str) -> str:
    """Convert '2017-02-27-10-17-27' -> '201702271017'."""
    parts = eaf_stem.replace("-", "")
    return parts[:12]


def load_area_vocab(vocab_dir: Path) -> Dict[str, int]:
    """Load area vocabulary, extending with tunnel if missing."""
    vocab_path = vocab_dir / "vocab_area.json"
    if not vocab_path.exists():
        return {"unknown": 0, "downtown": 1, "freeway": 2, "tunnel": 3}
    with open(vocab_path, encoding="utf-8") as f:
        data = json.load(f)
    vocab = dict(data["vocab"])
    if "tunnel" not in vocab:
        vocab["tunnel"] = max(vocab.values()) + 1
    return vocab


def load_area_label_map(vocab_dir: Path) -> Dict[str, str]:
    """Load area label map (Chinese -> English)."""
    vocab_path = vocab_dir / "vocab_area.json"
    if not vocab_path.exists():
        return {}
    with open(vocab_path, encoding="utf-8") as f:
        data = json.load(f)
    return data.get("label_map", {})


def map_annotations_to_timeline(
    annotations: List[dict],
    T: int,
    sample_hz: float,
    label_map: Dict[str, str],
    vocab: Dict[str, int],
) -> np.ndarray:
    """Map EAF tier annotations to integer label array of length T."""
    labels = np.zeros(T, dtype=np.int64)
    ms_per_step = 1000.0 / sample_hz

    for ann in annotations:
        start_ms = ann["start_ms"]
        end_ms = ann["end_ms"]
        label_raw = ann["label"].strip()

        mapped = label_map.get(label_raw)
        if mapped and mapped in vocab:
            label_idx = vocab[mapped]
        else:
            eng = " ".join(
                p for p in label_raw.split()
                if p.replace("-", "").replace("_", "").isascii()
            ).strip().lower().replace(" ", "_")
            label_idx = vocab.get(eng, 0)

        i_start = int(start_ms / ms_per_step)
        i_end = int(end_ms / ms_per_step)
        i_start = max(0, min(i_start, T))
        i_end = max(0, min(i_end, T))
        if i_start < i_end:
            labels[i_start:i_end] = label_idx

    return labels


# ---------------------------------------------------------------------------
# Style feature computation (adapted from twimo/models/style.py)
# ---------------------------------------------------------------------------

def compute_style_features(sensors: np.ndarray) -> Dict[str, float]:
    """Compute driving style features from prealigned sensor segment.

    Uses hardcoded channel mapping (PREALIGNED_CHANNELS).
    sensors: shape (N, D) where D >= 5.
    """
    D = sensors.shape[1]

    def ch(idx: int) -> Optional[np.ndarray]:
        return sensors[:, idx] if idx < D else None

    steer = ch(0)        # steer.steer_angle
    steer_speed = ch(1)  # steer.steer_speed
    accel = ch(2)        # accel_pedal.pedalangle
    brake = ch(3)        # brake_pedal.pedalpressure
    vel = ch(4)          # vel.vel

    out: Dict[str, float] = {}

    if accel is not None:
        out["accel_mean"] = float(np.mean(accel))
        out["accel_p95"] = float(np.percentile(accel, 95))
    if brake is not None:
        out["brake_mean"] = float(np.mean(brake))
        out["brake_p95"] = float(np.percentile(brake, 95))
    if steer is not None:
        out["steer_std"] = float(np.std(steer))
    if steer_speed is not None:
        out["steer_speed_p95"] = float(np.percentile(np.abs(steer_speed), 95))
    if vel is not None:
        out["vel_mean"] = float(np.mean(vel))
        out["vel_p95"] = float(np.percentile(vel, 95))

    # Aggressiveness score (same formula as style.py)
    out["aggr_score"] = float(
        0.0
        + out.get("accel_p95", 0.0) / 100.0
        + out.get("brake_p95", 0.0) / 200.0
        + out.get("steer_speed_p95", 0.0) / 50.0
        + out.get("vel_p95", 0.0) / 50.0
    )
    return out


# ---------------------------------------------------------------------------
# Clustering (same as twimo/models/style.py)
# ---------------------------------------------------------------------------

def cluster_styles(
    style_feats: List[Dict[str, float]], k: int = 3, seed: int = 7
) -> Tuple[np.ndarray, List[str], KMeans]:
    keys = sorted({key for d in style_feats for key in d.keys()})
    X = np.array(
        [[d.get(key, 0.0) for key in keys] for d in style_feats], dtype=np.float32
    )
    km = KMeans(n_clusters=k, random_state=seed, n_init="auto")
    c = km.fit_predict(X)
    return c, keys, km


def name_clusters(centroids: np.ndarray, keys: List[str]) -> Dict[int, str]:
    if "aggr_score" in keys:
        idx = keys.index("aggr_score")
        scores = centroids[:, idx]
        order = np.argsort(scores)
        n = len(order)
        mapping: Dict[int, str] = {}
        if n >= 3:
            mapping[int(order[0])] = "prudent"
            mapping[int(order[1])] = "smooth"
            mapping[int(order[2])] = "aggressive"
        elif n == 2:
            mapping[int(order[0])] = "prudent"
            mapping[int(order[1])] = "aggressive"
        else:
            mapping[int(order[0])] = "smooth"
        return mapping
    return {i: f"style_{i}" for i in range(centroids.shape[0])}


# ---------------------------------------------------------------------------
# Core: segment sessions by area and extract features
# ---------------------------------------------------------------------------

def process_sessions(
    sensor_dir: Path,
    eaf_parsed_dir: Path,
    vocab_dir: Path,
    sample_hz: float = 3.0,
) -> List[Dict]:
    """Load all sessions, segment by area, compute style features.

    Returns list of dicts: {session_id, area, area_name, n_frames, features}.
    """
    area_vocab = load_area_vocab(vocab_dir)
    area_label_map = load_area_label_map(vocab_dir)
    inv_vocab = {v: k for k, v in area_vocab.items()}

    # Build EAF mapping
    eaf_map: Dict[str, Path] = {}
    for ef in sorted(eaf_parsed_dir.glob("*.json")):
        if ef.name == "summary.json":
            continue
        eaf_map[normalize_session_id(ef.stem)] = ef

    segments: List[Dict] = []

    for sf in sorted(sensor_dir.glob("*.npy")):
        sid = sf.stem
        if sid not in eaf_map:
            continue

        # Load EAF
        with open(eaf_map[sid], encoding="utf-8") as f:
            eaf_data = json.load(f)
        tiers = eaf_data.get("tiers_grouped", {})

        # Require Goal + Stimuli tiers (same filter as two_stage_transformer.py)
        has_goal = any("goal" in k.lower() for k in tiers)
        has_stimuli = any(
            "stimuli" in k.lower() or "stimulus" in k.lower() for k in tiers
        )
        if not has_goal or not has_stimuli:
            continue

        # Load sensors
        sensors = np.load(sf).astype(np.float32)
        if sensors.ndim != 2:
            continue
        T = sensors.shape[0]

        # Build area timeline
        area_key = None
        for k in tiers:
            if "area" in k.lower():
                area_key = k
                break

        area_timeline = np.zeros(T, dtype=np.int64)
        if area_key:
            area_timeline = map_annotations_to_timeline(
                tiers[area_key], T, sample_hz, area_label_map, area_vocab
            )

        # Segment by area: collect all frames for each area_id
        for area_id in np.unique(area_timeline):
            mask = area_timeline == area_id
            n_frames = int(mask.sum())
            if n_frames < MIN_SEGMENT_FRAMES:
                continue

            area_sensors = sensors[mask]
            features = compute_style_features(area_sensors)
            area_name = inv_vocab.get(int(area_id), f"area_{area_id}")

            segments.append({
                "session_id": sid,
                "area_id": int(area_id),
                "area_name": area_name,
                "n_frames": n_frames,
                "duration_sec": round(n_frames / sample_hz, 1),
                "features": features,
            })

        print(f"  [OK] {sid}: {T} frames, "
              f"{len([s for s in segments if s['session_id'] == sid])} area segments")

    return segments


# ---------------------------------------------------------------------------
# Command: cluster
# ---------------------------------------------------------------------------

def cmd_cluster(args: argparse.Namespace) -> None:
    sensor_dir = Path(args.sensor_dir)
    eaf_parsed_dir = Path(args.eaf_parsed_dir)
    vocab_dir = Path(args.vocab_dir)
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("AREA-AWARE DRIVING STYLE CLUSTERING (EAF)")
    print("=" * 70)
    print(f"Sensor dir:      {sensor_dir}")
    print(f"EAF parsed dir:  {eaf_parsed_dir}")
    print(f"Vocab dir:       {vocab_dir}")
    print(f"Output dir:      {outdir}")
    print(f"K (clusters):    {args.k}")
    print()

    # 1. Process sessions → segments
    print("--- Step 1: Segmenting sessions by area ---")
    segments = process_sessions(sensor_dir, eaf_parsed_dir, vocab_dir)

    if not segments:
        print("[ERROR] No segments found. Check paths.")
        sys.exit(1)

    print(f"\nTotal segments: {len(segments)}")
    area_counts = Counter(s["area_name"] for s in segments)
    for area, count in sorted(area_counts.items()):
        print(f"  {area}: {count} segments")

    # 2. Cluster
    print(f"\n--- Step 2: K-Means clustering (k={args.k}) ---")
    all_feats = [s["features"] for s in segments]
    clusters, keys, km = cluster_styles(all_feats, k=args.k)
    centroids = km.cluster_centers_
    name_map = name_clusters(centroids, keys)

    # Attach cluster info to segments
    for seg, c in zip(segments, clusters):
        seg["cluster"] = int(c)
        seg["style"] = name_map.get(int(c), f"cluster_{c}")

    # Print cluster summary
    print("\nCluster assignment:")
    for cid, cname in sorted(name_map.items()):
        count = int((clusters == cid).sum())
        print(f"  {cname}: {count} segments")

    # 3. Per-area distribution
    print("\n--- Step 3: Per-area style distribution ---")
    per_area_dist: Dict[str, Dict[str, int]] = {}
    for seg in segments:
        area = seg["area_name"]
        style = seg["style"]
        if area not in per_area_dist:
            per_area_dist[area] = {}
        per_area_dist[area][style] = per_area_dist[area].get(style, 0) + 1

    for area in sorted(per_area_dist.keys()):
        dist = per_area_dist[area]
        total = sum(dist.values())
        print(f"\n  [{area.upper()}] ({total} segments)")
        for style in ["prudent", "smooth", "aggressive"]:
            count = dist.get(style, 0)
            pct = 100.0 * count / total if total > 0 else 0
            print(f"    {style:12s}: {count:4d} ({pct:5.1f}%)")

    # 4. Per-area feature statistics
    print("\n--- Step 4: Per-area feature statistics ---")
    per_area_stats: Dict[str, Dict] = {}
    for area in sorted(per_area_dist.keys()):
        area_segs = [s for s in segments if s["area_name"] == area]
        feat_keys = ["aggr_score", "accel_p95", "brake_p95", "vel_p95", "steer_std", "steer_speed_p95"]
        stats: Dict[str, Dict[str, float]] = {}
        for fk in feat_keys:
            vals = [s["features"].get(fk, 0.0) for s in area_segs]
            if vals:
                stats[fk] = {
                    "mean": round(float(np.mean(vals)), 4),
                    "std": round(float(np.std(vals)), 4),
                    "min": round(float(np.min(vals)), 4),
                    "max": round(float(np.max(vals)), 4),
                }
        per_area_stats[area] = stats

        print(f"\n  [{area.upper()}]")
        for fk in feat_keys:
            if fk in stats:
                s = stats[fk]
                print(f"    {fk:20s}: {s['mean']:8.3f} +/- {s['std']:8.3f}  "
                      f"[{s['min']:8.3f}, {s['max']:8.3f}]")

    # 5. Save results
    print(f"\n--- Saving results to {outdir}/ ---")

    # Profiles JSONL
    profiles_path = outdir / "style_eaf_profiles.jsonl"
    with open(profiles_path, "w", encoding="utf-8") as f:
        for seg in segments:
            f.write(json.dumps(seg, ensure_ascii=False) + "\n")
    print(f"  style_eaf_profiles.jsonl ({len(segments)} entries)")

    # Centroids JSON
    centroids_path = outdir / "style_eaf_centroids.json"
    with open(centroids_path, "w", encoding="utf-8") as f:
        json.dump({
            "keys": keys,
            "centroids": centroids.tolist(),
            "name_map": {str(k): v for k, v in name_map.items()},
            "k": args.k,
        }, f, indent=2)
    print(f"  style_eaf_centroids.json")

    # Summary JSON
    summary_path = outdir / "style_eaf_summary.json"
    summary = {
        "n_sessions": len(set(s["session_id"] for s in segments)),
        "n_segments": len(segments),
        "k": args.k,
        "cluster_names": {str(k): v for k, v in name_map.items()},
        "per_area_distribution": per_area_dist,
        "per_area_feature_stats": per_area_stats,
        "area_counts": dict(area_counts),
        "channel_mapping": {str(k): v for k, v in PREALIGNED_CHANNELS.items()},
    }
    with open(summary_path, "w", encoding="utf-8") as f:
        json.dump(summary, f, indent=2, ensure_ascii=False)
    print(f"  style_eaf_summary.json")

    print("\n[OK] Area-aware style clustering complete!")


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def main():
    parser = argparse.ArgumentParser(
        description="Area-aware driving style clustering using EAF annotations"
    )
    sub = parser.add_subparsers(dest="command")

    p = sub.add_parser("cluster", help="Cluster driving styles per area")
    p.add_argument("--sensor-dir", required=True, help="Dir with prealigned sensor .npy files")
    p.add_argument("--eaf-parsed-dir", required=True, help="Dir with parsed EAF .json files")
    p.add_argument("--vocab-dir", required=True, help="Dir with vocab_area.json")
    p.add_argument("--outdir", required=True, help="Output directory")
    p.add_argument("--k", type=int, default=3, help="Number of clusters (default: 3)")
    p.add_argument("--sample-hz", type=float, default=3.0, help="Sample rate (default: 3.0)")

    args = parser.parse_args()
    if args.command == "cluster":
        cmd_cluster(args)
    else:
        parser.print_help()


if __name__ == "__main__":
    main()
