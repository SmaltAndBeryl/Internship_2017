package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Batch 
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportBatchDao extends AbstractTransactionalDao {
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportBatchTrainingPartnerIdCheck(Map<String,Object> getRecord)
	{
		try{				
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("trainingPartnerId",getRecord.get("trainingPartnerId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	
	
	public int dataImportBatchCentreIdCheck(Map<String,Object> getRecord)
	{
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("centreId",getRecord.get("centreId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getCentreIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	
	public int dataImportBatchTrainerIdCheck(Map<String,Object> getRecord)
	{
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("trainerId",getRecord.get("trainerId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainerIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	
	public int dataImportBatchAgencyIdCheck(Map<String,Object> getRecord)
	{
		try{					
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("agencyId",getRecord.get("agencyId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	
	public int dataImportBatchAssessorIdCheck(Map<String,Object> getRecord)
	{
		try{					
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("assessorId",getRecord.get("assessorId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getAssessorIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	
	
	/*
	 * checking for primary key constraint for candidateDetailsId in Candidate Table
	 */
	
	public int dataImportBatchPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		try{							
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("batchId",getRecord.get("batchId"));
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getBatchIdExistsForBatch(), parameters,Integer.class );					
		}
			catch(Exception e)
			{
				e.printStackTrace();
				return 2;
			}		
}	
		
	/*
	 * Inserting data in Candidate Table
	 */
	
	public int insertDataInBatch(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoBatchSql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInBatch(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoBatchSql(), recordToInsert);
	}
	
	

}
