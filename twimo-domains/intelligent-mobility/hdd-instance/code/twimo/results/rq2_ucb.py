"""
RQ2-B — Use Case B: two-stage EAF event detection + Goal/Stimuli classification.

Reads evaluation outputs from the EAF two-stage pipeline and produces:

Produces
--------
  artifacts/results/rq2_ucb/ucb_stage1.csv / .tex     -> Tab. ucB_stage1
  artifacts/results/rq2_ucb/ucb_stage2.csv / .tex     -> Tab. ucB_stage2 (E2E vs Oracle)
  artifacts/results/rq2_ucb/ucb_gap.csv / .tex        -> Tab. ucB_gap
  artifacts/results/rq2_ucb/ucb_pr_curve.png          -> Fig. ucB_pr  (ROC/PR from roc_curves.json)
  artifacts/results/rq2_ucb/ucb_cm_goal.png           -> Fig. ucB_cm_goal
  artifacts/results/rq2_ucb/ucb_cm_stim.png           -> Fig. ucB_cm_stim

Expected input files (auto-searched in artifacts dir)
------------------------------------------------------
  artifacts/eaf_two_stage/evaluation_results.json   — Stage-1 + Stage-2 (B1/B2)
  artifacts/eaf_yolo/evaluation_results.json         — Two-Stage YOLO (B3/B4)
  artifacts/eaf_*/evaluation_results_oracle.json     — Oracle evaluation (if run)
  artifacts/eaf_*/roc_curves.json                    — ROC/PR data (optional)

Usage
-----
  python -m twimo.results.rq2_ucb
  python -m twimo.results.rq2_ucb --artifacts-dir artifacts --outdir artifacts/results/rq2_ucb
"""
from __future__ import annotations

import argparse
from pathlib import Path

import numpy as np
import pandas as pd

from twimo.results._utils import (
    load_json, fmt_f, save_artifact, setup_mpl,
)

# EAF output subdirectories to search
EAF_DIRS = ["eaf_two_stage", "eaf_yolo", "eaf", "maneuver_eaf"]
EVAL_FILENAMES = ["evaluation_results.json", "eval_results.json", "test_metrics_eaf.json"]


# ─── Helpers ─────────────────────────────────────────────────────────────────

def _find_eval_file(artifacts_dir: Path, subdirs: list[str],
                    filenames: list[str]) -> tuple[Path | None, str]:
    """Search for evaluation results in known subdirectories."""
    for sd in subdirs:
        d = artifacts_dir / sd
        if not d.exists():
            continue
        for fn in filenames:
            f = d / fn
            if f.exists():
                return f, sd
    return None, ""


def _extract_global_metrics(data: dict) -> dict:
    """Extract global_metrics dict from an evaluation_results.json."""
    if "global_metrics" in data:
        return data["global_metrics"]
    # Flat format (no nesting)
    return data


def _bootstrap_over_sessions(data: dict) -> dict:
    """Compute mean ± CI over session_metrics list if available."""
    sess = data.get("session_metrics", [])
    if not sess:
        return {}
    keys = ["accuracy", "f1_macro", "f1_weighted", "precision_macro", "recall_macro"]
    result = {}
    for k in keys:
        vals = [s[k] for s in sess if k in s and s[k] is not None]
        if vals:
            arr = np.array(vals)
            rng = np.random.default_rng(42)
            means = [rng.choice(arr, len(arr), replace=True).mean() for _ in range(2000)]
            ci_lo, ci_hi = np.percentile(means, [2.5, 97.5])
            result[k] = {"mean": arr.mean(), "ci_lo": ci_lo, "ci_hi": ci_hi, "n": len(vals)}
    return result


def _fmt_mean_ci(stats: dict, key: str, dec: int = 4) -> str:
    """Format mean ± CI string from bootstrap stats dict."""
    if key not in stats:
        return "---"
    s = stats[key]
    m  = s["mean"]
    lo = s["ci_lo"]
    hi = s["ci_hi"]
    return f"{m:.{dec}f} [{lo:.{dec}f}, {hi:.{dec}f}]"


