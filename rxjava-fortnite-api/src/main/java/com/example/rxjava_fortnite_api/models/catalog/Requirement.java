package com.example.rxjava_fortnite_api.models.catalog;

public class Requirement {
    private String requirementType;
    private String requiredId;
    private int minQuantity;

    public Requirement() {

    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequiredId() {
        return requiredId;
    }

    public void setRequiredId(String requiredId) {
        this.requiredId = requiredId;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }
}
