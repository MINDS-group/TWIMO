#!/usr/bin/env python
"""
Example script to visualize driving styles in semantic space.

This script demonstrates:
1. Loading style clustering results
2. Reducing dimensionality (PCA/UMAP/t-SNE)
3. Creating interactive visualizations
4. Building a vector database for similarity search
5. Querying similar driving sessions
"""

# Add project root to Python path to import twimo without installation
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import argparse
import json
import numpy as np

from twimo.config import get_config
from twimo.visualization import (
    reduce_dimensions,
    create_interactive_plot,
    create_vector_database,
    query_similar_sessions,
    export_semantic_space,
    print_cluster_statistics,
)


def main():
    # Parse arguments
    parser = argparse.ArgumentParser(
        description='Visualize driving styles in semantic space'
    )
    parser.add_argument(
        '--config',
        type=Path,
        default=None,
        help='Path to config.yaml (default: project root)'
    )
    parser.add_argument(
        '--style-dir',
        type=Path,
        default=None,
        help='Directory with style clustering results (default: artifacts/style/proxy)'
    )
    parser.add_argument(
        '--outdir',
        type=Path,
        default=None,
        help='Output directory for visualizations (default: from config)'
    )
    parser.add_argument(
        '--reduction',
        type=str,
        default=None,
        help='Dimensionality reduction method: umap or tsne (default: from config)'
    )

    args = parser.parse_args()

    # Load configuration
    config = get_config(args.config)

    # Use config defaults if not specified
    style_dir = Path(args.style_dir) if args.style_dir else Path('./artifacts/style/proxy')
    viz_dir = Path(args.outdir) if args.outdir else config.get_output_dir('style_viz')
    reduction_method = args.reduction if args.reduction else config.get('visualization.reduction_method', 'umap')

    viz_dir.mkdir(exist_ok=True, parents=True)

    print("="*70)
    print("DRIVING STYLE SEMANTIC SPACE VISUALIZATION")
    print("="*70)

    # 1. Load style clustering results
    print("\n[1/6] Loading style clustering results...")

    profiles_file = style_dir / "style_profiles.jsonl"
    if not profiles_file.exists():
        print(f"[Error] Style profiles not found at: {profiles_file}")
        print("        Run 'python -m twimo.cli train-style' first!")
        return

    # Load profiles
    profiles = []
    with open(profiles_file) as f:
        for line in f:
            profiles.append(json.loads(line))

    print(f"  Loaded {len(profiles)} driving sessions")

    # Extract data
    session_ids = [p['session_id'] for p in profiles]
    clusters = np.array([p['cluster'] for p in profiles])
    features = [p['features'] for p in profiles]

    # Load cluster names
    centroids_file = style_dir / "style_centroids.json"
    with open(centroids_file) as f:
        centroids_data = json.load(f)
        cluster_names = centroids_data['name_map']

    # Convert cluster_names keys to int
    cluster_names = {int(k): v for k, v in cluster_names.items()}

    print(f"  Clusters: {sorted(set(clusters))}")
    print(f"  Styles: {list(cluster_names.values())}")

    # 2. Print cluster statistics
    print("\n[2/6] Computing cluster statistics...")
    print_cluster_statistics(clusters, cluster_names, features)

    # 3. Prepare feature matrix
    print("\n[3/6] Preparing feature matrix...")
    keys = sorted({k for f in features for k in f.keys()})
    X = np.array([[f.get(k, 0.0) for k in keys] for f in features], dtype=np.float32)
    print(f"  Feature matrix shape: {X.shape}")
    print(f"  Features: {', '.join(keys)}")

    # 4. Reduce dimensions
    print("\n[4/6] Reducing dimensions for visualization...")
    print(f"  Using method: {reduction_method}")

    # Primary reduction method from config
    print(f"\n  [4a] {reduction_method.upper()} (2D)...")
    X_reduced_2d = reduce_dimensions(X, method=reduction_method, n_components=2)

    print(f"\n  [4b] {reduction_method.upper()} (3D)...")
    X_reduced_3d = reduce_dimensions(X, method=reduction_method, n_components=3)

    print("\n  [4c] PCA (2D) for comparison...")
    X_pca_2d = reduce_dimensions(X, method="pca", n_components=2)

    # 5. Create interactive visualizations
    print("\n[5/6] Creating interactive visualizations...")

    # Primary method 2D
    create_interactive_plot(
        X_reduced_2d,
        clusters,
        cluster_names,
        session_ids,
        features,
        output_path=viz_dir / f"driving_styles_{reduction_method}_2d.html",
        title=f"Driving Styles - {reduction_method.upper()} 2D Projection",
    )

    # Primary method 3D
    create_interactive_plot(
        X_reduced_3d,
        clusters,
        cluster_names,
        session_ids,
        features,
        output_path=viz_dir / f"driving_styles_{reduction_method}_3d.html",
        title=f"Driving Styles - {reduction_method.upper()} 3D Projection",
    )

    # PCA 2D
    create_interactive_plot(
        X_pca_2d,
        clusters,
        cluster_names,
        session_ids,
        features,
        output_path=viz_dir / "driving_styles_pca_2d.html",
        title="Driving Styles - PCA 2D Projection",
    )

    # 6. Create vector database (Qdrant Docker)
    print("\n[6/6] Creating vector database for similarity search...")
    print("  Make sure Qdrant is running: cd qdrant && docker-compose up -d")

    create_vector_database(
        features,
        session_ids,
        clusters,
        cluster_names,
        qdrant_url="http://localhost:6333",
        collection_name="driving_styles",
    )

    # 7. Example: Find similar sessions
    print("\n[DEMO] Similarity search example...")

    if len(session_ids) > 0:
        query_session = session_ids[0]
        print(f"\n  Query session: {query_session}")

        similar = query_similar_sessions(
            query_session,
            n_results=5,
            collection_name="driving_styles",
            qdrant_url="http://localhost:6333",
        )

        print(f"\n  Top 5 most similar sessions:")
        print("  " + "-" * 60)

        for i, result in enumerate(similar[:5], 1):
            session_id = result['session_id']
            distance = result['distance']
            style = result['metadata']['style']
            aggr_score = result['metadata'].get('aggr_score', 0.0)

            print(f"  {i}. {session_id}")
            print(f"     Style: {style}")
            print(f"     Aggressiveness: {aggr_score:.2f}")
            print(f"     Distance: {distance:.4f}")
            print()

    # 8. Export for external tools
    print("\n[EXPORT] Exporting semantic space data...")

    export_semantic_space(
        X_reduced_2d,
        clusters,
        cluster_names,
        session_ids,
        features,
        output_path=viz_dir / f"semantic_space_{reduction_method}_2d.json",
    )

    export_semantic_space(
        X_reduced_3d,
        clusters,
        cluster_names,
        session_ids,
        features,
        output_path=viz_dir / f"semantic_space_{reduction_method}_3d.json",
    )

    # Summary
    print("\n" + "="*70)
    print("VISUALIZATION COMPLETE!")
    print("="*70)
    print(f"\n[Interactive Visualizations]")
    print(f"   - {reduction_method.upper()} 2D: {viz_dir / f'driving_styles_{reduction_method}_2d.html'}")
    print(f"   - {reduction_method.upper()} 3D: {viz_dir / f'driving_styles_{reduction_method}_3d.html'}")
    print(f"   - PCA 2D:  {viz_dir / 'driving_styles_pca_2d.html'}")
    print(f"\n[Vector Database (Qdrant)]")
    print(f"   - URL: http://localhost:6333")
    print(f"   - Dashboard: http://localhost:6333/dashboard")
    print(f"   - Collection: driving_styles")
    print(f"   - Documents: {len(session_ids)}")
    print(f"\n[Exported Data]")
    print(f"   - {reduction_method.upper()} 2D JSON: {viz_dir / f'semantic_space_{reduction_method}_2d.json'}")
    print(f"   - {reduction_method.upper()} 3D JSON: {viz_dir / f'semantic_space_{reduction_method}_3d.json'}")
    print(f"\n[Next Steps]")
    print(f"   1. Open the HTML files in your browser for interactive exploration")
    print(f"   2. Use the vector database for similarity search")
    print(f"   3. Export to your preferred visualization tool (e.g., Embedding Projector)")
    print()


if __name__ == "__main__":
    main()
