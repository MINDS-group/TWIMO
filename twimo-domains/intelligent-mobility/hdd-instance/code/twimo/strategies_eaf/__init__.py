"""EAF annotation strategy for TWIMO.

This module provides tools for integrating ELAN Annotation Format (EAF)
files into TWIMO's training pipeline.

Workflow:
    1. parse_eaf.py       - Parse EAF XML files
    2. build_vocab.py     - Build maneuver vocabulary
    3. align_eaf_to_sensors.py - Align annotations to sensor timeline (.npy)
    4. Train with EAF     - Use CLI: train-maneuver with EAF manifest
    5. evaluate_eaf.py    - Evaluate against ground-truth

See strategies_EAF/README.md for detailed documentation.
"""

__version__ = '0.2.0'
