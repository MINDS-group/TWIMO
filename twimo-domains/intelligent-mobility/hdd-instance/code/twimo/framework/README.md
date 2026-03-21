# Framework - Digital Twin Engineering Metamodel

This folder contains the **core architecture** of TWIMO, implementing the **DTE (Digital Twin Engineering) metamodel** from the framework specification.

The framework files are aligned with two architecture references:
- **`twim.ecore`** — DTE metamodel
- **`TWIMO_Use_Case_Scenarios_Diagram.png`** — EAF architecture diagram (the canonical implementation blueprint)

| File | Purpose |
|------|---------|
| [`twimo_components.py`](twimo_components.py) | Design-time framework components |
| [`twimo_objects.py`](twimo_objects.py) | Runtime execution objects |
| [`runner.py`](runner.py) | **Programmatic pipeline executor** — bridges framework objects to CLI |

---

## 3. Programmatic Runner (`runner.py`)

`TwimoRunner` is the **executor** layer. It lets you run the entire TWIMO pipeline from Python by calling methods on a `DigitalTwin` config object — no CLI required.

### Architecture

```
instantiate_hdd_driving_behavior_twin()
    └─> DigitalTwin  (design config, twimo_components.py)
            └─> TwimoRunner  (adapter, runner.py)
                    └─> cmd_* functions  (execution, twimo/cli.py)
                            └─> models / dt / xai / data  (unchanged)
```

No changes to any model, data, or simulation code. The runner only translates framework objects into `argparse.Namespace` objects and calls the existing CLI functions.

---

### Quickstart — full pipeline

```python
from twimo.framework.runner import TwimoRunner
from twimo.framework.twimo_components import instantiate_hdd_driving_behavior_twin

# 1. Define the Digital Twin blueprint
twin = instantiate_hdd_driving_behavior_twin(
    root="./example_data",   # path to HDD sessions (for dataset metadata)
    sample_hz=3.0,
    extractor="none",        # "torch" | "eaf" | "yolo" | "none"
)

# 2. Create the runner (needs the manifest path)
runner = TwimoRunner(twin=twin, manifest="./artifacts/manifest.jsonl")

# 3. Run the full pipeline (all 4 DTE phases)
runner.full_pipeline(
    artifacts_dir="./artifacts",
    train_epochs=5,
    dt_sample_hz=3.0,
    style_k=3,
    explain_every_steps=50,
)
```

**Equivalent CLI commands:**
```bash
python -m twimo.cli train-maneuver \
    --manifest ./artifacts/manifest.jsonl \
    --outdir   ./artifacts/maneuver_transformer \
    --model    transformer --sample-hz 3 --epochs 5

python -m twimo.cli simulate-dt-optimized \
    --manifest ./artifacts/manifest.jsonl \
    --outdir   ./artifacts/dt_optimized \
    --sample-hz 3

python -m twimo.cli train-style \
    --manifest ./artifacts/manifest.jsonl \
    --outdir   ./artifacts/style --k 3

python -m twimo.cli explain \
    --manifest ./artifacts/manifest.jsonl \
    --modeldir ./artifacts/maneuver_transformer \
    --outdir   ./artifacts/explain \
    --explain-every-steps 50
```

---

### Step-by-step commands

#### Scan dataset

```python
runner.scan(
    root="./example_data",
    out="./artifacts/manifest.jsonl",
    # optional prealigned arrays:
    prealigned_labels_dir="./twimo/assets/hdd_prealigned/20200710_labels/target",
    prealigned_sensors_dir="./twimo/assets/hdd_prealigned/20200710_sensors/sensor",
)
```

**Equivalent CLI:**
```bash
python -m twimo.cli scan \
    --root ./example_data \
    --out  ./artifacts/manifest.jsonl \
    --prealigned-labels-dir  ./twimo/assets/hdd_prealigned/20200710_labels/target \
    --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor
```

---

#### Train maneuver model

```python
runner.train_maneuver(
    outdir="./artifacts/maneuver_transformer",
    model="transformer",      # default: twin.driving_model.model_type
    sample_hz=3.0,            # default: twin.perception.sample_hz
    epochs=5,
    batch_size=64,
    horizons=[0.1, 0.25, 0.5, 0.75, 1.0, 2.0, 3.0, 4.0, 5.0],
)
```

**Equivalent CLI:**
```bash
python -m twimo.cli train-maneuver \
    --manifest  ./artifacts/manifest.jsonl \
    --outdir    ./artifacts/maneuver_transformer \
    --model     transformer \
    --sample-hz 3 \
    --epochs    5
```

