"""Multi-dimensional visualization for hierarchical clustering results.

This module creates rich visualizations combining:
- X-axis: Driving style (prudent → aggressive)
- Y-axis: Context (city → highway)
- Color: Time of day
- Size: Session duration
"""

from __future__ import annotations

from pathlib import Path
from typing import Dict, List, Optional
from datetime import datetime

import json
import numpy as np
import pandas as pd


def extract_time_of_day(timestamp_str: str) -> str:
    """Extract time of day category from session timestamp.

    Args:
        timestamp_str: Session ID timestamp (e.g., "201702271017")

    Returns:
        Time category: 'night', 'morning', 'afternoon', 'evening', 'rush_morning', 'rush_evening'
    """
    # Extract hour from timestamp (format: YYYYMMDDHHmm)
    try:
        if len(timestamp_str) >= 10:
            hour = int(timestamp_str[8:10])
        else:
            return 'unknown'
    except (ValueError, IndexError):
        return 'unknown'

    # Categorize
    if 6 <= hour < 9:
        return 'rush_morning'
    elif 9 <= hour < 12:
        return 'morning'
    elif 12 <= hour < 17:
        return 'afternoon'
    elif 17 <= hour < 20:
        return 'rush_evening'
    elif 20 <= hour < 23:
        return 'evening'
    else:
        return 'night'


def compute_session_duration(csv_path: Path) -> float:
    """Compute session duration in minutes.

    Args:
        csv_path: Path to session CSV

    Returns:
        Duration in minutes
    """
    try:
        df = pd.read_csv(csv_path)
        if 'timestamp' in df.columns and len(df) > 0:
            duration_ms = df['timestamp'].iloc[-1] - df['timestamp'].iloc[0]
            duration_min = duration_ms / 60000.0  # Convert to minutes
            return max(duration_min, 0.1)  # Minimum 0.1 minute
        return 1.0  # Default
    except Exception:
        return 1.0  # Default


