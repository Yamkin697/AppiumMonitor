#!/bin/bash

# Function to count the number of screen sessions
count_screen_sessions() {
    screen_count=$(screen -ls | grep -c "Socket")
    echo "$screen_count"
}

# Function to gracefully terminate all processes
terminate_processes() {
    echo "Terminating all processes..."
    # Send SIGTERM signal to all processes except for PID 1 (init/systemd)
    sudo kill -15 $(pidof -x bash) &>/dev/null
    # Wait for processes to terminate gracefully
    sleep 5
}

# Main function to check screen sessions, terminate processes, and reboot if necessary
check_and_reboot() {
    screen_count=$(count_screen_sessions)
    if [ "$screen_count" -lt 1 ]; then
        echo "Only $screen_count screen sessions found. Terminating processes and rebooting the computer..."
        terminate_processes
        shutdown -r 1
        sleep 90
    else
        echo "Number of screen sessions is sufficient ($screen_count). No action required."
    fi
}

# Run the main function
check_and_reboot
