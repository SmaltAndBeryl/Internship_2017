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
import com.skill.India.config.DataImportConfigSql;
import com.skill.India.dto.DataImportGetBatchInfoDto;

@Repository
public class DataImportFindBatchUsingBatchId extends AbstractTransactionalDao {
	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;

	private static final DataImportRowSelectRowMapper ROW_MAPPER = new DataImportRowSelectRowMapper();
	
	public Collection<DataImportGetBatchInfoDto> getDataOfBatchUsingBatchId(String batchId){
		Map<String,Object> parameters= new HashMap<String, Object>();
		parameters.put("batchId",batchId);
		return getJdbcTemplate().query(dataImportConfigSql.getBatchInfoUsingBatchId(), parameters,
			ROW_MAPPER);
		
	}
	
	private static class DataImportRowSelectRowMapper implements RowMapper<DataImportGetBatchInfoDto> {

		@Override
		public DataImportGetBatchInfoDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			Integer batchId = resultSet.getInt("batchId");
			String batchName = resultSet.getString("batchName");
			String batchStartDate = resultSet.getDate("batchStartDate").toString();
			String batchEndDate = resultSet.getDate("batchEndDate").toString();
			String trainingPartnerName = resultSet.getString("trainingPartnerName");

			return new DataImportGetBatchInfoDto(batchId, batchName,batchStartDate,batchEndDate,trainingPartnerName);
		}
	}
}
	