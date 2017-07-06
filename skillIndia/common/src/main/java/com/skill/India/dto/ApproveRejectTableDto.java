package com.skill.India.dto;

import java.sql.Date;



import com.skill.India.common.BaseDto;

public class ApproveRejectTableDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;

	private Integer applicationId;
	
	private final String applicationState ;

	private final Boolean activeFlag;
	
	private final Date date;

	private final String userId;

	
	
	public ApproveRejectTableDto (Integer applicationId, String applicationState, Boolean activeFlag, Date date,String userId) {
		super();
		this.applicationId = applicationId;
		this.applicationState = applicationState;
		this.activeFlag = activeFlag;
		this.date = date;
		this.userId = userId;

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
	public 	Date getdate() {
		return date;
	}
	public String getuserId() {
		return userId;
}
}