"""Temporal segmentation and analysis of driving sessions.

This module segments driving sessions into time windows and performs
clustering on micro-behaviors within sessions.
"""

from __future__ import annotations

from pathlib import Path
from typing import Dict, List, Optional, Tuple

import json
import numpy as np
import pandas as pd
from sklearn.cluster import KMeans

from twimo.features.advanced_features import compute_context_features, detect_driving_context
from twimo.features.hdd_loader import load_hdd_session, check_hdd_format


def segment_session_by_time(
    df: pd.DataFrame,
    window_size_sec: int = 30,
    stride_sec: int = 15,
    time_col: str = 'timestamp',
) -> List[pd.DataFrame]:
    """Segment a driving session into time windows.

    Args:
        df: Session dataframe
        window_size_sec: Window size in seconds
        stride_sec: Stride between windows in seconds
        time_col: Timestamp column name

    Returns:
        List of windowed dataframes
    """
    windows = []

    # Convert to milliseconds
    window_size_ms = window_size_sec * 1000
    stride_ms = stride_sec * 1000

    times = df[time_col].values
    start_time = times[0]
    end_time = times[-1]

    current_time = start_time
    while current_time + window_size_ms <= end_time:
        mask = (times >= current_time) & (times < current_time + window_size_ms)
        window_df = df[mask].copy()

        if len(window_df) >= 10:  # Minimum points for meaningful analysis
            windows.append(window_df)

        current_time += stride_ms

    return windows


def cluster_temporal_segments(
    session_windows: List[Dict[str, any]],
    n_clusters: int = 5,
    random_state: int = 42,
) -> Tuple[np.ndarray, Dict]:
    """Cluster temporal segments across all sessions.

    Args:
        session_windows: List of dicts with 'session_id', 'window_id', and 'features'
        n_clusters: Number of clusters
        random_state: Random seed

    Returns:
        Tuple of (cluster assignments, cluster info dict)
    """
    # Extract features
    feature_list = []
    metadata_list = []

    for window_data in session_windows:
        features = window_data['features']
        feature_list.append(features)
        metadata_list.append({
            'session_id': window_data['session_id'],
            'window_id': window_data['window_id'],
            'window_start': window_data.get('window_start_time', 0),
        })

    # Convert to feature matrix
    if not feature_list:
        return np.array([]), {}

    # Get feature keys (use first window as template)
    feature_keys = sorted(feature_list[0].keys())
    X = np.array([[f.get(k, 0.0) for k in feature_keys] for f in feature_list])

    # Normalize features
    X_mean = np.mean(X, axis=0)
    X_std = np.std(X, axis=0) + 1e-8
    X_norm = (X - X_mean) / X_std

    # Cluster
    kmeans = KMeans(n_clusters=n_clusters, random_state=random_state, n_init=10)
    clusters = kmeans.fit_predict(X_norm)

    # Analyze clusters
    cluster_info = {
        'n_clusters': n_clusters,
        'feature_keys': feature_keys,
        'cluster_sizes': {int(i): int(np.sum(clusters == i)) for i in range(n_clusters)},
        'cluster_centroids': kmeans.cluster_centers_.tolist(),
        'metadata': metadata_list,
    }

    return clusters, cluster_info


def analyze_temporal_transitions(
    session_id: str,
    window_clusters: List[int],
    cluster_names: Optional[Dict[int, str]] = None,
) -> Dict:
    """Analyze transitions between clusters within a session.

    Args:
        session_id: Session identifier
        window_clusters: List of cluster assignments for windows
        cluster_names: Optional mapping of cluster IDs to names

    Returns:
        Dictionary with transition statistics
    """
    if cluster_names is None:
        cluster_names = {i: f'cluster_{i}' for i in set(window_clusters)}

    transitions = []
    for i in range(len(window_clusters) - 1):
        from_cluster = window_clusters[i]
        to_cluster = window_clusters[i + 1]
        if from_cluster != to_cluster:
            transitions.append({
                'from': cluster_names.get(from_cluster, f'cluster_{from_cluster}'),
                'to': cluster_names.get(to_cluster, f'cluster_{to_cluster}'),
                'window_index': i,
            })

    # Count transitions
    transition_counts = {}
    for trans in transitions:
        key = f"{trans['from']} -> {trans['to']}"
        transition_counts[key] = transition_counts.get(key, 0) + 1

    return {
        'session_id': session_id,
        'n_windows': len(window_clusters),
        'n_transitions': len(transitions),
        'transition_rate': len(transitions) / max(len(window_clusters) - 1, 1),
        'transitions': transitions,
        'transition_counts': transition_counts,
        'cluster_sequence': [cluster_names.get(c, f'cluster_{c}') for c in window_clusters],
    }


