package com.skill.India.dto;

import java.sql.Date;



import com.skill.India.common.BaseDto;

public class ApproveRejectTableDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;

	private Integer applicationId;
	
	private final String applicationState ;

	private final Boolean activeFlag;
	
	private final Date dateOfSubmission;

	private String userRole;
	
	private final String organizationName;

	
	
	public ApproveRejectTableDto (Integer applicationId, String applicationState, Boolean activeFlag, Date dateOfSubmission, String organisationName, String userRole) {
		super();
		this.applicationId = applicationId;
		this.applicationState = applicationState;
		this.activeFlag = activeFlag;
		this.dateOfSubmission = dateOfSubmission;	
		this.organizationName = organisationName;
		this.userRole=userRole;

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

	public String getOrganisationName()
	{
		return organizationName;
	}
	public String getUserRole()
	{
		return userRole;
	}
}