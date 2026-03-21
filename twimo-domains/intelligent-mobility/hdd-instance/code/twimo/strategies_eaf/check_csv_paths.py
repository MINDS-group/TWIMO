#!/usr/bin/env python
"""Check CSV paths in manifest to diagnose alignment issues.

Usage:
    python strategies_EAF/check_csv_paths.py --manifest ./artifacts/manifest.jsonl
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path


def check_manifest_csv_paths(manifest_path: Path) -> None:
    """Check CSV paths in manifest and verify they exist."""

    print("="*80)
    print("CSV PATH VERIFICATION")
    print("="*80)
    print(f"Manifest: {manifest_path}\n")

    # Load manifest
    records = []
    with open(manifest_path, 'r', encoding='utf-8') as f:
        for line in f:
            records.append(json.loads(line))

    print(f"Total sessions in manifest: {len(records)}\n")

    # Check first 5 sessions
    csv_exists = 0
    csv_missing = 0

    for i, record in enumerate(records[:10]):
        session_id = record.get('session_id', 'unknown')
        csv_dir = record.get('csv_dir', '')

        print(f"Session {i+1}: {session_id}")
        print(f"  csv_dir: {csv_dir}")

        csv_path = Path(csv_dir)
        if csv_path.exists():
            print(f"  ✅ Directory exists")
            csv_exists += 1

            # List CSV files
            csv_files = list(csv_path.glob('**/*.csv'))
            if csv_files:
                print(f"  CSV files found: {len(csv_files)}")
                # Show first 5
                for csv_file in csv_files[:5]:
                    rel_path = csv_file.relative_to(csv_path)
                    print(f"    - {rel_path}")
                if len(csv_files) > 5:
                    print(f"    ... and {len(csv_files) - 5} more")
            else:
                print(f"  ⚠️  No CSV files found")
        else:
            print(f"  ❌ Directory does NOT exist")
            csv_missing += 1

        print()

    if len(records) > 10:
        print(f"... and {len(records) - 10} more sessions")

    # Summary
    print("="*80)
    print("SUMMARY")
    print("="*80)
    print(f"CSV directories exist:    {csv_exists}/{min(10, len(records))} (checked first 10)")
    print(f"CSV directories missing:  {csv_missing}/{min(10, len(records))}")

    if csv_missing > 0:
        print(f"\n⚠️  Some CSV directories are missing!")
        print(f"\nPossible solutions:")
        print(f"  1. Update manifest with correct csv_dir paths")
        print(f"  2. Re-run manifest generation:")
        print(f"     python -m twimo.cli scan \\")
        print(f"       --root ./path/to/your/data \\")
        print(f"       --out ./artifacts/manifest.jsonl")

    print("="*80 + "\n")


def main():
    parser = argparse.ArgumentParser(description="Check CSV paths in manifest")
    parser.add_argument(
        '--manifest',
        type=Path,
        required=True,
        help='Path to manifest.jsonl file',
    )

    args = parser.parse_args()

    if not args.manifest.exists():
        print(f"❌ Manifest not found: {args.manifest}")
        return

    check_manifest_csv_paths(args.manifest)


if __name__ == '__main__':
    main()
