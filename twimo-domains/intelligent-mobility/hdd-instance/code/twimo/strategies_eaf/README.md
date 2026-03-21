# EAF Annotation Strategy

This folder contains tools for integrating **ELAN Annotation Format (EAF)** files with TWIMO's training pipeline.

## Overview

EAF files are XML-based annotation files created with ELAN software. They contain manually annotated maneuver labels with precise timestamps, providing **ground-truth labels** for training and evaluation.

Instead of using heuristic proxy labels, this workflow uses **human-annotated EAF labels** for supervised learning.

---

## EAF Tier Roles

EAF annotations are organized in 6 tiers. Their roles depend on the pipeline used:

| Tier | Role (Classic) | Role (YOLO Pipeline) | Description | Example Values |
|------|---------------|---------------------|-------------|----------------|
| **Goal** | **Target** (Maneuver) | **Target** (head 1) | Driving maneuver being performed | `left_turn`, `right_turn`, `lane_change` |
| **Stimuli** | **Target** (Stimuli) | **Target** (head 2) | External stimuli triggering maneuver | `traffic_light`, `pedestrian`, `vehicle` |
| **Area** | **Input Feature** | (not used) | Location context | `intersection`, `highway`, `parking` |
| **Event** | **Input Feature** | (event label) | Whether a driving event is occurring | `braking`, `accelerating`, `stopping` |
| **Cause** | **Input Feature** | **Target** (head 3) | Reason for maneuver (now predicted!) | `traffic`, `obstacle`, `signal` |
| **Attention** | **Input Feature** | **Target** (head 4) | Driver attention state (now predicted!) | `focused`, `distracted`, `scanning` |

> **Note**: In the Two-Stage YOLO pipeline, **Cause** and **Attention** are no longer input features — they become additional prediction targets alongside Goal and Stimuli. The visual context (YOLOv8 detections) serves as the primary input signal for predicting these causal factors.

---

## Workflow Modes

This folder provides **three workflows**:

### 1. **Single-Target Workflow** (Basic)

- Uses **one vocabulary** for all EAF annotations
- Predicts **one target**: maneuver labels (mixed from all tiers)
- Sensors: Standard CSV features only
- **Scripts**: `align_eaf_to_sensors.py`, `example_pipeline.sh/ps1`
- **Use case**: Simple maneuver prediction with EAF ground-truth

### 2. **Multi-Target Workflow** (Advanced)

- Uses **6 separate vocabularies** (Goal, Stimuli, Area, Event, Cause, Attention)
- Predicts **two targets**: Goal (maneuver) + Stimuli (external triggers)
- Sensors: Standard CSV features + optional EAF features
- **Scripts**:
  - `align_eaf_to_sensors_multitarget_new.py` (8 features: 4 sensors + 4 EAF categories)
  - `align_eaf_to_sensors_multitarget_simple.py` (4 sensors only - clean version)
- **Use case**: Multi-task prediction with separate Goal/Stimuli models

### 3. **Two-Stage Multi-Model Workflow** (Model Comparison)

- Uses same **2 vocabularies** (Goal + Stimuli) as Two-Stage Transformer
- Predicts **two targets**: Goal + Stimuli (same Stage 1 / Stage 2 design)
- **7 alternative model families**: GRU, LSTM, TCN, MLP (mean/max/concat), XGBoost, LightGBM, Random Forest
- **Data-compatible**: Uses the exact same prepared `.npy` data as the Transformer pipeline
- **Script**: `two_stage_multi_model.py` (4 subcommands: prepare, train-stage1, train-stage2, predict)
- **Use case**: Model comparison — benchmark alternative architectures against the Transformer under identical conditions

### 4. **Two-Stage YOLO Workflow** (Full Sensor + Video, Recommended)

- Uses **4 vocabularies**: Goal, Stimuli, Cause, Attention — all as **prediction targets**
- Predicts **four targets simultaneously**: Goal, Stimuli, Cause, Attention (single 4-head Transformer)
- Input: 8 prealigned sensors + 13 YOLO detection features = 21-dim per timestep
- **Script**: `two_stage_yolo.py` (5 subcommands: extract, train, validate, filter-retrain, evaluate)
- **Video annotation**: `twimo/plots/annotate_video_eaf_yolo.py`
- **Use case**: Full visual + sensor fusion for multi-target driving behavior prediction

**Key differences**:

| Aspect | Single-Target | Multi-Target | Two-Stage Transformer | Two-Stage Multi-Model | Two-Stage YOLO |
|--------|---------------|--------------|----------------------|-----------------------|----------------|
| **Vocabularies** | 1 vocab | 6 vocabs | 2 (Goal + Stimuli) | 2 (Goal + Stimuli) | 4 (Goal/Stimuli/Cause/Att.) |
| **Prediction targets** | 1 (maneuver) | 2 (Goal + Stimuli) | 3 (Event + Goal + Stimuli) | 3 (Event + Goal + Stimuli) | **5 (Event + 4 heads)** |
| **Input features** | (T, D) sensors | (T, 4) or (T, 8) | (T, D) prealigned | (T, D) prealigned | **(T, 21) sensors + YOLO** |
| **Models** | 1 model | 2 models | 2 Transformers | 2 models (7 families) | **2 Transformers + YOLOv8** |
| **Video required** | No | No | No | No | **Yes (YOLOv8)** |
| **Annotation script** | — | — | `annotate_video_eaf.py` | — | `annotate_video_eaf_yolo.py` |

---

## Core Scripts

### Preprocessing

- **`parse_eaf.py`** - Parse EAF XML files to JSON with tier grouping
- **`build_vocab.py`** - Build single vocabulary from parsed EAF
- **`build_all_vocabs.py`** - Build all 6 vocabularies at once (standard tier names)
- **`build_all_vocabs_chinese.py`** - Build all 6 vocabularies with Chinese/bilingual support

### Two-Stage Pipelines

- **`two_stage_transformer.py`** - Two-Stage Transformer (Event detection + Goal/Stimuli classification)
- **`two_stage_multi_model.py`** - Two-Stage for GRU / LSTM / TCN / MLP / XGBoost / LightGBM / RF

### Alignment

- **`align_eaf_to_sensors.py`** - Single-target alignment (1 vocab, 1 target)
- **`align_eaf_to_sensors_multitarget_new.py`** - Multi-target with 8 features (4 sensors + 4 EAF categories)
- **`align_eaf_to_sensors_multitarget_simple.py`** - Multi-target with 4 sensors only (clean, no EAF features)

### Utilities

