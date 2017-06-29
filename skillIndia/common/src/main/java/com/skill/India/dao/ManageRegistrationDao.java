package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ManageRegistrationConfig;

@Repository
public class ManageRegistrationDao extends AbstractTransactionalDao {

	@Autowired
	public ManageRegistrationConfig config;

		public int putUpdateRowMapper(int id) {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("app_state", "pending");
		
			return getJdbcTemplate().update(config.getUpdateSql(), parameters);
			
		}
	
}

