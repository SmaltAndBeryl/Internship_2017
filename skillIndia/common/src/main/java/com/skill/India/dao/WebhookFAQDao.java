package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.WebhookFAQConfig;

@Repository
public class WebhookFAQDao extends AbstractTransactionalDao{

	@Autowired
	private WebhookFAQConfig webhookFAQConfig;
	
	public int numberOfAssessedPmkvyCandidates() {
		Map<String,Object> parameters = new HashMap<>();
		return getJdbcTemplate().queryForObject(webhookFAQConfig.getCandidatesAssessedPmkvy(), parameters, Integer.class);
	}
}
