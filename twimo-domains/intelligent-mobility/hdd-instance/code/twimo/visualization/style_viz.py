from __future__ import annotations

import json
from pathlib import Path
from typing import Dict, List, Optional, Tuple

import numpy as np
import pandas as pd


def reduce_dimensions(
    X: np.ndarray,
    method: str = "umap",
    n_components: int = 2,
    random_state: int = 42,
) -> np.ndarray:
    """Reduce dimensionality of feature vectors for visualization.

    Args:
        X: Feature matrix (N, D)
        method: "pca", "tsne", or "umap"
        n_components: Target dimensions (2 or 3)
        random_state: Random seed for reproducibility

    Returns:
        Reduced feature matrix (N, n_components)
    """
    if method == "pca":
        from sklearn.decomposition import PCA
        model = PCA(n_components=n_components, random_state=random_state)
        X_reduced = model.fit_transform(X)
        print(f"[PCA] Explained variance: {model.explained_variance_ratio_.sum():.2%}")

    elif method == "tsne":
        from sklearn.manifold import TSNE
        model = TSNE(
            n_components=n_components,
            random_state=random_state,
            perplexity=min(30, X.shape[0] - 1),
            n_iter=1000,
        )
        X_reduced = model.fit_transform(X)
        print(f"[t-SNE] Completed with {n_components}D projection")

    elif method == "umap":
        try:
            import umap
            model = umap.UMAP(
                n_components=n_components,
                random_state=random_state,
                n_neighbors=min(15, X.shape[0] - 1),
                min_dist=0.1,
            )
            X_reduced = model.fit_transform(X)
            print(f"[UMAP] Completed with {n_components}D projection")
        except ImportError:
            print("[Warning] UMAP not installed. Install with: pip install umap-learn")
            print("          Falling back to PCA...")
            return reduce_dimensions(X, method="pca", n_components=n_components, random_state=random_state)

    else:
        raise ValueError(f"Unknown method: {method}. Use 'pca', 'tsne', or 'umap'")

    return X_reduced


def create_interactive_plot(
    X_reduced: np.ndarray,
    clusters: np.ndarray,
    cluster_names: Dict[int, str],
    session_ids: List[str],
    features: Optional[List[Dict[str, float]]] = None,
    output_path: Optional[Path] = None,
    title: str = "Driving Style Clustering - Semantic Space",
) -> None:
    """Create interactive 2D/3D scatter plot with Plotly.

    Args:
        X_reduced: Reduced coordinates (N, 2) or (N, 3)
        clusters: Cluster assignments (N,)
        cluster_names: Mapping cluster_id -> name
        session_ids: Session IDs for hover info
        features: Optional feature dictionaries for hover details
        output_path: Path to save HTML file
        title: Plot title
    """
    try:
        import plotly.graph_objects as go
        import plotly.express as px
    except ImportError:
        print("[Error] Plotly not installed. Install with: pip install plotly")
        return

    # Prepare data
    df = pd.DataFrame()

    if X_reduced.shape[1] == 2:
        df['x'] = X_reduced[:, 0]
        df['y'] = X_reduced[:, 1]
    elif X_reduced.shape[1] == 3:
        df['x'] = X_reduced[:, 0]
        df['y'] = X_reduced[:, 1]
        df['z'] = X_reduced[:, 2]

    df['cluster'] = clusters
    df['style'] = [cluster_names.get(c, f"cluster_{c}") for c in clusters]
    df['session_id'] = session_ids

    # Add feature info to hover
    if features:
        for key in ['aggr_score', 'accel_p95', 'brake_p95', 'vel_p95']:
            if key in features[0]:
                df[key] = [f.get(key, 0.0) for f in features]

    # Color mapping
    color_map = {
        'prudent': '#2E7D32',      # Green
        'smooth': '#1976D2',       # Blue
        'aggressive': '#D32F2F',   # Red
        'normal': '#FFA726',       # Orange
    }

    colors = [color_map.get(style, '#757575') for style in df['style']]

    # Create figure
    if X_reduced.shape[1] == 2:
        fig = go.Figure()

        for style in df['style'].unique():
            mask = df['style'] == style
            fig.add_trace(go.Scatter(
                x=df[mask]['x'],
                y=df[mask]['y'],
                mode='markers',
                name=style,
                marker=dict(
                    size=10,
                    color=color_map.get(style, '#757575'),
                    opacity=0.7,
                    line=dict(width=1, color='white'),
                ),
                text=df[mask]['session_id'],
                hovertemplate=(
                    '<b>%{text}</b><br>' +
                    'Style: ' + style + '<br>' +
                    'X: %{x:.2f}<br>' +
                    'Y: %{y:.2f}<br>' +
                    '<extra></extra>'
                ),
            ))

        fig.update_layout(
            title=title,
            xaxis_title='Dimension 1',
            yaxis_title='Dimension 2',
            hovermode='closest',
            template='plotly_white',
            width=1000,
            height=700,
        )

    elif X_reduced.shape[1] == 3:
        fig = go.Figure()

        for style in df['style'].unique():
            mask = df['style'] == style
            fig.add_trace(go.Scatter3d(
                x=df[mask]['x'],
                y=df[mask]['y'],
                z=df[mask]['z'],
                mode='markers',
                name=style,
                marker=dict(
                    size=6,
                    color=color_map.get(style, '#757575'),
                    opacity=0.7,
                    line=dict(width=0.5, color='white'),
                ),
                text=df[mask]['session_id'],
                hovertemplate=(
                    '<b>%{text}</b><br>' +
                    'Style: ' + style + '<br>' +
                    'X: %{x:.2f}<br>' +
                    'Y: %{y:.2f}<br>' +
                    'Z: %{z:.2f}<br>' +
                    '<extra></extra>'
                ),
            ))

        fig.update_layout(
            title=title,
            scene=dict(
                xaxis_title='Dimension 1',
                yaxis_title='Dimension 2',
                zaxis_title='Dimension 3',
            ),
            hovermode='closest',
            template='plotly_white',
            width=1000,
            height=800,
        )

    # Save or show
    if output_path:
        fig.write_html(str(output_path))
        print(f"[Plotly] Interactive plot saved to: {output_path}")
    else:
        fig.show()


