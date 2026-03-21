# TWIMO Framework - Digital Twin Engineering for Driving Behaviour

TWIMO is a **Digital Twin Engineering (DTE) framework** applied to intelligent mobility. It creates digital replicas of driving sessions to predict driver behavior, simulate vehicle motion, and analyze driving styles.

---

## Framework Architecture

TWIMO implements the **DTE metamodel** across four phases:

| Phase | Purpose | Implementation |
|-------|---------|----------------|
| **Design** | Define entities, granularity, relationships | [framework/](framework/) - Core components and domain objects |
| **Build** | Create models from data | [models/](models/), [data/](data/), [features/](features/) |
| **Validate** | Test against physical reality | [dt/](dt/) - Digital Twin simulation |
| **Evolve** | Improve and explain | [xai/](xai/), [analysis/](analysis/), [visualization/](visualization/) |

---

## Package Mapping: Theory → Implementation

### 1. DTE Layer (Framework Metamodel)

**Location**: [`framework/`](framework/)

**Purpose**: Defines the core architecture and domain objects for the Digital Twin.

**Components**:
- `twimo_components.py` - Core framework components (DigitalTwin, Model, AIService)
- `twimo_objects.py` - Domain objects (Driver, Vehicle, Environment, Intent, Maneuver, Action)

**DTE Metamodel Mapping**:
- **Entities**: Driver, Vehicle, Environment, Stimulus, Maneuver
- **Granularity**: Session-level (individual driving runs)
- **Relationships**: Perception → Intention → Action chain

---

### 2. Digital Twin Package

**Location**: [`dt/`](dt/)

**Purpose**: Simulates vehicle motion using physics models and validates against GPS data.

**Components**:
- `simulator.py` - Kinematic bicycle model
- `dt_optimized.py` - Auto-calibrated simulation with drift correction

**DTE Mapping**:
- **DigitalTwin**: Session-level digital replica
- **Run**: Individual driving session
- **PredictedRun**: ML-generated synthetic run
- **TimePeriod**: Temporal segmentation (30s windows)

**Key Functions**:
- Simulate vehicle trajectory from sensor inputs (steering, velocity)
- Validate against RTK GPS (RMSE < 200m with optimization)
- Test ML predictions for physical plausibility

See [dt/README.md](dt/README.md) for details.

---

### 3. Model Package

#### 3.1. Digital Shadow

**Location**: [`data/`](data/)

**Purpose**: Loads, synchronizes, and resamples heterogeneous sensor data into a unified timeline.

**DTE Mapping**:
- **DigitalShadow**: Synchronized sensor representation of physical asset
- **DataSource**: CSV files (velocity, steering, brake, accelerator)
- **Resampling**: Uniform 3 Hz grid (linear interpolation for numeric, nearest for binary)

**Components**:
- `csv_session.py` - Sensor loading and resampling
- `manifest.py` - Session registry (JSONL)
- `scan_hdd.py` - Dataset scanner (Honda Driving Dataset)

See [data/README.md](data/README.md) for details.

---

#### 3.2. AI-Based Services

##### 3.2.1. Perception Services

**Location**: [`video/`](video/)

**Purpose**: Extract visual features from dashboard camera using CNN backbones.

**DTE Mapping**:
- **PerceptionService**: Video understanding
- **ObjectDetector**: ResNet18, MobileNetV3 feature extractors
- **SceneUnderstanding**: Frame-level embeddings

**Components**:
- `ffmpeg_reader.py` - Frame extraction
- `torch_extractor.py` - CNN feature extraction (ResNet18, MobileNetV3)

See [video/README.md](video/README.md) for details.

---

##### 3.2.2. Prediction Services

**Location**: [`models/`](models/)

**Purpose**: Predict driver actions (turn, brake, accelerate) using ML models.

**DTE Mapping**:
- **PredictionService**: Maneuver prediction
- **Predictor**: Multi-horizon forecasting (0.1s, 0.5s, 1.0s, 2.0s, 3.0s)
- **PredictiveModel**: 11 model architectures

**Available Models**:
- `maneuver_transformer.py` - Transformer (best accuracy)
- `xgboost_model.py` - XGBoost (fast, CPU-friendly)
- `lightgbm_model.py` - LightGBM (memory efficient)
- `gru_lstm_model.py` - GRU/LSTM (sequential patterns)
- `tcn_model.py` - Temporal Convolutional Network
- `random_forest_model.py` - Random Forest (robust)
- `mlp_pooling_model.py` - MLP with pooling (simple baseline)
- `baseline_window.py` - Auto-fallback (XGBoost or Random Forest)

