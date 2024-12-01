#!/bin/bash

# Путь к сигнальному файлу
SIGNAL_FILE_PATH="/shared/apk-installation-complete"

echo "Waiting for APK installation to complete..."

# Ожидание создания сигнального файла
while [ ! -f "$SIGNAL_FILE_PATH" ]; do
  sleep 5
done

echo "APK installation complete. Signal file detected at $SIGNAL_FILE_PATH"

