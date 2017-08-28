package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Agency 
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
public class DataImportAssessmentAgencyDao extends AbstractTransactionalDao {
	@Autowired
	private DataImportConfigSql dataImportConfigSql;

	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportAssessmentAgencyDao.class);
	
	public int dataImportAssessmentAgencyForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		
		/*
		 * checking for foreign key constraint on batchId,employerId  column in Batch,Employer Table 
		 */
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportAssessmentAgencyDao - dataImportAssessmentAgencyForeignKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.info("checking for foreign key constraint  Batch Employer Table ");
			
		try{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("applicationId",getRecord.get("applicationId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getApplicationIdExistsForAgency(), parameters,Integer.class );					
			}	// end of try
		catch(Exception e)
		{
//			e.printStackTrace();
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			return 2;
		}
	}
	
	/*
	 * checking for primary key constraint for agencyId in Assessment Agency
	 */
	
	public int dataImportAssessmentAgencyPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportAssessmentAgencyDao - dataImportAssessmentAgencyForeignKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.info("checking for primary key constraint in Assessment Agency ");
		try
		{							
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("agencyId",getRecord.get("agencyId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForAgency(), parameters,Integer.class );					
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
	 * Inserting data in Assessment Agency Table
	 */
	
	public int insertDataInAssessmentAgency(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportAssessmentAgencyDao - insertDataInAssessmentAgency");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Inserting data in Assessment Agency Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoAgencySql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Assessment Agency
	 */
	
	public int updateDataInAssessmentAgency(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportAssessmentAgencyDao - updateDataInAssessmentAgency");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Updating data in Assessment Agency");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoAgencySql(), recordToInsert);
	}
	
	
	
	
}
