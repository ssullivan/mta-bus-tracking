package com.github.ssullivan.mbt.client.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class MtaDirInfo {
    @JsonProperty("lineDirId")
    public abstract String lineDirId();

    @JsonProperty("dirName")
    public abstract String dirName();

    @JsonProperty("pttrnDestSigns")
    public abstract ImmutableList<MtaPatternDestSign> patterndestSigns();


    static MtaDirInfo create(@JsonProperty("lineDirId") String lineDirId,
                             @JsonProperty("dirName") String dirName,
                             @JsonProperty("pttrnDestSigns") String patternDestSigns) {
        return null;
    }
}
