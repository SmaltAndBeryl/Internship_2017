package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="userIdtoApplicationId",locations="classpath:sql/userIdtoApplicationId.yml")
public class UserIdtoApplicationIdConfigSql {
	
	private String selectSql;

	/**
	 * @return the selectSql
	 */
	public String getSelectSql() {
		return selectSql;
	}

	/**
	 * @param selectSql the selectSql to set
	 */
	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}

}
