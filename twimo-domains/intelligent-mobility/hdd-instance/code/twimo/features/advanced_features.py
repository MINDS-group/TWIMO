"""Advanced feature engineering for driving behavior analysis.

This module provides domain-specific features for:
- Context detection (city vs highway vs suburban)
- Fine-grained behavior analysis
- Temporal pattern extraction
"""

from __future__ import annotations

from typing import Dict, List, Optional

import numpy as np
import pandas as pd


def compute_context_features(
    df: pd.DataFrame,
    velocity_col: str = 'velocity',
    accel_col: str = 'accel',
    brake_col: str = 'brake',
    steer_col: str = 'steer',
    time_col: str = 'timestamp',
) -> Dict[str, float]:
    """Compute features for context detection (city/highway/suburban).

    Args:
        df: Session dataframe with driving signals
        velocity_col: Column name for velocity
        accel_col: Column name for acceleration
        brake_col: Column name for brake
        steer_col: Column name for steering
        time_col: Column name for timestamp

    Returns:
        Dictionary of context features
    """
    features = {}

    # Velocity statistics
    vel = df[velocity_col].values
    features['vel_mean'] = float(np.mean(vel))
    features['vel_median'] = float(np.median(vel))
    features['vel_std'] = float(np.std(vel))
    features['vel_p50'] = float(np.percentile(vel, 50))
    features['vel_p75'] = float(np.percentile(vel, 75))
    features['vel_p95'] = float(np.percentile(vel, 95))
    features['vel_p99'] = float(np.percentile(vel, 99))
    features['vel_cv'] = features['vel_std'] / (features['vel_mean'] + 1e-6)  # Coefficient of variation

    # Speed consistency (low = highway, high = city)
    features['vel_range'] = float(np.max(vel) - np.min(vel))
    features['vel_iqr'] = float(np.percentile(vel, 75) - np.percentile(vel, 25))

    # Stop detection
    stop_threshold = 5.0  # km/h
    stopped = vel < stop_threshold
    features['stop_count'] = int(np.sum(np.diff(stopped.astype(int)) == 1))
    features['stop_time_ratio'] = float(np.mean(stopped))

    # Calculate distance traveled (approximate)
    if len(df) > 1:
        time_diff = np.diff(df[time_col].values) / 1000.0  # Convert to seconds
        distance_km = np.sum(vel[:-1] * time_diff / 3600.0)  # km
        duration_hours = np.sum(time_diff) / 3600.0

        if duration_hours > 0 and distance_km > 0:
            features['avg_speed_kmh'] = float(distance_km / duration_hours)
            features['stop_count_per_km'] = features['stop_count'] / distance_km if distance_km > 0 else 0
        else:
            features['avg_speed_kmh'] = 0.0
            features['stop_count_per_km'] = 0.0
    else:
        features['avg_speed_kmh'] = 0.0
        features['stop_count_per_km'] = 0.0

    # Acceleration patterns
    if accel_col in df.columns:
        accel = df[accel_col].values
        features['accel_mean'] = float(np.mean(accel))
        features['accel_std'] = float(np.std(accel))
        features['accel_p95'] = float(np.percentile(accel, 95))

        # Acceleration frequency (how often driver accelerates)
        accel_threshold = 0.5
        accel_events = accel > accel_threshold
        features['accel_event_count'] = int(np.sum(np.diff(accel_events.astype(int)) == 1))

    # Braking patterns
    if brake_col in df.columns:
        brake = df[brake_col].values
        features['brake_mean'] = float(np.mean(brake))
        features['brake_std'] = float(np.std(brake))
        features['brake_p95'] = float(np.percentile(brake, 95))

        # Braking frequency
        brake_threshold = 0.3
        brake_events = brake > brake_threshold
        features['brake_event_count'] = int(np.sum(np.diff(brake_events.astype(int)) == 1))

        # Brake per km
        if 'distance_km' in locals() and distance_km > 0:
            features['brake_count_per_km'] = features['brake_event_count'] / distance_km
        else:
            features['brake_count_per_km'] = 0.0

    # Steering patterns
    if steer_col in df.columns:
        steer = df[steer_col].values
        features['steer_mean'] = float(np.mean(np.abs(steer)))
        features['steer_std'] = float(np.std(steer))
        features['steer_p95'] = float(np.percentile(np.abs(steer), 95))

        # Steering changes (curves/turns)
        steer_change = np.abs(np.diff(steer))
        features['steer_change_mean'] = float(np.mean(steer_change))
        features['steer_change_p95'] = float(np.percentile(steer_change, 95))

        # Turn count (significant steering changes)
        turn_threshold = 10  # degrees
        turn_events = steer_change > turn_threshold
        features['turn_count'] = int(np.sum(turn_events))

    # Driving smoothness (jerk - rate of change of acceleration)
    if accel_col in df.columns and len(df) > 1:
        jerk = np.abs(np.diff(df[accel_col].values))
        features['jerk_mean'] = float(np.mean(jerk))
        features['jerk_std'] = float(np.std(jerk))
        features['jerk_p95'] = float(np.percentile(jerk, 95))

    return features


