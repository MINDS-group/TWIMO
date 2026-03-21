"""
RQ2 – Proxy maneuver prediction: results visualisation.

Reads all model subdirectories inside --models-dir (default:
artifacts/00_maneuver_proxy) and produces:

  1. fig_horizon_f1.png/pdf   – Macro-F1 vs prediction horizon (line, all models)
  2. fig_model_compare.png/pdf – Model comparison bar chart at best horizon
  3. fig_confusion.png/pdf    – Row-normalised confusion matrix (best model)
  4. fig_per_class_f1.png/pdf – Per-class F1 heatmap (models × classes)
  5. proxy_results.csv        – Numeric summary table

Usage
-----
  python -m twimo.results.rq2_proxy_results
  python -m twimo.results.rq2_proxy_results --models-dir artifacts/00_maneuver_proxy --outdir artifacts_models/rq2_proxy_new --best-hz 0.333333
"""
from __future__ import annotations

import argparse
import json
from pathlib import Path

import numpy as np
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt
import matplotlib.ticker as mticker

# ── Display names ─────────────────────────────────────────────────────────────

_KIND_NAMES: dict[str, str] = {
    "transformer":   "Transformer",
    "xgboost":       "XGBoost",
    "lightgbm":      "LightGBM",
    "random_forest": "Random Forest",
    "gru":           "GRU",
    "lstm":          "LSTM",
    "tcn":           "TCN",
    "mlp_mean":      "MLP (mean)",
    "mlp_max":       "MLP (max)",
    "mlp_concat":    "MLP (concat)",
    "baseline":      "Baseline",
}

# Fixed color palette – one per model kind
_COLORS = [
    "#1F77B4", "#FF7F0E", "#2CA02C", "#D62728", "#9467BD",
    "#8C564B", "#E377C2", "#7F7F7F", "#BCBD22", "#17BECF",
]

plt.rcParams.update({
    "font.family":     "serif",
    "axes.spines.top": False,
    "axes.spines.right": False,
    "axes.grid":       True,
    "grid.alpha":      0.3,
    "figure.dpi":      150,
})


# ── I/O helpers ───────────────────────────────────────────────────────────────

def _load_json(path: Path) -> dict | None:
    try:
        return json.loads(path.read_text(encoding="utf-8"))
    except Exception:
        return None


def _horizon_s(key: str) -> float:
    return float(key.rstrip("s"))


def _load_model(d: Path) -> dict | None:
    """Return a model record or None if directory is incomplete."""
    kind_file = d / "model_kind.txt"
    metrics_file = d / "test_metrics.json"
    if not kind_file.exists() or not metrics_file.exists():
        return None
    kind = kind_file.read_text(encoding="utf-8").strip().lower()
    metrics = _load_json(metrics_file)
    if not isinstance(metrics, dict):
        return None
    label_map = _load_json(d / "label_map.json") or {}
    return {
        "name":       _KIND_NAMES.get(kind, kind),
        "kind":       kind,
        "dir":        d,
        "metrics":    metrics,
        "label_map":  label_map,
    }


# ── Data extraction ───────────────────────────────────────────────────────────

def _horizons(m: dict) -> list[float]:
    keys = [k for k in m["metrics"] if not k.startswith("_")]
    return sorted(_horizon_s(k) for k in keys)


def _metric_at(m: dict, hz_s: float, key: str) -> float | None:
    for k, v in m["metrics"].items():
        if k.startswith("_"):
            continue
        if abs(_horizon_s(k) - hz_s) < 1e-4:
            return v.get(key)
    return None


def _nearest_horizon(m: dict, target: float) -> float:
    hs = _horizons(m)
    if not hs:
        return target
    return min(hs, key=lambda h: abs(h - target))


def _per_class_f1(m: dict, hz_s: float) -> dict[str, float]:
    for k, v in m["metrics"].items():
        if k.startswith("_"):
            continue
        if abs(_horizon_s(k) - hz_s) < 1e-4:
            pc = v.get("per_class", {})
            return {cls: info.get("f1", float("nan")) for cls, info in pc.items()}
    return {}


def _confusion_matrix(m: dict, hz_s: float) -> tuple[np.ndarray, list[str]] | tuple[None, None]:
    for k, v in m["metrics"].items():
        if k.startswith("_"):
            continue
        if abs(_horizon_s(k) - hz_s) < 1e-4:
            cm = v.get("confusion_matrix")
            pc = v.get("per_class", {})
            if cm:
                classes = list(pc.keys()) if pc else [str(i) for i in range(len(cm))]
                return np.array(cm, dtype=float), classes
    return None, None


# ── Figures ───────────────────────────────────────────────────────────────────

