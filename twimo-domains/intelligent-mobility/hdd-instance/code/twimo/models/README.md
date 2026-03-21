# Models - AI-Based Prediction Services

This folder contains the **DrivingModel** implementations for TWIMO, implementing the **AI-Based Prediction Services** from the DTE framework.

---

## What's in This Folder?

This package provides **11 different model architectures** for multi-horizon maneuver prediction, plus driving style clustering.

### Maneuver Prediction Models

All models predict driver actions (turn left/right, brake, accelerate, stop, straight) at multiple future time steps (0.1s, 0.5s, 1.0s, 2.0s, 3.0s).

**Files**:
- `maneuver_transformer.py` - Multi-head self-attention (Transformer)
- `gru_lstm_model.py` - Recurrent networks (GRU, LSTM)
- `tcn_model.py` - Temporal Convolutional Network
- `mlp_pooling_model.py` - MLP with pooling (mean/max/concat)
- `xgboost_model.py` - XGBoost classifier
- `lightgbm_model.py` - LightGBM classifier
- `random_forest_model.py` - Random Forest classifier
- `baseline_window.py` - Auto-fallback baseline (XGBoost or Random Forest)

### Style Modeling

**File**: `style.py` - Unsupervised K-means clustering of driving styles (prudent, smooth, aggressive)

### Utilities

- `sequence.py` - Sequence processing utilities
- `training.py` - Common training utilities

---

## Framework Mapping

### DTE Metamodel → TWIMO Implementation

| DTE Component | TWIMO Implementation |
|---------------|----------------------|
| **AI-Based Services → Prediction Service** | This folder (`twimo/models/`) |
| **Predictor** | All maneuver prediction models |
| **PredictiveModel** | Individual architectures (Transformer, XGBoost, etc.) |
| **DrivingModel** | Composite model (Driver + Vehicle + Environment) |
| **Feature** | Input features from [data/](../data/) and [features/](../features/) |
| **VolatileFeature** | Time-varying features (acceleration, jerk) |
| **Metric** | Output metrics (accuracy, F1-score, RMSE) |

### Data Flow

```
Data Loading (data/) → Feature Extraction (features/) → Model Training (models/) → Prediction (Run)
     ↓                        ↓                              ↓                        ↓
  Sensors               Temporal Features              Predictor                 Maneuver
```

See [../README.md](../README.md) for complete framework overview.

---

## Available Models (11 Total)

### 1. Deep Learning Models (Sequence-based)

These models work with raw temporal sequences and learn representations automatically.

#### **Transformer** (`--model transformer`)
- **Architecture**: Multi-head self-attention encoder
- **Type**: Sequence-to-vector with temporal attention
- **Best for**: Complex temporal dependencies, long-range patterns
- **Pros**: State-of-the-art performance, captures long-range dependencies
- **Cons**: Slower training, requires more data, GPU recommended
- **File**: [maneuver_transformer.py](maneuver_transformer.py)

#### **GRU** (`--model gru`)
- **Architecture**: Gated Recurrent Unit
- **Type**: Recurrent neural network
- **Best for**: Sequential patterns, medium-range dependencies
- **Pros**: Good performance, faster than LSTM, less memory
- **Cons**: Can struggle with very long sequences
- **File**: [gru_lstm_model.py](gru_lstm_model.py)

#### **LSTM** (`--model lstm`)
- **Architecture**: Long Short-Term Memory
- **Type**: Recurrent neural network with memory cells
- **Best for**: Long-term dependencies, complex temporal patterns
- **Pros**: Excellent at capturing long sequences, handles vanishing gradients
- **Cons**: Slower than GRU, more parameters
- **File**: [gru_lstm_model.py](gru_lstm_model.py)

#### **TCN** (`--model tcn`)
- **Architecture**: Temporal Convolutional Network
- **Type**: 1D dilated causal convolutions
- **Best for**: Long sequences, parallelizable training
- **Pros**: Fast training (parallelizable), stable gradients, long receptive field
- **Cons**: More memory during inference
- **File**: [tcn_model.py](tcn_model.py)

