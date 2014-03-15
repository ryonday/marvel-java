package com.ryonday.marvel.api.data;

import java.net.URL;

/**
 * Defines methods to obtain a summary of a Marvel resource.
 */
public interface Summary {

    /**
     * @return The URL that describes the specific Marvel resource.
     */
    public URL getResourceURI();

    /**
     * @return The name of the specific Marvel resource.
     */
    public String getName();
}
