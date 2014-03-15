package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown =  true)
public abstract class LinkMixin {
    @JsonProperty("type")
    String type;

    @JsonProperty("url")
    URL url;

}
