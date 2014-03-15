package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/23/14.
 */
public class StorySummary extends AbstractSummary {

    /** The type of the story (interior or cover). */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\ttype", type)
                .add("\n\tsuperclass", super.toString().replaceAll("\n", "\n\t"))
                .addValue('\n')
                .toString();
    }
}
