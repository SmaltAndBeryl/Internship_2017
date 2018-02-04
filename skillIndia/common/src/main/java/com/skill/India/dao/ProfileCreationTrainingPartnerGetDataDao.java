package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.config.ProfileCreationTrainingPartnerConfigSql;
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerOrganizationDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerTrainingStaffDetailsDto;

@Repository
public class ProfileCreationTrainingPartnerGetDataDao  extends AbstractTransactionalDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationTrainingPartnerGetDataDao.class);
	@Autowired
	private ProfileCreationTrainingPartnerConfigSql profileCreationTrainingPartnerConfigSql;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	/*
	 * Get Training Partner Registration id using ApplicationId  
	 */
	
	public String profileCreationGetTrainingPartnerRegistrationIdUsingApplicationId(int applicationId)
	{
		String trainingPartnerRegistrationId = null;
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("applicationId",applicationId);
		trainingPartnerRegistrationId =  getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getGetTrainingPartnerRegistrationIdUsingApplicationId(), parameters, String.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			LOGGER.debug("Training Partner registartion Id does not exists");
			return "-1";
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding training partner registration id using application Id "+ e);
			return "-2";
		}
		return trainingPartnerRegistrationId;
 	}
	
	
	/*
	 * Get Training Partner Organization Level data from table  
	 */
	
	private static final ProfileCreationTrainingPartnerOrganizationDetailsRowMapper ROW_MAPPER_TPREG_ORGDETAILS = new ProfileCreationTrainingPartnerOrganizationDetailsRowMapper();
	
	public Collection<ProfileCreationTrainingPartnerOrganizationDetailsDto> profileCreationGetDataFromTrainingPartnerOrganizationDetails(int applicationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("applicationId",applicationId);
		return getJdbcTemplate().query(profileCreationTrainingPartnerConfigSql.getGetDataFromTrainingPartnerOrganizationDetails(),parameters,ROW_MAPPER_TPREG_ORGDETAILS);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured "+ e);
			return null;
		}
 	}
	
	public static class ProfileCreationTrainingPartnerOrganizationDetailsRowMapper implements RowMapper<ProfileCreationTrainingPartnerOrganizationDetailsDto> {

		@Override
		public ProfileCreationTrainingPartnerOrganizationDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String trainingPartnerRegistrationId = resultSet.getString("trainingPartnerRegistrationId");
			int applicationId = resultSet.getInt("applicationId");
			String organizationName = resultSet.getString("organizationName");
			String sPOCName = resultSet.getString("sPOCName");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
		    Long pincode = resultSet.getLong("pincode");
			Long mobileNumber = resultSet.getLong("mobileNumber");
			Long alternateMobileNumber = resultSet.getLong("alternateMobileNumber");
			Long landlineNumber = resultSet.getLong("landlineNumber");
			Long alternateLandlineNumber = resultSet.getLong("alternateLandlineNumber");
			Long faxNumber = resultSet.getLong("faxNumber");
			String websites = resultSet.getString("websites");
			String yearOfEstablishment = resultSet.getString("yearOfEstablishment");
			String qualificationPacks = resultSet.getString("qualificationPacks");
			String qualificationPacksAnnexurePath = resultSet.getString("qualificationPacksAnnexurePath");
			String nSDCFunded = resultSet.getString("nSDCFunded") ;
			String nSDCFundedCertificatePath = resultSet.getString("nSDCFundedCertificatePath");
			String mediumOfInstructions = resultSet.getString("mediumOfInstructions");
			String selfOwnedInstitution = resultSet.getString("selfOwnedInstitution");
			String selfOwnedInstitutionAnnexurePath = resultSet.getString("selfOwnedInstitutionAnnexurePath");
			String franchiseOwnedInstitution = resultSet.getString("franchiseOwnedInstitution");
			String franchiseOwnedInstitutionAnnexurePath = resultSet.getString("franchiseOwnedInstitutionAnnexurePath");
			String mobileTrainingInstitution = resultSet.getString("mobileTrainingInstitution");
			String mobileTrainingInstitutionAnnexurePath = resultSet.getString("mobileTrainingInstitutionAnnexurePath");
			String panNumber = resultSet.getString("panNumber");
			String panNumberPath = resultSet.getString("panNumberPath");
			String tanNumber = resultSet.getString("tanNumber");
			String tanNumberPath = resultSet.getString("tanNumberPath");
			String turnOverOfInstitution = resultSet.getString("turnOverOfInstitution");
			String turnOverOfInstitutionBalanceSheetPath = resultSet.getString("turnOverOfInstitutionBalanceSheetPath");
			String instituteReceivedAnyGrant = resultSet.getString("instituteReceivedAnyGrant");
			String instituteReceivedAnyRecognition = resultSet.getString("instituteReceivedAnyRecognition");
			String priorExperienceOfInstitutionInSkillDevelopment = resultSet.getString("priorExperienceOfInstitutionInSkillDevelopment");
			String anyPriorExperienceOfInstitutionInSkillTraining = resultSet.getString("anyPriorExperienceOfInstitutionInSkillTraining");
			String trainingStaffDetailsAnnexurePath = resultSet.getString("trainingStaffDetailsAnnexurePath");
			
			return new ProfileCreationTrainingPartnerOrganizationDetailsDto(trainingPartnerRegistrationId,applicationId,organizationName,sPOCName,address,city,state,pincode,
				mobileNumber,alternateMobileNumber,landlineNumber,alternateLandlineNumber,faxNumber,websites,yearOfEstablishment,qualificationPacks,qualificationPacksAnnexurePath,nSDCFunded,nSDCFundedCertificatePath,
				mediumOfInstructions,selfOwnedInstitution,selfOwnedInstitutionAnnexurePath,franchiseOwnedInstitution,franchiseOwnedInstitutionAnnexurePath,mobileTrainingInstitution,mobileTrainingInstitutionAnnexurePath,
				panNumber,panNumberPath,tanNumber,tanNumberPath,turnOverOfInstitution,turnOverOfInstitutionBalanceSheetPath,instituteReceivedAnyGrant,instituteReceivedAnyRecognition,priorExperienceOfInstitutionInSkillDevelopment,
				anyPriorExperienceOfInstitutionInSkillTraining,trainingStaffDetailsAnnexurePath);
		}

}
	
	/*
	 * Table 2 Center Level Details
	 */
	
