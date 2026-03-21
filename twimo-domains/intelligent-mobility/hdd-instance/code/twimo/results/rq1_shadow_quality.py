"""
RQ1-T1 — Digital Shadow: coverage and missingness diagnostics.

Produces
--------
  artifacts/results/rq1/ds_quality.csv / .tex    -> Tab. ds_quality
  artifacts/results/rq1/ds_missingness.csv / .tex -> Tab. ds_missingness (by feature group)
  artifacts/results/rq1/ds_missingness.png        -> Fig. ds_missingness

Usage
-----
  python -m twimo.results.rq1_shadow_quality
  python -m twimo.results.rq1_shadow_quality --manifest artifacts/manifest.jsonl \\
      --prealigned-sensors-dir twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
      --outdir artifacts/results/rq1
"""
from __future__ import annotations

import argparse
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import numpy as np
import pandas as pd

from twimo.results._utils import (
    load_manifest, load_json, load_npy,
    fmt_pct, save_artifact, setup_mpl,
)


# ─── Feature-group heuristic ──────────────────────────────────────────────────

_GROUP_KEYWORDS: list[tuple[str, list[str]]] = [
    ("Controls",            ["steer", "brake", "throttle", "accel", "pedal", "can"]),
    ("GPS / Position",      ["lat", "lng", "lon", "gps", "heading", "rtk", "pos"]),
    ("Dynamics – speed",    ["vel", "speed", "km"]),
    ("Dynamics – rotation", ["yaw", "roll", "pitch", "angular", "omega"]),
    ("IMU",                 ["imu", "gyro", "mpu", "acc_x", "acc_y", "acc_z"]),
    ("Video features",      ["video", "img", "feat", "embed"]),
]


def _feature_group(name: str) -> str:
    n = name.lower()
    for grp, keywords in _GROUP_KEYWORDS:
        if any(k in n for k in keywords):
            return grp
    return "Other"


# ─── Core logic ───────────────────────────────────────────────────────────────