def _plot_confusion_matrix(cm: list[list], class_names: list[str],
                            title: str, out_path: Path) -> None:
    import matplotlib.pyplot as plt
    cm_arr  = np.array(cm, dtype=float)
    row_sum = cm_arr.sum(axis=1, keepdims=True)
    cm_norm = cm_arr / np.where(row_sum == 0, 1.0, row_sum)
    cm_norm[row_sum.squeeze() == 0] = 0.0
    n = cm_norm.shape[0]

    # For large matrices, show a compact version
    fig_size = max(4, min(n * 0.8, 20))
    fig, ax = plt.subplots(figsize=(fig_size, fig_size * 0.9))
    im = ax.imshow(cm_norm, cmap="Blues", vmin=0, vmax=1, interpolation="nearest")
    plt.colorbar(im, ax=ax, fraction=0.046, pad=0.04)
    labels = class_names[:n] if class_names else [str(i) for i in range(n)]
    ax.set_xticks(np.arange(n))
    ax.set_yticks(np.arange(n))
    ax.set_xticklabels(labels, rotation=60, ha="right",
                        fontsize=max(4, 9 - n // 5))
    ax.set_yticklabels(labels, fontsize=max(4, 9 - n // 5))
    if n <= 15:
        for i in range(n):
            for j in range(n):
                ax.text(j, i, f"{cm_norm[i,j]:.2f}", ha="center", va="center",
                        fontsize=6, color="white" if cm_norm[i, j] > 0.5 else "black")
    ax.set_xlabel("Predicted")
    ax.set_ylabel("True")
    ax.set_title(title, fontsize=9)
    plt.tight_layout()
    fig.savefig(out_path, dpi=150, bbox_inches="tight")
    plt.close(fig)


def _plot_roc_pr(roc_data: dict, out_path: Path, title: str = "Stage-1 ROC curves") -> None:
    """Plot ROC curves from roc_curves.json structure."""
    import matplotlib.pyplot as plt
    # roc_data structure: {split: {horizon: {class: {fpr, tpr}}}}
    # For EAF, we use "test" split and the first horizon (or no horizon key)
    fig, ax = plt.subplots(figsize=(5, 4))
    ax.plot([0, 1], [0, 1], "k--", lw=0.8, alpha=0.5, label="Chance")
    colors = ["#4878CF", "#D65F5F", "#6ACC65", "#B47CC7"]

    splits = roc_data if not isinstance(list(roc_data.values())[0], dict) else roc_data
    # Try to navigate to class-level fpr/tpr
    def _extract_curves(node, depth=0):
        if "fpr" in node and "tpr" in node:
            return {"?": node}
        if depth > 3:
            return {}
        curves = {}
        for k, v in node.items():
            if isinstance(v, dict):
                sub = _extract_curves(v, depth + 1)
                curves.update(sub)
        return curves

    curves = _extract_curves(roc_data)
    for i, (cls_name, curve) in enumerate(list(curves.items())[:8]):
        fpr = np.array(curve["fpr"])
        tpr = np.array(curve["tpr"])
        auc = np.trapz(tpr, fpr)
        ax.plot(fpr, tpr, lw=1.5, color=colors[i % len(colors)],
                label=f"{cls_name} (AUC={auc:.2f})")

    ax.set_xlabel("False Positive Rate")
    ax.set_ylabel("True Positive Rate")
    ax.set_title(title, fontsize=9)
    ax.legend(fontsize=7, loc="lower right")
    plt.tight_layout()
    fig.savefig(out_path, dpi=150, bbox_inches="tight")
    plt.close(fig)


# ─── Core logic ───────────────────────────────────────────────────────────────

def run(args: argparse.Namespace) -> None:
    out      = Path(args.outdir)
    arts_dir = Path(args.artifacts_dir)
    out.mkdir(parents=True, exist_ok=True)
    print(f"\n[RQ2-B] Use Case B results  ->  {out}")

    # ── Find evaluation files ─────────────────────────────────────────────────
    eaf_file, eaf_subdir = _find_eval_file(arts_dir, EAF_DIRS, EVAL_FILENAMES)
    if eaf_file is None and args.eaf_outdir:
        # Try explicit path
        for fn in EVAL_FILENAMES:
            cand = Path(args.eaf_outdir) / fn
            if cand.exists():
                eaf_file, eaf_subdir = cand, args.eaf_outdir
                break

    oracle_file = None
    if args.eaf_outdir:
        for fn in ["evaluation_results_oracle.json", "eval_oracle.json"]:
            cand = Path(args.eaf_outdir) / fn
            if cand.exists():
                oracle_file = cand
                break
    if oracle_file is None:
        for sd in EAF_DIRS:
            for fn in ["evaluation_results_oracle.json", "eval_oracle.json"]:
                cand = arts_dir / sd / fn
                if cand.exists():
                    oracle_file = cand
                    break

    if eaf_file is None:
        print(f"  [WARN] No EAF evaluation_results.json found in {arts_dir}.")
        print("  Expected paths:")
        for sd in EAF_DIRS:
            for fn in EVAL_FILENAMES:
                print(f"    {arts_dir / sd / fn}")
        print("\n  Producing placeholder tables (fill manually after running Use Case B).")
        _write_placeholder_tables(out)
        return

    print(f"  EAF eval file: {eaf_file}")
    eaf_data   = load_json(eaf_file)
    global_m   = _extract_global_metrics(eaf_data)
    boot_stats = _bootstrap_over_sessions(eaf_data)

    oracle_data = None
    if oracle_file:
        oracle_data = load_json(oracle_file)
        print(f"  Oracle file:  {oracle_file}")

    # ── Table: ucB_stage1 ─────────────────────────────────────────────────────
    # Treat the EAF pipeline's global metrics as Stage-1 (event detection)
    # If pipeline is two-stage, the top-level metrics are typically Stage-1
    prec_val = global_m.get("precision_macro")
    rec_val  = global_m.get("recall_macro")
    f1_val   = global_m.get("f1_macro")
    auc_val  = global_m.get("roc_auc_macro") or global_m.get("roc_auc")

    if boot_stats:
        prec_str = _fmt_mean_ci(boot_stats, "precision_macro")
        rec_str  = _fmt_mean_ci(boot_stats, "recall_macro")
        f1_str   = _fmt_mean_ci(boot_stats, "f1_macro")
    else:
        prec_str = fmt_f(prec_val)
        rec_str  = fmt_f(rec_val)
        f1_str   = fmt_f(f1_val)

    stage1_df = pd.DataFrame([{
        "Stage-1 (Event detection)": "Test split",
        "Precision":                 prec_str,
        "Recall":                    rec_str,
        "F1":                        f1_str,
        "AUROC / AUPRC":             fmt_f(auc_val) if auc_val else "---",
    }])
    print("\n  [Tab] ucB_stage1")
    save_artifact(
        stage1_df, out, "ucb_stage1",
        caption="Use Case B: Stage-1 event detection performance on the test split (mean with 95\\% CI over sessions where available).",
        label="tab:ucB_stage1",
        col_format="lcccc",
    )

    # ── Table: ucB_stage2 + gap ───────────────────────────────────────────────
    # Try to read per-head metrics (Goal / Stimuli) from 'heads' field or fallback
    heads = eaf_data.get("heads") or eaf_data.get("per_head") or {}
    oracle_heads = (oracle_data or {}).get("heads") or (oracle_data or {}).get("per_head") or {}

    stage2_rows = []
    gap_rows    = []

    if heads:
        for head_name, head_data in heads.items():
            e2e_f1    = head_data.get("f1_macro")
            oracle_f1 = (oracle_heads.get(head_name) or {}).get("f1_macro")
            stage2_rows.append({
                "Head":       head_name,
                "Evaluation": "End-to-end",
                "Macro-F1":   fmt_f(e2e_f1),
                "Top-class per-class F1": "---",
            })
            stage2_rows.append({
                "Head":       head_name,
                "Evaluation": "Oracle",
                "Macro-F1":   fmt_f(oracle_f1),
                "Top-class per-class F1": "---",
            })
            if e2e_f1 is not None and oracle_f1 is not None:
                gap_rows.append({
                    "Head":                    head_name,
                    "Oracle Macro-F1":         fmt_f(oracle_f1),
                    r"$\Delta$ (Oracle - E2E)": f"{oracle_f1 - e2e_f1:+.4f}",
                })
    else:
        # No per-head breakdown — use global as single entry
        e2e_f1    = global_m.get("f1_macro")
        oracle_f1 = (_extract_global_metrics(oracle_data) if oracle_data else {}).get("f1_macro")
        for head in ["Goal", "Stimuli"]:
            stage2_rows.append({
                "Head":       head,
                "Evaluation": "End-to-end",
                "Macro-F1":   fmt_f(e2e_f1),
                "Top-class per-class F1": "---",
            })
            stage2_rows.append({
                "Head":       head,
                "Evaluation": "Oracle",
                "Macro-F1":   fmt_f(oracle_f1) if oracle_f1 else r"\textemdash",
                "Top-class per-class F1": "---",
            })
        if e2e_f1 is not None and oracle_f1 is not None:
            for head in ["Goal", "Stimuli"]:
                gap_rows.append({
                    "Head":                    head,
                    "Oracle Macro-F1":         fmt_f(oracle_f1),
                    r"$\Delta$ (Oracle - E2E)": f"{oracle_f1 - e2e_f1:+.4f}",
                })

    if stage2_rows:
        stage2_df = pd.DataFrame(stage2_rows)
        print("\n  [Tab] ucB_stage2")
        save_artifact(
            stage2_df, out, "ucb_stage2",
            caption="Use Case B: Stage-2 semantic classification for Goal and Stimuli (end-to-end vs. oracle evaluation).",
            label="tab:ucB_stage2",
            col_format="llcc",
            midrule_after=[1],
        )

    if gap_rows:
        gap_df = pd.DataFrame(gap_rows)
        print("\n  [Tab] ucB_gap")
        save_artifact(
            gap_df, out, "ucb_gap",
            caption="Error propagation: oracle vs. end-to-end gap in Macro-F1 for Use Case B Stage-2.",
            label="tab:ucB_gap",
            col_format="lcc",
        )
    else:
        print("  [INFO] Oracle results not found; ucb_gap table skipped. Run with --oracle flag in EAF pipeline first.")

    # ── Figures ───────────────────────────────────────────────────────────────
    if setup_mpl():
        # ROC/PR curve
        roc_path = eaf_file.parent / "roc_curves.json"
        if roc_path.exists():
            roc_data = load_json(roc_path)
            if roc_data:
                pr_out = out / "ucb_pr_curve.png"
                _plot_roc_pr(roc_data, pr_out, title="Use Case B Stage-1: ROC curves (test split)")
                print(f"\n  [Fig] ucb_pr_curve -> {pr_out}")

        # Confusion matrices
        cm_global = global_m.get("confusion_matrix")
        if cm_global:
            per_class_keys = list((eaf_data.get("global_metrics") or eaf_data).get("per_class", {}).keys())
            cm_path = out / "ucb_cm_stage1.png"
            _plot_confusion_matrix(
                cm_global, per_class_keys,
                "Use Case B Stage-1: confusion matrix (normalised, test split)",
                cm_path,
            )
            print(f"  [Fig] ucb_cm_stage1 -> {cm_path}")

        for head in ["Goal", "Stimuli"]:
            head_data = heads.get(head, {})
            cm = head_data.get("confusion_matrix")
            if cm:
                class_names = list(head_data.get("per_class", {}).keys())
                cm_path = out / f"ucb_cm_{head.lower()}.png"
                _plot_confusion_matrix(
                    cm, class_names,
                    f"Use Case B Stage-2: {head} confusion matrix (normalised)",
                    cm_path,
                )
                print(f"  [Fig] ucb_cm_{head.lower()} -> {cm_path}")

    print("  Done.\n")


def _write_placeholder_tables(out: Path) -> None:
    """Write placeholder LaTeX tables when no EAF data is available."""
    placeholder = "---"
    stage1_df = pd.DataFrame([{
        "Stage-1 (Event)": "Test split (mean $\\pm$ CI)",
        "Precision": placeholder,
        "Recall":    placeholder,
        "F1":        placeholder,
        "AUROC":     placeholder,
    }])
    save_artifact(
        stage1_df, out, "ucb_stage1",
        caption="Use Case B: Stage-1 event detection performance (PLACEHOLDER — run Use Case B first).",
        label="tab:ucB_stage1",
        col_format="lcccc",
    )
    stage2_df = pd.DataFrame([
        {"Head": "Goal",    "Evaluation": "End-to-end", "Macro-F1": placeholder},
        {"Head": "Goal",    "Evaluation": "Oracle",     "Macro-F1": placeholder},
        {"Head": "Stimuli", "Evaluation": "End-to-end", "Macro-F1": placeholder},
        {"Head": "Stimuli", "Evaluation": "Oracle",     "Macro-F1": placeholder},
    ])
    save_artifact(
        stage2_df, out, "ucb_stage2",
        caption="Use Case B: Stage-2 results (PLACEHOLDER — run Use Case B first).",
        label="tab:ucB_stage2",
        col_format="llc",
        midrule_after=[1],
    )
    gap_df = pd.DataFrame([
        {"Head": "Goal",    "Oracle Macro-F1": placeholder, "$\\Delta$": placeholder},
        {"Head": "Stimuli", "Oracle Macro-F1": placeholder, "$\\Delta$": placeholder},
    ])
    save_artifact(
        gap_df, out, "ucb_gap",
        caption="Error propagation gap (PLACEHOLDER).",
        label="tab:ucB_gap",
        col_format="lcc",
    )
    print("  Placeholder tables saved. Re-run after Use Case B execution.")


# ─── Entry point ─────────────────────────────────────────────────────────────

def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--artifacts-dir", default="artifacts", dest="artifacts_dir")
    p.add_argument("--eaf-outdir",    default=None, dest="eaf_outdir",
                   help="Explicit path to EAF output dir (optional; auto-searched otherwise)")
    p.add_argument("--outdir",        default="artifacts/results/rq2_ucb")
    run(p.parse_args())


if __name__ == "__main__":
    main()
