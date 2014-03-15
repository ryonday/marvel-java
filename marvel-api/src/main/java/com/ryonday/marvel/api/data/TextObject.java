package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

import java.util.Locale;

/**
 * Created by ryon on 2/21/14.
 */
public class TextObject {

    /** The string description of the text object (e.g. solicit text, preview text, etc.). */
    private String type;

    /**
     * A language code denoting which language the text object is written in.
     */
    private Locale language;

    /** The text of the text object. */
    private String text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\ttype", type)
                .add("\n\tlanguage", language)
                .add("\n\ttext", text)
                .addValue('\n')
                .toString();
    }
}
