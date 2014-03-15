package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CreatorMixin extends CoreEntityMixin {

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("middleName")
    String middleName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("suffix")
    String suffix;

    @JsonProperty("fullName")
    String fullName;

    @JsonProperty("comics")
    ResourceList<ComicSummary> comics;

    @JsonProperty("series")
    ResourceList<SeriesSummary> series;

    @JsonProperty("stories")
    ResourceList<StorySummary> stories;

    @JsonProperty("events")
    ResourceList<EventSummary> events;
}