- **`inspect_eaf_tiers.py`** - Inspect tier names in EAF files (useful for debugging)
- **`check_csv_paths.py`** - Check CSV file paths and session IDs
- **`create_stimuli_manifest.py`** - Create manifest for Stimuli training (swaps target paths)
- **`evaluate_eaf.py`** - Evaluate model predictions against EAF ground-truth

---

## Single-Target Workflow

### 1. Parse EAF Files

Extract annotations from EAF XML files:

```bash
python twimo/strategies_eaf/parse_eaf.py \
  --eaf-dir ./path/to/eaf_files \
  --output ./artifacts/eaf/parsed
```

**Outputs**:
- `./eaf_parsed/<SESSION_ID>.json` — Parsed annotations for each session
- `./eaf_parsed/summary.json` — Summary with all unique labels

### 2. Build Vocabulary

Create a mapping from maneuver labels to class IDs:

```bash
python twimo/strategies_eaf/build_vocab.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --output ./artifacts/vocab_eaf.json
```

### 3. Align EAF to Sensors

Map EAF annotations to sensor timeline and create `.npy` files:

```bash
python twimo/strategies_eaf/align_eaf_to_sensors.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab ./artifacts/vocab_eaf.json \
  --manifest ./artifacts/manifest.jsonl \
  --output-dir ./artifacts/eaf/aligned \
  --sample-hz 3
```

**Outputs**:
- `sensor/<SESSION_ID>.npy` — Sensor features (T, D)
- `target/<SESSION_ID>.npy` — Integer labels (T,)
- `manifest_eaf_aligned.jsonl` — Updated manifest

### 4. Train Model

```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/eaf/aligned/manifest_eaf_aligned.jsonl \
  --outdir ./artifacts/eaf/maneuver_goal \
  --model transformer \
  --sample-hz 3 \
  --epochs 10
```

### 5. Evaluate

```bash
python twimo/strategies_eaf/evaluate_eaf.py \
  --model-dir ./artifacts/eaf/maneuver_goal \
  --manifest ./artifacts/eaf/aligned/manifest_eaf_aligned.jsonl \
  --vocab ./artifacts/vocab_eaf.json \
  --output-dir ./artifacts/eaf/eval_goal \
  --sample-hz 3
```

---

## Multi-Target Workflow

### 1. Parse EAF Files

Same as single-target:

```bash
python twimo/strategies_eaf/parse_eaf.py \
  --eaf-dir ./hdd_dataset/eaf_annotations \
  --output ./artifacts/eaf/parsed
```

Output includes `tiers_grouped` field for tier-specific access.

### 2. Build All Vocabularies

Build separate vocabulary for each tier:

**Standard tier names:**
```bash
python twimo/strategies_eaf/build_all_vocabs.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --output-dir ./artifacts/eaf/vocabs
```

**Chinese/bilingual tier names:**
```bash
python twimo/strategies_eaf/build_all_vocabs_chinese.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --output-dir ./artifacts/eaf/vocabs
```

**Output**: 6 vocabulary files
- `vocab_goal.json`, `vocab_stimuli.json`, `vocab_area.json`
- `vocab_event.json`, `vocab_cause.json`, `vocab_attention.json`

### 3. Align EAF to Sensors (Multi-Target)

**Option A: 4 sensors only (RECOMMENDED - avoids feature scale mismatch):**

```bash
python twimo/strategies_eaf/align_eaf_to_sensors_multitarget_simple.py \
  --hdd-root ./example_data \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --output-dir ./artifacts/eaf/aligned \
  --sample-hz 3
```

Output:
- `sensor/<SESSION_ID>.npy` - (T, 4) standard sensors only
- `target_goal/<SESSION_ID>.npy` - (T,) Goal labels
- `target_stimuli/<SESSION_ID>.npy` - (T,) Stimuli labels

**Option B: 8 features (sensors + EAF categories - may cause feature scale issues):**

```bash
python twimo/strategies_eaf/align_eaf_to_sensors_multitarget_new.py \
  --hdd-root ./example_data \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --vocab-dir ./artifacts/eaf/vocabs \
  --output-dir ./artifacts/eaf/aligned_multitarget \
  --sample-hz 3
```

Output:
- `sensor/<SESSION_ID>.npy` - (T, 8) sensors + Area/Event/Cause/Attention
- `target_goal/<SESSION_ID>.npy` - (T,) Goal labels
- `target_stimuli/<SESSION_ID>.npy` - (T,) Stimuli labels

**⚠️ Note:** Option B adds EAF category features (range 0-14) to continuous sensors (range -422 to +442), which can cause feature scale mismatch issues. Option A is recommended.

### 4. Train Goal Model

```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/eaf/aligned/manifest_eaf_aligned_simple.jsonl \
  --outdir ./artifacts/eaf/maneuver_goal \
  --model transformer \
  --sample-hz 3 \
  --epochs 10
```

### 5. Train Stimuli Model

Create Stimuli manifest (swaps target paths):

```bash
python twimo/strategies_eaf/create_stimuli_manifest.py \
  --input ./artifacts/eaf/aligned/manifest_eaf_aligned_simple.jsonl \
  --output ./artifacts/eaf/aligned/manifest_eaf_aligned_stimuli.jsonl
```

Train:

```bash
python -m twimo.cli train-maneuver \
  --manifest ./artifacts/eaf/aligned/manifest_eaf_aligned_stimuli.jsonl \
  --outdir ./artifacts/eaf/maneuver_stimuli \
  --model transformer \
  --sample-hz 3 \
  --epochs 10
```

---

## Two-Stage Transformer (Event-Centric Approach)

Standard frame-level models collapse on the majority class because ~85-95% of frames are "None" (no event). The **Two-Stage Transformer** (`two_stage_transformer.py`) solves this with a two-stage pipeline:

- **Stage 1**: Event Detection Transformer — binary classification (event vs no-event) with Focal Loss
- **Stage 2**: Goal/Stimuli Classification Transformer — multi-task classification only on detected event windows

### Key Features

- **Sliding window**: 5-second windows (15 timesteps at 3Hz) with 1-second stride
- **All prealigned sensors**: Uses all D channels from `.npy` files (not just 4 CSV features)
- **Balanced training**: Undersamples no-event windows to 30% (70% event / 30% no-event)
- **Focal Loss** (gamma=2, alpha=0.75) for Stage 1 — handles heavy class imbalance
- **Weighted CrossEntropy + conditional masking** for Stage 2 — loss only on non-zero labels
- **Attention pooling**: Learned query vector for temporal aggregation
- **Per-day split**: Last day as test set, 10% of training for validation
- **Z-score normalization**: Fit on train, applied to val/test

