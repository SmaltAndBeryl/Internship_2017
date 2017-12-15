package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ProfileCreationAssessmentBodyConfigSql;
import com.skill.India.dto.ProfileCreationAssessmentBodyAffiliationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegionalOfficeDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegistrationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;

@Repository
public class ProfileCreationAssessmentBodyUpdateDataDao extends AbstractTransactionalDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationAssessmentBodyUpdateDataDao.class);
	
	@Autowired
	private ProfileCreationAssessmentBodyConfigSql profileCreationAssessmentBodyConfigSql;
	
	/*
	 * Updating data in Assessment Body Registration Details
	 */
	
	public int updateIntoAssessmentBodyRegistrationDetails(ProfileCreationAssessmentBodyRegistrationDetailsDto profileCreationAssessmentBodyRegistrationDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentBodyRegistrationDetailsDto.getAssessmentBodyRegistrationId());
			parameters.put("organizationName",profileCreationAssessmentBodyRegistrationDetailsDto.getOrganizationName());
			parameters.put("sPOCName",profileCreationAssessmentBodyRegistrationDetailsDto.getsPOCName());
			parameters.put("address",profileCreationAssessmentBodyRegistrationDetailsDto.getAddress());
			parameters.put("city",profileCreationAssessmentBodyRegistrationDetailsDto.getCity());
			parameters.put("state",profileCreationAssessmentBodyRegistrationDetailsDto.getState());
			parameters.put("pincode",profileCreationAssessmentBodyRegistrationDetailsDto.getPincode());
		    parameters.put("mobileNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getMobileNumber());
			parameters.put("alternateMobileNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getAlternateMobileNumber());			
			parameters.put("landlineNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getLandlineNumber());
			parameters.put("alternateLandlineNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getAlternateLandlineNumber());
			parameters.put("faxNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getFaxNumber());
			parameters.put("websites",profileCreationAssessmentBodyRegistrationDetailsDto.getWebsites());
			parameters.put("yearOfEstablishment",profileCreationAssessmentBodyRegistrationDetailsDto.getYearOfEstablishment());
			parameters.put("priorAssessmentExperience",profileCreationAssessmentBodyRegistrationDetailsDto.getPriorAssessmentExperience());
			parameters.put("panNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getPanNumber());
			//parameters.put("panNumberPath",profileCreationAssessmentBodyRegistrationDetailsDto.getPanNumberPath());
			parameters.put("tanNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getTanNumber());
			//parameters.put("tanNumberPath",profileCreationAssessmentBodyRegistrationDetailsDto.getTanNumberPath());
			parameters.put("insituteReceivedAnyRecognition",profileCreationAssessmentBodyRegistrationDetailsDto.getInsituteReceivedAnyRecognition());	
			parameters.put("numberOfTechnicalAssessors",profileCreationAssessmentBodyRegistrationDetailsDto.getNumberOfTechnicalAssessors());
			parameters.put("numberOfNonTechnicalAssessors",profileCreationAssessmentBodyRegistrationDetailsDto.getNumberOfNonTechnicalAssessors());
			parameters.put("affiliatedToAnySectorSkillCouncil",profileCreationAssessmentBodyRegistrationDetailsDto.getAffiliatedToAnySectorSkillCouncil());
			
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyRegistrationDetails(),parameters);

		}catch(Exception e)
		{
			LOGGER.error("An Exception occured while updating Assessment body registration details " + e);
			return -1;
		}
		
	}
	
	
	/*
	 * Updating data in Assessment Body Registration Details
	 */
	
	public int updateIntoAssessmentBodyRecognitions(ProfileCreationAssessmentBodyRecognitionsDto profileCreationAssessmentBodyRecognitionsDto)
	{
		int status = 0;
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRecognitionId",profileCreationAssessmentBodyRecognitionsDto.getAssessmentBodyRecognitionId());
			parameters.put("nameOfRecognitionBody",profileCreationAssessmentBodyRecognitionsDto.getNameOfRecognitionBody());
			parameters.put("recognitionNumber",profileCreationAssessmentBodyRecognitionsDto.getRecognitionNumber());
			parameters.put("yearOfRecognition",profileCreationAssessmentBodyRecognitionsDto.getValidityOfRecognition());
			parameters.put("validityOfRecognition",profileCreationAssessmentBodyRecognitionsDto.getYearOfRecognition());
			parameters.put("isActive",profileCreationAssessmentBodyRecognitionsDto.getIsActive());
			parameters.put("assessmentBodyRegistrationId", profileCreationAssessmentBodyRecognitionsDto.getAssessmentBodyRegistrationId());
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyRecognitions(),parameters);

		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while updating recognitions" + e);
			status = -1;
		}
		return status;
	}
	
	/*
	 *Updating data in table  AssessmentsExperienceInTechnicalDomain
	 */
	
	public int updateIntoAssessmentsExperienceInTechnicalDomain(ProfileCreationAssessmentsExperienceInTechnicalDomainDto profileCreationAssessmentsExperienceInTechnicalDomainDto)
	{
		int status = 0;
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentExperienceId",profileCreationAssessmentsExperienceInTechnicalDomainDto.getAssessmentExperienceId());
			parameters.put("domain",profileCreationAssessmentsExperienceInTechnicalDomainDto.getDomain());
			parameters.put("numberOfAssessmentsDone",profileCreationAssessmentsExperienceInTechnicalDomainDto.getNumberOfAssessmentsDone());
			parameters.put("isActive", profileCreationAssessmentsExperienceInTechnicalDomainDto.getIsActive());
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentsExperienceInTechnicalDomain(),parameters);

		}catch(Exception e)
		{
			LOGGER.error("An exception occured while updating experience of assessment body " + e);
			status = -1;
		}
		return status;
	}
	
	/*
	 * Updating data in table  AssessmentBodyDirectorsAndManagementTeamDetails
	 */
	
	public int updateIntoAssessmentBodyDirectorsAndManagementTeamDetails(ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto)
	{
		int status = 0;
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("directorsAndManagementId",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getDirectorsAndManagementId());
			parameters.put("name",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getName());
			parameters.put("designation",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getDesignation());
			parameters.put("contactNumber",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getContactNumber());
			parameters.put("emailId",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getEmailId());
			parameters.put("educationalQualification",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getEducationalQualification());
			parameters.put("experience",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getExperience());
			parameters.put("cVPath",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getcVPath());
			parameters.put("isActive",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getIsActive());
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyDirectorsAndManagementTeamDetails(),parameters);
		}
		catch(Exception e)
		{
			LOGGER.error("An Exception Occured while updating directors and management staff details of Assessmnet body " +e);
			status = -1;
			
		}
		return status;
	}
	
	/*
	 * Updating data in table AssessmentStaffDetails
	 */
	
	public int updateIntoAssessmentStaffDetails(ProfileCreationAssessmentStaffDetailsDto profileCreationAssessmentStaffDetailsDto)
	{
		int status = 0;
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentStaffId",profileCreationAssessmentStaffDetailsDto.getAssessmentStaffId());
			parameters.put("name",profileCreationAssessmentStaffDetailsDto.getName());
			parameters.put("jobRoleCode",profileCreationAssessmentStaffDetailsDto.getJobRoleCode());
			parameters.put("designation",profileCreationAssessmentStaffDetailsDto.getDesignation());
			parameters.put("contactNumber",profileCreationAssessmentStaffDetailsDto.getContactNumber());
			parameters.put("emailId",profileCreationAssessmentStaffDetailsDto.getEmailId());
			parameters.put("state",profileCreationAssessmentStaffDetailsDto.getState());
			parameters.put("city",profileCreationAssessmentStaffDetailsDto.getCity());
			parameters.put("educationalQualification",profileCreationAssessmentStaffDetailsDto.getEducationalQualification());
			parameters.put("experience",profileCreationAssessmentStaffDetailsDto.getExperience());
			parameters.put("cVPath",profileCreationAssessmentStaffDetailsDto.getcVPath());
			parameters.put("certificatePath",profileCreationAssessmentStaffDetailsDto.getCertificatePath());
			parameters.put("isActive",profileCreationAssessmentStaffDetailsDto.getIsActive());
			
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentStaffDetails(),parameters);

		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while updating Assessment Body Staff" + e);
			status = -1;
		}
		return status;
	}
	
	/*
	 * Updating data in table AssessmentBodyRegionalOfficeDetails
	 */
	
	public int updateIntoAssessmentBodyRegionalOfficeDetails(ProfileCreationAssessmentBodyRegionalOfficeDetailsDto profileCreationAssessmentBodyRegionalOfficeDetailsDto)
	{
		int status =0;
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("regionalOfficeId",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getRegionalOfficeId());
			parameters.put("address",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAddress());
			parameters.put("state",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getState());
			parameters.put("pincode",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getPincode());
			parameters.put("contactNumber",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getContactNumber());
			parameters.put("alternateContactNumber",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAlternateContactNumber());
			parameters.put("assessmentBodyRegistrationId", profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAssessmentBodyRegistrationId());
			parameters.put("isActive", profileCreationAssessmentBodyRegionalOfficeDetailsDto.getIsActive());
			LOGGER.info("These are the parametrs " + parameters);
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyRegionalOfficeDetails(),parameters);
			
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured "+ e);
			status = -1;
		}
		return status;
	}
	
	/*
	 * Updating data in table AssessmentBodyAffiliationDetails
	 */
	
	public int updateIntoAssessmentBodyAffiliationDetails(ProfileCreationAssessmentBodyAffiliationDetailsDto profileCreationAssessmentBodyAffiliationDetailsDto)
	{
		int status = 0;
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("affiliationId",profileCreationAssessmentBodyAffiliationDetailsDto.getAffiliationId());
			parameters.put("nameOfSectorSkillCouncil",profileCreationAssessmentBodyAffiliationDetailsDto.getNameOfSectorSkillCouncil());
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentBodyAffiliationDetailsDto.getAssessmentBodyRegistrationId());
			parameters.put("isActive",profileCreationAssessmentBodyAffiliationDetailsDto.getIsActive());
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyAffiliationDetails(),parameters);

		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while updating affiliation of assessment body" + e);
			status  =-1;
		}
		return status;
	}
	 
	
	/*
	 * Updating paths in table AssessmentBodyDirectorsAndManagementTeamDetails
	 */
	
	public int updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails(HashMap<String, String> setPaths,int directorsAndManagementId)
	{
		try{
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cVPath", setPaths.get("cVPath"));
		parameters.put("directorsAndManagementId", String.valueOf(directorsAndManagementId));
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails(), parameters);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updatePanPath(String panPath, int applicationId)
	{
		int status = 0;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("panNumberPath" , panPath);
			parameters.put("applicationId" , applicationId);
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getPanPath(), parameters);
			LOGGER.debug("Value of status in panNumber update " + status);
		}
		catch(Exception e)
		{
			status = -2;
			LOGGER.error("An exception occured while updating pan path of training partner " + e);
		}
		return status;
	}
	
	/*Update Tan Number path*/
	public int updateTanPath(String tanPath, int applicationId)
	{
		int status = 0;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("tanNumberPath" , tanPath);
			parameters.put("applicationId" , applicationId);
			status = getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getTanPathUpdate(), parameters);
			LOGGER.debug("Value of status in panNumber update " + status);
		}
		catch(Exception e)
		{
			status = -2;
			LOGGER.error("An exception occured while updating tan path of training partner " + e);
		}
		return status;
	}
	
	/*
	 * Updating paths in table AssessmentStaff Cv
	 */
	
	public int updatePathAssessmentStaffCv(String pathToBeUpdated, String assessmentBodyId)
	{
		try{
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cVPath", pathToBeUpdated);
		parameters.put("assessmentBodyRegistrationId", assessmentBodyId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdatePathsIntoAssessmentStaffDetails(), parameters);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while updating Assessmnet staff cv path in database " + e);
			return -1;
		}
	}
	
	/*
	 * Updating paths in table Assessment Body Management Cv
	 */
	
	public int updatePathAssessmentManagementCv(String pathToBeUpdated, String assessmentBodyId)
	{
		try{
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cVPath", pathToBeUpdated);
		parameters.put("assessmentBodyRegistrationId", assessmentBodyId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateAssessmentManagementCvPath(), parameters);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while updating Assessmnet staff cv path in database " + e);
			return -1;
		}
	}
	
	/*
	 * Updating paths in table Assessment Staff Education certificate
	 */
	
	public int updatePathAssessmentStaffEducationCertificate(String pathToBeUpdated, String assessmentBodyId)
	{
		try{
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("educationalQualification", pathToBeUpdated);
		parameters.put("assessmentBodyRegistrationId", assessmentBodyId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateAssessmentStaffEducationCertificatePath(), parameters);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while updating Assessmnet staff cv path in database " + e);
			return -1;
		}
	}
	

}
