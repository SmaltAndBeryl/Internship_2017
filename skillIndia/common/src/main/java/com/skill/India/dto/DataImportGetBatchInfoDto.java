package com.skill.India.dto;

public class DataImportGetBatchInfoDto {
	private String batchId;
	private String batchName;
	private String batchStartDate;
	private String batchEndDate;
	private String trainingPartnerName;
	
	
	public DataImportGetBatchInfoDto(String batchId, String batchName,String batchStartDate,String batchEndDate,String trainingPartnerName) {
		// TODO Auto-generated constructor stub
	this.batchId=batchId;
	this.batchName=batchName;
	this.batchStartDate=batchStartDate;
	this.batchEndDate=batchEndDate;
	this.trainingPartnerName=trainingPartnerName;		
}
	
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
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}
	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	/**
	 * @return the batchStartDate
	 */
	public String getBatchStartDate() {
		return batchStartDate;
	}
	/**
	 * @param batchStartDate the batchStartDate to set
	 */
	public void setBatchStartDate(String batchStartDate) {
		this.batchStartDate = batchStartDate;
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
