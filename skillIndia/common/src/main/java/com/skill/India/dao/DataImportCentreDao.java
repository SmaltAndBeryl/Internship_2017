package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Centre 
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
public class DataImportCentreDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportCentreDao.class);
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportCentreForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId,employerId  column in Batch,Employer Table 
		 */
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportCentreDao - dataImportCentreForeignKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint batchId,employerId ");
				
		try
		{				
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("trainingPartnerId",getRecord.get("trainingPartnerId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForCentre(), parameters,Integer.class );					
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
	 * checking for primary key constraint for candidateDetailsId in Candidate Table
	 */
	
	public int dataImportCentrePrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportCentreDao.java - dataImportCentrePrimaryKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for primary key constraint ");
		
		try
		{							
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("centreId",getRecord.get("centreId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getCentreIdExistsForCentre(), parameters,Integer.class );					
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
	
	public int insertDataInCentre(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportCentreDao - insertDataInCentre");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Inserting data in Centre Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCentreSql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInCentre(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportCentreDao - updateDataInCentre");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Updating data in Centre Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoCentreSql(), recordToInsert);
	}
	
	

	
}
