# Complete EAF Multi-Target Pipeline (PowerShell)
# This pipeline trains separate models for Goal and Stimuli prediction

Write-Host "======================================" -ForegroundColor Cyan
Write-Host "EAF Multi-Target Pipeline" -ForegroundColor Cyan
Write-Host "(Goal + Stimuli Prediction)" -ForegroundColor Cyan
Write-Host "======================================" -ForegroundColor Cyan

# Configuration
$EafDir = "./hdd_dataset/eaf_annotations"
$OutputBase = "./artifacts/eaf_multitarget"
$Manifest = "./artifacts/manifest.jsonl"
$SampleHz = 3.0

# Create output directories
New-Item -ItemType Directory -Force -Path $OutputBase | Out-Null

Write-Host ""
Write-Host "Step 1: Parse EAF files..." -ForegroundColor Yellow
python strategies_EAF/parse_eaf.py `
  --eaf-dir $EafDir `
  --output "$OutputBase/eaf_parsed"

Write-Host ""
Write-Host "Step 2: Build all vocabularies (Goal, Stimuli, Area, Event, Cause, Attention)..." -ForegroundColor Yellow
python strategies_EAF/build_all_vocabs.py `
  --eaf-parsed-dir "$OutputBase/eaf_parsed" `
  --output-dir "$OutputBase/vocabs"

Write-Host ""
Write-Host "Step 3: Align EAF to sensors (multi-target)..." -ForegroundColor Yellow
python strategies_EAF/align_eaf_to_sensors_multitarget.py `
  --eaf-parsed-dir "$OutputBase/eaf_parsed" `
  --vocab-dir "$OutputBase/vocabs" `
  --manifest $Manifest `
  --output-dir "$OutputBase/eaf_aligned" `
  --sample-hz $SampleHz

Write-Host ""
Write-Host "Step 4a: Train Goal prediction model..." -ForegroundColor Yellow
python -m twimo.cli train-maneuver `
  --manifest "$OutputBase/eaf_aligned/manifest_eaf_aligned_multitarget.jsonl" `
  --outdir "$OutputBase/maneuver_goal_transformer" `
  --model transformer `
  --sample-hz $SampleHz `
  --epochs 10

Write-Host ""
Write-Host "Step 4b: Train Stimuli prediction model..." -ForegroundColor Yellow
Write-Host "  NOTE: Requires custom data loader for target_stimuli/" -ForegroundColor Magenta
Write-Host "  See strategies_EAF/README_MULTITARGET.md for implementation details" -ForegroundColor Magenta
Write-Host "  Skipping for now..." -ForegroundColor Magenta

Write-Host ""
Write-Host "Step 5: Evaluate Goal model against EAF ground-truth..." -ForegroundColor Yellow
python strategies_EAF/evaluate_eaf.py `
  --model-dir "$OutputBase/maneuver_goal_transformer" `
  --manifest "$OutputBase/eaf_aligned/manifest_eaf_aligned_multitarget.jsonl" `
  --vocab "$OutputBase/vocabs/vocab_goal.json" `
  --output-dir "$OutputBase/eval_goal" `
  --sample-hz $SampleHz

Write-Host ""
Write-Host "======================================" -ForegroundColor Green
Write-Host "Pipeline completed!" -ForegroundColor Green
Write-Host "======================================" -ForegroundColor Green
Write-Host "Results:"
Write-Host "  Vocabularies:  $OutputBase/vocabs/" -ForegroundColor Cyan
Write-Host "  Aligned Data:  $OutputBase/eaf_aligned/" -ForegroundColor Cyan
Write-Host "    - sensor/           (with Area/Event/Cause/Attention features)" -ForegroundColor Cyan
Write-Host "    - target_goal/      (Goal maneuver labels)" -ForegroundColor Cyan
Write-Host "    - target_stimuli/   (Stimuli labels)" -ForegroundColor Cyan
Write-Host "  Goal Model:    $OutputBase/maneuver_goal_transformer/" -ForegroundColor Cyan
Write-Host "  Evaluation:    $OutputBase/eval_goal/evaluation_results.json" -ForegroundColor Cyan
Write-Host ""
