#!/usr/bin/env python
"""Evaluate maneuver predictions against EAF ground-truth annotations.

This script compares model predictions with EAF-based ground-truth labels
and computes classification metrics (accuracy, F1, confusion matrix).

Usage:
    python strategies_EAF/evaluate_eaf.py \
      --model-dir ./artifacts/maneuver_eaf_transformer \
      --manifest ./artifacts/eaf_aligned/manifest_eaf_aligned.jsonl \
      --vocab ./artifacts/vocab_eaf.json \
      --output-dir ./artifacts/eval_eaf \
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json
from pathlib import Path
from typing import Dict, List

import numpy as np
import pandas as pd
from tqdm import tqdm

# Import TWIMO utilities
import sys
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

from twimo.data.manifest import load_manifest, SessionRecord
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid


def load_vocab(vocab_path: Path) -> Dict[str, int]:
    """Load vocabulary from JSON file."""
    with open(vocab_path, encoding='utf-8') as f:
        data = json.load(f)
    return data['vocab']


def load_model(model_dir: Path):
    """Load trained model."""
    config_path = model_dir / 'config.json'
    with open(config_path) as f:
        config = json.load(f)

    model_kind_path = model_dir / 'model_kind.txt'
    model_kind = model_kind_path.read_text(encoding='utf-8').strip()

    # Load model based on type
    if model_kind == 'transformer':
        import torch
        import torch.nn as nn
        from twimo.models.maneuver_transformer import ManeuverConfig
        from dataclasses import fields

        # Try to find the model file
        # Priority: 1) model.pth, 2) {dir_name}.pt, 3) any .pt file
        model_path = None

        # Try model.pth first
        candidate = model_dir / 'model.pth'
        if candidate.exists():
            model_path = candidate

        # Try {dir_name}.pt
        if model_path is None:
            candidate = model_dir / f'{model_dir.name}.pt'
            if candidate.exists():
                model_path = candidate
                print(f"Using model file: {model_path}")

        # Try any .pt file
        if model_path is None:
            pt_files = list(model_dir.glob('*.pt'))
            if pt_files:
                model_path = pt_files[0]
                print(f"Using model file: {model_path}")

        if model_path is None:
            raise FileNotFoundError(f"No .pt or .pth model file found in {model_dir}")

        # Load checkpoint
        checkpoint = torch.load(model_path, map_location='cpu')

        # Check if it's a state_dict or a full checkpoint
        if isinstance(checkpoint, dict) and 'state_dict' in checkpoint:
            # New format: {state_dict, cfg_dict, steps, n_classes}
            cfg_dict = checkpoint['cfg_dict']
            n_classes = checkpoint['n_classes']
            steps_list = checkpoint['steps']

            # Reconstruct config
            # Filter only valid ManeuverConfig fields
            valid_fields = {f.name for f in fields(ManeuverConfig)}
            filtered_cfg = {k: v for k, v in cfg_dict.items() if k in valid_fields}
            cfg = ManeuverConfig(**filtered_cfg)

            # Reconstruct model architecture (matches train_transformer_multihead)
            class Model(nn.Module):
                def __init__(self, d_in: int, n_classes: int, steps: list):
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
                    self.heads = nn.ModuleList([nn.Linear(cfg.d_model, n_classes) for _ in steps])

                def forward(self, x):
                    x = self.proj(x)
                    h = self.enc(x)  # (B,T,D)
                    # pool over time
                    h = h.transpose(1,2)  # (B,D,T)
                    h = self.pool(h).squeeze(-1)  # (B,D)
                    return [head(h) for head in self.heads]

            # Get d_in from state_dict
            d_in = checkpoint['state_dict']['proj.weight'].shape[1]
            model = Model(d_in=d_in, n_classes=n_classes, steps=steps_list)
            model.load_state_dict(checkpoint['state_dict'])
            model.eval()
        else:
            # Old format: direct model object
            model = checkpoint
            if hasattr(model, 'eval'):
                model.eval()
    elif model_kind in ['xgboost', 'lightgbm', 'random_forest', 'baseline']:
        import joblib
        model_path = model_dir / 'model.joblib'
        model = joblib.load(model_path)
    else:
        raise ValueError(f"Unknown model_kind: {model_kind}")

    return model, config, model_kind


def predict_session(
    session_record: SessionRecord,
    model,
    config: dict,
    model_kind: str,
    sample_hz: float,
) -> np.ndarray:
    """Predict maneuvers for a session.

    Returns:
        predictions: (T,) array of integer class IDs
    """
    # Load aligned .npy files if available
    if session_record.prealigned_sensor_npy:
        X = np.load(session_record.prealigned_sensor_npy)
    else:
        # Fallback: load from CSV
        csv_dir = Path(session_record.csv_dir)
        df = load_run_sensors(csv_dir)
        aligned = align_sensors_to_grid(df, hz=sample_hz)

        sensor_cols = ['steer_angle', 'steer_speed', 'lturn', 'rturn']
        X_df = pd.DataFrame()
        for col in sensor_cols:
            if col in aligned.columns:
                X_df[col] = aligned[col].fillna(0.0)
            else:
                X_df[col] = 0.0

        X = X_df.values.astype(np.float32)

    # Predict based on model type
    if model_kind == 'transformer':
        import torch

        window = config.get('window_steps', 30)
        n_samples = X.shape[0] - window + 1

        X_windows = np.array([X[i:i+window] for i in range(n_samples)])

        device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        model = model.to(device)
        model.eval()

        batch_size = 64
        all_preds = []

        with torch.no_grad():
            for i in range(0, len(X_windows), batch_size):
                batch = torch.from_numpy(X_windows[i:i+batch_size]).float().to(device)
                # Multi-horizon output: list of tensors (one per horizon)
                # Take first horizon for simplicity
                logits = model(batch)

                # Handle multi-head output (list of tensors)
                if isinstance(logits, list):
                    logits = logits[0]  # First horizon (B, n_classes)
                elif len(logits.shape) == 3:
                    logits = logits[:, 0, :]  # First horizon (B, n_classes)

                preds = torch.argmax(logits, dim=-1).cpu().numpy()
                all_preds.append(preds)

        y_pred = np.concatenate(all_preds)

        # Extend to full timeline
        predictions = np.zeros(len(X), dtype=np.int32)
        predictions[window-1:] = y_pred
        predictions[:window-1] = y_pred[0] if len(y_pred) > 0 else 0

    elif model_kind in ['xgboost', 'lightgbm', 'random_forest', 'baseline']:
        # Build windowed features
        window = config.get('window_steps', 30)
        n_samples = X.shape[0] - window + 1

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

        X_feat = np.array(features, dtype=np.float32)
        y_pred = model.predict(X_feat)

        # Extend to full timeline
        predictions = np.zeros(len(X), dtype=np.int32)
        predictions[window-1:] = y_pred
        predictions[:window-1] = y_pred[0] if len(y_pred) > 0 else 0

    else:
        raise ValueError(f"Unknown model_kind: {model_kind}")

    return predictions


def compute_metrics(y_true: np.ndarray, y_pred: np.ndarray, n_classes: int) -> dict:
    """Compute classification metrics.

    Args:
        y_true: Ground-truth labels (T,)
        y_pred: Predicted labels (T,)
        n_classes: Number of classes

    Returns:
        Dictionary with metrics
    """
    from sklearn.metrics import accuracy_score, f1_score, precision_score, recall_score, confusion_matrix

    # Overall accuracy
    accuracy = float(accuracy_score(y_true, y_pred))

    # Per-class and macro metrics
    f1_macro = float(f1_score(y_true, y_pred, average='macro', zero_division=0))
    f1_weighted = float(f1_score(y_true, y_pred, average='weighted', zero_division=0))

    precision_macro = float(precision_score(y_true, y_pred, average='macro', zero_division=0))
    recall_macro = float(recall_score(y_true, y_pred, average='macro', zero_division=0))

    # Confusion matrix
    cm = confusion_matrix(y_true, y_pred, labels=list(range(n_classes)))

    return {
        'accuracy': accuracy,
        'f1_macro': f1_macro,
        'f1_weighted': f1_weighted,
        'precision_macro': precision_macro,
        'recall_macro': recall_macro,
        'confusion_matrix': cm.tolist(),
        'n_samples': len(y_true),
    }


def main():
    parser = argparse.ArgumentParser(
        description="Evaluate predictions against EAF ground-truth"
    )
    parser.add_argument(
        '--model-dir',
        type=Path,
        required=True,
        help='Trained model directory',
    )
    parser.add_argument(
        '--manifest',
        type=Path,
        required=True,
        help='Manifest with EAF-aligned sessions',
    )
    parser.add_argument(
        '--vocab',
        type=Path,
        required=True,
        help='Vocabulary JSON file',
    )
    parser.add_argument(
        '--output-dir',
        type=Path,
        required=True,
        help='Output directory for evaluation results',
    )
    parser.add_argument(
        '--sample-hz',
        type=float,
        default=3.0,
        help='Sampling frequency (default: 3.0 Hz)',
    )

    args = parser.parse_args()

    # Load vocabulary
    print(f"Loading vocabulary from {args.vocab}...")
    vocab = load_vocab(args.vocab)
    n_classes = len(vocab)
    print(f"  Vocabulary: {n_classes} classes")

    # Load model
    print(f"\nLoading model from {args.model_dir}...")
    model, config, model_kind = load_model(args.model_dir)
    print(f"  Model type: {model_kind}")

    # Load manifest
    print(f"\nLoading manifest from {args.manifest}...")
    records = load_manifest(args.manifest)
    print(f"  Found {len(records)} sessions")

    # Evaluate sessions
    print(f"\nEvaluating predictions...")
    args.output_dir.mkdir(parents=True, exist_ok=True)

    all_y_true = []
    all_y_pred = []
    session_metrics = []

    for record in tqdm(records, desc="Sessions"):
        try:
            # Load ground-truth
            y_true = np.load(record.prealigned_target_npy)

            # Predict
            y_pred = predict_session(record, model, config, model_kind, args.sample_hz)

            # Truncate to same length
            min_len = min(len(y_true), len(y_pred))
            y_true = y_true[:min_len]
            y_pred = y_pred[:min_len]

            # Compute session metrics
            metrics = compute_metrics(y_true, y_pred, n_classes)
            metrics['session_id'] = record.session_id
            session_metrics.append(metrics)

            # Accumulate for global metrics
            all_y_true.append(y_true)
            all_y_pred.append(y_pred)

        except Exception as e:
            print(f"\n  [Error] Failed to evaluate {record.session_id}: {e}")
            continue

    # Compute global metrics
    if len(all_y_true) == 0:
        print("\n[ERROR] All sessions failed to evaluate. Cannot compute global metrics.")
        print("Common causes:")
        print("  - Model architecture mismatch (features don't match)")
        print("  - Missing sensor files")
        print("  - Incompatible model checkpoint format")
        return

    all_y_true = np.concatenate(all_y_true)
    all_y_pred = np.concatenate(all_y_pred)
    global_metrics = compute_metrics(all_y_true, all_y_pred, n_classes)

    # Save results
    results = {
        'model_dir': str(args.model_dir),
        'model_kind': model_kind,
        'vocab_path': str(args.vocab),
        'n_classes': n_classes,
        'n_sessions': len(session_metrics),
        'global_metrics': global_metrics,
        'session_metrics': session_metrics,
    }

    results_path = args.output_dir / 'evaluation_results.json'
    with open(results_path, 'w', encoding='utf-8') as f:
        json.dump(results, f, indent=2)

    # Save confusion matrix as CSV
    cm = np.array(global_metrics['confusion_matrix'])
    cm_df = pd.DataFrame(cm)
    cm_df.to_csv(args.output_dir / 'confusion_matrix.csv', index=False)

    print(f"\n{'='*80}")
    print(f"Evaluation completed!")
    print(f"{'='*80}")
    print(f"  Sessions evaluated: {len(session_metrics)}")
    print(f"  Total samples: {global_metrics['n_samples']}")
    print(f"\nGlobal Metrics:")
    print(f"  Accuracy:    {global_metrics['accuracy']:.4f}")
    print(f"  F1 (macro):  {global_metrics['f1_macro']:.4f}")
    print(f"  F1 (weight): {global_metrics['f1_weighted']:.4f}")
    print(f"  Precision:   {global_metrics['precision_macro']:.4f}")
    print(f"  Recall:      {global_metrics['recall_macro']:.4f}")
    print(f"\nResults saved to: {results_path}")
    print(f"{'='*80}\n")


if __name__ == '__main__':
    main()