def process_sessions_with_temporal_segmentation(
    manifest_path: Path,
    window_size_sec: int = 30,
    stride_sec: int = 15,
    n_clusters: int = 5,
) -> Dict:
    """Process all sessions with temporal segmentation.

    Args:
        manifest_path: Path to manifest.jsonl
        window_size_sec: Window size in seconds
        stride_sec: Stride between windows
        n_clusters: Number of clusters

    Returns:
        Dictionary with all results
    """
    print(f"Loading manifest from: {manifest_path}")

    # Load manifest
    sessions = []
    with open(manifest_path) as f:
        for line in f:
            sessions.append(json.loads(line))

    print(f"Loaded {len(sessions)} sessions")

    # Process each session
    all_windows = []
    session_window_data = {}

    for sess in sessions:
        session_id = sess['session_id']

        # Construct CSV path from csv_dir
        if 'csv_path' in sess:
            csv_path = Path(sess['csv_path'])
        elif 'csv_dir' in sess:
            csv_dir = Path(sess['csv_dir'])
            # Find the first CSV file in the directory
            csv_files = list(csv_dir.glob('*.csv'))
            if not csv_files:
                print(f"  [Warning] No CSV files found in: {csv_dir}")
                continue
            csv_path = csv_files[0]
        else:
            print(f"  [Warning] No csv_path or csv_dir in manifest for: {session_id}")
            continue

        # Load session - handle both single CSV and HDD multi-file format
        if csv_path.is_dir() or (csv_path.parent.is_dir() and check_hdd_format(csv_path.parent)):
            # HDD format (multiple CSV files in directory)
            if csv_path.is_dir():
                df = load_hdd_session(csv_path)
            else:
                df = load_hdd_session(csv_path.parent)

            if df is None or len(df) == 0:
                print(f"  [Warning] Could not load HDD session: {session_id}")
                continue
        elif csv_path.is_file():
            # Single CSV file
            df = pd.read_csv(csv_path)
        else:
            print(f"  [Warning] CSV not found: {csv_path}")
            continue

        # Segment into windows
        windows = segment_session_by_time(df, window_size_sec, stride_sec)

        # Extract features for each window
        window_features = []
        for i, window_df in enumerate(windows):
            features = compute_context_features(window_df)
            context = detect_driving_context(features)

            window_data = {
                'session_id': session_id,
                'window_id': i,
                'window_start_time': float(window_df['timestamp'].iloc[0]),
                'window_end_time': float(window_df['timestamp'].iloc[-1]),
                'features': features,
                'context': context,
            }

            all_windows.append(window_data)
            window_features.append(features)

        session_window_data[session_id] = {
            'n_windows': len(windows),
            'window_features': window_features,
        }

        print(f"  [{session_id}] Segmented into {len(windows)} windows")

    # Cluster all windows
    print(f"\nClustering {len(all_windows)} windows into {n_clusters} clusters...")
    clusters, cluster_info = cluster_temporal_segments(all_windows, n_clusters)

    # Assign clusters back to windows
    for i, window_data in enumerate(all_windows):
        window_data['cluster'] = int(clusters[i])

    # Analyze transitions for each session
    print("\nAnalyzing temporal transitions...")
    session_transitions = {}

    current_window_idx = 0
    for session_id, session_data in session_window_data.items():
        n_windows = session_data['n_windows']
        window_clusters = clusters[current_window_idx:current_window_idx + n_windows]

        transitions = analyze_temporal_transitions(session_id, window_clusters.tolist())
        session_transitions[session_id] = transitions

        current_window_idx += n_windows

    return {
        'all_windows': all_windows,
        'cluster_info': cluster_info,
        'session_transitions': session_transitions,
        'n_total_windows': len(all_windows),
        'n_clusters': n_clusters,
        'window_size_sec': window_size_sec,
        'stride_sec': stride_sec,
    }


def save_temporal_results(results: Dict, output_dir: Path) -> None:
    """Save temporal segmentation results.

    Args:
        results: Results dictionary from process_sessions_with_temporal_segmentation
        output_dir: Output directory
    """
    output_dir.mkdir(parents=True, exist_ok=True)

    # Save window-level data
    windows_file = output_dir / 'temporal_windows.jsonl'
    with open(windows_file, 'w') as f:
        for window in results['all_windows']:
            f.write(json.dumps(window) + '\n')

    print(f"  Saved window data to: {windows_file}")

    # Save cluster info
    cluster_file = output_dir / 'temporal_cluster_info.json'
    with open(cluster_file, 'w') as f:
        json.dump(results['cluster_info'], f, indent=2)

    print(f"  Saved cluster info to: {cluster_file}")

    # Save transitions
    transitions_file = output_dir / 'temporal_transitions.json'
    with open(transitions_file, 'w') as f:
        json.dump(results['session_transitions'], f, indent=2)

    print(f"  Saved transitions to: {transitions_file}")

    # Summary statistics
    summary_file = output_dir / 'temporal_summary.txt'
    with open(summary_file, 'w') as f:
        f.write("TEMPORAL SEGMENTATION SUMMARY\n")
        f.write("=" * 60 + "\n\n")
        f.write(f"Total windows: {results['n_total_windows']}\n")
        f.write(f"Number of clusters: {results['n_clusters']}\n")
        f.write(f"Window size: {results['window_size_sec']} seconds\n")
        f.write(f"Stride: {results['stride_sec']} seconds\n\n")

        f.write("Cluster sizes:\n")
        for cluster_id, size in results['cluster_info']['cluster_sizes'].items():
            f.write(f"  Cluster {cluster_id}: {size} windows\n")

        f.write("\nTransition statistics:\n")
        for session_id, trans_data in results['session_transitions'].items():
            f.write(f"\n  {session_id}:\n")
            f.write(f"    Windows: {trans_data['n_windows']}\n")
            f.write(f"    Transitions: {trans_data['n_transitions']}\n")
            f.write(f"    Transition rate: {trans_data['transition_rate']:.2%}\n")

    print(f"  Saved summary to: {summary_file}")
