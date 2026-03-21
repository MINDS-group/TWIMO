#!/usr/bin/env python
"""Generate control predictions from regression model (steering + speed directly).

This script uses a trained regression model to predict steering angle and speed
directly from sensors, bypassing the maneuver prediction step entirely.

Supported Models:
    - Tree-based: xgboost, lightgbm, random_forest, baseline
    - Neural: transformer, gru, lstm, tcn, mlp_mean, mlp_max, mlp_concat

Usage:
    # With XGBoost regressor
    python workflows/generate_control_predictions.py \
      --model-dir ./artifacts/control_regressor_xgb \
      --manifest ./artifacts/manifest_test.jsonl \
      --output-dir ./control_predicted_sensors \
      --sample-hz 3

    # With Transformer regressor
    python workflows/generate_control_predictions.py \
      --model-dir ./artifacts/control_regressor_transformer \
      --manifest ./artifacts/manifest_test.jsonl \
      --output-dir ./control_predicted_sensors_transformer \
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path
import sys
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import joblib
import numpy as np
import pandas as pd
from tqdm import tqdm

from twimo.data.manifest import load_manifest, write_manifest, SessionRecord
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid


def build_windowed_features(X: np.ndarray, window: int) -> np.ndarray:
    """Build window statistics features."""
    T, D = X.shape
    n_samples = T - window + 1

    features = []
    for i in range(n_samples):
        W = X[i:i+window]
        mu = W.mean(axis=0)
        sd = W.std(axis=0)
        mn = W.min(axis=0)
        mx = W.max(axis=0)
        dt = W[-1] - W[0]
        feat = np.concatenate([mu, sd, mn, mx, dt])
        features.append(feat)

    return np.array(features, dtype=np.float32)


def generate_session_csvs(
    session_record: SessionRecord,
    model,
    config: dict,
    model_kind: str,
    output_dir: Path,
    sample_hz: float = 3.0,
) -> Path:
    """Generate HDD-compatible CSV files using regression model."""
    session_output_dir = output_dir / session_record.session_id
    session_output_dir.mkdir(parents=True, exist_ok=True)

    # Load sensors
    df = load_run_sensors(Path(session_record.csv_dir))
    aligned = align_sensors_to_grid(df, hz=sample_hz)

    # Extract features
    feature_names = config.get('feature_names', ['steer_angle', 'steer_speed', 'lturn', 'rturn'])

    X_df = pd.DataFrame()
    for col in feature_names:
        if col in aligned.columns:
            X_df[col] = aligned[col].fillna(0.0)
        else:
            X_df[col] = 0.0

    X = X_df.values.astype(np.float32)

    window = config.get('window_steps', 30)

    # Tree-based models: Use windowed features
    if model_kind in ['xgboost_regressor', 'lightgbm_regressor', 'random_forest_regressor', 'baseline_regressor']:
        X_feat = build_windowed_features(X, window)
        y_pred = model.predict(X_feat)  # (N, 2) where columns are [steer, speed]

    # Neural models: Use raw windows
    elif model_kind in ['transformer_regressor', 'gru_regressor', 'lstm_regressor', 'tcn_regressor', 'mlp_mean_regressor', 'mlp_max_regressor', 'mlp_concat_regressor']:
        import torch

        # Create windows
        n_samples = X.shape[0] - window + 1
        X_windows = np.array([X[i:i+window] for i in range(n_samples)])

        # Predict in batches
        device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        model = model.to(device)
        model.eval()

        batch_size = 64
        all_preds = []

        with torch.no_grad():
            for i in range(0, len(X_windows), batch_size):
                batch = torch.from_numpy(X_windows[i:i+batch_size]).float().to(device)
                y_batch = model(batch).cpu().numpy()
                all_preds.append(y_batch)

        y_pred = np.vstack(all_preds)  # (N, 2)

    else:
        raise ValueError(f"Unknown model_kind: {model_kind}")

    # Extend predictions to full timeline
    steer_pred_full = np.zeros(len(X))
    speed_pred_full = np.zeros(len(X))

    # Fill windowed predictions
    steer_pred_full[window-1:] = y_pred[:, 0]
    speed_pred_full[window-1:] = y_pred[:, 1]

    # Fill initial window with first prediction
    if len(y_pred) > 0:
        steer_pred_full[:window-1] = y_pred[0, 0]
        speed_pred_full[:window-1] = y_pred[0, 1]

    # Smooth predictions
    from scipy.ndimage import gaussian_filter1d
    steer_pred_smooth = gaussian_filter1d(steer_pred_full, sigma=2.0)
    speed_pred_smooth = gaussian_filter1d(speed_pred_full, sigma=2.0)

    # Get timestamps
    timestamps = aligned['unix_timestamp'].values if 'unix_timestamp' in aligned.columns else np.arange(len(X))

    # Save vel.csv
    vel_df = pd.DataFrame({
        'unix_timestamp': timestamps,
        'speed': speed_pred_smooth,
    })
    vel_df.to_csv(session_output_dir / 'vel.csv', index=False)

    # Save steer.csv
    steer_df = pd.DataFrame({
        'unix_timestamp': timestamps,
        'steer_angle': steer_pred_smooth,
    })
    steer_df.to_csv(session_output_dir / 'steer.csv', index=False)

    # Copy RTK files
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
        description="Generate control predictions using regression model"
    )
    parser.add_argument(
        "--model-dir",
        type=Path,
        required=True,
        help="Regression model directory",
    )
    parser.add_argument(
        "--manifest",
        type=Path,
        required=True,
        help="Test manifest",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        required=True,
        help="Output directory",
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
        help="Limit sessions",
    )

    args = parser.parse_args()

    # Load model
    print(f"Loading regression model from {args.model_dir}...")

    config_path = args.model_dir / 'config.json'
    with open(config_path) as f:
        config = json.load(f)

    model_kind_path = args.model_dir / 'model_kind.txt'
    model_kind = model_kind_path.read_text(encoding='utf-8').strip()

    # Load model based on type
    neural_models = ['transformer_regressor', 'gru_regressor', 'lstm_regressor', 'tcn_regressor', 'mlp_mean_regressor', 'mlp_max_regressor', 'mlp_concat_regressor']

    if model_kind in neural_models:
        # Neural models: Load from .pt
        import torch
        model_path = args.model_dir / f'{model_kind}.pt'
        model = torch.load(model_path, map_location='cpu')
        print(f"  Model type: {model_kind} (neural)")
    else:
        # Tree-based models: Load from .joblib
        model_path = args.model_dir / f'{model_kind}.joblib'
        model = joblib.load(model_path)
        print(f"  Model type: {model_kind} (tree-based)")

    print(f"  Window: {config['window_steps']} steps ({config['window_seconds']} seconds)")

    # Load manifest
    print(f"\nLoading manifest from {args.manifest}...")
    records = load_manifest(args.manifest)
    print(f"  Found {len(records)} sessions")

    if args.max_sessions:
        records = records[:args.max_sessions]
        print(f"  Limited to {len(records)} sessions")

    args.output_dir.mkdir(parents=True, exist_ok=True)

    # Generate predictions
    print(f"\nGenerating control predictions...")
    output_records = []

    for record in tqdm(records, desc="Sessions"):
        try:
            session_dir = generate_session_csvs(
                session_record=record,
                model=model,
                config=config,
                model_kind=model_kind,
                output_dir=args.output_dir,
                sample_hz=args.sample_hz,
            )

            output_record = SessionRecord(
                session_id=record.session_id,
                day_id=record.day_id,
                csv_dir=str(session_dir),
                video_path=None,
                prealigned_sensor_npy=None,
                prealigned_target_npy=None,
            )
            output_records.append(output_record)

        except Exception as e:
            print(f"\n  [Error] Failed to process {record.session_id}: {e}")
            continue

    # Write manifest
    output_manifest = args.output_dir.parent / 'manifest_control_predictions.jsonl'
    write_manifest(output_manifest, output_records)

    print(f"\n{'='*80}")
    print(f"Control predictions generated!")
    print(f"{'='*80}")
    print(f"  Sessions: {len(output_records)}/{len(records)}")
    print(f"  Output:   {args.output_dir}")
    print(f"  Manifest: {output_manifest}")
    print(f"\nNext steps:")
    print(f"  1. Test DT with control predictions:")
    print(f"     python -m twimo.cli simulate-dt \\")
    print(f"       --manifest {output_manifest} \\")
    print(f"       --outdir ./artifacts/dt_control_predictions \\")
    print(f"       --sample-hz {args.sample_hz}")
    print(f"\n  2. Compare RMSE:")
    print(f"     $ctrl = Get-Content ./artifacts/dt_control_predictions/dt_aggregated_metrics.json | ConvertFrom-Json")
    print(f"     $real = Get-Content ./artifacts/dt_real_sensors/dt_aggregated_metrics.json | ConvertFrom-Json")
    print(f"     [math]::Round($ctrl.rmse_xy_m_mean / $real.rmse_xy_m_mean, 2)")
    print(f"{'='*80}\n")


if __name__ == "__main__":
    main()
