package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TextObjectMixin {

    @JsonProperty("type")
    String type;

    @JsonProperty("language")
    Locale language;

    @JsonProperty("text")
    String text;
}
