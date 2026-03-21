"""twimo/run_scenarios.py
=======================
TWIMO Validation Use Case Scenarios — Programmatic Execution
=============================================================

Runs the five validation use cases of the TWIMO framework using TwimoRunner
and the DTE framework objects.  Configuration is loaded from ``config.yaml``
at the project root; all values can be overridden with CLI arguments.

Usage
-----
Run all use cases::

    python -m twimo.run_scenarios --all

Run a single use case::

    python -m twimo.run_scenarios --use-case A
    python -m twimo.run_scenarios --use-case B
    python -m twimo.run_scenarios --use-case C
    python -m twimo.run_scenarios --use-case D
    python -m twimo.run_scenarios --use-case E

Run specific steps within a use case::

    python -m twimo.run_scenarios --use-case A --steps A1         # transformer only
    python -m twimo.run_scenarios --use-case A --steps A1,A2      # transformer + xgboost
    python -m twimo.run_scenarios --use-case C --steps C2         # optimized DT only
    python -m twimo.run_scenarios --use-case E --steps E1         # explain only

Custom paths (override config.yaml defaults)::

    python -m twimo.run_scenarios --all \\
        --root          ./example_data \\
        --manifest      ./artifacts/manifest.jsonl \\
        --artifacts-dir ./artifacts \\
        --prealigned-sensors-dir ./twimo/assets/hdd_prealigned/20200710_sensors/sensor \\
        --prealigned-labels-dir  ./twimo/assets/hdd_prealigned/20200710_labels/target

Use Case Summary
----------------
A  Maneuver prediction with proxy supervision (heuristic labels, multi-model)
B  Event detection + Goal/Stimuli classification with EAF supervision (two-stage)
C  Vehicle Digital Twin simulation (real controls, calibrated)
D  Driving style analysis (K-means on time-aligned shadow features)
E  Explainability and reporting (textual explanations)

Step IDs (for --steps)
-----------------------
A1  Train Transformer (multi-horizon, GPU recommended)
A2  Train XGBoost (fast, CPU-friendly)
A3  Train Random Forest (interpretable baseline)
B1  Train EventNet + ClassifyNet (two-stage EAF model)
B2  Evaluate two-stage model
C1  Basic DT simulation (ground-truth controls, open-loop)
C2  Optimized DT simulation (auto-calibration + GPS drift correction)
D1  Driving style clustering (K-means)
E1  Generate explanations

DTE Framework mapping
---------------------
Each scenario maps to a DTE phase:
    A  -> Build       (model.aiBasedServices.prediction.Predictor)
    B  -> Build       (drivingBehaviour.Goal / Stimulus / Cause / AttentionCue)
    C  -> Validate    (digitalTwin.Run + ControlService)
    D  -> Evolve      (drivingBehaviour.DrivingModel style clustering)
    E  -> Evolve      (explainability.Explanation)
"""
from __future__ import annotations

import argparse
import sys
from pathlib import Path

# TwimoRunner + load_config live in the framework layer
from twimo.framework.runner import TwimoRunner, load_config


# ─────────────────────────────────────────────────────────────────────────────
# Load project config.yaml (framework reads configuration from here)
# ─────────────────────────────────────────────────────────────────────────────

_CFG = load_config("config.yaml")


# ─────────────────────────────────────────────────────────────────────────────
# Default paths — from config.yaml if available, else hardcoded fallbacks
# CLI args always override these.
# ─────────────────────────────────────────────────────────────────────────────

DEFAULT_ROOT             = _CFG.get("data_dir",        "./example_data")
DEFAULT_ARTIFACTS        = _CFG.get("artifacts_dir",   "./artifacts")
DEFAULT_MANIFEST         = _CFG.get("manifest_file",   "./artifacts/manifest.jsonl")
DEFAULT_PREALIGNED_SENS  = "./twimo/assets/hdd_prealigned/20200710_sensors/sensor"
DEFAULT_PREALIGNED_LBLS  = "./twimo/assets/hdd_prealigned/20200710_labels/target"
DEFAULT_EAF_PARSED_DIR   = "./artifacts/eaf/parsed"
DEFAULT_VOCAB_DIR        = "./twimo/strategies_eaf"   # folder with vocab_*.json files
DEFAULT_DET_CACHE_DIR    = "./artifacts/det_cache_improved"

# Clustering k — from config.yaml clustering section
_clustering_cfg          = _CFG.get("clustering", {})
DEFAULT_STYLE_K          = int(_clustering_cfg.get("level1_clusters", 3))


# ─────────────────────────────────────────────────────────────────────────────
# Step registry — maps step IDs to human-readable descriptions
# ─────────────────────────────────────────────────────────────────────────────

STEP_DESCRIPTIONS = {
    "A1": "Train Transformer (multi-horizon, GPU recommended)",
    "A2": "Train XGBoost (fast, CPU-friendly)",
    "A3": "Train Random Forest (interpretable baseline)",
    "A4": "Train LightGBM (very fast, memory-efficient)",
    "A5": "Train GRU (recurrent, sequence modeling)",
    "A6": "Train LSTM (long-term temporal dependencies)",
    "A7": "Train TCN (temporal convolutions, parallelizable)",
    "A8": "Train MLP mean pooling (simple, fast)",
    "A9": "Train MLP max pooling",
    "A10": "Train MLP concat pooling (mean+max+first+last)",
    "B1": "Train EventNet + ClassifyNet (two-stage EAF model, improved YOLO pipeline)",
    "B2": "Evaluate two-stage EAF model",
    "B3": "Train Two-Stage YOLO (sensor + object detection features, standard)",
    "B4": "Evaluate Two-Stage YOLO (standard)",
    "C1": "Basic DT simulation (ground-truth controls, open-loop)",
    "C2": "Optimized DT simulation (auto-calibration + GPS drift correction)",
    "D1": "Driving style clustering (K-means)",
    "E1": "Generate explanations",
}


# ─────────────────────────────────────────────────────────────────────────────
# Helpers
# ─────────────────────────────────────────────────────────────────────────────

