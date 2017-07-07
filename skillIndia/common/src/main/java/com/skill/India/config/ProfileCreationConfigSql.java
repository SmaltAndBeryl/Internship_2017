package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="profileCreation",locations="classpath:sql/dataPopulateProfileCreation.yml")
public class ProfileCreationConfigSql {
	
	private String populateData;

	/**
	 * @return the populateData
	 */
	public String getPopulateData() {
		return populateData;
	}

	/**
	 * @param populateData the populateData to set
	 */
	public void setPopulateData(String populateData) {
		this.populateData = populateData;
	}

}
