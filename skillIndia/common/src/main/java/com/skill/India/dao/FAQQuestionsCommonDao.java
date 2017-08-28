package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.FAQConfigSql;

/**
 * @author Aashish sharma
 *
 */

@Repository
public class FAQQuestionsCommonDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQQuestionsCommonDao.class);
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	public Integer getTotalTrainingCentresInAState(String state)  {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getTotalTrainingCentresInAState");
		LOGGER.info("Parameters Received from Service are - 'state': " +state);
				   	
		LOGGER.info("getting total training centers in a state");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("state", state);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalTrainingCentresInAState(), parameters, Integer.class);
	}
	
	public Integer getCountOfTotalTrainingCentresConductingTraining()  {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getCountOfTotalTrainingCentresConductingTraining");
				   	
		LOGGER.info("getting total training centers conducting training");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTrainingCentresConductingTraining(), parameters, Integer.class);
	}
	
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(String month)  {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getCountOfCandidatesAssessmentUpcomingForAMonth");
		LOGGER.info("Parameters Received from Service are - 'month': " +month);
		
		LOGGER.info("getting count of candidates assessment upcoming for a month");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("month", month);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query");
		Integer count= getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountOfCandidatesAssessmentUpcomingForAMonth(), parameters, Integer.class);
		LOGGER.info("Returning response");
		if(count==null)
			return 0;
		else return count;
	}
	
	public String getNameOfAgencyToWhichABatchIsAssigned(Integer batchId)throws EmptyResultDataAccessException {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getNameOfAgencyToWhichABatchIsAssigned");
		LOGGER.info("Parameters Received from Service are - 'batchId': " +batchId);
		
		LOGGER.info("getting name of agency to which Batch with Id is assigned");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
		LOGGER.info("Parameters inserted");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Executing SQL query");
			return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlNameOfAgencyToWhichABatchIsAssigned(), parameters, String.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			LOGGER.info("Inside CATCH block");
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.info("Returning NULL");
			return null;
		}
	}
	
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(String agencyName)throws EmptyResultDataAccessException {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getTotalCountOfBatchesAssignedToAAssessmentAgency");
		LOGGER.info("Parameters Received from Service are - 'agencyName': " +agencyName);
		
		LOGGER.info("getting count of batches assigned to a agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("agencyName", agencyName);
		LOGGER.info("Parameters inserted");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Executing SQL query");
			return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalOfBatchesAssignedToAAssessmentAgency(), parameters, Integer.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			LOGGER.info("Inside CATCH block");
			LOGGER.error("ERROR: Encountered Exception - "+e);
			LOGGER.info("Returning NULL");
			return null;
		}
		
	}
	
	public Integer getCountTotalAssessorsOfAParticularAgencyInAParticularState(String agencyName,String state) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getCountTotalAssessorsOfAParticularAgencyInAParticularState");
		LOGGER.info("Parameters Received from Service are - 'agencyName': " +agencyName+" 'state': "+state);
		
				   	
		LOGGER.info("getting total assessor of a agency in a state");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("agencyName", agencyName);
		parameters.put("state", state);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState(), parameters, Integer.class);
	}
	
	public Integer getCountBatchesForWhichResultIsPending() {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getCountBatchesForWhichResultIsPending");
				   	
		LOGGER.info("getting total number of batches whose result is pending");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountBatchesForWhichResultIsPending(), parameters, Integer.class);
	}

	public Integer getCountTotalNonAssignedBatches() {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQQuestionsCommonDao - getCountTotalNonAssignedBatches");
				   	
		LOGGER.info("getting total number of non assigned batches");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalNonAssignedBatches(), parameters, Integer.class);
	}
	
}

