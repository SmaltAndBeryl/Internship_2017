package com.skill.India.dto;

public class CenterLevelDto {
    private final String numberOfClassrooms;
    private final String buildingType;

    public String getNumberOfClassrooms() {
        return numberOfClassrooms;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public CenterLevelDto(String numberOfClassrooms, String buildingType) {
        this.numberOfClassrooms = numberOfClassrooms;
        this.buildingType = buildingType;

    }
}
