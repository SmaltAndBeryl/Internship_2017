package com.skill.India.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileCreationTpDto {

	@JsonProperty
	private String trainingPartnerName;
	@JsonProperty
	private String emailId;
	@JsonProperty
	private int mobileNumber;
	@JsonProperty
	private int landlineNumber;
	@JsonProperty
	private String firstName;
//	@JsonProperty
//	private String middleName;
	@JsonProperty
	private String lastName;
	
	public ProfileCreationTpDto() {
		super();
	}
	public ProfileCreationTpDto(String trainingPartnerName,String emailId,int mobileNumber,int landlineNumber,String firstName,String middleName,String lastName)
	{
		super();
		this.trainingPartnerName=trainingPartnerName;
		this.emailId=emailId;
		this.mobileNumber=mobileNumber;
		this.landlineNumber=landlineNumber;
		this.firstName=firstName;
//		this.middleName=middleName;
		this.lastName=lastName;
	
		}


	public String getTrainingPartnerName() {
		return trainingPartnerName;
	}


	


	public String getEmailId() {
		return emailId;
	}


	

	public int getMobileNumber() {
		return mobileNumber;
	}


	public int getLandlineNumber() {
		return landlineNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
