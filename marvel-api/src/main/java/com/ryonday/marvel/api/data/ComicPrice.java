package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/23/14.
 */
public class ComicPrice {

    /** A description of the price (e.g. print price, digital price). */
    private String type;

    /** The price (in U.S. Dollars). */
    private float price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper( ComicPrice.class )
                .add("\n\ttype", type)
                .add("\n\tprice", price)
                .addValue('\n')
                .toString();
    }
}
