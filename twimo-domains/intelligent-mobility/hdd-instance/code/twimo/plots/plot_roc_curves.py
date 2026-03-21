#!/usr/bin/env python
"""Plot ROC AUC curves from roc_curves.json.

Generates one PNG per (split, horizon) showing per-class ROC curves,
plus a summary PNG per split with macro-average ROC across horizons.

Usage:
    python twimo/plots/plot_roc_curves.py \
        --roc-json ./artifacts/maneuver_proxy/maneuver_transformer/roc_curves.json \
        --outdir ./artifacts/maneuver_proxy/maneuver_transformer/roc_plots
"""
from __future__ import annotations

import argparse
import json
from pathlib import Path

import matplotlib.pyplot as plt
import numpy as np


# Color palette for classes
CLASS_COLORS = [
    "#1f77b4", "#ff7f0e", "#2ca02c", "#d62728", "#9467bd",
    "#8c564b", "#e377c2", "#7f7f7f", "#bcbd22", "#17becf",
    "#aec7e8", "#ffbb78", "#98df8a", "#ff9896",
]


def plot_roc_for_horizon(
    horizon_key: str,
    class_curves: dict,
    split_name: str,
    outdir: Path,
) -> None:
    """Plot per-class ROC curves for a single horizon."""
    if not class_curves:
        return

    fig, ax = plt.subplots(figsize=(7, 6))

    for i, (cname, data) in enumerate(sorted(class_curves.items())):
        fpr = np.array(data["fpr"])
        tpr = np.array(data["tpr"])
        # Compute AUC via trapezoidal rule
        auc_val = float(np.trapz(tpr, fpr))
        color = CLASS_COLORS[i % len(CLASS_COLORS)]
        ax.plot(fpr, tpr, color=color, lw=1.8, label=f"{cname} (AUC={auc_val:.3f})")

    ax.plot([0, 1], [0, 1], "k--", lw=0.8, alpha=0.5, label="Random")
    ax.set_xlabel("False Positive Rate")
    ax.set_ylabel("True Positive Rate")
    ax.set_title(f"ROC Curves — {split_name} — Horizon {horizon_key}")
    ax.legend(loc="lower right", fontsize=8)
    ax.set_xlim([0, 1])
    ax.set_ylim([0, 1.02])
    ax.grid(True, alpha=0.3)

    fname = f"roc_{split_name}_{horizon_key.replace('.', '_')}.png"
    fig.savefig(outdir / fname, dpi=150, bbox_inches="tight")
    plt.close(fig)
    print(f"  Saved {fname}")


def plot_roc_summary(
    split_data: dict,
    split_name: str,
    outdir: Path,
) -> None:
    """Plot macro-average ROC per horizon on a single figure."""
    if not split_data:
        return

    fig, ax = plt.subplots(figsize=(8, 6))

    # Sort horizons numerically
    horizons = sorted(split_data.keys(), key=lambda k: float(k.rstrip("s")))

    for i, h_key in enumerate(horizons):
        class_curves = split_data[h_key]
        if not class_curves:
            continue

        # Compute macro-average ROC: interpolate all classes onto common FPR grid
        mean_fpr = np.linspace(0, 1, 200)
        tprs = []
        for cname, data in class_curves.items():
            fpr = np.array(data["fpr"])
            tpr = np.array(data["tpr"])
            tprs.append(np.interp(mean_fpr, fpr, tpr))

        mean_tpr = np.mean(tprs, axis=0)
        mean_tpr[0] = 0.0
        auc_val = float(np.trapz(mean_tpr, mean_fpr))

        color = CLASS_COLORS[i % len(CLASS_COLORS)]
        ax.plot(mean_fpr, mean_tpr, color=color, lw=1.8,
                label=f"{h_key} (macro AUC={auc_val:.3f})")

    ax.plot([0, 1], [0, 1], "k--", lw=0.8, alpha=0.5)
    ax.set_xlabel("False Positive Rate")
    ax.set_ylabel("True Positive Rate (macro-avg)")
    ax.set_title(f"Macro-Average ROC — {split_name} — All Horizons")
    ax.legend(loc="lower right", fontsize=8)
    ax.set_xlim([0, 1])
    ax.set_ylim([0, 1.02])
    ax.grid(True, alpha=0.3)

    fname = f"roc_summary_{split_name}.png"
    fig.savefig(outdir / fname, dpi=150, bbox_inches="tight")
    plt.close(fig)
    print(f"  Saved {fname}")


def main():
    parser = argparse.ArgumentParser(description="Plot ROC curves from roc_curves.json")
    parser.add_argument("--roc-json", type=Path, required=True,
                        help="Path to roc_curves.json")
    parser.add_argument("--outdir", type=Path, required=True,
                        help="Output directory for PNG plots")
    parser.add_argument("--splits", nargs="*", default=None,
                        help="Splits to plot (default: all). E.g. --splits test val")
    args = parser.parse_args()

    args.outdir.mkdir(parents=True, exist_ok=True)

    with open(args.roc_json, "r") as f:
        roc_data = json.load(f)

    splits = args.splits or list(roc_data.keys())

    for split_name in splits:
        split_data = roc_data.get(split_name, {})
        if not split_data:
            print(f"No ROC data for split '{split_name}', skipping.")
            continue

        print(f"\nPlotting ROC curves for '{split_name}':")

        # Per-horizon plots
        for h_key in sorted(split_data.keys(), key=lambda k: float(k.rstrip("s"))):
            plot_roc_for_horizon(h_key, split_data[h_key], split_name, args.outdir)

        # Summary plot (macro-avg across horizons)
        plot_roc_summary(split_data, split_name, args.outdir)

    print(f"\nAll ROC plots saved to {args.outdir}")


if __name__ == "__main__":
    main()
