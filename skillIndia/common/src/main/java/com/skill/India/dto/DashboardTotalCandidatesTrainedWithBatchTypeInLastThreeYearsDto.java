package com.skill.India.dto;

public class DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto {
	
	private final Integer year;
	
	private final String batchType;
	
	private final Integer trained;

	/**
	 * @return the years
	 */
	public Integer getYears() {
		return year;
	}

	/**
	 * @return the batchType
	 */
	public String getBatchType() {
		return batchType;
	}

	/**
	 * @return the trained
	 */
	public Integer getTrained() {
		return trained;
	}

	public DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto(Integer years, String batchType, Integer trained) {
		super();
		this.year = years;
		this.batchType = batchType;
		this.trained = trained;
	}
	
	
	

}