---

### 2. Deep Learning Models (Pooling-based)

These models use pooling to aggregate temporal information, then feed to MLP.

#### **MLP Mean Pooling** (`--model mlp_mean`)
- **Architecture**: Mean pooling + Multi-layer perceptron
- **Type**: Aggregate temporal features via averaging
- **Best for**: When mean statistics are informative
- **Pros**: Simple, fast, interpretable
- **Cons**: Loses temporal order information
- **File**: [mlp_pooling_model.py](mlp_pooling_model.py)

#### **MLP Max Pooling** (`--model mlp_max`)
- **Architecture**: Max pooling + Multi-layer perceptron
- **Type**: Aggregate temporal features via max operation
- **Best for**: When peak values are important
- **Pros**: Captures extreme events, fast
- **Cons**: Loses temporal order, sensitive to outliers
- **File**: [mlp_pooling_model.py](mlp_pooling_model.py)

#### **MLP Concat Pooling** (`--model mlp_concat`)
- **Architecture**: Concatenation of [mean, max, first, last] + MLP
- **Type**: Rich aggregation with multiple statistics
- **Best for**: When both summary stats and boundary values matter
- **Pros**: Combines multiple perspectives, still simple
- **Cons**: Higher dimensional input to MLP
- **File**: [mlp_pooling_model.py](mlp_pooling_model.py)

---

### 3. Gradient Boosting Models

These models use window statistics (mean, std, min, max, delta) as features.

#### **XGBoost** (`--model xgboost`)
- **Architecture**: Extreme Gradient Boosting
- **Type**: Tree-based ensemble with gradient boosting
- **Best for**: Tabular data, feature engineering
- **Pros**: Fast training, excellent performance, CPU-friendly, handles missing values
- **Cons**: Requires feature engineering, doesn't learn temporal structure directly
- **File**: [xgboost_model.py](xgboost_model.py)
- **Note**: Requires `pip install xgboost`

#### **LightGBM** (`--model lightgbm`)
- **Architecture**: Light Gradient Boosting Machine
- **Type**: Tree-based ensemble with leaf-wise growth
- **Best for**: Large datasets, fast training, memory efficiency
- **Pros**: Very fast, memory efficient, excellent performance
- **Cons**: Can overfit on small datasets
- **File**: [lightgbm_model.py](lightgbm_model.py)
- **Note**: Requires `pip install lightgbm`

---

### 4. Classic Machine Learning Models

#### **Random Forest** (`--model random_forest`)
- **Architecture**: Ensemble of decision trees
- **Type**: Bagging-based tree ensemble
- **Best for**: Robust baseline, interpretability
- **Pros**: No hyperparameter tuning needed, robust to outliers, no additional dependencies
- **Cons**: Slower than boosting, can be less accurate
- **File**: [random_forest_model.py](random_forest_model.py)

#### **Baseline** (`--model baseline`)
- **Architecture**: Random Forest or XGBoost (auto-selected)
- **Type**: Automatic fallback to best available
- **Best for**: Quick baseline, prototyping
- **Pros**: No dependency issues, automatic selection, reliable
- **Cons**: Less control over hyperparameters
- **File**: [baseline_window.py](baseline_window.py)
- **Note**: Auto-selects XGBoost if available, otherwise Random Forest

---

## Model Selection Guide

### Choose **Transformer** if:
- ✅ You have GPU available
- ✅ Dataset is large (>10k samples)
- ✅ You want best possible accuracy
- ✅ Training time is not a constraint

### Choose **GRU/LSTM** if:
- ✅ You have moderate-sized dataset
- ✅ Sequential patterns are important
- ✅ You want good performance with less complexity than Transformer

