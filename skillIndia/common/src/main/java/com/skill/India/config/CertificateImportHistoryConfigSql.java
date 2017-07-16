/**
 * 
 */
package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Rachit-PC
 *
 */
@Component
@ConfigurationProperties(prefix="certificateimportHistory",locations="classpath:sql/certificateimportHistory.yml")
public class CertificateImportHistoryConfigSql {
	
		
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
