#!/usr/bin/env bash
mkdir -p data
curl https://transitfeeds-data.s3-us-west-1.amazonaws.com/public/feeds/mta-maryland/247/20170706/gtfs.zip -o data/latest.zip