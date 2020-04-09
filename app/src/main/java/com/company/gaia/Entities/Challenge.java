package com.company.gaia.Entities;
/*
    TODO:
    Gera Challenge til að birta gögnin á réttan máta
    Þarf að vera eins uppsett og gamla gagnagrunninum
    id, title, info, count, carbonIndex
 */

import java.util.UUID;

public class Challenge {
    private UUID cId;
    private String title;
    private String info;
    private int count;
    private double carbonIndex;

    public Challenge(UUID cId, String title, String info, int count, double carbonIndex) {
        super();
        this.cId = cId;
        this.title = title;
        this.info = info;
        this.count = count;
        this.carbonIndex = carbonIndex;
    }


    public UUID getcId() {
        return cId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getCount() {
        return count;
    }

    public double getCarbonIndex() {
        return carbonIndex;
    }
}
