package com.skill.India.dto;


public class AssessmentBodyHomepageDto {

	private String batchId;
	
	private String trainingPartnerDetails;
	
	private String assessmentDate;
	
	private String location;
	
	private Integer totalCandidatesInBatch;

	/**
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the trainingPartnerDetails
	 */
	public String getTrainingPartnerDetails() {
		return trainingPartnerDetails;
	}

	/**
	 * @param trainingPartnerDetails the trainingPartnerDetails to set
	 */
	public void setTrainingPartnerDetails(String trainingPartnerDetails) {
		this.trainingPartnerDetails = trainingPartnerDetails;
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
	 * @return the totalCandidatesInBatch
	 */
	public Integer getTotalCandidatesInBatch() {
		return totalCandidatesInBatch;
	}

	/**
	 * @param totalCandidatesInBatch the totalCandidatesInBatch to set
	 */
	public void setTotalCandidatesInBatch(Integer totalCandidatesInBatch) {
		this.totalCandidatesInBatch = totalCandidatesInBatch;
	}
	
	public AssessmentBodyHomepageDto(String batchId, String trainingPartnerDetails, String assessmentDate, String location, Integer totalCandidatesInBatch ){
		super();
		this.batchId = batchId;
		this.trainingPartnerDetails = trainingPartnerDetails;
		this.assessmentDate = assessmentDate;
		this.location = location;
		this.totalCandidatesInBatch = totalCandidatesInBatch;
	}
	
}
