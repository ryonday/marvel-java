package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/23/14.
 */
public class CreatorSummary extends AbstractSummary {

    /** The role of the creator in the parent entity. */
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( CreatorSummary.class )
                .add("\n\trole", role)
                .add("\n\tsuperclass", super.toString().replaceAll("\n", "\n\t"))
                .addValue('\n')
                .toString();
    }
}
