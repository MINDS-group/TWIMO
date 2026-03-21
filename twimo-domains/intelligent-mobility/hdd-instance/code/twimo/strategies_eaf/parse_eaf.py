#!/usr/bin/env python
"""Parse ELAN Annotation Format (EAF) files to extract maneuver annotations.

This script parses EAF XML files and extracts:
- Time slots (timestamp in milliseconds)
- Tier annotations (maneuver labels with start/end times)
- Controlled vocabulary entries (CVE)

Usage:
    python strategies_EAF/parse_eaf.py \
      --eaf-file ./example_data/session_001/annotations.eaf \
      --output ./eaf_parsed/session_001.json
"""

from __future__ import annotations

import argparse
import json
import xml.etree.ElementTree as ET
from pathlib import Path
from typing import Dict, List, Tuple


def parse_eaf_file(eaf_path: Path) -> dict:
    """Parse EAF XML file and extract annotations.

    Args:
        eaf_path: Path to .eaf file

    Returns:
        Dictionary with:
            - time_slots: {slot_id: time_ms}
            - annotations: [{tier, start_ms, end_ms, label, cve_id}]
            - tiers: [tier_names]
            - media_url: video file path
    """
    tree = ET.parse(eaf_path)
    root = tree.getroot()

    # Parse TIME_ORDER (time slots)
    time_slots = {}
    time_order = root.find('TIME_ORDER')
    if time_order is not None:
        for time_slot in time_order.findall('TIME_SLOT'):
            slot_id = time_slot.get('TIME_SLOT_ID')
            time_value = time_slot.get('TIME_VALUE')
            if slot_id and time_value:
                time_slots[slot_id] = int(time_value)

    # Parse MEDIA_DESCRIPTOR (video URL)
    media_url = None
    header = root.find('HEADER')
    if header is not None:
        media_desc = header.find('MEDIA_DESCRIPTOR')
        if media_desc is not None:
            media_url = media_desc.get('RELATIVE_MEDIA_URL') or media_desc.get('MEDIA_URL')

    # Parse TIERs (annotations)
    annotations = []
    tier_names = []

    for tier in root.findall('TIER'):
        tier_id = tier.get('TIER_ID')
        tier_names.append(tier_id)

        for annotation in tier.findall('ANNOTATION'):
            # ALIGNABLE_ANNOTATION (aligned to time slots)
            alignable = annotation.find('ALIGNABLE_ANNOTATION')
            if alignable is not None:
                annotation_id = alignable.get('ANNOTATION_ID')
                ts_ref1 = alignable.get('TIME_SLOT_REF1')
                ts_ref2 = alignable.get('TIME_SLOT_REF2')
                cve_ref = alignable.get('CVE_REF')

                annotation_value_elem = alignable.find('ANNOTATION_VALUE')
                annotation_value = annotation_value_elem.text if annotation_value_elem is not None else ''

                if ts_ref1 in time_slots and ts_ref2 in time_slots:
                    annotations.append({
                        'tier': tier_id,
                        'annotation_id': annotation_id,
                        'start_ms': time_slots[ts_ref1],
                        'end_ms': time_slots[ts_ref2],
                        'label': annotation_value.strip() if annotation_value else '',
                        'cve_id': cve_ref,
                    })

    # Group annotations by tier for easier access
    tiers_grouped = {}
    for ann in annotations:
        tier = ann['tier']
        if tier not in tiers_grouped:
            tiers_grouped[tier] = []
        tiers_grouped[tier].append({
            'start_ms': ann['start_ms'],
            'end_ms': ann['end_ms'],
            'label': ann['label'],
        })

    return {
        'eaf_path': str(eaf_path),
        'media_url': media_url,
        'time_slots': time_slots,
        'tiers': tier_names,
        'annotations': annotations,
        'tiers_grouped': tiers_grouped,  # NEW: Annotations grouped by tier
        'n_annotations': len(annotations),
    }


