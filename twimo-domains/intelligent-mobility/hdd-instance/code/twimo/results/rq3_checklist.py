"""
RQ3 — Framework-level validation: traceability, reuse, and scenario-block mapping.

Produces
--------
  artifacts/results/rq3/artifact_checklist.csv / .tex  -> Tab. artifact_checklist
  artifacts/results/rq3/reuse_map.tex                  -> Tab. reuse_map        (static)
  artifacts/results/rq3/scenario_block_mapping.tex      -> Tab. scenario_block_mapping (static)

Usage
-----
  python -m twimo.results.rq3_checklist
  python -m twimo.results.rq3_checklist --artifacts-dir artifacts --outdir artifacts/results/rq3
"""
from __future__ import annotations

import argparse
from pathlib import Path

import pandas as pd

from twimo.results._utils import load_json, save_artifact, latex_table


# ─── Artifact checklist spec ─────────────────────────────────────────────────

# (run_label, relative_dir_in_artifacts, expected_files_dict)
#   expected_files_dict: display_name -> filename_or_glob_pattern
CHECKLIST_SPEC: list[tuple[str, str, dict[str, str]]] = [
    (
        "UC-A (Transformer)",
        "maneuver_transformer",
        {
            "Config":        "config.json",
            "Split IDs":     "split_ids.json",
            "Metrics":       "test_metrics.json",
            "ROC curves":    "roc_curves.json",
            "Model weights": "model.pth",
            "Feat. names":   "feature_names.json",
            "Explanations":  "explain/explanations__all.jsonl",
        },
    ),
    (
        "UC-A (XGBoost)",
        "maneuver_xgboost",
        {
            "Config":        "config.json",
            "Split IDs":     "split_ids.json",
            "Metrics":       "test_metrics.json",
            "ROC curves":    "roc_curves.json",
            "Model weights": "model.joblib",
            "Feat. names":   "feature_names.json",
            "Explanations":  "explain/explanations__all.jsonl",
        },
    ),
    (
        "UC-B Stage-1",
        "eaf_two_stage",
        {
            "Config":        "config.json",
            "Split IDs":     "split_ids.json",
            "Metrics":       "evaluation_results.json",
            "ROC curves":    "roc_curves.json",
            "Model weights": "model.pth",
            "Feat. names":   "feature_names.json",
            "Explanations":  "---",
        },
    ),
    (
        "UC-B Stage-2 (E2E)",
        "eaf_yolo",
        {
            "Config":        "config.json",
            "Split IDs":     "split_ids.json",
            "Metrics":       "evaluation_results.json",
            "ROC curves":    "roc_curves.json",
            "Model weights": "model.pth",
            "Feat. names":   "feature_names.json",
            "Explanations":  "---",
        },
    ),
    (
        "UC-C (DT basic)",
        "dt_basic",
        {
            "Config":        "---",
            "Split IDs":     "---",
            "Metrics":       "dt_summary.json",
            "ROC curves":    "---",
            "Model weights": "---",
            "Feat. names":   "---",
            "Explanations":  "---",
        },
    ),
    (
        "UC-C (DT optimized)",
        "dt_optimized",
        {
            "Config":        "---",
            "Split IDs":     "---",
            "Metrics":       "dt_optimized_summary.json",
            "ROC curves":    "---",
            "Model weights": "---",
            "Feat. names":   "---",
            "Explanations":  "---",
        },
    ),
    (
        "UC-D (Style)",
        "style",
        {
            "Config":        "---",
            "Split IDs":     "---",
            "Metrics":       "style_centroids.json",
            "ROC curves":    "---",
            "Model weights": "---",
            "Feat. names":   "---",
            "Explanations":  "---",
        },
    ),
    (
        "UC-E (Explain)",
        "explain",
        {
            "Config":        "---",
            "Split IDs":     "---",
            "Metrics":       "---",
            "ROC curves":    "---",
            "Model weights": "---",
            "Feat. names":   "---",
            "Explanations":  "explanations__all.jsonl",
        },
    ),
]

TICK = r"\checkmark"
CROSS = r"\texttimes"
NA = r"---"


def _check(artifacts_dir: Path, subdir: str, filename: str) -> str:
    """Return LaTeX tick/cross/NA for a file."""
    if filename == "---":
        return NA
    path = artifacts_dir / subdir / filename
    return TICK if path.exists() else CROSS


# ─── Static tables ───────────────────────────────────────────────────────────

REUSE_MAP_DATA = [
    # component, description, UC-A, UC-B, UC-C, UC-D, UC-E
    ("Digital Shadow builder",   r"Session scan + prealigned .npy alignment",
     TICK, TICK, TICK, TICK, TICK),
    ("Manifest schema",          r"\texttt{SessionRecord} JSONL registry",
     TICK, TICK, TICK, TICK, TICK),
    ("Sensor resampling",        r"\texttt{resample\_sensors()} @ fixed $f_s$",
     TICK, TICK, r"---", TICK, TICK),
    ("CLI orchestration",        r"\texttt{python -m twimo.cli <cmd>}",
     TICK, TICK, TICK, TICK, TICK),
    ("Artifact schema",          r"\texttt{config.json} + \texttt{test\_metrics.json}",
     TICK, TICK, r"---", r"---", r"---"),
    ("Profiling tracker",        r"\texttt{TrainingProfiler} (energy, time)",
     TICK, TICK, TICK, TICK, r"---"),
    ("Explanation exporter",     r"\texttt{twimo.xai.explain}",
     TICK, r"---", r"---", r"---", TICK),
    ("DTE metamodel mapping",    r"\texttt{predictor\_metadata.json} / \texttt{twin\_config.json}",
     TICK, TICK, TICK, r"---", r"---"),
]

