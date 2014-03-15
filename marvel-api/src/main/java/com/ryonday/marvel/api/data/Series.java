package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/21/14.
 */
public class Series extends DescribedCoreEntity implements Summary {

    /** The canonical title of the series. */
    private String title;

    /** The first year of publication for the series. */
    private  int startYear;

    /** The last year of publication for the series (conventionally, 2099 for ongoing series) */
    private int endYear;

    /** The age-appropriateness rating for the series. */
    private String rating;

    /** A resource list containing comics in this series. */
    private ResourceList<ComicSummary> comics;

    /** A resource list of stories which occur in the comics in this series. */
    private ResourceList<StorySummary> stories;

    /** A resource list of series in which this event appears. */
    private ResourceList<EventSummary> events;

    /** A resource list of characters which appear in the comics in this series. */
    private ResourceList<CharacterSummary> characters;

    /** A resource list of creators whose work appears in the comics in this series. */
    private ResourceList<CreatorSummary> creators;

    /** A summary representation of the series which follows this series. */
    private SeriesSummary next;

    /** A summary representation of the series which preceded this series. */
    private SeriesSummary previous;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public SeriesSummary getNext() {
        return next;
    }

    public void setNext(SeriesSummary next) {
        this.next = next;
    }

    public SeriesSummary getPrevious() {
        return previous;
    }

    public void setPrevious(SeriesSummary previous) {
        this.previous = previous;
    }

    /**
     * @return the {@link com.ryonday.marvel.api.data.Series#title} field, to comply with the {@link com.ryonday.marvel.api.data.Summary} contract.
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
                .add("\n\tstartYear", startYear)
                .add("\n\tendYear", endYear)
                .add("\n\trating", rating)
                .add("\n\tcomics", Objects.firstNonNull(comics, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tstories", Objects.firstNonNull(stories, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tevents", Objects.firstNonNull(events, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tcharacters", Objects.firstNonNull(characters, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tcreators", Objects.firstNonNull(creators, "").toString().replaceAll( "\n", "\n\t"))
                .add("\n\tnext", next)
                .add("\n\tprevious", previous)

                .addValue('\n')
                .toString();
    }
}
