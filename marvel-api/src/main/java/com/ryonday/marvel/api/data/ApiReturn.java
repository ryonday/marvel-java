package com.ryonday.marvel.api.data;

import com.google.common.base.Objects;

/**
 * Created by ryon on 2/21/14.
 */
public class ApiReturn<E extends CoreEntity> {

    /** The HTTP status code of the returned result. */
    private int code;

    /** A string description of the call status. */
    private String status;

    /** The copyright notice for the returned result. */
    private String copyright;

    /** The attribution notice for this result in raw text. Exploiting applications should include this or {@link #attributionHtml} with displayed results using this API. */
    private String attributionText;

    /** /** The attribution notice for this result in formatted HTML. Exploiting applications should include this or {@link #attributionText} with displayed results using this API. */
    private String attributionHtml;

    /** A digest value of the content returned by the call. */
    private String eTag;

    /** The results returned by the call. */
    private DataContainer<E> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHtml() {
        return attributionHtml;
    }

    public void setAttributionHtml(String attributionHtml) {
        this.attributionHtml = attributionHtml;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }

    public DataContainer<E> getData() {
        return data;
    }

    public void setData(DataContainer<E> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\tcode", code)
                .add("\n\tstatus", status)
                .add("\n\tcopyright", copyright)
                .add("\n\tattributionText", attributionText)
                .add("\n\tattributionHtml", attributionHtml)
                .add("\n\teTag", eTag)
                .add("\n\tdata", Objects.firstNonNull(data, "").toString().replaceAll( "\n", "\n\t") )
                .addValue('\n')
                .toString();
    }
}
