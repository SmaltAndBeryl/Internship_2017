package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Centre 
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportCentreDao extends AbstractTransactionalDao{
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportCentreForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId,employerId  column in Batch,Employer Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("trainingPartnerId",getRecord.get("trainingPartnerId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForCentre(), parameters,Integer.class );					
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
	
	public int dataImportCentrePrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		try{							
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("centreId",getRecord.get("centreId"));
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getCentreIdExistsForCentre(), parameters,Integer.class );					
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
	
	public int insertDataInCentre(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCentreSql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInCentre(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoCentreSql(), recordToInsert);
	}
	
	

	
}
