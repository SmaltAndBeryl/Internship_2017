package com.skill.India.dto;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

public class ProfileCreationABTPDto {

	private String type;
	private HashMap<String, HashMap<String, HashMap<String, String>>> userData;
	private HashMap<String, HashMap<String, HashMap<String, MultipartFile>>> userUploads;
	private HashMap<String, HashMap<String, HashMap<String, String>>> userDeletes;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public HashMap<String, HashMap<String, HashMap<String, MultipartFile>>> getUserUploads() {
		return userUploads;
	}
	public void setUserUploads(HashMap<String, HashMap<String, HashMap<String, MultipartFile>>> userUploads) {
		this.userUploads = userUploads;
	}
	public HashMap<String, HashMap<String, HashMap<String, String>>> getUserDeletes() {
		return userDeletes;
	}
	public void setUserDeletes(HashMap<String, HashMap<String, HashMap<String, String>>> userDeletes) {
		this.userDeletes = userDeletes;
	}
	public HashMap<String, HashMap<String, HashMap<String, String>>> getUserData() {
		return userData;
	}
	public void setUserData(HashMap<String, HashMap<String, HashMap<String, String>>> userData) {
		this.userData = userData;
	}
	
}
