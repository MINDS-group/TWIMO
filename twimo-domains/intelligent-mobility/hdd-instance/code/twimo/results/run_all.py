"""
Master runner — extract ALL paper results in one command.

Runs all RQ1/RQ2/RQ3 scripts and collects outputs into artifacts/results/.
Prints a final summary of what was produced and what LaTeX \\input{} paths to use.

Usage
-----
  python -m twimo.results.run_all
  python -m twimo.results.run_all --artifacts-dir artifacts --outdir artifacts/results
"""
from __future__ import annotations

import argparse
import time
from pathlib import Path

from twimo.results import rq1_shadow_quality, rq1_shadow_xcorr, rq1_shadow_sensitivity
from twimo.results import rq2_uca, rq2_ucb
from twimo.results import rq3_checklist


def _make_args(**kwargs):
    """Build a Namespace object from keyword arguments."""
    import argparse
    ns = argparse.Namespace()
    for k, v in kwargs.items():
        setattr(ns, k, v)
    return ns


def run(args: argparse.Namespace) -> None:
    root     = Path(args.outdir)
    arts     = Path(args.artifacts_dir)
    manifest = args.manifest
    pre_sens = args.prealigned_sensors_dir
    t0       = time.time()

    print("=" * 70)
    print("  TWIMO Results Extraction — all RQs")
    print(f"  Artifacts : {arts}")
    print(f"  Output    : {root}")
    print("=" * 70)

    # ── RQ1: Shadow quality ───────────────────────────────────────────────────
    rq1_shadow_quality.run(_make_args(
        manifest=manifest,
        prealigned_sensors_dir=pre_sens,
        artifacts_dir=str(arts),
        feature_names=None,
        sample_hz=args.sample_hz,
        outdir=str(root / "rq1"),
    ))

    rq1_shadow_xcorr.run(_make_args(
        manifest=manifest,
        prealigned_sensors_dir=pre_sens,
        artifacts_dir=str(arts),
        feature_names=None,
        sample_hz=args.sample_hz,
        max_lag=30,
        pair_indices=None,
        outdir=str(root / "rq1"),
    ))

    rq1_shadow_sensitivity.run(_make_args(
        model_dirs=None,        # auto-discover from artifacts_dir
        labels=None,
        artifacts_dir=str(arts),
        ref_horizon=args.ref_horizon,
        outdir=str(root / "rq1"),
    ))

    # ── RQ2-A: UC-A maneuver prediction ──────────────────────────────────────
    rq2_uca.run(_make_args(
        artifacts_dir=str(arts),
        ref_horizon=args.ref_horizon,
        outdir=str(root / "rq2_uca"),
    ))

    # ── RQ2-B: UC-B EAF event detection ──────────────────────────────────────
    rq2_ucb.run(_make_args(
        artifacts_dir=str(arts),
        eaf_outdir=None,
        outdir=str(root / "rq2_ucb"),
    ))

    # ── RQ3: Framework validation ─────────────────────────────────────────────
    rq3_checklist.run(_make_args(
        artifacts_dir=str(arts),
        outdir=str(root / "rq3"),
    ))

    elapsed = time.time() - t0
    _print_summary(root, elapsed)


