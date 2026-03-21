"""
RQ2-B — Two-Stage EAF Pipeline (UC-B)
======================================
Tables: tab:ucB_stage1, tab:ucB_stage2, tab:ucB_gap, tab:ucB_two_stage_suite

Reads:
  artifacts/03_manuever_two_stage/
      xgboost_stage1_event/metrics_stage1.json
      transformer_stage1_event/metrics_stage1.json
      transformer_stage2_classifier/metrics_stage2.json
      transformer_stage2_classifier/predictions/metrics_combined.json

  artifacts/eaf/two_stage/xgboost_v2/
      stage1/metrics_stage1.json
      stage2/metrics_stage2.json
      predictions/metrics_combined_h0.json     (h=0, current-step)

  artifacts/two_stage_yolo/
      metrics_stage1.json
      metrics_stage2.json

  artifacts/two_stage_yolo_imp/
      metrics_stage1.json
      metrics_stage2.json

Outputs:
  - results/03_rq2b_two_stage.json
  - LaTeX snippets for all UC-B tables
"""
from __future__ import annotations
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
ARTIFACTS = ROOT / "artifacts"
OUT_DIR = ROOT / "results"
OUT_DIR.mkdir(exist_ok=True)


def load(p: Path) -> dict:
    if not p.exists():
        return {}
    try:
        return json.loads(p.read_text())
    except Exception as e:
        print(f"  [!] Cannot load {p}: {e}", file=sys.stderr)
        return {}


def fmt(v, decimals: int = 3) -> str:
    if v is None:
        return "---"
    return f"{v:.{decimals}f}"


# ---------------------------------------------------------------------------
# Source definitions
# ---------------------------------------------------------------------------
SOURCES: dict[str, dict] = {
    "XGBoost (03)": {
        "s1": ARTIFACTS / "03_manuever_two_stage" / "xgboost_stage1_event" / "metrics_stage1.json",
        "s2": None,
        "combined": None,
    },
    "Transformer (03)": {
        "s1": ARTIFACTS / "03_manuever_two_stage" / "transformer_stage1_event" / "metrics_stage1.json",
        "s2": ARTIFACTS / "03_manuever_two_stage" / "transformer_stage2_classifier" / "metrics_stage2.json",
        "combined": ARTIFACTS / "03_manuever_two_stage" / "transformer_stage2_classifier" / "predictions" / "metrics_combined.json",
    },
    "XGBoost v2": {
        "s1": ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "stage1" / "metrics_stage1.json",
        "s2": ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "stage2" / "metrics_stage2.json",
        "combined": ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "predictions" / "metrics_combined_h0.json",
    },
    "YOLO (sensor+det)": {
        "s1": ARTIFACTS / "two_stage_yolo" / "metrics_stage1.json",
        "s2": ARTIFACTS / "two_stage_yolo" / "metrics_stage2.json",
        "combined": None,
    },
    "YOLO-imp": {
        "s1": ARTIFACTS / "two_stage_yolo_imp" / "metrics_stage1.json",
        "s2": ARTIFACTS / "two_stage_yolo_imp" / "metrics_stage2.json",
        "combined": None,
    },
}


def parse_stage1(d: dict) -> dict:
    """Normalise stage1 metrics across formats."""
    if not d:
        return {}
    # Format A: {accuracy, macro_f1/f1_macro, f1_no_event, f1_event}
    macro = d.get("macro_f1") or d.get("f1_macro")
    f1_ev = d.get("f1_event") or (d.get("per_class", {}).get("event", {}).get("f1"))
    f1_nev = d.get("f1_no_event") or (d.get("per_class", {}).get("no_event", {}).get("f1"))
    prec_ev = d.get("per_class", {}).get("event", {}).get("precision")
    rec_ev = d.get("per_class", {}).get("event", {}).get("recall")
    return {
        "accuracy":    d.get("accuracy"),
        "macro_f1":    macro,
        "f1_event":    f1_ev,
        "f1_no_event": f1_nev,
        "prec_event":  prec_ev,
        "rec_event":   rec_ev,
        "n_windows":   d.get("n_windows"),
        "n_event_windows": d.get("n_event_windows"),
    }


def parse_stage2(d: dict) -> dict:
    """Normalise stage2 metrics across formats."""
    if not d:
        return {}
    goal = d.get("goal", {})
    stim = d.get("stimuli", d.get("stimuli_on_predicted_events", {}))
    return {
        "goal_macro_f1":    goal.get("macro_f1") or goal.get("f1_macro"),
        "goal_accuracy":    goal.get("accuracy"),
        "stimuli_macro_f1": stim.get("macro_f1") or stim.get("f1_macro"),
        "stimuli_accuracy": stim.get("accuracy"),
    }


