package com.skill.India.dto;

//import java.sql.Timestamp;

import java.sql.Timestamp;

import com.skill.India.common.BaseDto;

/**
 * The Class PetDto.
 */
public class AssignedBatchesDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private final String batch_id;

	
	
	
	/** The owner. */
	//private final int total_candidates;

	/** The species. */
	private final String job_role;
	
	// The birth.
	private final Timestamp batch_end_date;

	//The death.
	private final Timestamp assessment_date;
	
	
    private final String recommended_ab;
	
	private final String assigned_ab;

	private Integer total_candidates;
	
	public  AssignedBatchesDto(String batch_id, Integer total_candidates, String job_role, Timestamp batch_end_date, Timestamp assessment_date, String assigned_ab, String recommended_ab) 
	{
		super();
	
		this.batch_id = batch_id;
		this.total_candidates = total_candidates;
		this.job_role = job_role;
		this.batch_end_date = batch_end_date;
		this.assessment_date = assessment_date;
		this.assigned_ab = assigned_ab;
		this.recommended_ab = recommended_ab;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public Integer getTotal_candidates() {
		return total_candidates;
	}
	
	

	public String getJob_role() {
		return job_role;
	}

	public Timestamp getBatch_end_date() {
		return batch_end_date;
	}

	public Timestamp getAssessment_date() {
		return assessment_date;
	}

	public String getRecommended_ab() {
		return recommended_ab;
	}

	public String getAssigned_ab() {
		return assigned_ab;
	}
	
	
}

	
	