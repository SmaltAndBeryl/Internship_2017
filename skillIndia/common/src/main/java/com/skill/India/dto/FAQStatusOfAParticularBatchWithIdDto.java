/**
 * 
 */
package com.skill.India.dto;

import java.sql.Date;

/**
 * @author Aashish sharma on 7/05/2017
 *
 */
public class FAQStatusOfAParticularBatchWithIdDto {
	
	private final String batchId;
	
	private final String trainingPartnerName;
	
	private final Date batchStartDate;
	
	private final Date batchEndDate;
	
	private final Date assessmentDate;
	
	private final String resultApproved;

	/**
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}

	/**
	 * @return the trainingPartnerName
	 */
	public String getTrainingPartnerName() {
		return trainingPartnerName;
	}

	/**
	 * @return the batchStartDate
	 */
	public Date getBatchStartDate() {
		return batchStartDate;
	}

	/**
	 * @return the batchEndDate
	 */
	public Date getBatchEndDate() {
		return batchEndDate;
	}

	/**
	 * @return the assessmentDate
	 */
	public Date getAssessmentDate() {
		return assessmentDate;
	}

	/**
	 * @return the resultApproved
	 */
	public String getResultApproved() {
		return resultApproved;
	}

	/**
	 * @param batchId
	 * @param trainingPartnerName
	 * @param batchStartDate
	 * @param batchEndDate
	 * @param assessmentDate
	 * @param resultApproved
	 */
	public FAQStatusOfAParticularBatchWithIdDto(String batchId,
			String trainingPartnerName, Date batchStartDate,
			Date batchEndDate, Date assessmentDate,
			String resultApproved) {
		super();
		this.batchId = batchId;
		this.trainingPartnerName = trainingPartnerName;
		this.batchStartDate = batchStartDate;
		this.batchEndDate = batchEndDate;
		this.assessmentDate = assessmentDate;
		this.resultApproved = resultApproved;
	}
	
	

}
