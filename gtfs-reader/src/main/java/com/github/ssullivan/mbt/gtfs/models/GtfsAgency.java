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
public abstract class GtfsAgency {
    @JsonProperty("agency_id")
    public abstract String id();

    @JsonProperty("agency_name")
    public abstract String name();

    @Nullable
    @JsonProperty("agency_url")
    public abstract String url();

    @Nullable
    @JsonProperty("agency_timezone")
    public abstract String timeZone();

    @Nullable
    @JsonProperty("agency_lang")
    public abstract String lang();

    @Nullable
    @JsonProperty("agency_phone")
    public abstract String phoneNumber();

    @Nullable
    @JsonProperty("agency_fare_url")
    public abstract String fareUrl();

    @Nullable
    @JsonProperty("agency_email")
    public abstract String email();


    @JsonCreator
    static GtfsAgency create(@JsonProperty("agency_id") String agencyId,
                             @JsonProperty("agency_name") String agencyName,
                             @JsonProperty("agency_url") String agencyUrl,
                             @JsonProperty("agency_timezone") String agencyTimeZone,
                             @JsonProperty("agency_lang") String agencyLang,
                             @JsonProperty("agency_phone") String agencyPhone,
                             @JsonProperty("agency_fare_url") String agencyFareUrl,
                             @JsonProperty("agency_email") String agencyEmail) {
      return new AutoValue_GtfsAgency(agencyId, agencyName, agencyUrl, agencyTimeZone, agencyLang, agencyPhone,
              agencyFareUrl, agencyEmail);
    }
}
