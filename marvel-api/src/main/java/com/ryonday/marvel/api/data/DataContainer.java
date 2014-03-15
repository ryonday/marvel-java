package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by ryon on 2/21/14.
 */
public class DataContainer<E extends CoreEntity> {

    /** The requested offset (number of skipped results) of the call. */
    private int offset;

    /** The requested result limit. */
    private int limit;

    /** The total number of resources available given the current filter set. */
    private int total;

    /** The total number of results returned by this call. */
    private int call;

    /** The list of Marvel {@link CoreEntity} objects returned by the call. */
    private List<E> results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCall() {
        return call;
    }

    public void setCall(int call) {
        this.call = call;
    }

    public List<E> getResults() {
        return results;
    }

    public void setResults(List<E> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( DataContainer.class )
                .add("\n\toffset", offset)
                .add("\n\tlimit", limit)
                .add("\n\ttotal", total)
                .add("\n\tcall", call)
                .add("\n\tresults", Objects.firstNonNull(results, "").toString().replaceAll( "\n", "\n\t"))
                .addValue('\n')
                .toString();
    }
}