**Feature Engineering**: [`features/`](features/)
- `elan_parser.py` - Parse ELAN annotations (Intent, Maneuver, Stimulus labels)
- `feature_extractor.py` - 40+ temporal features (velocity, acceleration, jerk, composite metrics)

See [models/MODELS_OVERVIEW.md](models/MODELS_OVERVIEW.md) and [features/README.md](features/README.md) for details.

---

##### 3.2.3. Planning & Decision Making Services

**Status**: Future work (not yet implemented)

**Planned Components**:
- Path planning (trajectory optimization)
- Decision making (lane change, overtake)
- Maneuver optimization

---

##### 3.2.4. Evaluation Services

**Location**: [`analysis/`](analysis/)

**Purpose**: Assess performance, cluster behaviors, detect events, analyze sequences.

**DTE Mapping**:
- **EvaluationService**: Performance and safety analysis
- **SafetyValidator**: Risk assessment (implicit in clustering)
- **PerformanceAnalyzer**: Hierarchical behavior analysis

**Components**:
- `style_clustering.py` - K-means clustering (prudent/smooth/aggressive)
- `hierarchical_clustering.py` - 3-level clustering (Style → Context → Behaviors)
- `temporal_segmentation.py` - Time-windowed analysis (30s windows)
- `event_detection.py` - Detect critical events (hard braking, sharp turns)
- `action_recognition.py` - Classify maneuvers from sensors
- `sequential_modeling.py` - Markov chains (action transitions)

See [analysis/README.md](analysis/README.md) for details.

---

#### 3.3. Data & Evidence Package

**Location**: [`data/`](data/), [`features/`](features/)

**DTE Mapping**:
- **Dataset**: Honda Driving Dataset (HDD)
- **DatasetCategory**: DRIVER_CENTRIC, VEHICLE_CENTRIC, TRAFFIC_CENTRIC, MULTI_MODAL
- **Annotation**: ELAN XML annotations (Intent, Maneuver, Stimulus, Goal)
- **Label**: Ground-truth or heuristic-derived (6 classes: STRAIGHT, TURN_LEFT, TURN_RIGHT, BRAKE, ACCEL, STOP)
- **Feature**: Sensor channels (velocity, steering, brake, accelerator)
- **VolatileFeature**: Time-varying features (acceleration, jerk)
- **Metric**: Performance metrics (RMSE, F1-score, accuracy)
- **EvidenceArtifact**: Model outputs, validation reports

**Heuristic Label Generation** (when ground-truth unavailable):
```python
# twimo/data/csv_session.py - derive_proxy_actions()
if velocity < 0.5:      → STOP
if steer_angle > 3°:    → TURN_RIGHT
if steer_angle < -3°:   → TURN_LEFT
if brake_pressure > 20: → BRAKE
if accel_angle > 20:    → ACCEL
else:                   → STRAIGHT
```

See [data/README.md](data/README.md) and [features/README.md](features/README.md) for details.

---

### 4. Driving Behaviour Package

**Location**: [`framework/twimo_objects.py`](framework/twimo_objects.py)

**Purpose**: Models the Perception → Intention → Action chain for driver behavior.

**DTE Mapping**:
- **DrivingModel**: Composite model (Driver + Vehicle + Environment)
- **Driver**: Human agent with intents, goals, maneuvers
- **Vehicle**: Physical asset (steering, velocity, wheelbase)
- **Environment**: Traffic context (road type, weather, time of day)

**Behavior Chain**:
```
Stimulus (cause) → AttentionCue → Intent (goal) → Maneuver (action)
```

**Components**:
- **Stimulus**: External event (e.g., pedestrian crossing, traffic light)
- **Cause**: Root cause of stimulus
- **AttentionCue**: Driver attention focus (visual, auditory)
- **Intent**: Driver intention (e.g., "prepare to turn left")
- **Goal**: Driver objective (goal-driven vs stimulus-driven)
- **Maneuver**: Physical action sequence (e.g., "brake + steer left")
- **Action**: Atomic control command (steer angle, pedal pressure)

