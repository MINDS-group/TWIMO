# TWIMO Intelligent Mobility - RDE Instance

This folder contains the **RDE (Real Driving Emission) application instance** of TWIMO within the **Intelligent Mobility** domain.

In this project, **TWIMO is applied to the RDE test procedure in AVL's virtual environment** with the goal of improving the fidelity of the human driver behaviour model through a **data-driven prediction approach**. The overall objective is to support the simulation of **human-like driving behaviour on arbitrary test routes and under different traffic conditions**, so that RDE-related testing and analysis can be performed more effectively in virtual environments.

The instance combines:

- a **modeling layer**, used to describe the relevant driver, vehicle, and environment concepts;
- a **data layer**, based on recorded RDE driving traces;
- an **implementation layer**, where different machine learning experiments are used to predict driver behaviour from route- and traffic-related features.

---

## Context and goal

Real Driving Emission testing is expensive and time-consuming when executed only in real-world conditions. In the AVL use case, the critical challenge is the creation of a **high-fidelity human driver model** that can be plugged into a virtual simulation environment.

This TWIMO instance addresses that challenge by combining:

- **model-based engineering**, to represent the structure of the driving behaviour domain;
- **historical driving data**, to capture actual route and traffic conditions;
- **machine learning predictors**, to approximate the average behaviour of human drivers.

The final purpose is not to reproduce a specific individual driver, but to build a reusable basis for predicting realistic driving behaviour in support of virtual RDE procedures.

---

## Repository structure

```text
rde-instance/
├── model/
│   ├── META-INF/
│   ├── model/
│   │   ├── drivingBehaviourMetamodel.ecore
│   │   ├── drivingBehaviourMetamodel.genmodel
│   │   └── drivingBehaviourMetamodel.aird
│   ├── .project
│   └── .classpath
└── code/
    ├── AVL-RDE/
    │   ├── *.csv
    │   ├── checkpoints/
    │   └── results/
    ├── Adaboost_ClassifierVer1_0.ipynb
    ├── DecisionTreeClassifierVer1_0.ipynb
    ├── Gaussian_NaiveBayes_ClassifierVer1_0.ipynb
    ├── Gradient_Booster_ClassifierVer1_0.ipynb
    ├── Logistic_Regression_ClassifierVer1_0.ipynb
    ├── RandomForestClassifierVer2_0.ipynb
    └── drive-download-20240328T122640Z-001/
        ├── RandomForestClassifierVer1.0.ipynb
        └── RNNMatteoCopy.ipynb
```

---

## Main contents

### `model/`
This folder contains the **modeling artifacts** of the RDE driver-behaviour scenario.

Its role is to provide a structured representation of the concepts involved in the prediction problem, such as:

- driver profiles and preferences;
- driving behaviour parameters;
- vehicle configuration and vehicle types;
- environment background and conditions;
- route-related and traffic-related elements.

Main files:

- **`drivingBehaviourMetamodel.ecore`**  
  the Ecore metamodel defining the domain concepts and relations;

- **`drivingBehaviourMetamodel.genmodel`**  
  the EMF generation model used to support code generation and tooling;

- **`drivingBehaviourMetamodel.aird`**  
  the Sirius representation file used to visualize and manipulate the modeling artifacts graphically.

Overall, this folder captures the **conceptual structure** of the RDE use case from a TWIMO perspective.

### `code/`
This folder contains the **implementation and experimentation artifacts** for the data-driven prediction of driver behaviour.

It includes:

- the prepared **RDE datasets** in CSV format;
- several **Jupyter notebooks** implementing machine learning experiments;
- intermediate experiment outputs such as **checkpoints**, logs, plots, and result files.

The implementation mainly explores **classification-based prediction pipelines** for driver behaviour / speed profile approximation using route and traffic descriptors derived from the RDE scenario.

---

## Detailed code organization

### `code/AVL-RDE/`
This subfolder contains the **scenario datasets** used by the notebooks.

The CSV files represent multiple recorded driving sessions and route segments, including examples related to:

- highway conditions;
- mountain routes;
- urban or mixed traffic situations;
- different RDE test paths.

The prepared files expose route- and traffic-oriented variables that are used by the experimental notebooks, such as time or path progression information together with features related to:

- speed limits;
- traffic flow;
- traffic lights;
- traffic signs;
- toll booths;
- curvature;
- slope;
- target speed / velocity.

This folder also includes:

- **`checkpoints/`**  
  saved intermediate artifacts from training runs, including model checkpoint files and callback logs;

- **`results/`**  
  result files produced by specific experiments.

### Classifier notebooks in `code/`
The notebooks in the root of `code/` implement a set of alternative machine learning experiments, each focused on a specific classifier family, including:

- AdaBoost;
- Decision Tree;
- Gaussian Naive Bayes;
- Gradient Boosting;
- Logistic Regression;
- Random Forest.

Across these notebooks, the general workflow is consistent:

1. load one or more CSV driving datasets;
2. preprocess and scale the selected features;
3. derive or discretize the prediction target;
4. split data into training and test sets;
5. train the classifier;
6. evaluate the model using metrics such as precision, recall, F1-score, accuracy, confusion matrices, and classification reports.

### `code/drive-download-20240328T122640Z-001/`
This auxiliary folder contains additional exploratory notebooks, including:

