from __future__ import annotations

import argparse
import contextlib
import json
import time
from dataclasses import asdict
from pathlib import Path
from typing import Dict, List, Optional, Tuple

import numpy as np

from twimo.data.manifest import load_manifest, save_manifest
from twimo.data.scan_hdd import scan_hdd_release
from twimo.data.scan_csv import scan_csv_bundle
from twimo.data.csv_session import load_sensors_from_csv_dir, resample_sensors, derive_proxy_actions
from twimo.data.prealigned import maybe_load_prealigned
from twimo.models.maneuver_transformer import ManeuverConfig, train_transformer_multihead, predict_transformer_multihead
from twimo.models.baseline_window import train_baseline_multihead, predict_baseline_multihead, save_baseline_checkpoint, load_baseline_checkpoint
from twimo.models.xgboost_model import train_xgboost_multihead, predict_xgboost_multihead, save_xgboost_checkpoint, load_xgboost_checkpoint
from twimo.models.random_forest_model import train_random_forest_multihead, predict_random_forest_multihead, save_random_forest_checkpoint, load_random_forest_checkpoint
from twimo.models.lightgbm_model import train_lightgbm_multihead, predict_lightgbm_multihead, save_lightgbm_checkpoint, load_lightgbm_checkpoint
from twimo.models.gru_lstm_model import train_gru_lstm_multihead, predict_gru_lstm_multihead
from twimo.models.tcn_model import train_tcn_multihead, predict_tcn_multihead
from twimo.models.mlp_pooling_model import train_mlp_pooling_multihead, predict_mlp_pooling_multihead
from twimo.models.style import compute_style_features, cluster_styles, name_clusters
from twimo.utils.io import ensure_dir, write_jsonl
from twimo.utils.profiling import TrainingProfiler, measure_inference_time, save_combined_metrics, ProfilingMetrics

from sklearn.metrics import (
    accuracy_score, precision_score, recall_score, f1_score,
    roc_auc_score, confusion_matrix, roc_curve,
)


DEFAULT_LABELS = [
    "STRAIGHT", "TURN_LEFT", "TURN_RIGHT", "BRAKE", "ACCEL", "STOP",
    # HDD (prealigned) actions (0-11) will be treated as generic if you don't provide names
]


def _compute_comprehensive_metrics(
    y_true: np.ndarray,
    y_pred: np.ndarray,
    y_probs: np.ndarray | None,
    n_classes: int,
    label_names: List[str],
) -> Dict:
    """Compute comprehensive classification metrics.

    Returns dict with accuracy, precision, recall, F1, ROC-AUC,
    confusion matrix, and per-class TP/TN/FP/FN.
    """
    n = len(y_true)
    acc = float(accuracy_score(y_true, y_pred))

    prec_macro = float(precision_score(y_true, y_pred, average='macro', zero_division=0.0))
    prec_weighted = float(precision_score(y_true, y_pred, average='weighted', zero_division=0.0))
    rec_macro = float(recall_score(y_true, y_pred, average='macro', zero_division=0.0))
    rec_weighted = float(recall_score(y_true, y_pred, average='weighted', zero_division=0.0))
    f1_mac = float(f1_score(y_true, y_pred, average='macro', zero_division=0.0))
    f1_wt = float(f1_score(y_true, y_pred, average='weighted', zero_division=0.0))

    # Per-class metrics
    prec_per = precision_score(y_true, y_pred, average=None, zero_division=0.0, labels=list(range(n_classes)))
    rec_per = recall_score(y_true, y_pred, average=None, zero_division=0.0, labels=list(range(n_classes)))
    f1_per = f1_score(y_true, y_pred, average=None, zero_division=0.0, labels=list(range(n_classes)))

    # Confusion matrix
    cm = confusion_matrix(y_true, y_pred, labels=list(range(n_classes)))

    # ROC-AUC (requires probabilities)
    roc_auc_mac = None
    roc_auc_wt = None
    if y_probs is not None and n_classes > 1:
        try:
            # Subset to classes actually present in y_true so roc_auc_score does not
            # raise ValueError when val/test splits miss some classes (e.g. no STOP events).
            present = np.unique(y_true).tolist()
            if len(present) >= 2:
                y_probs_sub = y_probs[:, present]
                row_sums = y_probs_sub.sum(axis=1, keepdims=True)
                y_probs_sub = y_probs_sub / np.where(row_sums == 0, 1.0, row_sums)
                roc_auc_mac = float(roc_auc_score(y_true, y_probs_sub, average='macro', multi_class='ovr', labels=present))
                roc_auc_wt = float(roc_auc_score(y_true, y_probs_sub, average='weighted', multi_class='ovr', labels=present))
        except ValueError:
            pass  # Not enough variation in y_true for ROC-AUC

    # Per-class TP/TN/FP/FN from confusion matrix
    per_class = {}
    for c in range(n_classes):
        tp = int(cm[c, c])
        fp = int(cm[:, c].sum() - tp)
        fn = int(cm[c, :].sum() - tp)
        tn = int(cm.sum() - tp - fp - fn)
        cname = label_names[c] if c < len(label_names) else f"class_{c}"
        per_class[cname] = {
            "precision": round(float(prec_per[c]), 4),
            "recall": round(float(rec_per[c]), 4),
            "f1": round(float(f1_per[c]), 4),
            "tp": tp, "fp": fp, "fn": fn, "tn": tn,
        }

    result = {
        "n": n,
        "accuracy": round(acc, 4),
        "precision_macro": round(prec_macro, 4),
        "precision_weighted": round(prec_weighted, 4),
        "recall_macro": round(rec_macro, 4),
        "recall_weighted": round(rec_weighted, 4),
        "f1_macro": round(f1_mac, 4),
        "f1_weighted": round(f1_wt, 4),
        "roc_auc_macro": round(roc_auc_mac, 4) if roc_auc_mac is not None else None,
        "roc_auc_weighted": round(roc_auc_wt, 4) if roc_auc_wt is not None else None,
        "confusion_matrix": cm.tolist(),
        "per_class": per_class,
    }
    return result


# -----------------------------
# scan
# -----------------------------

def cmd_scan(args: argparse.Namespace) -> None:
    root = Path(args.root)
    out = Path(args.out)
    outdir = ensure_dir(out.parent)

    # Initialize profiler
    profiler = TrainingProfiler(
        model_name="scan",
        output_dir=outdir,
        use_codecarbon=True,
    )

    with profiler:
        pre_labels = Path(args.prealigned_labels_dir) if args.prealigned_labels_dir else None
        pre_sensors = Path(args.prealigned_sensors_dir) if args.prealigned_sensors_dir else None

        recs = list(scan_hdd_release(root, prealigned_labels_dir=pre_labels, prealigned_sensors_dir=pre_sensors))
        # Fallback: if the path does not look like a full HDD release, treat it as a CSV-only bundle.
        if len(recs) == 0 and root.is_dir():
            recs = list(scan_csv_bundle(root))
        save_manifest(out, recs)

    print(f"Wrote manifest with {len(recs)} sessions -> {out}")


# -----------------------------
# splitting & loading
# -----------------------------

def _split_by_day(records, test_ratio: float = 0.2):
    """Deterministic split primarily by *day*.

    Rationale: HDD does not always provide a stable driver identity. A day-level split
    reduces the risk of temporal leakage (same trip fragments in both sets) and
    approximates a "driver unseen" split when sessions are grouped by data collection.

    Edge cases:
    - If there is only one day in the manifest, we fall back to a deterministic
      *session-level* split so that the quickstart can run.
    """
    by_day = {}
    for r in records:
        by_day.setdefault(r.day_id or 'unknown', []).append(r)
    days = sorted(by_day.keys())

    # If we only have one day, split sessions within that day.
    if len(days) <= 1:
        recs = sorted(records, key=lambda x: x.session_id)
        if len(recs) <= 1:
            return recs, [], []
        n_test = int(round(len(recs) * test_ratio))
        n_test = max(1, n_test)
        n_test = min(n_test, len(recs) - 1)  # keep at least one train session
        te = recs[-n_test:]
        tr = recs[:-n_test]
        return tr, te, []

    # Multi-day case: keep at least one day for training.
    n_test = max(1, int(round(len(days) * test_ratio)))
    n_test = min(n_test, len(days) - 1)
    test_days = set(days[-n_test:])
    tr, te = [], []
    for d in days:
        (te if d in test_days else tr).extend(by_day[d])
    return tr, te, sorted(test_days)


def _canonical_video_extractor(name: str) -> str:
    """Map user-friendly aliases to canonical backbone names."""
    if name in ('resnet', 'resnet18'):
        return 'resnet18'
    if name in ('mobilenet', 'mobilenet_v3_small'):
        return 'mobilenet_v3_small'
    return name


def _load_session_features(
    record,
    sample_hz: float,
    use_video: bool,
    video_extractor: str,
    video_cache: Path,
    max_frames: Optional[int],
    video_fps: Optional[float] = None,
) -> Tuple[Optional[np.ndarray], np.ndarray, np.ndarray, List[str]]:
    """Load (t, X, y, feat_names) for a session.

    - If prealigned arrays exist: load them (fast path).
    - Else: load CSV sensors, resample, and derive proxy actions.

    If use_video=True and record.video_path is available, concatenate video embeddings.
    """
    # 1) Prealigned fast path
    pre = maybe_load_prealigned(record.prealigned_sensor_npy, record.prealigned_target_npy)
    if pre is not None:
        X = pre.sensor.astype(np.float32)
        y = pre.target.astype(np.int64)
        t = np.arange(X.shape[0], dtype=np.float64) / float(sample_hz)
        feat_names = [f"sensor_{i}" for i in range(X.shape[1])]
        # Optional video: align by trimming
        if use_video and record.video_path:
            from twimo.video.torch_extractor import extract_video_features_torch
            cache_path = video_cache / f"rgb_{record.session_id}.npy"
            vf = extract_video_features_torch(
                Path(record.video_path),
                fps=float(video_fps or sample_hz),
                backbone=_canonical_video_extractor(video_extractor),
                cache_path=cache_path,
                max_frames=max_frames,
            )
            V = vf.features.astype(np.float32)
            T = min(X.shape[0], V.shape[0])
            X = np.concatenate([X[:T], V[:T]], axis=1)
            y = y[:T]
            t = t[:T]
            feat_names = feat_names + [f"video_{i}" for i in range(V.shape[1])]
        return t, X, y, feat_names

    # 2) CSV-only path (proxy labels)
    if not record.csv_dir:
        raise ValueError(f"Session {record.session_id} has no csv_dir and no prealigned arrays")

    frames = load_sensors_from_csv_dir(Path(record.csv_dir))
    t, X, feat_names = resample_sensors(frames, sample_hz=sample_hz)
    y = derive_proxy_actions(X, feat_names)

    if use_video and record.video_path:
        from twimo.video.torch_extractor import extract_video_features_torch
        cache_path = video_cache / f"rgb_{record.session_id}.npy"
        vf = extract_video_features_torch(
            Path(record.video_path),
            fps=float(video_fps or sample_hz),
            backbone=_canonical_video_extractor(video_extractor),
            cache_path=cache_path,
            max_frames=max_frames,
        )
        V = vf.features.astype(np.float32)
        T = min(X.shape[0], V.shape[0])
        X = np.concatenate([X[:T], V[:T]], axis=1)
        y = y[:T]
        t = t[:T]
        feat_names = feat_names + [f"video_{i}" for i in range(V.shape[1])]

    return t, X, y, feat_names


# -----------------------------
# train-maneuver
# -----------------------------