**Outputs saved:**
- `model.pth` / `model.joblib` — trained weights
- `config.json` — model hyperparameters
- `test_metrics.json`, `val_metrics.json`, `train_metrics.json` — metrics per horizon
- `roc_curves.json` — per-class ROC curves
- `predictor_metadata.json` — DTE `Predictor` record
- `twin_config.json` — DTE `DigitalTwin` blueprint

---

#### Simulate Digital Twin (basic)

```python
runner.simulate_dt(
    outdir="./artifacts/dt_eval",
    sample_hz=10.0,
    wheelbase=2.7,
    save_traj=True,   # optional: save per-session CSVs
)
```

**Equivalent CLI:**
```bash
python -m twimo.cli simulate-dt \
    --manifest  ./artifacts/manifest.jsonl \
    --outdir    ./artifacts/dt_eval \
    --sample-hz 10 \
    --wheelbase 2.7
```

---

#### Simulate Digital Twin (optimized — recommended)

```python
runner.simulate_dt_optimized(
    outdir="./artifacts/dt_optimized",
    sample_hz=3.0,
    calibrate=True,       # auto-calibrate per session
    use_reset=True,       # periodic GPS reset (eliminates drift)
    reset_interval=30,    # reset every 30 steps = 10s at 3Hz
)
```

**Equivalent CLI:**
```bash
python -m twimo.cli simulate-dt-optimized \
    --manifest  ./artifacts/manifest.jsonl \
    --outdir    ./artifacts/dt_optimized \
    --sample-hz 3
```

**Outputs saved:**
- `dt_optimized_summary.json` — per-session RMSE/MAE metrics
- `dt_optimized_aggregated_metrics.json` — global statistics
- `twin_run.json` — DTE `Run` record

---

#### Cluster driving styles

```python
runner.train_style(
    outdir="./artifacts/style",
    k=3,   # number of clusters
)
```

**Equivalent CLI:**
```bash
python -m twimo.cli train-style \
    --manifest  ./artifacts/manifest.jsonl \
    --outdir    ./artifacts/style \
    --k 3
```

---

#### Generate explanations

```python
runner.explain(
    modeldir="./artifacts/maneuver_transformer",
    outdir="./artifacts/explain",
    explain_every_steps=50,
)
```

**Equivalent CLI:**
```bash
python -m twimo.cli explain \
    --manifest  ./artifacts/manifest.jsonl \
    --modeldir  ./artifacts/maneuver_transformer \
    --outdir    ./artifacts/explain \
    --explain-every-steps 50
```

**Outputs saved:**
- `explanations__<day>.jsonl` — per-day explanation records (DTE `Explanation`)
- `explain_index.json` — index of generated files

---

### Choosing a different model

```python
# XGBoost (fast, no GPU needed)
twin_xgb = instantiate_hdd_driving_behavior_twin(root="./example_data", sample_hz=3.0)
twin_xgb.driving_model.model_type = "xgboost"

runner_xgb = TwimoRunner(twin=twin_xgb, manifest="./artifacts/manifest.jsonl")
runner_xgb.train_maneuver(outdir="./artifacts/maneuver_xgboost")
```

Available models: `transformer` | `xgboost` | `lightgbm` | `random_forest` | `gru` | `lstm` | `tcn` | `mlp_mean` | `mlp_max` | `mlp_concat` | `baseline`

---

### With video fusion (Supervision C / torch extractor)

```python
twin_video = instantiate_hdd_driving_behavior_twin(
    root="./example_data",
    sample_hz=3.0,
    extractor="torch",          # activates use_video=True automatically
)
runner_video = TwimoRunner(twin=twin_video, manifest="./artifacts/manifest.jsonl")
runner_video.train_maneuver(
    outdir="./artifacts/maneuver_transformer_video",
    video_extractor="mobilenet_v3_small",
)
```

**Equivalent CLI:**
```bash
python -m twimo.cli train-maneuver \
    --manifest       ./artifacts/manifest.jsonl \
    --outdir         ./artifacts/maneuver_transformer_video \
    --model          transformer \
    --use-video \
    --video-extractor mobilenet_v3_small
```

---

## What's in This Folder?

| File | Purpose | DTE Phase |
|------|---------|-----------|
| [`twimo_components.py`](twimo_components.py) | Design-time framework components | **Design** |
| [`twimo_objects.py`](twimo_objects.py) | Runtime execution objects | **Build, Validate, Evolve** |

