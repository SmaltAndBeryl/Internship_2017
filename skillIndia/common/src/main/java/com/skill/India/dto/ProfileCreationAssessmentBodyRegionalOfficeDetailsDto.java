package com.skill.India.dto;

public class ProfileCreationAssessmentBodyRegionalOfficeDetailsDto {

	private String regionalOfficeId;
	private String assessmentBodyRegistrationId;
	private String address;
	private String state;
	private Long pincode;
	private Long contactNumber;
	private Long alternateContactNumber;
	private Boolean isActive;
	
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentBodyRegionalOfficeDetailsDto() {
		super();
	}
	/**
	 * @param regionalOfficeId
	 * @param assessmentBodyRegistrationId
	 * @param address
	 * @param state
	 * @param pincode
	 * @param contactNumber
	 * @param alternateContactNumber
	 * @param isActive
	 */
	public ProfileCreationAssessmentBodyRegionalOfficeDetailsDto(
			String regionalOfficeId, String assessmentBodyRegistrationId,
			String address, String state, Long pincode, Long contactNumber,
			Long alternateContactNumber, Boolean isActive) {
		super();
		this.regionalOfficeId = regionalOfficeId;
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.isActive = isActive;
	}
	/**
	 * @return the regionalOfficeId
	 */
	public String getRegionalOfficeId() {
		return regionalOfficeId;
	}
	/**
	 * @param regionalOfficeId the regionalOfficeId to set
	 */
	public void setRegionalOfficeId(String regionalOfficeId) {
		this.regionalOfficeId = regionalOfficeId;
	}
	/**
	 * @return the assessmentBodyRegistrationId
	 */
	public String getAssessmentBodyRegistrationId() {
		return assessmentBodyRegistrationId;
	}
	/**
	 * @param assessmentBodyRegistrationId the assessmentBodyRegistrationId to set
	 */
	public void setAssessmentBodyRegistrationId(String assessmentBodyRegistrationId) {
		this.assessmentBodyRegistrationId = assessmentBodyRegistrationId;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public Long getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(Long pincode) {
		this.pincode = pincode;
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
	 * @return the alternateContactNumber
	 */
	public Long getAlternateContactNumber() {
		return alternateContactNumber;
	}
	/**
	 * @param alternateContactNumber the alternateContactNumber to set
	 */
	public void setAlternateContactNumber(Long alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
		
	
}
