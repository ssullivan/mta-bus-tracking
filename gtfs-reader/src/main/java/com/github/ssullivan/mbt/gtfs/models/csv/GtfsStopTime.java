package com.github.ssullivan.mbt.gtfs.models.csv;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    public abstract String arrivalTime();

    @Nullable
    @JsonProperty("arrival_time_seconds")
    public Long arrivalTimeSeconds() {
        return toSeconds(arrivalTime());
    }



    private static Long toSeconds(final String hms) {
        if (hms == null) return -1L;
        String parts[] = hms.trim().split("\\:", 3);

        if (parts.length != 3) {
            return -1L;
        }
        return Long.valueOf(parts[0]) * 3600 + Integer.valueOf(parts[1]) * 60 + Integer.valueOf(parts[2]);
    }

    @Nullable
    @JsonProperty("departure_time")
    public abstract String departureTime();

    @Nullable
    @JsonProperty("departure_time_seconds")
    public Long departueTimeSeconds() {
       return toSeconds(departureTime());
    }

    @JsonProperty("stop_id")
    public abstract String stopId();

    @JsonProperty("stop_sequence")
    public abstract Integer stopSequence();

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
                               @JsonProperty("arrival_time")
                               String arrivalTime,
                               @JsonProperty("departure_time")
                                String departureTime,
                               @JsonProperty("stop_id") String stopId,
                               @JsonProperty("stop_headsign") String stopHeadSign,
                               @JsonProperty("stop_sequence") Integer stopSequence,
                               @JsonProperty("pickup_type") String pickupType,
                               @JsonProperty("dropoff_type") String dropoffType,
                               @JsonProperty("shape_dist_traveled") Double shapeDistTraveled) {
        return new AutoValue_GtfsStopTime(tripId, arrivalTime.trim(),
                departureTime.trim(), stopId, stopSequence, stopHeadSign, pickupType, dropoffType, shapeDistTraveled);
    }
}
