# twimo/results — Paper Results Extraction

Scripts that read `artifacts/` outputs and produce ready-to-use
**CSV tables**, **LaTeX `.tex` snippets**, and **publication figures**
for Section 5.4 of the paper.

Results are saved to `artifacts_models/` (separate from the training artifacts).

All scripts are **self-contained** and **read-only** with respect to
the rest of the codebase (they only read JSON/NPY artifact files).

---

## Prerequisites

Run the full TWIMO pipeline first so that `artifacts/` is populated:

```bash
# 1. Scan sessions
python -m twimo.cli scan \
  --root example_data \
  --out artifacts/manifest.jsonl \
  --prealigned-sensors-dir twimo/assets/hdd_prealigned/20200710_sensors/sensor \
  --prealigned-labels-dir  twimo/assets/hdd_prealigned/20200710_labels/target

# 2. Train all models (Use Case A)
python -m twimo.run_scenarios --use-case A --all

# 3. Digital Twin simulation (Use Case C)
python -m twimo.run_scenarios --use-case C --all

# 4. Style clustering (Use Case D)
python -m twimo.run_scenarios --use-case D --all

# 5. Explanations (Use Case E)
python -m twimo.run_scenarios --use-case E --all

# 6. EAF pipeline (Use Case B) — optional, needed for RQ2-B tables
python -m twimo.run_scenarios --use-case B --all
```

---

## Quick start — extract everything at once

```bash
python -m twimo.results.run_all
```

Optional overrides:

```bash
python -m twimo.results.run_all \
  --artifacts-dir artifacts \
  --manifest      artifacts/manifest.jsonl \
  --prealigned-sensors-dir twimo/assets/hdd_prealigned/20200710_sensors/sensor \
  --sample-hz  3 \
  --ref-horizon 1.0 \
  --outdir     artifacts_models
```

At the end `run_all` prints a summary of all produced files and
the `\input{}` / `\includegraphics{}` paths for LaTeX.

---

## Per-script commands

### RQ1 — Digital Shadow reliability

#### `rq1_shadow_quality` — Tab. `ds_quality` + Fig. `ds_missingness`

```bash
python -m twimo.results.rq1_shadow_quality --artifacts-dir artifacts --outdir artifacts_models/rq1
```

Reads manifest + prealigned sensor `.npy` files. Produces:

| Output file | Paper artifact |
|---|---|
| `artifacts_models/rq1/ds_quality.csv` / `.tex` | Tab. `ds_quality` |
| `artifacts_models/rq1/ds_missingness.csv` / `.tex` | Tab. (missingness by group) |
| `artifacts_models/rq1/ds_missingness.png` | **Fig. `ds_missingness`** |

LaTeX usage:
```latex
\input{artifacts_models/rq1/ds_quality}
\input{artifacts_models/rq1/ds_missingness}

\begin{figure}[t]
  \centering
  \includegraphics[width=0.85\linewidth]{artifacts_models/rq1/ds_missingness.png}
  \caption{Digital Shadow missingness diagnostics by feature group.}
  \label{fig:ds_missingness}
\end{figure}
```

---

#### `rq1_shadow_xcorr` — Fig. `ds_xcorr`

```bash
python -m twimo.results.rq1_shadow_xcorr --artifacts-dir artifacts  --outdir artifacts_models/rq1

python -m twimo.results.rq1_shadow_xcorr --artifacts-dir artifacts --outdir artifacts_models/rq1 --prealigned-sensors-dir "artifacts/eaf/sensors_v2/sensor" --pair-indices "0,5:Steer→Yaw-rate" "2,4:Accel→Speed" "3,4:Brake→Speed"

python -m twimo.results.rq1_shadow_xcorr --manifest "artifacts/eaf/eaf_aligned/manifest_eaf_aligned.jsonl" --prealigned-sensors-dir "artifacts/eaf/sensors_v2/sensor" --outdir 
artifacts_models/rq1 --pair-indices "0,5:Steer-Yaw" "2,4:Accel-Speed" "3,4:Brake-Speed" 2>&1 | Select-Object -First 30

python -m twimo.results.rq1_xcorr_freq_sensitivity --sensor-dir artifacts/eaf/sensors_v2/sensor --outdir artifacts_models/rq1 --hz-levels 0.5 1.0 1.5 3.0

python -m twimo.results.rq1_xcorr_freq_sensitivity --sensor-dir artifacts/eaf/sensors_v2/sensor --outdir artifacts_models/rq1
```

Computes cross-correlation between correlated channel pairs
(speed↔accel, steering↔yaw-rate, brake↔decel).
Feature channels auto-detected from `feature_names.json` in any model dir.

