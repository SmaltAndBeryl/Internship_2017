package com.skill.India.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:applicationConstants.properties")
@ConfigurationProperties
	public class ReadApplicationConstants {

	   
	   private String saveCSVAtLocation;
	   private String saveCertificateAtLocation;
	   private String profileCreationTrainingPartnerFolder;
	   private String profileCreationAssessmentBodyFolder;
	   private String emailSender;
	   private String senderPassword;
	   private String hostserver;
	   private String hostport;
	   private String smskey;
	   private String senderId;
	   private String smsUrl;
	   private String pathtobrochure;
	   
	   
	   
	   
	   
	   

	/**
	 * @return the pathtobrochure
	 */
	public String getPathtobrochure() {
		return pathtobrochure;
	}

	/**
	 * @param pathtobrochure the pathtobrochure to set
	 */
	public void setPathtobrochure(String pathtobrochure) {
		this.pathtobrochure = pathtobrochure;
	}

	/**
	 * @return the smskey
	 */
	public String getSmskey() {
		return smskey;
	}

	/**
	 * @param smskey the smskey to set
	 */
	public void setSmskey(String smskey) {
		this.smskey = smskey;
	}

	/**
	 * @return the senderId
	 */
	public String getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId the senderId to set
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	/**
	 * @return the smsUrl
	 */
	public String getSmsUrl() {
		return smsUrl;
	}

	/**
	 * @param smsUrl the smsUrl to set
	 */
	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	/**
	 * @return the emailSender
	 */
	public String getEmailSender() {
		return emailSender;
	}

	/**
	 * @param emailSender the emailSender to set
	 */
	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	/**
	 * @return the senderPassword
	 */
	public String getSenderPassword() {
		return senderPassword;
	}

	/**
	 * @param senderPassword the senderPassword to set
	 */
	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}

	/**
	 * @return the hostserver
	 */
	public String getHostserver() {
		return hostserver;
	}

	/**
	 * @param hostserver the hostserver to set
	 */
	public void setHostserver(String hostserver) {
		this.hostserver = hostserver;
	}

	/**
	 * @return the hostport
	 */
	public String getHostport() {
		return hostport;
	}

	/**
	 * @param hostport the hostport to set
	 */
	public void setHostport(String hostport) {
		this.hostport = hostport;
	}

	/**
	 * @return the profileCreationTrainingPartnerFolder
	 */
	public String getProfileCreationTrainingPartnerFolder() {
		return profileCreationTrainingPartnerFolder;
	}

	/**
	 * @param profileCreationTrainingPartnerFolder the profileCreationTrainingPartnerFolder to set
	 */
	public void setProfileCreationTrainingPartnerFolder(
			String profileCreationTrainingPartnerFolder) {
		this.profileCreationTrainingPartnerFolder = profileCreationTrainingPartnerFolder;
	}

	/**
	 * @return the profileCreationAssessmentBodyFolder
	 */
	public String getProfileCreationAssessmentBodyFolder() {
		return profileCreationAssessmentBodyFolder;
	}

	/**
	 * @param profileCreationAssessmentBodyFolder the profileCreationAssessmentBodyFolder to set
	 */
	public void setProfileCreationAssessmentBodyFolder(
			String profileCreationAssessmentBodyFolder) {
		this.profileCreationAssessmentBodyFolder = profileCreationAssessmentBodyFolder;
	}

	/**
	 * @return the saveCertificateAtLocation
	 */
	public String getSaveCertificateAtLocation() {
		return saveCertificateAtLocation;
	}

	/**
	 * @param saveCertificateAtLocation the saveCertificateAtLocation to set
	 */
	public void setSaveCertificateAtLocation(String saveCertificateAtLocation) {
		this.saveCertificateAtLocation = saveCertificateAtLocation;
	}

	/**
	 * @return the saveCSVAtLocation
	 */
	public String getSaveCSVAtLocation() {
		return saveCSVAtLocation;
	}

	/**
	 * @param saveCSVAtLocation the saveCSVAtLocation to set
	 */
	public void setSaveCSVAtLocation(String saveCSVAtLocation) {
		this.saveCSVAtLocation = saveCSVAtLocation;
	}
	   
	   

 	}

