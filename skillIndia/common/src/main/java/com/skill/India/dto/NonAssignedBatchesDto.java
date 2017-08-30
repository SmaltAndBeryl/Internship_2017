package com.skill.India.dto;

/**
 * Created by Alkesh srivastav on 7/12/2017.
 */
public class NonAssignedBatchesDto {
    private final String batchID;
    private final String state;
    private final String district;
    private final String batchEndDate;
    private final String assessmentDate;
    private final String recommendedAB;

    public String getBatchID() {
        return batchID;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getBatchEndDate() {
        return batchEndDate;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public String getRecommendedAB() {
        return recommendedAB;
    }

    public NonAssignedBatchesDto(String batchID, String state, String district, String batchEndDate, String assessmentDate, String recommendedAB) {
        super();
        this.batchID = batchID;
        this.state = state;
        this.district = district;
        this.batchEndDate = batchEndDate;
        this.assessmentDate = assessmentDate;
        this.recommendedAB = recommendedAB;
    }


}