def create_hierarchical_multidim_plot(
    hierarchical_results: Dict,
    session_ids: List[str],
    features_list: List[Dict[str, float]],
    context_labels: List[str],
    manifest_data: Optional[List[Dict]] = None,
    output_path: Optional[Path] = None,
    title: str = "Multi-Dimensional Driving Behavior Analysis",
) -> None:
    """Create multi-dimensional scatter plot for hierarchical clustering.

    Visualizes:
    - X-axis: Aggressiveness score (prudent → aggressive)
    - Y-axis: Context score (city → highway)
    - Color: Time of day
    - Size: Session duration

    Args:
        hierarchical_results: Results from hierarchical_clustering
        session_ids: List of session IDs
        features_list: List of feature dictionaries
        context_labels: List of context labels (city/highway/suburban)
        manifest_data: Optional manifest data for session metadata
        output_path: Path to save HTML file
        title: Plot title
    """
    try:
        import plotly.graph_objects as go
    except ImportError:
        print("[Error] Plotly not installed. Install with: pip install plotly")
        return

    # Prepare data
    n_sessions = len(session_ids)

    # X-axis: Aggressiveness score (from features)
    aggressiveness_scores = []
    for features in features_list:
        # Combine acceleration and braking aggressiveness
        aggr = features.get('accel_p95', 0) + features.get('brake_p95', 0)
        aggressiveness_scores.append(aggr)

    # Y-axis: Context score (city=0, suburban=0.5, highway=1)
    context_scores = []
    context_map = {'city': 0, 'suburban': 0.5, 'highway': 1}
    for context in context_labels:
        context_scores.append(context_map.get(context, 0.5))

    # Color: Time of day
    time_categories = []
    for session_id in session_ids:
        time_cat = extract_time_of_day(session_id)
        time_categories.append(time_cat)

    # Size: Session duration
    durations = []
    if manifest_data:
        # Create a mapping of session_id to manifest entry
        sess_map = {s['session_id']: s for s in manifest_data}

        for session_id in session_ids:
            if session_id in sess_map:
                sess = sess_map[session_id]

                # Get CSV path
                if 'csv_path' in sess:
                    csv_path = Path(sess['csv_path'])
                elif 'csv_dir' in sess:
                    csv_dir = Path(sess['csv_dir'])
                    csv_files = list(csv_dir.glob('*.csv'))
                    if csv_files:
                        csv_path = csv_files[0]
                    else:
                        durations.append(10.0)
                        continue
                else:
                    durations.append(10.0)
                    continue

                duration = compute_session_duration(csv_path)
                durations.append(duration)
            else:
                durations.append(10.0)
    else:
        # Default durations
        durations = [10.0] * n_sessions

    # Normalize sizes for visualization (5-30 range)
    min_dur = min(durations) if durations else 1
    max_dur = max(durations) if durations else 10
    normalized_sizes = [5 + 25 * (d - min_dur) / (max_dur - min_dur + 1e-6) for d in durations]

    # Get hierarchical cluster names
    # JSON converts dict keys to strings, so we need to convert cluster IDs to strings
    level1_names = [
        hierarchical_results['level1']['cluster_names'][str(c)]
        for c in hierarchical_results['level1']['clusters']
    ]
    level2_names = [
        hierarchical_results['level2']['cluster_names'][str(c)]
        for c in hierarchical_results['level2']['clusters']
    ]

    # Create dataframe
    df = pd.DataFrame({
        'session_id': session_ids,
        'aggressiveness': aggressiveness_scores,
        'context_score': context_scores,
        'context': context_labels,
        'time_of_day': time_categories,
        'duration_min': durations,
        'size': normalized_sizes,
        'level1_cluster': level1_names,
        'level2_cluster': level2_names,
    })

    # Color mapping for time of day
    time_color_map = {
        'night': '#2C3E50',          # Dark blue
        'rush_morning': '#E74C3C',   # Red
        'morning': '#F39C12',        # Orange
        'afternoon': '#F1C40F',      # Yellow
        'rush_evening': '#E67E22',   # Dark orange
        'evening': '#9B59B6',        # Purple
        'unknown': '#95A5A6',        # Gray
    }

    # Create figure
    fig = go.Figure()

    # Add traces for each time category
    for time_cat in df['time_of_day'].unique():
        mask = df['time_of_day'] == time_cat
        subset = df[mask]

        fig.add_trace(go.Scatter(
            x=subset['aggressiveness'],
            y=subset['context_score'],
            mode='markers',
            name=time_cat.replace('_', ' ').title(),
            marker=dict(
                size=subset['size'],
                color=time_color_map.get(time_cat, '#95A5A6'),
                opacity=0.7,
                line=dict(width=1, color='white'),
            ),
            text=subset['session_id'],
            customdata=np.column_stack((
                subset['level1_cluster'],
                subset['level2_cluster'],
                subset['context'],
                subset['duration_min'],
            )),
            hovertemplate=(
                '<b>%{text}</b><br>' +
                'Aggressiveness: %{x:.2f}<br>' +
                'Context: %{customdata[2]}<br>' +
                'Style: %{customdata[0]}<br>' +
                'Cluster: %{customdata[1]}<br>' +
                'Time: ' + time_cat.replace('_', ' ').title() + '<br>' +
                'Duration: %{customdata[3]:.1f} min<br>' +
                '<extra></extra>'
            ),
        ))

    # Update layout
    fig.update_layout(
        title=dict(
            text=title,
            font=dict(size=18),
        ),
        xaxis=dict(
            title='Aggressiveness Score (Accel + Brake)',
            gridcolor='lightgray',
            range=[min(aggressiveness_scores) - 0.5, max(aggressiveness_scores) + 0.5],
        ),
        yaxis=dict(
            title='Context (City ← → Highway)',
            gridcolor='lightgray',
            tickvals=[0, 0.5, 1],
            ticktext=['City', 'Suburban', 'Highway'],
            range=[-0.1, 1.1],
        ),
        hovermode='closest',
        template='plotly_white',
        width=1200,
        height=800,
        legend=dict(
            title='Time of Day',
            yanchor='top',
            y=0.99,
            xanchor='left',
            x=0.01,
        ),
    )

    # Add annotations
    fig.add_annotation(
        text=f"Point size represents session duration ({min_dur:.1f} - {max_dur:.1f} min)",
        xref="paper", yref="paper",
        x=0.5, y=-0.1,
        showarrow=False,
        font=dict(size=12, color='gray'),
    )

    # Save or show
    if output_path:
        fig.write_html(str(output_path))
        print(f"[Plotly] Multi-dimensional plot saved to: {output_path}")
    else:
        fig.show()


