package com.skill.India.dao;
/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Training Partner
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
public class DataImportTrainingPartnerDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportTrainingPartnerDao.class);
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportTrainingPartnerForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId,employerId  column in Batch,Employer Table 
		 */
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainingPartnerDao - dataImportTrainingPartnerForeignKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint Batch,Employer ");
				
		try
		{				
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("applicationId",getRecord.get("applicationId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getApplicationIdExistsForTrainingPartner(), parameters,Integer.class );					
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
	 * checking for primary key constraint for TrainingPartnerId in TrainingPartner Table
	 */
	
	public int dataImportTrainingPartnerPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainingPartnerDao - dataImportTrainingPartnerPrimaryKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for primary key constraint in TrainingPartner Table");
		
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
		    return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForTrainingPartner(), parameters,Integer.class );					
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
	 * Inserting data in Training Partner Table
	 */
	
	public int insertDataInTrainingPartner(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainingPartnerDao - insertDataInTrainingPartner");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Inserting data in Training Partner Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoTrainingPartner(), recordToInsert);	
	}
	
	/*
	 * Updating data in Training Partner Table
	 */
	
	public int updateDataInTrainingPartner(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainingPartnerDao - updateDataInTrainingPartner");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Updating data in Training Partner Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoTrainingPartner(), recordToInsert);
	}	
}