### Choose **TCN** if:
- ✅ You want parallel training (faster than RNNs)
- ✅ You need stable gradients
- ✅ You have long sequences

### Choose **XGBoost/LightGBM** if: ⭐ **RECOMMENDED**
- ✅ You want fast training and inference
- ✅ You have limited GPU resources (CPU-only)
- ✅ You prefer interpretable models
- ✅ You're comfortable with feature engineering

### Choose **Random Forest** if:
- ✅ You want a robust baseline
- ✅ You need a simple, interpretable model
- ✅ You're running on CPU
- ✅ You don't want extra dependencies

### Choose **MLP Pooling** if:
- ✅ You want simple neural models
- ✅ Temporal order is less important than summary statistics
- ✅ You need fast training

---

## Performance Comparison

| Model | Training Speed | Inference Speed | Memory | GPU Needed | Accuracy |
|-------|---------------|-----------------|--------|------------|----------|
| Transformer | ⭐⭐ | ⭐⭐⭐ | ⭐⭐ | Recommended | ⭐⭐⭐⭐⭐ |
| GRU | ⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐ | Optional | ⭐⭐⭐⭐ |
| LSTM | ⭐⭐ | ⭐⭐⭐ | ⭐⭐ | Optional | ⭐⭐⭐⭐ |
| TCN | ⭐⭐⭐⭐ | ⭐⭐⭐ | ⭐⭐ | Optional | ⭐⭐⭐⭐ |
| **XGBoost** | **⭐⭐⭐⭐⭐** | **⭐⭐⭐⭐⭐** | **⭐⭐⭐⭐** | **No** | **⭐⭐⭐⭐** |
| **LightGBM** | **⭐⭐⭐⭐⭐** | **⭐⭐⭐⭐⭐** | **⭐⭐⭐⭐⭐** | **No** | **⭐⭐⭐⭐** |
| Random Forest | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ | No | ⭐⭐⭐ |
| MLP Mean/Max | ⭐⭐⭐⭐ | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐ | Optional | ⭐⭐⭐ |
| MLP Concat | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐ | Optional | ⭐⭐⭐ |

**Legend**: ⭐⭐⭐⭐⭐ = Excellent, ⭐⭐⭐⭐ = Very Good, ⭐⭐⭐ = Good, ⭐⭐ = Fair

---

## Usage Examples

All models are trained via the CLI using `--model <name>`.

### Train Transformer (Best Accuracy)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_transformer --model transformer --sample-hz 3 --epochs 5
```

### Train XGBoost (Recommended - Fast + Accurate + CPU)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_xgboost --model xgboost --sample-hz 3
```

### Train LightGBM (Very Fast + Memory Efficient)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_lightgbm --model lightgbm --sample-hz 3
```

### Train GRU (Sequential Patterns)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_gru --model gru --sample-hz 3 --epochs 5
```

### Train LSTM (Long-Term Dependencies)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_lstm --model lstm --sample-hz 3 --epochs 5
```

### Train TCN (Parallelizable Sequences)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_tcn --model tcn --sample-hz 3 --epochs 5
```

### Train Random Forest (Robust Baseline)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_rf --model random_forest --sample-hz 3
```

### Train MLP Mean Pooling (Simple + Fast)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_mlp_mean --model mlp_mean --sample-hz 3 --epochs 5
```

### Train MLP Max Pooling

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_mlp_max --model mlp_max --sample-hz 3 --epochs 5
```

### Train MLP Concat Pooling

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_mlp_concat --model mlp_concat --sample-hz 3 --epochs 5
```

### Train Baseline (Auto-Select Best Available)

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_baseline --model baseline --sample-hz 3
```

---

## Multi-Horizon Prediction

All models support **multi-horizon prediction**, meaning they predict multiple future time steps simultaneously.

### Default Horizons

- **0.1s**: Immediate next action
- **0.5s**: Short-term anticipation
- **1.0s**: Medium-term planning
- **2.0s**: Long-term intent
- **3.0s**: Strategic goal

### Custom Horizons

Use `--horizons` flag to specify custom prediction horizons:

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_custom --model transformer --horizons 0.5 1.0 2.0 --sample-hz 3 --epochs 5
```

