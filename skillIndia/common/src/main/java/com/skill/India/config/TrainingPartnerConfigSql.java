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

	    private String selectSqlOfBatches;

		/**
		 * @return the selectSqlOfBatches
		 */
		public String getSelectSqlOfBatches() {
			return selectSqlOfBatches;
		}

		/**
		 * @param selectSqlOfBatches the selectSqlOfBatches to set
		 */
		public void setSelectSqlOfBatches(String selectSqlOfBatches) {
			this.selectSqlOfBatches = selectSqlOfBatches;
		}

	     
	    }