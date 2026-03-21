"""
RQ2-A — Proxy-Label Maneuver Prediction (UC-A)
===============================================
Tables: tab:ucA_main, tab:ucA_model_suite, tab:ucA_ranks

Reads:
  - artifacts/00_maneuver_proxy/maneuver_{gru,lightgbm,rf,transformer,xgboost}/
      test_metrics.json       (per-horizon metrics)
      profiling_metrics.json  (training time, energy)
  - artifacts/01_maneuver_eaf/maneuver_eaf_xgboost/test_metrics.json  (EAF reference)
  - artifacts/02_manuever_multi_target/maneuver_goal_xgboost/test_metrics.json

Outputs:
  - results/02_rq2a_proxy.json
  - LaTeX table snippets for tab:ucA_main and tab:ucA_model_suite
"""
from __future__ import annotations
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
ARTIFACTS = ROOT / "artifacts"
OUT_DIR = ROOT / "results"
OUT_DIR.mkdir(exist_ok=True)

# Horizons to report (seconds) — paper uses 1s, 2s, 3s, 4s, 5s
HORIZONS_OF_INTEREST = ["0.333333s", "0.666667s", "1.0s", "2.0s", "3.0s", "4.0s", "5.0s"]
HORIZON_LABELS = ["0.33s", "0.67s", "1s", "2s", "3s", "4s", "5s"]

PROXY_MODELS = {
    "GRU":         ARTIFACTS / "00_maneuver_proxy" / "maneuver_gru",
    "LightGBM":    ARTIFACTS / "00_maneuver_proxy" / "maneuver_lightgbm",
    "RF":          ARTIFACTS / "00_maneuver_proxy" / "maneuver_rf",
    "Transformer": ARTIFACTS / "00_maneuver_proxy" / "maneuver_transformer",
    "XGBoost":     ARTIFACTS / "00_maneuver_proxy" / "maneuver_xgboost",
}
EAF_MODELS = {
    "XGBoost (EAF)":  ARTIFACTS / "01_maneuver_eaf" / "maneuver_eaf_xgboost",
    "XGBoost (Goal)": ARTIFACTS / "02_manuever_multi_target" / "maneuver_goal_xgboost",
}


def load_metrics(model_dir: Path) -> dict:
    """Load test_metrics.json from a model directory."""
    p = model_dir / "test_metrics.json"
    if not p.exists():
        return {}
    d = json.loads(p.read_text())
    # Some files wrap under "test_metrics" key
    if "test_metrics" in d:
        d = d["test_metrics"]
    return d


def load_profiling(model_dir: Path) -> dict:
    p = model_dir / "profiling_metrics.json"
    if not p.exists():
        return {}
    return json.loads(p.read_text())


def extract_f1(metrics: dict, horizon_key: str) -> float | None:
    h = metrics.get(horizon_key, {})
    if not h:
        return None
    return h.get("f1_macro")


def fmt(v: float | None, decimals: int = 3) -> str:
    if v is None:
        return "---"
    return f"{v:.{decimals}f}"


def pct(v: float | None) -> str:
    if v is None:
        return "---"
    return f"{v*100:.1f}"


