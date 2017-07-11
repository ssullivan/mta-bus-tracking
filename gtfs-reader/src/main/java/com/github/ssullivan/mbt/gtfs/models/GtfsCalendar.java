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
public abstract class GtfsCalendar {
    @JsonProperty("service_id")
    public abstract String id();

    @JsonProperty("monday")
    public abstract Boolean monday();

    @JsonProperty("tuesday")
    public abstract Boolean tuesday();

    @JsonProperty("wednesday")
    public abstract Boolean wednesday();

    @JsonProperty("thursday")
    public abstract Boolean thursday();

    @JsonProperty("friday")
    public abstract Boolean friday();

    @JsonProperty("saturday")
    public abstract Boolean saturday();

    @JsonProperty("sunday")
    public abstract Boolean sunday();

    @JsonProperty("start_date")
    public abstract ZonedDateTime startDate();

    @JsonProperty("end_date")
    public abstract ZonedDateTime endDate();

    @JsonCreator
    static GtfsCalendar create(@JsonProperty("service_id") String serviceId,
                               @JsonProperty("monday") Boolean monday,
                               @JsonProperty("tuesday") Boolean tuesday,
                               @JsonProperty("wednesday") Boolean wednesday,
                               @JsonProperty("thursday") Boolean thursday,
                               @JsonProperty("friday") Boolean friday,
                               @JsonProperty("saturday") Boolean saturday,
                               @JsonProperty("sunday") Boolean sunday,
                               @JsonProperty("start_date") ZonedDateTime startDate,
                               @JsonProperty("end_date") ZonedDateTime endDate)
    {
        return new AutoValue_GtfsCalendar(serviceId, monday, tuesday, wednesday,
                thursday, friday, saturday, sunday, startDate, endDate);
    }

}
