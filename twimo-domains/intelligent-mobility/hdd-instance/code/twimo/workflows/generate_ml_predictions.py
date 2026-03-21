#!/usr/bin/env python
"""Generate ML predictions as HDD-compatible CSV sensors for DT validation.

This script takes a trained ML model and generates predictions that are formatted
as HDD sensor CSV files, allowing the Digital Twin to simulate trajectories using
ML predictions instead of real sensors.

Supported models:
    - Neural models: transformer, gru, lstm, tcn, mlp_mean, mlp_max, mlp_concat
    - Tree-based models: xgboost, lightgbm, random_forest, baseline

Usage:
    # With Transformer model
    python examples/generate_ml_predictions.py \\
      --model-dir ./artifacts/maneuver_transformer \\
      --manifest ./artifacts/manifest_test.jsonl \\
      --output-dir ./ml_predicted_sensors \\
      --sample-hz 3

    # With XGBoost model
    python examples/generate_ml_predictions.py \\
      --model-dir ./artifacts/maneuver_xgboost \\
      --manifest ./artifacts/manifest_test.jsonl \\
      --output-dir ./ml_predicted_sensors_xgb \\
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json

from pathlib import Path
import sys
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

from typing import Dict, List

import numpy as np
import pandas as pd
from tqdm import tqdm

from twimo.data.manifest import load_manifest, write_manifest, SessionRecord
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid


def load_ml_model(model_dir: Path):
    """Load trained ML model.

    Supports: transformer, gru, lstm, tcn, mlp_mean, mlp_max, mlp_concat, xgboost, random_forest, lightgbm, baseline
    """
    import torch
    import torch.nn as nn

    # Load config
    config_path = model_dir / 'config.json'
    with open(config_path) as f:
        config_dict = json.load(f)

    # Load model kind
    model_kind_path = model_dir / 'model_kind.txt'
    if model_kind_path.exists():
        model_kind = model_kind_path.read_text(encoding='utf-8').strip()
    else:
        model_kind = 'transformer'  # Fallback

    # Tree-based models: Load from .joblib
    if model_kind in ['xgboost', 'lightgbm', 'random_forest', 'baseline']:
        import joblib

        checkpoint_path = model_dir / f'{model_kind}.joblib'
        if not checkpoint_path.exists():
            checkpoint_path = model_dir / 'model.joblib'  # Fallback

        checkpoint = joblib.load(checkpoint_path)

        # Extract steps_list from cfg_dict (tree-based models store config this way)
        if 'steps_list' in checkpoint:
            steps_list = checkpoint['steps_list']
        elif 'cfg_dict' in checkpoint:
            from twimo.models.maneuver_transformer import horizon_steps, ManeuverConfig
            cfg = ManeuverConfig(**checkpoint['cfg_dict'])
            steps_list = horizon_steps(cfg)
        else:
            # Fallback: infer from models dict keys
            steps_list = sorted(checkpoint['models'].keys())

        config_dict['steps_list'] = steps_list
        config_dict['n_classes'] = checkpoint['n_classes']
        config_dict['model_kind'] = model_kind
        config_dict['models'] = checkpoint['models']  # Dict of {steps: model}

        return checkpoint, config_dict

    # Neural models: Load from .pt
    elif model_kind == 'transformer':
        checkpoint = torch.load(model_dir / 'maneuver_transformer.pt', map_location='cpu')

        # Reconstruct ManeuverConfig
        from twimo.models.maneuver_transformer import ManeuverConfig
        from dataclasses import fields

        # Filter config_dict to only include ManeuverConfig fields
        cfg_fields = {f.name for f in fields(ManeuverConfig)}
        filtered_cfg = {k: v for k, v in config_dict.items() if k in cfg_fields}
        cfg = ManeuverConfig(**filtered_cfg)

        # Reconstruct model (nested class)
        steps_list = checkpoint['steps']
        n_classes = checkpoint['n_classes']

        class Model(nn.Module):
            def __init__(self, d_in: int):
                super().__init__()
                self.proj = nn.Linear(d_in, cfg.d_model)
                enc_layer = nn.TransformerEncoderLayer(
                    d_model=cfg.d_model,
                    nhead=cfg.nhead,
                    dim_feedforward=cfg.d_model*4,
                    dropout=cfg.dropout,
                    batch_first=True,
                )
                self.enc = nn.TransformerEncoder(enc_layer, num_layers=cfg.num_layers)
                self.pool = nn.AdaptiveAvgPool1d(1)
                self.heads = nn.ModuleList([nn.Linear(cfg.d_model, n_classes) for _ in steps_list])

            def forward(self, x):
                x = self.proj(x)
                h = self.enc(x)
                h = h.transpose(1, 2)
                h = self.pool(h).squeeze(-1)
                return [head(h) for head in self.heads]

        # Get d_in from state_dict (proj.weight shape)
        d_in = checkpoint['state_dict']['proj.weight'].shape[1]
        model = Model(d_in=d_in)
        model.load_state_dict(checkpoint['state_dict'])
        model.eval()

        config_dict['steps_list'] = steps_list
        config_dict['n_classes'] = n_classes
        config_dict['model_kind'] = model_kind

    elif model_kind in ['gru', 'lstm']:
        checkpoint = torch.load(model_dir / f'{model_kind}.pt', map_location='cpu')

        # Reconstruct ManeuverConfig
        from twimo.models.maneuver_transformer import ManeuverConfig
        from dataclasses import fields

        cfg_fields = {f.name for f in fields(ManeuverConfig)}
        filtered_cfg = {k: v for k, v in config_dict.items() if k in cfg_fields}
        cfg = ManeuverConfig(**filtered_cfg)

        steps_list = checkpoint['steps']
        n_classes = checkpoint['n_classes']
        use_gru = (model_kind == 'gru')

        class Model(nn.Module):
            def __init__(self, d_in: int, hidden_size: int, num_layers: int, use_gru: bool):
                super().__init__()
                self.use_gru = use_gru
                if use_gru:
                    self.rnn = nn.GRU(
                        input_size=d_in,
                        hidden_size=hidden_size,
                        num_layers=num_layers,
                        batch_first=True,
                        dropout=cfg.dropout if num_layers > 1 else 0.0,
                        bidirectional=False,
                    )
                else:
                    self.rnn = nn.LSTM(
                        input_size=d_in,
                        hidden_size=hidden_size,
                        num_layers=num_layers,
                        batch_first=True,
                        dropout=cfg.dropout if num_layers > 1 else 0.0,
                        bidirectional=False,
                    )
                self.heads = nn.ModuleList([nn.Linear(hidden_size, n_classes) for _ in steps_list])

            def forward(self, x):
                if self.use_gru:
                    out, h = self.rnn(x)
                else:
                    out, (h, c) = self.rnn(x)
                last_out = out[:, -1, :]
                return [head(last_out) for head in self.heads]

        # Get d_in from state_dict
        if use_gru:
            d_in = checkpoint['state_dict']['rnn.weight_ih_l0'].shape[1]
        else:
            d_in = checkpoint['state_dict']['rnn.weight_ih_l0'].shape[1]

        hidden_size = cfg.d_model
        num_layers = cfg.num_layers

        model = Model(d_in=d_in, hidden_size=hidden_size, num_layers=num_layers, use_gru=use_gru)
        model.load_state_dict(checkpoint['state_dict'])
        model.eval()

        config_dict['steps_list'] = steps_list
        config_dict['n_classes'] = n_classes
        config_dict['model_kind'] = model_kind

    elif model_kind == 'tcn':
        checkpoint = torch.load(model_dir / 'tcn.pt', map_location='cpu')

        from twimo.models.maneuver_transformer import ManeuverConfig
        from dataclasses import fields

        cfg_fields = {f.name for f in fields(ManeuverConfig)}
        filtered_cfg = {k: v for k, v in config_dict.items() if k in cfg_fields}
        cfg = ManeuverConfig(**filtered_cfg)

        steps_list = checkpoint['steps']
        n_classes = checkpoint['n_classes']

        # TCN blocks (copied from tcn_model.py)
        class TemporalBlock(nn.Module):
            def __init__(self, n_inputs, n_outputs, kernel_size, dilation, dropout=0.1):
                super().__init__()
                padding = (kernel_size - 1) * dilation
                self.conv1 = nn.Conv1d(n_inputs, n_outputs, kernel_size,
                                       padding=padding, dilation=dilation)
                self.chomp1 = nn.ConstantPad1d((0, -padding), 0.0)
                self.relu1 = nn.ReLU()
                self.dropout1 = nn.Dropout(dropout)

                self.conv2 = nn.Conv1d(n_outputs, n_outputs, kernel_size,
                                       padding=padding, dilation=dilation)
                self.chomp2 = nn.ConstantPad1d((0, -padding), 0.0)
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

        class TCNModel(nn.Module):
            def __init__(self, d_in: int, num_channels: List[int], kernel_size: int = 3, dropout: float = 0.1):
                super().__init__()
                layers = []
                num_levels = len(num_channels)
                for i in range(num_levels):
                    dilation = 2 ** i
                    in_ch = d_in if i == 0 else num_channels[i - 1]
                    out_ch = num_channels[i]
                    layers.append(TemporalBlock(in_ch, out_ch, kernel_size, dilation, dropout))

                self.network = nn.Sequential(*layers)
                self.heads = nn.ModuleList([nn.Linear(num_channels[-1], n_classes) for _ in steps_list])

            def forward(self, x):
                x = x.transpose(1, 2)
                out = self.network(x)
                out = out.mean(dim=2)
                return [head(out) for head in self.heads]

        # Get d_in from state_dict
        d_in = checkpoint['state_dict']['network.0.conv1.weight'].shape[1]
        num_channels = [cfg.d_model] * cfg.num_layers

        model = TCNModel(d_in=d_in, num_channels=num_channels, kernel_size=3, dropout=cfg.dropout)
        model.load_state_dict(checkpoint['state_dict'])
        model.eval()

        config_dict['steps_list'] = steps_list
        config_dict['n_classes'] = n_classes
        config_dict['model_kind'] = model_kind

    elif model_kind in ['mlp_mean', 'mlp_max', 'mlp_concat']:
        pooling_type = model_kind.split('_')[1]  # Extract 'mean', 'max', or 'concat'
        checkpoint = torch.load(model_dir / f'{model_kind}.pt', map_location='cpu')

        from twimo.models.maneuver_transformer import ManeuverConfig
        from dataclasses import fields

        cfg_fields = {f.name for f in fields(ManeuverConfig)}
        filtered_cfg = {k: v for k, v in config_dict.items() if k in cfg_fields}
        cfg = ManeuverConfig(**filtered_cfg)

        steps_list = checkpoint['steps']
        n_classes = checkpoint['n_classes']

        class MLPPoolingModel(nn.Module):
            def __init__(self, d_in: int, pooling_type: str):
                super().__init__()
                self.pooling_type = pooling_type

                if pooling_type == "mean" or pooling_type == "max":
                    pooled_dim = d_in
                elif pooling_type == "concat":
                    pooled_dim = d_in * 4
                else:
                    raise ValueError(f"Unknown pooling_type: {pooling_type}")

                self.mlp = nn.Sequential(
                    nn.Linear(pooled_dim, cfg.d_model * 2),
                    nn.ReLU(),
                    nn.Dropout(cfg.dropout),
                    nn.Linear(cfg.d_model * 2, cfg.d_model),
                    nn.ReLU(),
                    nn.Dropout(cfg.dropout),
                )

                self.heads = nn.ModuleList([nn.Linear(cfg.d_model, n_classes) for _ in steps_list])

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
                return [head(h) for head in self.heads]

        # Get d_in from state_dict
        if pooling_type == "concat":
            d_in = checkpoint['state_dict']['mlp.0.weight'].shape[1] // 4
        else:
            d_in = checkpoint['state_dict']['mlp.0.weight'].shape[1]

        model = MLPPoolingModel(d_in=d_in, pooling_type=pooling_type)
        model.load_state_dict(checkpoint['state_dict'])
        model.eval()

        config_dict['steps_list'] = steps_list
        config_dict['n_classes'] = n_classes
        config_dict['model_kind'] = model_kind

    else:
        raise NotImplementedError(f"Model kind '{model_kind}' not yet supported for ML prediction generation.")

    return model, config_dict


def predict_maneuvers(model, sensors: np.ndarray, config: Dict) -> np.ndarray:
    """Predict maneuvers using ML model.

    Args:
        model: Trained ML model (neural or tree-based)
        sensors: Sensor array (T, D)
        config: Model config

    Returns:
        predictions: Predicted maneuver labels (T,) - one per timestep
    """
    import torch
    from twimo.models.maneuver_transformer import make_windows

    # Get window parameters from config
    window_seconds = config.get('window_seconds', 10.0)
    sample_hz = config.get('sample_hz', 3.0)
    window = int(np.ceil(window_seconds * sample_hz))
    steps_list = config.get('steps_list', [1])
    model_kind = config.get('model_kind', 'transformer')

    # Create dummy labels (not used for prediction)
    dummy_labels = np.zeros(len(sensors), dtype=np.int64)

    # Use first horizon (1-step ahead) for predictions
    steps = steps_list[0]

    # Tree-based models: Use window statistics features
    if model_kind in ['xgboost', 'lightgbm', 'random_forest', 'baseline']:
        from twimo.models.xgboost_model import _window_stats_features

        # Get the model for the first horizon
        horizon_model = config['models'][int(steps)]

        # Create sliding windows
        Xw, _ = make_windows(sensors, dummy_labels, steps_ahead=steps, window=window)

        # Convert windows to feature vectors
        X_feat = np.stack([_window_stats_features(W) for W in Xw], axis=0).astype(np.float32)

        # Predict
        predictions_windowed = horizon_model.predict(X_feat)

    # Neural models: Use sliding windows directly
    else:
        # Create sliding windows
        Xw, _ = make_windows(sensors, dummy_labels, steps_ahead=steps, window=window)

        # Batch prediction
        device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        model = model.to(device)

        X_tensor = torch.from_numpy(Xw).float().to(device)

        with torch.no_grad():
            # Predict in batches to avoid memory issues
            batch_size = 64
            all_preds = []

            for i in range(0, len(X_tensor), batch_size):
                batch = X_tensor[i:i+batch_size]
                logits_list = model(batch)  # List of (batch, n_classes) per horizon

                # Use first horizon predictions
                logits = logits_list[0]  # (batch, n_classes)
                preds = torch.argmax(logits, dim=-1).cpu().numpy()
                all_preds.append(preds)

        predictions_windowed = np.concatenate(all_preds)

    # Expand predictions to match original timeline
    # Windows cover indices [steps:steps+window] for each prediction
    # We'll use the last valid prediction for each timestep
    predictions_full = np.zeros(len(sensors), dtype=int)

    for i, pred in enumerate(predictions_windowed):
        # This prediction is for timestep i + steps
        target_idx = min(i + steps, len(sensors) - 1)
        predictions_full[target_idx] = pred

    # Fill in initial steps with first prediction
    if len(predictions_windowed) > 0:
        predictions_full[:steps] = predictions_windowed[0]

    return predictions_full


def maneuver_to_control_commands(
    maneuver_label: int,
    current_speed: float,
    current_steer: float,
    vocab: Dict[int, str],
) -> Dict[str, float]:
    """Convert maneuver prediction to control commands.

    This is a heuristic mapping - adapt to your domain knowledge.

    Args:
        maneuver_label: Predicted maneuver class
        current_speed: Current speed (km/h)
        current_steer: Current steering angle (deg)
        vocab: Maneuver vocabulary {label: name}

    Returns:
        commands: {speed_kmh, steer_angle_deg, throttle, brake}
    """
    maneuver_name = vocab.get(maneuver_label, 'none').lower()

    # Heuristic mapping maneuver -> commands
    # IMPORTANT: These are rough estimates - refine based on your data analysis

    if maneuver_name == 'none' or maneuver_name == 'straight':
        # Maintain current state
        return {
            'speed_kmh': current_speed,
            'steer_angle_deg': 0.0,
            'throttle': 0.5 if current_speed < 30 else 0.3,
            'brake': 0.0,
        }

    elif 'turn' in maneuver_name:
        if 'left' in maneuver_name:
            steer = -15.0  # Left turn
        elif 'right' in maneuver_name:
            steer = 15.0  # Right turn
        else:
            steer = current_steer

        return {
            'speed_kmh': max(20.0, current_speed * 0.8),  # Slow down for turn
            'steer_angle_deg': steer,
            'throttle': 0.2,
            'brake': 0.1,
        }

    elif 'lane' in maneuver_name and 'change' in maneuver_name:
        if 'left' in maneuver_name:
            steer = -8.0
        elif 'right' in maneuver_name:
            steer = 8.0
        else:
            steer = current_steer

        return {
            'speed_kmh': current_speed,  # Maintain speed
            'steer_angle_deg': steer,
            'throttle': 0.4,
            'brake': 0.0,
        }

    elif 'stop' in maneuver_name or 'brake' in maneuver_name:
        return {
            'speed_kmh': max(0.0, current_speed * 0.5),  # Decelerate
            'steer_angle_deg': current_steer,
            'throttle': 0.0,
            'brake': 0.8,
        }

    else:
        # Unknown maneuver - maintain state
        return {
            'speed_kmh': current_speed,
            'steer_angle_deg': current_steer,
            'throttle': 0.3,
            'brake': 0.0,
        }


def generate_ml_sensor_csvs(
    session_record: SessionRecord,
    model,
    config: Dict,
    output_dir: Path,
    sample_hz: float = 3.0,
) -> Path:
    """Generate HDD-compatible CSV files from ML predictions.

    Args:
        session_record: Session metadata
        model: Trained ML model
        config: Model configuration
        output_dir: Output directory for CSV files
        sample_hz: Sampling frequency

    Returns:
        session_output_dir: Path to session output directory
    """
    # Create session output directory
    session_output_dir = output_dir / session_record.session_id
    session_output_dir.mkdir(parents=True, exist_ok=True)

    # Load real sensors (for context and initial state)
    df_real = load_run_sensors(Path(session_record.csv_dir))
    aligned_real = align_sensors_to_grid(df_real, hz=sample_hz)

    # Load feature names from training
    feature_names_path = Path(config.get('model_dir', '.')) / 'feature_names.json'
    if feature_names_path.exists():
        with open(feature_names_path) as f:
            feature_names = json.load(f)
    else:
        # Fallback: use all columns
        feature_names = [c for c in aligned_real.columns if c not in ['t', 'unix_timestamp', 'lat', 'lng']]

    # Extract sensor features for ML prediction (only features used in training)
    # Feature names from training may have prefixes (e.g., "steer.steer_angle")
    # But columns in aligned_real may not (e.g., "steer_angle")
    # Create mapping: try both full name and name without prefix

    def find_column_name(feat: str, columns: List[str]) -> str:
        """Find matching column name, trying both full name and without prefix."""
        if feat in columns:
            return feat
        # Try without prefix (e.g., "steer.steer_angle" -> "steer_angle")
        if '.' in feat:
            feat_no_prefix = feat.split('.', 1)[1]
            if feat_no_prefix in columns:
                return feat_no_prefix
        return None

    # Build sensor dataframe with required features
    sensors_df = pd.DataFrame(index=aligned_real.index)

    for feat in feature_names:
        col_name = find_column_name(feat, aligned_real.columns)
        if col_name:
            sensors_df[feat] = aligned_real[col_name]
        else:
            print(f"  [Warning] Feature '{feat}' not found in session {session_record.session_id}, using 0.0")
            sensors_df[feat] = 0.0

    sensors = sensors_df.fillna(0.0).values  # (T, D)

    # Predict maneuvers
    # NOTE: This is simplified - in practice, use sliding window for each timestep
    predicted_maneuvers = predict_maneuvers(model, sensors, config)

    # Load vocabulary
    vocab_path = Path(config.get('model_dir', '.')) / 'vocab.json'
    if vocab_path.exists():
        with open(vocab_path) as f:
            vocab = {int(k): v for k, v in json.load(f).items()}
    else:
        vocab = {i: f'class_{i}' for i in range(config.get('n_classes', 10))}

    # Convert maneuvers to control commands
    timestamps = aligned_real['unix_timestamp'].values if 'unix_timestamp' in aligned_real.columns else np.arange(len(sensors))

    ml_commands = []
    current_speed = 30.0  # Initial speed (km/h)
    current_steer = 0.0   # Initial steering (deg)

    for i, maneuver_label in enumerate(predicted_maneuvers):
        # Get control commands for this maneuver
        commands = maneuver_to_control_commands(
            maneuver_label,
            current_speed,
            current_steer,
            vocab,
        )

        # Update state
        current_speed = commands['speed_kmh']
        current_steer = commands['steer_angle_deg']

        ml_commands.append({
            'unix_timestamp': float(timestamps[i]),
            **commands,
        })

    ml_df = pd.DataFrame(ml_commands)

    # Save as HDD-compatible CSV files

    # 1. vel.csv (speed)
    vel_df = pd.DataFrame({
        'unix_timestamp': ml_df['unix_timestamp'],
        'speed': ml_df['speed_kmh'],  # km/h
    })
    vel_df.to_csv(session_output_dir / 'vel.csv', index=False)

    # 2. steer.csv (steering angle)
    steer_df = pd.DataFrame({
        'unix_timestamp': ml_df['unix_timestamp'],
        'steer_angle': ml_df['steer_angle_deg'],  # degrees
    })
    steer_df.to_csv(session_output_dir / 'steer.csv', index=False)

    # 3. throttle.csv (optional)
    throttle_df = pd.DataFrame({
        'unix_timestamp': ml_df['unix_timestamp'],
        'throttle': ml_df['throttle'],
    })
    throttle_df.to_csv(session_output_dir / 'throttle.csv', index=False)

    # 4. brake.csv (optional)
    brake_df = pd.DataFrame({
        'unix_timestamp': ml_df['unix_timestamp'],
        'brake': ml_df['brake'],
    })
    brake_df.to_csv(session_output_dir / 'brake.csv', index=False)

    # 5. Copy RTK files (for DT evaluation)
    if session_record.csv_dir:
        source_dir = Path(session_record.csv_dir)

        for rtk_file in ['rtk_pos.csv', 'rtk_track.csv']:
            source_path = source_dir / rtk_file
            if source_path.exists():
                import shutil
                shutil.copy(source_path, session_output_dir / rtk_file)

    return session_output_dir


def main():
    parser = argparse.ArgumentParser(
        description="Generate ML predictions as HDD-compatible CSV sensors"
    )
    parser.add_argument(
        "--model-dir",
        type=Path,
        required=True,
        help="Trained ML model directory (e.g., ./artifacts/maneuver_transformer)",
    )
    parser.add_argument(
        "--manifest",
        type=Path,
        required=True,
        help="Test manifest (e.g., ./artifacts/manifest_test.jsonl)",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        required=True,
        help="Output directory for ML-predicted sensors",
    )
    parser.add_argument(
        "--sample-hz",
        type=float,
        default=3.0,
        help="Sampling frequency (default: 3.0 Hz)",
    )
    parser.add_argument(
        "--max-sessions",
        type=int,
        default=None,
        help="Limit number of sessions (for testing)",
    )

    args = parser.parse_args()

    # Load ML model
    print(f"Loading ML model from {args.model_dir}...")
    model, config = load_ml_model(args.model_dir)
    config['model_dir'] = str(args.model_dir)
    print(f"  Model loaded: {config.get('model_kind', 'unknown')}")
    print(f"  Classes: {config.get('n_classes', 'N/A')}")

    # Load test manifest
    print(f"\nLoading test manifest from {args.manifest}...")
    records = load_manifest(args.manifest)
    print(f"  Found {len(records)} sessions")

    if args.max_sessions:
        records = records[:args.max_sessions]
        print(f"  Limited to {len(records)} sessions for testing")

    # Create output directory
    args.output_dir.mkdir(parents=True, exist_ok=True)

    # Generate ML predictions for each session
    print(f"\nGenerating ML predictions...")
    ml_records = []

    for record in tqdm(records, desc="Sessions"):
        try:
            session_dir = generate_ml_sensor_csvs(
                session_record=record,
                model=model,
                config=config,
                output_dir=args.output_dir,
                sample_hz=args.sample_hz,
            )

            # Create new session record pointing to ML-predicted sensors
            ml_record = SessionRecord(
                session_id=record.session_id,
                day_id=record.day_id,
                csv_dir=str(session_dir),
                video_path=None,  # No video for ML predictions
                prealigned_sensor_npy=None,
                prealigned_target_npy=None,
            )
            ml_records.append(ml_record)

        except Exception as e:
            print(f"\n  [Error] Failed to process {record.session_id}: {e}")
            continue

    # Write ML predictions manifest
    ml_manifest_path = args.output_dir.parent / 'manifest_ml_predictions.jsonl'
    write_manifest(ml_manifest_path, ml_records)

    print(f"\n{'='*80}")
    print(f"ML predictions generated successfully!")
    print(f"{'='*80}")
    print(f"  Sessions processed: {len(ml_records)}/{len(records)}")
    print(f"  Output directory:   {args.output_dir}")
    print(f"  ML manifest:        {ml_manifest_path}")
    print(f"\nNext steps:")
    print(f"  1. Test DT with ML predictions:")
    print(f"     python -m twimo.cli simulate-dt \\")
    print(f"       --manifest {ml_manifest_path} \\")
    print(f"       --outdir ./artifacts/dt_ml_sensors \\")
    print(f"       --sample-hz {args.sample_hz}")
    print(f"\n  2. Compare with real sensors:")
    print(f"     RMSE_ML=$(jq '.rmse_xy_m_mean' artifacts/dt_ml_sensors/dt_aggregated_metrics.json)")
    print(f"     RMSE_REAL=$(jq '.rmse_xy_m_mean' artifacts/dt_real_sensors/dt_aggregated_metrics.json)")
    print(f"     echo \"Ratio: $(echo \"scale=2; $RMSE_ML / $RMSE_REAL\" | bc)\"")
    print(f"{'='*80}\n")


if __name__ == "__main__":
    main()
