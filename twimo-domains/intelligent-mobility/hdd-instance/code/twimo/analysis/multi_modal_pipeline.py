"""Complete multi-modal analysis pipeline.

This module integrates all clustering approaches:
1. Basic style clustering (existing)
2. Context detection (city/highway/suburban)
3. Temporal segmentation
4. Hierarchical clustering
5. Advanced feature engineering
"""

from __future__ import annotations

from pathlib import Path
from typing import Dict, List, Optional

import json
import numpy as np
import pandas as pd

from twimo.features.advanced_features import (
    compute_all_advanced_features,
    detect_driving_context,
)
from twimo.features.hdd_loader import load_hdd_session, check_hdd_format
from twimo.analysis.hierarchical_clustering import (
    hierarchical_clustering,
    save_hierarchical_results,
)
from twimo.analysis.temporal_segmentation import (
    process_sessions_with_temporal_segmentation,
    save_temporal_results,
)


def run_complete_analysis_pipeline(
    manifest_path: Path,
    output_dir: Path,
    # Hierarchical clustering params
    level1_clusters: int = 3,
    level2_clusters: int = 3,
    level3_clusters: int = 5,
    # Temporal segmentation params
    window_size_sec: int = 30,
    stride_sec: int = 15,
    temporal_clusters: int = 5,
    # General
    random_state: int = 42,
) -> Dict:
    """Run complete multi-modal analysis pipeline.

    Args:
        manifest_path: Path to manifest.jsonl
        output_dir: Output directory for results
        level1_clusters: L1 clusters for hierarchical (style)
        level2_clusters: L2 clusters for hierarchical (context)
        level3_clusters: L3 clusters for hierarchical (behaviors)
        window_size_sec: Temporal window size
        stride_sec: Temporal stride
        temporal_clusters: Number of temporal clusters
        random_state: Random seed

    Returns:
        Complete analysis results
    """
    output_dir = Path(output_dir)
    output_dir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("MULTI-MODAL DRIVING BEHAVIOR ANALYSIS PIPELINE")
    print("=" * 70)

    # =========================================================================
    # Step 1: Load data and extract advanced features
    # =========================================================================
    print("\n[1/5] Loading sessions and extracting advanced features...")

    sessions = []
    with open(manifest_path) as f:
        for line in f:
            sessions.append(json.loads(line))

    session_ids = []
    all_features = []
    context_labels = []

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

        # Extract advanced features
        features = compute_all_advanced_features(df)
        context = features.pop('context')  # Remove context label from features

        session_ids.append(session_id)
        all_features.append(features)
        context_labels.append(context)

        print(f"  [{session_id}] Context: {context}, Features: {len(features)}")

    print(f"\nLoaded {len(session_ids)} sessions")
    print(f"Extracted {len(all_features[0]) if all_features else 0} features per session")

    # =========================================================================
    # Step 2: Context detection
    # =========================================================================
    print("\n[2/5] Analyzing driving contexts...")

    context_distribution = {}
    for context in context_labels:
        context_distribution[context] = context_distribution.get(context, 0) + 1

    print("  Context distribution:")
    for context, count in sorted(context_distribution.items(), key=lambda x: -x[1]):
        pct = count / len(context_labels) * 100
        print(f"    {context:15s}: {count:3d} sessions ({pct:5.1f}%)")

    # Save context results
    context_results = []
    for i, session_id in enumerate(session_ids):
        context_results.append({
            'session_id': session_id,
            'context': context_labels[i],
            'features': all_features[i],
        })

    context_file = output_dir / 'context_detection.jsonl'
    with open(context_file, 'w') as f:
        for result in context_results:
            f.write(json.dumps(result) + '\n')

    print(f"  Saved context detection to: {context_file}")

    # =========================================================================
    # Step 3: Hierarchical clustering
    # =========================================================================
    print("\n[3/5] Performing hierarchical multi-level clustering...")

    hierarchical_results = hierarchical_clustering(
        all_features,
        level1_clusters=level1_clusters,
        level2_clusters=level2_clusters,
        level3_clusters=level3_clusters,
        random_state=random_state,
    )

    hierarchical_dir = output_dir / 'hierarchical'
    save_hierarchical_results(hierarchical_results, session_ids, hierarchical_dir)

    print(f"  Hierarchical clustering completed")
    print(f"    Level 1 (Style): {hierarchical_results['level1']['n_clusters']} clusters")
    print(f"    Level 2 (Context): {hierarchical_results['level2']['n_clusters']} clusters")
    print(f"    Level 3 (Behavior): {hierarchical_results['level3']['n_clusters']} clusters")

    # =========================================================================
    # Step 4: Temporal segmentation
    # =========================================================================
    print("\n[4/5] Performing temporal segmentation...")

    temporal_results = process_sessions_with_temporal_segmentation(
        manifest_path,
        window_size_sec=window_size_sec,
        stride_sec=stride_sec,
        n_clusters=temporal_clusters,
    )

    temporal_dir = output_dir / 'temporal'
    save_temporal_results(temporal_results, temporal_dir)

    print(f"  Temporal segmentation completed")
    print(f"    Total windows: {temporal_results['n_total_windows']}")
    print(f"    Temporal clusters: {temporal_results['n_clusters']}")

    # =========================================================================
    # Step 5: Generate combined summary
    # =========================================================================
    print("\n[5/5] Generating combined analysis summary...")

    combined_results = {
        'n_sessions': len(session_ids),
        'session_ids': session_ids,
        'context_distribution': context_distribution,
        'hierarchical_summary': {
            'level1_clusters': hierarchical_results['level1']['n_clusters'],
            'level2_clusters': hierarchical_results['level2']['n_clusters'],
            'level3_clusters': hierarchical_results['level3']['n_clusters'],
        },
        'temporal_summary': {
            'n_windows': temporal_results['n_total_windows'],
            'n_clusters': temporal_results['n_clusters'],
            'window_size_sec': temporal_results['window_size_sec'],
        },
    }

    # Create combined session profiles
    combined_profiles = []
    for i, session_id in enumerate(session_ids):
        profile = {
            'session_id': session_id,
            'context': context_labels[i],
            'features': all_features[i],
            'hierarchical': {
                'level1_cluster': int(hierarchical_results['level1']['clusters'][i]),
                'level1_name': hierarchical_results['level1']['cluster_names'][hierarchical_results['level1']['clusters'][i]],
                'level2_cluster': int(hierarchical_results['level2']['clusters'][i]),
                'level2_name': hierarchical_results['level2']['cluster_names'][hierarchical_results['level2']['clusters'][i]],
                'level3_cluster': int(hierarchical_results['level3']['clusters'][i]),
                'level3_name': hierarchical_results['level3']['cluster_names'][hierarchical_results['level3']['clusters'][i]],
            },
        }
        combined_profiles.append(profile)

    # Save combined profiles
    profiles_file = output_dir / 'combined_profiles.jsonl'
    with open(profiles_file, 'w') as f:
        for profile in combined_profiles:
            f.write(json.dumps(profile) + '\n')

    print(f"  Saved combined profiles to: {profiles_file}")

    # Save summary
    summary_file = output_dir / 'analysis_summary.json'
    with open(summary_file, 'w') as f:
        json.dump(combined_results, f, indent=2)

    print(f"  Saved analysis summary to: {summary_file}")

    # Create detailed report
    report_file = output_dir / 'ANALYSIS_REPORT.txt'
    with open(report_file, 'w') as f:
        f.write("COMPLETE MULTI-MODAL DRIVING BEHAVIOR ANALYSIS REPORT\n")
        f.write("=" * 70 + "\n\n")

        f.write(f"Total Sessions Analyzed: {len(session_ids)}\n\n")

        # Context analysis
        f.write("CONTEXT DETECTION\n")
        f.write("-" * 70 + "\n")
        for context, count in sorted(context_distribution.items(), key=lambda x: -x[1]):
            pct = count / len(session_ids) * 100
            f.write(f"  {context:15s}: {count:3d} sessions ({pct:5.1f}%)\n")

        # Hierarchical clustering
        f.write("\n\nHIERARCHICAL CLUSTERING\n")
        f.write("-" * 70 + "\n")

        f.write("\nLevel 1 (Driving Style):\n")
        l1_dist = {}
        for i in hierarchical_results['level1']['clusters']:
            name = hierarchical_results['level1']['cluster_names'][i]
            l1_dist[name] = l1_dist.get(name, 0) + 1
        for name, count in sorted(l1_dist.items(), key=lambda x: -x[1]):
            pct = count / len(session_ids) * 100
            f.write(f"  {name:20s}: {count:3d} sessions ({pct:5.1f}%)\n")

        f.write("\nLevel 2 (Driving Context):\n")
        l2_dist = {}
        for i in hierarchical_results['level2']['clusters']:
            name = hierarchical_results['level2']['cluster_names'][i]
            l2_dist[name] = l2_dist.get(name, 0) + 1
        for name, count in sorted(l2_dist.items(), key=lambda x: -x[1]):
            pct = count / len(session_ids) * 100
            f.write(f"  {name:30s}: {count:3d} sessions ({pct:5.1f}%)\n")

        # Temporal segmentation
        f.write("\n\nTEMPORAL SEGMENTATION\n")
        f.write("-" * 70 + "\n")
        f.write(f"Total Windows: {temporal_results['n_total_windows']}\n")
        f.write(f"Window Size: {temporal_results['window_size_sec']} seconds\n")
        f.write(f"Stride: {temporal_results['stride_sec']} seconds\n")
        f.write(f"Temporal Clusters: {temporal_results['n_clusters']}\n\n")

        f.write("Cluster sizes:\n")
        for cluster_id, size in temporal_results['cluster_info']['cluster_sizes'].items():
            pct = size / temporal_results['n_total_windows'] * 100
            f.write(f"  Cluster {cluster_id}: {size:4d} windows ({pct:5.1f}%)\n")

        # Output files
        f.write("\n\nOUTPUT FILES\n")
        f.write("-" * 70 + "\n")
        f.write(f"  Combined Profiles: {profiles_file}\n")
        f.write(f"  Context Detection: {context_file}\n")
        f.write(f"  Hierarchical Results: {hierarchical_dir}\n")
        f.write(f"  Temporal Results: {temporal_dir}\n")
        f.write(f"  Summary: {summary_file}\n")

    print(f"  Saved detailed report to: {report_file}")

    print("\n" + "=" * 70)
    print("ANALYSIS COMPLETE!")
    print("=" * 70)
    print(f"\nResults saved to: {output_dir}")
    print(f"See {report_file} for detailed report")

    return {
        'combined_results': combined_results,
        'context_results': context_results,
        'hierarchical_results': hierarchical_results,
        'temporal_results': temporal_results,
        'combined_profiles': combined_profiles,
    }
