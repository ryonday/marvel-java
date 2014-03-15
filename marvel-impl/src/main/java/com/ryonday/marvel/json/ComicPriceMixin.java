package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ComicPriceMixin {

    @JsonProperty("type")
    String type;

    @JsonProperty("price")
    float price;
}
