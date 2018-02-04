package com.skill.India.dto;

public class ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto {

	private String managementAndStaffId;
	private String trainingPartnerRegistrationId;
	private String name;
	private String designation;
	private String emailId;
	private Long contactNumber;
	private String educationalQualification;
	//private String regularOrVisiting;
	private int experience;
	private String cVPath;
	private Boolean isActive;
	
	
	
	
	/**
	 * 
	 */
	public ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto() {
		super();
	}
	/**
	 * @param type
	 * @param name
	 * @param designation
	 * @param emailId
	 * @param contactNumber
	 * @param educationalQualification
	 * @param regularOrVisiting
	 * @param experience
	 * @param cVPath
	 * @param certificatePath
	 * @param isActive
	 */
	public ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto(
			String managementAndStaffId,String trainingPartnerRegistrationId, String name, String designation, String emailId,
			Long contactNumber, String educationalQualification,
			 int experience, String cVPath,
			Boolean isActive) {
		super();
		this.managementAndStaffId=managementAndStaffId;
		this.trainingPartnerRegistrationId=trainingPartnerRegistrationId;
		//this.trainingPartnerCenterId=trainingPartnerCenterId;

		this.name = name;
		this.designation = designation;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.educationalQualification = educationalQualification;
		//this.regularOrVisiting = regularOrVisiting;
		this.experience = experience;
		this.cVPath = cVPath;
		this.isActive = isActive;
	}
	
	
	
	/**
	 * @return the managementAndStaffId
	 */
	public String getManagementAndStaffId() {
		return managementAndStaffId;
	}
	/**
	 * @param managementAndStaffId the managementAndStaffId to set
	 */
	public void setManagementAndStaffId(String managementAndStaffId) {
		this.managementAndStaffId = managementAndStaffId;
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
	 * @return the trainingPartnerCenterId
	 */
//	public String getTrainingPartnerCenterId() {
//		return trainingPartnerCenterId;
//	}
	/**
	 * @param trainingPartnerCenterId the trainingPartnerCenterId to set
	 */
//	public void setTrainingPartnerCenterId(String trainingPartnerCenterId) {
//		this.trainingPartnerCenterId = trainingPartnerCenterId;
//	}
	/**
	 * @return the type
	 */
//	public String getType() {
//		return type;
//	}
	/**
	 * @param type the type to set
	 */
//	public void setType(String type) {
//		this.type = type;
//	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the contactNumber
	 */
	public Long getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the educationalQualification
	 */
	public String getEducationalQualification() {
		return educationalQualification;
	}
	/**
	 * @param educationalQualification the educationalQualification to set
	 */
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	/**
	 * @return the regularOrVisiting
	 */
//	public String getRegularOrVisiting() {
//		return regularOrVisiting;
//	}
	/**
	 * @param regularOrVisiting the regularOrVisiting to set
	 */
//	public void setRegularOrVisiting(String regularOrVisiting) {
//		this.regularOrVisiting = regularOrVisiting;
//	}
	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	/**
	 * @return the cVPath
	 */
	public String getcVPath() {
		return cVPath;
	}
	/**
	 * @param cVPath the cVPath to set
	 */
	public void setcVPath(String cVPath) {
		this.cVPath = cVPath;
	}
	/**
	 * @return the certificatePath
	 */
//	public String getCertificatePath() {
//		return certificatePath;
//	}
	/**
	 * @param certificatePath the certificatePath to set
	 */
//	public void setCertificatePath(String certificatePath) {
//		this.certificatePath = certificatePath;
//	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
