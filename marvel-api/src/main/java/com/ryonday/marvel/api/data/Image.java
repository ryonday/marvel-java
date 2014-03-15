package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/21/14.
 */
public class Image {
    /** The directory path of to the image. */
    private String path;

    /** The file extension for the image. */
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( Image.class )
                .add("\n\tpath", path)
                .add("\n\textension", extension)
                .addValue('\n')
                .toString();
    }
}
