package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import com.skill.India.dto.AlgorithmDto;
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
public class AlgorithmDao extends AbstractTransactionalDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AlgorithmDao.class);
    @Autowired
    private NonAssignedBatchesConfigSql nonAssignedBatchesConfigSql;

    private static AlgorithmDaoRowMapper ROW_MAPPER = new AlgorithmDaoRowMapper();

    public Collection<AlgorithmDto> algorithmDtoCollection(int batchId){
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AlgorithmDao - algorithmDtoCollection");
		LOGGER.debug("Parameters Received from Service are - 'batchId': " +batchId);
				   	
		LOGGER.debug("Adding values to arraylist of show interest for batch ID " + batchId);
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(nonAssignedBatchesConfigSql.getSelectSqlAgencyId(), parameters, ROW_MAPPER);
    }

    private static class AlgorithmDaoRowMapper implements RowMapper<AlgorithmDto>{
        @Override
        public AlgorithmDto mapRow(ResultSet resultSet, int i) throws SQLException {
            int agencyId = resultSet.getInt("agencyId");
            String state = resultSet.getString("state");
            String district = resultSet.getString("district");
            LOGGER.debug("The district is >>> " + agencyId);
            return new AlgorithmDto(agencyId, state, district);
        }
    }
}
