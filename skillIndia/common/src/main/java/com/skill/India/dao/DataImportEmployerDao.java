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
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportEmployerDao - dataImportEmployerPrimaryKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for primary key constraint for EmployerId ");
		
		try{							
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("employerId",getRecord.get("employerId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
		    return getJdbcTemplate().queryForObject(dataImportConfigSql.getEmployerIdExistsForEmployer(), parameters,Integer.class );					
		}
			catch(Exception e)
			{
				LOGGER.debug("Inside CATCH block");
				
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
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportEmployerDao - insertDataInEmployer");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Inserting data in Employer Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoEmployer(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInEmployer(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportEmployerDao - updateDataInEmployer");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Updating data in Employer Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoEmployer(), recordToInsert);
	}	


}
