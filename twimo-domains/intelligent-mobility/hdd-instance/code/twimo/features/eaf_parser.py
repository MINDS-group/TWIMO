"""ELAN Annotation File (.eaf) parser for driving behavior annotations.

Parses ELAN XML files containing multi-level annotations:
- Goal-oriented actions (turns, lane changes, etc.)
- Environmental causes (red light, pedestrian, etc.)
- Attention events
- Stimuli-driven reactions
"""

from __future__ import annotations

import xml.etree.ElementTree as ET
from pathlib import Path
from typing import Dict, List, Optional, Tuple
from dataclasses import dataclass


@dataclass
class Annotation:
    """Single annotation with temporal bounds."""
    tier_id: str
    annotation_id: str
    start_ms: int
    end_ms: int
    value: str

    @property
    def duration_ms(self) -> int:
        return self.end_ms - self.start_ms

    @property
    def duration_sec(self) -> float:
        return self.duration_ms / 1000.0


@dataclass
class EAFData:
    """Complete ELAN annotation data."""
    media_url: str
    annotations: List[Annotation]
    time_slots: Dict[str, int]
    tiers: Dict[str, List[Annotation]]
    controlled_vocab: Dict[str, Dict[str, str]]

    def get_annotations_at_time(self, time_ms: int) -> List[Annotation]:
        """Get all annotations active at given time."""
        return [
            ann for ann in self.annotations
            if ann.start_ms <= time_ms <= ann.end_ms
        ]

    def get_annotations_in_range(self, start_ms: int, end_ms: int) -> List[Annotation]:
        """Get all annotations overlapping with time range."""
        return [
            ann for ann in self.annotations
            if not (ann.end_ms < start_ms or ann.start_ms > end_ms)
        ]

    def get_tier_annotations(self, tier_id: str) -> List[Annotation]:
        """Get all annotations for a specific tier."""
        return self.tiers.get(tier_id, [])


def parse_eaf_file(eaf_path: Path) -> Optional[EAFData]:
    """Parse ELAN annotation file.

    Args:
        eaf_path: Path to .eaf XML file

    Returns:
        EAFData object with all annotations, or None if parsing fails
    """
    if not eaf_path.exists():
        print(f"[Error] EAF file not found: {eaf_path}")
        return None

    try:
        tree = ET.parse(eaf_path)
        root = tree.getroot()

        # Extract media URL
        media_url = ""
        media_desc = root.find('.//MEDIA_DESCRIPTOR')
        if media_desc is not None:
            media_url = media_desc.get('RELATIVE_MEDIA_URL', '')
            if not media_url:
                media_url = media_desc.get('MEDIA_URL', '')

        # Parse time slots
        time_slots = {}
        for ts in root.findall('.//TIME_SLOT'):
            slot_id = ts.get('TIME_SLOT_ID')
            time_value = int(ts.get('TIME_VALUE', 0))
            time_slots[slot_id] = time_value

        # Parse controlled vocabulary
        controlled_vocab = {}
        for cv in root.findall('.//CONTROLLED_VOCABULARY'):
            cv_id = cv.get('CV_ID')
            entries = {}
            for entry in cv.findall('.//CV_ENTRY_ML'):
                entry_id = entry.get('CVE_ID')
                value = entry.find('CVE_VALUE').text if entry.find('CVE_VALUE') is not None else ''
                entries[entry_id] = value
            controlled_vocab[cv_id] = entries

        # Parse annotations by tier
        tiers = {}
        all_annotations = []

        for tier in root.findall('.//TIER'):
            tier_id = tier.get('TIER_ID')
            tier_annotations = []

            for ann in tier.findall('.//ALIGNABLE_ANNOTATION'):
                ann_id = ann.get('ANNOTATION_ID')
                ts_ref1 = ann.get('TIME_SLOT_REF1')
                ts_ref2 = ann.get('TIME_SLOT_REF2')

                start_ms = time_slots.get(ts_ref1, 0)
                end_ms = time_slots.get(ts_ref2, 0)

                ann_value_elem = ann.find('ANNOTATION_VALUE')
                value = ann_value_elem.text if ann_value_elem is not None and ann_value_elem.text else ''

                annotation = Annotation(
                    tier_id=tier_id,
                    annotation_id=ann_id,
                    start_ms=start_ms,
                    end_ms=end_ms,
                    value=value
                )

                tier_annotations.append(annotation)
                all_annotations.append(annotation)

            tiers[tier_id] = tier_annotations

        # Sort annotations by start time
        all_annotations.sort(key=lambda x: x.start_ms)

        return EAFData(
            media_url=media_url,
            annotations=all_annotations,
            time_slots=time_slots,
            tiers=tiers,
            controlled_vocab=controlled_vocab
        )

    except Exception as e:
        print(f"[Error] Failed to parse EAF file {eaf_path}: {e}")
        return None