def create_vector_database(
    features: List[Dict[str, float]],
    session_ids: List[str],
    clusters: np.ndarray,
    cluster_names: Dict[int, str],
    db_path: Optional[Path] = None,
    qdrant_url: str = "http://localhost:6333",
    collection_name: str = "driving_styles",
) -> None:
    """Create Qdrant vector database for similarity search.

    Args:
        features: List of feature dictionaries
        session_ids: Session IDs
        clusters: Cluster assignments
        cluster_names: Cluster name mapping
        db_path: Path to database directory (for local file-based storage, deprecated)
        qdrant_url: Qdrant server URL (default: http://localhost:6333 for Docker)
        collection_name: Collection name
    """
    try:
        from qdrant_client import QdrantClient
        from qdrant_client.models import Distance, VectorParams, PointStruct
    except ImportError:
        print("[Error] Qdrant not installed. Install with: pip install qdrant-client")
        return

    # Initialize Qdrant client (connect to Docker instance)
    if db_path is not None:
        # Legacy: local file-based storage
        print(f"[Qdrant] Using local file-based storage at: {db_path}")
        client = QdrantClient(path=str(db_path))
    else:
        # Recommended: connect to Docker instance
        print(f"[Qdrant] Connecting to Qdrant server at: {qdrant_url}")
        try:
            client = QdrantClient(url=qdrant_url)
        except Exception as e:
            print(f"[Error] Could not connect to Qdrant at {qdrant_url}")
            print(f"        Make sure Qdrant is running: cd qdrant && docker-compose up -d")
            print(f"        Error: {e}")
            return

    # Prepare data
    keys = sorted({k for f in features for k in f.keys()})
    vector_size = len(keys)
    embeddings = [[f.get(k, 0.0) for k in keys] for f in features]

    # Delete existing collection if exists
    try:
        client.delete_collection(collection_name=collection_name)
    except:
        pass

    # Create collection
    client.create_collection(
        collection_name=collection_name,
        vectors_config=VectorParams(size=vector_size, distance=Distance.COSINE),
    )

    # Prepare points with metadata
    points = []
    for i in range(len(session_ids)):
        payload = {
            "session_id": session_ids[i],
            "cluster": int(clusters[i]),
            "style": cluster_names.get(int(clusters[i]), f"cluster_{clusters[i]}"),
            **{k: float(v) for k, v in features[i].items()}
        }

        point = PointStruct(
            id=i,
            vector=embeddings[i],
            payload=payload,
        )
        points.append(point)

    # Upload points in batch
    client.upsert(
        collection_name=collection_name,
        points=points,
    )

    if db_path is not None:
        print(f"[Qdrant] Vector database created at: {db_path}")
    else:
        print(f"[Qdrant] Vector database created at: {qdrant_url}")
    print(f"         Collection: {collection_name}")
    print(f"         Documents: {len(session_ids)}")
    print(f"         Dimensions: {len(keys)}")


