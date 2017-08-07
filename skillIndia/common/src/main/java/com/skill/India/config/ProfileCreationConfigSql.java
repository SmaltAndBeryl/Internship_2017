package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="ProfileCreation",locations="classpath:sql/ProfileCreation.yml")
public class ProfileCreationConfigSql {

	private String getTrainingPartnerDataByUserId;
	private String checkuserIdExistenceInTrainingPartnerRegistration;
	private String getTrainingPartnerDataByUserIdFronUser;
	
	/*
	 * Save As Draft Functionality
	 */
	private String insertDataInApplication;
	private String insertDataInTrainingPartnerRegistration;
	private String updateDataInTrainingPartnerRegistration;
	
	
	private String updateDataInApplication;
	
	
	
	
	/**
	 * @return the updateDataInApplication
	 */
	public String getUpdateDataInApplication() {
		return updateDataInApplication;
	}

	/**
	 * @param updateDataInApplication the updateDataInApplication to set
	 */
	public void setUpdateDataInApplication(String updateDataInApplication) {
		this.updateDataInApplication = updateDataInApplication;
	}

	/**
	 * @return the updateDataInTrainingPartnerRegistration
	 */
	public String getUpdateDataInTrainingPartnerRegistration() {
		return updateDataInTrainingPartnerRegistration;
	}

	/**
	 * @param updateDataInTrainingPartnerRegistration the updateDataInTrainingPartnerRegistration to set
	 */
	public void setUpdateDataInTrainingPartnerRegistration(
			String updateDataInTrainingPartnerRegistration) {
		this.updateDataInTrainingPartnerRegistration = updateDataInTrainingPartnerRegistration;
	}

	/**
	 * @return the insertDataInTrainingPartnerRegistration
	 */
	public String getInsertDataInTrainingPartnerRegistration() {
		return insertDataInTrainingPartnerRegistration;
	}

	/**
	 * @param insertDataInTrainingPartnerRegistration the insertDataInTrainingPartnerRegistration to set
	 */
	public void setInsertDataInTrainingPartnerRegistration(
			String insertDataInTrainingPartnerRegistration) {
		this.insertDataInTrainingPartnerRegistration = insertDataInTrainingPartnerRegistration;
	}

	/**
	 * @return the insertDataInApplication
	 */
	public String getInsertDataInApplication() {
		return insertDataInApplication;
	}

	/**
	 * @param insertDataInApplication the insertDataInApplication to set
	 */
	public void setInsertDataInApplication(String insertDataInApplication) {
		this.insertDataInApplication = insertDataInApplication;
	}

	/**
	 * @return the getTrainingPartnerDataByUserIdFronUser
	 */
	public String getGetTrainingPartnerDataByUserIdFronUser() {
		return getTrainingPartnerDataByUserIdFronUser;
	}

	/**
	 * @param getTrainingPartnerDataByUserIdFronUser the getTrainingPartnerDataByUserIdFronUser to set
	 */
	public void setGetTrainingPartnerDataByUserIdFronUser(
			String getTrainingPartnerDataByUserIdFronUser) {
		this.getTrainingPartnerDataByUserIdFronUser = getTrainingPartnerDataByUserIdFronUser;
	}

	/**
	 * @return the checkuserIdExistenceInTrainingPartnerRegistration
	 */
	public String getCheckuserIdExistenceInTrainingPartnerRegistration() {
		return checkuserIdExistenceInTrainingPartnerRegistration;
	}

	/**
	 * @param checkuserIdExistenceInTrainingPartnerRegistration the checkuserIdExistenceInTrainingPartnerRegistration to set
	 */
	public void setCheckuserIdExistenceInTrainingPartnerRegistration(
			String checkuserIdExistenceInTrainingPartnerRegistration) {
		this.checkuserIdExistenceInTrainingPartnerRegistration = checkuserIdExistenceInTrainingPartnerRegistration;
	}

	/**
	 * @return the getTrainingPartnerDataByUserId
	 */
	public String getGetTrainingPartnerDataByUserId() {
		return getTrainingPartnerDataByUserId;
	}

	/**
	 * @param getTrainingPartnerDataByUserId the getTrainingPartnerDataByUserId to set
	 */
	public void setGetTrainingPartnerDataByUserId(
			String getTrainingPartnerDataByUserId) {
		this.getTrainingPartnerDataByUserId = getTrainingPartnerDataByUserId;
	}
	
}
