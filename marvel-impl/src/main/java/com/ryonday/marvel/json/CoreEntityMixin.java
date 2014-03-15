package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.Image;
import com.ryonday.marvel.api.data.Link;
import org.joda.time.DateTime;

import java.net.URL;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown =  true)
public abstract class CoreEntityMixin {

    @JsonProperty("id")
    int id;

    @JsonProperty("description")
    String description;

    @JsonProperty("modified")
    DateTime modified;

    @JsonProperty("resourceURI")
    URL resourceURI;

    @JsonProperty("urls")
    List<Link> urls;

    @JsonProperty("thumbnail")
    Image thumbnail;
}
