CREATE TABLE IF NOT EXISTS events (
  service_date TIMESTAMP NOT NULL,
  trip_index BIGINT NOT NULL,
  vehicle_id INTEGER NOT NULL,
  stop_id INTEGER NOT NULL,
  est_dep_utc TIMESTAMP,
  dep_accuracy INTEGER,
  sched_dep_utc TIMESTAMP,
	sched_dep_date TIMESTAMP,
	sched_dep_hour NUMERIC(2),
	route_id TEXT NOT NULL,
	direction_id BOOLEAN NOT NULL,
  CONSTRAINT events_primary_key PRIMARY KEY (service_date, trip_index, vehicle_id, stop_id)
);

CREATE INDEX events_index ON events(sched_dep_date,
                                    sched_dep_hour,
                                    route_id,
                                    direction_id);

CREATE TABLE IF NOT EXISTS adherence (
  date TIMESTAMP NOT NULL,
	hour NUMERIC(2) NOT NULL,
  route_id text NOT NULL,
  direction_id NUMERIC(1) NOT NULL,
  stop_id INTEGER NOT NULL,
  early INTEGER NOT NULL,
  on_time INTEGER NOT NULL,
  late INTEGER NOT NULL,
  CONSTRAINT adherence_primary_key
	  PRIMARY KEY (date, hour, route_id, direction_id, stop_id)
);
