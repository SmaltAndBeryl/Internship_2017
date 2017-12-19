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
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportAssessmentAgencyDao - dataImportAssessmentAgencyForeignKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint  Batch Employer Table ");
			
		try{
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("applicationId",getRecord.get("applicationId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getApplicationIdExistsForAgency(), parameters,Integer.class );					
			}	// end of try
		catch(Exception e)
		{
//			e.printStackTrace();
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			return 2;
		}
	}
	
	/*
	 * checking for primary key constraint for agencyId in Assessment Agency
	 */
	
	public int dataImportAssessmentAgencyPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportAssessmentAgencyDao - dataImportAssessmentAgencyForeignKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for primary key constraint in Assessment Agency ");
		try
		{							
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("agencyId",getRecord.get("agencyId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForAgency(), parameters,Integer.class );					
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
	 * Inserting data in Assessment Agency Table
	 */
	
	public int insertDataInAssessmentAgency(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportAssessmentAgencyDao - insertDataInAssessmentAgency");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Inserting data in Assessment Agency Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoAgencySql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Assessment Agency
	 */
	
	public int updateDataInAssessmentAgency(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportAssessmentAgencyDao - updateDataInAssessmentAgency");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Updating data in Assessment Agency");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoAgencySql(), recordToInsert);
	}
	
	
	
	
}
