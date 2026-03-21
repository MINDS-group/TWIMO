#!/bin/bash
# Script to train and compare all available TWIMO models
# Usage: bash compare_all_models.sh [manifest_path]

set -e  # Exit on error

MANIFEST="${1:-./artifacts/manifest.jsonl}"
BASE_OUTDIR="./artifacts/model_comparison"
SAMPLE_HZ=3
EPOCHS=5

echo "========================================="
echo "TWIMO Model Comparison Script"
echo "========================================="
echo "Manifest: $MANIFEST"
echo "Output directory: $BASE_OUTDIR"
echo "Sample Hz: $SAMPLE_HZ"
echo "Epochs: $EPOCHS (neural models only)"
echo "========================================="
echo ""

# Check if manifest exists
if [ ! -f "$MANIFEST" ]; then
    echo "Error: Manifest file not found: $MANIFEST"
    echo "Usage: bash compare_all_models.sh [manifest_path]"
    exit 1
fi

# Create base output directory
mkdir -p "$BASE_OUTDIR"

# List of all models to compare
MODELS=(
    "transformer"
    "baseline"
    "xgboost"
    "random_forest"
    "lightgbm"
    "gru"
    "lstm"
    "tcn"
    "mlp_mean"
    "mlp_max"
    "mlp_concat"
)

# Train each model
for model in "${MODELS[@]}"; do
    echo "========================================="
    echo "Training: $model"
    echo "========================================="

    outdir="$BASE_OUTDIR/$model"

    # Skip if already trained (to allow resuming)
    if [ -f "$outdir/test_metrics.json" ]; then
        echo "Model already trained, skipping: $model"
        echo "Delete $outdir to retrain."
        echo ""
        continue
    fi

    # Train the model
    python -m twimo.cli train-maneuver \
        --manifest "$MANIFEST" \
        --outdir "$outdir" \
        --model "$model" \
        --sample-hz "$SAMPLE_HZ" \
        --epochs "$EPOCHS" \
        || {
            echo "Warning: Training failed for $model"
            echo "Check if required dependencies are installed (xgboost, lightgbm)"
            continue
        }

    echo "Completed: $model"
    echo ""
done

# Compare results
echo "========================================="
echo "Model Comparison Results"
echo "========================================="
echo ""

# Create a comparison summary
SUMMARY_FILE="$BASE_OUTDIR/comparison_summary.txt"
echo "TWIMO Model Comparison Summary" > "$SUMMARY_FILE"
echo "Generated: $(date)" >> "$SUMMARY_FILE"
echo "Manifest: $MANIFEST" >> "$SUMMARY_FILE"
echo "Sample Hz: $SAMPLE_HZ" >> "$SUMMARY_FILE"
echo "=========================================" >> "$SUMMARY_FILE"
echo "" >> "$SUMMARY_FILE"

# Print header
printf "%-20s" "Model" | tee -a "$SUMMARY_FILE"
for horizon in 1 2 5 6 9; do
    printf "%10s" "H${horizon}" | tee -a "$SUMMARY_FILE"
done
printf "%12s" "Mean Acc" | tee -a "$SUMMARY_FILE"
printf "%12s" "Status" | tee -a "$SUMMARY_FILE"
echo "" | tee -a "$SUMMARY_FILE"
echo "--------------------------------------------------------------------------------" | tee -a "$SUMMARY_FILE"

# Extract and display metrics for each model
for model in "${MODELS[@]}"; do
    metrics_file="$BASE_OUTDIR/$model/test_metrics.json"

    if [ ! -f "$metrics_file" ]; then
        printf "%-20s%s\n" "$model" "NOT TRAINED" | tee -a "$SUMMARY_FILE"
        continue
    fi

    # Check if it's an error note
    if grep -q '"note"' "$metrics_file"; then
        printf "%-20s%s\n" "$model" "NO TEST DATA" | tee -a "$SUMMARY_FILE"
        continue
    fi

    # Extract accuracies for each horizon (using Python for JSON parsing)
    printf "%-20s" "$model" | tee -a "$SUMMARY_FILE"

    # Extract horizon accuracies (assuming horizons 1, 2, 5, 6, 9 correspond to steps)
    accs=$(python3 -c "
import json, sys
try:
    data = json.load(open('$metrics_file'))
    accs = []
    for key in sorted(data.keys(), key=lambda x: int(x) if x.isdigit() else 0):
        if 'acc' in data[key]:
            accs.append(data[key]['acc'])
    print(' '.join([f'{a:.4f}' for a in accs[:5]]))
    if accs:
        print(f'{sum(accs)/len(accs):.4f}', end=' ')
    else:
        print('N/A', end=' ')
except Exception as e:
    print('ERROR', end=' ')
" 2>/dev/null || echo "PARSE_ERROR")

    printf "%s" "$accs" | tee -a "$SUMMARY_FILE"
    printf "%12s" "OK" | tee -a "$SUMMARY_FILE"
    echo "" | tee -a "$SUMMARY_FILE"
done

echo "" | tee -a "$SUMMARY_FILE"
echo "=========================================" | tee -a "$SUMMARY_FILE"
echo "Comparison complete!" | tee -a "$SUMMARY_FILE"
echo "Detailed results saved to: $SUMMARY_FILE" | tee -a "$SUMMARY_FILE"
echo "Individual model outputs in: $BASE_OUTDIR/<model_name>/" | tee -a "$SUMMARY_FILE"
echo "" | tee -a "$SUMMARY_FILE"

# Additional analysis with Python (optional)
python3 -c "
import json
import os
from pathlib import Path

base = Path('$BASE_OUTDIR')
results = {}

for model in ['transformer', 'baseline', 'xgboost', 'random_forest', 'lightgbm', 'gru', 'lstm', 'tcn', 'mlp_mean', 'mlp_max', 'mlp_concat']:
    metrics_file = base / model / 'test_metrics.json'
    if metrics_file.exists():
        try:
            with open(metrics_file) as f:
                data = json.load(f)
            if 'note' not in data:
                accs = [data[k]['acc'] for k in sorted(data.keys(), key=lambda x: int(x) if x.isdigit() else 0) if 'acc' in data[k]]
                if accs:
                    results[model] = {
                        'mean_acc': sum(accs) / len(accs),
                        'per_horizon': accs
                    }
        except:
            pass

if results:
    print('\nTop 5 Models by Mean Accuracy:')
    sorted_models = sorted(results.items(), key=lambda x: x[1]['mean_acc'], reverse=True)
    for i, (model, data) in enumerate(sorted_models[:5], 1):
        print(f'  {i}. {model:20s} - Mean Acc: {data[\"mean_acc\"]:.4f}')

    # Save detailed comparison
    comparison_file = base / 'detailed_comparison.json'
    with open(comparison_file, 'w') as f:
        json.dump(results, f, indent=2)
    print(f'\nDetailed comparison saved to: {comparison_file}')
else:
    print('\nNo models successfully trained with test data.')
" 2>/dev/null || echo "Python analysis skipped (optional)"

echo ""
echo "========================================="
echo "All done!"
echo "========================================="
