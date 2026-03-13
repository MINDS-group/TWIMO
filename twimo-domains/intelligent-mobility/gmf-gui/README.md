# Intelligent Mobility GUI

This folder contains the graphical tooling used to create and edit models conforming to the Intelligent Mobility metamodel.

---

## Purpose

The purpose of this folder is to provide the user-facing modeling environment for the Intelligent Mobility domain.

Through this graphical interface, users can create domain models without manipulating the metamodel only at code level.

The GUI is intended to support:

- model creation
- model editing
- domain-conformant modeling
- easier interaction with the Intelligent Mobility concepts
- faster construction of scenario models

---

## What is expected here

This folder may include:

- graphical editor definitions
- GMF / Eclipse-based tooling artifacts
- configuration files for the modeling environment
- generated editor components
- supporting resources for model visualization and interaction

---

## Relationship with the metamodel

The GUI depends on the Intelligent Mobility metamodel.

Its role is not to redefine domain concepts, but to provide a usable interface for instantiating them in concrete models.

In other words:

- the **metamodel** defines the language
- the **GUI** provides the editor for using that language

---

## Role in the repository

This folder is the bridge between conceptual modeling and concrete model creation.

It supports the generation of instance models that can later be connected with scenario implementations such as the HDD-based example included in this repository.

---

## Typical workflow

A typical workflow is:

1. open the modeling environment
2. create a model conforming to the Intelligent Mobility metamodel
3. save the resulting instance
4. use that instance as the basis for the concrete application scenario

---

## Notes

The exact technical content of this folder depends on the chosen modeling stack and tooling generation process.

If the folder contains generated artifacts, they should be kept aligned with the current version of the metamodel.