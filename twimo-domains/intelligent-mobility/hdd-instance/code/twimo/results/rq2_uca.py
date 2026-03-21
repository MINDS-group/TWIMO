"""
RQ2-A — Use Case A: multi-horizon maneuver prediction results.

Produces
--------
  uca_main.csv / .tex          -> Tab. ucA_main
  uca_baselines.csv / .tex     -> Tab. ucA_baselines
  uca_model_suite.csv / .tex   -> Tab. ucA_model_suite (mean F1 + 3 ref horizons)
  uca_ranks.csv / .tex         -> Tab. ucA_ranks (ranking + Friedman test)
  hp_suite.csv / .tex          -> Tab. hp_suite (hyperparameter audit)
  uca_all_models.csv
  horizon_curve.png            -> Fig. ucA_horizon_curve
  horizon_curve_all.png        -> Fig. ucA_horizon_curve_all (top-3 highlighted)
  confusion_matrix_<h>s.png    -> Fig. ucA_cm

Usage
-----
  python -m twimo.results_old.rq2_uca
  python -m twimo.results_old.rq2_uca --artifacts-dir artifacts --outdir artifacts_models/rq2_uca
"""
from __future__ import annotations

import argparse
from pathlib import Path

import numpy as np
import pandas as pd

from twimo.results._utils import (
    load_json, get_horizon_metrics, nearest_horizon,
    scan_model_dirs, fmt_f, model_display_name,
    save_artifact, setup_mpl,
)

BASELINE_HORIZONS = [0.5, 1.0, 2.0]
PRIMARY_MODEL = "transformer"

# Model-specific HP keys to extract from config.json
_MODEL_HP_KEYS: dict[str, list[str]] = {
    "transformer":   ["d_model", "nhead", "num_layers", "dropout", "lr", "batch_size", "epochs"],
    "gru":           ["hidden_dim", "num_layers", "dropout", "lr", "batch_size", "epochs"],
    "lstm":          ["hidden_dim", "num_layers", "dropout", "lr", "batch_size", "epochs"],
    "tcn":           ["num_channels", "kernel_size", "dropout", "lr", "batch_size", "epochs"],
    "mlp_mean":      ["hidden_dim", "num_layers", "dropout", "lr", "batch_size", "epochs"],
    "mlp_max":       ["hidden_dim", "num_layers", "dropout", "lr", "batch_size", "epochs"],
    "mlp_concat":    ["hidden_dim", "num_layers", "dropout", "lr", "batch_size", "epochs"],
    "xgboost":       ["n_estimators", "max_depth", "learning_rate", "subsample", "colsample_bytree"],
    "lightgbm":      ["n_estimators", "num_leaves", "learning_rate", "feature_fraction", "bagging_fraction"],
    "random_forest": ["n_estimators", "max_depth", "max_features"],
    "baseline":      ["n_estimators", "max_depth", "max_features"],
}


# ─── Helpers ─────────────────────────────────────────────────────────────────

def _read_model(d: Path) -> dict | None:
    """Load test_metrics + config from a model dir. Returns None on failure."""
    test   = load_json(d / "test_metrics.json")
    cfg    = load_json(d / "config.json")
    kind_f = d / "model_kind.txt"
    kind   = kind_f.read_text(encoding="utf-8").strip() if kind_f.exists() else d.name
    if test is None:
        return None
    hz_metrics = get_horizon_metrics(test)
    if not hz_metrics:
        return None
    return {"kind": kind, "display": model_display_name(kind),
            "config": cfg or {}, "hz_metrics": hz_metrics}


def _mean_f1(hz_metrics: dict) -> float | None:
    """Mean Macro-F1 across all available horizons."""
    vals = [v.get("f1_macro") for v in hz_metrics.values() if v.get("f1_macro") is not None]
    return float(np.mean(vals)) if vals else None


def _metric_row(hz_metrics: dict, h: float, model_display: str) -> dict:
    """Build a single row dict for one model at one horizon."""
    entry = hz_metrics.get(h)
    if entry is None:
        entry = {}
    return {
        "Model":        model_display,
        "Horizon (s)":  f"{h:.2f}",
        "Accuracy":     fmt_f(entry.get("accuracy"),          dec=4),
        "Macro-F1":     fmt_f(entry.get("f1_macro"),          dec=4),
        "Weighted-F1":  fmt_f(entry.get("f1_weighted"),       dec=4),
        "Macro-AUC":    fmt_f(entry.get("roc_auc_macro"),     dec=4),
        "N samples":    str(entry.get("n", "---")),
    }