def _print_summary(root: Path, elapsed: float) -> None:
    """Print a summary of all produced files and LaTeX \\input{} paths."""
    print("\n" + "=" * 70)
    print(f"  DONE  ({elapsed:.1f}s)  —  Summary of produced artifacts")
    print("=" * 70)

    sections = {
        "RQ1 — Digital Shadow quality (rq1/)": [
            ("Tab. ds_quality",     "rq1/ds_quality.tex"),
            ("Tab. ds_missingness", "rq1/ds_missingness.tex"),
            ("Tab. ds_sensitivity", "rq1/ds_sensitivity.tex"),
            ("Tab. ds_xcorr",       "rq1/ds_xcorr.tex"),
            ("Fig. ds_missingness", "rq1/ds_missingness.png"),
            ("Fig. ds_xcorr",       "rq1/ds_xcorr.png"),
        ],
        "RQ2-A — UC-A maneuver prediction (rq2_uca/)": [
            ("Tab. ucA_main",         "rq2_uca/uca_main.tex"),
            ("Tab. ucA_baselines",    "rq2_uca/uca_baselines.tex"),
            ("Tab. ucA_model_suite",  "rq2_uca/uca_model_suite.tex"),
            ("Tab. ucA_ranks",        "rq2_uca/uca_ranks.tex"),
            ("Tab. hp_suite",         "rq2_uca/hp_suite.tex"),
            ("Fig. horizon_curve",    "rq2_uca/horizon_curve.png"),
            ("Fig. horizon_curve_all","rq2_uca/horizon_curve_all.png"),
            ("Fig. ucA_cm",           "rq2_uca/confusion_matrix_*.png"),
        ],
        "RQ2-B — UC-B EAF two-stage (rq2_ucb/)": [
            ("Tab. ucB_stage1",     "rq2_ucb/ucb_stage1.tex"),
            ("Tab. ucB_stage2",     "rq2_ucb/ucb_stage2.tex"),
            ("Tab. ucB_gap",        "rq2_ucb/ucb_gap.tex"),
            ("Fig. ucB_pr",         "rq2_ucb/ucb_pr_curve.png"),
            ("Fig. ucB_cm_goal",    "rq2_ucb/ucb_cm_goal.png"),
            ("Fig. ucB_cm_stim",    "rq2_ucb/ucb_cm_stimuli.png"),
        ],
        "RQ3 — Framework validation (rq3/)": [
            ("Tab. artifact_checklist",       "rq3/artifact_checklist.tex"),
            ("Tab. reuse_map",                "rq3/reuse_map.tex"),
            ("Tab. scenario_block_mapping",   "rq3/scenario_block_mapping.tex"),
        ],
    }

    for section, items in sections.items():
        print(f"\n  {section}")
        for name, rel_path in items:
            full = root / rel_path
            if "*" in rel_path:
                # glob
                matches = list(root.glob(rel_path))
                status = f"({len(matches)} file(s))" if matches else "[MISSING]"
            else:
                status = "[OK]" if full.exists() else "[MISSING]"
            print(f"    {status:<10} {name:<28}  ->  {root / rel_path}")

    print("\n" + "─" * 70)
    print("  LaTeX integration — add to your paper preamble:")
    print(r"    \usepackage{booktabs,graphicx}")
    print()
    print("  Then include tables with:")
    print(f"    \\input{{{root}/rq1/ds_quality}}")
    print(f"    \\input{{{root}/rq2_uca/uca_main}}")
    print(f"    ...etc (one \\input per .tex file listed above)")
    print()
    print("  Include figures with:")
    print(f"    \\includegraphics[width=\\linewidth]{{{root}/rq2_uca/horizon_curve.png}}")
    print(f"    \\includegraphics[width=\\linewidth]{{{root}/rq1/ds_missingness.png}}")
    print("─" * 70 + "\n")


# ─── Entry point ─────────────────────────────────────────────────────────────

def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--artifacts-dir",
                   default="artifacts", dest="artifacts_dir",
                   help="Root artifacts directory (default: artifacts)")
    p.add_argument("--manifest",
                   default="artifacts/manifest.jsonl",
                   help="Path to manifest.jsonl (default: artifacts/manifest.jsonl)")
    p.add_argument("--prealigned-sensors-dir",
                   default="twimo/assets/hdd_prealigned/20200710_sensors/sensor",
                   dest="prealigned_sensors_dir",
                   help="Prealigned sensor .npy directory")
    p.add_argument("--sample-hz",
                   type=float, default=3.0, dest="sample_hz",
                   help="Sampling frequency used to compute durations (default: 3.0)")
    p.add_argument("--ref-horizon",
                   type=float, default=1.0, dest="ref_horizon",
                   help="Reference horizon in seconds for main tables (default: 1.0)")
    p.add_argument("--outdir",
                   default="artifacts/results",
                   help="Root output directory for all results (default: artifacts/results)")
    run(p.parse_args())


if __name__ == "__main__":
    main()
