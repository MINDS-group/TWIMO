from __future__ import annotations

import math
from dataclasses import dataclass

import torch
import torch.nn as nn


class PositionalEncoding(nn.Module):
    def __init__(self, d_model: int, dropout: float = 0.1, max_len: int = 2048):
        super().__init__()
        self.dropout = nn.Dropout(p=dropout)

        pe = torch.zeros(max_len, d_model)
        position = torch.arange(0, max_len, dtype=torch.float).unsqueeze(1)
        div_term = torch.exp(torch.arange(0, d_model, 2).float() * (-math.log(10000.0) / d_model))
        pe[:, 0::2] = torch.sin(position * div_term)
        pe[:, 1::2] = torch.cos(position * div_term)
        pe = pe.unsqueeze(0)  # (1, max_len, d_model)
        self.register_buffer("pe", pe)

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        # x: (B, T, D)
        x = x + self.pe[:, : x.size(1)]
        return self.dropout(x)


@dataclass
class SeqModelConfig:
    input_dim: int
    n_classes: int
    d_model: int = 256
    n_heads: int = 4
    n_layers: int = 3
    dropout: float = 0.1


class TransformerSequenceClassifier(nn.Module):
    """Encoder-only Transformer producing a single logit vector per time step."""

    def __init__(self, cfg: SeqModelConfig):
        super().__init__()
        self.proj = nn.Linear(cfg.input_dim, cfg.d_model)
        self.pos = PositionalEncoding(cfg.d_model, dropout=cfg.dropout)
        encoder_layer = nn.TransformerEncoderLayer(
            d_model=cfg.d_model,
            nhead=cfg.n_heads,
            dim_feedforward=cfg.d_model * 4,
            dropout=cfg.dropout,
            batch_first=True,
            activation="gelu",
        )
        self.encoder = nn.TransformerEncoder(encoder_layer, num_layers=cfg.n_layers)
        self.head = nn.Linear(cfg.d_model, cfg.n_classes)

    def forward(self, x: torch.Tensor) -> torch.Tensor:
        # x: (B, T, D)
        h = self.proj(x)
        h = self.pos(h)
        h = self.encoder(h)
        logits = self.head(h)  # (B, T, C)
        return logits
