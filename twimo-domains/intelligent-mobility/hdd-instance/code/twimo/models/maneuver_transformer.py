from __future__ import annotations

from dataclasses import dataclass, asdict
from typing import List

import numpy as np


@dataclass
class ManeuverConfig:
    window_seconds: float = 3.0
    sample_hz: float = 3.0
    horizons_seconds: List[float] = None  # e.g. [0.1,0.25,0.5,0.75,1,2,3,4,5]
    d_model: int = 128
    nhead: int = 4
    num_layers: int = 3
    dropout: float = 0.1
    batch_size: int = 64
    epochs: int = 8
    lr: float = 1e-3

    def __post_init__(self):
        if self.horizons_seconds is None:
            self.horizons_seconds = default_horizons(self.sample_hz)


def default_horizons(sample_hz: float, max_seconds: float = 5.0) -> List[float]:
    """Compute prediction horizons aligned to the sensor sampling rate.

    Sub-second: one horizon per step (step_size = 1/sample_hz), while
    step * step_size < 1.0.
    From 1s onwards: one horizon per second up to max_seconds.

    Examples
    --------
    3 Hz  → [0.333, 0.667, 1.0, 2.0, 3.0, 4.0, 5.0]
    10 Hz → [0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 2.0, 3.0, 4.0, 5.0]
    """
    step_size = 1.0 / sample_hz
    horizons: List[float] = []
    s = 1
    while round(s * step_size, 9) < 1.0:
        horizons.append(round(s * step_size, 6))
        s += 1
    t = 1.0
    while t <= max_seconds + 1e-9:
        horizons.append(round(t, 6))
        t += 1.0
    return horizons


def _torch_available() -> bool:
    try:
        import torch  # noqa
        return True
    except Exception:
        return False


def horizon_steps(cfg: ManeuverConfig) -> List[int]:
    # Convert to steps at cfg.sample_hz (round, min 1).
    # Using round() instead of ceil() avoids floating-point overcounting:
    # e.g. at 3 Hz, 2/3 s = 0.666667 → 0.666667*3 = 2.000001 → ceil=3 (wrong),
    # but round(2.000001) = 2 (correct step 2).
    steps = []
    for h in cfg.horizons_seconds:
        s = int(np.round(h * cfg.sample_hz))
        steps.append(max(1, s))
    return steps


def unique_horizon_steps(cfg: ManeuverConfig) -> List[int]:
    """Return deduplicated horizon steps (preserving order).

    At low sample rates, multiple horizons_seconds can map to the same step
    (e.g., 0.1s and 0.25s both → step 1 at 3Hz). This avoids training
    duplicate models/heads for the same step.
    """
    seen = set()
    unique = []
    for s in horizon_steps(cfg):
        if s not in seen:
            seen.add(s)
            unique.append(s)
    return unique


def make_windows(X: np.ndarray, y: np.ndarray, steps_ahead: int, window: int):
    """Create sliding windows.

    X: (T, D)
    y: (T,) int labels
    steps_ahead: predict y[t+steps_ahead]
    window: number of past steps to condition on

    Returns (Xw, yw)
      Xw: (N, window, D)
      yw: (N,)
    """
    T = X.shape[0]
    end = T - steps_ahead
    if end <= window:
        return None, None
    Xw = []
    yw = []
    for t in range(window, end):
        Xw.append(X[t-window:t])
        yw.append(y[t + steps_ahead])
    return np.stack(Xw, axis=0), np.array(yw, dtype=np.int64)


