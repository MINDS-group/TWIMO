"""Shared utilities for twimo.results scripts."""
from __future__ import annotations

import json
import sys
from pathlib import Path
from typing import Any

import numpy as np
import pandas as pd


# ─── I/O helpers ──────────────────────────────────────────────────────────────

def load_manifest(path: Path) -> list[dict]:
    """Load JSONL manifest; return list of session dicts."""
    records = []
    with open(path, encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if line:
                records.append(json.loads(line))
    return records


def load_json(path: Path) -> Any:
    """Load JSON file; return None on error (with warning)."""
    try:
        with open(path, encoding="utf-8") as f:
            return json.load(f)
    except (FileNotFoundError, json.JSONDecodeError) as e:
        print(f"  [WARN] Cannot load {path}: {e}", file=sys.stderr)
        return None


def load_npy(path: Path) -> np.ndarray | None:
    """Load .npy array; return None on error."""
    try:
        return np.load(str(path), allow_pickle=False)
    except Exception as e:
        print(f"  [WARN] Cannot load {path}: {e}", file=sys.stderr)
        return None


# ─── Metrics parsing ──────────────────────────────────────────────────────────

def parse_horizon_key(k: str) -> float:
    """Convert horizon key '1.0s' or '1.0' to float seconds."""
    return float(str(k).rstrip("s"))


def get_horizon_metrics(metrics: dict) -> dict[float, dict]:
    """
    Extract per-horizon entries from test_metrics.json.
    Keys are horizon floats (seconds); skips '_inference' and other non-horizon keys.
    """
    result: dict[float, dict] = {}
    for k, v in metrics.items():
        if k.startswith("_") or not isinstance(v, dict):
            continue
        try:
            h = parse_horizon_key(k)
            result[h] = v
        except ValueError:
            pass
    return dict(sorted(result.items()))


def nearest_horizon(available: list[float], target: float) -> float | None:
    """Return the horizon in *available* closest to *target*."""
    if not available:
        return None
    return min(available, key=lambda h: abs(h - target))


def scan_model_dirs(artifacts_dir: Path) -> list[Path]:
    """Return all maneuver model directories (contain model_kind.txt)."""
    dirs = []
    for d in sorted(artifacts_dir.iterdir()):
        if d.is_dir() and (d / "model_kind.txt").exists() and (d / "test_metrics.json").exists():
            dirs.append(d)
    return dirs


# ─── Statistical helpers ──────────────────────────────────────────────────────

def bootstrap_ci(values: list[float], n: int = 2000, ci: float = 0.95) -> tuple[float, float]:
    """Bootstrap 95% CI for the mean of *values*."""
    arr = np.array([v for v in values if v is not None and not np.isnan(float(v))])
    if len(arr) < 2:
        m = float(arr.mean()) if len(arr) == 1 else float("nan")
        return m, m
    rng = np.random.default_rng(42)
    means = [rng.choice(arr, len(arr), replace=True).mean() for _ in range(n)]
    lo = float(np.percentile(means, (1 - ci) / 2 * 100))
    hi = float(np.percentile(means, (1 + ci) / 2 * 100))
    return lo, hi


# ─── Formatting helpers ───────────────────────────────────────────────────────

def fmt_f(v, dec=4) -> str:
    """Format float to *dec* decimal places; '---' for None/NaN."""
    if v is None:
        return "---"
    try:
        if np.isnan(float(v)):
            return "---"
        return f"{float(v):.{dec}f}"
    except (TypeError, ValueError):
        return "---"


def fmt_pct(v, dec=1) -> str:
    """Format a 0-1 ratio as percentage string."""
    if v is None:
        return "---"
    try:
        if np.isnan(float(v)):
            return "---"
        return f"{float(v) * 100:.{dec}f}"
    except (TypeError, ValueError):
        return "---"


def fmt_ci(lo: float, hi: float, dec: int = 3) -> str:
    """Format a CI pair as '[lo, hi]'."""
    if np.isnan(lo) or np.isnan(hi):
        return "---"
    return f"[{lo:.{dec}f}, {hi:.{dec}f}]"


def model_display_name(kind: str) -> str:
    """Human-readable model name from model_kind.txt content."""
    MAP = {
        "transformer": "Transformer",
        "xgboost": "XGBoost",
        "lightgbm": "LightGBM",
        "random_forest": "Random Forest",
        "gru": "GRU",
        "lstm": "LSTM",
        "tcn": "TCN",
        "mlp_mean": "MLP (mean)",
        "mlp_max": "MLP (max)",
        "mlp_concat": "MLP (concat)",
        "baseline": "Baseline (auto)",
    }
    return MAP.get(kind.strip().lower(), kind.strip())


# ─── LaTeX output ─────────────────────────────────────────────────────────────

def latex_table(
    df: pd.DataFrame,
    caption: str,
    label: str,
    col_format: str | None = None,
    fontsize: str = r"\small",
    midrule_after: list[int] | None = None,
) -> str:
    """
    Render DataFrame as a complete LaTeX table using booktabs.

    Parameters
    ----------
    df : DataFrame to render (column headers become \\textbf{}).
    caption, label : LaTeX caption and label.
    col_format : column alignment string (default: l + c*n).
    fontsize : LaTeX font-size command (default: \\small).
    midrule_after : row indices (0-based) after which to insert \\midrule.
    """
    ncols = len(df.columns)
    if col_format is None:
        col_format = "l" + "c" * (ncols - 1)

    hdr = " & ".join(f"\\textbf{{{c}}}" for c in df.columns)
    lines = [
        r"\begin{table}[t]",
        r"\centering",
        fontsize,
        r"\setlength{\tabcolsep}{4pt}",
        r"\renewcommand{\arraystretch}{1.1}",
        f"\\begin{{tabular}}{{{col_format}}}",
        r"\toprule",
        hdr + r" \\",
        r"\midrule",
    ]
    midrule_after = set(midrule_after or [])
    for i, (_, row) in enumerate(df.iterrows()):
        lines.append(" & ".join(str(v) for v in row) + r" \\")
        if i in midrule_after:
            lines.append(r"\midrule")
    lines += [
        r"\bottomrule",
        r"\end{tabular}",
        f"\\caption{{{caption}}}",
        f"\\label{{{label}}}",
        r"\end{table}",
    ]
    return "\n".join(lines)


def save_artifact(
    df: pd.DataFrame,
    out_dir: Path,
    stem: str,
    caption: str,
    label: str,
    col_format: str | None = None,
    fontsize: str = r"\small",
    midrule_after: list[int] | None = None,
) -> None:
    """Save DataFrame as CSV and LaTeX snippet, printing paths."""
    out_dir.mkdir(parents=True, exist_ok=True)
    csv_path = out_dir / f"{stem}.csv"
    tex_path = out_dir / f"{stem}.tex"
    df.to_csv(csv_path, index=False)
    tex = latex_table(df, caption, label, col_format, fontsize, midrule_after)
    tex_path.write_text(tex, encoding="utf-8")
    print(f"    CSV  : {csv_path}")
    print(f"    LaTeX: {tex_path}")


# ─── Plot helpers ─────────────────────────────────────────────────────────────

def setup_mpl():
    """Configure matplotlib for publication-quality output. Returns True if available."""
    try:
        import matplotlib
        matplotlib.use("Agg")
        import matplotlib.pyplot as plt

        plt.rcParams.update(
            {
                "figure.dpi": 150,
                "font.family": "serif",
                "axes.spines.top": False,
                "axes.spines.right": False,
                "axes.grid": True,
                "grid.alpha": 0.3,
                "legend.framealpha": 0.8,
            }
        )
        return True
    except ImportError:
        return False
