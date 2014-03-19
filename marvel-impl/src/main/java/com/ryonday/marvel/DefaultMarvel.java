package com.ryonday.marvel;

import com.google.common.base.Charsets;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Ints;
import com.ryonday.marvel.api.Marvel;
import com.ryonday.marvel.api.MarvelConstants;
import com.ryonday.marvel.api.data.*;
import com.ryonday.marvel.config.MarvelConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;
import java.util.UUID;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * A Jackson implementation of the {@link com.ryonday.marvel.api.Marvel} interface.
 */
public class DefaultMarvel implements Marvel {

    /** SLF4J Logger */
    private final static Logger LOG = LoggerFactory.getLogger( DefaultMarvel.class );

    /** The underlying {@link javax.ws.rs.client.Client} instance used to construct requests to the Marvel web service */
    private final Client client;

    /** The configuration object for this {@code DefaultMarvel} instance */
    private final MarvelConfig config;

    /**
     * Constructs a new {@code DefaultMarvel} instance with the specified configuration object.
     *
     * @param config the non-null {@link com.ryonday.marvel.config.MarvelConfig} object to use with this {@code DefautlMarvel}.
     */
    @Inject
    public DefaultMarvel( @Nonnull MarvelConfig config ) {
        this.config = config;
        this.client = ClientBuilder.newBuilder()
                .build()
                .register(new LoggingFilter(java.util.logging.Logger.getLogger(LoggingFilter.class.getName()), true))
                .register(new MarvelMapperProvider());
     }

    /**
     * Updates the target URI with the required authentication information for the marvel web service.
     */
    private UriBuilder updateUriWithHash( UriBuilder b ) {
        String ts = UUID.randomUUID().toString();
        String hash = hash( config.getPublicKey(), config.getPrivateKey(), ts);
        b.queryParam(MarvelConstants.query_timeStamp, ts)
                .queryParam(MarvelConstants.query_hash, hash);
         return b;
    }

    /**
     * @return a {@link javax.ws.rs.client.WebTarget} instance for the specified Marvel resource.
     */
    private WebTarget getTarget( Map<String, Object> params, String resource, String ... resources ) {
        UriBuilder b = UriBuilder.fromPath(MarvelConstants.url_base)
                .queryParam(MarvelConstants.query_apiKey, config.getPublicKey());

        if( !isNullOrEmpty(resource) ) b.path(resource);

        if( resources != null ) {
            for( String s : resources ) {
                b.path( s );
            }
        }

        if( params != null ) {
            for( String s : params.keySet() ) {
                b.queryParam( s, params.get( s ) );
            }
        }

        updateUriWithHash( b );

       return client.target( b );
    }

