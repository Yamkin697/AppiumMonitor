#!/bin/bash

# Wait for the Android container to be ready
while ! nc -z ${ANDROID_CONTAINER_NAME} 5555; do
  echo "Waiting for Android container to be ready..."
  sleep 5  # 5 seconds
done

echo "Android container is ready."

# Connect to the Android emulator
adb connect ${ANDROID_CONTAINER_NAME}:5555

# Wait for the device to be online
DEVICE_ONLINE="offline"
while [ "$DEVICE_ONLINE" == "offline" ]; do
  DEVICE_ONLINE=$(adb -s ${ANDROID_CONTAINER_NAME}:5555 get-state 2>/dev/null)
  if [ "$DEVICE_ONLINE" == "offline" ]; then
    echo "Waiting for device to be online..."
    sleep 5  
  fi
done

echo "Device is online."

# Wait for the device to be fully booted
BOOT_COMPLETED="0"
while [ "$BOOT_COMPLETED" != "1" ]; do
  BOOT_COMPLETED=$(adb -s ${ANDROID_CONTAINER_NAME}:5555 shell getprop sys.boot_completed 2>/dev/null)
  if [ "$BOOT_COMPLETED" != "1" ]; then
    echo "Waiting for device to boot..."
    sleep 30  # 30 seconds
  fi
done

echo "Device booted successfully."

# Install the APK
adb -s ${ANDROID_CONTAINER_NAME}:5555 install ${APK_PATH}

echo "APK installation complete" > /shared/apk-installation-complete
