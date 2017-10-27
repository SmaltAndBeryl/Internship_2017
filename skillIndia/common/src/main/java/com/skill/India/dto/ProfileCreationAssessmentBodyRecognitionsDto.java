package com.skill.India.dto;

public class ProfileCreationAssessmentBodyRecognitionsDto {

	private String assessmentBodyRecognitionId;
	private String assessmentBodyRegistrationId;
	private String nameOfRecognitionBody;
	private String recognitionNumber;
	private String yearOfRecognition;
	private String validityOfRecognition;
	private Boolean isActive;
	
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentBodyRecognitionsDto() {
		super();
	}
	/**
	 * @param assessmentBodyRecognitionId
	 * @param assessmentBodyRegistrationId
	 * @param nameOfRecognitionBody
	 * @param recognitionNumber
	 * @param yearOfRecognition
	 * @param validityOfRecognition
	 */
	public ProfileCreationAssessmentBodyRecognitionsDto(
			String assessmentBodyRecognitionId,
			String assessmentBodyRegistrationId, String nameOfRecognitionBody,
			String recognitionNumber, String yearOfRecognition,
			String validityOfRecognition) {
		super();
		this.assessmentBodyRecognitionId = assessmentBodyRecognitionId;
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
		this.nameOfRecognitionBody = nameOfRecognitionBody;
		this.recognitionNumber = recognitionNumber;
		this.yearOfRecognition = yearOfRecognition;
		this.validityOfRecognition = validityOfRecognition;
	}
	/**
	 * @return the assessmentBodyRecognitionId
	 */
	public String getAssessmentBodyRecognitionId() {
		return assessmentBodyRecognitionId;
	}
	/**
	 * @param assessmentBodyRecognitionId the assessmentBodyRecognitionId to set
	 */
	public void setAssessmentBodyRecognitionId(String assessmentBodyRecognitionId) {
		this.assessmentBodyRecognitionId = assessmentBodyRecognitionId;
	}
	/**
	 * @return the assessmentBodyRegistrationId
	 */
	public String getAssessmentBodyRegistrationId() {
		return assessmentBodyRegistrationId;
	}
	/**
	 * @param assessmentBodyRegistrationId the assessmentBodyRegistrationId to set
	 */
	public void setAssessmentBodyRegistrationId(String assessmentBodyRegistrationId) {
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
	}
	/**
	 * @return the yearOfRecognition
	 */
	
	
	public String getYearOfRecognition() {
		return yearOfRecognition;
	}
	/**
	 * @return the nameOfRecognitionBody
	 */
	public String getNameOfRecognitionBody() {
		return nameOfRecognitionBody;
	}
	/**
	 * @param nameOfRecognitionBody the nameOfRecognitionBody to set
	 */
	public void setNameOfRecognitionBody(String nameOfRecognitionBody) {
		this.nameOfRecognitionBody = nameOfRecognitionBody;
	}
	/**
	 * @return the recognitionNumber
	 */
	public String getRecognitionNumber() {
		return recognitionNumber;
	}
	/**
	 * @param recognitionNumber the recognitionNumber to set
	 */
	public void setRecognitionNumber(String recognitionNumber) {
		this.recognitionNumber = recognitionNumber;
	}
	/**
	 * @param yearOfRecognition the yearOfRecognition to set
	 */
	public void setYearOfRecognition(String yearOfRecognition) {
		this.yearOfRecognition = yearOfRecognition;
	}
	/**
	 * @return the validityOfRecognition
	 */
	public String getValidityOfRecognition() {
		return validityOfRecognition;
	}
	/**
	 * @param validityOfRecognition the validityOfRecognition to set
	 */
	public void setValidityOfRecognition(String validityOfRecognition) {
		this.validityOfRecognition = validityOfRecognition;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
		
}