### Prerequisites

Requires parsed EAF files and vocabularies (same as Multi-Target workflow):

```bash
python twimo/strategies_eaf/parse_eaf.py --eaf-dir ./assets/hdd_prealigned/20200710_EAF --output ./artifacts/eaf/parsed
python twimo/strategies_eaf/build_all_vocabs.py --eaf-parsed-dir ./artifacts/eaf/parsed --output-dir ./artifacts/eaf/vocabs
```

### 1. Prepare Dataset

Loads prealigned sensors, maps EAF Goal/Stimuli annotations to the sensor timeline, creates sliding windows, balances, and splits:

```bash
python twimo/strategies_eaf/two_stage_transformer.py prepare --sensor-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor --eaf-parsed-dir ./artifacts/eaf/parsed --vocab-dir ./artifacts/eaf/vocabs --output-dir ./artifacts/eaf/two_stage/data --sample-hz 3 --window-sec 5 --stride-sec 1
```

Output: `two_stage_data/` with `X_train.npy`, `ev_train.npy`, `g_train.npy`, `s_train.npy` (+ val/test splits), `config.json`, `dataset_stats.json`.

### 2. Train Stage 1 — Event Detection

Binary Transformer (event vs no-event) with Focal Loss:

```bash
python twimo/strategies_eaf/two_stage_transformer.py train-stage1 --data-dir ./artifacts/eaf/two_stage/data --outdir ./artifacts/eaf/two_stage/stage1_event --epochs 30 --lr 1e-4 --batch-size 32
```

Output: `stage1.pt`, `config.json`, `metrics_stage1.json`.

### 3. Train Stage 2 — Goal/Stimuli Classification

Multi-task Transformer on event windows only (Goal: 14 classes, Stimuli: 9 classes):

```bash
python twimo/strategies_eaf/two_stage_transformer.py train-stage2 --data-dir ./artifacts/eaf/two_stage/data --stage1-model ./artifacts/eaf/two_stage/stage1_event/stage1.pt --outdir ./artifacts/eaf/two_stage/stage2_classify --epochs 30 --lr 1e-4 --batch-size 32
```

Output: `stage2.pt`, `config.json`, `metrics_stage2.json`.

### 4. End-to-End Prediction

Runs Stage 1 to detect events, then Stage 2 to classify Goal/Stimuli on predicted event windows:

```bash
python twimo/strategies_eaf/two_stage_transformer.py predict --data-dir ./artifacts/eaf/two_stage/data --stage1-model ./artifacts/eaf/two_stage/stage1_event/stage1.pt --stage2-model ./artifacts/eaf/two_stage/stage2_classify/stage2.pt --outdir ./artifacts/eaf/two_stage/predictions
```

Output: `metrics_combined.json` with event detection metrics, Goal/Stimuli metrics on predicted events, and oracle (ground-truth events) upper bound.

### 5. Prediction with Per-Area Breakdown (optional)

Adds `--breakdown-by-area` to compute separate metrics for each driving area (downtown, freeway, tunnel). Requires the original EAF and sensor paths:

```bash
python twimo/strategies_eaf/two_stage_transformer.py predict --data-dir ./artifacts/eaf/two_stage/data --stage1-model ./artifacts/eaf/two_stage/stage1_event/stage1.pt --stage2-model ./artifacts/eaf/two_stage/stage2_classify/stage2.pt --outdir ./artifacts/eaf/two_stage/predictions --breakdown-by-area --sensor-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor --eaf-parsed-dir ./artifacts/eaf/parsed --vocab-dir ./artifacts/eaf/vocabs
```

Output: `metrics_combined.json` now includes a `per_area` section with event detection F1, Goal Macro-F1, and Stimuli Macro-F1 for each area. Areas with no test windows are reported with `"n_windows": 0`.

### Results (21 sessions, test day: 20170306)

**Stage 1 — Event Detection:**

| Metric | Value |
|--------|-------|
| Macro-F1 | 0.647 |
| Event Recall | 98.2% |
| No-event Precision | 95.9% |

**Stage 2 — Classification (on predicted events):**

| Task | Macro-F1 | Best Classes |
|------|----------|-------------|
| Goal | 0.268 | right_turn (0.75), left_turn (0.71), intersection_passing (0.51) |
| Stimuli | 0.143 | stop_4_sign (0.41), stop_4_congestion (0.22) |

**Oracle upper bound** (Stage 2 on ground-truth events): Goal Macro-F1 = 0.359, Stimuli Macro-F1 = 0.178.

### Architecture Summary

| Component | Details |
|-----------|---------|
| Input | (B, 15, 8) sliding windows at 3Hz |
| Projection | Linear(D, 128) + learned positional embedding |
| Encoder | TransformerEncoder (3 layers, 4 heads, d_model=128, dim_ff=256, dropout=0.1) |
| Pooling | Attention pooling (learned query vector) |
| Stage 1 Head | Linear(128, 2) + Focal Loss (gamma=2, alpha=0.75) |
| Stage 2 Heads | Goal: Linear(128, 14), Stimuli: Linear(128, 9) + Weighted CE |
| Optimizer | AdamW (lr=1e-4, weight_decay=1e-4) + CosineAnnealingLR |

---

## Two-Stage Multi-Model (Model Comparison Pipeline)

The **Two-Stage Multi-Model** pipeline (`two_stage_multi_model.py`) provides the same event-centric two-stage design as the Transformer but with **7 alternative model families**, making it easy to benchmark architectures under identical conditions.

**Available models** (`--model`):

| Family | Models |
|--------|--------|
| Neural | `gru`, `lstm`, `tcn`, `mlp_mean`, `mlp_max`, `mlp_concat` |
| Tree-based | `xgboost`, `lightgbm`, `random_forest` |

### Data Compatibility

The prepared data format is **identical** to `two_stage_transformer.py`. If you already ran `prepare` for the Transformer, you can reuse the same `--data-dir` and skip Step 1.

### 1. Prepare Dataset

```bash
python -m twimo.strategies_eaf.two_stage_multi_model prepare \
    --sensor-dir     ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir      ./artifacts/eaf/vocabs \
    --output-dir     ./artifacts/eaf/two_stage/data
```

### 2. Train Stage 1 — Event Detection

