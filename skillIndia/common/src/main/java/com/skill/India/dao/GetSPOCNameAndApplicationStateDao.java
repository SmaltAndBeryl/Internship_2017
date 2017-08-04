package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.LoginConfig;
import com.skill.India.dto.GetSPOCNameAndApplicationStateDto;

@Repository
public class GetSPOCNameAndApplicationStateDao extends AbstractTransactionalDao {

	@Autowired
	private LoginConfig loginConfig;
	
	private static final GetSPOCNameAndApplicationStateRowMapper ROW_MAPPER = new GetSPOCNameAndApplicationStateRowMapper();
	
	public Collection<GetSPOCNameAndApplicationStateDto> getSPOCNameAndApplicationState(String userId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId",userId);
		return getJdbcTemplate().query(loginConfig.getGetSPOCNameAndApplicationStatus(), parameters,ROW_MAPPER);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
	private static class GetSPOCNameAndApplicationStateRowMapper implements RowMapper<GetSPOCNameAndApplicationStateDto> {
		
		@Override
		public GetSPOCNameAndApplicationStateDto mapRow(ResultSet rs, int rowNum)
		throws SQLException {
		
		String sPOCName = rs.getString("sPOCName");
		String applicationState = rs.getString("applicationState");
		
		
		return new GetSPOCNameAndApplicationStateDto(sPOCName, applicationState);
		}
	
	
	
}

}