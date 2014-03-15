package com.ryonday.marvel;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ryonday.marvel.api.data.*;
import com.ryonday.marvel.json.*;

/**
 * Performs tedious mappings from POJOs to Jackson Mixin classes, to avoid polluting the API objects with Jackson annotations.
 */
public class MarvelModule extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.setMixInAnnotations( ApiReturn.class, ApiReturnMixin.class );
        context.setMixInAnnotations( Comic.class, ComicMixin.class );
        context.setMixInAnnotations( ComicDate.class, ComicMixin.class );
        context.setMixInAnnotations( ComicPrice.class, ComicPriceMixin.class );
        context.setMixInAnnotations( ComicSummary.class, ComicSummaryMixin.class );
        context.setMixInAnnotations( CoreEntity.class, CoreEntityMixin.class );
        context.setMixInAnnotations( Creator.class, CreatorMixin.class );
        context.setMixInAnnotations( CreatorSummary.class, CreatorSummaryMixin.class );
        context.setMixInAnnotations( DataContainer.class, DataContainerMixin.class );
        context.setMixInAnnotations( Event.class, EventMixin.class );
        context.setMixInAnnotations( EventSummary.class, EventSummaryMixin.class );
        context.setMixInAnnotations( Image.class, ImageMixin.class );
        context.setMixInAnnotations( Link.class, LinkMixin.class );
        context.setMixInAnnotations( MarvelCharacter.class, MarvelCharacterMixin.class );
        context.setMixInAnnotations( ResourceList.class, ResourceListMixin.class );
        context.setMixInAnnotations( Series.class, SeriesMixin.class );
        context.setMixInAnnotations( SeriesSummary.class, SeriesSummaryMixin.class );
        context.setMixInAnnotations( Story.class, StoryMixin.class );
        context.setMixInAnnotations( StorySummary.class, StorySummaryMixin.class );
        context.setMixInAnnotations( AbstractSummary.class, AbstractSummaryMixin.class );
        context.setMixInAnnotations( TextObject.class, TextObjectMixin.class );
    }
}
