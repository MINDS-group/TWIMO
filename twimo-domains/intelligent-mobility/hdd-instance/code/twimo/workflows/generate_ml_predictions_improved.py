#!/usr/bin/env python
"""Generate ML predictions with data-driven control mapping (IMPROVED VERSION).

This improved version uses statistics learned from real data instead of
fixed heuristics to convert maneuver predictions → control commands.

Usage:
    # 1. First, analyze real data to extract maneuver statistics
    python examples/analyze_maneuver_statistics.py \
      --manifest ./artifacts/manifest_train.jsonl \
      --output ./artifacts/maneuver_control_stats.json \
      --vocab-path ./artifacts/maneuver_transformer/vocab.json \
      --sample-hz 3

    # 2. Generate ML predictions using learned statistics
    python examples/generate_ml_predictions_improved.py \
      --model-dir ./artifacts/maneuver_xgboost \
      --manifest ./artifacts/manifest_test.jsonl \
      --stats ./artifacts/maneuver_control_stats.json \
      --output-dir ./ml_predicted_sensors_improved \
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json
import sys
from pathlib import Path

# Import the original functions
sys.path.insert(0, str(Path(__file__).parent))
from generate_ml_predictions import (
    load_ml_model,
    predict_maneuvers,
    SessionRecord,
    load_manifest,
    write_manifest,
    load_run_sensors,
    align_sensors_to_grid,
)

import numpy as np
import pandas as pd
from tqdm import tqdm


def load_maneuver_stats(stats_path: Path) -> dict:
    """Load maneuver statistics from JSON file."""
    with open(stats_path) as f:
        data = json.load(f)
    return data['maneuver_statistics']


def maneuver_to_control_commands_improved(
    maneuver_label: int,
    current_speed: float,
    current_steer: float,
    vocab: dict,
    maneuver_stats: dict,
    use_sampling: bool = False,
) -> dict:
    """Convert maneuver prediction to control commands using learned statistics.

    Args:
        maneuver_label: Predicted maneuver class
        current_speed: Current speed (km/h)
        current_steer: Current steering angle (deg)
        vocab: Maneuver vocabulary {label: name}
        maneuver_stats: Statistics per maneuver from real data
        use_sampling: If True, sample from distribution. If False, use mean.

    Returns:
        commands: {speed_kmh, steer_angle_deg}
    """
    maneuver_name = vocab.get(maneuver_label, f'class_{maneuver_label}')

    # Get statistics for this maneuver
    if maneuver_name not in maneuver_stats:
        # Fallback: use current state
        return {
            'speed_kmh': current_speed,
            'steer_angle_deg': current_steer,
        }

    stats = maneuver_stats[maneuver_name]
    steer_stats = stats['steer_angle']
    speed_stats = stats['speed']

    # Generate commands
    if use_sampling:
        # Sample from normal distribution
        steer = float(np.random.normal(steer_stats['mean'], max(steer_stats['std'], 0.1)))
        speed = float(np.random.normal(speed_stats['mean'], max(speed_stats['std'], 1.0)))
    else:
        # Use mean values (more stable)
        steer = float(steer_stats['mean'])
        speed = float(speed_stats['mean'])

    # Clip to reasonable ranges
    steer = np.clip(steer, -45.0, 45.0)
    speed = np.clip(speed, 0.0, 150.0)

    return {
        'speed_kmh': speed,
        'steer_angle_deg': steer,
    }


def generate_ml_sensor_csvs_improved(
    session_record: SessionRecord,
    model,
    config: dict,
    maneuver_stats: dict,
    output_dir: Path,
    sample_hz: float = 3.0,
    use_sampling: bool = False,
) -> Path:
    """Generate HDD-compatible CSV files from ML predictions (IMPROVED VERSION)."""
    # Create session output directory
    session_output_dir = output_dir / session_record.session_id
    session_output_dir.mkdir(parents=True, exist_ok=True)

    # Load real sensors
    df_real = load_run_sensors(Path(session_record.csv_dir))
    aligned_real = align_sensors_to_grid(df_real, hz=sample_hz)

    # Load feature names from training
    feature_names_path = Path(config.get('model_dir', '.')) / 'feature_names.json'
    if feature_names_path.exists():
        with open(feature_names_path) as f:
            feature_names = json.load(f)
    else:
        feature_names = [c for c in aligned_real.columns if c not in ['t', 'unix_timestamp', 'lat', 'lng']]

    # Extract sensor features (same as original)
    def find_column_name(feat: str, columns: list) -> str:
        if feat in columns:
            return feat
        if '.' in feat:
            feat_no_prefix = feat.split('.', 1)[1]
            if feat_no_prefix in columns:
                return feat_no_prefix
        return None

    sensors_df = pd.DataFrame(index=aligned_real.index)
    for feat in feature_names:
        col_name = find_column_name(feat, aligned_real.columns)
        if col_name:
            sensors_df[feat] = aligned_real[col_name]
        else:
            sensors_df[feat] = 0.0

    sensors = sensors_df.fillna(0.0).values

    # Predict maneuvers
    predicted_maneuvers = predict_maneuvers(model, sensors, config)

    # Load vocabulary
    vocab_path = Path(config.get('model_dir', '.')) / 'vocab.json'
    if vocab_path.exists():
        with open(vocab_path) as f:
            vocab = {int(k): v for k, v in json.load(f).items()}
    else:
        vocab = {i: f'class_{i}' for i in range(config.get('n_classes', 10))}

    # Convert maneuvers to control commands using IMPROVED mapping
    timestamps = aligned_real['unix_timestamp'].values if 'unix_timestamp' in aligned_real.columns else np.arange(len(sensors))

    ml_commands = []

    # Initialize with real values if available
    if 'speed' in aligned_real.columns and len(aligned_real) > 0:
        current_speed = float(aligned_real['speed'].iloc[0])
    else:
        current_speed = 30.0

    if 'steer_angle' in aligned_real.columns and len(aligned_real) > 0:
        current_steer = float(aligned_real['steer_angle'].iloc[0])
    else:
        current_steer = 0.0

    for i, maneuver_label in enumerate(predicted_maneuvers):
        # Get control commands using learned statistics
        commands = maneuver_to_control_commands_improved(
            maneuver_label,
            current_speed,
            current_steer,
            vocab,
            maneuver_stats,
            use_sampling=use_sampling,
        )

        # Update state with smoothing
        alpha = 0.7  # Smoothing factor (0 = no change, 1 = instant change)
        current_speed = alpha * commands['speed_kmh'] + (1 - alpha) * current_speed
        current_steer = alpha * commands['steer_angle_deg'] + (1 - alpha) * current_steer

        ml_commands.append({
            'unix_timestamp': float(timestamps[i]),
            'speed_kmh': current_speed,
            'steer_angle_deg': current_steer,
        })

    ml_df = pd.DataFrame(ml_commands)

    # Save as HDD-compatible CSV files
    vel_df = pd.DataFrame({
        'unix_timestamp': ml_df['unix_timestamp'],
        'speed': ml_df['speed_kmh'],
    })
    vel_df.to_csv(session_output_dir / 'vel.csv', index=False)

    steer_df = pd.DataFrame({
        'unix_timestamp': ml_df['unix_timestamp'],
        'steer_angle': ml_df['steer_angle_deg'],
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
        description="Generate ML predictions with improved maneuver→control mapping"
    )
    parser.add_argument(
        "--model-dir",
        type=Path,
        required=True,
        help="Trained ML model directory",
    )
    parser.add_argument(
        "--manifest",
        type=Path,
        required=True,
        help="Test manifest (e.g., ./artifacts/manifest_test.jsonl)",
    )
    parser.add_argument(
        "--stats",
        type=Path,
        required=True,
        help="Maneuver statistics JSON (from analyze_maneuver_statistics.py)",
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
        "--use-sampling",
        action="store_true",
        help="Sample from distributions instead of using means (adds variability)",
    )
    parser.add_argument(
        "--max-sessions",
        type=int,
        default=None,
        help="Limit number of sessions (for testing)",
    )

    args = parser.parse_args()

    # Load maneuver statistics
    print(f"Loading maneuver statistics from {args.stats}...")
    maneuver_stats = load_maneuver_stats(args.stats)
    print(f"  Loaded statistics for {len(maneuver_stats)} maneuvers")

    # Load ML model
    print(f"\nLoading ML model from {args.model_dir}...")
    model, config = load_ml_model(args.model_dir)
    config['model_dir'] = str(args.model_dir)
    print(f"  Model loaded: {config.get('model_kind', 'unknown')}")

    # Load test manifest
    print(f"\nLoading test manifest from {args.manifest}...")
    records = load_manifest(args.manifest)
    print(f"  Found {len(records)} sessions")

    if args.max_sessions:
        records = records[:args.max_sessions]
        print(f"  Limited to {len(records)} sessions for testing")

    # Create output directory
    args.output_dir.mkdir(parents=True, exist_ok=True)

    # Generate ML predictions
    print(f"\nGenerating ML predictions (IMPROVED)...")
    ml_records = []

    for record in tqdm(records, desc="Sessions"):
        try:
            session_dir = generate_ml_sensor_csvs_improved(
                session_record=record,
                model=model,
                config=config,
                maneuver_stats=maneuver_stats,
                output_dir=args.output_dir,
                sample_hz=args.sample_hz,
                use_sampling=args.use_sampling,
            )

            ml_record = SessionRecord(
                session_id=record.session_id,
                day_id=record.day_id,
                csv_dir=str(session_dir),
                video_path=None,
                prealigned_sensor_npy=None,
                prealigned_target_npy=None,
            )
            ml_records.append(ml_record)

        except Exception as e:
            print(f"\n  [Error] Failed to process {record.session_id}: {e}")
            continue

    # Write manifest
    ml_manifest_path = args.output_dir.parent / 'manifest_ml_predictions_improved.jsonl'
    write_manifest(ml_manifest_path, ml_records)

    print(f"\n{'='*80}")
    print(f"IMPROVED ML predictions generated!")
    print(f"{'='*80}")
    print(f"  Sessions processed: {len(ml_records)}/{len(records)}")
    print(f"  Output directory:   {args.output_dir}")
    print(f"  ML manifest:        {ml_manifest_path}")
    print(f"\nNext steps:")
    print(f"  1. Test DT with improved ML predictions:")
    print(f"     python -m twimo.cli simulate-dt \\")
    print(f"       --manifest {ml_manifest_path} \\")
    print(f"       --outdir ./artifacts/dt_ml_improved \\")
    print(f"       --sample-hz {args.sample_hz}")
    print(f"\n  2. Compare with original ML predictions:")
    print(f"     # Old (heuristics): artifacts/dt_ml_sensors/")
    print(f"     # New (learned):    artifacts/dt_ml_improved/")
    print(f"{'='*80}\n")


if __name__ == "__main__":
    main()
