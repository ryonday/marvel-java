package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class StoryMixin extends DescribedCoreEntityMixin {

    @JsonProperty("title")
    String title;

    @JsonProperty("type")
    String type;

    @JsonProperty("creators")
    ResourceList<CreatorSummary> creators;

    @JsonProperty("characters")
    ResourceList<CharacterSummary> characters;

    @JsonProperty("series")
    ResourceList<SeriesSummary> series;

    @JsonProperty("comics")
    ResourceList<ComicSummary> comics;

    @JsonProperty("events")
    ResourceList<EventSummary> events;

    @JsonProperty("originalIssue")
    ComicSummary originalIssue;
}
