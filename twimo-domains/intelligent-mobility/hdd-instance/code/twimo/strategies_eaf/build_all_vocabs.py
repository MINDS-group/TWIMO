#!/usr/bin/env python
"""Build all vocabularies for EAF tiers (Goal, Stimuli, Area, Event, Cause, Attention).

This helper script builds 6 separate vocabularies:
- vocab_goal.json: Maneuver target labels (from Goal tier)
- vocab_stimuli.json: Stimuli target labels (from Stimuli tier)
- vocab_area.json: Area feature labels (from Area tier)
- vocab_event.json: Event feature labels (from Event tier)
- vocab_cause.json: Cause feature labels (from Cause tier)
- vocab_attention.json: Attention feature labels (from Attention tier)

Usage:
    python twimo/strategies_eaf/build_all_vocabs.py \
      --eaf-parsed-dir ./artifacts/eaf/parsed \
      --output-dir ./artifacts/eaf/vocabs
"""

from __future__ import annotations

import argparse
import subprocess
from pathlib import Path


# Define the 6 tiers to build vocabularies for
TIERS = {
    'Goal': 'Maneuver target (e.g., left_turn, right_turn)',
    'Stimuli': 'Stimuli target (e.g., traffic_light, pedestrian)',
    'Area': 'Area feature (e.g., intersection, highway)',
    'Event': 'Event feature (e.g., lane_change, braking)',
    'Cause': 'Cause feature (e.g., traffic, obstacle)',
    'Attention': 'Attention feature (e.g., focused, distracted)',
}


def build_vocab_for_tier(
    tier_name: str,
    eaf_parsed_dir: Path,
    output_path: Path,
) -> bool:
    """Build vocabulary for a single tier using build_vocab.py.

    Returns:
        True if successful, False otherwise
    """
    print(f"\nBuilding vocab for tier: {tier_name}")
    print(f"  Output: {output_path}")

    cmd = [
        'python',
        'twimo/strategies_eaf/build_vocab.py',
        '--eaf-parsed-dir', str(eaf_parsed_dir),
        '--tier', tier_name,
        '--output', str(output_path),
    ]

    try:
        result = subprocess.run(cmd, check=True, capture_output=True, text=True)
        print(result.stdout)
        return True
    except subprocess.CalledProcessError as e:
        print(f"  ❌ Failed to build vocab for {tier_name}")
        print(e.stderr)
        return False


def main():
    parser = argparse.ArgumentParser(
        description="Build all EAF vocabularies (Goal, Stimuli, Area, Event, Cause, Attention)"
    )
    parser.add_argument(
        '--eaf-parsed-dir',
        type=Path,
        required=True,
        help='Directory containing parsed EAF JSON files',
    )
    parser.add_argument(
        '--output-dir',
        type=Path,
        required=True,
        help='Output directory for all vocab JSON files',
    )

    args = parser.parse_args()

    # Create output directory
    args.output_dir.mkdir(parents=True, exist_ok=True)

    print("="*80)
    print("Building EAF Vocabularies")
    print("="*80)
    print(f"EAF parsed dir: {args.eaf_parsed_dir}")
    print(f"Output dir:     {args.output_dir}")
    print(f"\nTiers to process:")
    for tier, desc in TIERS.items():
        print(f"  - {tier:12s}: {desc}")

    # Build vocab for each tier
    results = {}
    for tier_name in TIERS.keys():
        output_path = args.output_dir / f'vocab_{tier_name.lower()}.json'
        success = build_vocab_for_tier(tier_name, args.eaf_parsed_dir, output_path)
        results[tier_name] = success

    # Summary
    print("\n" + "="*80)
    print("SUMMARY")
    print("="*80)

    success_count = sum(results.values())
    total_count = len(results)

    for tier_name, success in results.items():
        status = "✅" if success else "❌"
        print(f"  {status} {tier_name}")

    print(f"\nCompleted: {success_count}/{total_count} vocabularies built successfully")

    if success_count == total_count:
        print("\n✅ All vocabularies built successfully!")
        print(f"\nNext step: Run alignment with these vocabs:")
        print(f"  python twimo/strategies_eaf/align_eaf_to_sensors_multitarget.py \\")
        print(f"    --eaf-parsed-dir {args.eaf_parsed_dir} \\")
        print(f"    --vocab-dir {args.output_dir} \\")
        print(f"    --manifest ./artifacts/manifest.jsonl \\")
        print(f"    --output-dir ./artifacts/eaf/aligned_multitarget")
    else:
        print("\n⚠️  Some vocabularies failed to build. Check errors above.")

    print("="*80 + "\n")


if __name__ == '__main__':
    main()
