#!/usr/bin/env python
"""
Align EAF annotations to sensors with multi-target support (Goal + Stimuli).

This script aligns EAF annotations to sensor timeline at specified sampling rate (e.g., 3 Hz).

Key differences from align_eaf_to_sensors.py:
- Uses 6 separate vocabularies (Goal, Stimuli, Area, Event, Cause, Attention)
- Creates 2 separate target arrays:
  - target_goal/<SESSION_ID>.npy: Goal maneuver labels (T,)
  - target_stimuli/<SESSION_ID>.npy: Stimuli labels (T,)
- Augments sensor features with EAF annotations:
  - Area, Event, Cause, Attention as additional feature columns

CRITICAL FIX (timestamp alignment):
- EAF TIME_VALUE is in milliseconds RELATIVE to the recording start.
- Sensor CSV timestamps are often absolute UNIX time or otherwise offset.
- We ALWAYS convert sensor timestamps to milliseconds RELATIVE to the first sensor sample:
      rel_ms = unix_ms - unix_ms[0]
  This avoids timezone/epoch offsets (e.g., +8h => 28800000ms) that cause "all zero labels".

Tier matching:
- We do NOT invent tier names.
- We match tiers by checking that their name contains the literal substrings:
    "Goal" and "Stimuli" (case-insensitive),
  and similarly "Area", "Event", "Cause", "Attention".
  This works even if the tier names contain additional text (including Chinese),
  as long as the English keyword appears somewhere (e.g., "... Operation_Goal-oriented").

Output structure:
    output_dir/
    ├── sensor/<SESSION_ID>.npy         # (T, D+4) - sensors + EAF features
    ├── target_goal/<SESSION_ID>.npy    # (T,) - Goal labels
    ├── target_stimuli/<SESSION_ID>.npy # (T,) - Stimuli labels
    └── manifest_eaf_aligned_multitarget.jsonl

Usage:
    python strategies_EAF/align_eaf_to_sensors_multitarget_new.py \
      --eaf-parsed-dir ./eaf_parsed \
      --vocab-dir ./artifacts/vocabs \
      --manifest ./artifacts/manifest.jsonl \
      --output-dir ./artifacts/eaf_aligned_multitarget \
      --sample-hz 3
"""

from __future__ import annotations

import argparse
import json
import sys
import traceback
from dataclasses import dataclass, is_dataclass, replace
from pathlib import Path
from typing import Dict, List, Tuple, Optional

import numpy as np
from tqdm import tqdm

# Import TWIMO utilities
sys.path.insert(0, str(Path(__file__).parent.parent.parent))

from twimo.data.manifest import load_manifest, write_manifest, SessionRecord
from twimo.data.csv_loaders import load_run_sensors, align_sensors_to_grid


# =========================
# Session ID utilities
# =========================
def normalize_session_id(session_id: str) -> str:
    """Normalize session ID to compact format (YYYYMMDDHHMM).

    Handles both formats:
        - EAF format: "2017-02-27-10-17-27" → "201702271017"
        - Compact format: "201702271017" → "201702271017"
    """
    if session_id.isdigit() and len(session_id) == 12:
        return session_id

    if "-" in session_id:
        parts = session_id.split("-")
        if len(parts) == 6:
            year, month, day, hour, minute, _second = parts
            return f"{year}{month}{day}{hour}{minute}"

    return session_id


def build_eaf_to_manifest_mapping(eaf_parsed_dir: Path, records: List[SessionRecord]) -> Dict[str, str]:
    """Build mapping from EAF filenames to manifest session_ids.

    Returns:
        {eaf_filename_stem: manifest_session_id}
    """
    eaf_files = [f for f in eaf_parsed_dir.glob("*.json") if f.name != "summary.json"]
    eaf_stems = {f.stem for f in eaf_files}

    manifest_normalized = {normalize_session_id(r.session_id): r.session_id for r in records}

    mapping: Dict[str, str] = {}
    for eaf_stem in eaf_stems:
        normalized = normalize_session_id(eaf_stem)
        if normalized in manifest_normalized:
            mapping[eaf_stem] = manifest_normalized[normalized]

    return mapping


