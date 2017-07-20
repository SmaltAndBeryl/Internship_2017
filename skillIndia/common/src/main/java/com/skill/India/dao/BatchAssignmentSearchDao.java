package com.skill.India.dao;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.BatchAssignmentSearchConfigSql;
import com.skill.India.dto.BatchAssignmentSearchDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shitij on 07/08/17.
 */
@Repository
public class BatchAssignmentSearchDao extends AbstractTransactionalDao{

	@Autowired
	public BatchAssignmentSearchConfigSql batchAssignmentSelectSql;
	
	private static SearchBatchRowMapper ROW_MAPPER = new SearchBatchRowMapper();
	
	public Collection<BatchAssignmentSearchDto> executeSearch(int batchId)
	{
		
	  Map<String, Object> parameters = new HashMap<>();
	  parameters.put("batchId", batchId);
	  return getJdbcTemplate().query(batchAssignmentSelectSql.getSelectSqlInformationOfTheBatchId(), parameters , ROW_MAPPER );
	}
	
	private static class SearchBatchRowMapper implements RowMapper<BatchAssignmentSearchDto> {

		@Override
		public BatchAssignmentSearchDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String state= resultSet.getString("state");
			String batchEndDate = resultSet.getString("batchEndDate");
			String assessmentDate = resultSet.getString("assessmentDate");
			Integer batchId= resultSet.getInt("batchId");
			String agencyName = resultSet.getString("agencyName");
			
			return new BatchAssignmentSearchDto(state, batchEndDate, assessmentDate, batchId, agencyName);
		}

	}

}

