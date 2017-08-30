package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AlgorithmConfigSql;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import com.skill.India.dto.Algorithm3Dto;

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
public class Algorithm3Dao extends AbstractTransactionalDao {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(Algorithm3Dao.class);
	
	@Autowired
    private NonAssignedBatchesConfigSql nonAssignedBatchesConfigSql;

    private static Algorithm3DaoRowMapper ROW_MAPPER = new Algorithm3DaoRowMapper();

    public Collection<Algorithm3Dto> getAssessorIdCollection(String recommendedAgency){
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In Algorithm3Dao - getAssessorIdCollection");
				   	
		LOGGER.info("Getting assessor parameters");
		
		LOGGER.info("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("agencyId", recommendedAgency);
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(nonAssignedBatchesConfigSql.getSelectSqlAgencyName(), parameters, ROW_MAPPER);
    }

    private static class Algorithm3DaoRowMapper implements RowMapper<Algorithm3Dto>{
        @Override
        public Algorithm3Dto mapRow(ResultSet rs, int rowNum) throws SQLException {
            String agencyName = rs.getString("agencyName");
            return new Algorithm3Dto(agencyName);
        }
    }
}
