package com.skill.India.dto;

public class CommentDto {
	
	private  String comment;
	private  int applicationId;
	private String applicationState;
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
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
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the applicationId
	 */
	public int getApplicationId() {
		return applicationId;
	}
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @param comment
	 * @param applicationId
	 */
	public CommentDto(String comment, int applicationId) {
		super();
		this.comment = comment;
		this.applicationId = applicationId;
	}
	/**
	 * 
	 */
	public CommentDto() {
		super();
	}
	
	

}
