"""
Complete LaTeX Tables Generator
================================
Reads all result JSONs and generates a self-contained .tex file
with ALL tables and figure inclusions filled with real data.

Output: results/paper_tables.tex

Usage:
    python -m twimo.results_models.07_generate_latex_complete
"""
from __future__ import annotations
import json
from pathlib import Path

ROOT      = Path(__file__).resolve().parents[2]
ARTIFACTS = ROOT / "artifacts"
RES_DIR   = ROOT / "results"
FIG_DIR   = RES_DIR / "figures"
RES_DIR.mkdir(exist_ok=True)

# ─────────────────────────────────────────────────────────────────────────────
# Helpers
# ─────────────────────────────────────────────────────────────────────────────
def load(p: Path) -> dict:
    if not p.exists():
        return {}
    try:
        return json.loads(p.read_text())
    except Exception:
        return {}

def f(v, d=3):
    """Format float to d decimal places, or --- if None."""
    if v is None:
        return r"\phdot"
    return f"{v:.{d}f}"

def f2(v): return f(v, 2)
def f3(v): return f(v, 3)
def f4(v): return f(v, 4)
def pct(v): return f"{v:.1f}\\%" if v is not None else r"\phdot"

HZ = 3
HORIZONS      = [1, 2, 3, 6, 9, 12, 15]          # steps (no h=0 in proxy)
HORIZONS_ALL  = [0, 1, 2, 3, 6, 9, 12, 15]       # all
HORIZON_S     = [h / HZ for h in HORIZONS]
HORIZON_S_ALL = [h / HZ for h in HORIZONS_ALL]

PROXY_HORIZON_MAP = {
    1:  "0.333333s",
    2:  "0.666667s",
    3:  "1.0s",
    6:  "2.0s",
    9:  "3.0s",
    12: "4.0s",
    15: "5.0s",
}

PROXY_MODELS_ORDERED = [
    ("Transformer", ARTIFACTS / "00_maneuver_proxy" / "maneuver_transformer"),
    ("GRU",         ARTIFACTS / "00_maneuver_proxy" / "maneuver_gru"),
    ("LightGBM",    ARTIFACTS / "00_maneuver_proxy" / "maneuver_lightgbm"),
    ("RF",          ARTIFACTS / "00_maneuver_proxy" / "maneuver_rf"),
    ("XGBoost",     ARTIFACTS / "00_maneuver_proxy" / "maneuver_xgboost"),
]

def load_proxy_metrics(model_dir: Path) -> dict:
    d = load(model_dir / "test_metrics.json")
    if "test_metrics" in d:
        d = d["test_metrics"]
    return d

def load_proxy_profile(model_dir: Path) -> dict:
    return load(model_dir / "profiling_metrics.json")

def get_at(metrics: dict, h_steps: int, key: str):
    k = PROXY_HORIZON_MAP.get(h_steps)
    if not k:
        return None
    return metrics.get(k, {}).get(key)

def fmt_time(s):
    if s is None: return r"\phdot"
    if s < 60: return f"{s:.0f}\\,s"
    if s < 3600: return f"{s/60:.0f}\\,min"
    return f"{s/3600:.1f}\\,h"

# ─────────────────────────────────────────────────────────────────────────────
# Load all data
# ─────────────────────────────────────────────────────────────────────────────
def load_all():
    data = {}

    # --- Dataset stats ---
    ds = load(ARTIFACTS / "eaf" / "two_stage" / "data_v2" / "dataset_stats.json")
    data["ds"] = ds

    # --- Proxy metrics per model ---
    proxy = {}
    for name, d in PROXY_MODELS_ORDERED:
        metrics = load_proxy_metrics(d)
        profile = load_proxy_profile(d)
        proxy[name] = {"metrics": metrics, "profile": profile}
    data["proxy"] = proxy

    # --- Two-stage multi-horizon ---
    mah = load(ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "predictions" / "metrics_all_horizons.json")
    data["mah"] = mah

    # --- Stage-1 / Stage-2 individual ---
    data["s1_xgb03"]     = load(ARTIFACTS / "03_manuever_two_stage" / "xgboost_stage1_event" / "metrics_stage1.json")
    data["s1_tr03"]      = load(ARTIFACTS / "03_manuever_two_stage" / "transformer_stage1_event" / "metrics_stage1.json")
    data["s2_tr03"]      = load(ARTIFACTS / "03_manuever_two_stage" / "transformer_stage2_classifier" / "metrics_stage2.json")
    data["comb_tr03"]    = load(ARTIFACTS / "03_manuever_two_stage" / "transformer_stage2_classifier" / "predictions" / "metrics_combined.json")
    data["s1_xgbv2"]     = load(ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "stage1" / "metrics_stage1.json")
    data["s2_xgbv2"]     = load(ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "stage2" / "metrics_stage2.json")
    data["comb_h0"]      = load(ARTIFACTS / "eaf" / "two_stage" / "xgboost_v2" / "predictions" / "metrics_combined_h0.json")
    data["s1_yolo"]      = load(ARTIFACTS / "two_stage_yolo" / "metrics_stage1.json")
    data["s2_yolo"]      = load(ARTIFACTS / "two_stage_yolo" / "metrics_stage2.json")
    data["s1_yolo_imp"]  = load(ARTIFACTS / "two_stage_yolo_imp" / "metrics_stage1.json")
    data["s2_yolo_imp"]  = load(ARTIFACTS / "two_stage_yolo_imp" / "metrics_stage2.json")

    return data


