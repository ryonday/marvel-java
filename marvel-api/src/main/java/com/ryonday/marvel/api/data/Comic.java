package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by ryon on 2/21/14.
 */
public class Comic extends DescribedCoreEntity implements Summary {

    /** The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally. */
    private int digitalId;

    /** The canonical title of the comic. */
    private String title;

    /** The number of the issue in the series (will generally be 0 for collection formats). */
    private double issueNumber;

    /** If the issue is a variant (e.g. an alternate cover, second printing, or director’s cut), a text description of the variant. */
    private String variantDescription;

    /** The ISBN for the comic (generally only populated for collection formats). */
    private String isbn;

    /** The UPC barcode number for the comic (generally only populated for periodical formats). */
    private String upc;

    /** The Diamond code for the comic. */
    private String diamondCode;

    /** The EAN barcode for the comic. */
    private String ean;

    /** The ISSN barcode for the comic. */
    private String issn;

    /** The publication format of the comic e.g. comic, hardcover, trade paperback. */
    private String format;

    /** The number of story pages in the comic. */
    private int pageCount;

    /** A set of descriptive text blurbs for the comic. */
    private List<TextObject> textObjects;

    /** The canonical URL identifier for this resource. */
    private SeriesSummary series;

    /** A list of variant issues for this comic (includes the "original" issue if the current issue is a variant). */
    private List<ComicSummary> variants;

    /** A list of collections which include this comic (will generally be empty if the comic's format is a collection). */
    private List<ComicSummary> collections;

    /** A list of issues collected in this comic (will generally be empty for periodical formats such as "comic" or "magazine"). */
    private List<ComicSummary> collectedIssues;

    /** A list of key dates for this comic. */
    private List<ComicDate> dates;

    /** A list of prices for this comic. */
    private List<ComicPrice> prices;

    /** A list of promotional images associated with this comic. */
    private List<Image> images;

    /** A resource list containing the creators associated with this comic. */
    private ResourceList<CreatorSummary> creators;

    /** A resource list containing the characters which appear in this comic. */
    private ResourceList<CharacterSummary> characters;

    /** A resource list containing the stories which appear in this comic. */
    private ResourceList<StorySummary> stories;

    /** A resource list containing the events in which this comic appears. */
    private ResourceList<EventSummary> events;

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(double issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<TextObject> textObjects) {
        this.textObjects = textObjects;
    }

    public SeriesSummary getSeries() {
        return series;
    }

    public void setSeries(SeriesSummary series) {
        this.series = series;
    }

    public List<ComicSummary> getVariants() {
        return variants;
    }

    public void setVariants(List<ComicSummary> variants) {
        this.variants = variants;
    }

    public List<ComicSummary> getCollections() {
        return collections;
    }

    public void setCollections(List<ComicSummary> collections) {
        this.collections = collections;
    }

    public List<ComicSummary> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<ComicSummary> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<ComicDate> getDates() {
        return dates;
    }

    public void setDates(List<ComicDate> dates) {
        this.dates = dates;
    }

    public List<ComicPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ComicPrice> prices) {
        this.prices = prices;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public ResourceList<CreatorSummary> getCreators() {
        return creators;
    }

    public void setCreators(ResourceList<CreatorSummary> creators) {
        this.creators = creators;
    }

    public ResourceList<CharacterSummary> getCharacters() {
        return characters;
    }

    public void setCharacters(ResourceList<CharacterSummary> characters) {
        this.characters = characters;
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

    /**
     * @return the {@link com.ryonday.marvel.api.data.Comic#title} field, to comply with the {@link com.ryonday.marvel.api.data.Summary} contract.
     */
    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\tsuperclass", super.toString().replaceAll("\n", "\n\t"))
                .add("\n\tdigitalId", digitalId)
                .add("\n\ttitle", title)
                .add("\n\tissueNumber", issueNumber)
                .add("\n\tvariantDescription", variantDescription)
                .add("\n\tisbn", isbn)
                .add("\n\tupc", upc)
                .add("\n\tdiamondCode", diamondCode)
                .add("\n\tean", ean)
                .add("\n\tissn", issn)
                .add("\n\tformat", format)
                .add("\n\tpageCount", pageCount)
                .add("\n\ttextObjects", textObjects)
                .add("\n\tseries", series)
                .add("\n\tvariants", variants)
                .add("\n\tcollections", collections)
                .add("\n\tcollectedIssues", collectedIssues)
                .add("\n\tdates", dates)
                .add("\n\tprices", prices)
                .add("\n\timages", images)
                .add("\n\tcreators", creators)
                .add("\n\tcharacters", characters)
                .add("\n\tstories", stories)
                .add("\n\tevents", events)
                .addValue('\n')
                .toString();
    }
}