### Implementation

Each model outputs a **separate prediction head per horizon**:
- **Neural models** (Transformer, GRU, LSTM, TCN, MLP): One output head per horizon
- **Tree models** (XGBoost, LightGBM, Random Forest): One model instance per horizon

---

## Model Architecture Details

### Sequence Models (Transformer, GRU, LSTM, TCN)

**Input**: Raw temporal windows `(batch, time_steps, features)`

```
Time Window (3 seconds at 3 Hz = 9 time steps)
  ↓
Sequence Encoder (Transformer/GRU/LSTM/TCN)
  ↓
Temporal Representation (learned)
  ↓
Multi-Head Prediction (5 horizons × 6 classes)
```

**Example**:
- Input shape: `(32, 9, 4)` - 32 samples, 9 time steps, 4 base features
- Output shape: `(32, 5, 6)` - 32 samples, 5 horizons, 6 classes

---

### Gradient Boosting Models (XGBoost, LightGBM, Random Forest)

**Input**: Window statistics `[mean, std, min, max, delta]` per feature

```
Time Window (9 time steps × 4 features)
  ↓
Compute Statistics (mean, std, min, max, delta)
  ↓
Feature Vector (20 features: 4 base × 5 stats)
  ↓
Tree Ensemble (per horizon)
  ↓
Classification (6 classes)
```

**Example**:
- Input: 4 base features (velocity, accel, brake, steer)
- Window stats: 4 × 5 = 20 features
- One XGBoost model per horizon (5 models total)

---

### MLP Pooling Models

**Input**: Raw temporal windows → pooled → MLP

```
Time Window (9 time steps × 4 features)
  ↓
Pooling Operation (mean | max | concat)
  ↓
Feature Vector
  ↓
MLP (hidden layers)
  ↓
Multi-Head Prediction (5 horizons × 6 classes)
```

**Pooling Types**:
- **Mean**: Average across time → 4 features
- **Max**: Maximum across time → 4 features
- **Concat**: [mean, max, first, last] → 16 features

---

## Driving Style Clustering

**File**: [style.py](style.py)

**Purpose**: Unsupervised clustering of driving sessions into styles (prudent, smooth, aggressive).

**Method**: K-means clustering on aggregated features (mean velocity, std steering, max acceleration, etc.)

**Usage**:

```bash
python -m twimo.cli train-style --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/style --sample-hz 3 --k 3
```

**Parameters**:
- `--k`: Number of clusters (default: 3)
- Clusters typically represent: Prudent, Smooth, Aggressive

**Outputs**:
- `style_centroids.json`: Cluster centers and session assignments
- `style_profiles.jsonl`: Per-session style profiles

**DTE Mapping**:
- **AI-Based Services → Evaluation Service** → Clustering
- **PerformanceAnalyzer**: Analyzes driving behavior patterns

See [../analysis/README.md](../analysis/README.md) for hierarchical multi-level clustering.

---

## Common Hyperparameters

All models share these configuration options via `ManeuverConfig`:

### Data Parameters
- `--sample-hz`: Sampling frequency (default: 3.0 Hz)
- `--window-seconds`: Length of input window (default: 3.0s)
- `--horizons`: Prediction horizons in seconds (default: [0.1, 0.5, 1.0, 2.0, 3.0])

### Training Parameters (Neural Models Only)
- `--epochs`: Number of training epochs (default: 5)
- `--batch-size`: Batch size (default: 32)
- `--lr`: Learning rate (default: 0.001)

### Model Architecture (Neural Models Only)
- `--d-model`: Hidden dimension (default: 128)
- `--num-layers`: Number of layers (default: 4 for Transformer, 2 for GRU/LSTM)
- `--nhead`: Number of attention heads (Transformer only, default: 4)

