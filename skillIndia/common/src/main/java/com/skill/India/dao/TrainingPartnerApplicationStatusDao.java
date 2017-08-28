package com.skill.India.dao;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.TrainingPartnerApplicationStatusConfigSql;
import com.skill.India.dto.TrainingPartnerApplicationStatusDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Repository
public class TrainingPartnerApplicationStatusDao extends AbstractTransactionalDao
{

private static final Logger LOGGER = LoggerFactory.getLogger(TrainingPartnerApplicationStatusDao.class);
	
	

    @Autowired
    public TrainingPartnerApplicationStatusConfigSql updateConfigSql;

    private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
    
    
    public Collection<TrainingPartnerApplicationStatusDto> getUpateRowMapper(int applicationId) {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In TrainingPartnerApplicationStatusDao - getUpateRowMapper");
		LOGGER.info("Parameters Received from Service are - 'applicationId': " +applicationId);
		
		LOGGER.info("Getting Training Partner Application status");
		
		LOGGER.info("Creating HashMap object");
        Map<String, Object> parameters = new HashMap<>();
        LOGGER.info("object created successfully");
		
        LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("applicationId",applicationId);
		LOGGER.info("Parameters inserted");
		//return getJdbcTemplate().query
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(updateConfigSql.getSelectSql(), parameters, 
        		ROW_MAPPER);       
    }

  

    private static class UpdateRowSelectRowMapper implements RowMapper<TrainingPartnerApplicationStatusDto> {

        @Override
        public TrainingPartnerApplicationStatusDto mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            String applicationID = resultSet.getString("applicationID");
            String dateOfSubmission = resultSet.getString("dateOfSubmission");
            String trainingPartnerName = resultSet.getString("trainingPartnerName");
            String applicationState = resultSet.getString("applicationState");
            String comment = resultSet.getString("comment");

              
        	return new TrainingPartnerApplicationStatusDto(applicationID, dateOfSubmission,trainingPartnerName,applicationState, comment);
        }

    }
}