**ELAN Annotation Tiers** (parsed by `features/elan_parser.py`):
- Tier 1: Intent
- Tier 2: Maneuver
- Tier 3: Stimulus
- Tier 4: Cause
- Tier 5: Goal

See [features/README.md](features/README.md) for annotation details.

---

### 5. Explainability Layer

**Location**: [`xai/`](xai/)

**Purpose**: Generate human-readable explanations for model predictions.

**DTE Mapping**:
- **NLInterface**: Natural language explanation generator
- **XAIEngine**: Rule-based explanation engine
- **Explanation**: Textual explanation referencing Cause, Stimulus, AttentionCue
- **Advisory**: Recommendations (goal-driven vs stimulus-driven)

**Example Explanation**:
> "At 2.5s ahead, model predicts TURN_LEFT (confidence: 87%). This is because velocity is decreasing (45 → 32 km/h) and steering angle is increasing (0.2° → 5.8° left). Context: Urban intersection with pedestrian crossing detected."

**Components**:
- `explain.py` - Explanation generator
- `rules.py` - Rule templates for different maneuvers

See [xai/README.md](xai/README.md) for details.

---

### 6. Visualization & Evaluation Tools

**Location**: [`visualization/`](visualization/)

**Purpose**: Create interactive visualizations for analysis and debugging.

**DTE Mapping**:
- Part of **EvaluationService**
- Visualizes semantic space (UMAP/PCA/t-SNE)
- Enables similarity search (Qdrant vector database)

**Components**:
- `style_viz.py` - Semantic space projection (2D/3D)
- `hierarchical_viz.py` - 4D plots, sunburst charts, temporal heatmaps

**Outputs**:
- Interactive HTML plots (Plotly)
- Vector database (Qdrant) for session similarity search

See [visualization/README.md](visualization/README.md) for details.

---

### 7. Application Context

**Location**: Root CLI ([`cli.py`](cli.py))

**Purpose**: Deploy Digital Twin in Intelligent Mobility applications.

**DTE Mapping**:
- **IntelligentMobility**: Application domain (HAD, ADAS, V2X)
- **Objectives**: Maneuver prediction, DT simulation, style clustering, explainability

**CLI Commands**:
```bash
# Build Digital Twin
python -m twimo.cli scan --root ./data --out ./artifacts/manifest.jsonl

# Train Prediction Service
python -m twimo.cli train-maneuver --model xgboost

# Validate Digital Twin
python -m twimo.cli simulate-dt-optimized

# Cluster Driving Styles
python -m twimo.cli train-style --k 3

# Generate Explanations
python -m twimo.cli explain --modeldir ./artifacts/maneuver_xgboost
```

See main [README.md](../README.md) for complete workflow.

---

### 8. Federation & Connectivity (Future Work)

**Status**: Not yet implemented

**Planned Features**:
- Federated Digital Twins (multi-vehicle coordination)
- V2X connectivity (vehicle-to-everything)
- Integrated systems (traffic management, smart infrastructure)

---

## Utilities

**Location**: [`utils/`](utils/)

**Purpose**: Cross-cutting utilities for I/O, logging, profiling, time conversion.

**Components**:
- `io.py` - File I/O helpers (JSON, CSV, NumPy)
- `logging.py` - Structured logging
- `time.py` - Unix timestamp ↔ datetime conversion
- `profiling.py` - Performance profiling, carbon footprint tracking

See [utils/README.md](utils/README.md) for details.

---

## Configuration

**Location**: [`config.py`](config.py), root [`config.yaml`](../config.yaml)

**Purpose**: Centralized configuration management.

**Key Settings**:
```yaml
# Data paths
data_dir: "example_data"
manifest_file: "artifacts/manifest.jsonl"

# Model training
max_sessions: null  # Use all sessions
sample_hz: 3        # Resampling frequency

# Clustering
clustering:
  level1_clusters: 3   # Style
  level2_clusters: 7   # Style + Context
  level3_clusters: 11  # Fine-grained behaviors

# Temporal analysis
temporal:
  window_size_sec: 30
  stride_sec: 15

# Digital Twin
dt:
  wheelbase_m: 2.7
  reset_interval_sec: null  # No GPS reset (standard DT)

# Visualization
visualization:
  reduction_method: "umap"  # umap, pca, tsne
```

---

## Module Dependency Graph

