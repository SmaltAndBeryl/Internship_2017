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
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("applicationId",applicationId);
		return getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getGetTrainingPartnerRegistrationIdUsingApplicationId(), parameters, String.class);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding training partner registration id using application Id "+ e);
			return null;
		}
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
			String applicationId = resultSet.getString("applicationId");
			String organizationName = resultSet.getString("organizationName");
			String sPOCName = resultSet.getString("sPOCName");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
		    String pincode = resultSet.getString("pincode");
			String mobileNumber = resultSet.getString("mobileNumber");
			String alternateMobileNumber = resultSet.getString("alternateMobileNumber");
			String landlineNumber = resultSet.getString("landlineNumber");
			String alternateLandlineNumber = resultSet.getString("alternateLandlineNumber");
			String faxNumber = resultSet.getString("faxNumber");
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
			String numberOfPermanentOfficeManager = resultSet.getString("numberOfPermanentOfficeManager");
			String numberOftemporaryOfficeManager = resultSet.getString("numberOftemporaryOfficeManager");
			String numberOfPermanentOfficeStaff = resultSet.getString("numberOfPermanentOfficeStaff");
			String numberOfTemporaryOfficeStaff = resultSet.getString("numberOfTemporaryOfficeStaff");
			String numberOfPermanentLabAssistants = resultSet.getString("numberOfPermanentLabAssistants");
			String numberOfTemporaryLabAssistants = resultSet.getString("numberOfTemporaryLabAssistants");
			String numberOfPermanentAccountants = resultSet.getString("numberOfPermanentAccountants");
			String numberOfTemporaryAccountants = resultSet.getString("numberOfTemporaryAccountants");
			String numberOfPermanentSupportStaff = resultSet.getString("numberOfPermanentSupportStaff");
			String numberOfTemporarySupportStaff = resultSet.getString("numberOfTemporarySupportStaff");
			String numberOfPermanentOtherEmployees = resultSet.getString("numberOfPermanentOtherEmployees");
			String numberOfTemporaryOtherEmployees = resultSet.getString("numberOfTemporaryOtherEmployees");
			String areaOfInstitute = resultSet.getString("areaOfInstitute");
			String buildingType = resultSet.getString("buildingType");
			String sizeOfClassrooms = resultSet.getString("sizeOfClassrooms");
			String classroomPicsPath = resultSet.getString("classroomPicsPath");
			String numberOfClassrooms = resultSet.getString("numberOfClassrooms");
			String sizeOfLabs = resultSet.getString("sizeOfLabs");
			String labPicsPath = resultSet.getString("labPicsPath");
			String numberOfLabs = resultSet.getString("numberOfLabs");
			String sizeOfWorkshops = resultSet.getString("sizeOfWorkshops");
			String workshopPicsPath = resultSet.getString("workshopPicsPath");
			String numberOfWorkshops = resultSet.getString("numberOfWorkshops");
			String mandatoryToolKitpresent = resultSet.getString("mandatoryToolKitpresent");
			String mandatoryToolKitAnnexurePath = resultSet.getString("mandatoryToolKitAnnexurePath");
			String mandatoryToolKitPicsPath = resultSet.getString("mandatoryToolKitPicsPath");
			String safeDrinkingWater = resultSet.getString("safeDrinkingWater");
			String powerBackup = resultSet.getString("powerBackup");
			String separateToilets = resultSet.getString("separateToilets");
			String transportFacility = resultSet.getString("transportFacility");
			String presenceOfLibrary = resultSet.getString("presenceOfLibrary");
			String numberOfTechnicalBooks = resultSet.getString("numberOfTechnicalBooks");
			String numberOfNonTechnicalBooks = resultSet.getString("numberOfNonTechnicalBooks");
			String numberOfMagazines = resultSet.getString("numberOfMagazines");
			String numberOfDailies = resultSet.getString("numberOfDailies");
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
			return new ProfileCreationTrainingPartnerCenterDetailsDto(trainingPartnerCenterId,trainingPartnerRegistrationId,nameOfCenter,numberOfPermanentOfficeManager,numberOftemporaryOfficeManager,
				numberOfPermanentOfficeStaff,numberOfTemporaryOfficeStaff,numberOfPermanentLabAssistants,numberOfTemporaryLabAssistants,
				numberOfPermanentAccountants,numberOfTemporaryAccountants,numberOfPermanentSupportStaff,numberOfTemporarySupportStaff,
				numberOfPermanentOtherEmployees,numberOfTemporaryOtherEmployees,areaOfInstitute,buildingType,sizeOfClassrooms,classroomPicsPath,
				numberOfClassrooms,sizeOfLabs,labPicsPath,numberOfLabs,sizeOfWorkshops,workshopPicsPath,numberOfWorkshops,mandatoryToolKitpresent,
				mandatoryToolKitAnnexurePath,mandatoryToolKitPicsPath,safeDrinkingWater,powerBackup,separateToilets,transportFacility,presenceOfLibrary,
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			String yearOfRecognition = resultSet.getString("yearOfRecognition");
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
	public int isTrainingCenterPresent(String trainingPartnerRegistrationId, String trainingPartnerCenterId)
	{
		int status = 0;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("trainingPartnerCenterId", trainingPartnerCenterId);
			parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
			status =  getJdbcTemplate().queryForObject(profileCreationTrainingPartnerConfigSql.getIsTrainingCenterPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find value of management staff " +e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured " +e);
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
			String courseName = resultSet.getString("courseName");
			String numberOfBatchesPerYear = resultSet.getString("numberOfBatchesPerYear");
			String numberOfStudentsInEachBatch = resultSet.getString("numberOfStudentsInEachBatch");
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
			String trainingPartnerCenterId = resultSet.getString("trainingPartnerCenterId");
			String type = resultSet.getString("type");
			String name = resultSet.getString("name");;
			String designation = resultSet.getString("designation");;
			String emailId = resultSet.getString("emailId");;
			String contactNumber = resultSet.getString("contactNumber");;
			String educationalQualification = resultSet.getString("educationalQualification");;
			String regularOrVisiting = resultSet.getString("regularOrVisiting");;
			String experience = resultSet.getString("experience");;
			String cVPath = resultSet.getString("cVPath");;
			String certificatePath = resultSet.getString("certificatePath");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto(managementAndStaffId,trainingPartnerRegistrationId,trainingPartnerCenterId,type,name,designation,emailId,contactNumber,
					educationalQualification,regularOrVisiting,experience,cVPath,certificatePath,isActive);
		}

}	
	
}
