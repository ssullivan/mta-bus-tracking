package com.github.ssullivan.mbt.gtfs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class GtfsFeed {
    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("startDate")
    public abstract ZonedDateTime startDate();

    @Nullable
    @JsonProperty("endDate")
    public abstract ZonedDateTime endDate();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder name(String name);

        public abstract Builder startDate(ZonedDateTime dateTime);

        public abstract Builder endDate(ZonedDateTime dateTime);

        public abstract GtfsFeed build();
    }

    public static Builder builder() {
        return new AutoValue_GtfsFeed.Builder();
    }
}
