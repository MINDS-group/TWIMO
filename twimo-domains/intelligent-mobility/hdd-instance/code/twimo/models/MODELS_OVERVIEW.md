# TWIMO Models Overview

This document provides an overview of all available models for maneuver prediction in TWIMO.

---

## Available Models

TWIMO supports **11 different model architectures** for multi-horizon maneuver prediction. Each model can be selected using the `--model` flag in the `train-maneuver` command.

---

## Model Categories

### 1. Deep Learning Models (Sequence-based)

These models work with raw temporal sequences and learn representations automatically.

#### **Transformer** (`--model transformer`)
- **Architecture**: Multi-head self-attention encoder
- **Type**: Sequence-to-vector with temporal attention
- **Best for**: Complex temporal dependencies, long-range patterns
- **Pros**: State-of-the-art performance, captures long-range dependencies
- **Cons**: Slower training, requires more data, GPU recommended
- **File**: `maneuver_transformer.py`

#### **GRU** (`--model gru`)
- **Architecture**: Gated Recurrent Unit
- **Type**: Recurrent neural network
- **Best for**: Sequential patterns, medium-range dependencies
- **Pros**: Good performance, faster than LSTM, less memory
- **Cons**: Can struggle with very long sequences
- **File**: `gru_lstm_model.py`

#### **LSTM** (`--model lstm`)
- **Architecture**: Long Short-Term Memory
- **Type**: Recurrent neural network with memory cells
- **Best for**: Long-term dependencies, complex temporal patterns
- **Pros**: Excellent at capturing long sequences, handles vanishing gradients
- **Cons**: Slower than GRU, more parameters
- **File**: `gru_lstm_model.py`

#### **TCN** (`--model tcn`)
- **Architecture**: Temporal Convolutional Network
- **Type**: 1D dilated causal convolutions
- **Best for**: Long sequences, parallelizable training
- **Pros**: Fast training (parallelizable), stable gradients, long receptive field
- **Cons**: More memory during inference
- **File**: `tcn_model.py`

### 2. Deep Learning Models (Pooling-based)

These models use pooling to aggregate temporal information, then feed to MLP.

#### **MLP Mean Pooling** (`--model mlp_mean`)
- **Architecture**: Mean pooling + Multi-layer perceptron
- **Type**: Aggregate temporal features via averaging
- **Best for**: When mean statistics are informative
- **Pros**: Simple, fast, interpretable
- **Cons**: Loses temporal order information
- **File**: `mlp_pooling_model.py`

#### **MLP Max Pooling** (`--model mlp_max`)
- **Architecture**: Max pooling + Multi-layer perceptron
- **Type**: Aggregate temporal features via max operation
- **Best for**: When peak values are important
- **Pros**: Captures extreme events, fast
- **Cons**: Loses temporal order, sensitive to outliers
- **File**: `mlp_pooling_model.py`

#### **MLP Concat Pooling** (`--model mlp_concat`)
- **Architecture**: Concatenation of [mean, max, first, last] + MLP
- **Type**: Rich aggregation with multiple statistics
- **Best for**: When both summary stats and boundary values matter
- **Pros**: Combines multiple perspectives, still simple
- **Cons**: Higher dimensional input to MLP
- **File**: `mlp_pooling_model.py`

### 3. Gradient Boosting Models

These models use window statistics (mean, std, min, max, delta) as features.

#### **XGBoost** (`--model xgboost`)
- **Architecture**: Extreme Gradient Boosting
- **Type**: Tree-based ensemble with gradient boosting
- **Best for**: Tabular data, feature engineering
- **Pros**: Fast training, excellent performance, handles missing values
- **Cons**: Requires feature engineering, doesn't learn temporal structure directly
- **File**: `xgboost_model.py`
- **Note**: Requires `pip install xgboost`

#### **LightGBM** (`--model lightgbm`)
- **Architecture**: Light Gradient Boosting Machine
- **Type**: Tree-based ensemble with leaf-wise growth
- **Best for**: Large datasets, fast training
- **Pros**: Very fast, memory efficient, excellent performance
- **Cons**: Can overfit on small datasets
- **File**: `lightgbm_model.py`
- **Note**: Requires `pip install lightgbm`

### 4. Classic Machine Learning Models

#### **Random Forest** (`--model random_forest`)
- **Architecture**: Ensemble of decision trees
- **Type**: Bagging-based tree ensemble
- **Best for**: Robust baseline, interpretability
- **Pros**: No hyperparameter tuning needed, robust to outliers
- **Cons**: Slower than boosting, can be less accurate
- **File**: `random_forest_model.py`

#### **Baseline** (`--model baseline`)
- **Architecture**: Random Forest or XGBoost (auto-selected)
- **Type**: Automatic fallback to best available
- **Best for**: Quick baseline, prototyping
- **Pros**: No dependencies issues, automatic selection
- **Cons**: Less control over hyperparameters
- **File**: `baseline_window.py`

---

## Model Selection Guide

### Choose **Transformer** if:
- You have GPU available
- Dataset is large (>10k samples)
- You want best possible accuracy
- Training time is not a constraint

### Choose **GRU/LSTM** if:
- You have moderate-sized dataset
- Sequential patterns are important
- You want good performance with less complexity than Transformer

### Choose **TCN** if:
- You want parallel training (faster than RNNs)
- You need stable gradients
- You have long sequences

### Choose **XGBoost/LightGBM** if:
- You want fast training and inference
- You have limited GPU resources
- You prefer interpretable models
- You're comfortable with feature engineering

### Choose **Random Forest** if:
- You want a robust baseline
- You need a simple, interpretable model
- You're running on CPU

