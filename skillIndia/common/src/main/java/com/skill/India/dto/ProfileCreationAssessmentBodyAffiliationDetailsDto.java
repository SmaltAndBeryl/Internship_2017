package com.skill.India.dto;

public class ProfileCreationAssessmentBodyAffiliationDetailsDto {

	private String affiliationId;
	private String assessmentBodyRegistrationId;
	private String nameOfSectorSkillCouncil;
	
	
	
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentBodyAffiliationDetailsDto() {
		super();
	}
	/**
	 * @param affiliationId
	 * @param assessmentBodyRegistrationId
	 * @param nameOfSectorSkillCouncil
	 */
	public ProfileCreationAssessmentBodyAffiliationDetailsDto(
			String affiliationId, String assessmentBodyRegistrationId,
			String nameOfSectorSkillCouncil) {
		super();
		this.affiliationId = affiliationId;
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
		this.nameOfSectorSkillCouncil = nameOfSectorSkillCouncil;
	}
	/**
	 * @return the affiliationId
	 */
	public String getAffiliationId() {
		return affiliationId;
	}
	/**
	 * @param affiliationId the affiliationId to set
	 */
	public void setAffiliationId(String affiliationId) {
		this.affiliationId = affiliationId;
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
	 * @return the nameOfSectorSkillCouncil
	 */
	public String getNameOfSectorSkillCouncil() {
		return nameOfSectorSkillCouncil;
	}
	/**
	 * @param nameOfSectorSkillCouncil the nameOfSectorSkillCouncil to set
	 */
	public void setNameOfSectorSkillCouncil(String nameOfSectorSkillCouncil) {
		this.nameOfSectorSkillCouncil = nameOfSectorSkillCouncil;
	}

	
	
}
