"""
RQ1-T2 — Digital Shadow: temporal consistency / cross-correlation sanity checks.

Computes cross-correlation between correlated channel pairs to detect systematic
lag or misalignment (peak should concentrate around lag 0).

Produces
--------
  artifacts_models/rq1/ds_xcorr.csv / .tex  -> Tab. ds_xcorr (peak lags)
  artifacts_models/rq1/ds_xcorr.png         -> Fig. ds_xcorr

Channel detection
-----------------
  1. By feature name keywords (CSV mode: sensor names like 'steer.steer_angle')
  2. By column statistics (prealigned mode: generic 'sensor_0..N' names)
  3. Manual override via --pair-indices  "ia,ib:Label" (one per pair)

Pairs checked
-------------
  Steering  <->  Yaw-rate       (steering angle causes yaw, expect lag ~0-1 steps)
  Brake     <->  Deceleration   (brake pressure causes speed drop, expect lag ~0-2 steps)
  Speed     <->  Steer          (informational, expect low correlation at lag 0)

Usage
-----
  python -m twimo.results.rq1_shadow_xcorr
  python -m twimo.results.rq1_shadow_xcorr --artifacts-dir artifacts --outdir artifacts_models/rq1

  # Manual override (use column indices):
  python -m twimo.results.rq1_shadow_xcorr \\
      --pair-indices "1,7:Steer-Yaw" "4,0:Brake-Speed"
"""
from __future__ import annotations

import argparse
from pathlib import Path

import numpy as np
import pandas as pd

from twimo.results._utils import (
    load_manifest, load_json, load_npy,
    save_artifact, setup_mpl,
)


# ─── Name-based detection (CSV mode) ─────────────────────────────────────────

_PAIR_PATTERNS: list[tuple[str, list[str], list[str]]] = [
    ("Steering → Yaw-rate",    ["steer", "steering"],     ["yaw", "yaw_rate"]),
    ("Brake → Deceleration",   ["brake", "brk", "pressure"], ["acc_long", "acc_x", "decel"]),
    ("Speed → Acceleration",   ["vel", "speed"],          ["acc_long", "acc_x", "accel"]),
]


def _find_by_name(feature_names: list[str], keywords: list[str]) -> int | None:
    for i, fn in enumerate(feature_names):
        if any(k in fn.lower() for k in keywords):
            return i
    return None


# ─── Statistics-based detection (prealigned mode: generic sensor_N names) ────

def _detect_channels_by_stats(X: np.ndarray) -> dict[str, int]:
    """
    Heuristically identify channel types from column statistics.
    Returns a dict like {'speed': 0, 'steer': 1, 'yaw': 7, 'brake': 4}.
    """
    D = X.shape[1]
    result: dict[str, int] = {}
    stats = []
    for i in range(D):
        c = X[:, i]
        stats.append({
            "i":    i,
            "mean": float(np.nanmean(c)),
            "std":  float(np.nanstd(c)),
            "min":  float(np.nanmin(c)),
            "max":  float(np.nanmax(c)),
        })

    used: set[int] = set()

    # Speed: positive values 0–200, mean > 2, binary-free (std > 2)
    speed_cands = [s for s in stats
                   if s["min"] >= -1 and s["max"] < 250
                   and s["mean"] > 2 and s["std"] > 2]
    if speed_cands:
        best = max(speed_cands, key=lambda s: s["mean"])
        result["speed"] = best["i"]
        used.add(best["i"])

    # Steer: large symmetric range (large std, mean near 0, range spanning negative)
    steer_cands = [s for s in stats if s["i"] not in used
                   and s["min"] < -5 and s["std"] > 5]
    if steer_cands:
        best = max(steer_cands, key=lambda s: s["std"])
        result["steer"] = best["i"]
        used.add(best["i"])

    # Yaw-rate: smaller symmetric range, mean near 0, std 1–30
    yaw_cands = [s for s in stats if s["i"] not in used
                 and abs(s["mean"]) < 5 and 0.5 < s["std"] < 40
                 and s["min"] < -1]
    if yaw_cands:
        # Prefer the one whose range is smaller (more likely yaw than steer_speed)
        best = min(yaw_cands, key=lambda s: s["max"] - s["min"])
        result["yaw"] = best["i"]
        used.add(best["i"])

    # Brake: positive, potentially large range, mean > 5
    brake_cands = [s for s in stats if s["i"] not in used
                   and s["min"] >= -1 and s["mean"] > 5 and s["std"] > 5]
    if brake_cands:
        best = max(brake_cands, key=lambda s: s["max"])
        result["brake"] = best["i"]
        used.add(best["i"])

    return result


