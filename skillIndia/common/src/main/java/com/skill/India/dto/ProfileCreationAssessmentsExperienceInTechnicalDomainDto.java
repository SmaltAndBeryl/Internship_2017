package com.skill.India.dto;

public class ProfileCreationAssessmentsExperienceInTechnicalDomainDto {

	private String assessmentExperienceId;
	private String assessmentBodyRegistrationId;
	private String domain;
	private String numberOfAssessmentsDone;
	
	
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
	 */
	public ProfileCreationAssessmentsExperienceInTechnicalDomainDto(
			String assessmentExperienceId, String assessmentBodyRegistrationId,
			String domain, String numberOfAssessmentsDone) {
		super();
		this.assessmentExperienceId = assessmentExperienceId;
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
		this.domain = domain;
		this.numberOfAssessmentsDone = numberOfAssessmentsDone;
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
	public String getNumberOfAssessmentsDone() {
		return numberOfAssessmentsDone;
	}
	/**
	 * @param numberOfAssessmentsDone the numberOfAssessmentsDone to set
	 */
	public void setNumberOfAssessmentsDone(String numberOfAssessmentsDone) {
		this.numberOfAssessmentsDone = numberOfAssessmentsDone;
	}
	

	
}
