# HDD Instance

This folder contains a concrete **Intelligent Mobility application scenario** based on the Honda/HDD context.

It is the current instance-level realization of the TWIMO framework in this repository.

---

## Purpose

The purpose of this folder is to connect:

- the TWIMO Core
- the Intelligent Mobility domain metamodel
- a concrete created model
- the implementation code of the scenario

This is the most application-specific part of the repository.

---

## Scenario role

The HDD instance acts as a concrete demonstration of how the framework can be instantiated for a real Intelligent Mobility case.

In the context of the associated paper, this scenario is used to show how a model-driven engineering structure can support a Digital Twin workflow for mobility-related behavioural analysis.

---

## Main contents

This folder currently includes:

- `model/`  
  the model instance created through the Intelligent Mobility graphical tooling

- `code/`  
  the implementation of the scenario

Together, these two subfolders connect modeling and execution.

---

## Why this folder matters

This folder demonstrates the transition from:

- abstract framework concepts
- to domain concepts
- to a concrete application scenario

It therefore provides an example of TWIMO in practice.

---

## Typical usage

A typical usage flow is:

1. inspect the model in `model/`
2. inspect the implementation in `code/`
3. understand how the scenario operationalizes the Intelligent Mobility concepts
4. use the structure as a basis for replication, extension, or alternative scenarios

---

## Notes

This folder should remain aligned with:
- the Intelligent Mobility metamodel
- the created model instance
- the assumptions encoded in the application code

If the scenario evolves, changes in models and code should remain traceable.