def _train_model(model_kind: str, X_train, y_train, X_val, y_val, n_classes: int, cfg, outdir: Path, class_weights: np.ndarray | None = None):
    """Helper function to train a model and save checkpoint."""
    if model_kind == 'transformer':
        import torch
        ckpt = train_transformer_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg, class_weights=class_weights)
        torch.save(ckpt, outdir / 'maneuver_transformer.pt')
        (outdir / 'model_kind.txt').write_text('transformer', encoding='utf-8')
    elif model_kind == 'baseline':
        ckpt = train_baseline_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg)
        save_baseline_checkpoint(ckpt, outdir / 'baseline.joblib')
        (outdir / 'model_kind.txt').write_text('baseline', encoding='utf-8')
    elif model_kind == 'xgboost':
        ckpt = train_xgboost_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg)
        save_xgboost_checkpoint(ckpt, outdir / 'xgboost.joblib')
        (outdir / 'model_kind.txt').write_text('xgboost', encoding='utf-8')
    elif model_kind == 'random_forest':
        ckpt = train_random_forest_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg)
        save_random_forest_checkpoint(ckpt, outdir / 'random_forest.joblib')
        (outdir / 'model_kind.txt').write_text('random_forest', encoding='utf-8')
    elif model_kind == 'lightgbm':
        ckpt = train_lightgbm_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg)
        save_lightgbm_checkpoint(ckpt, outdir / 'lightgbm.joblib')
        (outdir / 'model_kind.txt').write_text('lightgbm', encoding='utf-8')
    elif model_kind == 'gru':
        import torch
        ckpt = train_gru_lstm_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg, use_gru=True, class_weights=class_weights)
        torch.save(ckpt, outdir / 'gru.pt')
        (outdir / 'model_kind.txt').write_text('gru', encoding='utf-8')
    elif model_kind == 'lstm':
        import torch
        ckpt = train_gru_lstm_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg, use_gru=False, class_weights=class_weights)
        torch.save(ckpt, outdir / 'lstm.pt')
        (outdir / 'model_kind.txt').write_text('lstm', encoding='utf-8')
    elif model_kind == 'tcn':
        import torch
        ckpt = train_tcn_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg, class_weights=class_weights)
        torch.save(ckpt, outdir / 'tcn.pt')
        (outdir / 'model_kind.txt').write_text('tcn', encoding='utf-8')
    elif model_kind == 'mlp_mean':
        import torch
        ckpt = train_mlp_pooling_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg, pooling_type='mean', class_weights=class_weights)
        torch.save(ckpt, outdir / 'mlp_mean.pt')
        (outdir / 'model_kind.txt').write_text('mlp_mean', encoding='utf-8')
    elif model_kind == 'mlp_max':
        import torch
        ckpt = train_mlp_pooling_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg, pooling_type='max', class_weights=class_weights)
        torch.save(ckpt, outdir / 'mlp_max.pt')
        (outdir / 'model_kind.txt').write_text('mlp_max', encoding='utf-8')
    elif model_kind == 'mlp_concat':
        import torch
        ckpt = train_mlp_pooling_multihead(X_train, y_train, X_val, y_val, n_classes=n_classes, cfg=cfg, pooling_type='concat', class_weights=class_weights)
        torch.save(ckpt, outdir / 'mlp_concat.pt')
        (outdir / 'model_kind.txt').write_text('mlp_concat', encoding='utf-8')
    else:
        raise ValueError("--model must be one of: transformer, baseline, xgboost, random_forest, lightgbm, gru, lstm, tcn, mlp_mean, mlp_max, mlp_concat")

    return ckpt


