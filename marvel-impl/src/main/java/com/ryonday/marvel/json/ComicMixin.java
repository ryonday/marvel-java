package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryonday.marvel.api.data.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true )
public abstract class ComicMixin extends DescribedCoreEntityMixin {

    @JsonProperty("digitaiId")
    int digitalId;

    @JsonProperty("title")
    String title;

    @JsonProperty("issueNumber")
    double issueNumber;

    @JsonProperty("variantDescription")
    String variantDescription;

    @JsonProperty("isbn")
    String isbn;

    @JsonProperty("upc")
    String upc;

    @JsonProperty("diamondCode")
    String diamondCode;

    @JsonProperty("ean")
    String ean;

    @JsonProperty("issn")
    String issn;

    @JsonProperty("format")
    String format;

    @JsonProperty("pageCount")
    int pageCount;

    @JsonProperty("textObjects")
    List<TextObject> textObjects;

    @JsonProperty("series")
    SeriesSummary series;

    @JsonProperty("variants")
    List<ComicSummary> variants;

    @JsonProperty("collections")
    List<ComicSummary> collections;

    @JsonProperty("collectedIssues")
    List<ComicSummary> collectedIssues;

    @JsonProperty("dates")
    List<ComicDate> dates;

    @JsonProperty("prices")
    List<ComicPrice> prices;

    @JsonProperty("images")
    List<Image> images;

    @JsonProperty("creators")
    ResourceList<CreatorSummary> creators;

    @JsonProperty("characters")
    ResourceList<CharacterSummary> characters;

    @JsonProperty("stories")
    ResourceList<StorySummary> stories;

    @JsonProperty("events")
    ResourceList<EventSummary> events;






}
