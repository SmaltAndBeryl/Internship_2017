package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class TrainingPartnerApplicationStatusDto extends BaseDto
{
	private static final long serialVersionUID = 1L;

    private final String applicationID;
    private final String dateOfSubmission;
    private final String trainingPartnerName;
    private final String applicationState;
    private final String comment;
    	    
    
    public TrainingPartnerApplicationStatusDto(String applicationID, String dateOfSubmission, String trainingPartnerName, String applicationState, String comment) {
        super();
        this.applicationID = applicationID;
        this.dateOfSubmission = dateOfSubmission;
        this.trainingPartnerName = trainingPartnerName;
        this.applicationState = applicationState;
        this.comment = comment;
        
        
    }

    public String getApplicationID() {
        return applicationID;
        
    }

    
    public String getDateOfSubmission() {
        return dateOfSubmission;
    }
    
    public String gettrainingPartnerName() {
        return trainingPartnerName;
    }
    
   	    
    public String getapplicationState() {
        return applicationState;
    }
    
    public String getComment() {
        return comment;
    }
}