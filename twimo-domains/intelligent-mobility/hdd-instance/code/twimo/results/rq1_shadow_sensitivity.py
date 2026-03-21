"""
RQ1-T3 — Digital Shadow: sensitivity of downstream metrics to alignment parameters.

Reads test_metrics.json from multiple model runs trained at different sampling
frequencies (or interpolation policies) and compares key metrics at a reference
horizon to assess robustness of the Digital Shadow alignment.

Produces
--------
  artifacts/results/rq1/ds_sensitivity.csv / .tex  -> Tab. ds_sensitivity

Usage
-----
  # Re-run training at different fs first, then:
  python -m twimo.results.rq1_shadow_sensitivity \\
      --model-dirs \\
          artifacts/maneuver_transformer_3hz \\
          artifacts/maneuver_transformer_1hz \\
          artifacts/maneuver_transformer_5hz \\
      --labels "3 Hz (default)" "1 Hz (alt-1)" "5 Hz (alt-2)" \\
      --outdir artifacts/results/rq1

  # Or auto-discover from artifacts dir:
  python -m twimo.results.rq1_shadow_sensitivity --artifacts-dir artifacts
"""
from __future__ import annotations

import argparse
from pathlib import Path

import numpy as np
import pandas as pd

from twimo.results._utils import (
    load_json, get_horizon_metrics, nearest_horizon,
    fmt_f, save_artifact,
)


def _load_run(model_dir: Path, ref_horizon: float) -> dict | None:
    """Load config + metrics from a model run directory."""
    cfg  = load_json(model_dir / "config.json")
    test = load_json(model_dir / "test_metrics.json")
    if test is None:
        return None

    hz_metrics = get_horizon_metrics(test)
    if not hz_metrics:
        return None

    h = nearest_horizon(list(hz_metrics.keys()), ref_horizon)
    m = hz_metrics[h]

    # Read sample_hz from config or model_kind
    sample_hz = None
    if cfg:
        sample_hz = cfg.get("sample_hz") or cfg.get("sample_hz_override")
    if sample_hz is None:
        # Try to infer from dir name (e.g., maneuver_transformer_3hz)
        for part in model_dir.name.split("_"):
            if part.endswith("hz"):
                try:
                    sample_hz = float(part[:-2])
                    break
                except ValueError:
                    pass

    interp = None
    if cfg:
        interp = cfg.get("interp_policy") or cfg.get("interpolation") or "---"

    model_kind_file = model_dir / "model_kind.txt"
    model_kind = model_kind_file.read_text(encoding="utf-8").strip() if model_kind_file.exists() else "?"

    return {
        "model_dir":   str(model_dir),
        "model_kind":  model_kind,
        "sample_hz":   sample_hz,
        "interp":      interp or "forward-fill",
        "ref_horizon": h,
        "f1_macro":    m.get("f1_macro"),
        "f1_weighted": m.get("f1_weighted"),
        "accuracy":    m.get("accuracy"),
        "roc_auc":     m.get("roc_auc_macro"),
    }


def run(args: argparse.Namespace) -> None:
    out = Path(args.outdir)
    out.mkdir(parents=True, exist_ok=True)
    print(f"\n[RQ1-T3] Shadow sensitivity to alignment parameters  ->  {out}")

    ref_h = args.ref_horizon
    model_dirs: list[Path] = []

    if args.model_dirs:
        model_dirs = [Path(d) for d in args.model_dirs]
    elif args.artifacts_dir:
        # Auto-discover: look for dirs with different hz in name
        base = Path(args.artifacts_dir)
        for d in sorted(base.iterdir()):
            if d.is_dir() and (d / "test_metrics.json").exists():
                model_dirs.append(d)
        print(f"  Auto-discovered {len(model_dirs)} model dir(s) in {base}")

    if not model_dirs:
        print("  [ERROR] No model directories found. Use --model-dirs or --artifacts-dir.")
        return

    labels = args.labels or []
    rows = []
    for i, d in enumerate(model_dirs):
        label = labels[i] if i < len(labels) else d.name
        info  = _load_run(d, ref_h)
        if info is None:
            print(f"  [WARN] Skipping {d} (no valid test_metrics.json)")
            continue
        hz_str    = f"{info['sample_hz']:.0f} Hz" if info["sample_hz"] else "?"
        interp    = info["interp"]
        ref_used  = info["ref_horizon"]
        rows.append({
            "Variant":                   label,
            "$f_s$":                     hz_str,
            "Interp policy":             interp,
            f"Macro-F1 @ {ref_used:.1f}s": fmt_f(info["f1_macro"], dec=4),
            f"Accuracy @ {ref_used:.1f}s": fmt_f(info["accuracy"], dec=4),
            f"ROC-AUC  @ {ref_used:.1f}s": fmt_f(info["roc_auc"],  dec=4),
            "Notes":                     "default" if i == 0 else f"alt-{i}",
        })
        print(f"  {label}: fs={hz_str}, Macro-F1={fmt_f(info['f1_macro'])}")

    if not rows:
        print("  [ERROR] No valid runs loaded.")
        return

    # Mark default (first row) and compute delta vs default
    df = pd.DataFrame(rows)
    print("\n  [Tab] ds_sensitivity")
    save_artifact(
        df, out, "ds_sensitivity",
        caption=(
            "Sensitivity of downstream performance to Digital Shadow alignment parameters. "
            f"Metrics reported at the reference horizon ({ref_h:.1f} s)."
        ),
        label="tab:ds_sensitivity",
    )

    # Also save a delta table (delta vs first row)
    f1_col = [c for c in df.columns if "Macro-F1" in c]
    if f1_col and len(rows) > 1:
        f1_col = f1_col[0]
        try:
            baseline = float(df.iloc[0][f1_col])
            delta_rows = []
            for _, r in df.iterrows():
                try:
                    val = float(r[f1_col])
                    delta = val - baseline
                except (ValueError, TypeError):
                    delta = float("nan")
                delta_rows.append({
                    "Variant":    r["Variant"],
                    "$f_s$":      r["$f_s$"],
                    "Macro-F1":   r[f1_col],
                    r"$\Delta$ vs default": f"{delta:+.4f}" if not np.isnan(delta) else "---",
                })
            delta_df = pd.DataFrame(delta_rows)
            save_artifact(
                delta_df, out, "ds_sensitivity_delta",
                caption=f"Delta in Macro-F1 (at {ref_h:.1f} s) relative to the default alignment configuration.",
                label="tab:ds_sensitivity_delta",
                col_format="lccc",
            )
        except (ValueError, TypeError):
            pass

    print("  Done.\n")


# ─── Entry point ─────────────────────────────────────────────────────────────

def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--model-dirs", nargs="+", default=None, dest="model_dirs",
                   help="Paths to model run directories (ordered: default first, then variants)")
    p.add_argument("--labels", nargs="+", default=None,
                   help="Display labels for each model dir (same order as --model-dirs)")
    p.add_argument("--artifacts-dir", default="artifacts", dest="artifacts_dir",
                   help="Auto-discover model dirs from this root (used if --model-dirs not set)")
    p.add_argument("--ref-horizon", type=float, default=1.0, dest="ref_horizon",
                   help="Reference horizon in seconds for the comparison table (default: 1.0)")
    p.add_argument("--outdir", default="artifacts/results/rq1")
    run(p.parse_args())


if __name__ == "__main__":
    main()
