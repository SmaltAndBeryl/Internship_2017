package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="ProfileCreationTrainingPartner",locations="classpath:sql/ProfileCreationTrainingPartner.yml")
public class ProfileCreationTrainingPartnerConfigSql {

	private String getTrainingPartnerRegistrationIdUsingApplicationId;
	private String getDataFromTrainingPartnerOrganizationDetails;
	private String getDataFromTrainingPartnerCenterLevelDetails;
	private String getDataFromTrainingPartnerInstituteGrant;
	private String getDataFromTrainingPartnerInstituteRecognition;
	private String getDataFromTrainingPartnerPriorExperienceInSkillTraining;
	private String getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails;
	private String insertIntoTrainingPartnerOrganizationDetails;
	private String insertIntoTrainingPartnerCenterLevelDetails;
	private String insertIntoTrainingPartnerInstituteGrant;
	private String insertIntoTrainingPartnerInstituteRecognition;
	private String insertIntoTrainingPartnerPriorExperienceInSkillTraining;
	private String insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	private String updateIntoTrainingPartnerOrganizationDetails;
	private String updateIntoTrainingPartnerCenterLevelDetails;
	private String updateIntoTrainingPartnerInstituteGrant;
	private String updateIntoTrainingPartnerInstituteRecognition;
	private String updateIntoTrainingPartnerPriorExperienceInSkillTraining;
	private String updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	private String updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	private String updatePathsIntoTrainingPartnerCenterLevelDetails;
	private String deleteFromTrainingPartnerInstituteGrant;
	private String deleteFromTrainingPartnerInstituteRecognition;
	private String deleteFromTrainingPartnerPriorExperienceInSkillTraining;
	private String deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails;
	private String deleteFromTrainingPartnerCenterLevelDetails;
	private String insertDataInApplication;
	private String updateDataInApplication;
	
	
	
