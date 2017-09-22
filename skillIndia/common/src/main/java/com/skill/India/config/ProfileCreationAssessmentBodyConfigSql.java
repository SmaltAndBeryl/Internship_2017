package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="ProfileCreationAssessmentBody",locations="classpath:sql/ProfileCreationAssessmentBody.yml")
public class ProfileCreationAssessmentBodyConfigSql {

	private String getAssessmentBodyRegistrationIdUsingApplicationId;
	private String getDataFromAssessmentBodyRegistrationDetails;
	private String getDataFromAssessmentBodyRecognitions;
	private String getDataFromAssessmentsExperienceInTechnicalDomain;
	private String getDataFromAssessmentBodyDirectorsAndManagementTeamDetails;
	private String getDataFromAssessmentStaffDetails;
	private String getDataFromAssessmentBodyRegionalOfficeDetails;
	private String getDataFromAssessmentBodyAffiliationDetails;
	private String insertDataInApplication;
	private String insertIntoAssessmentBodyRegistrationDetails;
	private String insertIntoAssessmentBodyRecognitions;
	private String insertIntoAssessmentsExperienceInTechnicalDomain;
	private String insertIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	private String insertIntoAssessmentStaffDetails;
	private String insertIntoAssessmentBodyRegionalOfficeDetails;
	private String insertIntoAssessmentBodyAffiliationDetails;
	private String updateDataInApplication;
	private String updateIntoAssessmentBodyRegistrationDetails;
	private String updateIntoAssessmentBodyRecognitions;
	private String updateIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	private String updateIntoAssessmentStaffDetails;
	private String updateIntoAssessmentBodyRegionalOfficeDetails;
	private String updateIntoAssessmentBodyAffiliationDetails;
	private String updateIntoAssessmentsExperienceInTechnicalDomain;
	private String updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	private String updatePathsIntoAssessmentStaffDetails;
	private String deleteFromAssessmentBodyRecognitions;
	private String deleteFromAssessmentsExperienceInTechnicalDomain;
	private String deleteFromAssessmentBodyDirectorsAndManagementTeamDetails;
	private String deleteFromAssessmentStaffDetails;
	private String deleteFromAssessmentBodyRegionalOfficeDetails;
	private String deleteFromAssessmentBodyAffiliationDetails;

	
	
	
	
