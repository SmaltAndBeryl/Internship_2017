package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.LoginConfig;

@Repository
public class GetApplicationStateDao extends AbstractTransactionalDao{

	@Autowired
	private LoginConfig loginConfig;
	
	
	public String getApplicationState(String userId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId",userId);
		return getJdbcTemplate().queryForObject(loginConfig.getGetApplicationState(), parameters, String.class);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		}
	
}