def create_hierarchical_sunburst(
    hierarchical_results: Dict,
    session_ids: List[str],
    output_path: Optional[Path] = None,
    title: str = "Hierarchical Clustering Sunburst",
) -> None:
    """Create sunburst chart showing hierarchical clustering structure.

    Args:
        hierarchical_results: Results from hierarchical_clustering
        session_ids: List of session IDs
        output_path: Path to save HTML file
        title: Plot title
    """
    try:
        import plotly.graph_objects as go
    except ImportError:
        print("[Error] Plotly not installed. Install with: pip install plotly")
        return

    # Build hierarchical data
    labels = ['All Sessions']
    parents = ['']
    values = [len(session_ids)]

    # Level 1: Styles
    level1_clusters = hierarchical_results['level1']['clusters']
    level1_names = hierarchical_results['level1']['cluster_names']

    for cluster_id in sorted(set(level1_clusters)):
        count = sum(1 for c in level1_clusters if c == cluster_id)
        name = level1_names[str(cluster_id)]  # Convert to string for JSON keys

        labels.append(name)
        parents.append('All Sessions')
        values.append(count)

    # Level 2: Contexts within styles
    level2_clusters = hierarchical_results['level2']['clusters']
    level2_names = hierarchical_results['level2']['cluster_names']

    for cluster_id in sorted(set(level2_clusters)):
        count = sum(1 for c in level2_clusters if c == cluster_id)
        name = level2_names[str(cluster_id)]  # Convert to string for JSON keys

        # Find parent (level 1)
        # Get sessions in this L2 cluster
        l2_indices = [i for i, c in enumerate(level2_clusters) if c == cluster_id]
        if l2_indices:
            # Get L1 cluster for first session in this L2 cluster
            parent_l1_cluster = level1_clusters[l2_indices[0]]
            parent_name = level1_names[str(parent_l1_cluster)]  # Convert to string for JSON keys

            labels.append(name)
            parents.append(parent_name)
            values.append(count)

    # Create sunburst
    fig = go.Figure(go.Sunburst(
        labels=labels,
        parents=parents,
        values=values,
        branchvalues='total',
        marker=dict(
            colorscale='RdYlGn_r',
            cmid=1,
        ),
        hovertemplate='<b>%{label}</b><br>Sessions: %{value}<br><extra></extra>',
    ))

    fig.update_layout(
        title=title,
        width=900,
        height=900,
    )

    # Save or show
    if output_path:
        fig.write_html(str(output_path))
        print(f"[Plotly] Sunburst chart saved to: {output_path}")
    else:
        fig.show()


def create_temporal_heatmap(
    temporal_results: Dict,
    session_ids: List[str],
    output_path: Optional[Path] = None,
    title: str = "Temporal Behavior Heatmap",
) -> None:
    """Create heatmap showing temporal cluster evolution across sessions.

    Args:
        temporal_results: Results from temporal segmentation
        session_ids: List of session IDs
        output_path: Path to save HTML file
        title: Plot title
    """
    try:
        import plotly.graph_objects as go
    except ImportError:
        print("[Error] Plotly not installed. Install with: pip install plotly")
        return

    # Extract temporal data
    session_transitions = temporal_results['session_transitions']

    # Find max windows across sessions
    max_windows = max(data['n_windows'] for data in session_transitions.values())

    # Create matrix: rows = sessions, cols = time windows, values = cluster
    n_sessions = len(session_ids)
    matrix = np.full((n_sessions, max_windows), -1, dtype=int)

    for i, session_id in enumerate(session_ids):
        if session_id in session_transitions:
            trans_data = session_transitions[session_id]
            # Get cluster sequence (as cluster IDs)
            # We need to map cluster names back to IDs
            cluster_seq = trans_data.get('cluster_sequence', [])

            for j, cluster_name in enumerate(cluster_seq):
                if j < max_windows:
                    # Extract cluster ID from name (simplified)
                    # For now, just use index as proxy
                    matrix[i, j] = hash(cluster_name) % 10  # Simple hash to color

    # Create heatmap
    fig = go.Figure(data=go.Heatmap(
        z=matrix,
        x=[f'Window {i}' for i in range(max_windows)],
        y=session_ids,
        colorscale='Viridis',
        hovertemplate='Session: %{y}<br>Window: %{x}<br>Cluster: %{z}<extra></extra>',
    ))

    fig.update_layout(
        title=title,
        xaxis_title='Time Window',
        yaxis_title='Session ID',
        width=1400,
        height=800,
    )

    # Save or show
    if output_path:
        fig.write_html(str(output_path))
        print(f"[Plotly] Temporal heatmap saved to: {output_path}")
    else:
        fig.show()