def _plot_confusion_matrix(cm: list[list], class_names: list[str],
                            title: str, out_path: Path) -> None:
    """Save a normalised confusion matrix as PNG."""
    import matplotlib.pyplot as plt
    import matplotlib.colors as mcolors

    cm_arr   = np.array(cm, dtype=float)
    row_sums = cm_arr.sum(axis=1, keepdims=True)
    cm_norm  = cm_arr / np.where(row_sums == 0, 1.0, row_sums)
    cm_norm[row_sums.squeeze() == 0] = 0.0

    n = cm_norm.shape[0]
    fig, ax = plt.subplots(figsize=(max(4, n * 1.2), max(3.5, n * 1.1)))
    im = ax.imshow(cm_norm, interpolation="nearest",
                   cmap="Blues", vmin=0, vmax=1)
    plt.colorbar(im, ax=ax, fraction=0.046, pad=0.04)
    ticks = np.arange(n)
    ax.set_xticks(ticks)
    ax.set_yticks(ticks)
    labels = class_names if class_names else [str(i) for i in range(n)]
    ax.set_xticklabels(labels, rotation=45, ha="right", fontsize=8)
    ax.set_yticklabels(labels, fontsize=8)
    thresh = 0.5
    for i in range(n):
        for j in range(n):
            ax.text(j, i, f"{cm_norm[i, j]:.2f}",
                    ha="center", va="center", fontsize=7,
                    color="white" if cm_norm[i, j] > thresh else "black")
    ax.set_xlabel("Predicted")
    ax.set_ylabel("True")
    ax.set_title(title, fontsize=9)
    plt.tight_layout()
    fig.savefig(out_path, dpi=150, bbox_inches="tight")
    plt.close(fig)


def _plot_horizon_curve(records: list[dict], out_path: Path,
                        highlight_model: str | None = None,
                        top_n: int = 0) -> None:
    """Macro-F1 vs horizon curve; one line per model.

    top_n > 0: highlight the top-N models by mean F1 with bold colour lines,
    rest are thin/grey — suitable for the ucA_horizon_curve_all figure.
    highlight_model: always highlight this model display name (on top of top_n).
    """
    import matplotlib.pyplot as plt

    COLORS = ["#4878CF","#D65F5F","#6ACC65","#B47CC7","#C4AD66",
              "#77BEDB","#F0A500","#E377C2","#8C564B","#666666"]
    ranked  = sorted(records, key=lambda r: (_mean_f1(r["hz_metrics"]) or -1), reverse=True)
    top_set = {r["display"] for r in ranked[:top_n]} if top_n > 0 else set()
    if highlight_model:
        top_set.add(highlight_model)

    fig, ax = plt.subplots(figsize=(7, 4))
    for i, rec in enumerate(records):
        hz_m  = rec["hz_metrics"]
        valid = [(h, hz_m[h].get("f1_macro")) for h in sorted(hz_m)
                 if hz_m[h].get("f1_macro") is not None]
        if not valid:
            continue
        hs_v, f1s_v = zip(*valid)
        in_top = rec["display"] in top_set
        ax.plot(hs_v, f1s_v, marker="o", markersize=4,
                lw=2.2 if in_top else 1.0,
                ls="-"  if in_top else "--",
                alpha=1.0 if in_top else 0.5,
                color=COLORS[i % len(COLORS)] if in_top else "#BBBBBB",
                label=rec["display"])

    ax.set_xlabel("Prediction horizon (s)")
    ax.set_ylabel("Macro-F1")
    ax.set_title("Use Case A: Macro-F1 vs. prediction horizon")
    ax.legend(fontsize=8, ncol=2)
    plt.tight_layout()
    fig.savefig(out_path, dpi=150, bbox_inches="tight")
    plt.close(fig)


# ─── New table builders ───────────────────────────────────────────────────────

def _make_model_suite_table(models: list[dict], out: Path) -> None:
    """Tab. ucA_model_suite — mean F1 across all horizons + 3 ref horizons."""
    rows = []
    for m in models:
        avail = list(m["hz_metrics"])
        row: dict = {
            "Model":               m["display"],
            "F1-mean (all hor.)":  fmt_f(_mean_f1(m["hz_metrics"]), dec=4),
        }
        for h in BASELINE_HORIZONS:
            nh  = nearest_horizon(avail, h)
            val = m["hz_metrics"][nh].get("f1_macro") if nh is not None else None
            row[f"@ {h}s"] = fmt_f(val, dec=4)
        rows.append(row)
    rows.sort(
        key=lambda r: float(r["F1-mean (all hor.)"]) if r["F1-mean (all hor.)"] != "---" else -1,
        reverse=True,
    )
    print("\n  [Tab] ucA_model_suite")
    save_artifact(
        pd.DataFrame(rows), out, "uca_model_suite",
        caption=(
            r"Use Case A: quantitative comparison across the model suite. "
            r"$\overline{\mathrm{F1}}$ = mean Macro-F1 across all prediction horizons; "
            r"columns @ Xs show Macro-F1 at that specific horizon."
        ),
        label="tab:ucA_model_suite",
    )


