from __future__ import annotations

from dataclasses import dataclass, field
from typing import Any, Dict, List, Optional


# ------------------------------------------------------------
# These classes mirror the intent of VM01-extended_twimo_framework.puml
# and the VM02 EAF architecture diagram (TWIMO_VM02_EAF_Diagram_new.png).
# They are light-weight runtime objects used by the pipeline.
# ------------------------------------------------------------


# ------------------------------------------------------------
# Data & Evidence
# ------------------------------------------------------------

@dataclass
class Dataset:
    """Simplified dataset representation for pipeline execution.

    DTE Mapping: model.dataAndEvidence.Dataset (runtime)
    Design-time counterpart: twimo_components.Dataset
    """
    name: str
    modalities: List[str]
    source: str


@dataclass
class Feature:
    """Single feature (column) in the data matrix.

    DTE Mapping: model.dataAndEvidence.Feature
    Implementation: feature names saved to artifacts/<outdir>/feature_names.json
    """
    name: str
    dtype: str


# ------------------------------------------------------------
# Digital Shadow  (PNG VM02: Time-Aligned Shadow artifact)
# ------------------------------------------------------------

@dataclass
class DigitalShadow:
    """Runtime Time-Aligned Shadow artifact produced by the Digital Shadow layer.

    DTE Mapping: model.DigitalShadow
    PNG Layer: Digital Shadow (Data-Centric) -> Time-Aligned Shadow (Features and Signals)
    Implementation:
        - Sensor arrays: twimo/data/csv_session.py, twimo/data/prealigned.py
        - Detection features: twimo/strategies_eaf/two_stage_yolo.py (cached .npy)
        - Generated via: twimo/data/generate_sensor_npy.py
    Design-time counterpart: twimo_components.DigitalShadow
    """
    session_id: str
    feature_names: List[str]
    n_timesteps: int
    sample_hz: float
    supervision_mode: str   # 'proxy' | 'eaf' | 'yolo'  (see SupervisionMode in twimo_components)
    array_path: str         # path to .npy file (prealigned) or '' for in-memory DataFrames


# ------------------------------------------------------------
# Driving Behaviour -- Goal / Stimulus / Cause / AttentionCue
# (PNG VM02: EAF Alignment Tiers; DTE: drivingBehaviour package)
# ------------------------------------------------------------

@dataclass
class Goal:
    """High-level driver goal (ELAN Tier 5).

    DTE Mapping: drivingBehaviour.Goal
    Implementation:
        - Labels: twimo/strategies_eaf/vocab_goal.json (14 classes)
        - Prediction head: two_stage_yolo_improved.py ClassifyNet -> 'goal' output
        - Supervision: Path B (EAF_EXPERT)
    """
    label: str         # one of the 14 vocab_goal labels
    confidence: float  # [0.0 - 1.0]


@dataclass
class Stimulus:
    """External stimulus that triggers or contextualises a maneuver (ELAN Tier 3).

    DTE Mapping: drivingBehaviour.Stimulus
    Implementation:
        - Labels: twimo/strategies_eaf/vocab_stimuli.json (9 classes)
        - Prediction head: two_stage_yolo_improved.py ClassifyNet -> 'stimuli' output
        - Supervision: Path B (EAF_EXPERT)
    """
    label: str
    confidence: float


@dataclass
class Cause:
    """Root cause of a maneuver (ELAN Tier 4).

    DTE Mapping: drivingBehaviour.Cause
    Implementation:
        - Labels: twimo/strategies_eaf/vocab_cause.json (17 classes)
        - Prediction head: two_stage_yolo_improved.py ClassifyNet -> 'cause' output
        - Supervision: Path B (EAF_EXPERT)
    """
    label: str
    confidence: float


@dataclass
class AttentionCue:
    """Visual attention / gaze cue of the driver (ELAN Tier 6).

    DTE Mapping: drivingBehaviour.AttentionCue
    Implementation:
        - Labels: twimo/strategies_eaf/vocab_attention.json (17 classes)
        - Prediction head: two_stage_yolo_improved.py ClassifyNet -> 'attention' output
        - Supervision: Path B (EAF_EXPERT)
    """
    label: str
    confidence: float


# ------------------------------------------------------------
# AI-Based Services
# ------------------------------------------------------------

@dataclass
class Predictor:
    """Encapsulates a trained model with multi-horizon prediction capability.

    DTE Mapping: model.aiBasedServices.prediction.Predictor
    PNG Layer: Digital Twin -> Driver Behaviour DT (AI Service)
    Implementation: twimo/models/ (all model types)
    Serialized to: artifacts/<outdir>/predictor_metadata.json
    """
    name: str
    horizons_sec: List[float]
    model_type: str
    artifacts: Dict[str, Any] = field(default_factory=dict)


# ------------------------------------------------------------
# Driving Model  (runtime)
# ------------------------------------------------------------

@dataclass
class DrivingModel:
    """Runtime representation linking driver, vehicle, and environment to a predictor.

    DTE Mapping: drivingBehaviour.DrivingModel (runtime)
    Design-time counterpart: twimo_components.DrivingModel
    """
    driver_id: str
    vehicle_id: str
    environment_id: str
    predictor: Predictor
    dataset: Dataset


# ------------------------------------------------------------
# Digital Twin  (runtime)
# ------------------------------------------------------------

@dataclass
class DigitalTwin:
    """Runtime instance of a Digital Twin execution.

    DTE Mapping: digitalTwin.DigitalTwin (runtime)
    PNG Layer: Digital Twin (Executable Models) layer
    Design-time counterpart: twimo_components.DigitalTwin
    """
    twin_id: str
    physical_system: str
    driving_model: DrivingModel
    purpose: str   # 'training' | 'validation' | 'deployment'


# ------------------------------------------------------------
# Run
# ------------------------------------------------------------

@dataclass
class Run:
    """Single execution record -- training run, DT simulation, or evaluation.

    DTE Mapping: digitalTwin.Run
    PNG Layer: Release & Validation -> DT Validation Comparator
    Implementation:
        - Training runs: twimo/cli.py cmd_train_maneuver -> artifacts/<outdir>/predictor_metadata.json
        - DT simulation runs: twimo/cli.py cmd_simulate_dt -> artifacts/<outdir>/twin_run.json
    """
    run_id: str
    twin: DigitalTwin
    config: Dict[str, Any]
    metrics: Dict[str, float] = field(default_factory=dict)


# ------------------------------------------------------------
# Explainability
# ------------------------------------------------------------

@dataclass
class Explanation:
    """Explanation record produced by the XAI layer.

    DTE Mapping: explainability.Explanation
    PNG Layer: Digital Twin -> Explanability (AI Service)
    Implementation: twimo/xai/explain.py (cod1_style_explain, simple_explain)
    Serialized to: artifacts/explain/explanations__<day>.jsonl

    Field mapping (JSONL output -> this class):
        JSONL 'text'        -> content
        JSONL 'probability' -> confidence
    """
    explanation_type: str       # 'rule_based' | 'saliency'
    content: str                # human-readable explanation text
    confidence: float           # prediction confidence [0.0 - 1.0]
    references: Dict[str, Any] = field(default_factory=dict)  # semantics: {braking, turning, ...}
    session_id: str = ""
    horizon_steps: int = 0
    t_index: int = 0
    predicted_label: int = 0
