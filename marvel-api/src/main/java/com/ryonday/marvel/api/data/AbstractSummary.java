package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

import java.net.URL;

/**
 * Created by ryon on 2/23/14.
 */
public abstract class AbstractSummary implements Summary {

    /** The path to the individual entity resource. */
    private URL resourceURI;

    /** The full name of the entity. */
    private String name;

    @Override
    public URL getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(URL resourceURI) {
        this.resourceURI = resourceURI;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( AbstractSummary.class )
                .add("\n\tresourceURI", resourceURI)
                .add("\n\tname", name)
                .addValue('\n')
                .toString();
    }
}
