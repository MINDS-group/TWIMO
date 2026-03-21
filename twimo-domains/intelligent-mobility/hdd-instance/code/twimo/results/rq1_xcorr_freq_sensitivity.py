"""
Frequency-sensitivity cross-correlation analysis.

Downsamples the 3 Hz prealigned sensor arrays to multiple target frequencies
and computes cross-correlations for causal signal pairs.  Lags are reported in
seconds so curves at different Hz are directly comparable.

Expected result:
  - Steer->Yaw  peak lag ~0.3 s stays stable at 3 Hz, smears at 0.5-1 Hz
  - The seconds-domain peak should converge -> validates 3 Hz choice

Sensor columns (sensors_v2, from feature_names.json):
  0  steer.steer_angle
  1  steer.steer_speed
  2  accel_pedal.pedalangle
  3  brake_pedal.pedalpressure
  4  vel.speed
  5  yaw.yaw
  6  turn_signal.lturn
  7  turn_signal.rturn

Usage
-----
  python -m twimo.results.rq1_xcorr_freq_sensitivity
  python -m twimo.results.rq1_xcorr_freq_sensitivity \\
      --sensor-dir artifacts/eaf/sensors_v2/sensor \\
      --outdir artifacts_models/rq1 \\
      --hz-levels 0.5 1.0 1.5 3.0
"""
from __future__ import annotations

import argparse
import json
from pathlib import Path

import numpy as np
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

# ── Constants ─────────────────────────────────────────────────────────────────

BASE_HZ = 3.0  # prealigned arrays are always at 3 Hz

# (display label, col_a, col_b)
PAIRS: list[tuple[str, int, int]] = [
    ("Steer-angle -> Yaw-rate", 0, 5),
    ("Accel -> Speed",          2, 4),
    ("Brake -> Speed",          3, 4),
]

# One color per Hz level (ordered dark→light)
_PALETTE = ["#D62728", "#FF7F0E", "#2CA02C", "#1F77B4", "#9467BD", "#8C564B"]


# ── Signal utilities ──────────────────────────────────────────────────────────

def _normalise(a: np.ndarray) -> np.ndarray:
    return np.nan_to_num((a - np.nanmean(a)) / (np.nanstd(a) + 1e-9))


def _xcorr(a: np.ndarray, b: np.ndarray, max_lag_steps: int
           ) -> tuple[np.ndarray, np.ndarray]:
    """Normalised cross-correlation; returns (lags, corr) clipped to ±max_lag_steps."""
    a = _normalise(a.astype(float))
    b = _normalise(b.astype(float))
    full = np.correlate(a, b, mode="full") / max(len(a), 1)
    mid  = len(full) // 2
    lo   = max(0, mid - max_lag_steps)
    hi   = min(len(full), mid + max_lag_steps + 1)
    # Only return if full window available (symmetric)
    if (mid - lo) != max_lag_steps or (hi - mid - 1) != max_lag_steps:
        return None, None
    lags = np.arange(-max_lag_steps, max_lag_steps + 1)
    return lags, full[lo:hi]


# ── Data loading ──────────────────────────────────────────────────────────────

def _load_sessions(sensor_dir: Path, min_cols: int = 6) -> list[np.ndarray]:
    arrays = []
    for f in sorted(sensor_dir.glob("*.npy")):
        try:
            x = np.load(str(f), allow_pickle=False)
            if x.ndim == 2 and x.shape[1] >= min_cols:
                arrays.append(x)
        except Exception:
            pass
    return arrays


# ── Core computation ──────────────────────────────────────────────────────────

def _compute_hz(sessions: list[np.ndarray], target_hz: float,
                max_lag_s: float) -> dict[str, dict]:
    """Return xcorr stats for each pair at *target_hz*."""
    step      = max(1, round(BASE_HZ / target_hz))
    actual_hz = BASE_HZ / step
    max_steps = int(round(max_lag_s * actual_hz))
    lags_s    = np.arange(-max_steps, max_steps + 1) / actual_hz

    out: dict[str, dict] = {}
    for pair_label, ia, ib in PAIRS:
        corrs: list[np.ndarray] = []
        for X in sessions:
            Xs = X[::step]
            if Xs.shape[0] < 2 * max_steps + 20:
                continue
            lags, c = _xcorr(Xs[:, ia], Xs[:, ib], max_steps)
            if c is not None:
                corrs.append(c)

        if not corrs:
            continue

        arr      = np.array(corrs)          # (N, 2*max_steps+1)
        mean_c   = arr.mean(axis=0)
        std_c    = arr.std(axis=0)
        peak_idx = int(np.argmax(np.abs(mean_c)))

        out[pair_label] = {
            "lags_s":     lags_s,
            "mean_corr":  mean_c,
            "std_corr":   std_c,
            "peak_lag_s": float(lags_s[peak_idx]),
            "peak_corr":  float(mean_c[peak_idx]),
            "actual_hz":  actual_hz,
            "step":       step,
            "n":          len(corrs),
        }
    return out


# ── Plotting ──────────────────────────────────────────────────────────────────

