#!/usr/bin/env python
from __future__ import annotations

import argparse
import json
from pathlib import Path
from collections import Counter, defaultdict
from dataclasses import dataclass
from typing import List

import numpy as np


# ---------------- Config (mirror of your training code) ----------------

@dataclass
class ManeuverConfig:
    window_seconds: float = 3.0
    sample_hz: float = 3.0
    horizons_seconds: List[float] = None  # e.g. [0.1,0.5,1,2,3]
    d_model: int = 128
    nhead: int = 4
    num_layers: int = 3
    dropout: float = 0.1
    batch_size: int = 64
    epochs: int = 8
    lr: float = 1e-3

    def __post_init__(self):
        if self.horizons_seconds is None:
            self.horizons_seconds = [0.1, 0.5, 1.0, 2.0, 3.0]


def make_windows(X: np.ndarray, y: np.ndarray, steps_ahead: int, window: int):
    T = X.shape[0]
    end = T - steps_ahead
    if end <= window:
        return None, None
    Xw = []
    yw = []
    for t in range(window, end):
        Xw.append(X[t - window : t])
        yw.append(y[t + steps_ahead])
    return np.stack(Xw, axis=0), np.array(yw, dtype=np.int64)


def predict_transformer_multihead(best_ckpt, X: np.ndarray, cfg: ManeuverConfig):
    import torch
    import torch.nn as nn

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    steps_list = best_ckpt["steps"]
    n_classes = best_ckpt["n_classes"]

    class Model(nn.Module):
        def __init__(self, d_in: int):
            super().__init__()
            self.proj = nn.Linear(d_in, cfg.d_model)
            enc_layer = nn.TransformerEncoderLayer(
                d_model=cfg.d_model,
                nhead=cfg.nhead,
                dim_feedforward=cfg.d_model * 4,
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

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    m = Model(d_in=X.shape[1]).to(device)
    m.load_state_dict(best_ckpt["state_dict"], strict=True)
    m.eval()

    probs = {}
    with torch.no_grad():
        for steps in steps_list:
            Xw, _ = make_windows(
                X,
                np.zeros((X.shape[0],), dtype=np.int64),
                steps_ahead=steps,
                window=window,
            )
            if Xw is None:
                continue
            X_t = torch.from_numpy(Xw).float().to(device)
            outs = []
            bs = 256
            head_idx = steps_list.index(steps)
            for i in range(0, X_t.shape[0], bs):
                logits = m(X_t[i : i + bs])[head_idx]
                outs.append(torch.softmax(logits, dim=1).cpu().numpy())
            probs[steps] = np.concatenate(outs, axis=0)
    return probs


# ---------------- Metrics helpers ----------------

def macro_f1(y_true: np.ndarray, y_pred: np.ndarray, n_classes: int, exclude_zero: bool) -> float:
    eps = 1e-12
    classes = range(1, n_classes) if exclude_zero else range(n_classes)
    f1s = []
    for c in classes:
        tp = np.sum((y_true == c) & (y_pred == c))
        fp = np.sum((y_true != c) & (y_pred == c))
        fn = np.sum((y_true == c) & (y_pred != c))
        prec = tp / (tp + fp + eps)
        rec = tp / (tp + fn + eps)
        f1 = 2 * prec * rec / (prec + rec + eps)
        f1s.append(f1)
    if not f1s:
        return 0.0
    return float(np.mean(f1s))


def load_manifest_jsonl(path: Path):
    recs = []
    with open(path, "r", encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if not line:
                continue
            recs.append(json.loads(line))
    return recs


def print_dist(title: str, y: np.ndarray, topk: int = 15):
    c = Counter(y.tolist())
    total = len(y)
    print(f"\n{title}: total={total}")
    for cls, n in c.most_common(topk):
        print(f"  class {cls:>3}: {n:>8}  ({n/total:.4f})")
    if 0 in c:
        print(f"  --> class 0 share: {c[0]/total:.4f}")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--manifest", type=Path, required=True)
    ap.add_argument("--ckpt", type=Path, required=True, help="torch checkpoint .pt with state_dict/steps/n_classes")
    ap.add_argument("--test-day", type=str, default=None)
    ap.add_argument("--target-key", type=str, default="prealigned_target_npy")
    ap.add_argument("--sensor-key", dest="sensor_key", default="prealigned_sensor_npy")
    args = ap.parse_args()

    recs = load_manifest_jsonl(args.manifest)

    # group by day_id
    by_day = defaultdict(list)
    for r in recs:
        d = r.get("day_id")
        by_day[d].append(r)

    days = sorted([d for d in by_day.keys() if d is not None])
    if not days:
        raise RuntimeError("No day_id found in manifest.")

    test_day = args.test_day or days[-1]
    train_days = [d for d in days if d != test_day]

    train_recs = [r for d in train_days for r in by_day[d]]
    test_recs = list(by_day[test_day])

    print("=" * 80)
    print("Split by day (replicated)")
    print("=" * 80)
    print(f"Manifest: {args.manifest}")
    print(f"Target key: {args.target_key}")
    print(f"Days: {days}")
    print(f"TEST day: {test_day}")
    print(f"Train sessions: {len(train_recs)} | Test sessions: {len(test_recs)}")

    def load_concat(recs, key):
        arrs = []
        for r in recs:
            p = r.get(key)
            if not p:
                raise RuntimeError(f"Missing '{key}' for session_id={r.get('session_id')}")
            arrs.append(np.load(p))
        return np.concatenate(arrs, axis=0)

    # Load raw frame-level arrays
    X_test =  load_concat(test_recs, args.sensor_key).astype(np.float32)
    y_test = load_concat(test_recs, args.target_key).astype(np.int64)

    # Distributions on raw frames
    y_train = load_concat(train_recs, args.target_key).astype(np.int64)
    print_dist("TRAIN class distribution (raw frames)", y_train)
    print_dist("TEST  class distribution (raw frames)", y_test)

    # Baseline on raw frames
    baseline_pred = np.zeros_like(y_test)
    base_acc = float(np.mean(baseline_pred == y_test))
    n_classes_raw = int(max(y_test.max(), y_train.max()) + 1)
    base_mf1_all = macro_f1(y_test, baseline_pred, n_classes=n_classes_raw, exclude_zero=False)
    base_mf1_ex0 = macro_f1(y_test, baseline_pred, n_classes=n_classes_raw, exclude_zero=True)
    mask_ann = (y_test != 0)
    base_acc_ann = float(np.mean(baseline_pred[mask_ann] == y_test[mask_ann])) if mask_ann.any() else 0.0

    print("\n" + "=" * 80)
    print("Baseline metrics (always predict 0) on TEST (raw frames)")
    print("=" * 80)
    print(f"Baseline accuracy:         {base_acc:.6f}")
    print(f"Macro-F1 (all classes):    {base_mf1_all:.6f}")
    print(f"Macro-F1 (excluding 0):    {base_mf1_ex0:.6f}")
    print(f"Accuracy on annotated (y!=0): {base_acc_ann:.6f}  (n={int(mask_ann.sum())}/{len(y_test)})")

    # Load model
    import torch
    best = torch.load(args.ckpt, map_location="cpu")

    cfg = ManeuverConfig()
    if "cfg_dict" in best:
        cfg = ManeuverConfig(**best["cfg_dict"])
    n_classes = int(best["n_classes"])
    steps_list = list(best["steps"])
    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))

    probs_by_steps = predict_transformer_multihead(best, X_test, cfg)

    print("\n" + "=" * 80)
    print("Model metrics on TEST (windowed, per horizon)")
    print("=" * 80)
    print(f"window_steps={window} | steps_list={steps_list} | n_classes={n_classes}")

    for steps in steps_list:
        probs = probs_by_steps.get(steps)
        if probs is None:
            print(f"\n[steps={steps}] skipped (no probs)")
            continue

        pred = probs.argmax(axis=1)
        _, y_win = make_windows(X_test, y_test, steps_ahead=steps, window=window)
        if y_win is None:
            print(f"\n[steps={steps}] skipped (no y_win)")
            continue

        N = min(len(pred), len(y_win))
        pred = pred[:N]
        y_win = y_win[:N]

        dist = Counter(pred.tolist())
        share0 = dist.get(0, 0) / max(1, N)

        acc_all = float(np.mean(pred == y_win))
        mf1_all = macro_f1(y_win, pred, n_classes=n_classes, exclude_zero=False)
        mf1_ex0 = macro_f1(y_win, pred, n_classes=n_classes, exclude_zero=True)

        mask = (y_win != 0)
        acc_ann = float(np.mean(pred[mask] == y_win[mask])) if mask.any() else 0.0

        print(f"\n[steps={steps}] N={N}")
        print(f"  pred class0 share: {share0:.6f}")
        print(f"  pred top-10: {dist.most_common(10)}")
        print(f"  acc (all): {acc_all:.6f}")
        print(f"  acc (annot y!=0): {acc_ann:.6f}  (n_annot={int(mask.sum())})")
        print(f"  macro-f1 (all): {mf1_all:.6f}")
        print(f"  macro-f1 (excl 0): {mf1_ex0:.6f}")

    print("\nDONE.")


if __name__ == "__main__":
    main()