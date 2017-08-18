package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="ProfileCreationTPABCommon",locations="classpath:sql/ProfileCreationTPABCommon.yml")
public class ProfileCreationTPABCommonConfigSql {
	
	private String getDataFromUser;
	private String insertIntoApplication;
	private String updateIntoApplication;
	/**
	 * @return the getDataFromUser
	 */
	public String getGetDataFromUser() {
		return getDataFromUser;
	}
	/**
	 * @param getDataFromUser the getDataFromUser to set
	 */
	public void setGetDataFromUser(String getDataFromUser) {
		this.getDataFromUser = getDataFromUser;
	}
	/**
	 * @return the insertIntoApplication
	 */
	public String getInsertIntoApplication() {
		return insertIntoApplication;
	}
	/**
	 * @param insertIntoApplication the insertIntoApplication to set
	 */
	public void setInsertIntoApplication(String insertIntoApplication) {
		this.insertIntoApplication = insertIntoApplication;
	}
	/**
	 * @return the updateIntoApplication
	 */
	public String getUpdateIntoApplication() {
		return updateIntoApplication;
	}
	/**
	 * @param updateIntoApplication the updateIntoApplication to set
	 */
	public void setUpdateIntoApplication(String updateIntoApplication) {
		this.updateIntoApplication = updateIntoApplication;
	}
	
	

}
