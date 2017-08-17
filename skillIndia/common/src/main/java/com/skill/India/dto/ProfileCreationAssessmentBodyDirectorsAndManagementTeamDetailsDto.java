package com.skill.India.dto;

public class ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto {

	private String directorsAndManagementId;
	private String assessmentBodyRegistrationId;
	private String name;
	private String designation;
	private String contactNumber;
	private String emailId;
	private String educationalQualification;
	private String experience;
	private String cVPath;
	
	
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto() {
		super();
	}
	/**
	 * @param directorsAndManagementId
	 * @param assessmentBodyRegistrationId
	 * @param name
	 * @param designation
	 * @param contactNumber
	 * @param emailId
	 * @param educationalQualification
	 * @param experience
	 * @param cVPath
	 */
	public ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto(
			String directorsAndManagementId,
			String assessmentBodyRegistrationId, String name,
			String designation, String contactNumber, String emailId,
			String educationalQualification, String experience, String cVPath) {
		super();
		this.directorsAndManagementId = directorsAndManagementId;
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
		this.name = name;
		this.designation = designation;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.educationalQualification = educationalQualification;
		this.experience = experience;
		this.cVPath = cVPath;
	}
	/**
	 * @return the directorsAndManagementId
	 */
	public String getDirectorsAndManagementId() {
		return directorsAndManagementId;
	}
	/**
	 * @param directorsAndManagementId the directorsAndManagementId to set
	 */
	public void setDirectorsAndManagementId(String directorsAndManagementId) {
		this.directorsAndManagementId = directorsAndManagementId;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the educationalQualification
	 */
	public String getEducationalQualification() {
		return educationalQualification;
	}
	/**
	 * @param educationalQualification the educationalQualification to set
	 */
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * @return the cVPath
	 */
	public String getcVPath() {
		return cVPath;
	}
	/**
	 * @param cVPath the cVPath to set
	 */
	public void setcVPath(String cVPath) {
		this.cVPath = cVPath;
	}
	

	
	
	
}
