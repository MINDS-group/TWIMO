# TWIMO — CLI Reference

Command-line reference for TWIMO and related tools.
For the programmatic Python API (TwimoRunner), see [README.md](README.md).

---

## Installation

### Requirements
- Python **3.10 or newer**
- `ffmpeg` (only needed for video features)
- Optional: NVIDIA GPU for faster training

### Setup

```bash
python -m venv .venv
.\.venv\Scripts\activate      # Windows
source .venv/bin/activate     # Linux/Mac
pip install -r requirements.txt
```

### Windows: ffmpeg Setup (Optional)

Only needed if you want to use video features (`--use-video`):

1. Download ffmpeg for Windows
2. Add the `bin` folder to System PATH
3. Restart terminal and verify: `ffmpeg -version`

---

## Configuration

All settings are in `config.yaml` at the project root. Update paths to point to your data:

```yaml
data_dir: "example_data"              # Folder with HDD sessions
video_dir: "example_data"             # Folder with videos (optional)
artifacts_dir: "artifacts"
manifest_file: "artifacts/manifest.jsonl"
max_sessions: null                    # null = use all sessions
```

---

## Data Structure

```
<data_dir>/
  <scenario>/                    # Example: 2017_02_27_ITS1
    <session_id>/                # Example: 201702271017
      general/csv/
        vel.csv                  # Velocity
        accel_pedal.csv          # Accelerator pedal
        brake_pedal.csv          # Brake pedal
        steer.csv                # Steering angle
      rtk/                       # GPS data (for Digital Twin validation)
        rtk_pos.csv              # GPS position (lng, lat)
        rtk_track.csv            # GPS heading
      camera/center/             # Videos (optional, for video features)
        *.mp4
```

**Heuristic Labels** (auto-generated when ground-truth is not available):

| Class | Label | Condition |
|-------|-------|-----------|
| 0 | STRAIGHT | Default |
| 1 | TURN_LEFT | Steering angle < -3.0° |
| 2 | TURN_RIGHT | Steering angle > 3.0° |
| 3 | BRAKE | Brake pressure > 20.0 kPa |
| 4 | ACCEL | Accelerator pedal > 20.0% |
| 5 | STOP | Velocity < 0.5 km/h |

Priority (highest → lowest): STOP > BRAKE/ACCEL > TURN_LEFT/TURN_RIGHT > STRAIGHT.

See [twimo/data/README.md](twimo/data/README.md) for details.

---

## Pipeline A: Proxy Labels (Heuristic)

Use when ground-truth EAF annotations are not available.

### Step 1: Build Manifest

```bash
python -m twimo.cli scan --root ./example_data --out ./artifacts/manifest.jsonl
```

### Step 2: Train Maneuver Prediction

**Template** (replace `MODEL` and `OUTDIR`):
```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/00_maneuver_proxy/OUTDIR \
  --model MODEL \
  --sample-hz 3 \
  [--epochs 10]          # neural models only
  [--use-video]          # optional: add camera features
  [--video-extractor mobilenet_v3_small]
```

**Available models:**

| Model | Speed | Notes |
|-------|-------|-------|
| `transformer` | Slow | Best accuracy; GPU recommended |
| `xgboost` | Fast | Excellent; CPU-friendly ⭐ |
| `lightgbm` | Very fast | Memory efficient |
| `gru` / `lstm` | Medium | Recurrent, sequential patterns |
| `tcn` | Medium | Parallelizable convolutions |
| `random_forest` | Fast | Robust, interpretable |
| `mlp_mean` / `mlp_max` / `mlp_concat` | Fast | Simple baselines |
| `baseline` | Fast | Auto-selects XGBoost or RF |

See [twimo/models/MODELS_OVERVIEW.md](twimo/models/MODELS_OVERVIEW.md) for detailed comparison.

**Outputs** in `--outdir`:
- `model.pth` or `model.joblib` (trained model)
- `test_metrics.json` (accuracy, F1-score, etc.)
- `config.json` (model configuration)

### Step 3: Plot Results

