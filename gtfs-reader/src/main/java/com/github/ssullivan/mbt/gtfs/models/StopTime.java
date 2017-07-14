package com.github.ssullivan.mbt.gtfs.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsStopTime;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsTrip;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class StopTime {
    @JsonProperty("trip")
    public abstract Trip trip();

    @Nullable
    @JsonProperty("arrival_time")
    public abstract ZonedDateTime arrivalTime();

    @Nullable
    @JsonProperty("departure_time")
    public abstract ZonedDateTime departureTime();

    @JsonProperty("stop")
    public abstract Stop stop();

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

    @AutoValue.Builder
    public static abstract class Builder {
        @JsonProperty("trip")
        public abstract Builder trip(Trip trip);

        @Nullable
        @JsonProperty("arrival_time")
        public abstract Builder arrivalTime(ZonedDateTime zonedDateTime);

        @Nullable
        @JsonProperty("departure_time")
        public abstract Builder departureTime(ZonedDateTime zonedDateTime);

        @JsonProperty("stop")
        public abstract Builder stop(Stop stop);

        @Nullable
        @JsonProperty("stop_headsign")
        public abstract Builder stopHeadSign(String stopHeadSign);

        @Nullable
        @JsonProperty("pickup_type")
        public abstract Builder pickupType(String pickupType);

        @Nullable
        @JsonProperty("drop_off_type")
        public abstract Builder dropoffType(String dropOffType);

        @Nullable
        @JsonProperty("shape_dist_traveled")
        public abstract Builder shapeDistTraveled(Double distTraveled);

        public abstract StopTime build();
    }

}
