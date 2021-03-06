package com.skill.India.dto;

public class DashboardTotalBatchesAccordingToJobRoleDto {
		
	private final Integer batches;
	
	private final String jobRole;
	
	private final String jobRoleCode;

	/**
	 * @return the batches
	 */
	public Integer getBatches() {
		return batches;
	}

	/**
	 * @return the jobRole
	 */
	public String getJobRole() {
		return jobRole;
	}

	/**
	 * @return the jobRoleCode
	 */
	public String getJobRoleCode() {
		return jobRoleCode;
	}

	/**
	 * @param batches
	 * @param jobRole
	 * @param jobRoleCode
	 */
	public DashboardTotalBatchesAccordingToJobRoleDto(Integer batches, String jobRole, String jobRoleCode) {
		super();
		this.batches = batches;
		this.jobRole = jobRole;
		this.jobRoleCode = jobRoleCode;
	}
	
	
	

}
