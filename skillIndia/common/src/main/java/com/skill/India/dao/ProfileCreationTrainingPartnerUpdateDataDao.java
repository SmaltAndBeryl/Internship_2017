package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ProfileCreationTrainingPartnerConfigSql;
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerOrganizationDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;

@Repository
public class ProfileCreationTrainingPartnerUpdateDataDao extends AbstractTransactionalDao{

	@Autowired
	private ProfileCreationTrainingPartnerConfigSql profileCreationTrainingPartnerConfigSql;

	/*
	 * Update into Application table 
	 */
	
	/*public int insertIntoApplication(String type)
	{
		try{
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		Map<String, Object> parameters=new HashMap<String, Object>();
		
		
		 *Getting userId here from session 
		 
		String userId="";
		
		
		if(type.equalsIgnoreCase("SaveAsDraft"))
		{
			parameters.put("applicationState","Draft");
		}
		else if(type.equalsIgnoreCase("Submit"))
		{
		parameters.put("applicationState","Submit");
		}
		parameters.put("userId",userId);
		parameters.put("activeFlag","1");
		parameters.put("dateOfSubmission",date);
		return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getUpdateDataInApplication(), parameters);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	*/
	
	/*
	 * update table Training Partner Organization Details 
	 * 
	 */
	
	public int updateIntoTrainingPartnerOrganizationDetails(ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganizationDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("applicationId",profileCreationTrainingPartnerOrganizationDetailsDto.getApplicationId());
			parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerOrganizationDetailsDto.getTrainingPartnerRegistrationId());
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
			parameters.put("qualificationPacksAnnexurePath",profileCreationTrainingPartnerOrganizationDetailsDto.getQualificationPacksAnnexurePath());
			parameters.put("nSDCFunded",profileCreationTrainingPartnerOrganizationDetailsDto.getnSDCFunded());
			parameters.put("nSDCFundedCertificatePath",profileCreationTrainingPartnerOrganizationDetailsDto.getnSDCFundedCertificatePath());
			parameters.put("mediumOfInstructions",profileCreationTrainingPartnerOrganizationDetailsDto.getMediumOfInstructions());
			parameters.put("selfOwnedInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getSelfOwnedInstitution());
			parameters.put("selfOwnedInstitutionAnnexurePath",profileCreationTrainingPartnerOrganizationDetailsDto.getSelfOwnedInstitutionAnnexurePath());
			parameters.put("franchiseOwnedInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getFranchiseOwnedInstitution());
			parameters.put("franchiseOwnedInstitutionAnnexurePath",profileCreationTrainingPartnerOrganizationDetailsDto.getFranchiseOwnedInstitutionAnnexurePath());
			parameters.put("mobileTrainingInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getMobileTrainingInstitution());
			parameters.put("mobileTrainingInstitutionAnnexurePath",profileCreationTrainingPartnerOrganizationDetailsDto.getMobileTrainingInstitutionAnnexurePath());
			parameters.put("panNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getPanNumber());
			parameters.put("panNumberPath",profileCreationTrainingPartnerOrganizationDetailsDto.getPanNumberPath());
			parameters.put("tanNumber",profileCreationTrainingPartnerOrganizationDetailsDto.getTanNumber());
			parameters.put("tanNumberPath",profileCreationTrainingPartnerOrganizationDetailsDto.getTanNumberPath());
			parameters.put("turnOverOfInstitution",profileCreationTrainingPartnerOrganizationDetailsDto.getTurnOverOfInstitution());
			parameters.put("turnOverOfInstitutionBalanceSheetPath",profileCreationTrainingPartnerOrganizationDetailsDto.getTurnOverOfInstitutionBalanceSheetPath());
			parameters.put("instituteReceivedAnyGrant",profileCreationTrainingPartnerOrganizationDetailsDto.getInstituteReceivedAnyGrant());
			parameters.put("instituteReceivedAnyRecognition",profileCreationTrainingPartnerOrganizationDetailsDto.getInstituteReceivedAnyRecognition());
			parameters.put("priorExperienceOfInstitutionInSkillDevelopment",profileCreationTrainingPartnerOrganizationDetailsDto.getPriorExperienceOfInstitutionInSkillDevelopment());
			parameters.put("anyPriorExperienceOfInstitutionInSkillTraining",profileCreationTrainingPartnerOrganizationDetailsDto.getAnyPriorExperienceOfInstitutionInSkillTraining());
			parameters.put("trainingStaffDetailsAnnexurePath",profileCreationTrainingPartnerOrganizationDetailsDto.getTrainingStaffDetailsAnnexurePath());
			return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getUpdateIntoTrainingPartnerOrganizationDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}

	
	/*
	 * Update Data in PC TP Center Level Details
	 *  will be inserting TPREGID 
	 */
	
	
	
		public int updateIntoTrainingPartnerCenterLevelDetails(ProfileCreationTrainingPartnerCenterDetailsDto profileCreationTrainingPartnerCenterDetailsDto)
		{
			try{
				Map<String, Object> parameters=new HashMap<String, Object>();
				
				/*
				 * Get TPREGID using App Id nd pass it on to This function
				 */
				parameters.put("trainingPartnerCenterId",profileCreationTrainingPartnerCenterDetailsDto.getTrainingPartnerCenterId());
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
				return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getUpdateIntoTrainingPartnerCenterLevelDetails(),parameters);

			}
			catch(Exception e)
			{
				e.printStackTrace();
				return -1;
			}
			
		}
	
		
		/*
		 * Update data in Institute grant Table
		 */
	
		public int updateIntoTrainingPartnerInstituteGrant(ProfileCreationTrainingPartnerInstituteGrantDto profileCreationTrainingPartnerInstituteGrantDto)
		{
			try{
				Map<String, Object> parameters=new HashMap<String, Object>();

				parameters.put("instituteGrantId",profileCreationTrainingPartnerInstituteGrantDto.getInstituteGrantId());
				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerInstituteGrantDto.getTrainingPartnerRegistrationId());
				parameters.put("nameOfMinistry",profileCreationTrainingPartnerInstituteGrantDto.getNameOfMinistry());
				parameters.put("natureOfWork",profileCreationTrainingPartnerInstituteGrantDto.getNatureOfWork());
				parameters.put("remarks",profileCreationTrainingPartnerInstituteGrantDto.getRemarks());
				
				return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getUpdateIntoTrainingPartnerInstituteGrant(),parameters);

			}catch(Exception e)
			{
				e.printStackTrace();
				return -1;
			}
	
		}
	
		
		/*
		 * Update data in Institute Recognition Table
		 */
	
