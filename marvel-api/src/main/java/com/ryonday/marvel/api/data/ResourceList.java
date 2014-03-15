package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

import java.net.URL;
import java.util.List;

/**
 * Created by ryon on 2/23/14.
 */
public class ResourceList<E extends AbstractSummary> {

    /** The number of total available entities in this list. Will always be greater than or equal to the "returned" value. */
    private int available;

    /** The number of entities returned in this collection (up to 20). */
    private int returned;

    /** The path to the full list of concrete entities in this collection. */
    private URL collectionURI;

    /** The list of returned concrete entities in this collection. */
    private List<E> items;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public URL getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(URL collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( ResourceList.class )
                .add("\n\tavailable", available)
                .add("\n\treturned", returned)
                .add("\n\tcollectionURI", collectionURI)
                .add("\n\titems", Objects.firstNonNull(items, "").toString().replaceAll( "\n", "\n\t"))
                .addValue('\n')
                .toString();
    }
}