| Output file | Paper artifact |
|---|---|
| `artifacts_models/rq1/ds_xcorr.csv` / `.tex` | Tab. `ds_xcorr` (peak lags) |
| `artifacts_models/rq1/ds_xcorr.png` | **Fig. `ds_xcorr`** |

LaTeX usage:
```latex
\input{artifacts_models/rq1/ds_xcorr}

\begin{figure}[t]
  \centering
  \includegraphics[width=\linewidth]{artifacts_models/rq1/ds_xcorr.png}
  \caption{Cross-correlation sanity checks between correlated channels.}
  \label{fig:ds_xcorr}
\end{figure}
```

---

#### `rq1_shadow_sensitivity` — Tab. `ds_sensitivity`

Requires re-running training at **different sampling frequencies** first:

```bash
# Train at 1 Hz and 5 Hz (in addition to the default 3 Hz)
python -m twimo.cli train-maneuver --manifest artifacts/manifest.jsonl --outdir   artifacts/maneuver_transformer_1hz --model transformer --sample-hz 1

python -m twimo.cli train-maneuver --manifest artifacts/manifest.jsonl --outdir   artifacts/maneuver_transformer_5hz --model transformer --sample-hz 5

# Then extract the sensitivity table
python -m twimo.results.rq1_shadow_sensitivity --model-dirs artifacts/00_maneuver_proxy/maneuver_transformer artifacts/maneuver_transformer_1hz artifacts/maneuver_transformer_5hz --labels "3 Hz (default)" "1 Hz" "5 Hz" --ref-horizon 1.0 --outdir artifacts_models/rq1
```

| Output file | Paper artifact |
|---|---|
| `artifacts_models/rq1/ds_sensitivity.csv` / `.tex` | Tab. `ds_sensitivity` |

LaTeX usage:
```latex
\input{artifacts_models/rq1/ds_sensitivity}
```

---

### RQ2-A — UC-A: Maneuver prediction

```bash
python -m twimo.results.rq2_uca \
  --artifacts-dir artifacts \
  --outdir artifacts_models/rq2_uca
```

Scans ALL `artifacts/00_maneuver_proxy/maneuver_*/` directories automatically.

| Output file | Paper artifact |
|---|---|
| `artifacts_models/rq2_uca/uca_main.csv` / `.tex` | Tab. `ucA_main` |
| `artifacts_models/rq2_uca/uca_baselines.csv` / `.tex` | Tab. `ucA_baselines` |
| `artifacts_models/rq2_uca/uca_all_models.csv` | Full cross-model data |
| `artifacts_models/rq2_uca/horizon_curve.png` | **Fig. `ucA_horizon_curve`** |
| `artifacts_models/rq2_uca/confusion_matrix_1.00s.png` | **Fig. `ucA_cm`** |

LaTeX usage:
```latex
\input{artifacts_models/rq2_uca/uca_main}
\input{artifacts_models/rq2_uca/uca_baselines}

\begin{figure}[t]
  \centering
  \includegraphics[width=0.8\linewidth]{artifacts_models/rq2_uca/horizon_curve.png}
  \caption{Use Case A: Macro-F1 as a function of prediction horizon.}
  \label{fig:ucA_horizon_curve}
\end{figure}

\begin{figure}[t]
  \centering
  \includegraphics[width=0.55\linewidth]{artifacts_models/rq2_uca/confusion_matrix_1.00s.png}
  \caption{Use Case A: confusion matrix at the reference horizon (1.0 s).}
  \label{fig:ucA_cm}
\end{figure}
```

Change reference horizon (e.g., 2.0 s):
```bash
python -m twimo.results.rq2_uca --artifacts-dir artifacts --ref-horizon 2.0 --outdir artifacts_models/rq2_uca
```

---

### RQ2-B — UC-B: EAF event detection

```bash
python -m twimo.results.rq2_ucb \
  --artifacts-dir artifacts \
  --outdir artifacts_models/rq2_ucb
```

Auto-searches `artifacts/eaf_two_stage/` and `artifacts/eaf_yolo/`
for `evaluation_results.json`. If Use Case B has not been run yet,
**placeholder** tables are generated and a warning is shown.

| Output file | Paper artifact |
|---|---|
| `artifacts_models/rq2_ucb/ucb_stage1.csv` / `.tex` | Tab. `ucB_stage1` |
| `artifacts_models/rq2_ucb/ucb_stage2.csv` / `.tex` | Tab. `ucB_stage2` |
| `artifacts_models/rq2_ucb/ucb_gap.csv` / `.tex` | Tab. `ucB_gap` |
| `artifacts_models/rq2_ucb/ucb_pr_curve.png` | **Fig. `ucB_pr`** |
| `artifacts_models/rq2_ucb/ucb_cm_goal.png` | **Fig. `ucB_cm_goal`** |
| `artifacts_models/rq2_ucb/ucb_cm_stimuli.png` | **Fig. `ucB_cm_stim`** |