def extract_unique_labels(annotations: List[dict]) -> List[str]:
    """Extract unique maneuver labels from annotations."""
    labels = set()
    for ann in annotations:
        label = ann['label']
        if label:
            labels.add(label)
    return sorted(labels)


def parse_eaf_directory(eaf_dir: Path, output_dir: Path) -> dict:
    """Parse all EAF files in a directory.

    Args:
        eaf_dir: Directory containing .eaf files
        output_dir: Directory to save parsed JSON files

    Returns:
        Summary dictionary with all labels found
    """
    output_dir.mkdir(parents=True, exist_ok=True)

    eaf_files = list(eaf_dir.rglob('*.eaf'))
    print(f"Found {len(eaf_files)} EAF files in {eaf_dir}")

    all_labels = set()
    parsed_files = []

    for eaf_file in eaf_files:
        try:
            parsed = parse_eaf_file(eaf_file)

            # Extract session ID from filename (e.g., "2017-02-27-10-17-27.eaf" → "2017-02-27-10-17-27")
            session_id = eaf_file.stem

            # Save parsed JSON
            output_path = output_dir / f"{session_id}.json"
            with open(output_path, 'w', encoding='utf-8') as f:
                json.dump(parsed, f, indent=2, ensure_ascii=False)

            # Collect unique labels
            labels = extract_unique_labels(parsed['annotations'])
            all_labels.update(labels)

            parsed_files.append({
                'session_id': session_id,
                'eaf_path': str(eaf_file),
                'json_path': str(output_path),
                'n_annotations': parsed['n_annotations'],
                'labels': labels,
            })

            print(f"  [{len(parsed_files)}/{len(eaf_files)}] {session_id}: {parsed['n_annotations']} annotations")

        except Exception as e:
            print(f"  [ERROR] Failed to parse {eaf_file}: {e}")

    # Save summary
    summary = {
        'eaf_dir': str(eaf_dir),
        'output_dir': str(output_dir),
        'n_files_parsed': len(parsed_files),
        'n_files_total': len(eaf_files),
        'all_labels': sorted(all_labels),
        'n_unique_labels': len(all_labels),
        'parsed_files': parsed_files,
    }

    summary_path = output_dir / 'summary.json'
    with open(summary_path, 'w', encoding='utf-8') as f:
        json.dump(summary, f, indent=2, ensure_ascii=False)

    print(f"\nSummary:")
    print(f"  Parsed: {len(parsed_files)}/{len(eaf_files)} files")
    print(f"  Unique labels: {len(all_labels)}")
    print(f"  Labels: {sorted(all_labels)}")
    print(f"  Summary saved to: {summary_path}")

    return summary


def main():
    parser = argparse.ArgumentParser(description="Parse EAF annotation files")
    parser.add_argument(
        '--eaf-file',
        type=Path,
        help='Single EAF file to parse',
    )
    parser.add_argument(
        '--eaf-dir',
        type=Path,
        help='Directory containing EAF files (scans recursively)',
    )
    parser.add_argument(
        '--output',
        type=Path,
        required=True,
        help='Output file or directory for parsed JSON',
    )

    args = parser.parse_args()

    if args.eaf_file:
        # Parse single file
        print(f"Parsing EAF file: {args.eaf_file}")
        parsed = parse_eaf_file(args.eaf_file)

        # Save to JSON
        args.output.parent.mkdir(parents=True, exist_ok=True)
        with open(args.output, 'w', encoding='utf-8') as f:
            json.dump(parsed, f, indent=2, ensure_ascii=False)

        print(f"Parsed {parsed['n_annotations']} annotations")
        print(f"Unique labels: {extract_unique_labels(parsed['annotations'])}")
        print(f"Saved to: {args.output}")

    elif args.eaf_dir:
        # Parse directory
        summary = parse_eaf_directory(args.eaf_dir, args.output)

    else:
        parser.error("Must specify either --eaf-file or --eaf-dir")


if __name__ == '__main__':
    main()
