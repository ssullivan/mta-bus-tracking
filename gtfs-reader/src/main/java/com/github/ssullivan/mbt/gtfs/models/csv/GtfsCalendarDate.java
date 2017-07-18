package com.github.ssullivan.mbt.gtfs.models.csv;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class GtfsCalendarDate {
    @JsonProperty("service_id")
    public abstract String id();

    @JsonProperty("date")
    public abstract LocalDate date();

    @JsonProperty("exception_type")
    public abstract String exceptionType();

    @JsonCreator
    static GtfsCalendarDate create(@JsonProperty("service_id") String serviceId,
                                   @JsonProperty("date") @JsonDeserialize(using = Jackson.YearMonthDayDeserializer.class) LocalDate date,
                                   @JsonProperty("exception_type") String exceptionType) {
        return new AutoValue_GtfsCalendarDate(serviceId, date, exceptionType);
    }
}
