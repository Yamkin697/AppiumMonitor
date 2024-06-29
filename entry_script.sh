#!/bin/bash

# Output the current date and time
echo "Starting APK installation at $(date)"

# Run the APK installation script
/install-apk.sh

# Check if the APK installation was successful
if [ $? -eq 0 ]; then
  echo "APK installation complete at $(date)"
else
  echo "APK installation failed at $(date)"
  exit 1
fi

# Keep the container running
echo "Keeping the container running..."
tail -f /dev/null

