from __future__ import annotations

from dataclasses import asdict
from typing import Dict, List

import numpy as np

from twimo.models.maneuver_transformer import ManeuverConfig, horizon_steps, unique_horizon_steps, make_windows


def _torch_available() -> bool:
    try:
        import torch  # noqa
        return True
    except Exception:
        return False


def train_mlp_pooling_multihead(
    X_train: np.ndarray,
    y_train: np.ndarray,
    X_val: np.ndarray,
    y_val: np.ndarray,
    n_classes: int,
    cfg: ManeuverConfig,
    pooling_type: str = "mean",
    class_weights: np.ndarray | None = None,
):
    """Train an MLP on pooled sequence features with one classification head per horizon.

    Args:
        pooling_type: Type of pooling - "mean", "max", or "concat" (mean+max+first+last)
    """
    if not _torch_available():
        raise RuntimeError("Torch not installed.")

    import torch
    import torch.nn as nn
    from torch.utils.data import DataLoader, TensorDataset

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    steps_list = unique_horizon_steps(cfg)

    # Build windowed datasets
    def build(X, y):
        Xw_list = []
        yw_list = []
        for s in steps_list:
            Xw, yw = make_windows(X, y, steps_ahead=s, window=window)
            if Xw is None:
                raise ValueError("Sequence too short for configured horizons")
            Xw_list.append(Xw)
            yw_list.append(yw)
        # Align N across horizons
        N = min(a.shape[0] for a in Xw_list)
        Xw = Xw_list[0][:N]
        ys = [a[:N] for a in yw_list]
        return Xw, ys

    Xw_tr, ys_tr = build(X_train, y_train)
    Xw_va, ys_va = build(X_val, y_val)

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

    # Model with pooling + MLP
    class MLPPoolingModel(nn.Module):
        def __init__(self, d_in: int, pooling_type: str):
            super().__init__()
            self.pooling_type = pooling_type

            # Calculate pooled feature dimension
            if pooling_type == "mean" or pooling_type == "max":
                pooled_dim = d_in
            elif pooling_type == "concat":
                # mean + max + first + last
                pooled_dim = d_in * 4
            else:
                raise ValueError(f"Unknown pooling_type: {pooling_type}")

            # MLP layers
            self.mlp = nn.Sequential(
                nn.Linear(pooled_dim, cfg.d_model * 2),
                nn.ReLU(),
                nn.Dropout(cfg.dropout),
                nn.Linear(cfg.d_model * 2, cfg.d_model),
                nn.ReLU(),
                nn.Dropout(cfg.dropout),
            )

            self.heads = nn.ModuleList([nn.Linear(cfg.d_model, n_classes) for _ in steps_list])

        def forward(self, x):
            # x: (B, T, D)
            if self.pooling_type == "mean":
                pooled = x.mean(dim=1)  # (B, D)
            elif self.pooling_type == "max":
                pooled = x.max(dim=1)[0]  # (B, D)
            elif self.pooling_type == "concat":
                mean_pool = x.mean(dim=1)  # (B, D)
                max_pool = x.max(dim=1)[0]  # (B, D)
                first = x[:, 0, :]  # (B, D)
                last = x[:, -1, :]  # (B, D)
                pooled = torch.cat([mean_pool, max_pool, first, last], dim=1)  # (B, 4*D)

            h = self.mlp(pooled)  # (B, d_model)
            return [head(h) for head in self.heads]

    m = MLPPoolingModel(d_in=X_train.shape[1], pooling_type=pooling_type).to(device)
    opt = torch.optim.Adam(m.parameters(), lr=cfg.lr)
    if class_weights is not None:
        w = torch.from_numpy(class_weights.astype(np.float32)).to(device)
        loss_fn = nn.CrossEntropyLoss(weight=w)
    else:
        loss_fn = nn.CrossEntropyLoss()

    def make_loader(Xw, ys, shuffle):
        X_t = torch.from_numpy(Xw).float()
        y_t = torch.stack([torch.from_numpy(y) for y in ys], dim=1).long()  # (N, H)
        ds = TensorDataset(X_t, y_t)
        return DataLoader(ds, batch_size=cfg.batch_size, shuffle=shuffle, drop_last=False)

    tr_loader = make_loader(Xw_tr, ys_tr, shuffle=True)
    va_loader = make_loader(Xw_va, ys_va, shuffle=False)

    best = None
    best_acc = -1.0

    print(f"Training MLP with {pooling_type} pooling, hidden_size={cfg.d_model}")

    for epoch in range(1, cfg.epochs + 1):
        m.train()
        for xb, yb in tr_loader:
            xb = xb.to(device)
            yb = yb.to(device)
            logits = m(xb)
            loss = 0.0
            for i, lg in enumerate(logits):
                loss = loss + loss_fn(lg, yb[:, i])
            opt.zero_grad()
            loss.backward()
            opt.step()

        # Eval
        m.eval()
        correct = [0] * len(steps_list)
        total = 0
        with torch.no_grad():
            for xb, yb in va_loader:
                xb = xb.to(device)
                yb = yb.to(device)
                logits = m(xb)
                total += yb.shape[0]
                for i, lg in enumerate(logits):
                    pred = lg.argmax(dim=1)
                    correct[i] += int((pred == yb[:, i]).sum().item())

        accs = [c / total for c in correct]
        mean_acc = float(sum(accs) / len(accs))
        if mean_acc > best_acc:
            best_acc = mean_acc
            best = {
                "state_dict": m.state_dict(),
                "cfg_dict": asdict(cfg),
                "steps": steps_list,
                "n_classes": n_classes,
                "pooling_type": pooling_type,
            }

        print(f"  [epoch {epoch}] val_acc_per_horizon={[f'{a:.4f}' for a in accs]} mean={mean_acc:.4f}")

    assert best is not None
    return best


