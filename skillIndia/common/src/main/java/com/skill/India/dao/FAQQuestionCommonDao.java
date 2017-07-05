package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.FAQConfigSql;

@Controller
public class FAQQuestionCommonDao extends AbstractTransactionalDao{
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	public Integer getTotalTrainingCentresInAState(String state)  {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("state", state);
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlTotalTrainingCentresInAState(), parameters, Integer.class);
	}
	
	public Integer getCountOfTotalTrainingCentresConductingTraining()  {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().queryForObject(fAQConfigSql.getSelectSqlCountTrainingCentresConductingTraining(), parameters, Integer.class);
	}
}
