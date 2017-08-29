package com.skill.India.dao;
/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Employer
 */

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportEmployerDao extends AbstractTransactionalDao {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportEmployerDao.class);
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	

	/*
	 * checking for primary key constraint for EmployerId in Employer Table
	 */
	
	public int dataImportEmployerPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportEmployerDao - dataImportEmployerPrimaryKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.info("checking for primary key constraint for EmployerId ");
		
		try{							
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("employerId",getRecord.get("employerId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
		    return getJdbcTemplate().queryForObject(dataImportConfigSql.getEmployerIdExistsForEmployer(), parameters,Integer.class );					
		}
			catch(Exception e)
			{
				LOGGER.info("Inside CATCH block");
				
				LOGGER.error("ERROR: Encountered Exception - "+e);
//				e.printStackTrace();
				return 2;
			}		
}	
		
	/*
	 * Inserting data in Candidate Table
	 */
	
	public int insertDataInEmployer(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportEmployerDao - insertDataInEmployer");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Inserting data in Employer Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoEmployer(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInEmployer(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportEmployerDao - updateDataInEmployer");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Updating data in Employer Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoEmployer(), recordToInsert);
	}	


}
