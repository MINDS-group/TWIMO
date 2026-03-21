#!/usr/bin/env python
"""Visualize EAF area-aware hierarchical clustering with multi-dimensional plots.

This script creates rich interactive hierarchical visualizations:
1. Multi-dimensional scatter: X=aggressiveness, Y=area, Color=style, Size=duration
2. Hierarchical sunburst: Area -> Style -> Sessions
3. Session-area heatmap: Matrix showing style per session-area combination

This is the EAF-aware equivalent of visualize_hierarchical_clustering.py.

Run this after running advanced_clustering_analysis_eaf.py.
"""

# Add project root to Python path
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import argparse
import json
import subprocess


def run_hierarchical_visualization(results_dir: Path, outdir: Path) -> None:
    """Run hierarchical visualization via hierarchical_eaf_viz.py."""
    print("=" * 70)
    print("EAF AREA-AWARE HIERARCHICAL VISUALIZATION")
    print("=" * 70)
    print()

    cmd = [
        sys.executable,
        "twimo/strategies_eaf/hierarchical_eaf_viz.py",
        "--results-dir", str(results_dir),
        "--outdir", str(outdir),
    ]

    print(f"Running: {' '.join(cmd)}\n")
    subprocess.run(cmd, check=True)


def print_summary(results_dir: Path, viz_dir: Path) -> None:
    """Print visualization summary with statistics."""
    print("\n" + "=" * 70)
    print("HIERARCHICAL VISUALIZATION COMPLETE!")
    print("=" * 70)

    # Load summary for stats
    summary_file = results_dir / "style_eaf_summary.json"
    with open(summary_file) as f:
        summary = json.load(f)

    print(f"\n[Dataset Overview]")
    print(f"   Sessions:     {summary['n_sessions']}")
    print(f"   Segments:     {summary['n_segments']}")
    print(f"   Areas:        {len(summary['area_counts'])} ({', '.join(sorted(summary['area_counts'].keys()))})")
    print(f"   Styles:       {summary['k']} ({', '.join(summary['cluster_names'].values())})")

    print(f"\n[Hierarchical Structure]")
    print(f"   Level 1:      Area (geographical context)")
    print(f"   Level 2:      Style (driving behavior within area)")
    print(f"   Segments:     {summary['n_segments']} (session × area pairs)")

    print(f"\n[Generated Visualizations]")
    plots = [
        ("multidim_scatter.html", "Multi-dimensional scatter plot",
         "X=aggressiveness, Y=area score, Color=style, Size=duration"),
        ("sunburst_area_style.html", "Hierarchical sunburst chart",
         "Interactive drill-down: Area -> Style -> Sessions"),
        ("heatmap_session_area.html", "Session-area heatmap",
         "Matrix showing style for each (session, area) pair"),
    ]

    for filename, title, description in plots:
        filepath = viz_dir / filename
        if filepath.exists():
            print(f"\n   [OK] {filename}")
            print(f"        {title}")
            print(f"        {description}")
        else:
            print(f"\n   [MISS] {filename} (not found)")

    print(f"\n[Output Directory]")
    print(f"   {viz_dir}")

    print("\n" + "=" * 70)
    print("VISUALIZATION GUIDE")
    print("=" * 70)

    print("\n[1] Multi-Dimensional Scatter")
    print("    This plot reveals the relationship between aggressiveness and area.")
    print("    - X-axis: Aggressiveness score (derived from accel, brake, steering)")
    print("    - Y-axis: Area context (downtown=0, freeway=0.5, tunnel=1)")
    print("    - Color: Driving style cluster (prudent/smooth/aggressive)")
    print("    - Size: Segment duration (larger = longer driving time)")
    print("    Use this to identify patterns like:")
    print("    - Do drivers behave more aggressively in certain areas?")
    print("    - How does style vary between downtown and freeway?")

    print("\n[2] Sunburst Chart")
    print("    Hierarchical view showing the distribution across areas and styles.")
    print("    - Inner ring: Areas (downtown, freeway, tunnel)")
    print("    - Outer ring: Styles within each area")
    print("    Click on segments to drill down and explore the hierarchy.")

    print("\n[3] Session-Area Heatmap")
    print("    Shows which style each driver exhibits in each area.")
    print("    - Rows: Individual driving sessions")
    print("    - Columns: Areas (downtown, freeway, tunnel)")
    print("    - Cell color: Driving style in that (session, area)")
    print("    Use this to identify:")
    print("    - Drivers who adapt their style to different areas")
    print("    - Drivers who maintain consistent style across areas")

    print("\n" + "=" * 70)
    print("NEXT STEPS")
    print("=" * 70)
    print("\n1. Explore multi-dimensional relationships:")
    print(f"   start {viz_dir / 'multidim_scatter.html'}")
    print("\n2. Navigate hierarchical structure:")
    print(f"   start {viz_dir / 'sunburst_area_style.html'}")
    print("\n3. Analyze session-level adaptability:")
    print(f"   start {viz_dir / 'heatmap_session_area.html'}")
    print("\n4. Review detailed statistics:")
    print(f"   cat {results_dir / 'ANALYSIS_REPORT_EAF.txt'}")


def main():
    parser = argparse.ArgumentParser(
        description='Visualize EAF area-aware hierarchical clustering results'
    )
    parser.add_argument(
        '--results-dir',
        type=Path,
        default=Path('./artifacts/eaf/style_analysis'),
        help='Directory with style_eaf clustering results'
    )
    parser.add_argument(
        '--outdir',
        type=Path,
        default=None,
        help='Output directory for plots (default: results-dir/plots)'
    )

    args = parser.parse_args()

    # Set default outdir
    if args.outdir is None:
        args.outdir = args.results_dir / "plots"

    # Validate inputs
    if not args.results_dir.exists():
        print(f"Error: Results directory not found: {args.results_dir}")
        print("Run clustering analysis first:")
        print("  python twimo/workflows/advanced_clustering_analysis_eaf.py")
        return

    profiles_file = args.results_dir / "style_eaf_profiles.jsonl"
    if not profiles_file.exists():
        print(f"Error: Profiles file not found: {profiles_file}")
        print("Run clustering analysis first:")
        print("  python twimo/workflows/advanced_clustering_analysis_eaf.py")
        return

    # Create output directory
    args.outdir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("EAF AREA-AWARE HIERARCHICAL VISUALIZATION")
    print("=" * 70)
    print(f"\nResults dir:  {args.results_dir}")
    print(f"Output dir:   {args.outdir}")
    print()

    # Check for Plotly
    try:
        import plotly  # noqa: F401
        print("[OK] Plotly is installed")
    except ImportError:
        print("[ERROR] Plotly not installed. Install with:")
        print("        pip install plotly")
        return

    # Run hierarchical visualization
    run_hierarchical_visualization(args.results_dir, args.outdir)

    # Print summary with interpretation guide
    print_summary(args.results_dir, args.outdir)


if __name__ == '__main__':
    main()