def _make_ranks_table(models: list[dict], out: Path) -> None:
    """Tab. ucA_ranks — ranking by mean F1 + Friedman test p-value."""
    all_h = sorted({h for m in models for h in m["hz_metrics"]})
    vecs  = [
        np.array([m["hz_metrics"].get(h, {}).get("f1_macro", np.nan) for h in all_h])
        for m in models
    ]
    means = [float(np.nanmean(v)) if not np.all(np.isnan(v)) else np.nan for v in vecs]

    friedman_p = "---"
    if len(models) >= 3:
        try:
            from scipy import stats as _st
            mask = ~np.any(np.isnan(np.stack(vecs)), axis=0)
            if mask.sum() >= 3:
                _, p = _st.friedmanchisquare(*[v[mask] for v in vecs])
                friedman_p = f"{p:.4f}"
        except Exception:
            pass

    ranks = pd.Series(means).rank(ascending=False, na_option="bottom").tolist()
    rows  = sorted(
        [{
            "Model":              m["display"],
            "Mean F1 (all hor.)": fmt_f(means[i], dec=4),
            "Rank":               str(int(ranks[i])),
            "Friedman p":         friedman_p if i == 0 else "---",
            "Notes":              "reference" if int(ranks[i]) == 1 else "",
        } for i, m in enumerate(models)],
        key=lambda r: int(r["Rank"]),
    )
    print("\n  [Tab] ucA_ranks")
    save_artifact(
        pd.DataFrame(rows), out, "uca_ranks",
        caption=(
            "Use Case A: model ranking by mean Macro-F1 across all horizons. "
            "Friedman p-value (row 1) treats horizons as blocks; "
            "--- means insufficient models or horizons for the test."
        ),
        label="tab:ucA_ranks",
    )


def _make_hp_suite_table(models: list[dict], out: Path) -> None:
    """Tab. hp_suite — hyperparameter audit from config.json."""
    COMMON = ["window_seconds", "sample_hz", "epochs"]
    rows   = []
    for m in models:
        cfg     = m.get("config", {})
        kind    = m["kind"].lower()
        hp_keys = _MODEL_HP_KEYS.get(kind, _MODEL_HP_KEYS["transformer"])
        hp_parts = [
            f"{k}={cfg[k]}" if cfg.get(k) is not None else f"{k}=?"
            for k in hp_keys
        ]
        common_p = [f"{k}={cfg[k]}" for k in COMMON if cfg.get(k) is not None]
        rows.append({
            "Model":           m["display"],
            "Key hyperparams": "; ".join(hp_parts) or "---",
            "Common config":   "; ".join(common_p)  or "---",
            "Selection":       "val Macro-F1",
        })
    print("\n  [Tab] hp_suite")
    save_artifact(
        pd.DataFrame(rows), out, "hp_suite",
        caption=(
            "Hyperparameter audit for the model suite (Use Case A). "
            "Values read from \\texttt{config.json}; "
            "? denotes model-specific params not stored in the shared config."
        ),
        label="tab:hp_suite",
        col_format=(
            "p{0.16\\linewidth}p{0.46\\linewidth}"
            "p{0.22\\linewidth}p{0.1\\linewidth}"
        ),
    )


# ─── Core logic ───────────────────────────────────────────────────────────────

