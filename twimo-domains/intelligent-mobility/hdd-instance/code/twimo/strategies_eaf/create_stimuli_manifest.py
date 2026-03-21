#!/usr/bin/env python
"""Create manifest for Stimuli training by swapping target paths.

This script takes the multi-target manifest (which points target_npy to target_goal/)
and creates a new manifest pointing to target_stimuli/ instead.

Usage:
    python strategies_EAF/create_stimuli_manifest.py \
      --input ./artifacts/eaf_multitarget/eaf_aligned/manifest_eaf_aligned_multitarget.jsonl \
      --output ./artifacts/eaf_multitarget/eaf_aligned/manifest_eaf_aligned_stimuli.jsonl
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path


def create_stimuli_manifest(input_manifest: Path, output_manifest: Path) -> int:
    """Create Stimuli manifest by swapping target_goal -> target_stimuli.

    Args:
        input_manifest: Input manifest (pointing to target_goal/)
        output_manifest: Output manifest (pointing to target_stimuli/)

    Returns:
        Number of records processed
    """
    records_processed = 0

    with open(input_manifest, 'r', encoding='utf-8') as f_in:
        with open(output_manifest, 'w', encoding='utf-8') as f_out:
            for line in f_in:
                record = json.loads(line)

                # Swap target_goal -> target_stimuli
                if 'target_npy' in record:
                    target_npy = record['target_npy']
                    if 'target_goal' in target_npy:
                        record['target_npy'] = target_npy.replace('target_goal', 'target_stimuli')

                f_out.write(json.dumps(record) + '\n')
                records_processed += 1

    return records_processed


def main():
    parser = argparse.ArgumentParser(
        description="Create Stimuli manifest by swapping target paths"
    )
    parser.add_argument(
        '--input',
        type=Path,
        required=True,
        help='Input manifest (pointing to target_goal/)',
    )
    parser.add_argument(
        '--output',
        type=Path,
        required=True,
        help='Output manifest (pointing to target_stimuli/)',
    )

    args = parser.parse_args()

    print("="*80)
    print("Creating Stimuli Manifest")
    print("="*80)
    print(f"Input:  {args.input}")
    print(f"Output: {args.output}")

    # Create output directory
    args.output.parent.mkdir(parents=True, exist_ok=True)

    # Process manifest
    n_records = create_stimuli_manifest(args.input, args.output)

    print(f"\n✅ Manifest created successfully!")
    print(f"   Records processed: {n_records}")
    print(f"   Output: {args.output}")

    print(f"\nNext step: Train Stimuli model")
    print(f"  python -m twimo.cli train-maneuver \\")
    print(f"    --manifest {args.output} \\")
    print(f"    --outdir ./artifacts/eaf_multitarget/maneuver_stimuli_transformer \\")
    print(f"    --model transformer \\")
    print(f"    --sample-hz 3 \\")
    print(f"    --epochs 10")

    print("="*80 + "\n")


if __name__ == '__main__':
    main()
