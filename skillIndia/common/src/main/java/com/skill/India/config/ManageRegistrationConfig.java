package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "approve", locations = "classpath:sql/manage.yml")
public class ManageRegistrationConfig {

	    private String updateSql;

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

