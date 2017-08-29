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
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportTrainingPartnerDao - dataImportTrainingPartnerForeignKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.info("checking for foreign key constraint Batch,Employer ");
				
		try
		{				
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("applicationId",getRecord.get("applicationId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getApplicationIdExistsForTrainingPartner(), parameters,Integer.class );					
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
	 * checking for primary key constraint for TrainingPartnerId in TrainingPartner Table
	 */
	
	public int dataImportTrainingPartnerPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportTrainingPartnerDao - dataImportTrainingPartnerPrimaryKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.info("checking for primary key constraint in TrainingPartner Table");
		
		try
		{							
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("trainingPartnerId",getRecord.get("trainingPartnerId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
		    return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForTrainingPartner(), parameters,Integer.class );					
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
	 * Inserting data in Training Partner Table
	 */
	
	public int insertDataInTrainingPartner(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportTrainingPartnerDao - insertDataInTrainingPartner");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Inserting data in Training Partner Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoTrainingPartner(), recordToInsert);	
	}
	
	/*
	 * Updating data in Training Partner Table
	 */
	
	public int updateDataInTrainingPartner(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportTrainingPartnerDao - updateDataInTrainingPartner");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Updating data in Training Partner Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoTrainingPartner(), recordToInsert);
	}	
}
