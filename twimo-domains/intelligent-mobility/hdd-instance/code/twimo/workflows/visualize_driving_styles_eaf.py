#!/usr/bin/env python
"""
Visualize EAF area-aware driving style clustering results.

This script creates interactive visualizations for area-aware style clusters:
1. 2D PCA scatter plot (style × area)
2. Style distribution bar chart per area
3. Radar chart of feature profiles
4. Box plots of features grouped by area and style

This is the EAF-aware equivalent of visualize_driving_styles.py.

Run this after running advanced_clustering_analysis_eaf.py.
"""

# Add project root to Python path
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import argparse
import json
import subprocess


def run_visualization(results_dir: Path, outdir: Path) -> None:
    """Run style visualization via style_eaf_viz.py."""
    print("=" * 70)
    print("EAF AREA-AWARE STYLE VISUALIZATION")
    print("=" * 70)
    print()

    cmd = [
        sys.executable,
        "twimo/strategies_eaf/style_eaf_viz.py",
        "--results-dir", str(results_dir),
        "--outdir", str(outdir),
    ]

    print(f"Running: {' '.join(cmd)}\n")
    subprocess.run(cmd, check=True)


def print_summary(results_dir: Path, viz_dir: Path) -> None:
    """Print visualization summary."""
    print("\n" + "=" * 70)
    print("VISUALIZATION COMPLETE!")
    print("=" * 70)

    # Load summary for stats
    summary_file = results_dir / "style_eaf_summary.json"
    with open(summary_file) as f:
        summary = json.load(f)

    print(f"\n[Dataset Statistics]")
    print(f"   Sessions:     {summary['n_sessions']}")
    print(f"   Segments:     {summary['n_segments']}")
    print(f"   Clusters:     {summary['k']}")
    print(f"   Areas:        {', '.join(sorted(summary['area_counts'].keys()))}")

    print(f"\n[Generated Visualizations]")

    # Dimensionality reduction plots
    reduction_plots = [
        ("driving_styles_umap_2d.html", "UMAP 2D scatter: Color=style, Shape=area"),
        ("driving_styles_umap_3d.html", "UMAP 3D scatter: Color=style, Shape=area"),
        ("driving_styles_pca_2d.html", "PCA 2D scatter (comparison): Color=style, Shape=area"),
    ]

    # Other analysis plots
    analysis_plots = [
        ("distribution_per_area.html", "Bar chart: Style distribution per area"),
        ("radar_profiles.html", "Radar chart: Feature profiles (style × area)"),
        ("boxplots_features.html", "Box plots: Features grouped by area and style"),
    ]

    plots = reduction_plots + analysis_plots

    for filename, description in plots:
        filepath = viz_dir / filename
        if filepath.exists():
            print(f"   [OK] {filename}")
            print(f"        {description}")
        else:
            print(f"   [MISS] {filename} (not found)")

    print(f"\n[Output Directory]")
    print(f"   {viz_dir}")

    print("\n" + "=" * 70)
    print("NEXT STEPS")
    print("=" * 70)
    print("\n[Dimensionality Reduction Plots]")
    print("\n1. Explore UMAP 2D projection (recommended - best separation):")
    print(f"   start {viz_dir / 'driving_styles_umap_2d.html'}")
    print("\n2. Explore UMAP 3D projection (interactive rotation):")
    print(f"   start {viz_dir / 'driving_styles_umap_3d.html'}")
    print("\n3. Compare with PCA 2D (linear projection):")
    print(f"   start {viz_dir / 'driving_styles_pca_2d.html'}")

    print("\n[Analysis Plots]")
    print("\n4. View per-area style distribution:")
    print(f"   start {viz_dir / 'distribution_per_area.html'}")
    print("\n5. Compare feature profiles:")
    print(f"   start {viz_dir / 'radar_profiles.html'}")
    print("\n6. Analyze feature distributions:")
    print(f"   start {viz_dir / 'boxplots_features.html'}")

    print("\n[Next: Hierarchical Visualizations]")
    print("\n7. Generate hierarchical plots:")
    print(f"   python workflows/visualize_hierarchical_clustering_eaf.py --results-dir {results_dir}")


def main():
    parser = argparse.ArgumentParser(
        description='Visualize EAF area-aware driving styles'
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
    print("EAF AREA-AWARE DRIVING STYLE VISUALIZATION")
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

    # Run visualization
    run_visualization(args.results_dir, args.outdir)

    # Print summary
    print_summary(args.results_dir, args.outdir)


if __name__ == "__main__":
    main()
