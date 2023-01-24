
package com.GoRest.Pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Pagination {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     */
    public Pagination() {
    }

    /**
     * @param total
     * @param pages
     * @param limit
     * @param links
     * @param page
     */
    public Pagination(Integer total, Integer pages, Integer page, Integer limit, Links links) {
        super();
        this.total = total;
        this.pages = pages;
        this.page = page;
        this.limit = limit;
        this.links = links;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Pagination withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Pagination withPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Pagination withPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Pagination withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Pagination withLinks(Links links) {
        this.links = links;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Pagination.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null) ? "<null>" : this.total));
        sb.append(',');
        sb.append("pages");
        sb.append('=');
        sb.append(((this.pages == null) ? "<null>" : this.pages));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null) ? "<null>" : this.page));
        sb.append(',');
        sb.append("limit");
        sb.append('=');
        sb.append(((this.limit == null) ? "<null>" : this.limit));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null) ? "<null>" : this.links));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.limit == null) ? 0 : this.limit.hashCode()));
        result = ((result * 31) + ((this.total == null) ? 0 : this.total.hashCode()));
        result = ((result * 31) + ((this.links == null) ? 0 : this.links.hashCode()));
        result = ((result * 31) + ((this.pages == null) ? 0 : this.pages.hashCode()));
        result = ((result * 31) + ((this.page == null) ? 0 : this.page.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pagination) == false) {
            return false;
        }
        Pagination rhs = ((Pagination) other);
        return ((((((this.limit == rhs.limit) || ((this.limit != null) && this.limit.equals(rhs.limit))) && ((this.total == rhs.total) || ((this.total != null) && this.total.equals(rhs.total)))) && ((this.links == rhs.links) || ((this.links != null) && this.links.equals(rhs.links)))) && ((this.pages == rhs.pages) || ((this.pages != null) && this.pages.equals(rhs.pages)))) && ((this.page == rhs.page) || ((this.page != null) && this.page.equals(rhs.page))));
    }

}
