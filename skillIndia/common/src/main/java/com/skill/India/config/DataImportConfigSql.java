package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="DataImport",locations="classpath:sql/DataImport.yml")
public class DataImportConfigSql {
		private String selectSql;
		private String insertSql;
		private String agencyIDExistsForAssessor;
		private String insertIntoAssessorSql;
		private String assessorIDExistsForAssessor;
		private String updateIntoAssessorSql;
		
		
		/**
		 * @return the updateIntoAssessorSql
		 */
		public String getUpdateIntoAssessorSql() {
			return updateIntoAssessorSql;
		}

		/**
		 * @param updateIntoAssessorSql the updateIntoAssessorSql to set
		 */
		public void setUpdateIntoAssessorSql(String updateIntoAssessorSql) {
			this.updateIntoAssessorSql = updateIntoAssessorSql;
		}

		/**
		 * @return the assessorIDExistsForAssessor
		 */
		public String getAssessorIDExistsForAssessor() {
			return assessorIDExistsForAssessor;
		}

		/**
		 * @param assessorIDExistsForAssessor the assessorIDExistsForAssessor to set
		 */
		public void setAssessorIDExistsForAssessor(String assessorIDExistsForAssessor) {
			this.assessorIDExistsForAssessor = assessorIDExistsForAssessor;
		}

		/**
		 * @return the insertIntoAssessorSql
		 */
		public String getInsertIntoAssessorSql() {
			return insertIntoAssessorSql;
		}

		/**
		 * @param insertIntoAssessorSql the insertIntoAssessorSql to set
		 */
		public void setInsertIntoAssessorSql(String insertIntoAssessorSql) {
			this.insertIntoAssessorSql = insertIntoAssessorSql;
		}

		/**
		 * @return the selectAgencyIDFromAssessor
		 */
		public String getAgencyIDExistsForAssessor() {
			return agencyIDExistsForAssessor;
		}

		/**
		 * @param selectAgencyIDFromAssessor the selectAgencyIDFromAssessor to set
		 */
		public void setAgencyIDExistsForAssessor(String agencyIDExistsForAssessor) {
			this.agencyIDExistsForAssessor = agencyIDExistsForAssessor;
		}

		public String getSelectSql()
		{
			return selectSql;
		}
		
		public void setSelectSql(String selectSql)
		{
			this.selectSql=selectSql;
		}
		
		public String getInsertSql()
		{
			return insertSql;
		}
		
		public void setInsertSql(String insertSql)
		{
			this.insertSql=insertSql;
		}

}