def cmd_train_maneuver(args: argparse.Namespace) -> None:
    from dataclasses import replace as dc_replace

    records = load_manifest(Path(args.manifest))
    outdir = ensure_dir(Path(args.outdir))

    tr, te, test_days = _split_by_day(records, test_ratio=args.test_ratio)
    print(f"Split by day -> train sessions: {len(tr)} | test sessions: {len(te)} | test_days={test_days}")

    # ── EAF target override ───────────────────────────────────────────────────
    target = getattr(args, 'target', 'proxy')
    label_vocab: dict = {}  # int class_id -> label name (populated for EAF targets)

    if target != 'proxy':
        # Resolve target dir
        target_dir = Path(args.target_dir) if getattr(args, 'target_dir', None) else None
        if target_dir is None:
            manifest_parent = Path(args.manifest).parent
            candidates = [
                manifest_parent.parent / 'sensors_v2' / f'target_{target}',
                manifest_parent / f'target_{target}',
                manifest_parent / 'target',
            ]
            for c in candidates:
                if c.is_dir():
                    target_dir = c
                    break
        if target_dir is None or not target_dir.is_dir():
            print(f"[!] --target={target}: cannot find target directory.")
            print(f"    Pass --target-dir explicitly. Tried: {[str(c) for c in candidates]}")
            import sys; sys.exit(1)
        print(f"[target] dir: {target_dir}")

        # Override prealigned_target_npy in each record; drop sessions with missing .npy
        def _override(rec):
            npy = target_dir / f"{rec.session_id}.npy"
            return dc_replace(rec, prealigned_target_npy=npy) if npy.exists() else None

        tr = [r for r in (_override(r) for r in tr) if r is not None]
        te = [r for r in (_override(r) for r in te) if r is not None]
        print(f"[target] After override: train={len(tr)}, test={len(te)} sessions")

        # Resolve vocab file
        vocab_file = Path(args.vocab_file) if getattr(args, 'vocab_file', None) else None
        if vocab_file is None:
            manifest_parent = Path(args.manifest).parent
            for c in [
                manifest_parent.parent / 'vocabs' / f'vocab_{target}.json',
                manifest_parent / 'vocabs' / f'vocab_{target}.json',
            ]:
                if c.exists():
                    vocab_file = c
                    break
        if vocab_file and vocab_file.exists():
            vd = json.loads(vocab_file.read_text(encoding='utf-8'))
            vocab = vd.get('vocab', {})
            label_vocab = {int(v): str(k) for k, v in vocab.items()}
            print(f"[target] vocab: {label_vocab}")
        else:
            print(f"[target] no vocab file found; class names will be numeric")

    sample_hz = float(args.sample_hz)
    use_video = bool(args.use_video)
    video_extractor = args.video_extractor
    video_fps = float(args.video_fps) if getattr(args, 'video_fps', None) is not None else sample_hz
    video_cache = ensure_dir(outdir / 'video_cache') if args.video_cache is None else ensure_dir(Path(args.video_cache))
    max_frames = args.max_frames

    # Load and concatenate sessions
    X_tr_list, y_tr_list = [], []
    X_te_list, y_te_list = [], []

    feat_names: List[str] = []

    for r in tr:
        _, X, y, fn = _load_session_features(
            r,
            sample_hz,
            use_video,
            video_extractor,
            video_cache,
            max_frames,
            video_fps=video_fps,
        )
        feat_names = fn
        X_tr_list.append(X)
        y_tr_list.append(y)

    for r in te:
        _, X, y, _ = _load_session_features(
            r,
            sample_hz,
            use_video,
            video_extractor,
            video_cache,
            max_frames,
            video_fps=video_fps,
        )
        X_te_list.append(X)
        y_te_list.append(y)

    X_train = np.concatenate(X_tr_list, axis=0)
    y_train = np.concatenate(y_tr_list, axis=0)

    # Some small manifests (e.g., the quickstart example) may not have enough days/sessions
    # to allocate a non-empty test split. Handle this gracefully.
    if len(X_te_list) > 0:
        X_test = np.concatenate(X_te_list, axis=0)
        y_test = np.concatenate(y_te_list, axis=0)
    else:
        X_test = X_train[:0]
        y_test = y_train[:0]

    # Simple val split from train tail
    n = X_train.shape[0]
    n_val = max(1, int(n * 0.1))
    X_val = X_train[-n_val:]
    y_val = y_train[-n_val:]
    X_train2 = X_train[:-n_val]
    y_train2 = y_train[:-n_val]

    # Remap labels to contiguous [0, n_classes-1] for compatibility with
    # tree-based models (XGBoost, LightGBM, RF) that require contiguous labels.
    from sklearn.preprocessing import LabelEncoder
    _label_enc = LabelEncoder()
    _label_enc.fit(np.concatenate([y_train, y_test]) if y_test.shape[0] > 0 else y_train)
    y_train = _label_enc.transform(y_train)
    y_test = _label_enc.transform(y_test) if y_test.shape[0] > 0 else y_test

    # Re-split val after encoding
    y_val = y_train[-n_val:]
    y_train2 = y_train[:-n_val]

    n_classes = len(_label_enc.classes_)
    print(f"Labels remapped to [0..{n_classes-1}] (original classes: {_label_enc.classes_.tolist()})")

    # Compute inverse-frequency class weights for balanced training
    class_counts = np.bincount(y_train2, minlength=n_classes).astype(np.float64)
    class_counts = np.maximum(class_counts, 1.0)  # avoid division by zero
    class_weights = (1.0 / class_counts)
    class_weights = class_weights / class_weights.sum() * n_classes  # normalize so mean weight = 1
    print(f"Class weights (inverse-frequency): {dict(zip(range(n_classes), class_weights.round(4).tolist()))}")

    cfg = ManeuverConfig(
        window_seconds=args.window_seconds,
        sample_hz=sample_hz,
        horizons_seconds=[float(h) for h in args.horizons] if args.horizons else None,
        epochs=args.epochs,
        batch_size=args.batch_size,
        lr=args.lr,
        d_model=args.d_model,
        nhead=args.nhead,
        num_layers=args.num_layers,
    )

    model_kind = str(args.model).lower()

    # Initialize profiler
    use_profiling = not args.disable_profiling if hasattr(args, 'disable_profiling') else True
    profiler = TrainingProfiler(
        model_name=model_kind,
        output_dir=outdir,
        use_codecarbon=use_profiling,
    ) if use_profiling else None

    # Train and evaluate — all phases inside one context for CodeCarbon task tracking
    _profiler_ctx = profiler if profiler else contextlib.nullcontext()
    with _profiler_ctx:
        # ── Phase: model training ─────────────────────────────────────────────
        if profiler:
            profiler.begin_phase("training", n_samples=int(X_train2.shape[0]))
        ckpt = _train_model(model_kind, X_train2, y_train2, X_val, y_val, n_classes, cfg, outdir, class_weights=class_weights)
        if profiler:
            profiler.end_phase("training")

        # Save common artifacts
        (outdir / 'feature_names.json').write_text(json.dumps(feat_names, indent=2), encoding='utf-8')
        cfg_dict = asdict(cfg)
        cfg_dict['target'] = target  # record which target was used
        (outdir / 'config.json').write_text(json.dumps(cfg_dict, indent=2), encoding='utf-8')
        # Save label mapping: encoded_idx -> original class id or name
        label_map = {}
        for i, c in enumerate(_label_enc.classes_):
            orig = int(c)
            label_map[int(i)] = label_vocab.get(orig, orig)
        (outdir / 'label_map.json').write_text(json.dumps(label_map, indent=2), encoding='utf-8')

        # --- Helper: predict with any model ---
        def _predict(X_data):
            if model_kind == 'transformer':
                return predict_transformer_multihead(ckpt, X_data, cfg)
            elif model_kind == 'baseline':
                return predict_baseline_multihead(ckpt, X_data, cfg)
            elif model_kind == 'xgboost':
                return predict_xgboost_multihead(ckpt, X_data, cfg)
            elif model_kind == 'random_forest':
                return predict_random_forest_multihead(ckpt, X_data, cfg)
            elif model_kind == 'lightgbm':
                return predict_lightgbm_multihead(ckpt, X_data, cfg)
            elif model_kind in ['gru', 'lstm']:
                return predict_gru_lstm_multihead(ckpt, X_data, cfg)
            elif model_kind == 'tcn':
                return predict_tcn_multihead(ckpt, X_data, cfg)
            elif model_kind in ['mlp_mean', 'mlp_max', 'mlp_concat']:
                return predict_mlp_pooling_multihead(ckpt, X_data, cfg)
            else:
                raise ValueError(f"Unknown model_kind: {model_kind}")

        # --- Shared setup for metrics computation ---
        from twimo.models.maneuver_transformer import horizon_steps
        _steps_list = horizon_steps(cfg)
        window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))

        # Resolve label names for per-class output
        _lbl_names = []
        for i in range(n_classes):
            orig_class = int(_label_enc.classes_[i]) if i < len(_label_enc.classes_) else i
            if label_vocab and orig_class in label_vocab:
                _lbl_names.append(label_vocab[orig_class])
            elif orig_class < len(DEFAULT_LABELS):
                _lbl_names.append(DEFAULT_LABELS[orig_class])
            else:
                _lbl_names.append(f"class_{orig_class}")

        def _compute_split_metrics(probs_by_steps, y_data, split_name, print_table=False):
            """Compute comprehensive metrics + ROC curves for a data split.

            Each horizon entry gains a ``_timing_s`` field (Level 1: wall-clock time
            for metric computation of that horizon slice).
            """
            split_metrics: Dict = {}
            split_roc: Dict = {}

            if print_table:
                print(f"\n{'Horizon':<10} {'Acc':>7} {'F1-mac':>7} {'F1-wt':>7} {'Prec-m':>7} {'Rec-m':>7} {'AUC-m':>7}")
                print("-" * 62)

            # Iterate over horizons_seconds to handle step collisions
            for h_sec, h_step in zip(cfg.horizons_seconds, _steps_list):
                h_key = f"{h_sec}s"
                probs = probs_by_steps.get(h_step)
                if probs is None:
                    continue

                _h_t0 = time.time()  # Level 1: per-horizon metric timing

                steps_ahead = int(h_step)
                end = y_data.shape[0] - steps_ahead
                y_true = y_data[window:end]
                y_pred = probs.argmax(axis=1)
                n_eval = min(len(y_pred), len(y_true))
                y_true = y_true[:n_eval]
                y_pred = y_pred[:n_eval]
                y_probs_h = probs[:n_eval]

                m = _compute_comprehensive_metrics(y_true, y_pred, y_probs_h, n_classes, _lbl_names)
                m["horizon_seconds"] = h_sec
                m["horizon_steps"] = steps_ahead
                m["_timing_s"] = round(time.time() - _h_t0, 6)  # Level 1: store
                split_metrics[h_key] = m

                # ROC curves (per-class FPR/TPR)
                h_roc = {}
                if y_probs_h is not None and n_classes > 1:
                    for c in range(n_classes):
                        cname = _lbl_names[c] if c < len(_lbl_names) else f"class_{c}"
                        y_bin = (y_true == c).astype(int)
                        scores = y_probs_h[:, c]
                        if y_bin.sum() > 0 and y_bin.sum() < len(y_bin) and not np.isnan(scores).any():
                            fpr, tpr, _ = roc_curve(y_bin, scores)
                            h_roc[cname] = {"fpr": fpr.tolist(), "tpr": tpr.tolist()}
                split_roc[h_key] = h_roc

                if print_table:
                    auc_str = f"{m['roc_auc_macro']:.4f}" if m['roc_auc_macro'] is not None else "  N/A"
                    print(f"{h_key:<10} {m['accuracy']:>7.4f} {m['f1_macro']:>7.4f} {m['f1_weighted']:>7.4f} {m['precision_macro']:>7.4f} {m['recall_macro']:>7.4f} {auc_str:>7}")

            return split_metrics, split_roc

        # ── Phase: training-set inference ─────────────────────────────────────
        if profiler:
            profiler.begin_phase("train_inference", n_samples=int(X_train2.shape[0]))
        print("\n--- Training Metrics ---")
        train_probs = _predict(X_train2)
        if profiler:
            profiler.end_phase("train_inference")
        train_metrics, train_roc = _compute_split_metrics(train_probs, y_train2, "train", print_table=True)
        (outdir / 'train_metrics.json').write_text(json.dumps(train_metrics, indent=2), encoding='utf-8')
        print(f"Saved training metrics -> {outdir / 'train_metrics.json'}")

        # ── Phase: validation-set inference ───────────────────────────────────
        if profiler:
            profiler.begin_phase("val_inference", n_samples=int(X_val.shape[0]))
        print("\n--- Validation Metrics ---")
        val_probs = _predict(X_val)
        if profiler:
            profiler.end_phase("val_inference")
        val_metrics, val_roc = _compute_split_metrics(val_probs, y_val, "val", print_table=True)
        (outdir / 'val_metrics.json').write_text(json.dumps(val_metrics, indent=2), encoding='utf-8')
        print(f"Saved validation metrics -> {outdir / 'val_metrics.json'}")

        # ── Phase: test-set inference ──────────────────────────────────────────
        metrics: Dict = {}
        test_roc: Dict = {}
        if X_test.shape[0] > 0:
            if profiler:
                profiler.begin_phase("test_inference", n_samples=int(X_test.shape[0]))
            print("\n--- Test Metrics ---")
            print("[Profiling] Measuring inference time...")
            inference_start = time.time()
            test_probs = _predict(X_test)
            inference_time = time.time() - inference_start
            if profiler:
                profiler.end_phase("test_inference")

            metrics, test_roc = _compute_split_metrics(test_probs, y_test, "test", print_table=True)

            # Add inference metrics
            throughput = X_test.shape[0] / inference_time if inference_time > 0 else 0
            metrics['_inference'] = {
                'inference_time_seconds': inference_time,
                'inference_samples': int(X_test.shape[0]),
                'throughput_samples_per_sec': throughput,
            }
            print(f"\n[Profiling] Inference time: {inference_time:.2f}s ({throughput:.1f} samples/sec)")

        else:
            metrics = {"note": "No held-out test split was created (manifest too small)."}

        # Save test metrics
        (outdir / 'test_metrics.json').write_text(json.dumps(metrics, indent=2), encoding='utf-8')

        # Save ROC curves (all splits in one file)
        roc_all = {"train": train_roc, "val": val_roc, "test": test_roc}
        (outdir / 'roc_curves.json').write_text(json.dumps(roc_all, indent=2), encoding='utf-8')
        print(f"Saved ROC curves -> {outdir / 'roc_curves.json'}")

        # --- DTE Framework mapping: Predictor metadata ---
        # Serializes a twimo_objects.Predictor record so the output artefacts are
        # explicitly linked to the DTE metamodel (model.aiBasedServices.prediction.Predictor).
        from twimo.framework.twimo_objects import Predictor as _PredictorMeta
        _pred_meta = _PredictorMeta(
            name=f"ManeuverPredictor_{model_kind}",
            horizons_sec=list(cfg.horizons_seconds),
            model_type=model_kind,
            artifacts={
                "outdir": str(outdir),
                "config_path": str(outdir / "config.json"),
                "test_metrics_path": str(outdir / "test_metrics.json"),
                "_dte_class": "model.aiBasedServices.prediction.Predictor",
            },
        )
        (outdir / 'predictor_metadata.json').write_text(
            json.dumps({
                "name": _pred_meta.name,
                "horizons_sec": _pred_meta.horizons_sec,
                "model_type": _pred_meta.model_type,
                "artifacts": _pred_meta.artifacts,
            }, indent=2),
            encoding='utf-8',
        )

        # --- DTE Framework mapping: DigitalTwin design blueprint ---
        from twimo.framework.twimo_components import instantiate_hdd_driving_behavior_twin as _hdd_twin
        _twin = _hdd_twin(
            root=str(args.manifest),
            sample_hz=cfg.sample_hz,
            extractor=video_extractor if use_video else "none",
        )
        (outdir / 'twin_config.json').write_text(
            json.dumps({
                "name": _twin.name,
                "physical_system": _twin.physical_system,
                "dataset": {"name": _twin.dataset.name,
                            "sources": [{"name": s.name, "modality": s.modality} for s in _twin.dataset.sources]},
                "perception": {"extractor": _twin.perception.extractor, "sample_hz": _twin.perception.sample_hz},
                "driving_model": {"task": _twin.driving_model.task, "model_type": model_kind},
                "_dte_class": "digitalTwin.DigitalTwin",
            }, indent=2),
            encoding='utf-8',
        )

    # Combine with profiling metrics if available
    if profiler and hasattr(profiler, 'metrics'):
        save_combined_metrics(profiler.metrics, metrics, outdir)

    print(f"\nSaved {model_kind} model to {outdir}.")


# -----------------------------
# simulate-dt
# -----------------------------

