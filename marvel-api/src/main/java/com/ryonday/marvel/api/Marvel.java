package com.ryonday.marvel.api;

import com.ryonday.marvel.api.data.*;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Years;

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
     * Fetches a set of one or more {@link com.ryonday.marvel.api.data.MarvelCharacter} objects by those characters' data elements.
     *
     * TODO: Type-safe orderBy
     *
     * @param name Return only characters matching the specified full character name (e.g. Spider-Man).
     * @param nameStartsWith Return characters with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince Return only characters which have been modified since the specified date.
     * @param comics Return only characters which appear in the specified comics (accepts a comma-separated list of ids).
     * @param series Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param orderBy Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit Limit the result set to the specified number of resources.
     * @param offset Skip the specified number of resources in the result set.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<MarvelCharacter> getCharacters( String name,
                                                    String nameStartsWith,
                                                    DateTime modifiedSince,
                                                    int[] comics,
                                                    int[] series,
                                                    int[] events,
                                                    int[] stories,
                                                    String orderBy,
                                                    int limit,
                                                    int offset );


    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Creator} by that creator's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Creator> getCreator( int creatorId );


    /**
     * Fetches a set of one or more {@link com.ryonday.marvel.api.data.Creator} objects by those creators' data elements.
     *
     * TODO: Type-safe orderBy
     *
     *
     * @param firstName Return only creators with the specified first name.
     * @param middleName Return only creators with the specified middle name.
     * @param lastName Return only creators with the specified last name.
     * @param suffix Return only creators with the specified suffix/title (e.g "Jr.", "pHD", etc)
     * @param nameStartsWith Return only creators whose full names begin with the specified {@code String}.
     * @param firstNameStartsWith Return only creators whose first names begin with the specified {@code String}.
     * @param middleNameStartsWith Return only creators whose middle names begin with the specified {@code String}.
     * @param modifiedSince Return only creators which have been modified since the specified date.
     * @param comics Return only creators responsible for work in the specified comics (accepts a comma-separated list of ids).
     * @param series Return only creators responsible for work in the specified series (accepts a comma-separated list of ids).
     * @param events Return only creators responsible for work in the specified events (accepts a comma-separated list of ids).
     * @param stories Return only creators responsible for work in the specified stories (accepts a comma-separated list of ids).
     * @param orderBy Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit Limit the result set to the specified number of resources.
     * @param offset Skip the specified number of resources in the result set.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Creator> getCreators(String firstName,
                                          String middleName,
                                          String lastName,
                                          String suffix,
                                          String nameStartsWith,
                                          String firstNameStartsWith,
                                          String middleNameStartsWith,
                                          String lastNameStartsWith,
                                          DateTime modifiedSince,
                                          int[] comics,
                                          int[] series,
                                          int[] events,
                                          int[] stories,
                                          String orderBy,
                                          int limit,
                                          int offset);

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Comic} by that comic's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Comic> getComic( int comicId );

    /**
     * Fetches a set of one or more {@link com.ryonday.marvel.api.data.Comic} objects by those comics' data elements.
     *
     * TODO: Type-safe orderBy
     * TODO: Type-safe format
     * TODO: Type-safe formatType
     * TODO: Type-safe dateDescriptor
     *
     * @param format Return only comics with the specified issue format
     * @param formatType return only commics with the specified issue format type.
     * @param noVariants specifies whether to exclude issue variants (alternate covers, etc) from the results.
     * @param dateDescriptor Return results within the specified convenience date range.
     * @param dateRange Return only results within the specified date range.
     * @param diamondCode Return only comics with the specified diamond code.
     * @param digitalId Return only comics with the specified digital ID.
     * @param upc Return only comics with the specified UPC code.
     * @param isbn Return only comics with the specified ISBN number.
     * @param ean Return only comics matching the specified EAN.
     * @param issn Return only comics with the specified issn number.
     * @param hasDigitalIssue Return only digitally available comics.
     * @param modifiedSince Return only comics which have been modified since the specified date.
     * @param creators return only comics which feature work by the specified creators.
     * @param characters return only comics which feature the specified characters.
     * @param series Return only comics which take place in the specified series (accepts a comma-separated list of ids).
     * @param events Return only comics which take place in the specified events (accepts a comma-separated list of ids).
     * @param stories Return only comics which contain the specified stories (accepts a comma-separated list of ids).
     * @param sharedAppearances Return only comics in which the specified characters (by id) appear.
     * @param collaborators Return only comics on which the specified creators worked together.
     * @param orderBy Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit Limit the result set to the specified number of resources.
     * @param offset Skip the specified number of resources in the result set.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Comic> getComics( String format,
                                                 String formatType,
                                                 boolean noVariants,
                                                 String dateDescriptor,
                                                 Interval dateRange,
                                                 String diamondCode,
                                                 String digitalId,
                                                 String upc,
                                                 String isbn,
                                                 String ean,
                                                 String issn,
                                                 boolean hasDigitalIssue,
                                                 DateTime modifiedSince,
                                                 int[] creators,
                                                 int[] characters,
                                                 int[] series,
                                                 int[] events,
                                                 int[] stories,
                                                 int[] sharedAppearances,
                                                 int[] collaborators,
                                                 String orderBy,
                                                 int limit,
                                                 int offset );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Event} by that event's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Event> getEvent( int eventId );

    /**
     * Fetches one or more {@link com.ryonday.marvel.api.data.Event} objects filtered by the method parameters.
     *
     * @param name Return only events which match the specified name.
     * @param nameStartsWith Return events with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince Return only events which have been modified since the specified date.
     * @param creators Return only events which feature work by the specified creators (by id).
     * @param characters Return only events which feature the specified characters (by id)
     * @param series Return only events which are part of the specified series (by id)
     * @param comics Return only events which take place in the specified comics(by id)
     * @param stories Return only events which take place in the specified stories (by id)
     * @param orderBy Sort the returned values by the given criteria.
     * @param limit Limit the result set to the specified number of events.
     * @param offset Skip the specified number of events in the result set (pagination).
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container zero or more entries.
     */
    public ApiReturn<Event> getEvents( String name,
                                       String nameStartsWith,
                                       DateTime modifiedSince,
                                       int[] creators,
                                       int[] characters,
                                       int[] series,
                                       int comics[],
                                       int stories[],
                                       String orderBy,
                                       int limit,
                                       int offset );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Story} by that event's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Story> getStory( int storyId );


    /**
     * Fetches lists of {@link com.ryonday.marvel.api.data.Story} objects using optional filters.
     *
     * @param modifiedSince Return only stories which have been modified since the specified date.
     * @param comics Return only stories in the specified comics (by id).
     * @param series Return only stories contained the specified series (by id).
     * @param events Return only stories which take place during the specified events (by id).
     * @param creators Return only stories which feature work by the specified creators (by id).
     * @param characters Return only stories which feature the specified characters (by id).
     * @param orderBy Order the results by criteria
     * @param limit Limit the result set to the specified number of stories.
     * @param offset Skip the specified number of stories in the result set.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having zero or more entries.
     */
    public ApiReturn<Story> getStories( DateTime modifiedSince,
                                        int[] comics,
                                        int[] series,
                                        int[] events,
                                        int[] creators,
                                        int[] characters,
                                        String orderBy,
                                        int limit,
                                        int offset );

    /**
     * Fetches a single {@link com.ryonday.marvel.api.data.Series} by that event's {@code id}.
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having a single entry.
     */
    public ApiReturn<Series> getSeries( int seriesId );

    /**
     * Fetches lists of comic series with optional filters.
     *
     * @param seriesType Filter the series by publication frequency type.
     * @param contains Return only series containing one or more comics with the specified format.
     * @param title Return only series matching the specified title.
     * @param titleStartsWith Return series with titles that begin with the specified string (e.g. Sp).
     * @param startYear Return only series matching the specified start year.
     * @param modifiedSince Return only series which have been modified since the specified date.
     * @param comics Return only series which contain the specified comics (by id).
     * @param stories Return only series which contain the specified stories (by id).
     * @param events Return only series which have comics that take place during the specified events (by id)
     * @param creators Return only series which feature work by the specified creators (by id)
     * @param characters Return only series which feature the specified characters (by id)
     * @param orderBy Order the result set by the specified criteria
     * @param limit Limit the result set to the specified number of resources.
     * @param offset Skip the specified number of resources in the result set
     *
     * @return a standard {@link com.ryonday.marvel.api.data.ApiReturn} object with its data container having zero or more entries.
     */
    public ApiReturn<Series> getSeries( String seriesType,
                                        String contains,
                                        String title, String titleStartsWith,
                                        Years startYear,
                                        DateTime modifiedSince,
                                        int[] comics,
                                        int[] stories,
                                        int[] events,
                                        int[] creators,
                                        int[] characters,
                                        String orderBy,
                                        int limit,
                                        int offset
                                        );



}
