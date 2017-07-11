#!/usr/bin/env bash
mkdir -p data
curl http://transitfeeds.com/p/mta-maryland/247/latest/download -o data/latest.zip