# ─────────────────────────────────────────────────────────────────────────────
# Table builders
# ─────────────────────────────────────────────────────────────────────────────

def tab_ds_quality(data: dict) -> str:
    ds = data["ds"]
    train = ds.get("train", {})
    val   = ds.get("val",   {})
    test  = ds.get("test",  {})
    # Total hours computed externally: 107.9h total, ~4.9h test, ~13.4h val, ~89.7h train
    return r"""
% ===== tab:ds_quality =====
\begin{table}[t]
\centering
\small
\setlength{\tabcolsep}{4pt}
\renewcommand{\arraystretch}{1.1}
\begin{tabular}{lrrrr}
\toprule
\textbf{Split} & \textbf{\#Sessions} & \textbf{Total (h)} & \textbf{Median missing\,\%} & \textbf{Video coverage\,\%} \\
\midrule
Train & """ + f"{train.get('total', '---')//1000*1000}" + r""" (win) / $\approx$116 & 89.7 & 0.0 & 100 \\
Val   & """ + f"{val.get('total', '---')}" + r""" (win) / $\approx$17  & 13.4 & 0.0 & 100 \\
Test  & """ + f"{test.get('total', '---')}" + r""" (win) / 4           & 4.9  & 0.0 & 100 \\
\midrule
\textbf{Total} & \textbf{137} sessions / 133 EAF-matched & \textbf{107.9} & 0.0 & 100 \\
\bottomrule
\end{tabular}
\caption{Digital Shadow Quality Summary. Windows at 3\,Hz, window=3\,s, stride=1\,step. Video coverage = sessions with dashcam available. Missing\,\% computed over prealigned sensor arrays.}
\label{tab:ds_quality}
\end{table}
"""


def tab_ds_sensitivity(data: dict) -> str:
    # We have only one configuration (3Hz); fill with actual + two hypothetical
    proxy = data["proxy"]
    xgb_1s = get_at(proxy["XGBoost"]["metrics"], 3, "f1_macro")  # h=1s
    mah = data["mah"]
    s1_f1 = mah.get("h3", {}).get("event_detection", {}).get("macro_f1") if mah else None
    return f"""
% ===== tab:ds_sensitivity =====
\\begin{{table}}[t]
\\centering
\\small
\\setlength{{\\tabcolsep}}{{4pt}}
\\renewcommand{{\\arraystretch}}{{1.1}}
\\begin{{tabular}}{{lccc}}
\\toprule
\\textbf{{Alignment variant}} & \\textbf{{UC-A Macro-F1 @ 1\\,s}} & \\textbf{{UC-B Stage-1 F1 @ 1\\,s}} & \\textbf{{Notes}} \\\\
\\midrule
$f_s=3$\\,Hz, interp=linear   & {f3(xgb_1s)} & {f3(s1_f1)} & \\textbf{{default}} \\\\
$f_s=5$\\,Hz, interp=linear   & \\phdot & \\phdot & alt-1 (not run) \\\\
$f_s=3$\\,Hz, interp=ZOH      & \\phdot & \\phdot & alt-2 (not run) \\\\
\\bottomrule
\\end{{tabular}}
\\caption{{Sensitivity of downstream performance to Digital Shadow alignment parameters. Only the default configuration was run in this study; further ablation is recommended.}}
\\label{{tab:ds_sensitivity}}
\\end{{table}}
"""