# =========================
# Vocabularies
# =========================
@dataclass
class VocabSet:
    """Container for all 6 vocabularies."""
    goal: Dict[str, int]
    stimuli: Dict[str, int]
    area: Dict[str, int]
    event: Dict[str, int]
    cause: Dict[str, int]
    attention: Dict[str, int]

    goal_label_map: Dict[str, str]
    stimuli_label_map: Dict[str, str]
    area_label_map: Dict[str, str]
    event_label_map: Dict[str, str]
    cause_label_map: Dict[str, str]
    attention_label_map: Dict[str, str]


def load_all_vocabs(vocab_dir: Path) -> VocabSet:
    """Load all 6 vocabularies from vocab_dir.

    Expected files:
        - vocab_goal.json
        - vocab_stimuli.json
        - vocab_area.json
        - vocab_event.json
        - vocab_cause.json
        - vocab_attention.json
    """

    def load_single_vocab(tier_name: str) -> Tuple[Dict[str, int], Dict[str, str]]:
        vocab_path = vocab_dir / f"vocab_{tier_name.lower()}.json"
        if not vocab_path.exists():
            raise FileNotFoundError(f"Vocabulary not found: {vocab_path}")

        with open(vocab_path, encoding="utf-8") as f:
            data = json.load(f)

        vocab = data.get("vocab", {})
        label_map = data.get("label_map", {})
        if not isinstance(vocab, dict) or not isinstance(label_map, dict):
            raise ValueError(f"Invalid vocab file format: {vocab_path}")
        return vocab, label_map

    goal_vocab, goal_map = load_single_vocab("goal")
    stimuli_vocab, stimuli_map = load_single_vocab("stimuli")
    area_vocab, area_map = load_single_vocab("area")
    event_vocab, event_map = load_single_vocab("event")
    cause_vocab, cause_map = load_single_vocab("cause")
    attention_vocab, attention_map = load_single_vocab("attention")

    return VocabSet(
        goal=goal_vocab,
        stimuli=stimuli_vocab,
        area=area_vocab,
        event=event_vocab,
        cause=cause_vocab,
        attention=attention_vocab,
        goal_label_map=goal_map,
        stimuli_label_map=stimuli_map,
        area_label_map=area_map,
        event_label_map=event_map,
        cause_label_map=cause_map,
        attention_label_map=attention_map,
    )


# =========================
# EAF parsed JSON handling
# =========================
def load_eaf_annotations(eaf_json_path: Path) -> dict:
    """Load parsed EAF JSON file.

    Expected shape (example):
        {
          "tiers_grouped": {
             "SOME TIER NAME ... Goal ...": [ {"start_ms":..., "end_ms":..., "label":...}, ... ],
             ...
          }
        }
    """
    with open(eaf_json_path, encoding="utf-8") as f:
        return json.load(f)


def _find_tier_key(tiers_grouped: Dict[str, List[dict]], keyword: str) -> Optional[str]:
    """Return the tier key whose name contains 'keyword' (case-insensitive)."""
    kw = keyword.lower()
    for k in tiers_grouped.keys():
        if kw in k.lower():
            return k
    return None


def _get_tier_annotations(tiers_grouped: Dict[str, List[dict]], keyword: str) -> List[dict]:
    """Get annotations list for the tier whose key contains keyword."""
    k = _find_tier_key(tiers_grouped, keyword)
    if k is None:
        return []
    anns = tiers_grouped.get(k, [])
    return anns if isinstance(anns, list) else []


def normalize_label(label: str, label_map: Dict[str, str]) -> str:
    """Normalize label using label_map, otherwise fallback."""
    if not isinstance(label, str):
        label = str(label)
    return label_map.get(label, label.replace(" ", "_").lower())


