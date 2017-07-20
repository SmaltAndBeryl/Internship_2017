package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.UserIdtoApplicationIdConfigSql;


@Repository
public class UserIdtoApplicationIdDao extends AbstractTransactionalDao {
	
	@Autowired
	private UserIdtoApplicationIdConfigSql userIdtoApplicationIdConfigSql;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserIdtoApplicationIdDao.class);

	public Integer getApplicationId(String userId){
		LOGGER.info("UserId to send in Sql query");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId", userId);
		return getJdbcTemplate().queryForObject(userIdtoApplicationIdConfigSql.getSelectSql(), parameters, Integer.class);

	}
}
