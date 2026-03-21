"""Sequential modeling for event->action prediction.

Models temporal sequences to predict driver actions from events.
Uses simple statistical models and transition matrices.
"""

from __future__ import annotations

from typing import Dict, List, Tuple, Optional
import numpy as np
import pandas as pd
from collections import defaultdict, Counter


class SequentialModel:
    """Statistical model for event->action sequences."""

    def __init__(self):
        self.transitions = defaultdict(Counter)  # event -> {action: count}
        self.event_counts = Counter()
        self.action_counts = Counter()
        self.trained = False

    def train(self, sequences: List[Dict]):
        """Train model on action sequences.

        Args:
            sequences: List of sequences from build_action_sequences()
        """
        for seq_data in sequences:
            sequence = seq_data['sequence']

            # Extract event-action pairs
            for i in range(len(sequence) - 1):
                current = sequence[i]
                next_item = sequence[i + 1]

                # Simplified: treat each item as both event and potential action
                current_value = self._normalize_value(current['value'])
                next_value = self._normalize_value(next_item['value'])

                # Update transitions
                self.transitions[current_value][next_value] += 1
                self.event_counts[current_value] += 1
                self.action_counts[next_value] += 1

        self.trained = True

    def _normalize_value(self, value: str) -> str:
        """Normalize annotation/event value to canonical form."""
        value = value.lower().strip()

        # Simplify Chinese/English mixed annotations
        if 'turn' in value or '轉' in value:
            if 'right' in value or '右' in value:
                return 'right_turn'
            elif 'left' in value or '左' in value:
                return 'left_turn'
            return 'turn'
        elif 'stop' in value or '停' in value:
            return 'stop'
        elif 'light' in value or '燈' in value:
            if 'red' in value or '紅' in value:
                return 'red_light'
            elif 'yellow' in value or '黃' in value:
                return 'yellow_light'
            elif 'green' in value or '綠' in value:
                return 'green_light'
            return 'traffic_light'
        elif 'pedestrian' in value or '行人' in value:
            return 'pedestrian'
        elif 'lane' in value and 'change' in value:
            return 'lane_change'
        elif 'congestion' in value or '壅塞' in value:
            return 'congestion'
        elif 'vehicle' in value or '車' in value:
            return 'vehicle'
        else:
            return value

    def predict_next_action(self, event: str, top_k: int = 3) -> List[Tuple[str, float]]:
        """Predict most likely next actions given an event.

        Args:
            event: Current event
            top_k: Number of top predictions to return

        Returns:
            List of (action, probability) tuples
        """
        if not self.trained:
            return []

        event = self._normalize_value(event)

        if event not in self.transitions:
            # Return most common actions overall
            total = sum(self.action_counts.values())
            if total == 0:
                return []
            common_actions = self.action_counts.most_common(top_k)
            return [(action, count / total) for action, count in common_actions]

        # Get transition probabilities
        action_counts = self.transitions[event]
        total = sum(action_counts.values())

        if total == 0:
            return []

        # Compute probabilities
        probabilities = [(action, count / total) for action, count in action_counts.items()]
        probabilities.sort(key=lambda x: x[1], reverse=True)

        return probabilities[:top_k]

    def get_transition_matrix(self) -> pd.DataFrame:
        """Get full transition probability matrix.

        Returns:
            DataFrame with events as rows, actions as columns
        """
        if not self.trained:
            return pd.DataFrame()

        # Get all unique events and actions
        all_events = sorted(self.transitions.keys())
        all_actions = sorted(self.action_counts.keys())

        # Build matrix
        matrix = np.zeros((len(all_events), len(all_actions)))

        for i, event in enumerate(all_events):
            action_counts = self.transitions[event]
            total = sum(action_counts.values())

            if total > 0:
                for j, action in enumerate(all_actions):
                    matrix[i, j] = action_counts[action] / total

        return pd.DataFrame(matrix, index=all_events, columns=all_actions)

    def evaluate(self, test_sequences: List[Dict]) -> Dict:
        """Evaluate model on test sequences.

        Args:
            test_sequences: List of test sequences

        Returns:
            Dictionary with evaluation metrics
        """
        if not self.trained:
            return {'error': 'Model not trained'}

        correct_top1 = 0
        correct_top3 = 0
        total = 0

        for seq_data in test_sequences:
            sequence = seq_data['sequence']

            for i in range(len(sequence) - 1):
                current = self._normalize_value(sequence[i]['value'])
                actual_next = self._normalize_value(sequence[i + 1]['value'])

                predictions = self.predict_next_action(current, top_k=3)

                if predictions:
                    # Top-1 accuracy
                    if predictions[0][0] == actual_next:
                        correct_top1 += 1

                    # Top-3 accuracy
                    if any(pred[0] == actual_next for pred in predictions):
                        correct_top3 += 1

                total += 1

        return {
            'total_predictions': total,
            'top1_accuracy': correct_top1 / total if total > 0 else 0,
            'top3_accuracy': correct_top3 / total if total > 0 else 0,
            'correct_top1': correct_top1,
            'correct_top3': correct_top3,
        }

    def get_most_common_sequences(self, length: int = 3, top_k: int = 10) -> List[Tuple[List[str], int]]:
        """Find most common action sequences of given length.

        Args:
            length: Sequence length
            top_k: Number of top sequences to return

        Returns:
            List of (sequence, count) tuples
        """
        # This requires storing full sequences during training
        # For now, return most common single transitions
        common_pairs = []

        for event, action_counts in self.transitions.items():
            for action, count in action_counts.items():
                common_pairs.append(([event, action], count))

        common_pairs.sort(key=lambda x: x[1], reverse=True)
        return common_pairs[:top_k]

    def summary(self) -> Dict:
        """Get model summary statistics.

        Returns:
            Dictionary with model statistics
        """
        if not self.trained:
            return {'trained': False}

        return {
            'trained': True,
            'num_unique_events': len(self.event_counts),
            'num_unique_actions': len(self.action_counts),
            'num_transitions': sum(sum(counts.values()) for counts in self.transitions.values()),
            'most_common_events': self.event_counts.most_common(5),
            'most_common_actions': self.action_counts.most_common(5),
            'avg_actions_per_event': np.mean([len(counts) for counts in self.transitions.values()]) if self.transitions else 0,
        }


