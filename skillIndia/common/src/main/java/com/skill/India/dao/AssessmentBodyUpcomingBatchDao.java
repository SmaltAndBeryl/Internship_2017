package com.skill.India.dao;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyUpcomingBatchConfigSql;
import com.skill.India.dto.AssessmentBodyUpcomingBatchDto;



//import com.skill.India.dto.PetDto;
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

/**
 * Created by shubham on 6/20/17.
 */
@Repository
public class AssessmentBodyUpcomingBatchDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);
	
	

    @Autowired
    public AssessmentBodyUpcomingBatchConfigSql updateConfigSql;

    private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
    
    
    public Collection<AssessmentBodyUpcomingBatchDto> getUpateRowMapper() {
    	LOGGER.info("Code reached");
        Map<String, Object> parameters = new HashMap<>();
        //return getJdbcTemplate().query
      
        return getJdbcTemplate().query(updateConfigSql.getSelectSql(), parameters, 
        		ROW_MAPPER);
        
        
        
    }

  

    private static class UpdateRowSelectRowMapper implements RowMapper<AssessmentBodyUpcomingBatchDto> {

        @Override
        public AssessmentBodyUpcomingBatchDto mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            String batch_id = resultSet.getString("batch_id");
            String ab_name = resultSet.getString("ab_name");
            String email = resultSet.getString("email");
            Integer contact_no = resultSet.getInt("contact_no");
            String assessment_date = resultSet.getString("assessment_date");
            String district = resultSet.getString("district");
            String state = resultSet.getString("state");
            String no_of_candidate = resultSet.getString("no_of_candidate");

//            batch_id = "Random Batch Id";
            
        	return new AssessmentBodyUpcomingBatchDto(batch_id, ab_name, email, contact_no, assessment_date, district, state, no_of_candidate);
        }


    }
}