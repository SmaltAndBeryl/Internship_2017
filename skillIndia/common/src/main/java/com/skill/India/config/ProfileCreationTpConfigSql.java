package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="profileCreation",locations="classpath:sql/profileCreationTp.yml")
public class ProfileCreationTpConfigSql {

	
	private String insertSqlOfProfileCreation;
    private String checkSqlOfProfileCreation;
	/**
	 * @return the insertSqlOfProfileCreation
	 */
	public String getInsertSqlOfProfileCreation() {
		return insertSqlOfProfileCreation;
	}

	/**
	 * @return the checkSqlOfProfileCreation
	 */
	public String getCheckSqlOfProfileCreation() {
		return checkSqlOfProfileCreation;
	}

	/**
	 * @param checkSqlOfProfileCreation the checkSqlOfProfileCreation to set
	 */
	public void setCheckSqlOfProfileCreation(String checkSqlOfProfileCreation) {
		this.checkSqlOfProfileCreation = checkSqlOfProfileCreation;
	}

	/**
	 * @param insertSqlOfProfileCreation the insertSqlOfProfileCreation to set
	 */
	public void setInsertSqlOfProfileCreation(String insertSqlOfProfileCreation) {
		this.insertSqlOfProfileCreation = insertSqlOfProfileCreation;
	}

}
