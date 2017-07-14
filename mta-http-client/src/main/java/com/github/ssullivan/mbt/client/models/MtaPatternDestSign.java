package com.github.ssullivan.mbt.client.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * Created by catal on 7/11/2017.
 */
@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class MtaPatternDestSign {
    public abstract String patternId();

    public abstract String destinationSign();

    @JsonCreator
    static MtaPatternDestSign create(@JsonProperty("patternId") String patternId,
                                     @JsonProperty("destinationSign") String destinationSign)
    {
        return null;
    }
}
