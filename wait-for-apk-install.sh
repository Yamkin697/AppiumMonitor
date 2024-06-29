#!/bin/bash

# Название контейнера
APK_INSTALLER_CONTAINER_NAME=$1
LOG_STRING="APK installation complete"

echo "Waiting for APK installation to complete..."

while ! docker logs $APK_INSTALLER_CONTAINER_NAME 2>&1 | grep -q "$LOG_STRING"; do
  sleep 5
done

echo "APK installation complete. Starting monitor container."