def map_tier_to_timeline(
    tier_annotations: List[dict],
    timestamps_ms: np.ndarray,
    vocab: Dict[str, int],
    label_map: Dict[str, str],
) -> np.ndarray:
    """Map a single tier's annotations to sensor timeline.

    Args:
        tier_annotations: List of {start_ms, end_ms, label}
        timestamps_ms: Sensor timestamps in milliseconds RELATIVE to sensor start (T,)
        vocab: Vocabulary mapping {normalized_label: class_id}
        label_map: Label normalization mapping {raw_label: normalized_label}

    Returns:
        labels: (T,) array of class_id (0 = unknown)
    """
    T = int(len(timestamps_ms))
    labels = np.zeros(T, dtype=np.int32)

    if T == 0 or not tier_annotations:
        return labels

    for ann in tier_annotations:
        try:
            start_ms = int(ann["start_ms"])
            end_ms = int(ann["end_ms"])
            raw_label = ann.get("label", "")
        except Exception:
            continue

        normalized = normalize_label(raw_label, label_map)
        class_id = int(vocab.get(normalized, 0))

        # EAF intervals are [start, end); keep that convention
        mask = (timestamps_ms >= start_ms) & (timestamps_ms < end_ms)
        labels[mask] = class_id

    return labels


# =========================
# Sensor timestamp handling
# =========================
def _extract_unix_seconds_column(aligned_df) -> Optional[str]:
    """Try to find a suitable unix timestamp column in aligned dataframe."""
    candidates = [
        "unix_timestamp",
        "# unix_timestamp",
        "timestamp",
        "# timestamp",
        "time",
        "# time",
    ]
    cols_lower = {c.lower(): c for c in aligned_df.columns}
    for c in candidates:
        if c in aligned_df.columns:
            return c
        if c.lower() in cols_lower:
            return cols_lower[c.lower()]
    # last resort: any column containing 'unix' and 'time'
    for c in aligned_df.columns:
        cl = str(c).lower()
        if "unix" in cl and "time" in cl:
            return c
    return None


def compute_sensor_timestamps_ms_relative(aligned_df) -> np.ndarray:
    """Compute sensor timestamps in ms RELATIVE to first sensor sample.

    This is the safest alignment with EAF TIME_VALUE, which is relative.
    It avoids timezone/epoch offsets (e.g., +8h => 28800000ms).
    """
    unix_col = _extract_unix_seconds_column(aligned_df)
    if unix_col is None:
        raise RuntimeError(
            "Cannot find unix timestamp column in aligned sensors. "
            "Expected something like 'unix_timestamp' or '# unix_timestamp'."
        )

    ts = aligned_df[unix_col].values.astype(np.float64)
    if len(ts) == 0:
        return np.array([], dtype=np.int64)

    med = float(np.nanmedian(ts))
    if med > 1e12:
        ts_ms = ts.astype(np.int64)  # already ms
    else:
        ts_ms = (ts * 1000.0).astype(np.int64)  # seconds -> ms (works also for relative seconds)

    rel_ms = ts_ms - int(ts_ms[0])
    return rel_ms


