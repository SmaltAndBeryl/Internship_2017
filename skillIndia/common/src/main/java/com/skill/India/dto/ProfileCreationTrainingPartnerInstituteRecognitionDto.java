package com.skill.India.dto;

public class ProfileCreationTrainingPartnerInstituteRecognitionDto {

	private String nameOfRecognizingBody;
	private String recognitionNumber;
	private String yearOfRecognition;
	private String validityOfRecognition;
	
	/**
	 * 
	 */
	public ProfileCreationTrainingPartnerInstituteRecognitionDto() {
		super();
	}
	/**
	 * @param nameOfRecognizingBody
	 * @param recognitionNumber
	 * @param yearOfRecognition
	 * @param validityOfRecognition
	 */
	public ProfileCreationTrainingPartnerInstituteRecognitionDto(
			String nameOfRecognizingBody, String recognitionNumber,
			String yearOfRecognition, String validityOfRecognition) {
		super();
		this.nameOfRecognizingBody = nameOfRecognizingBody;
		this.recognitionNumber = recognitionNumber;
		this.yearOfRecognition = yearOfRecognition;
		this.validityOfRecognition = validityOfRecognition;
	}
	/**
	 * @return the nameOfRecognizingBody
	 */
	public String getNameOfRecognizingBody() {
		return nameOfRecognizingBody;
	}
	/**
	 * @param nameOfRecognizingBody the nameOfRecognizingBody to set
	 */
	public void setNameOfRecognizingBody(String nameOfRecognizingBody) {
		this.nameOfRecognizingBody = nameOfRecognizingBody;
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
	 * @return the yearOfRecognition
	 */
	public String getYearOfRecognition() {
		return yearOfRecognition;
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
	
	
}
