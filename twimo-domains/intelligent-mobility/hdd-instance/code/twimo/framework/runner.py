"""twimo/framework/runner.py
=========================
TwimoRunner — programmatic interface to the TWIMO pipeline.

Bridges the DTE framework objects (DigitalTwin, DigitalShadow) to the CLI
execution functions in ``twimo/cli.py`` without touching their internals.

Usage example
-------------
>>> from twimo.framework.runner import TwimoRunner
>>> from twimo.framework.twimo_components import instantiate_hdd_driving_behavior_twin
>>>
>>> twin = instantiate_hdd_driving_behavior_twin(
...     root="./example_data",
...     sample_hz=3.0,
...     extractor="none",       # "torch" | "eaf" | "yolo" | "none"
... )
>>> runner = TwimoRunner(
...     twin=twin,
...     manifest="./artifacts/manifest.jsonl",
... )
>>> runner.scan(root="./example_data", out="./artifacts/manifest.jsonl")
>>> runner.train_maneuver(outdir="./artifacts/maneuver_transformer", epochs=5)
>>> runner.simulate_dt(outdir="./artifacts/dt_eval")
>>> runner.simulate_dt_optimized(outdir="./artifacts/dt_optimized")
>>> runner.train_style(outdir="./artifacts/style", k=3)
>>> runner.explain(modeldir="./artifacts/maneuver_transformer", outdir="./artifacts/explain")

DTE Mapping
-----------
This module acts as the **executor** layer, connecting:
    digitalTwin.DigitalTwin (design config)
        -> TwimoRunner (adapter)
            -> twimo/cli.py cmd_* functions (execution)
"""
from __future__ import annotations

import argparse
from pathlib import Path
from typing import Any, Dict, List, Optional

from twimo.framework.twimo_components import DigitalTwin


def load_config(config_path: str | Path = "config.yaml") -> Dict[str, Any]:
    """Load TWIMO configuration from a YAML file.

    Reads the project-level ``config.yaml`` and returns it as a plain dict.
    If the file does not exist or cannot be parsed, an empty dict is returned
    so callers can always use ``.get()`` with safe defaults.

    Parameters
    ----------
    config_path : str or Path
        Path to the YAML configuration file (default: ``config.yaml`` in CWD).

    Returns
    -------
    dict
        Configuration dictionary.  Keys mirror the top-level YAML keys.

    Examples
    --------
    >>> cfg = load_config()
    >>> data_dir = cfg.get("data_dir", "./example_data")
    >>> artifacts_dir = cfg.get("artifacts_dir", "./artifacts")
    >>> manifest_file = cfg.get("manifest_file", "./artifacts/manifest.jsonl")
    """
    try:
        import yaml  # PyYAML — listed in requirements.txt
    except ImportError:
        return {}

    p = Path(config_path)
    if not p.exists():
        return {}

    try:
        with open(p, "r", encoding="utf-8") as fh:
            cfg = yaml.safe_load(fh) or {}
        return cfg
    except Exception:
        return {}


