#!/bin/sh
echo // Date init start // `date`  
echo "Setting options ndots:1 in /etc/resolv.conf"
echo "options ndots:1" >> /etc/resolv.conf

echo "Running Application ..."
java -Xms128M -Xmx1G  -jar /data/banco-base-web-api/code-challenge-web-api.jar --spring.config.location=file:/data/banco-base-web-api/cfg/application.properties

echo "Up...."
