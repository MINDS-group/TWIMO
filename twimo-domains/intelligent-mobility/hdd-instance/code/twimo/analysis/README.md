# Advanced Analysis

This folder provides advanced analysis capabilities for driving behavior data.

---

## What Does This Do?

Performs multi-level clustering, temporal segmentation, event detection, and sequential modeling on driving sessions.

---

## Key Files

| File | What It Does |
|------|-------------|
| `hierarchical_clustering.py` | 3-level clustering: Style → Context → Behaviors |
| `temporal_segmentation.py` | Sliding window analysis over time |
| `multi_modal_pipeline.py` | Complete end-to-end analysis pipeline |
| `event_detection.py` | Detects driving events (stops, turns, lane changes) |
| `action_recognition.py` | Matches ELAN annotations to detected events |
| `sequential_modeling.py` | Predicts next action from event sequences |

---

## Hierarchical Clustering

### What Is It?

Groups driving sessions into clusters at 3 levels of detail:

**Level 1 - Driving Style** (3 clusters):
- 🟢 Prudent: Slow, safe driving
- 🔵 Smooth: Balanced, efficient driving
- 🔴 Aggressive: Fast, dynamic driving

**Level 2 - Style + Context** (7 clusters):
- Prudent city, Prudent highway
- Smooth city, Smooth suburban, Smooth highway
- Aggressive city, Aggressive highway

**Level 3 - Fine-Grained Behaviors** (11+ clusters):
- Detailed behavior patterns within each context

### How to Use

```bash
python workflows/advanced_clustering_analysis.py
```

**What it does:**
1. Loads all sessions from manifest
2. Extracts 40+ features per session
3. Clusters at 3 levels
4. Saves results to `artifacts/advanced_analysis/`

**Outputs:**
- `clustering_results.jsonl`: Per-session cluster assignments
- `centroids.json`: Cluster centers
- `hierarchy.json`: Cluster hierarchy tree

**Configure in `config.yaml`:**
```yaml
clustering:
  level1_clusters: 3   # Style
  level2_clusters: 7   # Style + Context
  level3_clusters: 11  # Fine-grained
```

---

## Temporal Segmentation

### What Is It?

Divides driving sessions into time windows and analyzes behavior changes.

**Example:**
```
Session: 0-300s (5 minutes)
Windows: [0-30s], [15-45s], [30-60s], ... (15s stride)
```

Each window gets:
- Feature vector (vel_mean, accel_p95, etc.)
- Behavior label (from clustering)
- Transition indicator (behavior changed?)

### How It Works

```python
from twimo.analysis.temporal_segmentation import segment_session

segments = segment_session(
    X,  # Sensor data
    feature_names,
    window_size_sec=30,  # 30-second windows
    stride_sec=15,  # 15-second overlap
    sample_hz=3.0
)

# Returns list of segments:
# [
#   {'start': 0, 'end': 30, 'features': {...}, 'behavior': 'smooth'},
#   {'start': 15, 'end': 45, 'features': {...}, 'behavior': 'smooth'},
#   {'start': 30, 'end': 60, 'features': {...}, 'behavior': 'aggressive'},
#   ...
# ]
```

**Use cases:**
- Detect behavior transitions (smooth → aggressive)
- Analyze context changes (city → highway)
- Study fatigue effects over time

---

## Event Detection

### What Are Events?

Events are specific driving actions detected from sensor data:

| Event | Detection Rule |
|-------|---------------|
| **Stop** | velocity < 0.5 km/h for > 2s |
| **Hard Brake** | brake > 200 or accel < -4 m/s² |
| **Hard Accel** | accel > 3 m/s² |
| **Turn Left** | steer < -15° |
| **Turn Right** | steer > 15° |
| **Lane Change** | steer crosses 0° (left↔right) |

### How to Use

```python
from twimo.analysis.event_detection import detect_events

events = detect_events(X, feature_names, sample_hz=3.0)

# Returns:
# [
#   {'type': 'stop', 'start': 10.5, 'end': 15.2, 'duration': 4.7},
#   {'type': 'hard_brake', 'start': 42.1, 'end': 43.5, 'peak': 230},
#   {'type': 'turn_left', 'start': 58.3, 'end': 62.1, 'angle': -25},
#   ...
# ]
```

---

## Action Recognition

### What Is It?

Matches ELAN expert annotations to automatically detected events.

**Example:**
```
Detected: hard_brake at 42.1-43.5s
ELAN annotation: "brake_for_red_light" at 42.0-44.0s
→ Match! (temporal overlap > 50%)
```

### How It Works

```python
from twimo.analysis.action_recognition import match_annotations_to_events

matches = match_annotations_to_events(
    events,  # From event_detection
    annotations,  # From ELAN parser
    overlap_threshold=0.5  # 50% temporal overlap
)

# Returns:
# [
#   {
#     'event': {'type': 'hard_brake', 'start': 42.1, ...},
#     'annotation': {'value': 'brake_for_red_light', 'start': 42.0, ...},
#     'overlap': 0.87  # 87% overlap
#   },
#   ...
# ]
```

**Use cases:**
- Validate automatic event detection
- Train supervised models with ELAN labels
- Study annotation patterns

---

## Sequential Modeling

### What Is It?

Predicts the next driver action based on event sequences using a Markov transition matrix.

**Example:**
```
Sequence: [stop, start, accelerate, turn_left, ...]
Model: "After accelerate, driver will likely turn_left (65%) or brake (25%)"
```

### How It Works

```python
from twimo.analysis.sequential_modeling import train_markov_model, predict_next_action

# Train on event sequences
model = train_markov_model(event_sequences)

# Predict next action
next_action, prob = predict_next_action(
    model,
    history=['stop', 'start', 'accelerate']
)
# Returns: ('turn_left', 0.65)
```

### Evaluation Metrics

Typical performance (from ELAN annotated data):
- **Top-1 accuracy**: ~56% (correct in 1st prediction)
- **Top-3 accuracy**: ~93% (correct in top 3 predictions)

---

## Multi-Modal Pipeline

### What Is It?

Complete end-to-end pipeline combining all analysis components.

```bash
python workflows/advanced_clustering_analysis.py
```

**Pipeline steps:**
1. Load sessions
2. Extract features
3. Hierarchical clustering (3 levels)
4. Temporal segmentation
5. Event detection
6. (Optional) Action recognition if ELAN available
7. (Optional) Sequential modeling if ELAN available
8. Save results

**Outputs:**
- `clustering_results.jsonl`
- `temporal_segments.jsonl`
- `detected_events.jsonl`
- `sequential_model.json`

---

## Configuration

Edit `config.yaml`:

```yaml
clustering:
  level1_clusters: 3
  level2_clusters: 7
  level3_clusters: 11

temporal:
  window_size_sec: 30
  stride_sec: 15

event_detection:
  stop_threshold: 0.5  # km/h
  hard_brake_threshold: 200
  turn_angle_threshold: 15  # degrees
```

---

## Related Files

- Features: `twimo/features/`
- Visualization: `twimo/visualization/`
- Examples: `workflows/advanced_clustering_analysis.py`
