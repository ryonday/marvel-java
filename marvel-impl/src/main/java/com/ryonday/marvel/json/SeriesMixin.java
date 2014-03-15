package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SeriesMixin extends DescribedCoreEntityMixin {

    @JsonProperty("title")
    String title;

    @JsonProperty("startYear")
    int startYear;

    @JsonProperty("endYear")
    int endYear;

    @JsonProperty("rating")
    String rating;

    @JsonProperty("comics")
    ResourceList<ComicSummary> comics;

    @JsonProperty("stories")
    ResourceList<StorySummary> stories;

    @JsonProperty("events")
    ResourceList<EventSummary> events;

    @JsonProperty("characters")
    ResourceList<CharacterSummary> characters;

    @JsonProperty("creators")
    ResourceList<CreatorSummary> creators;

    @JsonProperty("next")
    SeriesSummary next;

    @JsonProperty("previous")
    SeriesSummary previous;
}
