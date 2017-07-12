package com.skill.India.dao;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyApplicationStatusConfigSql;
import com.skill.India.dto.AssessmentBodyApplicationStatusDto;

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
public class AssessmentBodyApplicationStatusDao extends AbstractTransactionalDao {

	
private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);
	
	

    @Autowired
    public AssessmentBodyApplicationStatusConfigSql updateConfigSql;

    private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
    
    
    public Collection<AssessmentBodyApplicationStatusDto> getUpateRowMapper() {
    	LOGGER.info("Code reached");
        Map<String, Object> parameters = new HashMap<>();
        //return getJdbcTemplate().query
      
        return getJdbcTemplate().query(updateConfigSql.getSelectSql(), parameters, 
        		ROW_MAPPER);       
    }

  

    private static class UpdateRowSelectRowMapper implements RowMapper<AssessmentBodyApplicationStatusDto> {

        @Override
        public AssessmentBodyApplicationStatusDto mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            String applicationID = resultSet.getString("applicationID");
            String dateOfSubmission = resultSet.getString("dateOfSubmission");
            String assessmentAgencyName = resultSet.getString("assessmentAgencyName");
            String applicationState = resultSet.getString("applicationState");
            String comment = resultSet.getString("comment");

              
        	return new AssessmentBodyApplicationStatusDto(applicationID, dateOfSubmission,assessmentAgencyName,applicationState, comment);
        }

    }
}