```bash
# Neural model example (gru, lstm, tcn, mlp_mean, mlp_max, mlp_concat)
python -m twimo.strategies_eaf.two_stage_multi_model train-stage1 \
    --model gru \
    --data-dir ./artifacts/eaf/two_stage/data \
    --outdir   ./artifacts/eaf/two_stage/gru/stage1

# Tree model example (xgboost, lightgbm, random_forest)
python -m twimo.strategies_eaf.two_stage_multi_model train-stage1 \
    --model xgboost \
    --data-dir ./artifacts/eaf/two_stage/data \
    --outdir   ./artifacts/eaf/two_stage/xgboost/stage1
```

Output: `stage1.pt` (neural) or `stage1_tree.joblib` (tree) + `metrics_stage1.json`.

### 3. Train Stage 2 — Goal/Stimuli Classification

```bash
python -m twimo.strategies_eaf.two_stage_multi_model train-stage2 \
    --model gru \
    --data-dir     ./artifacts/eaf/two_stage/data \
    --stage1-model ./artifacts/eaf/two_stage/gru/stage1/stage1.pt \
    --outdir       ./artifacts/eaf/two_stage/gru/stage2
```

Output: `stage2.pt` (neural) or `stage2_tree.joblib` (tree) + `metrics_stage2.json`.

### 4. End-to-End Prediction

```bash
python -m twimo.strategies_eaf.two_stage_multi_model predict \
    --model gru \
    --data-dir     ./artifacts/eaf/two_stage/data \
    --stage1-model ./artifacts/eaf/two_stage/gru/stage1/stage1.pt \
    --stage2-model ./artifacts/eaf/two_stage/gru/stage2/stage2.pt \
    --outdir       ./artifacts/eaf/two_stage/gru/predictions
```

Output: `metrics_combined.json` with event detection, Goal/Stimuli on predicted events, and oracle upper bound.

### Architecture Details

| Model | Encoder (shared for Stage 1 + Stage 2) | Features |
|-------|----------------------------------------|----------|
| `gru` / `lstm` | Stacked RNN → last hidden state | Sequence order |
| `tcn` | Dilated causal residual Conv1D blocks (dilation = 2^i) → avg pool | Long receptive field |
| `mlp_mean` / `mlp_max` | Global mean/max pooling → 2-layer MLP | Simple, fast |
| `mlp_concat` | Concat(mean + max + first + last) → MLP | Rich pooling, 4× input |
| `xgboost` / `lightgbm` / `random_forest` | Window statistics: mean, std, min, max, delta (5×D) | No gradient, interpretable |

All neural models use **Focal Loss** (gamma=2, alpha=0.75) for Stage 1 imbalance handling,
and **weighted CrossEntropy with conditional masking** for Stage 2 — identical to the Transformer.

---

## Two-Stage YOLO (Sensor + Video, 4-Head Model)

The **Two-Stage YOLO** pipeline (`two_stage_yolo.py`) extends the Two-Stage Transformer with:

- **YOLOv8 visual detection**: 13-dimensional detection feature vector extracted from video frames (traffic lights, stop signs, pedestrians, vehicles, etc.)
- **4-head Stage 2**: Single Transformer trunk predicts **Goal**, **Stimuli**, **Cause**, and **Attention** simultaneously
- **Weighted cross-entropy for Stage 1**: `pos_weight = n_neg / n_pos` to handle heavy class imbalance
- **Sensor-video temporal alignment**: Automatic offset detection from CSV timestamps + session ID to align sensor arrays with EAF annotation timelines
- **Backward compatible**: Annotation script auto-detects 2-head vs 4-head models via `n_cause_classes` in `config.json`

### Input Features

| Source | Dimension | Description |
|--------|-----------|-------------|
| Prealigned sensors | 8 | Speed, steering, acceleration, GPS-derived signals |
| YOLO detections | 13 | Traffic lights (R/Y/G), stop sign, pedestrian proximity, vehicle positions, counts, congestion |
| **Total** | **21** | Combined input to both Stage 1 and Stage 2 |

### Detection Feature Vector (D=13)

| Index | Name | Description |
|-------|------|-------------|
| 0 | `tl_red` | Traffic light → red confidence |
| 1 | `tl_yellow` | Traffic light → yellow confidence |
| 2 | `tl_green` | Traffic light → green confidence |
| 3 | `stop_sign` | Stop sign detection confidence |
| 4 | `pedestrian_near` | Pedestrian proximity-weighted confidence |
| 5 | `vehicle_ahead` | Vehicle in centre of frame (large bbox) |
| 6 | `vehicle_cross` | Vehicle at frame sides (crossing / cut-in) |
| 7 | `vehicle_parked` | Vehicle on roadside (small, bottom of frame) |
| 8 | `bicycle` | Cyclist / bicycle |
| 9 | `motorcycle` | Motorcyclist |
| 10 | `heavy_vehicle` | Bus or truck |
| 11 | `vehicle_count` | Normalised vehicle count (clipped at 10) |
| 12 | `congestion` | Vehicle area / frame area (clipped at 0.5) |

### Architecture Summary

| Component | Details |
|-----------|---------|
| Input | (B, 15, 21) sliding windows at 3Hz (8 sensors + 13 detection features) |
| Projection | Linear(21, 128) + learned positional embedding |
| Encoder | TransformerEncoder (3 layers, 4 heads, d_model=128, dim_ff=256, dropout=0.1) |
| Pooling | Attention pooling (learned query vector) |
| Stage 1 Head | Linear(128, 2) + Weighted CrossEntropy (pos_weight = n_neg/n_pos) |
| Stage 2 Heads | Goal: Linear(128, N_goal), Stimuli: Linear(128, N_stim), Cause: Linear(128, N_cause), Attention: Linear(128, N_att) |
| Optimizer | AdamW (lr=1e-4, weight_decay=1e-4) + CosineAnnealingLR |

### Prerequisites

Requires parsed EAF files and all 6 vocabularies:

```bash
python twimo/strategies_eaf/parse_eaf.py \
    --eaf-dir ./assets/hdd_prealigned/20200710_EAF \
    --output ./artifacts/eaf/parsed

python twimo/strategies_eaf/build_all_vocabs_chinese.py \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --output-dir ./artifacts/eaf/vocabs
```

### Step 1 — Extract YOLO Detection Features

Run YOLOv8 on each session video and cache 13-dim detection feature vectors (one per sensor timestep):

```bash
python twimo/strategies_eaf/two_stage_yolo.py extract \
    --manifest ./artifacts/manifest.jsonl \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --yolo-model yolov8n.pt \
    --sample-hz 3
```

**Outputs** (in `det_cache/`):
- `<SESSION_ID>_det.npy` — Detection features (T, 13) per session

