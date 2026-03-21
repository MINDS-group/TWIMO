#!/usr/bin/env python
"""Analyze real sensor data to extract maneuver-specific control statistics.

This script analyzes real driving data to learn the relationship between
predicted maneuvers and actual control commands (steering angle, speed).

The output statistics can be used to improve maneuver_to_control_commands()
by replacing fixed heuristics with data-driven distributions.

Usage:
    python examples/analyze_maneuver_statistics.py \
      --manifest ./artifacts/manifest_train.jsonl \
      --output ./artifacts/maneuver_control_stats.json \
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json
from collections import defaultdict
from pathlib import Path
from typing import Dict, List

import numpy as np
import pandas as pd
from tqdm import tqdm

from twimo.data.manifest import load_manifest
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid


def load_labels_for_session(session_record, sample_hz: float = 3.0) -> np.ndarray:
    """Load ground-truth maneuver labels for a session."""
    # Try prealigned labels first
    if session_record.prealigned_target_npy:
        labels = np.load(session_record.prealigned_target_npy)
        return labels

    # Otherwise, we'd need proxy labels (not implemented here)
    return None


def analyze_session(session_record, sample_hz: float = 3.0) -> Dict:
    """Analyze one session to extract maneuver → control statistics."""
    # Load sensors
    df = load_run_sensors(Path(session_record.csv_dir))
    aligned = align_sensors_to_grid(df, hz=sample_hz)

    # Load labels
    labels = load_labels_for_session(session_record, sample_hz)
    if labels is None:
        return None

    # Ensure same length (trim to shortest)
    min_len = min(len(aligned), len(labels))
    aligned = aligned.iloc[:min_len]
    labels = labels[:min_len]

    # Extract control signals
    steer_angle = aligned.get('steer_angle', pd.Series(np.zeros(len(aligned)))).fillna(0.0).values
    speed = aligned.get('speed', pd.Series(np.zeros(len(aligned)))).fillna(0.0).values

    # Group by maneuver label
    maneuver_data = defaultdict(lambda: {'steer': [], 'speed': []})

    for i, label in enumerate(labels):
        maneuver_data[int(label)]['steer'].append(float(steer_angle[i]))
        maneuver_data[int(label)]['speed'].append(float(speed[i]))

    return maneuver_data


def compute_statistics(values: List[float]) -> Dict:
    """Compute distribution statistics for a list of values."""
    if len(values) == 0:
        return {
            'mean': 0.0,
            'median': 0.0,
            'std': 0.0,
            'min': 0.0,
            'max': 0.0,
            'q25': 0.0,
            'q75': 0.0,
            'count': 0,
        }

    arr = np.array(values)
    return {
        'mean': float(np.mean(arr)),
        'median': float(np.median(arr)),
        'std': float(np.std(arr)),
        'min': float(np.min(arr)),
        'max': float(np.max(arr)),
        'q25': float(np.percentile(arr, 25)),
        'q75': float(np.percentile(arr, 75)),
        'count': len(values),
    }


def main():
    parser = argparse.ArgumentParser(
        description="Analyze maneuver-specific control statistics from real data"
    )
    parser.add_argument(
        "--manifest",
        type=Path,
        required=True,
        help="Training manifest (e.g., ./artifacts/manifest_train.jsonl)",
    )
    parser.add_argument(
        "--output",
        type=Path,
        required=True,
        help="Output JSON file for statistics",
    )
    parser.add_argument(
        "--sample-hz",
        type=float,
        default=3.0,
        help="Sampling frequency (default: 3.0 Hz)",
    )
    parser.add_argument(
        "--max-sessions",
        type=int,
        default=None,
        help="Limit number of sessions (for testing)",
    )
    parser.add_argument(
        "--vocab-path",
        type=Path,
        default=None,
        help="Optional vocab.json to map label IDs to names",
    )

    args = parser.parse_args()

    # Load manifest
    print(f"Loading manifest from {args.manifest}...")
    records = load_manifest(args.manifest)
    print(f"  Found {len(records)} sessions")

    if args.max_sessions:
        records = records[:args.max_sessions]
        print(f"  Limited to {len(records)} sessions for testing")

    # Load vocab if provided
    vocab = {}
    if args.vocab_path and args.vocab_path.exists():
        with open(args.vocab_path) as f:
            vocab = {int(k): v for k, v in json.load(f).items()}
        print(f"  Loaded vocabulary with {len(vocab)} classes")

    # Aggregate data across all sessions
    print(f"\nAnalyzing sessions...")
    global_stats = defaultdict(lambda: {'steer': [], 'speed': []})

    successful = 0
    for record in tqdm(records, desc="Sessions"):
        try:
            session_data = analyze_session(record, args.sample_hz)
            if session_data is None:
                continue

            # Merge into global stats
            for label_id, data in session_data.items():
                global_stats[label_id]['steer'].extend(data['steer'])
                global_stats[label_id]['speed'].extend(data['speed'])

            successful += 1
        except Exception as e:
            print(f"\n  [Warning] Failed to process {record.session_id}: {e}")
            continue

    # Compute statistics per maneuver
    print(f"\nComputing statistics...")
    maneuver_stats = {}

    for label_id, data in global_stats.items():
        label_name = vocab.get(label_id, f'class_{label_id}')

        maneuver_stats[label_name] = {
            'label_id': label_id,
            'steer_angle': compute_statistics(data['steer']),
            'speed': compute_statistics(data['speed']),
        }

    # Save to JSON
    output_data = {
        'metadata': {
            'n_sessions': successful,
            'total_sessions': len(records),
            'sample_hz': args.sample_hz,
        },
        'maneuver_statistics': maneuver_stats,
    }

    args.output.parent.mkdir(parents=True, exist_ok=True)
    with open(args.output, 'w') as f:
        json.dump(output_data, f, indent=2)

    print(f"\n{'='*80}")
    print(f"Analysis complete!")
    print(f"{'='*80}")
    print(f"  Sessions analyzed: {successful}/{len(records)}")
    print(f"  Maneuvers found:   {len(maneuver_stats)}")
    print(f"  Output saved:      {args.output}")

    # Print summary
    print(f"\nManeuver Statistics Summary:")
    print(f"{'Maneuver':<30} {'Samples':>10} {'Steer (mean±std)':>20} {'Speed (mean±std)':>20}")
    print(f"{'-'*80}")

    for maneuver_name, stats in sorted(maneuver_stats.items(), key=lambda x: -x[1]['steer_angle']['count']):
        steer_stats = stats['steer_angle']
        speed_stats = stats['speed']

        print(f"{maneuver_name:<30} {steer_stats['count']:>10} "
              f"{steer_stats['mean']:>8.2f}±{steer_stats['std']:>6.2f}° "
              f"{speed_stats['mean']:>8.2f}±{speed_stats['std']:>6.2f} km/h")

    print(f"\nNext steps:")
    print(f"  1. Review statistics in {args.output}")
    print(f"  2. Update maneuver_to_control_commands() in generate_ml_predictions.py")
    print(f"     to use these statistics instead of fixed heuristics")
    print(f"  3. Re-generate ML predictions with improved mapping")
    print(f"{'='*80}\n")


if __name__ == "__main__":
    main()
