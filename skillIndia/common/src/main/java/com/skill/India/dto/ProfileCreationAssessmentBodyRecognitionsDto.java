package com.skill.India.dto;

public class ProfileCreationAssessmentBodyRecognitionsDto {

	private String NameOfRecognitionBody;
	private String RecognitionNumber;
	private String yearOfRecognition;
	private String validityOfRecognition;
	
	
	
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentBodyRecognitionsDto() {
		super();
	}
	/**
	 * @param nameOfRecognitionBody
	 * @param recognitionNumber
	 * @param yearOfRecognition
	 * @param validityOfRecognition
	 */
	public ProfileCreationAssessmentBodyRecognitionsDto(
			String nameOfRecognitionBody, String recognitionNumber,
			String yearOfRecognition, String validityOfRecognition) {
		super();
		NameOfRecognitionBody = nameOfRecognitionBody;
		RecognitionNumber = recognitionNumber;
		this.yearOfRecognition = yearOfRecognition;
		this.validityOfRecognition = validityOfRecognition;
	}
	/**
	 * @return the nameOfRecognitionBody
	 */
	public String getNameOfRecognitionBody() {
		return NameOfRecognitionBody;
	}
	/**
	 * @param nameOfRecognitionBody the nameOfRecognitionBody to set
	 */
	public void setNameOfRecognitionBody(String nameOfRecognitionBody) {
		NameOfRecognitionBody = nameOfRecognitionBody;
	}
	/**
	 * @return the recognitionNumber
	 */
	public String getRecognitionNumber() {
		return RecognitionNumber;
	}
	/**
	 * @param recognitionNumber the recognitionNumber to set
	 */
	public void setRecognitionNumber(String recognitionNumber) {
		RecognitionNumber = recognitionNumber;
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
