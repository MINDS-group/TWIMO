#!/usr/bin/env python
"""Build all vocabularies for EAF tiers with Chinese/bilingual names.

This script builds vocabularies using only the English part of tier names.

Usage:
    python strategies_EAF/build_all_vocabs_chinese.py \
      --eaf-parsed-dir ./eaf_parsed \
      --output-dir ./vocabs
"""

from __future__ import annotations

import argparse
import json
import re
from pathlib import Path
from typing import Dict, Tuple


def extract_english_tier_name(full_tier_name: str) -> str:
    """Extract English part from bilingual tier name.

    Examples:
        "主動的駕駛行為 Operation_Goal-oriented" → "Operation_Goal-oriented"
        "區域 Area" → "Area"
        "注意-1 Attention" → "Attention"
    """
    # Split by space and take ASCII parts
    parts = full_tier_name.split()
    english_parts = [p for p in parts if p.replace('-', '').replace('_', '').isascii()]

    if english_parts:
        return ' '.join(english_parts)
    else:
        # Fallback: return as-is
        return full_tier_name


def detect_tier_names(eaf_parsed_dir: Path) -> Dict[str, str]:
    """Auto-detect tier names from parsed EAF files.

    Returns:
        {tier_key: full_tier_name} mapping
    """
    # Check first few files to find tier names
    json_files = [f for f in eaf_parsed_dir.glob('*.json') if f.name != 'summary.json']

    if not json_files:
        return {}

    # Load first file
    with open(json_files[0], encoding='utf-8') as f:
        data = json.load(f)

    tiers_grouped = data.get('tiers_grouped', {})

    # Build mapping based on English keywords
    tier_mapping = {}

    for tier_name in tiers_grouped.keys():
        english_name = extract_english_tier_name(tier_name).lower()

        if 'goal' in english_name or 'operation_goal' in english_name:
            tier_mapping['goal'] = tier_name
        elif 'stimuli' in english_name or 'operation_stimuli' in english_name:
            tier_mapping['stimuli'] = tier_name
        elif 'area' in english_name and 'note' not in english_name:
            tier_mapping['area'] = tier_name
        elif 'cause' in english_name:
            tier_mapping['cause'] = tier_name
        elif 'attention' in english_name and '2' not in tier_name:
            tier_mapping['attention'] = tier_name

    return tier_mapping


# Define expected tier keys
TIER_KEYS = ['goal', 'stimuli', 'area', 'cause', 'attention']

TIER_DESCRIPTIONS = {
    'goal': 'Goal maneuver (e.g., left_turn, right_turn)',
    'stimuli': 'Stimuli (e.g., stop_4_light, stop_4_sign)',
    'area': 'Area (e.g., downtown, freeway)',
    'cause': 'Cause (e.g., congestion, crossing_vehicle)',
    'attention': 'Attention (e.g., red_light, crossing_vehicle)',
}


