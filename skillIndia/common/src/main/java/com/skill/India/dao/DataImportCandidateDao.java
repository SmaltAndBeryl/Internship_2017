package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Candidate 
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
public class DataImportCandidateDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportCandidateDao.class);
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportCandidateBatchIdCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId column in Batch Table 
		 */
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportCandidateDao - dataImportCandidateBatchIdCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.info("checking for foreign key constraint batchId ");
		
		try
		{				
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("batchId",getRecord.get("batchId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getBatchIdExistsForCandidate(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
//			e.printStackTrace();
			return 2;
		}
	}
	
	public int dataImportCandidateEmployerIdCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on batchId column in Batch Table 
		 */
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportCandidateDao - dataImportCandidateEmployerIdCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.info("checking for foreign key constraint batchId ");
		
		try
		{				
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("employerId",getRecord.get("employerId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
//	        System.out.println(parameters + dataImportConfigSql.getEmployerIdExistsForCandidate());
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getEmployerIdExistsForCandidate(), parameters,Integer.class );					
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
	 * checking for primary key constraint for candidateDetailsId in Candidate Table
	 */
	
	public int dataImportCandidatePrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportCandidateDao.java - dataImportCandidatePrimaryKeyConstraintCheck");
		LOGGER.info("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.info("checking for primary key constraint for candidateDetailsId ");
		
		try
		{							
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("candidateDetailsId",getRecord.get("candidateDetailsId"));
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getCandidateDeatilsIdExistsForCandidate(), parameters,Integer.class );					
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
	
	public int insertDataInCandidate(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportCandidateDao - insertDataInCandidate");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Inserting data in Candidate Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCandidateSql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInCandidate(Map<String , Object> recordToInsert)
	{
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DataImportCandidateDao - updateDataInCandidate");
		LOGGER.info("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.info("Updating data in Candidate Table");
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoCandidateSql(), recordToInsert);
	}	
	
	
}
