# Complete EAF annotation pipeline example (PowerShell)

Write-Host "======================================" -ForegroundColor Cyan
Write-Host "EAF Annotation Pipeline" -ForegroundColor Cyan
Write-Host "======================================" -ForegroundColor Cyan

# Configuration
$EafDir = "./hdd_dataset/eaf_annotations"
$OutputBase = "./artifacts/eaf_workflow"
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
Write-Host "Step 2: Build vocabulary..." -ForegroundColor Yellow
python strategies_EAF/build_vocab.py `
  --eaf-parsed-dir "$OutputBase/eaf_parsed" `
  --output "$OutputBase/vocab_eaf.json"

Write-Host ""
Write-Host "Step 3: Align EAF to sensors..." -ForegroundColor Yellow
python strategies_EAF/align_eaf_to_sensors.py `
  --eaf-parsed-dir "$OutputBase/eaf_parsed" `
  --vocab "$OutputBase/vocab_eaf.json" `
  --manifest $Manifest `
  --output-dir "$OutputBase/eaf_aligned" `
  --sample-hz $SampleHz

Write-Host ""
Write-Host "Step 4: Train model with EAF labels..." -ForegroundColor Yellow
python -m twimo.cli train-maneuver `
  --manifest "$OutputBase/eaf_aligned/manifest_eaf_aligned.jsonl" `
  --outdir "$OutputBase/maneuver_eaf_transformer" `
  --model transformer `
  --sample-hz $SampleHz `
  --epochs 10

Write-Host ""
Write-Host "Step 5: Evaluate against EAF ground-truth..." -ForegroundColor Yellow
python strategies_EAF/evaluate_eaf.py `
  --model-dir "$OutputBase/maneuver_eaf_transformer" `
  --manifest "$OutputBase/eaf_aligned/manifest_eaf_aligned.jsonl" `
  --vocab "$OutputBase/vocab_eaf.json" `
  --output-dir "$OutputBase/eval_eaf" `
  --sample-hz $SampleHz

Write-Host ""
Write-Host "======================================" -ForegroundColor Green
Write-Host "Pipeline completed!" -ForegroundColor Green
Write-Host "======================================" -ForegroundColor Green
Write-Host "Results:"
Write-Host "  Vocabulary:  $OutputBase/vocab_eaf.json" -ForegroundColor Cyan
Write-Host "  Aligned NPY: $OutputBase/eaf_aligned/" -ForegroundColor Cyan
Write-Host "  Model:       $OutputBase/maneuver_eaf_transformer/" -ForegroundColor Cyan
Write-Host "  Evaluation:  $OutputBase/eval_eaf/evaluation_results.json" -ForegroundColor Cyan
Write-Host ""
