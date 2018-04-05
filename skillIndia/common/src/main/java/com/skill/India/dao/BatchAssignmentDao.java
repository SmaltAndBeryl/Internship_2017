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
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In BatchAssignmentDao - getproposedBatchesBatchAssignmentRowMapper");
				   	
		LOGGER.debug("fetching Proposed batches details");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(BatchAssignmentConfigSql.getSelectSqlproposedBatchesBatchAssignment(), parameters,
				ROW_MAPPER);
	}
	
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In BatchAssignmentDao - getapprovedBatchesBatchAssignmentRowMapper");
				   	
		LOGGER.debug("fetching Approved batches details");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(BatchAssignmentConfigSql.getSelectSqlapprovedBatchesBatchAssignment(), parameters,
				ROW_MAPPER);
	}	
	
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In BatchAssignmentDao - getrejectedBatchesBatchAssignmentRowMapper");
				   	
		LOGGER.debug("fetching Rejected batches details");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(BatchAssignmentConfigSql.getSelectSqlrejectedBatchesBatchAssignment(), parameters,
				ROW_MAPPER);
	}

		

	
	private static class BatchAssignmentRowSelectRowMapper implements RowMapper<BatchAssignmentDto> {

		@Override
		public BatchAssignmentDto mapRow(ResultSet rs, int rowNum)
			throws SQLException {
			String batchId = rs.getString("batchId");
			String location = rs.getString("location");
			String batchEndDate = rs.getString("batchEndDate");
			String assessmentDate = rs.getString("assessmentDate");
			String agencyName = rs.getString("agencyName");
			
			return new BatchAssignmentDto(batchId, location, batchEndDate, assessmentDate, agencyName);
		}
  
	}

}