def cmd_simulate_dt(args: argparse.Namespace) -> None:
    """Evaluate a minimal kinematic bicycle Digital Twin against RTK ground truth.

    Requires HDD CSV exports containing at least:
    - rtk_pos.csv (lng, lat)
    - rtk_track.csv (GPS_course, GPS_Yaw(heading), ...)

    Output
    ------
    - dt_summary.csv / dt_summary.json (per-session metrics)
    - sim__<SESSION_ID>.csv (optional per-session trajectories)
    """
    import numpy as np
    import pandas as pd
    from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid
    from twimo.dt.simulator import simulate_kinematic_bicycle, evaluate_simulation, local_xy_to_latlng

    records = load_manifest(Path(args.manifest))
    outdir = ensure_dir(Path(args.outdir))

    sample_hz = float(args.sample_hz)

    max_sessions = args.max_sessions
    if max_sessions is not None and max_sessions <= 0:
        max_sessions = None

    # Initialize profiler
    profiler = TrainingProfiler(
        model_name="simulate_dt",
        output_dir=outdir,
        use_codecarbon=True,
    )

    with profiler:
        rows = []
        n_done = 0
        for r in records:
            if max_sessions is not None and n_done >= max_sessions:
                break
            if not r.csv_dir:
                continue

            try:
                df = load_run_sensors(Path(r.csv_dir))
                aligned = align_sensors_to_grid(df, hz=sample_hz)
            except Exception as e:
                rows.append({
                    "session_id": r.session_id,
                    "day_id": r.day_id,
                    "ok": False,
                    "error": f"Failed to load/align CSV sensors: {type(e).__name__}: {e}",
                })
                continue

            # -----------------------------
            # Unit normalization (HDD specifics)
            # -----------------------------
            # HDD "vel.csv" speed is typically provided in km/h.
            # The DT simulator uses m/s. We convert here and keep both columns for
            # debugging/verification.
            if 'speed' in aligned.columns and 'speed_mps' not in aligned.columns:
                sp = aligned['speed'].astype(float)
                # Heuristic: if the max speed is large, it is almost certainly km/h.
                sp_max = float(np.nanmax(sp.values)) if np.isfinite(sp.values).any() else float('nan')
                if np.isfinite(sp_max) and sp_max > 70.0:
                    aligned['speed_kmh'] = sp
                    aligned['speed_mps'] = sp / 3.6
                    aligned.attrs['speed_unit_inferred'] = 'km/h'
                else:
                    aligned['speed_mps'] = sp
                    aligned['speed_kmh'] = sp * 3.6
                    aligned.attrs['speed_unit_inferred'] = 'm/s'

                # Overwrite the generic "speed" column so DT uses m/s consistently.
                aligned['speed'] = aligned['speed_mps']

            try:
                sim = simulate_kinematic_bicycle(aligned, hz=sample_hz, wheelbase_m=float(args.wheelbase))
                metrics, traj = evaluate_simulation(aligned, sim)

                # Sanity-check fields (useful when validating a new dataset export)
                init_lat = float(aligned['lat'].iloc[0]) if 'lat' in aligned.columns and len(aligned) > 0 else None
                init_lng = float(aligned['lng'].iloc[0]) if 'lng' in aligned.columns and len(aligned) > 0 else None
                init_heading = None
                for col in ['GPS_Yaw(heading)', 'GPS_course', 'gps_yaw_heading', 'gps_course']:
                    if col in aligned.columns and len(aligned) > 0:
                        try:
                            init_heading = float(aligned[col].iloc[0])
                        except Exception:
                            init_heading = None
                        break

                metrics_row = {
                    "session_id": r.session_id,
                    "day_id": r.day_id,
                    "ok": True,
                    "init_lat": init_lat,
                    "init_lng": init_lng,
                    "init_heading_deg": init_heading,
                    "speed_unit_inferred": aligned.attrs.get('speed_unit_inferred', None),
                    **metrics,
                }
                rows.append(metrics_row)

                if args.save_traj:
                    # Augment the local XY trajectory with human-friendly signals
                    # so you can validate: (1) lat/lng are loaded correctly, (2) the
                    # initial yaw/heading is taken from rtk_track.csv, (3) speed units
                    # are sensible (km/h -> m/s conversion).

                    # Align lengths
                    nT = len(traj)
                    aligned_T = aligned.iloc[:nT].reset_index(drop=True)
                    out_traj = traj.copy().reset_index(drop=True)

                    # Ground-truth lat/lng from rtk_pos.csv (if available)
                    if 'lat' in aligned_T.columns:
                        out_traj['gt_lat'] = aligned_T['lat'].values
                    if 'lng' in aligned_T.columns:
                        out_traj['gt_lng'] = aligned_T['lng'].values

                    # Simulated lat/lng reconstructed from (x_sim_m, y_sim_m)
                    ref_lat = float(aligned_T['ref_lat'].iloc[0]) if 'ref_lat' in aligned_T.columns else None
                    ref_lng = float(aligned_T['ref_lng'].iloc[0]) if 'ref_lng' in aligned_T.columns else None
                    if ref_lat is not None and ref_lng is not None:
                        sim_lat, sim_lng = local_xy_to_latlng(
                            out_traj['x_sim_m'].values.astype(float),
                            out_traj['y_sim_m'].values.astype(float),
                            ref_lat=ref_lat,
                            ref_lng=ref_lng,
                        )
                        out_traj['sim_lat'] = sim_lat
                        out_traj['sim_lng'] = sim_lng

                    # Timestamp and heading debug
                    if 'unix_timestamp' in aligned_T.columns:
                        out_traj['unix_timestamp'] = aligned_T['unix_timestamp'].values
                    for col in ['GPS_Yaw(heading)', 'GPS_course', 'gps_yaw_heading', 'gps_course']:
                        if col in aligned_T.columns:
                            out_traj['gt_heading_deg'] = aligned_T[col].values
                            break

                    # Speed/steering debug
                    if 'speed_mps' in aligned_T.columns:
                        out_traj['speed_mps'] = aligned_T['speed_mps'].values
                    if 'speed_kmh' in aligned_T.columns:
                        out_traj['speed_kmh'] = aligned_T['speed_kmh'].values
                    if 'steer_angle_rad' in aligned_T.columns:
                        out_traj['steer_angle_rad'] = aligned_T['steer_angle_rad'].values

                    traj_path = outdir / f"sim__{r.session_id}.csv"
                    out_traj.to_csv(traj_path, index=False)

                n_done += 1
            except Exception as e:
                rows.append({
                    "session_id": r.session_id,
                    "day_id": r.day_id,
                    "ok": False,
                    "error": f"DT simulation failed: {type(e).__name__}: {e}",
                })

        # Write summary
        df_sum = pd.DataFrame(rows)
        df_sum.to_csv(outdir / 'dt_summary.csv', index=False)
        (outdir / 'dt_summary.json').write_text(json.dumps(rows, indent=2), encoding='utf-8')

        # Backwards-compatible name
        (outdir / 'dt_metrics.json').write_text(json.dumps({"rows": rows}, indent=2), encoding='utf-8')

        # --- DTE Framework mapping: Run metadata ---
        # Serializes a twimo_objects.Run record linking the simulation result to the
        # DTE metamodel (digitalTwin.Run) and the PNG Release & Validation layer.
        import datetime as _dt
        _run_id = f"simulate_dt_{_dt.datetime.now().strftime('%Y%m%d_%H%M%S')}"
        _ok_rows_for_run = [_r for _r in rows if _r.get('ok', False) and _r.get('has_rtk', False)]
        _run_metrics = {}
        if _ok_rows_for_run:
            import numpy as _np_run
            _rmse_vals = [_r['rmse_xy_m'] for _r in _ok_rows_for_run if _r.get('rmse_xy_m') is not None]
            if _rmse_vals:
                _run_metrics['rmse_xy_m_mean'] = float(_np_run.mean(_rmse_vals))
                _run_metrics['rmse_xy_m_median'] = float(_np_run.median(_rmse_vals))
            _run_metrics['n_sessions'] = len(_ok_rows_for_run)
        (outdir / 'twin_run.json').write_text(
            json.dumps({
                "run_id": _run_id,
                "purpose": "validation",
                "config": {"wheelbase_m": args.wheelbase, "sample_hz": args.sample_hz},
                "metrics": _run_metrics,
                "_dte_class": "digitalTwin.Run",
                "_png_layer": "Release & Validation -> DT Validation Comparator",
            }, indent=2),
            encoding='utf-8',
        )

        # Compute global aggregated metrics across all successful sessions
        ok_rows = [r for r in rows if r.get('ok', False) and r.get('has_rtk', False)]
        if ok_rows:
            # Extract metric values
            metric_keys = [
                'rmse_x_m', 'rmse_y_m', 'rmse_xy_m',
                'mae_x_m', 'mae_y_m', 'mae_xy_m',
                'mape_xy_percent',
                'nrmse_mean', 'nrmse_range',
                'mean_rtk_distance_m', 'trajectory_range_m',
                'n',
                'duration_s',
            ]

            aggregated = {
                'n_sessions_total': len(rows),
                'n_sessions_ok': len(ok_rows),
                'n_sessions_with_rtk': len(ok_rows),
            }

            for key in metric_keys:
                values = [r[key] for r in ok_rows if r.get(key) is not None and np.isfinite(r.get(key, float('nan')))]
                if values:
                    aggregated[f'{key}_mean'] = float(np.mean(values))
                    aggregated[f'{key}_median'] = float(np.median(values))
                    aggregated[f'{key}_std'] = float(np.std(values))
                    aggregated[f'{key}_min'] = float(np.min(values))
                    aggregated[f'{key}_max'] = float(np.max(values))
                    aggregated[f'{key}_q1'] = float(np.percentile(values, 25))
                    aggregated[f'{key}_q3'] = float(np.percentile(values, 75))
                else:
                    aggregated[f'{key}_mean'] = None
                    aggregated[f'{key}_median'] = None
                    aggregated[f'{key}_std'] = None
                    aggregated[f'{key}_min'] = None
                    aggregated[f'{key}_max'] = None
                    aggregated[f'{key}_q1'] = None
                    aggregated[f'{key}_q3'] = None

            # Save aggregated metrics
            (outdir / 'dt_aggregated_metrics.json').write_text(
                json.dumps(aggregated, indent=2), encoding='utf-8'
            )

            print(f"\nGlobal Aggregated Metrics (n={len(ok_rows)} sessions):")
            print(f"  RMSE (x,y,xy): {aggregated['rmse_x_m_mean']:.3f}, {aggregated['rmse_y_m_mean']:.3f}, {aggregated['rmse_xy_m_mean']:.3f} m")
            print(f"  MAE (x,y,xy):  {aggregated['mae_x_m_mean']:.3f}, {aggregated['mae_y_m_mean']:.3f}, {aggregated['mae_xy_m_mean']:.3f} m")
            if aggregated['mape_xy_percent_mean'] is not None:
                print(f"  MAPE (xy):     {aggregated['mape_xy_percent_mean']:.2f}%")
            if aggregated['nrmse_mean_mean'] is not None:
                print(f"  NRMSE (mean):  {aggregated['nrmse_mean_mean']:.4f}")
            if aggregated['nrmse_range_mean'] is not None:
                print(f"  NRMSE (range): {aggregated['nrmse_range_mean']:.4f}")

        ok_n = int(df_sum['ok'].sum()) if 'ok' in df_sum.columns else 0
        print(f"\nDT simulation done. Sessions evaluated: {ok_n}/{len(rows)} -> {outdir}")


# -----------------------------
# simulate-dt-optimized
# -----------------------------