### Choose **MLP Pooling** if:
- You want simple neural models
- Temporal order is less important than summary statistics
- You need fast training

---

## Performance Comparison (Typical)

| Model | Training Speed | Inference Speed | Memory | GPU Needed | Accuracy |
|-------|---------------|-----------------|--------|------------|----------|
| Transformer | ⭐⭐ | ⭐⭐⭐ | ⭐⭐ | Recommended | ⭐⭐⭐⭐⭐ |
| GRU | ⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐ | Optional | ⭐⭐⭐⭐ |
| LSTM | ⭐⭐ | ⭐⭐⭐ | ⭐⭐ | Optional | ⭐⭐⭐⭐ |
| TCN | ⭐⭐⭐⭐ | ⭐⭐⭐ | ⭐⭐ | Optional | ⭐⭐⭐⭐ |
| XGBoost | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐ | No | ⭐⭐⭐⭐ |
| LightGBM | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐⭐ | No | ⭐⭐⭐⭐ |
| Random Forest | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ | No | ⭐⭐⭐ |
| MLP Mean/Max | ⭐⭐⭐⭐ | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐ | Optional | ⭐⭐⭐ |
| MLP Concat | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐ | Optional | ⭐⭐⭐ |

---

## Usage Examples

### Train Transformer (default)
```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/maneuver_transformer \
  --model transformer
```

### Train XGBoost
```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/maneuver_xgboost \
  --model xgboost
```

### Train GRU
```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/maneuver_gru \
  --model gru
```

### Train TCN
```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/maneuver_tcn \
  --model tcn
```

### Train LightGBM
```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/maneuver_lightgbm \
  --model lightgbm
```

---

## Multi-Horizon Prediction

All models support **multi-horizon prediction**, meaning they predict multiple future time steps simultaneously:
- Default horizons: [0.1s, 0.5s, 1.0s, 2.0s, 3.0s]
- Configurable via `--horizons` flag

Each model outputs a separate prediction head per horizon.

---

## Model Architecture Details

### Sequence Models (Transformer, GRU, LSTM, TCN)
- **Input**: Raw temporal windows `(batch, time_steps, features)`
- **Process**: Learn temporal representations
- **Output**: One classification head per horizon

### Gradient Boosting Models (XGBoost, LightGBM, Random Forest)
- **Input**: Window statistics `[mean, std, min, max, delta]` per feature
- **Process**: Tree-based classification on aggregated features
- **Output**: One model per horizon

### MLP Pooling Models
- **Input**: Raw temporal windows
- **Process**: Pool temporal dimension → MLP
- **Output**: One classification head per horizon

---

## Common Hyperparameters (via ManeuverConfig)

All models share these configuration options:
- `--window-seconds`: Length of input window (default: 3.0s)
- `--sample-hz`: Sampling frequency (default: 3.0 Hz)
- `--horizons`: Prediction horizons in seconds
- `--epochs`: Training epochs (neural models only)
- `--batch-size`: Batch size (neural models only)
- `--lr`: Learning rate (neural models only)
- `--d-model`: Hidden dimension (neural models only)
- `--num-layers`: Number of layers (neural models only)

---

## Adding a New Model

To add a new model to TWIMO:

1. Create a new file in `twimo/models/` (e.g., `my_model.py`)
2. Implement:
   - `train_my_model_multihead(X_train, y_train, X_val, y_val, n_classes, cfg)`
   - `predict_my_model_multihead(ckpt, X, cfg)`
   - Optional: `save_my_model_checkpoint(ckpt, path)` and `load_my_model_checkpoint(path)`
3. Update `twimo/cli.py`:
   - Import your functions
   - Add to `--model` choices
   - Add training case in `cmd_train_maneuver`
   - Add prediction case in test metrics section
   - Add loading in `_load_model_for_explain`
   - Add prediction case in `cmd_explain`
4. Update documentation (`MODELS_OVERVIEW.md`)

---

## Dependencies

### Always Required
- PyTorch (for Transformer, GRU, LSTM, TCN, MLP models)
- scikit-learn (for Random Forest, preprocessing)
- NumPy, Pandas

### Optional (for specific models)
- **XGBoost**: `pip install xgboost`
- **LightGBM**: `pip install lightgbm`

---

## Best Practices

1. **Start with a baseline**: Use `--model baseline` or `--model random_forest` for quick prototyping
2. **Try gradient boosting**: XGBoost/LightGBM often give excellent performance with minimal tuning
3. **Use Transformer for final models**: If accuracy is critical and you have resources
4. **Compare multiple models**: Train several models and compare test metrics
5. **Monitor validation accuracy**: All models print per-horizon validation accuracy during training
6. **Consider inference speed**: If deploying in real-time, choose fast models (XGBoost, LightGBM)

---

## Troubleshooting

### XGBoost/LightGBM not found
```bash
pip install xgboost lightgbm
```

### CUDA out of memory (neural models)
- Reduce `--batch-size`
- Reduce `--d-model`
- Use CPU: Uninstall CUDA PyTorch, reinstall CPU version
- Switch to gradient boosting models

### Poor performance
- Increase `--epochs` (neural models)
- Increase `--window-seconds` (more context)
- Check data quality and alignment
- Try different models
- Ensure sufficient training data

---

## References

- Transformer: Vaswani et al., "Attention is All You Need" (2017)
- TCN: Bai et al., "An Empirical Evaluation of Generic Convolutional and Recurrent Networks for Sequence Modeling" (2018)
- XGBoost: Chen & Guestrin, "XGBoost: A Scalable Tree Boosting System" (2016)
- LightGBM: Ke et al., "LightGBM: A Highly Efficient Gradient Boosting Decision Tree" (2017)