```bash
python twimo/plots/maneuver_plots_log.py \
  ./artifacts/00_maneuver_proxy/maneuver_transformer/test_metrics.json \
  ./artifacts/00_maneuver_proxy/maneuver_transformer/plots

python twimo/plots/plot_roc_curves.py \
  --roc-json ./artifacts/00_maneuver_proxy/maneuver_transformer/roc_curves.json \
  --outdir ./artifacts/00_maneuver_proxy/maneuver_transformer/plots/roc_plots \
  --splits test
```

### Step 4: Digital Twin Simulation

**Standard DT** (baseline, ~2000-3000 m RMSE):
```bash
python -m twimo.cli simulate-dt \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/dt/dt_eval \
  --sample-hz 3 --wheelbase 2.7
```

**Optimized DT** (10-100× better, ~20-200 m RMSE):
```bash
python -m twimo.cli simulate-dt-optimized \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/dt/dt_optimized \
  --sample-hz 3
```

Key options for optimized DT:
- `--no-calibrate` — skip auto-calibration, use fixed parameters
- `--no-reset` — disable GPS drift reset (open-loop simulation)
- `--reset-interval 60` — change reset step interval (default: 30)
- `--save-traj` — save per-session trajectory CSVs

**Outputs**: `dt_optimized_summary.json`, `dt_optimized_aggregated_metrics.json`.

See [twimo/dt/README.md](twimo/dt/README.md) for details.

### Step 5: Driving Style Clustering

```bash
python -m twimo.cli train-style \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/style/proxy \
  --sample-hz 3 --k 3
```

### Step 6: Explainability

```bash
python -m twimo.cli explain \
  --manifest ./artifacts/manifest.jsonl \
  --modeldir ./artifacts/00_maneuver_proxy/maneuver_transformer \
  --outdir ./artifacts/explainability/maneuver_transformer \
  --explain-every-steps 50
```

---

## Pipeline B: EAF Ground-Truth Labels

Use when human-annotated EAF files from ELAN are available.

### Single-Target Workflow

#### 1. Parse EAF Files

```bash
python twimo/strategies_eaf/parse_eaf.py \
  --eaf-dir ./assets/hdd_prealigned/20200710_EAF \
  --output ./artifacts/eaf/parsed
```

#### 2. Build Vocabulary

```bash
python twimo/strategies_eaf/build_vocab.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --output ./artifacts/vocab_eaf.json
```

#### 3. Align EAF to Sensors

```bash
python twimo/strategies_eaf/align_eaf_to_sensors.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab ./artifacts/vocab_eaf.json \
  --manifest ./artifacts/manifest.jsonl \
  --output-dir ./artifacts/eaf/eaf_aligned \
  --sample-hz 3
```

#### 4. Train and Evaluate

```bash
# Train (use any --model from table above)
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/eaf/eaf_aligned/manifest_eaf_aligned.jsonl \
  --outdir ./artifacts/01_maneuver_eaf/maneuver_eaf_transformer \
  --model transformer --sample-hz 3 --epochs 10

# Evaluate against EAF ground-truth
python twimo/strategies_eaf/evaluate_eaf.py \
  --model-dir ./artifacts/01_maneuver_eaf/maneuver_eaf_transformer \
  --manifest ./artifacts/eaf/eaf_aligned/manifest_eaf_aligned.jsonl \
  --vocab ./artifacts/vocab_eaf.json \
  --output-dir ./artifacts/eaf/eval_eaf_transformer \
  --sample-hz 3
```

---

### Multi-Target Workflow

Enables **Goal + Stimuli prediction** with Area/Event/Cause/Attention as input features.

| Tier | Role | Example |
|------|------|---------|
| **Goal** | Target (maneuver) | `left_turn`, `right_turn` |
| **Stimuli** | Target (external trigger) | `traffic_light`, `pedestrian` |
| Area / Event / Cause / Attention | Input features | Context for the maneuver |

#### 1. Parse EAF Files

```bash
python twimo/strategies_eaf/parse_eaf.py \
  --eaf-dir ./assets/hdd_prealigned/20200710_EAF \
  --output ./artifacts/eaf/parsed
```

