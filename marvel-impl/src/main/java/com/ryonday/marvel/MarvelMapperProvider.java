package com.ryonday.marvel;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by ryon on 3/12/14.
 */
@Provider
public class MarvelMapperProvider implements ContextResolver<ObjectMapper>
{
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule( new MarvelModule() );
        mapper.registerModule( new JodaModule() );
        mapper.registerModule( new GuavaModule() );
        mapper.disable( DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE );
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
