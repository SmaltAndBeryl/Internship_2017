package com.skill.India.dto;

public class ProfileCreationTrainingPartnerTrainingStaffDetailsDto {
	private String trainingStaffId;
	private String trainingPartnerRegistrationId;
	private String name;
	private String designation;
	private String emailId;
	private String educationalQualification;
	private String regularOrVisiting;
	private String experience;
	private String cVPath;
	private String certificatePath;
	private Boolean isActive;
	
	
	public ProfileCreationTrainingPartnerTrainingStaffDetailsDto()
	{
		super();
	}
	
	public ProfileCreationTrainingPartnerTrainingStaffDetailsDto (String trainingStaffId,String trainingPartnerRegistrationId, 
			String name, String designation, String emailId, String educationalQualification,
			String regularOrVisiting , String experience, String cVPath, String certificatePath,
			Boolean isActive)
			{
				super();
				this.trainingStaffId = trainingStaffId;
				this.trainingPartnerRegistrationId = trainingPartnerRegistrationId;
				this.name = name;
				this.designation = designation;
				this.emailId = emailId;
				this.educationalQualification = educationalQualification;
				this.regularOrVisiting = regularOrVisiting;
				this.experience = experience;
				this.cVPath = cVPath;
				this.certificatePath = certificatePath;
				this.isActive = isActive;
			}
	
	public String getTrainingStaffId() {
		return trainingStaffId;
	}
	public void setTrainingStaffId(String trainingStaffId) {
		this.trainingStaffId = trainingStaffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrainingPartnerRegistrationId() {
		return trainingPartnerRegistrationId;
	}
	public void setTrainingPartnerRegistrationId(
			String trainingPartnerRegistrationId) {
		this.trainingPartnerRegistrationId = trainingPartnerRegistrationId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEducationalQualification() {
		return educationalQualification;
	}
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	public String getRegularOrVisiting() {
		return regularOrVisiting;
	}
	public void setRegularOrVisiting(String regularOrVisiting) {
		this.regularOrVisiting = regularOrVisiting;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getcVPath() {
		return cVPath;
	}
	public void setcVPath(String cVPath) {
		this.cVPath = cVPath;
	}
	public String getCertificatePath() {
		return certificatePath;
	}
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
