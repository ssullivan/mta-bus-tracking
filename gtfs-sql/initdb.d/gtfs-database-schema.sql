CREATE TABLE IF NOT EXISTS feeds (
  feed_index BIGSERIAL PRIMARY KEY,
  feed_start_date TIMESTAMP NOT NULL,
  feed_end_date TIMESTAMP NOT NULL,
  feed_name TEXT NOT NULL
);

CREATE INDEX IF NOT EXISTS feeds_start_end_date_index ON feeds(feed_start_date, feed_end_date);

/*
https://developers.google.com/transit/gtfs/reference/agency-file

agency_id,agency_name,agency_url,agency_timezone,agency_lang,agency_phone,agency_fare_url
1,Maryland Transit Administration,http://mta.maryland.gov/,America/New_York,en,410-539-5000,
*/

CREATE TABLE IF NOT EXISTS agency
(
  agency_index BIGSERIAL PRIMARY KEY,
  feed_index BIGINT,
  agency_id text NOT NULL,
  agency_name text,
  agency_url text,
  agency_timezone text,
  agency_lang text,
  agency_phone text,
  CONSTRAINT feed_agency_unique UNIQUE (feed_index, agency_id)
);

/*
calendar.txt
https://developers.google.com/transit/gtfs/reference/calendar-file

service_id,monday,tuesday,wednesday,thursday,friday,saturday,sunday,start_date,end_date
1,1,1,1,1,1,0,0,20170618,20170902
*/

CREATE TABLE IF NOT EXISTS calendar
(
  feed_index BIGINT,
  service_index BIGSERIAL PRIMARY KEY,
  service_id text,
  monday INTEGER,
  tuesday INTEGER,
  wednesday INTEGER,
  thursday INTEGER,
  friday INTEGER,
  saturday INTEGER,
  sunday INTEGER,
  start_date DATE,
  end_date DATE
);

/*
calendar_dates.txt
service_id,date,exception_type
3,20170704,1
*/

CREATE TABLE IF NOT EXISTS calendar_dates
(
  feed_index BIGINT,
  service_index BIGINT NOT NULL,
  service_id text,
  exception_date DATE,
  exception_type INTEGER
);


/*
routes.txt
https://developers.google.com/transit/gtfs/reference/routes-file

route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color
9521,1,21,WOODBERRY - CANTON CROSSING,,3,,879A8C,FFFFFF
*/

CREATE TABLE IF NOT EXISTS routes
(
  feed_index BIGINT NOT NULL,
  route_index BIGSERIAL PRIMARY KEY,
  route_id text NOT NULL,
  agency_index BIGINT,
  route_short_name text,
  route_long_name text,
  route_desc text,
  route_type INTEGER,
  route_url text,
  route_color text,
  route_text_color text,
  CONSTRAINT feed_route_unique UNIQUE (feed_index, route_id)
);

/*
shapes.txt
https://developers.google.com/transit/gtfs/reference/shapes-file

shape_id,shape_pt_lat,shape_pt_lon,shape_pt_sequence,shape_dist_traveled
97987,39.239290,-76.503280,1,0.0000
*/

CREATE TABLE IF NOT EXISTS shapes
(
  feed_index BIGINT NOT NULL,
  shape_index BIGSERIAL,
  shape_id text NOT NULL,
  shape_pt_lat DOUBLE PRECISION,
  shape_pt_lon DOUBLE PRECISION,
  shape_pt_sequence INTEGER,
  shape_dist_traveled NUMERIC,
  CONSTRAINT shapes_primary_key PRIMARY KEY (shape_index, shape_pt_sequence)
);

CREATE INDEX feed_shapes_index ON shapes (feed_index, shape_id);

/*
stop_times.txt
https://developers.google.com/transit/gtfs/reference/stop_times-file

trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type,shape_dist_traveled
1984728,11:00:00,11:00:00,1992,1,,0,0,
*/

CREATE TABLE IF NOT EXISTS stop_times
(
  trip_index BIGINT NOT NULL,
  arrival_time TIMESTAMP,
  departure_time TIMESTAMP,
  stop_id INTEGER NOT NULL,
  stop_sequence INTEGER,
  stop_headsign text,
  pickup_type text,
  drop_off_type text,
  CONSTRAINT stop_times_primary_key PRIMARY KEY (trip_index, stop_sequence)
);

CREATE INDEX trip_stop_index ON stop_times (trip_index, stop_id);

/*
stops.txt
https://developers.google.com/transit/gtfs/reference/stops-file

stop_id,stop_code,stop_name,stop_desc,stop_lat,stop_lon,zone_id,stop_url,location_type,parent_station,wheelchair_boarding
1,1,CYLBURN AVE & GREENSPRING AVE fs wb,,39.350945,-76.660393,,,,,0
*/

CREATE TABLE IF NOT EXISTS stops
(
  feed_index BIGINT NOT NULL,
  stop_index BIGSERIAL PRIMARY KEY,
  stop_id INTEGER,
  stop_code text,
  stop_name text,
  stop_desc text,
  stop_lat DOUBLE PRECISION,
  stop_lon DOUBLE PRECISION,
  zone_id INTEGER,
  stop_url text,
  location_type INTEGER,
  parent_station INTEGER,
  CONSTRAINT feed_stop_unique UNIQUE (feed_index, stop_id)
);

/*
trips.txt
https://developers.google.com/transit/gtfs/reference/trips-file

route_id,service_id,trip_id,trip_headsign,trip_short_name,direction_id,block_id,shape_id
9509,1,1984764,NV MONDAWMIN,,0,317699,97989
*/
CREATE TABLE IF NOT EXISTS trips
(
  feed_index BIGINT NOT NULL,
  trip_index BIGSERIAL PRIMARY KEY,
  route_id INTEGER NOT NULL,
  service_index BIGINT,
  trip_id text,
  trip_headsign text,
  trip_short_name text,
  direction_id INTEGER,
  block_id INTEGER,
  shape_index INTEGER,
  CONSTRAINT feed_trip_unique UNIQUE (feed_index, trip_id)
);

CREATE TABLE IF NOT EXISTS service_indexes_per_date (
  feed_index BIGINT NOT NULL,
  date TIMESTAMP NOT NULL,
  service_index BIGINT NOT NULL
);

CREATE INDEX IF NOT EXISTS service_feed_date_index ON service_indexes_per_date (feed_index, date);