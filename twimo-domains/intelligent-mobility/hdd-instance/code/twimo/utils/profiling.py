from __future__ import annotations

import time
import json
from pathlib import Path
from typing import Dict, Optional, Any
from contextlib import contextmanager
from dataclasses import dataclass, asdict


@dataclass
class ProfilingMetrics:
    """Metrics collected during model training and inference."""

    # Training metrics
    training_time_seconds: Optional[float] = None
    training_start_timestamp: Optional[str] = None
    training_end_timestamp: Optional[str] = None

    # Inference metrics
    inference_time_seconds: Optional[float] = None
    inference_samples: Optional[int] = None
    inference_throughput_samples_per_sec: Optional[float] = None

    # Energy metrics (CodeCarbon)
    energy_consumed_kwh: Optional[float] = None
    carbon_emissions_kg: Optional[float] = None
    carbon_emissions_rate_kg_per_kwh: Optional[float] = None
    cpu_energy_kwh: Optional[float] = None
    gpu_energy_kwh: Optional[float] = None
    ram_energy_kwh: Optional[float] = None

    # System info
    model_name: Optional[str] = None
    device: Optional[str] = None
    gpu_name: Optional[str] = None
    cpu_count: Optional[int] = None

    # Phase-level breakdown (Level 2 & 3): {phase_name: {time_s, n_samples, throughput, energy_kwh?, ...}}
    phases: Optional[Dict[str, Any]] = None

    def to_dict(self) -> Dict[str, Any]:
        """Convert to dictionary, filtering None values."""
        return {k: v for k, v in asdict(self).items() if v is not None}


class TrainingProfiler:
    """Context manager for profiling model training."""

    def __init__(self, model_name: str, output_dir: Path, use_codecarbon: bool = True):
        self.model_name = model_name
        self.output_dir = Path(output_dir)
        self.use_codecarbon = use_codecarbon
        self.metrics = ProfilingMetrics(model_name=model_name)
        self.start_time = None
        self.tracker = None
        # Phase tracking state (Level 1/2/3)
        self._phase_start: Dict[str, float] = {}
        self._phase_samples: Dict[str, int] = {}

    def __enter__(self):
        """Start profiling."""
        from datetime import datetime

        self.start_time = time.time()
        self.metrics.training_start_timestamp = datetime.now().isoformat()

        # Collect system info
        self._collect_system_info()

        # Start CodeCarbon tracker
        if self.use_codecarbon:
            try:
                import logging
                # Suppress CodeCarbon warnings (CPU detection, Power Gadget, etc.)
                logging.getLogger("codecarbon").setLevel(logging.ERROR)

                from codecarbon import EmissionsTracker

                self.tracker = EmissionsTracker(
                    project_name=f"TWIMO_{self.model_name}",
                    output_dir=str(self.output_dir),
                    output_file="emissions.csv",
                    log_level="error",
                    save_to_file=True,
                    on_csv_write="update",
                )
                self.tracker.start()
                print(f"[CodeCarbon] Energy tracking enabled for {self.model_name} (TDP-based estimation)")
            except ImportError:
                print("[Warning] CodeCarbon not installed. Skipping energy profiling.")
                print("          Install with: pip install codecarbon")
                self.use_codecarbon = False
            except Exception as e:
                print(f"[Warning] CodeCarbon initialization failed: {e}")
                self.use_codecarbon = False

        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        """Stop profiling and save metrics."""
        from datetime import datetime

        # Calculate training time
        if self.start_time:
            self.metrics.training_time_seconds = time.time() - self.start_time
            self.metrics.training_end_timestamp = datetime.now().isoformat()

        # Stop CodeCarbon tracker
        if self.use_codecarbon and self.tracker:
            try:
                emissions = self.tracker.stop()

                if emissions is not None:
                    self.metrics.energy_consumed_kwh = emissions

                    # Try to read detailed metrics from CSV
                    self._extract_codecarbon_metrics()

            except Exception as e:
                print(f"[Warning] CodeCarbon stop failed: {e}")

        # Save profiling metrics
        self._save_metrics()

        return False  # Don't suppress exceptions

    # ── Phase API (Level 1 / 2 / 3) ──────────────────────────────────────────

    def begin_phase(self, name: str, n_samples: int = 0) -> None:
        """Mark the start of a named execution phase.

        Starts a sub-task inside the CodeCarbon tracker (if available and
        running) so that per-phase energy is captured alongside wall-clock time.
        Must be called while the profiler context is active (between __enter__
        and __exit__).
        """
        self._phase_start[name] = time.time()
        self._phase_samples[name] = n_samples
        if self.use_codecarbon and self.tracker:
            try:
                self.tracker.start_task(name)
            except Exception:
                pass  # codecarbon < 2.3 or task API unavailable

    def end_phase(self, name: str) -> Dict[str, Any]:
        """Mark the end of a named phase and record its metrics.

        Returns the phase data dict that was stored in self.metrics.phases[name].
        """
        elapsed = time.time() - self._phase_start.pop(name, time.time())
        n_samples = self._phase_samples.pop(name, 0)

        phase_data: Dict[str, Any] = {
            "time_s": round(elapsed, 4),
            "n_samples": n_samples,
        }
        if n_samples > 0 and elapsed > 0:
            phase_data["throughput_samples_per_sec"] = round(n_samples / elapsed, 2)

        if self.use_codecarbon and self.tracker:
            try:
                task = self.tracker.stop_task()
                if task is not None:
                    phase_data["energy_kwh"] = getattr(task, "energy_consumed", None)
                    phase_data["emissions_kg"] = getattr(task, "emissions", None)
            except Exception:
                pass  # codecarbon < 2.3 or task API unavailable

        if self.metrics.phases is None:
            self.metrics.phases = {}
        self.metrics.phases[name] = phase_data
        return phase_data

    # ─────────────────────────────────────────────────────────────────────────

    def _collect_system_info(self):
        """Collect system information."""
        import platform
        import multiprocessing

        # CPU info
        self.metrics.cpu_count = multiprocessing.cpu_count()

        # Try to detect GPU
        try:
            import torch
            if torch.cuda.is_available():
                self.metrics.device = "cuda"
                self.metrics.gpu_name = torch.cuda.get_device_name(0)
            else:
                self.metrics.device = "cpu"
        except ImportError:
            self.metrics.device = "cpu"

    def _extract_codecarbon_metrics(self):
        """Extract detailed metrics from CodeCarbon CSV."""
        import csv

        csv_path = self.output_dir / "emissions.csv"
        if not csv_path.exists():
            return

        try:
            with open(csv_path, 'r') as f:
                reader = csv.DictReader(f)
                rows = list(reader)

                if rows:
                    # Get the last row (most recent)
                    last_row = rows[-1]

                    # Extract metrics
                    self.metrics.energy_consumed_kwh = float(last_row.get('energy_consumed', 0))
                    self.metrics.carbon_emissions_kg = float(last_row.get('emissions', 0))
                    self.metrics.carbon_emissions_rate_kg_per_kwh = float(last_row.get('emissions_rate', 0))
                    self.metrics.cpu_energy_kwh = float(last_row.get('cpu_energy', 0))
                    self.metrics.gpu_energy_kwh = float(last_row.get('gpu_energy', 0))
                    self.metrics.ram_energy_kwh = float(last_row.get('ram_energy', 0))

        except Exception as e:
            print(f"[Warning] Failed to extract CodeCarbon metrics: {e}")

    def _save_metrics(self):
        """Save profiling metrics to JSON."""
        output_file = self.output_dir / "profiling_metrics.json"

        try:
            with open(output_file, 'w') as f:
                json.dump(self.metrics.to_dict(), f, indent=2)

            print(f"\n[Profiling] Metrics saved to: {output_file}")
            print(f"  Total time: {self.metrics.training_time_seconds:.2f}s")

            if self.metrics.energy_consumed_kwh is not None:
                print(f"  Total energy: {self.metrics.energy_consumed_kwh * 1000:.4f} Wh")
                if self.metrics.carbon_emissions_kg is not None:
                    print(f"  Carbon emissions: {self.metrics.carbon_emissions_kg * 1000:.4f} g CO2")

            # Print per-phase breakdown if available
            if self.metrics.phases:
                print("  Phase breakdown:")
                for pname, pdata in self.metrics.phases.items():
                    t_s = pdata.get("time_s", 0.0)
                    n = pdata.get("n_samples", 0)
                    tput = pdata.get("throughput_samples_per_sec")
                    energy = pdata.get("energy_kwh")
                    line = f"    {pname:<20} {t_s:>8.3f}s"
                    if n:
                        line += f"  n={n}"
                    if tput:
                        line += f"  ({tput:.0f} samp/s)"
                    if energy is not None:
                        line += f"  {energy * 1000:.4f} Wh"
                    print(line)

        except Exception as e:
            print(f"[Warning] Failed to save profiling metrics: {e}")


