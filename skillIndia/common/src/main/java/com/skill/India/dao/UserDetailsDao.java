package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractQueryDao;
import com.skill.India.config.UserConfigSql;
import com.skill.India.dto.UserDetailsDto;

@Repository
public class UserDetailsDao extends AbstractQueryDao {
	
	@Autowired
	private UserConfigSql userConfiSql;

	public UserDetailsDto loadUserByUsername(String userName) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("username", userName);
//		getJdbcTemplate().execute(userConfiSql.getSelectSql(), map, action)
//		
		return null;
	}

}