def predict_mlp_pooling_multihead(best_ckpt, X: np.ndarray, cfg: ManeuverConfig):
    """Predict using trained MLP pooling model."""
    import torch
    import torch.nn as nn

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    steps_list = best_ckpt["steps"]
    n_classes = best_ckpt["n_classes"]
    pooling_type = best_ckpt["pooling_type"]

    class MLPPoolingModel(nn.Module):
        def __init__(self, d_in: int):
            super().__init__()
            self.pooling_type = pooling_type

            if pooling_type == "mean" or pooling_type == "max":
                pooled_dim = d_in
            elif pooling_type == "concat":
                pooled_dim = d_in * 4
            else:
                raise ValueError(f"Unknown pooling_type: {pooling_type}")

            self.mlp = nn.Sequential(
                nn.Linear(pooled_dim, cfg.d_model * 2),
                nn.ReLU(),
                nn.Dropout(cfg.dropout),
                nn.Linear(cfg.d_model * 2, cfg.d_model),
                nn.ReLU(),
                nn.Dropout(cfg.dropout),
            )

            self.heads = nn.ModuleList([nn.Linear(cfg.d_model, n_classes) for _ in steps_list])

        def forward(self, x):
            if self.pooling_type == "mean":
                pooled = x.mean(dim=1)
            elif self.pooling_type == "max":
                pooled = x.max(dim=1)[0]
            elif self.pooling_type == "concat":
                mean_pool = x.mean(dim=1)
                max_pool = x.max(dim=1)[0]
                first = x[:, 0, :]
                last = x[:, -1, :]
                pooled = torch.cat([mean_pool, max_pool, first, last], dim=1)

            h = self.mlp(pooled)
            return [head(h) for head in self.heads]

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    m = MLPPoolingModel(d_in=X.shape[1]).to(device)
    m.load_state_dict(best_ckpt["state_dict"], strict=True)
    m.eval()

    probs = {}
    with torch.no_grad():
        for steps in steps_list:
            Xw, _ = make_windows(X, np.zeros((X.shape[0],), dtype=np.int64), steps_ahead=steps, window=window)
            if Xw is None:
                continue
            X_t = torch.from_numpy(Xw).float().to(device)
            outs = []
            bs = 256
            for i in range(0, X_t.shape[0], bs):
                logits = m(X_t[i:i + bs])[steps_list.index(steps)]
                outs.append(torch.softmax(logits, dim=1).cpu().numpy())
            probs[steps] = np.concatenate(outs, axis=0)

    return probs
