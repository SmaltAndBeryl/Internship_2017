package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DropdownConfigSql;
import com.skill.India.dto.DropdownDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Repository
public class DropdownDao extends AbstractTransactionalDao{
    
	private static final Logger LOGGER = LoggerFactory.getLogger(DropdownDao.class);
	
	@Autowired
    private DropdownConfigSql dropdownConfigSql;

    private static DropdownRowMapper ROW_MAPPER = new DropdownRowMapper();

    public Collection<DropdownDto> getCollection(){
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DropdownDao - getCollection");
				   	
		LOGGER.debug("getting list of all agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(dropdownConfigSql.getSelectSql(), parameters, ROW_MAPPER);
    }
    private static class DropdownRowMapper implements RowMapper<DropdownDto> {
        @Override
        public DropdownDto mapRow(ResultSet resultSet, int rowNum)throws SQLException{
            String agencyName = resultSet.getString("agencyName");
            String agencyId = resultSet.getString("agencyId");
            return new DropdownDto(agencyName, agencyId);
        }
    }
}
