#!/usr/bin/env python
"""Split manifest into train and test sets.

Usage:
    python examples/split_manifest.py \\
      --manifest ./artifacts/manifest.jsonl \\
      --train ./artifacts/manifest_train.jsonl \\
      --test ./artifacts/manifest_test.jsonl \\
      --split 0.8
"""

from __future__ import annotations

import argparse
import random
from pathlib import Path
import sys
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

from twimo.data.manifest import load_manifest, write_manifest


def split_manifest(
    manifest_path: Path,
    train_path: Path,
    test_path: Path,
    train_ratio: float = 0.8,
    seed: int = 42,
    split_by: str = "day",
) -> None:
    """Split manifest into train and test sets.

    Args:
        manifest_path: Input manifest file
        train_path: Output train manifest file
        test_path: Output test manifest file
        train_ratio: Ratio of data for training (0.0-1.0)
        seed: Random seed for reproducibility
        split_by: Split by 'day' (recommended) or 'session'
    """
    # Load all sessions
    records = load_manifest(manifest_path)
    print(f"Loaded {len(records)} sessions from {manifest_path}")

    # Set random seed
    random.seed(seed)

    if split_by == "day":
        # Group by day_id to avoid temporal leakage
        from collections import defaultdict

        day_groups = defaultdict(list)
        for rec in records:
            day_groups[rec.day_id].append(rec)

        # Split days
        days = sorted(day_groups.keys())
        random.shuffle(days)

        n_train_days = int(len(days) * train_ratio)
        train_days = set(days[:n_train_days])
        test_days = set(days[n_train_days:])

        # Assign sessions
        train_records = []
        test_records = []
        for day_id, day_sessions in day_groups.items():
            if day_id in train_days:
                train_records.extend(day_sessions)
            else:
                test_records.extend(day_sessions)

        print(f"\nSplit by day:")
        print(f"  Train days: {len(train_days)} ({len(train_records)} sessions)")
        print(f"  Test days:  {len(test_days)} ({len(test_records)} sessions)")

    elif split_by == "session":
        # Shuffle and split sessions directly
        shuffled = list(records)
        random.shuffle(shuffled)

        n_train = int(len(shuffled) * train_ratio)
        train_records = shuffled[:n_train]
        test_records = shuffled[n_train:]

        print(f"\nSplit by session:")
        print(f"  Train: {len(train_records)} sessions")
        print(f"  Test:  {len(test_records)} sessions")

    else:
        raise ValueError(f"Invalid split_by: {split_by}. Use 'day' or 'session'.")

    # Write manifests
    write_manifest(train_path, train_records)
    write_manifest(test_path, test_records)

    print(f"\nWrote train manifest: {train_path}")
    print(f"Wrote test manifest:  {test_path}")


def main():
    parser = argparse.ArgumentParser(description="Split manifest into train/test sets")
    parser.add_argument(
        "--manifest",
        type=Path,
        required=True,
        help="Input manifest file (e.g., ./artifacts/manifest.jsonl)",
    )
    parser.add_argument(
        "--train",
        type=Path,
        required=True,
        help="Output train manifest file (e.g., ./artifacts/manifest_train.jsonl)",
    )
    parser.add_argument(
        "--test",
        type=Path,
        required=True,
        help="Output test manifest file (e.g., ./artifacts/manifest_test.jsonl)",
    )
    parser.add_argument(
        "--split",
        type=float,
        default=0.8,
        help="Train ratio (default: 0.8 = 80%% train, 20%% test)",
    )
    parser.add_argument(
        "--seed",
        type=int,
        default=42,
        help="Random seed for reproducibility (default: 42)",
    )
    parser.add_argument(
        "--split-by",
        choices=["day", "session"],
        default="day",
        help="Split by 'day' (recommended, avoids temporal leakage) or 'session' (default: day)",
    )

    args = parser.parse_args()

    split_manifest(
        manifest_path=args.manifest,
        train_path=args.train,
        test_path=args.test,
        train_ratio=args.split,
        seed=args.seed,
        split_by=args.split_by,
    )


if __name__ == "__main__":
    main()
