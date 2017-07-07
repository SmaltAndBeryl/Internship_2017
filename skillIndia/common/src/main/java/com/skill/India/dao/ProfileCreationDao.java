package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ProfileCreationConfigSql;

import com.skill.India.dto.ProfileCreationDataPopulateDto;


@Repository
public class ProfileCreationDao extends AbstractTransactionalDao{
	
	@Autowired
	private ProfileCreationConfigSql profileCreationConfig;
	
	private static final ProfileCreationDataPopulateRowMapper ROW_MAPPER = new ProfileCreationDataPopulateRowMapper();

		
	
	public ProfileCreationDataPopulateDto getUserData(String userId){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId",userId);
		return getJdbcTemplate().queryForObject(profileCreationConfig.getPopulateData(), parameters, ROW_MAPPER);
	}

	
	private static class ProfileCreationDataPopulateRowMapper implements RowMapper<ProfileCreationDataPopulateDto> {
		
		@Override
		public ProfileCreationDataPopulateDto mapRow(ResultSet resultSet, int rowNum)throws SQLException 
		{			
					String organizationName = resultSet.getString("organizationName");
					String spocName = resultSet.getString("spocName");
					return new ProfileCreationDataPopulateDto(organizationName,spocName);
					
		}
	
	
	}
}
