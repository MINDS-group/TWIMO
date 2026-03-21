#!/usr/bin/env python3
"""
Visualization for area-aware driving style clustering results.

Creates interactive Plotly HTML plots:
1. 2D scatter (PCA) colored by style, shaped by area
2. Bar chart: style distribution per area
3. Radar chart: mean feature profiles per (style x area)
4. Box plots: key features grouped by area, colored by style

Usage:
    python style_eaf_viz.py --results-dir ./artifacts/eaf/style_analysis --outdir ./artifacts/eaf/style_analysis/plots
"""
from __future__ import annotations

import argparse
import json
import sys
from pathlib import Path
from typing import Dict, List

import numpy as np


# ---------------------------------------------------------------------------
# Data loading
# ---------------------------------------------------------------------------

def load_profiles(results_dir: Path) -> List[Dict]:
    """Load style_eaf_profiles.jsonl."""
    profiles = []
    path = results_dir / "style_eaf_profiles.jsonl"
    with open(path, encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if line:
                profiles.append(json.loads(line))
    return profiles


def load_summary(results_dir: Path) -> Dict:
    """Load style_eaf_summary.json."""
    path = results_dir / "style_eaf_summary.json"
    with open(path, encoding="utf-8") as f:
        return json.load(f)


def load_centroids(results_dir: Path) -> Dict:
    """Load style_eaf_centroids.json."""
    path = results_dir / "style_eaf_centroids.json"
    with open(path, encoding="utf-8") as f:
        return json.load(f)


# ---------------------------------------------------------------------------
# Dimensionality reduction
# ---------------------------------------------------------------------------

def reduce_dimensions(X: np.ndarray, method: str = "pca", n_components: int = 2) -> np.ndarray:
    """Reduce feature matrix to 2D/3D for visualization."""
    if method == "pca":
        from sklearn.decomposition import PCA
        model = PCA(n_components=n_components, random_state=42)
        X_reduced = model.fit_transform(X)
        var = model.explained_variance_ratio_.sum()
        print(f"    [PCA] Explained variance: {var:.2%}")
    elif method == "tsne":
        from sklearn.manifold import TSNE
        model = TSNE(
            n_components=n_components, random_state=42,
            perplexity=min(30, X.shape[0] - 1), n_iter=1000,
        )
        X_reduced = model.fit_transform(X)
        print(f"    [t-SNE] Completed with {n_components}D projection")
    elif method == "umap":
        try:
            import umap
            model = umap.UMAP(
                n_components=n_components,
                random_state=42,
                n_neighbors=min(15, X.shape[0] - 1),
                min_dist=0.1,
            )
            X_reduced = model.fit_transform(X)
            print(f"    [UMAP] Completed with {n_components}D projection")
        except ImportError:
            print("    [Warning] UMAP not installed. Install with: pip install umap-learn")
            print("              Falling back to PCA...")
            return reduce_dimensions(X, method="pca", n_components=n_components)
    else:
        raise ValueError(f"Unknown method: {method}")
    return X_reduced


# ---------------------------------------------------------------------------
# Plot 1: 2D/3D scatter colored by style, shaped by area
# ---------------------------------------------------------------------------

def plot_scatter_style_area(
    profiles: List[Dict],
    outdir: Path,
    method: str = "pca",
    n_components: int = 2,
) -> None:
    """2D/3D scatter with style as color and area as marker shape."""
    import plotly.graph_objects as go

    # Build feature matrix
    feat_keys = sorted({k for p in profiles for k in p["features"].keys()})
    X = np.array(
        [[p["features"].get(k, 0.0) for k in feat_keys] for p in profiles],
        dtype=np.float32,
    )
    X_reduced = reduce_dimensions(X, method=method, n_components=n_components)

    style_colors = {
        "prudent": "#2E7D32",
        "smooth": "#1976D2",
        "aggressive": "#D32F2F",
    }
    area_symbols = {
        "unknown": "circle",
        "downtown": "square",
        "freeway": "diamond",
        "tunnel": "triangle-up",
    }

    fig = go.Figure()

    # Group by (style, area)
    combos = set((p["style"], p["area_name"]) for p in profiles)
    for style, area in sorted(combos):
        mask = [
            i for i, p in enumerate(profiles)
            if p["style"] == style and p["area_name"] == area
        ]
        if not mask:
            continue

        if n_components == 2:
            # 2D scatter
            fig.add_trace(go.Scatter(
                x=X_reduced[mask, 0],
                y=X_reduced[mask, 1],
                mode="markers",
                name=f"{style} / {area}",
                marker=dict(
                    size=10,
                    color=style_colors.get(style, "#757575"),
                    symbol=area_symbols.get(area, "circle"),
                    opacity=0.75,
                    line=dict(width=1, color="white"),
                ),
                text=[profiles[i]["session_id"] for i in mask],
                customdata=[
                    [profiles[i]["duration_sec"], profiles[i]["features"].get("aggr_score", 0)]
                    for i in mask
                ],
                hovertemplate=(
                    "<b>%{text}</b><br>"
                    f"Style: {style}<br>"
                    f"Area: {area}<br>"
                    "Aggr score: %{customdata[1]:.3f}<br>"
                    "Duration: %{customdata[0]:.1f}s<br>"
                    "Dim1: %{x:.2f}, Dim2: %{y:.2f}"
                    "<extra></extra>"
                ),
            ))
        else:
            # 3D scatter
            fig.add_trace(go.Scatter3d(
                x=X_reduced[mask, 0],
                y=X_reduced[mask, 1],
                z=X_reduced[mask, 2],
                mode="markers",
                name=f"{style} / {area}",
                marker=dict(
                    size=6,
                    color=style_colors.get(style, "#757575"),
                    symbol=area_symbols.get(area, "circle"),
                    opacity=0.75,
                    line=dict(width=0.5, color="white"),
                ),
                text=[profiles[i]["session_id"] for i in mask],
                customdata=[
                    [profiles[i]["duration_sec"], profiles[i]["features"].get("aggr_score", 0)]
                    for i in mask
                ],
                hovertemplate=(
                    "<b>%{text}</b><br>"
                    f"Style: {style}<br>"
                    f"Area: {area}<br>"
                    "Aggr score: %{customdata[1]:.3f}<br>"
                    "Duration: %{customdata[0]:.1f}s<br>"
                    "X: %{x:.2f}, Y: %{y:.2f}, Z: %{z:.2f}"
                    "<extra></extra>"
                ),
            ))

    method_upper = method.upper()
    if n_components == 2:
        fig.update_layout(
            title=f"Driving Style Clusters by Area ({method_upper} 2D)",
            xaxis_title="Dimension 1",
            yaxis_title="Dimension 2",
            hovermode="closest",
            template="plotly_white",
            width=1100,
            height=750,
            legend=dict(title="Style / Area"),
        )
    else:
        fig.update_layout(
            title=f"Driving Style Clusters by Area ({method_upper} 3D)",
            scene=dict(
                xaxis_title="Dimension 1",
                yaxis_title="Dimension 2",
                zaxis_title="Dimension 3",
            ),
            hovermode="closest",
            template="plotly_white",
            width=1100,
            height=800,
            legend=dict(title="Style / Area"),
        )

    suffix = f"{method}_{n_components}d"
    out = outdir / f"driving_styles_{suffix}.html"
    fig.write_html(str(out))
    print(f"  [OK] {out.name}")


# ---------------------------------------------------------------------------
# Plot 2: Bar chart — style distribution per area
# ---------------------------------------------------------------------------

def plot_distribution_per_area(summary: Dict, outdir: Path) -> None:
    """Grouped bar chart of style counts per area."""
    import plotly.graph_objects as go

    dist = summary.get("per_area_distribution", {})
    if not dist:
        print("  [SKIP] No per_area_distribution in summary")
        return

    areas = sorted(dist.keys())
    styles = ["prudent", "smooth", "aggressive"]
    style_colors = {"prudent": "#2E7D32", "smooth": "#1976D2", "aggressive": "#D32F2F"}

    fig = go.Figure()
    for style in styles:
        counts = [dist[area].get(style, 0) for area in areas]
        fig.add_trace(go.Bar(
            name=style.capitalize(),
            x=[a.capitalize() for a in areas],
            y=counts,
            marker_color=style_colors.get(style, "#757575"),
            text=counts,
            textposition="auto",
        ))

    fig.update_layout(
        title="Driving Style Distribution per Area",
        xaxis_title="Area",
        yaxis_title="Number of Segments",
        barmode="group",
        template="plotly_white",
        width=900,
        height=600,
    )

    out = outdir / "distribution_per_area.html"
    fig.write_html(str(out))
    print(f"  [OK] {out.name}")


# ---------------------------------------------------------------------------
# Plot 3: Radar chart — mean feature profiles per (style x area)
# ---------------------------------------------------------------------------

def plot_radar_profiles(profiles: List[Dict], outdir: Path) -> None:
    """Radar chart of mean feature values per style x area."""
    import plotly.graph_objects as go

    feat_keys = ["accel_p95", "brake_p95", "vel_p95", "steer_std", "steer_speed_p95", "aggr_score"]
    feat_labels = ["Accel P95", "Brake P95", "Vel P95", "Steer Std", "Steer Spd P95", "Aggr Score"]

    combos = sorted(set((p["style"], p["area_name"]) for p in profiles))
    style_colors = {"prudent": "#2E7D32", "smooth": "#1976D2", "aggressive": "#D32F2F"}

    # Normalize features to 0-1 for radar comparison
    all_vals = {fk: [] for fk in feat_keys}
    for p in profiles:
        for fk in feat_keys:
            all_vals[fk].append(p["features"].get(fk, 0.0))
    feat_min = {fk: min(v) if v else 0 for fk, v in all_vals.items()}
    feat_max = {fk: max(v) if v else 1 for fk, v in all_vals.items()}

    fig = go.Figure()
    for style, area in combos:
        segs = [p for p in profiles if p["style"] == style and p["area_name"] == area]
        if not segs:
            continue

        means = []
        for fk in feat_keys:
            vals = [s["features"].get(fk, 0.0) for s in segs]
            raw_mean = float(np.mean(vals))
            rng = feat_max[fk] - feat_min[fk]
            norm = (raw_mean - feat_min[fk]) / rng if rng > 0 else 0.5
            means.append(norm)

        # Close the radar polygon
        fig.add_trace(go.Scatterpolar(
            r=means + [means[0]],
            theta=feat_labels + [feat_labels[0]],
            fill="toself",
            name=f"{style} / {area}",
            opacity=0.5,
            line=dict(color=style_colors.get(style, "#757575")),
        ))

    fig.update_layout(
        polar=dict(radialaxis=dict(visible=True, range=[0, 1])),
        title="Feature Profiles: Style x Area (Normalized)",
        template="plotly_white",
        width=900,
        height=700,
    )

    out = outdir / "radar_profiles.html"
    fig.write_html(str(out))
    print(f"  [OK] {out.name}")


# ---------------------------------------------------------------------------
# Plot 4: Box plots — key features grouped by area, colored by style
# ---------------------------------------------------------------------------

def plot_boxplots_features(profiles: List[Dict], outdir: Path) -> None:
    """Box plots of key features, one subplot per feature, grouped by area+style."""
    import plotly.graph_objects as go
    from plotly.subplots import make_subplots

    feat_keys = ["accel_p95", "brake_p95", "vel_p95", "steer_std"]
    feat_labels = ["Accel P95", "Brake P95", "Velocity P95", "Steering Std"]
    style_colors = {"prudent": "#2E7D32", "smooth": "#1976D2", "aggressive": "#D32F2F"}

    areas = sorted(set(p["area_name"] for p in profiles))
    styles = sorted(set(p["style"] for p in profiles),
                    key=lambda s: ["prudent", "smooth", "aggressive"].index(s)
                    if s in ["prudent", "smooth", "aggressive"] else 99)

    fig = make_subplots(
        rows=2, cols=2,
        subplot_titles=feat_labels,
        horizontal_spacing=0.1,
        vertical_spacing=0.12,
    )

    for fi, fk in enumerate(feat_keys):
        row = fi // 2 + 1
        col = fi % 2 + 1
        for style in styles:
            vals = []
            x_labels = []
            for area in areas:
                segs = [
                    p for p in profiles
                    if p["style"] == style and p["area_name"] == area
                ]
                for s in segs:
                    vals.append(s["features"].get(fk, 0.0))
                    x_labels.append(area.capitalize())

            fig.add_trace(
                go.Box(
                    y=vals,
                    x=x_labels,
                    name=style.capitalize(),
                    marker_color=style_colors.get(style, "#757575"),
                    legendgroup=style,
                    showlegend=(fi == 0),
                ),
                row=row, col=col,
            )

    fig.update_layout(
        title="Feature Distributions by Area and Style",
        boxmode="group",
        template="plotly_white",
        width=1200,
        height=800,
    )

    out = outdir / "boxplots_features.html"
    fig.write_html(str(out))
    print(f"  [OK] {out.name}")


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def main():
    parser = argparse.ArgumentParser(
        description="Visualize area-aware driving style clustering results"
    )
    parser.add_argument("--results-dir", required=True, help="Dir with style_eaf results")
    parser.add_argument("--outdir", default=None, help="Output dir for plots (default: results-dir/plots)")
    parser.add_argument("--method", default="umap", choices=["pca", "tsne", "umap"],
                        help="Dim reduction method for scatter (default: umap)")
    args = parser.parse_args()

    results_dir = Path(args.results_dir)
    outdir = Path(args.outdir) if args.outdir else results_dir / "plots"
    outdir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("AREA-AWARE STYLE VISUALIZATION")
    print("=" * 70)
    print(f"Results dir: {results_dir}")
    print(f"Output dir:  {outdir}")
    print()

    # Load data
    profiles = load_profiles(results_dir)
    summary = load_summary(results_dir)
    print(f"Loaded {len(profiles)} segment profiles\n")

    try:
        import plotly  # noqa: F401
    except ImportError:
        print("[ERROR] Plotly not installed. Install with: pip install plotly")
        sys.exit(1)

    # Generate plots
    print("--- Generating dimensionality reduction plots ---")
    reduction_method = args.method
    print(f"Using method: {reduction_method}")

    # Primary method 2D
    print(f"\n  [1/3] {reduction_method.upper()} (2D)...")
    plot_scatter_style_area(profiles, outdir, method=reduction_method, n_components=2)

    # Primary method 3D
    print(f"  [2/3] {reduction_method.upper()} (3D)...")
    plot_scatter_style_area(profiles, outdir, method=reduction_method, n_components=3)

    # PCA 2D for comparison
    if reduction_method != "pca":
        print(f"  [3/3] PCA (2D) for comparison...")
        plot_scatter_style_area(profiles, outdir, method="pca", n_components=2)

    print("\n--- Generating other plots ---")
    plot_distribution_per_area(summary, outdir)
    plot_radar_profiles(profiles, outdir)
    plot_boxplots_features(profiles, outdir)

    print(f"\n[OK] All plots saved to {outdir}/")


if __name__ == "__main__":
    main()
