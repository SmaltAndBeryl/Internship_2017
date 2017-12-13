package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.config.ProfileCreationAssessmentBodyConfigSql;
import com.skill.India.dto.ProfileCreationAssessmentBodyAffiliationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegionalOfficeDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegistrationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;

@Repository
public class ProfileCreationAssessmentBodyGetDataDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationAssessmentBodyGetDataDao.class);
	@Autowired
	private ProfileCreationAssessmentBodyConfigSql profileCreationAssessmentBodyConfigSql;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	/*
	 * Get AssessmentBody Registration Id using ApplicationId  
	 */
	
	public String profileCreationGetAssessmentBodyRegistrationIdUsingApplicationId(int applicationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("applicationId",applicationId);
		return getJdbcTemplate().queryForObject(profileCreationAssessmentBodyConfigSql.getGetAssessmentBodyRegistrationIdUsingApplicationId(), parameters, String.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.debug("Assessment Body registartion Id does not exists");
			return "-1";
		}
		catch(Exception e)
		{
			LOGGER.error("An xception occured "+ e);
			return null;
		}
 	}
	


	/*
	 * Getting data from table 1 ProfileCreationAssessmentBodyRegistrationDetails 
	 */
	
private static final ProfileCreationAssessmentBodyRegistrationDetailsRowMapper ROW_MAPPER_ABREGDETAILS = new ProfileCreationAssessmentBodyRegistrationDetailsRowMapper();
	
	public Collection<ProfileCreationAssessmentBodyRegistrationDetailsDto> profileCreationGetDataFromAssessmentBodyRegistrationDetails(int applicationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("applicationId",applicationId);
		return getJdbcTemplate().query(profileCreationAssessmentBodyConfigSql.getGetDataFromAssessmentBodyRegistrationDetails(),parameters,ROW_MAPPER_ABREGDETAILS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	
	public static class ProfileCreationAssessmentBodyRegistrationDetailsRowMapper implements RowMapper<ProfileCreationAssessmentBodyRegistrationDetailsDto> {

		@Override
		public ProfileCreationAssessmentBodyRegistrationDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");
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
			String priorAssessmentExperience = resultSet.getString("priorAssessmentExperience");
			String panNumber = resultSet.getString("panNumber");
			String panNumberPath = resultSet.getString("panNumberPath");
			String tanNumber = resultSet.getString("tanNumber");
			String tanNumberPath = resultSet.getString("tanNumberPath");
			String insituteReceivedAnyRecognition = resultSet.getString("insituteReceivedAnyRecognition");
			String numberOfTechnicalAssessors = resultSet.getString("numberOfTechnicalAssessors");
			String numberOfNonTechnicalAssessors = resultSet.getString("numberOfNonTechnicalAssessors");
			String affiliatedToAnySectorSkillCouncil=resultSet.getString("affiliatedToAnySectorSkillCouncil");
			return new ProfileCreationAssessmentBodyRegistrationDetailsDto(assessmentBodyRegistrationId,applicationId,organizationName,sPOCName,address,city,state,pincode,mobileNumber,
				alternateMobileNumber,landlineNumber,alternateLandlineNumber,faxNumber,websites,yearOfEstablishment,priorAssessmentExperience,panNumber,panNumberPath,tanNumber,tanNumberPath,
				insituteReceivedAnyRecognition,numberOfTechnicalAssessors,numberOfNonTechnicalAssessors,affiliatedToAnySectorSkillCouncil);
		}

}

	/*
	 * Getting data from table 2 ProfileCreationAssessmentBodyRecognitions 
	 */
	
	private static final ProfileCreationAssessmentBodyRecognitionsRowMapper ROW_MAPPER_ABRECOGNITIONS = new ProfileCreationAssessmentBodyRecognitionsRowMapper();
	
	public Collection<ProfileCreationAssessmentBodyRecognitionsDto> profileCreationGetDataFromAssessmentBodyRecognitions(String assessmentBodyRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
		return getJdbcTemplate().query(profileCreationAssessmentBodyConfigSql.getGetDataFromAssessmentBodyRecognitions(),parameters,ROW_MAPPER_ABRECOGNITIONS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	
	public static class ProfileCreationAssessmentBodyRecognitionsRowMapper implements RowMapper<ProfileCreationAssessmentBodyRecognitionsDto> {

		@Override
		public ProfileCreationAssessmentBodyRecognitionsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {

			String assessmentBodyRecognitionId = resultSet.getString("assessmentBodyRecognitionId");
			String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");
			String nameOfRecognitionBody = resultSet.getString("nameOfRecognitionBody");
			String recognitionNumber = resultSet.getString("recognitionNumber");
			String yearOfRecognition = resultSet.getString("yearOfRecognition");
			String validityOfRecognition = resultSet.getString("validityOfRecognition");
			Boolean isActive = resultSet.getBoolean("isActive");
				return new ProfileCreationAssessmentBodyRecognitionsDto(assessmentBodyRecognitionId,assessmentBodyRegistrationId,nameOfRecognitionBody,
						recognitionNumber,yearOfRecognition,validityOfRecognition, isActive);
		}

}
	
	
	/*
	 * Getting data from table 3 ProfileCreationAssessmentsExperienceInTechnicalDomain 
	 */
	
	private static final ProfileCreationAssessmentsExperienceInTechnicalDomainRowMapper ROW_MAPPER_ABASSESSMENTSEXP = new ProfileCreationAssessmentsExperienceInTechnicalDomainRowMapper();
	
	public Collection<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> profileCreationGetDataFromAssessmentsExperienceInTechnicalDomain(String assessmentBodyRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
		return getJdbcTemplate().query(profileCreationAssessmentBodyConfigSql.getGetDataFromAssessmentsExperienceInTechnicalDomain(),parameters,ROW_MAPPER_ABASSESSMENTSEXP);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	
	public static class ProfileCreationAssessmentsExperienceInTechnicalDomainRowMapper implements RowMapper<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> {

		@Override
		public ProfileCreationAssessmentsExperienceInTechnicalDomainDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {

			String assessmentExperienceId = resultSet.getString("assessmentExperienceId");
			String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");
			String domain = resultSet.getString("domain");
			String numberOfAssessmentsDone = resultSet.getString("numberOfAssessmentsDone");
			Boolean isActive = resultSet.getBoolean("isActive");
				return new ProfileCreationAssessmentsExperienceInTechnicalDomainDto(assessmentExperienceId,assessmentBodyRegistrationId,
						domain,numberOfAssessmentsDone, isActive);
		}

}

	/*
	 * Getting data from table 4 ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetails 
	 */
	
private static final ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsRowMapper ROW_MAPPER_ABTEAMDETAILS = new ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsRowMapper();
	
	public Collection<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> profileCreationGetDataFromAssessmentBodyDirectorsAndManagementTeamDetails(String assessmentBodyRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
		return getJdbcTemplate().query(profileCreationAssessmentBodyConfigSql.getGetDataFromAssessmentBodyDirectorsAndManagementTeamDetails(),parameters,ROW_MAPPER_ABTEAMDETAILS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	
	public static class ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsRowMapper implements RowMapper<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> {

		@Override
		public ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {

			String directorsAndManagementId = resultSet.getString("directorsAndManagementId");
			String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");
			String name = resultSet.getString("name");
			String designation = resultSet.getString("designation");
			String contactNumber = resultSet.getString("contactNumber");
			String emailId = resultSet.getString("emailId");
			String educationalQualification = resultSet.getString("educationalQualification");
			String experience = resultSet.getString("experience");
			String cVPath = resultSet.getString("cVPath");
			Boolean isActive = resultSet.getBoolean("isActive");
				return new ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto(directorsAndManagementId,assessmentBodyRegistrationId,
						name,designation,contactNumber,emailId,educationalQualification,experience,cVPath, isActive);
		}

}
	
	/*
	 * Getting data from table 5  AssessmentStaffDetails
	 */
	
private static final ProfileCreationAssessmentStaffDetailsRowMapper ROW_MAPPER_ABSTAFFDETAILS = new ProfileCreationAssessmentStaffDetailsRowMapper();
	
	public Collection<ProfileCreationAssessmentStaffDetailsDto> profileCreationGetDataFromAssessmentStaffDetails(String assessmentBodyRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
		return getJdbcTemplate().query(profileCreationAssessmentBodyConfigSql.getGetDataFromAssessmentStaffDetails(),parameters,ROW_MAPPER_ABSTAFFDETAILS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	
	public static class ProfileCreationAssessmentStaffDetailsRowMapper implements RowMapper<ProfileCreationAssessmentStaffDetailsDto> {

		@Override
		public ProfileCreationAssessmentStaffDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {

			String assessmentStaffId = resultSet.getString("assessmentStaffId");
			String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");
			String name = resultSet.getString("name");
			String jobRoleCode = resultSet.getString("jobRoleCode");
			String designation = resultSet.getString("designation");
			String contactNumber = resultSet.getString("contactNumber");
			String emailId = resultSet.getString("emailId");
			String state = resultSet.getString("state");
			String city = resultSet.getString("city");
			String educationalQualification = resultSet.getString("educationalQualification");
			String experience = resultSet.getString("experience");
			String cVPath = resultSet.getString("cVPath");
			String certificatePath = resultSet.getString("certificatePath");
			Boolean isActive = resultSet.getBoolean("isActive");
				return new ProfileCreationAssessmentStaffDetailsDto(assessmentStaffId,assessmentBodyRegistrationId,
						name,jobRoleCode,designation,contactNumber,emailId,state,city,educationalQualification,
						experience,cVPath,certificatePath, isActive);
		}

}



	/*
	 * Getting data from table 6  AssessmentBodyRegionalOfficeDetails
	 */
	
private static final ProfileCreationAssessmentBodyRegionalOfficeDetailsRowMapper ROW_MAPPER_ABREGIONALOFFICEDETAILS = new ProfileCreationAssessmentBodyRegionalOfficeDetailsRowMapper();
	
	public Collection<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> profileCreationGetDataFromAssessmentBodyRegionalOfficeDetails(String assessmentBodyRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
		return getJdbcTemplate().query(profileCreationAssessmentBodyConfigSql.getGetDataFromAssessmentBodyRegionalOfficeDetails(),parameters,ROW_MAPPER_ABREGIONALOFFICEDETAILS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	
	public static class ProfileCreationAssessmentBodyRegionalOfficeDetailsRowMapper implements RowMapper<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> {

		@Override
		public ProfileCreationAssessmentBodyRegionalOfficeDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {

			String regionalOfficeId = resultSet.getString("regionalOfficeId");
			String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");
			String address = resultSet.getString("address");
			String state = resultSet.getString("state");
			String pincode = resultSet.getString("pincode");
			String contactNumber = resultSet.getString("contactNumber");
			String alternateContactNumber = resultSet.getString("alternateContactNumber");
			Boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationAssessmentBodyRegionalOfficeDetailsDto(regionalOfficeId,assessmentBodyRegistrationId,
					address,state,pincode,contactNumber,alternateContactNumber, isActive);
		}

}
	
	/*
	 * Getting data from table 7  AssessmentBodyAffiliationDetails
	 */
	
private static final ProfileCreationAssessmentBodyAffiliationDetailsRowMapper ROW_MAPPER_ABAFFILIATIONDETAILS = new ProfileCreationAssessmentBodyAffiliationDetailsRowMapper();
	
	public Collection<ProfileCreationAssessmentBodyAffiliationDetailsDto> profileCreationGetDataFromAssessmentBodyAffiliationDetails(String assessmentBodyRegistrationId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
		return getJdbcTemplate().query(profileCreationAssessmentBodyConfigSql.getGetDataFromAssessmentBodyAffiliationDetails(),parameters,ROW_MAPPER_ABAFFILIATIONDETAILS);
		}
		catch(Exception e)
		{
			LOGGER.error("An Exception occured" + e);
			return null;
		}
 	}
	
	
	/* To check presence of Affiliation data of Assessment body*/
	public int isAffiliationPresent(String assessmentBodyRegistrationId, String nameOfSectorSkillCouncil)
	{
		int status = 0;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("assessmentBodyRegistrationId", assessmentBodyRegistrationId);
			parameters.put("nameOfSectorSkillCouncil", nameOfSectorSkillCouncil);
			status =  getJdbcTemplate().queryForObject(profileCreationAssessmentBodyConfigSql.getIsAffiliationPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("An excpetion occured " +e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured " +e);
			status = -2;
		}
		
		return status;
	}
	/*
	 * IF Assessment body management is present */
	public int isManagementPresent(String assessmentBodyRegistrationId, String email)
	{
		int status = 0;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("assessmentBodyRegistrationId", assessmentBodyRegistrationId);
			parameters.put("emailId", email);
			status =  getJdbcTemplate().queryForObject(profileCreationAssessmentBodyConfigSql.getIsManagementPresent(), parameters, Integer.class);
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
	
	/*
	 * */
	public int isRecognitionPresent(String assessmentBodyRegistrationId, String nameOfRecognizingBody)
	{
		int status = 0;
		try
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("assessmentBodyRegistrationId", assessmentBodyRegistrationId);
			parameters.put("nameOfRecognitionBody", nameOfRecognizingBody);
			status =  getJdbcTemplate().queryForObject(profileCreationAssessmentBodyConfigSql.getIsRecognitionPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Could not find value of recogniton details " +e);
			status = -1;
		}
		catch (Exception e)
		{
			LOGGER.error("An excpetion occured " +e);
			status = -2;
		}
		return status;
	}
	
	/*
	 * */
	public int isRegionalOfficePresent(String assessmentBodyRegistrationId, String pincode)
	{
		int status =0;
		try
		{
			Map<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("assessmentBodyRegistrationId", assessmentBodyRegistrationId);
			parameters.put("pincode", pincode);
			status = getJdbcTemplate().queryForObject(profileCreationAssessmentBodyConfigSql.getIsRegionalOfficePresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("An exception occured while checking if regional office is present or not " + e);
			status =-1;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while checking if regional office is present or not " + e);
			status =-2;
		}
		;
		
		return status;
	}
	
	/*
	 * */
	public int isExperiencePresent(String assessmentBodyRegistrationId, String domain)
	{
		int status =0;
		try
		{
			Map<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("assessmentBodyRegistrationId", assessmentBodyRegistrationId);
			parameters.put("domain", domain);
			status = getJdbcTemplate().queryForObject(profileCreationAssessmentBodyConfigSql.getIsAssessmentExperiencePresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("An exception occured while checking if experience of assessment body is present or not " + e);
			status =-1;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while checking if experience of assessment body is present or not " + e);
			status =-2;
		}
		;
		
		return status;
	}
	
	/*
	 * */
	public int isStaffPresent(String assessmentBodyRegistrationId, String emailId)
	{
		int status =0;
		try
		{
			Map<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("assessmentBodyRegistrationId", assessmentBodyRegistrationId);
			parameters.put("emailId", emailId);
			status = getJdbcTemplate().queryForObject(profileCreationAssessmentBodyConfigSql.getIsAssessmentStaffPresent(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("An exception occured while checking if assessment staff of assessment body is present or not " + e);
			status =-1;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while checking if assessment staff of assessment body is present or not " + e);
			status =-2;
		}
		;
		
		return status;
	}
	
	/*
	 * */
	public static class ProfileCreationAssessmentBodyAffiliationDetailsRowMapper implements RowMapper<ProfileCreationAssessmentBodyAffiliationDetailsDto> {

		@Override
		public ProfileCreationAssessmentBodyAffiliationDetailsDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {

			String affiliationId = resultSet.getString("affiliationId");
			String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");
			String nameOfSectorSkillCouncil = resultSet.getString("nameOfSectorSkillCouncil");
			boolean isActive = resultSet.getBoolean("isActive");
			return new ProfileCreationAssessmentBodyAffiliationDetailsDto(affiliationId,assessmentBodyRegistrationId,
					nameOfSectorSkillCouncil, isActive);
		}

}

	
	
}
