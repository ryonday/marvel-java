package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;
import org.joda.time.LocalDate;

/**
 * Created by ryon on 2/21/14.
 */
public class Event extends DescribedCoreEntity implements Summary {

    /** The title of the event. */
    private String title;

    /** The date of publication of the first issue in this event. */
    private LocalDate start;

    /** The date of publication of the last issue in this event. */
    private LocalDate end;

    /** A resource list containing comics which feature this event. */
    private ResourceList<ComicSummary> comics;

    /** A resource list of stories in which this event appears (or stories that appear in this event). */
    private ResourceList<StorySummary> stories;

    /** A resource list of events in which this character appears. */
    private ResourceList<CharacterSummary> characters;

    /** A resource list of series in which this event appears. */
    private ResourceList<SeriesSummary> series;

    /** A resource list of series in which this event appears. */
    private ResourceList<CreatorSummary> creators;

    /** A summary representation of the event which follows this event. */
    private EventSummary next;

    /** A summary representation of the event which preceded this event. */
    private EventSummary previous;

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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

    public ResourceList<CharacterSummary> getCharacters() {
        return characters;
    }

    public void setCharacters(ResourceList<CharacterSummary> characters) {
        this.characters = characters;
    }

    public ResourceList<SeriesSummary> getSeries() {
        return series;
    }

    public void setSeries(ResourceList<SeriesSummary> series) {
        this.series = series;
    }

    public ResourceList<CreatorSummary> getCreators() {
        return creators;
    }

    public void setCreators(ResourceList<CreatorSummary> creators) {
        this.creators = creators;
    }

    public EventSummary getNext() {
        return next;
    }

    public void setNext(EventSummary next) {
        this.next = next;
    }

    public EventSummary getPrevious() {
        return previous;
    }

    public void setPrevious(EventSummary previous) {
        this.previous = previous;
    }

    /**
     * @return the {@link com.ryonday.marvel.api.data.Event#title} field, to comply with the {@link com.ryonday.marvel.api.data.Summary} contract.
     */
    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\tsuperclass", super.toString().replaceAll("\n", "\n\t"))
                .add("\n\ttitle", title)
                .add("\n\tstart", start)
                .add("\n\tend", end)
                .add("\n\tcomics", Objects.firstNonNull(comics, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tstories", Objects.firstNonNull(stories, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tcharacters", Objects.firstNonNull(characters, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tseries", Objects.firstNonNull(series, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tcreators", Objects.firstNonNull(creators, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tnext", next)
                .add("\n\tprevious", previous)
                .addValue('\n')
                .toString();
    }
}
