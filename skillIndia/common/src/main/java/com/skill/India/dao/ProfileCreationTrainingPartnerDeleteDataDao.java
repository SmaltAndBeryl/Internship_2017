package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ProfileCreationTrainingPartnerConfigSql;

@Repository
public class ProfileCreationTrainingPartnerDeleteDataDao extends AbstractTransactionalDao{

	@Autowired
	private ProfileCreationTrainingPartnerConfigSql profileCreationTrainingPartnerConfigSql;
	
	/*
	 * Deleting data from TrainingPartnerInstituteGrant table
	 */
	
	public int deletefromTrainingPartnerInstituteGrant(String instituteGrantId)
	{
		try{
		Map<String, String> parameters= new HashMap<String, String>();
		parameters.put("instituteGrantId", instituteGrantId);
		return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getDeleteFromTrainingPartnerInstituteGrant(), parameters);
		}
		catch(Exception e)
		{
			/*
			 * An exception occurs while deleting record from Institute Grant Table
			 */
			e.printStackTrace();
			return -1;
			
		}
	}
	
	/*
	 * Deleting from TrainingPartnerInstituteGrant table ends 
	 */
	
	/*
	 * Deleting data from TrainingPartnerInstituteRecognition table
	 */
	
	public int deletefromTrainingPartnerInstituteRecognition(String instituteRecognitionId)
	{
		try{
		Map<String, String> parameters= new HashMap<String, String>();
		parameters.put("instituteRecognitionId", instituteRecognitionId);
		return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getDeleteFromTrainingPartnerInstituteRecognition(), parameters);
		}
		catch(Exception e)
		{
			/*
			 * An exception occurs while deleting record from TrainingPartnerInstituteRecognition Table
			 */
			e.printStackTrace();
			return -1;
			
		}
	}
	
	/*
	 * Deleting from TrainingPartnerInstituteRecognition table ends 
	 */
	
	
	/*
	 * Deleting data from TrainingPartnerPriorExperienceInSkillTraining	 table
	 */
	
	public int deletefromTrainingPartnerPriorExperienceInSkillTraining(String priorExperienceInSkillTrainingId)
	{
		try{
		Map<String, String> parameters= new HashMap<String, String>();
		parameters.put("priorExperienceInSkillTrainingId", priorExperienceInSkillTrainingId);
		return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getDeleteFromTrainingPartnerPriorExperienceInSkillTraining(), parameters);
		}
		catch(Exception e)
		{
			/*
			 * An exception occurs while deleting record from TrainingPartnerPriorExperienceInSkillTraining Table
			 */
			e.printStackTrace();
			return -1;
			
		}
	}
	
	/*
	 * Deleting from TrainingPartnerPriorExperienceInSkillTraining table ends 
	 */
	
	/*
	 * Deleting data from TrainingPartnerManagementAndStaffAndOfficialsDetails table
	 */
	
	public int deletefromTrainingPartnerManagementAndStaffAndOfficialsDetails(String managementAndStaffId)
	{
		try{
		Map<String, String> parameters= new HashMap<String, String>();
		parameters.put("managementAndStaffId", managementAndStaffId);
		return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getDeleteFromTrainingPartnerManagementAndStaffAndOfficialsDetails(), parameters);
		}
		catch(Exception e)
		{
			/*
			 * An exception occurs while deleting record from TrainingPartnerManagementAndStaffAndOfficialsDetails Table
			 */
			e.printStackTrace();
			return -1;
			
		}
	}
	
	/*
	 * Deleting from TrainingPartnerManagementAndStaffAndOfficialsDetails table ends 
	 */
	
	/*
	 * Deleting data from TrainingPartnerCenterLevelDetails	 table
	 */
	
	public int deletefromTrainingPartnerCenterLevelDetails(String trainingPartnerCenterId)
	{
		try{
		Map<String, String> parameters= new HashMap<String, String>();
		parameters.put("trainingPartnerCenterId", trainingPartnerCenterId);
		return getJdbcTemplate().update(profileCreationTrainingPartnerConfigSql.getDeleteFromTrainingPartnerCenterLevelDetails(), parameters);
		}
		catch(Exception e)
		{
			/*
			 * An exception occurs while deleting record from TrainingPartnerCenterLevelDetails Table
			 */
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * Deleting from TrainingPartnerCenterLevelDetails table ends 
	 */
	
	
	
	
	
	
}