def run(args: argparse.Namespace) -> None:
    out = Path(args.outdir)
    out.mkdir(parents=True, exist_ok=True)
    print(f"\n[RQ1-T1] Digital Shadow quality diagnostics  ->  {out}")

    records = load_manifest(Path(args.manifest))
    print(f"  Manifest: {len(records)} session(s)")

    # Optional: load feature names from a model run
    feature_names: list[str] | None = None
    if args.feature_names and Path(args.feature_names).exists():
        fnames = load_json(Path(args.feature_names))
        if isinstance(fnames, list):
            feature_names = fnames
            print(f"  Feature names: {len(feature_names)} columns loaded")
    # Auto-search for feature_names.json in artifacts dir
    if feature_names is None and args.artifacts_dir:
        for candidate in sorted(Path(args.artifacts_dir).glob("**/maneuver_*/feature_names.json")):
            fnames = load_json(candidate)
            if isinstance(fnames, list):
                feature_names = fnames
                print(f"  Feature names: auto-loaded from {candidate} ({len(feature_names)} cols)")
                break

    # ── Per-session stats ─────────────────────────────────────────────────────
    sess_rows: list[dict] = []
    # feature_name -> list[nan_ratio per session]
    miss_acc: dict[str, list[float]] = {}

    for rec in records:
        sid      = rec.get("session_id", "?")
        day_id   = rec.get("day_id", "?")
        has_vid  = bool(rec.get("video_path"))

        # Locate prealigned sensor array
        npy_path = rec.get("prealigned_sensor_npy")
        X: np.ndarray | None = None
        if npy_path and Path(str(npy_path)).exists():
            X = load_npy(Path(str(npy_path)))
        if X is None and args.prealigned_sensors_dir:
            cand = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
            if cand.exists():
                X = load_npy(cand)

        if X is None:
            sess_rows.append(dict(
                session_id=sid, day_id=day_id, has_video=has_vid,
                T=None, duration_s=None, nan_ratio=None,
            ))
            continue

        T, D = X.shape
        duration_s = T / args.sample_hz
        nan_ratio  = float(np.isnan(X).mean())

        sess_rows.append(dict(
            session_id=sid, day_id=day_id, has_video=has_vid,
            T=T, duration_s=duration_s, nan_ratio=nan_ratio,
        ))

        # Accumulate per-feature missingness
        for d in range(D):
            fname = (feature_names[d]
                     if (feature_names and d < len(feature_names))
                     else f"feat_{d:03d}")
            col_nan = float(np.isnan(X[:, d]).mean())
            miss_acc.setdefault(fname, []).append(col_nan)

    df_sess = pd.DataFrame(sess_rows)
    valid   = df_sess.dropna(subset=["duration_s"])
    n_total = len(records)
    n_sens  = len(valid)
    n_vid   = int(df_sess["has_video"].sum())

    if n_total == 0:
        print("  [ERROR] No sessions in manifest. Aborting.")
        return

    total_h     = valid["duration_s"].sum() / 3600
    med_min     = valid["duration_s"].median() / 60
    med_miss    = valid["nan_ratio"].median() * 100
    vid_pct     = n_vid / n_total * 100

    # ── Table: ds_quality ─────────────────────────────────────────────────────
    quality_df = pd.DataFrame([
        {"Metric": r"\#Sessions (total)",                 "Value": str(n_total)},
        {"Metric": r"\#Sessions with prealigned sensors", "Value": str(n_sens)},
        {"Metric": r"\#Sessions with video",              "Value": f"{n_vid} ({vid_pct:.0f}\\%)"},
        {"Metric": "Total duration (h)",                  "Value": f"{total_h:.1f}"},
        {"Metric": "Median session duration (min)",       "Value": f"{med_min:.1f}"},
        {"Metric": "Median sensor NaN ratio (\\%)",       "Value": f"{med_miss:.2f}"},
    ])
    print("\n  [Tab] ds_quality")
    save_artifact(
        quality_df, out, "ds_quality",
        caption="Digital Shadow quality summary: session count, total duration, and missingness after alignment.",
        label="tab:ds_quality",
        col_format="lc",
    )

    # ── Table + Figure: ds_missingness ────────────────────────────────────────
    if miss_acc:
        group_data: dict[str, list[float]] = {}
        for fname, ratios in miss_acc.items():
            grp = _feature_group(fname)
            group_data.setdefault(grp, []).extend(ratios)

        miss_rows = []
        for grp, ratios in sorted(group_data.items()):
            arr = np.array(ratios)
            miss_rows.append({
                "Feature group":     grp,
                "Mean (\\%)":        f"{arr.mean()*100:.2f}",
                "Median (\\%)":      f"{np.median(arr)*100:.2f}",
                "Max (\\%)":         f"{arr.max()*100:.2f}",
                "\\#Features":       str(len(miss_acc) * 0),  # placeholder
            })
        # recompute #features per group
        for i, grp in enumerate(sorted(group_data.keys())):
            n_feats = sum(1 for fn in miss_acc if _feature_group(fn) == grp)
            miss_rows[i]["\\#Features"] = str(n_feats)

        miss_df = pd.DataFrame(miss_rows)
        print("\n  [Tab] ds_missingness")
        save_artifact(
            miss_df, out, "ds_missingness",
            caption="Sensor missingness by feature group: mean, median, and maximum NaN ratio across all sessions.",
            label="tab:ds_missingness",
            col_format="lcccc",
        )

        # Figure
        if setup_mpl():
            import matplotlib.pyplot as plt
            grps    = sorted(group_data.keys())
            means   = [np.mean(group_data[g]) * 100 for g in grps]
            medians = [np.median(group_data[g]) * 100 for g in grps]
            fig, ax = plt.subplots(figsize=(7, max(3, len(grps) * 0.6 + 1)))
            y = np.arange(len(grps))
            ax.barh(y - 0.2, means,   height=0.4, color="#4878CF", alpha=0.85, label="Mean")
            ax.barh(y + 0.2, medians, height=0.4, color="#D65F5F", alpha=0.85, label="Median")
            ax.set_yticks(y)
            ax.set_yticklabels(grps)
            ax.set_xlabel("NaN ratio (%)")
            ax.set_title("Digital Shadow: missingness by feature group")
            ax.legend()
            plt.tight_layout()
            fig_path = out / "ds_missingness.png"
            fig.savefig(fig_path, dpi=150, bbox_inches="tight")
            plt.close(fig)
            print(f"    Figure: {fig_path}")
    else:
        print("  [WARN] No sensor arrays found; missingness table/figure skipped.")

    # Save per-session raw data too (useful for reproducibility)
    sess_out = out / "ds_sessions_raw.csv"
    df_sess.to_csv(sess_out, index=False)
    print(f"    Raw sessions: {sess_out}")
    print("  Done.\n")


# ─── Entry point ─────────────────────────────────────────────────────────────

def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--manifest",               default="artifacts/manifest.jsonl")
    p.add_argument("--prealigned-sensors-dir",
                   default="artifacts/eaf/sensors_v2/sensor",
                   dest="prealigned_sensors_dir")
    p.add_argument("--artifacts-dir",          default="artifacts", dest="artifacts_dir",
                   help="Root artifacts dir (used to auto-find feature_names.json)")
    p.add_argument("--feature-names",          default=None, dest="feature_names",
                   help="Explicit path to feature_names.json (optional)")
    p.add_argument("--sample-hz",              type=float, default=3.0, dest="sample_hz")
    p.add_argument("--outdir",                 default="artifacts/results/rq1")
    run(p.parse_args())


if __name__ == "__main__":
    main()
