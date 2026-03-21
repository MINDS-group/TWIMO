#!/usr/bin/env python
"""Build manifest file from dataset directory.

Scans the data directory and creates a manifest.jsonl file with all sessions.
Uses configuration from config.yaml for paths.
"""

# Add project root to Python path
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

import json
import argparse
from twimo.config import get_config
from twimo.features.hdd_loader import check_hdd_format


def scan_sessions(data_dir: Path, scenarios=None, session_ids=None):
    """Scan data directory for valid HDD sessions.

    Args:
        data_dir: Base directory containing scenario folders
        scenarios: List of scenario names to process (None = all)
        session_ids: List of session IDs to process (None = all)

    Yields:
        Session info dictionaries
    """
    if not data_dir.exists():
        print(f"[Error] Data directory not found: {data_dir}")
        return

    # Iterate through scenario directories
    for scenario_dir in sorted(data_dir.iterdir()):
        if not scenario_dir.is_dir():
            continue

        scenario_name = scenario_dir.name

        # Filter by scenario if specified
        if scenarios and scenario_name not in scenarios:
            continue

        print(f"\nScanning scenario: {scenario_name}")

        # Iterate through session directories
        for session_dir in sorted(scenario_dir.iterdir()):
            if not session_dir.is_dir():
                continue

            session_id = session_dir.name

            # Filter by session ID if specified
            if session_ids and session_id not in session_ids:
                continue

            # Check for CSV directory
            csv_dir = session_dir / 'general' / 'csv'

            if not csv_dir.exists():
                print(f"  [Skip] {session_id}: No CSV directory found")
                continue

            # Verify HDD format
            if not check_hdd_format(csv_dir):
                print(f"  [Skip] {session_id}: Invalid HDD format")
                continue

            # Check for video directory (optional)
            video_dir = session_dir / 'camera' / 'center'
            has_video = video_dir.exists()

            print(f"  ✓ {session_id} (video: {'yes' if has_video else 'no'})")

            yield {
                'session_id': session_id,
                'scenario': scenario_name,
                'csv_dir': str(csv_dir),
                'video_dir': str(video_dir) if has_video else None,
                'session_dir': str(session_dir),
            }


def main():
    parser = argparse.ArgumentParser(
        description='Build manifest file from dataset directory'
    )
    parser.add_argument(
        '--config',
        type=Path,
        default=None,
        help='Path to config.yaml (default: project root)'
    )
    parser.add_argument(
        '--data-dir',
        type=Path,
        default=None,
        help='Override data directory from config'
    )
    parser.add_argument(
        '--output',
        type=Path,
        default=None,
        help='Override manifest output path from config'
    )
    parser.add_argument(
        '--scenario',
        action='append',
        help='Filter by scenario (can be used multiple times)'
    )
    parser.add_argument(
        '--session-id',
        action='append',
        help='Filter by session ID (can be used multiple times)'
    )

    args = parser.parse_args()

    # Load configuration
    config = get_config(args.config)

    # Get data directory
    data_dir = Path(args.data_dir) if args.data_dir else config.data_dir

    # Get output file
    manifest_file = Path(args.output) if args.output else config.manifest_file

    # Get filters from config or command line
    scenarios = args.scenario or config.get('scenarios', [])
    session_ids = args.session_id or config.get('session_ids', [])

    print("=" * 70)
    print("BUILDING MANIFEST FILE")
    print("=" * 70)
    print(f"\nData directory: {data_dir}")
    print(f"Output file: {manifest_file}")

    if scenarios:
        print(f"Filtering scenarios: {scenarios}")
    if session_ids:
        print(f"Filtering session IDs: {session_ids}")

    # Ensure output directory exists
    manifest_file.parent.mkdir(parents=True, exist_ok=True)

    # Scan sessions and write manifest
    session_count = 0

    with open(manifest_file, 'w') as f:
        for session_info in scan_sessions(data_dir, scenarios, session_ids):
            f.write(json.dumps(session_info) + '\n')
            session_count += 1

    print("\n" + "=" * 70)
    print(f"MANIFEST COMPLETE: {session_count} sessions")
    print("=" * 70)
    print(f"\nManifest file: {manifest_file}")
    print(f"\nTo use this manifest, run analysis scripts:")
    print(f"  python examples/visualize_driving_styles.py")
    print(f"  python examples/advanced_clustering_analysis.py")
    print(f"  python examples/analyze_annotated_sessions.py")


if __name__ == '__main__':
    main()
