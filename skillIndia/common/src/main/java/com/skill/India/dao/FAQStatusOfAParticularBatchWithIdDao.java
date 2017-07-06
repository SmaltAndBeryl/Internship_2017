package com.skill.India.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.FAQConfigSql;
import com.skill.India.dto.FAQStatusOfAParticularBatchWithIdDto;

@Repository
public class FAQStatusOfAParticularBatchWithIdDao extends AbstractTransactionalDao {
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	public static final FAQStatusOfAParticularBatchWithIdRowMapper ROW_MAPPER = new FAQStatusOfAParticularBatchWithIdRowMapper(); 
	
	public Collection<FAQStatusOfAParticularBatchWithIdDto> getStatusOfAParticularBatchWithId(Integer batchId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("batchId", batchId);
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
