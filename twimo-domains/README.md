# TWIMO Domains

This folder contains the **domain-specific extensions** of the TWIMO framework.

Each subfolder specializes the TWIMO Core for a particular application domain by introducing domain concepts, domain constraints, and dedicated tooling or instances.

---

## Purpose

The goal of `twimo.domains` is to make TWIMO usable in concrete application areas while preserving a clean separation between:

- the generic framework backbone (`twimo-core`)
- the domain semantics
- the concrete scenario implementations

This enables TWIMO to remain reusable and extensible across multiple Digital Twin domains.

---

## Current domain

At present, the repository contains the following domain:

- `intelligent-mobility`

This domain specializes TWIMO for Intelligent Mobility scenarios.

---

## General structure of a domain extension

A typical domain folder can include:

- a **metamodel**  
  the domain-specific conceptual extension of the TWIMO Core

- a **graphical editor / GUI**  
  tooling to create models conforming to the domain metamodel

- one or more **instance folders**  
  concrete scenario realizations, created models, and implementation code

---

## Design principles

Each domain extension should:

- be compatible with the TWIMO Core
- introduce only domain-specific concepts
- remain modular and self-contained
- keep a clear distinction between metamodel, models, and code
- support future instance-level extensions

---

## Current subfolder

- `intelligent-mobility/`  
  The current TWIMO domain for mobility-oriented Digital Twin Engineering.

See the local README in that folder for more details.