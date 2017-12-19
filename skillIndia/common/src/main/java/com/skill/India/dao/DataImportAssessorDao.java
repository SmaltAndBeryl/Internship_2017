package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Assessor 
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
public class DataImportAssessorDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportAssessorDao.class);
		
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportAssessorForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on agencyId  column in Assessment Agency Table 
		 */
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportAssessorDao - dataImportAssessorForeignKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint Assessment Agency Table ");
		
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
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForAssessor(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
//	        e.printStackTrace();
			return 2;
		}
	}
	/*
	 * checking for primary key constraint on assessorId  column in Assessor Table 
	 */
	
		public int dataImportAssessorPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
		{
			LOGGER.debug("Request Received from Service");
			LOGGER.debug("In DataImportAssessorDao - dataImportAssessorPrimaryKeyConstraintCheck");
			LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
					   	
			LOGGER.debug("checking for primary key constraint Assessor Table ");
			
			try
			{							
				LOGGER.debug("Inside TRY block");
				
				LOGGER.debug("Creating HashMap object");
				Map<String, Object> parameters = new HashMap<>();
				LOGGER.debug("object created successfully");
				
				LOGGER.debug("Inserting parameters to HashMap object");
				parameters.put("assessorId",getRecord.get("assessorId"));
				LOGGER.debug("Parameters inserted");
				
				LOGGER.debug("Executing SQL query and returning response");
				return getJdbcTemplate().queryForObject(dataImportConfigSql.getAssessorIdExistsForAssessor(), parameters,Integer.class );					
			}
				catch(Exception e)
				{
					LOGGER.debug("Inside CATCH block");
					
					LOGGER.error("ERROR: Encountered Exception - "+e);
//					e.printStackTrace();
					return 2;
				}		
	}	
				
		/*
		 * Inserting data in Assessor Table
		 */
		
		public int insertDataInAssessor(Map<String , Object> recordToInsert)
		{
			LOGGER.debug("Request Received from Service");
			LOGGER.debug("In DataImportAssessorDao - insertDataInAssessor");
			LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
					   	
			LOGGER.debug("Inserting data in Assessor Table");
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoAssessorSql(), recordToInsert);	
		}
		
		/*
		 * Updating data in Assessor Table
		 */
		public int updateDataInAssessor(Map<String , Object> recordToInsert)
		{
			LOGGER.debug("Request Received from Service");
			LOGGER.debug("In DataImportAssessorDao - updateDataInAssessor");
			LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
					   	
			LOGGER.debug("Updating data in Assessor Table");
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoAssessorSql(), recordToInsert);
		}
		
		
}
		