		public int updateIntoTrainingPartnerInstituteRecognition(ProfileCreationTrainingPartnerInstituteRecognitionDto profileCreationTrainingPartnerInstituteRecognitionDto)
		{
			try{
				Map<String, Object> parameters=new HashMap<String, Object>();
				
				parameters.put("instituteRecognitionId", profileCreationTrainingPartnerInstituteRecognitionDto.getInstituteRecognitionId());
				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerInstituteRecognitionDto.getTrainingPartnerRegistrationId());
				parameters.put("nameOfRecognizingBody",profileCreationTrainingPartnerInstituteRecognitionDto.getNameOfRecognizingBody());
				parameters.put("recognitionNumber",profileCreationTrainingPartnerInstituteRecognitionDto.getRecognitionNumber());
				parameters.put("yearOfRecognition",profileCreationTrainingPartnerInstituteRecognitionDto.getYearOfRecognition());
				parameters.put("validityOfRecognition",profileCreationTrainingPartnerInstituteRecognitionDto.getValidityOfRecognition());
				return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getUpdateIntoTrainingPartnerInstituteRecognition(),parameters);

			}catch(Exception e)
			{
				e.printStackTrace();
				return -1;
			}
	
		}
	
	
		/*
		 * Update data in Training Partner Prior Experience In Skill Training Table
		 */
		
		public int updateIntoTrainingPartnerPriorExperienceInSkillTraining(ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto)
		{
			try{
				Map<String, Object> parameters=new HashMap<String, Object>();

				parameters.put("priorExperienceInSkillTrainingId",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getPriorExperienceInSkillTrainingId());
				parameters.put("trainingPartnerRegistrationId",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getTrainingPartnerRegistrationId());
				parameters.put("courseName",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getCourseName());
				parameters.put("numberOfBatchesPerYear",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getNumberOfBatchesPerYear());
				parameters.put("numberOfStudentsInEachBatch",profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.getNumberOfStudentsInEachBatch());
				return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getUpdateIntoTrainingPartnerPriorExperienceInSkillTraining(),parameters);

			}catch(Exception e)
			{
				e.printStackTrace();
				return -1;
			}
	
		}
		
		
		
		

		/*
		 * Update data in Training Partner ManagementAndStaffAndOfficialsDetails Table 
		 */
		
		public int updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto)
		{
			try{
				Map<String, Object> parameters=new HashMap<String, Object>();

				parameters.put("managementAndStaffId",profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.getManagementAndStaffId());
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
				
				return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getUpdateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(),parameters);

			}catch(Exception e)
			{
				e.printStackTrace();
				return -1;
			}
	
		}
	

	
	
}
