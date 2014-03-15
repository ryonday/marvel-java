package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/21/14.
 */
public class Story extends DescribedCoreEntity implements Summary {

    /** The story title. */
    private String title;

    /** The story type e.g. interior story, cover, text story. */
    private String type;

    /** A resource list containing comics in which this story takes place. */
    private ResourceList<ComicSummary> comics;

    /** A resource list containing series in which this story appears. */
    private ResourceList<SeriesSummary> series;

    /** A resource list of the events in which this story appears. */
    private ResourceList<EventSummary> events;

    /** A resource list of characters which appear in this story. */
    private ResourceList<CharacterSummary> characters;

    /** A resource list of creators who worked on this story. */
    private ResourceList<CreatorSummary> creators;

    /** A summary representation of the issue in which this story was originally published. */
    private ComicSummary originalIssue;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResourceList<ComicSummary> getComics() {
        return comics;
    }

    public void setComics(ResourceList<ComicSummary> comics) {
        this.comics = comics;
    }

    public ResourceList<SeriesSummary> getSeries() {
        return series;
    }

    public void setSeries(ResourceList<SeriesSummary> series) {
        this.series = series;
    }

    public ResourceList<EventSummary> getEvents() {
        return events;
    }

    public void setEvents(ResourceList<EventSummary> events) {
        this.events = events;
    }

    public ResourceList<CharacterSummary> getCharacters() {
        return characters;
    }

    public void setCharacters(ResourceList<CharacterSummary> characters) {
        this.characters = characters;
    }

    public ResourceList<CreatorSummary> getCreators() {
        return creators;
    }

    public void setCreators(ResourceList<CreatorSummary> creators) {
        this.creators = creators;
    }

    public ComicSummary getOriginalIssue() {
        return originalIssue;
    }

    public void setOriginalIssue(ComicSummary originalIssue) {
        this.originalIssue = originalIssue;
    }

    /**
     * @return the {@link com.ryonday.marvel.api.data.Story#title} field, to comply with the {@link com.ryonday.marvel.api.data.Summary} contract.
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
                .add("\n\ttype", type)
                .add("\n\tcomics", Objects.firstNonNull(comics, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tseries", Objects.firstNonNull(series, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tevents", Objects.firstNonNull(events, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tcharacters", Objects.firstNonNull(characters, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tcreators", Objects.firstNonNull(creators, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\toriginalIssue", originalIssue)
                .addValue('\n')
                .toString();
    }
}
