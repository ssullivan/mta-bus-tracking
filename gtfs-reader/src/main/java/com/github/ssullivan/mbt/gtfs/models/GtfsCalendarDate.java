package com.github.ssullivan.mbt.gtfs.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class GtfsCalendarDate {
    @JsonProperty("serviceId")
    public abstract String id();

    @JsonProperty("date")
    public abstract ZonedDateTime date();

    @JsonProperty("exception_type")
    public abstract String exceptionType();

    @JsonCreator
    static GtfsCalendarDate create(@JsonProperty("serviceId") String serviceId,
                                   @JsonProperty("date") ZonedDateTime date,
                                   @JsonProperty("exception_type") String exceptionType) {
        return new AutoValue_GtfsCalendarDate(serviceId, date, exceptionType);
    }
}