def _section(title: str) -> None:
    print(f"\n{'='*60}")
    print(f"  {title}")
    print(f"{'='*60}\n")


def _warn_missing(path: str, label: str) -> bool:
    """Return True if path exists, False and print a warning otherwise."""
    if not Path(path).exists():
        print(f"  [SKIP] {label} not found: {path}")
        return False
    return True


def _should_run(step: str, steps: list[str] | None) -> bool:
    """Return True if this step should run given the steps filter.

    If *steps* is None or empty, all steps run (no filter applied).
    """
    if not steps:
        return True
    return step.upper() in steps


def _print_steps_header(steps: list[str] | None, use_case: str) -> None:
    """Print which steps will run for the current use case."""
    case_steps = [s for s in STEP_DESCRIPTIONS if s.startswith(use_case)]
    if steps:
        running = [s for s in steps if s.startswith(use_case)]
        skipped = [s for s in case_steps if s not in steps]
        print(f"  Steps selected : {', '.join(running) if running else '(none)'}")
        if skipped:
            print(f"  Steps skipped  : {', '.join(skipped)}")
        print()
    else:
        print(f"  Steps selected : all ({', '.join(case_steps)})\n")


# ─────────────────────────────────────────────────────────────────────────────
# Use Case A — Maneuver prediction with proxy supervision
# ─────────────────────────────────────────────────────────────────────────────

