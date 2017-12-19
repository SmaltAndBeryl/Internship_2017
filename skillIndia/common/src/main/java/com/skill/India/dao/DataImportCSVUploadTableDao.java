/**
 * 
 */
package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportCSVUploadTableDao.class);
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportCSVUploadForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on userId  column in User Table 
		 */
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportCSVUploadTableDao - dataImportCSVUploadForeignKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint userId ");
		
		try
		{				
		
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("userId",getRecord.get("csvUploadUserId"));
			LOGGER.debug("Parameters inserted");
		
			LOGGER.debug("Executing SQL query and returning response");
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getUserIdExistsForCSVUploaded(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
//			e.printStackTrace();
			return 2;
		}
	}
		
	/*
	 * Inserting data in csvuploaded Table
	 */
	
	public int insertDataInCSVUpload(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportCSVUploadTableDao - insertDataInCSVUpload");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Inserting data in csvuploaded Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCSVUploaded(), recordToInsert);	
	}
}
