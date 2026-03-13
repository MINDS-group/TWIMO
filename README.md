# TWIMO

TWIMO is a model-driven framework for **Digital Twin Engineering (DTE)** with a current application to the **Intelligent Mobility** domain.

This repository is organized as a reusable engineering package that separates:

- a **domain-independent core metamodel** (`twimo-core`)
- one or more **domain-specific extensions** (`twimo.domains`)
- concrete **application scenarios and implementations**
- executable artifacts, models, and supporting code for validation and experimentation

The repository supports the engineering vision behind the TWIMO framework presented in the accompanying paper: a structured, reusable, and traceable approach for designing Digital Twins through metamodels, domain specialization, synchronized data backbones, and AI-based services.

---

## Repository purpose

The main objective of this repository is to support an **industrializable and verifiable Digital Twin Engineering workflow**.

TWIMO is designed to support:

- **reproducibility**, by keeping models, code, scenarios, and evidence organized
- **reusability**, by separating generic framework concepts from domain-specific concepts
- **traceability**, by making explicit the relationships between metamodels, models, code, and scenario implementations
- **auditability**, by structuring the repository as a replication-ready engineering package
- **extensibility**, by enabling new domains to be added without changing the framework core

At the current stage, the repository includes an application to **Intelligent Mobility**, with a concrete implementation related to the **Honda/HDD driving-behaviour scenario**.

---

## High-level repository structure

```text
TWIMO/
├── twimo-core/
│   └── metamodel/
├── twimo.domains/
│   └── intelligent-mobility/
│       ├── metamodel/
│       ├── gui/
│       ├── hdd-instance/
│       │   ├── model/
│       │   └── code/
│       └── rde-instance/
│           ├── model/
│           └── code/
└── README.md