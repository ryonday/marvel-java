package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ryonday.marvel.api.data.*;
import org.joda.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class EventMixin extends DescribedCoreEntityMixin {

    @JsonProperty("title")
    String title;

    @JsonProperty("start")
    @JsonDeserialize( using = LocalDateDeserializer.class )
    LocalDate start;

    @JsonProperty("end")
    @JsonDeserialize( using = LocalDateDeserializer.class )
    LocalDate end;

    @JsonProperty("comics")
    ResourceList<ComicSummary> comics;

    @JsonProperty("stories")
    ResourceList<StorySummary> stories;

    @JsonProperty("characters")
    ResourceList<CharacterSummary> characters;

    @JsonProperty("series")
    ResourceList<SeriesSummary> series;

    @JsonProperty("creators")
    ResourceList<CreatorSummary> creators;

    @JsonProperty("next")
    EventSummary next;

    @JsonProperty("previous")
    EventSummary previous;
}