#### 2. Build All Vocabularies

```bash
python twimo/strategies_eaf/build_all_vocabs.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --output-dir ./artifacts/eaf/vocabs
```

#### 3. Generate Prealigned Sensor Arrays

> Skip if you already have prealigned `.npy` arrays in `./assets/hdd_prealigned/`.

```bash
python twimo/data/generate_sensor_npy.py \
  --manifest ./artifacts/manifest.jsonl \
  --outdir ./artifacts/eaf/sensors_v2 \
  --sample-hz 3
```

#### 4. Align EAF to Sensors (Multi-Target)

```bash
python -m twimo.strategies_eaf.align_eaf_to_sensors_multitarget_simple \
  --hdd-root F:/TWIMO/CASE-STUDY/hdd_data/release_2019_07_08 \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --output-dir ./artifacts/eaf/sensors_v2
```

**Outputs**:
- `sensor/<SESSION_ID>.npy` — sensor features (T, D)
- `target_goal/<SESSION_ID>.npy` — Goal labels (T,)
- `target_stimuli/<SESSION_ID>.npy` — Stimuli labels (T,)

---

## Pipeline C: Two-Stage Event-Centric (RECOMMENDED)

Solves the severe class imbalance (~85-95% of frames have no event). Uses a two-stage design:

- **Stage 1 (EventNet)**: binary detector — event vs no-event
- **Stage 2 (ClassifyNet)**: multi-task classifier — Goal + Stimuli (on event windows only)

### Pipeline Family Overview

| Script | Models | YOLO | Strategies | Use case |
|--------|--------|------|------------|----------|
| `two_stage_multi_model.py` | All | No | — | Sensors only (C1) |
| `two_stage_yolo_improved_multi_model.py` | All | Optional | 1a/1b/2/3/4/5/6/7 | Main ablation (C2/C3/C4) |
| `two_stage_yolo_improved.py` | Transformer | Optional | same | Transformer-only variant |
| `two_stage_transformer.py` | Transformer | No | — | Legacy transformer baseline |
| `two_stage_yolo.py` | Transformer | Yes (13-D) | — | Legacy YOLO baseline |

---

### Ablation Configurations (C1–C4)

These are the four feature configurations used in the paper:

| Config | Script | Strategies | Feature dim | Description |
|--------|--------|------------|-------------|-------------|
| **C1** | `two_stage_multi_model.py` | — | 8 | Pure sensors, no RTK, no YOLO |
| **C2** | `two_stage_yolo_improved_multi_model.py` | `1b` (no det cache) | 14 | Sensors + RTK |
| **C3** | `two_stage_yolo_improved_multi_model.py` | `1b 2` | 39 | Sensors + RTK + YOLO zone |
| **C4** | `two_stage_yolo_improved_multi_model.py` | `1b 2 5 6` | 53 | Sensors + RTK + YOLO full |

**RTK features** (`--rtk-dir`): 6-dim GPS-derived features saved as `{sid}_rtk.npy`.

**YOLO features** (`--det-cache-dir`): requires `extract-improved` pre-extraction (Step 0 below).

---

### Step 0: Extract YOLO Detection Features (C3 and C4 only)

Runs YOLOv8 and saves a `{SESSION_ID}_det_imp.npy` array of shape `(T, 39)` with all feature blocks pre-computed. Only the columns needed by the active strategies are loaded at train time.

```bash
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model extract-improved \
  --manifest ./artifacts/manifest.jsonl \
  --det-cache-dir ./artifacts/det_cache_imp \
  --sample-hz 3
```

> Needs HDD videos and `pip install ultralytics`. `yolov8n.pt` downloads automatically.
> Add `--overwrite` to force re-extraction.

---

### C1 — Base (8 sensors, no RTK, no YOLO)

**Script**: `two_stage_multi_model.py`

