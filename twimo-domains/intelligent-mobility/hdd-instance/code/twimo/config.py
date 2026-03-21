"""Configuration loader for TWIMO.

Centralizes all configuration management.
"""

from __future__ import annotations

import yaml
from pathlib import Path
from typing import Dict, Any, Optional


class Config:
    """TWIMO configuration manager."""

    def __init__(self, config_path: Optional[Path] = None):
        """Load configuration from YAML file.

        Args:
            config_path: Path to config.yaml (default: project root)
        """
        if config_path is None:
            # Default: look for config.yaml in project root
            config_path = Path(__file__).parent.parent / 'config.yaml'

        self.config_path = Path(config_path)

        if not self.config_path.exists():
            raise FileNotFoundError(
                f"Configuration file not found: {self.config_path}\n"
                f"Please create config.yaml in the project root."
            )

        with open(self.config_path) as f:
            self._config = yaml.safe_load(f)

    def get(self, key: str, default: Any = None) -> Any:
        """Get configuration value by key.

        Supports nested keys with dot notation: 'qdrant.collection_name'

        Args:
            key: Configuration key (supports dot notation)
            default: Default value if key not found

        Returns:
            Configuration value
        """
        keys = key.split('.')
        value = self._config

        for k in keys:
            if isinstance(value, dict) and k in value:
                value = value[k]
            else:
                return default

        return value

    def get_path(self, key: str, default: Optional[str] = None) -> Path:
        """Get configuration value as Path object.

        Args:
            key: Configuration key
            default: Default path if key not found

        Returns:
            Path object
        """
        value = self.get(key, default)
        if value is None:
            raise ValueError(f"Path configuration '{key}' not found")
        return Path(value)

    def get_output_dir(self, name: str) -> Path:
        """Get output directory path by name.

        Args:
            name: Output directory name (e.g., 'style_viz', 'advanced_analysis')

        Returns:
            Path to output directory
        """
        output_dirs = self.get('output_dirs', {})
        if name in output_dirs:
            return Path(output_dirs[name])

        # Fallback: create in artifacts directory
        artifacts_dir = self.get_path('artifacts_dir')
        return artifacts_dir / name

    @property
    def data_dir(self) -> Path:
        """Base directory for session data."""
        return self.get_path('data_dir')

    @property
    def eaf_dir(self) -> Path:
        """Directory containing EAF annotation files."""
        return self.get_path('eaf_dir')

    @property
    def preprocessed_elan_dir(self) -> Path:
        """Directory containing preprocessed ELAN .npy files."""
        return self.get_path('preprocessed_elan_dir')

    @property
    def video_dir(self) -> Path:
        """Base directory for video files."""
        return self.get_path('video_dir')

    @property
    def artifacts_dir(self) -> Path:
        """Base directory for all generated artifacts."""
        return self.get_path('artifacts_dir')

    @property
    def manifest_file(self) -> Path:
        """Path to manifest.jsonl file."""
        return self.get_path('manifest_file')

    @property
    def max_sessions(self) -> Optional[int]:
        """Maximum number of sessions to process (None = all)."""
        return self.get('max_sessions')

    @property
    def qdrant_collection(self) -> str:
        """Qdrant collection name."""
        return self.get('qdrant.collection_name', 'driving_sessions')

    @property
    def qdrant_host(self) -> str:
        """Qdrant host."""
        return self.get('qdrant.host', 'localhost')

    @property
    def qdrant_port(self) -> int:
        """Qdrant port."""
        return self.get('qdrant.port', 6333)

    def __repr__(self) -> str:
        return f"Config(config_path={self.config_path})"


# Global config instance
_config: Optional[Config] = None


def get_config(config_path: Optional[Path] = None) -> Config:
    """Get global configuration instance.

    Args:
        config_path: Optional path to config file (uses default if None)

    Returns:
        Config instance
    """
    global _config

    if _config is None or config_path is not None:
        _config = Config(config_path)

    return _config


def reload_config(config_path: Optional[Path] = None) -> Config:
    """Reload configuration from file.

    Args:
        config_path: Optional path to config file

    Returns:
        New Config instance
    """
    global _config
    _config = Config(config_path)
    return _config
