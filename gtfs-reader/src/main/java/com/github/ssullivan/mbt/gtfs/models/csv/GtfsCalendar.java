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
public abstract class GtfsCalendar {
    @JsonProperty("service_id")
    public abstract String id();

    @JsonProperty("monday")
    public abstract Integer monday();

    @JsonProperty("tuesday")
    public abstract Integer tuesday();

    @JsonProperty("wednesday")
    public abstract Integer wednesday();

    @JsonProperty("thursday")
    public abstract Integer thursday();

    @JsonProperty("friday")
    public abstract Integer friday();

    @JsonProperty("saturday")
    public abstract Integer saturday();

    @JsonProperty("sunday")
    public abstract Integer sunday();

    @JsonProperty("start_date")
    public abstract LocalDate startDate();

    @JsonProperty("end_date")
    public abstract LocalDate endDate();

    @JsonCreator
    static GtfsCalendar create(@JsonProperty("service_id") String serviceId,
                               @JsonProperty("monday") Integer monday,
                               @JsonProperty("tuesday") Integer tuesday,
                               @JsonProperty("wednesday") Integer wednesday,
                               @JsonProperty("thursday") Integer thursday,
                               @JsonProperty("friday") Integer friday,
                               @JsonProperty("saturday") Integer saturday,
                               @JsonProperty("sunday") Integer sunday,
                               @JsonProperty("start_date") @JsonDeserialize(using = Jackson.YearMonthDayDeserializer.class) LocalDate startDate,
                               @JsonProperty("end_date") @JsonDeserialize(using = Jackson.YearMonthDayDeserializer.class) LocalDate endDate)
    {
        return new AutoValue_GtfsCalendar(serviceId, monday, tuesday, wednesday,
                thursday, friday, saturday, sunday, startDate, endDate);
    }

}
