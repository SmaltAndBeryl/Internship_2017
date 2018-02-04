package com.skill.India.dto;

public class ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto {

	private String priorExperienceInSkillTrainingId;
	private String trainingPartnerRegistrationId;
	private String courseName;
	private Long numberOfBatchesPerYear;
	private int numberOfStudentsInEachBatch;
	private Boolean isActive;
	
	
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
	 * @param isActive
	 */
	public ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto(
			String priorExperienceInSkillTrainingId,
			String trainingPartnerRegistrationId,
			String courseName, Long numberOfBatchesPerYear,
			int numberOfStudentsInEachBatch, Boolean isActive) {
		super();
		this.courseName = courseName;
		this.numberOfBatchesPerYear = numberOfBatchesPerYear;
		this.numberOfStudentsInEachBatch = numberOfStudentsInEachBatch;
		this.priorExperienceInSkillTrainingId=priorExperienceInSkillTrainingId;
		this.trainingPartnerRegistrationId=trainingPartnerRegistrationId;
		this.isActive = isActive;
	}
	
	
	
	/**
	 * @return the priorExperienceInSkillTrainingId
	 */
	public String getPriorExperienceInSkillTrainingId() {
		return priorExperienceInSkillTrainingId;
	}
	/**
	 * @param priorExperienceInSkillTrainingId the priorExperienceInSkillTrainingId to set
	 */
	public void setPriorExperienceInSkillTrainingId(
			String priorExperienceInSkillTrainingId) {
		this.priorExperienceInSkillTrainingId = priorExperienceInSkillTrainingId;
	}
	/**
	 * @return the trainingPartnerRegistrationId
	 */
	public String getTrainingPartnerRegistrationId() {
		return trainingPartnerRegistrationId;
	}
	/**
	 * @param trainingPartnerRegistrationId the trainingPartnerRegistrationId to set
	 */
	public void setTrainingPartnerRegistrationId(
			String trainingPartnerRegistrationId) {
		this.trainingPartnerRegistrationId = trainingPartnerRegistrationId;
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
	public Long getNumberOfBatchesPerYear() {
		return numberOfBatchesPerYear;
	}
	/**
	 * @param numberOfBatchesPerYear the numberOfBatchesPerYear to set
	 */
	public void setNumberOfBatchesPerYear(Long numberOfBatchesPerYear) {
		this.numberOfBatchesPerYear = numberOfBatchesPerYear;
	}
	/**
	 * @return the numberOfStudentsInEachBatch
	 */
	public int getNumberOfStudentsInEachBatch() {
		return numberOfStudentsInEachBatch;
	}
	/**
	 * @param numberOfStudentsInEachBatch the numberOfStudentsInEachBatch to set
	 */
	public void setNumberOfStudentsInEachBatch(int numberOfStudentsInEachBatch) {
		this.numberOfStudentsInEachBatch = numberOfStudentsInEachBatch;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
}
