package com.skill.India.dto;

public class ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto {

	private String courseName;
	private String numberOfBatchesPerYear;
	private String numberOfStudentsInEachBatch;
	
	
	/**
	 * 
	 */
	public ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto() {
		super();
	}
	/**
	 * @param courseName
	 * @param numberOfBatchesPerYear
	 * @param numberOfStudentsInEachBatch
	 */
	public ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto(
			String courseName, String numberOfBatchesPerYear,
			String numberOfStudentsInEachBatch) {
		super();
		this.courseName = courseName;
		this.numberOfBatchesPerYear = numberOfBatchesPerYear;
		this.numberOfStudentsInEachBatch = numberOfStudentsInEachBatch;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the numberOfBatchesPerYear
	 */
	public String getNumberOfBatchesPerYear() {
		return numberOfBatchesPerYear;
	}
	/**
	 * @param numberOfBatchesPerYear the numberOfBatchesPerYear to set
	 */
	public void setNumberOfBatchesPerYear(String numberOfBatchesPerYear) {
		this.numberOfBatchesPerYear = numberOfBatchesPerYear;
	}
	/**
	 * @return the numberOfStudentsInEachBatch
	 */
	public String getNumberOfStudentsInEachBatch() {
		return numberOfStudentsInEachBatch;
	}
	/**
	 * @param numberOfStudentsInEachBatch the numberOfStudentsInEachBatch to set
	 */
	public void setNumberOfStudentsInEachBatch(String numberOfStudentsInEachBatch) {
		this.numberOfStudentsInEachBatch = numberOfStudentsInEachBatch;
	}

	
}
