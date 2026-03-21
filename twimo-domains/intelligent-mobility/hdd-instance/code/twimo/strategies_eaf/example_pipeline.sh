#!/bin/bash
# Complete EAF annotation pipeline example

echo "======================================"
echo "EAF Annotation Pipeline"
echo "======================================"

# Configuration
EAF_DIR="./hdd_dataset/eaf_annotations"
OUTPUT_BASE="./artifacts/eaf_workflow"
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
echo "Step 2: Build vocabulary..."
python strategies_EAF/build_vocab.py \
  --eaf-parsed-dir "$OUTPUT_BASE/eaf_parsed" \
  --output "$OUTPUT_BASE/vocab_eaf.json"

echo ""
echo "Step 3: Align EAF to sensors..."
python strategies_EAF/align_eaf_to_sensors.py \
  --eaf-parsed-dir "$OUTPUT_BASE/eaf_parsed" \
  --vocab "$OUTPUT_BASE/vocab_eaf.json" \
  --manifest "$MANIFEST" \
  --output-dir "$OUTPUT_BASE/eaf_aligned" \
  --sample-hz $SAMPLE_HZ

echo ""
echo "Step 4: Train model with EAF labels..."
python -m twimo.cli train-maneuver \
  --manifest "$OUTPUT_BASE/eaf_aligned/manifest_eaf_aligned.jsonl" \
  --outdir "$OUTPUT_BASE/maneuver_eaf_transformer" \
  --model transformer \
  --sample-hz $SAMPLE_HZ \
  --epochs 10

echo ""
echo "Step 5: Evaluate against EAF ground-truth..."
python strategies_EAF/evaluate_eaf.py \
  --model-dir "$OUTPUT_BASE/maneuver_eaf_transformer" \
  --manifest "$OUTPUT_BASE/eaf_aligned/manifest_eaf_aligned.jsonl" \
  --vocab "$OUTPUT_BASE/vocab_eaf.json" \
  --output-dir "$OUTPUT_BASE/eval_eaf" \
  --sample-hz $SAMPLE_HZ

echo ""
echo "======================================"
echo "Pipeline completed!"
echo "======================================"
echo "Results:"
echo "  Vocabulary:  $OUTPUT_BASE/vocab_eaf.json"
echo "  Aligned NPY: $OUTPUT_BASE/eaf_aligned/"
echo "  Model:       $OUTPUT_BASE/maneuver_eaf_transformer/"
echo "  Evaluation:  $OUTPUT_BASE/eval_eaf/evaluation_results.json"
echo ""
