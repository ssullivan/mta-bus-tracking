package com.github.ssullivan.mbt.client.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class MtaListOfLines {
    public abstract String version();

    public abstract ImmutableList<MtaLineWithDirInfo> result();

    public abstract String responseCode();
}
