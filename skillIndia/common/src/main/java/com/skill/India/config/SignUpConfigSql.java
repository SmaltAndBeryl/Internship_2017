package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="signUp",locations="classpath:sql/signUp.yml")
public class SignUpConfigSql {
	private String insertSql;
	private String checkSql;
	private String getSql;
		
	
	/**
	 * @return the checkSql
	 */
	public String getCheckSql() {
		return checkSql;
	}

	/**
	 * @param checkSql the checkSql to set
	 */
	public void setCheckSql(String checkSql) {
		this.checkSql = checkSql;
	}

	

	/**
	 * @return the insertSql
	 */
	public String getInsertSql() {
		return insertSql;
	}

	/**
	 * @param insertSql the insertSql to set
	 */
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}

	/**
	 * @return the getSql
	 */
	public String getGetSql() {
		return getSql;
	}

	

}
