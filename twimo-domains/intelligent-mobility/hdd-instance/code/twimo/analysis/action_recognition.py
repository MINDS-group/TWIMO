"""Action recognition from sensor data and annotations.

Recognizes driver actions and matches them with annotations:
- Goal-oriented actions (turns, lane changes, etc.)
- Reactive actions (stops, avoidance, etc.)
- Action-event correlation
"""

from __future__ import annotations

from typing import Dict, List, Optional, Tuple
import numpy as np
import pandas as pd

from twimo.features.eaf_parser import EAFData, Annotation
from twimo.analysis.event_detection import detect_all_events


def match_annotations_to_events(eaf_data: EAFData,
                                 detected_events: List[Dict],
                                 max_time_diff_ms: int = 2000) -> List[Dict]:
    """Match EAF annotations to sensor-detected events.

    Args:
        eaf_data: Parsed EAF annotation data
        detected_events: Events detected from sensors
        max_time_diff_ms: Maximum time difference for matching (ms)

    Returns:
        List of matched annotation-event pairs
    """
    matches = []

    for event in detected_events:
        event_start = event['start_ms']
        event_end = event['end_ms']
        event_mid = (event_start + event_end) // 2

        # Find overlapping annotations
        overlapping = eaf_data.get_annotations_in_range(
            event_start - max_time_diff_ms,
            event_end + max_time_diff_ms
        )

        for ann in overlapping:
            # Compute temporal overlap
            overlap_start = max(event_start, ann.start_ms)
            overlap_end = min(event_end, ann.end_ms)
            overlap_duration = max(0, overlap_end - overlap_start)

            # Compute time difference
            time_diff = min(
                abs(event_start - ann.start_ms),
                abs(event_end - ann.end_ms),
                abs(event_mid - (ann.start_ms + ann.end_ms) // 2)
            )

            if overlap_duration > 0 or time_diff <= max_time_diff_ms:
                matches.append({
                    'detected_event': event['event'],
                    'annotation': ann.value,
                    'tier': ann.tier_id,
                    'event_start_ms': event_start,
                    'event_end_ms': event_end,
                    'ann_start_ms': ann.start_ms,
                    'ann_end_ms': ann.end_ms,
                    'overlap_ms': overlap_duration,
                    'time_diff_ms': time_diff,
                    'match_quality': overlap_duration / max(event['duration_ms'], ann.duration_ms),
                })

    return sorted(matches, key=lambda x: x['match_quality'], reverse=True)


def build_action_sequences(eaf_data: EAFData,
                           detected_events: List[Dict],
                           time_window_ms: int = 10000) -> List[Dict]:
    """Build temporal sequences of actions for sequential modeling.

    Args:
        eaf_data: Parsed EAF data
        detected_events: Detected events from sensors
        time_window_ms: Time window for sequence grouping

    Returns:
        List of action sequences with context
    """
    # Combine annotations and detected events into unified timeline
    timeline = []

    # Add annotations
    for ann in eaf_data.annotations:
        timeline.append({
            'time_ms': ann.start_ms,
            'type': 'annotation',
            'value': ann.value,
            'tier': ann.tier_id,
            'duration_ms': ann.duration_ms,
        })

    # Add detected events
    for event in detected_events:
        timeline.append({
            'time_ms': event['start_ms'],
            'type': 'detected_event',
            'value': event['event'],
            'tier': 'sensor',
            'duration_ms': event.get('duration_ms', 0),
        })

    # Sort by time
    timeline.sort(key=lambda x: x['time_ms'])

    # Build sequences
    sequences = []
    current_sequence = []
    last_time = 0

    for item in timeline:
        time = item['time_ms']

        # Start new sequence if gap is too large
        if current_sequence and (time - last_time) > time_window_ms:
            if len(current_sequence) >= 2:
                sequences.append({
                    'sequence': current_sequence.copy(),
                    'start_ms': current_sequence[0]['time_ms'],
                    'end_ms': current_sequence[-1]['time_ms'],
                    'duration_ms': current_sequence[-1]['time_ms'] - current_sequence[0]['time_ms'],
                    'length': len(current_sequence),
                })
            current_sequence = []

        current_sequence.append(item)
        last_time = time

    # Add final sequence
    if len(current_sequence) >= 2:
        sequences.append({
            'sequence': current_sequence.copy(),
            'start_ms': current_sequence[0]['time_ms'],
            'end_ms': current_sequence[-1]['time_ms'],
            'duration_ms': current_sequence[-1]['time_ms'] - current_sequence[0]['time_ms'],
            'length': len(current_sequence),
        })

    return sequences


def extract_event_action_patterns(eaf_data: EAFData,
                                  detected_events: List[Dict]) -> Dict:
    """Extract common event->action patterns.

    Args:
        eaf_data: Parsed EAF data
        detected_events: Detected events from sensors

    Returns:
        Dictionary with pattern statistics
    """
    # Get event-action pairs from annotations
    cause_tier = None
    action_tier = None

    for tier_id in eaf_data.tiers.keys():
        if 'cause' in tier_id.lower() or 'event' in tier_id.lower():
            cause_tier = tier_id
        if 'stimuli' in tier_id.lower() or 'operation' in tier_id.lower():
            action_tier = tier_id

    patterns = {}

    if cause_tier and action_tier:
        causes = eaf_data.get_tier_annotations(cause_tier)
        actions = eaf_data.get_tier_annotations(action_tier)

        # Match causes to actions
        for cause in causes:
            # Find actions within 5 seconds after cause
            following_actions = [
                action for action in actions
                if cause.start_ms <= action.start_ms <= cause.end_ms + 5000
            ]

            for action in following_actions:
                pattern_key = f"{cause.value} -> {action.value}"
                if pattern_key not in patterns:
                    patterns[pattern_key] = {
                        'count': 0,
                        'avg_delay_ms': [],
                        'cause': cause.value,
                        'action': action.value,
                    }

                patterns[pattern_key]['count'] += 1
                patterns[pattern_key]['avg_delay_ms'].append(action.start_ms - cause.start_ms)

    # Compute average delays
    for pattern_key in patterns:
        delays = patterns[pattern_key]['avg_delay_ms']
        patterns[pattern_key]['avg_delay_ms'] = np.mean(delays)
        patterns[pattern_key]['std_delay_ms'] = np.std(delays)

    # Sort by frequency
    sorted_patterns = sorted(patterns.items(), key=lambda x: x[1]['count'], reverse=True)

    return {
        'patterns': dict(sorted_patterns),
        'total_patterns': len(patterns),
        'most_common': sorted_patterns[:10] if sorted_patterns else [],
    }


def compute_action_recognition_accuracy(eaf_data: EAFData,
                                       detected_events: List[Dict],
                                       tier_name: str = 'Goal-oriented') -> Dict:
    """Compute accuracy of sensor-based event detection vs annotations.

    Args:
        eaf_data: Ground truth annotations
        detected_events: Detected events from sensors
        tier_name: Tier to use as ground truth

    Returns:
        Dictionary with accuracy metrics
    """
    # Get ground truth annotations
    ground_truth = []
    for tier_id, annotations in eaf_data.tiers.items():
        if tier_name.lower() in tier_id.lower():
            ground_truth.extend(annotations)

    if not ground_truth:
        return {'error': 'No ground truth annotations found'}

    # Match detected events to ground truth
    matches = match_annotations_to_events(eaf_data, detected_events, max_time_diff_ms=3000)

    # Compute metrics
    true_positives = len([m for m in matches if m['match_quality'] > 0.3])
    false_positives = len(detected_events) - true_positives
    false_negatives = len(ground_truth) - true_positives

    precision = true_positives / (true_positives + false_positives) if (true_positives + false_positives) > 0 else 0
    recall = true_positives / (true_positives + false_negatives) if (true_positives + false_negatives) > 0 else 0
    f1 = 2 * precision * recall / (precision + recall) if (precision + recall) > 0 else 0

    return {
        'true_positives': true_positives,
        'false_positives': false_positives,
        'false_negatives': false_negatives,
        'precision': precision,
        'recall': recall,
        'f1_score': f1,
        'total_detected': len(detected_events),
        'total_ground_truth': len(ground_truth),
    }


def summarize_action_recognition(eaf_data: EAFData,
                                 detected_events: List[Dict]) -> Dict:
    """Complete summary of action recognition results.

    Args:
        eaf_data: Parsed EAF data
        detected_events: Detected events from sensors

    Returns:
        Comprehensive summary dictionary
    """
    matches = match_annotations_to_events(eaf_data, detected_events)
    sequences = build_action_sequences(eaf_data, detected_events)
    patterns = extract_event_action_patterns(eaf_data, detected_events)

    # Find best matching tier for accuracy
    best_accuracy = None
    for tier_id in eaf_data.tiers.keys():
        if 'goal' in tier_id.lower() or 'operation' in tier_id.lower():
            accuracy = compute_action_recognition_accuracy(eaf_data, detected_events, tier_id)
            if best_accuracy is None or accuracy.get('f1_score', 0) > best_accuracy.get('f1_score', 0):
                best_accuracy = accuracy
                best_accuracy['tier'] = tier_id

    return {
        'num_matches': len(matches),
        'num_sequences': len(sequences),
        'avg_sequence_length': np.mean([s['length'] for s in sequences]) if sequences else 0,
        'patterns': patterns,
        'accuracy': best_accuracy,
        'high_quality_matches': len([m for m in matches if m['match_quality'] > 0.5]),
    }
