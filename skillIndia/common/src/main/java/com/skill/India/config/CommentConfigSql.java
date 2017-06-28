package com.skill.India.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="comment",locations="classpath:sql/ManageRegistrationComment.yml")
 public class CommentConfigSql {

		private String insertSql;

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
	
		
		
	}



