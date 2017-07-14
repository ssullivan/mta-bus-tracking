# mta-bus-tracking

[![Build Status](https://travis-ci.org/ssullivan/mta-bus-tracking.svg?branch=master)](https://travis-ci.org/ssullivan/mta-bus-tracking)
[![codecov](https://codecov.io/github/ssullivan/mta-bus-tracking/coverage.svg?branch=master)](https://codecov.io/github/ssullivan/mta-bus-tracking?branch=master)

## Description
Java library for doing analysis of MTA bus [data](http://transitfeeds.com/p/mta-maryland)

## Data Source


## Developers

### IntelliJ

You may need to turn on annotation processing if you don't use the the following command
to setup the project.

```code
gradlew idea
```

You will also want to turn off the setting 'Separate Module Per SourceSet'

### Eclipse

## Running Locally

### Launch the database

The following will create a database and initialize it with the gtfs schema.


``bash
docker-compose -f gtfs-sql/docker-compose.yml up
``