```bash
# Step 1: Prepare dataset (once, shared across all models for C1)
python -m twimo.strategies_eaf.two_stage_multi_model prepare \
  --sensor-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --output-dir ./artifacts/20_base/data

# Step 2: Train Stage 1 — Event Detection
python -m twimo.strategies_eaf.two_stage_multi_model train-stage1 \
  --model xgboost \
  --data-dir ./artifacts/20_base/data \
  --outdir ./artifacts/20_base/xgboost

# Step 3: Train Stage 2 — Goal/Stimuli Classification
python -m twimo.strategies_eaf.two_stage_multi_model train-stage2 \
  --model xgboost \
  --data-dir ./artifacts/20_base/data \
  --stage1-model ./artifacts/20_base/xgboost/stage1_tree.joblib \
  --outdir ./artifacts/20_base/xgboost

# Step 4: Predict / Evaluate
python -m twimo.strategies_eaf.two_stage_multi_model predict \
  --model xgboost \
  --data-dir ./artifacts/20_base/data \
  --stage1-model ./artifacts/20_base/xgboost/stage1_tree.joblib \
  --stage2-model ./artifacts/20_base/xgboost/stage2_tree.joblib \
  --outdir ./artifacts/20_base/xgboost/predictions
```

Tree models save `stage1_tree.joblib` / `stage2_tree.joblib`. Neural models save `stage1.pt` / `stage2.pt`.

**Available models** for `--model`: `xgboost`, `lightgbm`, `random_forest`, `gru`, `lstm`, `tcn`, `mlp_mean`, `mlp_max`, `mlp_concat`.

---

### C2 — Sensors + RTK (no YOLO)

**Script**: `two_stage_yolo_improved_multi_model.py`

```bash
# Train
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \
  --model xgboost \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --outdir ./artifacts/21_base_rtk/xgboost

# Evaluate
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model evaluate \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --model-dir ./artifacts/21_base_rtk/xgboost \
  --outdir ./artifacts/21_base_rtk/xgboost/eval
```

> No `--det-cache-dir` for C2 — correct, YOLO features are not used.

---

### C3 — Sensors + RTK + YOLO Zone (strategies `1b 2`)

```bash
# Train
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \
  --model xgboost \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --det-cache-dir ./artifacts/det_cache_imp \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --strategies 1b 2 \
  --outdir ./artifacts/22_yolo_zone_rtk/xgboost

# Evaluate
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model evaluate \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --det-cache-dir ./artifacts/det_cache_imp \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --model-dir ./artifacts/22_yolo_zone_rtk/xgboost \
  --outdir ./artifacts/22_yolo_zone_rtk/xgboost/eval
```

---

### C4 — Sensors + RTK + YOLO Full (strategies `1b 2 5 6`)

```bash
# Train
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \
  --model xgboost \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --det-cache-dir ./artifacts/det_cache_imp \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --strategies 1b 2 5 6 \
  --outdir ./artifacts/23_yolo_full_rtk/xgboost

# Evaluate
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model evaluate \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --det-cache-dir ./artifacts/det_cache_imp \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --model-dir ./artifacts/23_yolo_full_rtk/xgboost \
  --outdir ./artifacts/23_yolo_full_rtk/xgboost/eval
```

---

### Transformer (C2/C3/C4)

For the Transformer model, replace `--model xgboost` with `--model transformer` and add `--epochs 10`. The train command delegates to `two_stage_yolo_improved.py` internally.

```bash
# C2 — Transformer + RTK
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \
  --model transformer \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --epochs 10 \
  --outdir ./artifacts/21_base_rtk/transformer

# C3 — Transformer + RTK + YOLO zone
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \
  --model transformer \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --det-cache-dir ./artifacts/det_cache_imp \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --strategies 1b 2 \
  --epochs 10 \
  --outdir ./artifacts/22_yolo_zone_rtk/transformer

# C4 — Transformer + RTK + YOLO full
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model train \
  --model transformer \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --det-cache-dir ./artifacts/det_cache_imp \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --strategies 1b 2 5 6 \
  --epochs 10 \
  --outdir ./artifacts/23_yolo_full_rtk/transformer
```

