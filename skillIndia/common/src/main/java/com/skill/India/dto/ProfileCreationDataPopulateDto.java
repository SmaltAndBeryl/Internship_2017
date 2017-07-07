package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class ProfileCreationDataPopulateDto extends BaseDto{
	
	private String organizationName;
	private String spocName;
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @return the spocName
	 */
	public String getSpocName() {
		return spocName;
	}
	
	public ProfileCreationDataPopulateDto(String organizationName, String spocName) {
		// TODO Auto-generated constructor stub
		super();
		
		this.organizationName = organizationName;
		this.spocName = spocName;
	}
		
	

}
