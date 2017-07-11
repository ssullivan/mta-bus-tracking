package com.github.ssullivan.mbt.gtfs.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class GtfsShapePoint {
    @JsonProperty("shape_id")
    public abstract String id();

    @Nullable
    @JsonProperty("shape_pt_lat")
    public abstract Double lat();

    @Nullable
    @JsonProperty("shape_pt_lon")
    public abstract Double lon();

    @Nullable
    @JsonProperty("shape_pt_sequence")
    public abstract Integer sequence();

    @Nullable
    @JsonProperty("shape_dist_traveled")
    public abstract Double distanceTraveled();

    @JsonCreator
    static GtfsShapePoint create(@JsonProperty("shape_id") String shapeId,
                       @JsonProperty("shape_pt_lat") Double lat,
                       @JsonProperty("shape_pt_lon") Double lon,
                       @JsonProperty("shape_pt_sequence") Integer sequence,
                       @JsonProperty("shape_dist_traveled") Double distTraveled) {

        return new AutoValue_GtfsShapePoint(shapeId, lat, lon, sequence, distTraveled);
    }
}
