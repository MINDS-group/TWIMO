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


def train_gru_lstm_multihead(
    X_train: np.ndarray,
    y_train: np.ndarray,
    X_val: np.ndarray,
    y_val: np.ndarray,
    n_classes: int,
    cfg: ManeuverConfig,
    use_gru: bool = True,
    class_weights: np.ndarray | None = None,
):
    """Train a GRU or LSTM encoder with one classification head per horizon.

    Args:
        use_gru: If True, use GRU. If False, use LSTM.
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

    # Model
    class Model(nn.Module):
        def __init__(self, d_in: int, hidden_size: int, num_layers: int, use_gru: bool):
            super().__init__()
            self.use_gru = use_gru
            if use_gru:
                self.rnn = nn.GRU(
                    input_size=d_in,
                    hidden_size=hidden_size,
                    num_layers=num_layers,
                    batch_first=True,
                    dropout=cfg.dropout if num_layers > 1 else 0.0,
                    bidirectional=False,
                )
            else:
                self.rnn = nn.LSTM(
                    input_size=d_in,
                    hidden_size=hidden_size,
                    num_layers=num_layers,
                    batch_first=True,
                    dropout=cfg.dropout if num_layers > 1 else 0.0,
                    bidirectional=False,
                )
            self.heads = nn.ModuleList([nn.Linear(hidden_size, n_classes) for _ in steps_list])

        def forward(self, x):
            # x: (B, T, D)
            if self.use_gru:
                out, h = self.rnn(x)  # out: (B, T, H), h: (num_layers, B, H)
            else:
                out, (h, c) = self.rnn(x)  # out: (B, T, H)

            # Take last timestep output
            last_out = out[:, -1, :]  # (B, H)
            return [head(last_out) for head in self.heads]

    hidden_size = cfg.d_model
    num_layers = cfg.num_layers

    m = Model(d_in=X_train.shape[1], hidden_size=hidden_size, num_layers=num_layers, use_gru=use_gru).to(device)
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

    model_type = "GRU" if use_gru else "LSTM"
    print(f"Training {model_type} model with {num_layers} layers, hidden_size={hidden_size}")

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
                "use_gru": use_gru,
                "hidden_size": hidden_size,
                "num_layers": num_layers,
            }

        print(f"  [epoch {epoch}] val_acc_per_horizon={[f'{a:.4f}' for a in accs]} mean={mean_acc:.4f}")

    assert best is not None
    return best


def predict_gru_lstm_multihead(best_ckpt, X: np.ndarray, cfg: ManeuverConfig):
    """Predict using trained GRU/LSTM model."""
    import torch
    import torch.nn as nn

    window = int(np.ceil(cfg.window_seconds * cfg.sample_hz))
    steps_list = best_ckpt["steps"]
    n_classes = best_ckpt["n_classes"]
    use_gru = best_ckpt["use_gru"]
    hidden_size = best_ckpt["hidden_size"]
    num_layers = best_ckpt["num_layers"]

    class Model(nn.Module):
        def __init__(self, d_in: int):
            super().__init__()
            self.use_gru = use_gru
            if use_gru:
                self.rnn = nn.GRU(
                    input_size=d_in,
                    hidden_size=hidden_size,
                    num_layers=num_layers,
                    batch_first=True,
                    dropout=cfg.dropout if num_layers > 1 else 0.0,
                    bidirectional=False,
                )
            else:
                self.rnn = nn.LSTM(
                    input_size=d_in,
                    hidden_size=hidden_size,
                    num_layers=num_layers,
                    batch_first=True,
                    dropout=cfg.dropout if num_layers > 1 else 0.0,
                    bidirectional=False,
                )
            self.heads = nn.ModuleList([nn.Linear(hidden_size, n_classes) for _ in steps_list])

        def forward(self, x):
            if self.use_gru:
                out, h = self.rnn(x)
            else:
                out, (h, c) = self.rnn(x)
            last_out = out[:, -1, :]
            return [head(last_out) for head in self.heads]

    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    m = Model(d_in=X.shape[1]).to(device)
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
