# TWIMO Workflows - End-to-End Pipelines

Complete, ready-to-run workflows demonstrating TWIMO's Digital Twin Engineering capabilities.

---

## What Are Workflows?

These are **end-to-end pipeline scripts** that combine multiple TWIMO modules to accomplish complete tasks. Each workflow implements a specific phase of the **DTE (Digital Twin Engineering) lifecycle**:

```
Design → Build → Validate → Evolve
```

Unlike the CLI (`python -m twimo.cli`), workflows provide:
- ✅ More control and customization
- ✅ Transparent pipeline steps
- ✅ Example code for integration

---

## Quick Reference

### Data Preparation

| Workflow | Purpose | Modules Used | Time |
|----------|---------|--------------|------|
| [`build_manifest.py`](#1-build-manifest) | Scan dataset and create session registry | [data/](../twimo/data/) | ~10s |
| [`split_manifest.py`](#2-split-manifest) | Split manifest into train/test sets | [data/](../twimo/data/) | ~1s |

### Model Training

| Workflow | Purpose | Modules Used | Time |
|----------|---------|--------------|------|
| [`train_control_regression.py`](#3-train-control-regression) | Train direct control regressor (steering + speed) | [models/](../twimo/models/), [data/](../twimo/data/) | ~5min |

### Prediction Generation

| Workflow | Purpose | Modules Used | Time |
|----------|---------|--------------|------|
| [`generate_control_predictions.py`](#4-generate-control-predictions) | Generate ML control predictions | [models/](../twimo/models/), [dt/](../twimo/dt/) | ~2min |
| [`generate_ml_predictions.py`](#5-generate-ml-predictions-basic) | Generate ML predictions from maneuver classifier | [models/](../twimo/models/) | ~2min |
| [`generate_ml_predictions_improved.py`](#6-generate-ml-predictions-improved) | Improved maneuver-to-control conversion | [models/](../twimo/models/) | ~2min |

### Analysis

| Workflow | Purpose | Modules Used | Time |
|----------|---------|--------------|------|
| [`advanced_clustering_analysis.py`](#7-advanced-clustering-analysis) | 3-level hierarchical clustering | [analysis/](../twimo/analysis/) | ~10min |
| [`analyze_annotated_sessions.py`](#8-analyze-annotated-sessions) | Parse and analyze ELAN annotations | [features/](../twimo/features/) | ~5min |
| [`analyze_maneuver_statistics.py`](#9-analyze-maneuver-statistics) | Compute maneuver distribution statistics | [data/](../twimo/data/) | ~2min |

### Visualization

| Workflow | Purpose | Modules Used | Time |
|----------|---------|--------------|------|
| [`visualize_hierarchical_clustering.py`](#10-visualize-hierarchical-clustering) | Create 4D plots, sunburst charts, heatmaps | [visualization/](../twimo/visualization/) | ~5min |
| [`visualize_driving_styles.py`](#11-visualize-driving-styles) | Semantic space + Qdrant vector search | [visualization/](../twimo/visualization/) | ~5min |

### EAF Area-Aware Analysis

| Workflow | Purpose | Modules Used | Time |
|----------|---------|--------------|------|
| [`advanced_clustering_analysis_eaf.py`](#12-advanced-clustering-analysis-eaf) | Cluster styles per area (downtown/freeway/tunnel) | Custom scripts | ~2min |
| [`visualize_driving_styles_eaf.py`](#13-visualize-driving-styles-eaf) | UMAP/PCA plots + per-area distributions | Custom scripts | ~3min |
| [`visualize_hierarchical_clustering_eaf.py`](#14-visualize-hierarchical-clustering-eaf) | Area → Style hierarchy (sunburst, heatmap) | Custom scripts | ~2min |

---

## Data Preparation Workflows

### 1. Build Manifest

**Purpose**: Scan your data folder and create a session registry (manifest).

**Modules Used**: [twimo/data/](../twimo/data/README.md)

**How to Use**:

```bash
python twimo/workflows/build_manifest.py
```

**Configuration** (`config.yaml`):
```yaml
data_dir: "example_data"
manifest_file: "artifacts/manifest.jsonl"
```

**Output**: `artifacts/manifest.jsonl`

```json
{"session_id": "201702271017", "csv_dir": "...", "video_dir": "..."}
{"session_id": "201702281115", "csv_dir": "...", "video_dir": "..."}
```

**Alternative**: Use CLI
```bash
python -m twimo.cli scan --root ./example_data --out ./artifacts/manifest.jsonl
```

---

### 2. Split Manifest

**Purpose**: Split manifest into training and test sets.

**Modules Used**: [twimo/data/](../twimo/data/README.md)

**How to Use**:

```bash
# Split by day (recommended - avoids temporal leakage)
python twimo/workflows/split_manifest.py --manifest ./artifacts/manifest.jsonl --train ./artifacts/manifest_train.jsonl --test ./artifacts/manifest_test.jsonl --split 0.8 --split-by day

# Split by session
python twimo/workflows/split_manifest.py --manifest ./artifacts/manifest.jsonl --train ./artifacts/manifest_train.jsonl --test ./artifacts/manifest_test.jsonl --split 0.8 --split-by session
```

**Output**:
- `manifest_train.jsonl`: 80% sessions for training
- `manifest_test.jsonl`: 20% sessions for testing

**Why split by day?**
- Avoids temporal leakage (sessions from same day are correlated)
- More realistic test scenario

---

## Model Training Workflows

### 3. Train Control Regression

**Purpose**: Train a model to predict steering angle and speed directly (instead of maneuver classes).

**Modules Used**: [twimo/models/](../twimo/models/README.md), [twimo/data/](../twimo/data/README.md)

**Why this approach?**
- ✅ Predicts continuous values (steering, speed)
- ✅ 10x better than maneuver classification for DT validation
- ✅ Physically realistic outputs

**How to Use**:

```bash
python twimo/workflows/train_control_regression.py --manifest ./artifacts/manifest_train.jsonl --test-manifest ./artifacts/manifest_test.jsonl --outdir ./artifacts/control_regressor_xgb --model xgboost --sample-hz 3
```

**Available models**:
- `xgboost` (recommended)
- `lightgbm`
- `random_forest`

**Output**: `artifacts/control_regressor_xgb/`
- `model.joblib`: Trained model
- `test_metrics.json`: RMSE for steering and speed

**Alternative**: Use maneuver prediction via CLI
```bash
python -m twimo.cli train-maneuver --model xgboost
```

---

## Prediction Generation Workflows

### 4. Generate Control Predictions

**Purpose**: Use trained control regressor to generate synthetic sensor data (steering + speed predictions).

**Modules Used**: [twimo/models/](../twimo/models/README.md), [twimo/dt/](../twimo/dt/README.md)

**How to Use**:

```bash
python twimo/workflows/generate_control_predictions.py --model-dir ./artifacts/control_regressor_xgb --manifest ./artifacts/manifest_test.jsonl --output-dir ./control_predicted_sensors --sample-hz 3
```

**Output**:
- `control_predicted_sensors/<SESSION_ID>/vel.csv`: Predicted velocity
- `control_predicted_sensors/<SESSION_ID>/steer.csv`: Predicted steering
- `manifest_control_predictions.jsonl`: Manifest pointing to predictions

**Use case**: ML Physical Consistency Validation (see main [README.md](../README.md))

---

### 5. Generate ML Predictions (Basic)

**Purpose**: Use maneuver classifier to generate predictions, then convert to sensor commands using heuristics.

**Modules Used**: [twimo/models/](../twimo/models/README.md)

**Note**: This is Approach 1 (Basic) - not recommended. Use control regression (Workflow #4) instead.

**How to Use**:

```bash
python twimo/workflows/generate_ml_predictions.py --model-dir ./artifacts/maneuver_xgboost --manifest ./artifacts/manifest_test.jsonl --output-dir ./ml_predicted_sensors --sample-hz 3
```

**Output**: Similar to `generate_control_predictions.py` but lower quality.

---

### 6. Generate ML Predictions (Improved)

**Purpose**: Improved version of maneuver-to-control conversion with better heuristics.

**Modules Used**: [twimo/models/](../twimo/models/README.md)

**How to Use**:

```bash
python twimo/workflows/generate_ml_predictions_improved.py --model-dir ./artifacts/maneuver_xgboost --manifest ./artifacts/manifest_test.jsonl --output-dir ./ml_predicted_sensors_v2 --sample-hz 3
```

**Improvements over basic version**:
- Better velocity smoothing
- Context-aware steering predictions
- Reduced jitter in generated signals

---

## Analysis Workflows

### 7. Advanced Clustering Analysis

**Purpose**: 3-level hierarchical clustering of driving behaviors.

**Modules Used**: [twimo/analysis/](../twimo/analysis/README.md)

**Clustering Levels**:
- **Level 1**: Style (prudent/smooth/aggressive)
- **Level 2**: Style + Context (city/highway)
- **Level 3**: Fine-grained behaviors

**How to Use**:

```bash
python twimo/workflows/advanced_clustering_analysis.py
```

**Configuration** (`config.yaml`):
```yaml
clustering:
  level1_clusters: 3
  level2_clusters: 7
  level3_clusters: 11

temporal:
  window_size_sec: 30
  stride_sec: 15
```

**Output**: `artifacts/advanced_analysis/`
- `clustering_results.jsonl`: Per-session cluster assignments
- `centroids.json`: Cluster centers
- `temporal_segments.jsonl`: Time-windowed segments
- `CLUSTERING_REPORT.txt`: Summary statistics

**Example output**:
```
=== Clustering Summary ===
Level 1 (Style):
  - Prudent: 45 sessions (43%)
  - Smooth: 38 sessions (37%)
  - Aggressive: 21 sessions (20%)

Level 2 (Style + Context):
  - Prudent City: 18 sessions
  - Prudent Highway: 27 sessions
  - Smooth City: 15 sessions
  - Smooth Suburban: 12 sessions
  ...
```

**Alternative**: Use CLI for simple clustering
```bash
python -m twimo.cli train-style --k 3
```

See [twimo/analysis/README.md](../twimo/analysis/README.md) for details.

---

### 8. Analyze Annotated Sessions

**Purpose**: Parse and analyze ELAN annotation files (.eaf).

**Modules Used**: [twimo/features/](../twimo/features/README.md)

**What it analyzes**:
- **Tier 1**: Intent annotations
- **Tier 2**: Maneuver annotations
- **Tier 3**: Stimulus annotations
- **Tier 4**: Cause annotations
- **Tier 5**: Goal annotations

**How to Use**:

```bash
python twimo/workflows/analyze_annotated_sessions.py --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/annotation_analysis
```

**Output**: `artifacts/annotation_analysis/`
- `annotation_summary.json`: Statistics per tier
- `intent_distribution.csv`: Intent frequency
- `maneuver_transitions.csv`: Markov transition matrix
- `stimulus_causes.csv`: Stimulus-Cause pairs

**Use case**: Understand ground-truth annotation patterns, validate ELAN files

See [twimo/features/README.md](../twimo/features/README.md) for ELAN annotation details.

---

### 9. Analyze Maneuver Statistics

**Purpose**: Compute distribution statistics of maneuvers (ground-truth or predicted).

**Modules Used**: [twimo/data/](../twimo/data/README.md)

**How to Use**:

```bash
python twimo/workflows/analyze_maneuver_statistics.py --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_stats
```

**Output**: `artifacts/maneuver_stats/`
- `maneuver_distribution.csv`: Frequency per class
- `session_maneuver_counts.json`: Per-session breakdown
- `temporal_patterns.csv`: Maneuver sequences

**Use case**: Understand class imbalance, identify rare maneuvers

---

## Visualization Workflows

### 10. Visualize Hierarchical Clustering

**Purpose**: Create interactive visualizations of hierarchical clustering results.

**Modules Used**: [twimo/visualization/](../twimo/visualization/README.md)

**Visualizations**:
- **4D scatter plot**: velocity, accel, steer, color=style
- **Sunburst chart**: Hierarchical cluster structure
- **Temporal heatmap**: Behavior changes over time

**How to Use**:

```bash
python twimo/workflows/visualize_hierarchical_clustering.py
```

**Prerequisites**: Run `advanced_clustering_analysis.py` first.

**Output**: `artifacts/advanced_viz/`
- `hierarchical_4d_plot.html`
- `hierarchical_sunburst.html`
- `temporal_heatmap.html`

**Open in browser** to explore interactively.

See [twimo/visualization/README.md](../twimo/visualization/README.md) for details.

---

### 11. Visualize Driving Styles

**Purpose**: Project sessions into 2D/3D semantic space and enable similarity search.

**Modules Used**: [twimo/visualization/](../twimo/visualization/README.md)

**Features**:
- Dimensionality reduction (UMAP, PCA, t-SNE)
- Qdrant vector database indexing
- Similarity search

**Prerequisites**:

```bash
# Start Qdrant (Docker required)
cd qdrant && docker-compose up -d
```

**How to Use**:

```bash
python twimo/workflows/visualize_driving_styles.py
```

**Output**: `artifacts/style_viz/`
- `driving_styles_umap_2d.html`: Interactive 2D plot
- `driving_styles_umap_3d.html`: Interactive 3D plot
- `driving_styles_pca_2d.html`: PCA comparison
- `semantic_space_umap_2d.json`: Exported data

**Qdrant**:
- Dashboard: `http://localhost:6333/dashboard`
- Collection: `driving_styles`
- Use for similarity search

**Alternative**: Use CLI
```bash
python -m twimo.cli train-style --k 3
```

See [twimo/visualization/README.md](../twimo/visualization/README.md) for details.

---

## EAF Area-Aware Workflows

### 12. Advanced Clustering Analysis (EAF)

**Purpose**: Cluster driving styles per geographical area (downtown/freeway/tunnel) using EAF annotations.

**Modules Used**: Custom standalone scripts ([style_eaf.py](../strategies_EAF/style_eaf.py), [style_eaf_viz.py](../strategies_EAF/style_eaf_viz.py), [hierarchical_eaf_viz.py](../strategies_EAF/hierarchical_eaf_viz.py))

**Key Features**:
- Segments sensor data by **EAF Area tier** (downtown/freeway/tunnel)
- Each (session, area) pair becomes a separate data point
- K-Means clustering (k=3): prudent / smooth / aggressive
- Per-area distribution statistics (e.g., "60% prudent in downtown")

**Prerequisites**:
- EAF files parsed: `python twimo/strategies_eaf/parse_eaf.py`
- Vocabularies built: `python twimo/strategies_eaf/build_all_vocabs_chinese.py`

**How to Use**:

```bash
python twimo/workflows/advanced_clustering_analysis_eaf.py
```

**Optional arguments**:
```bash
python twimo/workflows/advanced_clustering_analysis_eaf.py --sensor-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor --eaf-parsed-dir ./artifacts/eaf/parsed --vocab-dir ./artifacts/eaf/vocabs --outdir ./artifacts/eaf/style_analysis --k 3 --sample-hz 3.0
```

**Output**: `artifacts/eaf/style_analysis/`
- `style_eaf_profiles.jsonl`: All (session × area) segments with features + style labels
- `style_eaf_centroids.json`: K-Means cluster centroids and name mapping
- `style_eaf_summary.json`: Per-area statistics (distribution, feature means/stds)
- `ANALYSIS_REPORT_EAF.txt`: Human-readable comprehensive report

**Example report excerpt**:
```
=== Per-Area Style Distribution ===
[DOWNTOWN] (21 segments)
  prudent     :   13 ( 61.9%)
  smooth      :    6 ( 28.6%)
  aggressive  :    2 (  9.5%)

[FREEWAY] (2 segments)
  prudent     :    2 (100.0%)
  smooth      :    0 (  0.0%)
  aggressive  :    0 (  0.0%)
```

---

### 13. Visualize Driving Styles (EAF)

**Purpose**: Generate interactive visualizations for area-aware style clustering.

**Modules Used**: [style_eaf_viz.py](../strategies_EAF/style_eaf_viz.py)

**Visualizations**:
1. **Dimensionality reduction** (same as standard workflow):
   - UMAP 2D: Best separation, colored by style, shaped by area
   - UMAP 3D: Interactive rotation
   - PCA 2D: Linear projection for comparison
2. **Per-area analysis**:
   - Bar chart: Style distribution per area
   - Radar chart: Feature profiles (style × area)
   - Box plots: Feature distributions grouped by area + style

**Prerequisites**: Run `advanced_clustering_analysis_eaf.py` first.

**How to Use**:

```bash
python twimo/workflows/visualize_driving_styles_eaf.py --results-dir artifacts/eaf/style_analysis
```

**Optional arguments**:
```bash
python twimo/workflows/visualize_driving_styles_eaf.py --results-dir artifacts/eaf/style_analysis --outdir artifacts/eaf/style_analysis/plots --method umap
```

**Output**: `artifacts/eaf/style_analysis/plots/`
- `driving_styles_umap_2d.html`: UMAP 2D projection (recommended)
- `driving_styles_umap_3d.html`: UMAP 3D projection
- `driving_styles_pca_2d.html`: PCA 2D projection
- `distribution_per_area.html`: Bar chart per area
- `radar_profiles.html`: Normalized feature profiles
- `boxplots_features.html`: Feature distributions (box plots)

**Note**: Requires `plotly` and `umap-learn`:
```bash
pip install plotly umap-learn
```

---

### 14. Visualize Hierarchical Clustering (EAF)

**Purpose**: Create hierarchical visualizations showing Area → Style relationships.

**Modules Used**: [hierarchical_eaf_viz.py](../strategies_EAF/hierarchical_eaf_viz.py)

**Visualizations**:
1. **Multi-dimensional scatter**: X=aggressiveness, Y=area score (downtown=0, freeway=0.5, tunnel=1), Color=style, Size=segment duration
2. **Sunburst chart**: Interactive hierarchical view (Area → Style → Sessions)
3. **Heatmap**: Session × Area matrix, cell color = driving style

**Use cases**:
- Understand how aggressiveness correlates with geographical context
- Identify drivers who **adapt** their style across areas vs. those who remain consistent
- Explore hierarchical distribution (Area → Style)

**Prerequisites**: Run `advanced_clustering_analysis_eaf.py` first.

**How to Use**:

```bash
python twimo/workflows/visualize_hierarchical_clustering_eaf.py --results-dir artifacts/eaf/style_analysis
```

**Optional arguments**:
```bash
python twimo/workflows/visualize_hierarchical_clustering_eaf.py --results-dir artifacts/eaf/style_analysis --outdir artifacts/eaf/style_analysis/plots
```

**Output**: `artifacts/eaf/style_analysis/plots/`
- `multidim_scatter.html`: Multi-dimensional scatter (aggr × area)
- `sunburst_area_style.html`: Hierarchical sunburst chart
- `heatmap_session_area.html`: Session adaptability matrix

**Interpretation**:
- **Multidim scatter**: Reveals if drivers are more aggressive in certain areas (e.g., freeway vs. downtown)
- **Sunburst**: Shows distribution hierarchy (Area outer ring → Style inner ring)
- **Heatmap**: Identify drivers with consistent style (same color across rows) vs. adaptive (varying colors)

---

## Complete Pipeline Example

Run the full DTE workflow (Design → Build → Validate → Evolve):

```bash
# DESIGN: Prepare data
python twimo/workflows/build_manifest.py
python twimo/workflows/split_manifest.py --manifest ./artifacts/manifest.jsonl --train ./artifacts/manifest_train.jsonl --test ./artifacts/manifest_test.jsonl --split 0.8 --split-by day

# BUILD: Train models
python twimo/workflows/train_control_regression.py --manifest ./artifacts/manifest_train.jsonl --test-manifest ./artifacts/manifest_test.jsonl --outdir ./artifacts/control_regressor_xgb --model xgboost --sample-hz 3

# VALIDATE: Generate predictions and test DT
python twimo/workflows/generate_control_predictions.py --model-dir ./artifacts/control_regressor_xgb --manifest ./artifacts/manifest_test.jsonl --output-dir ./control_predicted_sensors --sample-hz 3
python -m twimo.cli simulate-dt-optimized --manifest ./artifacts/manifest_test.jsonl --outdir ./artifacts/dt_optimized

# EVOLVE: Analyze and visualize
python twimo/workflows/advanced_clustering_analysis.py
cd qdrant && docker-compose up -d && cd ..
python twimo/workflows/visualize_hierarchical_clustering.py
python twimo/workflows/visualize_driving_styles.py
```

### EAF Area-Aware Pipeline Example

Analyze driving styles per geographical area using EAF annotations:

```bash
# PREPARE: Parse EAF files and build vocabularies
python twimo/strategies_eaf/parse_eaf.py --eaf-dir ./path/to/eaf_files --output-dir ./artifacts/eaf/parsed
python twimo/strategies_eaf/build_all_vocabs_chinese.py --eaf-dir ./artifacts/eaf/parsed --output-dir ./artifacts/eaf/vocabs

# CLUSTER: Segment by area and cluster styles
python twimo/workflows/advanced_clustering_analysis_eaf.py

# VISUALIZE: Generate all plots
python twimo/workflows/visualize_driving_styles_eaf.py --results-dir artifacts/eaf/style_analysis
python twimo/workflows/visualize_hierarchical_clustering_eaf.py --results-dir artifacts/eaf/style_analysis

# VIEW: Open results
start artifacts/eaf/style_analysis/ANALYSIS_REPORT_EAF.txt
start artifacts/eaf/style_analysis/plots/driving_styles_umap_2d.html
start artifacts/eaf/style_analysis/plots/sunburst_area_style.html
```

---

## Customization

### Change Clustering Parameters

Edit `config.yaml`:

```yaml
clustering:
  level1_clusters: 5  # Try 5 styles instead of 3
  level2_clusters: 10
  level3_clusters: 20

temporal:
  window_size_sec: 60  # Larger windows
  stride_sec: 30
```

### Change ML Model

Most workflows accept `--model` argument:

```bash
python twimo/workflows/train_control_regression.py --model lightgbm  # Instead of xgboost
```

### Limit Sessions for Testing

Use `--max-sessions` flag:

```bash
python twimo/workflows/advanced_clustering_analysis.py --max-sessions 10
```

---

## Workflow vs CLI

| Feature | Workflows | CLI |
|---------|-----------|-----|
| **Use case** | Complex pipelines, custom logic | Quick standard operations |
| **Flexibility** | High - full Python access | Medium - predefined commands |
| **Ease of use** | Medium - requires Python knowledge | High - simple commands |
| **Customization** | Easy to modify scripts | Limited to CLI arguments |
| **Best for** | Research, experiments, integration | Production, automation |

**When to use workflows**:
- ✅ Need custom preprocessing
- ✅ Want to understand internals
- ✅ Building custom pipelines
- ✅ Research experiments

**When to use CLI**:
- ✅ Standard operations
- ✅ Quick prototyping
- ✅ Automation scripts
- ✅ Don't want to write Python

---

## Module Cross-Reference

Each workflow uses specific TWIMO modules:

| Workflow | Primary Module | Related Modules |
|----------|----------------|-----------------|
| `build_manifest.py` | [data/](../twimo/data/) | - |
| `split_manifest.py` | [data/](../twimo/data/) | - |
| `train_control_regression.py` | [models/](../twimo/models/) | [data/](../twimo/data/), [features/](../twimo/features/) |
| `generate_control_predictions.py` | [models/](../twimo/models/) | [dt/](../twimo/dt/) |
| `generate_ml_predictions.py` | [models/](../twimo/models/) | [dt/](../twimo/dt/) |
| `generate_ml_predictions_improved.py` | [models/](../twimo/models/) | [dt/](../twimo/dt/) |
| `advanced_clustering_analysis.py` | [analysis/](../twimo/analysis/) | [data/](../twimo/data/) |
| `analyze_annotated_sessions.py` | [features/](../twimo/features/) | [data/](../twimo/data/) |
| `analyze_maneuver_statistics.py` | [data/](../twimo/data/) | [analysis/](../twimo/analysis/) |
| `visualize_hierarchical_clustering.py` | [visualization/](../twimo/visualization/) | [analysis/](../twimo/analysis/) |
| `visualize_driving_styles.py` | [visualization/](../twimo/visualization/) | [analysis/](../twimo/analysis/) |
| `advanced_clustering_analysis_eaf.py` | Custom ([style_eaf.py](../strategies_EAF/style_eaf.py)) | EAF parsing, K-Means |
| `visualize_driving_styles_eaf.py` | Custom ([style_eaf_viz.py](../strategies_EAF/style_eaf_viz.py)) | Plotly, UMAP, PCA |
| `visualize_hierarchical_clustering_eaf.py` | Custom ([hierarchical_eaf_viz.py](../strategies_EAF/hierarchical_eaf_viz.py)) | Plotly |

See individual module README.md files for API documentation.

---

## Troubleshooting

### "No manifest found"

Run `python twimo/workflows/build_manifest.py` first.

### "Qdrant connection refused"

```bash
cd qdrant && docker-compose up -d
# Check: http://localhost:6333/dashboard
```

### Workflows run slowly

- Use `--max-sessions 10` to test with fewer sessions
- Check `config.yaml`: `max_sessions: 10`

### Import errors

Make sure TWIMO is in PYTHONPATH:
```bash
# From project root
export PYTHONPATH="${PYTHONPATH}:$(pwd)"
```

Or add at script top:
```python
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent))
```

---

## Creating Custom Workflows

To create a new workflow:

1. **Copy an existing workflow** as a template
2. **Import TWIMO modules**:
```python
from twimo.data import load_manifest
from twimo.models import train_xgboost_multihead
from twimo.analysis import cluster_styles
```
3. **Add argument parsing** (use `argparse`)
4. **Implement pipeline logic**
5. **Save outputs** to `artifacts/`
6. **Update this README.md**

See [twimo/README.md](../twimo/README.md) for module architecture.

---

## Related Documentation

- **Main README**: [../README.md](../README.md) - Project overview and quickstart
- **Framework**: [../twimo/README.md](../twimo/README.md) - DTE framework mapping
- **Data**: [../twimo/data/README.md](../twimo/data/README.md) - Data loading and manifests
- **Models**: [../twimo/models/README.md](../twimo/models/README.md) - ML models (11 architectures)
- **Analysis**: [../twimo/analysis/README.md](../twimo/analysis/README.md) - Clustering and analysis
- **Visualization**: [../twimo/visualization/README.md](../twimo/visualization/README.md) - Interactive plots
- **Features**: [../twimo/features/README.md](../twimo/features/README.md) - Feature engineering
- **XAI**: [../twimo/xai/README.md](../twimo/xai/README.md) - Explainability
- **Digital Twin**: [../twimo/dt/README.md](../twimo/dt/README.md) - DT simulation

---

**Last Updated**: 2026-02-13
