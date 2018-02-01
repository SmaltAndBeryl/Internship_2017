package com.skill.India.dto;

import java.util.Date;

import com.skill.India.common.BaseDto;

public class TrainingPartnerApplicationStatusDto extends BaseDto
{
	private static final long serialVersionUID = 1L;

    private final String applicationID;
    private final Date dateOfSubmission;
    private final String trainingPartnerName;
    private final String applicationState;
    private final String comment;
    	    
    
    public TrainingPartnerApplicationStatusDto(String applicationID, Date dateOfSubmission, String trainingPartnerName, String applicationState, String comment) {
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

    
    public Date getDateOfSubmission() {
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