	/**
	 * @return the updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails
	 */
	public String getUpdatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails() {
		return updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @param updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails the updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails to set
	 */
	public void setUpdatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails(
			String updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails) {
		this.updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails = updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @return the updatePathsIntoAssessmentStaffDetails
	 */
	public String getUpdatePathsIntoAssessmentStaffDetails() {
		return updatePathsIntoAssessmentStaffDetails;
	}
	/**
	 * @param updatePathsIntoAssessmentStaffDetails the updatePathsIntoAssessmentStaffDetails to set
	 */
	public void setUpdatePathsIntoAssessmentStaffDetails(
			String updatePathsIntoAssessmentStaffDetails) {
		this.updatePathsIntoAssessmentStaffDetails = updatePathsIntoAssessmentStaffDetails;
	}
	/**
	 * @return the deleteFromAssessmentBodyRecognitions
	 */
	public String getDeleteFromAssessmentBodyRecognitions() {
		return deleteFromAssessmentBodyRecognitions;
	}
	/**
	 * @param deleteFromAssessmentBodyRecognitions the deleteFromAssessmentBodyRecognitions to set
	 */
	public void setDeleteFromAssessmentBodyRecognitions(
			String deleteFromAssessmentBodyRecognitions) {
		this.deleteFromAssessmentBodyRecognitions = deleteFromAssessmentBodyRecognitions;
	}
	/**
	 * @return the deleteFromAssessmentsExperienceInTechnicalDomain
	 */
	public String getDeleteFromAssessmentsExperienceInTechnicalDomain() {
		return deleteFromAssessmentsExperienceInTechnicalDomain;
	}
	/**
	 * @param deleteFromAssessmentsExperienceInTechnicalDomain the deleteFromAssessmentsExperienceInTechnicalDomain to set
	 */
	public void setDeleteFromAssessmentsExperienceInTechnicalDomain(
			String deleteFromAssessmentsExperienceInTechnicalDomain) {
		this.deleteFromAssessmentsExperienceInTechnicalDomain = deleteFromAssessmentsExperienceInTechnicalDomain;
	}
	/**
	 * @return the deleteFromAssessmentBodyDirectorsAndManagementTeamDetails
	 */
	public String getDeleteFromAssessmentBodyDirectorsAndManagementTeamDetails() {
		return deleteFromAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @param deleteFromAssessmentBodyDirectorsAndManagementTeamDetails the deleteFromAssessmentBodyDirectorsAndManagementTeamDetails to set
	 */
	public void setDeleteFromAssessmentBodyDirectorsAndManagementTeamDetails(
			String deleteFromAssessmentBodyDirectorsAndManagementTeamDetails) {
		this.deleteFromAssessmentBodyDirectorsAndManagementTeamDetails = deleteFromAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @return the deleteFromAssessmentStaffDetails
	 */
	public String getDeleteFromAssessmentStaffDetails() {
		return deleteFromAssessmentStaffDetails;
	}
	/**
	 * @param deleteFromAssessmentStaffDetails the deleteFromAssessmentStaffDetails to set
	 */
	public void setDeleteFromAssessmentStaffDetails(
			String deleteFromAssessmentStaffDetails) {
		this.deleteFromAssessmentStaffDetails = deleteFromAssessmentStaffDetails;
	}
	/**
	 * @return the deleteFromAssessmentBodyRegionalOfficeDetails
	 */
	public String getDeleteFromAssessmentBodyRegionalOfficeDetails() {
		return deleteFromAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @param deleteFromAssessmentBodyRegionalOfficeDetails the deleteFromAssessmentBodyRegionalOfficeDetails to set
	 */
	public void setDeleteFromAssessmentBodyRegionalOfficeDetails(
			String deleteFromAssessmentBodyRegionalOfficeDetails) {
		this.deleteFromAssessmentBodyRegionalOfficeDetails = deleteFromAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @return the deleteFromAssessmentBodyAffiliationDetails
	 */
	public String getDeleteFromAssessmentBodyAffiliationDetails() {
		return deleteFromAssessmentBodyAffiliationDetails;
	}
	/**
	 * @param deleteFromAssessmentBodyAffiliationDetails the deleteFromAssessmentBodyAffiliationDetails to set
	 */
	public void setDeleteFromAssessmentBodyAffiliationDetails(
			String deleteFromAssessmentBodyAffiliationDetails) {
		this.deleteFromAssessmentBodyAffiliationDetails = deleteFromAssessmentBodyAffiliationDetails;
	}
	/**
	 * @return the getAssessmentBodyRegistrationIdUsingApplicationId
	 */
	public String getGetAssessmentBodyRegistrationIdUsingApplicationId() {
		return getAssessmentBodyRegistrationIdUsingApplicationId;
	}
	/**
	 * @param getAssessmentBodyRegistrationIdUsingApplicationId the getAssessmentBodyRegistrationIdUsingApplicationId to set
	 */
	public void setGetAssessmentBodyRegistrationIdUsingApplicationId(
			String getAssessmentBodyRegistrationIdUsingApplicationId) {
		this.getAssessmentBodyRegistrationIdUsingApplicationId = getAssessmentBodyRegistrationIdUsingApplicationId;
	}
	/**
	 * @return the getDataFromAssessmentBodyRegistrationDetails
	 */
	public String getGetDataFromAssessmentBodyRegistrationDetails() {
		return getDataFromAssessmentBodyRegistrationDetails;
	}
	/**
	 * @param getDataFromAssessmentBodyRegistrationDetails the getDataFromAssessmentBodyRegistrationDetails to set
	 */
	public void setGetDataFromAssessmentBodyRegistrationDetails(
			String getDataFromAssessmentBodyRegistrationDetails) {
		this.getDataFromAssessmentBodyRegistrationDetails = getDataFromAssessmentBodyRegistrationDetails;
	}
	/**
	 * @return the getDataFromAssessmentBodyRecognitions
	 */
	public String getGetDataFromAssessmentBodyRecognitions() {
		return getDataFromAssessmentBodyRecognitions;
	}
	/**
	 * @param getDataFromAssessmentBodyRecognitions the getDataFromAssessmentBodyRecognitions to set
	 */
	public void setGetDataFromAssessmentBodyRecognitions(
			String getDataFromAssessmentBodyRecognitions) {
		this.getDataFromAssessmentBodyRecognitions = getDataFromAssessmentBodyRecognitions;
	}
	/**
	 * @return the getDataFromAssessmentsExperienceInTechnicalDomain
	 */
	public String getGetDataFromAssessmentsExperienceInTechnicalDomain() {
		return getDataFromAssessmentsExperienceInTechnicalDomain;
	}
	/**
	 * @param getDataFromAssessmentsExperienceInTechnicalDomain the getDataFromAssessmentsExperienceInTechnicalDomain to set
	 */
	public void setGetDataFromAssessmentsExperienceInTechnicalDomain(
			String getDataFromAssessmentsExperienceInTechnicalDomain) {
		this.getDataFromAssessmentsExperienceInTechnicalDomain = getDataFromAssessmentsExperienceInTechnicalDomain;
	}
	/**
	 * @return the getDataFromAssessmentBodyDirectorsAndManagementTeamDetails
	 */
	public String getGetDataFromAssessmentBodyDirectorsAndManagementTeamDetails() {
		return getDataFromAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @param getDataFromAssessmentBodyDirectorsAndManagementTeamDetails the getDataFromAssessmentBodyDirectorsAndManagementTeamDetails to set
	 */
	public void setGetDataFromAssessmentBodyDirectorsAndManagementTeamDetails(
			String getDataFromAssessmentBodyDirectorsAndManagementTeamDetails) {
		this.getDataFromAssessmentBodyDirectorsAndManagementTeamDetails = getDataFromAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @return the getDataFromAssessmentStaffDetails
	 */
	public String getGetDataFromAssessmentStaffDetails() {
		return getDataFromAssessmentStaffDetails;
	}
	/**
	 * @param getDataFromAssessmentStaffDetails the getDataFromAssessmentStaffDetails to set
	 */
	public void setGetDataFromAssessmentStaffDetails(
			String getDataFromAssessmentStaffDetails) {
		this.getDataFromAssessmentStaffDetails = getDataFromAssessmentStaffDetails;
	}
	/**
	 * @return the getDataFromAssessmentBodyRegionalOfficeDetails
	 */
	public String getGetDataFromAssessmentBodyRegionalOfficeDetails() {
		return getDataFromAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @param getDataFromAssessmentBodyRegionalOfficeDetails the getDataFromAssessmentBodyRegionalOfficeDetails to set
	 */
	public void setGetDataFromAssessmentBodyRegionalOfficeDetails(
			String getDataFromAssessmentBodyRegionalOfficeDetails) {
		this.getDataFromAssessmentBodyRegionalOfficeDetails = getDataFromAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @return the getDataFromAssessmentBodyAffiliationDetails
	 */
	public String getGetDataFromAssessmentBodyAffiliationDetails() {
		return getDataFromAssessmentBodyAffiliationDetails;
	}
	/**
	 * @param getDataFromAssessmentBodyAffiliationDetails the getDataFromAssessmentBodyAffiliationDetails to set
	 */
	public void setGetDataFromAssessmentBodyAffiliationDetails(
			String getDataFromAssessmentBodyAffiliationDetails) {
		this.getDataFromAssessmentBodyAffiliationDetails = getDataFromAssessmentBodyAffiliationDetails;
	}
	/**
	 * @return the insertDataInApplication
	 */
	public String getInsertDataInApplication() {
		return insertDataInApplication;
	}
	/**
	 * @param insertDataInApplication the insertDataInApplication to set
	 */
	public void setInsertDataInApplication(String insertDataInApplication) {
		this.insertDataInApplication = insertDataInApplication;
	}
	/**
	 * @return the insertIntoAssessmentBodyRegistrationDetails
	 */
	public String getInsertIntoAssessmentBodyRegistrationDetails() {
		return insertIntoAssessmentBodyRegistrationDetails;
	}
	/**
	 * @param insertIntoAssessmentBodyRegistrationDetails the insertIntoAssessmentBodyRegistrationDetails to set
	 */
	public void setInsertIntoAssessmentBodyRegistrationDetails(
			String insertIntoAssessmentBodyRegistrationDetails) {
		this.insertIntoAssessmentBodyRegistrationDetails = insertIntoAssessmentBodyRegistrationDetails;
	}
	/**
	 * @return the insertIntoAssessmentBodyRecognitions
	 */
	public String getInsertIntoAssessmentBodyRecognitions() {
		return insertIntoAssessmentBodyRecognitions;
	}
	/**
	 * @param insertIntoAssessmentBodyRecognitions the insertIntoAssessmentBodyRecognitions to set
	 */
	public void setInsertIntoAssessmentBodyRecognitions(
			String insertIntoAssessmentBodyRecognitions) {
		this.insertIntoAssessmentBodyRecognitions = insertIntoAssessmentBodyRecognitions;
	}
	/**
	 * @return the insertIntoAssessmentsExperienceInTechnicalDomain
	 */
	public String getInsertIntoAssessmentsExperienceInTechnicalDomain() {
		return insertIntoAssessmentsExperienceInTechnicalDomain;
	}
	/**
	 * @param insertIntoAssessmentsExperienceInTechnicalDomain the insertIntoAssessmentsExperienceInTechnicalDomain to set
	 */
	public void setInsertIntoAssessmentsExperienceInTechnicalDomain(
			String insertIntoAssessmentsExperienceInTechnicalDomain) {
		this.insertIntoAssessmentsExperienceInTechnicalDomain = insertIntoAssessmentsExperienceInTechnicalDomain;
	}
	/**
	 * @return the insertIntoAssessmentBodyDirectorsAndManagementTeamDetails
	 */
	public String getInsertIntoAssessmentBodyDirectorsAndManagementTeamDetails() {
		return insertIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @param insertIntoAssessmentBodyDirectorsAndManagementTeamDetails the insertIntoAssessmentBodyDirectorsAndManagementTeamDetails to set
	 */
	public void setInsertIntoAssessmentBodyDirectorsAndManagementTeamDetails(
			String insertIntoAssessmentBodyDirectorsAndManagementTeamDetails) {
		this.insertIntoAssessmentBodyDirectorsAndManagementTeamDetails = insertIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @return the insertIntoAssessmentStaffDetails
	 */
	public String getInsertIntoAssessmentStaffDetails() {
		return insertIntoAssessmentStaffDetails;
	}
	/**
	 * @param insertIntoAssessmentStaffDetails the insertIntoAssessmentStaffDetails to set
	 */
	public void setInsertIntoAssessmentStaffDetails(
			String insertIntoAssessmentStaffDetails) {
		this.insertIntoAssessmentStaffDetails = insertIntoAssessmentStaffDetails;
	}
	/**
	 * @return the insertIntoAssessmentBodyRegionalOfficeDetails
	 */
	public String getInsertIntoAssessmentBodyRegionalOfficeDetails() {
		return insertIntoAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @param insertIntoAssessmentBodyRegionalOfficeDetails the insertIntoAssessmentBodyRegionalOfficeDetails to set
	 */
	public void setInsertIntoAssessmentBodyRegionalOfficeDetails(
			String insertIntoAssessmentBodyRegionalOfficeDetails) {
		this.insertIntoAssessmentBodyRegionalOfficeDetails = insertIntoAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @return the insertIntoAssessmentBodyAffiliationDetails
	 */
	public String getInsertIntoAssessmentBodyAffiliationDetails() {
		return insertIntoAssessmentBodyAffiliationDetails;
	}
	/**
	 * @param insertIntoAssessmentBodyAffiliationDetails the insertIntoAssessmentBodyAffiliationDetails to set
	 */
	public void setInsertIntoAssessmentBodyAffiliationDetails(
			String insertIntoAssessmentBodyAffiliationDetails) {
		this.insertIntoAssessmentBodyAffiliationDetails = insertIntoAssessmentBodyAffiliationDetails;
	}
	/**
	 * @return the updateDataInApplication
	 */
	public String getUpdateDataInApplication() {
		return updateDataInApplication;
	}
	/**
	 * @param updateDataInApplication the updateDataInApplication to set
	 */
	public void setUpdateDataInApplication(String updateDataInApplication) {
		this.updateDataInApplication = updateDataInApplication;
	}
	/**
	 * @return the updateIntoAssessmentBodyRegistrationDetails
	 */
	public String getUpdateIntoAssessmentBodyRegistrationDetails() {
		return updateIntoAssessmentBodyRegistrationDetails;
	}
	/**
	 * @param updateIntoAssessmentBodyRegistrationDetails the updateIntoAssessmentBodyRegistrationDetails to set
	 */
	public void setUpdateIntoAssessmentBodyRegistrationDetails(
			String updateIntoAssessmentBodyRegistrationDetails) {
		this.updateIntoAssessmentBodyRegistrationDetails = updateIntoAssessmentBodyRegistrationDetails;
	}
	/**
	 * @return the updateIntoAssessmentBodyRecognitions
	 */
	public String getUpdateIntoAssessmentBodyRecognitions() {
		return updateIntoAssessmentBodyRecognitions;
	}
	/**
	 * @param updateIntoAssessmentBodyRecognitions the updateIntoAssessmentBodyRecognitions to set
	 */
	public void setUpdateIntoAssessmentBodyRecognitions(
			String updateIntoAssessmentBodyRecognitions) {
		this.updateIntoAssessmentBodyRecognitions = updateIntoAssessmentBodyRecognitions;
	}
	/**
	 * @return the updateIntoAssessmentBodyDirectorsAndManagementTeamDetails
	 */
	public String getUpdateIntoAssessmentBodyDirectorsAndManagementTeamDetails() {
		return updateIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @param updateIntoAssessmentBodyDirectorsAndManagementTeamDetails the updateIntoAssessmentBodyDirectorsAndManagementTeamDetails to set
	 */
	public void setUpdateIntoAssessmentBodyDirectorsAndManagementTeamDetails(
			String updateIntoAssessmentBodyDirectorsAndManagementTeamDetails) {
		this.updateIntoAssessmentBodyDirectorsAndManagementTeamDetails = updateIntoAssessmentBodyDirectorsAndManagementTeamDetails;
	}
	/**
	 * @return the updateIntoAssessmentStaffDetails
	 */
	public String getUpdateIntoAssessmentStaffDetails() {
		return updateIntoAssessmentStaffDetails;
	}
	/**
	 * @param updateIntoAssessmentStaffDetails the updateIntoAssessmentStaffDetails to set
	 */
	public void setUpdateIntoAssessmentStaffDetails(
			String updateIntoAssessmentStaffDetails) {
		this.updateIntoAssessmentStaffDetails = updateIntoAssessmentStaffDetails;
	}
	/**
	 * @return the updateIntoAssessmentBodyRegionalOfficeDetails
	 */
	public String getUpdateIntoAssessmentBodyRegionalOfficeDetails() {
		return updateIntoAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @param updateIntoAssessmentBodyRegionalOfficeDetails the updateIntoAssessmentBodyRegionalOfficeDetails to set
	 */
	public void setUpdateIntoAssessmentBodyRegionalOfficeDetails(
			String updateIntoAssessmentBodyRegionalOfficeDetails) {
		this.updateIntoAssessmentBodyRegionalOfficeDetails = updateIntoAssessmentBodyRegionalOfficeDetails;
	}
	/**
	 * @return the updateIntoAssessmentBodyAffiliationDetails
	 */
	public String getUpdateIntoAssessmentBodyAffiliationDetails() {
		return updateIntoAssessmentBodyAffiliationDetails;
	}
	/**
	 * @param updateIntoAssessmentBodyAffiliationDetails the updateIntoAssessmentBodyAffiliationDetails to set
	 */
	public void setUpdateIntoAssessmentBodyAffiliationDetails(
			String updateIntoAssessmentBodyAffiliationDetails) {
		this.updateIntoAssessmentBodyAffiliationDetails = updateIntoAssessmentBodyAffiliationDetails;
	}
	/**
	 * @return the updateIntoAssessmentsExperienceInTechnicalDomain
	 */
	public String getUpdateIntoAssessmentsExperienceInTechnicalDomain() {
		return updateIntoAssessmentsExperienceInTechnicalDomain;
	}
	/**
	 * @param updateIntoAssessmentsExperienceInTechnicalDomain the updateIntoAssessmentsExperienceInTechnicalDomain to set
	 */
	public void setUpdateIntoAssessmentsExperienceInTechnicalDomain(
			String updateIntoAssessmentsExperienceInTechnicalDomain) {
		this.updateIntoAssessmentsExperienceInTechnicalDomain = updateIntoAssessmentsExperienceInTechnicalDomain;
	}
	
	
	

}
