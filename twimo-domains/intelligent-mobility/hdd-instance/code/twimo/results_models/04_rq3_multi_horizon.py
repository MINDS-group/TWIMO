"""
RQ3 — Multi-Horizon Prediction (UC-B)
=======================================
Table: multi-horizon results for all horizons h in {0,1,2,3,6,9,12,15} steps
       (at 3 Hz: 0, 0.33, 0.67, 1, 2, 3, 4, 5 seconds)

Reads:
  artifacts/eaf/two_stage/xgboost_v2/predictions/
      metrics_all_horizons.json    (XGBoost v2 two-stage, all horizons)
      metrics_combined_h{h}.json   (per-horizon detailed)

  artifacts/00_maneuver_proxy/maneuver_xgboost/test_metrics.json
      (proxy XGBoost, multi-horizon maneuver prediction)

  artifacts/two_stage_mh/          (if multi-horizon two-stage trained)

Outputs:
  - results/04_rq3_multi_horizon.json
  - LaTeX table for multi-horizon comparison
"""
from __future__ import annotations
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
ARTIFACTS = ROOT / "artifacts"
OUT_DIR = ROOT / "results"
OUT_DIR.mkdir(exist_ok=True)

HZ = 3  # sample rate
HORIZONS_STEPS = [0, 1, 2, 3, 6, 9, 12, 15]
HORIZON_SECONDS = [round(h / HZ, 4) for h in HORIZONS_STEPS]

# Horizon labels for display
def h_label(steps: int) -> str:
    s = steps / HZ
    return f"{s:.2f}s" if s % 1 else f"{int(s)}s"


def load(p: Path) -> dict:
    if not p.exists():
        return {}
    try:
        return json.loads(p.read_text())
    except Exception as e:
        print(f"  [!] {p}: {e}", file=sys.stderr)
        return {}


def fmt(v, decimals: int = 3) -> str:
    if v is None:
        return "---"
    return f"{v:.{decimals}f}"


