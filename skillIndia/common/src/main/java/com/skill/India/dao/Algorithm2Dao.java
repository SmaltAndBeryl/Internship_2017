package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import com.skill.India.dto.Algorithm2Dto;

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
 * Created by Alkesh srivastav on 7/18/2017.
 */
@Repository
public class Algorithm2Dao extends AbstractTransactionalDao{
    
	private static final Logger LOGGER = LoggerFactory.getLogger(Algorithm2Dao.class);
	
	@Autowired
    private NonAssignedBatchesConfigSql nonAssignedBatchesConfigSql;

    private static Algorithm2DaoRowMapper ROW_MAPPER = new Algorithm2DaoRowMapper();

    public Collection<Algorithm2Dto> getAgencyIdCollection(){
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In Algorithm2Dao - getAgencyIdCollection");
//		LOGGER.debug("Parameters Received from Service are - 'batchId': " +batchId);
				   	
		LOGGER.debug("Getting all agency which have shown interest ");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
//		parameters.put("batchId", batchId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(nonAssignedBatchesConfigSql.getSelectSqlAgencyIdAll(), parameters, ROW_MAPPER);
    }


    private static class Algorithm2DaoRowMapper implements RowMapper<Algorithm2Dto>{
        @Override
        public Algorithm2Dto mapRow(ResultSet rs, int rowNum) throws SQLException {
            int agencyId = rs.getInt("agencyId");
            String state = rs.getString("state");
            String district = rs.getString("district");
            return new Algorithm2Dto(agencyId, state, district);
        }
    }
}
