CREATE TABLE IF NOT EXISTS positions (
  timestamp_utc TIMESTAMP NOT NULL,
  vehicle_id INTEGER NOT NULL,
  latitude DOUBLE PRECISION NOT NULL,
  longitude DOUBLE PRECISION NOT NULL,
  bearing DOUBLE PRECISION NOT NULL,
  progress NUMERIC(1) NOT NULL,
  service_date TIMESTAMP NOT NULL,
  trip_index BIGINT NOT NULL,
  block_assigned NUMERIC(1) NOT NULL,
  next_stop_id INTEGER,
  dist_along_route DOUBLE PRECISION,
  dist_from_stop DOUBLE PRECISION,
  CONSTRAINT positions_primary_key
  PRIMARY KEY (timestamp_utc, vehicle_id)
);
