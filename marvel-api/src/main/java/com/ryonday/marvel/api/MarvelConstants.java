package com.ryonday.marvel.api;

/**
 * A collection of useful constants for the Marvel web service.
 */
public final class MarvelConstants {

    /** The version of the Marvel API that this Java implementation adheres to. */
    public final static String version_api = "Cable";

    /** The base URL of the Marvel REST service */
    public final static String url_base = "http://gateway.marvel.com/v1/public";

    /** The path fragment that denotes the REST resource for a comic collection */
    public final static String path_comics = "comics";

    /** The path fragment that denotes the REST resource for one or more characters */
    public final static String path_chars = "characters";

    /** The path fragment that denotes the REST resource for one or more comic creators. */
    public final static String path_creators = "creators";

    /** The path fragment that denotes the REST resource for comic events. */
    public final static String path_events = "events";

    /** The path fragment that denotes the REST resource for comic series. */
    public final static String path_series = "series";

    /** The path fragment that denotes the REST resource for comic characters */
    public final static String path_stories = "stories";

    /** The required query parameter that specifies the authentication hash to authorize access to the Marvel web service */
    public final static String query_hash = "hash";

    /** The required query parameter that specifies the user's public API for access to the Marvel API. */
    public final static String query_apiKey = "apikey";

    /** The required query parameter that specifies the request-specific timestamp/random hash */
    public final static String query_timeStamp = "ts";

    /** The query parameter used to return only resources involved with the specified comic(s) (by ID) */
    public final static String query_comics = "comics";

    /** The query parameter used to return only resources the name(s) of which begin with the specified String. */
    public final static String query_nameStart = "nameStartsWith";

    /** The query parameter used to return only creators with the given first name */
    public final static String query_firstName = "firstName";

    /** The query parameter used to return only creators with the given middle name */
    public final static String query_middleName = "middleName";

    /** The query parameter used to return only creators with the given first name */
    public final static String query_lastName = "lastName";

    /** The query parameter used to return only creators with the given suffix/title */
    public final static String query_suffix = "suffix";

    /** The query parameter used to return only creators whose first names start with a given {@code String}. */
    public final static String query_firstNameStartsWith = "firstNameStartsWith";

    /** The query parameter used to return only creators whose first middle start with a given {@code String}. */
    public final static String query_middleNameStartsWith = "middleNameStartsWith";

    /** The query parameter used to return only creators whose last names start with a given {@code String}. */
    public final static String query_lastNameStartsWith = "lastNameStartsWith";


    /** The query parameter used to return only resources with the given name. */
    public final static String query_name = "name";

    /** The query parameter used to return only resources modified since the given date. */
    public final static String query_modifiedSince = "modifiedSince";

    /** The query parameter used to return only resources involved with the specified series (by ID) */
    public final static String query_series = "series";

    /** The query parameter used to return only resources associated with the specified event or events (by ID) */
    public final static String query_events = "events";

    /** The query parameter used to return only resources which contain the specified story or stories (by ID) */
    public final static String query_stories = "stories";

    /** The query parameter used to order the result set by one or more criteria */
    public final static String query_orderBy = "orderBy";

    /** The query parameter used to specify the number of desired results. */
    public final static String query_limit = "limit";

    /** The query parameter used to enable pagination by skipping result set entries */
    public final static String query_offset = "offset";

    /** The query parameter used to return only comics with the specified creator(s) (by ID) */
    public final static String query_creators = "creators";

    /** The query parameter used to filter comics by publication format */
    public final static String query_format = "format";

    /** The query parameter used to filter comics by format type */
    public final static String query_formatType = "formatType";

    /** The query parameter used to direct the Marvel web service to exclude variant comics from a query result */
    public final static String query_noVariants = "noVariants";

    /** The query parameter used with convenience date descriptors ("last month", etc) */
    public final static String query_dateDescriptor = "dateDescriptor";

    /** The query parameter used to search for comics within a specified date range. */
    public final static String query_dateRange = "dateRange";

    /** The query parameter used to search for a comic with a specific diamond code. */
    public final static String query_diamondCode = "diamondCode";

    /** The query parameter used to search for a comic with a specific digital ID. */
    public final static String query_digitalId = "digitalId";

    /** The query parameter used to search for a comic with a specific UPC code. */
    public final static String query_upc = "upc";

    /** The query parameter used to search for a comic with a specific ISBM. */
    public final static String query_isbn = "isbn";

    /** The query parameter used to search for a comic with a specific EAN. */
    public final static String query_ean = "ean";

    /** The query parameter used to search for a comic with a specific ISSN. */
    public final static String query_issn = "issn";

    /** The query parameter used to search for comics that had a digital issue available. */
    public final static String query_hasDigitalIssue = "hasDigitalIssue";

    /** The query parameter used to search for comics in which the specified characters (by ID) appeared in together. */
    public final static String query_sharedAppearances = "sharedAppearances";

    /** The query parameter used to search for comics that specific creators (by ID) worked on together */
    public final static String query_collaborators = "collaborators";

    /** The query parameter used to search for resources that feature specific characters (by ID) */
    public final static String query_characters = "characters";

    /** The query parameter used to search for a series with a spcific name. */
    public final static String query_title = "title";

    /** The query parameter used to search for series the names of which start with a specific string. */
    public final static String query_titleStartsWith = "titleStartsWith";

    /** The query parameter used to search for series starting a specific year. */
    public final static String query_startYear = "startYear";

    /** The query parameter used to filter a series by publication frequency */
    public final static String query_seriesType = "seriesType";

    /** The query parameter used to filter a series by comic format */
    public final static String query_contains = "contains";






}
