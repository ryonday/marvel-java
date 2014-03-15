package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/21/14.
 */
public class MarvelCharacter extends CoreEntity implements Summary {

    /** The name of the Marvel comic character. */
    private String name;

    /** A resource list containing comics which feature this character. */
    private ResourceList<ComicSummary> comics;

    /** A resource list of stories in which this character appears. */
    private ResourceList<StorySummary> stories;

    /** A resource list of events in which this character appears. */
    private ResourceList<EventSummary> events;

    /** A resource list of series in which this character appears. */
    private ResourceList<SeriesSummary> series;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceList<ComicSummary> getComics() {
        return comics;
    }

    public void setComics(ResourceList<ComicSummary> comics) {
        this.comics = comics;
    }

    public ResourceList<StorySummary> getStories() {
        return stories;
    }

    public void setStories(ResourceList<StorySummary> stories) {
        this.stories = stories;
    }

    public ResourceList<EventSummary> getEvents() {
        return events;
    }

    public void setEvents(ResourceList<EventSummary> events) {
        this.events = events;
    }

    public ResourceList<SeriesSummary> getSeries() {
        return series;
    }

    public void setSeries(ResourceList<SeriesSummary> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(MarvelCharacter.class)
                .add("\n\tsuperclass", super.toString().replaceAll("\n", "\n\t"))
                .add("\n\tname", name)
                .add("\n\tcomics", Objects.firstNonNull(comics, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tstories", Objects.firstNonNull(stories, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tevents", Objects.firstNonNull(events, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tseries", Objects.firstNonNull(series, "").toString().replaceAll( "\n", "\n\t"))
                .addValue('\n')
                .toString();
    }
}
