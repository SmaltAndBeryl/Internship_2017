/**
 * 
 */
package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

/**
 * @author Ruchit
 *
 */
@Repository
public class DataImportCSVUploadTableDao extends AbstractTransactionalDao{
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportCSVUploadForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on userId  column in User Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId",getRecord.get("csvUploadUserId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getUserIdExistsForCSVUploaded(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
		
	/*
	 * Inserting data in csvuploaded Table
	 */
	
	public int insertDataInCSVUpload(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCSVUploaded(), recordToInsert);	
	}
}
