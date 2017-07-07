package com.skill.India.dao;
/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Training Partner
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportTrainingPartnerDao extends AbstractTransactionalDao {

	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	
	public int dataImportTrainingPartnerForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId,employerId  column in Batch,Employer Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("applicationId",getRecord.get("applicationId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getApplicationIdExistsForTrainingPartner(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}

	/*
	 * checking for primary key constraint for TrainingPartnerId in TrainingPartner Table
	 */
	
	public int dataImportTrainingPartnerPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		try{							
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("trainingPartnerId",getRecord.get("trainingPartnerId"));
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForTrainingPartner(), parameters,Integer.class );					
		}
			catch(Exception e)
			{
				e.printStackTrace();
				return 2;
			}		
}	
		
	/*
	 * Inserting data in Training Partner Table
	 */
	
	public int insertDataInTrainingPartner(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoTrainingPartner(), recordToInsert);	
	}
	
	/*
	 * Updating data in Training Partner Table
	 */
	
	public int updateDataInTrainingPartner(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoTrainingPartner(), recordToInsert);
	}	
}
