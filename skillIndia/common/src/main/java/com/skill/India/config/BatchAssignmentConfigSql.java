package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Priyanshu pandey on 7/13/2017.
 */

@Component
@ConfigurationProperties(prefix="batchAssignment",locations="classpath:sql/batchAssignment.yml")
public class BatchAssignmentConfigSql {


		
		private String selectSqlProposedBatchesBatchAssignment;
		
		private String selectSqlApprovedBatchesBatchAssignment;
		
		private String selectSqlRejectedBatchesBatchAssignment;
		
		private String updateSqlBatchAssignment;

		/**
		 * @return the selectSqlproposedBatchesBatchAssignment
		 */
		public String getSelectSqlproposedBatchesBatchAssignment() {
			return selectSqlProposedBatchesBatchAssignment;
		}

		/**
		 * @param selectSqlproposedBatchesBatchAssignment the selectSqlproposedBatchesBatchAssignment to set
		 */
		public void setSelectSqlproposedBatchesBatchAssignment(
				String selectSqlproposedBatchesBatchAssignment) {
			this.selectSqlProposedBatchesBatchAssignment = selectSqlproposedBatchesBatchAssignment;
		}

		/**
		 * @return the selectSqlapprovedBatchesBatchAssignment
		 */
		public String getSelectSqlapprovedBatchesBatchAssignment() {
			return selectSqlApprovedBatchesBatchAssignment;
		}

		/**
		 * @param selectSqlapprovedBatchesBatchAssignment the selectSqlapprovedBatchesBatchAssignment to set
		 */
		public void setSelectSqlapprovedBatchesBatchAssignment(
				String selectSqlapprovedBatchesBatchAssignment) {
			this.selectSqlApprovedBatchesBatchAssignment = selectSqlapprovedBatchesBatchAssignment;
		}

		/**
		 * @return the selectSqlrejectedBatchesBatchAssignment
		 */
		public String getSelectSqlrejectedBatchesBatchAssignment() {
			return selectSqlRejectedBatchesBatchAssignment;
		}

		/**
		 * @param selectSqlrejectedBatchesBatchAssignment the selectSqlrejectedBatchesBatchAssignment to set
		 */
		public void setSelectSqlrejectedBatchesBatchAssignment(
				String selectSqlrejectedBatchesBatchAssignment) {
			this.selectSqlRejectedBatchesBatchAssignment = selectSqlrejectedBatchesBatchAssignment;
		}
		
		/**
		 * @return the updateSqlBatchAssignment
		 */
		public String getUpdateSqlBatchAssignment() {
			return updateSqlBatchAssignment;
		}

		/**
		 * @param updateSqlBatchAssignment the updateSqlBatchAssignment to set
		 */
		public void setUpdateSqlBatchAssignment(String updateSqlBatchAssignment) {
			this.updateSqlBatchAssignment = updateSqlBatchAssignment;
		}

	}