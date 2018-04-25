package com.example.mrr.rx_fortnite_api.models;

public class Stats {

    private String name;
    private String window;
    private Integer value;
    private Integer ownerType;

    public Stats(String name, String window, Integer value, Integer ownerType) {
        this.name = name;
        this.window = window;
        this.value = value;
        this.ownerType = ownerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }
}
