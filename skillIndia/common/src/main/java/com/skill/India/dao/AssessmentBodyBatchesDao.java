package com.skill.India.dao;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyBatchesConfigSql;
import com.skill.India.dto.AssessmentBodyBatchesDto;




//import com.skill.India.dto.PetDto;
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

/**
 * Created by shubham on 6/20/17.
 */
@Repository
public class AssessmentBodyBatchesDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);
	
	

    @Autowired
    public AssessmentBodyBatchesConfigSql updateConfigSql;

    private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
    
    
    public Collection<AssessmentBodyBatchesDto> getUpdateRowMapper() {
    	LOGGER.info("Code reached");
        Map<String, Object> parameters = new HashMap<>();
        //return getJdbcTemplate().query
      
        return getJdbcTemplate().query(updateConfigSql.getSelectSql(), parameters, 
        		ROW_MAPPER);       
    }

  

    private static class UpdateRowSelectRowMapper implements RowMapper<AssessmentBodyBatchesDto> {

        @Override
        public AssessmentBodyBatchesDto mapRow(ResultSet resultSet, int rowNum) throws SQLException 
        
        //String query = "select * from updatetable where assessment_date > CURDATE()";
             {
            String batchID = resultSet.getString("batchID");
            String abName = resultSet.getString("abName");
            String email = resultSet.getString("email");
            Integer contactNo = resultSet.getInt("contactNo");
            Date assessmentDate = resultSet.getDate("assessmentDate");
            String district = resultSet.getString("district");
            String state = resultSet.getString("state");
            String noOfCandidate = resultSet.getString("noOfCandidate");

//            batch_id = "Random Batch Id";
            
         
        	return new AssessmentBodyBatchesDto(batchID, abName, email, contactNo, assessmentDate, district, state, noOfCandidate);
        }
             

    }
}