	/**
	 * @return the updatePathsIntoTrainingPartnerCenterLevelDetails
	 */
	public String getUpdatePathsIntoTrainingPartnerCenterLevelDetails() {
		return updatePathsIntoTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @param updatePathsIntoTrainingPartnerCenterLevelDetails the updatePathsIntoTrainingPartnerCenterLevelDetails to set
	 */
	public void setUpdatePathsIntoTrainingPartnerCenterLevelDetails(
			String updatePathsIntoTrainingPartnerCenterLevelDetails) {
		this.updatePathsIntoTrainingPartnerCenterLevelDetails = updatePathsIntoTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @return the updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails
	 */
	public String getUpdatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails() {
		return updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @param updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails the updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails to set
	 */
	public void setUpdatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(
			String updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails) {
		this.updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails = updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @return the deleteFromTrainingPartnerInstituteRecognition
	 */
	public String getDeleteFromTrainingPartnerInstituteRecognition() {
		return deleteFromTrainingPartnerInstituteRecognition;
	}
	/**
	 * @param deleteFromTrainingPartnerInstituteRecognition the deleteFromTrainingPartnerInstituteRecognition to set
	 */
	public void setDeleteFromTrainingPartnerInstituteRecognition(
			String deleteFromTrainingPartnerInstituteRecognition) {
		this.deleteFromTrainingPartnerInstituteRecognition = deleteFromTrainingPartnerInstituteRecognition;
	}
	/**
	 * @return the deleteFromTrainingPartnerPriorExperienceInSkillTraining
	 */
	public String getDeleteFromTrainingPartnerPriorExperienceInSkillTraining() {
		return deleteFromTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @param deleteFromTrainingPartnerPriorExperienceInSkillTraining the deleteFromTrainingPartnerPriorExperienceInSkillTraining to set
	 */
	public void setDeleteFromTrainingPartnerPriorExperienceInSkillTraining(
			String deleteFromTrainingPartnerPriorExperienceInSkillTraining) {
		this.deleteFromTrainingPartnerPriorExperienceInSkillTraining = deleteFromTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @return the deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails
	 */
	public String getDeleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails() {
		return deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @param deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails the deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails to set
	 */
	public void setDeleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails(
			String deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails) {
		this.deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails = deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @return the deleteFromTrainingPartnerCenterLevelDetails
	 */
	public String getDeleteFromTrainingPartnerCenterLevelDetails() {
		return deleteFromTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @param deleteFromTrainingPartnerCenterLevelDetails the deleteFromTrainingPartnerCenterLevelDetails to set
	 */
	public void setDeleteFromTrainingPartnerCenterLevelDetails(
			String deleteFromTrainingPartnerCenterLevelDetails) {
		this.deleteFromTrainingPartnerCenterLevelDetails = deleteFromTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @return the deleteFromTrainingPartnerInstituteGrant
	 */
	public String getDeleteFromTrainingPartnerInstituteGrant() {
		return deleteFromTrainingPartnerInstituteGrant;
	}
	/**
	 * @param deleteFromTrainingPartnerInstituteGrant the deleteFromTrainingPartnerInstituteGrant to set
	 */
	public void setDeleteFromTrainingPartnerInstituteGrant(
			String deleteFromTrainingPartnerInstituteGrant) {
		this.deleteFromTrainingPartnerInstituteGrant = deleteFromTrainingPartnerInstituteGrant;
	}
	/**
	 * @return the getTrainingPartnerRegistrationIdUsingApplicationId
	 */
	public String getGetTrainingPartnerRegistrationIdUsingApplicationId() {
		return getTrainingPartnerRegistrationIdUsingApplicationId;
	}
	/**
	 * @param getTrainingPartnerRegistrationIdUsingApplicationId the getTrainingPartnerRegistrationIdUsingApplicationId to set
	 */
	public void setGetTrainingPartnerRegistrationIdUsingApplicationId(
			String getTrainingPartnerRegistrationIdUsingApplicationId) {
		this.getTrainingPartnerRegistrationIdUsingApplicationId = getTrainingPartnerRegistrationIdUsingApplicationId;
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
	 * @return the getDataFromTrainingPartnerOrganizationDetails
	 */
	public String getGetDataFromTrainingPartnerOrganizationDetails() {
		return getDataFromTrainingPartnerOrganizationDetails;
	}
	/**
	 * @param getDataFromTrainingPartnerOrganizationDetails the getDataFromTrainingPartnerOrganizationDetails to set
	 */
	public void setGetDataFromTrainingPartnerOrganizationDetails(
			String getDataFromTrainingPartnerOrganizationDetails) {
		this.getDataFromTrainingPartnerOrganizationDetails = getDataFromTrainingPartnerOrganizationDetails;
	}
	/**
	 * @return the getDataFromTrainingPartnerCenterLevelDetails
	 */
	public String getGetDataFromTrainingPartnerCenterLevelDetails() {
		return getDataFromTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @param getDataFromTrainingPartnerCenterLevelDetails the getDataFromTrainingPartnerCenterLevelDetails to set
	 */
	public void setGetDataFromTrainingPartnerCenterLevelDetails(
			String getDataFromTrainingPartnerCenterLevelDetails) {
		this.getDataFromTrainingPartnerCenterLevelDetails = getDataFromTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @return the getDataFromTrainingPartnerInstituteGrant
	 */
	public String getGetDataFromTrainingPartnerInstituteGrant() {
		return getDataFromTrainingPartnerInstituteGrant;
	}
	/**
	 * @param getDataFromTrainingPartnerInstituteGrant the getDataFromTrainingPartnerInstituteGrant to set
	 */
	public void setGetDataFromTrainingPartnerInstituteGrant(
			String getDataFromTrainingPartnerInstituteGrant) {
		this.getDataFromTrainingPartnerInstituteGrant = getDataFromTrainingPartnerInstituteGrant;
	}
	/**
	 * @return the getDataFromTrainingPartnerInstituteRecognition
	 */
	public String getGetDataFromTrainingPartnerInstituteRecognition() {
		return getDataFromTrainingPartnerInstituteRecognition;
	}
	/**
	 * @param getDataFromTrainingPartnerInstituteRecognition the getDataFromTrainingPartnerInstituteRecognition to set
	 */
	public void setGetDataFromTrainingPartnerInstituteRecognition(
			String getDataFromTrainingPartnerInstituteRecognition) {
		this.getDataFromTrainingPartnerInstituteRecognition = getDataFromTrainingPartnerInstituteRecognition;
	}
	/**
	 * @return the getDataFromTrainingPartnerPriorExperienceInSkillTraining
	 */
	public String getGetDataFromTrainingPartnerPriorExperienceInSkillTraining() {
		return getDataFromTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @param getDataFromTrainingPartnerPriorExperienceInSkillTraining the getDataFromTrainingPartnerPriorExperienceInSkillTraining to set
	 */
	public void setGetDataFromTrainingPartnerPriorExperienceInSkillTraining(
			String getDataFromTrainingPartnerPriorExperienceInSkillTraining) {
		this.getDataFromTrainingPartnerPriorExperienceInSkillTraining = getDataFromTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @return the getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails
	 */
	public String getGetDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails() {
		return getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @param getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails the getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails to set
	 */
	public void setGetDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails(
			String getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails) {
		this.getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails = getDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @return the insertIntoTrainingPartnerOrganizationDetails
	 */
	public String getInsertIntoTrainingPartnerOrganizationDetails() {
		return insertIntoTrainingPartnerOrganizationDetails;
	}
	/**
	 * @param insertIntoTrainingPartnerOrganizationDetails the insertIntoTrainingPartnerOrganizationDetails to set
	 */
	public void setInsertIntoTrainingPartnerOrganizationDetails(
			String insertIntoTrainingPartnerOrganizationDetails) {
		System.out.println("In tpconfig : " +insertIntoTrainingPartnerOrganizationDetails);
		this.insertIntoTrainingPartnerOrganizationDetails = insertIntoTrainingPartnerOrganizationDetails;
	}
	/**
	 * @return the insertIntoTrainingPartnerCenterLevelDetails
	 */
	public String getInsertIntoTrainingPartnerCenterLevelDetails() {
		return insertIntoTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @param insertIntoTrainingPartnerCenterLevelDetails the insertIntoTrainingPartnerCenterLevelDetails to set
	 */
	public void setInsertIntoTrainingPartnerCenterLevelDetails(
			String insertIntoTrainingPartnerCenterLevelDetails) {
		this.insertIntoTrainingPartnerCenterLevelDetails = insertIntoTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @return the insertIntoTrainingPartnerInstituteGrant
	 */
	public String getInsertIntoTrainingPartnerInstituteGrant() {
		return insertIntoTrainingPartnerInstituteGrant;
	}
	/**
	 * @param insertIntoTrainingPartnerInstituteGrant the insertIntoTrainingPartnerInstituteGrant to set
	 */
	public void setInsertIntoTrainingPartnerInstituteGrant(
			String insertIntoTrainingPartnerInstituteGrant) {
		this.insertIntoTrainingPartnerInstituteGrant = insertIntoTrainingPartnerInstituteGrant;
	}
	/**
	 * @return the insertIntoTrainingPartnerInstituteRecognition
	 */
	public String getInsertIntoTrainingPartnerInstituteRecognition() {
		return insertIntoTrainingPartnerInstituteRecognition;
	}
	/**
	 * @param insertIntoTrainingPartnerInstituteRecognition the insertIntoTrainingPartnerInstituteRecognition to set
	 */
	public void setInsertIntoTrainingPartnerInstituteRecognition(
			String insertIntoTrainingPartnerInstituteRecognition) {
		this.insertIntoTrainingPartnerInstituteRecognition = insertIntoTrainingPartnerInstituteRecognition;
	}
	/**
	 * @return the insertIntoTrainingPartnerPriorExperienceInSkillTraining
	 */
	public String getInsertIntoTrainingPartnerPriorExperienceInSkillTraining() {
		return insertIntoTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @param insertIntoTrainingPartnerPriorExperienceInSkillTraining the insertIntoTrainingPartnerPriorExperienceInSkillTraining to set
	 */
	public void setInsertIntoTrainingPartnerPriorExperienceInSkillTraining(
			String insertIntoTrainingPartnerPriorExperienceInSkillTraining) {
		this.insertIntoTrainingPartnerPriorExperienceInSkillTraining = insertIntoTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @return the insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails
	 */
	public String getInsertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails() {
		return insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @param insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails the insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails to set
	 */
	public void setInsertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(
			String insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails) {
		this.insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails = insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @return the updateIntoTrainingPartnerOrganizationDetails
	 */
	public String getUpdateIntoTrainingPartnerOrganizationDetails() {
		return updateIntoTrainingPartnerOrganizationDetails;
	}
	/**
	 * @param updateIntoTrainingPartnerOrganizationDetails the updateIntoTrainingPartnerOrganizationDetails to set
	 */
	public void setUpdateIntoTrainingPartnerOrganizationDetails(
			String updateIntoTrainingPartnerOrganizationDetails) {
		this.updateIntoTrainingPartnerOrganizationDetails = updateIntoTrainingPartnerOrganizationDetails;
	}
	/**
	 * @return the updateIntoTrainingPartnerCenterLevelDetails
	 */
	public String getUpdateIntoTrainingPartnerCenterLevelDetails() {
		return updateIntoTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @param updateIntoTrainingPartnerCenterLevelDetails the updateIntoTrainingPartnerCenterLevelDetails to set
	 */
	public void setUpdateIntoTrainingPartnerCenterLevelDetails(
			String updateIntoTrainingPartnerCenterLevelDetails) {
		this.updateIntoTrainingPartnerCenterLevelDetails = updateIntoTrainingPartnerCenterLevelDetails;
	}
	/**
	 * @return the updateIntoTrainingPartnerInstituteGrant
	 */
	public String getUpdateIntoTrainingPartnerInstituteGrant() {
		return updateIntoTrainingPartnerInstituteGrant;
	}
	/**
	 * @param updateIntoTrainingPartnerInstituteGrant the updateIntoTrainingPartnerInstituteGrant to set
	 */
	public void setUpdateIntoTrainingPartnerInstituteGrant(
			String updateIntoTrainingPartnerInstituteGrant) {
		this.updateIntoTrainingPartnerInstituteGrant = updateIntoTrainingPartnerInstituteGrant;
	}
	/**
	 * @return the updateIntoTrainingPartnerInstituteRecognition
	 */
	public String getUpdateIntoTrainingPartnerInstituteRecognition() {
		return updateIntoTrainingPartnerInstituteRecognition;
	}
	/**
	 * @param updateIntoTrainingPartnerInstituteRecognition the updateIntoTrainingPartnerInstituteRecognition to set
	 */
	public void setUpdateIntoTrainingPartnerInstituteRecognition(
			String updateIntoTrainingPartnerInstituteRecognition) {
		this.updateIntoTrainingPartnerInstituteRecognition = updateIntoTrainingPartnerInstituteRecognition;
	}
	/**
	 * @return the updateIntoTrainingPartnerPriorExperienceInSkillTraining
	 */
	public String getUpdateIntoTrainingPartnerPriorExperienceInSkillTraining() {
		return updateIntoTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @param updateIntoTrainingPartnerPriorExperienceInSkillTraining the updateIntoTrainingPartnerPriorExperienceInSkillTraining to set
	 */
	public void setUpdateIntoTrainingPartnerPriorExperienceInSkillTraining(
			String updateIntoTrainingPartnerPriorExperienceInSkillTraining) {
		this.updateIntoTrainingPartnerPriorExperienceInSkillTraining = updateIntoTrainingPartnerPriorExperienceInSkillTraining;
	}
	/**
	 * @return the updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails
	 */
	public String getUpdateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails() {
		return updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}
	/**
	 * @param updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails the updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails to set
	 */
	public void setUpdateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(
			String updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails) {
		this.updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails = updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	}


	
	
}