def _plot(all_results: dict[float, dict[str, dict]], out_dir: Path) -> None:
    hz_list = sorted(all_results.keys())
    n_pairs = len(PAIRS)

    plt.rcParams.update({
        "font.family":        "serif",
        "axes.spines.top":    False,
        "axes.spines.right":  False,
        "axes.grid":          True,
        "grid.alpha":         0.3,
    })

    fig, axes = plt.subplots(
        1, n_pairs,
        figsize=(5.5 * n_pairs, 4.2),
        sharey=False,
    )
    if n_pairs == 1:
        axes = [axes]

    for ax, (pair_label, _, _) in zip(axes, PAIRS):
        for color, hz in zip(_PALETTE, hz_list):
            r = all_results[hz].get(pair_label)
            if r is None:
                continue
            lbl = f"{r['actual_hz']:.2g} Hz  ({r['peak_lag_s']:+.2f}s)"
            ax.plot(r["lags_s"], r["mean_corr"],
                    color=color, lw=1.8, label=lbl)
            ax.fill_between(
                r["lags_s"],
                r["mean_corr"] - r["std_corr"],
                r["mean_corr"] + r["std_corr"],
                alpha=0.12, color=color,
            )
            # Mark peak lag
            ax.axvline(r["peak_lag_s"], color=color, lw=1.0, ls=":",
                       alpha=0.85)

        ax.axvline(0, color="k", lw=1.0, ls="--", alpha=0.45, zorder=0)
        ax.axhline(0, color="k", lw=0.4, ls="-",  alpha=0.25, zorder=0)
        ax.set_xlabel("Lag (s)", fontsize=10)
        ax.set_ylabel("Cross-correlation", fontsize=10)
        ax.set_title(pair_label, fontsize=10)
        ax.legend(fontsize=7.5, loc="lower right")

    fig.suptitle(
        "Cross-correlation at variable sampling frequencies\n"
        "Dotted lines = peak lag per Hz; shaded = ±1 std across sessions",
        fontsize=10,
    )
    plt.tight_layout()

    for ext in ("png", "pdf"):
        p = out_dir / f"xcorr_freq_sensitivity.{ext}"
        fig.savefig(str(p), dpi=150, bbox_inches="tight")
        print(f"  Saved: {p}")
    plt.close(fig)


# ── Peak-lag summary table ────────────────────────────────────────────────────

def _print_summary(all_results: dict[float, dict[str, dict]]) -> None:
    pair_labels = [p[0] for p in PAIRS]
    col_w = max(len(l) for l in pair_labels) + 2
    header = f"{'Hz':>6}  " + "".join(f"{l:<{col_w}}" for l in pair_labels)
    print("\n" + header)
    print("-" * len(header))
    for hz in sorted(all_results.keys()):
        row = f"{hz:>6.2f}  "
        for pair_label, _, _ in PAIRS:
            r = all_results[hz].get(pair_label)
            if r:
                cell = f"{r['peak_lag_s']:+.3f}s (|r|={abs(r['peak_corr']):.3f})"
            else:
                cell = "N/A"
            row += f"{cell:<{col_w}}"
        print(row)
    print()


# ── Entry point ───────────────────────────────────────────────────────────────

def run(args: argparse.Namespace) -> None:
    sensor_dir = Path(args.sensor_dir)
    out_dir    = Path(args.outdir)
    out_dir.mkdir(parents=True, exist_ok=True)

    print(f"\n[Freq-sensitivity xcorr]  sensor_dir={sensor_dir}  outdir={out_dir}")
    sessions = _load_sessions(sensor_dir)
    print(f"  Loaded {len(sessions)} sessions  (base {BASE_HZ} Hz)")
    if not sessions:
        print("[ERROR] No valid sessions found — check --sensor-dir.")
        return

    # Override first pair (steer) based on --steer argument
    steer_col   = 0 if args.steer == "angle" else 1
    steer_label = "Steer-angle -> Yaw-rate" if args.steer == "angle" else "Steer-speed -> Yaw-rate"
    PAIRS[0] = (steer_label, steer_col, PAIRS[0][2])
    print(f"  Steer signal: {steer_label}  (col {steer_col})")

    hz_levels = sorted(set(args.hz_levels))
    all_results: dict[float, dict[str, dict]] = {}

    for hz in hz_levels:
        step      = max(1, round(BASE_HZ / hz))
        actual_hz = BASE_HZ / step
        print(f"\n  target={hz:.2g} Hz  step={step}  actual={actual_hz:.4g} Hz")
        all_results[hz] = _compute_hz(sessions, hz, args.max_lag_s)
        for pair_label, r in all_results[hz].items():
            print(f"    {pair_label}: peak={r['peak_lag_s']:+.3f}s  "
                  f"|corr|={abs(r['peak_corr']):.3f}  n={r['n']}")

    _print_summary(all_results)
    _plot(all_results, out_dir)

    # JSON summary
    summary = {}
    for hz, pairs in all_results.items():
        for pair_label, r in pairs.items():
            summary[f"{hz}hz::{pair_label}"] = {
                "target_hz":  hz,
                "actual_hz":  r["actual_hz"],
                "step":       r["step"],
                "peak_lag_s": r["peak_lag_s"],
                "peak_corr":  r["peak_corr"],
                "n_sessions": r["n"],
            }
    (out_dir / "xcorr_freq_sensitivity.json").write_text(
        json.dumps(summary, indent=2), encoding="utf-8"
    )
    print("Done.\n")


def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--sensor-dir", default="artifacts/eaf/sensors_v2/sensor",
                   dest="sensor_dir",
                   help="Directory containing 3 Hz prealigned .npy sensor arrays")
    p.add_argument("--outdir",     default="artifacts_models/rq1")
    p.add_argument("--hz-levels",  nargs="+", type=float,
                   default=[0.5, 1.0, 1.5, 3.0],
                   dest="hz_levels",
                   help="Target sampling frequencies to evaluate (must be <= 3 Hz)")
    p.add_argument("--max-lag-s",  type=float, default=10.0, dest="max_lag_s",
                   help="Max lag in seconds for xcorr window (default: 10)")
    p.add_argument("--steer", choices=["angle", "speed"], default="angle",
                   help="Steer signal to use: 'angle' (col 0) or 'speed' (col 1) [default: angle]")
    run(p.parse_args())


if __name__ == "__main__":
    main()