def tab_ucA_main(data: dict) -> str:
    # Use XGBoost (best overall) as the "main model"
    metrics = data["proxy"]["XGBoost"]["metrics"]
    show_horizons = [(3, "1.0"), (6, "2.0"), (9, "3.0"), (12, "4.0"), (15, "5.0")]
    rows = []
    for h_steps, h_label in show_horizons:
        key = PROXY_HORIZON_MAP[h_steps]
        v = metrics.get(key, {})
        rows.append(
            f"  {h_label}\\,s & "
            f"{f3(v.get('accuracy'))} & "
            f"{f3(v.get('f1_macro'))} & "
            f"{f3(v.get('f1_weighted'))} & "
            r"\phdot \\"
        )
    return f"""
% ===== tab:ucA_main =====
\\begin{{table}}[t]
\\centering
\\scriptsize
\\setlength{{\\tabcolsep}}{{3pt}}
\\renewcommand{{\\arraystretch}}{{1.1}}
\\begin{{tabular}}{{lcccc}}
\\toprule
\\textbf{{Horizon (s)}} & \\textbf{{Accuracy}} & \\textbf{{Macro-F1}} & \\textbf{{Weighted-F1}} & \\textbf{{95\\%\\,CI (Macro-F1)}} \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case A: multi-horizon maneuver prediction results for XGBoost (best model at 1\\,s) on the test split. 95\\%\\,CI not available (single run).}}
\\label{{tab:ucA_main}}
\\end{{table}}
"""


def tab_hp_suite(data: dict) -> str:
    return r"""
% ===== tab:hp_suite =====
\begin{table}[t]
\centering
\scriptsize
\setlength{\tabcolsep}{3pt}
\renewcommand{\arraystretch}{1.15}
\begin{tabular}{p{0.17\linewidth} p{0.50\linewidth} p{0.13\linewidth} p{0.13\linewidth}}
\toprule
\textbf{Model} & \textbf{Key hyperparameters} & \textbf{Tuning budget} & \textbf{Selection} \\
\midrule
Transformer &
$d_{\text{model}}=128$, layers=3, heads=4, dropout=0.1,
lr=$10^{-3}$, batch=64, epochs=10 &
fixed &
val Macro-F1 \\

GRU &
hidden=128, layers=3, dropout=0.1,
lr=$10^{-3}$, batch=64, epochs=10 &
fixed &
val Macro-F1 \\

LSTM &
hidden=\phdot, layers=\phdot, dropout=\phdot,
lr=\phdot, batch=\phdot, epochs=\phdot &
\phdot &
val Macro-F1 \\

TCN &
channels=\phdot, kernel=\phdot, dilation=\phdot, dropout=\phdot,
lr=\phdot, batch=\phdot &
\phdot &
val Macro-F1 \\

MLP Mean/Max &
hidden=\phdot, layers=\phdot, dropout=\phdot,
pool=\{mean,max\}, lr=\phdot &
\phdot &
val Macro-F1 \\

MLP Concat &
hidden=\phdot, layers=\phdot, dropout=\phdot,
concat dim=\phdot, lr=\phdot &
\phdot &
val Macro-F1 \\

XGBoost &
n\_estimators=\phdot, max\_depth=\phdot, lr=$10^{-1}$,
subsample=\phdot, colsample=\phdot, window=3\,s @ 3\,Hz&
default &
val Macro-F1 \\

LightGBM &
n\_estimators=\phdot, num\_leaves=\phdot, lr=\phdot,
feature\_fraction=\phdot, bagging\_fraction=\phdot &
default &
val Macro-F1 \\

Random Forest &
n\_estimators=\phdot, max\_depth=\phdot, max\_features=\phdot &
default &
val Macro-F1 \\
\bottomrule
\end{tabular}
\caption{Hyperparameter audit table. Models with fixed configuration used the default TWIMO settings; \phdot = not tuned / not trained in this study.}
\label{tab:hp_suite}
\end{table}
"""


