package com.github.ssullivan.mbt.client.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class MtaLineWithDirInfo {
    public abstract String lineId();

    public abstract String abbr();

    public abstract String name();

    public abstract String color();

    public abstract ImmutableList<MtaDirInfo> drInfos();


}
