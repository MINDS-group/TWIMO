# TWIMO Domain: Intelligent Mobility

This folder contains the **Intelligent Mobility** domain extension of TWIMO.

It specializes the TWIMO Core to support the engineering of Digital Twins in mobility-related scenarios, with particular attention to vehicles, drivers, environment, infrastructure, traffic context, and driving behaviour.

---

## Purpose

The Intelligent Mobility domain extends the generic TWIMO framework with concepts that are meaningful for mobility systems.

This domain is intended to support scenarios involving:

- mobility-system modeling
- vehicle and driver representation
- environment and infrastructure characterization
- driving behaviour and manoeuvre representation
- safety, regulation, and traffic context
- domain-specific modeling and implementation workflows

---

## Main contents

This folder currently includes:

- `metamodel/`  
  the domain-specific Intelligent Mobility metamodel

- `gui/`  
  the graphical tooling used to create models conforming to the domain metamodel

- `hdd-instance/`  
  a concrete scenario implementation related to the Honda/HDD use case
  
- `rde-instance/`  
  a concrete scenario implementation related to the Real Driver Emission/RDE use case

---

## Relationship with the TWIMO Core

This domain reuses and specializes the abstractions defined in `twimo-core`.

The core provides the framework-level engineering backbone; the Intelligent Mobility domain adds the semantics required to represent mobility systems and their behavioural and environmental context.

This layered structure supports both reuse and traceability:
- the core defines what remains common
- the domain defines what is mobility-specific
- the instance defines what is scenario-specific

---

## Current application scenario

The current repository includes a concrete HDD-oriented application scenario.

This scenario connects:
- the Intelligent Mobility metamodel
- a created domain model
- the implementation code of the scenario

It is the current example showing how TWIMO can be instantiated for an Intelligent Mobility use case.

---

## Why this domain matters

Intelligent Mobility is a strong application domain for TWIMO because it combines:

- heterogeneous system entities
- dynamic environmental context
- behavioural modeling
- data-driven and AI-enabled services
- strong traceability needs between models, code, and evidence

For this reason, it is a meaningful domain to demonstrate the TWIMO approach.