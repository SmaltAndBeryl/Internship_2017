package com.skill.India.dto;

public class PriorExperienceDto {
    private final String courseName;
    private final String numberOfBatchesPerYear;
    private final String numberOfStudentsInEachBatch;

    public PriorExperienceDto(String courseName, String numberOfBatchesPerYear, String numberOfStudentsInEachBatch) {

        this.courseName = courseName;
        this.numberOfBatchesPerYear = numberOfBatchesPerYear;
        this.numberOfStudentsInEachBatch = numberOfStudentsInEachBatch;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getNumberOfBatchesPerYear() {
        return numberOfBatchesPerYear;
    }

    public String getNumberOfStudentsInEachBatch() {
        return numberOfStudentsInEachBatch;
    }
}
