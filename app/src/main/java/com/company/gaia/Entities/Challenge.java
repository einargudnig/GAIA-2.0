package com.company.gaia.Entities;

public class Challenge {

    private long id;
    private String title;
    public String description;
    private long count;
    private Double carbonIndex;

    public Challenge() {

    }

    /* GETTES & SETTERS */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Double getCarbonIndex() {
        return carbonIndex;
    }

    public void setCarbonIndex(Double carbonIndex) {
        this.carbonIndex = carbonIndex;
    }
}
