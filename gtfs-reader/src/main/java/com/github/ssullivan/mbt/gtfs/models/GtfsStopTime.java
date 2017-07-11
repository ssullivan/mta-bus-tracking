package com.github.ssullivan.mbt.gtfs.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class GtfsStopTime {
    @JsonProperty("trip_id")
    public abstract String tripId();

    @Nullable
    @JsonProperty("arrival_time")
    public abstract ZonedDateTime arrivalTime();

    @Nullable
    @JsonProperty("departure_time")
    public abstract ZonedDateTime departureTime();

    @JsonProperty("stop_id")
    public abstract String stopId();

    @Nullable
    @JsonProperty("stop_headsign")
    public abstract String stopHeadSign();

    @Nullable
    @JsonProperty("pickup_type")
    public abstract String pickupType();

    @Nullable
    @JsonProperty("drop_off_type")
    public abstract String dropoffType();

    @Nullable
    @JsonProperty("shape_dist_traveled")
    public abstract Double shapeDistTraveled();

    @JsonCreator
    static GtfsStopTime create(@JsonProperty("trip_id") String tripId,
                               @JsonProperty("arrival_time") ZonedDateTime arrivalTime,
                               @JsonProperty("departure_time") ZonedDateTime departureTime,
                               @JsonProperty("stop_id") String stopId,
                               @JsonProperty("stop_headsign") String stopHeadSign,
                               @JsonProperty("pickup_type") String pickupType,
                               @JsonProperty("dropoff_type") String dropoffType,
                               @JsonProperty("shape_dist_traveled") Double shapeDistTraveled) {
        return new AutoValue_GtfsStopTime(tripId, arrivalTime,
                departureTime, stopId, stopHeadSign, pickupType, dropoffType, shapeDistTraveled);
    }
}
