# Feature Engineering

This folder contains advanced feature extraction from sensor data and ELAN annotations.

---

## What Does This Do?

Transforms raw sensor data into meaningful features for machine learning models.

---

## Key Files

| File | What It Does |
|------|-------------|
| `hdd_loader.py` | Loads and combines multiple CSV files from HDD sessions |
| `advanced_features.py` | Extracts 40+ engineered features from sensor data |
| `eaf_parser.py` | Parses ELAN annotation files (.eaf) for expert labels |

---

## Advanced Features (`advanced_features.py`)

### What Are Features?

Features are numerical representations of driving behavior extracted from raw sensors.

**Example:**
- Raw data: velocity = [45, 46, 44, 43, 42 km/h]
- Features:
  - `vel_mean` = 44 km/h
  - `vel_std` = 1.58 km/h
  - `vel_trend` = -0.75 km/h/s (decelerating)

### Feature Categories (40+ total)

#### Velocity Features (6)
- `vel_mean`: Average speed
- `vel_std`: Speed variability
- `vel_min`, `vel_max`: Speed range
- `vel_p95`: 95th percentile speed
- `vel_trend`: Acceleration/deceleration trend

#### Acceleration Features (5)
- `accel_mean`: Average acceleration
- `accel_std`: Acceleration variability
- `accel_max`: Maximum acceleration
- `accel_p95`: 95th percentile
- `jerk_mean`: Rate of acceleration change

#### Brake Features (4)
- `brake_mean`: Average brake pressure
- `brake_max`: Maximum braking
- `brake_p95`: 95th percentile
- `brake_activations`: Number of brake presses

#### Steering Features (5)
- `steer_mean`: Average steering angle
- `steer_std`: Steering variability
- `steer_max_abs`: Maximum steering (left or right)
- `steer_rate_max`: Fastest steering change
- `steer_reversals`: Number of direction changes

#### Composite Features (10+)
- `aggr_score`: Aggressiveness score (0-10)
- `smoothness`: Driving smoothness (0-1)
- `efficiency`: Fuel efficiency indicator
- `safety_score`: Safety indicator

### How to Use

```python
from twimo.features.advanced_features import extract_advanced_features

# X: (T, D) sensor array from csv_session.py
features = extract_advanced_features(X, feature_names, sample_hz=3.0)

# Returns dict:
# {
#   'vel_mean': 45.2,
#   'vel_std': 8.3,
#   'accel_p95': 2.1,
#   'brake_max': 85.3,
#   'aggr_score': 6.8,
#   ...
# }
```

---

## ELAN Annotation Parser (`eaf_parser.py`)

### What Are ELAN Annotations?

ELAN files (`.eaf`) contain expert annotations with multiple tiers:

| Tier | What It Annotates |
|------|------------------|
| **Cause** | External causes (traffic light, pedestrian, etc.) |
| **Attention** | What driver is looking at |
| **Goal** | Driver's intention (turn left, change lane, etc.) |
| **Maneuver** | Physical action (brake, accelerate, steer) |

### How ELAN Works

Experts watch driving videos and annotate:
```
Time 10.5s - 12.3s: Cause=traffic_light, Goal=stop, Maneuver=brake
Time 12.3s - 15.8s: Cause=clear, Goal=go, Maneuver=accelerate
```

### Parsing ELAN Files

```python
from twimo.features.eaf_parser import parse_eaf_file

annotations = parse_eaf_file("session.eaf")

# Returns list of annotations:
# [
#   {'tier': 'Goal', 'start': 10.5, 'end': 12.3, 'value': 'stop'},
#   {'tier': 'Maneuver', 'start': 10.5, 'end': 12.3, 'value': 'brake'},
#   ...
# ]
```

### Converting to Labels

```python
from twimo.features.eaf_parser import annotations_to_labels

# Convert annotations to frame-by-frame labels
y = annotations_to_labels(
    annotations,
    tier='Goal',  # Which tier to use
    t_grid=t_grid,  # Timeline from resample_sensors()
    vocab={'none': 0, 'stop': 1, 'turn_left': 2, ...}
)
# Returns: (T,) array of label indices
```

---

## HDD Loader (`hdd_loader.py`)

Multi-CSV loader that combines all sensor files.

### Usage

```python
from twimo.features.hdd_loader import load_hdd_session

data = load_hdd_session(
    csv_dir="example_data/2017_02_27_ITS1/201702271017/general/csv",
    sample_hz=3.0
)

# Returns:
# {
#   't': (T,) time array,
#   'X': (T, D) sensor array,
#   'feature_names': ['vel', 'steer', 'accel', 'brake', ...],
#   'y': (T,) labels (if annotations available)
# }
```

---

## Feature Engineering Best Practices

### Window-Based Features

For ML models, features are often computed over **windows** (e.g., last 2 seconds):

```python
# Window size: 2 seconds at 3 Hz = 6 timesteps
window = 6

for i in range(window, len(X)):
    window_data = X[i-window:i]  # Last 6 timesteps

    features[i] = {
        'vel_mean': window_data[:, vel_idx].mean(),
        'vel_std': window_data[:, vel_idx].std(),
        'accel_max': window_data[:, accel_idx].max(),
        ...
    }
```

**Why windows?**
- Captures temporal context (what happened recently)
- More robust than single-timestep features
- Better for predicting future maneuvers

---

## Feature Normalization

Always normalize features before training:

```python
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
X_normalized = scaler.fit_transform(X)
# Scales each feature to mean=0, std=1
```

**Why normalize?**
- Different features have different scales (velocity: 0-100 km/h, brake: 0-255)
- ML models work better with normalized inputs
- Prevents features with large values from dominating

---

## Related Files

- Data loading: `twimo/data/csv_session.py`
- Models: `twimo/models/`
- Analysis: `twimo/analysis/`