**Options**:
- `--overwrite` — Reprocess already-cached sessions
- `--prealigned-sensors-dir` — If given, uses sensor timestamps for alignment

### Step 2 — Train (Stage 1 + Stage 2)

Train both stages end-to-end. Stage 1 detects events (binary). Stage 2 classifies all 4 targets on detected event windows:

```bash
python twimo/strategies_eaf/two_stage_yolo.py train \
    --manifest ./artifacts/manifest.jsonl \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/two_stage_yolo \
    --epochs 30 \
    --lr 1e-4 \
    --batch-size 32
```

> **Important**: `--prealigned-sensors-dir` must point to the **same sensor source** used during annotation to ensure consistent normalization. Use the HDD prealigned directory (`./twimo/assets/hdd_prealigned/20200710_sensors/sensor`), not CSV-generated arrays.

**Outputs** (in `two_stage_yolo/`):
- `stage1.pt` — Event detection model weights
- `stage2.pt` — 4-head classification model weights
- `config.json` — Full model configuration (includes `n_cause_classes`, `n_attention_classes`)
- `norm_mean.npy`, `norm_std.npy` — Normalization statistics (fit on training set)
- `metrics_stage1.json` — Stage 1 accuracy, F1, precision, recall
- `metrics_stage2.json` — Stage 2 metrics for all 4 heads (Goal, Stimuli, Cause, Attention)

**Training hyperparameters** (via shared function, can be overridden with CLI flags):

| Argument | Default | Description |
|----------|---------|-------------|
| `--epochs` | 30 | Training epochs |
| `--lr` | 1e-4 | Learning rate (AdamW) |
| `--batch-size` | 32 | Mini-batch size |
| `--sample-hz` | 3.0 | Sensor sampling frequency |
| `--window-sec` | 5.0 | Sliding window duration in seconds |

### Step 3 — Validate (EAF Annotation Agreement)

Checks how well EAF Cause/Attention annotations align with YOLO detections.
Useful for identifying low-quality or misaligned annotations before retraining:

```bash
python twimo/strategies_eaf/two_stage_yolo.py validate \
    --manifest ./artifacts/manifest.jsonl \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/validation \
    --threshold 0.15 \
    --min-agreement 0.30 \
    --sample-hz 3
```

**Outputs** (in `validation/`):
- `agreement_scores.json` — Per-session agreement between Cause/Attention labels and detections
- `low_agreement_sessions.json` — Sessions below `--min-agreement` threshold

### Step 4 — Filter & Retrain (Optional)

Remove low-agreement sessions and retrain for cleaner labels:

```bash
python twimo/strategies_eaf/two_stage_yolo.py filter-retrain \
    --validation-dir ./artifacts/eaf/validation \
    --min-agreement 0.30 \
    --manifest ./artifacts/manifest.jsonl \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/two_stage_yolo_filtered
```

**Outputs**: Same as `train` but trained only on high-agreement sessions.

### Step 5 — Evaluate

Run full evaluation on all sessions in the manifest and compute metrics for all 4 heads:

```bash
python twimo/strategies_eaf/two_stage_yolo.py evaluate \
    --manifest ./artifacts/manifest.jsonl \
    --model-dir ./artifacts/eaf/two_stage_yolo \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/eval_yolo \
    --sample-hz 3
```

**Outputs** (in `eval_yolo/`):
- `metrics_stage1.json` — Event detection: accuracy, F1, precision, recall
- `metrics_stage2.json` — 4-head classification metrics:
  - `goal`: Accuracy, Macro-F1, per-class F1, classification report
  - `stimuli`: Accuracy, Macro-F1, per-class F1, classification report
  - `cause`: Accuracy, Macro-F1, per-class F1, classification report
  - `attention`: Accuracy, Macro-F1, per-class F1, classification report

### Step 6 — Annotate Video (Live Inference + YOLO Overlay)

Generate annotated videos with:
- **YOLO bounding boxes** drawn on every frame (persistent across frames at 3Hz sampling)
- **Ground-truth panel**: EAF Goal, Stimuli, Cause, Attention labels as coloured text
- **Prediction panel**: All 4 head predictions with confidence bars per horizon
- **Sensor panel**: Live sensor signals (speed, steer, GPS track, etc.)
- **Map overlay**: RTK GPS trajectory

```bash
python twimo/plots/annotate_video_eaf_yolo.py \
    --manifest ./artifacts/manifest.jsonl \
    --stage1-model ./artifacts/eaf/two_stage_yolo/stage1.pt \
    --stage2-model ./artifacts/eaf/two_stage_yolo/stage2.pt \
    --data-dir     ./artifacts/eaf/two_stage_yolo \
    --vocab-dir    ./artifacts/eaf/vocabs \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --outdir ./artifacts/annotated_eaf_yolo \
    --session 201702271017 \
    --max-seconds 120
```

**Options**:

| Argument | Default | Description |
|----------|---------|-------------|
| `--session` | (all) | Process one specific session ID only |
| `--max-seconds` | (full) | Truncate annotation at N seconds |
| `--yolo-model` | `yolov8n.pt` | YOLOv8 variant for live bbox overlay |
| `--yolo-conf` | 0.30 | Detection confidence threshold |
| `--horizons` | `1.0 3.0 5.0` | Prediction horizons in seconds |
| `--sample-hz` | 3.0 | Sensor sampling frequency |
| `--det-cache-dir` | (optional) | Pre-cached detection features; if omitted, detection features default to zeros (bboxes still drawn) |

**Outputs** (in `annotated_eaf_yolo/`):
- `<SESSION_ID>.mp4` — Annotated video with bbox overlay, GT panel, prediction panel

> **Backward compatibility**: The script auto-detects whether the loaded model has 4 heads (`n_cause_classes > 0` in `config.json`) or 2 heads (original sensor-only model). For 2-head models, the Cause and Attention prediction columns are hidden in the panel.

### Full Pipeline (Quick Reference)