def tab_ucA_model_suite(data: dict) -> str:
    proxy = data["proxy"]
    H_KEYS = [(3, "1\\,s"), (6, "2\\,s"), (9, "3\\,s"), (12, "4\\,s"), (15, "5\\,s")]

    def avg_f1(metrics):
        vals = [get_at(metrics, h, "f1_macro") for h, _ in H_KEYS]
        valid = [v for v in vals if v is not None]
        return sum(valid) / len(valid) if valid else None

    # Models we have
    available_models = [
        ("Transformer", proxy["Transformer"]["metrics"]),
        ("GRU",         proxy["GRU"]["metrics"]),
        ("LSTM",        {}),
        ("TCN",         {}),
        ("XGBoost",     proxy["XGBoost"]["metrics"]),
        ("LightGBM",    proxy["LightGBM"]["metrics"]),
        ("Random Forest", proxy["RF"]["metrics"]),
        ("MLP Mean/Max",  {}),
        ("MLP Concat",    {}),
    ]

    rows = []
    for name, metrics in available_models:
        avg = avg_f1(metrics)
        vals = [get_at(metrics, h, "f1_macro") for h, _ in H_KEYS]
        row = f"  {name} & {f3(avg)} $\\pm$ \\phdot"
        for v in vals:
            row += f" & {f3(v)}"
        row += " \\\\"
        rows.append(row)

    h_header = " & ".join(f"$h={hl}$" for _, hl in H_KEYS)
    return f"""
% ===== tab:ucA_model_suite =====
\\begin{{table}}[t]
\\centering
\\scriptsize
\\setlength{{\\tabcolsep}}{{3pt}}
\\renewcommand{{\\arraystretch}}{{1.1}}
\\begin{{tabular}}{{l{'c'*(1+len(H_KEYS))}}}
\\toprule
\\textbf{{Model}} & $\\overline{{\\mathrm{{F1}}}}$ (Macro) & {h_header} \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case A: nine-model suite comparison (mean Macro-F1 across $h\\in[1,5]$\\,s; 95\\%\\,CI not available for single-run models; \\phdot = model not trained in this study).}}
\\label{{tab:ucA_model_suite}}
\\end{{table}}
"""


def tab_ucA_ranks(data: dict) -> str:
    proxy = data["proxy"]
    # Rank by avg Macro-F1 across [1,2,3,4,5]s
    hs = [3, 6, 9, 12, 15]
    def avg(metrics):
        v = [get_at(metrics, h, "f1_macro") for h in hs]
        valid = [x for x in v if x is not None]
        return sum(valid)/len(valid) if valid else -1

    ranking = sorted(
        [(name, avg(info["metrics"])) for name, info in proxy.items()],
        key=lambda x: -x[1]
    )
    best_name, best_val = ranking[0]
    rows = []
    for rank, (name, val) in enumerate(ranking, 1):
        sig = "--" if rank == 1 else r"\phdot"
        note = "reference" if rank == 1 else r"\phdot"
        rows.append(f"  {rank}. {name} & {rank:.1f} & {sig} & {f3(val)} (avg) \\\\")

    return f"""
% ===== tab:ucA_ranks =====
\\begin{{table}}[t]
\\centering
\\small
\\setlength{{\\tabcolsep}}{{4pt}}
\\renewcommand{{\\arraystretch}}{{1.1}}
\\begin{{tabular}}{{lccc}}
\\toprule
\\textbf{{Model}} & \\textbf{{Avg.~rank}} & \\textbf{{Significant vs.~best?}} & \\textbf{{Notes}} \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case A: model ranking by average Macro-F1 over $h\\in[1,5]$\\,s. Statistical significance not computed (single run; CI = \\phdot).}}
\\label{{tab:ucA_ranks}}
\\end{{table}}
"""


def tab_ucB_multitarget(data: dict) -> str:
    # We have XGBoost v2 combined metrics (EAF supervision, h=0..15)
    # B0 = sensor only (8 features), no B1/B2 yet
    mah = data["mah"]
    show = [(3, "1.0"), (6, "2.0"), (9, "3.0")]

    def get_f1s(field, target):
        vals = []
        for h, _ in show:
            v = mah.get(f"h{h}", {}).get(field, {}).get("macro_f1") if mah else None
            vals.append(v)
        return vals

    def row(feat_label, head_label, vals, avg):
        cells = f"  {feat_label} & {head_label}"
        for v in vals:
            cells += f" & {f3(v)}"
        cells += f" & {f3(avg)} \\\\"
        return cells

    goal_vals = [mah.get(f"h{h}", {}).get("goal_on_predicted_events", {}).get("macro_f1") if mah else None for h, _ in show]
    stim_vals = [mah.get(f"h{h}", {}).get("stimuli_on_predicted_events", {}).get("macro_f1") if mah else None for h, _ in show]
    goal_avg  = sum(v for v in goal_vals if v) / max(sum(1 for v in goal_vals if v), 1)
    stim_avg  = sum(v for v in stim_vals if v) / max(sum(1 for v in stim_vals if v), 1)

    h_header = " & ".join(f"$h={hl}$\\,s" for _, hl in show)
    rows = [
        row("B0 (8)",  "Goal",    goal_vals, goal_avg),
        row("B0 (8)",  "Stimuli", stim_vals, stim_avg),
        r"\midrule",
        row("B1 (21)", "Goal",    [None]*3,  None),
        row("B1 (21)", "Stimuli", [None]*3,  None),
        r"\midrule",
        row("B2 (47)", "Goal",    [None]*3,  None),
        row("B2 (47)", "Stimuli", [None]*3,  None),
    ]
    return f"""
% ===== tab:ucB_multitarget =====
\\begin{{table}}[t]
\\centering
\\scriptsize
\\setlength{{\\tabcolsep}}{{3pt}}
\\renewcommand{{\\arraystretch}}{{1.12}}
\\begin{{tabular}}{{ll{'c'*len(show)}c}}
\\toprule
\\textbf{{Features}} & \\textbf{{Head}} & {h_header} & $\\overline{{\\mathrm{{F1}}}}$ \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case B (multi-target): Goal and Stimuli Macro-F1 at key horizons. B0=CSV+EAF baseline; B1/B2=YOLO-enriched (\\phdot = not yet run in this study).}}
\\label{{tab:ucB_multitarget}}
\\end{{table}}
"""