def cmd_simulate_dt_optimized(args: argparse.Namespace) -> None:
    """Optimized Digital Twin with parameter calibration and drift correction.

    Improvements over basic DT:
    1. Auto-calibrates vehicle parameters (wheelbase, speed scale, steering scale)
    2. Periodic position reset to RTK GPS (reduces drift)
    3. Better initial state estimation

    Output
    ------
    - dt_optimized_summary.csv / dt_optimized_summary.json (per-session metrics + calibrated params)
    - dt_optimized_aggregated_metrics.json (global statistics)
    - sim_optimized__<SESSION_ID>.csv (optional per-session trajectories)
    """
    import numpy as np
    import pandas as pd
    from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid
    from twimo.dt.optimized_simulator import (
        OptimizedDTConfig,
        simulate_and_evaluate_optimized,
        local_xy_to_latlng,
    )

    records = load_manifest(Path(args.manifest))
    outdir = ensure_dir(Path(args.outdir))

    sample_hz = float(args.sample_hz)

    # Create config
    config = OptimizedDTConfig(
        wheelbase_m=float(args.wheelbase),
        calibrate_params=args.calibrate,
        optimize_wheelbase=args.optimize_wheelbase,
        optimize_speed_scale=args.optimize_speed,
        optimize_steer_scale=args.optimize_steer,
        use_position_reset=args.use_reset,
        reset_interval_steps=args.reset_interval,
        use_multi_sample_init=args.multi_sample_init,
        init_samples=args.init_samples,
    )

    max_sessions = args.max_sessions
    if max_sessions is not None and max_sessions <= 0:
        max_sessions = None

    # Initialize profiler
    profiler = TrainingProfiler(
        model_name="simulate_dt_optimized",
        output_dir=outdir,
        use_codecarbon=True,
    )

    with profiler:
        rows = []
        n_done = 0
        for r in records:
            if max_sessions is not None and n_done >= max_sessions:
                break
            if not r.csv_dir:
                continue

            try:
                df = load_run_sensors(Path(r.csv_dir))
                aligned = align_sensors_to_grid(df, hz=sample_hz)
            except Exception as e:
                rows.append({
                    "session_id": r.session_id,
                    "day_id": r.day_id,
                    "ok": False,
                    "error": f"Failed to load/align CSV sensors: {type(e).__name__}: {e}",
                })
                continue

            # Unit normalization (same as basic DT)
            if 'speed' in aligned.columns and 'speed_mps' not in aligned.columns:
                sp = aligned['speed'].astype(float)
                sp_max = float(np.nanmax(sp.values)) if np.isfinite(sp.values).any() else float('nan')
                if np.isfinite(sp_max) and sp_max > 70.0:
                    aligned['speed_kmh'] = sp
                    aligned['speed_mps'] = sp / 3.6
                    aligned.attrs['speed_unit_inferred'] = 'km/h'
                else:
                    aligned['speed_mps'] = sp
                    aligned['speed_kmh'] = sp * 3.6
                    aligned.attrs['speed_unit_inferred'] = 'm/s'

                aligned['speed'] = aligned['speed_mps']

            try:
                sim, metrics, traj = simulate_and_evaluate_optimized(aligned, hz=sample_hz, config=config)

                # Sanity-check fields
                init_lat = float(aligned['lat'].iloc[0]) if 'lat' in aligned.columns and len(aligned) > 0 else None
                init_lng = float(aligned['lng'].iloc[0]) if 'lng' in aligned.columns and len(aligned) > 0 else None
                init_heading = None
                for col in ['GPS_Yaw(heading)', 'GPS_course', 'gps_yaw_heading', 'gps_course']:
                    if col in aligned.columns and len(aligned) > 0:
                        try:
                            init_heading = float(aligned[col].iloc[0])
                        except Exception:
                            init_heading = None
                        break

                metrics_row = {
                    "session_id": r.session_id,
                    "day_id": r.day_id,
                    "ok": True,
                    "init_lat": init_lat,
                    "init_lng": init_lng,
                    "init_heading_deg": init_heading,
                    "speed_unit_inferred": aligned.attrs.get('speed_unit_inferred', None),
                    **metrics,
                }
                rows.append(metrics_row)

                if args.save_traj:
                    # Save trajectory
                    nT = len(traj) if traj is not None else 0
                    if nT > 0:
                        aligned_T = aligned.iloc[:nT].reset_index(drop=True)
                        out_traj = traj.copy().reset_index(drop=True)

                        # Add ground-truth lat/lng
                        if 'lat' in aligned_T.columns:
                            out_traj['gt_lat'] = aligned_T['lat'].values
                        if 'lng' in aligned_T.columns:
                            out_traj['gt_lng'] = aligned_T['lng'].values

                        # Add simulated lat/lng
                        ref_lat = float(aligned_T['lat'].iloc[0]) if 'lat' in aligned_T.columns else None
                        ref_lng = float(aligned_T['lng'].iloc[0]) if 'lng' in aligned_T.columns else None
                        if ref_lat is not None and ref_lng is not None:
                            sim_lat, sim_lng = local_xy_to_latlng(
                                out_traj['x_sim_m'].values.astype(float),
                                out_traj['y_sim_m'].values.astype(float),
                                ref_lat=ref_lat,
                                ref_lng=ref_lng,
                            )
                            out_traj['sim_lat'] = sim_lat
                            out_traj['sim_lng'] = sim_lng

                        # Add speeds
                        if 'speed_mps' in aligned_T.columns:
                            out_traj['speed_mps'] = aligned_T['speed_mps'].values
                        if 'speed_kmh' in aligned_T.columns:
                            out_traj['speed_kmh'] = aligned_T['speed_kmh'].values

                        traj_path = outdir / f"sim_optimized__{r.session_id}.csv"
                        out_traj.to_csv(traj_path, index=False)

                n_done += 1
                print(f"[{n_done}/{len(records)}] {r.session_id}: RMSE={metrics.get('rmse_xy_m', 0):.1f}m "
                      f"(wheelbase={metrics['config']['wheelbase_m']:.2f}m, "
                      f"speed_scale={metrics['config']['speed_scale']:.3f}, "
                      f"steer_scale={metrics['config']['steer_scale']:.3f})")

            except Exception as e:
                rows.append({
                    "session_id": r.session_id,
                    "day_id": r.day_id,
                    "ok": False,
                    "error": f"Optimized DT simulation failed: {type(e).__name__}: {e}",
                })

        # Write summary
        df_sum = pd.DataFrame(rows)
        df_sum.to_csv(outdir / 'dt_optimized_summary.csv', index=False)
        (outdir / 'dt_optimized_summary.json').write_text(json.dumps(rows, indent=2), encoding='utf-8')

        # --- DTE Framework mapping: Run metadata (optimized DT) ---
        import datetime as _dt2
        _run_id2 = f"simulate_dt_optimized_{_dt2.datetime.now().strftime('%Y%m%d_%H%M%S')}"
        _ok_rows_opt = [_r for _r in rows if _r.get('ok', False) and _r.get('has_rtk', False)]
        _run_metrics2 = {}
        if _ok_rows_opt:
            import numpy as _np_run2
            _rmse_opt = [_r['rmse_xy_m'] for _r in _ok_rows_opt if _r.get('rmse_xy_m') is not None]
            if _rmse_opt:
                _run_metrics2['rmse_xy_m_mean'] = float(_np_run2.mean(_rmse_opt))
                _run_metrics2['rmse_xy_m_median'] = float(_np_run2.median(_rmse_opt))
            _run_metrics2['n_sessions'] = len(_ok_rows_opt)
        (outdir / 'twin_run.json').write_text(
            json.dumps({
                "run_id": _run_id2,
                "purpose": "validation",
                "config": {"sample_hz": args.sample_hz, "calibrate": not args.no_calibrate,
                           "reset_interval": args.reset_interval},
                "metrics": _run_metrics2,
                "_dte_class": "digitalTwin.Run",
                "_png_layer": "Release & Validation -> DT Validation Comparator",
            }, indent=2),
            encoding='utf-8',
        )

        # Compute global aggregated metrics
        ok_rows = [r for r in rows if r.get('ok', False) and r.get('has_rtk', False)]
        if ok_rows:
            # Extract metric values
            metric_keys = [
                'rmse_x_m', 'rmse_y_m', 'rmse_xy_m',
                'mae_x_m', 'mae_y_m', 'mae_xy_m',
                'mape_xy_percent',
                'nrmse_mean', 'nrmse_range',
                'mean_rtk_distance_m', 'trajectory_range_m',
                'n',
                'duration_s',
            ]

            aggregated = {
                'n_sessions_total': len(rows),
                'n_sessions_ok': len(ok_rows),
                'n_sessions_with_rtk': len(ok_rows),
            }

            for key in metric_keys:
                values = [r[key] for r in ok_rows if r.get(key) is not None and np.isfinite(r.get(key, float('nan')))]
                if values:
                    aggregated[f'{key}_mean'] = float(np.mean(values))
                    aggregated[f'{key}_median'] = float(np.median(values))
                    aggregated[f'{key}_std'] = float(np.std(values))
                    aggregated[f'{key}_min'] = float(np.min(values))
                    aggregated[f'{key}_max'] = float(np.max(values))
                    aggregated[f'{key}_q1'] = float(np.percentile(values, 25))
                    aggregated[f'{key}_q3'] = float(np.percentile(values, 75))
                else:
                    aggregated[f'{key}_mean'] = None
                    aggregated[f'{key}_median'] = None
                    aggregated[f'{key}_std'] = None
                    aggregated[f'{key}_min'] = None
                    aggregated[f'{key}_max'] = None
                    aggregated[f'{key}_q1'] = None
                    aggregated[f'{key}_q3'] = None

            # Add calibrated parameters stats
            if 'config' in ok_rows[0]:
                param_keys = ['wheelbase_m', 'speed_scale', 'steer_scale']
                for param in param_keys:
                    values = [r['config'][param] for r in ok_rows if 'config' in r and param in r['config']]
                    if values:
                        aggregated[f'{param}_mean'] = float(np.mean(values))
                        aggregated[f'{param}_median'] = float(np.median(values))
                        aggregated[f'{param}_std'] = float(np.std(values))
                        aggregated[f'{param}_q1'] = float(np.percentile(values, 25))
                        aggregated[f'{param}_q3'] = float(np.percentile(values, 75))

            # Save aggregated metrics
            (outdir / 'dt_optimized_aggregated_metrics.json').write_text(
                json.dumps(aggregated, indent=2), encoding='utf-8'
            )

            print(f"\n{'='*80}")
            print(f"OPTIMIZED DT - Global Aggregated Metrics (n={len(ok_rows)} sessions)")
            print(f"{'='*80}")
            print(f"  RMSE (x,y,xy): {aggregated['rmse_x_m_mean']:.3f}, {aggregated['rmse_y_m_mean']:.3f}, {aggregated['rmse_xy_m_mean']:.3f} m")
            print(f"  MAE (x,y,xy):  {aggregated['mae_x_m_mean']:.3f}, {aggregated['mae_y_m_mean']:.3f}, {aggregated['mae_xy_m_mean']:.3f} m")
            if aggregated['mape_xy_percent_mean'] is not None:
                print(f"  MAPE (xy):     {aggregated['mape_xy_percent_mean']:.2f}%")
            if aggregated['nrmse_mean_mean'] is not None:
                print(f"  NRMSE (mean):  {aggregated['nrmse_mean_mean']:.4f}")
            if aggregated['nrmse_range_mean'] is not None:
                print(f"  NRMSE (range): {aggregated['nrmse_range_mean']:.4f}")

            if 'wheelbase_m_mean' in aggregated:
                print(f"\n  Calibrated Parameters (mean ± std):")
                print(f"    Wheelbase:    {aggregated['wheelbase_m_mean']:.3f} ± {aggregated.get('wheelbase_m_std', 0):.3f} m")
                print(f"    Speed scale:  {aggregated['speed_scale_mean']:.3f} ± {aggregated.get('speed_scale_std', 0):.3f}")
                print(f"    Steer scale:  {aggregated['steer_scale_mean']:.3f} ± {aggregated.get('steer_scale_std', 0):.3f}")

            print(f"{'='*80}\n")

        ok_n = int(df_sum['ok'].sum()) if 'ok' in df_sum.columns else 0
        print(f"Optimized DT simulation done. Sessions evaluated: {ok_n}/{len(rows)} -> {outdir}")


# -----------------------------
# train-style
# -----------------------------

def cmd_train_style(args: argparse.Namespace) -> None:
    records = load_manifest(Path(args.manifest))
    outdir = ensure_dir(Path(args.outdir))

    sample_hz = float(args.sample_hz)

    # Initialize profiler
    profiler = TrainingProfiler(
        model_name="train_style",
        output_dir=outdir,
        use_codecarbon=True,
    )

    with profiler:
        feats = []
        meta = []
        for r in records:
            # use sensors only
            _, X, _, feat_names = _load_session_features(
                r, sample_hz, use_video=False,
                video_extractor='mobilenet_v3_small',
                video_cache=outdir,
                max_frames=None,
            )
            f = compute_style_features(X, feat_names)
            feats.append(f)
            meta.append(r)

        clusters, keys, km = cluster_styles(feats, k=args.k)
        centroids = km.cluster_centers_
        name_map = name_clusters(centroids, keys)

        rows = []
        for r, f, c in zip(meta, feats, clusters):
            rows.append({
                "session_id": r.session_id,
                "day_id": r.day_id,
                "cluster": int(c),
                "style": name_map.get(int(c), str(int(c))),
                "features": f,
            })

        write_jsonl(outdir / 'style_profiles.jsonl', rows)
        (outdir / 'style_centroids.json').write_text(
            json.dumps({"keys": keys, "centroids": centroids.tolist(), "name_map": name_map}, indent=2),
            encoding='utf-8',
        )

    print(f"Saved {len(rows)} style profiles -> {outdir}")


# -----------------------------
# explain
# -----------------------------

