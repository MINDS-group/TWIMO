"""Event detection from sensor data.

Detects driving events from telemetry:
- Stops (for light, sign, pedestrian, congestion)
- Turns (left, right)
- Lane changes
- Hard braking
- Hard acceleration
"""

from __future__ import annotations

from typing import Dict, List, Tuple
import numpy as np
import pandas as pd


def detect_stops(df: pd.DataFrame,
                 velocity_col: str = 'velocity',
                 timestamp_col: str = 'timestamp',
                 stop_threshold: float = 2.0,
                 min_stop_duration_ms: int = 2000) -> List[Dict]:
    """Detect stop events.

    Args:
        df: DataFrame with velocity and timestamp
        velocity_col: Name of velocity column (m/s)
        timestamp_col: Name of timestamp column (ms)
        stop_threshold: Velocity threshold for stopped (m/s)
        min_stop_duration_ms: Minimum duration to count as stop

    Returns:
        List of stop events with start/end times and duration
    """
    if velocity_col not in df.columns or timestamp_col not in df.columns:
        return []

    vel = df[velocity_col].values
    times = df[timestamp_col].values

    # Find stopped periods
    stopped = vel < stop_threshold

    # Find transitions
    stop_starts = np.where(np.diff(stopped.astype(int)) == 1)[0] + 1
    stop_ends = np.where(np.diff(stopped.astype(int)) == -1)[0] + 1

    # Handle edge cases
    if stopped[0]:
        stop_starts = np.concatenate([[0], stop_starts])
    if stopped[-1]:
        stop_ends = np.concatenate([stop_ends, [len(stopped) - 1]])

    # Build stop events
    stops = []
    for start_idx, end_idx in zip(stop_starts, stop_ends):
        if start_idx < len(times) and end_idx < len(times):
            start_time = times[start_idx]
            end_time = times[end_idx]
            duration = end_time - start_time

            if duration >= min_stop_duration_ms:
                stops.append({
                    'event': 'stop',
                    'start_ms': int(start_time),
                    'end_ms': int(end_time),
                    'duration_ms': int(duration),
                    'start_idx': int(start_idx),
                    'end_idx': int(end_idx),
                })

    return stops


def detect_turns(df: pd.DataFrame,
                 steer_col: str = 'steer',
                 velocity_col: str = 'velocity',
                 timestamp_col: str = 'timestamp',
                 steer_threshold: float = 45.0,
                 min_velocity: float = 1.0) -> List[Dict]:
    """Detect turn events (left/right).

    Args:
        df: DataFrame with steering, velocity, timestamp
        steer_col: Name of steering angle column (degrees)
        velocity_col: Name of velocity column (m/s)
        timestamp_col: Name of timestamp column (ms)
        steer_threshold: Steering angle threshold (degrees)
        min_velocity: Minimum velocity to count as turn (m/s)

    Returns:
        List of turn events with direction and magnitude
    """
    if steer_col not in df.columns:
        return []

    steer = df[steer_col].values
    vel = df[velocity_col].values if velocity_col in df.columns else np.ones(len(df))
    times = df[timestamp_col].values if timestamp_col in df.columns else np.arange(len(df))

    # Smooth steering to reduce noise
    window = 5
    steer_smooth = pd.Series(steer).rolling(window, center=True, min_periods=1).mean().values

    turns = []

    # Find turn regions
    turning_right = (steer_smooth > steer_threshold) & (vel > min_velocity)
    turning_left = (steer_smooth < -steer_threshold) & (vel > min_velocity)

    # Right turns
    right_starts = np.where(np.diff(turning_right.astype(int)) == 1)[0] + 1
    right_ends = np.where(np.diff(turning_right.astype(int)) == -1)[0] + 1

    if turning_right[0]:
        right_starts = np.concatenate([[0], right_starts])
    if turning_right[-1]:
        right_ends = np.concatenate([right_ends, [len(turning_right) - 1]])

    for start_idx, end_idx in zip(right_starts, right_ends):
        if start_idx < len(times) and end_idx < len(times):
            max_angle = np.max(steer_smooth[start_idx:end_idx+1])
            turns.append({
                'event': 'right_turn',
                'start_ms': int(times[start_idx]),
                'end_ms': int(times[end_idx]),
                'duration_ms': int(times[end_idx] - times[start_idx]),
                'max_angle': float(max_angle),
                'start_idx': int(start_idx),
                'end_idx': int(end_idx),
            })

    # Left turns
    left_starts = np.where(np.diff(turning_left.astype(int)) == 1)[0] + 1
    left_ends = np.where(np.diff(turning_left.astype(int)) == -1)[0] + 1

    if turning_left[0]:
        left_starts = np.concatenate([[0], left_starts])
    if turning_left[-1]:
        left_ends = np.concatenate([left_ends, [len(turning_left) - 1]])

    for start_idx, end_idx in zip(left_starts, left_ends):
        if start_idx < len(times) and end_idx < len(times):
            min_angle = np.min(steer_smooth[start_idx:end_idx+1])
            turns.append({
                'event': 'left_turn',
                'start_ms': int(times[start_idx]),
                'end_ms': int(times[end_idx]),
                'duration_ms': int(times[end_idx] - times[start_idx]),
                'max_angle': float(min_angle),
                'start_idx': int(start_idx),
                'end_idx': int(end_idx),
            })

    return sorted(turns, key=lambda x: x['start_ms'])


