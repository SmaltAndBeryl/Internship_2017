package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Candidate 
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportCandidateDao extends AbstractTransactionalDao {

	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportCandidateForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId,employerId  column in Batch,Employer Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("batchId",getRecord.get("batchId"));
		parameters.put("employerId",getRecord.get("employerId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getBatchIdemployerIdExistsForCandidate(), parameters,Integer.class );					
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
	
	public int dataImportCandidatePrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		try{							
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("candidateDetailsId",getRecord.get("candidateDetailsId"));
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getCandidateDeatilsIdExistsForCandidate(), parameters,Integer.class );					
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
	
	public int insertDataInCandidate(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCandidateSql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInCandidate(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoCandidateSql(), recordToInsert);
	}	
	
	
}
