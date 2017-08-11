package com.skill.India.dto;

public class ProfileCreationAssessmentBodyRegionalOfficeDetailsDto {

	private String address;
	private String state;
	private String pincode;
	private String contactNumber;
	private String alternateContactNumber;
	
	/**
	 * 
	 */
	public ProfileCreationAssessmentBodyRegionalOfficeDetailsDto() {
		super();
	}
	/**
	 * @param address
	 * @param state
	 * @param pincode
	 * @param contactNumber
	 * @param alternateContactNumber
	 */
	public ProfileCreationAssessmentBodyRegionalOfficeDetailsDto(
			String address, String state, String pincode, String contactNumber,
			String alternateContactNumber) {
		super();
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
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
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the alternateContactNumber
	 */
	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}
	/**
	 * @param alternateContactNumber the alternateContactNumber to set
	 */
	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	
	
}
