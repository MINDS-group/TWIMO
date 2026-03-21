#!/usr/bin/env python
"""Build maneuver vocabulary from EAF annotations.

This script creates a mapping between maneuver labels (from EAF) and integer class IDs.

Usage:
    python twimo/strategies_eaf/build_vocab.py \
      --eaf-parsed-dir ./artifacts/eaf/parsed \
      --tier Goal \
      --output ./artifacts/eaf/vocabs/vocab_goal.json
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path
from typing import Dict, List, Optional


def _find_tier_key(tiers_grouped: Dict[str, List[dict]], keyword: str) -> Optional[str]:
    """Find tier key whose name contains 'keyword' (case-insensitive).

    This allows matching tier names like '主動的駕駛行為 Operation_Goal-oriented'
    when searching for "Goal".
    """
    kw = keyword.lower()
    for k in tiers_grouped.keys():
        if kw in k.lower():
            return k
    return None


def extract_all_labels(parsed_dir: Path, tier_filter: str | None = None) -> List[str]:
    """Extract all unique labels from parsed EAF JSON files.

    Args:
        parsed_dir: Directory containing parsed EAF JSON files
        tier_filter: If specified, only extract labels from this TIER (e.g., "Goal", "Stimuli")

    Returns:
        Sorted list of unique labels
    """
    labels = set()

    for json_file in parsed_dir.glob('*.json'):
        if json_file.name == 'summary.json':
            continue

        with open(json_file, encoding='utf-8') as f:
            data = json.load(f)

        # Use tiers_grouped if filtering by tier, otherwise use annotations
        if tier_filter:
            tiers_grouped = data.get('tiers_grouped', {})
            # Use substring matching to find tier (e.g., "Goal" matches "主動的駕駛行為 Operation_Goal-oriented")
            tier_key = _find_tier_key(tiers_grouped, tier_filter)
            tier_annotations = tiers_grouped.get(tier_key, []) if tier_key else []
            for ann in tier_annotations:
                label = ann.get('label', '').strip()
                if label:
                    labels.add(label)
        else:
            for ann in data.get('annotations', []):
                label = ann.get('label', '').strip()
                if label:
                    labels.add(label)

    return sorted(labels)


def normalize_label(label: str) -> str:
    """Normalize EAF label to canonical form.

    EAF labels often have both Chinese and English (e.g., "右轉 right turn").
    This function extracts the English part for consistency.
    """
    # Split by space and take English part
    parts = label.split()

    # If label has both Chinese and English, take English part
    # Examples:
    #   "右轉 right turn" → "right_turn"
    #   "穿過十字路口 intersection passing" → "intersection_passing"
    english_parts = [p for p in parts if p.isascii()]

    if english_parts:
        # Join English parts with underscore
        normalized = '_'.join(english_parts).lower()
        return normalized
    else:
        # Fallback: use original label (Chinese only)
        return label.replace(' ', '_').lower()


def build_vocab(parsed_dir: Path, tier_filter: str | None = None, include_unknown: bool = True) -> Dict[str, int]:
    """Build vocabulary mapping from EAF labels.

    Args:
        parsed_dir: Directory containing parsed EAF JSON files
        tier_filter: If specified, only build vocab from this TIER (e.g., "Goal", "Stimuli")
        include_unknown: If True, add "unknown" class for unmapped labels

    Returns:
        Dictionary {label_name: class_id}
    """
    # Extract all labels (optionally filtered by tier)
    raw_labels = extract_all_labels(parsed_dir, tier_filter=tier_filter)

    # Normalize labels
    label_map = {}
    for raw_label in raw_labels:
        normalized = normalize_label(raw_label)
        label_map[raw_label] = normalized

    # Get unique normalized labels
    unique_normalized = sorted(set(label_map.values()))

    # Build vocab: {normalized_label: class_id}
    vocab = {}

    if include_unknown:
        vocab['unknown'] = 0
        start_id = 1
    else:
        start_id = 0

    for i, label in enumerate(unique_normalized):
        vocab[label] = start_id + i

    return vocab, label_map


def main():
    parser = argparse.ArgumentParser(description="Build maneuver vocabulary from EAF annotations")
    parser.add_argument(
        '--eaf-parsed-dir',
        type=Path,
        required=True,
        help='Directory containing parsed EAF JSON files',
    )
    parser.add_argument(
        '--output',
        type=Path,
        required=True,
        help='Output vocab JSON file',
    )
    parser.add_argument(
        '--tier',
        type=str,
        default=None,
        help='Filter by TIER (e.g., "Goal", "Stimuli", "Area", "Event"). If not specified, uses all tiers.',
    )
    parser.add_argument(
        '--include-unknown',
        action='store_true',
        default=True,
        help='Include "unknown" class (default: True)',
    )

    args = parser.parse_args()

    tier_msg = f" (tier: {args.tier})" if args.tier else " (all tiers)"
    print(f"Building vocabulary from {args.eaf_parsed_dir}{tier_msg}...")

    # Build vocabulary
    vocab, label_map = build_vocab(
        args.eaf_parsed_dir,
        tier_filter=args.tier,
        include_unknown=args.include_unknown
    )

    # Save vocab
    args.output.parent.mkdir(parents=True, exist_ok=True)

    vocab_data = {
        'vocab': vocab,
        'label_map': label_map,
        'n_classes': len(vocab),
        'tier_filter': args.tier,  # NEW: Store which tier this vocab is for
        'include_unknown': args.include_unknown,
    }

    with open(args.output, 'w', encoding='utf-8') as f:
        json.dump(vocab_data, f, indent=2, ensure_ascii=False)

    print(f"\nVocabulary built:")
    print(f"  Total classes: {len(vocab)}")
    print(f"  Saved to: {args.output}")
    print(f"\nClass mapping:")
    for label, class_id in sorted(vocab.items(), key=lambda x: x[1]):
        print(f"  {class_id:2d}: {label}")


if __name__ == '__main__':
    main()
