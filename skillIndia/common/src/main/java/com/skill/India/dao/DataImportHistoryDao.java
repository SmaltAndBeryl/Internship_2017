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
import com.skill.India.config.DataImportHistoryConfigSql;
import com.skill.India.dto.DataImportHistoryDto;

@Repository
public class DataImportHistoryDao extends AbstractTransactionalDao{
	@Autowired
	public DataImportHistoryConfigSql config;

	private static final DataImportHistoryRowMapper ROW_MAPPER = new  DataImportHistoryRowMapper();

	public Collection<DataImportHistoryDto> getUpdateHistory() {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
	}

 private static class DataImportHistoryRowMapper implements RowMapper<DataImportHistoryDto> {

		@Override
		public DataImportHistoryDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			Integer SerialNo = resultSet.getInt("SerialNo");
		    String CSVname = resultSet.getString("CSVname");
			String CSVType = resultSet.getString("CSVType");
			Date CSV_Upload_Date = resultSet.getDate("CSV_Upload_Date");
			String CSV_Upload_UserId = resultSet.getString("CSV_Upload_UserId");

			return new DataImportHistoryDto(SerialNo, CSVname, CSVType, CSV_Upload_Date, CSV_Upload_UserId);
		}

	}
}