def _load_model_for_explain(modeldir: Path, model_kind: str):
    import torch
    if model_kind == 'transformer':
        ckpt = torch.load(modeldir / 'maneuver_transformer.pt', map_location='cpu')
        return ckpt
    elif model_kind == 'baseline':
        return load_baseline_checkpoint(modeldir / 'baseline.joblib')
    elif model_kind == 'xgboost':
        return load_xgboost_checkpoint(modeldir / 'xgboost.joblib')
    elif model_kind == 'random_forest':
        return load_random_forest_checkpoint(modeldir / 'random_forest.joblib')
    elif model_kind == 'lightgbm':
        return load_lightgbm_checkpoint(modeldir / 'lightgbm.joblib')
    elif model_kind == 'gru':
        return torch.load(modeldir / 'gru.pt', map_location='cpu')
    elif model_kind == 'lstm':
        return torch.load(modeldir / 'lstm.pt', map_location='cpu')
    elif model_kind == 'tcn':
        return torch.load(modeldir / 'tcn.pt', map_location='cpu')
    elif model_kind == 'mlp_mean':
        return torch.load(modeldir / 'mlp_mean.pt', map_location='cpu')
    elif model_kind == 'mlp_max':
        return torch.load(modeldir / 'mlp_max.pt', map_location='cpu')
    elif model_kind == 'mlp_concat':
        return torch.load(modeldir / 'mlp_concat.pt', map_location='cpu')
    raise ValueError(f"Unknown model kind: {model_kind}")


def cmd_explain(args: argparse.Namespace) -> None:
    from twimo.xai.explain import cod1_style_explain

    records = load_manifest(Path(args.manifest))
    outdir = ensure_dir(Path(args.outdir))

    modeldir = Path(args.modeldir)

    # if user doesn't specify --model, infer from modeldir/model_kind.txt
    model_kind = (args.model or '').lower().strip() if args.model is not None else ''
    if not model_kind:
        mk_path = modeldir / 'model_kind.txt'
        if mk_path.exists():
            model_kind = mk_path.read_text(encoding='utf-8').strip().lower()
        else:
            # default to transformer for backwards compatibility
            model_kind = 'transformer'

    ckpt = _load_model_for_explain(modeldir, model_kind)

    cfg_dict = json.loads((modeldir / 'config.json').read_text(encoding='utf-8'))
    cfg = ManeuverConfig(**cfg_dict)

    sample_hz = float(cfg.sample_hz)
    use_video = bool(args.use_video)
    video_cache = ensure_dir(modeldir / 'video_cache')

    explain_every = int(args.explain_every_steps)
    max_steps = args.max_steps
    if max_steps is not None and max_steps <= 0:
        max_steps = None

    max_sessions = args.max_sessions
    if max_sessions is not None and max_sessions <= 0:
        max_sessions = None

    # Initialize profiler
    profiler = TrainingProfiler(
        model_name="explain",
        output_dir=outdir,
        use_codecarbon=True,
    )

    with profiler:
        # Accumulate per-day outputs
        by_day: Dict[str, List[Dict]] = {}

        for r_i, r in enumerate(records):
            if max_sessions is not None and r_i >= max_sessions:
                break

            t, X, y, feat_names = _load_session_features(
                r,
                sample_hz,
                use_video,
                args.video_extractor,
                video_cache,
                max_frames=args.max_frames,
                video_fps=args.video_fps,
            )

            if model_kind == 'transformer':
                probs_by_steps = predict_transformer_multihead(ckpt, X, cfg)
            elif model_kind == 'baseline':
                probs_by_steps = predict_baseline_multihead(ckpt, X, cfg)
            elif model_kind == 'xgboost':
                probs_by_steps = predict_xgboost_multihead(ckpt, X, cfg)
            elif model_kind == 'random_forest':
                probs_by_steps = predict_random_forest_multihead(ckpt, X, cfg)
            elif model_kind == 'lightgbm':
                probs_by_steps = predict_lightgbm_multihead(ckpt, X, cfg)
            elif model_kind in ['gru', 'lstm']:
                probs_by_steps = predict_gru_lstm_multihead(ckpt, X, cfg)
            elif model_kind == 'tcn':
                probs_by_steps = predict_tcn_multihead(ckpt, X, cfg)
            elif model_kind in ['mlp_mean', 'mlp_max', 'mlp_concat']:
                probs_by_steps = predict_mlp_pooling_multihead(ckpt, X, cfg)
            else:
                raise ValueError(f"Unknown model_kind: {model_kind}")

            day_key = r.day_id or 'unknown'
            by_day.setdefault(day_key, [])

            window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))

            for steps, probs in probs_by_steps.items():
                steps_ahead = int(steps)

                # prob rows correspond to indices t in [window, ..., T-steps_ahead-1]
                n_probs = probs.shape[0]

                # choose indices every N steps
                idxs = list(range(0, n_probs, explain_every))
                if (n_probs - 1) not in idxs:
                    idxs.append(n_probs - 1)

                if max_steps is not None:
                    idxs = [i for i in idxs if i <= max_steps]

                for pi in idxs:
                    # map prob-index -> original X index
                    t_index = int(pi)
                    pvec = probs[pi]
                    pred = int(np.argmax(pvec))

                    # now/future vectors for the explanation rules
                    # - the window for prediction pi corresponds to X[pi : pi+window]
                    now_idx = pi + window - 1
                    fut_idx = now_idx + steps_ahead
                    x_now = X[now_idx]
                    x_fut = X[fut_idx] if fut_idx < X.shape[0] else None

                    text, _sem = cod1_style_explain(x_now, x_fut, feat_names)

                    row = {
                        "session_id": r.session_id,
                        "day_id": r.day_id,
                        "horizon_steps": int(steps),
                        "t_index": int(t_index),
                        "predicted_label": pred,
                        "probability": float(pvec[pred]),
                        "text": text,
                    }
                    # best-effort timestamp
                    if t is not None and (now_idx < len(t)):
                        row["unix_timestamp"] = float(t[now_idx])

                    by_day[day_key].append(row)

        # Write per-day jsonl
        for day, rows in by_day.items():
            out_path = outdir / f"explanations__{day}.jsonl"
            write_jsonl(out_path, rows)

        # Write an index file
        index = {
            "model_kind": model_kind,
            "explain_every_steps": explain_every,
            "days": {day: len(rows) for day, rows in by_day.items()},
        }
        (outdir / 'explain_index.json').write_text(json.dumps(index, indent=2), encoding='utf-8')

    print(f"Wrote explanations per day -> {outdir} (index: explain_index.json)")


# -----------------------------
# Extra commands — plots, annotation, EAF alignment, EAF pipelines
# -----------------------------

def _delegate(module_main, args_list) -> None:
    """Rebuild sys.argv and delegate to another module's main()."""
    import sys as _sys
    old = _sys.argv[:]
    _sys.argv = [_sys.argv[0]] + [str(a) for a in args_list]
    try:
        module_main()
    finally:
        _sys.argv = old


def cmd_plot_maneuver(args: argparse.Namespace) -> None:
    from twimo.plots.maneuver_plots import load_metrics, plot_single_metric, plot_dual_metric
    json_path = Path(args.json_file)
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    horizons, acc, prec_mac, prec_w, rec_mac, rec_w, f1_mac, f1_w = load_metrics(json_path)
    plot_single_metric(horizons, acc, "Accuracy", outdir)
    plot_dual_metric(horizons, prec_mac, prec_w, "Precision", outdir)
    plot_dual_metric(horizons, rec_mac, rec_w, "Recall", outdir)
    plot_dual_metric(horizons, f1_mac, f1_w, "F1", outdir)
    print(f"Plots saved to: {outdir}")


def cmd_plot_roc(args: argparse.Namespace) -> None:
    import json as _json
    from twimo.plots.plot_roc_curves import plot_roc_for_horizon, plot_roc_summary
    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    with open(args.roc_json, "r") as f:
        roc_data = _json.load(f)
    splits = args.splits or list(roc_data.keys())
    for split_name in splits:
        split_data = roc_data.get(split_name, {})
        if not split_data:
            print(f"No ROC data for split '{split_name}', skipping.")
            continue
        print(f"\nPlotting ROC curves for '{split_name}':")
        for h_key in sorted(split_data.keys(), key=lambda k: float(k.rstrip("s"))):
            plot_roc_for_horizon(h_key, split_data[h_key], split_name, outdir)
        plot_roc_summary(split_data, split_name, outdir)
    print(f"\nAll ROC plots saved to {outdir}")


def cmd_annotate_video(args: argparse.Namespace) -> None:
    from twimo.plots.annotate_video import main as _m
    argv = [
        "--manifest", str(args.manifest),
        "--modeldir", str(args.modeldir),
        "--outdir", str(args.outdir),
        "--sample-hz", str(args.sample_hz),
    ]
    if args.session:
        argv += ["--session", args.session]
    if args.horizons:
        argv += ["--horizons"] + [str(h) for h in args.horizons]
    if args.max_seconds is not None:
        argv += ["--max-seconds", str(args.max_seconds)]
    if args.prealigned_sensors_dir is not None:
        argv += ["--prealigned-sensors-dir", str(args.prealigned_sensors_dir)]
    _delegate(_m, argv)


def cmd_annotate_video_eaf(args: argparse.Namespace) -> None:
    from twimo.plots.annotate_video_eaf import main as _m
    argv = [
        "--manifest", str(args.manifest),
        "--stage1-model", str(args.stage1_model),
        "--stage2-model", str(args.stage2_model),
        "--data-dir", str(args.data_dir),
        "--vocab-dir", str(args.vocab_dir),
        "--outdir", str(args.outdir),
        "--sample-hz", str(args.sample_hz),
    ]
    if args.session:
        argv += ["--session", args.session]
    if args.horizons:
        argv += ["--horizons"] + [str(h) for h in args.horizons]
    if args.max_seconds is not None:
        argv += ["--max-seconds", str(args.max_seconds)]
    if args.prealigned_sensors_dir is not None:
        argv += ["--prealigned-sensors-dir", str(args.prealigned_sensors_dir)]
    if args.eaf_parsed_dir is not None:
        argv += ["--eaf-parsed-dir", str(args.eaf_parsed_dir)]
    _delegate(_m, argv)


def cmd_annotate_video_eaf_yolo(args: argparse.Namespace) -> None:
    from twimo.plots.annotate_video_eaf_yolo import main as _m
    argv = [
        "--manifest", str(args.manifest),
        "--stage1-model", str(args.stage1_model),
        "--stage2-model", str(args.stage2_model),
        "--data-dir", str(args.data_dir),
        "--vocab-dir", str(args.vocab_dir),
        "--outdir", str(args.outdir),
        "--sample-hz", str(args.sample_hz),
        "--yolo-conf", str(args.yolo_conf),
    ]
    if args.session:
        argv += ["--session", args.session]
    if args.horizons:
        argv += ["--horizons"] + [str(h) for h in args.horizons]
    if args.max_seconds is not None:
        argv += ["--max-seconds", str(args.max_seconds)]
    if args.prealigned_sensors_dir is not None:
        argv += ["--prealigned-sensors-dir", str(args.prealigned_sensors_dir)]
    if args.det_cache_dir is not None:
        argv += ["--det-cache-dir", str(args.det_cache_dir)]
    if args.eaf_parsed_dir is not None:
        argv += ["--eaf-parsed-dir", str(args.eaf_parsed_dir)]
    if args.yolo_model is not None:
        argv += ["--yolo-model", str(args.yolo_model)]
    _delegate(_m, argv)