class TwimoRunner:
    """Programmatic adapter from DTE framework objects to the TWIMO CLI pipeline.

    Wraps every CLI command as a Python method. Each method builds an
    ``argparse.Namespace`` from the ``DigitalTwin`` config + the supplied
    runtime arguments, then delegates to the corresponding ``cmd_*`` function
    in ``twimo/cli.py``.

    Parameters
    ----------
    twin : DigitalTwin
        Design-time blueprint produced by ``instantiate_hdd_driving_behavior_twin()``.
    manifest : str or Path
        Path to the JSONL session manifest (output of ``scan`` / ``cmd_scan``).
    """

    def __init__(self, twin: DigitalTwin, manifest: str | Path) -> None:
        self.twin = twin
        self.manifest = str(manifest)

    # ------------------------------------------------------------------
    # scan
    # ------------------------------------------------------------------

    def scan(
        self,
        root: str | Path,
        out: str | Path,
        prealigned_labels_dir: Optional[str] = None,
        prealigned_sensors_dir: Optional[str] = None,
    ) -> None:
        """Scan an HDD-like directory and create (or update) the manifest.jsonl.

        DTE Phase: Design — discovers the physical data sources.
        PNG Layer: Data Acquisition.

        Parameters
        ----------
        root : str or Path
            Root folder containing HDD session sub-directories.
        out : str or Path
            Output path for the JSONL manifest (e.g. ``./artifacts/manifest.jsonl``).
        prealigned_labels_dir : str, optional
            Folder with prealigned ``<session_id>.npy`` label arrays.
        prealigned_sensors_dir : str, optional
            Folder with prealigned ``<session_id>.npy`` sensor arrays.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.cli scan \\
                --root <root> \\
                --out <out> \\
                [--prealigned-labels-dir <labels_dir>] \\
                [--prealigned-sensors-dir <sensors_dir>]
        """
        from twimo.cli import cmd_scan
        args = argparse.Namespace(
            root=str(root),
            out=str(out),
            prealigned_labels_dir=prealigned_labels_dir,
            prealigned_sensors_dir=prealigned_sensors_dir,
        )
        cmd_scan(args)
        # Update the stored manifest path after scanning
        self.manifest = str(out)

    # ------------------------------------------------------------------
    # train_maneuver
    # ------------------------------------------------------------------

    def train_maneuver(
        self,
        outdir: str | Path,
        *,
        model: Optional[str] = None,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        batch_size: int = 64,
        lr: float = 1e-3,
        d_model: int = 128,
        nhead: int = 4,
        num_layers: int = 3,
        test_ratio: float = 0.2,
        window_seconds: float = 3.0,
        horizons: Optional[List[float]] = None,
        use_video: Optional[bool] = None,
        video_extractor: str = "mobilenet_v3_small",
        video_fps: Optional[float] = None,
        video_cache: Optional[str] = None,
        max_frames: Optional[int] = None,
    ) -> None:
        """Train a maneuver prediction model.

        Values not supplied default to those stored in ``self.twin`` where
        applicable, then fall back to the same defaults as the CLI.

        DTE Phase: Build.
        PNG Layer: Digital Twin -> Driver Behaviour DT (AI Service).
        Outputs: ``<outdir>/predictor_metadata.json``, ``twin_config.json``,
                 ``test_metrics.json``, ``model.*``.

        Parameters
        ----------
        outdir : str or Path
            Directory where model artefacts are saved.
        model : str, optional
            Model family.  Defaults to ``twin.driving_model.model_type``.
            Choices: transformer | xgboost | lightgbm | random_forest |
                     gru | lstm | tcn | mlp_mean | mlp_max | mlp_concat | baseline
        sample_hz : float, optional
            Sensor resampling frequency.  Defaults to ``twin.perception.sample_hz``.
        epochs : int
            Training epochs (neural models only).
        batch_size : int
            Mini-batch size.
        lr : float
            Learning rate.
        d_model : int
            Transformer hidden dimension.
        nhead : int
            Transformer attention heads.
        num_layers : int
            Transformer encoder layers.
        test_ratio : float
            Fraction of days reserved for the test split.
        window_seconds : float
            Input sliding-window length in seconds.
        horizons : list of float, optional
            Prediction horizons in seconds.
            Default: [0.1, 0.25, 0.5, 0.75, 1.0, 2.0, 3.0, 4.0, 5.0]
        use_video : bool, optional
            Whether to fuse video features.
            Defaults to ``twin.perception.extractor == "torch"``.
        video_extractor : str
            Torchvision backbone for video (mobilenet_v3_small | resnet18).
        video_fps : float, optional
            Override sampled video FPS.
        video_cache : str, optional
            Directory for cached video .npy features.
        max_frames : int, optional
            Debug cap on sampled frames per video.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.cli train-maneuver \\
                --manifest <manifest> \\
                --outdir <outdir> \\
                --model <model> \\
                --sample-hz <sample_hz> \\
                --epochs <epochs>
        """
        from twimo.cli import cmd_train_maneuver

        _model = model or self.twin.driving_model.model_type or "transformer"
        _hz = sample_hz if sample_hz is not None else self.twin.perception.sample_hz
        _use_video = use_video if use_video is not None else (self.twin.perception.extractor == "torch")
        _horizons = horizons or [0.1, 0.25, 0.5, 0.75, 1.0, 2.0, 3.0, 4.0, 5.0]

        args = argparse.Namespace(
            manifest=self.manifest,
            outdir=str(outdir),
            model=_model,
            sample_hz=float(_hz),
            epochs=int(epochs),
            batch_size=int(batch_size),
            lr=float(lr),
            d_model=int(d_model),
            nhead=int(nhead),
            num_layers=int(num_layers),
            test_ratio=float(test_ratio),
            window_seconds=float(window_seconds),
            horizons=[float(h) for h in _horizons],
            use_video=bool(_use_video),
            video_extractor=video_extractor,
            video_fps=video_fps,
            video_cache=video_cache,
            max_frames=max_frames,
            max_sessions=None,
        )
        cmd_train_maneuver(args)

    # ------------------------------------------------------------------
    # simulate_dt
    # ------------------------------------------------------------------

    def simulate_dt(
        self,
        outdir: str | Path,
        *,
        sample_hz: float = 10.0,
        wheelbase: float = 2.7,
        max_sessions: Optional[int] = None,
        save_traj: bool = False,
    ) -> None:
        """Run the basic kinematic bicycle Digital Twin simulation.

        DTE Phase: Validate.
        PNG Layer: Release & Validation -> DT Validation Comparator.
        Outputs: ``dt_summary.json``, ``twin_run.json``, ``dt_aggregated_metrics.json``.

        Parameters
        ----------
        outdir : str or Path
            Directory for DT simulation results.
        sample_hz : float
            Simulation frequency in Hz (default 10.0).
        wheelbase : float
            Vehicle wheelbase in metres (default 2.7).
        max_sessions : int, optional
            Cap number of sessions (debug).
        save_traj : bool
            Save per-session trajectory CSVs.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.cli simulate-dt \\
                --manifest <manifest> \\
                --outdir <outdir> \\
                --sample-hz <sample_hz> \\
                --wheelbase <wheelbase>
        """
        from twimo.cli import cmd_simulate_dt
        args = argparse.Namespace(
            manifest=self.manifest,
            outdir=str(outdir),
            sample_hz=float(sample_hz),
            wheelbase=float(wheelbase),
            max_sessions=max_sessions,
            save_traj=bool(save_traj),
        )
        cmd_simulate_dt(args)

    # ------------------------------------------------------------------
    # simulate_dt_optimized
    # ------------------------------------------------------------------

    def simulate_dt_optimized(
        self,
        outdir: str | Path,
        *,
        sample_hz: float = 3.0,
        wheelbase: float = 2.7,
        max_sessions: Optional[int] = None,
        save_traj: bool = False,
        calibrate: bool = True,
        optimize_wheelbase: bool = True,
        optimize_speed: bool = True,
        optimize_steer: bool = True,
        use_reset: bool = True,
        reset_interval: int = 30,
        multi_sample_init: bool = True,
        init_samples: int = 10,
    ) -> None:
        """Run the optimized Digital Twin with auto-calibration and drift correction.

        DTE Phase: Validate.
        PNG Layer: Release & Validation -> DT Validation Comparator.
        Outputs: ``dt_optimized_summary.json``, ``twin_run.json``,
                 ``dt_optimized_aggregated_metrics.json``.

        Parameters
        ----------
        outdir : str or Path
            Directory for DT simulation results.
        sample_hz : float
            Simulation frequency in Hz (default 3.0).
        wheelbase : float
            Initial wheelbase guess in metres (default 2.7).
        calibrate : bool
            Auto-calibrate parameters per session (default True).
        use_reset : bool
            Periodically reset position to RTK GPS (default True).
        reset_interval : int
            Reset every N steps (default 30 = 10 s at 3 Hz).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.cli simulate-dt-optimized \\
                --manifest <manifest> \\
                --outdir <outdir> \\
                --sample-hz <sample_hz>
        """
        from twimo.cli import cmd_simulate_dt_optimized
        args = argparse.Namespace(
            manifest=self.manifest,
            outdir=str(outdir),
            sample_hz=float(sample_hz),
            wheelbase=float(wheelbase),
            max_sessions=max_sessions,
            save_traj=bool(save_traj),
            calibrate=bool(calibrate),
            no_calibrate=not calibrate,
            optimize_wheelbase=bool(optimize_wheelbase),
            optimize_speed=bool(optimize_speed),
            optimize_steer=bool(optimize_steer),
            use_reset=bool(use_reset),
            no_reset=not use_reset,
            reset_interval=int(reset_interval),
            multi_sample_init=bool(multi_sample_init),
            init_samples=int(init_samples),
        )
        cmd_simulate_dt_optimized(args)

    # ------------------------------------------------------------------
    # train_style
    # ------------------------------------------------------------------

    def train_style(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        k: int = 3,
    ) -> None:
        """Cluster driving styles using K-means on aggregated features.

        DTE Phase: Evolve.
        Outputs: ``style_centroids.json``.

        Parameters
        ----------
        outdir : str or Path
            Directory for style clustering results.
        sample_hz : float, optional
            Sensor resampling frequency.  Defaults to ``twin.perception.sample_hz``.
        k : int
            Number of driving style clusters (default 3).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.cli train-style \\
                --manifest <manifest> \\
                --outdir <outdir> \\
                --k <k>
        """
        from twimo.cli import cmd_train_style
        _hz = sample_hz if sample_hz is not None else self.twin.perception.sample_hz
        args = argparse.Namespace(
            manifest=self.manifest,
            outdir=str(outdir),
            sample_hz=float(_hz),
            k=int(k),
            max_sessions=None,
        )
        cmd_train_style(args)

    # ------------------------------------------------------------------
    # explain
    # ------------------------------------------------------------------

    def explain(
        self,
        modeldir: str | Path,
        outdir: str | Path,
        *,
        model: Optional[str] = None,
        use_video: Optional[bool] = None,
        video_extractor: str = "mobilenet_v3_small",
        video_fps: Optional[float] = None,
        max_frames: int = 300,
        explain_every_steps: int = 50,
        max_steps: Optional[int] = None,
        max_sessions: Optional[int] = None,
    ) -> None:
        """Generate textual explanations over model predictions.

        DTE Phase: Evolve.
        PNG Layer: Digital Twin -> Explanability (AI Service).
        Outputs: ``explanations__<day>.jsonl``, ``explain_index.json``.

        Parameters
        ----------
        modeldir : str or Path
            Directory containing the trained model artefacts
            (``model_kind.txt``, ``config.json``, model weights).
        outdir : str or Path
            Directory for explanation output files.
        model : str, optional
            Override model kind (auto-detected from ``model_kind.txt`` if omitted).
        use_video : bool, optional
            Fuse video features.  Defaults to ``twin.perception.extractor == "torch"``.
        explain_every_steps : int
            Generate one explanation every N time steps (default 50).
        max_sessions : int, optional
            Cap number of sessions (debug).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.cli explain \\
                --manifest <manifest> \\
                --modeldir <modeldir> \\
                --outdir <outdir> \\
                --explain-every-steps <explain_every_steps>
        """
        from twimo.cli import cmd_explain
        _use_video = use_video if use_video is not None else (self.twin.perception.extractor == "torch")
        args = argparse.Namespace(
            manifest=self.manifest,
            modeldir=str(modeldir),
            outdir=str(outdir),
            model=model,
            use_video=bool(_use_video),
            video_extractor=video_extractor,
            video_fps=video_fps,
            max_frames=max_frames,
            explain_every_steps=explain_every_steps,
            max_steps=max_steps,
            max_sessions=max_sessions,
        )
        cmd_explain(args)

    # ------------------------------------------------------------------
    # full_pipeline  (convenience wrapper)
    # ------------------------------------------------------------------

    def full_pipeline(
        self,
        artifacts_dir: str | Path = "./artifacts",
        *,
        train_epochs: int = 3,
        dt_sample_hz: float = 3.0,
        style_k: int = 3,
        explain_every_steps: int = 50,
    ) -> None:
        """Run the complete TWIMO pipeline: train -> simulate DT -> style -> explain.

        Executes all four DTE phases in sequence using default parameters.
        Individual step directories are created under ``artifacts_dir``.

        DTE Phases: Build -> Validate -> Evolve.

        Parameters
        ----------
        artifacts_dir : str or Path
            Root directory for all pipeline outputs.
        train_epochs : int
            Epochs for neural model training (default 3).
        dt_sample_hz : float
            DT simulation frequency (default 3.0 Hz).
        style_k : int
            Number of driving style clusters (default 3).
        explain_every_steps : int
            Explanation granularity in time steps (default 50).

        Example
        -------
        >>> runner.full_pipeline("./artifacts", train_epochs=5)
        """
        base = Path(artifacts_dir)
        model_dir = base / f"maneuver_{self.twin.driving_model.model_type}"

        print(f"\n=== TWIMO Full Pipeline | Twin: {self.twin.name} ===\n")

        print("[1/4] Training maneuver model...")
        self.train_maneuver(outdir=model_dir, epochs=train_epochs)

        print("[2/4] Simulating Digital Twin (optimized)...")
        self.simulate_dt_optimized(outdir=base / "dt_optimized", sample_hz=dt_sample_hz)

        print("[3/4] Clustering driving styles...")
        self.train_style(outdir=base / "style", k=style_k)

        print("[4/4] Generating explanations...")
        self.explain(
            modeldir=model_dir,
            outdir=base / "explain",
            explain_every_steps=explain_every_steps,
        )

        print(f"\n=== Pipeline complete. Artefacts in: {base} ===")

    # ==================================================================
    # SECTION: Additional model convenience methods (Use Case A)
    # ==================================================================
    #
    # Each method is a thin wrapper over train_maneuver() that locks the
    # model type, making scenario files and Jupyter notebooks cleaner.
    # All keyword arguments are forwarded to train_maneuver().

    def _train_model(
        self,
        model: str,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
        **kwargs,
    ) -> None:
        """Internal helper that calls train_maneuver with a fixed model type."""
        self.train_maneuver(
            outdir=outdir,
            model=model,
            sample_hz=sample_hz,
            epochs=epochs,
            horizons=horizons,
            **kwargs,
        )

    # ── A: sensor-only model shortcuts ────────────────────────────────

    def train_lightgbm(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        horizons: Optional[List[float]] = None,
    ) -> None:
        """Train LightGBM maneuver predictor (fast, CPU-friendly, low memory).

        DTE Phase: Build.  PNG Layer: Digital Twin -> Driver Behaviour DT.
        Equivalent CLI: ``python -m twimo.cli train-maneuver --model lightgbm``

        Parameters
        ----------
        outdir : str or Path
            Directory for model artefacts (``model.joblib``, ``test_metrics.json``).
        sample_hz : float, optional
            Sensor resampling frequency.  Defaults to ``twin.perception.sample_hz``.
        horizons : list of float, optional
            Prediction horizons in seconds.
        """
        self._train_model("lightgbm", outdir, sample_hz=sample_hz, horizons=horizons)

    def train_gru(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
    ) -> None:
        """Train GRU maneuver predictor (recurrent, good for sequences).

        DTE Phase: Build.  PNG Layer: Digital Twin -> Driver Behaviour DT.
        Equivalent CLI: ``python -m twimo.cli train-maneuver --model gru``
        """
        self._train_model("gru", outdir, sample_hz=sample_hz, epochs=epochs, horizons=horizons)

    def train_lstm(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
    ) -> None:
        """Train LSTM maneuver predictor (long-term temporal dependencies).

        DTE Phase: Build.  PNG Layer: Digital Twin -> Driver Behaviour DT.
        Equivalent CLI: ``python -m twimo.cli train-maneuver --model lstm``
        """
        self._train_model("lstm", outdir, sample_hz=sample_hz, epochs=epochs, horizons=horizons)

    def train_tcn(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
    ) -> None:
        """Train TCN maneuver predictor (temporal convolutions, parallelizable).

        DTE Phase: Build.  PNG Layer: Digital Twin -> Driver Behaviour DT.
        Equivalent CLI: ``python -m twimo.cli train-maneuver --model tcn``
        """
        self._train_model("tcn", outdir, sample_hz=sample_hz, epochs=epochs, horizons=horizons)

    def train_mlp_mean(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
    ) -> None:
        """Train MLP (mean pooling) maneuver predictor.

        DTE Phase: Build.  PNG Layer: Digital Twin -> Driver Behaviour DT.
        Equivalent CLI: ``python -m twimo.cli train-maneuver --model mlp_mean``
        """
        self._train_model("mlp_mean", outdir, sample_hz=sample_hz, epochs=epochs, horizons=horizons)

    def train_mlp_max(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
    ) -> None:
        """Train MLP (max pooling) maneuver predictor.

        DTE Phase: Build.  PNG Layer: Digital Twin -> Driver Behaviour DT.
        Equivalent CLI: ``python -m twimo.cli train-maneuver --model mlp_max``
        """
        self._train_model("mlp_max", outdir, sample_hz=sample_hz, epochs=epochs, horizons=horizons)

    def train_mlp_concat(
        self,
        outdir: str | Path,
        *,
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
    ) -> None:
        """Train MLP (concat pooling: mean+max+first+last) maneuver predictor.

        DTE Phase: Build.  PNG Layer: Digital Twin -> Driver Behaviour DT.
        Equivalent CLI: ``python -m twimo.cli train-maneuver --model mlp_concat``
        """
        self._train_model("mlp_concat", outdir, sample_hz=sample_hz, epochs=epochs, horizons=horizons)

    # ── A+Video: sensor + camera (Sensors + Camera fusion) ────────────

    def train_maneuver_with_video(
        self,
        outdir: str | Path,
        *,
        model: Optional[str] = None,
        video_extractor: str = "mobilenet_v3_small",
        sample_hz: Optional[float] = None,
        epochs: int = 3,
        horizons: Optional[List[float]] = None,
        video_fps: Optional[float] = None,
        video_cache: Optional[str] = None,
        max_frames: Optional[int] = None,
    ) -> None:
        """Train a maneuver predictor with CSV sensor + camera video fusion.

        Fuses temporal sensor signals with per-frame visual embeddings extracted
        by a Torchvision backbone (MobileNetV3-Small by default).

        DTE Phase: Build.
        PNG Layer: Data Acquisition -> Camera / Digital Shadow -> Time-Aligned Shadow.
        Requires ffmpeg on PATH and at least one session with a ``video_path``.

        Parameters
        ----------
        outdir : str or Path
            Directory for model artefacts.
        model : str, optional
            Model family (default: ``twin.driving_model.model_type``).
            Any model accepted by ``train_maneuver`` works with video fusion.
        video_extractor : str
            Torchvision backbone.  ``mobilenet_v3_small`` (default) or ``resnet18``.
        sample_hz : float, optional
            Sensor resampling frequency.
        epochs : int
            Training epochs for neural models.
        horizons : list of float, optional
            Prediction horizons in seconds.
        video_fps : float, optional
            Override video sampling FPS.
        video_cache : str, optional
            Cache directory for pre-extracted video embeddings (.npy).
        max_frames : int, optional
            Debug cap on sampled frames per video.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.cli train-maneuver \\
                --manifest <manifest> --outdir <outdir> \\
                --model <model> \\
                --use-video \\
                --video-extractor mobilenet_v3_small
        """
        self.train_maneuver(
            outdir=outdir,
            model=model,
            sample_hz=sample_hz,
            epochs=epochs,
            horizons=horizons,
            use_video=True,
            video_extractor=video_extractor,
            video_fps=video_fps,
            video_cache=video_cache,
            max_frames=max_frames,
        )

    # ==================================================================
    # SECTION: Plot generation
    # ==================================================================

    @staticmethod
    def _call_main_with_argv(main_fn, argv: List[str]) -> None:
        """Temporarily patch sys.argv and call a script main() function.

        Used for scripts that rely on ``parser.parse_args()`` (no args param).
        Restores the original sys.argv unconditionally via finally.
        """
        import sys
        old_argv = sys.argv
        sys.argv = ["runner"] + [str(a) for a in argv]
        try:
            main_fn()
        finally:
            sys.argv = old_argv

    def plot_metrics(
        self,
        modeldir: str | Path,
        outdir: str | Path,
        *,
        metric_file: str = "test_metrics.json",
        log_scale: bool = False,
    ) -> None:
        """Plot per-horizon maneuver prediction metrics from a saved metrics JSON.

        Generates line plots and bar plots for accuracy, precision, recall, F1
        (macro + weighted) vs prediction horizon.

        DTE Phase: Evolve — Release & Validation.
        PNG Layer: Release & Validation -> External Consumer (Dashboard).

        Parameters
        ----------
        modeldir : str or Path
            Model artefact directory containing the metrics JSON file.
        outdir : str or Path
            Directory where plot images are saved (PNG files).
        metric_file : str
            Name of the metrics JSON inside ``modeldir`` (default: ``test_metrics.json``).
            Use ``train_metrics.json`` or ``val_metrics.json`` for other splits.
        log_scale : bool
            If True, use log-scale x-axis for the horizon axis.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/plots/maneuver_plots.py \\
                <metrics_json> <outdir>
        """
        from twimo.plots import maneuver_plots, maneuver_plots_log

        Path(outdir).mkdir(parents=True, exist_ok=True)
        metrics_json = Path(modeldir) / metric_file

        plotter = maneuver_plots_log if log_scale else maneuver_plots
        self._call_main_with_argv(
            plotter.main,
            [str(metrics_json), str(outdir)],
        )

    def plot_roc_curves(
        self,
        modeldir: str | Path,
        outdir: str | Path,
        *,
        splits: Optional[List[str]] = None,
    ) -> None:
        """Plot per-class ROC curves from a saved ``roc_curves.json``.

        Generates one figure per horizon with per-class FPR/TPR curves and AUC
        annotations, plus a summary figure across all horizons.

        DTE Phase: Evolve — Release & Validation.

        Parameters
        ----------
        modeldir : str or Path
            Directory containing ``roc_curves.json`` (output of ``train-maneuver``).
        outdir : str or Path
            Directory where ROC plot images are saved.
        splits : list of str, optional
            Which metric splits to plot (e.g. ``["test", "val"]``).
            Default: all splits present in the JSON.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/plots/plot_roc_curves.py \\
                --roc-json <modeldir>/roc_curves.json \\
                --outdir <outdir>
        """
        from twimo.plots import plot_roc_curves as _roc_mod

        Path(outdir).mkdir(parents=True, exist_ok=True)
        roc_json = Path(modeldir) / "roc_curves.json"
        argv = ["--roc-json", str(roc_json), "--outdir", str(outdir)]
        if splits:
            argv += ["--splits"] + splits
        self._call_main_with_argv(_roc_mod.main, argv)

    # ==================================================================
    # SECTION: EAF Annotation Strategy (single-target / multi-target)
    # ==================================================================

    def align_eaf_single_target(
        self,
        eaf_dir: str | Path,
        sensor_dir: str | Path,
        outdir: str | Path,
        *,
        sample_hz: float = 3.0,
    ) -> None:
        """Align EAF annotations to sensor timeline — single-target strategy.

        Classic pipeline: one annotation tier per session aligned to the 3 Hz
        sensor timeline.  Produces ``<session_id>.npy`` label arrays.

        DTE Phase: Design / Build.
        PNG Layer: Digital Shadow -> EAF Alignment Tiers.
        SupervisionMode: EAF_EXPERT (Path B).

        Parameters
        ----------
        eaf_dir : str or Path
            Directory containing raw ``.eaf`` annotation files.
        sensor_dir : str or Path
            Directory with prealigned ``<session_id>.npy`` sensor arrays.
        outdir : str or Path
            Output directory for aligned label arrays.
        sample_hz : float
            Target resampling frequency in Hz (default 3.0).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/strategies_eaf/align_eaf_to_sensors.py \\
                --eaf-dir <eaf_dir> \\
                --sensor-dir <sensor_dir> \\
                --outdir <outdir> \\
                --sample-hz <sample_hz>
        """
        from twimo.strategies_eaf import align_eaf_to_sensors as _mod
        Path(outdir).mkdir(parents=True, exist_ok=True)
        self._call_main_with_argv(
            _mod.main,
            [
                "--eaf-dir",    str(eaf_dir),
                "--sensor-dir", str(sensor_dir),
                "--outdir",     str(outdir),
                "--sample-hz",  str(sample_hz),
            ],
        )

    def align_eaf_multi_target(
        self,
        eaf_dir: str | Path,
        sensor_dir: str | Path,
        outdir: str | Path,
        *,
        sample_hz: float = 3.0,
        simple: bool = False,
    ) -> None:
        """Align EAF annotations to sensor timeline — multi-target strategy.

        Advanced pipeline: multiple annotation tiers (Goal, Stimulus, Cause,
        AttentionCue) aligned simultaneously to the 3 Hz sensor timeline.
        Produces per-tier ``<session_id>_<tier>.npy`` label arrays.

        DTE Phase: Design / Build.
        PNG Layer: Digital Shadow -> EAF Alignment Tiers.
        SupervisionMode: EAF_EXPERT (Path B).

        Parameters
        ----------
        eaf_dir : str or Path
            Directory containing raw ``.eaf`` annotation files.
        sensor_dir : str or Path
            Directory with prealigned ``<session_id>.npy`` sensor arrays.
        outdir : str or Path
            Output directory for aligned label arrays.
        sample_hz : float
            Target resampling frequency in Hz (default 3.0).
        simple : bool
            If True, use the simplified multi-target aligner
            (``align_eaf_to_sensors_multitarget_simple``).
            Default False uses the full ``align_eaf_to_sensors_multitarget_new``.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/strategies_eaf/align_eaf_to_sensors_multitarget_new.py \\
                --eaf-dir <eaf_dir> \\
                --sensor-dir <sensor_dir> \\
                --outdir <outdir>
        """
        if simple:
            from twimo.strategies_eaf import align_eaf_to_sensors_multitarget_simple as _mod
        else:
            from twimo.strategies_eaf import align_eaf_to_sensors_multitarget_new as _mod
        Path(outdir).mkdir(parents=True, exist_ok=True)
        self._call_main_with_argv(
            _mod.main,
            [
                "--eaf-dir",    str(eaf_dir),
                "--sensor-dir", str(sensor_dir),
                "--outdir",     str(outdir),
                "--sample-hz",  str(sample_hz),
            ],
        )

    # ==================================================================
    # SECTION: Two-Stage Transformer (Event-Centric)
    # ==================================================================

    def two_stage_transformer_prepare(
        self,
        sensor_dir: str | Path,
        eaf_parsed_dir: str | Path,
        vocab_dir: str | Path,
        data_dir: str | Path,
        *,
        sample_hz: float = 3.0,
        window_sec: float = 5.0,
        stride_sec: float = 1.0,
        event_ratio: float = 0.7,
    ) -> None:
        """Prepare windowed dataset for the Two-Stage Transformer pipeline.

        Builds balanced event / no-event windows from prealigned sensors and
        parsed EAF annotations.  Output is saved to ``data_dir`` and consumed
        by ``two_stage_transformer_train_stage1/2``.

        DTE Phase: Build — data preparation.
        PNG Layer: Digital Shadow -> Time-Aligned Shadow (Features and Signals).

        Parameters
        ----------
        sensor_dir : str or Path
            Prealigned ``<session_id>.npy`` sensor arrays (3 Hz).
        eaf_parsed_dir : str or Path
            Directory with parsed EAF JSON files.
        vocab_dir : str or Path
            Directory with ``vocab_goal.json``, ``vocab_stimuli.json``, etc.
        data_dir : str or Path
            Output directory for the prepared windowed dataset.
        sample_hz : float
            Target frequency in Hz (default 3.0).
        window_sec : float
            Window length in seconds (default 5.0).
        stride_sec : float
            Window stride in seconds (default 1.0).
        event_ratio : float
            Target ratio of event windows for balancing (default 0.7).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/strategies_eaf/two_stage_transformer.py prepare \\
                --sensor-dir <sensor_dir> \\
                --eaf-parsed-dir <eaf_parsed_dir> \\
                --vocab-dir <vocab_dir> \\
                --output-dir <data_dir>
        """
        from twimo.strategies_eaf.two_stage_transformer import cmd_prepare
        Path(data_dir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            sensor_dir      = Path(sensor_dir),
            eaf_parsed_dir  = Path(eaf_parsed_dir),
            vocab_dir       = Path(vocab_dir),
            output_dir      = Path(data_dir),
            sample_hz       = float(sample_hz),
            window_sec      = float(window_sec),
            stride_sec      = float(stride_sec),
            event_ratio     = float(event_ratio),
        )
        cmd_prepare(args)

    def two_stage_transformer_train_stage1(
        self,
        data_dir: str | Path,
        outdir: str | Path,
        *,
        epochs: int = 30,
        lr: float = 1e-4,
        batch_size: int = 32,
    ) -> None:
        """Train Stage 1 — Event Detection Transformer (binary: event vs no-event).

        DTE Phase: Build.
        PNG Layer: Digital Twin -> Driver Behaviour DT (Stage 1 EventNet head).
        DTE Object: drivingBehaviour.Goal (detection trigger).

        Parameters
        ----------
        data_dir : str or Path
            Prepared dataset directory (output of ``two_stage_transformer_prepare``).
        outdir : str or Path
            Directory where the Stage 1 model (``stage1.pt``) is saved.
        epochs : int
            Training epochs (default 30).
        lr : float
            Learning rate (default 1e-4).
        batch_size : int
            Mini-batch size (default 32).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/strategies_eaf/two_stage_transformer.py train-stage1 \\
                --data-dir <data_dir> --outdir <outdir> --epochs <epochs>
        """
        from twimo.strategies_eaf.two_stage_transformer import cmd_train_stage1
        Path(outdir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            data_dir   = Path(data_dir),
            outdir     = Path(outdir),
            epochs     = int(epochs),
            lr         = float(lr),
            batch_size = int(batch_size),
        )
        cmd_train_stage1(args)

    def two_stage_transformer_train_stage2(
        self,
        data_dir: str | Path,
        stage1_model: str | Path,
        outdir: str | Path,
        *,
        epochs: int = 30,
        lr: float = 1e-4,
        batch_size: int = 32,
    ) -> None:
        """Train Stage 2 — Goal/Stimuli Classification Transformer.

        Conditioned on Stage 1 event detections, classifies each event into
        Goal (14 classes), Stimuli (9 classes), Cause (17 classes),
        and Attention (17 classes).

        DTE Phase: Build.
        PNG Layer: Digital Twin -> Driver Behaviour DT (Stage 2 ClassifyNet heads).
        DTE Objects: drivingBehaviour.Goal, Stimulus, Cause, AttentionCue.

        Parameters
        ----------
        data_dir : str or Path
            Prepared dataset directory (output of ``two_stage_transformer_prepare``).
        stage1_model : str or Path
            Path to the trained Stage 1 model file (``stage1.pt``).
        outdir : str or Path
            Directory where the Stage 2 model (``stage2.pt``) is saved.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/strategies_eaf/two_stage_transformer.py train-stage2 \\
                --data-dir <data_dir> \\
                --stage1-model <stage1_model> \\
                --outdir <outdir>
        """
        from twimo.strategies_eaf.two_stage_transformer import cmd_train_stage2
        Path(outdir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            data_dir      = Path(data_dir),
            stage1_model  = Path(stage1_model),
            outdir        = Path(outdir),
            epochs        = int(epochs),
            lr            = float(lr),
            batch_size    = int(batch_size),
        )
        cmd_train_stage2(args)

    def two_stage_transformer_predict(
        self,
        data_dir: str | Path,
        stage1_model: str | Path,
        stage2_model: str | Path,
        outdir: str | Path,
    ) -> None:
        """Run end-to-end prediction with the Two-Stage Transformer pipeline.

        Stage 1 detects events; Stage 2 classifies them into Goal/Stimuli/Cause/
        Attention.  Prediction results are saved as JSONL in ``outdir``.

        DTE Phase: Validate / Evolve.
        DTE Objects: drivingBehaviour.Goal, Stimulus, Cause, AttentionCue.

        Parameters
        ----------
        data_dir : str or Path
            Prepared dataset directory.
        stage1_model : str or Path
            Trained Stage 1 model (``stage1.pt``).
        stage2_model : str or Path
            Trained Stage 2 model (``stage2.pt``).
        outdir : str or Path
            Directory for prediction output files.
        """
        from twimo.strategies_eaf.two_stage_transformer import cmd_predict
        Path(outdir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            data_dir     = Path(data_dir),
            stage1_model = Path(stage1_model),
            stage2_model = Path(stage2_model),
            outdir       = Path(outdir),
        )
        cmd_predict(args)

    # ==================================================================
    # SECTION: Two-Stage YOLO Pipeline (Sensor + Object Detection Features)
    # ==================================================================

    def two_stage_yolo_extract(
        self,
        det_cache_dir: str | Path,
        *,
        yolo_model: str = "yolov8n.pt",
        sample_hz: float = 3.0,
        prealigned_sensors_dir: Optional[str] = None,
        overwrite: bool = False,
    ) -> None:
        """Extract YOLOv8 object detection features for the Two-Stage YOLO pipeline.

        Runs YOLOv8 on each session video and caches per-frame detection
        features as ``.npy`` arrays in ``det_cache_dir``.

        DTE Phase: Design / Build — Digital Shadow enrichment.
        PNG Layer: Data Acquisition -> Camera / Digital Shadow -> Time-Aligned Shadow.
        SupervisionMode: YOLO_DETECTION (Path C).

        Parameters
        ----------
        det_cache_dir : str or Path
            Directory where detection feature caches are written.
        yolo_model : str
            YOLOv8 weights file (default ``yolov8n.pt``).
        sample_hz : float
            Sensor frequency used for alignment (default 3.0).
        prealigned_sensors_dir : str, optional
            Prealigned sensor directory (for alignment).
        overwrite : bool
            Recompute even if cache already exists (default False).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python -m twimo.strategies_eaf.two_stage_yolo extract \\
                --manifest <manifest> \\
                --det-cache-dir <det_cache_dir>
        """
        from twimo.strategies_eaf.two_stage_yolo import cmd_extract
        Path(det_cache_dir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            manifest               = Path(self.manifest),
            det_cache_dir          = Path(det_cache_dir),
            yolo_model             = yolo_model,
            sample_hz              = float(sample_hz),
            prealigned_sensors_dir = Path(prealigned_sensors_dir) if prealigned_sensors_dir else None,
            overwrite              = bool(overwrite),
        )
        cmd_extract(args)

    def two_stage_yolo_train(
        self,
        det_cache_dir: str | Path,
        outdir: str | Path,
        *,
        sample_hz: float = 3.0,
        window_sec: float = 5.0,
        epochs: int = 30,
        lr: float = 1e-4,
        batch_size: int = 32,
        prealigned_sensors_dir: Optional[str] = None,
    ) -> None:
        """Train the Two-Stage YOLO model (EventNet + ClassifyNet on YOLO features).

        Fuses prealigned sensor signals with YOLOv8 object detection features
        to train Stage 1 (event detection) and Stage 2 (maneuver classification).

        DTE Phase: Build.
        PNG Layer: Digital Twin -> Driver Behaviour DT.
        SupervisionMode: YOLO_DETECTION (Path C).

        Parameters
        ----------
        det_cache_dir : str or Path
            Directory with pre-extracted YOLOv8 detection feature caches.
        outdir : str or Path
            Directory for trained model artefacts.
        sample_hz : float
            Sensor frequency (default 3.0).
        window_sec : float
            Input window in seconds (default 5.0).
        epochs : int
            Training epochs (default 30).
        lr : float
            Learning rate (default 1e-4).
        batch_size : int
            Mini-batch size (default 32).
        prealigned_sensors_dir : str, optional
            Prealigned sensor ``.npy`` directory.
        """
        from twimo.strategies_eaf.two_stage_yolo import cmd_train
        Path(outdir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            manifest               = Path(self.manifest),
            det_cache_dir          = Path(det_cache_dir),
            prealigned_sensors_dir = Path(prealigned_sensors_dir) if prealigned_sensors_dir else None,
            outdir                 = Path(outdir),
            sample_hz              = float(sample_hz),
            window_sec             = float(window_sec),
            epochs                 = int(epochs),
            lr                     = float(lr),
            batch_size             = int(batch_size),
        )
        cmd_train(args)

    def two_stage_yolo_evaluate(
        self,
        model_dir: str | Path,
        det_cache_dir: str | Path,
        eaf_parsed_dir: str | Path,
        outdir: str | Path,
        *,
        sample_hz: float = 3.0,
        prealigned_sensors_dir: Optional[str] = None,
    ) -> None:
        """Evaluate the Two-Stage YOLO model on the test set.

        DTE Phase: Validate.
        PNG Layer: Release & Validation -> DT Validation Comparator.

        Parameters
        ----------
        model_dir : str or Path
            Directory with trained model artefacts.
        det_cache_dir : str or Path
            YOLOv8 detection feature cache directory.
        eaf_parsed_dir : str or Path
            Parsed EAF JSON files (ground-truth labels).
        outdir : str or Path
            Directory for evaluation results.
        sample_hz : float
            Sensor frequency (default 3.0).
        prealigned_sensors_dir : str, optional
            Prealigned sensor ``.npy`` directory.
        """
        from twimo.strategies_eaf.two_stage_yolo import cmd_evaluate
        Path(outdir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            manifest               = Path(self.manifest),
            model_dir              = Path(model_dir),
            eaf_parsed_dir         = Path(eaf_parsed_dir),
            det_cache_dir          = Path(det_cache_dir),
            prealigned_sensors_dir = Path(prealigned_sensors_dir) if prealigned_sensors_dir else None,
            outdir                 = Path(outdir),
            sample_hz              = float(sample_hz),
        )
        cmd_evaluate(args)

    # ==================================================================
    # SECTION: Two-Stage YOLO Improved Pipeline (Strategy Selection)
    # ==================================================================

    def two_stage_yolo_improved_train(
        self,
        eaf_parsed_dir: str | Path,
        prealigned_sensors_dir: str | Path,
        vocab_dir: str | Path,
        outdir: str | Path,
        *,
        det_cache_dir: Optional[str] = None,
        sample_hz: float = 3.0,
        window_sec: float = 5.0,
        epochs: int = 40,
        lr: float = 1e-4,
        batch_size: int = 32,
        stage1_threshold: float = 0.30,
        strategies: Optional[List[str]] = None,
    ) -> None:
        """Train the Improved Two-Stage YOLO model with strategy selection.

        Supports multiple detection strategies (sensor-only, YOLO, combined)
        and enriches ClassifyNet with YOLOv8 detection features when a
        ``det_cache_dir`` is provided.

        DTE Phase: Build.
        PNG Layer: Digital Twin -> Driver Behaviour DT.
        SupervisionMode: EAF_EXPERT or YOLO_DETECTION depending on det_cache.
        DTE Objects: drivingBehaviour.Goal, Stimulus, Cause, AttentionCue.

        Parameters
        ----------
        eaf_parsed_dir : str or Path
            Parsed EAF JSON files (expert supervision).
        prealigned_sensors_dir : str or Path
            Prealigned sensor ``.npy`` directory.
        vocab_dir : str or Path
            Directory with ``vocab_goal.json``, ``vocab_stimuli.json``, etc.
        outdir : str or Path
            Directory for trained model artefacts.
        det_cache_dir : str, optional
            YOLOv8 detection feature cache (enables Supervision C enrichment).
        sample_hz : float
            Sensor frequency (default 3.0).
        window_sec : float
            Input window in seconds (default 5.0).
        epochs : int
            Training epochs (default 40).
        lr : float
            Learning rate (default 1e-4).
        batch_size : int
            Mini-batch size (default 32).
        stage1_threshold : float
            Stage 1 confidence threshold for event detection (default 0.30).
        strategies : list of str, optional
            List of strategy names to enable.  Default: all strategies.
        """
        from twimo.strategies_eaf.two_stage_yolo_improved import cmd_train
        Path(outdir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            manifest               = Path(self.manifest),
            eaf_parsed_dir         = Path(eaf_parsed_dir),
            det_cache_dir          = Path(det_cache_dir) if det_cache_dir else None,
            prealigned_sensors_dir = Path(prealigned_sensors_dir),
            vocab_dir              = Path(vocab_dir),
            outdir                 = Path(outdir),
            strategies             = strategies or [],
            stage1_threshold       = float(stage1_threshold),
            sample_hz              = float(sample_hz),
            window_sec             = float(window_sec),
            epochs                 = int(epochs),
            lr                     = float(lr),
            batch_size             = int(batch_size),
        )
        cmd_train(args)

    def two_stage_yolo_improved_evaluate(
        self,
        model_dir: str | Path,
        eaf_parsed_dir: str | Path,
        prealigned_sensors_dir: str | Path,
        vocab_dir: str | Path,
        outdir: str | Path,
        *,
        det_cache_dir: Optional[str] = None,
        sample_hz: float = 3.0,
    ) -> None:
        """Evaluate the Improved Two-Stage YOLO model on the test set.

        DTE Phase: Validate.
        PNG Layer: Release & Validation -> DT Validation Comparator.

        Parameters
        ----------
        model_dir : str or Path
            Directory with trained model artefacts.
        eaf_parsed_dir : str or Path
            Parsed EAF JSON files (ground-truth labels for evaluation).
        prealigned_sensors_dir : str or Path
            Prealigned sensor ``.npy`` directory.
        vocab_dir : str or Path
            Directory with vocab JSON files.
        outdir : str or Path
            Directory for evaluation results (metrics JSON, confusion matrices).
        det_cache_dir : str, optional
            YOLOv8 detection feature cache.
        sample_hz : float
            Sensor frequency (default 3.0).
        """
        from twimo.strategies_eaf.two_stage_yolo_improved import cmd_evaluate
        Path(outdir).mkdir(parents=True, exist_ok=True)
        args = argparse.Namespace(
            manifest               = Path(self.manifest),
            model_dir              = Path(model_dir),
            eaf_parsed_dir         = Path(eaf_parsed_dir),
            det_cache_dir          = Path(det_cache_dir) if det_cache_dir else None,
            prealigned_sensors_dir = Path(prealigned_sensors_dir),
            vocab_dir              = Path(vocab_dir),
            outdir                 = Path(outdir),
            sample_hz              = float(sample_hz),
        )
        cmd_evaluate(args)

    # ==================================================================
    # SECTION: Digital Twin — Production Workflow & Physical Consistency
    # ==================================================================

    def simulate_dt_production(
        self,
        modeldir: str | Path,
        outdir: str | Path,
        *,
        sample_hz: float = 3.0,
        max_sessions: Optional[int] = None,
    ) -> None:
        """Production Workflow — Autonomous DT for ML Testing.

        Replaces ground-truth sensor signals with ML-predicted counterparts,
        then runs the optimised DT simulation.  This validates whether ML
        predictions are physically consistent: a well-calibrated model should
        yield DT RMSE close to the real-sensor baseline.

        Pipeline:
            1. ``generate_ml_predictions`` — synthesise sensor CSVs from
               the trained maneuver model (``modeldir``).
            2. ``simulate_dt_optimized`` — run the calibrated DT on the
               ML-predicted sensor manifest.

        DTE Phase: Validate.
        DTE Object: digitalTwin.Run (purpose='ml_testing').
        PNG Layer: Release & Validation -> DT Validation Comparator.

        Parameters
        ----------
        modeldir : str or Path
            Trained maneuver predictor directory (any model supported by
            ``generate_ml_predictions``).
        outdir : str or Path
            Root output directory.  Sub-dirs ``ml_sensors/`` and ``dt_ml/``
            are created automatically.
        sample_hz : float
            Simulation frequency in Hz (default 3.0).
        max_sessions : int, optional
            Cap number of sessions for quick testing.

        Equivalent CLI commands
        -----------------------
        .. code-block:: bash

            python twimo/workflows/generate_ml_predictions.py \\
                --model-dir <modeldir> \\
                --manifest <manifest> \\
                --output-dir <outdir>/ml_sensors

            python -m twimo.cli simulate-dt-optimized \\
                --manifest <outdir>/ml_sensors/../manifest_ml_predictions.jsonl \\
                --outdir <outdir>/dt_ml
        """
        from twimo.workflows.generate_ml_predictions import main as _gen_main

        outdir = Path(outdir)
        ml_sensors_dir = outdir / "ml_sensors"
        ml_sensors_dir.mkdir(parents=True, exist_ok=True)

        # Step 1 — generate ML-predicted sensor CSVs
        print("[Production] Step 1: Generating ML-predicted sensor CSVs...")
        argv = [
            "--model-dir",   str(modeldir),
            "--manifest",    str(self.manifest),
            "--output-dir",  str(ml_sensors_dir),
            "--sample-hz",   str(sample_hz),
        ]
        if max_sessions is not None:
            argv += ["--max-sessions", str(max_sessions)]
        self._call_main_with_argv(_gen_main, argv)

        # Step 2 — run optimised DT on ML-predicted manifest
        ml_manifest = ml_sensors_dir.parent / "manifest_ml_predictions.jsonl"
        if not ml_manifest.exists():
            print(f"  [WARN] ML manifest not found: {ml_manifest}")
            print("         Skipping DT simulation step.")
            return

        print("[Production] Step 2: Simulating DT on ML-predicted sensors...")
        # Temporarily switch manifest to the ML predictions one
        original_manifest = self.manifest
        self.manifest = str(ml_manifest)
        try:
            self.simulate_dt_optimized(
                outdir=outdir / "dt_ml",
                sample_hz=sample_hz,
                max_sessions=max_sessions,
            )
        finally:
            self.manifest = original_manifest

    def validate_physical_consistency_v1(
        self,
        real_dt_outdir: str | Path,
        ml_dt_outdir: Optional[str | Path] = None,
    ) -> None:
        """ML Physical Consistency Validation — Approach 1 (Metric Comparison).

        Loads pre-computed DT aggregated metrics from two runs and computes
        the ML-to-real RMSE ratio.  A ratio close to 1.0 indicates that ML
        predictions are physically consistent with ground-truth sensor behaviour.

        This method is read-only: it does NOT run any simulation; it compares
        existing ``dt_aggregated_metrics.json`` files.

        DTE Phase: Validate.
        PNG Layer: Release & Validation -> DT Validation Comparator.

        Parameters
        ----------
        real_dt_outdir : str or Path
            Directory containing the real-sensor DT results
            (``dt_aggregated_metrics.json``).
        ml_dt_outdir : str or Path, optional
            Directory containing the ML-prediction DT results.
            If omitted, only the real-sensor metrics are displayed.

        Usage example
        -------------
        >>> runner.validate_physical_consistency_v1(
        ...     real_dt_outdir="./artifacts/dt_optimized",
        ...     ml_dt_outdir="./artifacts/dt_production/dt_ml",
        ... )
        """
        import json

        def _load_metrics(outdir: Path) -> Optional[dict]:
            for fname in ("dt_optimized_aggregated_metrics.json",
                          "dt_aggregated_metrics.json"):
                p = outdir / fname
                if p.exists():
                    with open(p) as f:
                        return json.load(f)
            return None

        real_dir = Path(real_dt_outdir)
        real_m   = _load_metrics(real_dir)

        print("\n=== ML Physical Consistency Validation (Approach 1) ===")
        if real_m is None:
            print(f"  [ERROR] No aggregated metrics found in: {real_dir}")
            return

        rmse_real = real_m.get("rmse_xy_m_mean") or real_m.get("rmse_mean")
        print(f"  Real-sensor DT   RMSE (mean): {rmse_real:.2f} m" if rmse_real else
              f"  Real-sensor DT metrics: {real_m}")

        if ml_dt_outdir is not None:
            ml_dir = Path(ml_dt_outdir)
            ml_m   = _load_metrics(ml_dir)
            if ml_m is None:
                print(f"  [WARN] No ML DT metrics found in: {ml_dir}")
                print("         Run simulate_dt_production() first.")
            else:
                rmse_ml = ml_m.get("rmse_xy_m_mean") or ml_m.get("rmse_mean")
                print(f"  ML-prediction DT RMSE (mean): {rmse_ml:.2f} m" if rmse_ml else
                      f"  ML-prediction DT metrics: {ml_m}")
                if rmse_real and rmse_ml:
                    ratio = rmse_ml / rmse_real
                    verdict = ("CONSISTENT" if ratio < 2.0 else
                               "MARGINAL"   if ratio < 5.0 else
                               "INCONSISTENT")
                    print(f"\n  RMSE ratio (ML / Real): {ratio:.2f}  →  {verdict}")
                    print(f"    ratio < 2.0  → physically consistent")
                    print(f"    ratio 2-5    → marginal (model may be underfitting)")
                    print(f"    ratio > 5.0  → physically inconsistent (retrain)")
        print()

    def validate_physical_consistency_v2(
        self,
        modeldir: str | Path,
        outdir: str | Path,
        *,
        control_model: str = "xgboost",
        sample_hz: float = 3.0,
        max_sessions: Optional[int] = None,
    ) -> None:
        """ML Physical Consistency Validation — Approach 2 (Control Regression).

        Full closed-loop validation:
            1. Train a maneuver → control regressor (steer, velocity)
               using ``train_control_regression.py``.
            2. Generate control predictions for each session using
               ``generate_control_predictions.py``.
            3. Run the optimised DT simulation with regressed controls.
            4. Compare metrics vs real-sensor baseline.

        This approach tests whether the learned control policy is physically
        realisable under the kinematic bicycle model.

        DTE Phase: Validate.
        DTE Object: ControlService (regressor_type='ml_regressor').
        PNG Layer: Release & Validation -> DT Validation Comparator.

        Parameters
        ----------
        modeldir : str or Path
            Trained maneuver predictor (used to split train/test manifests).
        outdir : str or Path
            Root output directory.  Sub-dirs are created automatically.
        control_model : str
            Regression model for maneuver→control mapping
            (``xgboost`` | ``lightgbm`` | ``random_forest`` | ``transformer``
            | ``gru`` | ``lstm`` | ``tcn`` | ``mlp_mean``).
        sample_hz : float
            Simulation frequency in Hz (default 3.0).
        max_sessions : int, optional
            Cap number of sessions for quick testing.

        Equivalent CLI commands
        -----------------------
        .. code-block:: bash

            python twimo/workflows/train_control_regression.py \\
                --manifest <manifest> \\
                --test-manifest <manifest> \\
                --outdir <outdir>/control_model \\
                --model <control_model>

            python twimo/workflows/generate_control_predictions.py \\
                --manifest <manifest> \\
                --model-dir <outdir>/control_model \\
                --outdir <outdir>/control_sensors

            python -m twimo.cli simulate-dt-optimized \\
                --manifest <outdir>/control_manifest.jsonl \\
                --outdir <outdir>/dt_control
        """
        from twimo.workflows.train_control_regression import main as _ctrl_train
        from twimo.workflows.generate_control_predictions import main as _ctrl_gen

        outdir = Path(outdir)
        ctrl_model_dir  = outdir / "control_model"
        ctrl_sensor_dir = outdir / "control_sensors"
        ctrl_model_dir.mkdir(parents=True, exist_ok=True)
        ctrl_sensor_dir.mkdir(parents=True, exist_ok=True)

        # Step 1 — train maneuver→control regressor
        print(f"[PhysVal-V2] Step 1: Training control regression model ({control_model})...")
        train_argv = [
            "--manifest",      str(self.manifest),
            "--test-manifest", str(self.manifest),
            "--outdir",        str(ctrl_model_dir),
            "--model",         control_model,
            "--sample-hz",     str(sample_hz),
        ]
        if max_sessions is not None:
            train_argv += ["--max-sessions", str(max_sessions)]
        self._call_main_with_argv(_ctrl_train, train_argv)

        # Step 2 — generate control predictions per session
        print("[PhysVal-V2] Step 2: Generating control predictions...")
        gen_argv = [
            "--manifest",  str(self.manifest),
            "--model-dir", str(ctrl_model_dir),
            "--outdir",    str(ctrl_sensor_dir),
            "--sample-hz", str(sample_hz),
        ]
        if max_sessions is not None:
            gen_argv += ["--max-sessions", str(max_sessions)]
        self._call_main_with_argv(_ctrl_gen, gen_argv)

        # Step 3 — simulate DT on control-regressed sensors
        ctrl_manifest = ctrl_sensor_dir.parent / "manifest_control_predictions.jsonl"
        if not ctrl_manifest.exists():
            # fallback: look inside ctrl_sensor_dir
            ctrl_manifest = ctrl_sensor_dir / "manifest_control_predictions.jsonl"

        if ctrl_manifest.exists():
            print("[PhysVal-V2] Step 3: Simulating DT on control-regressed sensors...")
            original_manifest = self.manifest
            self.manifest = str(ctrl_manifest)
            try:
                self.simulate_dt_optimized(
                    outdir=outdir / "dt_control",
                    sample_hz=sample_hz,
                    max_sessions=max_sessions,
                )
            finally:
                self.manifest = original_manifest
        else:
            print(f"  [WARN] Control manifest not found; skipping DT step.")
            print(f"         Expected: {ctrl_manifest}")

    # ==================================================================
    # SECTION: Video Annotation
    # ==================================================================

    def annotate_video(
        self,
        modeldir: str | Path,
        outdir: str | Path,
        *,
        session: Optional[str] = None,
        sample_hz: float = 3.0,
        horizons: Optional[List[float]] = None,
        max_seconds: Optional[int] = None,
        prealigned_sensors_dir: Optional[str] = None,
    ) -> None:
        """Annotate driving video(s) with proxy/maneuver prediction overlays.

        Overlays per-frame predicted maneuver class and probability bars
        (at multiple horizons), rule-based explanations, and live sensor
        readouts (speed, steer, brake) on the session video.

        Supervision Path: A (PROXY_HEURISTIC) — uses ``train-maneuver`` model.

        DTE Phase: Evolve.
        PNG Layer: Release & Validation -> External Consumer (Dashboard/API).
        DTE Object: explainability.Explanation (visual form).

        Parameters
        ----------
        modeldir : str or Path
            Trained model directory (any model from ``train-maneuver``).
        outdir : str or Path
            Directory where annotated video files are written.
        session : str, optional
            Specific session ID to annotate.  Default: all sessions in manifest.
        sample_hz : float
            Model inference frequency (default 3.0).
        horizons : list of float, optional
            Prediction horizons to display (default [1.0, 3.0, 5.0]).
        max_seconds : int, optional
            Limit output video length (useful for quick tests).
        prealigned_sensors_dir : str, optional
            Prealigned sensor directory (if applicable).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/plots/annotate_video.py \\
                --manifest <manifest> \\
                --modeldir <modeldir> \\
                --outdir <outdir> \\
                [--session <session>]
        """
        from twimo.plots.annotate_video import main as _main
        Path(outdir).mkdir(parents=True, exist_ok=True)
        _horizons = horizons or [1.0, 3.0, 5.0]
        argv = [
            "--manifest",  str(self.manifest),
            "--modeldir",  str(modeldir),
            "--outdir",    str(outdir),
            "--sample-hz", str(sample_hz),
            "--horizons",  *[str(h) for h in _horizons],
        ]
        if session:
            argv += ["--session", session]
        if max_seconds is not None:
            argv += ["--max-seconds", str(max_seconds)]
        if prealigned_sensors_dir:
            argv += ["--prealigned-sensors-dir", str(prealigned_sensors_dir)]
        self._call_main_with_argv(_main, argv)

    def annotate_video_eaf(
        self,
        data_dir: str | Path,
        vocab_dir: str | Path,
        outdir: str | Path,
        *,
        session: Optional[str] = None,
        sample_hz: float = 3.0,
        horizons: Optional[List[float]] = None,
        max_seconds: Optional[int] = None,
        eaf_parsed_dir: Optional[str] = None,
        prealigned_sensors_dir: Optional[str] = None,
    ) -> None:
        """Annotate driving video(s) with EAF two-stage prediction overlays.

        Overlays EAF-supervised Goal/Stimuli/Cause/Attention class predictions
        alongside sensor readouts. Does not require YOLO detections.

        Supervision Path: B (EAF_EXPERT).

        DTE Phase: Evolve.
        PNG Layer: Release & Validation -> External Consumer.
        DTE Objects: drivingBehaviour.Goal, Stimulus, Cause, AttentionCue.

        Parameters
        ----------
        data_dir : str or Path
            Two-stage model data / output directory (``eaf_two_stage/``).
        vocab_dir : str or Path
            Directory with ``vocab_goal.json`` etc.
        outdir : str or Path
            Directory where annotated video files are written.
        session : str, optional
            Specific session ID to annotate.
        eaf_parsed_dir : str, optional
            Parsed EAF JSON directory (for ground-truth overlay).
        prealigned_sensors_dir : str, optional
            Prealigned sensor directory.

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/plots/annotate_video_eaf.py \\
                --manifest <manifest> \\
                --data-dir <data_dir> \\
                --vocab-dir <vocab_dir> \\
                --outdir <outdir>
        """
        from twimo.plots.annotate_video_eaf import main as _main
        Path(outdir).mkdir(parents=True, exist_ok=True)
        _horizons = horizons or [1.0, 3.0, 5.0]
        argv = [
            "--manifest",  str(self.manifest),
            "--data-dir",  str(data_dir),
            "--vocab-dir", str(vocab_dir),
            "--outdir",    str(outdir),
            "--sample-hz", str(sample_hz),
            "--horizons",  *[str(h) for h in _horizons],
        ]
        if session:
            argv += ["--session", session]
        if max_seconds is not None:
            argv += ["--max-seconds", str(max_seconds)]
        if eaf_parsed_dir:
            argv += ["--eaf-parsed-dir", str(eaf_parsed_dir)]
        if prealigned_sensors_dir:
            argv += ["--prealigned-sensors-dir", str(prealigned_sensors_dir)]
        self._call_main_with_argv(_main, argv)

    def annotate_video_eaf_yolo(
        self,
        data_dir: str | Path,
        vocab_dir: str | Path,
        outdir: str | Path,
        *,
        session: Optional[str] = None,
        sample_hz: float = 3.0,
        horizons: Optional[List[float]] = None,
        max_seconds: Optional[int] = None,
        eaf_parsed_dir: Optional[str] = None,
        prealigned_sensors_dir: Optional[str] = None,
        det_cache_dir: Optional[str] = None,
        yolo_model: Optional[str] = None,
        yolo_conf: float = 0.30,
    ) -> None:
        """Annotate driving video(s) with EAF + YOLOv8 detection overlays.

        Combines EAF-supervised Goal/Stimuli predictions with live YOLOv8
        object detection bounding boxes and classification overlays.

        Supervision Paths: B (EAF_EXPERT) + C (YOLO_DETECTION).

        DTE Phase: Evolve.
        PNG Layer: Release & Validation -> External Consumer.
        DTE Objects: drivingBehaviour.Goal, Stimulus, Cause, AttentionCue.

        Parameters
        ----------
        data_dir : str or Path
            Two-stage YOLO model data directory.
        vocab_dir : str or Path
            Directory with vocab JSON files.
        outdir : str or Path
            Directory for annotated output videos.
        session : str, optional
            Specific session ID to annotate.
        eaf_parsed_dir : str, optional
            Parsed EAF JSON directory for ground-truth overlays.
        prealigned_sensors_dir : str, optional
            Prealigned sensor directory.
        det_cache_dir : str, optional
            YOLOv8 detection feature cache directory.
        yolo_model : str, optional
            YOLOv8 weights (e.g. ``yolov8n.pt``).  Default: auto-detect.
        yolo_conf : float
            YOLOv8 confidence threshold (default 0.30).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/plots/annotate_video_eaf_yolo.py \\
                --manifest <manifest> \\
                --data-dir <data_dir> \\
                --vocab-dir <vocab_dir> \\
                --outdir <outdir>
        """
        from twimo.plots.annotate_video_eaf_yolo import main as _main
        Path(outdir).mkdir(parents=True, exist_ok=True)
        _horizons = horizons or [1.0, 3.0, 5.0]
        argv = [
            "--manifest",  str(self.manifest),
            "--data-dir",  str(data_dir),
            "--vocab-dir", str(vocab_dir),
            "--outdir",    str(outdir),
            "--sample-hz", str(sample_hz),
            "--horizons",  *[str(h) for h in _horizons],
            "--yolo-conf", str(yolo_conf),
        ]
        if session:
            argv += ["--session", session]
        if max_seconds is not None:
            argv += ["--max-seconds", str(max_seconds)]
        if eaf_parsed_dir:
            argv += ["--eaf-parsed-dir", str(eaf_parsed_dir)]
        if prealigned_sensors_dir:
            argv += ["--prealigned-sensors-dir", str(prealigned_sensors_dir)]
        if det_cache_dir:
            argv += ["--det-cache-dir", str(det_cache_dir)]
        if yolo_model:
            argv += ["--yolo-model", str(yolo_model)]
        self._call_main_with_argv(_main, argv)

    def annotate_video_eaf_yolo_improved(
        self,
        model_dir: str | Path,
        vocab_dir: str | Path,
        outdir: str | Path,
        *,
        session: Optional[str] = None,
        sample_hz: float = 3.0,
        horizons: Optional[List[float]] = None,
        max_seconds: Optional[int] = None,
        eaf_parsed_dir: Optional[str] = None,
        prealigned_sensors_dir: Optional[str] = None,
        det_cache_dir: Optional[str] = None,
        yolo_model: Optional[str] = None,
        yolo_conf: float = 0.30,
        no_zone_colours: bool = False,
    ) -> None:
        """Annotate driving video(s) using the Improved EAF + YOLOv8 pipeline.

        Uses the improved two-stage model (strategy-selection, richer zone
        colour-coding, and enhanced detection overlays).

        Supervision Paths: B (EAF_EXPERT) + C (YOLO_DETECTION).

        DTE Phase: Evolve.
        PNG Layer: Release & Validation -> External Consumer.
        DTE Objects: drivingBehaviour.Goal, Stimulus, Cause, AttentionCue.

        Parameters
        ----------
        model_dir : str or Path
            Improved two-stage model directory (``eaf_two_stage/`` or similar).
        vocab_dir : str or Path
            Directory with vocab JSON files.
        outdir : str or Path
            Directory for annotated output videos.
        session : str, optional
            Specific session ID to annotate.
        eaf_parsed_dir : str, optional
            Parsed EAF JSON directory.
        prealigned_sensors_dir : str, optional
            Prealigned sensor directory.
        det_cache_dir : str, optional
            YOLOv8 detection feature cache.
        yolo_model : str, optional
            YOLOv8 weights file.  Default: auto-detect.
        yolo_conf : float
            YOLOv8 confidence threshold (default 0.30).
        no_zone_colours : bool
            Disable zone colour-coding in the overlay (default False).

        Equivalent CLI command
        ----------------------
        .. code-block:: bash

            python twimo/plots/annotate_video_eaf_yolo_improved.py \\
                --manifest <manifest> \\
                --model-dir <model_dir> \\
                --vocab-dir <vocab_dir> \\
                --outdir <outdir>
        """
        from twimo.plots.annotate_video_eaf_yolo_improved import main as _main
        Path(outdir).mkdir(parents=True, exist_ok=True)
        _horizons = horizons or [1.0, 3.0, 5.0]
        argv = [
            "--manifest",  str(self.manifest),
            "--model-dir", str(model_dir),
            "--vocab-dir", str(vocab_dir),
            "--outdir",    str(outdir),
            "--sample-hz", str(sample_hz),
            "--horizons",  *[str(h) for h in _horizons],
            "--yolo-conf", str(yolo_conf),
        ]
        if session:
            argv += ["--session", session]
        if max_seconds is not None:
            argv += ["--max-seconds", str(max_seconds)]
        if eaf_parsed_dir:
            argv += ["--eaf-parsed-dir", str(eaf_parsed_dir)]
        if prealigned_sensors_dir:
            argv += ["--prealigned-sensors-dir", str(prealigned_sensors_dir)]
        if det_cache_dir:
            argv += ["--det-cache-dir", str(det_cache_dir)]
        if yolo_model:
            argv += ["--yolo-model", str(yolo_model)]
        if no_zone_colours:
            argv += ["--no-zone-colours"]
        self._call_main_with_argv(_main, argv)