### Example with Custom Hyperparameters

```bash
python -m twimo.cli train-maneuver --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/maneuver_custom --model transformer --sample-hz 3 --window-seconds 5.0 --epochs 10 --batch-size 64 --lr 0.0005 --d-model 256 --num-layers 6 --nhead 8
```

---

## Output Artifacts

All models save the following artifacts to `--outdir`:

### Required Files
- `config.json`: Model configuration (hyperparameters, horizons, etc.)
- `feature_names.json`: List of feature column names
- `model_kind.txt`: Model type identifier (e.g., "transformer", "xgboost")
- `test_metrics.json`: Test set metrics (accuracy, F1-score, precision, recall per horizon)

### Model Checkpoints
- **Neural models** (Transformer, GRU, LSTM, TCN, MLP): `model.pth` (PyTorch state dict)
- **Tree models** (XGBoost, LightGBM, Random Forest): `model.joblib` (scikit-learn/joblib)

### Optional Files
- `video_cache/`: Cached video embeddings (if `--use-video`)
- `train_log.txt`: Training progress log (neural models)

---

## Adding a New Model

To add a new model to TWIMO:

### 1. Create Model File

Create `twimo/models/my_new_model.py`:

```python
from __future__ import annotations
import numpy as np
from typing import Dict, Any, List

def train_my_model_multihead(
    X_train: np.ndarray,
    y_train: List[np.ndarray],  # One array per horizon
    X_val: np.ndarray,
    y_val: List[np.ndarray],
    n_classes: int,
    cfg: Any,
) -> Dict[str, Any]:
    """Train model and return checkpoint dict."""
    # Training logic here
    return {"model": trained_model, "config": cfg}

def predict_my_model_multihead(
    ckpt: Dict[str, Any],
    X: np.ndarray,
    cfg: Any,
) -> List[np.ndarray]:
    """Predict for all horizons."""
    # Prediction logic here
    return [predictions_h1, predictions_h2, ...]
```

### 2. Update CLI (`twimo/cli.py`)

Import your functions:

```python
from twimo.models.my_new_model import (
    train_my_model_multihead,
    predict_my_model_multihead,
)
```

Add to `--model` choices:

```python
parser.add_argument(
    '--model',
    choices=['transformer', 'xgboost', ..., 'my_new_model'],
    default='transformer',
)
```

Add training case:

```python
if args.model == "my_new_model":
    ckpt = train_my_model_multihead(
        X_train, y_trains_h, X_val, y_vals_h, n_classes, cfg
    )
```

Add prediction case:

```python
if args.model == "my_new_model":
    y_preds_h = predict_my_model_multihead(ckpt, X_test, cfg)
```

### 3. Update Documentation

- Update this README.md
- Update main [README.md](../../README.md)

---

## Dependencies

### Always Required
- **PyTorch** (>= 2.1): For Transformer, GRU, LSTM, TCN, MLP models
- **scikit-learn** (>= 1.3): For Random Forest, preprocessing, metrics
- **NumPy** (>= 1.23): Array processing
- **Pandas** (>= 2.0): DataFrame operations

### Optional (for specific models)
- **XGBoost** (>= 2.0): For `--model xgboost`
  ```bash
  pip install xgboost
  ```
- **LightGBM** (>= 4.0): For `--model lightgbm`
  ```bash
  pip install lightgbm
  ```

### Installation

```bash
# Core dependencies (required)
pip install -r requirements.txt

# Optional dependencies (XGBoost, LightGBM)
pip install -r requirements-optional.txt
```

---

## Best Practices

### 1. Start with a Baseline
Use `--model baseline` or `--model random_forest` for quick prototyping without extra dependencies.

### 2. Try Gradient Boosting
XGBoost/LightGBM often give excellent performance with minimal tuning and fast training.

