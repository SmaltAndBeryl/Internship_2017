package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.config.ProfileCreationTPABCommonConfigSql;

@Repository
public class GetUserRoleDao extends AbstractTransactionalDao {

	@Autowired
	private ProfileCreationTPABCommonConfigSql profileCreationTPABCommonConfigSql;
	
	@Autowired
	private SessionUserUtility sessionUserUtility; 
	
	public String getUserRole(String userId)
	{
		/*
		 * Getting UserId from Session and returning UserRole 
		 */
		
		try{
		Map<String , Object> parameters = new HashMap<String, Object>();
	//	parameters.put("userId",sessionUserUtility.getSessionMangementfromSession().getUsername());
		parameters.put("userId", userId);
		return getJdbcTemplate().queryForObject(profileCreationTPABCommonConfigSql.getGetUserRole(), parameters, String.class);
		}
		catch(Exception e)
		{
			/*
			 * Error getting UserRole from user Table 
			 */
			e.printStackTrace();
			return null;
		}
		}
}
