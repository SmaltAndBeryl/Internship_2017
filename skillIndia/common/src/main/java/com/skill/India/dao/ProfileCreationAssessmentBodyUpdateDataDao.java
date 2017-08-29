package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

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
public class ProfileCreationAssessmentBodyUpdateDataDao extends AbstractTransactionalDao{

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
			parameters.put("panNumberPath",profileCreationAssessmentBodyRegistrationDetailsDto.getPanNumberPath());
			parameters.put("tanNumber",profileCreationAssessmentBodyRegistrationDetailsDto.getTanNumber());
			parameters.put("tanNumberPath",profileCreationAssessmentBodyRegistrationDetailsDto.getTanNumberPath());
			parameters.put("insituteReceivedAnyRecognition",profileCreationAssessmentBodyRegistrationDetailsDto.getInsituteReceivedAnyRecognition());	
			parameters.put("numberOfTechnicalAssessors",profileCreationAssessmentBodyRegistrationDetailsDto.getNumberOfTechnicalAssessors());
			parameters.put("numberOfNonTechnicalAssessors",profileCreationAssessmentBodyRegistrationDetailsDto.getNumberOfNonTechnicalAssessors());
			parameters.put("affiliatedToAnySectorSkillCouncil",profileCreationAssessmentBodyRegistrationDetailsDto.getAffiliatedToAnySectorSkillCouncil());
			
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyRegistrationDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	/*
	 * Updating data in Assessment Body Registration Details
	 */
	
	public int updateIntoAssessmentBodyRecognitions(ProfileCreationAssessmentBodyRecognitionsDto profileCreationAssessmentBodyRecognitionsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentBodyRecognitionId",profileCreationAssessmentBodyRecognitionsDto.getAssessmentBodyRecognitionId());
			parameters.put("nameOfRecognitionBody",profileCreationAssessmentBodyRecognitionsDto.getNameOfRecognitionBody());
			parameters.put("recognitionNumber",profileCreationAssessmentBodyRecognitionsDto.getRecognitionNumber());
			parameters.put("yearOfRecognition",profileCreationAssessmentBodyRecognitionsDto.getValidityOfRecognition());
			parameters.put("validityOfRecognition",profileCreationAssessmentBodyRecognitionsDto.getYearOfRecognition());
						
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyRecognitions(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/*
	 *Updating data in table  AssessmentsExperienceInTechnicalDomain
	 */
	
	public int updateIntoAssessmentsExperienceInTechnicalDomain(ProfileCreationAssessmentsExperienceInTechnicalDomainDto profileCreationAssessmentsExperienceInTechnicalDomainDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("assessmentExperienceId",profileCreationAssessmentsExperienceInTechnicalDomainDto.getAssessmentExperienceId());
			parameters.put("domain",profileCreationAssessmentsExperienceInTechnicalDomainDto.getDomain());
			parameters.put("numberOfAssessmentsDone",profileCreationAssessmentsExperienceInTechnicalDomainDto.getNumberOfAssessmentsDone());			
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentsExperienceInTechnicalDomain(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/*
	 * Updating data in table  AssessmentBodyDirectorsAndManagementTeamDetails
	 */
	
	public int updateIntoAssessmentBodyDirectorsAndManagementTeamDetails(ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto)
	{
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
			
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyDirectorsAndManagementTeamDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/*
	 * Updating data in table AssessmentStaffDetails
	 */
	
	public int updateIntoAssessmentStaffDetails(ProfileCreationAssessmentStaffDetailsDto profileCreationAssessmentStaffDetailsDto)
	{
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
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentStaffDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Updating data in table AssessmentBodyRegionalOfficeDetails
	 */
	
	public int updateIntoAssessmentBodyRegionalOfficeDetails(ProfileCreationAssessmentBodyRegionalOfficeDetailsDto profileCreationAssessmentBodyRegionalOfficeDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("regionalOfficeId",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getRegionalOfficeId());
			parameters.put("address",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAddress());
			parameters.put("state",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getState());
			parameters.put("pincode",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getPincode());
			parameters.put("contactNumber",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getContactNumber());
			parameters.put("alternateContactNumber",profileCreationAssessmentBodyRegionalOfficeDetailsDto.getAlternateContactNumber());
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyRegionalOfficeDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Updating data in table AssessmentBodyAffiliationDetails
	 */
	
	public int updateIntoAssessmentBodyAffiliationDetails(ProfileCreationAssessmentBodyAffiliationDetailsDto profileCreationAssessmentBodyAffiliationDetailsDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			
			parameters.put("affiliationId",profileCreationAssessmentBodyAffiliationDetailsDto.getAffiliationId());
			parameters.put("nameOfSectorSkillCouncil",profileCreationAssessmentBodyAffiliationDetailsDto.getNameOfSectorSkillCouncil());
			return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getUpdateIntoAssessmentBodyAffiliationDetails(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	 

}
