# Utilities

Helper functions used throughout TWIMO.

---

## Key Files

| File | What It Does |
|------|-------------|
| `io.py` | File I/O helpers (JSON, pickle, etc.) |
| `logging.py` | Logging utilities |
| `time.py` | Time conversion helpers |
| `profiling.py` | Performance profiling and carbon footprint tracking |

---

## File I/O (`io.py`)

### Save/Load JSON

```python
from twimo.utils.io import save_json, load_json

# Save
data = {'accuracy': 0.95, 'f1': 0.88}
save_json(data, 'results.json')

# Load
data = load_json('results.json')
```

### Save/Load Pickle

```python
from twimo.utils.io import save_pickle, load_pickle

# Save Python object
model = {'weights': [...], 'config': {...}}
save_pickle(model, 'model.pkl')

# Load
model = load_pickle('model.pkl')
```

---

## Logging (`logging.py`)

### Setup Logger

```python
from twimo.utils.logging import get_logger

logger = get_logger('my_module')
logger.info("Training started")
logger.warning("Low data quality")
logger.error("Failed to load file")
```

**Output:**
```
[INFO] 2024-01-15 10:30:15 - my_module - Training started
[WARNING] 2024-01-15 10:30:16 - my_module - Low data quality
[ERROR] 2024-01-15 10:30:17 - my_module - Failed to load file
```

---

## Time Conversion (`time.py`)

### Unix Timestamp to Datetime

```python
from twimo.utils.time import timestamp_to_datetime

dt = timestamp_to_datetime(1673780400)
# Returns: datetime(2023, 1, 15, 10, 0, 0)
```

### Seconds to HH:MM:SS

```python
from twimo.utils.time import seconds_to_hms

hms = seconds_to_hms(3665)
# Returns: "01:01:05"
```

---

## Performance Profiling (`profiling.py`)

### What Is Profiling?

Measures execution time and memory usage of code.

### Time Profiling

```python
from twimo.utils.profiling import Timer

with Timer("Data loading"):
    data = load_large_dataset()

# Output:
# [Timer] Data loading: 12.35s
```

### Memory Profiling

```python
from twimo.utils.profiling import profile_memory

@profile_memory
def process_data(data):
    result = heavy_computation(data)
    return result

result = process_data(data)
# Output:
# [Memory] process_data: Peak 2.3 GB, Delta +450 MB
```

### Carbon Footprint Tracking

```python
from twimo.utils.profiling import TrainingProfiler

with TrainingProfiler(model_name="my_model", output_dir=Path("./artifacts/my_run")):
    train_model()

# Output:
# [CodeCarbon] Energy tracking enabled for my_model (TDP-based estimation)
# [Profiling] Metrics saved to: artifacts/my_run/profiling_metrics.json
#   Training time: 142.30s
#   Energy consumed: 1.8375 Wh
#   Carbon emissions: 0.6064 g CO2
```

**Why track carbon?**
- Training ML models consumes energy
- Supports reproducibility and sustainability reporting in academic papers
- Enables fair comparison of model efficiency across experiments

---

### How CodeCarbon Estimates CO₂ Emissions

CodeCarbon computes carbon emissions in three steps.

#### Step 1 — Measure Energy Consumption (kWh)

**CPU energy**
- **Linux**: reads directly from Intel RAPL hardware counters (`/sys/class/powercap/`) — real measurement.
- **Windows with Intel Power Gadget**: reads Intel hardware counters — real measurement.
- **TDP fallback** (default on most systems): uses the processor's Thermal Design Power (e.g., i9-11950H = 45 W) multiplied by elapsed time. This is a conservative overestimate, as it assumes the CPU runs at its maximum rated load for the entire duration.

**GPU energy**
- Uses `pynvml` (NVIDIA Management Library) to sample real-time power draw from the GPU. Only available when an NVIDIA GPU is present.

**RAM energy**
- Fixed empirical estimate: **0.375 W per GB** of installed RAM, based on published studies on DRAM power consumption.

#### Step 2 — Compute Total Energy

```
Energy (kWh) = (P_cpu + P_gpu + P_ram) × execution_time_s / 3 600 000
```

Example (no NVIDIA GPU, TDP fallback):
```
Energy ≈ (45 W + 0 W + ~6 W) × time_s / 3 600 000
```

#### Step 3 — Convert to CO₂ (kg)

```
CO₂ (kg) = Energy (kWh) × Carbon Intensity (kg CO₂/kWh)
```

The carbon intensity factor reflects the energy mix of the local power grid. CodeCarbon uses a geolocation API to determine the country/region automatically and applies the corresponding value:

| Country / Region | Carbon Intensity (kg CO₂/kWh) |
|-----------------|-------------------------------|
| France | ~0.06 (high nuclear share) |
| Italy | ~0.33 |
| Germany | ~0.35 |
| USA (average) | ~0.42 |
| Poland | ~0.74 (coal-heavy) |

#### Important Note for Papers

On Windows without Intel Power Gadget, CodeCarbon falls back to TDP-based estimation. This is a standard approach in the literature when hardware counters are unavailable. For academic publications, the recommended disclosure is:

> *"Energy consumption and CO₂ emissions were estimated using CodeCarbon (Courty et al., 2023) with TDP-based CPU power estimation."*

---

## Profiling Best Practices

### Profile During Development

```python
# Before optimization
with Timer("Slow operation"):
    result = slow_function()
# Output: 45.2s

# After optimization
with Timer("Fast operation"):
    result = fast_function()
# Output: 2.1s
```

### Identify Bottlenecks

```python
with Timer("Load data"):
    data = load_data()  # 12.3s

with Timer("Preprocess"):
    data = preprocess(data)  # 0.5s

with Timer("Train model"):
    model = train(data)  # 125.8s  ← Bottleneck!

# Focus optimization on training
```

### Track Memory Leaks

```python
@profile_memory
def potential_leak():
    cache = []
    for i in range(1000):
        cache.append(large_object())  # Memory keeps growing!
    return cache

# Output shows increasing memory usage
```

---

## Advanced: Full Profiling Report

```bash
python -m twimo.utils.profiling --module my_script.py
```

**Generates:**
- `profiling_report.txt`: Detailed timing breakdown
- `memory_usage.png`: Memory usage over time
- `carbon_footprint.json`: CO2 and energy metrics

**Example report:**
```
=== Profiling Report ===
Total execution time: 185.3s

Top 5 slowest operations:
1. train_model()         125.8s  (67.9%)
2. load_data()            12.3s  ( 6.6%)
3. extract_features()      8.5s  ( 4.6%)
4. preprocess_data()       2.1s  ( 1.1%)
5. save_results()          0.8s  ( 0.4%)

Memory:
- Peak usage: 4.2 GB
- Average: 2.8 GB

Carbon footprint:
- CO2: 0.08 kg
- Energy: 0.18 kWh
```

---

## `emissions.csv` Field Reference

Each run appended to `emissions.csv` by CodeCarbon. The table below lists the numeric and measurement fields with their units; string/metadata fields (project name, OS, CPU model, etc.) are omitted.

| Field | Unit | Description |
|-------|------|-------------|
| `duration` | s | Elapsed wall-clock time of the tracked code block |
| `emissions` | kg CO₂eq | Total estimated carbon emissions |
| `emissions_rate` | kg CO₂eq / s | Average emission rate during the run |
| `cpu_power` | W | CPU power draw (TDP value or hardware-measured) |
| `gpu_power` | W | GPU power draw (NVML real-time, 0 if no NVIDIA GPU) |
| `ram_power` | W | RAM power draw (0.375 W/GB × installed GB) |
| `cpu_energy` | kWh | Energy consumed by the CPU over the run |
| `gpu_energy` | kWh | Energy consumed by the GPU over the run |
| `ram_energy` | kWh | Energy consumed by RAM over the run |
| `energy_consumed` | kWh | Total energy (cpu + gpu + ram) |
| `water_consumed` | L | Estimated water consumption for cooling (derived from WUE) |
| `cpu_count` | # (integer) | Number of logical CPU cores |
| `gpu_count` | # (integer) | Number of GPUs detected |
| `longitude` | ° | Longitude used for carbon intensity lookup |
| `latitude` | ° | Latitude used for carbon intensity lookup |
| `ram_total_size` | GB | Total installed RAM |
| `cpu_utilization_percent` | % | Average CPU utilisation during the run |
| `gpu_utilization_percent` | % | Average GPU utilisation during the run (0 if no GPU) |
| `ram_utilization_percent` | % | Average RAM utilisation during the run |
| `ram_used_gb` | GB | Average RAM in use during the run |
| `pue` | dimensionless | Power Usage Effectiveness (datacenter overhead ratio; 1.0 for local hardware) |
| `wue` | L / kWh | Water Usage Effectiveness (water per unit of energy; used to derive `water_consumed`) |

> **Note:** `emissions` and all `*_energy` fields are the primary values of interest for reporting. `pue = 1.0` and `wue = 0.0` are typical defaults when running on a local workstation rather than a cloud datacenter.

---

## Related Files

- All modules use these utilities
- Main CLI: `twimo/cli.py`
