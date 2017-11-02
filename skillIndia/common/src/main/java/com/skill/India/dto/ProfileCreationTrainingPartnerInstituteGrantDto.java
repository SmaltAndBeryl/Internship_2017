package com.skill.India.dto;

public class ProfileCreationTrainingPartnerInstituteGrantDto {

	private String instituteGrantId;
	private String trainingPartnerRegistrationId;
	private String nameOfMinistry;
	private String natureOfWork;
	private String remarks;
	private Boolean isActive;
	
	
	/**
	 * 
	 */
	public ProfileCreationTrainingPartnerInstituteGrantDto() {
		super();
	}
	/**
	 * @param nameOfMinistry
	 * @param natureOfWork
	 * @param remarks
	 */
	public ProfileCreationTrainingPartnerInstituteGrantDto(String instituteGrantId, String trainingPartnerRegistrationId ,String nameOfMinistry,
			String natureOfWork, String remarks, Boolean isActive) {
		super();
		this.instituteGrantId=instituteGrantId;
		this.trainingPartnerRegistrationId=trainingPartnerRegistrationId;
		this.nameOfMinistry = nameOfMinistry;
		this.natureOfWork = natureOfWork;
		this.remarks = remarks;
		this.isActive = isActive;
	}
	

	/**
	 * @return the instituteGrantId
	 */
	public String getInstituteGrantId() {
		return instituteGrantId;
	}
	/**
	 * @param instituteGrantId the instituteGrantId to set
	 */
	public void setInstituteGrantId(String instituteGrantId) {
		this.instituteGrantId = instituteGrantId;
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
	 * @return the nameOfMinistry
	 */
	public String getNameOfMinistry() {
		return nameOfMinistry;
	}
	/**
	 * @param nameOfMinistry the nameOfMinistry to set
	 */
	public void setNameOfMinistry(String nameOfMinistry) {
		this.nameOfMinistry = nameOfMinistry;
	}
	/**
	 * @return the natureOfWork
	 */
	public String getNatureOfWork() {
		return natureOfWork;
	}
	/**
	 * @param natureOfWork the natureOfWork to set
	 */
	public void setNatureOfWork(String natureOfWork) {
		this.natureOfWork = natureOfWork;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