Evaluate Transformer (same pattern, replace `xgboost` with `transformer`):
```bash
python -m twimo.strategies_eaf.two_stage_yolo_improved_multi_model evaluate \
  --manifest ./artifacts/manifest.jsonl \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --rtk-dir ./artifacts/eaf/rtk_features \
  --model-dir ./artifacts/21_base_rtk/transformer \
  --outdir ./artifacts/21_base_rtk/transformer/eval
```

---

### Training Options

| Option | Default | Applies to | Description |
|--------|---------|-----------|-------------|
| `--strategies` | `[]` | C2/C3/C4 | Space-separated strategy flags |
| `--stage1-threshold` | `0.30` | `1b` | P(event) gate threshold |
| `--balance-ratio` | none | all | Undersample no-event windows |
| `--window-sec` | `5.0` | all | Observation window length (s) |
| `--stride-sec` | `1.0` | all | Stride between windows (s) |
| `--epochs` | `30` | neural | Training epochs |
| `--lr` | `1e-4` | neural | Learning rate |
| `--batch-size` | `64` | neural | Batch size |

### Strategies Reference

| Flag | Name | What it does | Cache needed |
|------|------|-------------|--------------|
| `1a` | Remove Stage 1 | Stage 2 on ALL windows; no event gate | original |
| `1b` | Weaken Stage 1 | Fires Stage 2 when `P(event) ≥ threshold` (default 0.30) | original |
| `2` | Zone features | +12 YOLO zone columns (ego/adjacent/oncoming/sidewalk) | `extract-improved` |
| `3` | Majority-vote labels | Labels by majority vote over window frames | original |
| `4` | Class weights | Inverse-frequency weights for Stage 2 loss | original |
| `5` | Motion features | +5 inter-frame motion signals (TTC, scene motion, ...) | `extract-improved` |
| `6` | Top-K tracking | +9 columns tracking 3 largest vehicles | `extract-improved` |
| `7` | 10 s window | Doubles window from 5 s to 10 s | original |

> `1a` and `1b` are mutually exclusive — `1a` takes priority.

**Feature dim** depends on active strategies:

| Active strategies | det_dim | Total dim (+ 8 sensors + 6 RTK) |
|-------------------|---------|----------------------------------|
| none (no det cache) | 0 | 14 |
| base (13-D) | 13 | 27 |
| `2` (+ zone) | 25 | 39 |
| `2 5` (+ motion) | 30 | 44 |
| `2 5 6` (+ top-K) | 39 | 53 |

### Outputs

```
artifacts/<config>/<model>/
├── stage1.pt / stage1_tree.joblib     # Stage 1 checkpoint
├── stage2.pt / stage2_tree.joblib     # Stage 2 checkpoint
├── config.json                        # Model config (incl. strategies, dims)
├── strategies.json                    # Active strategy flags
├── norm_mean.npy / norm_std.npy       # Normalisation stats
├── metrics_train.json                 # Stage1 + Goal/Stimuli F1 (train)
├── metrics_val.json                   # Same (validation)
├── metrics_test.json                  # Same (test)
├── metrics_all_horizons.json          # Multi-horizon table (test)
└── throughput_train.json              # Training + inference throughput
```

`metrics_all_horizons.json` contains per-horizon (0–5 s) Goal + Stimuli F1 with oracle metrics.
`throughput_train.json` contains `training_samp_per_sec` and `inference_samp_per_sec`.

---

## Video Annotation

TWIMO provides four annotation scripts that overlay predictions on front-facing camera video.

| Script | Model source | Overlay content |
|--------|-------------|-----------------|
| `annotate_video.py` | `train-maneuver` | Proxy maneuver labels |
| `annotate_video_eaf.py` | `two_stage_transformer.py` | Event + Goal + Stimuli bars |
| `annotate_video_eaf_yolo.py` | `two_stage_yolo.py` | YOLOv8 bboxes + YOLO-augmented predictions |
| `annotate_video_eaf_yolo_improved.py` | `two_stage_yolo_improved.py` | Zone-colored bboxes + strategy badge + 4-head panel |

