package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import com.skill.India.dto.NonAssignedBatchesDto;

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

//    public Collection<NonAssignedBatchesDto> getCollection(ArrayList<String> rec) {
    public Collection<NonAssignedBatchesDto> getCollection() {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In NonAssignedBatchesDao - getCollection");
//		LOGGER.info("Parameters Received from Service are - 'rec': " +rec);
		   	
		LOGGER.info("Select those batches which haven't been proposed and assigned to any agency ");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");


		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(nonAssignedBatchesConfigSql.getSelectSqlNonAssignedBatches(), parameters, ROW_MAPPER);
    }


    private static class NonAssignedBatchesDaoRowMapper implements RowMapper<NonAssignedBatchesDto> {

//        int counter = 0;
        @Override
        public NonAssignedBatchesDto mapRow(ResultSet resultSet, int rowNum)throws SQLException{

            String batchID = resultSet.getString("batchId");
            String state = resultSet.getString("state");
            String district = resultSet.getString("district");
            String batchEndDate = resultSet.getString("batchEndDate");
            String assessmentDate = resultSet.getString("assessmentDate");
            String recommendedAB = "No Recommendations";

            LOGGER.info("Getting agencyID show interest ");

            return new NonAssignedBatchesDto(batchID, state, district, batchEndDate, assessmentDate, recommendedAB);

        }
    }
}
