"""
Master script — run all result computation scripts in sequence.

Usage:
    python -m twimo.results_models.run_all
    # or
    python twimo/results_models/run_all.py

Outputs all JSON and LaTeX snippets to results/
"""
from __future__ import annotations
import importlib
import sys
from pathlib import Path

SCRIPTS = [
    "twimo.results_models.01_rq1_dataset",
    "twimo.results_models.02_rq2a_proxy",
    "twimo.results_models.03_rq2b_two_stage",
    "twimo.results_models.04_rq3_multi_horizon",
    "twimo.results_models.05_energy_profiling",
    "twimo.results_models.06_generate_figures",
    "twimo.results_models.07_generate_latex_complete",
]


def run_module(mod_name: str) -> None:
    sep = "=" * 72
    print(f"\n{sep}")
    print(f"  Running: {mod_name}")
    print(f"{sep}")
    try:
        mod = importlib.import_module(mod_name)
        mod.main()
    except Exception as e:
        print(f"[ERROR] {mod_name}: {e}", file=sys.stderr)
        import traceback
        traceback.print_exc()


def main() -> None:
    ROOT = Path(__file__).resolve().parents[2]
    sys.path.insert(0, str(ROOT))

    print("TWIMO — Paper Results Generator")
    print(f"Output dir: {ROOT / 'results'}")

    for script in SCRIPTS:
        run_module(script)

    print(f"\n{'=' * 72}")
    print("Done.")
    print("  JSON stats  : results/*.json")
    print("  Figures     : results/figures/*.pdf  results/figures/*.png")
    print("  LaTeX tables: results/paper_tables.tex")


if __name__ == "__main__":
    main()
