package com.skill.India.dto;

public class ProfileCreationTrainingPartnerOrganizationDetailsDto {
	private int applicationId;
	private String trainingPartnerRegistrationId;
	private String organizationName;
	private String sPOCName;
	private String address;
	private String city;
	private String state;
	private Long pincode;
	private Long mobileNumber;
	private Long alternateMobileNumber;
	private Long landlineNumber;
	private Long alternateLandlineNumber;
	private Long faxNumber;
	private String websites;
	private String yearOfEstablishment;
	private String qualificationPacks;
	private String qualificationPacksAnnexurePath;
	private String nSDCFunded;
	private String nSDCFundedCertificatePath;
	private String mediumOfInstructions;
	private String selfOwnedInstitution;
	private String selfOwnedInstitutionAnnexurePath;
	private String franchiseOwnedInstitution;
	private String franchiseOwnedInstitutionAnnexurePath;
	private String mobileTrainingInstitution;
	private String mobileTrainingInstitutionAnnexurePath;
	private String panNumber;
	private String panNumberPath;
	private String tanNumber;
	private String tanNumberPath;
	private String turnOverOfInstitution;
	private String turnOverOfInstitutionBalanceSheetPath;
	private String instituteReceivedAnyGrant;
	private String instituteReceivedAnyRecognition;
	private String priorExperienceOfInstitutionInSkillDevelopment;
	private String anyPriorExperienceOfInstitutionInSkillTraining;
	private String trainingStaffDetailsAnnexurePath;
	/*
	 * to check if the button clicked is submit or draft
	 */
	private String type;
	
	
	
