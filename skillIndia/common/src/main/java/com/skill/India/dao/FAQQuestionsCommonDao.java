package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.FAQConfigSql;

@Repository
public class FAQQuestionsCommonDao extends AbstractTransactionalDao{
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	public Integer getTotalTrainingCentresInAState(String state)  {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("state", state);
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalTrainingCentresInAState(), parameters, Integer.class);
	}
	
	public Integer getCountOfTotalTrainingCentresConductingTraining()  {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTrainingCentresConductingTraining(), parameters, Integer.class);
	}
	
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(String month)  {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("month", month);
		Integer count= getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountOfCandidatesAssessmentUpcomingForAMonth(), parameters, Integer.class);
		if(count==null)
			return 0;
		else return count;
	}
	
	public String getNameOfAgencyToWhichABatchIsAssigned(Integer batchId)throws EmptyResultDataAccessException {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("batchId", batchId);
		try
		{
			return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlNameOfAgencyToWhichABatchIsAssigned(), parameters, String.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}
	
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(String agencyName)throws EmptyResultDataAccessException {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("agencyName", agencyName);
		try
		{
			return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalOfBatchesAssignedToAAssessmentAgency(), parameters, Integer.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		
	}
	
	public Integer getCountTotalNumberOfBatchesInAParticularState(String state) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("state", state);
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalNumberOfBatchesInAParticularState(), parameters, Integer.class);
	}
	
	public Integer getCountTotalNumberOfBatchesInAParticularScheme(String batchType) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("batchType", batchType);
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalNumberOfBatchesInAParticularScheme(), parameters, Integer.class);
	}
	
	public Integer getCountTotalAssessorsOfAParticularAgencyInAParticularState(String agencyName,String state) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("agencyName", agencyName);
		parameters.put("state", state);
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState(), parameters, Integer.class);
	}
	
	public Integer getCountBatchesForWhichResultIsPending() {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountBatchesForWhichResultIsPending(), parameters, Integer.class);
	}

	public Integer getCountTotalNonAssignedBatches() {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTotalNonAssignedBatches(), parameters, Integer.class);
	}
}

