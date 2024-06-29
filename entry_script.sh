#!/bin/bash

# Выполнение основного процесса (установка APK)
echo "Starting APK installation at $(date)"
/install-apk.sh

# Проверка успешности установки APK
if [ $? -eq 0 ]; then
  echo "APK installation complete at $(date)"
else
  echo "APK installation failed at $(date)"
  exit 1
fi

# Оставить контейнер работающим
echo "Keeping the container running..."
tail -f /dev/null