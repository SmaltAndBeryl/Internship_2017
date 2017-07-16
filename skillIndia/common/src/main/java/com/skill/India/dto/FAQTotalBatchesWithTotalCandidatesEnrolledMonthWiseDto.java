/**
 * 
 */
package com.skill.India.dto;

/**
 * @author Aashish sharma
 *
 */
public class FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto {
		
		private final String month;
		
		private final Integer totalBatches;
		
		private final Integer candidatesEnrolled;

		/**
		 * @return the month
		 */
		public String getMonth() {
			return month;
		}

		/**
		 * @return the totalBatches
		 */
		public Integer getTotalBatches() {
			return totalBatches;
		}

		/**
		 * @return the candidatesEnrolled
		 */
		public Integer getCandidatesEnrolled() {
			return candidatesEnrolled;
		}

		/**
		 * @param month
		 * @param totalBatches
		 * @param candidatesEnrolled
		 */
		public FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto(String month,
				Integer totalBatches, Integer candidatesEnrolled) {
			super();
			this.month = month;
			this.totalBatches = totalBatches;
			this.candidatesEnrolled = candidatesEnrolled;
		}
		
		
}
