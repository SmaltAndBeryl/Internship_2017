package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.BatchAssignmentConfigSql;
import com.skill.India.dto.BatchAssignmentDto;


@Repository
public class BatchAssignmentDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchAssignmentDao.class);
	
	@Autowired
	public BatchAssignmentConfigSql BatchAssignmentConfigSql;

	private static final BatchAssignmentRowSelectRowMapper ROW_MAPPER = new BatchAssignmentRowSelectRowMapper();

	public Collection<BatchAssignmentDto> getproposedBatchesBatchAssignmentRowMapper() {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In BatchAssignmentDao - getproposedBatchesBatchAssignmentRowMapper");
				   	
		LOGGER.info("fetching Proposed batches details");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(BatchAssignmentConfigSql.getSelectSqlproposedBatchesBatchAssignment(), parameters,
				ROW_MAPPER);
	}
	
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper() {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In BatchAssignmentDao - getapprovedBatchesBatchAssignmentRowMapper");
				   	
		LOGGER.info("fetching Approved batches details");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(BatchAssignmentConfigSql.getSelectSqlapprovedBatchesBatchAssignment(), parameters,
				ROW_MAPPER);
	}	
	
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper() {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In BatchAssignmentDao - getrejectedBatchesBatchAssignmentRowMapper");
				   	
		LOGGER.info("fetching Rejected batches details");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(BatchAssignmentConfigSql.getSelectSqlrejectedBatchesBatchAssignment(), parameters,
				ROW_MAPPER);
	}

		

	
	private static class BatchAssignmentRowSelectRowMapper implements RowMapper<BatchAssignmentDto> {

		@Override
		public BatchAssignmentDto mapRow(ResultSet rs, int rowNum)
			throws SQLException {
			Integer batchId = rs.getInt("batchId");
			String location = rs.getString("location");
			String batchEndDate = rs.getString("batchEndDate");
			String assessmentDate = rs.getString("assessmentDate");
			String agencyName = rs.getString("agencyName");
			
			return new BatchAssignmentDto(batchId, location, batchEndDate, assessmentDate, agencyName);
		}
  
	}

}