"""Setup script for TWIMO package."""

from setuptools import setup, find_packages
from pathlib import Path

# Read README for long description
readme_path = Path(__file__).parent / "README.md"
long_description = readme_path.read_text(encoding="utf-8") if readme_path.exists() else ""

setup(
    name="twimo",
    version="0.2.0",
    description="Digital Twin Framework for Driving Behavior",
    long_description=long_description,
    long_description_content_type="text/markdown",
    author="TWIMO Team",
    packages=find_packages(include=["twimo", "twimo.*"]),
    python_requires=">=3.10",
    install_requires=[
        "numpy>=1.23",
        "pandas>=2.0",
        "torch>=2.1",
        "torchvision>=0.16",
        "scikit-learn>=1.3",
        "opencv-python>=4.8",
        "tqdm>=4.66",
        "pyyaml>=6.0",
        "scipy>=1.10",
    ],
    extras_require={
        "optional": [
            "xgboost>=2.0",
            "lightgbm>=4.0",
        ],
    },
    entry_points={
        "console_scripts": [
            "twimo=twimo.cli:main",
        ],
    },
    classifiers=[
        "Development Status :: 4 - Beta",
        "Intended Audience :: Science/Research",
        "Programming Language :: Python :: 3.10",
        "Programming Language :: Python :: 3.11",
    ],
)