def build_vocab_for_tier_direct(
    tier_key: str,
    tier_name: str,
    eaf_parsed_dir: Path,
    output_path: Path,
) -> bool:
    """Build vocabulary for a single tier directly (without subprocess).

    This avoids Unicode encoding issues on Windows by directly calling the functions
    instead of using subprocess.

    Args:
        tier_key: Short key for output filename (e.g., 'goal')
        tier_name: Actual tier name in EAF (full name with Chinese)
        eaf_parsed_dir: Directory with parsed EAF JSON files
        output_path: Output vocab JSON path

    Returns:
        True if successful, False otherwise
    """
    print(f"\nBuilding vocab for: {tier_key}")
    english_name = extract_english_tier_name(tier_name)
    print(f"  Tier: {english_name}")
    print(f"  Output: {output_path}")

    try:
        # Import build_vocab functions directly to avoid subprocess encoding issues
        import sys
        sys.path.insert(0, str(Path(__file__).parent))

        from build_vocab import build_vocab

        # Build vocab using the FULL tier name (including Chinese)
        vocab, label_map = build_vocab(
            eaf_parsed_dir,
            tier_filter=tier_name,  # Use full name for filtering
            include_unknown=True
        )

        # Save vocab
        output_path.parent.mkdir(parents=True, exist_ok=True)

        vocab_data = {
            'vocab': vocab,
            'label_map': label_map,
            'n_classes': len(vocab),
            'tier_filter': tier_name,
            'include_unknown': True,
        }

        with open(output_path, 'w', encoding='utf-8') as f:
            json.dump(vocab_data, f, indent=2, ensure_ascii=False)

        print(f"  Total classes: {len(vocab)}")
        print(f"  Saved to: {output_path}")

        # Show class mapping
        for label, class_id in sorted(vocab.items(), key=lambda x: x[1])[:5]:
            print(f"    {class_id:2d}: {label}")
        if len(vocab) > 5:
            print(f"    ... and {len(vocab) - 5} more")

        return True

    except Exception as e:
        print(f"  Failed to build vocab for {tier_key}: {e}")
        import traceback
        traceback.print_exc()
        return False


def main():
    parser = argparse.ArgumentParser(
        description="Build all EAF vocabularies (auto-detects Chinese/bilingual tier names)"
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
    print("Building EAF Vocabularies (Auto-Detect Tier Names)")
    print("="*80)
    print(f"EAF parsed dir: {args.eaf_parsed_dir}")
    print(f"Output dir:     {args.output_dir}")

    # Auto-detect tier names
    print(f"\nAuto-detecting tier names from EAF files...")
    tier_mapping = detect_tier_names(args.eaf_parsed_dir)

    if not tier_mapping:
        print("  No tiers found! Check that EAF files are parsed correctly.")
        return

    print(f"  Found {len(tier_mapping)} tiers:")
    for tier_key, tier_name in tier_mapping.items():
        english_name = extract_english_tier_name(tier_name)
        desc = TIER_DESCRIPTIONS.get(tier_key, '')
        print(f"    {tier_key:12s}: {english_name}")
        if desc:
            print(f"      {desc}")

    # Build vocab for each tier
    print(f"\nBuilding vocabularies...")
    results = {}
    for tier_key in TIER_KEYS:
        if tier_key not in tier_mapping:
            print(f"\n  Skipping {tier_key}: not found in EAF files")
            continue

        tier_name = tier_mapping[tier_key]
        output_path = args.output_dir / f'vocab_{tier_key}.json'
        success = build_vocab_for_tier_direct(tier_key, tier_name, args.eaf_parsed_dir, output_path)
        results[tier_key] = success

    # Summary
    print("\n" + "="*80)
    print("SUMMARY")
    print("="*80)

    success_count = sum(results.values())
    total_count = len(results)

    for tier_key, success in results.items():
        status = "✅" if success else "❌"
        tier_name = tier_mapping.get(tier_key, 'unknown')
        english_name = extract_english_tier_name(tier_name)
        print(f"  {status} {tier_key:12s} ({english_name})")

    print(f"\nCompleted: {success_count}/{total_count} vocabularies built successfully")

    if success_count == total_count:
        print("\n✅ All vocabularies built successfully!")
        print(f"\nNext step: Run alignment with these vocabs:")
        print(f"  python strategies_EAF/align_eaf_to_sensors_multitarget.py \\")
        print(f"    --eaf-parsed-dir {args.eaf_parsed_dir} \\")
        print(f"    --vocab-dir {args.output_dir} \\")
        print(f"    --manifest ./artifacts/manifest.jsonl \\")
        print(f"    --output-dir ./artifacts/eaf_aligned_multitarget \\")
        print(f"    --sample-hz 3")
    else:
        print("\n⚠️  Some vocabularies failed to build. Check errors above.")

    print("="*80 + "\n")


if __name__ == '__main__':
    main()
