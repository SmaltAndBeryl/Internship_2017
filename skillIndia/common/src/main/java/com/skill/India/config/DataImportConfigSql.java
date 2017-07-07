package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="DataImport",locations="classpath:sql/DataImport.yml")
public class DataImportConfigSql {
	
		private String selectSql;
		private String insertSql;
		private String agencyIdExistsForAssessor;
		private String insertIntoAssessorSql;
		private String assessorIdExistsForAssessor;
		private String updateIntoAssessorSql;
		private String batchIdemployerIdExistsForCandidate;
		private String candidateDeatilsIdExistsForCandidate;
		private String insertIntoCandidateSql;
		private String updateIntoCandidateSql;
		
		/**
		 * @return the candidateDeatilsIdExistsForCandidate
		 */
		public String getCandidateDeatilsIdExistsForCandidate() {
			return candidateDeatilsIdExistsForCandidate;
		}

		/**
		 * @param candidateDeatilsIdExistsForCandidate the candidateDeatilsIdExistsForCandidate to set
		 */
		public void setCandidateDeatilsIdExistsForCandidate(
				String candidateDeatilsIdExistsForCandidate) {
			this.candidateDeatilsIdExistsForCandidate = candidateDeatilsIdExistsForCandidate;
		}

		/**
		 * @return the insertIntoCandidateSql
		 */
		public String getInsertIntoCandidateSql() {
			return insertIntoCandidateSql;
		}

		/**
		 * @param insertIntoCandidateSql the insertIntoCandidateSql to set
		 */
		public void setInsertIntoCandidateSql(String insertIntoCandidateSql) {
			this.insertIntoCandidateSql = insertIntoCandidateSql;
		}

		/**
		 * @return the updateIntoCandidateSql
		 */
		public String getUpdateIntoCandidateSql() {
			return updateIntoCandidateSql;
		}

		/**
		 * @param updateIntoCandidateSql the updateIntoCandidateSql to set
		 */
		public void setUpdateIntoCandidateSql(String updateIntoCandidateSql) {
			this.updateIntoCandidateSql = updateIntoCandidateSql;
		}

		/**
		 * @return the batchIdemployerIdExistsForCandidate
		 */
		public String getBatchIdemployerIdExistsForCandidate() {
			return batchIdemployerIdExistsForCandidate;
		}

		/**
		 * @param batchIdemployerIdExistsForCandidate the batchIdemployerIdExistsForCandidate to set
		 */
		public void setBatchIdemployerIdExistsForCandidate(
				String batchIdemployerIdExistsForCandidate) {
			this.batchIdemployerIdExistsForCandidate = batchIdemployerIdExistsForCandidate;
		}

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
		 * @return the assessorIdExistsForAssessor
		 */
		public String getAssessorIdExistsForAssessor() {
			return assessorIdExistsForAssessor;
		}

		/**
		 * @param assessorIdExistsForAssessor the assessorIdExistsForAssessor to set
		 */
		public void setAssessorIdExistsForAssessor(String assessorIdExistsForAssessor) {
			this.assessorIdExistsForAssessor = assessorIdExistsForAssessor;
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
		 * @return the selectAgencyIdFromAssessor
		 */
		public String getAgencyIdExistsForAssessor() {
			return agencyIdExistsForAssessor;
		}

		/**
		 * @param selectAgencyIdFromAssessor the selectAgencyIdFromAssessor to set
		 */
		public void setAgencyIdExistsForAssessor(String agencyIdExistsForAssessor) {
			this.agencyIdExistsForAssessor = agencyIdExistsForAssessor;
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
