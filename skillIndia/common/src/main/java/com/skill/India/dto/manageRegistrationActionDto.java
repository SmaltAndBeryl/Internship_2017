package com.skill.India.dto;



	public class ManageRegistrationActionDto{

		private String applicationState;
		private String userId;
		private Boolean activeFlag;		
		/**
		 * @return the activeFlag
		 */
		public Boolean getActiveFlag() {
			return activeFlag;
		}
		/**
		 * @param activeFlag the activeFlag to set
		 */
		public void setActiveFlag(Boolean activeFlag) {
			this.activeFlag = activeFlag;
		}
		/**
		 * @return the applicationState
		 */
		public String getApplicationState() {
			return applicationState;
		}
		/**
		 * @param applicationState the applicationState to set
		 */
		public void setApplicationState(String applicationState) {
			this.applicationState = applicationState;
		}
		/**
		 * @return the userId
		 */
		public String getUserId() {
			return userId;
		}
		/**
		 * 
		 */
		public ManageRegistrationActionDto() {
			super();
		}
		/**
		 * @param applicationState
		 * @param userId
		 */
		public ManageRegistrationActionDto(String applicationState,
				String userId,Boolean activeFlag) {
			super();
			this.applicationState = applicationState;
			this.userId = userId;
			this.activeFlag = activeFlag;
		}
		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}
	    	    	    
	}