private static final ProfileCreationTrainingPartnerCenterLevelDetailsRowMapper ROW_MAPPER_TPREG_CENTERDEATILS = new ProfileCreationTrainingPartnerCenterLevelDetailsRowMapper();
	
	public Collection<ProfileCreationTrainingPartnerCenterDetailsDto> profileCreationGetDataFromTrainingPartnerCenterLevelDetails(String trainingPartnerRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("trainingPartnerRegistrationId",trainingPartnerRegistrationId);
		return getJdbcTemplate().query(profileCreationTrainingPartnerConfigSql.getGetDataFromTrainingPartnerCenterLevelDetails(),parameters,ROW_MAPPER_TPREG_CENTERDEATILS);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while fetching trainingpartner center level details "+ e);
			return null;
		}
 	}
	
	public static class ProfileCreationTrainingPartnerCenterLevelDetailsRowMapper implements RowMapper<ProfileCreationTrainingPartnerCenterDetailsDto> {

		@Override
		public ProfileCreationTrainingPartnerCenterDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String trainingPartnerCenterId = resultSet.getString("trainingPartnerCenterId");
			String trainingPartnerRegistrationId = resultSet.getString("trainingPartnerRegistrationId");
			String nameOfCenter = resultSet.getString("nameOfCenter");
			 String nameOperationHead = resultSet.getString("nameOperationHead");
			String designationOperationHead= resultSet.getString("designationOperationHead");
			String emailOperationHead= resultSet.getString("emailOperationHead");
			Long contactNumberOperationHead= resultSet.getLong("contactNumberOperationHead");
			String educationalQualificationOperationHead= resultSet.getString("educationalQualificationOperationHead");
			String experienceOperationHead= resultSet.getString("experienceOperationHead");
			String cvOperationHeadPath= resultSet.getString("cvOperationHeadPath");
			String nameAffiliationCoordinator= resultSet.getString("nameAffiliationCoordinator");
			String designationAffiliationCoordinator= resultSet.getString("designationAffiliationCoordinator");
			String emailAffiliationCoordinator= resultSet.getString("emailAffiliationCoordinator");
			Long contactNumberAffiliationCoordinator= resultSet.getLong("contactNumberAffiliationCoordinator");
			String educationalQualificationAffiliationCoordinator= resultSet.getString("educationalQualificationAffiliationCoordinator");
			String experienceAffiliationCoordinator= resultSet.getString("experienceAffiliationCoordinator");
			String cvAffiliationCoordinatorPath= resultSet.getString("cvAffiliationCoordinatorPath");
			String nameSPOC= resultSet.getString("nameSPOC");
			String designationSPOC= resultSet.getString("designationSPOC");
			String emailSPOC= resultSet.getString("emailSPOC");
			Long contactNumberSPOC= resultSet.getLong("contactNumberSPOC");
			String educationalQualificationSPOC= resultSet.getString("educationalQualificationSPOC");
			String experienceSPOC= resultSet.getString("experienceSPOC");
			String cvSPOCPath= resultSet.getString("cvSPOCPath");
			int numberOfPermanentOfficeManager = resultSet.getInt("numberOfPermanentOfficeManager");
			int numberOftemporaryOfficeManager = resultSet.getInt("numberOftemporaryOfficeManager");
			int numberOfPermanentOfficeStaff = resultSet.getInt("numberOfPermanentOfficeStaff");
			int numberOfTemporaryOfficeStaff = resultSet.getInt("numberOfTemporaryOfficeStaff");
			int numberOfPermanentLabAssistants = resultSet.getInt("numberOfPermanentLabAssistants");
			int numberOfTemporaryLabAssistants = resultSet.getInt("numberOfTemporaryLabAssistants");
			int numberOfPermanentAccountants = resultSet.getInt("numberOfPermanentAccountants");
			int numberOfTemporaryAccountants = resultSet.getInt("numberOfTemporaryAccountants");
			int numberOfPermanentSupportStaff = resultSet.getInt("numberOfPermanentSupportStaff");
			int numberOfTemporarySupportStaff = resultSet.getInt("numberOfTemporarySupportStaff");
			int numberOfPermanentOtherEmployees = resultSet.getInt("numberOfPermanentOtherEmployees");
			int numberOfTemporaryOtherEmployees = resultSet.getInt("numberOfTemporaryOtherEmployees");
			int areaOfInstitute = resultSet.getInt("areaOfInstitute");
			String buildingType = resultSet.getString("buildingType");
			int sizeOfClassrooms = resultSet.getInt("sizeOfClassrooms");
			String classroomPicsPath = resultSet.getString("classroomPicsPath");
			int numberOfClassrooms = resultSet.getInt("numberOfClassrooms");
			int sizeOfLabs = resultSet.getInt("sizeOfLabs");
			String labPicsPath = resultSet.getString("labPicsPath");
			int numberOfLabs = resultSet.getInt("numberOfLabs");
			int sizeOfWorkshops = resultSet.getInt("sizeOfWorkshops");
			String workshopPicsPath = resultSet.getString("workshopPicsPath");
			int numberOfWorkshops = resultSet.getInt("numberOfWorkshops");
			String mandatoryToolKitpresent = resultSet.getString("mandatoryToolKitpresent");
			String mandatoryToolKitAnnexurePath = resultSet.getString("mandatoryToolKitAnnexurePath");
			String mandatoryToolKitPicsPath = resultSet.getString("mandatoryToolKitPicsPath");
			String safeDrinkingWater = resultSet.getString("safeDrinkingWater");
			String powerBackup = resultSet.getString("powerBackup");
			String separateToilets = resultSet.getString("separateToilets");
			String transportFacility = resultSet.getString("transportFacility");
			String fireSafety = resultSet.getString("fireSafety");
			String presenceOfLibrary = resultSet.getString("presenceOfLibrary");
			int numberOfTechnicalBooks = resultSet.getInt("numberOfTechnicalBooks");
			int numberOfNonTechnicalBooks = resultSet.getInt("numberOfNonTechnicalBooks");
			int numberOfMagazines = resultSet.getInt("numberOfMagazines");
			int numberOfDailies = resultSet.getInt("numberOfDailies");
			String remarksOnInfrastructureDetails = resultSet.getString("remarksOnInfrastructureDetails");
			String sufficientClassroomIlluminationLevel = resultSet.getString("sufficientClassroomIlluminationLevel");
			String sufficientClassroomVentilationLevel = resultSet.getString("sufficientClassroomVentilationLevel");
			String sufficientCenterCleanliness = resultSet.getString("sufficientCenterCleanliness");
			String centerWeatherProtected = resultSet.getString("centerWeatherProtected");
			String remarksOnLearningEnviornment = resultSet.getString("remarksOnLearningEnviornment");
			String printedBrochureOrProspectus = resultSet.getString("printedBrochureOrProspectus");
			String documentedPolicyAndProcedures = resultSet.getString("documentedPolicyAndProcedures");
			String concessionPolicy = resultSet.getString("concessionPolicy");
			String safeCustodyOfStudentDocuments = resultSet.getString("safeCustodyOfStudentDocuments");
			String studentAgreementWithInstitution = resultSet.getString("studentAgreementWithInstitution");
			String remarksOnStudentAdmissionDetails = resultSet.getString("remarksOnStudentAdmissionDetails");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationTrainingPartnerCenterDetailsDto(trainingPartnerCenterId,trainingPartnerRegistrationId,nameOfCenter,nameOperationHead, designationOperationHead, 
				emailOperationHead,  contactNumberOperationHead,educationalQualificationOperationHead, experienceOperationHead, cvOperationHeadPath,nameAffiliationCoordinator,
				designationAffiliationCoordinator, emailAffiliationCoordinator, contactNumberAffiliationCoordinator, educationalQualificationAffiliationCoordinator,
				experienceAffiliationCoordinator,cvAffiliationCoordinatorPath,nameSPOC,	designationSPOC,emailSPOC,contactNumberSPOC,educationalQualificationSPOC,
			    experienceSPOC,	cvSPOCPath, numberOfPermanentOfficeManager, numberOftemporaryOfficeManager,	numberOfPermanentOfficeStaff,numberOfTemporaryOfficeStaff,numberOfPermanentLabAssistants,numberOfTemporaryLabAssistants,
				numberOfPermanentAccountants,numberOfTemporaryAccountants,numberOfPermanentSupportStaff,numberOfTemporarySupportStaff,
				numberOfPermanentOtherEmployees,numberOfTemporaryOtherEmployees,areaOfInstitute,buildingType,sizeOfClassrooms,classroomPicsPath,
				numberOfClassrooms,sizeOfLabs,labPicsPath,numberOfLabs,sizeOfWorkshops,workshopPicsPath,numberOfWorkshops,mandatoryToolKitpresent,
				mandatoryToolKitAnnexurePath,mandatoryToolKitPicsPath,safeDrinkingWater,powerBackup,separateToilets,transportFacility,fireSafety,presenceOfLibrary,
				numberOfTechnicalBooks,numberOfNonTechnicalBooks,numberOfMagazines,numberOfDailies,remarksOnInfrastructureDetails,
				sufficientClassroomIlluminationLevel,sufficientClassroomVentilationLevel,sufficientCenterCleanliness,centerWeatherProtected,
				remarksOnLearningEnviornment,printedBrochureOrProspectus,documentedPolicyAndProcedures,concessionPolicy,safeCustodyOfStudentDocuments,
				studentAgreementWithInstitution,remarksOnStudentAdmissionDetails,isActive);
		}

}
/*
 * Table 3 Institute Grant
 * 	
 */
	
	
	
