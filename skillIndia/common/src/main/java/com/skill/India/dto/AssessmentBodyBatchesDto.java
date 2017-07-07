package com.skill.India.dto;

import java.util.Date;

import com.skill.India.common.BaseDto;


public class AssessmentBodyBatchesDto extends BaseDto{
    private static final long serialVersionUID = 1L;

    private final String batchID;
    private final String abName;
    private final String email;
    private final Integer contactNo;
    private final Date assessmentDate;
    private final String district;
    private final String state;
    private final String noOfCandidate;
    
    
    public AssessmentBodyBatchesDto(String batchID, String abName, String email, Integer contactNo, Date assessmentDate, String district, String state, String noOfCandidate) {
        super();
        this.batchID = batchID;
        this.abName = abName;
        this.email = email;
        this.contactNo = contactNo;
        this.assessmentDate = assessmentDate;
        this.district = district;
        this.state = state;
        this.noOfCandidate = noOfCandidate;
        
        
    }

    public String getBatchID() {
        return batchID;
        
    }

    
    public String getAbName() {
        return abName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Integer getContactNo() {
        return contactNo;
    }
    
    public Date getAssessmentDate() {
        return assessmentDate;
    }
    
    public String getDistrict() {
        return district;
    }
    
    
    public String getState() {
        return state;
    }
    
    public String getNoOfCandidate() {
        return noOfCandidate;
    }
    
}