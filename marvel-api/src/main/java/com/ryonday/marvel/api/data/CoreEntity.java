package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

import java.net.URL;
import java.util.List;

/**
 * Created by ryon on 2/21/14.
 */
public abstract class CoreEntity implements Comparable<CoreEntity> {

    /** The unique ID of the Marvel entity resource. */
    private int id;

    /** The date the entity was most recently modified. */
    private DateTime modified;

    /** The canonical URL identifier for this entity. */
    private URL resourceURI;

    /**  A set of public web site URLs for this entity. */
    private List<Link> urls;

    /** The representative image for this entity. */
    private Image thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getModified() {
        return modified;
    }

    public void setModified(DateTime modified) {
        this.modified = modified;
    }

    public URL getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(URL resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<Link> getUrls() {
        return urls;
    }

    public void setUrls(List<Link> urls) {
        this.urls = urls;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Compares two {@code CoreEntity} objects by {@link com.ryonday.marvel.api.data.CoreEntity#id}. Note that
     * different {@code CoreEntity} descendants may still be compared like this.
     *
     * @see java.lang.Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(CoreEntity o) {
        return Integer.compare( this.id, o.id );
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( CoreEntity.class )
                .add("\n\tid", id)
                .add("\n\tmodified", modified)
                .add("\n\tresourceURI", resourceURI)
                .add("\n\turls", Objects.firstNonNull(urls, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tthumbnail", thumbnail)
                .addValue('\n')
                .toString();
    }
}
