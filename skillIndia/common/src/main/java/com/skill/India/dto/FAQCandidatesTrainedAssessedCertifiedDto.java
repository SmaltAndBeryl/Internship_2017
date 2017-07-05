package com.skill.India.dto;

public class FAQCandidatesTrainedAssessedCertifiedDto {

		private Integer totalNoOfCandidatesEnrolled;
		
		private Integer totalNoOfCandidatesAssessed;
		
		private Integer totalNoOfCandidatesCertified;
		
		/**
		 * @return the totalNoOfCandidatesEnrolled
		 */
		public Integer getTotalNoOfCandidatesEnrolled() {
			return totalNoOfCandidatesEnrolled;
		}

		/**
		 * @return the totalNoOfCandidatesAssessed
		 */
		public Integer getTotalNoOfCandidatesAssessed() {
			return totalNoOfCandidatesAssessed;
		}

		/**
		 * @return the totalNoOfCandidatesCertified
		 */
		public Integer getTotalNoOfCandidatesCertified() {
			return totalNoOfCandidatesCertified;
		}

		/**
		 * @param totalNoOfCandidatesEnrolled
		 * @param totalNoOfCandidatesAssessed
		 * @param totalNoOfCandidatesCertified
		 */
		public FAQCandidatesTrainedAssessedCertifiedDto(Integer totalNoOfCandidatesEnrolled,
				Integer totalNoOfCandidatesAssessed, Integer totalNoOfCandidatesCertified) {
			this.totalNoOfCandidatesEnrolled = totalNoOfCandidatesEnrolled;
			this.totalNoOfCandidatesAssessed = totalNoOfCandidatesAssessed;
			this.totalNoOfCandidatesCertified = totalNoOfCandidatesCertified;
		}

}