	/**
	 * @param organizationName
	 * @param sPOCName
	 * @param address
	 * @param city
	 * @param state
	 * @param pincode
	 * @param mobileNumber
	 * @param alternateMobileNumber
	 * @param landlineNumber
	 * @param alternateLandlineNumber
	 * @param faxNumber
	 * @param websites
	 * @param yearOfEstablishment
	 * @param qualificationPacks
	 * @param qualificationPacksAnnexurePath
	 * @param nSDCFunded
	 * @param nSDCFundedCertificatePath
	 * @param mediumOfInstructions
	 * @param selfOwnedInstitution
	 * @param selfOwnedInstitutionAnnexurePath
	 * @param franchiseOwnedInstitution
	 * @param franchiseOwnedInstitutionAnnexurePath
	 * @param mobileTrainingInstitution
	 * @param mobileTrainingInstitutionAnnexurePath
	 * @param panNumber
	 * @param panNumberPath
	 * @param tanNumber
	 * @param tanNumberPath
	 * @param turnOverOfInstitution
	 * @param turnOverOfInstitutionBalanceSheetPath
	 * @param instituteReceivedAnyGrant
	 * @param instituteReceivedAnyRecognition
	 * @param priorExperienceOfInstitutionInSkillDevelopment
	 * @param anyPriorExperienceOfInstitutionInSkillTraining
	 * @param trainingStaffDetailsAnnexurePath
	 */
	public ProfileCreationTrainingPartnerOrganizationDetailsDto(
			String trainingPartnerRegistrationId,int applicationId,
			String organizationName, String sPOCName, String address,
			String city, String state, Long pincode, Long mobileNumber,
			Long alternateMobileNumber, Long landlineNumber,
			Long alternateLandlineNumber, Long faxNumber, String websites,
			String yearOfEstablishment, String qualificationPacks,
			String qualificationPacksAnnexurePath, String nSDCFunded,
			String nSDCFundedCertificatePath, String mediumOfInstructions,
			String selfOwnedInstitution,
			String selfOwnedInstitutionAnnexurePath,
			String franchiseOwnedInstitution,
			String franchiseOwnedInstitutionAnnexurePath,
			String mobileTrainingInstitution,
			String mobileTrainingInstitutionAnnexurePath, String panNumber,
			String panNumberPath, String tanNumber, String tanNumberPath,
			String turnOverOfInstitution,
			String turnOverOfInstitutionBalanceSheetPath,
			String instituteReceivedAnyGrant,
			String instituteReceivedAnyRecognition,
			String priorExperienceOfInstitutionInSkillDevelopment,
			String anyPriorExperienceOfInstitutionInSkillTraining,
			String trainingStaffDetailsAnnexurePath) {
		super();
		this.trainingPartnerRegistrationId=trainingPartnerRegistrationId;
		this.applicationId=applicationId;
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.alternateMobileNumber = alternateMobileNumber;
		this.landlineNumber = landlineNumber;
		this.alternateLandlineNumber = alternateLandlineNumber;
		this.faxNumber = faxNumber;
		this.websites = websites;
		this.yearOfEstablishment = yearOfEstablishment;
		this.qualificationPacks = qualificationPacks;
		this.qualificationPacksAnnexurePath = qualificationPacksAnnexurePath;
		this.nSDCFunded = nSDCFunded;
		this.nSDCFundedCertificatePath = nSDCFundedCertificatePath;
		this.mediumOfInstructions = mediumOfInstructions;
		this.selfOwnedInstitution = selfOwnedInstitution;
		this.selfOwnedInstitutionAnnexurePath = selfOwnedInstitutionAnnexurePath;
		this.franchiseOwnedInstitution = franchiseOwnedInstitution;
		this.franchiseOwnedInstitutionAnnexurePath = franchiseOwnedInstitutionAnnexurePath;
		this.mobileTrainingInstitution = mobileTrainingInstitution;
		this.mobileTrainingInstitutionAnnexurePath = mobileTrainingInstitutionAnnexurePath;
		this.panNumber = panNumber;
		this.panNumberPath = panNumberPath;
		this.tanNumber = tanNumber;
		this.tanNumberPath = tanNumberPath;
		this.turnOverOfInstitution = turnOverOfInstitution;
		this.turnOverOfInstitutionBalanceSheetPath = turnOverOfInstitutionBalanceSheetPath;
		this.instituteReceivedAnyGrant = instituteReceivedAnyGrant;
		this.instituteReceivedAnyRecognition = instituteReceivedAnyRecognition;
		this.priorExperienceOfInstitutionInSkillDevelopment = priorExperienceOfInstitutionInSkillDevelopment;
		this.anyPriorExperienceOfInstitutionInSkillTraining = anyPriorExperienceOfInstitutionInSkillTraining;
		this.trainingStaffDetailsAnnexurePath = trainingStaffDetailsAnnexurePath;
	}
	/**
	 * 
	 */
	public ProfileCreationTrainingPartnerOrganizationDetailsDto() {
		super();
	}
	/**
	 * @param organizationName
	 * @param sPOCName
	 */
	public ProfileCreationTrainingPartnerOrganizationDetailsDto(String organizationName,
			String sPOCName) {
		super();
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
	}
	/**
	 * @param organizationName
	 * @param sPOCName
	 * @param address
	 * @param city
	 * @param state
	 * @param pincode
	 * @param mobileNumber
	 * @param alternateMobileNumber
	 * @param landlineNumber
	 * @param alternateLandlineNumber
	 * @param faxNumber
	 * @param websites
	 * @param yearOfEstablishment
	 * @param qualificationPacks
	 * @param qualificationPacksAnnexurePath
	 * @param nSDCFunded
	 * @param nSDCFundedCertificatePath
	 * @param mediumOfInstructions
	 * @param selfOwnedInstitution
	 * @param selfOwnedInstitutionAnnexurePath
	 * @param franchiseOwnedInstitution
	 * @param franchiseOwnedInstitutionAnnexurePath
	 * @param mobileTrainingInstitution
	 * @param mobileTrainingInstitutionAnnexurePath
	 * @param panNumber
	 * @param panNumberPath
	 * @param tanNumber
	 * @param tanNumberPath
	 * @param turnOverOfInstitution
	 * @param turnOverOfInstitutionBalanceSheetPath
	 * @param instituteReceivedAnyGrant
	 * @param instituteReceivedAnyRecognition
	 * @param priorExperienceOfInstitutionInSkillDevelopment
	 * @param anyPriorExperienceOfInstitutionInSkillTraining
	 * @param trainingStaffDetailsAnnexurePath
	 */
	public ProfileCreationTrainingPartnerOrganizationDetailsDto(String trainingPartnerRegistrationId,
			int applicationId,String organizationName,
			String sPOCName, String address, String city, String state,
			Long pincode, Long mobileNumber, Long alternateMobileNumber,
			Long landlineNumber, Long alternateLandlineNumber,
			Long faxNumber, String websites, String yearOfEstablishment,
			String qualificationPacks, String qualificationPacksAnnexurePath,
			String nSDCFunded, String nSDCFundedCertificatePath,
			String mediumOfInstructions, String selfOwnedInstitution,
			String selfOwnedInstitutionAnnexurePath,
			String franchiseOwnedInstitution,
			String franchiseOwnedInstitutionAnnexurePath,
			String mobileTrainingInstitution,
			String mobileTrainingInstitutionAnnexurePath, String panNumber,
			String panNumberPath, String tanNumber, String tanNumberPath,
			String turnOverOfInstitution,
			String turnOverOfInstitutionBalanceSheetPath,
			String instituteReceivedAnyGrant,
			String instituteReceivedAnyRecognition,
			String priorExperienceOfInstitutionInSkillDevelopment,
			String anyPriorExperienceOfInstitutionInSkillTraining,
			String trainingStaffDetailsAnnexurePath,
			String type) {
		super();
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.alternateMobileNumber = alternateMobileNumber;
		this.landlineNumber = landlineNumber;
		this.alternateLandlineNumber = alternateLandlineNumber;
		this.faxNumber = faxNumber;
		this.websites = websites;
		this.yearOfEstablishment = yearOfEstablishment;
		this.qualificationPacks = qualificationPacks;
		this.qualificationPacksAnnexurePath = qualificationPacksAnnexurePath;
		this.nSDCFunded = nSDCFunded;
		this.nSDCFundedCertificatePath = nSDCFundedCertificatePath;
		this.mediumOfInstructions = mediumOfInstructions;
		this.selfOwnedInstitution = selfOwnedInstitution;
		this.selfOwnedInstitutionAnnexurePath = selfOwnedInstitutionAnnexurePath;
		this.franchiseOwnedInstitution = franchiseOwnedInstitution;
		this.franchiseOwnedInstitutionAnnexurePath = franchiseOwnedInstitutionAnnexurePath;
		this.mobileTrainingInstitution = mobileTrainingInstitution;
		this.mobileTrainingInstitutionAnnexurePath = mobileTrainingInstitutionAnnexurePath;
		this.panNumber = panNumber;
		this.panNumberPath = panNumberPath;
		this.tanNumber = tanNumber;
		this.tanNumberPath = tanNumberPath;
		this.turnOverOfInstitution = turnOverOfInstitution;
		this.turnOverOfInstitutionBalanceSheetPath = turnOverOfInstitutionBalanceSheetPath;
		this.instituteReceivedAnyGrant = instituteReceivedAnyGrant;
		this.instituteReceivedAnyRecognition = instituteReceivedAnyRecognition;
		this.priorExperienceOfInstitutionInSkillDevelopment = priorExperienceOfInstitutionInSkillDevelopment;
		this.anyPriorExperienceOfInstitutionInSkillTraining = anyPriorExperienceOfInstitutionInSkillTraining;
		this.trainingStaffDetailsAnnexurePath = trainingStaffDetailsAnnexurePath;
		this.type=type;
		this.trainingPartnerRegistrationId=trainingPartnerRegistrationId;
		this.applicationId=applicationId;
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
	 * @return the trainingPartnerRegistrationId
	 */
	public String getTrainingPartnerRegistrationId() {
		return trainingPartnerRegistrationId;
	}
	/**
	 * @param trainingPartnerRegistrationId the trainingPartnerRegistrationId to set
	 */
	public void setTrainingPartnerRegistrationId(
			String trainingPartnerRegistrationId) {
		this.trainingPartnerRegistrationId = trainingPartnerRegistrationId;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * @return the sPOCName
	 */
	public String getsPOCName() {
		return sPOCName;
	}
	/**
	 * @param sPOCName the sPOCName to set
	 */
	public void setsPOCName(String sPOCName) {
		this.sPOCName = sPOCName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public Long getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the mobileNumber
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the alternateMobileNumber
	 */
	public Long getAlternateMobileNumber() {
		return alternateMobileNumber;
	}
	/**
	 * @param alternateMobileNumber the alternateMobileNumber to set
	 */
	public void setAlternateMobileNumber(Long alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}
	/**
	 * @return the landlineNumber
	 */
	public Long getLandlineNumber() {
		return landlineNumber;
	}
	/**
	 * @param landlineNumber the landlineNumber to set
	 */
	public void setLandlineNumber(Long landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	/**
	 * @return the alternateLandlineNumber
	 */
	public Long getAlternateLandlineNumber() {
		return alternateLandlineNumber;
	}
	/**
	 * @param alternateLandlineNumber the alternateLandlineNumber to set
	 */
	public void setAlternateLandlineNumber(Long alternateLandlineNumber) {
		this.alternateLandlineNumber = alternateLandlineNumber;
	}
	/**
	 * @return the faxNumber
	 */
	public Long getFaxNumber() {
		return faxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(Long faxNumber) {
		this.faxNumber = faxNumber;
	}
	/**
	 * @return the websites
	 */
	public String getWebsites() {
		return websites;
	}
	/**
	 * @param websites the websites to set
	 */
	public void setWebsites(String websites) {
		this.websites = websites;
	}
	/**
	 * @return the yearOfEstablishment
	 */
	public String getYearOfEstablishment() {
		return yearOfEstablishment;
	}
	/**
	 * @param yearOfEstablishment the yearOfEstablishment to set
	 */
	public void setYearOfEstablishment(String yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}
	/**
	 * @return the qualificationPacks
	 */
	public String getQualificationPacks() {
		return qualificationPacks;
	}
	/**
	 * @param qualificationPacks the qualificationPacks to set
	 */
	public void setQualificationPacks(String qualificationPacks) {
		this.qualificationPacks = qualificationPacks;
	}
	/**
	 * @return the qualificationPacksAnnexurePath
	 */
	public String getQualificationPacksAnnexurePath() {
		return qualificationPacksAnnexurePath;
	}
	/**
	 * @param qualificationPacksAnnexurePath the qualificationPacksAnnexurePath to set
	 */
	public void setQualificationPacksAnnexurePath(
			String qualificationPacksAnnexurePath) {
		this.qualificationPacksAnnexurePath = qualificationPacksAnnexurePath;
	}
	/**
	 * @return the nSDCFunded
	 */
	public String getnSDCFunded() {
		return nSDCFunded;
	}
	/**
	 * @param nSDCFunded the nSDCFunded to set
	 */
	public void setnSDCFunded(String nSDCFunded) {
		this.nSDCFunded = nSDCFunded;
	}
	/**
	 * @return the nSDCFundedCertificatePath
	 */
	public String getnSDCFundedCertificatePath() {
		return nSDCFundedCertificatePath;
	}
	/**
	 * @param nSDCFundedCertificatePath the nSDCFundedCertificatePath to set
	 */
	public void setnSDCFundedCertificatePath(String nSDCFundedCertificatePath) {
		this.nSDCFundedCertificatePath = nSDCFundedCertificatePath;
	}
	/**
	 * @return the mediumOfInstructions
	 */
	public String getMediumOfInstructions() {
		return mediumOfInstructions;
	}
	/**
	 * @param mediumOfInstructions the mediumOfInstructions to set
	 */
	public void setMediumOfInstructions(String mediumOfInstructions) {
		this.mediumOfInstructions = mediumOfInstructions;
	}
	/**
	 * @return the selfOwnedInstitution
	 */
	public String getSelfOwnedInstitution() {
		return selfOwnedInstitution;
	}
	/**
	 * @param selfOwnedInstitution the selfOwnedInstitution to set
	 */
	public void setSelfOwnedInstitution(String selfOwnedInstitution) {
		this.selfOwnedInstitution = selfOwnedInstitution;
	}
	/**
	 * @return the selfOwnedInstitutionAnnexurePath
	 */
	public String getSelfOwnedInstitutionAnnexurePath() {
		return selfOwnedInstitutionAnnexurePath;
	}
	/**
	 * @param selfOwnedInstitutionAnnexurePath the selfOwnedInstitutionAnnexurePath to set
	 */
	public void setSelfOwnedInstitutionAnnexurePath(
			String selfOwnedInstitutionAnnexurePath) {
		this.selfOwnedInstitutionAnnexurePath = selfOwnedInstitutionAnnexurePath;
	}
	/**
	 * @return the franchiseOwnedInstitution
	 */
	public String getFranchiseOwnedInstitution() {
		return franchiseOwnedInstitution;
	}
	/**
	 * @param franchiseOwnedInstitution the franchiseOwnedInstitution to set
	 */
	public void setFranchiseOwnedInstitution(String franchiseOwnedInstitution) {
		this.franchiseOwnedInstitution = franchiseOwnedInstitution;
	}
	/**
	 * @return the franchiseOwnedInstitutionAnnexurePath
	 */
	public String getFranchiseOwnedInstitutionAnnexurePath() {
		return franchiseOwnedInstitutionAnnexurePath;
	}
	/**
	 * @param franchiseOwnedInstitutionAnnexurePath the franchiseOwnedInstitutionAnnexurePath to set
	 */
	public void setFranchiseOwnedInstitutionAnnexurePath(
			String franchiseOwnedInstitutionAnnexurePath) {
		this.franchiseOwnedInstitutionAnnexurePath = franchiseOwnedInstitutionAnnexurePath;
	}
	/**
	 * @return the mobileTrainingInstitution
	 */
	public String getMobileTrainingInstitution() {
		return mobileTrainingInstitution;
	}
	/**
	 * @param mobileTrainingInstitution the mobileTrainingInstitution to set
	 */
	public void setMobileTrainingInstitution(String mobileTrainingInstitution) {
		this.mobileTrainingInstitution = mobileTrainingInstitution;
	}
	/**
	 * @return the mobileTrainingInstitutionAnnexurePath
	 */
	public String getMobileTrainingInstitutionAnnexurePath() {
		return mobileTrainingInstitutionAnnexurePath;
	}
	/**
	 * @param mobileTrainingInstitutionAnnexurePath the mobileTrainingInstitutionAnnexurePath to set
	 */
	public void setMobileTrainingInstitutionAnnexurePath(
			String mobileTrainingInstitutionAnnexurePath) {
		this.mobileTrainingInstitutionAnnexurePath = mobileTrainingInstitutionAnnexurePath;
	}
	/**
	 * @return the panNumber
	 */
	public String getPanNumber() {
		return panNumber;
	}
	/**
	 * @param panNumber the panNumber to set
	 */
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	/**
	 * @return the panNumberPath
	 */
	public String getPanNumberPath() {
		return panNumberPath;
	}
	/**
	 * @param panNumberPath the panNumberPath to set
	 */
	public void setPanNumberPath(String panNumberPath) {
		this.panNumberPath = panNumberPath;
	}
	/**
	 * @return the tanNumber
	 */
	public String getTanNumber() {
		return tanNumber;
	}
	/**
	 * @param tanNumber the tanNumber to set
	 */
	public void setTanNumber(String tanNumber) {
		this.tanNumber = tanNumber;
	}
	/**
	 * @return the tanNumberPath
	 */
	public String getTanNumberPath() {
		return tanNumberPath;
	}
	/**
	 * @param tanNumberPath the tanNumberPath to set
	 */
	public void setTanNumberPath(String tanNumberPath) {
		this.tanNumberPath = tanNumberPath;
	}
	/**
	 * @return the turnOverOfInstitution
	 */
	public String getTurnOverOfInstitution() {
		return turnOverOfInstitution;
	}
	/**
	 * @param turnOverOfInstitution the turnOverOfInstitution to set
	 */
	public void setTurnOverOfInstitution(String turnOverOfInstitution) {
		this.turnOverOfInstitution = turnOverOfInstitution;
	}
	/**
	 * @return the turnOverOfInstitutionBalanceSheetPath
	 */
	public String getTurnOverOfInstitutionBalanceSheetPath() {
		return turnOverOfInstitutionBalanceSheetPath;
	}
	/**
	 * @param turnOverOfInstitutionBalanceSheetPath the turnOverOfInstitutionBalanceSheetPath to set
	 */
	public void setTurnOverOfInstitutionBalanceSheetPath(
			String turnOverOfInstitutionBalanceSheetPath) {
		this.turnOverOfInstitutionBalanceSheetPath = turnOverOfInstitutionBalanceSheetPath;
	}
	/**
	 * @return the instituteReceivedAnyGrant
	 */
	public String getInstituteReceivedAnyGrant() {
		return instituteReceivedAnyGrant;
	}
	/**
	 * @param instituteReceivedAnyGrant the instituteReceivedAnyGrant to set
	 */
	public void setInstituteReceivedAnyGrant(String instituteReceivedAnyGrant) {
		this.instituteReceivedAnyGrant = instituteReceivedAnyGrant;
	}
	/**
	 * @return the instituteReceivedAnyRecognition
	 */
	public String getInstituteReceivedAnyRecognition() {
		return instituteReceivedAnyRecognition;
	}
	/**
	 * @param instituteReceivedAnyRecognition the instituteReceivedAnyRecognition to set
	 */
	public void setInstituteReceivedAnyRecognition(
			String instituteReceivedAnyRecognition) {
		this.instituteReceivedAnyRecognition = instituteReceivedAnyRecognition;
	}
	/**
	 * @return the priorExperienceOfInstitutionInSkillDevelopment
	 */
	public String getPriorExperienceOfInstitutionInSkillDevelopment() {
		return priorExperienceOfInstitutionInSkillDevelopment;
	}
	/**
	 * @param priorExperienceOfInstitutionInSkillDevelopment the priorExperienceOfInstitutionInSkillDevelopment to set
	 */
	public void setPriorExperienceOfInstitutionInSkillDevelopment(
			String priorExperienceOfInstitutionInSkillDevelopment) {
		this.priorExperienceOfInstitutionInSkillDevelopment = priorExperienceOfInstitutionInSkillDevelopment;
	}
	/**
	 * @return the anyPriorExperienceOfInstitutionInSkillTraining
	 */
	public String getAnyPriorExperienceOfInstitutionInSkillTraining() {
		return anyPriorExperienceOfInstitutionInSkillTraining;
	}
	/**
	 * @param anyPriorExperienceOfInstitutionInSkillTraining the anyPriorExperienceOfInstitutionInSkillTraining to set
	 */
	public void setAnyPriorExperienceOfInstitutionInSkillTraining(
			String anyPriorExperienceOfInstitutionInSkillTraining) {
		this.anyPriorExperienceOfInstitutionInSkillTraining = anyPriorExperienceOfInstitutionInSkillTraining;
	}
	/**
	 * @return the trainingStaffDetailsAnnexurePath
	 */
	public String getTrainingStaffDetailsAnnexurePath() {
		return trainingStaffDetailsAnnexurePath;
	}
	/**
	 * @param trainingStaffDetailsAnnexurePath the trainingStaffDetailsAnnexurePath to set
	 */
	public void setTrainingStaffDetailsAnnexurePath(
			String trainingStaffDetailsAnnexurePath) {
		this.trainingStaffDetailsAnnexurePath = trainingStaffDetailsAnnexurePath;
	}
	
	
	
	
}