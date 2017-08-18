package com.skill.India.dto;

public class ProfileCreationGetDataFromUserDto {

	private String organizationName;
	private String sPOCName;
	private String userId;
	
	
	
	/**
	 * 
	 */
	public ProfileCreationGetDataFromUserDto() {
		super();
	}



	/**
	 * @param organizationName
	 * @param sPOCName
	 * @param userId
	 */
	public ProfileCreationGetDataFromUserDto(String organizationName,
			String sPOCName, String userId) {
		super();
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
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
	
	
	
}
