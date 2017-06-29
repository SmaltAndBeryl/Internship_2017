package com.skill.India.dto;

public class DashboardTopStatesWithMaxTrainingCentersDto {
	
	private final String state;
	
	private final Integer trainingCenters;

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the trainingCenters
	 */
	public Integer getTrainingCenters() {
		return trainingCenters;
	}

	public DashboardTopStatesWithMaxTrainingCentersDto(String state, Integer trainingCenters) {
		super();
		this.state = state;
		this.trainingCenters = trainingCenters;
	}


	
}
