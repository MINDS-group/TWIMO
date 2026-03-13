# Intelligent Mobility Metamodel

This folder contains the **domain-specific metamodel** for Intelligent Mobility.

The metamodel extends the TWIMO Core and introduces the concepts needed to model mobility-oriented Digital Twin scenarios.

---

## Purpose

The purpose of this metamodel is to provide a structured modeling language for Intelligent Mobility applications within TWIMO.

It specializes the framework so that mobility scenarios can be represented explicitly through domain concepts such as:

- mobility systems
- drivers
- vehicles
- environment conditions
- infrastructure
- traffic situations
- behaviours and manoeuvres
- regulations and safety constraints
- exceptional events and contextual conditions

---

## Interpreting the metamodel

From the current diagram, the Intelligent Mobility metamodel is centered on the concept of a **Mobility System**, which acts as a domain-level aggregation point for the main elements of the scenario.

The metamodel organizes Intelligent Mobility around several major conceptual areas.

### 1. Mobility system and system context
The model includes a `MobilitySystem` concept that connects the main contextual dimensions of a mobility scenario, such as:

- driver profile
- vehicle configuration
- environment background
- environment conditions
- infrastructure

This suggests that the domain is designed not around isolated entities, but around a system-level view of mobility.

### 2. Driver and behaviour modeling
A substantial part of the metamodel focuses on the driver and on driving behaviour.

Key concepts visible in the model include:

- `Driver_Profile`
- `Driver_Emotion`
- `Driver_Level`
- `Driver_Preference`
- `Driving_Behaviour`

The behaviour part is refined through more specific concepts such as:

- `Normal_Behaviour`
- `Abnormal_Behaviour`
- `CooperativeBehavior`
- `Following`
- `Forward`
- `Backward`
- `Turn`
- `LaneChanging`
- `GapAcceptance`
- `Action`
- `Goal`

This indicates that the metamodel explicitly supports behavioural and manoeuvre-oriented representations, which are central for Intelligent Mobility Digital Twins.

### 3. Vehicle modeling
The vehicle side includes concepts such as:

- `Vehicle_Configuration`
- `Vehicle_Type`
- specialized vehicle notions such as `Platoon`, `Leading_Vehicle`, and `Following_Vehicle`

This part of the metamodel captures the static and dynamic representation of vehicles and their role in mobility interactions.

### 4. Environment and infrastructure
The metamodel also models the surrounding context in which the mobility system operates.

Relevant concepts include:

- `Environment_Background`
- `Environment_Condition`
- `Weather`
- `Traffic_Situation`
- `Special_Condition`
- `Intersection`
- `Collision`
- `Obstruction`
- `Regulation`
- `Safety_Requirement`
- `Infrastructure`
- `RoadSegment`
- `Road_Side_Unit`
- `ChargingStation`
- `SmartSensor`
- `CommunicationInterface`

This indicates that the Intelligent Mobility model is not limited to the driver-vehicle pair; it includes the wider physical and digital environment in which mobility actions take place.

### 5. Semantic typing through enumerations
The metamodel also uses domain enumerations for concepts such as:

- driver type
- lane type
- direction
- car type
- road shape
- road type
- traffic type
- protocol type

These enumerations help constrain values and keep the models semantically coherent.

---

## Metamodel role in the repository

This metamodel is the domain-specific semantic layer used by:

- the graphical modeling environment
- the creation of Intelligent Mobility models
- the HDD application scenario
- future Intelligent Mobility instances

It bridges the generic TWIMO framework and the concrete mobility-oriented implementation.

---

## Intended use

A typical usage flow is:

1. define the Intelligent Mobility concepts through this metamodel
2. create conforming models with the provided GUI
3. use those models as the basis for scenario-specific implementations
4. connect the model with application code and validation artifacts

---

## Notes

This metamodel should evolve consistently with the TWIMO Core.

Changes here should preserve:
- alignment with the framework abstractions
- domain coherence
- clear semantics for mobility entities and behaviours
- compatibility with existing models when possible