def main() -> None:
    all_results: dict = {}

    print("=" * 70)
    print("RQ2-A — UC-A: Proxy-Label Maneuver Prediction")
    print("=" * 70)

    # -----------------------------------------------------------------------
    # 1. Load all model metrics
    # -----------------------------------------------------------------------
    all_models = {**PROXY_MODELS, **EAF_MODELS}
    for name, model_dir in all_models.items():
        metrics = load_metrics(model_dir)
        profiling = load_profiling(model_dir)
        if not metrics:
            print(f"  [!] Missing: {model_dir.name}")
            all_results[name] = {"available": False}
            continue

        row: dict = {"available": True, "horizons": {}}
        for h_key in HORIZONS_OF_INTEREST:
            h_data = metrics.get(h_key, {})
            if h_data:
                row["horizons"][h_key] = {
                    "f1_macro":  h_data.get("f1_macro"),
                    "f1_weighted": h_data.get("f1_weighted"),
                    "accuracy":  h_data.get("accuracy"),
                    "roc_auc_macro": h_data.get("roc_auc_macro"),
                    "n":         h_data.get("n"),
                }
        row["training_time_s"] = profiling.get("training_time_seconds")
        row["energy_kwh"] = profiling.get("energy_consumed_kwh")
        row["device"] = profiling.get("device")
        all_results[name] = row

    # -----------------------------------------------------------------------
    # 2. Print summary table (console)
    # -----------------------------------------------------------------------
    print(f"\n{'Model':<16s}", end="")
    for hl in HORIZON_LABELS:
        print(f"  {hl:>7s}", end="")
    print(f"  {'Train(s)':>9s}  {'E(kWh)':>8s}")
    print("-" * (16 + 9 * len(HORIZON_LABELS) + 22))

    for name, row in all_results.items():
        if not row.get("available"):
            print(f"{name:<16s}  [no data]")
            continue
        print(f"{name:<16s}", end="")
        for h_key in HORIZONS_OF_INTEREST:
            v = row["horizons"].get(h_key, {}).get("f1_macro")
            print(f"  {fmt(v):>7s}", end="")
        t = row.get("training_time_s")
        e = row.get("energy_kwh")
        print(f"  {fmt(t, 1) if t else '---':>9s}  {fmt(e, 5) if e else '---':>8s}")

    # -----------------------------------------------------------------------
    # 3. LaTeX: tab:ucA_main  (main horizon comparison — 1s, 2s, 3s, 4s, 5s)
    # -----------------------------------------------------------------------
    MAIN_HORIZONS = ["1.0s", "2.0s", "3.0s", "4.0s", "5.0s"]
    MAIN_LABELS   = ["1\\,s", "2\\,s", "3\\,s", "4\\,s", "5\\,s"]

    rows_latex = []
    for name, row in all_results.items():
        if not row.get("available"):
            continue
        cells = [name]
        for h_key in MAIN_HORIZONS:
            v = row["horizons"].get(h_key, {}).get("f1_macro")
            cells.append(fmt(v))
        rows_latex.append(" & ".join(cells) + " \\\\")

    col_spec = "l" + "r" * len(MAIN_HORIZONS)
    header = "Model & " + " & ".join(f"$h={l}$" for l in MAIN_LABELS) + " \\\\"
    latex_main = f"""
% ===== tab:ucA_main  (auto-generated by 02_rq2a_proxy.py) =====
\\begin{{table}}[ht]
\\centering
\\caption{{UC-A: Macro-F1 at increasing prediction horizons. Models trained with proxy maneuver labels (3\\,Hz).}}
\\label{{tab:ucA_main}}
\\begin{{tabular}}{{{col_spec}}}
\\toprule
{header}
\\midrule
{chr(10).join(rows_latex)}
\\bottomrule
\\end{{tabular}}
\\end{{table}}
"""
    print("\n" + latex_main)

    # -----------------------------------------------------------------------
    # 4. LaTeX: tab:ucA_model_suite  (all horizons, all models)
    # -----------------------------------------------------------------------
    ALL_HZ_LATEX = ["0.33\\,s", "0.67\\,s", "1\\,s", "2\\,s", "3\\,s", "4\\,s", "5\\,s"]
    rows_suite = []
    for name, row in all_results.items():
        if not row.get("available"):
            continue
        cells = [name]
        for h_key in HORIZONS_OF_INTEREST:
            v = row["horizons"].get(h_key, {}).get("f1_macro")
            cells.append(fmt(v))
        t = row.get("training_time_s")
        cells.append(f"{t:.0f}\\,s" if t else "---")
        rows_suite.append(" & ".join(cells) + " \\\\")

    col_spec2 = "l" + "r" * len(HORIZONS_OF_INTEREST) + "r"
    header2 = "Model & " + " & ".join(f"$h={l}$" for l in ALL_HZ_LATEX) + " & Train \\\\"
    latex_suite = f"""
% ===== tab:ucA_model_suite  (auto-generated by 02_rq2a_proxy.py) =====
\\begin{{table}}[ht]
\\centering
\\caption{{UC-A: Full model suite — Macro-F1 at all horizons.}}
\\label{{tab:ucA_model_suite}}
\\begin{{tabular}}{{{col_spec2}}}
\\toprule
{header2}
\\midrule
{chr(10).join(rows_suite)}
\\bottomrule
\\end{{tabular}}
\\end{{table}}
"""
    print(latex_suite)

    # -----------------------------------------------------------------------
    # 5. LaTeX: tab:ucA_ranks  (rank per horizon)
    # -----------------------------------------------------------------------
    def rank_models(h_key: str) -> list[tuple[str, float | None]]:
        vals = []
        for name, row in all_results.items():
            if not row.get("available"):
                continue
            v = row["horizons"].get(h_key, {}).get("f1_macro")
            vals.append((name, v))
        vals.sort(key=lambda x: x[1] if x[1] is not None else -1, reverse=True)
        return vals

    print("\n--- Rankings per horizon ---")
    for h_key, h_label in zip(MAIN_HORIZONS, MAIN_LABELS):
        ranked = rank_models(h_key)
        print(f"  {h_label:>5s}: " + " > ".join(f"{n}({fmt(v)})" for n, v in ranked))

    # -----------------------------------------------------------------------
    # Save JSON
    # -----------------------------------------------------------------------
    out = OUT_DIR / "02_rq2a_proxy.json"
    out.write_text(json.dumps(all_results, indent=2))
    print(f"\n[+] Saved: {out}")


if __name__ == "__main__":
    main()
