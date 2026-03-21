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


def train_tcn_multihead(
    X_train: np.ndarray,
    y_train: np.ndarray,
    X_val: np.ndarray,
    y_val: np.ndarray,
    n_classes: int,
    cfg: ManeuverConfig,
    class_weights: np.ndarray | None = None,
):
    """Train a Temporal Convolutional Network (TCN) with one classification head per horizon.

    TCN uses dilated causal convolutions to capture long-range temporal dependencies.
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

    # TCN Block with causal dilated convolutions
    class TemporalBlock(nn.Module):
        def __init__(self, n_inputs, n_outputs, kernel_size, dilation, dropout=0.1):
            super().__init__()
            padding = (kernel_size - 1) * dilation
            self.conv1 = nn.Conv1d(n_inputs, n_outputs, kernel_size,
                                   padding=padding, dilation=dilation)
            self.chomp1 = nn.ConstantPad1d((0, -padding), 0.0)  # Causal: remove future
            self.relu1 = nn.ReLU()
            self.dropout1 = nn.Dropout(dropout)

            self.conv2 = nn.Conv1d(n_outputs, n_outputs, kernel_size,
                                   padding=padding, dilation=dilation)
            self.chomp2 = nn.ConstantPad1d((0, -padding), 0.0)
            self.relu2 = nn.ReLU()
            self.dropout2 = nn.Dropout(dropout)

            self.downsample = nn.Conv1d(n_inputs, n_outputs, 1) if n_inputs != n_outputs else None
            self.relu = nn.ReLU()

        def forward(self, x):
            # x: (B, C, T)
            out = self.conv1(x)
            out = out[:, :, :x.shape[2]]  # Causal truncation
            out = self.relu1(out)
            out = self.dropout1(out)

            out = self.conv2(out)
            out = out[:, :, :x.shape[2]]  # Causal truncation
            out = self.relu2(out)
            out = self.dropout2(out)

            res = x if self.downsample is None else self.downsample(x)
            return self.relu(out + res)

    # TCN Model
    class TCNModel(nn.Module):
        def __init__(self, d_in: int, num_channels: List[int], kernel_size: int = 3, dropout: float = 0.1):
            super().__init__()
            layers = []
            num_levels = len(num_channels)
            for i in range(num_levels):
                dilation = 2 ** i
                in_ch = d_in if i == 0 else num_channels[i - 1]
                out_ch = num_channels[i]
                layers.append(TemporalBlock(in_ch, out_ch, kernel_size, dilation, dropout))

            self.network = nn.Sequential(*layers)
            self.heads = nn.ModuleList([nn.Linear(num_channels[-1], n_classes) for _ in steps_list])

        def forward(self, x):
            # x: (B, T, D) -> (B, D, T) for Conv1d
            x = x.transpose(1, 2)
            out = self.network(x)  # (B, C, T)
            # Global average pooling over time
            out = out.mean(dim=2)  # (B, C)
            return [head(out) for head in self.heads]

    # TCN configuration: increasing channels with depth
    num_channels = [cfg.d_model] * cfg.num_layers

    m = TCNModel(d_in=X_train.shape[1], num_channels=num_channels,
                 kernel_size=3, dropout=cfg.dropout).to(device)
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

    print(f"Training TCN with {cfg.num_layers} levels, {cfg.d_model} channels per level")

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
                "num_channels": num_channels,
            }

        print(f"  [epoch {epoch}] val_acc_per_horizon={[f'{a:.4f}' for a in accs]} mean={mean_acc:.4f}")

    assert best is not None
    return best


def predict_tcn_multihead(best_ckpt, X: np.ndarray, cfg: ManeuverConfig):
    """Predict using trained TCN model."""
    import torch
    import torch.nn as nn

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    steps_list = best_ckpt["steps"]
    n_classes = best_ckpt["n_classes"]
    num_channels = best_ckpt["num_channels"]

    class TemporalBlock(nn.Module):
        def __init__(self, n_inputs, n_outputs, kernel_size, dilation, dropout=0.1):
            super().__init__()
            padding = (kernel_size - 1) * dilation
            self.conv1 = nn.Conv1d(n_inputs, n_outputs, kernel_size,
                                   padding=padding, dilation=dilation)
            self.chomp1 = nn.ConstantPad1d((0, -padding), 0.0)
            self.relu1 = nn.ReLU()
            self.dropout1 = nn.Dropout(dropout)

            self.conv2 = nn.Conv1d(n_outputs, n_outputs, kernel_size,
                                   padding=padding, dilation=dilation)
            self.chomp2 = nn.ConstantPad1d((0, -padding), 0.0)
            self.relu2 = nn.ReLU()
            self.dropout2 = nn.Dropout(dropout)

            self.downsample = nn.Conv1d(n_inputs, n_outputs, 1) if n_inputs != n_outputs else None
            self.relu = nn.ReLU()

        def forward(self, x):
            out = self.conv1(x)
            out = out[:, :, :x.shape[2]]
            out = self.relu1(out)
            out = self.dropout1(out)

            out = self.conv2(out)
            out = out[:, :, :x.shape[2]]
            out = self.relu2(out)
            out = self.dropout2(out)

            res = x if self.downsample is None else self.downsample(x)
            return self.relu(out + res)

    class TCNModel(nn.Module):
        def __init__(self, d_in: int):
            super().__init__()
            layers = []
            num_levels = len(num_channels)
            for i in range(num_levels):
                dilation = 2 ** i
                in_ch = d_in if i == 0 else num_channels[i - 1]
                out_ch = num_channels[i]
                layers.append(TemporalBlock(in_ch, out_ch, 3, dilation, cfg.dropout))

            self.network = nn.Sequential(*layers)
            self.heads = nn.ModuleList([nn.Linear(num_channels[-1], n_classes) for _ in steps_list])

        def forward(self, x):
            x = x.transpose(1, 2)
            out = self.network(x)
            out = out.mean(dim=2)
            return [head(out) for head in self.heads]

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    m = TCNModel(d_in=X.shape[1]).to(device)
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