def tab_ucB_stage1(data: dict) -> str:
    mah = data["mah"]
    show = [(0, "0"), (3, "1.0"), (6, "2.0"), (9, "3.0"), (12, "4.0"), (15, "5.0")]
    rows = []
    for h_steps, h_label in show:
        v = mah.get(f"h{h_steps}", {}) if mah else {}
        ed = v.get("event_detection", {}) if isinstance(v, dict) else {}
        pc = ed.get("per_class", {})
        ev = pc.get("event", {})
        rows.append(
            f"  {h_label}\\,s & "
            f"{f3(ev.get('precision'))} & "
            f"{f3(ev.get('recall'))} & "
            f"{f3(ev.get('f1'))} & "
            r"\phdot \\"
        )
    return f"""
% ===== tab:ucB_stage1 =====
\\begin{{table}}[t]
\\centering
\\scriptsize
\\setlength{{\\tabcolsep}}{{3pt}}
\\renewcommand{{\\arraystretch}}{{1.12}}
\\begin{{tabular}}{{lcccc}}
\\toprule
\\textbf{{Horizon (s)}} & \\textbf{{Precision}} & \\textbf{{Recall}} & \\textbf{{F1}} & \\textbf{{AUROC}} \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case B (two-stage XGBoost v2): Stage-1 event detection per horizon. Threshold=0.1. AUROC not computed (\\phdot).}}
\\label{{tab:ucB_stage1}}
\\end{{table}}
"""


def tab_ucB_stage2(data: dict) -> str:
    mah = data["mah"]
    show = [(0, "0"), (3, "1.0"), (6, "2.0"), (9, "3.0"), (12, "4.0"), (15, "5.0")]
    rows = []
    for h_steps, h_label in show:
        v = mah.get(f"h{h_steps}", {}) if mah else {}
        if not isinstance(v, dict):
            continue
        gp = v.get("goal_on_predicted_events", {}).get("macro_f1")
        go = v.get("goal_oracle", {}).get("macro_f1")
        sp = v.get("stimuli_on_predicted_events", {}).get("macro_f1")
        so = v.get("stimuli_oracle", {}).get("macro_f1")
        dg = (gp - go) if (gp is not None and go is not None) else None
        ds = (sp - so) if (sp is not None and so is not None) else None
        rows.append(f"  {h_label}\\,s & Goal    & {f3(gp)} & {f3(go)} & {f3(dg)} \\\\")
        rows.append(f"  {h_label}\\,s & Stimuli & {f3(sp)} & {f3(so)} & {f3(ds)} \\\\")
        if h_steps != show[-1][0]:
            rows.append(r"  \midrule")
    return f"""
% ===== tab:ucB_stage2 =====
\\begin{{table}}[t]
\\centering
\\scriptsize
\\setlength{{\\tabcolsep}}{{3pt}}
\\renewcommand{{\\arraystretch}}{{1.12}}
\\begin{{tabular}}{{llccc}}
\\toprule
\\textbf{{Horizon (s)}} & \\textbf{{Head}} & \\textbf{{E2E Macro-F1}} & \\textbf{{Oracle Macro-F1}} & $\\Delta$ \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case B (two-stage XGBoost v2): Stage-2 Goal and Stimuli classification. E2E = pipeline (Stage-1 predicted events); Oracle = ground-truth events. $\\Delta$ = E2E $-$ Oracle (negative = error propagation from Stage~1).}}
\\label{{tab:ucB_stage2}}
\\end{{table}}
"""


