package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyHomepageConfigSql;


@Repository
public class AssessmentBodyHomepageFunctionalitiesDao extends AbstractTransactionalDao{

	@Autowired
	public AssessmentBodyHomepageConfigSql assessmentBodyHomepageConfigSql;
	
	public int putShowInterest(String batchId,String agencyId){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("batchId",batchId);
		parameters.put("agencyId",agencyId);
		return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlShowInterest(), parameters);
	}
	public int putApproveBatch(String from){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("batchId",from);
		return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlapproveBatchesAssessmentBody(), parameters);
	}
	public int putRejectBatch(String from){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("batchId",from);
		return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlrejectBatchesAssessmentBody(), parameters);
	}
	
}
