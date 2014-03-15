package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.CoreEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class DataContainerMixin<E extends CoreEntity> {

    @JsonProperty("offset")
    int offset;

    @JsonProperty("limit")
    int limit;

    @JsonProperty("total")
    int total;

    @JsonProperty("count")
    int call;

    @JsonProperty("results")
    List<E> results;
}