private static final ProfileCreationTrainingPartnerInstituteGrantRowMapper ROW_MAPPER_TPREG_INSTGRANT = new ProfileCreationTrainingPartnerInstituteGrantRowMapper();
	
	public Collection<ProfileCreationTrainingPartnerInstituteGrantDto> profileCreationGetDataFromTrainingPartnerInstituteGrant(String trainingPartnerRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("trainingPartnerRegistrationId",trainingPartnerRegistrationId);
		return getJdbcTemplate().query(profileCreationTrainingPartnerConfigSql.getGetDataFromTrainingPartnerInstituteGrant(),parameters,ROW_MAPPER_TPREG_INSTGRANT);
		}
		catch(Exception e)
		{
			LOGGER.error("Exception occured while creating row mapper for Institute Grant " + e);
			return null;
		}
 	}
	
	public static class ProfileCreationTrainingPartnerInstituteGrantRowMapper implements RowMapper<ProfileCreationTrainingPartnerInstituteGrantDto> {

		@Override
		public ProfileCreationTrainingPartnerInstituteGrantDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String instituteGrantId = resultSet.getString("instituteGrantId");
			String trainingPartnerRegistrationId = resultSet.getString("trainingPartnerRegistrationId");
			String nameOfMinistry = resultSet.getString("nameOfMinistry");
			String natureOfWork = resultSet.getString("natureOfWork");
			String remarks = resultSet.getString("remarks");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationTrainingPartnerInstituteGrantDto(instituteGrantId,trainingPartnerRegistrationId,nameOfMinistry,natureOfWork,remarks,isActive);
		}

}
	
	/*
	 * Table 4 Institute Recognition 
	 */
	