@contextmanager
def profile_inference(n_samples: int):
    """Context manager for profiling inference time."""
    start_time = time.time()

    yield

    elapsed = time.time() - start_time
    throughput = n_samples / elapsed if elapsed > 0 else 0

    return {
        'inference_time_seconds': elapsed,
        'inference_samples': n_samples,
        'inference_throughput_samples_per_sec': throughput,
    }


def measure_inference_time(X, predict_fn, cfg) -> Dict[str, float]:
    """Measure inference time and throughput.

    Args:
        X: Input data (numpy array)
        predict_fn: Prediction function that takes (X, cfg)
        cfg: Model configuration

    Returns:
        Dictionary with inference metrics
    """
    import time

    n_samples = X.shape[0]
    start_time = time.time()

    # Run inference
    _ = predict_fn(X, cfg)

    elapsed = time.time() - start_time
    throughput = n_samples / elapsed if elapsed > 0 else 0

    return {
        'inference_time_seconds': elapsed,
        'inference_samples': n_samples,
        'inference_throughput_samples_per_sec': throughput,
    }


def save_combined_metrics(
    profiling_metrics: ProfilingMetrics,
    test_metrics: Dict,
    output_dir: Path,
):
    """Save combined profiling and test metrics.

    Args:
        profiling_metrics: Profiling metrics from training
        test_metrics: Test accuracy metrics
        output_dir: Output directory
    """
    combined = {
        'test_metrics': test_metrics,
        'profiling': profiling_metrics.to_dict(),
    }

    output_file = output_dir / 'metrics_combined.json'

    try:
        with open(output_file, 'w') as f:
            json.dump(combined, f, indent=2)
        print(f"[Metrics] Combined metrics saved to: {output_file}")
    except Exception as e:
        print(f"[Warning] Failed to save combined metrics: {e}")
