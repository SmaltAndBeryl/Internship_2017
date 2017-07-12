package com.skill.India.dto;

public class BatchAssignmentSearchDto {
  
	private final String state;
	
	private final String batchEndDate;
	
	private final String assessmentDate;
	
	private final Integer batchId;
	
	private final String assessorName;

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the batchEndDate
	 */
	public String getBatchEndDate() {
		return batchEndDate;
	}

	/**
	 * @return the assessmentDate
	 */
	public String getAssessmentDate() {
		return assessmentDate;
	}

	/**
	 * @return the batchId
	 */
	public Integer getBatchId() {
		return batchId;
	}

	/**
	 * @return the assessorName
	 */
	public String getAssessorName() {
		return assessorName;
	}

	/**
	 * @param state
	 * @param batchEndDate
	 * @param assessmentDate
	 * @param batchId
	 * @param assessorName
	 */
	public BatchAssignmentSearchDto(String state, String batchEndDate,
			String assessmentDate, Integer batchId, String assessorName) {
		super();
		this.state = state;
		this.batchEndDate = batchEndDate;
		this.assessmentDate = assessmentDate;
		this.batchId = batchId;
		this.assessorName = assessorName;
	}
	
	}

	

