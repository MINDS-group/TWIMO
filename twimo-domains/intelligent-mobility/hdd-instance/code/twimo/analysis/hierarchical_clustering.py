"""Hierarchical multi-level clustering for driving behavior.

This module implements hierarchical clustering with multiple levels:
- Level 1: Driving style (prudent, smooth, aggressive)
- Level 2: Driving context (city, highway, suburban)
- Level 3: Fine-grained behaviors
"""

from __future__ import annotations

from pathlib import Path
from typing import Dict, List, Optional, Tuple

import json
import numpy as np
from sklearn.cluster import KMeans

from twimo.features.advanced_features import (
    compute_all_advanced_features,
    detect_driving_context,
)


def hierarchical_clustering(
    features_list: List[Dict[str, float]],
    level1_clusters: int = 3,  # Style: prudent, smooth, aggressive
    level2_clusters: int = 3,  # Context: city, highway, suburban
    level3_clusters: int = 5,  # Fine-grained behaviors
    random_state: int = 42,
) -> Dict:
    """Perform hierarchical multi-level clustering.

    Args:
        features_list: List of feature dictionaries
        level1_clusters: Number of clusters for level 1 (style)
        level2_clusters: Number of clusters for level 2 (context)
        level3_clusters: Number of clusters for level 3 (behaviors)
        random_state: Random seed

    Returns:
        Dictionary with clustering results at all levels
    """
    n_samples = len(features_list)

    # Extract feature matrix
    # Level 1 features: Focus on aggressiveness and control
    level1_feature_keys = [
        'accel_p95', 'brake_p95', 'vel_p95',
        'accel_std', 'brake_std', 'steer_std',
    ]

    # Level 2 features: Focus on context (speed patterns, stops)
    level2_feature_keys = [
        'vel_mean', 'vel_std', 'vel_cv',
        'stop_count_per_km', 'brake_count_per_km',
        'vel_p95', 'vel_range',
    ]

    # Level 3 features: All available features for fine-grained analysis
    level3_feature_keys = sorted({k for f in features_list for k in f.keys() if isinstance(f.get(k), (int, float))})

    # Build feature matrices
    X_level1 = np.array([[f.get(k, 0.0) for k in level1_feature_keys] for f in features_list])
    X_level2 = np.array([[f.get(k, 0.0) for k in level2_feature_keys] for f in features_list])
    X_level3 = np.array([[f.get(k, 0.0) for k in level3_feature_keys] for f in features_list])

    # Normalize
    def normalize(X):
        mean = np.mean(X, axis=0)
        std = np.std(X, axis=0) + 1e-8
        return (X - mean) / std

    X_level1_norm = normalize(X_level1)
    X_level2_norm = normalize(X_level2)
    X_level3_norm = normalize(X_level3)

    # Level 1 clustering: Driving style
    print(f"  Level 1: Clustering driving styles into {level1_clusters} clusters...")
    kmeans_l1 = KMeans(n_clusters=level1_clusters, random_state=random_state, n_init=10)
    clusters_l1 = kmeans_l1.fit_predict(X_level1_norm)

    # Name level 1 clusters based on aggressiveness
    # First, compute all aggressiveness scores to determine appropriate thresholds
    all_aggr_scores = [f.get('accel_p95', 0) + f.get('brake_p95', 0) for f in features_list]
    aggr_min = min(all_aggr_scores)
    aggr_max = max(all_aggr_scores)
    aggr_33 = np.percentile(all_aggr_scores, 33)  # 33rd percentile
    aggr_66 = np.percentile(all_aggr_scores, 66)  # 66th percentile

    cluster_l1_names = {}
    for i in range(level1_clusters):
        mask = clusters_l1 == i
        avg_aggr = np.mean([f.get('accel_p95', 0) + f.get('brake_p95', 0) for j, f in enumerate(features_list) if mask[j]])

        # Use data-driven thresholds based on percentiles
        if avg_aggr < aggr_33:
            cluster_l1_names[i] = 'prudent'
        elif avg_aggr < aggr_66:
            cluster_l1_names[i] = 'smooth'
        else:
            cluster_l1_names[i] = 'aggressive'

    # Handle duplicates
    name_counts = {}
    for cluster_id, name in cluster_l1_names.items():
        if name in name_counts:
            name_counts[name] += 1
            cluster_l1_names[cluster_id] = f"{name}_{name_counts[name]}"
        else:
            name_counts[name] = 1

    # Level 2 clustering: Within each style cluster, cluster by context
    clusters_l2 = np.zeros(n_samples, dtype=int)
    cluster_l2_names = {}
    l2_global_id = 0

    print(f"  Level 2: Clustering contexts within each style...")
    for l1_cluster_id in range(level1_clusters):
        mask = clusters_l1 == l1_cluster_id
        indices = np.where(mask)[0]

        if len(indices) < level2_clusters:
            # Not enough samples, assign all to same cluster
            clusters_l2[indices] = l2_global_id
            cluster_l2_names[l2_global_id] = f"{cluster_l1_names[l1_cluster_id]}_mixed"
            l2_global_id += 1
        else:
            # Cluster within this style group
            X_subset = X_level2_norm[indices]
            kmeans_l2 = KMeans(n_clusters=min(level2_clusters, len(indices)), random_state=random_state, n_init=10)
            sub_clusters = kmeans_l2.fit_predict(X_subset)

            # Assign global cluster IDs
            for sub_id in range(kmeans_l2.n_clusters):
                sub_mask = sub_clusters == sub_id
                sub_indices = indices[sub_mask]

                # Detect context for this subcluster
                avg_vel_p95 = np.mean([features_list[j].get('vel_p95', 0) for j in sub_indices])
                avg_stops = np.mean([features_list[j].get('stop_count_per_km', 0) for j in sub_indices])

                if avg_vel_p95 > 80 and avg_stops < 0.5:
                    context = 'highway'
                elif avg_vel_p95 < 50 and avg_stops > 1.5:
                    context = 'city'
                else:
                    context = 'suburban'

                clusters_l2[sub_indices] = l2_global_id
                cluster_l2_names[l2_global_id] = f"{cluster_l1_names[l1_cluster_id]}_{context}"
                l2_global_id += 1

    # Level 3 clustering: Fine-grained behaviors within each L2 cluster
    clusters_l3 = np.zeros(n_samples, dtype=int)
    cluster_l3_names = {}
    l3_global_id = 0

    print(f"  Level 3: Clustering fine-grained behaviors...")
    unique_l2 = np.unique(clusters_l2)

    for l2_cluster_id in unique_l2:
        mask = clusters_l2 == l2_cluster_id
        indices = np.where(mask)[0]

        if len(indices) < level3_clusters:
            # Not enough samples
            clusters_l3[indices] = l3_global_id
            cluster_l3_names[l3_global_id] = f"{cluster_l2_names[l2_cluster_id]}_default"
            l3_global_id += 1
        else:
            # Cluster within this L2 group
            X_subset = X_level3_norm[indices]
            kmeans_l3 = KMeans(n_clusters=min(level3_clusters, len(indices)), random_state=random_state, n_init=10)
            sub_clusters = kmeans_l3.fit_predict(X_subset)

            for sub_id in range(kmeans_l3.n_clusters):
                sub_mask = sub_clusters == sub_id
                sub_indices = indices[sub_mask]

                clusters_l3[sub_indices] = l3_global_id
                cluster_l3_names[l3_global_id] = f"{cluster_l2_names[l2_cluster_id]}_behavior{sub_id}"
                l3_global_id += 1

    return {
        'level1': {
            'clusters': clusters_l1.tolist(),
            'cluster_names': cluster_l1_names,
            'n_clusters': level1_clusters,
            'feature_keys': level1_feature_keys,
        },
        'level2': {
            'clusters': clusters_l2.tolist(),
            'cluster_names': cluster_l2_names,
            'n_clusters': len(unique_l2),
            'feature_keys': level2_feature_keys,
        },
        'level3': {
            'clusters': clusters_l3.tolist(),
            'cluster_names': cluster_l3_names,
            'n_clusters': l3_global_id,
            'feature_keys': level3_feature_keys,
        },
    }


