#!/usr/bin/env python
"""Advanced EAF area-aware clustering analysis workflow.

This script runs area-aware driving style clustering using EAF Area annotations
(downtown/freeway/tunnel), then generates comprehensive statistics and reports.

This is the EAF-aware equivalent of advanced_clustering_analysis.py, but segments
data by geographical area from EAF annotations instead of context detection.

Workflow:
1. Segment sensor data by EAF Area tier
2. Compute style features per (session, area) segment
3. Cluster globally into prudent / smooth / aggressive
4. Generate per-area distribution statistics
5. Save comprehensive results and reports

Run this after parsing EAF files and having prealigned sensor data.
"""

# Add project root to Python path
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import argparse
import json
import subprocess


def run_clustering(
    sensor_dir: Path,
    eaf_parsed_dir: Path,
    vocab_dir: Path,
    outdir: Path,
    k: int = 3,
    sample_hz: float = 3.0,
) -> dict:
    """Run area-aware style clustering via style_eaf.py."""
    print("=" * 70)
    print("STEP 1: AREA-AWARE STYLE CLUSTERING")
    print("=" * 70)
    print()

    cmd = [
        sys.executable,
        "twimo/strategies_eaf/style_eaf.py",
        "cluster",
        "--sensor-dir", str(sensor_dir),
        "--eaf-parsed-dir", str(eaf_parsed_dir),
        "--vocab-dir", str(vocab_dir),
        "--outdir", str(outdir),
        "--k", str(k),
        "--sample-hz", str(sample_hz),
    ]

    print(f"Running: {' '.join(cmd)}\n")
    result = subprocess.run(cmd, check=True)

    # Load results
    summary_file = outdir / "style_eaf_summary.json"
    with open(summary_file) as f:
        summary = json.load(f)

    return summary


def generate_report(summary: dict, outdir: Path) -> None:
    """Generate comprehensive text report."""
    print("\n" + "=" * 70)
    print("STEP 2: GENERATING ANALYSIS REPORT")
    print("=" * 70)

    report_lines = []
    report_lines.append("=" * 70)
    report_lines.append("AREA-AWARE DRIVING STYLE ANALYSIS REPORT")
    report_lines.append("=" * 70)
    report_lines.append("")

    # Overview
    report_lines.append("OVERVIEW")
    report_lines.append("-" * 70)
    report_lines.append(f"Sessions analyzed:     {summary['n_sessions']}")
    report_lines.append(f"Total segments:        {summary['n_segments']}")
    report_lines.append(f"Number of clusters:    {summary['k']}")
    report_lines.append("")

    # Area distribution
    report_lines.append("AREA DISTRIBUTION")
    report_lines.append("-" * 70)
    for area, count in sorted(summary['area_counts'].items()):
        pct = 100.0 * count / summary['n_segments']
        report_lines.append(f"  {area:15s}: {count:4d} segments ({pct:5.1f}%)")
    report_lines.append("")

    # Cluster distribution
    report_lines.append("STYLE CLUSTER DISTRIBUTION (GLOBAL)")
    report_lines.append("-" * 70)
    for cid, cname in sorted(summary['cluster_names'].items(), key=lambda x: x[0]):
        # Count segments in this cluster
        # We need to load profiles to count
        profiles_file = outdir / "style_eaf_profiles.jsonl"
        cluster_counts = {}
        with open(profiles_file) as f:
            for line in f:
                p = json.loads(line)
                cluster_counts[p['style']] = cluster_counts.get(p['style'], 0) + 1

        count = cluster_counts.get(cname, 0)
        pct = 100.0 * count / summary['n_segments']
        report_lines.append(f"  {cname:15s}: {count:4d} segments ({pct:5.1f}%)")
    report_lines.append("")

    # Per-area style distribution
    report_lines.append("STYLE DISTRIBUTION PER AREA")
    report_lines.append("-" * 70)
    dist = summary.get('per_area_distribution', {})
    for area in sorted(dist.keys()):
        area_dist = dist[area]
        total = sum(area_dist.values())
        report_lines.append(f"\n[{area.upper()}] ({total} segments)")
        for style in ['prudent', 'smooth', 'aggressive']:
            count = area_dist.get(style, 0)
            pct = 100.0 * count / total if total > 0 else 0
            report_lines.append(f"  {style:12s}: {count:4d} ({pct:5.1f}%)")
    report_lines.append("")

    # Per-area feature statistics
    report_lines.append("FEATURE STATISTICS PER AREA")
    report_lines.append("-" * 70)
    stats = summary.get('per_area_feature_stats', {})
    for area in sorted(stats.keys()):
        area_stats = stats[area]
        report_lines.append(f"\n[{area.upper()}]")
        for feat in ['aggr_score', 'accel_p95', 'brake_p95', 'vel_p95', 'steer_std', 'steer_speed_p95']:
            if feat in area_stats:
                s = area_stats[feat]
                report_lines.append(
                    f"  {feat:20s}: {s['mean']:8.3f} ± {s['std']:8.3f}  "
                    f"[{s['min']:8.3f}, {s['max']:8.3f}]"
                )
    report_lines.append("")

    # Output files
    report_lines.append("OUTPUT FILES")
    report_lines.append("-" * 70)
    report_lines.append(f"  {outdir / 'style_eaf_profiles.jsonl'}")
    report_lines.append(f"  {outdir / 'style_eaf_centroids.json'}")
    report_lines.append(f"  {outdir / 'style_eaf_summary.json'}")
    report_lines.append(f"  {outdir / 'ANALYSIS_REPORT_EAF.txt'}")
    report_lines.append("")

    report_lines.append("=" * 70)
    report_lines.append("END OF REPORT")
    report_lines.append("=" * 70)

    # Save report
    report_file = outdir / "ANALYSIS_REPORT_EAF.txt"
    report_file.write_text("\n".join(report_lines), encoding="utf-8")

    # Print to console
    print("\n" + "\n".join(report_lines))
    print(f"\nReport saved to: {report_file}")


