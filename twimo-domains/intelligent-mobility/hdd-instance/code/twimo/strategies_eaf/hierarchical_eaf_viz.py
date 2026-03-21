#!/usr/bin/env python3
"""
Hierarchical multi-dimensional visualization for area-aware driving styles.

Creates:
1. Multi-dim scatter: X=aggressiveness, Y=area, Color=style, Size=duration
2. Sunburst: Area -> Style -> Sessions
3. Heatmap: Sessions x Areas, cell color = style

Usage:
    python hierarchical_eaf_viz.py --results-dir ./artifacts/eaf/style_analysis --outdir ./artifacts/eaf/style_analysis/plots
"""
from __future__ import annotations

import argparse
import json
import sys
from collections import Counter, defaultdict
from pathlib import Path
from typing import Dict, List

import numpy as np


# ---------------------------------------------------------------------------
# Data loading
# ---------------------------------------------------------------------------

def load_profiles(results_dir: Path) -> List[Dict]:
    profiles = []
    path = results_dir / "style_eaf_profiles.jsonl"
    with open(path, encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if line:
                profiles.append(json.loads(line))
    return profiles


def load_summary(results_dir: Path) -> Dict:
    path = results_dir / "style_eaf_summary.json"
    with open(path, encoding="utf-8") as f:
        return json.load(f)


# ---------------------------------------------------------------------------
# Helper: extract time of day from session ID
# ---------------------------------------------------------------------------

def extract_time_of_day(session_id: str) -> str:
    """Extract time category from session ID (format: YYYYMMDDHHmm)."""
    try:
        if len(session_id) >= 10:
            hour = int(session_id[8:10])
        else:
            return "unknown"
    except (ValueError, IndexError):
        return "unknown"

    if 6 <= hour < 9:
        return "rush_morning"
    elif 9 <= hour < 12:
        return "morning"
    elif 12 <= hour < 17:
        return "afternoon"
    elif 17 <= hour < 20:
        return "rush_evening"
    elif 20 <= hour < 23:
        return "evening"
    else:
        return "night"


# ---------------------------------------------------------------------------
# Plot 1: Multi-dimensional scatter
# ---------------------------------------------------------------------------

def plot_multidim_scatter(profiles: List[Dict], outdir: Path) -> None:
    """X=aggressiveness, Y=area score, Color=style, Size=duration."""
    import plotly.graph_objects as go

    area_score_map = {"unknown": -0.1, "downtown": 0.0, "freeway": 0.5, "tunnel": 1.0}
    style_colors = {"prudent": "#2E7D32", "smooth": "#1976D2", "aggressive": "#D32F2F"}

    aggr_scores = [p["features"].get("aggr_score", 0) for p in profiles]
    area_scores = [area_score_map.get(p["area_name"], 0.25) for p in profiles]
    durations = [p.get("duration_sec", 10) for p in profiles]

    # Normalize sizes (5-30 range)
    min_dur = min(durations) if durations else 1
    max_dur = max(durations) if durations else 10
    rng = max_dur - min_dur + 1e-6
    sizes = [5 + 25 * (d - min_dur) / rng for d in durations]

    time_cats = [extract_time_of_day(p["session_id"]) for p in profiles]

    fig = go.Figure()

    # Group by style
    styles = sorted(set(p["style"] for p in profiles),
                    key=lambda s: ["prudent", "smooth", "aggressive"].index(s)
                    if s in ["prudent", "smooth", "aggressive"] else 99)

    for style in styles:
        mask = [i for i, p in enumerate(profiles) if p["style"] == style]
        if not mask:
            continue

        fig.add_trace(go.Scatter(
            x=[aggr_scores[i] for i in mask],
            y=[area_scores[i] for i in mask],
            mode="markers",
            name=style.capitalize(),
            marker=dict(
                size=[sizes[i] for i in mask],
                color=style_colors.get(style, "#757575"),
                opacity=0.7,
                line=dict(width=1, color="white"),
            ),
            text=[profiles[i]["session_id"] for i in mask],
            customdata=[
                [profiles[i]["area_name"], durations[i], time_cats[i]]
                for i in mask
            ],
            hovertemplate=(
                "<b>%{text}</b><br>"
                f"Style: {style}<br>"
                "Area: %{customdata[0]}<br>"
                "Aggr score: %{x:.3f}<br>"
                "Duration: %{customdata[1]:.1f}s<br>"
                "Time: %{customdata[2]}"
                "<extra></extra>"
            ),
        ))

    fig.update_layout(
        title="Multi-Dimensional: Aggressiveness vs Area Context",
        xaxis=dict(
            title="Aggressiveness Score",
            gridcolor="lightgray",
        ),
        yaxis=dict(
            title="Area Context",
            gridcolor="lightgray",
            tickvals=[-0.1, 0.0, 0.5, 1.0],
            ticktext=["Unknown", "Downtown", "Freeway", "Tunnel"],
            range=[-0.2, 1.2],
        ),
        hovermode="closest",
        template="plotly_white",
        width=1200,
        height=800,
        legend=dict(title="Driving Style"),
    )

    fig.add_annotation(
        text=f"Point size = segment duration ({min_dur:.0f}s - {max_dur:.0f}s)",
        xref="paper", yref="paper", x=0.5, y=-0.08,
        showarrow=False, font=dict(size=12, color="gray"),
    )

    out = outdir / "multidim_scatter.html"
    fig.write_html(str(out))
    print(f"  [OK] {out.name}")


# ---------------------------------------------------------------------------
# Plot 2: Sunburst — Area -> Style -> Sessions
# ---------------------------------------------------------------------------

def plot_sunburst(profiles: List[Dict], outdir: Path) -> None:
    """Sunburst chart: Area -> Style -> individual sessions."""
    import plotly.graph_objects as go

    labels = ["All"]
    parents = [""]
    values = [len(profiles)]
    colors_list = ["#ECEFF1"]

    area_colors = {
        "unknown": "#9E9E9E",
        "downtown": "#42A5F5",
        "freeway": "#66BB6A",
        "tunnel": "#FFA726",
    }
    style_colors = {
        "prudent": "#81C784",
        "smooth": "#64B5F6",
        "aggressive": "#E57373",
    }

    # Level 1: Areas
    areas = sorted(set(p["area_name"] for p in profiles))
    for area in areas:
        area_segs = [p for p in profiles if p["area_name"] == area]
        labels.append(area.capitalize())
        parents.append("All")
        values.append(len(area_segs))
        colors_list.append(area_colors.get(area, "#BDBDBD"))

        # Level 2: Styles within area
        styles_in_area = sorted(set(p["style"] for p in area_segs))
        for style in styles_in_area:
            style_segs = [p for p in area_segs if p["style"] == style]
            label = f"{style.capitalize()} ({area})"
            labels.append(label)
            parents.append(area.capitalize())
            values.append(len(style_segs))
            colors_list.append(style_colors.get(style, "#BDBDBD"))

    fig = go.Figure(go.Sunburst(
        labels=labels,
        parents=parents,
        values=values,
        branchvalues="total",
        marker=dict(colors=colors_list),
        hovertemplate="<b>%{label}</b><br>Segments: %{value}<extra></extra>",
    ))

    fig.update_layout(
        title="Hierarchical View: Area -> Style",
        width=900,
        height=900,
    )

    out = outdir / "sunburst_area_style.html"
    fig.write_html(str(out))
    print(f"  [OK] {out.name}")


# ---------------------------------------------------------------------------
# Plot 3: Heatmap — Sessions x Areas, cell = style
# ---------------------------------------------------------------------------

def plot_heatmap_session_area(profiles: List[Dict], outdir: Path) -> None:
    """Heatmap: rows=sessions, cols=areas, cell=dominant style."""
    import plotly.graph_objects as go

    # Build session -> area -> style mapping
    session_area_style: Dict[str, Dict[str, str]] = defaultdict(dict)
    session_area_aggr: Dict[str, Dict[str, float]] = defaultdict(dict)

    for p in profiles:
        sid = p["session_id"]
        area = p["area_name"]
        session_area_style[sid][area] = p["style"]
        session_area_aggr[sid][area] = p["features"].get("aggr_score", 0)

    sessions = sorted(session_area_style.keys())
    areas = sorted(set(p["area_name"] for p in profiles))

    style_to_num = {"prudent": 0, "smooth": 1, "aggressive": 2}

    # Build matrix
    z = []
    hover_text = []
    for sid in sessions:
        row = []
        hover_row = []
        for area in areas:
            style = session_area_style[sid].get(area)
            if style:
                row.append(style_to_num.get(style, -1))
                aggr = session_area_aggr[sid].get(area, 0)
                hover_row.append(f"{sid}<br>Area: {area}<br>Style: {style}<br>Aggr: {aggr:.3f}")
            else:
                row.append(-1)
                hover_row.append(f"{sid}<br>Area: {area}<br>No data")
        z.append(row)
        hover_text.append(hover_row)

    # Custom colorscale: -1=gray, 0=green, 1=blue, 2=red
    colorscale = [
        [0.0, "#E0E0E0"],     # -1 → no data (gray)
        [0.33, "#E0E0E0"],
        [0.33, "#2E7D32"],    # 0 → prudent (green)
        [0.50, "#2E7D32"],
        [0.50, "#1976D2"],    # 1 → smooth (blue)
        [0.67, "#1976D2"],
        [0.67, "#D32F2F"],    # 2 → aggressive (red)
        [1.0, "#D32F2F"],
    ]

    fig = go.Figure(go.Heatmap(
        z=z,
        x=[a.capitalize() for a in areas],
        y=sessions,
        colorscale=colorscale,
        zmin=-1,
        zmax=2,
        text=hover_text,
        hovertemplate="%{text}<extra></extra>",
        colorbar=dict(
            title="Style",
            tickvals=[-0.5, 0.5, 1.5],
            ticktext=["Prudent", "Smooth", "Aggressive"],
        ),
    ))

    fig.update_layout(
        title="Driving Style per Session and Area",
        xaxis_title="Area",
        yaxis_title="Session ID",
        template="plotly_white",
        width=800,
        height=max(400, len(sessions) * 30 + 150),
    )

    out = outdir / "heatmap_session_area.html"
    fig.write_html(str(out))
    print(f"  [OK] {out.name}")


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def main():
    parser = argparse.ArgumentParser(
        description="Hierarchical multi-dimensional visualization for area-aware styles"
    )
    parser.add_argument("--results-dir", required=True, help="Dir with style_eaf results")
    parser.add_argument("--outdir", default=None, help="Output dir for plots (default: results-dir/plots)")
    args = parser.parse_args()

    results_dir = Path(args.results_dir)
    outdir = Path(args.outdir) if args.outdir else results_dir / "plots"
    outdir.mkdir(parents=True, exist_ok=True)

    print("=" * 70)
    print("HIERARCHICAL AREA-STYLE VISUALIZATION")
    print("=" * 70)
    print(f"Results dir: {results_dir}")
    print(f"Output dir:  {outdir}")
    print()

    profiles = load_profiles(results_dir)
    print(f"Loaded {len(profiles)} segment profiles\n")

    try:
        import plotly  # noqa: F401
    except ImportError:
        print("[ERROR] Plotly not installed. Install with: pip install plotly")
        sys.exit(1)

    print("--- Generating hierarchical plots ---")
    plot_multidim_scatter(profiles, outdir)
    plot_sunburst(profiles, outdir)
    plot_heatmap_session_area(profiles, outdir)

    print(f"\n[OK] All hierarchical plots saved to {outdir}/")


if __name__ == "__main__":
    main()
