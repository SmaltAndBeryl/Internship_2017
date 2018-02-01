package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyApplicationStatusConfigSql;
import com.skill.India.dto.AssessmentBodyApplicationStatusDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Repository
public class AssessmentBodyApplicationStatusDao extends AbstractTransactionalDao {

	
private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyApplicationStatusDao.class);
	
	@Autowired
    public AssessmentBodyApplicationStatusConfigSql updateConfigSql;

    private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
    
    
    public Collection<AssessmentBodyApplicationStatusDto> getUpateRowMapper(int applicationId) {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AssessmentBodyApplicationStatusDao - getUpateRowMapper");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.debug("Getting application status of Assessment Body");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("applicationId",applicationId);
		LOGGER.debug("Parameters inserted");
		//return getJdbcTemplate().query
      		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(updateConfigSql.getSelectSql(), parameters, 
        		ROW_MAPPER);       
    }

  

    private static class UpdateRowSelectRowMapper implements RowMapper<AssessmentBodyApplicationStatusDto> {

        @Override
        public AssessmentBodyApplicationStatusDto mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            String applicationID = resultSet.getString("applicationID");
            Date dateOfSubmission = resultSet.getDate("dateOfSubmission");
            String assessmentAgencyName = resultSet.getString("organizationName");
            String applicationState = resultSet.getString("applicationState");
            String comment = resultSet.getString("comment");

              
        	return new AssessmentBodyApplicationStatusDto(applicationID, dateOfSubmission,assessmentAgencyName,applicationState, comment);
        }

    }
}