def _fig_horizon_f1(models: list[dict], out_dir: Path, metric: str = "f1_macro") -> None:
    fig, ax = plt.subplots(figsize=(8, 4.5))
    for m, color in zip(models, _COLORS):
        hs = _horizons(m)
        vals = [_metric_at(m, h, metric) for h in hs]
        vals = [v if v is not None else float("nan") for v in vals]
        ax.plot(hs, vals, marker="o", ms=5, lw=1.8, label=m["name"], color=color)

    ax.set_xlabel("Prediction horizon (s)", fontsize=11)
    ax.set_ylabel("Macro F1", fontsize=11)
    ax.set_title("Proxy maneuver prediction – Macro-F1 vs horizon", fontsize=11)
    ax.legend(fontsize=8, loc="upper right", ncol=2)
    ax.xaxis.set_major_locator(mticker.MaxNLocator(integer=False, nbins=8))
    plt.tight_layout()
    _save(fig, out_dir, "fig_horizon_f1")


def _fig_model_compare(models: list[dict], hz_s: float, out_dir: Path) -> None:
    names  = [m["name"] for m in models]
    f1mac  = [_metric_at(m, _nearest_horizon(m, hz_s), "f1_macro")    or 0.0 for m in models]
    f1wt   = [_metric_at(m, _nearest_horizon(m, hz_s), "f1_weighted") or 0.0 for m in models]
    auc    = [_metric_at(m, _nearest_horizon(m, hz_s), "roc_auc_macro") or 0.0 for m in models]

    x      = np.arange(len(names))
    width  = 0.25
    fig, ax = plt.subplots(figsize=(max(8, len(names) * 0.9 + 2), 4.5))
    ax.bar(x - width, f1mac, width, label="F1-macro",    color="#1F77B4", alpha=0.85)
    ax.bar(x,         f1wt,  width, label="F1-weighted", color="#FF7F0E", alpha=0.85)
    ax.bar(x + width, auc,   width, label="ROC-AUC",     color="#2CA02C", alpha=0.85)
    ax.set_xticks(x)
    ax.set_xticklabels(names, rotation=30, ha="right", fontsize=9)
    ax.set_ylabel("Score", fontsize=11)
    ax.set_ylim(0, 1.05)
    ax.set_title(f"Model comparison at h = {hz_s:.2f}s", fontsize=11)
    ax.legend(fontsize=9)
    plt.tight_layout()
    _save(fig, out_dir, "fig_model_compare")


def _fig_confusion(model: dict, hz_s: float, out_dir: Path) -> None:
    hz_s  = _nearest_horizon(model, hz_s)
    cm, classes = _confusion_matrix(model, hz_s)
    if cm is None:
        print(f"  [WARN] No confusion matrix for {model['name']} at {hz_s}s")
        return
    # Row-normalise
    cm_norm = cm / (cm.sum(axis=1, keepdims=True) + 1e-9)

    fig, ax = plt.subplots(figsize=(7, 6))
    im = ax.imshow(cm_norm, cmap="Blues", vmin=0, vmax=1)
    fig.colorbar(im, ax=ax, fraction=0.046, pad=0.04)
    ax.set_xticks(range(len(classes)))
    ax.set_yticks(range(len(classes)))
    ax.set_xticklabels(classes, rotation=40, ha="right", fontsize=9)
    ax.set_yticklabels(classes, fontsize=9)
    ax.set_xlabel("Predicted", fontsize=10)
    ax.set_ylabel("True", fontsize=10)
    ax.set_title(f"Confusion matrix – {model['name']}  (h={hz_s:.2f}s, row-normalised)",
                 fontsize=10)
    # Annotate cells
    for i in range(len(classes)):
        for j in range(len(classes)):
            val = cm_norm[i, j]
            ax.text(j, i, f"{val:.2f}", ha="center", va="center",
                    fontsize=8, color="white" if val > 0.55 else "black")
    plt.tight_layout()
    _save(fig, out_dir, "fig_confusion")


def _fig_per_class_f1(models: list[dict], hz_s: float, out_dir: Path) -> None:
    # Collect all class names
    all_classes: list[str] = []
    for m in models:
        hz = _nearest_horizon(m, hz_s)
        for cls in _per_class_f1(m, hz):
            if cls not in all_classes:
                all_classes.append(cls)
    if not all_classes:
        return

    matrix = np.full((len(models), len(all_classes)), float("nan"))
    for i, m in enumerate(models):
        hz = _nearest_horizon(m, hz_s)
        pc = _per_class_f1(m, hz)
        for j, cls in enumerate(all_classes):
            matrix[i, j] = pc.get(cls, float("nan"))

    fig, ax = plt.subplots(figsize=(max(7, len(all_classes) * 1.1 + 2),
                                    max(4, len(models) * 0.55 + 1.5)))
    im = ax.imshow(matrix, cmap="RdYlGn", vmin=0, vmax=1, aspect="auto")
    fig.colorbar(im, ax=ax, fraction=0.03, pad=0.02, label="F1")
    ax.set_xticks(range(len(all_classes)))
    ax.set_yticks(range(len(models)))
    ax.set_xticklabels(all_classes, rotation=35, ha="right", fontsize=9)
    ax.set_yticklabels([m["name"] for m in models], fontsize=9)
    ax.set_title(f"Per-class F1 – all models  (h={hz_s:.2f}s)", fontsize=11)
    for i in range(len(models)):
        for j in range(len(all_classes)):
            v = matrix[i, j]
            if not np.isnan(v):
                ax.text(j, i, f"{v:.2f}", ha="center", va="center",
                        fontsize=7.5, color="black")
    plt.tight_layout()
    _save(fig, out_dir, "fig_per_class_f1")


