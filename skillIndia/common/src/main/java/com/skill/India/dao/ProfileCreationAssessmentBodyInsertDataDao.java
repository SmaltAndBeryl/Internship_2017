package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
public class ProfileCreationAssessmentBodyInsertDataDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationAssessmentBodyInsertDataDao.class);
	
	@Autowired
	private ProfileCreationAssessmentBodyConfigSql profileCreationAssessmentBodyConfigSql;
	
	
	/*
	 * Inserting data in Assessment Body Registration Details
	 */
	
	public int insertIntoAssessmentBodyRegistrationDetails(ProfileCreationAssessmentBodyRegistrationDetailsDto profileCreationAssessmentBodyRegistrationDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("applicationId",profileCreationAssessmentBodyRegistrationDetailsDto.getApplicationId());
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
			//parameters.put("panNumberPath",getPaths.get("panNumberPath"));
			parameters.put("tanNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getTanNumber());
			//parameters.put("tanNumberPath",getPaths.get("tanNumberPath"));
			parameters.put("insituteReceivedAnyRecognition",profileCreationAssessmentBodyRegistrationDetailsDto.getInsituteReceivedAnyRecognition());	
			parameters.put("numberOfTechnicalAssessors",profileCreationAssessmentBodyRegistrationDetailsDto.getNumberOfTechnicalAssessors());
			parameters.put("numberOfNonTechnicalAssessors",profileCreationAssessmentBodyRegistrationDetailsDto.getNumberOfNonTechnicalAssessors());
			parameters.put("affiliatedToAnySectorSkillCouncil",profileCreationAssessmentBodyRegistrationDetailsDto.getAffiliatedToAnySectorSkillCouncil());
			
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getInsertIntoAssessmentBodyRegistrationDetails(),parameters);

		}catch(Exception e)
		{
			LOGGER.error("An Exception occured " + e);
			return -1;
		}
		
	}
	
	
	/*
	 * Inserting data in Assessment Body Registration Details
	 */
	
	public int insertIntoAssessmentBodyRecognitions(ProfileCreationAssessmentBodyRecognitionsDto profileCreationAssessmentBodyRecognitionsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentBodyRecognitionsDto.getAssessmentBodyRegistrationId());
			parameters.put("nameOfRecognitionBody",profileCreationAssessmentBodyRecognitionsDto.getNameOfRecognitionBody());
			parameters.put("recognitionNumber",profileCreationAssessmentBodyRecognitionsDto.getRecognitionNumber());
			parameters.put("yearOfRecognition",profileCreationAssessmentBodyRecognitionsDto.getValidityOfRecognition());
			parameters.put("validityOfRecognition",profileCreationAssessmentBodyRecognitionsDto.getYearOfRecognition());
						
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getInsertIntoAssessmentBodyRecognitions(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/*
	 *Inserting data in table  AssessmentsExperienceInTechnicalDomain
	 */
	
	public int insertIntoAssessmentsExperienceInTechnicalDomain(ProfileCreationAssessmentsExperienceInTechnicalDomainDto profileCreationAssessmentsExperienceInTechnicalDomainDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentsExperienceInTechnicalDomainDto.getAssessmentBodyRegistrationId());
			parameters.put("domain",profileCreationAssessmentsExperienceInTechnicalDomainDto.getDomain());
			parameters.put("numberOfAssessmentsDone",profileCreationAssessmentsExperienceInTechnicalDomainDto.getNumberOfAssessmentsDone());			
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getInsertIntoAssessmentsExperienceInTechnicalDomain(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/*
	 * Inserting data in table  AssessmentBodyDirectorsAndManagementTeamDetails
	 */
	
	public int insertIntoAssessmentBodyDirectorsAndManagementTeamDetails(ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getAssessmentBodyRegistrationId());
			parameters.put("name",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getName());
			parameters.put("designation",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getDesignation());
			parameters.put("contactNumber",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getContactNumber());
			parameters.put("emailId",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getEmailId());
			parameters.put("educationalQualification",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getEducationalQualification());
			parameters.put("experience",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getExperience());
			parameters.put("cVPath",profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.getcVPath());
			
			return insert(profileCreationAssessmentBodyConfigSql.getInsertIntoAssessmentBodyDirectorsAndManagementTeamDetails(),parameters, "directorsAndManagementId");
		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	/*
	 * Inserting data in table AssessmentStaffDetails
	 */
	
	public int insertIntoAssessmentStaffDetails(ProfileCreationAssessmentStaffDetailsDto profileCreationAssessmentStaffDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentStaffDetailsDto.getAssessmentBodyRegistrationId());
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
			
			return insert(profileCreationAssessmentBodyConfigSql.getInsertIntoAssessmentStaffDetails(),parameters, "assessmentStaffId");
		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	
	/*
	 * Inserting data in table AssessmentBodyRegionalOfficeDetails
	 */
	
	public int insertIntoAssessmentBodyRegionalOfficeDetails(ProfileCreationAssessmentBodyRegionalOfficeDetailsDto profileCreationAssessmentBodyRegionalOfficeDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAssessmentBodyRegistrationId());
			parameters.put("address",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAddress());
			parameters.put("state",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getState());
			parameters.put("pincode",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getPincode());
			parameters.put("contactNumber",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getContactNumber());
			parameters.put("alternateContactNumber",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAlternateContactNumber());
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getInsertIntoAssessmentBodyRegionalOfficeDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Inserting data in table AssessmentBodyAffiliationDetails
	 */
	
	public int insertIntoAssessmentBodyAffiliationDetails(ProfileCreationAssessmentBodyAffiliationDetailsDto profileCreationAssessmentBodyAffiliationDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRegistrationId",profileCreationAssessmentBodyAffiliationDetailsDto.getAssessmentBodyRegistrationId());
			parameters.put("nameOfSectorSkillCouncil",profileCreationAssessmentBodyAffiliationDetailsDto.getNameOfSectorSkillCouncil());
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getInsertIntoAssessmentBodyAffiliationDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	
}
