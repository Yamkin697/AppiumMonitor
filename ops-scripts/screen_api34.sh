#!/bin/bash
cd /home/lookyerrorbot/AppiumMonitor/ops-scripts && sh start_appium_monitor_API_34.sh;
bash -c /sbin/shutdown -r 1;
sleep 90;
