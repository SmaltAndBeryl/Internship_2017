package com.skill.India.dto;

public class ProfileCreationAssessmentsExperienceInTechnicalDomainDto {

	private String assessmentExperienceId;
	private String assessmentBodyRegistrationId;
	private String domain;
	private int numberOfAssessmentsDone;
	private Boolean isActive;
	
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentsExperienceInTechnicalDomainDto() {
		super();
	}
	/**
	 * @param assessmentExperienceId
	 * @param assessmentBodyRegistrationId
	 * @param domain
	 * @param numberOfAssessmentsDone
	 * @param isActive
	 */
	public ProfileCreationAssessmentsExperienceInTechnicalDomainDto(
			String assessmentExperienceId, String assessmentBodyRegistrationId,
			String domain, int numberOfAssessmentsDone, Boolean isActive) {
		super();
		this.assessmentExperienceId = assessmentExperienceId;
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
		this.domain = domain;
		this.numberOfAssessmentsDone = numberOfAssessmentsDone;
		this.isActive = isActive;
	}
	/**
	 * @return the assessmentExperienceId
	 */
	public String getAssessmentExperienceId() {
		return assessmentExperienceId;
	}
	/**
	 * @param assessmentExperienceId the assessmentExperienceId to set
	 */
	public void setAssessmentExperienceId(String assessmentExperienceId) {
		this.assessmentExperienceId = assessmentExperienceId;
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
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return the numberOfAssessmentsDone
	 */
	public int getNumberOfAssessmentsDone() {
		return numberOfAssessmentsDone;
	}
	/**
	 * @param numberOfAssessmentsDone the numberOfAssessmentsDone to set
	 */
	public void setNumberOfAssessmentsDone(int numberOfAssessmentsDone) {
		this.numberOfAssessmentsDone = numberOfAssessmentsDone;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	

	
}
