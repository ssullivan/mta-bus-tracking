#!/usr/bin/env bash
TODAY=$(date --iso-8601 -u)
EPOCH=$(date +%s)
FILENAME="TripUpdates_$EPOCH.pb"
mkdir -p "data/TripUpdates/$TODAY"
curl http://gtfsrt.mta.maryland.gov:8888/TMGTFSRealTimeWebService/TripUpdate/TripUpdates.pb \
    -o "data/TripUpdates/$TODAY/$FILENAME"