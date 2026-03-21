@echo off
REM Start Qdrant vector database for TWIMO

echo ================================================
echo Starting Qdrant Vector Database for TWIMO
echo ================================================
echo.

REM Check if Docker is running
docker info >nul 2>&1
if errorlevel 1 (
    echo X Error: Docker is not running
    echo    Please start Docker Desktop
    exit /b 1
)

echo [OK] Docker is running
echo.

REM Start Qdrant
echo [*] Starting Qdrant...
docker-compose up -d

if errorlevel 0 (
    echo.
    echo [OK] Qdrant started successfully!
    echo.
    echo Dashboard: http://localhost:6333/dashboard
    echo REST API:  http://localhost:6333
    echo gRPC API:  localhost:6334
    echo.
    echo Data is stored in: .\storage\
    echo.

    REM Wait for Qdrant to start
    echo [*] Waiting for Qdrant to be ready...
    timeout /t 3 /nobreak >nul

    echo [OK] Qdrant should be ready now!
    echo.
    echo Next steps:
    echo    1. Train style clustering:
    echo       python -m twimo.cli train-style --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/style --k 3
    echo.
    echo    2. Create visualizations:
    echo       python examples/visualize_driving_styles.py
    echo.
    echo    3. Stop Qdrant when done:
    echo       cd qdrant ^&^& docker-compose down
    echo.

    REM Open dashboard in browser
    start http://localhost:6333/dashboard
) else (
    echo X Failed to start Qdrant
    echo    Check Docker logs with: docker-compose logs
    exit /b 1
)
