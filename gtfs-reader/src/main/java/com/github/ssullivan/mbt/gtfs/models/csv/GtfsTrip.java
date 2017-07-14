package com.github.ssullivan.mbt.gtfs.models.csv;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class GtfsTrip {
    @JsonProperty("trip_id")
    public abstract String id();

    @JsonProperty("route_id")
    public abstract String routeId();

    @JsonProperty("service_id")
    public abstract String serviceId();

    @Nullable
    @JsonProperty("trip_headsign")
    public abstract String headSign();

    @Nullable
    @JsonProperty("trip_short_name")
    public abstract String shortName();

    @JsonProperty("direction_id")
    public abstract String directionId();

    @JsonProperty("block_id")
    public abstract String blockId();

    @JsonProperty("shape_id")
    public abstract String shapeId();


    @JsonCreator
    static GtfsTrip create(@JsonProperty("trip_id") String tripId,
                           @JsonProperty("route_id") String routeId,
                           @JsonProperty("service_id") String serviceId,
                           @JsonProperty("trip_headsign") String tripHeadSign,
                           @JsonProperty("trip_short_name") String tripShortName,
                           @JsonProperty("direction_id") String directionId,
                           @JsonProperty("block_id") String blockId,
                           @JsonProperty("shape_id") String shapeId) {

        return new AutoValue_GtfsTrip(tripId, routeId, serviceId,
                tripHeadSign, tripShortName, directionId,
                blockId, shapeId);
    }

}