---

## 1. Design-Time Components (`twimo_components.py`)

**Purpose**: Defines the **architecture blueprint** of a Digital Twin before it runs.

### SupervisionMode (new)

Enum capturing the three data-labelling paths from the PNG VM02 architecture (left column):

```python
class SupervisionMode(str, Enum):
    PROXY_HEURISTIC = "proxy"   # Path A — csv_session.py threshold rules
    EAF_EXPERT      = "eaf"     # Path B — ELAN/EAF expert annotation
    YOLO_DETECTION  = "yolo"    # Path C — offline YOLOv8 feature extraction
```

**DTE Mapping**: data provenance concept — not in original metamodel, added per VM02 PNG.

---

### DataSource

```python
@dataclass
class DataSource:
    name: str       # "front_camera" | "can_bus" | "actions"
    modality: str   # 'video' | 'sensors' | 'labels'
    path: str
```

**DTE Mapping**: `model.dataAndEvidence.Dataset → DataSource`
**Implementation**: `twimo/data/csv_loaders.py`, `twimo/data/prealigned.py`

---

### Dataset

```python
@dataclass
class Dataset:
    name: str
    sources: List[DataSource]
```

**DTE Mapping**: `model.dataAndEvidence.Dataset`
**Implementation**: `twimo/data/csv_session.py`, `twimo/data/manifest.py`

---

### DigitalShadow (new)

The central concept of the PNG VM02 architecture — the **Time-Aligned Shadow** that fuses all data streams.

```python
@dataclass
class DigitalShadow:
    name: str
    dataset: Dataset
    perception: PerceptionService
    supervision_mode: SupervisionMode
    sample_hz: float
    n_features: int   # 60+ sensors-only | 33 sensors+yolo-13 | 58 sensors+yolo-39
```

**DTE Mapping**: `model.DigitalShadow`
**PNG Layer**: Digital Shadow (Data-Centric) → Time-Aligned Shadow
**Implementation**: `twimo/data/csv_session.py`, `twimo/data/prealigned.py`, `twimo/strategies_eaf/two_stage_yolo.py`

---

### PerceptionService

```python
@dataclass
class PerceptionService:
    name: str
    extractor: str   # 'torch' | 'eaf' | 'yolo' | 'none'
    sample_hz: float
```

**DTE Mapping**: `model.aiBasedServices.perception.PerceptionService`
**PNG Layer**: Digital Shadow → EAF Alignment / YOLOv8 Feature Extraction

| Extractor | Description | Implementation |
|-----------|-------------|----------------|
| `torch`   | CNN video features (ResNet18, MobileNetV3) | `twimo/video/torch_extractor.py` |
| `eaf`     | ELAN Tiers → frame-aligned labels (Supervision B) | `twimo/strategies_eaf/align_eaf_to_sensors*.py` |
| `yolo`    | Offline YOLOv8 detection features, cached .npy (Supervision C) | `twimo/strategies_eaf/two_stage_yolo.py` |
| `none`    | Sensor data only, no perception | — |

---

### ControlService (new)

```python
@dataclass
class ControlService:
    name: str
    regressor_type: str   # 'ground_truth' | 'kinematic' | 'ml_regressor' (future)
    input_type: str       # 'ground_truth_sensors' | 'predicted_maneuver'
```

**DTE Mapping**: `model.aiBasedServices.PlanningService` (partially)
**PNG Layer**: Digital Twin → Control Commands Regressor + Maneuver to Control Commands
**Implementation (open-loop)**: `twimo/dt/simulator.py` — uses ground-truth steer+vel from CSV.
**Closed-loop**: NOT YET IMPLEMENTED (future work).

---

### DrivingModel

```python
@dataclass
class DrivingModel:
    name: str
    task: str        # 'maneuver' | 'style' | 'explain'
    model_type: str  # 'transformer' | 'xgboost' | 'kmeans' | 'gru' | 'lstm' | 'tcn' | ...
    params: Dict[str, str]
```

**DTE Mapping**: `drivingBehaviour.DrivingModel`
**PNG Layer**: Digital Twin → Driver Behaviour DT (AI Service)
**Implementation**: `twimo/models/`

---

### VisualizationService (new)

```python
@dataclass
class VisualizationService:
    name: str
    renderer: str       # 'video_annotator' | 'dashboard'
    output_format: str  # 'mp4' | 'json' | 'html'
```

