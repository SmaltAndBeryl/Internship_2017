package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class AssessmentBodyApplicationStatusDto extends BaseDto {
	
	  private static final long serialVersionUID = 1L;

	    private final String applicationID;
	    private final String dateOfSubmission;
	    private final String assessmentAgencyName;
	    private final String applicationState;
	    private final String comment;
	    	    
	    
	    public AssessmentBodyApplicationStatusDto(String applicationID, String dateOfSubmission, String assessmentAgencyName, String applicationState, String comment) {
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

	    
	    public String getDateOfSubmission() {
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
