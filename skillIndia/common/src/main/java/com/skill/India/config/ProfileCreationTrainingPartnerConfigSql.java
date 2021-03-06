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
	private String getDataFromTrainingPartnerTrainingStaffDetails;
	
	private String insertIntoTrainingPartnerTrainingStaff;
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
	private String updateIntoTrainingStaff;
	private String updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails;
	private String updatePathsClassRoomImagePath;
	
	private String deleteFromTrainingPartnerInstituteGrant;
	private String deleteFromTrainingPartnerInstituteRecognition;
	private String deleteFromTrainingPartnerPriorExperienceInSkillTraining;
	private String deleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails;
	private String deleteFromTrainingPartnerCenterLevelDetails;
	
	private String insertDataInApplication;
	private String updateDataInApplication;
	
	private String isApplicationIdPresentInTrainingPartner;
	private String isTrainingCenterPresent;
	private String isInstituteGrantPresent;
	private String isRecognitnionPresent;
	private String isTrainingStaffPresent;
	
	
	private String isTrainingExperiencePresent;
	private String isTrainingPartnerStaffTrainingStaffPresent;
	
	private String updatePanPath;
	private String updateTanPath;
	private String updateNSDCCertificatePath;
	private String updateSelfOwnedAnnexurePath;
	private String updateFranchiseeAnnexurePath;
	private String updateMobileAnnexurePath;
	private String updateTrainingStaffEducationCertificatePath;
	private String updateManagementCvPath;
	private String updateTrainingStaffCvPath;
	private String updateOperationHeadCvPath;
	private String updatePathsAffiliationCoordinatorCvPath;
	private String updatePathsSPOC;
	private String updatelabImagesPath;
	private String updateWorkshopImagesPath;
	private String updateMandatoryToolkitImagePath;
	private String updateMandatoryToolkitAnnexurePath;
	
	
	public String getUpdatelabImagesPath() {
		return updatelabImagesPath;
	}
	public void setUpdatelabImagesPath(String updatelabImagesPath) {
		this.updatelabImagesPath = updatelabImagesPath;
	}
	public String getUpdateWorkshopImagesPath() {
		return updateWorkshopImagesPath;
	}
	public void setUpdateWorkshopImagesPath(String updateWorkshopImagesPath) {
		this.updateWorkshopImagesPath = updateWorkshopImagesPath;
	}
	public String getUpdateMandatoryToolkitImagePath() {
		return updateMandatoryToolkitImagePath;
	}
	public void setUpdateMandatoryToolkitImagePath(
			String updateMandatoryToolkitImagePath) {
		this.updateMandatoryToolkitImagePath = updateMandatoryToolkitImagePath;
	}
	public String getUpdateMandatoryToolkitAnnexurePath() {
		return updateMandatoryToolkitAnnexurePath;
	}
	public void setUpdateMandatoryToolkitAnnexurePath(
			String updateMandatoryToolkitAnnexurePath) {
		this.updateMandatoryToolkitAnnexurePath = updateMandatoryToolkitAnnexurePath;
	}
	public String getUpdateOperationHeadCvPath() {
		return updateOperationHeadCvPath;
	}
	public void setUpdateOperationHeadCvPath(String updateOperationHeadCvPath) {
		this.updateOperationHeadCvPath = updateOperationHeadCvPath;
	}
	public String getUpdatePathsAffiliationCoordinatorCvPath() {
		return updatePathsAffiliationCoordinatorCvPath;
	}
	public void setUpdatePathsAffiliationCoordinatorCvPath(
			String updatePathsAffiliationCoordinatorCvPath) {
		this.updatePathsAffiliationCoordinatorCvPath = updatePathsAffiliationCoordinatorCvPath;
	}
	public String getUpdatePathsSPOC() {
		return updatePathsSPOC;
	}
	public void setUpdatePathsSPOC(String updatePathsSPOC) {
		this.updatePathsSPOC = updatePathsSPOC;
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
	public String getIsTrainingCenterPresent() {
		return isTrainingCenterPresent;
	}
	public void setIsTrainingCenterPresent(String isTrainingCenterPresent) {
		this.isTrainingCenterPresent = isTrainingCenterPresent;
	}
	public String getIsInstituteGrantPresent() {
		return isInstituteGrantPresent;
	}
	public void setIsInstituteGrantPresent(String isInstituteGrantPresent) {
		this.isInstituteGrantPresent = isInstituteGrantPresent;
	}
	public String getIsRecognitnionPresent() {
		return isRecognitnionPresent;
	}
	public void setIsRecognitnionPresent(String isRecognitnionPresent) {
		this.isRecognitnionPresent = isRecognitnionPresent;
	}
	public String getIsTrainingStaffPresent() {
		return isTrainingStaffPresent;
	}
	public void setIsTrainingStaffPresent(String isTrainingStaffPresent) {
		this.isTrainingStaffPresent = isTrainingStaffPresent;
	}
	public String getIsTrainingExperiencePresent() {
		return isTrainingExperiencePresent;
	}
	public void setIsTrainingExperiencePresent(
			String isTrainingExperiencePresent) {
		this.isTrainingExperiencePresent = isTrainingExperiencePresent;
	}
	public String getUpdatePanPath() {
		return updatePanPath;
	}
	public void setUpdatePanPath(String updatePanPath) {
		this.updatePanPath = updatePanPath;
	}
	public String getUpdateTanPath() {
		return updateTanPath;
	}
	public void setUpdateTanPath(String updateTanPath) {
		this.updateTanPath = updateTanPath;
	}
	public String getUpdateNSDCCertificatePath() {
		return updateNSDCCertificatePath;
	}
	public void setUpdateNSDCCertificatePath(String updateNSDCCertificatePath) {
		this.updateNSDCCertificatePath = updateNSDCCertificatePath;
	}
	public String getUpdateSelfOwnedAnnexurePath() {
		return updateSelfOwnedAnnexurePath;
	}
	public void setUpdateSelfOwnedAnnexurePath(
			String updateSelfOwnedAnnexurePath) {
		this.updateSelfOwnedAnnexurePath = updateSelfOwnedAnnexurePath;
	}
	public String getUpdateFranchiseeAnnexurePath() {
		return updateFranchiseeAnnexurePath;
	}
	public void setUpdateFranchiseeAnnexurePath(
			String updateFranchiseeAnnexurePath) {
		this.updateFranchiseeAnnexurePath = updateFranchiseeAnnexurePath;
	}
	public String getUpdateMobileAnnexurePath() {
		return updateMobileAnnexurePath;
	}
	public void setUpdateMobileAnnexurePath(String updateMobileAnnexurePath) {
		this.updateMobileAnnexurePath = updateMobileAnnexurePath;
	}
	public String getGetDataFromTrainingPartnerTrainingStaffDetails() {
		return getDataFromTrainingPartnerTrainingStaffDetails;
	}
	public void setGetDataFromTrainingPartnerTrainingStaffDetails(
			String getDataFromTrainingPartnerTrainingStaffDetails) {
		this.getDataFromTrainingPartnerTrainingStaffDetails = getDataFromTrainingPartnerTrainingStaffDetails;
	}
	public String getIsTrainingPartnerStaffTrainingStaffPresent() {
		return isTrainingPartnerStaffTrainingStaffPresent;
	}
	public void setIsTrainingPartnerStaffTrainingStaffPresent(
			String isTrainingPartnerStaffTrainingStaffPresent) {
		this.isTrainingPartnerStaffTrainingStaffPresent = isTrainingPartnerStaffTrainingStaffPresent;
	}
	public String getUpdateIntoTrainingStaff() {
		return updateIntoTrainingStaff;
	}
	public void setUpdateIntoTrainingStaff(String updateIntoTrainingStaff) {
		this.updateIntoTrainingStaff = updateIntoTrainingStaff;
	}
	public String getInsertIntoTrainingPartnerTrainingStaff() {
		return insertIntoTrainingPartnerTrainingStaff;
	}
	public void setInsertIntoTrainingPartnerTrainingStaff(
			String insertIntoTrainingPartnerTrainingStaff) {
		this.insertIntoTrainingPartnerTrainingStaff = insertIntoTrainingPartnerTrainingStaff;
	}
	public String getUpdateTrainingStaffEducationCertificatePath() {
		return updateTrainingStaffEducationCertificatePath;
	}
	public void setUpdateTrainingStaffEducationCertificatePath(
			String updateTrainingStaffEducationCertificatePath) {
		this.updateTrainingStaffEducationCertificatePath = updateTrainingStaffEducationCertificatePath;
	}
	public String getUpdateManagementCvPath() {
		return updateManagementCvPath;
	}
	public void setUpdateManagementCvPath(String updateManagementCvPath) {
		this.updateManagementCvPath = updateManagementCvPath;
	}
	public String getUpdateTrainingStaffCvPath() {
		return updateTrainingStaffCvPath;
	}
	public void setUpdateTrainingStaffCvPath(String updateTrainingStaffCvPath) {
		this.updateTrainingStaffCvPath = updateTrainingStaffCvPath;
	}
	public String getUpdatePathsClassRoomImagePath() {
		return updatePathsClassRoomImagePath;
	}
	public void setUpdatePathsClassRoomImagePath(
			String updatePathsClassRoomImagePath) {
		this.updatePathsClassRoomImagePath = updatePathsClassRoomImagePath;
	}
	public String getIsApplicationIdPresentInTrainingPartner() {
		return isApplicationIdPresentInTrainingPartner;
	}
	public void setIsApplicationIdPresentInTrainingPartner(
			String isApplicationIdPresentInTrainingPartner) {
		this.isApplicationIdPresentInTrainingPartner = isApplicationIdPresentInTrainingPartner;
	}


	
	
}
