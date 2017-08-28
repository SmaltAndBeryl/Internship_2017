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
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportAssessorDao - dataImportAssessorForeignKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.info("checking for foreign key constraint Assessment Agency Table ");
		
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
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForAssessor(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
//	        e.printStackTrace();
			return 2;
		}
	}
	/*
	 * checking for primary key constraint on assessorId  column in Assessor Table 
	 */
	
		public int dataImportAssessorPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
		{
			LOGGER.info("Request Received from Service");
			LOGGER.info("In DataImportAssessorDao - dataImportAssessorPrimaryKeyConstraintCheck");
			LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
					   	
			LOGGER.info("checking for primary key constraint Assessor Table ");
			
			try
			{							
				LOGGER.info("Inside TRY block");
				
				LOGGER.info("Creating HashMap object");
				Map<String, Object> parameters = new HashMap<>();
				LOGGER.info("object created successfully");
				
				LOGGER.info("Inserting parameters to HashMap object");
				parameters.put("assessorId",getRecord.get("assessorId"));
				LOGGER.info("Parameters inserted");
				
				LOGGER.info("Executing SQL query and returning response");
				return getJdbcTemplate().queryForObject(dataImportConfigSql.getAssessorIdExistsForAssessor(), parameters,Integer.class );					
			}
				catch(Exception e)
				{
					LOGGER.info("Inside CATCH block");
					
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
			LOGGER.info("Request Received from Service");
			LOGGER.info("In DataImportAssessorDao - insertDataInAssessor");
			LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
					   	
			LOGGER.info("Inserting data in Assessor Table");
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoAssessorSql(), recordToInsert);	
		}
		
		/*
		 * Updating data in Assessor Table
		 */
		public int updateDataInAssessor(Map<String , Object> recordToInsert)
		{
			LOGGER.info("Request Received from Service");
			LOGGER.info("In DataImportAssessorDao - updateDataInAssessor");
			LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
					   	
			LOGGER.info("Updating data in Assessor Table");
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoAssessorSql(), recordToInsert);
		}
		
		
}
		