def cmd_annotate_video_eaf_yolo_improved(args: argparse.Namespace) -> None:
    from twimo.plots.annotate_video_eaf_yolo_improved import main as _m
    argv = [
        "--manifest", str(args.manifest),
        "--model-dir", str(args.model_dir),
        "--vocab-dir", str(args.vocab_dir),
        "--outdir", str(args.outdir),
        "--sample-hz", str(args.sample_hz),
        "--yolo-conf", str(args.yolo_conf),
    ]
    if args.session:
        argv += ["--session", args.session]
    if args.horizons:
        argv += ["--horizons"] + [str(h) for h in args.horizons]
    if args.max_seconds is not None:
        argv += ["--max-seconds", str(args.max_seconds)]
    if args.prealigned_sensors_dir is not None:
        argv += ["--prealigned-sensors-dir", str(args.prealigned_sensors_dir)]
    if args.det_cache_dir is not None:
        argv += ["--det-cache-dir", str(args.det_cache_dir)]
    if args.eaf_parsed_dir is not None:
        argv += ["--eaf-parsed-dir", str(args.eaf_parsed_dir)]
    if args.yolo_model is not None:
        argv += ["--yolo-model", str(args.yolo_model)]
    if args.no_zone_colours:
        argv += ["--no-zone-colours"]
    _delegate(_m, argv)


def cmd_align_eaf(args: argparse.Namespace) -> None:
    from twimo.strategies_eaf.align_eaf_to_sensors import main as _m
    argv = [
        "--eaf-parsed-dir", str(args.eaf_parsed_dir),
        "--vocab", str(args.vocab),
        "--manifest", str(args.manifest),
        "--output-dir", str(args.outdir),   # underlying script uses --output-dir
        "--sample-hz", str(args.sample_hz),
    ]
    _delegate(_m, argv)


def cmd_align_eaf_multi(args: argparse.Namespace) -> None:
    from twimo.strategies_eaf.align_eaf_to_sensors_multitarget_new import main as _m
    argv = [
        "--eaf-parsed-dir", str(args.eaf_parsed_dir),
        "--vocab-dir", str(args.vocab_dir),
        "--manifest", str(args.manifest),
        "--output-dir", str(args.outdir),   # underlying script uses --output-dir
        "--sample-hz", str(args.sample_hz),
    ]
    if args.debug:
        argv += ["--debug"]
    _delegate(_m, argv)


def cmd_eaf_yolo(args: argparse.Namespace) -> None:
    from twimo.strategies_eaf.two_stage_yolo import main as _m
    _delegate(_m, [args.subcommand] + list(args.remainder))


def cmd_eaf_yolo_improved(args: argparse.Namespace) -> None:
    from twimo.strategies_eaf.two_stage_yolo_improved import main as _m
    _delegate(_m, [args.subcommand] + list(args.remainder))


def cmd_eaf_transformer(args: argparse.Namespace) -> None:
    from twimo.strategies_eaf.two_stage_transformer import main as _m
    _delegate(_m, [args.subcommand] + list(args.remainder))


# -----------------------------
# CLI
# -----------------------------

class _FullHelpAction(argparse.Action):
    """Custom --help that prints every subcommand with its full list of flags."""

    def __init__(self, option_strings, dest=argparse.SUPPRESS,
                 default=argparse.SUPPRESS, help=None):
        super().__init__(option_strings=option_strings, dest=dest,
                         default=default, nargs=0, help=help)

    def __call__(self, parser, namespace, values, option_string=None):
        # ── top-level overview ─────────────────────────────────────────────────
        parser.print_help()

        # ── per-subcommand detail ──────────────────────────────────────────────
        for action in parser._actions:
            if not isinstance(action, argparse._SubParsersAction):
                continue
            for name, sub in action.choices.items():
                print(f"\n{'-' * 72}")
                print(f"  twimo {name}")
                desc = sub.description or sub._defaults.get('func', lambda: None).__doc__ or ''
                if desc:
                    first_line = desc.strip().splitlines()[0]
                    print(f"  {first_line}")
                print(f"{'-' * 72}")
                for a in sub._actions:
                    if isinstance(a, argparse._HelpAction):
                        continue
                    # Flag string (e.g. "--manifest") or positional name
                    if a.option_strings:
                        flag = ', '.join(a.option_strings)
                    else:
                        flag = a.dest
                    # Type annotation
                    if a.type is not None:
                        type_str = f' {a.type.__name__.upper()}'
                    elif a.nargs in ('*', '+', argparse.REMAINDER):
                        type_str = ' ...'
                    elif isinstance(a, argparse._StoreTrueAction):
                        type_str = ''
                    else:
                        type_str = ' STR' if a.default is None else ''
                    # Required / default tags
                    tags = ''
                    if getattr(a, 'required', False):
                        tags += '  [required]'
                    elif a.default not in (None, argparse.SUPPRESS, False):
                        tags += f'  [default: {a.default}]'
                    if isinstance(a, argparse._StoreTrueAction):
                        tags += '  [flag]'
                    help_text = (a.help or '').replace('%(default)s', str(a.default))
                    print(f"  {flag}{type_str}{tags}")
                    if help_text and help_text != argparse.SUPPRESS:
                        print(f"      {help_text}")
            break

        parser.exit()


