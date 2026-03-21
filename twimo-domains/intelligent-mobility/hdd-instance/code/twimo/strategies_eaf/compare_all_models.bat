@echo off
REM Script to train and compare all available TWIMO models on Windows
REM Usage: compare_all_models.bat [manifest_path]

setlocal enabledelayedexpansion

set MANIFEST=%1
if "%MANIFEST%"=="" set MANIFEST=.\artifacts\manifest.jsonl

set BASE_OUTDIR=.\artifacts\model_comparison
set SAMPLE_HZ=3
set EPOCHS=5

echo =========================================
echo TWIMO Model Comparison Script (Windows)
echo =========================================
echo Manifest: %MANIFEST%
echo Output directory: %BASE_OUTDIR%
echo Sample Hz: %SAMPLE_HZ%
echo Epochs: %EPOCHS% (neural models only)
echo =========================================
echo.

REM Check if manifest exists
if not exist "%MANIFEST%" (
    echo Error: Manifest file not found: %MANIFEST%
    echo Usage: compare_all_models.bat [manifest_path]
    exit /b 1
)

REM Create base output directory
if not exist "%BASE_OUTDIR%" mkdir "%BASE_OUTDIR%"

REM List of all models to compare
set MODELS=transformer baseline xgboost random_forest lightgbm gru lstm tcn mlp_mean mlp_max mlp_concat

REM Train each model
for %%M in (%MODELS%) do (
    echo =========================================
    echo Training: %%M
    echo =========================================

    set OUTDIR=%BASE_OUTDIR%\%%M

    REM Skip if already trained
    if exist "!OUTDIR!\test_metrics.json" (
        echo Model already trained, skipping: %%M
        echo Delete !OUTDIR! to retrain.
        echo.
    ) else (
        REM Train the model
        python -m twimo.cli train-maneuver --manifest "%MANIFEST%" --outdir "!OUTDIR!" --model %%M --sample-hz %SAMPLE_HZ% --epochs %EPOCHS%

        if errorlevel 1 (
            echo Warning: Training failed for %%M
            echo Check if required dependencies are installed (xgboost, lightgbm^)
        ) else (
            echo Completed: %%M
        )
        echo.
    )
)

REM Compare results
echo =========================================
echo Model Comparison Results
echo =========================================
echo.

set SUMMARY_FILE=%BASE_OUTDIR%\comparison_summary.txt
echo TWIMO Model Comparison Summary > "%SUMMARY_FILE%"
echo Generated: %date% %time% >> "%SUMMARY_FILE%"
echo Manifest: %MANIFEST% >> "%SUMMARY_FILE%"
echo Sample Hz: %SAMPLE_HZ% >> "%SUMMARY_FILE%"
echo ========================================= >> "%SUMMARY_FILE%"
echo. >> "%SUMMARY_FILE%"

echo Model comparison complete!
echo.
echo Results summary:
echo =========================================

REM Simple results listing
for %%M in (%MODELS%) do (
    set METRICS_FILE=%BASE_OUTDIR%\%%M\test_metrics.json
    if exist "!METRICS_FILE!" (
        echo %%M: TRAINED
    ) else (
        echo %%M: NOT TRAINED
    )
)

echo =========================================
echo.
echo Detailed results saved to: %SUMMARY_FILE%
echo Individual model outputs in: %BASE_OUTDIR%\^<model_name^>\
echo.
echo To view test metrics for a specific model:
echo   type %BASE_OUTDIR%\^<model_name^>\test_metrics.json
echo.
echo Recommended: Use Python script for detailed comparison:
echo   python -c "import json; print(json.dumps(json.load(open('%BASE_OUTDIR%\^<model^>\test_metrics.json')), indent=2))"
echo.
echo =========================================
echo All done!
echo =========================================

endlocal
