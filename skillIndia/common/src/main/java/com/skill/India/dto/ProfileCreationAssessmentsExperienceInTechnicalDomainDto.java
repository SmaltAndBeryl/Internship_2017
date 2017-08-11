package com.skill.India.dto;

public class ProfileCreationAssessmentsExperienceInTechnicalDomainDto {

	private String domain;
	private String numberOfAssessmentsDone;
	

	/**
	 * 
	 */
	public ProfileCreationAssessmentsExperienceInTechnicalDomainDto() {
		super();
	}
	/**
	 * @param domain
	 * @param numberOfAssessmentsDone
	 */
	public ProfileCreationAssessmentsExperienceInTechnicalDomainDto(String domain,
			String numberOfAssessmentsDone) {
		super();
		this.domain = domain;
		this.numberOfAssessmentsDone = numberOfAssessmentsDone;
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
