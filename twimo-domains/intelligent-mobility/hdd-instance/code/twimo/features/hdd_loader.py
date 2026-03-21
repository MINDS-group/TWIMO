"""Helper functions to load HDD (Honda Driving Dataset) CSV files."""

from __future__ import annotations

from pathlib import Path
from typing import Dict, Optional

import pandas as pd
import numpy as np


def load_hdd_session(csv_dir: Path) -> Optional[pd.DataFrame]:
    """Load HDD session from directory with multiple CSV files.

    HDD stores each signal in a separate CSV file:
    - vel.csv: velocity
    - accel_pedal.csv: accelerator pedal
    - brake_pedal.csv: brake pedal
    - steer.csv: steering angle
    - etc.

    This function loads and merges them into a single DataFrame.

    Args:
        csv_dir: Directory containing CSV files

    Returns:
        Merged DataFrame or None if loading fails
    """
    csv_dir = Path(csv_dir)

    # Define expected files and their column mappings
    # Try multiple possible column names for robustness
    file_mappings = {
        'vel.csv': (['speed(m/s)', 'speed'], 'velocity'),
        'accel_pedal.csv': (['pedalangle(percent)', 'pedalangle'], 'accel'),
        'brake_pedal.csv': (['pedalpressure(kPa)', 'pedalangle(percent)', 'pedalangle'], 'brake'),
        'steer.csv': (['angle(deg)', 'angle'], 'steer'),
    }

    # Load each CSV
    dfs = {}

    for filename, (possible_cols, target_col) in file_mappings.items():
        filepath = csv_dir / filename

        if not filepath.exists():
            continue

        try:
            # Read CSV - the first line is the header starting with '#'
            with open(filepath) as f:
                lines = f.readlines()

            # Remove '#' from first line to get proper header
            if lines and lines[0].startswith('#'):
                lines[0] = lines[0][1:].strip() + '\n'

            from io import StringIO
            df = pd.read_csv(StringIO(''.join(lines)))

            # Find which column name exists
            original_col = None
            for col_name in possible_cols:
                if col_name in df.columns:
                    original_col = col_name
                    break

            # Extract timestamp and value
            if 'unix_timestamp' in df.columns and original_col is not None:
                temp_df = df[['unix_timestamp', original_col]].copy()
                temp_df.rename(columns={
                    'unix_timestamp': 'timestamp',
                    original_col: target_col
                }, inplace=True)

                # Convert timestamp to milliseconds
                temp_df['timestamp'] = (temp_df['timestamp'] * 1000).astype(int)

                dfs[target_col] = temp_df

        except Exception as e:
            print(f"  [Warning] Could not load {filename}: {e}")
            continue

    if not dfs:
        return None

    # Merge all dataframes on timestamp
    # Start with the first one
    merged_df = None

    for signal_name, df in dfs.items():
        if merged_df is None:
            merged_df = df
        else:
            # Merge on timestamp with outer join to keep all timestamps
            merged_df = pd.merge(
                merged_df,
                df,
                on='timestamp',
                how='outer',
                suffixes=('', f'_{signal_name}')
            )

    if merged_df is None:
        return None

    # Sort by timestamp
    merged_df = merged_df.sort_values('timestamp').reset_index(drop=True)

    # Forward fill missing values (interpolate between samples)
    merged_df = merged_df.ffill().bfill()

    # Fill any remaining NaNs with 0
    merged_df = merged_df.fillna(0)

    return merged_df


def check_hdd_format(path: Path) -> bool:
    """Check if path is an HDD-format directory.

    Args:
        path: Path to check

    Returns:
        True if path is an HDD CSV directory
    """
    if not path.is_dir():
        return False

    # Check for characteristic HDD files
    hdd_files = ['vel.csv', 'accel_pedal.csv', 'brake_pedal.csv', 'steer.csv']
    found_files = [f for f in hdd_files if (path / f).exists()]

    return len(found_files) >= 2  # At least 2 HDD files present