private static final ProfileCreationTrainingPartnerInstituteRecognitionRowMapper ROW_MAPPER_TPREG_INSTRECOGNITION = new ProfileCreationTrainingPartnerInstituteRecognitionRowMapper();
	
	public Collection<ProfileCreationTrainingPartnerInstituteRecognitionDto> profileCreationGetDataFromTrainingPartnerInstituteRecognition(String trainingPartnerRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("trainingPartnerRegistrationId",trainingPartnerRegistrationId);
		return getJdbcTemplate().query(profileCreationTrainingPartnerConfigSql.getGetDataFromTrainingPartnerInstituteRecognition(),parameters,ROW_MAPPER_TPREG_INSTRECOGNITION);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured "+ e);
			return null;
		}
 	}
	
	public static class ProfileCreationTrainingPartnerInstituteRecognitionRowMapper implements RowMapper<ProfileCreationTrainingPartnerInstituteRecognitionDto> {

		@Override
		public ProfileCreationTrainingPartnerInstituteRecognitionDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String instituteRecognitionId = resultSet.getString("instituteRecognitionId");
			String trainingPartnerRegistrationId = resultSet.getString("trainingPartnerRegistrationId");
			String nameOfRecognizingBody = resultSet.getString("nameOfRecognizingBody");
			String recognitionNumber = resultSet.getString("recognitionNumber");
			int yearOfRecognition = resultSet.getInt("yearOfRecognition");
			String validityOfRecognition = resultSet.getString("validityOfRecognition");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationTrainingPartnerInstituteRecognitionDto(instituteRecognitionId,trainingPartnerRegistrationId,nameOfRecognizingBody,recognitionNumber,yearOfRecognition,validityOfRecognition,isActive);
		}

}
	
	/*
	 * Table 5 Prior Experience In SkillTraining
	 */
	
	
