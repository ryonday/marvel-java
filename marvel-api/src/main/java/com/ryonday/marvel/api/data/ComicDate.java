package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * Created by ryon on 2/23/14.
 */
public class ComicDate {

    /** A description of the date (e.g. onsale date, FOC date). */
    private String type;

    /** The date. */
    private DateTime Date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DateTime getDate() {
        return Date;
    }

    public void setDate(DateTime date) {
        Date = date;
    }

    @Override
    public String  toString() {
        return Objects.toStringHelper( ComicDate.class )
                .add("\n\ttype", type)
                .add("\n\tDate", Date)
                .addValue('\n')
                .toString();
    }
}