- an earlier **Random Forest** variant;
- an **RNN/LSTM-oriented** experiment (`RNNMatteoCopy.ipynb`).

These files indicate that the repository was also used to explore alternative modeling strategies beyond the main baseline classifiers.

---

## Implementation overview

From an implementation perspective, this instance follows a **model + data + predictor** organization.

### 1. Modeling layer
The modeling layer defines the structure of the domain through EMF/Sirius artifacts. It describes the entities that matter for the scenario, including driver characteristics, vehicle configuration, behaviour parameters, and environmental context.

### 2. Data layer
The data layer is made of recorded RDE traces organized as CSV files. These traces encode route, traffic, and contextual variables extracted from real driving sessions and used as the empirical basis for learning.

### 3. Prediction layer
The prediction layer is implemented in notebooks and applies machine learning algorithms to the prepared datasets. The main idea is to learn a predictor that estimates realistic driver behaviour from route and traffic context, enabling virtual execution or support for RDE-oriented simulation workflows.

---

## General processing pipeline

The overall logic of the project can be summarized as follows:

1. **Collect and prepare recorded RDE driving data** from different routes and conditions.
2. **Select the most relevant contextual features** for driver behaviour prediction.
3. **Preprocess the data** through scaling and target preparation.
4. **Train and compare multiple ML models** on the prepared datasets.
5. **Evaluate the resulting predictors** using standard classification metrics.
6. **Use the learned model as a driver-behaviour approximation layer** for virtual RDE testing scenarios.

This reflects the role of TWIMO in connecting the conceptual representation of the domain with the concrete implementation of the predictive solution.

---

## Technology and artifact notes

This repository should be considered a **research / prototype instance** rather than a packaged production-ready software component.

A few practical notes:

- several notebooks are written in a **Google Colab-oriented style** and contain paths that must be adapted before local execution;
- the implementation relies mainly on the Python data/ML stack, especially **pandas**, **NumPy**, **scikit-learn**, and in some exploratory cases **TensorFlow/Keras**;
- some experimental artifacts are stored directly in the repository, including checkpoints and result files;
- the notebooks represent alternative experiments rather than a single unified executable pipeline.

---

## Relationship with TWIMO

This RDE instance is a concrete example of how TWIMO can be instantiated in the Intelligent Mobility domain.

In particular, it shows how TWIMO can be used to:

- structure a domain-specific modeling space for driving behaviour;
- connect models with real data coming from an industrial scenario;
- support the implementation of AI/ML-based prediction components;
- maintain traceability between conceptual elements, scenario data, and experimental implementations.

For this reason, the RDE instance is not only a dataset-and-code package, but also a **model-driven application example** that demonstrates how TWIMO supports an industrial mobility use case.

---

## Suggested reading of the folder

A practical way to navigate this instance is:

1. start from `model/model/drivingBehaviourMetamodel.ecore` to understand the domain concepts;
2. inspect the CSV files in `code/AVL-RDE/` to understand the prepared input data;
3. open `RandomForestClassifierVer2_0.ipynb` as the main reference notebook for the prediction workflow;
4. compare the other notebooks to see how different classifiers were evaluated;
5. inspect `checkpoints/` and `results/` for saved outputs of specific experiments.

---

## Summary

This folder contains the **TWIMO RDE instance for AVL's Real Driving Emission scenario**.
It combines:

- a **metamodel of driver behaviour and driving context**;
- **recorded and prepared RDE datasets**;
- **machine learning notebooks** for driver behaviour prediction experiments.

The instance demonstrates how TWIMO can support the engineering of a data-driven driver model for virtual RDE testing, with the broader goal of improving the realism, repeatability, and efficiency of automotive validation workflows.

---

## How to Cite?
If you use our work in your research, please cite: 
```
@ARTICLE{Eramo2024-ps,
  title         = "{AI-augmented} automation for real driving prediction: An
                   industrial use case",
  author        = "Eramo, Romina and Salman, Hamzeh Eyal and Spezialetti,
                   Matteo and Stern, Darko and Quinton, Pierre and Cicchetti,
                   Antonio",
  abstract      = "The risen complexity of automotive systems requires new
                   development strategies and methods to master the upcoming
                   challenges. Traditional methods need thus to be changed by
                   an increased level of automation, and a faster continuous
                   improvement cycle. In this context, current vehicle
                   performance tests represent a very time-consuming and
                   expensive task due to the need to perform the tests in real
                   driving conditions. As a consequence, agile/iterative
                   processes like DevOps are largely hindered by the necessity
                   of triggering frequent tests. This paper reports on a
                   practical experience of developing an AI-augmented solution
                   based on Machine Learning and Model-based Engineering to
                   support continuous vehicle development and testing. In
                   particular, historical data collected in real driving
                   conditions is leveraged to synthesize a high-fidelity
                   driving simulator and hence enable performance tests in
                   virtual environments. Based on this practical experience,
                   this paper also proposes a conceptual framework to support
                   predictions based on real driving behavior.",
  month         =  apr,
  year          =  2024,
  copyright     = "http://creativecommons.org/licenses/by/4.0/",
  archivePrefix = "arXiv",
  primaryClass  = "cs.SE",
  eprint        = "2404.02841"
}
```