    /**
     * This is a tedious set of null checks and collection marching to construct a Marvel web services query string.
     *
     * Unfortunately, there is no clean way of organizing the various query parameters that each Marvel API call
     * can exploit. There are a number of common (in the 'frequent' sense of the word, unforunately not the 'shared'
     * since of the word) parameters shared among many, but not all of the methods:
     * <ul>
     *     <li><code>modifiedSince</code></li>
     *     <li><code>orderBy</code> (although the ordering rubrics are all quite different)</li>
     *     <li><code>limit</code></li>
     *     <li><code>offset</code></li>
     * </ul>
     * More heartbreakingly, there are several which are shared among <em>almost</em> all:
     * <ul>
     *     <li><code>comics</code></li>
     *     <li><code>events</code></li>
     *     <li><code>series</code></li>
     *     <li><code>stories</code></li>
     *     <li><code>creators</code></li>
     *     <li><code>characters</code></li>
     * </ul>
     * And some that are in half or less:
     * <ul>
     *     <li><code>name</code></li>
     *     <li><code>nameStartsWith</code></li>
     *     <li></li>
     * </ul>
     *
     * The remainder of the query parameters are specific to individual requests (<code>creator</code> and <code>comic</code> are particularly tedious).
     *
     * @return a {@link java.util.Map} of strings to query parameters.
     */
    private Map<String, Object> collectCommonQueryParams( ImmutableMap.Builder<String, Object> additional,
                                                          DateTime modifiedSince,
                                                          String orderBy,
                                                          Integer limit,
                                                          Integer offset,
                                                          int[] comics,
                                                          int[] series,
                                                          int[] events,
                                                          int[] stories,
                                                          int[] characters,
                                                          int[] creators,
                                                          String name,
                                                          String nameStartsWith ) {

        ImmutableMap.Builder<String, Object> params = additional != null ? additional : ImmutableMap.<String, Object>builder();

        if( !isNullOrEmpty( orderBy ) ) {
            params.put( MarvelConstants.query_orderBy, orderBy ); // TODO Type safety.
        }
        if( !isNullOrEmpty( name )) {
            params.put( MarvelConstants.query_name, name );
        }
        if( !isNullOrEmpty( nameStartsWith )) {
            params.put( MarvelConstants.query_nameStart, nameStartsWith );
        }
        if( limit != null && limit > 1 ) {
            params.put( MarvelConstants.query_limit, limit );
        }
        if( offset != null && offset >= 0 ) {
            params.put( MarvelConstants.query_offset, offset );
        }
        if( modifiedSince != null && !modifiedSince.isAfterNow() ) {
            params.put( MarvelConstants.query_modifiedSince, modifiedSince.toString("yyyy-MM-dd"));
        }

        // LOL :(
        Map<String, Optional<int[]>> x;
        for( String s : (x = ImmutableMap.<String, Optional<int[]>>builder()
                .put( MarvelConstants.query_comics, Optional.fromNullable( comics ) )
                .put( MarvelConstants.query_series, Optional.fromNullable(series ) )
                .put( MarvelConstants.query_events, Optional.fromNullable(events ) )
                .put( MarvelConstants.query_stories, Optional.fromNullable(stories ) )
                .put( MarvelConstants.query_characters, Optional.fromNullable(characters ) )
                .put( MarvelConstants.query_creators, Optional.fromNullable(creators ) )
                .build()).keySet() ) {

            Optional<int[]> y = x.get( s );

            if( y.isPresent() && y.get().length > 0 ){
                params.put( s, Ints.join(",", y.get() ));
            }
        }

        Map<String, Object> p = params.build();

        LOG.debug( "Constructed query parameters: {}", p );

        return p;
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getCharacter(int)
     */
    @Override
    public ApiReturn<MarvelCharacter> getCharacter( int characterId ) {
        WebTarget t = getTarget(null, MarvelConstants.path_chars, Integer.toString( characterId ) );
        return call( t, new GenericType<ApiReturn<MarvelCharacter>>(){});

    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getCharacters(String, String, org.joda.time.DateTime, int[], int[], int[], int[], String, int, int)
     */
    @Override
    public ApiReturn<MarvelCharacter> getCharacters(String name,
                                                   String nameStartsWith,
                                                   DateTime modifiedSince,
                                                   int[] comics,
                                                   int[] series,
                                                   int[] events,
                                                   int[] stories,
                                                   String orderBy,
                                                   int limit,
                                                   int offset ) {

        Map<String, Object> params = collectCommonQueryParams(null, modifiedSince,
                orderBy, limit, offset, comics, series, events, stories,
                null,
                null,
                name, nameStartsWith);

        WebTarget t = getTarget(params, MarvelConstants.path_chars );
        return call( t, new GenericType<ApiReturn<MarvelCharacter>>(){});
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getCreator(int)
     */
    @Override
    public ApiReturn<Creator> getCreator( int creatorId ) {
        WebTarget t = getTarget(null, MarvelConstants.path_creators);
        return call( t, new GenericType<ApiReturn<Creator>>(){});

    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getCreators(String, String, String, String, String, String, String, String, org.joda.time.DateTime, int[], int[], int[], int[], String, int, int)
     */
    @Override
    public ApiReturn<Creator> getCreators( String firstName,
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
                                                   int offset ) {

        ImmutableMap.Builder<String, Object> additional = ImmutableMap.builder();

        if( !isNullOrEmpty( firstName ) ) additional.put( MarvelConstants.query_firstName, firstName );
        if( !isNullOrEmpty( middleName )) additional.put( MarvelConstants.query_middleName, middleName );
        if( !isNullOrEmpty( lastName )) additional.put( MarvelConstants.query_lastName, lastName );
        if( !isNullOrEmpty( suffix )) additional.put( MarvelConstants.query_suffix, suffix );
        if( !isNullOrEmpty( firstNameStartsWith)) additional.put( MarvelConstants.query_firstNameStartsWith, firstNameStartsWith );
        if( !isNullOrEmpty( middleNameStartsWith)) additional.put( MarvelConstants.query_middleNameStartsWith, middleNameStartsWith );
        if( !isNullOrEmpty( lastNameStartsWith )) additional.put( MarvelConstants.query_lastNameStartsWith, lastNameStartsWith );

        Map<String, Object> params = collectCommonQueryParams( additional,
                modifiedSince,
                orderBy,
                limit,
                offset,
                comics,
                series,
                events,
                stories,
                null,
                null,
                null,
                nameStartsWith );

        WebTarget t = getTarget( params, MarvelConstants.path_creators );
        return call( t, new GenericType<ApiReturn<Creator>>(){});
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getComic(int)
     */
    @Override
    public ApiReturn<Comic> getComic( int comicId ) {
        WebTarget t = getTarget(null, MarvelConstants.path_comics);
        return call( t, new GenericType<ApiReturn<Comic>>(){});
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getComics(String, String, boolean, String, org.joda.time.Interval, String, String, String, String, String, String, boolean, org.joda.time.DateTime, int[], int[], int[], int[], int[], int[], int[], String, int, int)
     */
    @Override
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
                                                 int offset) {

        ImmutableMap.Builder<String, Object> additional = ImmutableMap.builder();

        if( !isNullOrEmpty( format ) ) additional.put( MarvelConstants.query_format, format );
        if( !isNullOrEmpty( formatType )) additional.put( MarvelConstants.query_formatType, formatType);
        if( !isNullOrEmpty( dateDescriptor )) additional.put(MarvelConstants.query_dateDescriptor,dateDescriptor );

        if( dateRange != null ) {
            additional.put( MarvelConstants.query_dateRange,
                    dateRange.getStart().toString("yyyy-MM-dd") + "," + dateRange.getEnd().toString( "yyyy-MM-dd"));
        }
        if( !isNullOrEmpty( diamondCode) ) additional.put( MarvelConstants.query_diamondCode, diamondCode );
        if( !isNullOrEmpty( digitalId )) additional.put( MarvelConstants.query_digitalId, digitalId );
        if( !isNullOrEmpty( upc )) additional.put( MarvelConstants.query_upc, upc );
        if( !isNullOrEmpty( isbn)) additional.put( MarvelConstants.query_isbn, isbn );
        if( !isNullOrEmpty( ean )) additional.put( MarvelConstants.query_ean, ean );

        if( sharedAppearances != null && sharedAppearances.length > 0 ) {
            additional.put( MarvelConstants.query_sharedAppearances, Ints.join( ",", sharedAppearances ));
        }

        if( collaborators != null && collaborators.length > 0 ) {
            additional.put( MarvelConstants.query_collaborators, Ints.join( ",", collaborators ));
        }

        Map<String, Object> params = collectCommonQueryParams( additional,
                modifiedSince,
                orderBy,
                limit,
                offset,
                null,
                series,
                events,
                stories,
                characters,
                creators, null, null );

        WebTarget t = getTarget( params, MarvelConstants.path_comics );

        return call( t, new GenericType<ApiReturn<Comic>>(){});
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getEvent(int)
     */
    @Override
    public ApiReturn<Event> getEvent( int eventId ) {
        WebTarget t = getTarget(null, MarvelConstants.path_events);
        return call( t, new GenericType<ApiReturn<Event>>(){});
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getEvents(String, String, org.joda.time.DateTime, int[], int[], int[], int[], int[], String, int, int)
     */
    @Override
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
                                       int offset ) {

        Map<String, Object> params = collectCommonQueryParams( null, modifiedSince,
                orderBy, limit,
                offset, comics,
                series, null,
                stories, characters,
                creators, name,
                nameStartsWith );

        WebTarget t = getTarget(params, MarvelConstants.path_events);
        return call( t, new GenericType<ApiReturn<Event>>(){});
    }


    /**
     * @see com.ryonday.marvel.api.Marvel#getStory(int)
     */
    @Override
    public ApiReturn<Story> getStory( int storyId ) {
        WebTarget t = getTarget(null, MarvelConstants.path_stories);
        return call( t, new GenericType<ApiReturn<Story>>(){});
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getStories(org.joda.time.DateTime, int[], int[], int[], int[], int[], String, int, int)
     */
    @Override
    public ApiReturn<Story> getStories( DateTime modifiedSince,
                                        int[] comics,
                                        int[] series,
                                        int[] events,
                                        int[] creators,
                                        int[] characters,
                                        String orderBy,
                                        int limit,
                                        int offset ) {

        Map<String, Object> params = collectCommonQueryParams( null, modifiedSince,
                orderBy, limit,
                offset, comics,
                series, events,
                null, characters,
                creators, null,
                null );

        WebTarget t = getTarget(params, MarvelConstants.path_stories);
        return call( t, new GenericType<ApiReturn<Story>>(){});
    }

    /**
     * @see com.ryonday.marvel.api.Marvel#getSeries(int)
     */
    @Override
    public ApiReturn<Series> getSeries( int seriesId ) {
        WebTarget t = getTarget(null, MarvelConstants.path_series);
        return call( t, new GenericType<ApiReturn<Series>>(){});
    }

    /**
     * @see Marvel#getSeries(String, String, String, String, org.joda.time.Years, org.joda.time.DateTime, int[], int[], int[], int[], int[], String, int, int)
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
                                        int offset ) {
        ImmutableMap.Builder<String, Object> additional = ImmutableMap.builder();

        if( !isNullOrEmpty( seriesType )) additional.put( MarvelConstants.query_seriesType, seriesType );
        if( !isNullOrEmpty( contains )) additional.put( MarvelConstants.query_contains, contains );
        if( !isNullOrEmpty( title )) additional.put( MarvelConstants.query_title, title );
        if( !isNullOrEmpty( titleStartsWith )) additional.put( MarvelConstants.query_titleStartsWith, titleStartsWith );
        if( startYear != null ) additional.put( MarvelConstants.query_startYear, startYear.toString() );

        Map<String, Object> params = collectCommonQueryParams( additional, modifiedSince, orderBy, limit, offset,
                comics, null, events, stories, characters, creators, null, null );
        WebTarget t = getTarget(params, MarvelConstants.path_series);

        return call( t, new GenericType<ApiReturn<Series>>(){});
    }


    private <T extends CoreEntity> ApiReturn<T> call( WebTarget t, GenericType<ApiReturn<T>> x ) {
        ApiReturn<T> ret = t.request( MediaType.APPLICATION_JSON_TYPE).get( x );
        return ret;
    }


    /**
     * A function that implements Marvel's signing strategy for server-side requests, the MD5Sum of the concatenation of a nonce (generated by this method), {@pubKey} and {@code privKey}.
     *
     * @param pubKey The user's public key to the Marvel web service.
     * @param privKey The user's private key to the Marvel web service.
     * @param ts a request-specific string (not really a nonce in this case) such as a timestamp or other random-ish String.
     * @return a {@code String} which serves as a signature to the Marvel web service request.
     */
    private static String hash( String pubKey, String privKey, String ts ) {

        String hash = Hashing.md5().hashString( ts + privKey + pubKey, Charsets.UTF_8 ).toString();

        LOG.debug( "Generated authentication hash '{}' from public key '{}', private key '{}' and ts '{}'",
                hash, pubKey, privKey, ts );

        return hash;
    }

}