```
┌─────────────────────────────────────────────────┐
│ CLI (cli.py)                                    │
│ Application Context: Intelligent Mobility       │
└─────────────────────────────────────────────────┘
          │
          ├─── Data & Evidence ──────────────────┐
          │    ├── data/        (DigitalShadow)  │
          │    └── features/    (Feature Eng.)   │
          │                                       │
          ├─── AI-Based Services ────────────────┤
          │    ├── models/      (Prediction)     │
          │    ├── video/       (Perception)     │
          │    ├── analysis/    (Evaluation)     │
          │    └── visualization/ (Evaluation)   │
          │                                       │
          ├─── Digital Twin ─────────────────────┤
          │    └── dt/          (Simulation)     │
          │                                       │
          ├─── Explainability ───────────────────┤
          │    └── xai/         (XAI Engine)     │
          │                                       │
          ├─── Framework ────────────────────────┤
          │    └── framework/   (DTE Metamodel)  │
          │                                       │
          └─── Utilities ────────────────────────┤
               └── utils/       (I/O, Logging)   │
```

---

## Key Design Principles

### 1. Separation of Concerns
- **Data loading** (data/) separate from **feature engineering** (features/)
- **Model training** (models/) separate from **model evaluation** (analysis/)
- **Simulation** (dt/) separate from **prediction** (models/)

### 2. Extensibility
- **11 model architectures** with unified interface
- **Plugin system** for video extractors (ResNet, MobileNet)
- **Configurable clustering** (K, hierarchy levels, temporal windows)

### 3. Reproducibility
- **Config files** for all experiments (config.yaml)
- **JSONL manifests** for dataset versioning
- **Timestamped artifacts** for traceability

### 4. Validation
- **Digital Twin** validates predictions against physics
- **RMSE metrics** for quantitative assessment
- **Visual inspection** via interactive plots

### 5. Explainability
- **XAI module** generates textual explanations
- **References domain concepts** (Stimulus, Cause, Goal)
- **Multi-level granularity** (feature-level, maneuver-level, session-level)

---

## Implementation Completeness

| DTE Component | Implementation | Status |
|---------------|----------------|--------|
| DigitalTwin | dt/simulator.py | ✅ Complete |
| DigitalShadow | data/csv_session.py | ✅ Complete |
| Prediction Service | models/ (11 architectures) | ✅ Complete |
| Perception Service | video/ (ResNet, MobileNet) | ✅ Complete |
| Evaluation Service | analysis/, visualization/ | ✅ Complete |
| Planning Service | - | ❌ Future work |
| Data & Evidence | data/, features/ | ✅ Complete |
| Driving Behaviour | framework/twimo_objects.py | ✅ Complete |
| Explainability | xai/ | ✅ Complete |
| Federation | - | ❌ Future work |

---

## Getting Started

### 1. Understand the Framework
Read [framework/README.md](framework/) to understand core components and domain objects.

### 2. Load Data
Read [data/README.md](data/README.md) to understand data loading, manifest creation, and heuristic labels.

### 3. Extract Features
Read [features/README.md](features/README.md) to understand feature engineering and ELAN annotations.

### 4. Train Models
Read [models/MODELS_OVERVIEW.md](models/MODELS_OVERVIEW.md) to choose a model architecture.

### 5. Validate with Digital Twin
Read [dt/README.md](dt/README.md) to run simulations and validate predictions.

### 6. Analyze & Visualize
Read [analysis/README.md](analysis/README.md) and [visualization/README.md](visualization/README.md) for clustering and visualizations.

### 7. Generate Explanations
Read [xai/README.md](xai/README.md) to generate human-readable explanations.

---

## Contributing

When adding new features:

1. **Map to DTE components**: Identify which package (DigitalTwin, Model, DrivingBehaviour, etc.)
2. **Follow existing patterns**: Use dataclasses, type hints, pathlib.Path
3. **Document thoroughly**: Update module README.md
4. **Validate**: Test with example_data/ first
5. **Update config.yaml**: Add new settings if needed

---

## References

- Main README: [../README.md](../README.md)
- DTE Metamodel: UML diagram (provided by user)
- Honda Driving Dataset: [HDD Paper](https://usa.honda-ri.com/hdd)
- Example Scripts: [../workflows/README.md](../workflows/README.md)

---

**Version**: 0.2.0
**Last Updated**: 2026-02-13