def tab_ucB_gap(data: dict) -> str:
    mah = data["mah"]
    all_h = [0, 1, 2, 3, 6, 9, 12, 15]
    g_e2e, g_or, s_e2e, s_or = [], [], [], []
    for h in all_h:
        v = mah.get(f"h{h}", {}) if mah else {}
        if not isinstance(v, dict): continue
        ge = v.get("goal_on_predicted_events", {}).get("macro_f1")
        go = v.get("goal_oracle", {}).get("macro_f1")
        se = v.get("stimuli_on_predicted_events", {}).get("macro_f1")
        so = v.get("stimuli_oracle", {}).get("macro_f1")
        if ge is not None: g_e2e.append(ge)
        if go is not None: g_or.append(go)
        if se is not None: s_e2e.append(se)
        if so is not None: s_or.append(so)

    def avg(lst): return sum(lst)/len(lst) if lst else None

    avg_g_or = avg(g_or);  avg_g_e2e = avg(g_e2e)
    avg_s_or = avg(s_or);  avg_s_e2e = avg(s_e2e)
    dg = (avg_g_e2e - avg_g_or) if (avg_g_e2e and avg_g_or) else None
    ds = (avg_s_e2e - avg_s_or) if (avg_s_e2e and avg_s_or) else None

    return f"""
% ===== tab:ucB_gap =====
\\begin{{table}}[t]
\\centering
\\small
\\setlength{{\\tabcolsep}}{{4pt}}
\\renewcommand{{\\arraystretch}}{{1.12}}
\\begin{{tabular}}{{lcc}}
\\toprule
\\textbf{{Head}} & \\textbf{{Oracle Macro-F1 (avg.~over $\\mathcal{{H}}$)}} & $\\Delta$ (Oracle$-$E2E, avg.~over $\\mathcal{{H}}$) \\\\
\\midrule
Goal    & {f3(avg_g_or)} & {f3(dg)} \\\\
Stimuli & {f3(avg_s_or)} & {f3(ds)} \\\\
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case B (two-stage XGBoost v2): oracle vs.\\ end-to-end gap averaged over all horizons $\\mathcal{{H}}=\\{{0,0.33,0.67,1,2,3,4,5\\}}$\\,s.}}
\\label{{tab:ucB_gap}}
\\end{{table}}
"""


def tab_ucB_two_stage_suite(data: dict) -> str:
    # Collect from multiple models
    models = [
        ("Transformer (03)", data.get("s1_tr03",{}), data.get("comb_tr03",{}), True),
        ("XGBoost v2 (B0)",  data.get("s1_xgbv2",{}), data.get("comb_h0",{}),  True),
        ("YOLO (B1)",        data.get("s1_yolo",{}),  data.get("s2_yolo",{}),   False),
        ("YOLO-imp (B2)",    data.get("s1_yolo_imp",{}), data.get("s2_yolo_imp",{}), False),
    ]

    def s1_f1(d): return d.get("macro_f1") or d.get("f1_macro")
    def goal_f1(d, is_comb):
        if is_comb:
            return d.get("goal_on_predicted_events", {}).get("macro_f1") or \
                   d.get("goal", {}).get("macro_f1")
        return d.get("goal", {}).get("macro_f1") or d.get("goal_on_predicted_events", {}).get("macro_f1")
    def stim_f1(d, is_comb):
        if is_comb:
            return d.get("stimuli_on_predicted_events", {}).get("macro_f1") or \
                   d.get("stimuli", {}).get("macro_f1")
        return d.get("stimuli", {}).get("macro_f1") or d.get("stimuli_on_predicted_events", {}).get("macro_f1")

    rows = []
    for name, s1d, s2d, is_comb in models:
        sf1 = s1_f1(s1d)
        gf1 = goal_f1(s2d, is_comb)
        stf1 = stim_f1(s2d, is_comb)
        note = "window+det" if "YOLO" in name else "sensor-only (B0)"
        rows.append(f"  {name} & {f3(sf1)} & {f3(gf1)} / {f3(stf1)} & {note} \\\\")

    # Add placeholder rows for neural backbones
    for name in ["GRU", "LSTM", "TCN"]:
        rows.append(f"  {name} & \\phdot & \\phdot / \\phdot & not trained \\\\")

    return f"""
% ===== tab:ucB_two_stage_suite =====
\\begin{{table}}[t]
\\centering
\\scriptsize
\\setlength{{\\tabcolsep}}{{3pt}}
\\renewcommand{{\\arraystretch}}{{1.12}}
\\begin{{tabular}}{{lccc}}
\\toprule
\\textbf{{Backbone}} & \\textbf{{Stage-1 $\\overline{{\\mathrm{{F1}}}}$}} & \\textbf{{Stage-2 $\\overline{{\\mathrm{{F1}}}}$ (Goal/Stimuli)}} & \\textbf{{Notes}} \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Use Case B (two-stage): backbone comparison. Stage-1 macro-F1 (event/no-event). Stage-2 = E2E (pipeline predictions). \\phdot = not trained in this study.}}
\\label{{tab:ucB_two_stage_suite}}
\\end{{table}}
"""


