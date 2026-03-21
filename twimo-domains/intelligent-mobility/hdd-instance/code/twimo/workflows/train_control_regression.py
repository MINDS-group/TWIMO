#!/usr/bin/env python
"""Train a regression model to predict control commands directly (BEST APPROACH).

Instead of predicting maneuvers (classification) and then converting to commands,
this approach trains a regression model to predict steering angle and speed directly
from sensor data.

This eliminates the maneuver→control conversion step and should give more
accurate, physically plausible predictions.

Supported Models:
    Tree-based (fast, CPU-friendly):
        - xgboost (recommended)
        - lightgbm
        - random_forest
        - baseline (auto-fallback: XGBoost or Random Forest)

    Neural (GPU recommended):
        - transformer
        - gru
        - lstm
        - tcn
        - mlp_mean, mlp_max, mlp_concat

Usage:
    # Train XGBoost regressor (recommended)
    python workflows/train_control_regression.py \
      --manifest ./artifacts/manifest_train.jsonl \
      --test-manifest ./artifacts/manifest_test.jsonl \
      --outdir ./artifacts/control_regressor_xgb \
      --model xgboost \
      --sample-hz 3

    # Train Transformer regressor (best accuracy)
    python workflows/train_control_regression.py \
      --manifest ./artifacts/manifest_train.jsonl \
      --test-manifest ./artifacts/manifest_test.jsonl \
      --outdir ./artifacts/control_regressor_transformer \
      --model transformer \
      --sample-hz 3

    # Train LightGBM regressor (very fast)
    python workflows/train_control_regression.py \
      --manifest ./artifacts/manifest_train.jsonl \
      --test-manifest ./artifacts/manifest_test.jsonl \
      --outdir ./artifacts/control_regressor_lgbm \
      --model lightgbm \
      --sample-hz 3
"""

from __future__ import annotations

from pathlib import Path
import sys
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import argparse
import json
from pathlib import Path
from typing import Tuple

import numpy as np
import pandas as pd
from tqdm import tqdm

from twimo.data.manifest import load_manifest
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid


def load_session_data(session_record, sample_hz: float = 3.0, window_seconds: float = 10.0) -> Tuple[np.ndarray, np.ndarray]:
    """Load sensors and control targets for one session.

    Returns:
        X: Sensor features (T, D)
        y: Control targets (T, 2) where columns are [steer_angle, speed]
    """
    df = load_run_sensors(Path(session_record.csv_dir))
    aligned = align_sensors_to_grid(df, hz=sample_hz)

    # Extract features (use same features as maneuver prediction for consistency)
    feature_cols = ['steer_angle', 'steer_speed', 'lturn', 'rturn']

    # Build feature matrix
    X_df = pd.DataFrame()
    for col in feature_cols:
        if col in aligned.columns:
            X_df[col] = aligned[col].fillna(0.0)
        else:
            X_df[col] = 0.0

    X = X_df.values.astype(np.float32)

    # Extract control targets (what we want to predict)
    steer_target = aligned.get('steer_angle', pd.Series(np.zeros(len(aligned)))).fillna(0.0).values
    speed_target = aligned.get('speed', pd.Series(np.zeros(len(aligned)))).fillna(0.0).values

    y = np.column_stack([steer_target, speed_target]).astype(np.float32)

    return X, y


def build_windowed_features(X: np.ndarray, window: int) -> np.ndarray:
    """Build window statistics features for tree-based models.

    Args:
        X: Raw sensor array (T, D)
        window: Window size in timesteps

    Returns:
        X_feat: Windowed features (T-window, 5*D)
    """
    T, D = X.shape
    n_samples = T - window + 1

    features = []
    for i in range(n_samples):
        W = X[i:i+window]  # (window, D)

        # Compute statistics
        mu = W.mean(axis=0)
        sd = W.std(axis=0)
        mn = W.min(axis=0)
        mx = W.max(axis=0)
        dt = W[-1] - W[0]

        feat = np.concatenate([mu, sd, mn, mx, dt])
        features.append(feat)

    return np.array(features, dtype=np.float32)