**DTE Mapping**: new concept per PNG VM02 architecture (not in original metamodel)
**PNG Layer**: Digital Twin → Video Annotation Renderer / Data Visualization (AI Service)
**Implementation**: `twimo/plots/annotate_video_eaf_yolo.py`, `twimo/plots/annotate_video_eaf.py`, `twimo/plots/annotate_video.py`

---

### DigitalTwin

```python
@dataclass
class DigitalTwin:
    name: str
    physical_system: str
    dataset: Dataset
    perception: PerceptionService
    driving_model: DrivingModel
```

**DTE Mapping**: `digitalTwin.DigitalTwin`
**PNG Layer**: Digital Twin (Executable Models)
**Implementation**: assembled by `twimo/cli.py` commands; serialized to `<outdir>/twin_config.json`

---

### Factory Function

**`instantiate_hdd_driving_behavior_twin(root, sample_hz, extractor)`**

Creates a pre-configured Digital Twin for Honda Driving Dataset (HDD).

```python
twin = instantiate_hdd_driving_behavior_twin(
    root="./example_data",
    sample_hz=3.0,
    extractor="torch"  # or "yolo", "eaf", "none"
)
# Output: DigitalTwin("DrivingBehaviorTwin", "Vehicle + Driver", ...)
```

Called from `twimo/cli.py` (`cmd_train_maneuver`); output saved to `<outdir>/twin_config.json`.

---

## 2. Runtime Objects (`twimo_objects.py`)

**Purpose**: Defines **runtime instances** created during execution.

### Dataset (Runtime)

```python
@dataclass
class Dataset:
    name: str
    modalities: List[str]
    source: str
```

---

### Feature

```python
@dataclass
class Feature:
    name: str    # "steer.steer_angle"
    dtype: str   # 'float32' | 'int64' | 'bool'
```

**DTE Mapping**: `model.dataAndEvidence.Feature`
**Implementation**: `feature_names.json` in each model artifact directory

---

### DigitalShadow (Runtime, new)

```python
@dataclass
class DigitalShadow:
    session_id: str
    feature_names: List[str]
    n_timesteps: int
    sample_hz: float
    supervision_mode: str   # 'proxy' | 'eaf' | 'yolo'
    array_path: str         # path to .npy file or '' for in-memory
```

**DTE Mapping**: `model.DigitalShadow` (runtime)
**PNG Layer**: Digital Shadow → Time-Aligned Shadow artifact

---

### Goal / Stimulus / Cause / AttentionCue (new)

Four `drivingBehaviour` dataclasses matching the EAF taxonomy:

```python
@dataclass
class Goal:
    label: str        # from vocab_goal.json (14 classes)
    confidence: float

@dataclass
class Stimulus:
    label: str        # from vocab_stimuli.json (9 classes)
    confidence: float

@dataclass
class Cause:
    label: str        # from vocab_cause.json (17 classes)
    confidence: float

@dataclass
class AttentionCue:
    label: str        # from vocab_attention.json (17 classes)
    confidence: float
```

**DTE Mapping**: `drivingBehaviour.Goal/Stimulus/Cause/AttentionCue`
**PNG Layer**: Digital Shadow → EAF Alignment (ELAN Tiers)
**Implementation**: `twimo/strategies_eaf/two_stage_yolo_improved.py` (ClassifyNet heads), vocab JSONs in `twimo/strategies_eaf/`

---

### Predictor

```python
@dataclass
class Predictor:
    name: str
    horizons_sec: List[float]   # [0.1, 0.25, 0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0]
    model_type: str
    artifacts: Dict[str, Any]
```

**DTE Mapping**: `model.aiBasedServices.prediction.Predictor`
**PNG Layer**: Digital Twin → Driver Behaviour DT
**Implementation**: all models in `twimo/models/`; serialized to `<outdir>/predictor_metadata.json`

---

### DrivingModel (Runtime)

```python
@dataclass
class DrivingModel:
    driver_id: str
    vehicle_id: str
    environment_id: str
    predictor: Predictor
    dataset: Dataset
```

---

### DigitalTwin (Runtime)

```python
@dataclass
class DigitalTwin:
    twin_id: str
    physical_system: str
    driving_model: DrivingModel
    purpose: str   # 'training' | 'validation' | 'deployment'
```

---

### Run

```python
@dataclass
class Run:
    run_id: str
    twin: DigitalTwin
    config: Dict[str, Any]
    metrics: Dict[str, float]
```

