# Data Loading and Management

This folder handles loading and processing driving session data from the Honda Driving Dataset (HDD).

---

## What Does This Do?

Scans HDD folders, loads CSV sensor files, resamples data to a common timeline, and generates labels for maneuver prediction.

---

## Key Files

| File | What It Does |
|------|-------------|
| `schema.py` | Defines `SessionRecord` dataclass (session metadata) |
| `manifest.py` | Reads/writes session manifest (JSONL format) |
| `scan_hdd.py` | Scans HDD folders and finds all sessions |
| `scan_csv.py` | CSV-only scanner (no video) |
| `csv_session.py` | Loads CSV files, resamples to common timeline |
| `csv_loaders.py` | Reads individual CSV files (vel, steer, brake, etc.) |
| `csv_io.py` | Low-level CSV I/O utilities |
| `prealigned.py` | Loads prealigned `.npy` arrays (faster) |

---

## How to Use

### 1. Scan Dataset and Build Manifest

```bash
python -m twimo.cli scan --root ./example_data --out ./artifacts/manifest.jsonl
```

**What it does:**
- Scans `example_data/` folder
- Finds all session folders with CSV files
- Creates `manifest.jsonl` (one session per line)

**Output:** `artifacts/manifest.jsonl`

---

### 2. Data Loading Modes

#### CSV-Only Mode (Default)

Works with raw HDD session folders:

```
<data_dir>/
  <scenario>/                    # e.g., 2017_02_27_ITS1
    <session_id>/                # e.g., 201702271017
      general/csv/
        vel.csv                  # Velocity
        accel_pedal.csv          # Accelerator
        brake_pedal.csv          # Brake
        steer.csv                # Steering
```

**Labels:** Generated automatically using heuristic rules (see "Heuristic Labels" below).

---

## How Data Loading Works

### Step 1: Scan (`scan_hdd.py`)

```python
from twimo.data.scan_hdd import scan_hdd_directory

sessions = scan_hdd_directory(
    root="./example_data",
    manifest_file="./artifacts/manifest.jsonl"
)
# Returns list of SessionRecord objects
```

### Step 2: Load Session (`csv_session.py`)

```python
from twimo.data.csv_session import load_sensors_from_csv_dir

csv_dir = Path("example_data/2017_02_27_ITS1/201702271017/general/csv")
sensor_frames = load_sensors_from_csv_dir(csv_dir)
# Returns dict: {'vel': DataFrame, 'steer': DataFrame, ...}
```

### Step 3: Resample to Common Timeline

```python
from twimo.data.csv_session import resample_sensors

t_grid, X, feature_names = resample_sensors(
    sensor_frames,
    sample_hz=3.0  # 3 Hz (one sample every 0.33s)
)
# Returns:
#   t_grid: (T,) time in seconds
#   X: (T, D) sensor array
#   feature_names: ['vel.vel', 'steer.steer_angle', ...]
```

**Why resample?**
- Different sensors record at different frequencies
- Resampling creates a uniform timeline for ML models

---

## Heuristic Labels

When ground-truth labels aren't available, TWIMO generates labels using simple rules:

### Rules

```python
def derive_proxy_actions(X, feature_names):
    """
    0 = STRAIGHT  (default)
    1 = TURN_LEFT (steer < -3°)
    2 = TURN_RIGHT (steer > 3°)
    3 = BRAKE (brake > 20)
    4 = ACCEL (accel > 20)
    5 = STOP (speed < 0.5 km/h)
    """
```

**Advantages:**
- ✅ Works on any HDD session
- ✅ No manual annotation needed
- ✅ Good enough for basic models

**Disadvantages:**
- ❌ Not as accurate as expert annotations
- ❌ Simple threshold-based rules
- ❌ Can't capture complex maneuvers

**Location:** `csv_session.py:126` (`derive_proxy_actions()`)

---

## Feature Extraction

### Sensor Channels

| Channel | CSV File | What It Measures |
|---------|----------|-----------------|
| Velocity | `vel.csv` | Speed in km/h |
| Steering | `steer.csv` | Steering angle (degrees) |
| Accelerator | `accel_pedal.csv` | Pedal angle (degrees) |
| Brake | `brake_pedal.csv` | Pedal pressure |
| Yaw | `yaw.csv` | Heading angle (optional) |
| Turn Signals | `turn_signal.csv` | Left/right indicators (optional) |

### Resampling Strategy

- **Numeric channels** (velocity, steering, etc.): Linear interpolation
- **Binary channels** (turn signals): Nearest neighbor

---

## Manifest Format

The manifest is a JSONL file (one JSON object per line):

```json
{"session_id": "201702271017", "csv_dir": "example_data/.../csv", "video_dir": "..."}
{"session_id": "201702281115", "csv_dir": "...", "video_dir": "..."}
```

**Fields:**
- `session_id`: Unique identifier (YYYYMMDDHHmm)
- `csv_dir`: Path to CSV folder
- `video_dir`: Path to video folder (optional)
- `rtk_dir`: Path to RTK GPS files (optional)

---

## Configuration

Edit `config.yaml` in the project root:

```yaml
# Dataset paths
data_dir: "example_data"              # Folder with HDD sessions
manifest_file: "artifacts/manifest.jsonl"

# Session limit
max_sessions: null  # null = use all sessions
```

See root `config.yaml` for all options.

---

## Troubleshooting

### "No sessions found when building manifest"

- Check `data_dir` in `config.yaml`
- Verify folder structure: `<scenario>/<session_id>/general/csv/`
- Run `python -m twimo.cli scan --root ./example_data` to see what's being scanned

### "Missing CSV files"

- Required: `vel.csv`, `steer.csv`, `accel_pedal.csv`, `brake_pedal.csv`
- Optional: `yaw.csv`, `turn_signal.csv`

---

## Performance

### CSV Loading Times

| Sessions | Time (CSV) | Time (.npy) | Speedup |
|----------|-----------|-------------|---------|
| 10 | ~60s | ~2s | 30x ✅ |
| 50 | ~5min | ~5s | 60x ✅ |
| 100 | ~15min | ~10s | 90x ✅ |

**Recommendation:** Use prealigned `.npy` files for large datasets.

---

## Related Files

- Main CLI: `twimo/cli.py`
- Configuration: `config.yaml` (root)
- Examples: `workflows/build_manifest.py`
