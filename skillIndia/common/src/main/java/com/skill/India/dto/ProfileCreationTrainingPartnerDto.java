package com.skill.India.dto;

public class ProfileCreationTrainingPartnerDto {
	
	private String organizationName;
	private String sPOCName;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String mobileNumber;
	private String alternateMobileNumber;
	private String landlineNumber;
	private String alternateLandlineNumber;
	private String faxNumber;
	private String websites;
	private String userId;
	private String type;
	
	
	
	/**
	 * 
	 */
	public ProfileCreationTrainingPartnerDto() {
		super();
	}



	/**
	 * @param organizationName
	 * @param sPOCName
	 * @param userId
	 */
	public ProfileCreationTrainingPartnerDto(String organizationName,
			String sPOCName, String userId) {
		super();
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
		this.userId = userId;
	}



	/**
	 * @param organizationName
	 * @param sPOCName
	 * @param address
	 * @param city
	 * @param state
	 * @param pincode
	 * @param mobileNumber
	 * @param alternateMobileNumber
	 * @param landlineNumber
	 * @param alternateLandlineNumber
	 * @param faxNumber
	 * @param websites
	 */
	public ProfileCreationTrainingPartnerDto(String organizationName,
			String sPOCName,String userId, String address, String city, String state,
			String pincode, String mobileNumber, String alternateMobileNumber,
			String landlineNumber, String alternateLandlineNumber,
			String faxNumber, String websites) {
		super();
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.alternateMobileNumber = alternateMobileNumber;
		this.landlineNumber = landlineNumber;
		this.alternateLandlineNumber = alternateLandlineNumber;
		this.faxNumber = faxNumber;
		this.websites = websites;
		this.userId=userId;
	}
	
	
	
	
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}



	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}



	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * @return the sPOCName
	 */
	public String getsPOCName() {
		return sPOCName;
	}
	/**
	 * @param sPOCName the sPOCName to set
	 */
	public void setsPOCName(String sPOCName) {
		this.sPOCName = sPOCName;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the alternateMobileNumber
	 */
	public String getAlternateMobileNumber() {
		return alternateMobileNumber;
	}
	/**
	 * @param alternateMobileNumber the alternateMobileNumber to set
	 */
	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}
	/**
	 * @return the landlineNumber
	 */
	public String getLandlineNumber() {
		return landlineNumber;
	}
	/**
	 * @param landlineNumber the landlineNumber to set
	 */
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	/**
	 * @return the alternateLandlineNumber
	 */
	public String getAlternateLandlineNumber() {
		return alternateLandlineNumber;
	}
	/**
	 * @param alternateLandlineNumber the alternateLandlineNumber to set
	 */
	public void setAlternateLandlineNumber(String alternateLandlineNumber) {
		this.alternateLandlineNumber = alternateLandlineNumber;
	}
	/**
	 * @return the faxNumber
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	/**
	 * @return the websites
	 */
	public String getWebsites() {
		return websites;
	}
	/**
	 * @param websites the websites to set
	 */
	public void setWebsites(String websites) {
		this.websites = websites;
	}

	
	
	
	
	
	
	
	
	
	
//	
//	
//	private String organizationName;
//	private String SPOCName;
//	private String address;
//	private String city;
//	private String state;
//	private String pincode;
//	private String mobileNumber;
//	private String landlineNumber;
//	private String faxNumber;
//	private String website;
//	private String userId;
//	
//	/**
//	 * @return the pincode
//	 */
//	public String getPincode() {
//		return pincode;
//	}
//	/**
//	 * @param pincode the pincode to set
//	 */
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
//	/**
//	 * @return the organizationName
//	 */
//	public String getOrganizationName() {
//		return organizationName;
//	}
//	/**
//	 * @param organizationName the organizationName to set
//	 */
//	public void setOrganizationName(String organizationName) {
//		this.organizationName = organizationName;
//	}
//	/**
//	 * @return the sPOCName
//	 */
//	public String getSPOCName() {
//		return SPOCName;
//	}
//	/**
//	 * @param sPOCName the sPOCName to set
//	 */
//	public void setSPOCName(String sPOCName) {
//		SPOCName = sPOCName;
//	}
//	/**
//	 * @return the address
//	 */
//	public String getAddress() {
//		return address;
//	}
//	/**
//	 * @param address the address to set
//	 */
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	/**
//	 * @return the city
//	 */
//	public String getCity() {
//		return city;
//	}
//	/**
//	 * @param city the city to set
//	 */
//	public void setCity(String city) {
//		this.city = city;
//	}
//	/**
//	 * @return the state
//	 */
//	public String getState() {
//		return state;
//	}
//	/**
//	 * @param state the state to set
//	 */
//	public void setState(String state) {
//		this.state = state;
//	}
//	
//	/**
//	 * @return the mobileNumber
//	 */
//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//	/**
//	 * @param mobileNumber the mobileNumber to set
//	 */
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//	/**
//	 * @return the landlineNumber
//	 */
//	public String getLandlineNumber() {
//		return landlineNumber;
//	}
//	/**
//	 * @param landlineNumber the landlineNumber to set
//	 */
//	public void setLandlineNumber(String landlineNumber) {
//		this.landlineNumber = landlineNumber;
//	}
//	/**
//	 * @return the faxNumber
//	 */
//	public String getFaxNumber() {
//		return faxNumber;
//	}
//	/**
//	 * @param faxNumber the faxNumber to set
//	 */
//	public void setFaxNumber(String faxNumber) {
//		this.faxNumber = faxNumber;
//	}
//	/**
//	 * @return the website
//	 */
//	public String getWebsite() {
//		return website;
//	}
//	/**
//	 * @param website the website to set
//	 */
//	public void setWebsite(String website) {
//		this.website = website;
//	}
//	/**
//	 * @return the userId
//	 */
//	public String getUserId() {
//		return userId;
//	}
//	/**
//	 * @param userId the userId to set
//	 */
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	/**
//	 * @param organizationName
//	 * @param sPOCName
//	 * @param address
//	 * @param city
//	 * @param state
//	 * @param pincode
//	 * @param mobileNumber
//	 * @param landlineNumber
//	 * @param faxNumber
//	 * @param website
//	 * @param userId
//	 */
//	public ProfileCreationTrainingPartnerDto(String organizationName,
//			String sPOCName, String address, String city, String state,
//			String pincode, String mobileNumber, String landlineNumber,
//			String faxNumber, String website, String userId) {
//		super();
//		this.organizationName = organizationName;
//		this.SPOCName = sPOCName;
//		this.address = address;
//		this.city = city;
//		this.state = state;
//		this.pincode = pincode;
//		this.mobileNumber = mobileNumber;
//		this.landlineNumber = landlineNumber;
//		this.faxNumber = faxNumber;
//		this.website = website;
//		this.userId = userId;
//	}
//	/**
//	 * @param organizationName
//	 * @param sPOCName
//	 * @param userId
//	 */
//	public ProfileCreationTrainingPartnerDto(String organizationName,
//			String sPOCName, String userId) {
//		super();
//		this.organizationName = organizationName;
//		SPOCName = sPOCName;
//		this.userId = userId;
//	}
//	/**
//	 * 
//	 */
//	public ProfileCreationTrainingPartnerDto() {
//		super();
//	}
//	
	

}