SCENARIO_MAP_DATA = [
    # scenario block, metamodel class, code entrypoint, artifacts produced
    ("A1 Train Transformer",
     r"\texttt{Predictor}",
     r"\texttt{cli train-maneuver --model transformer}",
     r"\texttt{test\_metrics.json}, \texttt{roc\_curves.json}"),
    ("A2--A10 Train baselines",
     r"\texttt{Predictor}",
     r"\texttt{cli train-maneuver --model \{xgb, rf, \ldots\}}",
     r"\texttt{test\_metrics.json}"),
    ("B1/B2 EAF two-stage",
     r"\texttt{Predictor} (two-stage)",
     r"\texttt{cli eaf-yolo-improved train}",
     r"\texttt{evaluation\_results.json}"),
    ("C1 Basic DT",
     r"\texttt{DigitalTwin}",
     r"\texttt{cli simulate-dt}",
     r"\texttt{dt\_summary.json}"),
    ("C2 Optimized DT",
     r"\texttt{DigitalTwin}",
     r"\texttt{cli simulate-dt-optimized}",
     r"\texttt{dt\_optimized\_summary.json}"),
    ("D1 Style clustering",
     r"\texttt{StyleAnalyser}",
     r"\texttt{cli train-style}",
     r"\texttt{style\_centroids.json}"),
    ("E1 Explain",
     r"\texttt{ExplainService}",
     r"\texttt{cli explain}",
     r"\texttt{explanations\_\_all.jsonl}"),
]


def _reuse_map_tex(out_dir: Path) -> None:
    header = ["Component", "Description", "A", "B", "C", "D", "E"]
    rows = []
    for comp, desc, a, b, c, d, e in REUSE_MAP_DATA:
        rows.append({"Component": comp, "Description": desc,
                     "A": a, "B": b, "C": c, "D": d, "E": e})
    df = pd.DataFrame(rows)
    df.columns = header
    tex = latex_table(
        df,
        caption="Shared TWIMO components and which Use Cases rely on them (reuse map, RQ3-T2).",
        label="tab:reuse_map",
        col_format="llccccc",
        fontsize=r"\small",
    )
    path = out_dir / "reuse_map.tex"
    path.write_text(tex, encoding="utf-8")
    df.to_csv(out_dir / "reuse_map.csv", index=False)
    print(f"    LaTeX: {path}")


def _scenario_map_tex(out_dir: Path) -> None:
    header = ["Scenario block", "Metamodel class", "Code entrypoint", "Artifacts produced"]
    rows = []
    for sb, mc, ce, ap in SCENARIO_MAP_DATA:
        rows.append({"Scenario block": sb, "Metamodel class": mc,
                     "Code entrypoint": ce, "Artifacts produced": ap})
    df = pd.DataFrame(rows)
    df.columns = header
    tex = latex_table(
        df,
        caption="Scenario-block to metamodel mapping and produced artifacts (RQ3-T3).",
        label="tab:scenario_block_mapping",
        col_format="llll",
        fontsize=r"\scriptsize",
    )
    path = out_dir / "scenario_block_mapping.tex"
    path.write_text(tex, encoding="utf-8")
    df.to_csv(out_dir / "scenario_block_mapping.csv", index=False)
    print(f"    LaTeX: {path}")


# ─── Core logic ───────────────────────────────────────────────────────────────

def run(args: argparse.Namespace) -> None:
    out      = Path(args.outdir)
    arts_dir = Path(args.artifacts_dir)
    out.mkdir(parents=True, exist_ok=True)
    print(f"\n[RQ3] Framework validation  ->  {out}")

    # ── Tab: artifact_checklist ───────────────────────────────────────────────
    all_artifact_keys = list(CHECKLIST_SPEC[0][2].keys())
    rows = []
    for run_label, subdir, files_spec in CHECKLIST_SPEC:
        row: dict = {"Run": run_label}
        for display_name, filename in files_spec.items():
            row[display_name] = _check(arts_dir, subdir, filename)
        rows.append(row)

    df = pd.DataFrame(rows)
    print("\n  [Tab] artifact_checklist")
    save_artifact(
        df, out, "artifact_checklist",
        caption=(
            "Evidence artifact checklist for RQ3-T1 (traceability). "
            r"\checkmark = present, \texttimes = missing, --- = not applicable."
        ),
        label="tab:artifact_checklist",
        col_format="l" + "c" * len(all_artifact_keys),
        fontsize=r"\scriptsize",
    )

    # Summary counts
    n_total  = sum(1 for row in rows for v in list(row.values())[1:] if v != NA)
    n_present = sum(1 for row in rows for v in list(row.values())[1:] if v == TICK)
    n_missing = sum(1 for row in rows for v in list(row.values())[1:] if v == CROSS)
    print(f"    Summary: {n_present}/{n_total} artifacts present, {n_missing} missing")

    # ── Tab: reuse_map (static) ───────────────────────────────────────────────
    print("\n  [Tab] reuse_map (static)")
    _reuse_map_tex(out)

    # ── Tab: scenario_block_mapping (static) ──────────────────────────────────
    print("\n  [Tab] scenario_block_mapping (static)")
    _scenario_map_tex(out)

    print("  Done.\n")


# ─── Entry point ─────────────────────────────────────────────────────────────

def main() -> None:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawTextHelpFormatter)
    p.add_argument("--artifacts-dir", default="artifacts", dest="artifacts_dir")
    p.add_argument("--outdir",        default="artifacts/results/rq3")
    run(p.parse_args())


if __name__ == "__main__":
    main()
