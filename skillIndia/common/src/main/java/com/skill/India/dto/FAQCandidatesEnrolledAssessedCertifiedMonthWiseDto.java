/**
 * 
 */
package com.skill.India.dto;

/**
 * @author Aashish sharma
 *
 */
public class FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto {
	
	private String month;
	
	private Integer numberOfCandidates;

	
	/**
	 * 
	 */
	public FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto() {
		super();
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @return the numberOfCandidates
	 */
	public Integer getNumberOfCandidates() {
		return numberOfCandidates;
	}

	/**
	 * @param month
	 * @param numberOfCandidates
	 */
	public FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto(String month,
			Integer numberOfCandidates) {
		super();
		this.month = month;
		this.numberOfCandidates = numberOfCandidates;
	}
	
	

}