def extract_event_sequence(eaf_data: EAFData, tier_name: str) -> List[Tuple[int, int, str]]:
    """Extract temporal sequence of events from a tier.

    Args:
        eaf_data: Parsed EAF data
        tier_name: Name of tier to extract (substring match)

    Returns:
        List of (start_ms, end_ms, event_label) tuples
    """
    sequence = []

    for tier_id, annotations in eaf_data.tiers.items():
        if tier_name.lower() in tier_id.lower():
            for ann in annotations:
                sequence.append((ann.start_ms, ann.end_ms, ann.value))

    return sorted(sequence, key=lambda x: x[0])


def categorize_annotation(annotation: Annotation) -> Dict[str, str]:
    """Categorize annotation into semantic groups.

    Returns:
        Dictionary with category information
    """
    value = annotation.value.lower()

    # Event/Cause categories
    if 'light' in value or 'red' in value or 'yellow' in value or 'green' in value:
        category = 'traffic_signal'
    elif 'pedestrian' in value or 'crossing' in value:
        category = 'pedestrian'
    elif 'vehicle' in value or 'car' in value or 'merging' in value:
        category = 'vehicle'
    elif 'congestion' in value or 'traffic' in value:
        category = 'congestion'
    elif 'sign' in value or 'road work' in value:
        category = 'infrastructure'
    # Action categories
    elif 'turn' in value:
        if 'right' in value:
            category = 'right_turn'
        elif 'left' in value:
            category = 'left_turn'
        else:
            category = 'turn'
    elif 'lane change' in value or 'lane-change' in value:
        category = 'lane_change'
    elif 'stop' in value:
        category = 'stop'
    elif 'passing' in value:
        category = 'passing'
    else:
        category = 'other'

    return {
        'category': category,
        'raw_value': annotation.value,
        'tier': annotation.tier_id
    }


def build_event_action_pairs(eaf_data: EAFData,
                              event_tier: str = 'Cause',
                              action_tier: str = 'Stimuli-driven') -> List[Dict]:
    """Build pairs of (event, action) for causal modeling.

    Args:
        eaf_data: Parsed EAF data
        event_tier: Tier containing events/causes
        action_tier: Tier containing driver reactions

    Returns:
        List of event-action pairs with temporal info
    """
    pairs = []

    # Get event and action annotations
    events = []
    actions = []

    for tier_id, annotations in eaf_data.tiers.items():
        if event_tier.lower() in tier_id.lower():
            events.extend(annotations)
        if action_tier.lower() in tier_id.lower():
            actions.extend(annotations)

    # Match events to subsequent actions (within reasonable time window)
    max_delay_ms = 5000  # Max 5 seconds between event and action

    for event in events:
        # Find actions that start during or shortly after this event
        matching_actions = [
            action for action in actions
            if event.start_ms <= action.start_ms <= event.end_ms + max_delay_ms
        ]

        for action in matching_actions:
            pairs.append({
                'event': event.value,
                'action': action.value,
                'event_start_ms': event.start_ms,
                'event_end_ms': event.end_ms,
                'action_start_ms': action.start_ms,
                'action_end_ms': action.end_ms,
                'delay_ms': action.start_ms - event.start_ms,
                'event_category': categorize_annotation(event)['category'],
                'action_category': categorize_annotation(action)['category'],
            })

    return pairs


def summarize_eaf_data(eaf_data: EAFData) -> Dict:
    """Create summary statistics for EAF data.

    Returns:
        Dictionary with summary statistics
    """
    total_duration_ms = max(ann.end_ms for ann in eaf_data.annotations) if eaf_data.annotations else 0

    tier_stats = {}
    for tier_id, annotations in eaf_data.tiers.items():
        tier_stats[tier_id] = {
            'count': len(annotations),
            'total_duration_ms': sum(ann.duration_ms for ann in annotations),
            'avg_duration_ms': sum(ann.duration_ms for ann in annotations) / len(annotations) if annotations else 0,
        }

    # Event distribution
    event_counts = {}
    for ann in eaf_data.annotations:
        cat = categorize_annotation(ann)['category']
        event_counts[cat] = event_counts.get(cat, 0) + 1

    return {
        'total_annotations': len(eaf_data.annotations),
        'total_duration_ms': total_duration_ms,
        'total_duration_sec': total_duration_ms / 1000.0,
        'num_tiers': len(eaf_data.tiers),
        'tier_statistics': tier_stats,
        'event_distribution': event_counts,
    }
