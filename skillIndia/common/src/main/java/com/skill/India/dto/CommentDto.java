package com.skill.India.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentDto {
	@JsonProperty
	private Integer commentID;
	@JsonProperty
	private  String comment;
	@JsonProperty
	private  int applicationID;
	@JsonProperty
	private  boolean flag;
	
	
	public CommentDto(Integer commentID, String comment , int applicationID,
			boolean flag) {
		super();
		this.commentID = commentID;
		this.comment = comment;
		this.applicationID = applicationID;
		this.flag = flag;
		}
	
	
	
	public CommentDto() {
		super();
	}



	/**
	 * @return the commentID
	 */
	public Integer getCommentID() {
		return commentID;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return the applicationId
	 */
	public int getApplicationID() {
		return applicationID;
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}
	
	
}
