package com.ryonday.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CharacterSummaryMixin extends AbstractSummaryMixin {

}
