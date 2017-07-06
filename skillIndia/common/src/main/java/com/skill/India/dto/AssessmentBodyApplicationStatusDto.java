package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class AssessmentBodyApplicationStatusDto extends BaseDto {
	
	  private static final long serialVersionUID = 1L;

	    private final String applicationID;
	    private final String dateOfSubmission;
	    private final String submittedby;
	    private final String status;
	    private final String comment;
	    	    
	    
	    public AssessmentBodyApplicationStatusDto(String applicationID, String dateOfSubmission, String submittedby, String status, String comment) {
	        super();
	        this.applicationID = applicationID;
	        this.dateOfSubmission = dateOfSubmission;
	        this.submittedby = submittedby;
	        this.status = status;
	        this.comment = comment;
	        
	        
	    }

	    public String getApplicationID() {
	        return applicationID;
	        
	    }

	    
	    public String getDateOfSubmission() {
	        return dateOfSubmission;
	    }
	    
	    public String getSubmittedby() {
	        return submittedby;
	    }
	    
	   	    
	    public String getStatus() {
	        return status;
	    }
	    
	    public String getComment() {
	        return comment;
	    }

}