```bash
# 0. Prerequisites: parse EAF + build vocabularies
python twimo/strategies_eaf/parse_eaf.py \
    --eaf-dir ./assets/hdd_prealigned/20200710_EAF \
    --output ./artifacts/eaf/parsed
python twimo/strategies_eaf/build_all_vocabs_chinese.py \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --output-dir ./artifacts/eaf/vocabs

# 1. Extract YOLO features from videos
python twimo/strategies_eaf/two_stage_yolo.py extract \
    --manifest ./artifacts/manifest.jsonl \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --yolo-model yolov8n.pt --sample-hz 3

# 2. Train 4-head model (Goal + Stimuli + Cause + Attention)
python twimo/strategies_eaf/two_stage_yolo.py train \
    --manifest ./artifacts/manifest.jsonl \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/two_stage_yolo

# 3. Validate annotation quality
python twimo/strategies_eaf/two_stage_yolo.py validate \
    --manifest ./artifacts/manifest.jsonl \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/validation

# 4. Evaluate on full manifest
python twimo/strategies_eaf/two_stage_yolo.py evaluate \
    --manifest ./artifacts/manifest.jsonl \
    --model-dir ./artifacts/eaf/two_stage_yolo \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/eval_yolo

# 5. Annotate a video session
python twimo/plots/annotate_video_eaf_yolo.py \
    --manifest ./artifacts/manifest.jsonl \
    --stage1-model ./artifacts/eaf/two_stage_yolo/stage1.pt \
    --stage2-model ./artifacts/eaf/two_stage_yolo/stage2.pt \
    --data-dir     ./artifacts/eaf/two_stage_yolo \
    --vocab-dir    ./artifacts/eaf/vocabs \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --outdir ./artifacts/annotated_eaf_yolo \
    --session 201702271017 --max-seconds 120
```

---

## Quick Start Pipelines

### Single-Target

**PowerShell:**
```powershell
.\strategies_EAF\example_pipeline.ps1
```

**Bash:**
```bash
bash strategies_EAF/example_pipeline.sh
```

### Multi-Target

**PowerShell:**
```powershell
.\strategies_EAF\example_pipeline_multitarget.ps1
```

**Bash:**
```bash
bash strategies_EAF/example_pipeline_multitarget.sh
```

---

## File Formats

### EAF Format (Input)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ANNOTATION_DOCUMENT>
  <TIME_ORDER>
    <TIME_SLOT TIME_SLOT_ID="ts1" TIME_VALUE="30"/>
    <TIME_SLOT TIME_SLOT_ID="ts2" TIME_VALUE="48020"/>
  </TIME_ORDER>
  <TIER TIER_ID="主動的駕駛行為 Operation_Goal-oriented">
    <ANNOTATION>
      <ALIGNABLE_ANNOTATION ANNOTATION_ID="a457" TIME_SLOT_REF1="ts1" TIME_SLOT_REF2="ts2">
        <ANNOTATION_VALUE>右轉 right turn</ANNOTATION_VALUE>
      </ALIGNABLE_ANNOTATION>
    </ANNOTATION>
  </TIER>
</ANNOTATION_DOCUMENT>
```

### Parsed JSON (Intermediate)

```json
{
  "eaf_path": "session_001.eaf",
  "media_url": "./session_001.mp4",
  "annotations": [
    {
      "tier": "主動的駕駛行為 Operation_Goal-oriented",
      "start_ms": 30,
      "end_ms": 48020,
      "label": "右轉 right turn"
    }
  ],
  "tiers_grouped": {
    "Goal": [{"start_ms": 30, "end_ms": 48020, "label": "右轉 right turn"}],
    "Stimuli": [...],
    "Area": [...],
    "Event": [...],
    "Cause": [...],
    "Attention": [...]
  }
}
```

### Vocabulary JSON

```json
{
  "vocab": {
    "unknown": 0,
    "right_turn": 1,
    "left_turn": 2,
    ...
  },
  "label_map": {
    "右轉 right turn": "right_turn",
    "左轉 left turn": "left_turn",
    ...
  },
  "tier_filter": "Goal",
  "n_classes": 14
}
```

### Aligned .npy (Output)

**Single-Target:**
- `sensor/<SESSION_ID>.npy`: Shape (T, D), dtype=float32
- `target/<SESSION_ID>.npy`: Shape (T,), dtype=int64

**Multi-Target:**
- `sensor/<SESSION_ID>.npy`: Shape (T, 4) or (T, 8), dtype=float32
- `target_goal/<SESSION_ID>.npy`: Shape (T,), dtype=int64
- `target_stimuli/<SESSION_ID>.npy`: Shape (T,), dtype=int64

---

## Troubleshooting

### Missing EAF files

**Error**: `FileNotFoundError: EAF file not found for session_001`

**Solution**: Ensure EAF files are named consistently with session IDs:
- Session ID: `2017-02-27-10-17-27`
- EAF file: `2017-02-27-10-17-27.eaf`

### Empty vocabularies (only 1 class "unknown")

**Cause**: EAF files have bilingual tier names (e.g., "主動的駕駛行為 Operation_Goal-oriented")

**Solution**: Use `build_all_vocabs_chinese.py` instead of `build_all_vocabs.py`:
```bash
python twimo/strategies_eaf/build_all_vocabs_chinese.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --output-dir ./artifacts/eaf/vocabs
```

### Inspect tier names

Check what tier names exist in your EAF files:

```bash
python twimo/strategies_eaf/inspect_eaf_tiers.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed
```

### Feature scale mismatch (poor model performance)

**Symptom**: Model predicts mostly one class, poor accuracy on annotated frames

**Cause**: Mixing continuous sensors (-422 to +442) with categorical EAF features (0-14)

**Solution**: Use `align_eaf_to_sensors_multitarget_simple.py` (4 sensors only) instead of the 8-feature version

### Timestamp alignment issues

If annotations don't align with sensor timeline, check:
1. EAF timestamps are in **milliseconds**
2. Sensor timestamps are in **Unix seconds**
3. Conversion: `sensor_timestamp * 1000 = eaf_timestamp`

### Sensor panel values don't match video (YOLO pipeline)

**Symptom**: Sensor values shown in the annotation panel don't correspond to what's visible in the video frame at that moment.

**Cause**: The prealigned sensor array starts at sensor power-on time, which is before the video recording starts. EAF annotations are relative to the video start (t=0 in video ≠ t=0 in sensor array).

**Fix**: The `_compute_sensor_video_offset()` function in `two_stage_yolo.py` automatically computes this offset by:
1. Reading the first timestamp from `steer.csv` (sensor start time)
2. Parsing the session ID as a datetime (video start time)
3. Trying UTC, UTC+9 (JST), and UTC-9 timezone interpretations
4. Selecting the offset that falls in the valid range [0, 600 seconds]

Both training (`cmd_train`) and annotation (`annotate_video_eaf_yolo.py`) apply this offset so EAF labels map to the correct sensor timestep.

### Model predicts nothing / always predicts "no event" (Stage 1)

**Cause**: Without class weighting, the Stage 1 binary cross-entropy loss collapses on the majority class (no-event) because ~85-95% of windows have no driving event.

**Fix**: The `train` command applies weighted cross-entropy:
```
pos_weight = n_neg / n_pos   # e.g. 9.0 for 90% no-event data
```
This is computed automatically per training run. If predictions still seem empty, verify that your EAF files contain Event tier annotations and that sessions have sufficient annotated events.

### Normalization mismatch between training and annotation

**Symptom**: Annotation produces poor predictions even though training metrics were good.

**Cause**: If `--prealigned-sensors-dir` points to different data during training vs annotation (e.g., HDD prealigned vs CSV-generated arrays), the value ranges differ and the normalization statistics (`norm_mean.npy`, `norm_std.npy`) don't apply correctly.

**Fix**: Always use the **same sensor directory** for both training and annotation:
```bash
# Training:
--prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor

