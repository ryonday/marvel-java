package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.AbstractSummary;

import java.net.URL;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ResourceListMixin<E extends AbstractSummary> {

    @JsonProperty("available")
    int available;

    @JsonProperty("returned")
    int returned;

    @JsonProperty("collectionURI")
    URL collectionURI;

    @JsonProperty("items")
    List<E> items;
}