def main():
    parser = argparse.ArgumentParser(
        description='Advanced EAF area-aware clustering analysis'
    )
    parser.add_argument(
        '--sensor-dir',
        type=Path,
        default=Path('./twimo/assets/hdd_prealigned/20200710_sensors/sensor'),
        help='Directory with prealigned sensor .npy files'
    )
    parser.add_argument(
        '--eaf-parsed-dir',
        type=Path,
        default=Path('./artifacts/eaf/parsed'),
        help='Directory with parsed EAF .json files'
    )
    parser.add_argument(
        '--vocab-dir',
        type=Path,
        default=Path('./artifacts/eaf/vocabs'),
        help='Directory with vocab_area.json'
    )
    parser.add_argument(
        '--outdir',
        type=Path,
        default=Path('./artifacts/eaf/style_analysis'),
        help='Output directory for results'
    )
    parser.add_argument(
        '--k',
        type=int,
        default=3,
        help='Number of clusters (default: 3 for prudent/smooth/aggressive)'
    )
    parser.add_argument(
        '--sample-hz',
        type=float,
        default=3.0,
        help='Sample rate in Hz (default: 3.0)'
    )

    args = parser.parse_args()

    # Validate inputs
    if not args.sensor_dir.exists():
        print(f"Error: Sensor directory not found: {args.sensor_dir}")
        return

    if not args.eaf_parsed_dir.exists():
        print(f"Error: EAF parsed directory not found: {args.eaf_parsed_dir}")
        print("Run EAF parsing first:")
        print("  python twimo/strategies_eaf/parse_eaf.py")
        return

    if not args.vocab_dir.exists():
        print(f"Error: Vocab directory not found: {args.vocab_dir}")
        print("Run vocabulary building first:")
        print("  python twimo/strategies_eaf/build_all_vocabs_chinese.py")
        return

    # Create output directory
    args.outdir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("ADVANCED EAF AREA-AWARE CLUSTERING ANALYSIS")
    print("=" * 70)
    print(f"\nSensor dir:      {args.sensor_dir}")
    print(f"EAF parsed dir:  {args.eaf_parsed_dir}")
    print(f"Vocab dir:       {args.vocab_dir}")
    print(f"Output dir:      {args.outdir}")
    print(f"Clusters (k):    {args.k}")
    print()

    # Run clustering
    summary = run_clustering(
        sensor_dir=args.sensor_dir,
        eaf_parsed_dir=args.eaf_parsed_dir,
        vocab_dir=args.vocab_dir,
        outdir=args.outdir,
        k=args.k,
        sample_hz=args.sample_hz,
    )

    # Generate report
    generate_report(summary, args.outdir)

    # Summary
    print("\n" + "=" * 70)
    print("ANALYSIS COMPLETE!")
    print("=" * 70)
    print(f"\nResults directory: {args.outdir}")
    print(f"\nKey Files:")
    print(f"  - style_eaf_profiles.jsonl     - All segment profiles with style labels")
    print(f"  - style_eaf_centroids.json     - Cluster centroids and mapping")
    print(f"  - style_eaf_summary.json       - Per-area distribution stats")
    print(f"  - ANALYSIS_REPORT_EAF.txt      - Human-readable comprehensive report")

    print("\n" + "=" * 70)
    print("NEXT STEPS")
    print("=" * 70)
    print("\n1. View detailed report:")
    print(f"   cat {args.outdir / 'ANALYSIS_REPORT_EAF.txt'}")
    print("\n2. Explore segment profiles:")
    print(f"   head {args.outdir / 'style_eaf_profiles.jsonl'}")
    print("\n3. Generate visualizations:")
    print(f"   python workflows/visualize_driving_styles_eaf.py --results-dir {args.outdir}")
    print("\n4. Create hierarchical plots:")
    print(f"   python workflows/visualize_hierarchical_clustering_eaf.py --results-dir {args.outdir}")


if __name__ == '__main__':
    main()
