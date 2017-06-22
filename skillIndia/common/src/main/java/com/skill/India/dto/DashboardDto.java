package com.skill.India.dto;

import java.util.Collections;

public class DashboardDto {

	
	//private final Integer totalCandidateEnrolled;
	
//	private final Integer totalCandidateAssessed;
	
//	private final Integer totalCandidateCertified;
	
//	private final Integer totalTrainingPartner;
	
//	private final Integer totalTrainingCenter;
	
	private final String key;
	
	public String getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}

	private final Integer value;
	
		
	public DashboardDto(String key,Integer value) {
		super();
		this.key = key;
		this.value = value;
	}

/*	public DashboardDto(Integer totalCandidateEnrolled, Integer totalCandidateAssessed, Integer totalCandidateCertified,
			Integer totalTrainingPartner, Integer totalTrainingCenter) {
		super();
		this.totalCandidateEnrolled = totalCandidateEnrolled;
		this.totalCandidateAssessed = totalCandidateAssessed;
		this.totalCandidateCertified = totalCandidateCertified;
		this.totalTrainingPartner = totalTrainingPartner;
		this.totalTrainingCenter = totalTrainingCenter;
		
		
	}

	public Integer getTotalCandidateEnrolled() {
		return totalCandidateEnrolled;
	}

	public Integer getTotalCandidateAssessed() {
		return totalCandidateAssessed;
	}

	public Integer getTotalCandidateCertified() {
		return totalCandidateCertified;
	}

	public Integer getTotalTrainingPartner() {
		return totalTrainingPartner;
	}

	public Integer getTotalTrainingCenter() {
		return totalTrainingCenter;
	}
	*/
}