# Annotation (must match):
--prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor
```

### Session ID mismatch

**Error**: `No common sessions found between EAF and manifest`

**Cause**: Session ID format differs (e.g., `2017-02-27-10-17-27` vs `201702271017`)

**Solution**: Scripts auto-normalize IDs, but verify with:
```bash
python twimo/strategies_eaf/check_csv_paths.py \
  --eaf-parsed-dir ./artifacts/eaf/parsed \
  --manifest ./artifacts/manifest.jsonl
```

---

## Advantages Over Proxy Labels

| Feature | Proxy Labels (Heuristic) | EAF Labels (Human-Annotated) |
|---------|--------------------------|------------------------------|
| Accuracy | Approximate | Ground-truth |
| Coverage | Full timeline | Sparse (only annotated segments) |
| Semantics | Inferred from sensors | Human judgment |
| Training | May learn spurious patterns | Learns true maneuvers |
| Evaluation | Unclear ground-truth | Clear ground-truth |

---

## Notes

- **Unlabeled segments**: Timesteps without EAF annotations are labeled as `unknown` (class 0)
- **Label normalization**: Bilingual labels (e.g., "右轉 right turn") are normalized to English ("right_turn")
- **Sparse annotations**: Not all timesteps have labels — this is expected for human annotations
- **Chinese support**: Use `build_all_vocabs_chinese.py` for bilingual EAF files

---

## Two-Stage YOLO Improved (Configurable Strategies)

The **Two-Stage YOLO Improved** pipeline (`two_stage_yolo_improved.py`) extends the standard YOLO pipeline with **8 independently selectable improvement strategies** targeting the most common failure modes: Stage 1 over-suppression, poor spatial context, label quality, class imbalance, and temporal coverage.

Only the **Transformer** architecture is supported in this script. For multi-model support with strategies, use `two_stage_yolo_multi_model_improved.py`.

### Active Feature Dimensions

| Strategies active | Detection dim | Total input dim |
|-------------------|--------------|----------------|
| None (base) | 13 | 21 |
| + `2` (zone) | 25 | 33 |
| + `2` + `5` (motion) | 30 | 38 |
| + `2` + `5` + `6` (top-K) | 39 | 47 |

### Strategies Reference

| Flag | Name | Needs | Effect |
|------|------|-------|--------|
| `1a` | Remove Stage 1 | — | Stage 2 on ALL windows; no event gate; Goal=unknown = "no event" |
| `1b` | Weaken Stage 1 | — | P(event) ≥ threshold (default 0.30) instead of argmax |
| `2` | Zone features | extract-improved | +12 ego-lane / adjacent / oncoming / sidewalk columns |
| `3` | Majority-vote labels | — | Window label = majority across all frames (vs mid-point only) |
| `4` | Class weights | — | Inverse-frequency loss weights for all 4 Stage 2 heads |
| `5` | Motion features | extract-improved | +5 approach speed / TTC proxy / scene-motion columns |
| `6` | Top-K tracking | extract-improved | +9 columns: (cx, cy, size) for 3 largest vehicles |
| `7` | Longer window | — | 10 s observation window instead of 5 s |

Strategies `1a` and `1b` are mutually exclusive — `1a` takes precedence.
Strategies `2`, `5`, `6` require running `extract-improved` to build the 39-dim cache.

### Step 1 — Extract Improved Detection Features

```bash
python twimo/strategies_eaf/two_stage_yolo_improved.py extract-improved \
    --manifest ./artifacts/manifest.jsonl \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --yolo-model yolov8n.pt \
    --sample-hz 3
```

Output: `<SESSION_ID>_det_imp.npy` — shape (T, 39) per session.

### Step 2 — Train with Strategies

```bash
# Strategies 1a + 2 + 3 + 4 (recommended combination)
python twimo/strategies_eaf/two_stage_yolo_improved.py train \
    --manifest ./artifacts/manifest.jsonl \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/two_stage_yolo_imp \
    --strategies 1a 2 3 4 \
    --epochs 40

# All strategies
python twimo/strategies_eaf/two_stage_yolo_improved.py train \
    --manifest ./artifacts/manifest.jsonl \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/two_stage_yolo_imp_all \
    --strategies 1a 2 3 4 5 6 7
```

Active strategies are saved to `config.json` and `strategies.json` inside the output directory.

### Step 3 — Evaluate

```bash
python twimo/strategies_eaf/two_stage_yolo_improved.py evaluate \
    --manifest ./artifacts/manifest.jsonl \
    --model-dir ./artifacts/eaf/two_stage_yolo_imp \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/eaf/eval_yolo_imp
```

---

## Two-Stage YOLO Multi-Model (Model Comparison with YOLO Features)

The **Two-Stage YOLO Multi-Model** pipeline (`two_stage_yolo_multi_model.py`) adds multi-model support to the standard YOLO pipeline. It imports training machinery from `two_stage_multi_model.py` and feature extraction from `two_stage_yolo.py` without modifying either.

**Script**: `twimo/strategies_eaf/two_stage_yolo_multi_model.py`

Input: 8 prealigned sensor features + 13 YOLO detection features = **21-D** combined.

### Available Models

| Family | Models |
|--------|--------|
| Neural | `gru`, `lstm`, `tcn`, `mlp_mean`, `mlp_max`, `mlp_concat` |
| Tree-based | `xgboost`, `lightgbm`, `random_forest` |
| Transformer | `transformer` (delegates to `two_stage_yolo.cmd_train`) |

### Step 1 — Extract YOLO Features

```bash
python -m twimo.strategies_eaf.two_stage_yolo_multi_model extract \
    --manifest ./artifacts/manifest.jsonl \
    --outdir ./artifacts/eaf/det_cache \
    --sample-hz 3