def detect_lane_changes(df: pd.DataFrame,
                        steer_col: str = 'steer',
                        velocity_col: str = 'velocity',
                        timestamp_col: str = 'timestamp',
                        steer_threshold: float = 15.0,
                        max_duration_ms: int = 5000) -> List[Dict]:
    """Detect lane change events.

    Lane changes are quick, moderate steering maneuvers.

    Args:
        df: DataFrame with steering, velocity, timestamp
        steer_col: Name of steering column
        velocity_col: Name of velocity column
        timestamp_col: Name of timestamp column
        steer_threshold: Minimum steering angle (degrees)
        max_duration_ms: Maximum duration for lane change

    Returns:
        List of lane change events
    """
    if steer_col not in df.columns:
        return []

    steer = df[steer_col].values
    vel = df[velocity_col].values if velocity_col in df.columns else np.ones(len(df))
    times = df[timestamp_col].values if timestamp_col in df.columns else np.arange(len(df))

    # Lane changes: moderate steering angle + high speed + quick maneuver
    # Look for steering rate of change
    steer_rate = np.abs(np.gradient(steer))
    steer_rate_smooth = pd.Series(steer_rate).rolling(3, center=True, min_periods=1).mean().values

    # Detect rapid steering changes at highway speeds
    lane_change_candidates = (steer_rate_smooth > 2.0) & (vel > 10.0) & (np.abs(steer) > steer_threshold)

    starts = np.where(np.diff(lane_change_candidates.astype(int)) == 1)[0] + 1
    ends = np.where(np.diff(lane_change_candidates.astype(int)) == -1)[0] + 1

    if lane_change_candidates[0]:
        starts = np.concatenate([[0], starts])
    if lane_change_candidates[-1]:
        ends = np.concatenate([ends, [len(lane_change_candidates) - 1]])

    lane_changes = []
    for start_idx, end_idx in zip(starts, ends):
        if start_idx < len(times) and end_idx < len(times):
            duration = times[end_idx] - times[start_idx]
            if duration <= max_duration_ms:
                direction = 'right' if np.mean(steer[start_idx:end_idx+1]) > 0 else 'left'
                lane_changes.append({
                    'event': f'lane_change_{direction}',
                    'start_ms': int(times[start_idx]),
                    'end_ms': int(times[end_idx]),
                    'duration_ms': int(duration),
                    'avg_steer': float(np.mean(steer[start_idx:end_idx+1])),
                    'start_idx': int(start_idx),
                    'end_idx': int(end_idx),
                })

    return sorted(lane_changes, key=lambda x: x['start_ms'])