def query_similar_sessions(
    query_session_id: str,
    n_results: int = 10,
    collection_name: str = "driving_styles",
    db_path: Optional[Path] = None,
    qdrant_url: str = "http://localhost:6333",
) -> List[Dict]:
    """Find similar driving sessions using vector similarity.

    Args:
        query_session_id: Session to find similar sessions for
        n_results: Number of similar sessions to return
        collection_name: Collection name
        db_path: Path to Qdrant database (for local file-based storage, deprecated)
        qdrant_url: Qdrant server URL (default: http://localhost:6333 for Docker)

    Returns:
        List of similar sessions with metadata and scores
    """
    try:
        from qdrant_client import QdrantClient
        from qdrant_client.models import Filter, FieldCondition, MatchValue
    except ImportError:
        print("[Error] Qdrant not installed. Install with: pip install qdrant-client")
        return []

    # Initialize Qdrant client
    if db_path is not None:
        client = QdrantClient(path=str(db_path))
    else:
        try:
            client = QdrantClient(url=qdrant_url)
        except Exception as e:
            print(f"[Error] Could not connect to Qdrant at {qdrant_url}")
            print(f"        Error: {e}")
            return []

    # Get the query session's vector
    search_result = client.scroll(
        collection_name=collection_name,
        scroll_filter=Filter(
            must=[
                FieldCondition(
                    key="session_id",
                    match=MatchValue(value=query_session_id),
                )
            ]
        ),
        limit=1,
    )

    if not search_result[0]:
        print(f"[Error] Session {query_session_id} not found in database")
        return []

    query_vector = search_result[0][0].vector

    # Search for similar sessions
    results = client.query_points(
        collection_name=collection_name,
        query=query_vector,
        limit=n_results,
        with_payload=True,
    ).points

    # Format results
    similar_sessions = []
    for result in results:
        similar_sessions.append({
            'session_id': result.payload['session_id'],
            'score': result.score,  # Cosine similarity score (higher = more similar)
            'distance': 1 - result.score,  # Convert to distance
            'metadata': result.payload,
        })

    return similar_sessions


def export_semantic_space(
    X_reduced: np.ndarray,
    clusters: np.ndarray,
    cluster_names: Dict[int, str],
    session_ids: List[str],
    features: List[Dict[str, float]],
    output_path: Path,
) -> None:
    """Export semantic space data to JSON for external visualization.

    Args:
        X_reduced: Reduced coordinates
        clusters: Cluster assignments
        cluster_names: Cluster names
        session_ids: Session IDs
        features: Feature dictionaries
        output_path: Output JSON path
    """
    data = {
        'metadata': {
            'n_sessions': len(session_ids),
            'n_dimensions': X_reduced.shape[1],
            'n_clusters': len(set(clusters)),
            'cluster_names': cluster_names,
        },
        'sessions': []
    }

    for i in range(len(session_ids)):
        session_data = {
            'session_id': session_ids[i],
            'cluster': int(clusters[i]),
            'style': cluster_names.get(int(clusters[i]), f"cluster_{clusters[i]}"),
            'coordinates': X_reduced[i].tolist(),
            'features': features[i],
        }
        data['sessions'].append(session_data)

    with open(output_path, 'w') as f:
        json.dump(data, f, indent=2)

    print(f"[Export] Semantic space data saved to: {output_path}")


def print_cluster_statistics(
    clusters: np.ndarray,
    cluster_names: Dict[int, str],
    features: List[Dict[str, float]],
) -> None:
    """Print statistics for each cluster.

    Args:
        clusters: Cluster assignments
        cluster_names: Cluster names
        features: Feature dictionaries
    """
    print("\n" + "="*60)
    print("CLUSTER STATISTICS")
    print("="*60)

    for cluster_id in sorted(set(clusters)):
        mask = clusters == cluster_id
        cluster_features = [f for i, f in enumerate(features) if mask[i]]

        style_name = cluster_names.get(cluster_id, f"cluster_{cluster_id}")
        count = int(mask.sum())

        print(f"\n{style_name.upper()} (Cluster {cluster_id}) - {count} sessions")
        print("-" * 60)

        # Calculate statistics for key features
        for key in ['aggr_score', 'accel_p95', 'brake_p95', 'steer_std', 'vel_p95']:
            values = [f.get(key, 0.0) for f in cluster_features if key in f]
            if values:
                mean = np.mean(values)
                std = np.std(values)
                print(f"  {key:20s}: {mean:6.2f} ± {std:6.2f}")

    print("\n" + "="*60)
