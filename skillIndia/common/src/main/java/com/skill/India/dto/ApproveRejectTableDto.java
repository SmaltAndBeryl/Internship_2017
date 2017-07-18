package com.skill.India.dto;

import java.sql.Date;



import com.skill.India.common.BaseDto;

public class ApproveRejectTableDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;

	private Integer applicationId;
	
	private final String applicationState ;

	private final Boolean activeFlag;
	
	private final Date dateOfSubmission;

	private final String userId;
	
	private final String organisationName;

	
	
	public ApproveRejectTableDto (Integer applicationId, String applicationState, Boolean activeFlag, Date dateOfSubmission,String userId, String organisationName) {
		super();
		this.applicationId = applicationId;
		this.applicationState = applicationState;
		this.activeFlag = activeFlag;
		this.dateOfSubmission = dateOfSubmission;
		this.userId = userId;
		this.organisationName = organisationName;

	}

	public Integer getapplicationId() {
		return applicationId;
	}

	public String getapplicationState() {
		return applicationState;
	}


	public Boolean getactiveFlag() {
		return activeFlag;
	}
	public 	Date getdateOfSubmission() {
		return dateOfSubmission;
	}
	public String getuserId() {
		return userId;
}
	public String getOrganisationName()
	{
		return organisationName;
	}
}