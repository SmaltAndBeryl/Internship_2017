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
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportCSVUploadTableDao - dataImportCSVUploadForeignKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.info("checking for foreign key constraint userId ");
		
		try
		{				
		
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("userId",getRecord.get("csvUploadUserId"));
			LOGGER.info("Parameters inserted");
		
			LOGGER.info("Executing SQL query and returning response");
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getUserIdExistsForCSVUploaded(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.info("Inside CATCH block");
			
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
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportCSVUploadTableDao - insertDataInCSVUpload");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Inserting data in csvuploaded Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCSVUploaded(), recordToInsert);	
	}
}