def analyze_temporal_patterns(sequences: List[Dict]) -> Dict:
    """Analyze temporal patterns in action sequences.

    Args:
        sequences: List of action sequences

    Returns:
        Dictionary with temporal pattern analysis
    """
    if not sequences:
        return {'error': 'No sequences provided'}

    # Analyze sequence lengths
    lengths = [seq['length'] for seq in sequences]
    durations = [seq['duration_ms'] for seq in sequences]

    # Analyze inter-event times
    inter_event_times = []
    for seq_data in sequences:
        sequence = seq_data['sequence']
        for i in range(len(sequence) - 1):
            time_diff = sequence[i + 1]['time_ms'] - sequence[i]['time_ms']
            inter_event_times.append(time_diff)

    # Analyze event types distribution
    event_types = []
    for seq_data in sequences:
        for item in seq_data['sequence']:
            event_types.append(item['value'])

    event_distribution = Counter(event_types)

    return {
        'num_sequences': len(sequences),
        'sequence_length': {
            'mean': np.mean(lengths),
            'std': np.std(lengths),
            'min': min(lengths),
            'max': max(lengths),
            'median': np.median(lengths),
        },
        'sequence_duration_ms': {
            'mean': np.mean(durations),
            'std': np.std(durations),
            'min': min(durations),
            'max': max(durations),
            'median': np.median(durations),
        },
        'inter_event_time_ms': {
            'mean': np.mean(inter_event_times) if inter_event_times else 0,
            'std': np.std(inter_event_times) if inter_event_times else 0,
            'median': np.median(inter_event_times) if inter_event_times else 0,
        },
        'event_distribution': dict(event_distribution.most_common(10)),
        'total_events': len(event_types),
    }