def train_xgboost_regressor(X_train: np.ndarray, y_train: np.ndarray,
                            X_val: np.ndarray, y_val: np.ndarray) -> dict:
    """Train XGBoost multi-output regressor."""
    try:
        import xgboost as xgb
    except ImportError:
        raise RuntimeError("XGBoost not installed. Install with: pip install xgboost")

    from sklearn.multioutput import MultiOutputRegressor
    from sklearn.preprocessing import StandardScaler
    from sklearn.pipeline import make_pipeline

    # Create multi-output regressor (predicts both steer and speed)
    base = xgb.XGBRegressor(
        n_estimators=300,
        max_depth=8,
        learning_rate=0.05,
        subsample=0.9,
        colsample_bytree=0.9,
        reg_lambda=1.0,
        reg_alpha=0.1,
        n_jobs=-1,
        tree_method='hist',
        random_state=42,
    )

    model = make_pipeline(
        StandardScaler(with_mean=True, with_std=True),
        MultiOutputRegressor(base),
    )

    print("  Training XGBoost regressor...")
    model.fit(X_train, y_train)

    # Evaluate
    y_pred = model.predict(X_val)

    # Compute metrics
    steer_mae = float(np.mean(np.abs(y_val[:, 0] - y_pred[:, 0])))
    speed_mae = float(np.mean(np.abs(y_val[:, 1] - y_pred[:, 1])))
    steer_rmse = float(np.sqrt(np.mean((y_val[:, 0] - y_pred[:, 0])**2)))
    speed_rmse = float(np.sqrt(np.mean((y_val[:, 1] - y_pred[:, 1])**2)))

    metrics = {
        'steer_mae': steer_mae,
        'steer_rmse': steer_rmse,
        'speed_mae': speed_mae,
        'speed_rmse': speed_rmse,
        'n_val': len(y_val),
    }

    print(f"    Steer MAE: {steer_mae:.3f}°, RMSE: {steer_rmse:.3f}°")
    print(f"    Speed MAE: {speed_mae:.3f} km/h, RMSE: {speed_rmse:.3f} km/h")

    return {'model': model, 'metrics': metrics}


def train_random_forest_regressor(X_train: np.ndarray, y_train: np.ndarray,
                                  X_val: np.ndarray, y_val: np.ndarray) -> dict:
    """Train Random Forest multi-output regressor."""
    from sklearn.ensemble import RandomForestRegressor
    from sklearn.preprocessing import StandardScaler
    from sklearn.pipeline import make_pipeline

    model = make_pipeline(
        StandardScaler(with_mean=True, with_std=True),
        RandomForestRegressor(
            n_estimators=400,
            max_depth=None,
            min_samples_split=2,
            min_samples_leaf=1,
            n_jobs=-1,
            random_state=42,
        ),
    )

    print("  Training Random Forest regressor...")
    model.fit(X_train, y_train)

    # Evaluate
    y_pred = model.predict(X_val)

    steer_mae = float(np.mean(np.abs(y_val[:, 0] - y_pred[:, 0])))
    speed_mae = float(np.mean(np.abs(y_val[:, 1] - y_pred[:, 1])))
    steer_rmse = float(np.sqrt(np.mean((y_val[:, 0] - y_pred[:, 0])**2)))
    speed_rmse = float(np.sqrt(np.mean((y_val[:, 1] - y_pred[:, 1])**2)))

    metrics = {
        'steer_mae': steer_mae,
        'steer_rmse': steer_rmse,
        'speed_mae': speed_mae,
        'speed_rmse': speed_rmse,
        'n_val': len(y_val),
    }

    print(f"    Steer MAE: {steer_mae:.3f}°, RMSE: {steer_rmse:.3f}°")
    print(f"    Speed MAE: {speed_mae:.3f} km/h, RMSE: {speed_rmse:.3f} km/h")

    return {'model': model, 'metrics': metrics}


def train_lightgbm_regressor(X_train: np.ndarray, y_train: np.ndarray,
                              X_val: np.ndarray, y_val: np.ndarray) -> dict:
    """Train LightGBM multi-output regressor."""
    try:
        import lightgbm as lgb
    except ImportError:
        raise RuntimeError("LightGBM not installed. Install with: pip install lightgbm")

    from sklearn.multioutput import MultiOutputRegressor
    from sklearn.preprocessing import StandardScaler
    from sklearn.pipeline import make_pipeline

    base = lgb.LGBMRegressor(
        n_estimators=300,
        max_depth=8,
        learning_rate=0.05,
        subsample=0.9,
        colsample_bytree=0.9,
        reg_lambda=1.0,
        reg_alpha=0.1,
        n_jobs=-1,
        random_state=42,
        verbose=-1,
    )

    model = make_pipeline(
        StandardScaler(with_mean=True, with_std=True),
        MultiOutputRegressor(base),
    )

    print("  Training LightGBM regressor...")
    model.fit(X_train, y_train)

    # Evaluate
    y_pred = model.predict(X_val)

    steer_mae = float(np.mean(np.abs(y_val[:, 0] - y_pred[:, 0])))
    speed_mae = float(np.mean(np.abs(y_val[:, 1] - y_pred[:, 1])))
    steer_rmse = float(np.sqrt(np.mean((y_val[:, 0] - y_pred[:, 0])**2)))
    speed_rmse = float(np.sqrt(np.mean((y_val[:, 1] - y_pred[:, 1])**2)))

    metrics = {
        'steer_mae': steer_mae,
        'steer_rmse': steer_rmse,
        'speed_mae': speed_mae,
        'speed_rmse': speed_rmse,
        'n_val': len(y_val),
    }

    print(f"    Steer MAE: {steer_mae:.3f}°, RMSE: {steer_rmse:.3f}°")
    print(f"    Speed MAE: {speed_mae:.3f} km/h, RMSE: {speed_rmse:.3f} km/h")

    return {'model': model, 'metrics': metrics}


