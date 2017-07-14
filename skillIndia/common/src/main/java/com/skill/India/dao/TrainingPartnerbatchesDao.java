package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.TrainingPartnerConfigSql;
import com.skill.India.dto.TrainingPartnerBatchesDto;

/**
 * @author Rachit-PC
 *
 */
@Repository
public class TrainingPartnerbatchesDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);
	
	

    @Autowired
    public TrainingPartnerConfigSql updateConfigSql;

    private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
    
    
    public Collection<TrainingPartnerBatchesDto> getUpdateRowMapper() {
    	LOGGER.info("Code reached");
        Map<String, Object> parameters = new HashMap<>();
        //return getJdbcTemplate().query
      
        return getJdbcTemplate().query(updateConfigSql.getSelectSqlOfBatches(), parameters, 
        		ROW_MAPPER); 
    }

  

    private static class UpdateRowSelectRowMapper implements RowMapper<TrainingPartnerBatchesDto> {

        @Override
        public TrainingPartnerBatchesDto mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            String batchId = resultSet.getString("batchId");
            Date completionDate = resultSet.getDate("batchEndDate");
            String instructorName = resultSet.getString("trainerName");
            Integer noOfCandidates = resultSet.getInt("totalCandidatesInBatch");

            
        	return new TrainingPartnerBatchesDto(batchId, completionDate, instructorName, noOfCandidates);
        }


    }

}