def parse_combined(d: dict) -> dict:
    """Parse unified prediction metrics (combined stage1+stage2 eval)."""
    if not d:
        return {}
    ev = d.get("event_detection", {})
    gp = d.get("goal_on_predicted_events", {})
    sp = d.get("stimuli_on_predicted_events", {})
    go = d.get("goal_oracle", {})
    so = d.get("stimuli_oracle", {})
    return {
        "event_macro_f1":   ev.get("macro_f1"),
        "goal_pred_f1":     gp.get("macro_f1"),
        "stimuli_pred_f1":  sp.get("macro_f1"),
        "goal_oracle_f1":   go.get("macro_f1"),
        "stimuli_oracle_f1":so.get("macro_f1"),
        "n_test_windows":   d.get("n_test_windows"),
        "n_predicted_events": d.get("n_predicted_events"),
        "n_gt_events":      d.get("n_gt_events"),
    }


def main() -> None:
    print("=" * 70)
    print("RQ2-B — UC-B: Two-Stage EAF Pipeline")
    print("=" * 70)

    all_results: dict = {}

    for name, paths in SOURCES.items():
        s1_raw = load(paths["s1"]) if paths["s1"] else {}
        s2_raw = load(paths["s2"]) if paths["s2"] else {}
        comb_raw = load(paths["combined"]) if paths["combined"] else {}

        s1 = parse_stage1(s1_raw)
        s2 = parse_stage2(s2_raw)
        comb = parse_combined(comb_raw)

        available = bool(s1)
        all_results[name] = {
            "available": available,
            "stage1": s1,
            "stage2": s2,
            "combined": comb,
        }

    # -----------------------------------------------------------------------
    # Console: Stage 1 summary
    # -----------------------------------------------------------------------
    print(f"\n{'Model':<22s}  {'Acc':>6s}  {'Macro-F1':>8s}  {'F1(ev)':>7s}  {'F1(no-ev)':>9s}  {'P(ev)':>6s}  {'R(ev)':>6s}")
    print("-" * 75)
    for name, row in all_results.items():
        s1 = row["stage1"]
        if not s1:
            print(f"{name:<22s}  [no stage1 data]")
            continue
        print(f"{name:<22s}  {fmt(s1.get('accuracy')):>6s}  {fmt(s1.get('macro_f1')):>8s}  "
              f"{fmt(s1.get('f1_event')):>7s}  {fmt(s1.get('f1_no_event')):>9s}  "
              f"{fmt(s1.get('prec_event')):>6s}  {fmt(s1.get('rec_event')):>6s}")

    # -----------------------------------------------------------------------
    # Console: Stage 2 summary
    # -----------------------------------------------------------------------
    print(f"\n{'Model':<22s}  {'Goal F1':>8s}  {'Stim F1':>8s}")
    print("-" * 45)
    for name, row in all_results.items():
        s2 = row["stage2"]
        if not s2:
            print(f"{name:<22s}  [no stage2 data]")
            continue
        print(f"{name:<22s}  {fmt(s2.get('goal_macro_f1')):>8s}  {fmt(s2.get('stimuli_macro_f1')):>8s}")

    # -----------------------------------------------------------------------
    # Console: Combined (predicted events) summary
    # -----------------------------------------------------------------------
    print(f"\n{'Model':<22s}  {'Ev F1':>6s}  {'Goal(pred)':>10s}  {'Stim(pred)':>10s}  {'Goal(oracle)':>12s}  {'Stim(oracle)':>12s}")
    print("-" * 80)
    for name, row in all_results.items():
        comb = row["combined"]
        if not comb:
            continue
        print(f"{name:<22s}  "
              f"{fmt(comb.get('event_macro_f1')):>6s}  "
              f"{fmt(comb.get('goal_pred_f1')):>10s}  "
              f"{fmt(comb.get('stimuli_pred_f1')):>10s}  "
              f"{fmt(comb.get('goal_oracle_f1')):>12s}  "
              f"{fmt(comb.get('stimuli_oracle_f1')):>12s}")

    # -----------------------------------------------------------------------
    # LaTeX: tab:ucB_stage1
    # -----------------------------------------------------------------------
    rows_s1 = []
    for name, row in all_results.items():
        s1 = row["stage1"]
        if not s1:
            continue
        rows_s1.append(" & ".join([
            name,
            fmt(s1.get("accuracy")),
            fmt(s1.get("macro_f1")),
            fmt(s1.get("f1_event")),
            fmt(s1.get("f1_no_event")),
            fmt(s1.get("prec_event")),
            fmt(s1.get("rec_event")),
        ]) + " \\\\")

    latex_s1 = f"""
% ===== tab:ucB_stage1  (auto-generated by 03_rq2b_two_stage.py) =====
\\begin{{table}}[ht]
\\centering
\\caption{{UC-B Stage 1: Event Detection. Macro-F1, per-class F1, precision and recall on predicted events.}}
\\label{{tab:ucB_stage1}}
\\begin{{tabular}}{{lrrrrrr}}
\\toprule
Model & Acc & Macro-F1 & F1(event) & F1(no-ev) & P(event) & R(event) \\\\
\\midrule
{chr(10).join(rows_s1)}
\\bottomrule
\\end{{tabular}}
\\end{{table}}
"""
    print(latex_s1)

    # -----------------------------------------------------------------------
    # LaTeX: tab:ucB_stage2
    # -----------------------------------------------------------------------
    rows_s2 = []
    for name, row in all_results.items():
        s2 = row["stage2"]
        comb = row["combined"]
        if not s2 and not comb:
            continue
        goal_f1 = s2.get("goal_macro_f1") if s2 else comb.get("goal_pred_f1") if comb else None
        stim_f1 = s2.get("stimuli_macro_f1") if s2 else comb.get("stimuli_pred_f1") if comb else None
        g_oracle = comb.get("goal_oracle_f1") if comb else None
        s_oracle = comb.get("stimuli_oracle_f1") if comb else None
        rows_s2.append(" & ".join([
            name,
            fmt(goal_f1),
            fmt(stim_f1),
            fmt(g_oracle),
            fmt(s_oracle),
        ]) + " \\\\")

    latex_s2 = f"""
% ===== tab:ucB_stage2  (auto-generated by 03_rq2b_two_stage.py) =====
\\begin{{table}}[ht]
\\centering
\\caption{{UC-B Stage 2: Goal and Stimuli classification on predicted events. Oracle = evaluated on ground-truth events only.}}
\\label{{tab:ucB_stage2}}
\\begin{{tabular}}{{lrrrr}}
\\toprule
Model & Goal F1 & Stim F1 & Goal(oracle) & Stim(oracle) \\\\
\\midrule
{chr(10).join(rows_s2)}
\\bottomrule
\\end{{tabular}}
\\end{{table}}
"""
    print(latex_s2)

    # -----------------------------------------------------------------------
    # LaTeX: tab:ucB_gap  (oracle vs predicted gap)
    # -----------------------------------------------------------------------
    rows_gap = []
    for name, row in all_results.items():
        comb = row["combined"]
        if not comb:
            continue
        gp = comb.get("goal_pred_f1")
        go = comb.get("goal_oracle_f1")
        sp = comb.get("stimuli_pred_f1")
        so = comb.get("stimuli_oracle_f1")
        g_gap = (gp - go) if (gp is not None and go is not None) else None
        s_gap = (sp - so) if (sp is not None and so is not None) else None
        rows_gap.append(" & ".join([
            name,
            fmt(go), fmt(gp), fmt(g_gap),
            fmt(so), fmt(sp), fmt(s_gap),
        ]) + " \\\\")

    if rows_gap:
        latex_gap = f"""
% ===== tab:ucB_gap  (auto-generated by 03_rq2b_two_stage.py) =====
\\begin{{table}}[ht]
\\centering
\\caption{{UC-B: Gap between oracle and pipeline predictions for Goal and Stimuli (negative = pipeline loses due to Stage~1 errors).}}
\\label{{tab:ucB_gap}}
\\begin{{tabular}}{{lrrrrrr}}
\\toprule
Model & Goal(oracle) & Goal(pred) & $\\Delta$Goal & Stim(oracle) & Stim(pred) & $\\Delta$Stim \\\\
\\midrule
{chr(10).join(rows_gap)}
\\bottomrule
\\end{{tabular}}
\\end{{table}}
"""
        print(latex_gap)

    # -----------------------------------------------------------------------
    # Save
    # -----------------------------------------------------------------------
    out = OUT_DIR / "03_rq2b_two_stage.json"
    out.write_text(json.dumps(all_results, indent=2))
    print(f"[+] Saved: {out}")


if __name__ == "__main__":
    main()
