# twimo.dt

This package implements the **Digital Twin** part of TWIMO for the HDD use case.

## What is simulated

- A **minimal vehicle dynamics model**: *kinematic bicycle*.
- Inputs: steering angle (deg) and vehicle speed (m/s) derived from CSV sensors.
- Output: simulated trajectory `(x, y)` in meters.

## What is evaluated

The simulator compares the simulated trajectory against **RTK GPS** (from `rtk_pos.csv` and `rtk_track.csv`) and reports:

- RMSE on x/y position and planar RMSE (meters)
- Number of compared samples

The CLI entry point is: `python -m twimo.cli simulate-dt ...`
