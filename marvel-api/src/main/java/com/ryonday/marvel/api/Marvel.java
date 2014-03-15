package com.ryonday.marvel.api;

import com.ryonday.marvel.api.data.*;

/**
 * This interface provides java method definitions that map to the Marvel web service RESTful URLs.
 */
public interface Marvel {

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.MarvelCharacter} by that character's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<MarvelCharacter> getCharacter( int characterId );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Creator} by that creator's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Creator> getCreator( int creatorId );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Comic} by that comic's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Comic> getComic( int comicId );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Event} by that event's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Event> getEvent( int eventId );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Story} by that event's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Story> getStory( int storyId );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Series} by that event's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Series> getSeries( int seriesId );



}
