#!/bin/bash 
CMDVAR="-Dcse.service.registry.address=https://$CONFIGIP:30100 -Dcse.config.client.serverUri=https://$CONFIGIP:30103 -Dcse.monitor.client.serverUri=https://$CONFIGIP:30109 -Dcse.credentials.accessKey=$AK -Dcse.credentials.secretKey=$SK -Dcse.credentials.project=$PROJECT"  
trap 'ps -ax | grep -w activity |grep -v grep |cut -c 1-6 |xargs kill -15;sleep 5s '  SIGTERM
#nohup java $CMDVAR -jar activity-1.0.0-SNAPSHOT.jar 2>&1 &
nohup java -jar activity-1.0.0-SNAPSHOT.jar 2>&1 &
wait $!