def detect_driving_context(features: Dict[str, float]) -> str:
    """Classify driving context based on features.

    Uses rule-based classification to determine if driving is in:
    - city: Low speed, frequent stops, variable speed
    - highway: High speed, few stops, consistent speed
    - suburban: Medium speed, occasional stops

    Args:
        features: Dictionary of driving features

    Returns:
        Context label: 'city', 'highway', or 'suburban'
    """
    vel_p95 = features.get('vel_p95', 0)
    vel_std = features.get('vel_std', 0)
    stop_count_per_km = features.get('stop_count_per_km', 0)
    vel_cv = features.get('vel_cv', 0)

    # Highway: high speed, low variability, few stops
    if vel_p95 > 80 and vel_cv < 0.3 and stop_count_per_km < 0.5:
        return 'highway'

    # City: low speed, high variability, many stops
    elif vel_p95 < 50 and (vel_cv > 0.5 or stop_count_per_km > 1.5):
        return 'city'

    # Suburban: everything in between
    else:
        return 'suburban'


def compute_temporal_features(
    df: pd.DataFrame,
    window_size_sec: int = 30,
    velocity_col: str = 'velocity',
    time_col: str = 'timestamp',
) -> List[Dict[str, float]]:
    """Compute features over sliding time windows.

    Args:
        df: Session dataframe
        window_size_sec: Window size in seconds
        velocity_col: Column name for velocity
        time_col: Column name for timestamp

    Returns:
        List of feature dictionaries, one per window
    """
    window_features = []

    # Convert window size to milliseconds
    window_size_ms = window_size_sec * 1000

    # Get time range
    times = df[time_col].values
    start_time = times[0]
    end_time = times[-1]

    # Slide window
    current_time = start_time
    while current_time + window_size_ms <= end_time:
        # Extract window
        window_mask = (times >= current_time) & (times < current_time + window_size_ms)
        window_df = df[window_mask]

        if len(window_df) > 5:  # Minimum points for meaningful features
            # Compute features for this window
            window_feat = compute_context_features(window_df)
            window_feat['window_start_time'] = float(current_time)
            window_feat['window_end_time'] = float(current_time + window_size_ms)
            window_features.append(window_feat)

        # Slide window by half the window size (50% overlap)
        current_time += window_size_ms // 2

    return window_features


def compute_behavior_features(
    df: pd.DataFrame,
    accel_col: str = 'accel',
    brake_col: str = 'brake',
    steer_col: str = 'steer',
) -> Dict[str, float]:
    """Compute features related to driving behavior style.

    These features capture aggressiveness, smoothness, and control.

    Args:
        df: Session dataframe
        accel_col: Column name for acceleration
        brake_col: Column name for brake
        steer_col: Column name for steering

    Returns:
        Dictionary of behavior features
    """
    features = {}

    # Aggressiveness: hard acceleration and braking
    if accel_col in df.columns:
        accel = df[accel_col].values
        hard_accel_threshold = np.percentile(accel, 90) if len(accel) > 0 else 0
        features['hard_accel_ratio'] = float(np.mean(accel > hard_accel_threshold))
        features['accel_aggression'] = float(np.percentile(accel, 95))

    if brake_col in df.columns:
        brake = df[brake_col].values
        hard_brake_threshold = np.percentile(brake, 90) if len(brake) > 0 else 0
        features['hard_brake_ratio'] = float(np.mean(brake > hard_brake_threshold))
        features['brake_aggression'] = float(np.percentile(brake, 95))

    # Smoothness: low variance in controls
    if accel_col in df.columns and brake_col in df.columns:
        accel = df[accel_col].values
        brake = df[brake_col].values

        # Combined pedal variance (lower = smoother)
        pedal_changes = np.abs(np.diff(accel)) + np.abs(np.diff(brake))
        features['pedal_smoothness'] = float(1.0 / (np.mean(pedal_changes) + 1e-6))

    if steer_col in df.columns:
        steer = df[steer_col].values
        steer_changes = np.abs(np.diff(steer))
        features['steer_smoothness'] = float(1.0 / (np.mean(steer_changes) + 1e-6))

    # Control precision: consistency in repeated actions
    if accel_col in df.columns:
        accel = df[accel_col].values
        # Coefficient of variation for acceleration
        features['accel_precision'] = float(1.0 / (np.std(accel) / (np.mean(np.abs(accel)) + 1e-6) + 1e-6))

    return features


def compute_all_advanced_features(
    df: pd.DataFrame,
    velocity_col: str = 'velocity',
    accel_col: str = 'accel',
    brake_col: str = 'brake',
    steer_col: str = 'steer',
    time_col: str = 'timestamp',
) -> Dict[str, float]:
    """Compute all advanced features for a session.

    Combines context, behavior, and temporal features.

    Args:
        df: Session dataframe
        velocity_col: Velocity column name
        accel_col: Acceleration column name
        brake_col: Brake column name
        steer_col: Steering column name
        time_col: Timestamp column name

    Returns:
        Combined dictionary of all features
    """
    # Context features
    context_feat = compute_context_features(
        df, velocity_col, accel_col, brake_col, steer_col, time_col
    )

    # Behavior features
    behavior_feat = compute_behavior_features(df, accel_col, brake_col, steer_col)

    # Combine all features
    all_features = {**context_feat, **behavior_feat}

    # Add context label
    all_features['context'] = detect_driving_context(context_feat)

    return all_features