def analyze_hierarchical_distribution(
    hierarchical_results: Dict,
    session_ids: List[str],
) -> Dict:
    """Analyze distribution across hierarchical levels.

    Args:
        hierarchical_results: Results from hierarchical_clustering
        session_ids: List of session IDs

    Returns:
        Distribution statistics
    """
    stats = {}

    for level_name in ['level1', 'level2', 'level3']:
        level_data = hierarchical_results[level_name]
        clusters = np.array(level_data['clusters'])
        cluster_names = level_data['cluster_names']

        # Count distribution
        distribution = {}
        for cluster_id in np.unique(clusters):
            count = int(np.sum(clusters == cluster_id))
            name = cluster_names.get(int(cluster_id), f'cluster_{cluster_id}')
            distribution[name] = count

        stats[level_name] = {
            'distribution': distribution,
            'n_clusters': level_data['n_clusters'],
        }

    return stats


def save_hierarchical_results(
    results: Dict,
    session_ids: List[str],
    output_dir: Path,
) -> None:
    """Save hierarchical clustering results.

    Args:
        results: Hierarchical clustering results
        session_ids: List of session IDs
        output_dir: Output directory
    """
    output_dir.mkdir(parents=True, exist_ok=True)

    # Save full results
    results_file = output_dir / 'hierarchical_clustering.json'
    with open(results_file, 'w') as f:
        json.dump(results, f, indent=2)

    print(f"  Saved hierarchical clustering to: {results_file}")

    # Save session assignments at each level
    assignments_file = output_dir / 'hierarchical_assignments.jsonl'
    with open(assignments_file, 'w') as f:
        for i, session_id in enumerate(session_ids):
            assignment = {
                'session_id': session_id,
                'level1_cluster': int(results['level1']['clusters'][i]),
                'level1_name': results['level1']['cluster_names'][results['level1']['clusters'][i]],
                'level2_cluster': int(results['level2']['clusters'][i]),
                'level2_name': results['level2']['cluster_names'][results['level2']['clusters'][i]],
                'level3_cluster': int(results['level3']['clusters'][i]),
                'level3_name': results['level3']['cluster_names'][results['level3']['clusters'][i]],
            }
            f.write(json.dumps(assignment) + '\n')

    print(f"  Saved session assignments to: {assignments_file}")

    # Distribution stats
    stats = analyze_hierarchical_distribution(results, session_ids)

    summary_file = output_dir / 'hierarchical_summary.txt'
    with open(summary_file, 'w') as f:
        f.write("HIERARCHICAL CLUSTERING SUMMARY\n")
        f.write("=" * 60 + "\n\n")

        for level in ['level1', 'level2', 'level3']:
            f.write(f"\n{level.upper()}:\n")
            f.write(f"  Total clusters: {stats[level]['n_clusters']}\n")
            f.write(f"  Distribution:\n")

            for name, count in sorted(stats[level]['distribution'].items(), key=lambda x: -x[1]):
                pct = count / len(session_ids) * 100
                f.write(f"    {name:30s}: {count:4d} sessions ({pct:5.1f}%)\n")

    print(f"  Saved summary to: {summary_file}")
