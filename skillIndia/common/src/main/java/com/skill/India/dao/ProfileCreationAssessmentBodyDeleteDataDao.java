package com.skill.India.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ProfileCreationAssessmentBodyConfigSql;

@Repository
public class ProfileCreationAssessmentBodyDeleteDataDao extends AbstractTransactionalDao {

	@Autowired
	private ProfileCreationAssessmentBodyConfigSql profileCreationAssessmentBodyConfigSql;
	
	
	/*
	 * Delete from AssessmentBodyRecognitions
	 */
	public int deleteFromAssessmentBodyRecognitions(String assessmentBodyRecognitionId)
	{
		try{
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("assessmentBodyRecognitionId", assessmentBodyRecognitionId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getDeleteFromAssessmentBodyRecognitions(), parameters);
		}
		catch(Exception e)
		{
		/*
		 * An error occurred while deleting record
		 */
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Delete from AssessmentsExperienceInTechnicalDomain
	 */
	
	public int deleteFromAssessmentsExperienceInTechnicalDomain(String assessmentExperienceId)
	{
		try{
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("assessmentExperienceId", assessmentExperienceId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getDeleteFromAssessmentsExperienceInTechnicalDomain(), parameters);
		}
		catch(Exception e)
		{
		/*
		 * An error occurred while deleting record
		 */
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Delete from AssessmentBodyDirectorsAndManagementTeamDetails
	 */
	
	public int deleteFromAssessmentBodyDirectorsAndManagementTeamDetails(String directorsAndManagementId)
	{
		try{
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("directorsAndManagementId", directorsAndManagementId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getDeleteFromAssessmentBodyDirectorsAndManagementTeamDetails(), parameters);
		}
		catch(Exception e)
		{
		/*
		 * An error occurred while deleting record
		 */
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Delete from AssessmentStaffDetails
	 */
	
	public int deleteFromAssessmentStaffDetails(String assessmentStaffId)
	{
		try{
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("assessmentStaffId", assessmentStaffId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getDeleteFromAssessmentStaffDetails(), parameters);
		}
		catch(Exception e)
		{
		/*
		 * An error occurred while deleting record
		 */
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Delete from AssessmentBodyRegionalOfficeDetails
	 */
	
	public int deleteFromAssessmentBodyRegionalOfficeDetails(String regionalOfficeId)
	{
		try{
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("regionalOfficeId", regionalOfficeId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getDeleteFromAssessmentBodyRegionalOfficeDetails(), parameters);
		}
		catch(Exception e)
		{
		/*
		 * An error occurred while deleting record
		 */
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Delete from AssessmentBodyAffiliationDetails
	 */
	
	public int deleteFromAssessmentBodyAffiliationDetails(String affiliationId)
	{
		try{
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("affiliationId", affiliationId);
		return getJdbcTemplate().update(profileCreationAssessmentBodyConfigSql.getDeleteFromAssessmentBodyAffiliationDetails(), parameters);
		}
		catch(Exception e)
		{
		/*
		 * An error occurred while deleting record
		 */
			e.printStackTrace();
			return -1;
		}
	}
	
}
