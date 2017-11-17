package com.skill.India.dao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.config.ProfileCreationTrainingPartnerConfigSql;
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerOrganizationDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;

@Repository
public class ProfileCreationTrainingPartnerInsertDataDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationTrainingPartnerInsertDataDao.class);
	@Autowired
	private ProfileCreationTrainingPartnerConfigSql profileCreationTrainingPartnerConfigSql;
	
	private ReadApplicationConstants readApplicationConstants;
	
	/*
	 * 
	 * SEND APPLICATION ID & TRAINING PARTNER REGISTRATION ID ALONG WITH CALLING DAOS FROM SERVICE
	 * 
	 */
	

	
	public int insertIntoTrainingPartnerOrganizationDetails(ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganizationDetailsDto)
	{
		int status = 0;
		try{
			LOGGER.debug("Trying to construct database query to insert organisation level registration data of training partner into database");
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("applicationId",profileCreationTrainingPartnerOrganizationDetailsDto.getApplicationId());
			parameters.put("organizationName",profileCreationTrainingPartnerOrganizationDetailsDto.getOrganizationName());
			parameters.put("sPOCName",profileCreationTrainingPartnerOrganizationDetailsDto.getsPOCName());
			parameters.put("address",profileCreationTrainingPartnerOrganizationDetailsDto.getAddress());
			parameters.put("city",profileCreationTrainingPartnerOrganizationDetailsDto.getCity());
			parameters.put("state",profileCreationTrainingPartnerOrganizationDetailsDto.getState());
			parameters.put("pincode",profileCreationTrainingPartnerOrganizationDetailsDto.getPincode());
			parameters.put("mobileNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getMobileNumber());
			parameters.put("alternateMobileNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getAlternateMobileNumber());
			parameters.put("landlineNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getLandlineNumber());
			parameters.put("alternateLandlineNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getAlternateLandlineNumber());
			parameters.put("faxNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getFaxNumber());
			parameters.put("websites",profileCreationTrainingPartnerOrganizationDetailsDto.getWebsites());
			parameters.put("yearOfEstablishment",profileCreationTrainingPartnerOrganizationDetailsDto.getYearOfEstablishment());
			parameters.put("qualificationPacks",profileCreationTrainingPartnerOrganizationDetailsDto.getQualificationPacks());
			//parameters.put("qualificationPacksAnnexurePath",getPaths.get("qualificationPacksAnnexurePath"));
			parameters.put("nSDCFunded",profileCreationTrainingPartnerOrganizationDetailsDto.getnSDCFunded());
			//parameters.put("nSDCFundedCertificatePath",getPaths.get("nSDCFundedCertificatePath"));
			parameters.put("mediumOfInstructions",profileCreationTrainingPartnerOrganizationDetailsDto.getMediumOfInstructions());
			parameters.put("selfOwnedInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getSelfOwnedInstitution());
			//parameters.put("selfOwnedInstitutionAnnexurePath",getPaths.get("selfOwnedInstitutionAnnexurePath"));
			parameters.put("franchiseOwnedInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getFranchiseOwnedInstitution());
			//parameters.put("franchiseOwnedInstitutionAnnexurePath",getPaths.get("franchiseOwnedInstitutionAnnexurePath"));
			parameters.put("mobileTrainingInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getMobileTrainingInstitution());
			//parameters.put("mobileTrainingInstitutionAnnexurePath",getPaths.get("mobileTrainingInstitutionAnnexurePath"));
			parameters.put("panNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getPanNumber());
			//parameters.put("panNumberPath",getPaths.get("panNumberPath"));
			parameters.put("tanNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getTanNumber());
			//parameters.put("tanNumberPath",getPaths.get("tanNumberPath"));
			parameters.put("turnOverOfInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getTurnOverOfInstitution());
			//parameters.put("turnOverOfInstitutionBalanceSheetPath",getPaths.get("turnOverOfInstitutionBalanceSheetPath"));
			parameters.put("instituteReceivedAnyGrant",profileCreationTrainingPartnerOrganizationDetailsDto.getInstituteReceivedAnyGrant());
			parameters.put("instituteReceivedAnyRecognition",profileCreationTrainingPartnerOrganizationDetailsDto.getInstituteReceivedAnyRecognition());
			parameters.put("priorExperienceOfInstitutionInSkillDevelopment",profileCreationTrainingPartnerOrganizationDetailsDto.getPriorExperienceOfInstitutionInSkillDevelopment());
			parameters.put("anyPriorExperienceOfInstitutionInSkillTraining",profileCreationTrainingPartnerOrganizationDetailsDto.getAnyPriorExperienceOfInstitutionInSkillTraining());
			//parameters.put("trainingStaffDetailsAnnexurePath",getPaths.get("trainingStaffDetailsAnnexurePath"));
			
			LOGGER.debug("Trying to execute database query to insert organisation level registration data of training partner");
			status = getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getInsertIntoTrainingPartnerOrganizationDetails(),parameters);

		}
		catch(Exception e)
		{
			LOGGER.error("Exception occured during inserting organisation level details of training partner in database,the exception is - "+e);
			
			status = -1;
		}
		return status;
	}
	
	/*
	 * Insert Data in PC TP Center Level Details
	 * will be inserting TPREGID 
	 */
	
	
	
		public int insertIntoTrainingPartnerCenterLevelDetails(ProfileCreationTrainingPartnerCenterDetailsDto profileCreationTrainingPartnerCenterDetailsDto)
		{
			int status =0;
			try{
				LOGGER.info("Trying to construct database query to insert center level registration data of training partner");
				Map<String, Object> parameters=new HashMap<String, Object>();
		
				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerCenterDetailsDto.getTrainingPartnerRegistrationId());
				parameters.put("nameOfCenter",profileCreationTrainingPartnerCenterDetailsDto.getNameOfCenter());
				parameters.put("numberOfPermanentOfficeManager",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfPermanentOfficeManager());
				parameters.put("numberOftemporaryOfficeManager",profileCreationTrainingPartnerCenterDetailsDto.getNumberOftemporaryOfficeManager());
				parameters.put("numberOfPermanentOfficeStaff",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfPermanentOfficeStaff());
				parameters.put("numberOfTemporaryOfficeStaff",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfTemporaryOfficeStaff());
				parameters.put("numberOfPermanentLabAssistants",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfPermanentLabAssistants());
				parameters.put("numberOfTemporaryLabAssistants",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfTemporaryLabAssistants());
				parameters.put("numberOfPermanentAccountants",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfPermanentAccountants());
				parameters.put("numberOfTemporaryAccountants",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfTemporaryAccountants());
				parameters.put("numberOfPermanentSupportStaff",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfPermanentSupportStaff());
				parameters.put("numberOfTemporarySupportStaff",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfTemporarySupportStaff());
				parameters.put("numberOfPermanentOtherEmployees",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfPermanentOtherEmployees());
				parameters.put("numberOfTemporaryOtherEmployees",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfTemporaryOtherEmployees());
				parameters.put("areaOfInstitute",profileCreationTrainingPartnerCenterDetailsDto.getAreaOfInstitute());
				parameters.put("buildingType",profileCreationTrainingPartnerCenterDetailsDto.getBuildingType());
				parameters.put("sizeOfClassrooms",profileCreationTrainingPartnerCenterDetailsDto.getSizeOfClassrooms());
				parameters.put("classroomPicsPath",profileCreationTrainingPartnerCenterDetailsDto.getClassroomPicsPath());
				parameters.put("numberOfClassrooms",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfClassrooms());
				parameters.put("sizeOfLabs",profileCreationTrainingPartnerCenterDetailsDto.getSizeOfLabs());
				parameters.put("labPicsPath",profileCreationTrainingPartnerCenterDetailsDto.getLabPicsPath());
				parameters.put("numberOfLabs",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfLabs());
				parameters.put("sizeOfWorkshops",profileCreationTrainingPartnerCenterDetailsDto.getSizeOfWorkshops());
				parameters.put("workshopPicsPath",profileCreationTrainingPartnerCenterDetailsDto.getWorkshopPicsPath());
				parameters.put("numberOfWorkshops",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfWorkshops());
				parameters.put("mandatoryToolKitpresent",profileCreationTrainingPartnerCenterDetailsDto.getMandatoryToolKitpresent());
				parameters.put("mandatoryToolKitAnnexurePath",profileCreationTrainingPartnerCenterDetailsDto.getMandatoryToolKitAnnexurePath());
				parameters.put("mandatoryToolKitPicsPath",profileCreationTrainingPartnerCenterDetailsDto.getMandatoryToolKitPicsPath());
				parameters.put("safeDrinkingWater",profileCreationTrainingPartnerCenterDetailsDto.getSafeDrinkingWater());
				parameters.put("powerBackup",profileCreationTrainingPartnerCenterDetailsDto.getPowerBackup());
				parameters.put("separateToilets",profileCreationTrainingPartnerCenterDetailsDto.getSeparateToilets());
				parameters.put("transportFacility",profileCreationTrainingPartnerCenterDetailsDto.getTransportFacility());
				parameters.put("presenceOfLibrary",profileCreationTrainingPartnerCenterDetailsDto.getPresenceOfLibrary());
				parameters.put("numberOfTechnicalBooks",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfNonTechnicalBooks());
				parameters.put("numberOfNonTechnicalBooks",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfNonTechnicalBooks());
				parameters.put("numberOfMagazines",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfMagazines());
				parameters.put("numberOfDailies",profileCreationTrainingPartnerCenterDetailsDto.getNumberOfDailies());
				parameters.put("remarksOnInfrastructureDetails",profileCreationTrainingPartnerCenterDetailsDto.getRemarksOnInfrastructureDetails());
				parameters.put("sufficientClassroomIlluminationLevel",profileCreationTrainingPartnerCenterDetailsDto.getSufficientClassroomIlluminationLevel());
				parameters.put("sufficientClassroomVentilationLevel",profileCreationTrainingPartnerCenterDetailsDto.getSufficientClassroomVentilationLevel());
				parameters.put("sufficientCenterCleanliness",profileCreationTrainingPartnerCenterDetailsDto.getSufficientCenterCleanliness());
				parameters.put("centerWeatherProtected",profileCreationTrainingPartnerCenterDetailsDto.getCenterWeatherProtected());
				parameters.put("remarksOnLearningEnviornment",profileCreationTrainingPartnerCenterDetailsDto.getRemarksOnLearningEnviornment());
				parameters.put("printedBrochureOrProspectus",profileCreationTrainingPartnerCenterDetailsDto.getPrintedBrochureOrProspectus());
				parameters.put("documentedPolicyAndProcedures",profileCreationTrainingPartnerCenterDetailsDto.getDocumentedPolicyAndProcedures());
				parameters.put("concessionPolicy",profileCreationTrainingPartnerCenterDetailsDto.getConcessionPolicy());
				parameters.put("safeCustodyOfStudentDocuments",profileCreationTrainingPartnerCenterDetailsDto.getSafeCustodyOfStudentDocuments());
				parameters.put("studentAgreementWithInstitution",profileCreationTrainingPartnerCenterDetailsDto.getStudentAgreementWithInstitution());
				parameters.put("remarksOnStudentAdmissionDetails",profileCreationTrainingPartnerCenterDetailsDto.getRemarksOnStudentAdmissionDetails());
				parameters.put("isActive",profileCreationTrainingPartnerCenterDetailsDto.getIsActive());
				
				LOGGER.debug("Trying to execute database query to insert center level registration data of training partner");
				status = insert(profileCreationTrainingPartnerConfigSql.getInsertIntoTrainingPartnerCenterLevelDetails(),parameters,"trainingPartnerCenterId");
			}
			catch(Exception e)
			{
				LOGGER.error("Exception occured during inserting center level registration data of training partner. The exception is -" + e);
				
				status = -1;
			}
			return status;
		}
	
	
		/*
		 * Insert data in Institute grant Table
		 */
	
		public int insertIntoTrainingPartnerInstituteGrant(ProfileCreationTrainingPartnerInstituteGrantDto profileCreationTrainingPartnerInstituteGrantDto)
		{
			int status = 0;
			try{
				LOGGER.info("Trying to construct database query to insert details of institution grant of training partner");
				Map<String, Object> parameters=new HashMap<String, Object>();
				
				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerInstituteGrantDto.getTrainingPartnerRegistrationId());
				parameters.put("nameOfMinistry",profileCreationTrainingPartnerInstituteGrantDto.getNameOfMinistry());
				parameters.put("natureOfWork",profileCreationTrainingPartnerInstituteGrantDto.getNatureOfWork());
				parameters.put("remarks",profileCreationTrainingPartnerInstituteGrantDto.getRemarks());
				parameters.put("isActive",profileCreationTrainingPartnerInstituteGrantDto.getIsActive());
				
				LOGGER.debug("Trying to execute database query to insert details of institution grant of training partner");
				status = getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getInsertIntoTrainingPartnerInstituteGrant(),parameters);

			}
			catch(Exception e)
			{
				LOGGER.error("Exception occured during insertion of details of institution grant of training partner. The exception is -" + e);
				
				status = -1;
			}
			return status;
		}
	

		/*
		 * Insert data in Institute Recognition Table
		 */
	
		public int insertIntoTrainingPartnerInstituteRecognition(ProfileCreationTrainingPartnerInstituteRecognitionDto profileCreationTrainingPartnerInstituteRecognitionDto)
		{
			int status =0;
			try{
				LOGGER.info("Trying to construct database query to insert details of institution recognition of training partner");
				Map<String, Object> parameters=new HashMap<String, Object>();
				
				/*
				 * Get TPREGID using App Id nd pass it on to This function
				 */
				
				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerInstituteRecognitionDto.getTrainingPartnerRegistrationId());
				parameters.put("nameOfRecognizingBody",profileCreationTrainingPartnerInstituteRecognitionDto.getNameOfRecognizingBody());
				parameters.put("recognitionNumber",profileCreationTrainingPartnerInstituteRecognitionDto.getRecognitionNumber());
				parameters.put("yearOfRecognition",profileCreationTrainingPartnerInstituteRecognitionDto.getYearOfRecognition());
				parameters.put("validityOfRecognition",profileCreationTrainingPartnerInstituteRecognitionDto.getValidityOfRecognition());
				parameters.put("isActive",profileCreationTrainingPartnerInstituteRecognitionDto.getIsActive());
				
				
				LOGGER.debug("Trying to execute database query to insert details of recognitions of training partner");
				status = getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getInsertIntoTrainingPartnerInstituteRecognition(),parameters);

			}
			catch(Exception e)
			{
				LOGGER.error("Execption occured during insertion of details of institution recognition of training partner. The exception is -"+ e);
				
				status = -1;
			}
	return status;
		}
	
	
		/*
		 * Insert data in Training Partner Prior Experience In Skill Training Table
		 */
		
		public int insertIntoTrainingPartnerPriorExperienceInSkillTraining(ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto)
		{
			int status =0;
			try{
				LOGGER.info("Trying to construct database query to insert details of prior experience of training partner");
				Map<String, Object> parameters=new HashMap<String, Object>();
				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getTrainingPartnerRegistrationId());
				parameters.put("courseName",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getCourseName());
				parameters.put("numberOfBatchesPerYear",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getNumberOfBatchesPerYear());
				parameters.put("numberOfStudentsInEachBatch",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getNumberOfStudentsInEachBatch());
				parameters.put("isActive",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getIsActive());
				
				LOGGER.debug("Trying to execute database query to insert details of prior experience of training partner");
				status = getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getInsertIntoTrainingPartnerPriorExperienceInSkillTraining(),parameters);

			}
			catch(Exception e)
			{
				LOGGER.error("Exception occured during insertion of details of prior experience of training partner. The exception is -" + e);
				status = -1;
			}
			return status;
		}
		
		

		/*
		 * Insert data in Training Partner ManagementAndStaffAndOfficialsDetails Table 
		 */
		
		public int insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto)
		{
			int status =0;
			try{
				LOGGER.debug("Trying to construct database query to insert details of management and training staff of training partner");
				Map<String, Object> parameters=new HashMap<String, Object>();

				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getTrainingPartnerRegistrationId());
				parameters.put("trainingPartnerCenterId",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getTrainingPartnerCenterId());
				parameters.put("type",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getType());
				parameters.put("name",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getName());
				parameters.put("designation",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getDesignation());
				parameters.put("emailId",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getEmailId());
				parameters.put("contactNumber",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getContactNumber());
				parameters.put("educationalQualification",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getEducationalQualification());
				parameters.put("regularOrVisiting",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getRegularOrVisiting());
				parameters.put("experience",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getExperience());
				parameters.put("cVPath",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getcVPath());
				parameters.put("certificatePath",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getCertificatePath());
				parameters.put("isActive",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getIsActive());
				
				LOGGER.debug("Trying to execute database query to insert details of management and training staff of training partner and get back the managementAndStaffId");
				
				status = insert(profileCreationTrainingPartnerConfigSql.getInsertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(),parameters, "managementAndStaffId");

			}
			catch(Exception e)
			{
				LOGGER.error("Exception occured during insertion of details of management and training staff of training partner. The exception is" +e);
				status  =-1;
			}
				return status;
		}
		
		
	
}
	