private static final ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingRowMapper ROW_MAPPER_TPREG_PRIOREXP = new ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingRowMapper();
	
	public Collection<ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> profileCreationGetDataFromTrainingPartnerPriorExperienceInSkillTraining(String trainingPartnerRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("trainingPartnerRegistrationId",trainingPartnerRegistrationId);
		return getJdbcTemplate().query(profileCreationTrainingPartnerConfigSql.getGetDataFromTrainingPartnerPriorExperienceInSkillTraining(),parameters,ROW_MAPPER_TPREG_PRIOREXP);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	public int isTrainingCenterPresent(String trainingPartnerRegistrationId, String nameOfCenter)
	{
		int status = 10;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("nameOfCenter", nameOfCenter);
			parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
			status =  getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsTrainingCenterPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find if training center already exists" +e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured " +e);
			status = -2;
		}
		return status;
	}
	private static final ProfileCreationTrainingStaffRowMapper ROW_MAPPER_TPREG_TRSTAFF = new ProfileCreationTrainingStaffRowMapper();
	public Collection<ProfileCreationTrainingPartnerTrainingStaffDetailsDto> getTrainingStaffData(String trainingPartnerRegistrationId)
	{
		try{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("trainingPartnerRegistrationId",trainingPartnerRegistrationId);
			return getJdbcTemplate().query(profileCreationTrainingPartnerConfigSql.getGetDataFromTrainingPartnerTrainingStaffDetails(),parameters, ROW_MAPPER_TPREG_TRSTAFF);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
	}
	
	public static class ProfileCreationTrainingStaffRowMapper implements RowMapper<ProfileCreationTrainingPartnerTrainingStaffDetailsDto> {

		@Override
		public ProfileCreationTrainingPartnerTrainingStaffDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String trainingStaffId = resultSet.getString("trainingStaffId");
			String trainingPartnerRegistrationId = resultSet.getString("trainingPartnerRegistrationId");
			String name = resultSet.getString("name");
			String designation = resultSet.getString("designation");
			String emailId = resultSet.getString("emailId").toLowerCase();
			String educationalQualification = resultSet.getString("educationalQualification");
			String regularOrVisiting = resultSet.getString("regularOrVisiting");
			int experience =resultSet.getInt("experience");
			String cVPath = resultSet.getString("cVPath");
			String certificatePath = resultSet.getString("certificatePath");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationTrainingPartnerTrainingStaffDetailsDto(trainingStaffId , trainingPartnerRegistrationId , name,designation,emailId, educationalQualification, regularOrVisiting,experience,cVPath, certificatePath, isActive);
		}

}
	//to find out if Institute grant exists or not
	public int isInstituteGrantPresent(String trainingPartnerRegistrationId, String nameOfMinistry)
	{
		int status = 10;
		try
		{
			Map<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
			parameters.put("nameOfMinistry", nameOfMinistry);
			status = getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsInstituteGrantPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			status = -1;
			LOGGER.debug("Could not find value of Institute Grant " +e);
			
		}
		catch (Exception e)
		{
			status = -2;
			LOGGER.error("An exception occured while finding if institute grant already exists in database " + e);
			
		}
		return status;
	}
	
	public int isInstituteRecognitionPresent(String trainingPartnerRegistrationId, String nameOfRecognizingBody)
	{
		int status = 10;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("nameOfRecognizingBody", nameOfRecognizingBody);
			parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
			status =  getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsRecognitnionPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find value of Institute recognition " +e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured while finding if institute recognition already exists in database " + e);
			status = -2;
		}
		return status;
	}
	
	
	
	
	

	/**
	 * 
	 * @param applicationId
	 * @return
	 */
	public int isApplicationIdPresentinTrainingPartner(int applicationId)
	{
		int status = 10;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("applicationId", applicationId);
			
			status = getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsApplicationIdPresentInTrainingPartner(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find applicationId in Training partner organisation details, returnig : -1" + e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured while finding if applicationId exists in Training Partner Organisation details" +e);
			status = -2;
		}
		return status;
	}
	
	/**
	 * 
	 * @param trainingPartnerRegistrationId
	 * @param email
	 * @return
	 */
	public int isTrainingPartnerManagementStaffPresent(String trainingPartnerRegistrationId, String email)
	{
		int status = 10;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("emailId", email);
			parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
			status = getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsTrainingStaffPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find value of Training PArtnerManagement" + e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured while finding if training Partner Management already exists in database " +e);
			status = -2;
		}
		return status;
	}
	
	public int isTrainerPresent(String trainingPartnerRegistrationId, String email)
	{
		int status = 10;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("emailId", email);
			parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
			status = getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsTrainingPartnerStaffTrainingStaffPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find if Trainer exists" + e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured while finding if Trainer already exists in database " +e);
			status = -2;
		}
		return status;
	}
	
	public int isTrainingExperiencePresent(String trainingPartnerRegistrationId, String courseName)
	{
		int status = 10;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("courseName", courseName);
			parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
			status =  getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsTrainingExperiencePresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find value of Training Experience" + e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured while finding if traing experience already exists in database " +e);
			status = -2;
		}
		return status;
	}
	
	public static class ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingRowMapper implements RowMapper<ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> {

		@Override
		public ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String priorExperienceInSkillTrainingId = resultSet.getString("priorExperienceInSkillTrainingId");
			String trainingPartnerRegistrationId = resultSet.getString("trainingPartnerRegistrationId");
			String courseName = resultSet.getString("courseName").toUpperCase();
			Long numberOfBatchesPerYear = resultSet.getLong("numberOfBatchesPerYear");
			int numberOfStudentsInEachBatch = resultSet.getInt("numberOfStudentsInEachBatch");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto(priorExperienceInSkillTrainingId,trainingPartnerRegistrationId,courseName,numberOfBatchesPerYear,numberOfStudentsInEachBatch,isActive);
		}

}
	
	/*
	 * Table 6 Management And Staff And Officials Details
	 */

