from __future__ import annotations

from dataclasses import dataclass
from typing import Dict, List, Tuple

import numpy as np
import torch
import torch.nn as nn
from torch.utils.data import DataLoader, Dataset
from tqdm import tqdm


@dataclass
class TrainConfig:
    lr: float = 3e-4
    batch_size: int = 16
    epochs: int = 10
    device: str = "cuda" if torch.cuda.is_available() else "cpu"


class WindowedSequenceDataset(Dataset):
    def __init__(self, X: np.ndarray, y: np.ndarray, window: int, horizons: List[int]):
        assert len(X) == len(y)
        self.X = X.astype(np.float32)
        self.y = y.astype(np.int64)
        self.window = int(window)
        self.horizons = [int(h) for h in horizons]
        # valid indices where all horizons are in range
        self.valid_idx = np.arange(self.window, len(y) - max(self.horizons), dtype=np.int64)

    def __len__(self) -> int:
        return len(self.valid_idx)

    def __getitem__(self, i: int) -> Tuple[np.ndarray, np.ndarray]:
        t = int(self.valid_idx[i])
        xw = self.X[t - self.window : t]  # (W, D)
        # multi-horizon targets for the NEXT step(s)
        ys = np.array([self.y[t + h] for h in self.horizons], dtype=np.int64)
        return xw, ys


def train_multihorizon(
    model: nn.Module,
    train_ds: Dataset,
    val_ds: Dataset,
    cfg: TrainConfig,
) -> Dict[str, float]:
    device = torch.device(cfg.device)
    model.to(device)

    train_loader = DataLoader(train_ds, batch_size=cfg.batch_size, shuffle=True, drop_last=True)
    val_loader = DataLoader(val_ds, batch_size=cfg.batch_size, shuffle=False, drop_last=False)

    opt = torch.optim.AdamW(model.parameters(), lr=cfg.lr)
    loss_fn = nn.CrossEntropyLoss()

    best_val = 0.0

    for epoch in range(cfg.epochs):
        model.train()
        pbar = tqdm(train_loader, desc=f"train epoch {epoch+1}/{cfg.epochs}")
        for xb, yb in pbar:
            xb = xb.to(device)
            yb = yb.to(device)  # (B, H)

            logits = model(xb)  # (B, W, C)
            last = logits[:, -1, :]  # predict from the last token

            # average loss across horizons by reusing the same head
            loss = 0.0
            for h in range(yb.shape[1]):
                loss = loss + loss_fn(last, yb[:, h])
            loss = loss / float(yb.shape[1])

            opt.zero_grad()
            loss.backward()
            nn.utils.clip_grad_norm_(model.parameters(), 1.0)
            opt.step()

            pbar.set_postfix({"loss": float(loss.detach().cpu())})

        # val
        model.eval()
        correct = 0
        total = 0
        with torch.no_grad():
            for xb, yb in val_loader:
                xb = xb.to(device)
                yb = yb.to(device)
                logits = model(xb)
                pred = logits[:, -1, :].argmax(dim=-1)
                # evaluate on the 1st horizon by default
                correct += int((pred == yb[:, 0]).sum().cpu())
                total += int(len(pred))
        val_acc = correct / max(total, 1)
        best_val = max(best_val, val_acc)

    return {"val_acc_h1": float(best_val)}
