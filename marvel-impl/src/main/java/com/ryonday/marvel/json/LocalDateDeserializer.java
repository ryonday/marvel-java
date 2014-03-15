package com.ryonday.marvel.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * The default date/time string intelligible to the joda-time plugin for Jackson doesn't understand
 * all of the formats returned by Marvel, particularly the format for Event start/end dates:
 *
 * <code>"start": "1989-12-10 00:00:00", "end": "2008-01-04 00:00:00",</code>
 *
 * Subclasses may override {@link LocalDateDeserializer#getDateFormat()} to provide a custom format.
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    /** Sfl4j Logger */
    private final static Logger LOG = LoggerFactory.getLogger( LocalDateDeserializer.class );

    /** Format used by Marvel for Event start and end dates */
    private final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public LocalDateDeserializer() {
        super();
    }

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String rawDate = jp.getText();
        LocalDate date = format.parseLocalDate( rawDate );
        LOG.debug("Parsed LocalDate '{}' from raw String '{}'.", date, rawDate );
        return date;
    }

    /**
     * Example from a Marvel API response:
     * <code>"start": "1989-12-10 00:00:00", "end": "2008-01-04 00:00:00",</code>
     *
     * @return a {@code String} with the date format string for a given instance of {@code LocalDateDeserializer}
     */
    protected String getDateFormat() {
        return "yyyy-MM-dd HH:mm:ss";
    }

}

