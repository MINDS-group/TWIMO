#!/usr/bin/env python
"""Visualize hierarchical clustering results with multi-dimensional plots.

This script creates rich interactive visualizations:
1. Multi-dimensional scatter (X=style, Y=context, Color=time, Size=duration)
2. Hierarchical sunburst chart
3. Temporal behavior heatmap

Run this after running the advanced clustering analysis.
"""

# Add project root to Python path
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import argparse
import json
from twimo.config import get_config
from twimo.visualization import (
    create_hierarchical_multidim_plot,
    create_hierarchical_sunburst,
    create_temporal_heatmap,
)


def main():
    parser = argparse.ArgumentParser(
        description='Visualize hierarchical clustering results'
    )
    parser.add_argument(
        '--config',
        type=Path,
        default=None,
        help='Path to config.yaml (default: project root)'
    )
    parser.add_argument(
        '--analysis-dir',
        type=Path,
        default=None,
        help='Directory with advanced analysis results (default: from config)'
    )
    parser.add_argument(
        '--manifest',
        type=Path,
        default=None,
        help='Path to manifest.jsonl (for session metadata) (default: from config)'
    )
    parser.add_argument(
        '--outdir',
        type=Path,
        default=None,
        help='Output directory for visualizations (default: from config)'
    )

    args = parser.parse_args()

    # Load configuration
    config = get_config(args.config)

    # Use config defaults if not specified
    analysis_dir = Path(args.analysis_dir) if args.analysis_dir else config.get_output_dir('advanced_analysis')
    manifest_file = Path(args.manifest) if args.manifest else config.manifest_file
    outdir = Path(args.outdir) if args.outdir else config.get_output_dir('advanced_viz')

    # Update args with resolved values
    args.analysis_dir = analysis_dir
    args.manifest = manifest_file
    args.outdir = outdir

    # Validate inputs
    if not args.analysis_dir.exists():
        print(f"Error: Analysis directory not found: {args.analysis_dir}")
        print("Run advanced clustering analysis first:")
        print("  python examples/advanced_clustering_analysis.py")
        return

    # Create output directory
    args.outdir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("HIERARCHICAL CLUSTERING VISUALIZATION")
    print("=" * 70)

    # Load results
    print("\n[1/4] Loading analysis results...")

    # Load combined profiles
    profiles_file = args.analysis_dir / 'combined_profiles.jsonl'
    if not profiles_file.exists():
        print(f"Error: Profiles file not found: {profiles_file}")
        return

    profiles = []
    with open(profiles_file) as f:
        for line in f:
            profiles.append(json.loads(line))

    print(f"  Loaded {len(profiles)} session profiles")

    # Extract data
    session_ids = [p['session_id'] for p in profiles]
    features_list = [p['features'] for p in profiles]
    context_labels = [p['context'] for p in profiles]

    # Load hierarchical results
    hierarchical_file = args.analysis_dir / 'hierarchical' / 'hierarchical_clustering.json'
    if not hierarchical_file.exists():
        print(f"Error: Hierarchical results not found: {hierarchical_file}")
        return

    with open(hierarchical_file) as f:
        hierarchical_results = json.load(f)

    print(f"  Loaded hierarchical clustering results")

    # Load manifest (optional)
    manifest_data = None
    if args.manifest.exists():
        manifest_data = []
        with open(args.manifest) as f:
            for line in f:
                manifest_data.append(json.loads(line))
        print(f"  Loaded manifest with {len(manifest_data)} sessions")

    # Create visualizations
    print("\n[2/4] Creating multi-dimensional scatter plot...")
    create_hierarchical_multidim_plot(
        hierarchical_results=hierarchical_results,
        session_ids=session_ids,
        features_list=features_list,
        context_labels=context_labels,
        manifest_data=manifest_data,
        output_path=args.outdir / 'hierarchical_multidim.html',
        title='Multi-Dimensional Driving Behavior Analysis',
    )

    print("\n[3/4] Creating hierarchical sunburst chart...")
    create_hierarchical_sunburst(
        hierarchical_results=hierarchical_results,
        session_ids=session_ids,
        output_path=args.outdir / 'hierarchical_sunburst.html',
        title='Hierarchical Clustering Structure',
    )

    # Load temporal results if available
    temporal_file = args.analysis_dir / 'temporal' / 'temporal_transitions.json'
    if temporal_file.exists():
        print("\n[4/4] Creating temporal behavior heatmap...")

        with open(temporal_file) as f:
            temporal_transitions = json.load(f)

        temporal_results = {
            'session_transitions': temporal_transitions,
        }

        create_temporal_heatmap(
            temporal_results=temporal_results,
            session_ids=session_ids,
            output_path=args.outdir / 'temporal_heatmap.html',
            title='Temporal Behavior Evolution',
        )
    else:
        print("\n[4/4] Skipping temporal heatmap (temporal results not found)")

    # Summary
    print("\n" + "=" * 70)
    print("VISUALIZATION COMPLETE!")
    print("=" * 70)

    print(f"\nGenerated Visualizations:")
    print(f"  1. Multi-Dimensional Scatter:")
    print(f"     {args.outdir / 'hierarchical_multidim.html'}")
    print(f"     - X-axis: Aggressiveness (prudent to aggressive)")
    print(f"     - Y-axis: Context (city to highway)")
    print(f"     - Color: Time of day")
    print(f"     - Size: Session duration")
    print(f"\n  2. Hierarchical Sunburst:")
    print(f"     {args.outdir / 'hierarchical_sunburst.html'}")
    print(f"     - Shows clustering hierarchy")
    print(f"     - Interactive drill-down")

    if temporal_file.exists():
        print(f"\n  3. Temporal Heatmap:")
        print(f"     {args.outdir / 'temporal_heatmap.html'}")
        print(f"     - Shows behavior changes over time")
        print(f"     - Rows = sessions, Columns = time windows")

    print(f"\n" + "=" * 70)
    print("NEXT STEPS")
    print("=" * 70)
    print(f"\n1. Open multi-dimensional plot in browser:")
    print(f"   start {args.outdir / 'hierarchical_multidim.html'}")
    print(f"\n2. Explore hierarchical structure:")
    print(f"   start {args.outdir / 'hierarchical_sunburst.html'}")
    if temporal_file.exists():
        print(f"\n3. Analyze temporal patterns:")
        print(f"   start {args.outdir / 'temporal_heatmap.html'}")


if __name__ == '__main__':
    main()