def build_parser() -> argparse.ArgumentParser:
    p = argparse.ArgumentParser(
        prog='twimo',
        description='TWIMO: ML-driven Digital Twin for Driving Behavior (HDD-focused).',
        add_help=False,
    )
    p.add_argument(
        '-h', '--help',
        action=_FullHelpAction,
        help='Show this help message with all subcommand flags and exit',
    )
    sub = p.add_subparsers(dest='cmd', required=True)

    s = sub.add_parser('scan', help='Scan an HDD-like filesystem and create a manifest.jsonl')
    s.add_argument('--root', required=True, help='Root folder (e.g., .../release_2019_07_08/release_2019_07_08)')
    s.add_argument('--out', required=True, help='Output manifest path (.jsonl)')
    s.add_argument('--prealigned-labels-dir', default=None, help='Optional dir with <session_id>.npy targets')
    s.add_argument('--prealigned-sensors-dir', default=None, help='Optional dir with <session_id>.npy sensors')
    s.set_defaults(func=cmd_scan)

    t = sub.add_parser('train-maneuver', help='Train maneuver prediction models (multi-horizon)')
    t.add_argument('--manifest', required=True)
    t.add_argument('--outdir', required=True)

    t.add_argument('--model', choices=['transformer', 'baseline', 'xgboost', 'random_forest', 'lightgbm', 'gru', 'lstm', 'tcn', 'mlp_mean', 'mlp_max', 'mlp_concat'], default='transformer', help='Model family')

    # NOTE: --sample-fps is kept as a backwards-compatible alias.
    t.add_argument('--sample-hz', '--sample-fps', dest='sample_hz', type=float, default=3.0)
    t.add_argument('--window-seconds', type=float, default=3.0)
    t.add_argument('--horizons', nargs='+', type=float, default=None,
                   help='Prediction horizons in seconds. Default: auto-computed from --sample-hz '
                        '(sub-second: every step, 1s+: every second up to 5s).')

    # Keep defaults small so the quickstart runs fast on CPU.
    t.add_argument('--epochs', type=int, default=3)
    t.add_argument('--batch-size', type=int, default=64)
    t.add_argument('--lr', type=float, default=1e-3)
    t.add_argument('--d-model', type=int, default=128)
    t.add_argument('--nhead', type=int, default=4)
    t.add_argument('--num-layers', type=int, default=3)
    t.add_argument('--test-ratio', type=float, default=0.2)

    t.add_argument('--use-video', action='store_true', help='Fuse video features with sensors')
    t.add_argument(
        '--video-extractor',
        choices=['mobilenet_v3_small', 'resnet18', 'mobilenet', 'resnet'],
        default='mobilenet_v3_small',
    )
    t.add_argument(
        '--video-fps',
        type=float,
        default=None,
        help='Override the sampled video FPS (defaults to --sample-hz/--sample-fps).',
    )
    t.add_argument('--video-cache', default=None, help='Where to store video feature .npy cache')
    t.add_argument('--max-frames', type=int, default=None, help='Debug: stop after N sampled frames per video')

    # EAF target selection
    t.add_argument('--target', choices=['proxy', 'goal', 'stimuli'], default='proxy',
                   help='Prediction target: proxy=heuristic maneuver labels (default), '
                        'goal=EAF Goal tier, stimuli=EAF Stimuli tier.')
    t.add_argument('--target-dir', default=None,
                   help='Directory containing per-session target .npy files '
                        '(one file per session_id). Auto-discovered if omitted.')
    t.add_argument('--vocab-file', default=None,
                   help='Path to vocab JSON (e.g. vocab_goal.json) for label name mapping. '
                        'Auto-discovered if omitted.')

    t.set_defaults(func=cmd_train_maneuver)

    # NOTE: user requested simulate-dt to be positioned before train-style
    dt = sub.add_parser('simulate-dt', help='Evaluate a kinematic bicycle Digital Twin vs RTK ground truth')
    dt.add_argument('--manifest', required=True)
    dt.add_argument('--outdir', required=True)
    dt.add_argument('--sample-hz', type=float, default=10.0, help='DT simulation/align frequency (Hz)')
    dt.add_argument('--wheelbase', type=float, default=2.7)
    dt.add_argument('--max-sessions', type=int, default=None, help='Optional cap for faster debugging (default: all)')
    dt.add_argument('--save-traj', action='store_true', help='Save per-session sim__<SESSION_ID>.csv trajectories')
    dt.set_defaults(func=cmd_simulate_dt)

    # Optimized DT with parameter calibration and drift correction
    dt_opt = sub.add_parser('simulate-dt-optimized', help='Optimized DT with auto-calibration and drift correction')
    dt_opt.add_argument('--manifest', required=True)
    dt_opt.add_argument('--outdir', required=True)
    dt_opt.add_argument('--sample-hz', type=float, default=3.0, help='DT simulation/align frequency (Hz)')
    dt_opt.add_argument('--wheelbase', type=float, default=2.7, help='Initial wheelbase guess (m)')
    dt_opt.add_argument('--max-sessions', type=int, default=None, help='Optional cap for faster debugging (default: all)')
    dt_opt.add_argument('--save-traj', action='store_true', help='Save per-session sim_optimized__<SESSION_ID>.csv trajectories')

    # Calibration options
    dt_opt.add_argument('--calibrate', action='store_true', default=True, help='Auto-calibrate parameters per session (default: True)')
    dt_opt.add_argument('--no-calibrate', action='store_false', dest='calibrate', help='Disable parameter calibration')
    dt_opt.add_argument('--optimize-wheelbase', action='store_true', default=True, help='Optimize wheelbase (default: True)')
    dt_opt.add_argument('--optimize-speed', action='store_true', default=True, help='Optimize speed scale (default: True)')
    dt_opt.add_argument('--optimize-steer', action='store_true', default=True, help='Optimize steering scale (default: True)')

    # Drift correction options
    dt_opt.add_argument('--use-reset', action='store_true', default=True, help='Use periodic position reset to RTK (default: True)')
    dt_opt.add_argument('--no-reset', action='store_false', dest='use_reset', help='Disable position reset')
    dt_opt.add_argument('--reset-interval', type=int, default=30, help='Reset position every N steps (default: 30 = 10s at 3Hz)')

    # Initial state estimation
    dt_opt.add_argument('--multi-sample-init', action='store_true', default=True, help='Use multi-sample initial state estimation (default: True)')
    dt_opt.add_argument('--init-samples', type=int, default=10, help='Number of samples for initial state estimation (default: 10)')

    dt_opt.set_defaults(func=cmd_simulate_dt_optimized)

    st = sub.add_parser('train-style', help='Unsupervised driving style profiles from sensors')
    st.add_argument('--manifest', required=True)
    st.add_argument('--outdir', required=True)
    st.add_argument('--sample-hz', type=float, default=3.0)
    st.add_argument('--k', type=int, default=3)
    st.set_defaults(func=cmd_train_style)

    ex = sub.add_parser('explain', help='Generate explanations on top of model predictions')
    ex.add_argument('--manifest', required=True)
    ex.add_argument('--modeldir', required=True)
    ex.add_argument('--outdir', required=True)
    ex.add_argument('--model', choices=['transformer', 'baseline', 'xgboost', 'random_forest', 'lightgbm', 'gru', 'lstm', 'tcn', 'mlp_mean', 'mlp_max', 'mlp_concat'], default=None, help='Override model kind (else infer)')
    ex.add_argument('--use-video', action='store_true')
    ex.add_argument(
        '--video-extractor',
        choices=['mobilenet_v3_small', 'resnet18', 'mobilenet', 'resnet'],
        default='mobilenet_v3_small',
    )
    ex.add_argument('--explain-every-steps', dest='explain_every_steps', type=int, default=50,
                    help='Generate one explanation every N time steps (default: 50)')
    ex.add_argument('--max-steps', type=int, default=None, help='Optional cap on max explanation indices per session (default: all)')
    ex.add_argument('--video-fps', type=float, default=None)
    ex.add_argument('--max-frames', type=int, default=300)
    ex.add_argument('--max-sessions', type=int, default=None, help='Optional cap for faster debugging (default: all)')
    ex.set_defaults(func=cmd_explain)

    # ── plot-maneuver ──────────────────────────────────────────────────────────
    pm = sub.add_parser('plot-maneuver',
                        help='Plot maneuver prediction metrics (accuracy, precision, recall, F1) from a metrics JSON')
    pm.add_argument('--json-file', required=True,
                    help='Path to test_metrics.json (or train_metrics.json / val_metrics.json)')
    pm.add_argument('--outdir', required=True,
                    help='Output directory for PNG plots')
    pm.set_defaults(func=cmd_plot_maneuver)

    # ── plot-roc ───────────────────────────────────────────────────────────────
    pr = sub.add_parser('plot-roc',
                        help='Plot ROC AUC curves (per class, per horizon) from roc_curves.json')
    pr.add_argument('--roc-json', required=True, type=Path,
                    help='Path to roc_curves.json produced by train-maneuver')
    pr.add_argument('--outdir', required=True, type=Path,
                    help='Output directory for PNG plots')
    pr.add_argument('--splits', nargs='*', default=None,
                    help='Splits to plot (default: all found in JSON). E.g. --splits test  or  --splits train val test')
    pr.set_defaults(func=cmd_plot_roc)

    # ── annotate-video ─────────────────────────────────────────────────────────
    av = sub.add_parser('annotate-video',
                        help='Annotate driving video(s) with maneuver predictions and sensor overlays')
    av.add_argument('--manifest', type=Path, required=True)
    av.add_argument('--modeldir', type=Path, required=True,
                    help='Directory with trained model artifacts (model.pth, config.json, feature_names.json)')
    av.add_argument('--outdir', type=Path, required=True)
    av.add_argument('--session', type=str, default=None,
                    help='Session ID to annotate (default: all sessions in manifest)')
    av.add_argument('--horizons', type=float, nargs='+', default=[1.0, 3.0, 5.0],
                    help='Prediction horizons to overlay in seconds (default: 1.0 3.0 5.0)')
    av.add_argument('--sample-hz', type=float, default=3.0)
    av.add_argument('--max-seconds', type=float, default=None,
                    help='Trim video to first N seconds (default: full video)')
    av.add_argument('--prealigned-sensors-dir', type=Path, default=None,
                    help='Directory with prealigned sensor .npy files')
    av.set_defaults(func=cmd_annotate_video)

    # ── annotate-video-eaf ─────────────────────────────────────────────────────
    ave = sub.add_parser('annotate-video-eaf',
                         help='Annotate video with EAF two-stage model predictions (Goal / Stimuli)')
    ave.add_argument('--manifest', type=Path, required=True)
    ave.add_argument('--stage1-model', type=Path, required=True,
                     help='Path to EventNet stage-1 model .pt file')
    ave.add_argument('--stage2-model', type=Path, required=True,
                     help='Path to ClassifyNet stage-2 model .pt file')
    ave.add_argument('--data-dir', type=Path, required=True,
                     help='Dir with config.json and norm_mean/std.npy (EAF model output dir)')
    ave.add_argument('--vocab-dir', type=Path, required=True,
                     help='Directory containing vocab_*.json vocabulary files')
    ave.add_argument('--outdir', type=Path, required=True)
    ave.add_argument('--session', type=str, default=None)
    ave.add_argument('--sample-hz', type=float, default=3.0)
    ave.add_argument('--horizons', type=float, nargs='+', default=[1.0, 3.0, 5.0])
    ave.add_argument('--max-seconds', type=float, default=None)
    ave.add_argument('--prealigned-sensors-dir', type=Path, default=None)
    ave.add_argument('--eaf-parsed-dir', type=Path, default=None,
                     help='Dir with parsed EAF JSONL files (for ground-truth overlay)')
    ave.set_defaults(func=cmd_annotate_video_eaf)

    # ── annotate-video-eaf-yolo ────────────────────────────────────────────────
    avey = sub.add_parser('annotate-video-eaf-yolo',
                          help='Annotate video with EAF predictions + YOLOv8 bounding box overlay')
    avey.add_argument('--manifest', type=Path, required=True)
    avey.add_argument('--stage1-model', type=Path, required=True)
    avey.add_argument('--stage2-model', type=Path, required=True)
    avey.add_argument('--data-dir', type=Path, required=True)
    avey.add_argument('--vocab-dir', type=Path, required=True)
    avey.add_argument('--outdir', type=Path, required=True)
    avey.add_argument('--session', type=str, default=None)
    avey.add_argument('--sample-hz', type=float, default=3.0)
    avey.add_argument('--horizons', type=float, nargs='+', default=[1.0, 3.0, 5.0])
    avey.add_argument('--max-seconds', type=float, default=None)
    avey.add_argument('--prealigned-sensors-dir', type=Path, default=None)
    avey.add_argument('--det-cache-dir', type=Path, default=None,
                      help='Precomputed YOLO detection feature cache directory')
    avey.add_argument('--eaf-parsed-dir', type=Path, default=None)
    avey.add_argument('--yolo-model', type=str, default=None,
                      help='YOLOv8 weights file (e.g. yolov8n.pt); omit to use cached detections only')
    avey.add_argument('--yolo-conf', type=float, default=0.30,
                      help='YOLO detection confidence threshold (default: 0.30)')
    avey.set_defaults(func=cmd_annotate_video_eaf_yolo)

    # ── annotate-video-eaf-yolo-improved ──────────────────────────────────────
    aveyi = sub.add_parser('annotate-video-eaf-yolo-improved',
                           help='Annotate video with improved EAF predictions + YOLOv8 bboxes')
    aveyi.add_argument('--manifest', type=Path, required=True)
    aveyi.add_argument('--model-dir', type=Path, required=True,
                       help='Directory with improved EAF model artifacts (two_stage_yolo_improved output)')
    aveyi.add_argument('--vocab-dir', type=Path, required=True)
    aveyi.add_argument('--outdir', type=Path, required=True)
    aveyi.add_argument('--session', type=str, default=None)
    aveyi.add_argument('--sample-hz', type=float, default=3.0)
    aveyi.add_argument('--horizons', type=float, nargs='+', default=[1.0, 3.0, 5.0])
    aveyi.add_argument('--max-seconds', type=float, default=None)
    aveyi.add_argument('--prealigned-sensors-dir', type=Path, default=None)
    aveyi.add_argument('--det-cache-dir', type=Path, default=None)
    aveyi.add_argument('--eaf-parsed-dir', type=Path, default=None)
    aveyi.add_argument('--yolo-model', type=str, default=None)
    aveyi.add_argument('--yolo-conf', type=float, default=0.30)
    aveyi.add_argument('--no-zone-colours', action='store_true',
                       help='Disable colour-coded zone overlays')
    aveyi.set_defaults(func=cmd_annotate_video_eaf_yolo_improved)

    # ── align-eaf ─────────────────────────────────────────────────────────────
    ae = sub.add_parser('align-eaf',
                        help='Align EAF annotations (single-target: Goal) to sensor timeline')
    ae.add_argument('--eaf-parsed-dir', type=Path, required=True,
                    help='Directory with parsed EAF JSONL files')
    ae.add_argument('--vocab', type=Path, required=True,
                    help='Vocabulary JSON file (e.g. twimo/strategies_eaf/vocab_goal.json)')
    ae.add_argument('--manifest', type=Path, required=True)
    ae.add_argument('--outdir', type=Path, required=True,
                    help='Output directory for aligned .npy files')
    ae.add_argument('--sample-hz', type=float, default=3.0)
    ae.set_defaults(func=cmd_align_eaf)

    # ── align-eaf-multi ───────────────────────────────────────────────────────
    aem = sub.add_parser('align-eaf-multi',
                         help='Align EAF annotations (multi-target: Goal + Stimuli + Cause + Attention) to sensor timeline')
    aem.add_argument('--eaf-parsed-dir', type=Path, required=True,
                     help='Directory with parsed EAF JSONL files')
    aem.add_argument('--vocab-dir', type=Path, required=True,
                     help='Directory with vocab_goal.json, vocab_stimuli.json, etc.')
    aem.add_argument('--manifest', type=Path, required=True)
    aem.add_argument('--outdir', type=Path, required=True,
                     help='Output directory for aligned multi-target .npy files')
    aem.add_argument('--sample-hz', type=float, default=3.0)
    aem.add_argument('--debug', action='store_true',
                     help='Enable verbose debug output during alignment')
    aem.set_defaults(func=cmd_align_eaf_multi)

    # ── eaf-yolo ──────────────────────────────────────────────────────────────
    ey = sub.add_parser('eaf-yolo',
                        help='Two-stage EAF + YOLOv8 pipeline. '
                             'Subcommands: extract | train | validate | filter-retrain | evaluate')
    ey.add_argument('subcommand',
                    choices=['extract', 'train', 'validate', 'filter-retrain', 'evaluate'],
                    help='Pipeline stage to run')
    ey.add_argument('remainder', nargs=argparse.REMAINDER,
                    help='Arguments forwarded verbatim to the sub-command. '
                         'Run "python -m twimo.strategies_eaf.two_stage_yolo <subcommand> --help" for details.')
    ey.set_defaults(func=cmd_eaf_yolo)

    # ── eaf-yolo-improved ─────────────────────────────────────────────────────
    eyi = sub.add_parser('eaf-yolo-improved',
                         help='Improved two-stage EAF + YOLOv8 pipeline. '
                              'Subcommands: extract-improved | train | evaluate')
    eyi.add_argument('subcommand',
                     choices=['extract-improved', 'train', 'evaluate'],
                     help='Pipeline stage to run')
    eyi.add_argument('remainder', nargs=argparse.REMAINDER,
                     help='Arguments forwarded verbatim to the sub-command.')
    eyi.set_defaults(func=cmd_eaf_yolo_improved)

    # ── eaf-transformer ───────────────────────────────────────────────────────
    et = sub.add_parser('eaf-transformer',
                        help='Two-stage EAF Transformer pipeline. '
                             'Subcommands: prepare | train-stage1 | train-stage2 | predict')
    et.add_argument('subcommand',
                    choices=['prepare', 'train-stage1', 'train-stage2', 'predict'],
                    help='Pipeline stage to run')
    et.add_argument('remainder', nargs=argparse.REMAINDER,
                    help='Arguments forwarded verbatim to the sub-command.')
    et.set_defaults(func=cmd_eaf_transformer)

    return p


def main(argv: Optional[List[str]] = None) -> None:
    p = build_parser()
    args = p.parse_args(argv)
    args.func(args)


if __name__ == '__main__':
    main()
