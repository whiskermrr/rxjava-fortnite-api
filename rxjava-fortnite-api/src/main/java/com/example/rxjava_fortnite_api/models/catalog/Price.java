package com.example.rxjava_fortnite_api.models.catalog;

public class Price {
    private String currencyType;
    private String currencySubType;
    private int regularPrice;
    private int finalPrice;
    private int basePrice;
    private String saleExpiration;

    public Price() {

    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getCurrencySubType() {
        return currencySubType;
    }

    public void setCurrencySubType(String currencySubType) {
        this.currencySubType = currencySubType;
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(int regularPrice) {
        this.regularPrice = regularPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getSaleExpiration() {
        return saleExpiration;
    }

    public void setSaleExpiration(String saleExpiration) {
        this.saleExpiration = saleExpiration;
    }
}