def train_transformer_multihead(
    X_train: np.ndarray,
    y_train: np.ndarray,
    X_val: np.ndarray,
    y_val: np.ndarray,
    n_classes: int,
    cfg: ManeuverConfig,
    class_weights: np.ndarray | None = None,
):
    """Train a Transformer encoder with one classification head per horizon."""
    if not _torch_available():
        raise RuntimeError("Torch not installed.")

    import torch
    import torch.nn as nn
    from torch.utils.data import DataLoader, TensorDataset

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    steps_list = unique_horizon_steps(cfg)

    # Build windowed datasets (concatenate horizons by keeping same X windows, multiple y)
    def build(X, y):
        Xw_list = []
        yw_list = []
        for s in steps_list:
            Xw, yw = make_windows(X, y, steps_ahead=s, window=window)
            if Xw is None:
                raise ValueError("Sequence too short for configured horizons")
            Xw_list.append(Xw)
            yw_list.append(yw)
        # Align N across horizons (take min)
        N = min(a.shape[0] for a in Xw_list)
        Xw = Xw_list[0][:N]
        ys = [a[:N] for a in yw_list]
        return Xw, ys

    Xw_tr, ys_tr = build(X_train, y_train)
    Xw_va, ys_va = build(X_val, y_val)

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

    # Model
    class Model(nn.Module):
        def __init__(self, d_in: int):
            super().__init__()
            self.proj = nn.Linear(d_in, cfg.d_model)
            enc_layer = nn.TransformerEncoderLayer(
                d_model=cfg.d_model,
                nhead=cfg.nhead,
                dim_feedforward=cfg.d_model*4,
                dropout=cfg.dropout,
                batch_first=True,
            )
            self.enc = nn.TransformerEncoder(enc_layer, num_layers=cfg.num_layers)
            self.pool = nn.AdaptiveAvgPool1d(1)
            self.heads = nn.ModuleList([nn.Linear(cfg.d_model, n_classes) for _ in steps_list])

        def forward(self, x):
            x = self.proj(x)
            h = self.enc(x)  # (B,T,D)
            # pool over time
            h = h.transpose(1,2)  # (B,D,T)
            h = self.pool(h).squeeze(-1)  # (B,D)
            return [head(h) for head in self.heads]

    m = Model(d_in=X_train.shape[1]).to(device)
    opt = torch.optim.Adam(m.parameters(), lr=cfg.lr)
    if class_weights is not None:
        w = torch.from_numpy(class_weights.astype(np.float32)).to(device)
        loss_fn = nn.CrossEntropyLoss(weight=w)
    else:
        loss_fn = nn.CrossEntropyLoss()

    def make_loader(Xw, ys, shuffle):
        X_t = torch.from_numpy(Xw).float()
        y_t = torch.stack([torch.from_numpy(y) for y in ys], dim=1).long()  # (N,H)
        ds = TensorDataset(X_t, y_t)
        return DataLoader(ds, batch_size=cfg.batch_size, shuffle=shuffle, drop_last=False)

    tr_loader = make_loader(Xw_tr, ys_tr, shuffle=True)
    va_loader = make_loader(Xw_va, ys_va, shuffle=False)

    best = None
    best_acc = -1.0

    for epoch in range(1, cfg.epochs+1):
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
            torch.nn.utils.clip_grad_norm_(m.parameters(), max_norm=1.0)
            opt.step()

        # Eval
        m.eval()
        correct = [0]*len(steps_list)
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

        accs = [c/total for c in correct]
        mean_acc = float(sum(accs)/len(accs))
        if mean_acc > best_acc:
            best_acc = mean_acc
            best = {"state_dict": m.state_dict(), "cfg_dict": asdict(cfg), "steps": steps_list, "n_classes": n_classes}

        print(f"[epoch {epoch}] val_acc_per_horizon={accs} mean={mean_acc:.3f}")

    assert best is not None
    return best


def predict_transformer_multihead(best_ckpt, X: np.ndarray, cfg: ManeuverConfig):
    import torch
    import torch.nn as nn

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    steps_list = best_ckpt["steps"]
    n_classes = best_ckpt["n_classes"]

    class Model(nn.Module):
        def __init__(self, d_in: int):
            super().__init__()
            self.proj = nn.Linear(d_in, cfg.d_model)
            enc_layer = nn.TransformerEncoderLayer(
                d_model=cfg.d_model,
                nhead=cfg.nhead,
                dim_feedforward=cfg.d_model*4,
                dropout=cfg.dropout,
                batch_first=True,
            )
            self.enc = nn.TransformerEncoder(enc_layer, num_layers=cfg.num_layers)
            self.pool = nn.AdaptiveAvgPool1d(1)
            self.heads = nn.ModuleList([nn.Linear(cfg.d_model, n_classes) for _ in steps_list])

        def forward(self, x):
            x = self.proj(x)
            h = self.enc(x)
            h = h.transpose(1,2)
            h = self.pool(h).squeeze(-1)
            return [head(h) for head in self.heads]

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    m = Model(d_in=X.shape[1]).to(device)
    m.load_state_dict(best_ckpt["state_dict"], strict=True)
    m.eval()

    # Make windows once for each horizon: we return probabilities aligned to the last window index
    probs = {}
    with torch.no_grad():
        for steps in steps_list:
            Xw, _ = make_windows(X, np.zeros((X.shape[0],), dtype=np.int64), steps_ahead=steps, window=window)
            if Xw is None:
                continue
            X_t = torch.from_numpy(Xw).float().to(device)
            # forward, pick correct head
            outs = []
            bs = 256
            for i in range(0, X_t.shape[0], bs):
                logits = m(X_t[i:i+bs])[steps_list.index(steps)]
                outs.append(torch.softmax(logits, dim=1).cpu().numpy())
            probs[steps] = np.concatenate(outs, axis=0)

    return probs
