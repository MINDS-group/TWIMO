# Visualization

This folder creates interactive visualizations and enables similarity search for driving sessions.

---

## What Does This Do?

Generates interactive HTML plots, 4D scatter plots, hierarchical charts, and vector database for session similarity search.

---

## Key Files

| File | What It Does |
|------|-------------|
| `style_viz.py` | Semantic space visualization + Qdrant vector search |
| `hierarchical_viz.py` | 4D plots, sunburst charts, temporal heatmaps |

---

## Semantic Space Visualization

### What Is It?

Projects high-dimensional driving sessions into 2D/3D space for visualization.

**Input:** 40+ features per session (velocity, accel, brake, etc.)
**Output:** 2D/3D coordinates where similar sessions are close together

### How to Use

```bash
# Start Qdrant vector database (requires Docker)
cd qdrant && docker-compose up -d

# Generate visualizations
python workflows/visualize_driving_styles.py
```

**Outputs:**
- `driving_styles_umap_2d.html`: Interactive 2D plot
- `driving_styles_umap_3d.html`: Interactive 3D plot
- `driving_styles_pca_2d.html`: PCA comparison plot

**Open in browser:** Double-click HTML files

---

## Understanding the Plots

### UMAP 2D Plot

```
       Y (Dim 2)
         ↑
    🔴🔴🔴│           🟢🟢🟢
    🔴🔴🔴│        🟢🟢🟢
         │     🔵🔵
    ─────┼──────────────→ X (Dim 1)
         │  🟠🟠🟠
         │ 🟠🟠🟠
```

**Colors:**
- 🟢 Green → Prudent (safe, slow)
- 🔵 Blue → Smooth (balanced)
- 🔴 Red → Aggressive (fast, dynamic)
- 🟠 Orange → Normal (moderate)

**What axes mean:**
- **NOT** literal features (velocity, steering)
- **Latent dimensions** that capture overall similarity
- **Close points** = similar driving styles

### Hover Information

Hover over any point to see:
```
Session: 201702271017
Style: aggressive
X: 2.45, Y: -1.32
Aggr_score: 7.8
Vel_p95: 65.3 km/h
Accel_p95: 0.85 m/s²
```

---

## Dimensionality Reduction Methods

### UMAP (Recommended)

**Best for:** Visualizing clusters, preserving global + local structure

**Pros:**
- ⭐⭐⭐⭐ Excellent cluster separation
- Preserves both local and global relationships
- Fast

**Cons:**
- Less interpretable axes
- Nondeterministic (slight variations between runs)

### PCA

**Best for:** Understanding feature variance

**Pros:**
- ⭐⭐⭐⭐ Interpretable axes (linear combinations of features)
- Shows variance explained (e.g., PC1=45%, PC2=25%)
- Deterministic

**Cons:**
- Weaker cluster separation
- Linear method (misses nonlinear patterns)

### t-SNE

**Best for:** (Not recommended - use UMAP instead)

**Pros:**
- Good local structure

**Cons:**
- Very slow
- Loses global structure
- Unreliable distances between clusters

---

## Vector Similarity Search (Qdrant)

### What Is It?

A database that finds similar driving sessions based on feature vectors.

### Setup

```bash
# Start Qdrant (Docker required)
cd qdrant
docker-compose up -d

# Check dashboard
open http://localhost:6333/dashboard
```

### How to Use

```python
from twimo.visualization.style_viz import query_similar_sessions

# Find sessions similar to 201702271017
similar = query_similar_sessions(
    query_session_id='201702271017',
    n_results=5,
    qdrant_url='http://localhost:6333'
)

# Returns:
# [
#   {'session_id': '201702281115', 'score': 0.95, 'style': 'aggressive'},
#   {'session_id': '201703011420', 'score': 0.89, 'style': 'aggressive'},
#   ...
# ]
```

**Use cases:**
- Find similar driving patterns
- Build recommendation systems
- Cluster validation

---

## Hierarchical Visualization

### 4D Scatter Plot

Shows 4 dimensions at once:
- **X-axis:** Velocity
- **Y-axis:** Acceleration
- **Z-axis:** Steering
- **Color:** Driving style

```bash
python workflows/visualize_hierarchical_clustering.py
```

**Output:** `hierarchical_4d_plot.html`

### Sunburst Chart

Shows hierarchical cluster structure:

```
        ┌─ Prudent City
    Prudent ─┼─ Prudent Suburban
        └─ Prudent Highway

        ┌─ Smooth City
    Smooth ─┼─ Smooth Suburban
        └─ Smooth Highway

        ┌─ Aggressive City
    Aggressive ─┼─ Aggressive Suburban
        └─ Aggressive Highway
```

**Output:** `hierarchical_sunburst.html`

### Temporal Heatmap

Shows behavior changes over time:

```
Time (minutes) →
Session 1: [smooth smooth smooth aggressive smooth smooth]
Session 2: [prudent prudent smooth smooth smooth smooth]
Session 3: [aggressive aggressive aggressive smooth smooth smooth]
```

**Output:** `temporal_heatmap.html`

---

## Customization

### Change Colors

Edit `style_viz.py`:

```python
color_map = {
    'prudent': '#2E7D32',      # Green
    'smooth': '#1976D2',       # Blue
    'aggressive': '#D32F2F',   # Red
    'normal': '#FFA726',       # Orange
}
```

### Change Clustering Method

Edit config.yaml:

```yaml
visualization:
  reduction_method: 'umap'  # 'umap', 'tsne', or 'pca'
  n_components: 2  # 2D or 3D
```

### Export for External Tools

```bash
python workflows/visualize_driving_styles.py
```

**Outputs JSON:**
- `semantic_space_umap_2d.json`
- `semantic_space_umap_3d.json`

**Import in:**
- Embedding Projector (TensorFlow)
- Plotly Dash
- Custom web apps

---

## Troubleshooting

### Qdrant connection refused

```bash
# Start Qdrant
cd qdrant && docker-compose up -d

# Check status
docker ps | grep qdrant

# Access dashboard
open http://localhost:6333/dashboard
```

### Plots don't show clusters

- **Try UMAP instead of PCA:** `--reduction umap`
- **Increase cluster count:** Edit `config.yaml` `level1_clusters: 5`
- **Normalize features:** Features should be standardized

### Colors overlap

- **Reduce opacity:** Edit `style_viz.py` `opacity=0.5`
- **Use 3D plot:** Better separation in 3D

---

## Related Files

- Analysis: `twimo/analysis/`
- Examples: `workflows/visualize_driving_styles.py`, `workflows/visualize_hierarchical_clustering.py`
- Qdrant setup: `qdrant/docker-compose.yml`