def train_transformer_regressor(X_train: np.ndarray, y_train: np.ndarray,
                                 X_val: np.ndarray, y_val: np.ndarray,
                                 window: int, d_model: int = 128, num_layers: int = 3,
                                 epochs: int = 10, batch_size: int = 64) -> dict:
    """Train Transformer multi-output regressor."""
    import torch
    import torch.nn as nn
    from torch.utils.data import TensorDataset, DataLoader

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    print(f"  Using device: {device}")

    # Create windows from flat sequences
    def create_windows(X, y, window):
        n_samples = X.shape[0] - window + 1
        X_windows = np.array([X[i:i+window] for i in range(n_samples)])
        y_windows = y[window-1:]  # Align targets with windows
        return X_windows, y_windows

    X_train_w, y_train_w = create_windows(X_train, y_train, window)
    X_val_w, y_val_w = create_windows(X_val, y_val, window)

    # Model definition
    class TransformerRegressor(nn.Module):
        def __init__(self, d_in, d_model, num_layers, n_outputs=2):
            super().__init__()
            self.proj = nn.Linear(d_in, d_model)
            enc_layer = nn.TransformerEncoderLayer(
                d_model=d_model,
                nhead=4,
                dim_feedforward=d_model*4,
                dropout=0.1,
                batch_first=True,
            )
            self.enc = nn.TransformerEncoder(enc_layer, num_layers=num_layers)
            self.pool = nn.AdaptiveAvgPool1d(1)
            self.head = nn.Linear(d_model, n_outputs)  # Regression: output 2 values

        def forward(self, x):
            x = self.proj(x)
            h = self.enc(x)
            h = h.transpose(1, 2)
            h = self.pool(h).squeeze(-1)
            return self.head(h)

    model = TransformerRegressor(d_in=X_train_w.shape[-1], d_model=d_model, num_layers=num_layers).to(device)

    # Training
    criterion = nn.MSELoss()
    optimizer = torch.optim.Adam(model.parameters(), lr=1e-3)

    train_dataset = TensorDataset(torch.from_numpy(X_train_w).float(), torch.from_numpy(y_train_w).float())
    train_loader = DataLoader(train_dataset, batch_size=batch_size, shuffle=True)

    print(f"  Training Transformer regressor ({epochs} epochs)...")
    model.train()
    for epoch in range(epochs):
        total_loss = 0
        for X_batch, y_batch in train_loader:
            X_batch, y_batch = X_batch.to(device), y_batch.to(device)
            optimizer.zero_grad()
            y_pred = model(X_batch)
            loss = criterion(y_pred, y_batch)
            loss.backward()
            optimizer.step()
            total_loss += loss.item()

        if (epoch + 1) % max(1, epochs // 5) == 0:
            print(f"    Epoch {epoch+1}/{epochs}, Loss: {total_loss/len(train_loader):.4f}")

    # Evaluate
    model.eval()
    with torch.no_grad():
        X_val_t = torch.from_numpy(X_val_w).float().to(device)
        y_pred = model(X_val_t).cpu().numpy()

    steer_mae = float(np.mean(np.abs(y_val_w[:, 0] - y_pred[:, 0])))
    speed_mae = float(np.mean(np.abs(y_val_w[:, 1] - y_pred[:, 1])))
    steer_rmse = float(np.sqrt(np.mean((y_val_w[:, 0] - y_pred[:, 0])**2)))
    speed_rmse = float(np.sqrt(np.mean((y_val_w[:, 1] - y_pred[:, 1])**2)))

    metrics = {
        'steer_mae': steer_mae,
        'steer_rmse': steer_rmse,
        'speed_mae': speed_mae,
        'speed_rmse': speed_rmse,
        'n_val': len(y_val_w),
    }

    print(f"    Steer MAE: {steer_mae:.3f}°, RMSE: {steer_rmse:.3f}°")
    print(f"    Speed MAE: {speed_mae:.3f} km/h, RMSE: {speed_rmse:.3f} km/h")

    return {'model': model.cpu(), 'metrics': metrics, 'window': window}


def train_gru_lstm_regressor(X_train: np.ndarray, y_train: np.ndarray,
                              X_val: np.ndarray, y_val: np.ndarray,
                              window: int, use_gru: bool = True, hidden_size: int = 128,
                              num_layers: int = 2, epochs: int = 10, batch_size: int = 64) -> dict:
    """Train GRU/LSTM multi-output regressor."""
    import torch
    import torch.nn as nn
    from torch.utils.data import TensorDataset, DataLoader

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    print(f"  Using device: {device}")

    # Create windows
    def create_windows(X, y, window):
        n_samples = X.shape[0] - window + 1
        X_windows = np.array([X[i:i+window] for i in range(n_samples)])
        y_windows = y[window-1:]
        return X_windows, y_windows

    X_train_w, y_train_w = create_windows(X_train, y_train, window)
    X_val_w, y_val_w = create_windows(X_val, y_val, window)

    # Model definition
    class RNNRegressor(nn.Module):
        def __init__(self, d_in, hidden_size, num_layers, use_gru=True, n_outputs=2):
            super().__init__()
            if use_gru:
                self.rnn = nn.GRU(d_in, hidden_size, num_layers, batch_first=True, dropout=0.1 if num_layers > 1 else 0.0)
            else:
                self.rnn = nn.LSTM(d_in, hidden_size, num_layers, batch_first=True, dropout=0.1 if num_layers > 1 else 0.0)
            self.head = nn.Linear(hidden_size, n_outputs)
            self.use_gru = use_gru

        def forward(self, x):
            if self.use_gru:
                out, h = self.rnn(x)
            else:
                out, (h, c) = self.rnn(x)
            last_out = out[:, -1, :]
            return self.head(last_out)

    model = RNNRegressor(d_in=X_train_w.shape[-1], hidden_size=hidden_size, num_layers=num_layers, use_gru=use_gru).to(device)

    # Training
    criterion = nn.MSELoss()
    optimizer = torch.optim.Adam(model.parameters(), lr=1e-3)

    train_dataset = TensorDataset(torch.from_numpy(X_train_w).float(), torch.from_numpy(y_train_w).float())
    train_loader = DataLoader(train_dataset, batch_size=batch_size, shuffle=True)

    model_name = "GRU" if use_gru else "LSTM"
    print(f"  Training {model_name} regressor ({epochs} epochs)...")
    model.train()
    for epoch in range(epochs):
        total_loss = 0
        for X_batch, y_batch in train_loader:
            X_batch, y_batch = X_batch.to(device), y_batch.to(device)
            optimizer.zero_grad()
            y_pred = model(X_batch)
            loss = criterion(y_pred, y_batch)
            loss.backward()
            optimizer.step()
            total_loss += loss.item()

        if (epoch + 1) % max(1, epochs // 5) == 0:
            print(f"    Epoch {epoch+1}/{epochs}, Loss: {total_loss/len(train_loader):.4f}")

    # Evaluate
    model.eval()
    with torch.no_grad():
        X_val_t = torch.from_numpy(X_val_w).float().to(device)
        y_pred = model(X_val_t).cpu().numpy()

    steer_mae = float(np.mean(np.abs(y_val_w[:, 0] - y_pred[:, 0])))
    speed_mae = float(np.mean(np.abs(y_val_w[:, 1] - y_pred[:, 1])))
    steer_rmse = float(np.sqrt(np.mean((y_val_w[:, 0] - y_pred[:, 0])**2)))
    speed_rmse = float(np.sqrt(np.mean((y_val_w[:, 1] - y_pred[:, 1])**2)))

    metrics = {
        'steer_mae': steer_mae,
        'steer_rmse': steer_rmse,
        'speed_mae': speed_mae,
        'speed_rmse': speed_rmse,
        'n_val': len(y_val_w),
    }

    print(f"    Steer MAE: {steer_mae:.3f}°, RMSE: {steer_rmse:.3f}°")
    print(f"    Speed MAE: {speed_mae:.3f} km/h, RMSE: {speed_rmse:.3f} km/h")

    return {'model': model.cpu(), 'metrics': metrics, 'window': window}


def train_tcn_regressor(X_train: np.ndarray, y_train: np.ndarray,
                        X_val: np.ndarray, y_val: np.ndarray,
                        window: int, num_channels: list = None, epochs: int = 10, batch_size: int = 64) -> dict:
    """Train TCN multi-output regressor."""
    import torch
    import torch.nn as nn
    from torch.utils.data import TensorDataset, DataLoader

    if num_channels is None:
        num_channels = [128, 128, 128]

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    print(f"  Using device: {device}")

    # Create windows
    def create_windows(X, y, window):
        n_samples = X.shape[0] - window + 1
        X_windows = np.array([X[i:i+window] for i in range(n_samples)])
        y_windows = y[window-1:]
        return X_windows, y_windows

    X_train_w, y_train_w = create_windows(X_train, y_train, window)
    X_val_w, y_val_w = create_windows(X_val, y_val, window)

    # TCN blocks
    class TemporalBlock(nn.Module):
        def __init__(self, n_inputs, n_outputs, kernel_size, dilation, dropout=0.1):
            super().__init__()
            padding = (kernel_size - 1) * dilation
            self.conv1 = nn.Conv1d(n_inputs, n_outputs, kernel_size, padding=padding, dilation=dilation)
            self.relu1 = nn.ReLU()
            self.dropout1 = nn.Dropout(dropout)
            self.conv2 = nn.Conv1d(n_outputs, n_outputs, kernel_size, padding=padding, dilation=dilation)
            self.relu2 = nn.ReLU()
            self.dropout2 = nn.Dropout(dropout)
            self.downsample = nn.Conv1d(n_inputs, n_outputs, 1) if n_inputs != n_outputs else None
            self.relu = nn.ReLU()

        def forward(self, x):
            out = self.conv1(x)
            out = out[:, :, :x.shape[2]]
            out = self.relu1(out)
            out = self.dropout1(out)
            out = self.conv2(out)
            out = out[:, :, :x.shape[2]]
            out = self.relu2(out)
            out = self.dropout2(out)
            res = x if self.downsample is None else self.downsample(x)
            return self.relu(out + res)

    class TCNRegressor(nn.Module):
        def __init__(self, d_in, num_channels, kernel_size=3, dropout=0.1, n_outputs=2):
            super().__init__()
            layers = []
            for i in range(len(num_channels)):
                dilation = 2 ** i
                in_ch = d_in if i == 0 else num_channels[i - 1]
                out_ch = num_channels[i]
                layers.append(TemporalBlock(in_ch, out_ch, kernel_size, dilation, dropout))
            self.network = nn.Sequential(*layers)
            self.head = nn.Linear(num_channels[-1], n_outputs)

        def forward(self, x):
            x = x.transpose(1, 2)
            out = self.network(x)
            out = out.mean(dim=2)
            return self.head(out)

    model = TCNRegressor(d_in=X_train_w.shape[-1], num_channels=num_channels).to(device)

    # Training
    criterion = nn.MSELoss()
    optimizer = torch.optim.Adam(model.parameters(), lr=1e-3)

    train_dataset = TensorDataset(torch.from_numpy(X_train_w).float(), torch.from_numpy(y_train_w).float())
    train_loader = DataLoader(train_dataset, batch_size=batch_size, shuffle=True)

    print(f"  Training TCN regressor ({epochs} epochs)...")
    model.train()
    for epoch in range(epochs):
        total_loss = 0
        for X_batch, y_batch in train_loader:
            X_batch, y_batch = X_batch.to(device), y_batch.to(device)
            optimizer.zero_grad()
            y_pred = model(X_batch)
            loss = criterion(y_pred, y_batch)
            loss.backward()
            optimizer.step()
            total_loss += loss.item()

        if (epoch + 1) % max(1, epochs // 5) == 0:
            print(f"    Epoch {epoch+1}/{epochs}, Loss: {total_loss/len(train_loader):.4f}")

    # Evaluate
    model.eval()
    with torch.no_grad():
        X_val_t = torch.from_numpy(X_val_w).float().to(device)
        y_pred = model(X_val_t).cpu().numpy()

    steer_mae = float(np.mean(np.abs(y_val_w[:, 0] - y_pred[:, 0])))
    speed_mae = float(np.mean(np.abs(y_val_w[:, 1] - y_pred[:, 1])))
    steer_rmse = float(np.sqrt(np.mean((y_val_w[:, 0] - y_pred[:, 0])**2)))
    speed_rmse = float(np.sqrt(np.mean((y_val_w[:, 1] - y_pred[:, 1])**2)))

    metrics = {
        'steer_mae': steer_mae,
        'steer_rmse': steer_rmse,
        'speed_mae': speed_mae,
        'speed_rmse': speed_rmse,
        'n_val': len(y_val_w),
    }

    print(f"    Steer MAE: {steer_mae:.3f}°, RMSE: {steer_rmse:.3f}°")
    print(f"    Speed MAE: {speed_mae:.3f} km/h, RMSE: {speed_rmse:.3f} km/h")

    return {'model': model.cpu(), 'metrics': metrics, 'window': window}


def train_mlp_pooling_regressor(X_train: np.ndarray, y_train: np.ndarray,
                                 X_val: np.ndarray, y_val: np.ndarray,
                                 window: int, pooling_type: str = 'mean',
                                 hidden_size: int = 128, epochs: int = 10, batch_size: int = 64) -> dict:
    """Train MLP with pooling multi-output regressor."""
    import torch
    import torch.nn as nn
    from torch.utils.data import TensorDataset, DataLoader

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    print(f"  Using device: {device}")

    # Create windows
    def create_windows(X, y, window):
        n_samples = X.shape[0] - window + 1
        X_windows = np.array([X[i:i+window] for i in range(n_samples)])
        y_windows = y[window-1:]
        return X_windows, y_windows

    X_train_w, y_train_w = create_windows(X_train, y_train, window)
    X_val_w, y_val_w = create_windows(X_val, y_val, window)

    # Model definition
    class MLPPoolingRegressor(nn.Module):
        def __init__(self, d_in, pooling_type, hidden_size, n_outputs=2):
            super().__init__()
            self.pooling_type = pooling_type

            if pooling_type in ["mean", "max"]:
                pooled_dim = d_in
            elif pooling_type == "concat":
                pooled_dim = d_in * 4
            else:
                raise ValueError(f"Unknown pooling_type: {pooling_type}")

            self.mlp = nn.Sequential(
                nn.Linear(pooled_dim, hidden_size * 2),
                nn.ReLU(),
                nn.Dropout(0.1),
                nn.Linear(hidden_size * 2, hidden_size),
                nn.ReLU(),
                nn.Dropout(0.1),
            )
            self.head = nn.Linear(hidden_size, n_outputs)

        def forward(self, x):
            if self.pooling_type == "mean":
                pooled = x.mean(dim=1)
            elif self.pooling_type == "max":
                pooled = x.max(dim=1)[0]
            elif self.pooling_type == "concat":
                mean_pool = x.mean(dim=1)
                max_pool = x.max(dim=1)[0]
                first = x[:, 0, :]
                last = x[:, -1, :]
                pooled = torch.cat([mean_pool, max_pool, first, last], dim=1)

            h = self.mlp(pooled)
            return self.head(h)

    model = MLPPoolingRegressor(d_in=X_train_w.shape[-1], pooling_type=pooling_type, hidden_size=hidden_size).to(device)

    # Training
    criterion = nn.MSELoss()
    optimizer = torch.optim.Adam(model.parameters(), lr=1e-3)

    train_dataset = TensorDataset(torch.from_numpy(X_train_w).float(), torch.from_numpy(y_train_w).float())
    train_loader = DataLoader(train_dataset, batch_size=batch_size, shuffle=True)

    print(f"  Training MLP-{pooling_type.upper()} regressor ({epochs} epochs)...")
    model.train()
    for epoch in range(epochs):
        total_loss = 0
        for X_batch, y_batch in train_loader:
            X_batch, y_batch = X_batch.to(device), y_batch.to(device)
            optimizer.zero_grad()
            y_pred = model(X_batch)
            loss = criterion(y_pred, y_batch)
            loss.backward()
            optimizer.step()
            total_loss += loss.item()

        if (epoch + 1) % max(1, epochs // 5) == 0:
            print(f"    Epoch {epoch+1}/{epochs}, Loss: {total_loss/len(train_loader):.4f}")

    # Evaluate
    model.eval()
    with torch.no_grad():
        X_val_t = torch.from_numpy(X_val_w).float().to(device)
        y_pred = model(X_val_t).cpu().numpy()

    steer_mae = float(np.mean(np.abs(y_val_w[:, 0] - y_pred[:, 0])))
    speed_mae = float(np.mean(np.abs(y_val_w[:, 1] - y_pred[:, 1])))
    steer_rmse = float(np.sqrt(np.mean((y_val_w[:, 0] - y_pred[:, 0])**2)))
    speed_rmse = float(np.sqrt(np.mean((y_val_w[:, 1] - y_pred[:, 1])**2)))

    metrics = {
        'steer_mae': steer_mae,
        'steer_rmse': steer_rmse,
        'speed_mae': speed_mae,
        'speed_rmse': speed_rmse,
        'n_val': len(y_val_w),
    }

    print(f"    Steer MAE: {steer_mae:.3f}°, RMSE: {steer_rmse:.3f}°")
    print(f"    Speed MAE: {speed_mae:.3f} km/h, RMSE: {speed_rmse:.3f} km/h")

    return {'model': model.cpu(), 'metrics': metrics, 'window': window}


def main():
    parser = argparse.ArgumentParser(
        description="Train regression model for direct control prediction"
    )
    parser.add_argument(
        "--manifest",
        type=Path,
        required=True,
        help="Training manifest",
    )
    parser.add_argument(
        "--test-manifest",
        type=Path,
        required=True,
        help="Test manifest",
    )
    parser.add_argument(
        "--outdir",
        type=Path,
        required=True,
        help="Output directory for model",
    )
    parser.add_argument(
        "--model",
        choices=['transformer', 'xgboost', 'lightgbm', 'gru', 'lstm', 'tcn', 'random_forest', 'mlp_mean', 'mlp_max', 'mlp_concat', 'baseline'],
        default='xgboost',
        help="Model type (default: xgboost)",
    )
    parser.add_argument(
        "--sample-hz",
        type=float,
        default=3.0,
        help="Sampling frequency (default: 3.0 Hz)",
    )
    parser.add_argument(
        "--window-seconds",
        type=float,
        default=10.0,
        help="Window size in seconds (default: 10.0)",
    )
    parser.add_argument(
        "--max-sessions",
        type=int,
        default=None,
        help="Limit sessions for testing",
    )

    args = parser.parse_args()

    # Load manifests
    print(f"Loading training manifest from {args.manifest}...")
    train_records = load_manifest(args.manifest)
    print(f"  Found {len(train_records)} training sessions")

    print(f"Loading test manifest from {args.test_manifest}...")
    test_records = load_manifest(args.test_manifest)
    print(f"  Found {len(test_records)} test sessions")

    if args.max_sessions:
        train_records = train_records[:args.max_sessions]
        test_records = test_records[:min(args.max_sessions//2, len(test_records))]
        print(f"  Limited to {len(train_records)} train, {len(test_records)} test")

    # Load training data
    print(f"\nLoading training data...")
    X_train_list, y_train_list = [], []

    for record in tqdm(train_records, desc="Train sessions"):
        try:
            X, y = load_session_data(record, args.sample_hz, args.window_seconds)
            X_train_list.append(X)
            y_train_list.append(y)
        except Exception as e:
            print(f"\n  [Warning] Failed to load {record.session_id}: {e}")
            continue

    # Load test data
    print(f"Loading test data...")
    X_test_list, y_test_list = [], []

    for record in tqdm(test_records, desc="Test sessions"):
        try:
            X, y = load_session_data(record, args.sample_hz, args.window_seconds)
            X_test_list.append(X)
            y_test_list.append(y)
        except Exception as e:
            print(f"\n  [Warning] Failed to load {record.session_id}: {e}")
            continue

    # Concatenate
    X_train = np.vstack(X_train_list)
    y_train = np.vstack(y_train_list)
    X_test = np.vstack(X_test_list)
    y_test = np.vstack(y_test_list)

    print(f"\nData shapes:")
    print(f"  X_train: {X_train.shape}, y_train: {y_train.shape}")
    print(f"  X_test:  {X_test.shape}, y_test:  {y_test.shape}")

    # Build windowed features
    window = int(np.ceil(args.window_seconds * args.sample_hz))
    print(f"\nBuilding windowed features (window={window})...")

    X_train_feat = build_windowed_features(X_train, window)
    y_train_feat = y_train[window-1:]  # Align targets with windows

    X_test_feat = build_windowed_features(X_test, window)
    y_test_feat = y_test[window-1:]

    print(f"  X_train_feat: {X_train_feat.shape}")
    print(f"  X_test_feat:  {X_test_feat.shape}")

    # Train model
    print(f"\nTraining {args.model} regressor...")
    if args.model == 'xgboost':
        result = train_xgboost_regressor(X_train_feat, y_train_feat, X_test_feat, y_test_feat)
    elif args.model == 'random_forest':
        result = train_random_forest_regressor(X_train_feat, y_train_feat, X_test_feat, y_test_feat)
    elif args.model == 'lightgbm':
        result = train_lightgbm_regressor(X_train_feat, y_train_feat, X_test_feat, y_test_feat)
    elif args.model == 'transformer':
        result = train_transformer_regressor(X_train, y_train, X_test, y_test, window, d_model=128, num_layers=3, epochs=10)
    elif args.model == 'gru':
        result = train_gru_lstm_regressor(X_train, y_train, X_test, y_test, window, use_gru=True, hidden_size=128, num_layers=2, epochs=10)
    elif args.model == 'lstm':
        result = train_gru_lstm_regressor(X_train, y_train, X_test, y_test, window, use_gru=False, hidden_size=128, num_layers=2, epochs=10)
    elif args.model == 'tcn':
        result = train_tcn_regressor(X_train, y_train, X_test, y_test, window, num_channels=[128, 128, 128], epochs=10)
    elif args.model == 'mlp_mean':
        result = train_mlp_pooling_regressor(X_train, y_train, X_test, y_test, window, pooling_type='mean', hidden_size=128, epochs=10)
    elif args.model == 'mlp_max':
        result = train_mlp_pooling_regressor(X_train, y_train, X_test, y_test, window, pooling_type='max', hidden_size=128, epochs=10)
    elif args.model == 'mlp_concat':
        result = train_mlp_pooling_regressor(X_train, y_train, X_test, y_test, window, pooling_type='concat', hidden_size=128, epochs=10)
    elif args.model == 'baseline':
        # Auto-fallback: Try XGBoost first, then Random Forest
        try:
            result = train_xgboost_regressor(X_train_feat, y_train_feat, X_test_feat, y_test_feat)
        except Exception:
            result = train_random_forest_regressor(X_train_feat, y_train_feat, X_test_feat, y_test_feat)
    else:
        raise ValueError(f"Unknown model: {args.model}")

    model = result['model']
    metrics = result['metrics']

    # Save model
    args.outdir.mkdir(parents=True, exist_ok=True)

    # Neural models: Save as .pt
    if args.model in ['transformer', 'gru', 'lstm', 'tcn', 'mlp_mean', 'mlp_max', 'mlp_concat']:
        import torch
        model_path = args.outdir / f'{args.model}_regressor.pt'
        torch.save(model, model_path)
        print(f"\nModel saved to {model_path}")
    # Tree-based models: Save as .joblib
    else:
        import joblib
        model_path = args.outdir / f'{args.model}_regressor.joblib'
        joblib.dump(model, model_path)
        print(f"\nModel saved to {model_path}")

    # Save config
    config = {
        'model_type': args.model,
        'sample_hz': args.sample_hz,
        'window_seconds': args.window_seconds,
        'window_steps': window,
        'feature_names': ['steer_angle', 'steer_speed', 'lturn', 'rturn'],
        'target_names': ['steer_angle', 'speed'],
        'n_train_samples': len(X_train_feat),
        'n_test_samples': len(X_test_feat),
    }

    config_path = args.outdir / 'config.json'
    with open(config_path, 'w') as f:
        json.dump(config, f, indent=2)

    # Save metrics
    metrics_path = args.outdir / 'test_metrics.json'
    with open(metrics_path, 'w') as f:
        json.dump(metrics, f, indent=2)

    # Save model kind
    kind_path = args.outdir / 'model_kind.txt'
    kind_path.write_text(f'{args.model}_regressor', encoding='utf-8')

    print(f"\n{'='*80}")
    print(f"Training complete!")
    print(f"{'='*80}")
    print(f"  Model:   {model_path}")
    print(f"  Config:  {config_path}")
    print(f"  Metrics: {metrics_path}")
    print(f"\nTest Performance:")
    print(f"  Steering Angle - MAE: {metrics['steer_mae']:.3f}°, RMSE: {metrics['steer_rmse']:.3f}°")
    print(f"  Speed          - MAE: {metrics['speed_mae']:.3f} km/h, RMSE: {metrics['speed_rmse']:.3f} km/h")
    print(f"\nNext steps:")
    print(f"  1. Generate predictions using this regressor:")
    print(f"     python examples/generate_control_predictions.py \\")
    print(f"       --model-dir {args.outdir} \\")
    print(f"       --manifest ./artifacts/manifest_test.jsonl \\")
    print(f"       --output-dir ./control_predicted_sensors \\")
    print(f"       --sample-hz {args.sample_hz}")
    print(f"{'='*80}\n")


if __name__ == "__main__":
    main()
