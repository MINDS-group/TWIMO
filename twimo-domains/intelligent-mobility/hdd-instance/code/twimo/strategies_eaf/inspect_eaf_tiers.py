#!/usr/bin/env python
"""Inspect EAF parsed files to see which TIERs and labels exist.

Usage:
    python strategies_EAF/inspect_eaf_tiers.py --eaf-parsed-dir ./eaf_parsed
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path
from collections import defaultdict


def inspect_eaf_files(eaf_parsed_dir: Path) -> None:
    """Inspect all parsed EAF files and report tiers and labels."""

    # Collect statistics
    all_tiers = defaultdict(lambda: {"count": 0, "labels": set()})
    files_with_tiers_grouped = 0
    files_without_tiers_grouped = 0
    total_files = 0

    json_files = [f for f in eaf_parsed_dir.glob('*.json') if f.name != 'summary.json']

    print("="*80)
    print("EAF TIER INSPECTION")
    print("="*80)
    print(f"Parsed directory: {eaf_parsed_dir}")
    print(f"Files to inspect: {len(json_files)}")
    print()

    # Inspect each file
    for json_file in json_files[:5]:  # Check first 5 files
        total_files += 1

        with open(json_file, encoding='utf-8') as f:
            data = json.load(f)

        print(f"\nFile: {json_file.name}")
        print(f"  Total annotations: {data.get('n_annotations', 0)}")

        # Check if tiers_grouped exists
        if 'tiers_grouped' in data:
            files_with_tiers_grouped += 1
            tiers_grouped = data['tiers_grouped']
            print(f"  ✅ Has 'tiers_grouped' field")
            print(f"  Tiers found: {list(tiers_grouped.keys())}")

            for tier_name, annotations in tiers_grouped.items():
                all_tiers[tier_name]["count"] += len(annotations)

                # Collect labels
                for ann in annotations:
                    label = ann.get('label', '').strip()
                    if label:
                        all_tiers[tier_name]["labels"].add(label)

                print(f"    - {tier_name}: {len(annotations)} annotations")
                # Show first 3 labels
                labels = [ann.get('label', '') for ann in annotations[:3]]
                if labels:
                    print(f"      Examples: {labels}")
        else:
            files_without_tiers_grouped += 1
            print(f"  ❌ Missing 'tiers_grouped' field!")
            print(f"  Available fields: {list(data.keys())}")

    if total_files < len(json_files):
        print(f"\n... and {len(json_files) - total_files} more files")

    # Summary
    print("\n" + "="*80)
    print("SUMMARY")
    print("="*80)
    print(f"Files inspected: {total_files}")
    print(f"Files with 'tiers_grouped': {files_with_tiers_grouped}")
    print(f"Files without 'tiers_grouped': {files_without_tiers_grouped}")

    if all_tiers:
        print(f"\nTiers found across all files:")
        for tier_name, stats in sorted(all_tiers.items()):
            print(f"\n  {tier_name}:")
            print(f"    Total annotations: {stats['count']}")
            print(f"    Unique labels: {len(stats['labels'])}")
            print(f"    Labels: {sorted(stats['labels'])[:10]}")
            if len(stats['labels']) > 10:
                print(f"      ... and {len(stats['labels']) - 10} more")
    else:
        print("\n❌ No tiers found!")

    # Recommendations
    print("\n" + "="*80)
    print("RECOMMENDATIONS")
    print("="*80)

    if files_without_tiers_grouped > 0:
        print("⚠️  Some files are missing 'tiers_grouped' field!")
        print("   This means they were parsed with an older version of parse_eaf.py")
        print("\n   FIX: Re-run parsing:")
        print(f"   python strategies_EAF/parse_eaf.py \\")
        print(f"     --eaf-dir ./path/to/eaf_files \\")
        print(f"     --output {eaf_parsed_dir}")

    if all_tiers:
        expected_tiers = {"Goal", "Stimuli", "Area", "Event", "Cause", "Attention"}
        found_tiers = set(all_tiers.keys())
        missing_tiers = expected_tiers - found_tiers
        extra_tiers = found_tiers - expected_tiers

        if missing_tiers:
            print(f"\n⚠️  Expected tiers not found: {missing_tiers}")
            print("   Your EAF files may use different tier names.")

        if extra_tiers:
            print(f"\n✅ Found additional tiers: {extra_tiers}")
            print("   These can also be used with --tier parameter")

        print(f"\n✅ To build vocabs for the tiers you have:")
        for tier_name in sorted(found_tiers):
            print(f"   python strategies_EAF/build_vocab.py \\")
            print(f"     --eaf-parsed-dir {eaf_parsed_dir} \\")
            print(f"     --tier {tier_name} \\")
            print(f"     --output ./vocabs/vocab_{tier_name.lower()}.json")
            print()

    print("="*80 + "\n")


def main():
    parser = argparse.ArgumentParser(description="Inspect EAF parsed files for tiers and labels")
    parser.add_argument(
        '--eaf-parsed-dir',
        type=Path,
        required=True,
        help='Directory containing parsed EAF JSON files',
    )

    args = parser.parse_args()

    if not args.eaf_parsed_dir.exists():
        print(f"❌ Directory not found: {args.eaf_parsed_dir}")
        return

    inspect_eaf_files(args.eaf_parsed_dir)


if __name__ == '__main__':
    main()
