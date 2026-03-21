# Explainability (XAI)

This folder generates human-readable explanations for ML model predictions.

---

## What Does This Do?

Converts model predictions into text explanations explaining **why** the model made a prediction.

---

## Key Files

| File | What It Does |
|------|-------------|
| `explain.py` | Generates text explanations from predictions |
| `rules.py` | Rule templates for explanation generation |

---

## How It Works

### Example Prediction

**Model output:**
```
At time 14.5s:
Predicted class: TURN_LEFT
Confidence: 87%
Input features:
  - velocity: 45 km/h → 32 km/h (decreasing)
  - steer_angle: 0.2° → 5.8° left (increasing)
  - brake: 0 → 15 (light pressure)
```

**Explanation generated:**
> "At 14.5s ahead, the model predicts **TURN_LEFT** with 87% confidence. This is because the velocity is decreasing from 45 to 32 km/h and the steering angle is increasing leftward from 0.2° to 5.8°."

---

## How to Use

```bash
python -m twimo.cli explain --manifest ./artifacts/manifest.jsonl --modeldir ./artifacts/maneuver_transformer --outdir ./artifacts/explain --explain-every-steps 50
```

**What it does:**
1. Loads trained model
2. Runs predictions on test data
3. Generates text explanation every 50 timesteps
4. Saves to JSONL file

**Output:** `artifacts/explain/explanations__all.jsonl`

```json
{"time": 14.5, "pred": "TURN_LEFT", "conf": 0.87, "explanation": "At 14.5s ahead..."}
{"time": 29.0, "pred": "BRAKE", "conf": 0.92, "explanation": "At 29.0s ahead..."}
```

---

## Explanation Components

### 1. Prediction Statement

```
"The model predicts TURN_LEFT with 87% confidence."
```

### 2. Feature Analysis

Identifies which features triggered the prediction:

```
"This is because:
- Velocity is decreasing (45 → 32 km/h)
- Steering angle is increasing leftward (0.2° → 5.8°)
- Brake pressure is applied (0 → 15)"
```

### 3. Context Information

Adds temporal context:

```
"At 14.5s ahead" (prediction horizon)
"In the last 2 seconds" (window analyzed)
```

---

## Rule Templates (`rules.py`)

Templates for different maneuver types:

```python
EXPLANATION_TEMPLATES = {
    'TURN_LEFT': "Steering angle increased leftward from {steer_start}° to {steer_end}°",
    'BRAKE': "Brake pressure increased from {brake_start} to {brake_end}",
    'ACCEL': "Velocity increased from {vel_start} to {vel_end} km/h",
    'STOP': "Velocity decreased to {vel_end} km/h (near stop)",
    ...
}
```

### Adding Custom Rules

Edit `rules.py`:

```python
def explain_lane_change(features):
    if abs(features['steer_delta']) > 10:
        return f"Steering changed rapidly by {features['steer_delta']:.1f}°"
    return "Gradual lane change detected"
```

---

## Configuration

### Explanation Frequency

```bash
--explain-every-steps 50  # Explain every 50 predictions
--explain-every-steps 1   # Explain ALL predictions (verbose)
```

### Confidence Threshold

Only explain high-confidence predictions:

```python
from twimo.xai.explain import generate_explanation

if confidence > 0.8:  # Only explain if >80% confident
    explanation = generate_explanation(pred, features, confidence)
```

---

## Use Cases

### 1. Model Debugging

Find when the model makes mistakes:

```
Prediction: TURN_LEFT (85%)
Actual: STRAIGHT
Explanation: "Steering increased to 2.1°" ← too sensitive!
```

**Action:** Adjust steering threshold in model.

### 2. User Interface

Show explanations in driving assistance systems:

```
Dashboard: "Predicting right turn in 3 seconds because
steering angle is increasing and velocity decreasing"
```

### 3. Safety Validation

Verify predictions make sense:

```
Prediction: ACCEL
Explanation: "Velocity increasing, brake released"
✅ Makes sense!

Prediction: ACCEL
Explanation: "Brake pressure applied, velocity decreasing"
❌ Contradiction! Model error.
```

---

## Advanced: Feature Importance

Identify which features are most important:

```python
from twimo.xai.explain import compute_feature_importance

importance = compute_feature_importance(model, X)

# Returns:
# {
#   'steer_angle': 0.35,  # Most important
#   'velocity': 0.28,
#   'brake': 0.20,
#   'accel': 0.17
# }
```

**Visualize:**
```python
import matplotlib.pyplot as plt

plt.barh(list(importance.keys()), list(importance.values()))
plt.xlabel('Importance')
plt.title('Feature Importance for TURN_LEFT Prediction')
plt.show()
```

---

## Related Files

- Models: `twimo/models/`
- CLI: `twimo/cli.py`
- Examples: See main README Step 2
