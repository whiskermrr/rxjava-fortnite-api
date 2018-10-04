package com.example.rxjava_fortnite_api.models.catalog;

import java.util.List;

public class Storefront {
    private String name;
    private List<CatalogEntry> catalogEntries;

    public Storefront() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CatalogEntry> getCatalogEntries() {
        return catalogEntries;
    }

    public void setCatalogEntries(List<CatalogEntry> catalogEntries) {
        this.catalogEntries = catalogEntries;
    }
}