def _build_pairs_from_stats(detected: dict[str, int]) -> list[tuple[str, int, int]]:
    """Build xcorr pairs from auto-detected channel indices."""
    pairs = []
    if "steer" in detected and "yaw" in detected:
        pairs.append(("Steering → Yaw-rate", detected["steer"], detected["yaw"]))
    if "brake" in detected and "speed" in detected:
        pairs.append(("Brake → Speed (decel proxy)", detected["brake"], detected["speed"]))
    if "speed" in detected and "steer" in detected:
        pairs.append(("Speed → Steering", detected["speed"], detected["steer"]))
    return pairs


# ─── Cross-correlation ────────────────────────────────────────────────────────

def _xcorr(a: np.ndarray, b: np.ndarray, max_lag: int = 30) -> tuple[np.ndarray, np.ndarray]:
    """Normalised cross-correlation between 1-D arrays a and b."""
    a = np.nan_to_num((a - np.nanmean(a)) / (np.nanstd(a) + 1e-9))
    b = np.nan_to_num((b - np.nanmean(b)) / (np.nanstd(b) + 1e-9))
    corr = np.correlate(a, b, mode="full") / max(len(a), 1)
    mid  = len(corr) // 2
    lo   = max(0, mid - max_lag)
    hi   = min(len(corr), mid + max_lag + 1)
    lags = np.arange(lo - mid, hi - mid)
    return lags, corr[lo:hi]


# ─── Core logic ───────────────────────────────────────────────────────────────