def run(args: argparse.Namespace) -> None:
    out = Path(args.outdir)
    out.mkdir(parents=True, exist_ok=True)
    print(f"\n[RQ2-A] Use Case A results  ->  {out}")

    arts_dir = Path(args.artifacts_dir)
    model_dirs = scan_model_dirs(arts_dir)
    if not model_dirs:
        print(f"  [ERROR] No model dirs found in {arts_dir}")
        return
    print(f"  Found {len(model_dirs)} model dir(s): {[d.name for d in model_dirs]}")

    # Load all models
    models: list[dict] = []
    for d in model_dirs:
        rec = _read_model(d)
        if rec is None:
            print(f"  [WARN] Skipping {d.name}")
            continue
        rec["dir"] = d
        models.append(rec)
        print(f"  Loaded: {d.name}  ({len(rec['hz_metrics'])} horizons)")

    if not models:
        print("  [ERROR] No valid model data. Aborting.")
        return

    ref_h = args.ref_horizon

    # ── Table: ucA_main (primary model, all horizons) ─────────────────────────
    primary = next(
        (m for m in models if m["kind"].lower() == PRIMARY_MODEL),
        models[0],   # fallback to first available
    )
    print(f"\n  Primary model for ucA_main: {primary['display']} ({primary['dir'].name})")

    main_rows = []
    for h in sorted(primary["hz_metrics"].keys()):
        main_rows.append(_metric_row(primary["hz_metrics"], h, primary["display"]))
    main_df = pd.DataFrame(main_rows)
    print("\n  [Tab] ucA_main")
    save_artifact(
        main_df, out, "uca_main",
        caption=(
            f"Use Case A: multi-horizon maneuver prediction results for the "
            f"{primary['display']} model on the test split."
        ),
        label="tab:ucA_main",
        col_format="lcccccc",
    )

    # ── Tables ────────────────────────────────────────────────────────────────
    # ucA_baselines — pivot: one row per model, 3 ref horizons
    pivot_rows = []
    for m in models:
        avail = list(m["hz_metrics"].keys())
        row: dict = {"Model": m["display"]}
        for target_h in BASELINE_HORIZONS:
            h   = nearest_horizon(avail, target_h)
            val = m["hz_metrics"][h].get("f1_macro") if h is not None else None
            row[f"Macro-F1 @ {target_h}s"] = fmt_f(val, dec=4)
        pivot_rows.append(row)
    bas_df = pd.DataFrame(pivot_rows)
    print("\n  [Tab] ucA_baselines")
    save_artifact(
        bas_df, out, "uca_baselines",
        caption="Use Case A: Macro-F1 comparison across all models at selected horizons.",
        label="tab:ucA_baselines",
    )

    # New tables: model_suite, ranks, hp_suite
    _make_model_suite_table(models, out)
    _make_ranks_table(models, out)
    _make_hp_suite_table(models, out)

    # ── Full cross-model CSV ──────────────────────────────────────────────────
    all_rows = []
    for m in models:
        for h in sorted(m["hz_metrics"].keys()):
            all_rows.append(_metric_row(m["hz_metrics"], h, m["display"]))
    if all_rows:
        all_csv = out / "uca_all_models.csv"
        pd.DataFrame(all_rows).to_csv(all_csv, index=False)
        print(f"    Full table: {all_csv}")

    # ── Figures ───────────────────────────────────────────────────────────────
    if setup_mpl():
        # Fig. ucA_horizon_curve (primary model highlighted)
        fig_path = out / "horizon_curve.png"
        _plot_horizon_curve(models, fig_path, highlight_model=primary["display"])
        print(f"\n  [Fig] horizon_curve -> {fig_path}")

        # Fig. ucA_horizon_curve_all (top-3 highlighted, rest grey)
        fig_all = out / "horizon_curve_all.png"
        _plot_horizon_curve(models, fig_all, top_n=3)
        print(f"  [Fig] horizon_curve_all -> {fig_all}")

        # Fig. ucA_cm (confusion matrix at ref horizon)
        p_h = nearest_horizon(list(primary["hz_metrics"].keys()), ref_h)
        if p_h is not None:
            entry = primary["hz_metrics"][p_h]
            cm    = entry.get("confusion_matrix")
            if cm:
                per_class   = entry.get("per_class", {})
                class_names = list(per_class.keys()) if per_class else []
                cm_path     = out / f"confusion_matrix_{p_h:.2f}s.png"
                _plot_confusion_matrix(
                    cm, class_names,
                    title=f"{primary['display']} -- confusion matrix @ {p_h:.2f}s (normalised)",
                    out_path=cm_path,
                )
                print(f"  [Fig] confusion_matrix_{p_h:.2f}s.png -> {cm_path}")

    print("  Done.\n")


# ─── Entry point ─────────────────────────────────────────────────────────────

def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--artifacts-dir", default="artifacts", dest="artifacts_dir")
    p.add_argument("--ref-horizon",   type=float, default=1.0, dest="ref_horizon",
                   help="Reference horizon in seconds for the confusion matrix (default: 1.0)")
    p.add_argument("--outdir",        default="artifacts/results/rq2_uca")
    run(p.parse_args())


if __name__ == "__main__":
    main()
