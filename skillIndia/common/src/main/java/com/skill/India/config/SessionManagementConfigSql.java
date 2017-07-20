package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="Session",locations="classpath:sql/Session.yml")
public class SessionManagementConfigSql {

private String getUserIdPasswordRole;
private String checkUserSql;


	
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

	/**
	 * @return the getUserIdPasswordRole
	 */
	public String getGetUserIdPasswordRole() {
		return getUserIdPasswordRole;
	}

	/**
	 * @param getUserIdPasswordRole the getUserIdPasswordRole to set
	 */
	public void setGetUserIdPasswordRole(String getUserIdPasswordRole) {
		this.getUserIdPasswordRole = getUserIdPasswordRole;
	}
}
