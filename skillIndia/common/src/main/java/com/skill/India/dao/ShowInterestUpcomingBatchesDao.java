package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ShowInterestUpcomingBatchesConfigSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
@Repository
public class ShowInterestUpcomingBatchesDao extends AbstractTransactionalDao 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ShowInterestUpcomingBatchesDao.class);
@Autowired
public ShowInterestUpcomingBatchesConfigSql insertConfigSql;

//private static final InsertRowSelectRowMapper ROW_MAPPER = new InsertRowSelectRowMapper();


public int insertShowInterestUpcomingBatches(int id) {
	
	LOGGER.info("Request Received from Service");
	LOGGER.info("In ShowInterestUpcomingBatchesDao - insertShowInterestUpcomingBatches");
	LOGGER.info("Parameters Received from Service are - 'id': " +id);
	   	
	LOGGER.info("Marking the Show Interest for Batch Id with Agency Id with TimeStamp");
	
	//Map<String, Object> parameters = new HashMap<>();
	//parameters.put("batch",27);
	//parameters.put("batch_id", "BA_27");

	
	LOGGER.info("Creating HashMap object");
	Map<String, Object> parameters = new HashMap<>();
	LOGGER.info("object created successfully");
	
	
	LOGGER.info("Creating TimeStamp object");
	Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
	LOGGER.info("Successfully created and initialized");
	
	LOGGER.info("Inserting parameters to HashMap object");
	parameters.put("batch_id",id);
	parameters.put("time_stamp", timeStamp);
	LOGGER.info("Parameters inserted");
	
	LOGGER.info("Executing SQL query and returning response");
	return getJdbcTemplate().update(insertConfigSql.getinsertSql(), parameters);
//	return new ShowInterestUpcomingBatchesDto(id, batch_id);

}
}

/*public static class InsertRowSelectRowMapper implements RowMapper<ShowInterestUpcomingBatchesDto> {

    @Override
    public ShowInterestUpcomingBatchesDto mapRow(ResultSet resultSet, int rowNum)
            throws SQLException {
    	Integer id = resultSet.getInt("id");
        String batch_id = resultSet.getString("batch_id");
     //        batch_id = "Random Batch Id";
        
    	return new ShowInterestUpcomingBatchesDto( id ,batch_id);

}}
}
*/