/**
 * 
 */
package com.skill.India.dto;

/**
 * @author Aashish sharma
 *
 */
public class FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto {
	
	private Integer batches;
	
	private Integer totalCandidates;

	/**
	 * @return the batches
	 */
	public Integer getBatches() {
		return batches;
	}

	/**
	 * @param batches the batches to set
	 */
	public void setBatches(Integer batches) {
		this.batches = batches;
	}

	/**
	 * @return the totalCandidates
	 */
	public Integer getTotalCandidates() {
		return totalCandidates;
	}

	/**
	 * @param totalCandidates the totalCandidates to set
	 */
	public void setTotalCandidates(Integer totalCandidates) {
		this.totalCandidates = totalCandidates;
	}

	/**
	 * @param batches
	 * @param totalCandidates
	 */
	public FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto(
			Integer batches, Integer totalCandidates) {
		super();
		this.batches = batches;
		this.totalCandidates = totalCandidates;
	}
	
	

}
