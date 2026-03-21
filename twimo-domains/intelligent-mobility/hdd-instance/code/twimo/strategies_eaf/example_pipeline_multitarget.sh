#!/bin/bash
# Complete EAF Multi-Target Pipeline
# This pipeline trains separate models for Goal and Stimuli prediction

echo "======================================"
echo "EAF Multi-Target Pipeline"
echo "(Goal + Stimuli Prediction)"
echo "======================================"

# Configuration
EAF_DIR="./hdd_dataset/eaf_annotations"
OUTPUT_BASE="./artifacts/eaf_multitarget"
MANIFEST="./artifacts/manifest.jsonl"
SAMPLE_HZ=3.0

# Create output directories
mkdir -p "$OUTPUT_BASE"

echo ""
echo "Step 1: Parse EAF files..."
python strategies_EAF/parse_eaf.py \
  --eaf-dir "$EAF_DIR" \
  --output "$OUTPUT_BASE/eaf_parsed"

echo ""
echo "Step 2: Build all vocabularies (Goal, Stimuli, Area, Event, Cause, Attention)..."
python strategies_EAF/build_all_vocabs.py \
  --eaf-parsed-dir "$OUTPUT_BASE/eaf_parsed" \
  --output-dir "$OUTPUT_BASE/vocabs"

echo ""
echo "Step 3: Align EAF to sensors (multi-target)..."
python strategies_EAF/align_eaf_to_sensors_multitarget.py \
  --eaf-parsed-dir "$OUTPUT_BASE/eaf_parsed" \
  --vocab-dir "$OUTPUT_BASE/vocabs" \
  --manifest "$MANIFEST" \
  --output-dir "$OUTPUT_BASE/eaf_aligned" \
  --sample-hz $SAMPLE_HZ

echo ""
echo "Step 4a: Train Goal prediction model..."
python -m twimo.cli train-maneuver \
  --manifest "$OUTPUT_BASE/eaf_aligned/manifest_eaf_aligned_multitarget.jsonl" \
  --outdir "$OUTPUT_BASE/maneuver_goal_transformer" \
  --model transformer \
  --sample-hz $SAMPLE_HZ \
  --epochs 10

echo ""
echo "Step 4b: Train Stimuli prediction model..."
echo "  NOTE: Requires custom data loader for target_stimuli/"
echo "  See strategies_EAF/README_MULTITARGET.md for implementation details"
echo "  Skipping for now..."

echo ""
echo "Step 5: Evaluate Goal model against EAF ground-truth..."
python strategies_EAF/evaluate_eaf.py \
  --model-dir "$OUTPUT_BASE/maneuver_goal_transformer" \
  --manifest "$OUTPUT_BASE/eaf_aligned/manifest_eaf_aligned_multitarget.jsonl" \
  --vocab "$OUTPUT_BASE/vocabs/vocab_goal.json" \
  --output-dir "$OUTPUT_BASE/eval_goal" \
  --sample-hz $SAMPLE_HZ

echo ""
echo "======================================"
echo "Pipeline completed!"
echo "======================================"
echo "Results:"
echo "  Vocabularies:  $OUTPUT_BASE/vocabs/"
echo "  Aligned Data:  $OUTPUT_BASE/eaf_aligned/"
echo "    - sensor/           (with Area/Event/Cause/Attention features)"
echo "    - target_goal/      (Goal maneuver labels)"
echo "    - target_stimuli/   (Stimuli labels)"
echo "  Goal Model:    $OUTPUT_BASE/maneuver_goal_transformer/"
echo "  Evaluation:    $OUTPUT_BASE/eval_goal/evaluation_results.json"
echo ""
