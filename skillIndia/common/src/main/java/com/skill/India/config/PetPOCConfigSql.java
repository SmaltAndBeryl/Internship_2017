package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="pet",locations="classpath:sql/petPOC.yml")
public class PetPOCConfigSql {

	
	private String selectSql;
	private String insertSql;
	private String updateSql;
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
	 * @return the updateSql
	 */
	public String getUpdateSql() {
		return updateSql;
	}
	/**
	 * @param updateSql the updateSql to set
	 */
	public void setUpdateSql(String updateSql) {
		this.updateSql = updateSql;
	}
	
	
	
}
