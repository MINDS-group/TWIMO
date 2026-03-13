# TWIMO Core Metamodel

This folder contains the **core metamodel** of TWIMO.

The core metamodel defines the generic concepts of the framework and acts as the conceptual foundation for all TWIMO domain specializations.

---

## Purpose

The purpose of the core metamodel is to provide a reusable and domain-independent language for Digital Twin Engineering.

It defines the classes, relations, and abstractions that structure the framework before any domain specialization is introduced.

This layer is intended to answer questions such as:

- what are the core elements of a TWIMO-based Digital Twin Engineering process?
- which engineering concepts are common across domains?
- how can domain-specific metamodels extend a shared conceptual backbone?

---

## Interpreting the TWIMO Core metamodel

Based on the current core metamodel, the TWIMO framework is organized around a set of high-level concepts that support the engineering of Digital Twin systems.

The metamodel includes, at a framework level, concepts related to:

- the **Digital Twin Engineering process**
- the distinction between **digital and physical elements**
- **resources**, **actors**, and **constraints**
- **AI-enabled services**
- **data-oriented and knowledge-oriented elements**
- **models**, **datasets**, **annotations**, and **evidence-related concepts**
- service-oriented capabilities such as **perception**, **prediction**, **evaluation**, **planning**, and **explainability**
- modular support for different domain extensions

In other words, the core metamodel acts as the generic engineering substrate on top of which a domain can define its own semantics.

---

## Core metamodel role in TWIMO

Within the repository, this metamodel provides the stable backbone for:

- extending TWIMO toward specific domains
- connecting modeling activities with implementation activities
- keeping a consistent structure across different Digital Twin applications
- supporting reuse and evolution over time

The core does not model a particular domain directly. Instead, it defines the generic structures that domain metamodels can reuse and refine.

---

## Expected usage

A typical usage flow is:

1. use the TWIMO Core metamodel as the common conceptual basis
2. define a domain specialization in `twimo.domains`
3. create domain-specific models using the specialized concepts
4. connect those models with concrete code and scenario implementations

---

## Notes for maintainers

When evolving this metamodel, try to preserve:

- backward compatibility where possible
- clear separation from domain-specific elements
- conceptual stability of the main framework abstractions
- explicit extension points for future domains