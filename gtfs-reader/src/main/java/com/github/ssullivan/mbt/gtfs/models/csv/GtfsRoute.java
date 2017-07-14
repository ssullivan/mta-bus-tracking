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
public abstract class GtfsRoute {
    @JsonProperty("route_id")
    public abstract String id();

    @JsonProperty("agency_id")
    public abstract String agencyId();

    @Nullable
    @JsonProperty("route_short_name")
    public abstract String shortName();

    @Nullable
    @JsonProperty("route_long_name")
    public abstract String longName();

    @Nullable
    @JsonProperty("route_desc")
    public abstract String description();

    @Nullable
    @JsonProperty("route_type")
    public abstract String type();

    @Nullable
    @JsonProperty("route_url")
    public abstract String url();

    @Nullable
    @JsonProperty("route_color")
    public abstract String color();

    @Nullable
    @JsonProperty("route_text_color")
    public abstract String textColor();

    @JsonCreator
    static GtfsRoute create(@JsonProperty("route_id") String routeId,
                            @JsonProperty("agency_id") String agencyId,
                            @JsonProperty("route_short_name") String shortName,
                            @JsonProperty("route_long_name") String longName,
                            @JsonProperty("route_desc") String description,
                            @JsonProperty("route_type") String type,
                            @JsonProperty("route_url") String url,
                            @JsonProperty("route_color") String color,
                            @JsonProperty("route_text_color") String textColor) {
        return new AutoValue_GtfsRoute(routeId, agencyId,
                shortName, longName, description, type, url, color, textColor);
    }
}
