/**
 * 
 */
package com.skill.India.dto;

/**
 * @author Aashish sharma
 *
 */
public class FAQTrainingCentresNotTakingAnyBatchesDto {
	
	private final Integer centreId;
	
	private final String centreName;

	/**
	 * @return the centreId
	 */
	public Integer getCentreId() {
		return centreId;
	}

	/**
	 * @return the centreName
	 */
	public String getCentreName() {
		return centreName;
	}

	/**
	 * @param centreId
	 * @param centreName
	 */
	public FAQTrainingCentresNotTakingAnyBatchesDto(Integer centreId,
			String centreName) {
		super();
		this.centreId = centreId;
		this.centreName = centreName;
	}
	
	

}
