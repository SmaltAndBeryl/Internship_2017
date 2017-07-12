package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="batchAssignmentSearch",locations="classpath:sql/batchAssignmentSearchBatches.yml")

public class BatchAssignmentSearchConfigSql {
	
	private String selectSqlInformationOfTheBatchId;

	/**
	 * @return the selectSqlInformationOfTheBatchId
	 */
	public String getSelectSqlInformationOfTheBatchId() {
		return selectSqlInformationOfTheBatchId;
	}

	/**
	 * @param selectSqlInformationOfTheBatchId the selectSqlInformationOfTheBatchId to set
	 */
	public void setSelectSqlInformationOfTheBatchId(
			String selectSqlInformationOfTheBatchId) {
		this.selectSqlInformationOfTheBatchId = selectSqlInformationOfTheBatchId;
	}

    
}


