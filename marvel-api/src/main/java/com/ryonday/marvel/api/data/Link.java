package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

import java.net.URL;

/**
 * Created by ryon on 2/21/14.
 */
public class Link {
    /** A text identifier for the URL. */
    private String type;

    /** A full URL (including scheme, domain, and path). */
    private URL url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( Link.class )
                .add("\n\ttype", type)
                .add("\n\turl", url)
                .addValue('\n')
                .toString();
    }
}
