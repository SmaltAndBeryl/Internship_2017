/**
 * 
 */
package com.skill.India.dto;

/**
 * @author Aashish sharma
 *
 */
public class FAQBatchWiseCandidateDetailsDto {
	
	private final String candidateName;
	
	private final String mobileNumber;
	
	private final String emailId;
	
	private final String traineeAddress;
	
	private final String trainingPartnerName;
	
	private final Integer batchId;
	
	private final String batchStartDate;
	
	private final String batchEndDate;

	/**
	 * @return the candidateName
	 */
	public String getCandidateName() {
		return candidateName;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @return the eMailId
	 */
	public String geteMailId() {
		return emailId;
	}

	/**
	 * @return the traineeAddress
	 */
	public String getTraineeAddress() {
		return traineeAddress;
	}

	/**
	 * @return the trainingPartnerName
	 */
	public String getTrainingPartnerName() {
		return trainingPartnerName;
	}

	/**
	 * @return the batchId
	 */
	public Integer getBatchId() {
		return batchId;
	}

	/**
	 * @return the batchStartDate
	 */
	public String getBatchStartDate() {
		return batchStartDate;
	}

	/**
	 * @return the batchEndDate
	 */
	public String getBatchEndDate() {
		return batchEndDate;
	}

	/**
	 * @param candidateName
	 * @param mobileNumber
	 * @param eMailId
	 * @param traineeAddress
	 * @param trainingPartnerName
	 * @param batchId
	 * @param batchStartDate
	 * @param batchEndDate
	 */
	public FAQBatchWiseCandidateDetailsDto(String candidateName,
			String mobileNumber, String eMailId, String traineeAddress,
			String trainingPartnerName, Integer batchId, String batchStartDate,
			String batchEndDate) {
		super();
		this.candidateName = candidateName;
		this.mobileNumber = mobileNumber;
		this.emailId = eMailId;
		this.traineeAddress = traineeAddress;
		this.trainingPartnerName = trainingPartnerName;
		this.batchId = batchId;
		this.batchStartDate = batchStartDate;
		this.batchEndDate = batchEndDate;
	}
	
	

}
