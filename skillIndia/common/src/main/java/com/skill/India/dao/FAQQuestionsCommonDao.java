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
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getTotalTrainingCentresInAState");
		LOGGER.debug("Parameters Received from Service are - 'state': " +state);
				   	
		LOGGER.debug("getting total training centers in a state");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("state", state);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalTrainingCentresInAState(), parameters, Integer.class);
	}
	
	public Integer getCountOfTotalTrainingCentresConductingTraining()  {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getCountOfTotalTrainingCentresConductingTraining");
				   	
		LOGGER.debug("getting total training centers conducting training");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTrainingCentresConductingTraining(), parameters, Integer.class);
	}
	
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(String month)  {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getCountOfCandidatesAssessmentUpcomingForAMonth");
		LOGGER.debug("Parameters Received from Service are - 'month': " +month);
		
		LOGGER.debug("getting count of candidates assessment upcoming for a month");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("month", month);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query");
		Integer count= getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountOfCandidatesAssessmentUpcomingForAMonth(), parameters, Integer.class);
		LOGGER.debug("Returning response");
		if(count==null)
			return 0;
		else return count;
	}
	
	public String getNameOfAgencyToWhichABatchIsAssigned(String batchId)throws EmptyResultDataAccessException {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getNameOfAgencyToWhichABatchIsAssigned");
		LOGGER.debug("Parameters Received from Service are - 'batchId': " +batchId);
		
		LOGGER.debug("getting name of agency to which Batch with Id is assigned");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
		LOGGER.debug("Parameters inserted");
		
		try
		{
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Executing SQL query");
			return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlNameOfAgencyToWhichABatchIsAssigned(), parameters, String.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			LOGGER.debug("Inside CATCH block");
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.debug("Returning NULL");
			return null;
		}
	}
	
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(String agencyName)throws EmptyResultDataAccessException {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getTotalCountOfBatchesAssignedToAAssessmentAgency");
		LOGGER.debug("Parameters Received from Service are - 'agencyName': " +agencyName);
		
		LOGGER.debug("getting count of batches assigned to a agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyName", agencyName);
		LOGGER.debug("Parameters inserted");
		
		try
		{
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Executing SQL query");
			return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalOfBatchesAssignedToAAssessmentAgency(), parameters, Integer.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			LOGGER.debug("Inside CATCH block");
			LOGGER.error("ERROR: Encountered Exception - "+e);
			LOGGER.debug("Returning NULL");
			return null;
		}
		
	}
	
	public Integer getCountTotalAssessorsOfAParticularAgencyInAParticularState(String agencyName,String state) {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getCountTotalAssessorsOfAParticularAgencyInAParticularState");
		LOGGER.debug("Parameters Received from Service are - 'agencyName': " +agencyName+" 'state': "+state);
		
				   	
		LOGGER.debug("getting total assessor of a agency in a state");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyName", agencyName);
		parameters.put("state", state);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState(), parameters, Integer.class);
	}
	
	public Integer getCountBatchesForWhichResultIsPending() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getCountBatchesForWhichResultIsPending");
				   	
		LOGGER.debug("getting total number of batches whose result is pending");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountBatchesForWhichResultIsPending(), parameters, Integer.class);
	}

	public Integer getCountTotalNonAssignedBatches() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQQuestionsCommonDao - getCountTotalNonAssignedBatches");
				   	
		LOGGER.debug("getting total number of non assigned batches");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalNonAssignedBatches(), parameters, Integer.class);
	}
	
}

