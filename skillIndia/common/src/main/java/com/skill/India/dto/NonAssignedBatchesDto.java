package com.skill.India.dto;

/**
 * Created by Alkesh srivastav on 7/12/2017.
 */
public class NonAssignedBatchesDto {
    private final String batchID;
    private final String state;
    private final String batchEndDate;
    private final String assessmentDate;

    public String getBatchID() {
        return batchID;
    }

    public String getState() {
        return state;
    }

    public String getBatchEndDate() {
        return batchEndDate;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public NonAssignedBatchesDto(String batchID, String state, String batchEndDate, String assessmentDate) {
        super();
        this.batchID = batchID;
        this.state = state;
        this.batchEndDate = batchEndDate;
        this.assessmentDate = assessmentDate;
    }
}