**Panel layout** (all scripts):
- **Left 22%**: EAF ground-truth (Event / Goal / Stimuli) or proxy label
- **Center 50–54%**: Per-head prediction bars with class names and confidence %
- **Right 24%**: Sensor readouts (Speed, Steer, Accel, Brake, Yaw, Lat/Lng)

### Proxy Annotation

```bash
python twimo/plots/annotate_video.py \
  --manifest ./artifacts/manifest.jsonl \
  --modeldir ./artifacts/maneuver_transformer \
  --outdir ./artifacts/annotated_video_proxy \
  --sample-hz 3
  [--session SESSION_ID]   # annotate a single session
  [--max-seconds N]
```

### EAF Two-Stage Annotation

```bash
python twimo/plots/annotate_video_eaf.py \
  --manifest ./artifacts/manifest.jsonl \
  --stage1-model ./artifacts/eaf/two_stage/stage1_event/stage1.pt \
  --stage2-model ./artifacts/eaf/two_stage/stage2_classify/stage2.pt \
  --data-dir ./example_data \
  --vocab-dir ./artifacts/eaf/vocabs \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --outdir ./artifacts/annotated_video_eaf \
  --sample-hz 3
```

### EAF + YOLOv8 Annotation

```bash
python twimo/plots/annotate_video_eaf_yolo.py \
  --manifest ./artifacts/manifest.jsonl \
  --stage1-model ./artifacts/two_stage_yolo/stage1.pt \
  --stage2-model ./artifacts/two_stage_yolo/stage2.pt \
  --data-dir ./example_data \
  --vocab-dir ./artifacts/eaf/vocabs \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --det-cache-dir ./artifacts/det_cache \
  --outdir ./artifacts/annotated_video_eaf_yolo \
  --yolo-model yolov8n.pt --yolo-conf 0.35 \
  --sample-hz 3 --max-seconds 120
  [--session-id SESSION_ID]
```

`--det-cache-dir` uses pre-computed detections; if omitted, YOLO runs live.

### EAF + YOLOv8 Improved Annotation

Visualizes results from `two_stage_yolo_improved.py`. Adds zone-colored bboxes and strategy badge.

```bash
python twimo/plots/annotate_video_eaf_yolo_improved.py \
  --manifest ./artifacts/manifest.jsonl \
  --model-dir ./artifacts/05_manuever_yolo_impr/two_stage_yolo_imp \
  --vocab-dir ./artifacts/eaf/vocabs \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --det-cache-dir ./artifacts/det_cache_imp \
  --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
  --outdir ./artifacts/annotated_video_eaf_yolo_imp \
  --yolo-model yolov8n.pt --yolo-conf 0.35 \
  --sample-hz 3 --max-seconds 120
  [--session SESSION_ID]       # note: --session, not --session-id
  [--no-zone-colours]          # disable zone-based bbox coloring
```

> Video and CSV paths are read from the manifest's `video_dir` / `csv_dir` fields (no `--data-dir` argument).

---

## Workflow Comparison

| Aspect | Proxy Pipeline A | EAF Multi-Target B | Two-Stage C (Main) |
|--------|-----------------|-------------------|-------------------|
| **Labels** | Heuristic | Human-annotated EAF | Human-annotated EAF |
| **Targets** | 1 (maneuver class) | 2 (Goal + Stimuli) | 3 (Event + Goal + Stimuli) |
| **Imbalance handling** | None | None | Stage 1 gate + Focal Loss |
| **YOLO features** | Optional | No | Optional (C3/C4) |
| **RTK features** | No | No | Optional (C2/C3/C4) |
| **Models** | 11 | 11 | 10 (+ Transformer special) |
| **Use case** | Quick experiments | Multi-task classification | Paper ablation |

---

## Resources

- [README.md](README.md): Project overview and programmatic API
- [CLAUDE.md](CLAUDE.md): Developer guide and code conventions
- [twimo/models/MODELS_OVERVIEW.md](twimo/models/MODELS_OVERVIEW.md): Model comparison
- [twimo/dt/README.md](twimo/dt/README.md): Digital Twin simulation details
