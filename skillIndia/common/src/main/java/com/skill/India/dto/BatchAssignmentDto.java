package com.skill.India.dto;

/**
 * Created by Priyanshu pandey on 7/13/2017.
 */

public class BatchAssignmentDto {
	
	private Integer batchId;
	
	private String location;
	
	private String batchEndDate;
	
	private String assessmentDate;
	
	private String agencyName;

	/**
	 * @return the batchId
	 */
	public Integer getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the batchEndDate
	 */
	public String getBatchEndDate() {
		return batchEndDate;
	}

	/**
	 * @param batchEndDate the batchEndDate to set
	 */
	public void setBatchEndDate(String batchEndDate) {
		this.batchEndDate = batchEndDate;
	}

	/**
	 * @return the assessmentDate
	 */
	public String getAssessmentDate() {
		return assessmentDate;
	}

	/**
	 * @param assessmentDate the assessmentDate to set
	 */
	public void setAssessmentDate(String assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	/**
	 * @return the agencyName
	 */
	public String getAgencyName() {
		return agencyName;
	}

	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public BatchAssignmentDto(Integer batchId, String location, String batchEndDate, String assessmentDate, String agencyName) {
		super();
		this.batchId = batchId;
		this.location = location;
		this.batchEndDate = batchEndDate;
		this.assessmentDate = assessmentDate;
		this.agencyName = agencyName;
	}
}
