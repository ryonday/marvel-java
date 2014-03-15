package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/21/14.
 */
public class Creator extends CoreEntity implements Summary {

    /** The first name of the creator. */
    private String firstName;

    /** The middle name of the creator */
    private String middleName;

    /** The last name of the creator */
    private String lastName;

    /** The suffix or honorific (Jr, phD, etc) for the creator. */
    private String suffix;

    /**The full name of the creator (a space-separated concatenation of {@link com.ryonday.marvel.api.data.Creator#firstName}, {@link com.ryonday.marvel.api.data.Creator#middleName}, {@link com.ryonday.marvel.api.data.Creator#lastName} and {@link com.ryonday.marvel.api.data.Creator#suffix}. */
    private String fullName;

    /** A resource list containing the comics which feature work by this creator. */
    private ResourceList<ComicSummary> comics;

    /** A resource list containing the series which feature work by this creator. */
    private ResourceList<SeriesSummary> series;

    /** A resource list containing the stories which feature work by this creator. */
    private ResourceList<StorySummary> stories;

    /** A resource list containing the events which feature work by this creator. */
    private ResourceList<EventSummary> events;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ResourceList<SeriesSummary> getSeries() {
        return series;
    }

    public void setSeries(ResourceList<SeriesSummary> series) {
        this.series = series;
    }

    public ResourceList<StorySummary> getStories() {
        return stories;
    }

    public void setStories(ResourceList<StorySummary> stories) {
        this.stories = stories;
    }

    public ResourceList<ComicSummary> getComics() {
        return comics;
    }

    public void setComics(ResourceList<ComicSummary> comics) {
        this.comics = comics;
    }

    public ResourceList<EventSummary> getEvents() {
        return events;
    }

    public void setEvents(ResourceList<EventSummary> events) {
        this.events = events;
    }

    /**
     * @return {@link com.ryonday.marvel.api.data.Creator#fullName}, to comply with the {@link com.ryonday.marvel.api.data.Summary} contract.
     */
    @Override
    public String getName() {
        return fullName;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\tsuperclass", super.toString().replaceAll("\n", "\n\t"))
                .add("\n\tfirstName", firstName)
                .add("\n\tmiddleName", middleName)
                .add("\n\tlastName", lastName)
                .add("\n\tsuffix", suffix)
                .add("\n\tfullName", fullName)
                .add("\n\tseries", Objects.firstNonNull(series, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tstories", Objects.firstNonNull(stories, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tcomics", Objects.firstNonNull(comics, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tevents", Objects.firstNonNull(events, "").toString().replaceAll( "\n", "\n\t"))
                .addValue('\n')
                .toString();
    }


}
