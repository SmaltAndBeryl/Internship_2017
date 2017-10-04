package com.skill.India.dto;

/*
 * Author 		: Ruchit Jain
 * Description  : DTO for Training Partner 
 */

public class ValidateTrainingPartnerCSVDto {
	private String trainingPartnerId;
	private String applicationId;
	private String trainingPartnerName;
	private String batchType;
	
	
	/**
	 * @return the batchType
	 */
	public String getBatchType() {
		return batchType;
	}
	/**
	 * @param batchType the batchType to set
	 */
	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}
	/**
	 * @return the trainingPartnerId
	 */
	public String getTrainingPartnerId() {
		return trainingPartnerId;
	}
	/**
	 * @param trainingPartnerId the trainingPartnerId to set
	 */
	public void setTrainingPartnerId(String trainingPartnerId) {
		this.trainingPartnerId = trainingPartnerId;
	}
	/**
	 * @return the originalApplicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}
	/**
	 * @param originalApplicationId the originalApplicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @return the trainingPartnerName
	 */
	public String getTrainingPartnerName() {
		return trainingPartnerName;
	}
	/**
	 * @param trainingPartnerName the trainingPartnerName to set
	 */
	public void setTrainingPartnerName(String trainingPartnerName) {
		this.trainingPartnerName = trainingPartnerName;
	}
	
	

}
