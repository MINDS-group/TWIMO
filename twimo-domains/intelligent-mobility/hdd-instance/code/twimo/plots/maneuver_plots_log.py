import json
import argparse
from pathlib import Path

import matplotlib.pyplot as plt
import numpy as np


# -----------------------------
# Formatting utilities
# -----------------------------

def format_horizon(value):
    """
    Format horizon values:
    - 1.0 -> "1.0"
    - 0.1 -> "0.1"
    - 0.25 -> "0.25"
    - Remove unnecessary trailing zeros
    """
    if float(value).is_integer():
        return f"{value:.1f}"
    else:
        return f"{value}".rstrip("0").rstrip(".")


def setup_log_x_axis(ax, x_values):
    """
    Set log scale on X axis and apply clean tick labels.
    """
    ax.set_xscale("log")
    ax.set_xticks(x_values)
    ax.set_xticklabels([format_horizon(v) for v in x_values])


# -----------------------------
# Data loading
# -----------------------------

def load_metrics(json_path: Path):
    with open(json_path, "r") as f:
        data = json.load(f)

    horizons = []
    accuracy = []
    precision_macro = []
    precision_weighted = []
    recall_macro = []
    recall_weighted = []
    f1_macro = []
    f1_weighted = []

    for key, value in data.items():
        if key.startswith("_"):
            continue

        h = value.get("horizon_seconds")
        if h is None:
            continue

        horizons.append(h)
        accuracy.append(value["accuracy"])
        precision_macro.append(value["precision_macro"])
        precision_weighted.append(value["precision_weighted"])
        recall_macro.append(value["recall_macro"])
        recall_weighted.append(value["recall_weighted"])
        f1_macro.append(value["f1_macro"])
        f1_weighted.append(value["f1_weighted"])

    # Sort by increasing horizon
    sorted_idx = np.argsort(horizons)
    horizons = np.array(horizons)[sorted_idx]

    return (
        horizons,
        np.array(accuracy)[sorted_idx],
        np.array(precision_macro)[sorted_idx],
        np.array(precision_weighted)[sorted_idx],
        np.array(recall_macro)[sorted_idx],
        np.array(recall_weighted)[sorted_idx],
        np.array(f1_macro)[sorted_idx],
        np.array(f1_weighted)[sorted_idx],
    )


# -----------------------------
# Plotting functions
# -----------------------------

def plot_single_metric(x, y, name, output_folder):
    # Line plot
    fig, ax = plt.subplots()
    ax.plot(x, y, marker="o")
    setup_log_x_axis(ax, x)

    ax.set_xlabel("Prediction Horizon (seconds)")
    ax.set_ylabel(name)
    ax.set_title(f"{name} vs Horizon")
    ax.grid(True, which="both", linestyle="--", linewidth=0.5)

    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_lineplot.png", dpi=300)
    plt.close()

    # Bar plot
    fig, ax = plt.subplots()
    ax.bar(x, y)
    setup_log_x_axis(ax, x)

    ax.set_xlabel("Prediction Horizon (seconds)")
    ax.set_ylabel(name)
    ax.set_title(f"{name} vs Horizon")

    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_barplot.png", dpi=300)
    plt.close()


def plot_dual_metric(x, y_macro, y_weighted, name, output_folder):
    # Line plot
    fig, ax = plt.subplots()
    ax.plot(x, y_macro, marker="o", label="Macro")
    ax.plot(x, y_weighted, marker="o", label="Weighted")
    setup_log_x_axis(ax, x)

    ax.set_xlabel("Prediction Horizon (seconds)")
    ax.set_ylabel(name)
    ax.set_title(f"{name} vs Horizon")
    ax.legend()
    ax.grid(True, which="both", linestyle="--", linewidth=0.5)

    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_lineplot.png", dpi=300)
    plt.close()

    # Bar plot
    width = 0.35
    x_pos = np.arange(len(x))

    fig, ax = plt.subplots()
    ax.bar(x_pos - width / 2, y_macro, width, label="Macro")
    ax.bar(x_pos + width / 2, y_weighted, width, label="Weighted")

    ax.set_xticks(x_pos)
    ax.set_xticklabels([format_horizon(v) for v in x])

    ax.set_xlabel("Prediction Horizon (seconds)")
    ax.set_ylabel(name)
    ax.set_title(f"{name} vs Horizon")
    ax.legend()

    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_barplot.png", dpi=300)
    plt.close()


# -----------------------------
# Main
# -----------------------------

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("json_file", type=str, help="Path to JSON file")
    parser.add_argument("output_folder", type=str, help="Folder to save plots")
    args = parser.parse_args()

    json_path = Path(args.json_file)
    output_folder = Path(args.output_folder)

    if not json_path.exists():
        raise FileNotFoundError(f"JSON file not found: {json_path}")

    output_folder.mkdir(parents=True, exist_ok=True)

    (
        horizons,
        accuracy,
        precision_macro,
        precision_weighted,
        recall_macro,
        recall_weighted,
        f1_macro,
        f1_weighted,
    ) = load_metrics(json_path)

    plot_single_metric(horizons, accuracy, "Accuracy", output_folder)
    plot_dual_metric(horizons, precision_macro, precision_weighted, "Precision", output_folder)
    plot_dual_metric(horizons, recall_macro, recall_weighted, "Recall", output_folder)
    plot_dual_metric(horizons, f1_macro, f1_weighted, "F1", output_folder)

    print(f"Plots saved in: {output_folder}")


if __name__ == "__main__":
    main()