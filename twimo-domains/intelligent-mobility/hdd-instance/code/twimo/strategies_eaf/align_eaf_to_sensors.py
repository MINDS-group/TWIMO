#!/usr/bin/env python
"""Align EAF annotations to sensor timeline and create .npy label files.

This script:
1. Loads sensor CSV files for each session
2. Aligns sensors to 3 Hz grid
3. Maps EAF annotations (in milliseconds) to sensor timesteps
4. Creates .npy files with integer labels for training

Usage:
    python strategies_EAF/align_eaf_to_sensors.py \
      --eaf-parsed-dir ./eaf_parsed \
      --vocab ./artifacts/vocab_eaf.json \
      --manifest ./artifacts/manifest.jsonl \
      --output-dir ./artifacts/eaf_aligned \
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path
from typing import Dict, List, Tuple

import numpy as np
import pandas as pd
from tqdm import tqdm

# Import TWIMO utilities
import sys
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

from twimo.data.manifest import load_manifest, write_manifest, SessionRecord
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid


def normalize_session_id(session_id: str) -> str:
    """Normalize session ID to compact format (YYYYMMDDHHMM).

    Handles both formats:
        - EAF format: "2017-02-27-10-17-27" → "201702271017"
        - Compact format: "201702271017" → "201702271017"
    """
    # If already compact format (12 digits), return as-is
    if session_id.isdigit() and len(session_id) == 12:
        return session_id

    # If EAF format with dashes
    if '-' in session_id:
        parts = session_id.split('-')
        if len(parts) == 6:
            # Format: YYYY-MM-DD-HH-MM-SS → YYYYMMDDHHMM
            year, month, day, hour, minute, second = parts
            return f"{year}{month}{day}{hour}{minute}"

    # Fallback: return as-is
    return session_id


def build_eaf_to_manifest_mapping(eaf_parsed_dir: Path, records: List[SessionRecord]) -> Dict[str, str]:
    """Build mapping from EAF filenames to manifest session_ids.

    Returns:
        {eaf_filename_stem: manifest_session_id}
    """
    # Get all EAF files
    eaf_files = [f for f in eaf_parsed_dir.glob('*.json') if f.name != 'summary.json']
    eaf_stems = {f.stem for f in eaf_files}

    # Normalize manifest session IDs
    manifest_normalized = {normalize_session_id(r.session_id): r.session_id for r in records}

    # Build mapping
    mapping = {}
    for eaf_stem in eaf_stems:
        normalized = normalize_session_id(eaf_stem)
        if normalized in manifest_normalized:
            mapping[eaf_stem] = manifest_normalized[normalized]

    return mapping


def load_vocab(vocab_path: Path) -> Tuple[Dict[str, int], Dict[str, str]]:
    """Load vocabulary from JSON file.

    Returns:
        (vocab, label_map) where:
            vocab: {normalized_label: class_id}
            label_map: {raw_label: normalized_label}
    """
    with open(vocab_path, encoding='utf-8') as f:
        data = json.load(f)

    vocab = data['vocab']
    label_map = data.get('label_map', {})

    return vocab, label_map


def load_eaf_annotations(eaf_parsed_path: Path) -> List[dict]:
    """Load parsed EAF annotations from JSON."""
    with open(eaf_parsed_path, encoding='utf-8') as f:
        data = json.load(f)

    return data.get('annotations', [])


def normalize_label(label: str, label_map: Dict[str, str]) -> str:
    """Normalize raw EAF label using label_map."""
    if label in label_map:
        return label_map[label]

    # Fallback: normalize manually
    parts = label.split()
    english_parts = [p for p in parts if p.isascii()]
    if english_parts:
        return '_'.join(english_parts).lower()
    else:
        return label.replace(' ', '_').lower()


def compute_sensor_timestamps_ms_relative(aligned_df) -> np.ndarray:
    """Compute sensor timestamps in ms RELATIVE to first sensor sample.

    CRITICAL FIX: EAF TIME_VALUE is in milliseconds RELATIVE to recording start.
    Sensor CSV timestamps are often absolute UNIX time or otherwise offset.
    We ALWAYS convert to milliseconds RELATIVE to the first sensor sample:
        rel_ms = unix_ms - unix_ms[0]
    This avoids timezone/epoch offsets (e.g., +8h => 28800000ms) that cause "all zero labels".

    Args:
        aligned_df: DataFrame with sensor data

    Returns:
        timestamps_ms: (T,) array of timestamps in ms relative to first sample
    """
    # Find timestamp column
    timestamp_col = None
    for c in aligned_df.columns:
        cl = c.lower()
        if "unix" in cl and "time" in cl:
            timestamp_col = c
            break

    if timestamp_col is None:
        # Fallback: create synthetic relative timestamps at sample_hz
        # Assume 3 Hz: 0, 333, 666, 1000, ...
        return np.arange(len(aligned_df)) * (1000.0 / 3.0)

    ts = aligned_df[timestamp_col].values

    # Detect if timestamps are in seconds or milliseconds
    # If median > 1e12, likely already in ms; else in seconds
    med = np.median(ts)
    if med > 1e12:
        ts_ms = ts.astype(np.int64)  # already ms
    else:
        ts_ms = (ts * 1000.0).astype(np.int64)  # seconds -> ms

    # Make RELATIVE to first sample
    rel_ms = ts_ms - int(ts_ms[0])
    return rel_ms


def map_annotations_to_timeline(
    annotations: List[dict],
    timestamps_ms: np.ndarray,
    vocab: Dict[str, int],
    label_map: Dict[str, str],
    unknown_label: str = 'unknown',
) -> np.ndarray:
    """Map EAF annotations to sensor timeline.

    Args:
        annotations: List of EAF annotations [{start_ms, end_ms, label}]
        timestamps_ms: Sensor timestamps in milliseconds RELATIVE to first sample
        vocab: {normalized_label: class_id}
        label_map: {raw_label: normalized_label}
        unknown_label: Label to use for unmapped/unlabeled timesteps

    Returns:
        labels: (T,) array of integer class IDs
    """
    T = len(timestamps_ms)
    labels = np.full(T, vocab.get(unknown_label, 0), dtype=np.int32)

    for ann in annotations:
        start_ms = ann['start_ms']
        end_ms = ann['end_ms']
        raw_label = ann['label']

        # Normalize label
        normalized = normalize_label(raw_label, label_map)

        # Get class ID
        if normalized in vocab:
            class_id = vocab[normalized]
        elif unknown_label in vocab:
            class_id = vocab[unknown_label]
        else:
            continue

        # Find timesteps that fall within [start_ms, end_ms)
        mask = (timestamps_ms >= start_ms) & (timestamps_ms < end_ms)
        labels[mask] = class_id

    return labels


def align_session(
    session_record: SessionRecord,
    eaf_json_path: Path,
    vocab: Dict[str, int],
    label_map: Dict[str, str],
    output_dir: Path,
    sample_hz: float = 3.0,
) -> SessionRecord | None:
    """Align EAF annotations for a single session.

    Args:
        session_record: Session metadata
        eaf_json_path: Path to parsed EAF JSON file
        vocab: Vocabulary mapping
        label_map: Label normalization map
        output_dir: Output directory for .npy files
        sample_hz: Sampling frequency

    Returns:
        Updated SessionRecord with paths to aligned .npy files, or None if failed
    """
    session_id = session_record.session_id

    # Load EAF annotations
    if not eaf_json_path.exists():
        return None

    annotations = load_eaf_annotations(eaf_json_path)
    if not annotations:
        return None

    # Load sensors
    csv_dir = Path(session_record.csv_dir)
    if not csv_dir.exists():
        return None

    df = load_run_sensors(csv_dir)
    aligned = align_sensors_to_grid(df, hz=sample_hz)

    # Get sensor timestamps in milliseconds RELATIVE to first sample
    # CRITICAL FIX: This makes timestamps compatible with EAF TIME_VALUE
    timestamps_ms = compute_sensor_timestamps_ms_relative(aligned)
    if len(timestamps_ms) == 0:
        return None

    # Map annotations to timeline
    labels = map_annotations_to_timeline(annotations, timestamps_ms, vocab, label_map)

    # Extract sensors (same as prealigned workflow)
    sensor_cols = ['steer_angle', 'steer_speed', 'lturn', 'rturn']
    X_df = pd.DataFrame()
    for col in sensor_cols:
        if col in aligned.columns:
            X_df[col] = aligned[col].fillna(0.0)
        else:
            X_df[col] = 0.0

    X = X_df.values.astype(np.float32)

    # Save as .npy
    sensor_dir = output_dir / 'sensor'
    target_dir = output_dir / 'target'
    sensor_dir.mkdir(parents=True, exist_ok=True)
    target_dir.mkdir(parents=True, exist_ok=True)

    sensor_path = sensor_dir / f"{session_id}.npy"
    target_path = target_dir / f"{session_id}.npy"

    np.save(sensor_path, X)
    np.save(target_path, labels)

    # Create updated SessionRecord
    updated_record = SessionRecord(
        session_id=session_id,
        day_id=session_record.day_id,
        csv_dir=session_record.csv_dir,
        video_path=session_record.video_path,
        prealigned_sensor_npy=str(sensor_path),
        prealigned_target_npy=str(target_path),
    )

    return updated_record


def main():
    parser = argparse.ArgumentParser(
        description="Align EAF annotations to sensor timeline"
    )
    parser.add_argument(
        '--eaf-parsed-dir',
        type=Path,
        required=True,
        help='Directory with parsed EAF JSON files',
    )
    parser.add_argument(
        '--vocab',
        type=Path,
        required=True,
        help='Vocabulary JSON file',
    )
    parser.add_argument(
        '--manifest',
        type=Path,
        required=True,
        help='Input manifest (JSONL)',
    )
    parser.add_argument(
        '--output-dir',
        type=Path,
        required=True,
        help='Output directory for aligned .npy files',
    )
    parser.add_argument(
        '--sample-hz',
        type=float,
        default=3.0,
        help='Sampling frequency (default: 3.0 Hz)',
    )

    args = parser.parse_args()

    # Load vocabulary
    print(f"Loading vocabulary from {args.vocab}...")
    vocab, label_map = load_vocab(args.vocab)
    print(f"  Vocabulary: {len(vocab)} classes")

    # Load manifest
    print(f"\nLoading manifest from {args.manifest}...")
    records = load_manifest(args.manifest)
    print(f"  Found {len(records)} sessions")

    # Build EAF-to-manifest mapping
    print(f"\nBuilding EAF-to-manifest session ID mapping...")
    eaf_to_manifest = build_eaf_to_manifest_mapping(args.eaf_parsed_dir, records)
    print(f"  Matched {len(eaf_to_manifest)} EAF files to manifest sessions")

    if len(eaf_to_manifest) == 0:
        print(f"\n⚠️  No EAF files matched manifest sessions!")
        print(f"\nRun diagnostic check:")
        print(f"  python strategies_EAF/diagnostic_check.py \\")
        print(f"    --eaf-parsed-dir {args.eaf_parsed_dir} \\")
        print(f"    --manifest {args.manifest}")
        return

    # Create reverse mapping (manifest_id -> eaf_filename)
    manifest_to_eaf = {v: k for k, v in eaf_to_manifest.items()}

    # Align sessions
    print(f"\nAligning EAF annotations to sensors...")
    aligned_records = []
    skipped_reasons = {
        'no_eaf': [],
        'no_csv': [],
        'no_annotations': [],
        'error': [],
    }

    for record in tqdm(records, desc="Sessions"):
        try:
            # Check if session has EAF file (using mapping)
            if record.session_id not in manifest_to_eaf:
                skipped_reasons['no_eaf'].append(record.session_id)
                continue

            eaf_filename = manifest_to_eaf[record.session_id]
            eaf_json_path = args.eaf_parsed_dir / f"{eaf_filename}.json"

            if not eaf_json_path.exists():
                skipped_reasons['no_eaf'].append(record.session_id)
                continue

            # Check CSV dir exists
            csv_dir = Path(record.csv_dir)
            if not csv_dir.exists():
                skipped_reasons['no_csv'].append(record.session_id)
                continue

            aligned_record = align_session(
                session_record=record,
                eaf_json_path=eaf_json_path,
                vocab=vocab,
                label_map=label_map,
                output_dir=args.output_dir,
                sample_hz=args.sample_hz,
            )

            if aligned_record is not None:
                aligned_records.append(aligned_record)
            else:
                skipped_reasons['no_annotations'].append(record.session_id)

        except Exception as e:
            skipped_reasons['error'].append((record.session_id, str(e)))
            continue

    # Write manifest
    manifest_path = args.output_dir / 'manifest_eaf_aligned.jsonl'
    write_manifest(manifest_path, aligned_records)

    print(f"\n{'='*80}")
    print(f"EAF alignment completed!")
    print(f"{'='*80}")
    print(f"  Sessions aligned: {len(aligned_records)}/{len(records)}")
    print(f"  Output directory: {args.output_dir}")
    print(f"  Manifest: {manifest_path}")

    # Report skipped sessions
    if len(aligned_records) < len(records):
        print(f"\nSkipped sessions breakdown:")
        if skipped_reasons['no_eaf']:
            print(f"  No EAF file: {len(skipped_reasons['no_eaf'])} sessions")
            for sid in skipped_reasons['no_eaf'][:3]:
                print(f"    - {sid}")
            if len(skipped_reasons['no_eaf']) > 3:
                print(f"    ... and {len(skipped_reasons['no_eaf']) - 3} more")

        if skipped_reasons['no_csv']:
            print(f"  No CSV dir: {len(skipped_reasons['no_csv'])} sessions")
            for sid in skipped_reasons['no_csv'][:3]:
                print(f"    - {sid}")
            if len(skipped_reasons['no_csv']) > 3:
                print(f"    ... and {len(skipped_reasons['no_csv']) - 3} more")

        if skipped_reasons['no_annotations']:
            print(f"  No annotations: {len(skipped_reasons['no_annotations'])} sessions")
            for sid in skipped_reasons['no_annotations'][:3]:
                print(f"    - {sid}")
            if len(skipped_reasons['no_annotations']) > 3:
                print(f"    ... and {len(skipped_reasons['no_annotations']) - 3} more")

        if skipped_reasons['error']:
            print(f"  Errors: {len(skipped_reasons['error'])} sessions")
            for sid, err in skipped_reasons['error'][:3]:
                print(f"    - {sid}: {err}")
            if len(skipped_reasons['error']) > 3:
                print(f"    ... and {len(skipped_reasons['error']) - 3} more")

    if len(aligned_records) > 0:
        print(f"\nNext steps:")
        print(f"  1. Train model with EAF labels:")
        print(f"     python -m twimo.cli train-maneuver \\")
        print(f"       --manifest {manifest_path} \\")
        print(f"       --outdir ./artifacts/maneuver_eaf_transformer \\")
        print(f"       --model transformer \\")
        print(f"       --sample-hz {args.sample_hz}")
    else:
        print(f"\n⚠️  No sessions were aligned. Check:")
        print(f"  1. EAF files exist in {args.eaf_parsed_dir}")
        print(f"  2. Session IDs in manifest match EAF filenames")
        print(f"  3. CSV directories exist for each session")

    print(f"{'='*80}\n")


if __name__ == '__main__':
    main()
