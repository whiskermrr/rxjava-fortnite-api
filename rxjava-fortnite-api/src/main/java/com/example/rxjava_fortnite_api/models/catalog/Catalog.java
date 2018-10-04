package com.example.rxjava_fortnite_api.models.catalog;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Catalog {
    private int refreshIntervalHrs;
    private int dailyPurchaseHrs;
    private String expiration;
    private List<Storefront> storefronts;

    public Catalog() {

    }

    public int getRefreshIntervalHrs() {
        return refreshIntervalHrs;
    }

    public void setRefreshIntervalHrs(int refreshIntervalHrs) {
        this.refreshIntervalHrs = refreshIntervalHrs;
    }

    public int getDailyPurchaseHrs() {
        return dailyPurchaseHrs;
    }

    public void setDailyPurchaseHrs(int dailyPurchaseHrs) {
        this.dailyPurchaseHrs = dailyPurchaseHrs;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public List<Storefront> getStorefronts() {
        return storefronts;
    }

    public void setStorefronts(List<Storefront> storefronts) {
        this.storefronts = storefronts;
    }
}
