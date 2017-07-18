package com.github.ssullivan.mbt.gtfs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ssullivan.mbt.gtfs.models.csv.*;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class GtfsData {

    @JsonProperty("agencies")
    public abstract ImmutableList<GtfsAgency> agencies();

    @JsonProperty("calendars")
    public abstract ImmutableList<GtfsCalendar> calendars();

    @JsonProperty("calendarDates")
    public abstract ImmutableList<GtfsCalendarDate> calendarDates();

    @JsonProperty("routes")
    public abstract ImmutableList<GtfsRoute> routes();

    @JsonProperty("shapePoints")
    public abstract ImmutableList<GtfsShapePoint> shapePoints();

    public abstract ImmutableList<GtfsStop> stops();

    @JsonProperty("stopTimes")
    public abstract ImmutableList<GtfsStopTime> stopTimes();

    public abstract ImmutableList<GtfsTrip> trips();

    @AutoValue.Builder
    public abstract static class Builder {
        abstract ImmutableList.Builder<GtfsAgency> agenciesBuilder();

        public abstract Builder agencies(List<GtfsAgency> agencies);

        public Builder addAgency(GtfsAgency gtfsAgency) {
            agenciesBuilder().add(gtfsAgency);
            return this;
        }

        abstract ImmutableList.Builder<GtfsCalendar> calendarsBuilder();

        public abstract Builder calendars(List<GtfsCalendar> calendars);

        public Builder addCalendar(GtfsCalendar gtfsCalendar) {
            calendarsBuilder().add(gtfsCalendar);
            return this;
        }

        abstract ImmutableList.Builder<GtfsCalendarDate>  calendarDatesBuilder();

        public abstract Builder calendarDates(List<GtfsCalendarDate> calendarDates);

        public Builder addCalendarDate(GtfsCalendarDate calendarDate) {
            calendarDatesBuilder().add(calendarDate);
            return this;
        }

        abstract ImmutableList.Builder<GtfsRoute> routesBuilder();

        public abstract Builder routes(List<GtfsRoute> routes);

        public Builder addRoute(GtfsRoute gtfsRoute) {
            routesBuilder().add(gtfsRoute);
            return this;
        }

        abstract ImmutableList.Builder<GtfsShapePoint> shapePointsBuilder();

        public abstract Builder shapePoints(List<GtfsShapePoint> shapePoints);

        public Builder addShapePoint(GtfsShapePoint shapePoint) {
            shapePointsBuilder().add(shapePoint);
            return this;
        }

        abstract ImmutableList.Builder<GtfsStop> stopsBuilder();

        public abstract Builder stops(List<GtfsStop> stops);

        public Builder addStop(GtfsStop stop) {
            stopsBuilder()
                    .add(stop);
            return this;
        }

        abstract ImmutableList.Builder<GtfsStopTime> stopTimesBuilder();

        public abstract Builder stopTimes(List<GtfsStopTime> stopTimes);

        public Builder addStopTime(GtfsStopTime gtfsStopTime) {
            stopTimesBuilder()
                    .add(gtfsStopTime);
            return this;
        }

        abstract ImmutableList.Builder<GtfsTrip> tripsBuilder();

        public abstract Builder trips(List<GtfsTrip> trips);

        public Builder addTrip(GtfsTrip trip) {
            tripsBuilder()
                    .add(trip);
            return this;
        }

        public abstract GtfsData build();
    }

    public static Builder builder() {
        return new AutoValue_GtfsData.Builder();
    }
}
