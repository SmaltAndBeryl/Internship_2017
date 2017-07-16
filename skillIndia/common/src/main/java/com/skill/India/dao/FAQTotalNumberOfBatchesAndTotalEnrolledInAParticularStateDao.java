/**
 * 
 */
package com.skill.India.dao;

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
import com.skill.India.dto.FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto;

/**
 * @author Aashish sharma
 *
 */
@Repository
public class FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao extends AbstractTransactionalDao {

	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static final FAQTotalNumberOfBatchesAndTotalEnrolledRowMapper ROW_MAPPER = new FAQTotalNumberOfBatchesAndTotalEnrolledRowMapper();
	
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(String state) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("state", state);
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState(), parameters, ROW_MAPPER);
	}
	
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(String state,String batchType) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("state", state);
		parameters.put("batchType", batchType);
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(), parameters, ROW_MAPPER);
	}
	
	private static class FAQTotalNumberOfBatchesAndTotalEnrolledRowMapper implements RowMapper<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> {

		@Override
		public FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto mapRow(
				ResultSet rs, int rowNum) throws SQLException {
			
			Integer batches = rs.getInt("BATCHES");
			Integer totalCandidates = rs.getInt("TOTALCANDIDATES");
			
			if(totalCandidates==null)
				totalCandidates=0;
			
			return new FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto(batches, totalCandidates);
		}		
	}
}
