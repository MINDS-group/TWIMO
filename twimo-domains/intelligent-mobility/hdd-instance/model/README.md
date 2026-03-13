# HDD Instance Model

This folder contains the **model instance** created through the Intelligent Mobility graphical editor for the HDD application scenario.

---

## Purpose

The purpose of this folder is to store the model that represents the current Intelligent Mobility scenario at instance level.

This model is expected to conform to the Intelligent Mobility metamodel and to capture the structure of the application scenario in a model-driven way.

---

## What this model represents

The model stored here is the scenario-level instantiation of the domain concepts.

Depending on the actual modeling choices, it may include instantiated elements such as:

- mobility system configuration
- driver-related entities
- vehicle-related entities
- environment and infrastructure context
- behavioural concepts
- scenario-specific relationships and parameters

---

## Role in the repository

This folder is the explicit model artifact that links:

- the domain metamodel
- the graphical modeling activity
- the concrete implementation in `../code`

It is therefore a key traceability artifact.

---

## Why it is important

This model is important because it makes the scenario explicit at modeling level before or alongside implementation.

It supports:
- model-driven traceability
- easier maintenance
- better alignment between conceptual design and code
- future reuse and evolution

---

## Typical usage

A typical workflow is:

1. create or update the model through the GUI
2. store the resulting model artifact here
3. use the model as a reference for the application code
4. evolve the model and implementation consistently over time

---

## Notes

If multiple versions of the scenario are created in the future, this folder can be extended with versioned models or additional instance files.