def run(args: argparse.Namespace) -> None:
    out = Path(args.outdir)
    out.mkdir(parents=True, exist_ok=True)
    print(f"\n[RQ1-T2] Cross-correlation diagnostics  ->  {out}")

    records = load_manifest(Path(args.manifest))
    print(f"  Manifest: {len(records)} session(s)")

    # Load feature names (for name-based detection)
    feature_names: list[str] = []
    if args.feature_names and Path(args.feature_names).exists():
        fn = load_json(Path(args.feature_names))
        if isinstance(fn, list):
            feature_names = fn
    if not feature_names and args.artifacts_dir:
        for cand in sorted(Path(args.artifacts_dir).glob("maneuver_*/feature_names.json")):
            fn = load_json(cand)
            if isinstance(fn, list):
                feature_names = fn
                print(f"  Feature names: loaded from {cand}")
                break

    # Parse manual pair overrides: "ia,ib:Label"
    manual_pairs: list[tuple[str, int, int]] = []
    for spec in (args.pair_indices or []):
        try:
            idx_part, label = spec.split(":", 1)
            ia, ib = [int(x) for x in idx_part.split(",")]
            manual_pairs.append((label.strip(), ia, ib))
        except Exception:
            print(f"  [WARN] Cannot parse --pair-indices '{spec}'; expected format: 'ia,ib:Label'")

    # Load a sample session to get column statistics for auto-detection
    X_sample: np.ndarray | None = None
    for rec in records:
        npy = rec.get("prealigned_sensor_npy")
        X_s = None
        if npy and Path(str(npy)).exists():
            X_s = load_npy(Path(str(npy)))
        if X_s is None and args.prealigned_sensors_dir:
            cand = Path(args.prealigned_sensors_dir) / f"{rec.get('session_id','')}.npy"
            if cand.exists():
                X_s = load_npy(cand)
        if X_s is not None:
            X_sample = X_s
            break

    # Resolve pairs
    pairs: list[tuple[str, int, int]] = []

    if manual_pairs:
        pairs = manual_pairs
        print(f"  Using {len(pairs)} manual pair(s) from --pair-indices")
    else:
        # 1. Name-based detection
        for label, kw_a, kw_b in _PAIR_PATTERNS:
            ia = _find_by_name(feature_names, kw_a)
            ib = _find_by_name(feature_names, kw_b)
            if ia is not None and ib is not None and ia != ib:
                pairs.append((label, ia, ib))

        # 2. Stats-based detection (prealigned generic names)
        if not pairs and X_sample is not None:
            print("  Feature names are generic (sensor_N); using statistics-based channel detection.")
            detected = _detect_channels_by_stats(X_sample)
            print(f"  Auto-detected channels: {detected}")
            # Print column stats for transparency
            D = X_sample.shape[1]
            for i in range(D):
                c = X_sample[:, i]
                role = next((k for k, v in detected.items() if v == i), "?")
                fn   = feature_names[i] if i < len(feature_names) else f"sensor_{i}"
                print(f"    col {i} ({fn}): mean={c.mean():.2f} std={c.std():.2f} "
                      f"min={c.min():.2f} max={c.max():.2f}  -> {role}")
            pairs = _build_pairs_from_stats(detected)

    if not pairs:
        print("  [ERROR] No valid channel pairs found.")
        print("  Tip: use --pair-indices 'ia,ib:Label' to specify pairs by column index.")
        return

    print(f"  Pairs to correlate: {[(lbl, ia, ib) for lbl, ia, ib in pairs]}")

    max_lag = args.max_lag
    pair_results: dict[str, list[dict]] = {lbl: [] for lbl, _, _ in pairs}
    pair_avg_corr: dict[str, dict]      = {}

    # Iterate sessions
    for rec in records:
        sid  = rec.get("session_id", "?")
        npy  = rec.get("prealigned_sensor_npy")
        X: np.ndarray | None = None
        if npy and Path(str(npy)).exists():
            X = load_npy(Path(str(npy)))
        if X is None and args.prealigned_sensors_dir:
            cand = Path(args.prealigned_sensors_dir) / f"{sid}.npy"
            if cand.exists():
                X = load_npy(cand)
        if X is None:
            continue

        for label, ia, ib in pairs:
            if ia >= X.shape[1] or ib >= X.shape[1]:
                continue
            a = X[:, ia].astype(float)
            b = X[:, ib].astype(float)
            lags, corr = _xcorr(a, b, max_lag=max_lag)
            peak_idx   = int(np.argmax(np.abs(corr)))
            peak_lag   = int(lags[peak_idx])
            peak_corr  = float(corr[peak_idx])
            pair_results[label].append({
                "session_id":    sid,
                "peak_lag_steps": peak_lag,
                "peak_lag_s":     peak_lag / args.sample_hz,
                "peak_corr":      peak_corr,
            })
            if label not in pair_avg_corr:
                pair_avg_corr[label] = {"lags": lags, "corrs": []}
            pair_avg_corr[label]["corrs"].append(corr)

    # ── Summary table ─────────────────────────────────────────────────────────
    rows = []
    for label, ia, ib in pairs:
        sess_data = pair_results[label]
        if not sess_data:
            continue
        fn_a = feature_names[ia] if ia < len(feature_names) else f"col {ia}"
        fn_b = feature_names[ib] if ib < len(feature_names) else f"col {ib}"
        lags  = [d["peak_lag_steps"] for d in sess_data]
        cors  = [abs(d["peak_corr"])  for d in sess_data]
        rows.append({
            "Signal pair":           label,
            "Channels":              f"{fn_a} / {fn_b}",
            "N sess.":               len(sess_data),
            "Mean peak lag (steps)": f"{np.mean(lags):.2f}",
            "Std peak lag (steps)":  f"{np.std(lags):.2f}",
            "Mean peak lag (s)":     f"{np.mean(lags)/args.sample_hz:.3f}",
            "Mean |corr|":           f"{np.mean(cors):.3f}",
        })

    if rows:
        table_df = pd.DataFrame(rows)
        print("\n  [Tab] ds_xcorr")
        save_artifact(
            table_df, out, "ds_xcorr",
            caption=(
                "Cross-correlation sanity checks between correlated channel pairs. "
                "Peak lag near 0 indicates correct temporal alignment."
            ),
            label="tab:ds_xcorr",
            col_format="llccccc",
        )
    else:
        print("  [WARN] No xcorr data produced.")

    # ── Figure ────────────────────────────────────────────────────────────────
    if pair_avg_corr and setup_mpl():
        import matplotlib.pyplot as plt
        n_pairs = len(pair_avg_corr)
        fig, axes = plt.subplots(1, n_pairs, figsize=(4.5 * n_pairs, 3.5), sharey=False)
        if n_pairs == 1:
            axes = [axes]
        colors = ["#4878CF", "#D65F5F", "#6ACC65"]
        for ax, (label, data), color in zip(axes, pair_avg_corr.items(), colors):
            lags   = data["lags"]
            corrs  = np.array(data["corrs"])
            mean_c = corrs.mean(axis=0)
            std_c  = corrs.std(axis=0)
            lag_s  = lags / args.sample_hz
            ax.plot(lag_s, mean_c, color=color, lw=1.8, label="Mean")
            ax.fill_between(lag_s, mean_c - std_c, mean_c + std_c,
                            alpha=0.25, color=color, label=r"$\pm$1 std")
            ax.axvline(0, color="k", lw=0.8, ls="--", alpha=0.5)
            ax.set_xlabel("Lag (s)")
            ax.set_ylabel("Correlation")
            ax.set_title(label, fontsize=9)
            ax.legend(fontsize=7)
        fig.suptitle("Cross-correlation diagnostics (peak lag should concentrate near 0)",
                     fontsize=10)
        plt.tight_layout()
        fig_path = out / "ds_xcorr.png"
        fig.savefig(fig_path, dpi=150, bbox_inches="tight")
        plt.close(fig)
        print(f"    Figure: {fig_path}")

    # Save raw per-session data
    all_raw = [{"pair": lbl, **d}
               for lbl, data in pair_results.items() for d in data]
    if all_raw:
        raw_out = out / "ds_xcorr_sessions.csv"
        pd.DataFrame(all_raw).to_csv(raw_out, index=False)
        print(f"    Raw: {raw_out}")

    print("  Done.\n")


# ─── Entry point ─────────────────────────────────────────────────────────────

def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--manifest",               default="artifacts/manifest.jsonl")
    p.add_argument("--prealigned-sensors-dir",
                   default="twimo/assets/hdd_prealigned/20200710_sensors/sensor",
                   dest="prealigned_sensors_dir")
    p.add_argument("--artifacts-dir",          default="artifacts", dest="artifacts_dir")
    p.add_argument("--feature-names",          default=None, dest="feature_names")
    p.add_argument("--sample-hz",              type=float, default=3.0, dest="sample_hz")
    p.add_argument("--max-lag",                type=int,   default=30,  dest="max_lag",
                   help="Max lag in steps for cross-correlation (default: 30 = 10s at 3Hz)")
    p.add_argument("--pair-indices",           nargs="+",  default=None, dest="pair_indices",
                   metavar="'ia,ib:Label'",
                   help="Manual pair override by column index. Example: '1,7:Steer-Yaw' '4,0:Brake-Speed'")
    p.add_argument("--outdir",                 default="artifacts_models/rq1")
    run(p.parse_args())


if __name__ == "__main__":
    main()
