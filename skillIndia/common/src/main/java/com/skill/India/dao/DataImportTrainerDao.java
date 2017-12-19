package com.skill.India.dao;
/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Trainer 
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
public class DataImportTrainerDao extends AbstractTransactionalDao {
	

	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportTrainerDao.class);
	
	public int dataImportEmployerForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on trainingPartnerId  column in Training Partner Table 
		 */
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainerDao - dataImportEmployerForeignKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint userId,batchId ");
				
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
		    return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForTrainer(), parameters,Integer.class );					
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
	 * checking for primary key constraint for EmployerId in Employer Table
	 */
	
	public int dataImportEmployerPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainerDao - dataImportEmployerPrimaryKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for primary key constraint ");
		
		try{							
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("trainerId",getRecord.get("trainerId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
		    return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainerIdExistsForTrainer(), parameters,Integer.class );					
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
	 * Inserting data in Employer Table
	 */
	
	public int insertDataInEmployer(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainerDao - insertDataInEmployer");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Inserting data in Trainer Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoTrainer(), recordToInsert);	
	}
	
	/*
	 * Updating data in Employer Table
	 */
	
	public int updateDataInEmployer(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportTrainerDao - updateDataInEmployer");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Updating data in Trainer Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoTrainer(), recordToInsert);
	}	
	

}