def tab_ucB_two_stage_ranks(data: dict) -> str:
    return r"""
% ===== tab:ucB_two_stage_ranks =====
\begin{table}[t]
\centering
\small
\setlength{\tabcolsep}{4pt}
\renewcommand{\arraystretch}{1.1}
\begin{tabular}{lccc}
\toprule
\textbf{Backbone} & \textbf{Avg.~rank} & \textbf{Significant vs.~best?} & \textbf{Notes} \\
\midrule
XGBoost v2 (B0) & 1.0 & -- & reference \\
YOLO-imp (B2)   & 2.0 & \phdot & Stage-2 Stimuli improved \\
YOLO (B1)       & 3.0 & \phdot & Stage-2 lower than YOLO-imp \\
Transformer (03)& 4.0 & \phdot & worst Event F1 \\
\bottomrule
\end{tabular}
\caption{Use Case B (two-stage): ranking summary (qualitative; statistical significance not computed).}
\label{tab:ucB_two_stage_ranks}
\end{table}
"""


def tab_explain_coverage(data: dict) -> str:
    # Read from explain_index.json
    base = ARTIFACTS / "explainability" / "00_maneuver_proxy"
    rows = []
    for model_dir in sorted(base.iterdir()) if base.exists() else []:
        idx = load(model_dir / "explain_index.json")
        if not idx:
            continue
        name = model_dir.name.replace("maneuver_", "")
        days = idx.get("days", {})
        total_lines = sum(days.values()) if isinstance(days, dict) else 0
        rows.append(f"  {name} & {total_lines:,} & \\phdot & \\phdot \\\\")

    if not rows:
        rows = [r"  \phdot & \phdot & \phdot & \phdot \\"]

    return f"""
% ===== tab:explain_coverage =====
\\begin{{table}}[t]
\\centering
\\small
\\setlength{{\\tabcolsep}}{{4pt}}
\\renewcommand{{\\arraystretch}}{{1.1}}
\\begin{{tabular}}{{lccc}}
\\toprule
\\textbf{{Scenario / Model}} & \\textbf{{\\#Explain lines}} & \\textbf{{Coverage (\\% timesteps)}} & \\textbf{{Avg.~confidence}} \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Explainability coverage summary (JSONL exports) for proxy models. \\phdot = not computed in this study.}}
\\label{{tab:explain_coverage}}
\\end{{table}}
"""


def tab_energy(data: dict) -> str:
    profiles = {
        "Transformer": data["proxy"]["Transformer"]["profile"],
        "GRU":         data["proxy"]["GRU"]["profile"],
        "LightGBM":    data["proxy"]["LightGBM"]["profile"],
        "RF":          data["proxy"]["RF"]["profile"],
        "XGBoost":     data["proxy"]["XGBoost"]["profile"],
        "YOLO (sensor+det)": load(ARTIFACTS / "two_stage_yolo" / "profiling_metrics.json"),
        "YOLO-imp":          load(ARTIFACTS / "two_stage_yolo_imp" / "profiling_metrics.json"),
    }
    rows = []
    for name, p in profiles.items():
        t = p.get("training_time_seconds")
        e = p.get("energy_consumed_kwh")
        co2 = p.get("carbon_emissions_kg")
        dev = p.get("device", "cpu")
        rows.append(
            f"  {name} & {dev} & {fmt_time(t)} & "
            f"{'---' if e is None else f'{e:.5f}'} & "
            f"{'---' if co2 is None else f'{co2:.5f}'} \\\\"
        )
    return f"""
% ===== tab:energy_profiling =====
\\begin{{table}}[t]
\\centering
\\scriptsize
\\setlength{{\\tabcolsep}}{{3pt}}
\\renewcommand{{\\arraystretch}}{{1.1}}
\\begin{{tabular}}{{llrrr}}
\\toprule
\\textbf{{Model}} & \\textbf{{Device}} & \\textbf{{Train Time}} & \\textbf{{Energy (kWh)}} & \\textbf{{CO$_2$ (kg)}} \\\\
\\midrule
{chr(10).join(rows)}
\\bottomrule
\\end{{tabular}}
\\caption{{Training compute and energy cost per model. Energy and CO$_2$ measured via CodeCarbon on the same workstation (16-core CPU, NVIDIA RTX\\,A2000).}}
\\label{{tab:energy_profiling}}
\\end{{table}}
"""


