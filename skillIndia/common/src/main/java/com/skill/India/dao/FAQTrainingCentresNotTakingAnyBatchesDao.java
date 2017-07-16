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
import com.skill.India.dto.FAQTrainingCentresNotTakingAnyBatchesDto;

/**
 * @author Aashish sharma
 *
 */
@Repository
public class FAQTrainingCentresNotTakingAnyBatchesDao extends AbstractTransactionalDao {
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static final FAQTrainingCentresNotTakingAnyBatchesRowMapper ROW_MAPPER = new FAQTrainingCentresNotTakingAnyBatchesRowMapper();
	
	public Collection<FAQTrainingCentresNotTakingAnyBatchesDto> getTotalTrainingCentresNotTakingAnyBatches() {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqTrainingCentresNotTakingAnyBatches(), parameters, ROW_MAPPER);
	}
	
	private static class FAQTrainingCentresNotTakingAnyBatchesRowMapper implements RowMapper<FAQTrainingCentresNotTakingAnyBatchesDto> {

		@Override
		public FAQTrainingCentresNotTakingAnyBatchesDto mapRow(ResultSet rs,
				int rowNum) throws SQLException {
			
			Integer centreId = rs.getInt("centreId");
			String centreName = rs.getString("centreName");
			
			return new FAQTrainingCentresNotTakingAnyBatchesDto(centreId, centreName);
		}
	}

}
