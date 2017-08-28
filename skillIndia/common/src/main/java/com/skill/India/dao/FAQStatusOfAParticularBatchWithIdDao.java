package com.skill.India.dao;

import java.sql.Date;
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
import com.skill.India.config.FAQConfigSql;
import com.skill.India.dto.FAQStatusOfAParticularBatchWithIdDto;

@Repository
public class FAQStatusOfAParticularBatchWithIdDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQStatusOfAParticularBatchWithIdDao.class);
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	public static final FAQStatusOfAParticularBatchWithIdRowMapper ROW_MAPPER = new FAQStatusOfAParticularBatchWithIdRowMapper(); 
	
	public Collection<FAQStatusOfAParticularBatchWithIdDto> getStatusOfAParticularBatchWithId(Integer batchId) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQStatusOfAParticularBatchWithIdDao - getStatusOfAParticularBatchWithId");
		LOGGER.info("Parameters Received from Service are - 'batchId': " +batchId);
				   	
		LOGGER.info("getting status of a batch with Batch Id");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlStatusOfAParticularBatchWithId(), parameters, ROW_MAPPER);
						
	}
	
	public static class FAQStatusOfAParticularBatchWithIdRowMapper implements RowMapper<FAQStatusOfAParticularBatchWithIdDto> {

		@Override
		public FAQStatusOfAParticularBatchWithIdDto mapRow(ResultSet rs,int rowNum) throws SQLException {
		
			Integer batchId = rs.getInt("batchId");
			
			String trainingPartnerName = rs.getString("trainingPartnerName");
			
			Date batchStartDate = rs.getDate("batchStartDate");
			
			Date batchEndDate = rs.getDate("batchEndDate");
			
			Date assessmentDate = rs.getDate("assessmentDate");
			
			String resultApproved = rs.getString("resultApproved");
			
			return new FAQStatusOfAParticularBatchWithIdDto(batchId, trainingPartnerName, batchStartDate, batchEndDate, assessmentDate, resultApproved);
		}
		
	}

}
