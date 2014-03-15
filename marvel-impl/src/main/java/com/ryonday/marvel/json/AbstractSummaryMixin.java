package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractSummaryMixin {

    @JsonProperty("resourceURI")
    URL resourceURI;

    @JsonProperty("name")
    String name;
}
