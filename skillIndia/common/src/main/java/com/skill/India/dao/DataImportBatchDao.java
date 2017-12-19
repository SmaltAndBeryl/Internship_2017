package com.skill.India.dao;

/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Batch 
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
public class DataImportBatchDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportBatchDao.class);
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportBatchTrainingPartnerIdCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - dataImportBatchTrainingPartnerIdCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint TrainingPartnerId ");
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
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
//			e.printStackTrace();
			return 2;
		}
	}
	
	
	public int dataImportBatchCentreIdCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - dataImportBatchCentreIdCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
				   	
		LOGGER.debug("checking for foreign key constraint CentreId ");
		try{				
		
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("centreId",getRecord.get("centreId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getCentreIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
//			e.printStackTrace();
			return 2;
		}
	}
	
	public int dataImportBatchTrainerIdCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - dataImportBatchTrainerIdCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for foreign key constraint TrainerId ");
		
		try
		{				
		
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("trainerId",getRecord.get("trainerId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainerIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
//			e.printStackTrace();
			return 2;
		}
	}
	
	public int dataImportBatchAgencyIdCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - dataImportBatchAgencyIdCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for foreign key constraint AgencyId ");
		
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
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForBatch(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
//			e.printStackTrace();
			return 2;
		}
	}
	
	public int dataImportBatchAssessorIdCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - dataImportBatchAssessorIdCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for foreign key constraint for AssessorId ");
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
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getAssessorIdExistsForBatch(), parameters,Integer.class );					
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
	
	public int dataImportBatchPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - dataImportBatchPrimaryKeyConstraintCheck");
		LOGGER.debug("Parameters Received from Service are - HashMap 'getRecord' ");
		
		LOGGER.debug("checking for primary key constraint for candidateDetailsId ");
		try
		{							
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("batchId",getRecord.get("batchId"));
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(dataImportConfigSql.getBatchIdExistsForBatch(), parameters,Integer.class );					
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
	
	public int insertDataInBatch(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - insertDataInBatch");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Inserting data in Candidate Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoBatchSql(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInBatch(Map<String , Object> recordToInsert)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataImportBatchDao - updateDataInBatch");
		LOGGER.debug("Parameters Received from Service are  - HashMap 'recordToInsert'");
				   	
		LOGGER.debug("Updating data in Candidate Table");
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoBatchSql(), recordToInsert);
	}
	
	

}