**DTE Mapping**: `digitalTwin.Run`
**PNG Layer**: Release & Validation → DT Validation Comparator
**Implementation**: serialized to `<outdir>/twin_run.json` by `cmd_simulate_dt` and `cmd_simulate_dt_optimized`

---

### Explanation

```python
@dataclass
class Explanation:
    explanation_type: str   # 'rule_based' | 'saliency'
    content: str            # human-readable text  (JSONL field: 'text')
    confidence: float       # [0.0 - 1.0]          (JSONL field: 'probability')
    references: Dict[str, Any]   # semantics: {braking, turning, ...}
    session_id: str = ""
    horizon_steps: int = 0
    t_index: int = 0
    predicted_label: int = 0
```

**DTE Mapping**: `explainability.Explanation`
**PNG Layer**: Digital Twin → Explanability (AI Service)
**Implementation**: `twimo/xai/explain.py` imports this class from `twimo_objects` (no local duplicate).
**Serialized to**: `artifacts/explain/explanations__<day>.jsonl`

---

## DTE Metamodel Phases

| Phase | What | Implementation |
|-------|------|----------------|
| **Design** | Define entities, granularity, relationships | `twimo_components.py` (DigitalTwin blueprint) |
| **Build** | Create models from data | `twimo/cli.py cmd_train_maneuver` → `predictor_metadata.json` |
| **Validate** | Test against physical reality | `twimo/cli.py cmd_simulate_dt` → `twin_run.json` |
| **Evolve** | Explain and improve | `twimo/cli.py cmd_explain` → `explanations__*.jsonl` |

---

## PNG VM02 Architecture → DTE Metamodel → Code Mapping

### Digital Shadow Layer (PNG VM02)

| PNG Component | DTE Concept | Code Location |
|---|---|---|
| EAF Alignment (Tiers→Frames) | `PerceptionService(extractor='eaf')` | `twimo/strategies_eaf/align_eaf_to_sensors*.py` |
| YOLOv8 Feature Extraction | `PerceptionService(extractor='yolo')` | `twimo/strategies_eaf/two_stage_yolo.py` |
| Proxy Label Generator | `SupervisionMode.PROXY_HEURISTIC` | `twimo/data/csv_session.py` |
| Ingestion + Sync (3 Hz) | `Dataset` + `DigitalShadow` | `twimo/data/csv_session.py resample_sensors()` |
| Feature Engineering (60+) | `Feature` list | `twimo/data/csv_session.py load_sensors_from_csv_dir()` |
| **Time-Aligned Shadow** | `DigitalShadow` | `.npy` prealigned arrays + feature DataFrames |

### Digital Twin Layer (PNG VM02)

| PNG Component | DTE Concept | Code Location |
|---|---|---|
| Driver Behaviour DT | `DrivingModel` + `Predictor` | `twimo/models/maneuver_transformer.py` + all models |
| Control Commands Regressor | `ControlService(input='ground_truth')` | `twimo/dt/simulator.py` (open-loop) |
| Maneuver to Control Commands | `ControlService` (future closed-loop) | NOT YET IMPLEMENTED |
| Vehicle DT (Bicycle Model) | `digitalTwin.DigitalTwin` (simulation) | `twimo/dt/simulator.py` |
| Explanability | `Explanation` | `twimo/xai/explain.py` |
| Video Annotation Renderer | `VisualizationService` | `twimo/plots/annotate_video_eaf_yolo.py` |
| Data Visualization | `VisualizationService` | `twimo/plots/` |

### EAF Tiers (drivingBehaviour package)

| ELAN Tier | DTE Concept | Code Location |
|---|---|---|
| Tier 3 — Stimulus | `Stimulus` | `vocab_stimuli.json` (9 classes), ClassifyNet head |
| Tier 4 — Cause | `Cause` | `vocab_cause.json` (17 classes), ClassifyNet head |
| Tier 5 — Goal | `Goal` | `vocab_goal.json` (14 classes), ClassifyNet head |
| Tier 6 — Attention | `AttentionCue` | `vocab_attention.json` (17 classes), ClassifyNet head |

---

## Output Artefacts and DTE Mapping

Each CLI command now saves explicit framework metadata alongside its results:

| File | Command | DTE Object |
|------|---------|-----------|
| `twin_config.json` | `train-maneuver` | `DigitalTwin` (design blueprint) |
| `predictor_metadata.json` | `train-maneuver` | `Predictor` |
| `twin_run.json` | `simulate-dt`, `simulate-dt-optimized` | `Run` |
| `test_metrics.json` | `train-maneuver` | `Run.metrics` (subset) |
| `explanations__<day>.jsonl` | `explain` | `Explanation` |

---

## Relationship to PlantUML Framework (VM01)

### Fully Implemented

| PlantUML Package | TWIMO Implementation |
|------------------|----------------------|
| `digitalTwin.DigitalTwin` | `twimo_components.DigitalTwin` + `twimo_objects.DigitalTwin` + `twin_config.json` |
| `digitalTwin.Run` | `twimo_objects.Run` + `twin_run.json` |
| `model.DigitalShadow` | `twimo_components.DigitalShadow` + `twimo_objects.DigitalShadow` + `.npy` arrays |
| `model.aiBasedServices.prediction.Predictor` | `twimo_objects.Predictor` + `predictor_metadata.json` |
| `model.aiBasedServices.perception.PerceptionService` | `twimo_components.PerceptionService` (extractor: torch/eaf/yolo/none) |
| `model.dataAndEvidence.Dataset` | `twimo_components.Dataset` + `twimo_objects.Dataset` |
| `model.dataAndEvidence.Feature` | `twimo_objects.Feature` + `feature_names.json` |
| `drivingBehaviour.DrivingModel` | `twimo_components.DrivingModel` + `twimo_objects.DrivingModel` |
| `drivingBehaviour.Goal` | `twimo_objects.Goal` + `vocab_goal.json` + ClassifyNet head |
| `drivingBehaviour.Stimulus` | `twimo_objects.Stimulus` + `vocab_stimuli.json` + ClassifyNet head |
| `drivingBehaviour.Cause` | `twimo_objects.Cause` + `vocab_cause.json` + ClassifyNet head |
| `drivingBehaviour.AttentionCue` | `twimo_objects.AttentionCue` + `vocab_attention.json` + ClassifyNet head |
| `explainability.Explanation` | `twimo_objects.Explanation` (canonical) + `xai/explain.py` + JSONL output |

### New Concepts (from PNG VM02, not in original metamodel)

| Concept | TWIMO Implementation |
|---------|----------------------|
| `SupervisionMode` enum | `twimo_components.SupervisionMode` (A/B/C paths) |
| `VisualizationService` | `twimo_components.VisualizationService` + `twimo/plots/` |
| `ControlService` | `twimo_components.ControlService` (open-loop: ground_truth) |

### Implicit / Future Work

| PlantUML Package | Status |
|------------------|--------|
| `drivingBehaviour.Intent` | ⚠️ Implicit — ELAN Tier 1 annotations, no dataclass |
| `drivingBehaviour.Maneuver` | ⚠️ Implicit — predicted label int, no dataclass |
| `drivingBehaviour.Action` | ⚠️ Implicit — sensor commands (steer_angle, pedal_pressure) |
| `model.aiBasedServices.PlanningService` (closed-loop) | ❌ Future work — `ControlService.regressor_type='ml_regressor'` |
| `federation.FederatedDT` | ❌ Future work |

---

## Architectural Gap: Open-Loop vs Closed-Loop DT

The PNG VM02 architecture shows a **closed-loop** pipeline:
```
ManeuverPredictor → ControlCommandsRegressor (ML) → VehicleDT → DTComparator
```

The current implementation is **open-loop**:
```
ground-truth steer_angle + velocity (from CSV) → VehicleDT → DTComparator
```

`ControlService.regressor_type = 'ground_truth'` captures this explicitly.
A closed-loop implementation would require a new regression model in `twimo/models/`
predicting steer+velocity from the predicted maneuver class.

---

## References

- **PNG VM02 Architecture**: `TWIMO_VM02_EAF_Diagram_new.png` (canonical blueprint)
- **PlantUML Metamodel**: `VM01-extended_twimo_framework.puml`
- Main README: [../README.md](../README.md)
- Data Loading: [../data/README.md](../data/README.md)
- Models: [../models/MODELS_OVERVIEW.md](../models/MODELS_OVERVIEW.md)
- Digital Twin: [../dt/README.md](../dt/README.md)
- Explainability: [../xai/README.md](../xai/README.md)
- EAF Strategies: `../strategies_eaf/` (two_stage_yolo.py, two_stage_yolo_improved.py)

---

**Last Updated**: 2026-02-24