```

### Step 2 — Train

```bash
# XGBoost (fast, CPU-friendly)
python -m twimo.strategies_eaf.two_stage_yolo_multi_model train \
    --model xgboost \
    --manifest ./artifacts/manifest.jsonl \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/two_stage_yolo_xgb \
    --balance-ratio 0.5

# GRU
python -m twimo.strategies_eaf.two_stage_yolo_multi_model train \
    --model gru \
    --manifest ./artifacts/manifest.jsonl \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/two_stage_yolo_gru \
    --epochs 30
```

**Key options**:

| Option | Default | Description |
|--------|---------|-------------|
| `--balance-ratio` | None | Target event ratio after undersampling |
| `--event-threshold` | 0.5 | P(event) threshold for Stage 1 gate |
| `--window-sec` | 5.0 | Observation window in seconds |
| `--stride-sec` | 1.0 | Stride between windows |

**Outputs**: `config.json`, `norm_mean.npy`, `norm_std.npy`, `stage1.pt` / `stage1_tree.joblib`, `stage2.pt` / `stage2_tree.joblib`, `test_metrics.json`.

### Step 3 — Evaluate

```bash
python -m twimo.strategies_eaf.two_stage_yolo_multi_model evaluate \
    --manifest ./artifacts/manifest.jsonl \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir ./artifacts/eaf/vocabs \
    --model-dir ./artifacts/two_stage_yolo_xgb \
    --outdir ./artifacts/two_stage_yolo_xgb/eval
```

Output: `eval_metrics.json` — Stage1 F1, Goal F1, Stimuli F1, Oracle F1 (Stage 2 on ground-truth events).

---

## Two-Stage YOLO Multi-Model Improved (Multi-Model + Strategies)

The **Two-Stage YOLO Multi-Model Improved** pipeline (`two_stage_yolo_multi_model_improved.py`) is the most complete variant: it combines multi-model support with all 8 improvement strategies. No existing file is modified.

**Script**: `twimo/strategies_eaf/two_stage_yolo_multi_model_improved.py`

### Strategy Implementation per Model Family

| Strategy | Neural (GRU/LSTM/TCN/MLP) | Tree (XGBoost/LightGBM/RF) |
|----------|--------------------------|---------------------------|
| `1a` | Pass all-ones `ev_mask` to `_train_neural_s2` | Pass all-ones `ev_mask` to tree S2 |
| `1b` | Lower threshold to `--stage1-threshold` | Same |
| `2/5/6` | `_load_det_multi` selects from 39-dim cache | Same |
| `3` | Always active via `create_windows()` | Same |
| `4` | Boosted `focal_alpha=0.90` | `sklearn.compute_sample_weight("balanced")` |
| `7` | `window_sec = 10.0` | Same |

### Step 1 — Extract Features

```bash
# Standard 13-dim (for strategies 1a/1b/3/4/7)
python -m twimo.strategies_eaf.two_stage_yolo_multi_model_improved extract \
    --manifest ./artifacts/manifest.jsonl \
    --outdir ./artifacts/eaf/det_cache \
    --sample-hz 3

# Extended 39-dim (for strategies 2/5/6)
python -m twimo.strategies_eaf.two_stage_yolo_multi_model_improved extract-improved \
    --manifest ./artifacts/manifest.jsonl \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --sample-hz 3
```

The script auto-selects the 39-dim cache when available and falls back to 13-dim with zero-padding (with a warning) when strategies 2/5/6 are active but only the standard cache is present.

### Step 2 — Train with Strategies

```bash
# XGBoost: remove Stage 1 gate + zone features + class weights
python -m twimo.strategies_eaf.two_stage_yolo_multi_model_improved train \
    --model xgboost \
    --manifest ./artifacts/manifest.jsonl \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/two_stage_yolo_xgb_imp \
    --strategies 1a 2 4

# GRU: all strategies
python -m twimo.strategies_eaf.two_stage_yolo_multi_model_improved train \
    --model gru \
    --manifest ./artifacts/manifest.jsonl \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/two_stage_yolo_gru_imp \
    --strategies 1a 2 4 5 6 7

# Weaken Stage 1 (soft threshold) instead of removing it
python -m twimo.strategies_eaf.two_stage_yolo_multi_model_improved train \
    --model xgboost \
    --manifest ./artifacts/manifest.jsonl \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir ./artifacts/eaf/vocabs \
    --outdir ./artifacts/two_stage_yolo_xgb_1b \
    --strategies 1b 4 \
    --stage1-threshold 0.30
```

Active strategies are stored in `config.json` and automatically restored at evaluation time.

### Step 3 — Evaluate

```bash
python -m twimo.strategies_eaf.two_stage_yolo_multi_model_improved evaluate \
    --manifest ./artifacts/manifest.jsonl \
    --prealigned-sensors-dir ./artifacts/eaf/sensors_v2/sensor \
    --det-cache-dir ./artifacts/eaf/det_cache_imp \
    --eaf-parsed-dir ./artifacts/eaf/parsed \
    --vocab-dir ./artifacts/eaf/vocabs \
    --model-dir ./artifacts/two_stage_yolo_xgb_imp \
    --outdir ./artifacts/two_stage_yolo_xgb_imp/eval
```

Output: `eval_metrics.json` — Stage1 F1, Goal F1, Stimuli F1, Oracle F1, `strategies_active` list.

### Full Pipeline Comparison Table

| Aspect | Two-Stage YOLO | YOLO Multi-Model | YOLO Improved | YOLO Multi-Model Improved |
|--------|---------------|-----------------|---------------|--------------------------|
| **Script** | `two_stage_yolo.py` | `two_stage_yolo_multi_model.py` | `two_stage_yolo_improved.py` | `two_stage_yolo_multi_model_improved.py` |
| **Models** | Transformer only | 10 model families | Transformer only | 10 model families |
| **Strategies** | None | None | 8 strategies | 8 strategies |
| **Prediction heads** | 4 (Goal/Stim/Cause/Att) | 2 (Goal + Stimuli) | 4 (Goal/Stim/Cause/Att) | 2 (Goal + Stimuli) |
| **Detection dim** | 13 | 13 | Up to 39 | Up to 39 |
| **Total input dim** | 21 | 21 | Up to 47 | Up to 47 |

---

## References

- ELAN: https://archive.mpi.nl/tla/elan
- EAF Format Specification: https://www.mpi.nl/tools/elan/EAF_Annotation_Format_3.0_and_ELAN.pdf
- TWIMO docs: `../README.md`
