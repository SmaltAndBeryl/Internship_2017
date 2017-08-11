package com.skill.India.dto;

public class ProfileCreationAssessmentBodyAffiliationDetailsDto {

	private String nameOfSectorSkillCouncil;

	
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentBodyAffiliationDetailsDto() {
		super();
	}

	/**
	 * @param nameOfSectorSkillCouncil
	 */
	public ProfileCreationAssessmentBodyAffiliationDetailsDto(
			String nameOfSectorSkillCouncil) {
		super();
		this.nameOfSectorSkillCouncil = nameOfSectorSkillCouncil;
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
