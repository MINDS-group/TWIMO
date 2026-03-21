from __future__ import annotations

import json
from pathlib import Path
from typing import Any, Dict, Iterable, Iterator, List


def iter_jsonl(path: str | Path) -> Iterator[Dict[str, Any]]:
    p = Path(path)
    with p.open('r', encoding='utf-8') as f:
        for line in f:
            line = line.strip()
            if not line:
                continue
            yield json.loads(line)


def read_jsonl(path: str | Path) -> List[Dict[str, Any]]:
    return list(iter_jsonl(path))


def write_jsonl(path: str | Path, rows: Iterable[Dict[str, Any]]) -> None:
    p = Path(path)
    p.parent.mkdir(parents=True, exist_ok=True)
    with p.open('w', encoding='utf-8') as f:
        for r in rows:
            f.write(json.dumps(r, ensure_ascii=False) + "\n")


def ensure_dir(path: str | Path) -> Path:
    """Create a directory (including parents) if it does not exist, and return it."""
    p = Path(path)
    p.mkdir(parents=True, exist_ok=True)
    return p
