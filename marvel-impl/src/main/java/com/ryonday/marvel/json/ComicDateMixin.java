package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ComicDateMixin {

    @JsonProperty("type")
    String type;

    @JsonProperty("date")
    DateTime Date;

}
