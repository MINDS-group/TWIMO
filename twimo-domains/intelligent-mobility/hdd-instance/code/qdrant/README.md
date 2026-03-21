# Qdrant Vector Database for TWIMO

This directory contains the Qdrant vector database setup for storing and querying driving style embeddings.

## Quick Start

### 1. Start Qdrant with Docker

```bash
cd qdrant
docker-compose up -d
```

This will:
- Start Qdrant on port 6333 (REST API) and 6334 (gRPC)
- Persist data in `./storage/` directory
- Run in the background

### 2. Verify Qdrant is Running

```bash
# Check container status
docker-compose ps

# Check Qdrant health
curl http://localhost:6333/healthz
```

You should see `{"status":"ok"}` if Qdrant is running correctly.

### 3. Access Qdrant Dashboard

Open your browser and go to:
```
http://localhost:6333/dashboard
```

This provides a web UI for exploring your collections and data.

---

## Usage with TWIMO

Once Qdrant is running, the visualization script will automatically connect to it:

```bash
# Train style clustering first
python -m twimo.cli train-style --manifest ./artifacts/manifest.jsonl --outdir ./artifacts/style --k 3

# Create visualizations and populate Qdrant
python workflows/visualize_driving_styles.py
```

The vector database will be created in the `driving_styles` collection.

---

## Docker Commands

### Start Qdrant
```bash
cd qdrant
docker-compose up -d
```

### Stop Qdrant
```bash
cd qdrant
docker-compose down
```

### View Logs
```bash
cd qdrant
docker-compose logs -f
```

### Restart Qdrant
```bash
cd qdrant
docker-compose restart
```

### Remove All Data (Fresh Start)
```bash
cd qdrant
docker-compose down -v
rm -rf storage/*
docker-compose up -d
```

---

## Configuration

### Default Settings
- **REST API**: http://localhost:6333
- **gRPC API**: localhost:6334
- **Storage**: `./storage/` (persisted on host)
- **Dashboard**: http://localhost:6333/dashboard

### Change Ports

Edit `docker-compose.yml` to use different ports:

```yaml
ports:
  - "8333:6333"  # Use 8333 instead of 6333
  - "8334:6334"  # Use 8334 instead of 6334
```

Then restart:
```bash
docker-compose down
docker-compose up -d
```

---

## Data Storage

All vector data is stored in `./storage/` which is mounted as a Docker volume.

```
qdrant/
├── docker-compose.yml
├── storage/               # Qdrant data (auto-created)
│   ├── collections/
│   ├── raft/
│   └── ...
└── README.md
```

**Important**: The `storage/` directory is gitignored and should NOT be committed to version control.

---

## Connecting from Python

The TWIMO visualization module automatically connects to Qdrant:

```python
from qdrant_client import QdrantClient

# Connect to Docker instance
client = QdrantClient(host="localhost", port=6333)

# Or use the visualization module directly
from twimo.visualization import create_vector_database, query_similar_sessions
from pathlib import Path

# This will use the Docker Qdrant instance
create_vector_database(
    features=features,
    session_ids=session_ids,
    clusters=clusters,
    cluster_names=cluster_names,
    qdrant_url="http://localhost:6333",
    collection_name="driving_styles",
)
```

---

## Troubleshooting

### Port Already in Use
If port 6333 is already in use:
```bash
# Find what's using the port
netstat -ano | findstr :6333  # Windows
lsof -i :6333                  # Linux/Mac

# Kill the process or change ports in docker-compose.yml
```

### Container Won't Start
```bash
# Check Docker logs
docker-compose logs

# Remove and recreate
docker-compose down
docker-compose up -d
```

### Permission Errors on Storage
```bash
# Linux/Mac: Fix permissions
chmod -R 777 storage/

# Windows: Run Docker Desktop as administrator
```

### Can't Connect from Python
1. Verify Qdrant is running: `curl http://localhost:6333/healthz`
2. Check firewall settings
3. Try using IP instead of localhost: `http://127.0.0.1:6333`

---

## API Examples

### REST API

```bash
# List all collections
curl http://localhost:6333/collections

# Get collection info
curl http://localhost:6333/collections/driving_styles

# Search for similar vectors
curl -X POST http://localhost:6333/collections/driving_styles/points/search \
  -H 'Content-Type: application/json' \
  -d '{
    "vector": [0.1, 0.2, 0.3, ...],
    "limit": 10
  }'
```

### Python Client

```python
from qdrant_client import QdrantClient
from qdrant_client.models import Distance, VectorParams

client = QdrantClient(host="localhost", port=6333)

# List collections
print(client.get_collections())

# Get collection info
info = client.get_collection("driving_styles")
print(f"Points count: {info.points_count}")
print(f"Vectors dimension: {info.config.params.vectors.size}")

# Search
results = client.search(
    collection_name="driving_styles",
    query_vector=[0.1, 0.2, ...],
    limit=10
)
```

---

## Performance Tips

### For Large Datasets (>100k sessions)

1. **Increase memory limit**:
```yaml
# In docker-compose.yml
services:
  qdrant:
    deploy:
      resources:
        limits:
          memory: 4G
```

2. **Use gRPC for faster queries**:
```python
from qdrant_client import QdrantClient

client = QdrantClient(host="localhost", port=6334, prefer_grpc=True)
```

3. **Enable indexing**:
```python
from qdrant_client.models import VectorParams, Distance

client.create_collection(
    collection_name="driving_styles",
    vectors_config=VectorParams(
        size=128,
        distance=Distance.COSINE,
        on_disk=True  # Store vectors on disk for large collections
    )
)
```

---

## Backup and Restore

### Create Snapshot
```bash
# Via API
curl -X POST http://localhost:6333/collections/driving_styles/snapshots

# Download snapshot
curl http://localhost:6333/collections/driving_styles/snapshots/<snapshot_name> \
  --output backup.snapshot
```

### Restore Snapshot
```bash
# Copy snapshot to container
docker cp backup.snapshot twimo_qdrant:/qdrant/storage/

# Restore via API
curl -X PUT http://localhost:6333/collections/driving_styles/snapshots/upload \
  -F 'snapshot=@backup.snapshot'
```

---

## Resources

- **Qdrant Documentation**: https://qdrant.tech/documentation/
- **Docker Compose Docs**: https://docs.docker.com/compose/
- **Python Client**: https://github.com/qdrant/qdrant-client
- **REST API Reference**: https://qdrant.github.io/qdrant/redoc/

---

## Summary

```bash
# Start Qdrant
cd qdrant && docker-compose up -d

# Verify
curl http://localhost:6333/healthz

# Use with TWIMO
python workflows/visualize_driving_styles.py

# View dashboard
open http://localhost:6333/dashboard

# Stop when done
cd qdrant && docker-compose down
```

Your driving style embeddings are now stored in a production-ready vector database! 🚗🗄️
