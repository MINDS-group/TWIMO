#!/bin/bash
# Start Qdrant vector database for TWIMO

echo "================================================"
echo "Starting Qdrant Vector Database for TWIMO"
echo "================================================"
echo ""

# Check if Docker is installed
if ! command -v docker &> /dev/null; then
    echo "❌ Error: Docker is not installed"
    echo "   Please install Docker from: https://www.docker.com/get-started"
    exit 1
fi

# Check if Docker Compose is installed
if ! command -v docker-compose &> /dev/null; then
    echo "❌ Error: Docker Compose is not installed"
    echo "   Please install Docker Compose from: https://docs.docker.com/compose/install/"
    exit 1
fi

echo "✅ Docker is installed"
echo ""

# Start Qdrant
echo "🚀 Starting Qdrant..."
docker-compose up -d

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Qdrant started successfully!"
    echo ""
    echo "📊 Dashboard: http://localhost:6333/dashboard"
    echo "🔌 REST API:  http://localhost:6333"
    echo "🔌 gRPC API:  localhost:6334"
    echo ""
    echo "💾 Data is stored in: ./storage/"
    echo ""

    # Wait a bit for Qdrant to start
    echo "⏳ Waiting for Qdrant to be ready..."
    sleep 3

    # Check health
    if curl -s http://localhost:6333/healthz | grep -q "ok"; then
        echo "✅ Qdrant is healthy and ready to use!"
    else
        echo "⚠️  Qdrant is starting... (may take a few more seconds)"
    fi

    echo ""
    echo "📝 Next steps:"
    echo "   1. Train style clustering:"
    echo "      python -m twimo.cli train-style --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/style --k 3"
    echo ""
    echo "   2. Create visualizations:"
    echo "      python examples/visualize_driving_styles.py"
    echo ""
    echo "   3. Stop Qdrant when done:"
    echo "      cd qdrant && docker-compose down"
    echo ""
else
    echo "❌ Failed to start Qdrant"
    echo "   Check Docker logs with: docker-compose logs"
    exit 1
fi
