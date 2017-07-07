package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Agency 
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportAssessmentAgencyDao extends AbstractTransactionalDao {
	@Autowired
	private DataImportConfigSql dataImportConfigSql;

	public int dataImportAssessmentAgencyForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId,employerId  column in Batch,Employer Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("applicationId",getRecord.get("applicationId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getApplicationIdExistsForAgency(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	
	/*
	 * checking for primary key constraint for agencyId in Assessment Agency
	 */
	
	public int dataImportAssessmentAgencyPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		try{							
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("agencyId",getRecord.get("agencyId"));
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForAgency(), parameters,Integer.class );					
		}
			catch(Exception e)
			{
				e.printStackTrace();
				return 2;
			}		
}	
		
	/*
	 * Inserting data in Assessment Agency Table
	 */
	
	public int insertDataInAssessmentAgency(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoAgencySql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Assessment Agency
	 */
	
	public int updateDataInAssessmentAgency(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoAgencySql(), recordToInsert);
	}
	
	
	
	
}
