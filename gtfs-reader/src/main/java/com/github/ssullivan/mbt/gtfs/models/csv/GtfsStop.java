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
public abstract class GtfsStop {
    @JsonProperty("stop_id")
    public abstract Integer id();

    @Nullable
    @JsonProperty("stop_code")
    public abstract String code();

    @Nullable
    @JsonProperty("stop_name")
    public abstract String name();

    @Nullable
    @JsonProperty("stop_desc")
    public abstract String description();

    @Nullable
    @JsonProperty("stop_lat")
    public abstract Double lat();

    @Nullable
    @JsonProperty("stop_lon")
    public abstract Double lon();

    @Nullable
    @JsonProperty("zone_id")
    public abstract Integer zoneId();

    @Nullable
    @JsonProperty("stop_url")
    public abstract String url();

    @Nullable
    @JsonProperty("location_type")
    public abstract Integer locationType();

    @Nullable
    @JsonProperty("parent_station")
    public abstract Integer parentStation();

    @Nullable
    @JsonProperty("wheelchair_boarding")
    public abstract Integer wheelchairBoarding();

    @Nullable
    @JsonProperty("stop_timezone")
    public abstract String timeZone();


    @JsonCreator
    static GtfsStop create(@JsonProperty("stop_id") Integer stopId,
                           @JsonProperty("stop_code") String stopCode,
                           @JsonProperty("stop_name") String stopName,
                           @JsonProperty("stop_desc") String stopDesc,
                           @JsonProperty("stop_lat") Double stopLat,
                           @JsonProperty("stop_lon") Double stopLon,
                           @JsonProperty("zone_id") Integer zoneId,
                           @JsonProperty("stop_url") String url,
                           @JsonProperty("location_type") Integer locationType,
                           @JsonProperty("parent_station") Integer parentStation,
                           @JsonProperty("wheelchair_boarding") Integer wheelchairBoarding,
                           @JsonProperty("stop_timezone") String stopTimeZone) {
        return new AutoValue_GtfsStop(
                stopId,
                stopCode,
                stopName,
                stopDesc,
                stopLat,
                stopLon,
                zoneId,
                url,
                locationType,
                parentStation,
                wheelchairBoarding,
                stopTimeZone
        );
    }
}
