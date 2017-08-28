package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import com.skill.India.dto.NonAssignedBatchesDto;

import com.skill.India.service.NonAssignedBatchesService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Repository
public class NonAssignedBatchesDao extends AbstractTransactionalDao{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.dao.NonAssignedBatchesDao.class);

    static ArrayList<String> test = new ArrayList<>();

    @Autowired
    private NonAssignedBatchesConfigSql nonAssignedBatchesConfigSql;

    private static com.skill.India.dao.NonAssignedBatchesDao.NonAssignedBatchesDaoRowMapper ROW_MAPPER = new com.skill.India.dao.NonAssignedBatchesDao.NonAssignedBatchesDaoRowMapper();

    public Collection<NonAssignedBatchesDto> getCollection(ArrayList<String> rec) {
    	
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In NonAssignedBatchesDao - getCollection");
		LOGGER.info("Parameters Received from Service are - 'rec': " +rec);
		   	
		LOGGER.info("Select those batches which haven't been proposed and assigned to any agency ");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		if(test.isEmpty())
        {
            test = rec;
        }
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(nonAssignedBatchesConfigSql.getSelectSqlNonAssignedBatches(), parameters, ROW_MAPPER);
    }

    private static class NonAssignedBatchesDaoRowMapper implements RowMapper<NonAssignedBatchesDto> {

        int counter = 0;
        @Override
        public NonAssignedBatchesDto mapRow(ResultSet resultSet, int rowNum)throws SQLException{

            String batchID = resultSet.getString("batchId");
            String state = resultSet.getString("state");
            String batchEndDate = resultSet.getString("batchEndDate");
            String assessmentDate = resultSet.getString("assessmentDate");
            String recommendedAB = "Not get";

            if(!test.isEmpty()){
                if(counter >= test.size()){
                    LOGGER.info("The value of counter on after calls is " + String.valueOf(counter));
                    recommendedAB = "No Recommendations";
                }
                else {
                    LOGGER.info("The value of counter on before call is " + String.valueOf(counter));
                    recommendedAB = test.get(counter++);
                }

            }

            LOGGER.info("Getting agencyID show interest ");

            return new NonAssignedBatchesDto(batchID, state, batchEndDate, assessmentDate, recommendedAB);

        }
    }
}