# =========================
# Alignment per session
# =========================
def align_session(
    session_record: SessionRecord,
    eaf_json_path: Path,
    vocabs: VocabSet,
    output_dir: Path,
    sample_hz: float = 3.0,
    debug: bool = False,
) -> SessionRecord | None:
    """Align EAF annotations for a single session (multi-target version)."""
    session_id = session_record.session_id

    if not eaf_json_path.exists():
        return None

    eaf_data = load_eaf_annotations(eaf_json_path)
    tiers_grouped = eaf_data.get("tiers_grouped", {})
    if not isinstance(tiers_grouped, dict) or len(tiers_grouped) == 0:
        return None

    # Load sensors
    csv_dir = Path(session_record.csv_dir)
    df = load_run_sensors(csv_dir)               # dict of dataframes
    aligned = align_sensors_to_grid(df, hz=sample_hz)  # aligned dataframe

    # Sensor timestamps (RELATIVE ms)
    timestamps_ms = compute_sensor_timestamps_ms_relative(aligned)
    if len(timestamps_ms) == 0:
        return None

    # Extract sensor features
    sensor_cols = [
        "steer_angle", "steer_speed",   # steer.csv
        "lturn", "rturn",               # turn_signal.csv
        "speed",                        # vel.csv
        "pedalangle(percent)",          # accel_pedal.csv
        "pedalpressure(kPa)",           # brake_pedal.csv
        "yaw(degree/s)",                # yaw.csv
    ]
    import pandas as pd
    X_df = pd.DataFrame()
    for col in sensor_cols:
        if col in aligned.columns:
            X_df[col] = aligned[col].fillna(0.0)
        else:
            X_df[col] = 0.0
    X_sensors = X_df.values.astype(np.float32)  # (T, D)

    # Get tier annotations by keyword (literal substrings Goal/Stimuli/Area/Event/Cause/Attention)
    anns_goal = _get_tier_annotations(tiers_grouped, "goal")
    anns_stimuli = _get_tier_annotations(tiers_grouped, "stimuli")
    anns_area = _get_tier_annotations(tiers_grouped, "area")
    anns_event = _get_tier_annotations(tiers_grouped, "event")
    anns_cause = _get_tier_annotations(tiers_grouped, "cause")
    anns_attention = _get_tier_annotations(tiers_grouped, "attention")

    if debug:
        print(f"[DBG] {session_id} tier keys available: {list(tiers_grouped.keys())[:12]}{' ...' if len(tiers_grouped)>12 else ''}")
        if len(anns_goal) > 0:
            g0 = anns_goal[0]
            print(f"[DBG] {session_id} first Goal ann: {g0.get('start_ms')}..{g0.get('end_ms')} label={g0.get('label')}")
        if len(anns_stimuli) > 0:
            s0 = anns_stimuli[0]
            print(f"[DBG] {session_id} first Stimuli ann: {s0.get('start_ms')}..{s0.get('end_ms')} label={s0.get('label')}")
        print(f"[DBG] {session_id} sensor rel ms range: {int(timestamps_ms.min())}..{int(timestamps_ms.max())}")

    # Map tiers to timeline
    labels_goal = map_tier_to_timeline(anns_goal, timestamps_ms, vocabs.goal, vocabs.goal_label_map)
    labels_stimuli = map_tier_to_timeline(anns_stimuli, timestamps_ms, vocabs.stimuli, vocabs.stimuli_label_map)
    labels_area = map_tier_to_timeline(anns_area, timestamps_ms, vocabs.area, vocabs.area_label_map)
    labels_event = map_tier_to_timeline(anns_event, timestamps_ms, vocabs.event, vocabs.event_label_map)
    labels_cause = map_tier_to_timeline(anns_cause, timestamps_ms, vocabs.cause, vocabs.cause_label_map)
    labels_attention = map_tier_to_timeline(anns_attention, timestamps_ms, vocabs.attention, vocabs.attention_label_map)

    # Warn if goal+stimuli are all zeros (common symptom of misalignment or missing tiers)
    if np.all(labels_goal == 0) and np.all(labels_stimuli == 0):
        tier_keys_preview = list(tiers_grouped.keys())
        tier_keys_preview = tier_keys_preview[:8]
        print(
            f"[WARN] {session_id}: Goal and Stimuli targets are ALL ZERO.\n"
            f"       Likely causes: missing tiers containing 'Goal'/'Stimuli' or timestamps still misaligned.\n"
            f"       Tier keys available: {tier_keys_preview}{' ...' if len(tiers_grouped)>8 else ''}\n"
            f"       timestamps_ms (REL) range: {int(timestamps_ms.min())} .. {int(timestamps_ms.max())}"
        )

    # Augment sensors with EAF features (Area, Event, Cause, Attention)
    eaf_features = np.stack([labels_area, labels_event, labels_cause, labels_attention], axis=1).astype(np.float32)
    augmented_sensors = np.concatenate([X_sensors, eaf_features], axis=1)  # (T, D+4)

    # Save aligned arrays
    sensor_dir = output_dir / "sensor"
    target_goal_dir = output_dir / "target_goal"
    target_stimuli_dir = output_dir / "target_stimuli"

    sensor_dir.mkdir(parents=True, exist_ok=True)
    target_goal_dir.mkdir(parents=True, exist_ok=True)
    target_stimuli_dir.mkdir(parents=True, exist_ok=True)

    sensor_path = sensor_dir / f"{session_id}.npy"
    target_goal_path = target_goal_dir / f"{session_id}.npy"
    target_stimuli_path = target_stimuli_dir / f"{session_id}.npy"

    np.save(sensor_path, augmented_sensors)
    np.save(target_goal_path, labels_goal)
    np.save(target_stimuli_path, labels_stimuli)

    # Update session record (primary target = Goal, as in your original script)
    if is_dataclass(session_record):
        updated_record = replace(
            session_record,
            prealigned_sensor_npy=str(sensor_path),
            prealigned_target_npy=str(target_goal_path),
        )
    else:
        updated_record = SessionRecord(
            session_id=session_record.session_id,
            video_path=session_record.video_path,
            csv_dir=session_record.csv_dir,
            prealigned_sensor_npy=str(sensor_path),
            prealigned_target_npy=str(target_goal_path),
            day_id=session_record.day_id,
        )

    return updated_record


