#!/usr/bin/env python
"""Advanced clustering analysis example.

This script demonstrates all 5 advanced clustering approaches:
1. Context detection (city/highway/suburban)
2. Advanced feature engineering
3. Temporal segmentation
4. Hierarchical multi-level clustering
5. Complete multi-modal pipeline

Run this after training basic style clustering.
"""

# Add project root to Python path
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import argparse
from twimo.config import get_config
from twimo.analysis.multi_modal_pipeline import run_complete_analysis_pipeline


def main():
    parser = argparse.ArgumentParser(
        description='Advanced multi-modal clustering analysis'
    )
    parser.add_argument(
        '--config',
        type=Path,
        default=None,
        help='Path to config.yaml (default: project root)'
    )
    parser.add_argument(
        '--manifest',
        type=Path,
        default=None,
        help='Path to manifest.jsonl (default: from config)'
    )
    parser.add_argument(
        '--outdir',
        type=Path,
        default=None,
        help='Output directory for results (default: from config)'
    )
    parser.add_argument(
        '--level1-clusters',
        type=int,
        default=None,
        help='Number of Level 1 clusters (driving style) (default: from config)'
    )
    parser.add_argument(
        '--level2-clusters',
        type=int,
        default=None,
        help='Number of Level 2 clusters (context per style) (default: from config)'
    )
    parser.add_argument(
        '--level3-clusters',
        type=int,
        default=None,
        help='Number of Level 3 clusters (behaviors per context) (default: from config)'
    )
    parser.add_argument(
        '--window-size',
        type=int,
        default=None,
        help='Temporal window size in seconds (default: from config)'
    )
    parser.add_argument(
        '--stride',
        type=int,
        default=None,
        help='Temporal stride in seconds (default: from config)'
    )
    parser.add_argument(
        '--temporal-clusters',
        type=int,
        default=None,
        help='Number of temporal clusters (default: from config)'
    )

    args = parser.parse_args()

    # Load configuration
    config = get_config(args.config)

    # Use config defaults if not specified
    manifest_file = Path(args.manifest) if args.manifest else config.manifest_file
    outdir = Path(args.outdir) if args.outdir else config.get_output_dir('advanced_analysis')
    level1_clusters = args.level1_clusters if args.level1_clusters is not None else config.get('clustering.level1_clusters', 3)
    level2_clusters = args.level2_clusters if args.level2_clusters is not None else config.get('clustering.level2_clusters', 7)
    level3_clusters = args.level3_clusters if args.level3_clusters is not None else config.get('clustering.level3_clusters', 11)
    window_size = args.window_size if args.window_size is not None else config.get('temporal.window_size_sec', 30)
    stride = args.stride if args.stride is not None else config.get('temporal.stride_sec', 15)
    temporal_clusters = args.temporal_clusters if args.temporal_clusters is not None else 5

    # Update args with resolved values
    args.manifest = manifest_file
    args.outdir = outdir
    args.level1_clusters = level1_clusters
    args.level2_clusters = level2_clusters
    args.level3_clusters = level3_clusters
    args.window_size = window_size
    args.stride = stride
    args.temporal_clusters = temporal_clusters

    # Validate inputs
    if not args.manifest.exists():
        print(f"Error: Manifest not found at {args.manifest}")
        print("Run data preparation first:")
        print("  python -m twimo.cli prepare-dataset ...")
        return

    # Run complete pipeline
    results = run_complete_analysis_pipeline(
        manifest_path=args.manifest,
        output_dir=args.outdir,
        level1_clusters=args.level1_clusters,
        level2_clusters=args.level2_clusters,
        level3_clusters=args.level3_clusters,
        window_size_sec=args.window_size,
        stride_sec=args.stride,
        temporal_clusters=args.temporal_clusters,
    )

    # Print summary
    print("\n" + "=" * 70)
    print("QUICK SUMMARY")
    print("=" * 70)

    # Context distribution
    print("\nContext Distribution:")
    for context, count in sorted(results['combined_results']['context_distribution'].items(),
                                   key=lambda x: -x[1]):
        pct = count / results['combined_results']['n_sessions'] * 100
        print(f"  {context:15s}: {count:3d} sessions ({pct:5.1f}%)")

    # Hierarchical summary
    print("\nHierarchical Clustering:")
    h_summary = results['combined_results']['hierarchical_summary']
    print(f"  Level 1 (Style):    {h_summary['level1_clusters']} clusters")
    print(f"  Level 2 (Context):  {h_summary['level2_clusters']} clusters")
    print(f"  Level 3 (Behavior): {h_summary['level3_clusters']} clusters")

    # Temporal summary
    print("\nTemporal Segmentation:")
    t_summary = results['combined_results']['temporal_summary']
    print(f"  Total Windows:   {t_summary['n_windows']}")
    print(f"  Window Size:     {t_summary['window_size_sec']} seconds")
    print(f"  Temporal Clusters: {t_summary['n_clusters']}")

    # Output files
    print("\n" + "=" * 70)
    print("OUTPUT FILES")
    print("=" * 70)
    print(f"\nResults Directory: {args.outdir}")
    print(f"\nKey Files:")
    print(f"  - combined_profiles.jsonl      - All session profiles with all clustering levels")
    print(f"  - context_detection.jsonl      - Context detection results (city/highway/suburban)")
    print(f"  - analysis_summary.json        - Overall analysis summary")
    print(f"  - ANALYSIS_REPORT.txt          - Detailed human-readable report")
    print(f"\nHierarchical Clustering:")
    print(f"  - hierarchical/hierarchical_clustering.json")
    print(f"  - hierarchical/hierarchical_assignments.jsonl")
    print(f"  - hierarchical/hierarchical_summary.txt")
    print(f"\nTemporal Segmentation:")
    print(f"  - temporal/temporal_windows.jsonl")
    print(f"  - temporal/temporal_cluster_info.json")
    print(f"  - temporal/temporal_transitions.json")
    print(f"  - temporal/temporal_summary.txt")

    print("\n" + "=" * 70)
    print("NEXT STEPS")
    print("=" * 70)
    print("\n1. View detailed report:")
    print(f"   cat {args.outdir / 'ANALYSIS_REPORT.txt'}")
    print("\n2. Explore combined profiles:")
    print(f"   head {args.outdir / 'combined_profiles.jsonl'}")
    print("\n3. Analyze temporal transitions:")
    print(f"   cat {args.outdir / 'temporal' / 'temporal_summary.txt'}")
    print("\n4. Compare hierarchical levels:")
    print(f"   cat {args.outdir / 'hierarchical' / 'hierarchical_summary.txt'}")


if __name__ == '__main__':
    main()
