package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.CoreEntity;
import com.ryonday.marvel.api.data.DataContainer;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ApiReturnMixin<E extends CoreEntity> {

    @JsonProperty("code")
    int code;

    @JsonProperty("status")
    String status;

    @JsonProperty("copyright")
    String copyright;

    @JsonProperty("attributionText")
    String attributionText;

    @JsonProperty("attributionHTML")
    String attributionHtml;

    @JsonProperty("etag")
    String eTag;

    @JsonProperty("data")
    DataContainer<E> data;
}