# =========================
# CLI main
# =========================
def main():
    parser = argparse.ArgumentParser(
        description="Align EAF annotations to sensors (multi-target: Goal + Stimuli)"
    )
    parser.add_argument(
        "--eaf-parsed-dir",
        type=Path,
        required=True,
        help="Directory containing parsed EAF JSON files",
    )
    parser.add_argument(
        "--vocab-dir",
        type=Path,
        required=True,
        help="Directory containing all 6 vocab JSON files (vocab_goal.json, ...)",
    )
    parser.add_argument(
        "--manifest",
        type=Path,
        required=True,
        help="Input manifest JSONL file",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        required=True,
        help="Output directory for aligned .npy files",
    )
    parser.add_argument(
        "--sample-hz",
        type=float,
        default=3.0,
        help="Sampling frequency in Hz (default: 3.0)",
    )
    parser.add_argument(
        "--debug",
        action="store_true",
        help="Print debug info for tier keys and timestamp ranges",
    )

    args = parser.parse_args()

    print("=" * 80)
    print("EAF Multi-Target Alignment (Goal + Stimuli)")
    print("=" * 80)

    # Load vocabularies
    print(f"\nLoading vocabularies from {args.vocab_dir}...")
    try:
        vocabs = load_all_vocabs(args.vocab_dir)
        print(f"  ✅ Goal:      {len(vocabs.goal)} classes")
        print(f"  ✅ Stimuli:   {len(vocabs.stimuli)} classes")
        print(f"  ✅ Area:      {len(vocabs.area)} classes")
        print(f"  ✅ Event:     {len(vocabs.event)} classes")
        print(f"  ✅ Cause:     {len(vocabs.cause)} classes")
        print(f"  ✅ Attention: {len(vocabs.attention)} classes")
    except FileNotFoundError as e:
        print(f"  ❌ Error: {e}")
        print(f"\nRun this command first to build all vocabs:")
        print(f"  python strategies_EAF/build_all_vocabs.py \\")
        print(f"    --eaf-parsed-dir {args.eaf_parsed_dir} \\")
        print(f"    --output-dir {args.vocab_dir}")
        return
    except Exception as e:
        print(f"  ❌ Error loading vocabs: {e}")
        return

    # Load manifest
    print(f"\nLoading manifest from {args.manifest}...")
    records = load_manifest(args.manifest)
    print(f"  Found {len(records)} sessions")

    # Build EAF-to-manifest mapping
    print(f"\nBuilding EAF-to-manifest session ID mapping...")
    eaf_to_manifest = build_eaf_to_manifest_mapping(args.eaf_parsed_dir, records)
    print(f"  Matched {len(eaf_to_manifest)} EAF files to manifest sessions")

    if len(eaf_to_manifest) == 0:
        print(f"\n⚠️  No EAF files matched manifest sessions!")
        print(f"\nRun diagnostic check:")
        print(f"  python strategies_EAF/diagnostic_check.py \\")
        print(f"    --eaf-parsed-dir {args.eaf_parsed_dir} \\")
        print(f"    --manifest {args.manifest}")
        return

    manifest_to_eaf = {v: k for k, v in eaf_to_manifest.items()}

    # Align sessions
    print(f"\nAligning EAF annotations to sensors...")
    aligned_records: List[SessionRecord] = []
    skipped_reasons = {
        "no_eaf": [],
        "no_csv": [],
        "no_annotations": [],
        "error": [],
    }

    for record in tqdm(records, desc="Sessions"):
        try:
            if record.session_id not in manifest_to_eaf:
                skipped_reasons["no_eaf"].append(record.session_id)
                continue

            eaf_filename = manifest_to_eaf[record.session_id]
            eaf_json_path = args.eaf_parsed_dir / f"{eaf_filename}.json"
            if not eaf_json_path.exists():
                skipped_reasons["no_eaf"].append(record.session_id)
                continue

            csv_dir = Path(record.csv_dir)
            if not csv_dir.exists():
                skipped_reasons["no_csv"].append(record.session_id)
                continue

            aligned_record = align_session(
                session_record=record,
                eaf_json_path=eaf_json_path,
                vocabs=vocabs,
                output_dir=args.output_dir,
                sample_hz=args.sample_hz,
                debug=args.debug,
            )

            if aligned_record is not None:
                aligned_records.append(aligned_record)
            else:
                skipped_reasons["no_annotations"].append(record.session_id)

        except Exception as e:
            error_details = f"{str(e)}\n{traceback.format_exc()}"
            skipped_reasons["error"].append((record.session_id, error_details))
            continue

    # Write manifest
    manifest_path = args.output_dir / "manifest_eaf_aligned_multitarget.jsonl"
    write_manifest(manifest_path, aligned_records)

    print(f"\n{'=' * 80}")
    print("EAF Multi-Target Alignment Completed!")
    print(f"{'=' * 80}")
    print(f"  Sessions aligned: {len(aligned_records)}/{len(records)}")
    print(f"  Output directory: {args.output_dir}")
    print(f"  Manifest: {manifest_path}")

    # Report skipped sessions
    if len(aligned_records) < len(records):
        print(f"\nSkipped sessions breakdown:")
        if skipped_reasons["no_eaf"]:
            print(f"  No EAF file: {len(skipped_reasons['no_eaf'])} sessions")
        if skipped_reasons["no_csv"]:
            print(f"  No CSV dir: {len(skipped_reasons['no_csv'])} sessions")
        if skipped_reasons["no_annotations"]:
            print(f"  No annotations / failed alignment: {len(skipped_reasons['no_annotations'])} sessions")
        if skipped_reasons["error"]:
            print(f"  Errors: {len(skipped_reasons['error'])} sessions")
            print(f"\n  First error details:")
            sid, err = skipped_reasons["error"][0]
            print(f"    Session: {sid}")
            print("    Error:")
            for line in err.split("\n"):
                if line.strip():
                    print(f"      {line}")
            if len(skipped_reasons["error"]) > 1:
                print(f"\n  ... and {len(skipped_reasons['error']) - 1} more errors")

    if len(aligned_records) > 0:
        print(f"\n✅ Output structure:")
        print("  sensor/            - Augmented sensors (standard + Area/Event/Cause/Attention)")
        print("  target_goal/       - Goal maneuver labels")
        print("  target_stimuli/    - Stimuli labels")

        print(f"\nNext steps:")
        print(f"  1. Train Goal model:")
        print(f"     python -m twimo.cli train-maneuver \\")
        print(f"       --manifest {manifest_path} \\")
        print(f"       --outdir ./artifacts/maneuver_goal_transformer \\")
        print(f"       --model transformer \\")
        print(f"       --sample-hz {args.sample_hz}")
        print(f"\n  2. Train Stimuli model (requires custom loader for target_stimuli/):")
        print("     [See strategies_EAF/README_MULTITARGET.md for details]")
    else:
        print(f"\n⚠️  No sessions were aligned. Check:")
        print(f"  1. EAF files exist in {args.eaf_parsed_dir}")
        print(f"  2. Session IDs in manifest match EAF filenames")
        print(f"  3. CSV directories exist for each session")
        print(f"  4. Vocabularies exist in {args.vocab_dir}")
        print(f"  5. Sensor timestamp column exists (unix_timestamp or similar)")
        print(f"  6. Tier names contain the literal substrings: Goal / Stimuli / Area / Event / Cause / Attention")

    print(f"{'=' * 80}\n")


if __name__ == "__main__":
    main()