def detect_hard_events(df: pd.DataFrame,
                       accel_col: str = 'accel',
                       brake_col: str = 'brake',
                       timestamp_col: str = 'timestamp',
                       hard_accel_threshold: float = 20.0,
                       hard_brake_threshold: float = 800.0) -> List[Dict]:
    """Detect hard acceleration and braking events.

    Args:
        df: DataFrame with accel, brake, timestamp
        accel_col: Name of accelerator column (%)
        brake_col: Name of brake column (kPa)
        timestamp_col: Name of timestamp column (ms)
        hard_accel_threshold: Threshold for hard acceleration (%)
        hard_brake_threshold: Threshold for hard braking (kPa)

    Returns:
        List of hard accel/brake events
    """
    events = []

    # Hard acceleration
    if accel_col in df.columns:
        accel = df[accel_col].values
        times = df[timestamp_col].values if timestamp_col in df.columns else np.arange(len(df))

        hard_accel = accel > hard_accel_threshold

        starts = np.where(np.diff(hard_accel.astype(int)) == 1)[0] + 1
        ends = np.where(np.diff(hard_accel.astype(int)) == -1)[0] + 1

        if hard_accel[0]:
            starts = np.concatenate([[0], starts])
        if hard_accel[-1]:
            ends = np.concatenate([ends, [len(hard_accel) - 1]])

        for start_idx, end_idx in zip(starts, ends):
            if start_idx < len(times) and end_idx < len(times):
                events.append({
                    'event': 'hard_acceleration',
                    'start_ms': int(times[start_idx]),
                    'end_ms': int(times[end_idx]),
                    'duration_ms': int(times[end_idx] - times[start_idx]),
                    'max_accel': float(np.max(accel[start_idx:end_idx+1])),
                    'start_idx': int(start_idx),
                    'end_idx': int(end_idx),
                })

    # Hard braking
    if brake_col in df.columns:
        brake = df[brake_col].values
        times = df[timestamp_col].values if timestamp_col in df.columns else np.arange(len(df))

        hard_brake = brake > hard_brake_threshold

        starts = np.where(np.diff(hard_brake.astype(int)) == 1)[0] + 1
        ends = np.where(np.diff(hard_brake.astype(int)) == -1)[0] + 1

        if hard_brake[0]:
            starts = np.concatenate([[0], starts])
        if hard_brake[-1]:
            ends = np.concatenate([ends, [len(hard_brake) - 1]])

        for start_idx, end_idx in zip(starts, ends):
            if start_idx < len(times) and end_idx < len(times):
                events.append({
                    'event': 'hard_braking',
                    'start_ms': int(times[start_idx]),
                    'end_ms': int(times[end_idx]),
                    'duration_ms': int(times[end_idx] - times[start_idx]),
                    'max_brake': float(np.max(brake[start_idx:end_idx+1])),
                    'start_idx': int(start_idx),
                    'end_idx': int(end_idx),
                })

    return sorted(events, key=lambda x: x['start_ms'])


def detect_all_events(df: pd.DataFrame) -> List[Dict]:
    """Detect all types of events from sensor data.

    Args:
        df: DataFrame with sensor columns

    Returns:
        Sorted list of all detected events
    """
    all_events = []

    # Detect each type
    all_events.extend(detect_stops(df))
    all_events.extend(detect_turns(df))
    all_events.extend(detect_lane_changes(df))
    all_events.extend(detect_hard_events(df))

    # Sort by time
    return sorted(all_events, key=lambda x: x['start_ms'])


def compute_event_statistics(events: List[Dict]) -> Dict:
    """Compute statistics over detected events.

    Args:
        events: List of detected events

    Returns:
        Dictionary with event statistics
    """
    if not events:
        return {'total_events': 0}

    event_counts = {}
    event_durations = {}

    for event in events:
        event_type = event['event']
        event_counts[event_type] = event_counts.get(event_type, 0) + 1

        if 'duration_ms' in event:
            if event_type not in event_durations:
                event_durations[event_type] = []
            event_durations[event_type].append(event['duration_ms'])

    stats = {
        'total_events': len(events),
        'event_counts': event_counts,
        'event_rates': {k: v / len(events) for k, v in event_counts.items()},
    }

    # Average durations
    avg_durations = {}
    for event_type, durations in event_durations.items():
        avg_durations[event_type] = {
            'mean_ms': np.mean(durations),
            'std_ms': np.std(durations),
            'median_ms': np.median(durations),
        }

    stats['avg_durations'] = avg_durations

    return stats