def main() -> None:
    print("=" * 70)
    print("RQ3 — Multi-Horizon Prediction")
    print("=" * 70)

    all_results: dict = {}

    # -----------------------------------------------------------------------
    # 1. XGBoost v2 two-stage: metrics_all_horizons.json
    # -----------------------------------------------------------------------
    mah_path = ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "predictions" / "metrics_all_horizons.json"
    mah = load(mah_path)

    two_stage_mh: dict = {}
    if mah:
        for h_steps in HORIZONS_STEPS:
            key = f"h{h_steps}"
            v = mah.get(key, {})
            if not isinstance(v, dict):
                continue
            ev = v.get("event_detection", {})
            gp = v.get("goal_on_predicted_events", {})
            sp = v.get("stimuli_on_predicted_events", {})
            go = v.get("goal_oracle", {})
            so = v.get("stimuli_oracle", {})
            two_stage_mh[key] = {
                "horizon_steps": h_steps,
                "horizon_seconds": h_steps / HZ,
                "event_macro_f1": ev.get("macro_f1"),
                "goal_pred_f1":   gp.get("macro_f1"),
                "stimuli_pred_f1":sp.get("macro_f1"),
                "goal_oracle_f1": go.get("macro_f1"),
                "stimuli_oracle_f1": so.get("macro_f1"),
                "n_predicted":    v.get("n_predicted_events"),
                "n_gt_events":    v.get("n_gt_events"),
                "n_test_windows": v.get("n_test_windows"),
            }
    all_results["XGBoost-v2 (two-stage)"] = two_stage_mh

    # -----------------------------------------------------------------------
    # 2. Proxy XGBoost: per-horizon maneuver prediction
    # -----------------------------------------------------------------------
    proxy_xgb_path = ARTIFACTS / "00_maneuver_proxy" / "maneuver_xgboost" / "test_metrics.json"
    proxy_raw = load(proxy_xgb_path)
    if "test_metrics" in proxy_raw:
        proxy_raw = proxy_raw["test_metrics"]

    # Map horizon_steps -> metrics key
    HORIZON_KEY_MAP = {
        1:  "0.333333s",
        2:  "0.666667s",
        3:  "1.0s",
        6:  "2.0s",
        9:  "3.0s",
        12: "4.0s",
        15: "5.0s",
        0:  "0.333333s",  # no h=0 in proxy; use h=1 as closest
    }
    proxy_mh: dict = {}
    for h_steps in HORIZONS_STEPS:
        key = f"h{h_steps}"
        h_key = HORIZON_KEY_MAP.get(h_steps)
        if not h_key:
            continue
        v = proxy_raw.get(h_key, {})
        proxy_mh[key] = {
            "horizon_steps": h_steps,
            "horizon_seconds": h_steps / HZ,
            "f1_macro": v.get("f1_macro"),
            "accuracy": v.get("accuracy"),
            "roc_auc_macro": v.get("roc_auc_macro"),
        }
    all_results["XGBoost (proxy maneuver)"] = proxy_mh

    # -----------------------------------------------------------------------
    # 3. Multi-horizon two-stage (two_stage_mh/) — if available
    # -----------------------------------------------------------------------
    mh_dir = ARTIFACTS / "two_stage_mh"
    if mh_dir.exists() and any(mh_dir.iterdir()):
        mh_horizons: dict = {}
        for h_steps in HORIZONS_STEPS:
            h_pred_path = mh_dir / f"horizon_{h_steps}" / "predictions" / "metrics_combined.json"
            v = load(h_pred_path)
            if v:
                ev = v.get("event_detection", {})
                gp = v.get("goal_on_predicted_events", {})
                sp = v.get("stimuli_on_predicted_events", {})
                go = v.get("goal_oracle", {})
                so = v.get("stimuli_oracle", {})
                mh_horizons[f"h{h_steps}"] = {
                    "horizon_steps": h_steps,
                    "horizon_seconds": h_steps / HZ,
                    "event_macro_f1": ev.get("macro_f1"),
                    "goal_pred_f1":   gp.get("macro_f1"),
                    "stimuli_pred_f1":sp.get("macro_f1"),
                    "goal_oracle_f1": go.get("macro_f1"),
                    "stimuli_oracle_f1": so.get("macro_f1"),
                }
        if mh_horizons:
            all_results["XGBoost-MH (per-horizon trained)"] = mh_horizons
    else:
        print(f"  [!] two_stage_mh/ not found or empty — skipping dedicated MH model.")

    # -----------------------------------------------------------------------
    # Console: two-stage multi-horizon table
    # -----------------------------------------------------------------------
    print(f"\n{'Horizon':>8s}  {'Steps':>5s}  {'Ev-F1':>6s}  {'Goal(pred)':>10s}  "
          f"{'Stim(pred)':>10s}  {'Goal(oracle)':>12s}  {'Stim(oracle)':>12s}")
    print("-" * 72)
    ts = all_results.get("XGBoost-v2 (two-stage)", {})
    for h_steps in HORIZONS_STEPS:
        key = f"h{h_steps}"
        v = ts.get(key, {})
        s = h_steps / HZ
        lbl = f"{s:.2f}s" if s % 1 else f"{int(s)}s"
        print(f"{lbl:>8s}  {h_steps:>5d}  "
              f"{fmt(v.get('event_macro_f1')):>6s}  "
              f"{fmt(v.get('goal_pred_f1')):>10s}  "
              f"{fmt(v.get('stimuli_pred_f1')):>10s}  "
              f"{fmt(v.get('goal_oracle_f1')):>12s}  "
              f"{fmt(v.get('stimuli_oracle_f1')):>12s}")

    # -----------------------------------------------------------------------
    # Console: proxy maneuver multi-horizon
    # -----------------------------------------------------------------------
    print(f"\nProxy-label XGBoost (maneuver) — f1_macro per horizon:")
    px = all_results.get("XGBoost (proxy maneuver)", {})
    for h_steps in HORIZONS_STEPS:
        key = f"h{h_steps}"
        v = px.get(key, {})
        s = h_steps / HZ
        lbl = f"{s:.2f}s" if s % 1 else f"{int(s)}s"
        print(f"  {lbl:>6s} ({h_steps} steps): f1_macro={fmt(v.get('f1_macro'))}")

    # -----------------------------------------------------------------------
    # LaTeX: multi-horizon two-stage table
    # -----------------------------------------------------------------------
    rows = []
    for h_steps in HORIZONS_STEPS:
        key = f"h{h_steps}"
        v = ts.get(key, {})
        s = h_steps / HZ
        lbl = f"{s:.2f}\\,s" if s % 1 else f"{int(s)}\\,s"
        rows.append(" & ".join([
            lbl,
            str(h_steps),
            fmt(v.get("event_macro_f1")),
            fmt(v.get("goal_pred_f1")),
            fmt(v.get("stimuli_pred_f1")),
            fmt(v.get("goal_oracle_f1")),
            fmt(v.get("stimuli_oracle_f1")),
        ]) + " \\\\")

    latex = f"""
% ===== tab:ucB_multi_horizon  (auto-generated by 04_rq3_multi_horizon.py) =====
\\begin{{table}}[ht]
\\centering
\\caption{{UC-B: XGBoost two-stage pipeline results across prediction horizons. F1-macro on test set.}}
\\label{{tab:ucB_multi_horizon}}
\\begin{{tabular}}{{rrrrrrr}}
\\toprule
Horizon & Steps & Ev-F1 & Goal(pred) & Stim(pred) & Goal(oracle) & Stim(oracle) \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\end{{table}}
"""
    print(latex)

    # -----------------------------------------------------------------------
    # LaTeX: comparison table proxy vs two-stage at key horizons
    # -----------------------------------------------------------------------
    KEY_HORIZONS = [0, 3, 6, 9, 12, 15]
    rows_cmp = []
    for h_steps in KEY_HORIZONS:
        key = f"h{h_steps}"
        s = h_steps / HZ
        lbl = f"{s:.2f}\\,s" if s % 1 else f"{int(s)}\\,s"
        ts_v = ts.get(key, {})
        px_v = px.get(key, {})
        rows_cmp.append(" & ".join([
            lbl,
            fmt(px_v.get("f1_macro")),
            fmt(ts_v.get("event_macro_f1")),
            fmt(ts_v.get("goal_pred_f1")),
            fmt(ts_v.get("stimuli_pred_f1")),
        ]) + " \\\\")

    latex_cmp = f"""
% ===== tab:rq3_comparison  (auto-generated by 04_rq3_multi_horizon.py) =====
\\begin{{table}}[ht]
\\centering
\\caption{{RQ3: Proxy maneuver (Macro-F1) vs Two-Stage EAF (Event/Goal/Stim F1) at key horizons.}}
\\label{{tab:rq3_comparison}}
\\begin{{tabular}}{{rrrrr}}
\\toprule
Horizon & Proxy F1 & Two-Stage Ev-F1 & Goal F1 & Stim F1 \\\\
\\midrule
{chr(10).join(rows_cmp)}
\\bottomrule
\\end{{tabular}}
\\end{{table}}
"""
    print(latex_cmp)

    # -----------------------------------------------------------------------
    # Save
    # -----------------------------------------------------------------------
    out = OUT_DIR / "04_rq3_multi_horizon.json"
    out.write_text(json.dumps(all_results, indent=2))
    print(f"[+] Saved: {out}")


if __name__ == "__main__":
    main()