### 3. Use Transformer for Final Models
If accuracy is critical and you have GPU resources, Transformer achieves best performance.

### 4. Compare Multiple Models
Train several models and compare `test_metrics.json` to find best performer.

### 5. Monitor Validation Accuracy
All models print per-horizon validation accuracy during training. Watch for overfitting.

### 6. Consider Inference Speed
If deploying in real-time systems, prioritize fast models (XGBoost, LightGBM, MLP).

### 7. Use Video Features Wisely
Video features (`--use-video`) improve accuracy but slow training. Use for final models only.

### 8. Split Data Properly
Use temporal splits (by day) to avoid data leakage:

```bash
python workflows/split_manifest.py --manifest ./artifacts/manifest.jsonl --train ./artifacts/manifest_train.jsonl --test ./artifacts/manifest_test.jsonl --split 0.8 --split-by day
```

---

## Troubleshooting

### XGBoost/LightGBM not found

**Error**: `ModuleNotFoundError: No module named 'xgboost'`

**Solution**:
```bash
pip install xgboost lightgbm
```

Or use `--model baseline` which auto-falls back to Random Forest.

---

### CUDA out of memory (neural models)

**Error**: `RuntimeError: CUDA out of memory`

**Solutions**:
1. Reduce `--batch-size` (try 16, 8, or 4)
2. Reduce `--d-model` (try 64 or 32)
3. Reduce `--num-layers` (try 2)
4. Use CPU-only PyTorch:
   ```bash
   pip uninstall torch torchvision
   pip install torch torchvision --index-url https://download.pytorch.org/whl/cpu
   ```
5. Switch to gradient boosting models (`--model xgboost`)

---

### Poor performance

**Symptoms**: Low accuracy (< 50%), poor F1-scores

**Solutions**:
1. Increase `--epochs` (try 10, 20 for neural models)
2. Increase `--window-seconds` (try 5.0 or 10.0 for more context)
3. Check data quality:
   - Verify manifest sessions are valid
   - Check for missing/corrupted CSV files
   - Inspect feature distributions
4. Try different models (XGBoost, Transformer)
5. Ensure sufficient training data (>100 sessions recommended)
6. Check class balance (some maneuvers may be rare)

---

### Training too slow

**Symptoms**: Training takes hours/days

**Solutions**:
1. Use faster models: XGBoost/LightGBM instead of Transformer
2. Reduce `--epochs` for prototyping
3. Use `--max-sessions` to limit dataset size during development
4. Enable GPU for neural models
5. Remove `--use-video` (video processing is slow)

---

### Model not loading

**Error**: `FileNotFoundError: model.pth not found`

**Solutions**:
1. Verify `--outdir` contains saved artifacts
2. Check `model_kind.txt` matches `--model` argument
3. Retrain if checkpoint is corrupted
4. For tree models, look for `model.joblib` instead of `model.pth`

---

## References

### Papers

- **Transformer**: Vaswani et al., "Attention is All You Need" (NeurIPS 2017)
- **TCN**: Bai et al., "An Empirical Evaluation of Generic Convolutional and Recurrent Networks for Sequence Modeling" (arXiv 2018)
- **XGBoost**: Chen & Guestrin, "XGBoost: A Scalable Tree Boosting System" (KDD 2016)
- **LightGBM**: Ke et al., "LightGBM: A Highly Efficient Gradient Boosting Decision Tree" (NIPS 2017)

### Related TWIMO Documentation

- Main README: [../../README.md](../../README.md)
- Framework Overview: [../README.md](../README.md)
- Data Loading: [../data/README.md](../data/README.md)
- Feature Engineering: [../features/README.md](../features/README.md)
- Digital Twin Simulation: [../dt/README.md](../dt/README.md)
- Analysis & Clustering: [../analysis/README.md](../analysis/README.md)
- Explainability: [../xai/README.md](../xai/README.md)

---

**Last Updated**: 2026-02-13