def run_use_case_a(args: argparse.Namespace) -> None:
    """Use Case A — Maneuver prediction with proxy supervision.

    Predicts discrete maneuver labels from aligned CSV sensors and/or
    video-derived representations, across multiple prediction horizons,
    using proxy labels generated by heuristics (SupervisionMode.PROXY_HEURISTIC).

    DTE Phase : Build
    DTE Object: model.aiBasedServices.prediction.Predictor
    PNG Layer : Digital Twin -> Driver Behaviour DT (AI Service)

    Steps
    -----
    A1  Transformer  — best accuracy, GPU recommended
    A2  XGBoost      — fast, CPU-friendly, excellent baseline
    A3  Random Forest — robust, fully interpretable
    """
    _section("USE CASE A — Maneuver Prediction (Proxy Supervision)")

    steps = args.steps

    from twimo.framework.twimo_components import (
        instantiate_hdd_driving_behavior_twin,
        SupervisionMode,
    )

    twin = instantiate_hdd_driving_behavior_twin(
        root=args.root,
        sample_hz=3.0,
        extractor="none",          # sensor-only; set "torch" to enable video fusion
    )
    print(f"DigitalTwin  : {twin.name}")
    print(f"Supervision  : {SupervisionMode.PROXY_HEURISTIC.value}  (Path A — heuristic threshold rules)")
    print(f"Dataset root : {args.root}")
    print(f"Manifest     : {args.manifest}")
    _print_steps_header(steps, "A")

    runner = TwimoRunner(twin=twin, manifest=args.manifest)

    if args.use_video:
        print(f"  Video fusion : ENABLED  (extractor={args.video_extractor})")

    # A1 — Transformer (primary model)
    if _should_run("A1", steps):
        print("--- A1  Transformer (multi-horizon, GPU recommended) ---")
        runner.train_maneuver(
            outdir=Path(args.transformer_outdir),
            model="transformer",
            sample_hz=3.0,
            epochs=args.epochs,
            horizons=None,  # auto-computed from sample_hz
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A1  Transformer: SKIPPED ---")

    # A2 — XGBoost (fast baseline, no GPU needed)
    if _should_run("A2", steps):
        print("\n--- A2  XGBoost (fast baseline, CPU-friendly) ---")
        runner.train_maneuver(
            outdir=Path(args.xgboost_outdir),
            model="xgboost",
            sample_hz=3.0,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A2  XGBoost: SKIPPED ---")

    # A3 — Random Forest (fully interpretable)
    if _should_run("A3", steps):
        print("\n--- A3  Random Forest (interpretable baseline) ---")
        runner.train_maneuver(
            outdir=Path(args.rf_outdir),
            model="random_forest",
            sample_hz=3.0,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A3  Random Forest: SKIPPED ---")

    # A4 — LightGBM
    if _should_run("A4", steps):
        print("\n--- A4  LightGBM (very fast, memory-efficient) ---")
        runner.train_maneuver(
            outdir=Path(args.lightgbm_outdir),
            model="lightgbm",
            sample_hz=3.0,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A4  LightGBM: SKIPPED ---")

    # A5 — GRU
    if _should_run("A5", steps):
        print("\n--- A5  GRU (recurrent, sequence modeling) ---")
        runner.train_maneuver(
            outdir=Path(args.gru_outdir),
            model="gru",
            sample_hz=3.0,
            epochs=args.epochs,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A5  GRU: SKIPPED ---")

    # A6 — LSTM
    if _should_run("A6", steps):
        print("\n--- A6  LSTM (long-term temporal dependencies) ---")
        runner.train_maneuver(
            outdir=Path(args.lstm_outdir),
            model="lstm",
            sample_hz=3.0,
            epochs=args.epochs,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A6  LSTM: SKIPPED ---")

    # A7 — TCN
    if _should_run("A7", steps):
        print("\n--- A7  TCN (temporal convolutions, parallelizable) ---")
        runner.train_maneuver(
            outdir=Path(args.tcn_outdir),
            model="tcn",
            sample_hz=3.0,
            epochs=args.epochs,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A7  TCN: SKIPPED ---")

    # A8 — MLP mean pooling
    if _should_run("A8", steps):
        print("\n--- A8  MLP mean pooling (simple, fast) ---")
        runner.train_maneuver(
            outdir=Path(args.mlp_mean_outdir),
            model="mlp_mean",
            sample_hz=3.0,
            epochs=args.epochs,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A8  MLP mean: SKIPPED ---")

    # A9 — MLP max pooling
    if _should_run("A9", steps):
        print("\n--- A9  MLP max pooling ---")
        runner.train_maneuver(
            outdir=Path(args.mlp_max_outdir),
            model="mlp_max",
            sample_hz=3.0,
            epochs=args.epochs,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A9  MLP max: SKIPPED ---")

    # A10 — MLP concat pooling
    if _should_run("A10", steps):
        print("\n--- A10  MLP concat pooling (mean+max+first+last) ---")
        runner.train_maneuver(
            outdir=Path(args.mlp_concat_outdir),
            model="mlp_concat",
            sample_hz=3.0,
            epochs=args.epochs,
            use_video=args.use_video,
            video_extractor=args.video_extractor,
        )
    else:
        print("--- A10  MLP concat: SKIPPED ---")

    video_note = f"  (video fusion: {args.video_extractor})" if args.use_video else ""
    print(f"\n[A] Done{video_note}. Artefacts in: {args.artifacts_dir}/maneuver_*")
    print("    predictor_metadata.json  — DTE Predictor record")
    print("    test_metrics.json        — per-horizon accuracy / F1 / AUC")
    print("    roc_curves.json          — per-class ROC curves")
    print("    twin_config.json         — DTE DigitalTwin blueprint")


# ─────────────────────────────────────────────────────────────────────────────
# Use Case B — EAF two-stage (Goal / Stimuli with expert supervision)
# ─────────────────────────────────────────────────────────────────────────────

def run_use_case_b(args: argparse.Namespace) -> None:
    """Use Case B — Event detection + Goal/Stimuli classification (EAF supervision).

    Uses EAF expert labels aligned to the 3 Hz timeline to supervise:
        Stage 1 — EventNet  : binary event vs no-event detection
        Stage 2 — ClassifyNet : conditional classification of
                                Goal / Stimuli / Cause / Attention

    DTE Phase : Build
    DTE Object: drivingBehaviour.Goal, Stimulus, Cause, AttentionCue
    PNG Layer : Digital Shadow -> EAF Alignment (Tiers -> Frames)
                Digital Twin  -> Driver Behaviour DT (Stage 2 heads)

    Steps
    -----
    B1  Train EventNet + ClassifyNet
    B2  Evaluate two-stage model
    """
    _section("USE CASE B — EAF Two-Stage (Goal/Stimuli with Expert Supervision)")

    steps = args.steps

    from twimo.framework.twimo_components import SupervisionMode

    if not Path(args.eaf_parsed_dir).exists():
        print(f"  [INFO] Parsed EAF annotations not found: {args.eaf_parsed_dir}")
        print(f"         Use Case B is optional and requires human-annotated EAF data")
        print(f"         (not included in example_data). To enable, run:")
        print(f"           python twimo/strategies_eaf/parse_eaf.py \\")
        print(f"               --eaf-dir  <path_to_eaf_files> \\")
        print(f"               --output   {args.eaf_parsed_dir}")
        return

    sens_ok  = _warn_missing(args.prealigned_sensors_dir,  "--prealigned-sensors-dir")
    vocab_ok = _warn_missing(args.vocab_dir,               "--vocab-dir")

    if not (sens_ok and vocab_ok):
        print("\n  [SKIP] Use Case B also requires prealigned sensors and vocab files.")
        return

    det_cache = args.det_cache_dir if Path(args.det_cache_dir).exists() else None
    supervision = (SupervisionMode.YOLO_DETECTION.value if det_cache
                   else SupervisionMode.EAF_EXPERT.value)
    print(f"Supervision  : {supervision}")
    print(f"EAF parsed   : {args.eaf_parsed_dir}")
    print(f"Detection cache (Supervision C enrichment): {det_cache or 'not available'}")
    _print_steps_header(steps, "B")

    outdir_b = Path(args.eaf_outdir)

    # --- B.0  (Optional) Extract improved YOLOv8 detection features ----------
    if det_cache is None and _warn_missing(args.manifest, "--manifest"):
        print("--- B.0  YOLOv8 feature extraction (Supervision C, optional) ---")
        print("         Skipping: no existing det-cache-dir.  To enable, run:")
        print(f"           python -m twimo.strategies_eaf.two_stage_yolo_improved extract-improved \\")
        print(f"               --manifest               {args.manifest} \\")
        print(f"               --det-cache-dir          {args.det_cache_dir} \\")
        print(f"               --prealigned-sensors-dir {args.prealigned_sensors_dir}")
    elif det_cache:
        print("--- B.0  YOLOv8 detection features: already cached ---")

    # --- B1  Train two-stage model ------------------------------------------
    if _should_run("B1", steps):
        print("\n--- B1  Train EventNet + ClassifyNet (two-stage) ---")
        from twimo.strategies_eaf.two_stage_yolo_improved import cmd_train as _b_train

        train_args = argparse.Namespace(
            manifest               = Path(args.manifest),
            eaf_parsed_dir         = Path(args.eaf_parsed_dir),
            det_cache_dir          = Path(det_cache) if det_cache else None,
            prealigned_sensors_dir = Path(args.prealigned_sensors_dir),
            vocab_dir              = Path(args.vocab_dir),
            outdir                 = outdir_b,
            strategies             = [],       # all strategies enabled by default
            stage1_threshold       = 0.30,
            sample_hz              = 3.0,
            window_sec             = 5.0,
            epochs                 = args.eaf_epochs,
            lr                     = 1e-4,
            batch_size             = 32,
        )
        _b_train(train_args)
    else:
        print("--- B1  Train two-stage: SKIPPED ---")

    # --- B2  Evaluate -------------------------------------------------------
    if _should_run("B2", steps):
        print("\n--- B2  Evaluate two-stage model ---")
        from twimo.strategies_eaf.two_stage_yolo_improved import cmd_evaluate as _b_eval

        eval_args = argparse.Namespace(
            manifest               = Path(args.manifest),
            model_dir              = outdir_b,
            eaf_parsed_dir         = Path(args.eaf_parsed_dir),
            det_cache_dir          = Path(det_cache) if det_cache else None,
            prealigned_sensors_dir = Path(args.prealigned_sensors_dir),
            vocab_dir              = Path(args.vocab_dir),
            outdir                 = outdir_b / "eval",
            sample_hz              = 3.0,
        )
        _b_eval(eval_args)
    else:
        print("--- B2  Evaluate: SKIPPED ---")

    # --- B3  Two-Stage YOLO (standard, non-improved) -------------------------
    if _should_run("B3", steps):
        print("\n--- B3  Two-Stage YOLO (sensor + object detection, standard) ---")
        runner.two_stage_yolo_train(
            det_cache_dir=args.det_cache_dir,
            outdir=Path(args.yolo_outdir),
            prealigned_sensors_dir=args.prealigned_sensors_dir,
            eaf_parsed_dir=args.eaf_parsed_dir,
            sample_hz=3.0,
            epochs=args.eaf_epochs,
        )
    else:
        print("--- B3  Two-Stage YOLO: SKIPPED ---")

    # --- B4  Evaluate Two-Stage YOLO (standard) ------------------------------
    if _should_run("B4", steps):
        print("\n--- B4  Evaluate Two-Stage YOLO (standard) ---")
        runner.two_stage_yolo_evaluate(
            model_dir=Path(args.yolo_outdir),
            det_cache_dir=args.det_cache_dir,
            eaf_parsed_dir=args.eaf_parsed_dir,
            outdir=Path(args.yolo_outdir) / "eval",
            prealigned_sensors_dir=args.prealigned_sensors_dir,
            sample_hz=3.0,
        )
    else:
        print("--- B4  Evaluate Two-Stage YOLO: SKIPPED ---")

    print(f"\n[B] Done. Artefacts in: {outdir_b}, {args.yolo_outdir}")
    print("    Stage 1: event detection metrics")
    print("    Stage 2: Goal / Stimuli / Cause / Attention per-class F1")
    print("    DTE objects: Goal, Stimulus, Cause, AttentionCue")


# ─────────────────────────────────────────────────────────────────────────────
# Use Case C — Vehicle Digital Twin simulation
# ─────────────────────────────────────────────────────────────────────────────

def run_use_case_c(args: argparse.Namespace) -> None:
    """Use Case C — Vehicle DT simulation under multiple control regimes.

    Executes the kinematic bicycle Vehicle DT and validates simulated
    trajectories against RTK ground truth.

    Regime C1  — real controls (ground truth steer + velocity from CSV)
                   ControlService.regressor_type = 'ground_truth'
    Regime C2  — calibrated DT with GPS drift correction
                   ControlService.regressor_type = 'kinematic'
    Regime C3  — maneuver-to-control generation    [NOT YET IMPLEMENTED]
    Regime C4  — ML control regression             [NOT YET IMPLEMENTED]

    DTE Phase : Validate
    DTE Object: digitalTwin.Run, ControlService
    PNG Layer : Release & Validation -> DT Validation Comparator

    Steps
    -----
    C1  Basic DT simulation (ground-truth controls, open-loop)
    C2  Optimized DT simulation (auto-calibration + GPS drift correction)
    """
    _section("USE CASE C — Vehicle DT Simulation (Multiple Control Regimes)")

    steps = args.steps

    from twimo.framework.twimo_components import (
        instantiate_hdd_driving_behavior_twin,
        ControlService,
    )

    twin = instantiate_hdd_driving_behavior_twin(root=args.root, sample_hz=3.0)
    runner = TwimoRunner(twin=twin, manifest=args.manifest)

    _print_steps_header(steps, "C")

    # C1 — Basic DT with ground-truth controls
    if _should_run("C1", steps):
        print("--- C1  Basic DT (ground-truth controls, open-loop) ---")
        ctrl_i = ControlService(
            name="GroundTruthControl",
            regressor_type="ground_truth",
            input_type="ground_truth_sensors",
        )
        print(f"ControlService : {ctrl_i.name}  ({ctrl_i.regressor_type})")
        runner.simulate_dt(
            outdir=Path(args.dt_basic_outdir),
            sample_hz=10.0,
            wheelbase=2.7,
        )
    else:
        print("--- C1  Basic DT: SKIPPED ---")

    # C2 — Calibrated + drift-corrected DT
    if _should_run("C2", steps):
        print("\n--- C2  Optimized DT (auto-calibration + GPS drift correction) ---")
        ctrl_opt = ControlService(
            name="CalibratedGroundTruthControl",
            regressor_type="kinematic",
            input_type="ground_truth_sensors",
        )
        print(f"ControlService : {ctrl_opt.name}  ({ctrl_opt.regressor_type})")
        runner.simulate_dt_optimized(
            outdir=Path(args.dt_optimized_outdir),
            sample_hz=3.0,
            calibrate=True,
            use_reset=True,
            reset_interval=30,
        )
    else:
        print("--- C2  Optimized DT: SKIPPED ---")

    # C3/C4 — future work (always shown as informational)
    print("\n--- C3  Maneuver-to-Control generation [NOT YET IMPLEMENTED] ---")
    ctrl_ii = ControlService(
        name="ManeuverToControlBridge",
        regressor_type="ml_regressor",
        input_type="predicted_maneuver",
    )
    print(f"ControlService : {ctrl_ii.name}  ({ctrl_ii.regressor_type})")
    print("         Requires a regression model that maps maneuver class -> (steer, velocity).")
    print("         See twimo/framework/twimo_components.py::ControlService for details.")

    print("\n--- C4  ML control regression [NOT YET IMPLEMENTED] ---")
    print("         Same as C3 but trained end-to-end.  Future work.")

    print(f"\n[C] Implemented regimes done. Artefacts in: {args.dt_basic_outdir}, {args.dt_optimized_outdir}")
    print("    twin_run.json                          — DTE Run record")
    print("    dt_optimized_aggregated_metrics.json   — global RMSE/MAE statistics")


# ─────────────────────────────────────────────────────────────────────────────
# Use Case D — Driving style analysis
# ─────────────────────────────────────────────────────────────────────────────

def run_use_case_d(args: argparse.Namespace) -> None:
    """Use Case D — Driving style analysis.

    Computes engineered features from the time-aligned shadow and infers
    driving-style profiles (e.g., prudent / smooth / aggressive) as an
    interpretable behavioural summary of sessions or segments.

    DTE Phase : Evolve
    DTE Object: drivingBehaviour.DrivingModel (task='style')
    PNG Layer : Digital Twin -> Driver Behaviour DT (AI Service)

    Steps
    -----
    D1  Style clustering (K-means on aggregated features)
    """
    _section("USE CASE D — Driving Style Analysis")

    steps = args.steps

    from twimo.framework.twimo_components import instantiate_hdd_driving_behavior_twin

    twin = instantiate_hdd_driving_behavior_twin(root=args.root, sample_hz=3.0)
    twin.driving_model.task       = "style"
    twin.driving_model.model_type = "kmeans"

    runner = TwimoRunner(twin=twin, manifest=args.manifest)

    print(f"DrivingModel  : {twin.driving_model.name}  (task={twin.driving_model.task})")
    print(f"Model type    : {twin.driving_model.model_type}")
    print(f"Clusters (k)  : {args.style_k}")
    _print_steps_header(steps, "D")

    if _should_run("D1", steps):
        # When the manifest uses prealigned sensors, _load_session_features assigns
        # generic names sensor_0..N. compute_style_features cannot match these to
        # steer/accel/brake/vel signals → aggr_score = 0 for every session → all
        # sessions cluster to "prudent". Fix: strip prealigned paths so cli.py falls
        # back to CSV loading, which yields properly named columns.
        import json as _json
        import tempfile as _tmp
        import os as _os

        stripped = []
        with open(args.manifest, "r", encoding="utf-8") as _mf:
            for _line in _mf:
                if _line.strip():
                    _rec = _json.loads(_line)
                    _rec["prealigned_sensor_npy"] = None
                    _rec["prealigned_target_npy"] = None
                    stripped.append(_json.dumps(_rec))

        _fd, _tmp_manifest = _tmp.mkstemp(suffix=".jsonl")
        with _os.fdopen(_fd, "w", encoding="utf-8") as _mf:
            _mf.write("\n".join(stripped) + "\n")

        _orig_manifest = runner.manifest
        runner.manifest = _tmp_manifest
        try:
            runner.train_style(
                outdir=Path(args.style_outdir),
                k=args.style_k,
            )
        finally:
            runner.manifest = _orig_manifest
            _os.unlink(_tmp_manifest)
    else:
        print("--- D1  Style clustering: SKIPPED ---")

    print(f"\n[D] Done. Artefacts in: {args.style_outdir}")
    print("    style_centroids.json — cluster centroids + session assignments")


# ─────────────────────────────────────────────────────────────────────────────
# Use Case E — Explainability and reporting
# ─────────────────────────────────────────────────────────────────────────────

def run_use_case_e(args: argparse.Namespace) -> None:
    """Use Case E — Explainability and reporting.

    Generates human-readable explanations and evidence for predictions,
    and publishes reports and artefacts for auditing and iterative refinement.

    Uses rule-based explanations (cod1_style_explain):
        - braking / turning / straight inference from sensor signals
        - per-timestep explanation records serialised to JSONL

    DTE Phase : Evolve
    DTE Object: explainability.Explanation
    PNG Layer : Digital Twin -> Explanability (AI Service)
                Release & Validation -> External Consumer (Dashboard/API)

    Steps
    -----
    E1  Generate explanations

    Model selection strategy
    ------------------------
    Tries model candidates in preference order:
        1. maneuver_transformer
        2. maneuver_xgboost
        3. maneuver_rf
    If a model fails with a weight/shape mismatch (feature count changed since
    training), the next candidate is tried automatically and a warning is printed.
    Retrain Use Case A to fix the mismatch permanently.
    """
    _section("USE CASE E — Explainability and Reporting")

    steps = args.steps

    from twimo.framework.twimo_objects import Explanation
    from twimo.framework.twimo_components import instantiate_hdd_driving_behavior_twin

    if not _should_run("E1", steps):
        print("--- E1  Explain: SKIPPED ---")
        return

    # If the user specified an explicit model directory, use only that
    if getattr(args, "explain_modeldir", None):
        explicit = Path(args.explain_modeldir)
        if not explicit.exists():
            print(f"  [WARN] --explain-modeldir not found: {explicit}")
            return
        # Infer kind from model_kind.txt if present, else use directory name
        mk_path = explicit / "model_kind.txt"
        kind = mk_path.read_text(encoding="utf-8").strip() if mk_path.exists() else explicit.name
        available = [(explicit, kind)]
    else:
        # Model candidates in preference order (first available wins)
        model_candidates = [
            (Path(args.artifacts_dir) / "maneuver_transformer", "transformer"),
            (Path(args.artifacts_dir) / "maneuver_xgboost",     "xgboost"),
            (Path(args.artifacts_dir) / "maneuver_rf",          "random_forest"),
        ]
        available = [(d, k) for d, k in model_candidates if d.exists()]
        if not available:
            print("  [WARN] No trained model found. Run Use Case A first.")
            print("         Checked:")
            for d, _ in model_candidates:
                print(f"           {d}")
            return

    twin = instantiate_hdd_driving_behavior_twin(root=args.root, sample_hz=3.0)
    twin.driving_model.task = "explain"

    runner = TwimoRunner(twin=twin, manifest=args.manifest)

    print(f"DrivingModel  : {twin.driving_model.name}  (task={twin.driving_model.task})")
    print(f"DTE type      : {Explanation.__name__} (twimo_objects.Explanation)")
    print(f"Model candidates (in priority order):")
    for d, k in available:
        print(f"    {k:20s}  {d}")
    print()

    # Try each available model; fall back on weight/shape mismatch
    explain_outdir = Path(args.explain_outdir)
    success = False

    for attempt_dir, attempt_kind in available:
        try:
            print(f"--- E1  Explain with: {attempt_kind} ({attempt_dir.name}) ---")
            runner.explain(
                modeldir=attempt_dir,
                outdir=explain_outdir,
                explain_every_steps=args.explain_every_steps,
                use_video=False,  # Use Case A trains sensor-only; avoid feature dimension mismatch
            )
            print(f"\n[E] Done using model: {attempt_kind}")
            success = True
            break
        except (RuntimeError, ValueError) as exc:
            msg = str(exc)
            if (
                "size mismatch" in msg
                or "shape" in msg.lower()
                or "features" in msg.lower()
                or "expected" in msg.lower()
            ):
                print(f"  [WARN] {attempt_kind}: weight/shape mismatch — trying next model.")
                print(f"         Hint: {msg[:160]}")
                print(f"         To fix: retrain '{attempt_dir.name}' with the current manifest.")
                continue
            # Any other error is real — propagate
            raise

    if not success:
        print("\n  [ERROR] All model candidates failed with weight/shape mismatch.")
        print("          Solution: rerun Use Case A to retrain models with the current dataset.")
        print("          The mismatch occurs when the feature count changed between training")
        print("          and inference (e.g., manifest rebuilt with different sessions/assets).")
        return

    print(f"    explanations__<day>.jsonl — per-day Explanation records")
    print(f"    explain_index.json        — index of generated files")
    print(f"    (serialise to dashboard/API via the External Consumer layer)")


# ─────────────────────────────────────────────────────────────────────────────
# Scenario registry
# ─────────────────────────────────────────────────────────────────────────────

SCENARIOS = {
    "A": run_use_case_a,
    "B": run_use_case_b,
    "C": run_use_case_c,
    "D": run_use_case_d,
    "E": run_use_case_e,
}

SCENARIO_LABELS = {
    "A": "Maneuver prediction with proxy supervision",
    "B": "Event detection + Goal/Stimuli classification (EAF supervision)",
    "C": "Vehicle DT simulation (multiple control regimes)",
    "D": "Driving style analysis",
    "E": "Explainability and reporting",
}


# ─────────────────────────────────────────────────────────────────────────────
# Setup: scan + manifest
# ─────────────────────────────────────────────────────────────────────────────

def run_setup(args: argparse.Namespace) -> None:
    """Step 0: scan data directory and build the session manifest."""
    _section("SETUP — Scan Dataset and Build Manifest")

    from twimo.framework.twimo_components import instantiate_hdd_driving_behavior_twin

    twin = instantiate_hdd_driving_behavior_twin(root=args.root, sample_hz=3.0)
    runner = TwimoRunner(twin=twin, manifest=args.manifest)

    runner.scan(
        root=args.root,
        out=args.manifest,
        prealigned_labels_dir=(
            args.prealigned_labels_dir
            if Path(args.prealigned_labels_dir).exists() else None
        ),
        prealigned_sensors_dir=(
            args.prealigned_sensors_dir
            if Path(args.prealigned_sensors_dir).exists() else None
        ),
    )
    print(f"\n[Setup] Manifest written to: {args.manifest}")


# ─────────────────────────────────────────────────────────────────────────────
# CLI entry point
# ─────────────────────────────────────────────────────────────────────────────

class _FullHelpAction(argparse.Action):
    """Custom --help: prints description then all flags grouped by scenario."""

    def __init__(self, option_strings, dest=argparse.SUPPRESS,
                 default=argparse.SUPPRESS, help=None):
        super().__init__(option_strings=option_strings, dest=dest,
                         default=default, nargs=0, help=help)

    @staticmethod
    def _fmt(a: argparse.Action) -> str:
        flag = ", ".join(a.option_strings) if a.option_strings else a.dest
        if a.type is not None:
            type_str = f" {a.type.__name__.upper()}"
        elif a.nargs in ("*", "+", argparse.REMAINDER):
            type_str = " ..."
        elif isinstance(a, argparse._StoreTrueAction):
            type_str = ""
        else:
            type_str = " STR" if a.default is None else ""
        tags = ""
        if getattr(a, "required", False):
            tags += "  [required]"
        elif a.default not in (None, argparse.SUPPRESS, False):
            tags += f"  [default: {a.default}]"
        if isinstance(a, argparse._StoreTrueAction):
            tags += "  [flag]"
        help_text = (a.help or "").replace("%(default)s", str(a.default))
        first_line = help_text.strip().splitlines()[0] if help_text.strip() else ""
        out = f"  {flag}{type_str}{tags}"
        if first_line and first_line != argparse.SUPPRESS:
            out += f"\n      {first_line}"
        return out

    def __call__(self, parser, namespace, values, option_string=None):
        parser.print_help()
        _SKIP_GROUPS = {"positional arguments", "options"}
        _SKIP_TYPES  = (_FullHelpAction, argparse._HelpAction)
        for group in parser._action_groups:
            if group.title in _SKIP_GROUPS:
                continue
            actions = [a for a in group._group_actions
                       if not isinstance(a, _SKIP_TYPES)]
            if not actions:
                continue
            print(f"\n{'-' * 72}")
            print(f"  {group.title}")
            print(f"{'-' * 72}")
            for a in actions:
                print(self._fmt(a))
        print()
        parser.exit()


def build_parser() -> argparse.ArgumentParser:
    step_help = "\n".join(f"  {k}  {v}" for k, v in STEP_DESCRIPTIONS.items())
    p = argparse.ArgumentParser(
        prog="python -m twimo.run_scenarios",
        description=(
            "TWIMO Validation Use Case Scenarios\n"
            "Runs A-E use cases using TwimoRunner + DTE framework objects.\n"
            "Configuration defaults are loaded from config.yaml.\n\n"
            "Use cases:\n"
            + "\n".join(f"  {k}  {v}" for k, v in SCENARIO_LABELS.items())
        ),
        formatter_class=argparse.RawTextHelpFormatter,
        add_help=False,
    )
    p.add_argument(
        "-h", "--help",
        action=_FullHelpAction,
        help="Show this help message with all flags and exit",
    )

    # ── Scenario selection ────────────────────────────────────────────────────
    g_sel = p.add_argument_group("Scenario selection")
    exclusive = g_sel.add_mutually_exclusive_group(required=True)
    exclusive.add_argument(
        "--use-case", choices=list(SCENARIOS.keys()),
        metavar="CASE",
        help="Run a single use case: A | B | C | D | E",
    )
    exclusive.add_argument(
        "--all", action="store_true",
        help="Run all use cases in order A -> E",
    )
    g_sel.add_argument(
        "--steps",
        default=None,
        metavar="STEPS",
        help=(
            "Comma-separated step IDs to run within the selected use case(s).\n"
            "Omit to run all steps for each use case.  Available step IDs:\n"
            + step_help + "\n"
            "Examples:\n"
            "  --use-case A --steps A1           (transformer only)\n"
            "  --use-case A --steps A1,A2        (transformer + xgboost)\n"
            "  --use-case C --steps C2           (optimized DT only)\n"
            "  --all --steps A1,C2,D1,E1         (one step per use case)"
        ),
    )

    # ── Data paths (shared across all use cases) ──────────────────────────────
    g_paths = p.add_argument_group("Data paths  [shared]")
    g_paths.add_argument("--root", default=DEFAULT_ROOT,
                         help=f"HDD data root folder (default from config.yaml: {DEFAULT_ROOT})")
    g_paths.add_argument("--manifest", default=DEFAULT_MANIFEST,
                         help=f"Manifest JSONL path (default from config.yaml: {DEFAULT_MANIFEST})")
    g_paths.add_argument("--artifacts-dir", default=DEFAULT_ARTIFACTS, dest="artifacts_dir",
                         help=f"Output artefacts root (default from config.yaml: {DEFAULT_ARTIFACTS})")
    g_paths.add_argument("--prealigned-sensors-dir", default=DEFAULT_PREALIGNED_SENS,
                         dest="prealigned_sensors_dir",
                         help="Prealigned sensor .npy directory")
    g_paths.add_argument("--prealigned-labels-dir", default=DEFAULT_PREALIGNED_LBLS,
                         dest="prealigned_labels_dir",
                         help="Prealigned label .npy directory")
    g_paths.add_argument("--skip-setup", action="store_true",
                         help="Skip the scan/manifest step (manifest already exists)")

    # ── Use Case A — Maneuver prediction ──────────────────────────────────────
    g_a = p.add_argument_group("Use Case A  [maneuver prediction]")
    g_a.add_argument("--transformer-outdir",  default=None, dest="transformer_outdir",
                     help="Output dir for A1 Transformer (default: {artifacts-dir}/maneuver_transformer)")
    g_a.add_argument("--xgboost-outdir",      default=None, dest="xgboost_outdir",
                     help="Output dir for A2 XGBoost (default: {artifacts-dir}/maneuver_xgboost)")
    g_a.add_argument("--rf-outdir",           default=None, dest="rf_outdir",
                     help="Output dir for A3 Random Forest (default: {artifacts-dir}/maneuver_rf)")
    g_a.add_argument("--lightgbm-outdir",     default=None, dest="lightgbm_outdir",
                     help="Output dir for A4 LightGBM (default: {artifacts-dir}/maneuver_lightgbm)")
    g_a.add_argument("--gru-outdir",          default=None, dest="gru_outdir",
                     help="Output dir for A5 GRU (default: {artifacts-dir}/maneuver_gru)")
    g_a.add_argument("--lstm-outdir",         default=None, dest="lstm_outdir",
                     help="Output dir for A6 LSTM (default: {artifacts-dir}/maneuver_lstm)")
    g_a.add_argument("--tcn-outdir",          default=None, dest="tcn_outdir",
                     help="Output dir for A7 TCN (default: {artifacts-dir}/maneuver_tcn)")
    g_a.add_argument("--mlp-mean-outdir",     default=None, dest="mlp_mean_outdir",
                     help="Output dir for A8 MLP mean (default: {artifacts-dir}/maneuver_mlp_mean)")
    g_a.add_argument("--mlp-max-outdir",      default=None, dest="mlp_max_outdir",
                     help="Output dir for A9 MLP max (default: {artifacts-dir}/maneuver_mlp_max)")
    g_a.add_argument("--mlp-concat-outdir",   default=None, dest="mlp_concat_outdir",
                     help="Output dir for A10 MLP concat (default: {artifacts-dir}/maneuver_mlp_concat)")
    g_a.add_argument("--epochs", type=int, default=3,
                     help="Training epochs for Use Case A transformer (default: 3)")
    g_a.add_argument("--use-video", action="store_true", dest="use_video",
                     help="Enable video fusion for Use Case A model training (sensor + camera)")
    g_a.add_argument("--video-extractor", default="mobilenet_v3_small", dest="video_extractor",
                     help="Video backbone for Use Case A video fusion (default: mobilenet_v3_small; alt: resnet18)")

    # ── Use Case B — EAF event detection ─────────────────────────────────────
    g_b = p.add_argument_group("Use Case B  [EAF event detection]")
    g_b.add_argument("--eaf-parsed-dir", default=DEFAULT_EAF_PARSED_DIR, dest="eaf_parsed_dir",
                     help="Parsed EAF JSON files (Use Case B)")
    g_b.add_argument("--vocab-dir", default=DEFAULT_VOCAB_DIR, dest="vocab_dir",
                     help="Folder with vocab_*.json files (Use Case B)")
    g_b.add_argument("--det-cache-dir", default=DEFAULT_DET_CACHE_DIR, dest="det_cache_dir",
                     help="YOLOv8 detection feature cache dir (Use Case B, optional)")
    g_b.add_argument("--eaf-outdir", default=None, dest="eaf_outdir",
                     help="Output dir for B1/B2 EAF two-stage model (default: {artifacts-dir}/eaf_two_stage)")
    g_b.add_argument("--yolo-outdir", default=None, dest="yolo_outdir",
                     help="Output dir for B3/B4 Two-Stage YOLO (default: {artifacts-dir}/eaf_yolo)")
    g_b.add_argument("--eaf-epochs", type=int, default=40, dest="eaf_epochs",
                     help="Training epochs for Use Case B two-stage model (default: 40)")

    # ── Use Case C — Digital Twin simulation ─────────────────────────────────
    g_c = p.add_argument_group("Use Case C  [Digital Twin simulation]")
    g_c.add_argument("--dt-basic-outdir", default=None, dest="dt_basic_outdir",
                     help="Output dir for C1 basic DT simulation (default: {artifacts-dir}/dt_basic)")
    g_c.add_argument("--dt-optimized-outdir", default=None, dest="dt_optimized_outdir",
                     help="Output dir for C2 optimized DT simulation (default: {artifacts-dir}/dt_optimized)")

    # ── Use Case D — Driving style clustering ────────────────────────────────
    g_d = p.add_argument_group("Use Case D  [driving style clustering]")
    g_d.add_argument("--style-outdir", default=None, dest="style_outdir",
                     help="Output dir for D1 style clustering (default: {artifacts-dir}/style)")
    g_d.add_argument("--style-k", type=int, default=DEFAULT_STYLE_K, dest="style_k",
                     help=f"Number of style clusters for Use Case D (default from config.yaml: {DEFAULT_STYLE_K})")

    # ── Use Case E — Explainability ───────────────────────────────────────────
    g_e = p.add_argument_group("Use Case E  [explainability]")
    g_e.add_argument("--explain-outdir", default=None, dest="explain_outdir",
                     help="Output dir for E1 explanations (default: {artifacts-dir}/explain)")
    g_e.add_argument("--explain-every-steps", type=int, default=50, dest="explain_every_steps",
                     help="Explanation granularity in steps for Use Case E (default: 50)")
    g_e.add_argument("--explain-modeldir", default=None, dest="explain_modeldir",
                     help="Explicit model directory for Use Case E explain (overrides automatic candidate search)")

    return p


def main(argv=None) -> None:
    parser = build_parser()
    args = parser.parse_args(argv)

    # Normalise --steps into an uppercase list (or None = run all)
    if args.steps:
        args.steps = [s.strip().upper() for s in args.steps.split(",") if s.strip()]
    else:
        args.steps = None

    # Validate step IDs against known steps
    if args.steps:
        unknown = [s for s in args.steps if s not in STEP_DESCRIPTIONS]
        if unknown:
            parser.error(
                f"Unknown step ID(s): {', '.join(unknown)}\n"
                f"Valid step IDs: {', '.join(STEP_DESCRIPTIONS.keys())}"
            )

    # Resolve output directory defaults (None → relative to artifacts_dir)
    _base = Path(args.artifacts_dir)
    if not args.transformer_outdir:    args.transformer_outdir    = str(_base / "maneuver_transformer")
    if not args.xgboost_outdir:        args.xgboost_outdir        = str(_base / "maneuver_xgboost")
    if not args.rf_outdir:             args.rf_outdir             = str(_base / "maneuver_rf")
    if not args.lightgbm_outdir:       args.lightgbm_outdir       = str(_base / "maneuver_lightgbm")
    if not args.gru_outdir:            args.gru_outdir            = str(_base / "maneuver_gru")
    if not args.lstm_outdir:           args.lstm_outdir           = str(_base / "maneuver_lstm")
    if not args.tcn_outdir:            args.tcn_outdir            = str(_base / "maneuver_tcn")
    if not args.mlp_mean_outdir:       args.mlp_mean_outdir       = str(_base / "maneuver_mlp_mean")
    if not args.mlp_max_outdir:        args.mlp_max_outdir        = str(_base / "maneuver_mlp_max")
    if not args.mlp_concat_outdir:     args.mlp_concat_outdir     = str(_base / "maneuver_mlp_concat")
    if not args.eaf_outdir:            args.eaf_outdir            = str(_base / "eaf_two_stage")
    if not args.yolo_outdir:           args.yolo_outdir           = str(_base / "eaf_yolo")
    if not args.dt_basic_outdir:       args.dt_basic_outdir       = str(_base / "dt_basic")
    if not args.dt_optimized_outdir:   args.dt_optimized_outdir   = str(_base / "dt_optimized")
    if not args.style_outdir:          args.style_outdir          = str(_base / "style")
    if not args.explain_outdir:        args.explain_outdir        = str(_base / "explain")

    # Create artefacts directory
    Path(args.artifacts_dir).mkdir(parents=True, exist_ok=True)

    print("\n" + "="*60)
    print("  TWIMO — Validation Use Case Scenarios")
    print("  DTE Framework: Digital Twin Engineering")
    print("="*60)
    print(f"  Config source : config.yaml" if _CFG else "  Config source : defaults (config.yaml not found)")
    print(f"  Root          : {args.root}")
    print(f"  Manifest      : {args.manifest}")
    print(f"  Artifacts dir : {args.artifacts_dir}")
    if args.steps:
        print(f"  Steps filter  : {', '.join(args.steps)}")

    # Determine which use cases to run
    if args.all:
        cases_to_run = list(SCENARIOS.keys())
    else:
        cases_to_run = [args.use_case]

    # Step 0 — Setup (scan + manifest)
    if not args.skip_setup:
        run_setup(args)
    else:
        print(f"\n[Setup] Skipped (using existing manifest: {args.manifest})")

    # Run selected use cases
    for case in cases_to_run:
        print(f"\n>>> Starting Use Case {case}: {SCENARIO_LABELS[case]}")
        try:
            SCENARIOS[case](args)
        except Exception as exc:
            print(f"\n[ERROR] Use Case {case} failed: {type(exc).__name__}: {exc}")
            if not args.all:
                raise
            print("        Continuing with next use case...")

    print("\n" + "="*60)
    print("  All requested use cases completed.")
    print(f"  Artefacts in: {args.artifacts_dir}")
    print("="*60 + "\n")


if __name__ == "__main__":
    main()
