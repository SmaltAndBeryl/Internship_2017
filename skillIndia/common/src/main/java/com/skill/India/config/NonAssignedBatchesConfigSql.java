package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Component
@ConfigurationProperties(prefix="nonAssignedBatches",locations="classpath:sql/nonAssignedBatches.yml")
public class NonAssignedBatchesConfigSql {

    private String selectSqlNonAssignedBatches;
    private String updateSqlNonAssignedBatches;

	public String getUpdateSqlNonAssignedBatches() {
		return updateSqlNonAssignedBatches;
	}

	public void setUpdateSqlNonAssignedBatches(String updateSqlNonAssignedBatches) {
		this.updateSqlNonAssignedBatches = updateSqlNonAssignedBatches;
	}

	/**
	 * @return the selectSqlNonAssignedBatches
	 */
	public String getSelectSqlNonAssignedBatches() {
		return selectSqlNonAssignedBatches;
	}

	/**
	 * @param selectSqlNonAssignedBatches the selectSqlNonAssignedBatches to set
	 */
	public void setSelectSqlNonAssignedBatches(String selectSqlNonAssignedBatches) {
		this.selectSqlNonAssignedBatches = selectSqlNonAssignedBatches;
	}
    
}