def _save(fig, out_dir: Path, stem: str) -> None:
    for ext in ("png", "pdf"):
        p = out_dir / f"{stem}.{ext}"
        fig.savefig(str(p), dpi=150, bbox_inches="tight")
        print(f"  Saved: {p}")
    plt.close(fig)


# ── CSV summary ───────────────────────────────────────────────────────────────

def _save_csv(models: list[dict], hz_s: float, out_dir: Path) -> None:
    import csv
    rows = []
    for m in models:
        h = _nearest_horizon(m, hz_s)
        rows.append({
            "model":        m["name"],
            "horizon_s":    h,
            "f1_macro":     _metric_at(m, h, "f1_macro"),
            "f1_weighted":  _metric_at(m, h, "f1_weighted"),
            "accuracy":     _metric_at(m, h, "accuracy"),
            "precision_macro": _metric_at(m, h, "precision_macro"),
            "recall_macro": _metric_at(m, h, "recall_macro"),
            "roc_auc_macro": _metric_at(m, h, "roc_auc_macro"),
        })
    rows.sort(key=lambda r: -(r["f1_macro"] or 0))
    path = out_dir / "proxy_results.csv"
    with open(path, "w", newline="", encoding="utf-8") as f:
        w = csv.DictWriter(f, fieldnames=list(rows[0].keys()))
        w.writeheader()
        w.writerows(rows)
    print(f"  CSV: {path}")

    # Print table to console
    print(f"\n  {'Model':<20} {'F1-mac':>7} {'F1-wt':>7} {'AUC':>7} {'Acc':>7}")
    print("  " + "-" * 52)
    for r in rows:
        f1m = f"{r['f1_macro']:.4f}"   if r['f1_macro']    is not None else "  N/A"
        f1w = f"{r['f1_weighted']:.4f}" if r['f1_weighted'] is not None else "  N/A"
        auc = f"{r['roc_auc_macro']:.4f}" if r['roc_auc_macro'] is not None else "  N/A"
        acc = f"{r['accuracy']:.4f}"   if r['accuracy']    is not None else "  N/A"
        print(f"  {r['model']:<20} {f1m:>7} {f1w:>7} {auc:>7} {acc:>7}")
    print()


# ── Entry point ───────────────────────────────────────────────────────────────

def run(args: argparse.Namespace) -> None:
    models_dir = Path(args.models_dir)
    out_dir    = Path(args.outdir)
    out_dir.mkdir(parents=True, exist_ok=True)

    print(f"\n[RQ2 Proxy]  models_dir={models_dir}  outdir={out_dir}")

    models: list[dict] = []
    for d in sorted(models_dir.iterdir()):
        if not d.is_dir():
            continue
        m = _load_model(d)
        if m:
            models.append(m)
            print(f"  Loaded: {m['name']}  ({d.name})")

    if not models:
        print("[ERROR] No model directories found.")
        return

    hz_s = args.best_hz
    print(f"\n  Reference horizon: {hz_s}s")
    print(f"  Models found: {len(models)}")

    # Best model by F1-macro at reference horizon
    best = max(models,
               key=lambda m: _metric_at(m, _nearest_horizon(m, hz_s), "f1_macro") or 0.0)
    print(f"  Best model: {best['name']}\n")

    print("  Generating figures...")
    _fig_horizon_f1(models, out_dir)
    _fig_model_compare(models, hz_s, out_dir)
    _fig_confusion(best, hz_s, out_dir)
    _fig_per_class_f1(models, hz_s, out_dir)
    _save_csv(models, hz_s, out_dir)
    print("Done.\n")


def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--models-dir", default="artifacts/00_maneuver_proxy",
                   dest="models_dir",
                   help="Directory containing one subdirectory per model")
    p.add_argument("--outdir",     default="artifacts_models/rq2_proxy")
    p.add_argument("--best-hz",    type=float, default=0.333333, dest="best_hz",
                   help="Reference horizon in seconds for comparison plots (default: 0.333333)")
    run(p.parse_args())


if __name__ == "__main__":
    main()
