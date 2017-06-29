package com.skill.India.dto;

public class DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto {
	
	private final Integer year;
	
	private final Integer candidatesCertified;
	
	private final String mode;

	/**
	 * @return the years
	 */
	public Integer getYears() {
		return year;
	}

	/**
	 * @return the candidatesCertified
	 */
	public Integer getCandidatesCertified() {
		return candidatesCertified;
	}

	/**
	 * @return the modes
	 */
	public String getModes() {
		return mode;
	}

	/**
	 * @param years
	 * @param candidatesCertified
	 * @param modes
	 */
	public DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto(Integer years, Integer candidatesCertified, String modes) {
		super();
		this.year = years;
		this.candidatesCertified = candidatesCertified;
		this.mode = modes;
	}
	
	

}
