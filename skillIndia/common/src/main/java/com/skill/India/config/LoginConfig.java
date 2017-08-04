package com.skill.India.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="login",locations="classpath:sql/login.yml")
public class LoginConfig {

	private String selectSql;
	private String checkUserSql;
	private String getSPOCNameAndApplicationStatus;
	
	

	

	/**
	 * @return the getSPOCNameAndApplicationStatus
	 */
	public String getGetSPOCNameAndApplicationStatus() {
		return getSPOCNameAndApplicationStatus;
	}

	/**
	 * @param getSPOCNameAndApplicationStatus the getSPOCNameAndApplicationStatus to set
	 */
	public void setGetSPOCNameAndApplicationStatus(
			String getSPOCNameAndApplicationStatus) {
		this.getSPOCNameAndApplicationStatus = getSPOCNameAndApplicationStatus;
	}

	public String getSelectSql() {
		return selectSql;
	}

	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}

	/**
	 * @return the checkUserSql
	 */
	public String getCheckUserSql() {
		return checkUserSql;
	}

	/**
	 * @param checkUserSql the checkUserSql to set
	 */
	public void setCheckUserSql(String checkUserSql) {
		this.checkUserSql = checkUserSql;
	}
	

}