private static final ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsRowMapper ROW_MAPPER_TPREG_STAFFDETAILS = new ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsRowMapper();
	
	public Collection<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> profileCreationGetDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails(String trainingPartnerRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("trainingPartnerRegistrationId",trainingPartnerRegistrationId);
		return getJdbcTemplate().query(profileCreationTrainingPartnerConfigSql.getGetDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails(),parameters,ROW_MAPPER_TPREG_STAFFDETAILS);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while getting data for training partner managemnet details " + e);
			return null;
		}
 	}
	
	public static class ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsRowMapper implements RowMapper<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> {

		@Override
		public ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String managementAndStaffId = resultSet.getString("managementAndStaffId");
			String trainingPartnerRegistrationId = resultSet.getString("trainingPartnerRegistrationId");
			//String trainingPartnerCenterId = resultSet.getString("trainingPartnerCenterId");
			//String type = resultSet.getString("type");
			String name = resultSet.getString("name");
			String designation = resultSet.getString("designation");
			String emailId = resultSet.getString("emailId");
			Long contactNumber = resultSet.getLong("contactNumber");
			String educationalQualification = resultSet.getString("educationalQualification");
			//String regularOrVisiting = resultSet.getString("regularOrVisiting");
			int experience = resultSet.getInt("experience");
			String cVPath = resultSet.getString("cVPath");
			//String certificatePath = resultSet.getString("certificatePath");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto(managementAndStaffId,trainingPartnerRegistrationId,name,designation,emailId,contactNumber,
					educationalQualification,experience,cVPath, isActive);
		}

}	
	
}
