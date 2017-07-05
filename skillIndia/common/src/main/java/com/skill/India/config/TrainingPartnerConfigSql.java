/**
 * 
 */
package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Rachit Goyal
 *
 */
@Component
@ConfigurationProperties(prefix = "trainingPartnerBatches", locations = "classpath:sql/trainingPartner.yml")
public class TrainingPartnerConfigSql {

	    private String selectSql;

	    public String getSelectSql() {
	        return selectSql;
	    }

	    public void setSelectSql(String selectSql) {
	        this.selectSql = selectSql;
	    }
}