package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MarvelCharacterMixin extends DescribedCoreEntityMixin {

    @JsonProperty("name")
    String name;

    @JsonProperty("comics")
    ResourceList<ComicSummary> comics;

    @JsonProperty("stories")
    ResourceList<StorySummary> stories;

    @JsonProperty("events")
    ResourceList<EventSummary> events;

    @JsonProperty("series")
    ResourceList<SeriesSummary> series;
}
