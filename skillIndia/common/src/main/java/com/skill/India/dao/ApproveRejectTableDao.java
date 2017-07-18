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
import com.skill.India.config.ApproveRejectTableConfigSql;
import com.skill.India.dto.ApproveRejectTableDto;


@Repository
public class ApproveRejectTableDao extends AbstractTransactionalDao {
    
	@Autowired
	public ApproveRejectTableConfigSql config;

	private static final ApproveRejectSelectRowMapper ROW_MAPPER = new ApproveRejectSelectRowMapper();

	public Collection<ApproveRejectTableDto> getUpdateRowMapper(String applicationState) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("applicationState", applicationState);
		return getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
	}

 private static class ApproveRejectSelectRowMapper implements RowMapper<ApproveRejectTableDto> {

		@Override
		public ApproveRejectTableDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			Integer applicationId = resultSet.getInt("applicationId");
		    String applicationState= resultSet.getString("applicationState");
		    Boolean activeFlag = resultSet.getBoolean("activeFlag");
			Date dateOfSubmission = resultSet.getDate("dateOfSubmission");
            String userId = resultSet.getString("userId");

			return new ApproveRejectTableDto(applicationId, applicationState, activeFlag, dateOfSubmission,userId);
		}

	
 }
}