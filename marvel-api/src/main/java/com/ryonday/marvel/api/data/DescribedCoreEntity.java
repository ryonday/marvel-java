package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 3/14/14.
 */
public abstract class DescribedCoreEntity extends CoreEntity {
    /** A textual description of the entity. */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( DescribedCoreEntity.class )
                .add("\n\tsuperclass", super.toString().replaceAll("\n", "\n\t"))
                .add("\n\tdescription", description)
                .addValue('\n')
                .toString();

    }
}
