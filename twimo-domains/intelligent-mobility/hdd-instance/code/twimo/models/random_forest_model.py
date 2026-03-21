from __future__ import annotations

import json
from dataclasses import asdict, dataclass
from typing import Dict, List, Tuple

import numpy as np

from twimo.models.maneuver_transformer import ManeuverConfig, horizon_steps, unique_horizon_steps, make_windows


def _window_stats_features(W: np.ndarray) -> np.ndarray:
    """Convert a window W (window, D) into a fixed-length vector.

    Stats per feature:
    - mean
    - std
    - min
    - max
    - delta (last - first)

    Returns shape (5*D,).
    """
    if W.ndim != 2:
        raise ValueError(f"Expected 2D window (window, D), got shape {W.shape}")
    mu = W.mean(axis=0)
    sd = W.std(axis=0)
    mn = W.min(axis=0)
    mx = W.max(axis=0)
    dt = W[-1] - W[0]
    return np.concatenate([mu, sd, mn, mx, dt], axis=0)


def _build_dataset(X: np.ndarray, y: np.ndarray, steps_ahead: int, window: int) -> Tuple[np.ndarray, np.ndarray]:
    """Build (X_feat, y_aligned) for a given horizon."""
    Xw, y_aligned = make_windows(X, y, steps_ahead=steps_ahead, window=window)
    # Xw: (N, window, D) -> (N, 5D)
    feats = np.stack([_window_stats_features(W) for W in Xw], axis=0).astype(np.float32)
    return feats, y_aligned.astype(np.int64)


def _make_random_forest_classifier(n_classes: int):
    """Return Random Forest classifier with tuned hyperparameters."""
    from sklearn.ensemble import RandomForestClassifier

    return RandomForestClassifier(
        n_estimators=100,    # 500 → 100: 5x fewer trees
        max_depth=12,        # None → 12: max 8191 nodes/tree instead of ~417K
        min_samples_split=10,
        min_samples_leaf=20, # 2 → 20: larger leaves, shallower trees
        max_features='sqrt',
        bootstrap=True,
        n_jobs=-1,
        random_state=42,
        verbose=0,
    )


def train_random_forest_multihead(
    X_train: np.ndarray,
    y_train: np.ndarray,
    X_val: np.ndarray,
    y_val: np.ndarray,
    n_classes: int,
    cfg: ManeuverConfig,
) -> Dict:
    """Train one Random Forest classifier per horizon.

    Returns a checkpoint dict (joblib-serializable).
    """
    from sklearn.pipeline import make_pipeline
    from sklearn.preprocessing import StandardScaler

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    u_steps = unique_horizon_steps(cfg)

    _all_steps = horizon_steps(cfg)
    step_to_secs: Dict[int, List[float]] = {}
    for h_sec, h_step in zip(cfg.horizons_seconds, _all_steps):
        step_to_secs.setdefault(h_step, []).append(h_sec)

    models: Dict[int, object] = {}
    label_encoders: Dict[int, object] = {}
    val_metrics: Dict[int, Dict[str, float]] = {}

    # Build datasets per unique horizon and fit
    for steps in u_steps:
        import pandas as pd
        from sklearn.preprocessing import LabelEncoder
        Xtr, ytr = _build_dataset(X_train, y_train, steps_ahead=int(steps), window=window)
        Xva, yva = _build_dataset(X_val, y_val, steps_ahead=int(steps), window=window)

        # Remap labels to contiguous [0..n_local-1]; some classes may be absent
        # from the windowed dataset for a specific horizon.
        le = LabelEncoder()
        le.fit(np.unique(np.concatenate([ytr, yva])))
        ytr_enc = le.transform(ytr)
        n_local = len(le.classes_)

        cols = [f"f{i}" for i in range(Xtr.shape[1])]
        Xtr = pd.DataFrame(Xtr, columns=cols)
        Xva = pd.DataFrame(Xva, columns=cols)

        clf = _make_random_forest_classifier(n_local)
        model = make_pipeline(StandardScaler(with_mean=True, with_std=True), clf)
        model.fit(Xtr, ytr_enc)

        # Remap local probs back to global n_classes space
        probs_local = model.predict_proba(Xva)
        probs_global = np.zeros((len(yva), n_classes), dtype=np.float32)
        for local_i, global_label in enumerate(le.classes_):
            probs_global[:, global_label] = probs_local[:, local_i]
        ypred = probs_global.argmax(axis=1)
        acc = float((ypred == yva).mean()) if len(yva) else 0.0
        val_metrics[int(steps)] = {"acc": acc, "n": float(len(yva))}
        models[int(steps)] = model
        label_encoders[int(steps)] = le

        secs_str = "/".join(f"{s}s" for s in step_to_secs.get(steps, []))
        print(f"  [RandomForest] horizon={steps} steps ({secs_str}), val_acc={acc:.4f}")

    ckpt = {
        "type": "random_forest_window_stats_v1",
        "n_classes": int(n_classes),
        "cfg_dict": asdict(cfg),
        "val_metrics": val_metrics,
        "models": models,
        "label_encoders": label_encoders,
    }
    return ckpt


def predict_random_forest_multihead(ckpt: Dict, X: np.ndarray, cfg: ManeuverConfig) -> Dict[int, np.ndarray]:
    """Return probabilities per horizon, aligned like predict_transformer_multihead."""
    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    out: Dict[int, np.ndarray] = {}

    for steps in unique_horizon_steps(cfg):
        import pandas as pd
        steps = int(steps)
        model = ckpt["models"][steps]
        y_dummy = np.zeros((X.shape[0],), dtype=np.int64)
        Xw, _ = make_windows(X, y_dummy, steps_ahead=steps, window=window)
        feats = np.stack([_window_stats_features(W) for W in Xw], axis=0).astype(np.float32)
        feats = pd.DataFrame(feats, columns=[f"f{i}" for i in range(feats.shape[1])])
        probs_local = model.predict_proba(feats)
        le = ckpt.get("label_encoders", {}).get(steps)
        if le is not None:
            n_classes_global = ckpt["n_classes"]
            N = probs_local.shape[0]
            probs_global = np.zeros((N, n_classes_global), dtype=np.float32)
            for local_i, global_label in enumerate(le.classes_):
                probs_global[:, global_label] = probs_local[:, local_i]
            out[steps] = probs_global
        else:
            out[steps] = probs_local.astype(np.float32)
    return out


def save_random_forest_checkpoint(ckpt: Dict, path) -> None:
    import joblib
    joblib.dump(ckpt, path)


def load_random_forest_checkpoint(path) -> Dict:
    import joblib
    return joblib.load(path)
