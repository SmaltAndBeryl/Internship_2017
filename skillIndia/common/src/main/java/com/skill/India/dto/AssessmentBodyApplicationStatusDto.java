package com.skill.India.dto;

import java.util.Date;

import com.skill.India.common.BaseDto;

public class AssessmentBodyApplicationStatusDto extends BaseDto {
	
	  private static final long serialVersionUID = 1L;

	    private final String applicationID;
	    private final Date dateOfSubmission;
	    private final String assessmentAgencyName;
	    private final String applicationState;
	    private final String comment;
	    	    
	    
	    public AssessmentBodyApplicationStatusDto(String applicationID, Date dateOfSubmission, String assessmentAgencyName, String applicationState, String comment) {
	        super();
	        this.applicationID = applicationID;
	        this.dateOfSubmission = dateOfSubmission;
	        this.assessmentAgencyName = assessmentAgencyName;
	        this.applicationState = applicationState;
	        this.comment = comment;
	        
	        
	    }

	    public String getApplicationID() {
	        return applicationID;
	        
	    }

	    
	    public Date getDateOfSubmission() {
	        return dateOfSubmission;
	    }
	    
	    public String getassessmentAgencyName() {
	        return assessmentAgencyName;
	    }
	    
	   	    
	    public String getapplicationState() {
	        return applicationState;
	    }
	    
	    public String getComment() {
	        return comment;
	    }

}