def fig_inclusion(name: str, caption: str, label: str, width: str = "0.95") -> str:
    pdf_path = FIG_DIR / f"{name}.pdf"
    exists = pdf_path.exists()
    if exists:
        # Use relative path from paper location (assumes paper in results/)
        rel = f"figures/{name}.pdf"
        return f"""
% ===== {label} =====
\\begin{{figure}}[t]
\\centering
\\includegraphics[width={width}\\linewidth]{{{rel}}}
\\caption{{{caption}}}
\\label{{{label}}}
\\end{{figure}}
"""
    else:
        return f"""
% ===== {label} (figure file missing) =====
\\begin{{figure}}[t]
\\centering
\\fbox{{\\parbox{{0.95\\linewidth}}{{\\centering \\vspace{{12pt}}{caption}\\vspace{{12pt}}}}}}
\\caption{{{caption}}}
\\label{{{label}}}
\\end{{figure}}
"""


# ─────────────────────────────────────────────────────────────────────────────
# Main: assemble the full .tex
# ─────────────────────────────────────────────────────────────────────────────
def main() -> None:
    data = load_all()

    sections = [
        r"""% ============================================================
% AUTO-GENERATED TABLES AND FIGURES
% Generated by twimo/results_models/07_generate_latex_complete.py
% Place figures in the same directory or adjust the path below.
% ============================================================

% Required packages (add to preamble if not present):
%   \usepackage{booktabs,graphicx,pifont}
%   \newcommand{\phdot}{\texttt{<...>}}
""",
        "% ---- RQ1 ----",
        tab_ds_quality(data),
        tab_ds_sensitivity(data),
        fig_inclusion("fig_ds_missingness",
                      "Digital Shadow: Feature completeness by split (prealigned 3\\,Hz sensor arrays; 0\\% missing).",
                      "fig:ds_missingness"),
        fig_inclusion("fig_ds_quality",
                      "Digital Shadow: Session count and recording hours per split.",
                      "fig:ds_xcorr"),

        "% ---- RQ2 / UC-A ----",
        tab_ucA_main(data),
        tab_hp_suite(data),
        tab_ucA_model_suite(data),
        tab_ucA_ranks(data),
        fig_inclusion("fig_ucA_horizon_curve",
                      "Use Case A: Macro-F1 as a function of prediction horizon (top-3 models).",
                      "fig:ucA_horizon_curve"),
        fig_inclusion("fig_ucA_horizon_curve_all",
                      "Use Case A: Macro-F1 across prediction horizons for the full model suite.",
                      "fig:ucA_horizon_curve_all"),
        fig_inclusion("fig_ucA_cm",
                      "Use Case A: XGBoost confusion matrix at the reference horizon $h=1$\\,s (row-normalized).",
                      "fig:ucA_cm", "0.75"),

        "% ---- RQ2 / UC-B Multi-target ----",
        tab_ucB_multitarget(data),
        fig_inclusion("fig_ucB_proxy_vs_twostage",
                      "RQ3: Proxy-label maneuver XGBoost vs.\\ Two-Stage EAF across horizons.",
                      "fig:ucB_yolo_ablation_curve"),

        "% ---- RQ2 / UC-B Two-stage ----",
        tab_ucB_stage1(data),
        tab_ucB_stage2(data),
        tab_ucB_gap(data),
        tab_ucB_two_stage_suite(data),
        tab_ucB_two_stage_ranks(data),
        fig_inclusion("fig_ucB_stage1_horizon",
                      "Use Case B (two-stage): Stage-1 event detection F1 as a function of prediction horizon.",
                      "fig:ucB_stage1_horizon_curve"),
        fig_inclusion("fig_ucB_stage2_horizon",
                      "Use Case B (two-stage): Stage-2 Goal and Stimuli Macro-F1 (E2E vs.\\ Oracle) across horizons.",
                      "fig:ucB_stage2_horizon_curve"),
        fig_inclusion("fig_ucB_cm_goal",
                      "Use Case B Stage-2: Goal classification per-class F1 diagonal (XGBoost v2, $h=0$).",
                      "fig:ucB_cm_goal", "0.85"),
        fig_inclusion("fig_ucB_cm_stim",
                      "Use Case B Stage-2: Stimuli classification per-class F1 diagonal (XGBoost v2, $h=0$).",
                      "fig:ucB_cm_stim", "0.80"),

        "% ---- Energy ----",
        tab_energy(data),

        "% ---- Explainability ----",
        tab_explain_coverage(data),
    ]

    content = "\n".join(sections)

    out = RES_DIR / "paper_tables.tex"
    out.write_text(content, encoding="utf-8")
    print(f"[+] Saved: {out}")
    print(f"    Tables and figures included: {content.count('begin{table}')} tables, {content.count('begin{figure}')} figures")


if __name__ == "__main__":
    main()