LaTeX usage:
```latex
\input{artifacts_models/rq2_ucb/ucb_stage1}
\input{artifacts_models/rq2_ucb/ucb_stage2}
\input{artifacts_models/rq2_ucb/ucb_gap}

\begin{figure}[t]
  \centering
  \includegraphics[width=0.7\linewidth]{artifacts_models/rq2_ucb/ucb_pr_curve.png}
  \caption{Use Case B Stage-1: Precision--Recall curve.}
  \label{fig:ucB_pr}
\end{figure>
```

> **Note on Oracle evaluation**: the `ucb_gap` table requires an oracle
> evaluation (Stage-2 evaluated on ground-truth event windows). This is
> currently not implemented in the EAF pipeline CLI. When available,
> save the oracle evaluation as `evaluation_results_oracle.json` in the
> same directory as the standard evaluation file.

---

### RQ3 — Framework validation

```bash
python -m twimo.results.rq3_checklist \
  --artifacts-dir artifacts \
  --outdir artifacts_models/rq3
```

| Output file | Paper artifact |
|---|---|
| `artifacts_models/rq3/artifact_checklist.csv` / `.tex` | Tab. `artifact_checklist` |
| `artifacts_models/rq3/reuse_map.tex` | Tab. `reuse_map` (static) |
| `artifacts_models/rq3/scenario_block_mapping.tex` | Tab. `scenario_block_mapping` (static) |

LaTeX usage:
```latex
\input{artifacts_models/rq3/artifact_checklist}
\input{artifacts_models/rq3/reuse_map}
\input{artifacts_models/rq3/scenario_block_mapping}
```

---

## Output directory layout

```
artifacts/              <- pipeline outputs (train, simulate, style, explain)
│   maneuver_*/
│   dt_*/
│   style/
│   explain/
│   manifest.jsonl
│
artifacts_models/       <- results extraction outputs (this module)
├── rq1/
│   ├── ds_quality.csv / .tex
│   ├── ds_missingness.csv / .tex / .png     <- Fig. ds_missingness
│   ├── ds_xcorr.csv / .tex / .png           <- Fig. ds_xcorr
│   ├── ds_xcorr_sessions.csv                <- raw per-session xcorr data
│   ├── ds_sensitivity.csv / .tex
│   ├── ds_sensitivity_delta.csv / .tex
│   └── ds_sessions_raw.csv                  <- raw per-session quality data
│
├── rq2_uca/
│   ├── uca_main.csv / .tex
│   ├── uca_baselines.csv / .tex
│   ├── uca_all_models.csv
│   ├── horizon_curve.png                    <- Fig. ucA_horizon_curve
│   └── confusion_matrix_<h>s.png            <- Fig. ucA_cm
│
├── rq2_ucb/
│   ├── ucb_stage1.csv / .tex
│   ├── ucb_stage2.csv / .tex
│   ├── ucb_gap.csv / .tex
│   ├── ucb_pr_curve.png                     <- Fig. ucB_pr
│   ├── ucb_cm_stage1.png
│   ├── ucb_cm_goal.png                      <- Fig. ucB_cm_goal
│   └── ucb_cm_stimuli.png                   <- Fig. ucB_cm_stim
│
└── rq3/
    ├── artifact_checklist.csv / .tex
    ├── reuse_map.csv / .tex
    └── scenario_block_mapping.csv / .tex
```

---

## Confidence intervals (95% CI)

The scripts report **point estimates** by default.
To obtain 95% CI via bootstrap over multiple seeds:

```bash
# Train multiple seeds (example: 3 seeds)
for seed in 0 1 2; do
  python -m twimo.cli train-maneuver \
    --manifest artifacts/manifest.jsonl \
    --outdir   artifacts/maneuver_transformer_seed${seed} \
    --model transformer
done

# The aggregate script picks up all maneuver_* dirs automatically
python -m twimo.results.rq2_uca --artifacts-dir artifacts --outdir artifacts_models/rq2_uca
```

CI in `uca_main.tex` will be populated when `session_metrics` per seed
are available. The current `test_metrics.json` stores global metrics only;
bootstrap CI requires per-session predictions which can be derived by
running evaluation on individual session subsets.

---

## Troubleshooting

| Issue | Fix |
|---|---|
| `No sensor arrays found` | Run `scan` with `--prealigned-sensors-dir` first |
| `No model dirs found` | Run `train-maneuver` for at least one model |
| `EAF evaluation_results.json not found` | Run Use Case B pipeline; placeholder tables are output |
| `Feature names not found` | Pass `--feature-names artifacts/maneuver_transformer/feature_names.json` |
| Figures not produced | Install matplotlib: `pip install matplotlib` |
