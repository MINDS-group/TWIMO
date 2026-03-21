import json
import argparse
from pathlib import Path

import matplotlib.pyplot as plt
import numpy as np


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


def plot_single_metric(x, y, name, output_folder):
    # Line plot
    plt.figure()
    plt.plot(x, y)
    # plt.xscale("log")
    plt.xlabel("Prediction Horizon (seconds)")
    plt.ylabel(name)
    plt.title(f"{name} vs Horizon")
    plt.xticks(x)
    plt.grid(True)
    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_lineplot.png")
    plt.close()

    # Bar plot
    plt.figure()
    plt.bar(x, y)
    # plt.xscale("log")
    plt.xlabel("Prediction Horizon (seconds)")
    plt.ylabel(name)
    plt.title(f"{name} vs Horizon")
    plt.xticks(x)
    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_barplot.png")
    plt.close()


def plot_dual_metric(x, y_macro, y_weighted, name, output_folder):
    # Line plot
    plt.figure()
    plt.plot(x, y_macro, label="Macro")
    plt.plot(x, y_weighted, label="Weighted")
    # plt.xscale("log")
    plt.xlabel("Prediction Horizon (seconds)")
    plt.ylabel(name)
    plt.title(f"{name} vs Horizon")
    plt.xticks(x)
    plt.legend()
    plt.grid(True)
    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_lineplot.png")
    plt.close()

    # Bar plot
    width = 0.35
    x_pos = np.arange(len(x))

    plt.figure()
    plt.bar(x_pos - width/2, y_macro, width, label="Macro")
    plt.bar(x_pos + width/2, y_weighted, width, label="Weighted")
    # plt.xscale("log")
    plt.xlabel("Prediction Horizon (seconds)")
    plt.ylabel(name)
    plt.title(f"{name} vs Horizon")
    plt.xticks(x_pos, x)
    plt.legend()
    plt.tight_layout()
    plt.savefig(output_folder / f"{name.lower()}_barplot.png")
    plt.close()


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("json_file", type=str, help="Full path to the JSON file")
    parser.add_argument("output_folder", type=str, help="Folder where plots will be saved")
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

    print("Plots saved in:", output_folder)


if __name__ == "__main__":
    main()