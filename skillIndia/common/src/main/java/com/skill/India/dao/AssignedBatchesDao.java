package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssignedBatchesConfigSql;
import com.skill.India.dto.AssignedBatchesDto;


@Repository
public class AssignedBatchesDao extends AbstractTransactionalDao {
	
private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);
	
	@Autowired
    public AssignedBatchesConfigSql updateConfigSql;

	private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();

	public Collection<AssignedBatchesDto> getupdateRowMapper() {
		LOGGER.info("Code reached");
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(updateConfigSql.getSelectSql(), parameters,
				ROW_MAPPER);
	}
		
	
	private static class UpdateRowSelectRowMapper implements RowMapper<AssignedBatchesDto> {

		@Override
		public AssignedBatchesDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String batch_id = resultSet.getString("batch_id");
			Integer total_candidates = resultSet.getInt("total_candidates");
			String job_role = resultSet.getString("job_role");
		

        	Timestamp batch_end_date = resultSet.getTimestamp("batch_end_date");
			Timestamp assessment_date = resultSet.getTimestamp("assessment_date");
			String recommended_ab = resultSet.getString("recommended_ab");
			String assigned_ab = resultSet.getString("assigned_ab");
			return new AssignedBatchesDto(batch_id,total_candidates,job_role,batch_end_date,assessment_date,recommended_ab,assigned_ab);
		}

	}

}
