
# TWIMO Core

This folder contains the **domain-independent core** of the TWIMO framework.

The TWIMO Core provides the foundational metamodel abstractions used to engineer Digital Twins in a systematic and reusable way, independently of any specific application domain.

---

## Purpose

The purpose of the TWIMO Core is to define the generic engineering backbone on top of which domain-specific Digital Twin solutions can be built.

It captures reusable concepts that remain stable across domains and that can later be specialized in domain extensions such as Intelligent Mobility.

The core is intended to support:

- common conceptual foundations
- structural consistency across domains
- reuse of engineering abstractions
- traceability between models, services, and artifacts
- long-term extensibility of the framework

---

## What is contained here

This folder hosts the core elements of the framework, in particular the **TWIMO metamodel** and related assets required to define the generic concepts of the framework.

Typical contents include:

- generic metamodel definitions
- domain-independent entities and relations
- reusable framework abstractions
- supporting artifacts for the evolution of the core model

---

## Role of the core in the repository

The TWIMO Core is the shared foundation used by all domain extensions.

It should not contain domain-specific concepts such as mobility-only entities, application-specific labels, or scenario-specific implementations. Those belong in `twimo.domains`.

The core is designed to remain reusable even when new domains are added.

---

## Design principles

The TWIMO Core follows these principles:

### Domain independence
The core captures generic concepts that are meaningful across multiple Digital Twin domains.

### Separation of concerns
Framework-level abstractions are kept separate from domain semantics and instance-level implementations.

### Extensibility
The core is intentionally designed to be extended by domain metamodels without requiring intrusive changes.

### Traceability
The core acts as the stable conceptual anchor that links domains, models, and implementations.

---

## Main subfolder

- `metamodel/`  
  Contains the core TWIMO metamodel and related definitions.

See the local README inside that folder for more details.