#!/usr/bin/env python
"""Align EAF annotations to sensor timeline - SIMPLE MULTI-TARGET VERSION.

This version creates separate Goal and Stimuli target arrays but uses ONLY
the 4 standard sensor features (no EAF category augmentation).

This avoids feature scale mismatch between continuous sensors (-422 to +442)
and categorical EAF features (0-14).

Output structure:
    output_dir/
    ├── sensor/<SESSION_ID>.npy         # (T, 4) - standard sensors only
    ├── target_goal/<SESSION_ID>.npy    # (T,) - Goal labels
    ├── target_stimuli/<SESSION_ID>.npy # (T,) - Stimuli labels
    └── manifest_eaf_aligned_multitarget_simple.jsonl

Usage:
    python strategies_EAF/align_eaf_to_sensors_multitarget_simple.py \
      --hdd-root ./example_data \
      --eaf-parsed-dir ./strategies_EAF/eaf_parsed_chinese \
      --vocab-dir ./strategies_EAF/vocabs_chinese \
      --output-dir ./eaf_aligned_multitarget_simple \
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json
import sys
from dataclasses import dataclass, replace
from pathlib import Path
from typing import Dict, List

import numpy as np
from tqdm import tqdm

sys.path.insert(0, str(Path(__file__).parent.parent.parent))
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid
from twimo.data.manifest import write_manifest, SessionRecord


@dataclass
class MultiTargetVocabularies:
    """Vocabularies for multi-target prediction."""
    goal: List[str]
    stimuli: List[str]
    goal_label_map: Dict[str, int]
    stimuli_label_map: Dict[str, int]


def load_vocabularies(vocab_dir: Path) -> MultiTargetVocabularies:
    """Load Goal and Stimuli vocabularies only."""
    goal_vocab_path = vocab_dir / "vocab_goal.json"
    stimuli_vocab_path = vocab_dir / "vocab_stimuli.json"

    with open(goal_vocab_path, encoding='utf-8') as f:
        goal_vocab = json.load(f)

    with open(stimuli_vocab_path, encoding='utf-8') as f:
        stimuli_vocab = json.load(f)

    def _parse_vocab(v: dict) -> tuple[list[str], dict[str, int]]:
        """Parse vocab JSON: supports {labels:[...]} or {vocab:{lbl:idx,...}, label_map:{...}}."""
        if "labels" in v:
            labels = v["labels"]
            label_map = {lbl: i for i, lbl in enumerate(labels)}
        elif "vocab" in v and isinstance(v["vocab"], dict):
            label_map = v["vocab"]
            labels = [lbl for lbl, _ in sorted(label_map.items(), key=lambda x: x[1])]
        elif "label_map" in v and isinstance(v["label_map"], dict):
            label_map = v["label_map"]
            labels = [lbl for lbl, _ in sorted(label_map.items(), key=lambda x: x[1])]
        else:
            labels = ["unknown"]
            label_map = {"unknown": 0}
        return labels, label_map

    goal_labels, goal_label_map = _parse_vocab(goal_vocab)
    stimuli_labels, stimuli_label_map = _parse_vocab(stimuli_vocab)

    return MultiTargetVocabularies(
        goal=goal_labels,
        stimuli=stimuli_labels,
        goal_label_map=goal_label_map,
        stimuli_label_map=stimuli_label_map,
    )


def normalize_session_id(original_id: str) -> str:
    """Normalize session ID from YYYY-MM-DD-HH-MM-SS to YYYYMMDDHHMM."""
    parts = original_id.replace('-', '_').split('_')
    if len(parts) >= 5:
        return ''.join(parts[:5])
    return original_id


def map_tier_to_timeline(
    annotations: List[dict],
    timestamps_ms: np.ndarray,
    vocab: List[str],
    label_map: Dict[str, int],
) -> np.ndarray:
    """Map tier annotations to integer labels on timeline."""
    T = len(timestamps_ms)
    labels = np.zeros(T, dtype=np.int64)

    for ann in annotations:
        start_ms = ann['start_ms']
        end_ms = ann['end_ms']
        label_raw = ann['label'].strip()

        # Extract English part
        label_clean = ' '.join(p for p in label_raw.split() if p.replace('-', '').replace('_', '').isascii()).strip()
        if not label_clean:
            label_clean = label_raw

        # Try multiple normalizations: original, underscored, lowercased
        label_idx = (
            label_map.get(label_clean)
            or label_map.get(label_clean.replace(' ', '_'))
            or label_map.get(label_clean.lower())
            or label_map.get(label_clean.lower().replace(' ', '_'))
            or 0
        )

        mask = (timestamps_ms >= start_ms) & (timestamps_ms < end_ms)
        labels[mask] = label_idx

    return labels


def align_eaf_to_sensors_simple(
    csv_dir: Path,
    eaf_parsed_path: Path,
    vocabs: MultiTargetVocabularies,
    sample_hz: int = 3,
    sensor_cols: list[str] | None = None,
) -> tuple[np.ndarray, np.ndarray, np.ndarray] | None:
    """Align EAF to sensors.

    Returns:
        (sensors, target_goal, target_stimuli) or None if failed
        - sensors: (T, D) float32 array  (D = len(sensor_cols))
        - target_goal: (T,) int64 array
        - target_stimuli: (T,) int64 array
    """
    if sensor_cols is None:
        sensor_cols = [
            'steer_angle', 'steer_speed',   # steer.csv
            'lturn', 'rturn',                # turn_signal.csv
            'speed',                         # vel.csv
            'pedalangle(percent)',           # accel_pedal.csv
            'pedalpressure(kPa)',            # brake_pedal.csv
            'yaw(degree/s)',                 # yaw.csv
        ]

    df = load_run_sensors(csv_dir)
    if not df:
        return None

    X_df = align_sensors_to_grid(df, hz=sample_hz)
    if X_df is None or X_df.empty:
        return None

    # Required: at least steer or turn signals must be present
    required = {'steer_angle', 'steer_speed', 'lturn', 'rturn'}
    if not required.intersection(X_df.columns):
        return None

    import pandas as pd
    feat = pd.DataFrame(index=X_df.index)
    for col in sensor_cols:
        feat[col] = X_df[col].fillna(0.0) if col in X_df.columns else 0.0

    X_sensors = feat.values.astype(np.float32)  # (T, D)
    # Relative timestamps in ms (EAF TIME_VALUE is relative to recording start)
    unix_ts = X_df["unix_timestamp"].values if "unix_timestamp" in X_df.columns else np.arange(len(X_df)) / sample_hz
    timestamps_ms = ((unix_ts - unix_ts[0]) * 1000).astype(np.int64)

    # Load EAF annotations
    with open(eaf_parsed_path, encoding='utf-8') as f:
        eaf_data = json.load(f)

    tiers_grouped = eaf_data.get('tiers_grouped', {})

    # Find Goal and Stimuli tiers
    goal_tier_key = None
    stimuli_tier_key = None

    for tier_name in tiers_grouped.keys():
        tier_lower = tier_name.lower()
        if 'goal' in tier_lower:
            goal_tier_key = tier_name
        elif 'stimuli' in tier_lower or 'stimulus' in tier_lower:
            stimuli_tier_key = tier_name

    if not goal_tier_key or not stimuli_tier_key:
        return None

    anns_goal = tiers_grouped[goal_tier_key]
    anns_stimuli = tiers_grouped[stimuli_tier_key]

    # Map to timeline
    labels_goal = map_tier_to_timeline(anns_goal, timestamps_ms, vocabs.goal, vocabs.goal_label_map)
    labels_stimuli = map_tier_to_timeline(anns_stimuli, timestamps_ms, vocabs.stimuli, vocabs.stimuli_label_map)

    return X_sensors, labels_goal, labels_stimuli


def main():
    parser = argparse.ArgumentParser(
        description="Align EAF to sensors - Simple Multi-Target (4 sensors only)"
    )
    parser.add_argument(
        "--hdd-root",
        type=Path,
        required=True,
        help="Root directory of HDD dataset",
    )
    parser.add_argument(
        "--eaf-parsed-dir",
        type=Path,
        required=True,
        help="Directory with parsed EAF JSON files",
    )
    parser.add_argument(
        "--vocab-dir",
        type=Path,
        required=True,
        help="Directory with vocabulary JSON files",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        required=True,
        help="Output directory for aligned arrays",
    )
    parser.add_argument(
        "--sample-hz",
        type=int,
        default=3,
        help="Sampling frequency (default: 3 Hz)",
    )
    parser.add_argument(
        "--sensor-cols",
        nargs="+",
        default=None,
        metavar="COL",
        help=(
            "Sensor columns to include (default: steer_angle steer_speed lturn rturn "
            "speed pedalangle(percent) pedalpressure(kPa) yaw(degree/s)). "
            "Missing columns are filled with 0."
        ),
    )

    args = parser.parse_args()

    print("=" * 80)
    print("EAF -> Sensors Alignment - SIMPLE MULTI-TARGET")
    print("=" * 80)
    print(f"HDD root:        {args.hdd_root}")
    print(f"EAF parsed dir:  {args.eaf_parsed_dir}")
    print(f"Vocab dir:       {args.vocab_dir}")
    print(f"Output dir:      {args.output_dir}")
    print(f"Sample Hz:       {args.sample_hz}")
    _default_cols = ['steer_angle', 'steer_speed', 'lturn', 'rturn',
                     'speed', 'pedalangle(percent)', 'pedalpressure(kPa)', 'yaw(degree/s)']
    _cols_used = args.sensor_cols if args.sensor_cols else _default_cols
    print(f"Sensor cols ({len(_cols_used)}): {_cols_used}")
    print()

    # Load vocabularies
    print("Loading vocabularies...")
    vocabs = load_vocabularies(args.vocab_dir)
    print(f"  Goal vocab:     {len(vocabs.goal)} classes")
    print(f"  Stimuli vocab:  {len(vocabs.stimuli)} classes")
    print()

    # Find EAF parsed files
    eaf_files = sorted(args.eaf_parsed_dir.glob("*.json"))
    print(f"Found {len(eaf_files)} parsed EAF files")
    print()

    # Output directories
    sensor_dir = args.output_dir / "sensor"
    target_goal_dir = args.output_dir / "target_goal"
    target_stimuli_dir = args.output_dir / "target_stimuli"

    sensor_dir.mkdir(parents=True, exist_ok=True)
    target_goal_dir.mkdir(parents=True, exist_ok=True)
    target_stimuli_dir.mkdir(parents=True, exist_ok=True)

    # Process each session
    records: List[SessionRecord] = []
    success_count = 0
    fail_count = 0

    def _find_csv_dir(hdd_root: Path, sid_orig: str, sid_norm: str) -> Path | None:
        """Search for session CSV dir in flat or HDD nested (day_folder/session/general) structure."""
        candidates = [
            hdd_root / sid_orig,
            hdd_root / sid_norm,
            hdd_root / sid_orig / "general",
            hdd_root / sid_norm / "general",
        ]
        # HDD nested: hdd_root/YYYY_MM_DD*/session_id/general
        if len(sid_norm) >= 8:
            day_raw = sid_norm[:8]  # "YYYYMMDD"
            day_fmt = f"{day_raw[:4]}_{day_raw[4:6]}_{day_raw[6:8]}"  # "YYYY_MM_DD"
            for day_dir in sorted(hdd_root.glob(f"{day_fmt}*")):
                if day_dir.is_dir():
                    for sub in (sid_orig, sid_norm):
                        for suffix in ("general", ""):
                            p = day_dir / sub / suffix if suffix else day_dir / sub
                            candidates.append(p)
        for c in candidates:
            if c.exists():
                return c
        return None

    print("Aligning sessions...")
    for eaf_file in tqdm(eaf_files, desc="Sessions"):
        session_id_orig = eaf_file.stem
        session_id_norm = normalize_session_id(session_id_orig)

        csv_dir = _find_csv_dir(args.hdd_root, session_id_orig, session_id_norm)
        if csv_dir is None:
            fail_count += 1
            continue

        # Align
        result = align_eaf_to_sensors_simple(
            csv_dir,
            eaf_file,
            vocabs,
            sample_hz=args.sample_hz,
            sensor_cols=args.sensor_cols,
        )

        if result is None:
            fail_count += 1
            continue

        X_sensors, labels_goal, labels_stimuli = result

        # Save arrays
        sensor_path_new = sensor_dir / f"{session_id_norm}.npy"
        target_goal_path_new = target_goal_dir / f"{session_id_norm}.npy"
        target_stimuli_path_new = target_stimuli_dir / f"{session_id_norm}.npy"

        np.save(sensor_path_new, X_sensors)
        np.save(target_goal_path_new, labels_goal)
        np.save(target_stimuli_path_new, labels_stimuli)

        # Create session record
        record = SessionRecord(
            session_id=session_id_norm,
            day_id=session_id_norm[:8],  # YYYYMMDD
            csv_dir=str(csv_dir),
            video_path=None,
            prealigned_sensor_npy=str(sensor_path_new),
            prealigned_target_npy=str(target_goal_path_new),
        )
        records.append(record)
        success_count += 1

    # Write manifest
    manifest_path = args.output_dir / "manifest_eaf_aligned_multitarget_simple.jsonl"
    write_manifest(manifest_path, records)

    # Summary
    print()
    print("=" * 80)
    print("ALIGNMENT SUMMARY")
    print("=" * 80)
    print(f"Total sessions:    {len(eaf_files)}")
    print(f"[OK] Success:      {success_count}")
    print(f"[X] Failed:        {fail_count}")
    print()
    print(f"Output manifest:   {manifest_path}")
    print()
    print("Output structure:")
    print(f"  - sensor/        (T, 4) - 4 standard sensors only")
    print(f"  - target_goal/   (T,) - Goal labels")
    print(f"  - target_stimuli/ (T,) - Stimuli labels")
    print()
    print("[OK] Alignment complete!")
    print()
    print("Next step: Rebalance and train:")
    print(f"  python strategies_EAF/rebalance_data_downsample.py \\")
    print(f"    --input-manifest {manifest_path} \\")
    print(f"    --output-dir ./eaf_aligned_downsampled_simple \\")
    print(f"    --target-class0-ratio 0.5 \\")
    print(f"    --test-day 2017_03_06_ITS1")
    print("=" * 80 + "\n")


if __name__ == "__main__":
    main()
