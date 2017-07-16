/**
 * 
 */
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
import com.skill.India.config.CertificateImportHistoryConfigSql;
import com.skill.India.dto.CertificateImportHistorydto;


/**
 * @author Rachit-PC
 *
 */
@Repository
public class CertificateImportHistorydao extends AbstractTransactionalDao{
	@Autowired
	public CertificateImportHistoryConfigSql config;
	
	private static final CertificateImportHistoryRowMapper ROW_MAPPER = new CertificateImportHistoryRowMapper();

	public Collection<CertificateImportHistorydto> getUpdateHistory() {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
	}

 private static class CertificateImportHistoryRowMapper implements RowMapper<CertificateImportHistorydto> {

		@Override
		public CertificateImportHistorydto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
		    String batchId = resultSet.getString("BatchID");
			String certificateName = resultSet.getString("CertificateName");
			Date certificateUploadDate = resultSet.getDate("CertificateUploadDate");
			String userId = resultSet.getString("UserId");

			return new CertificateImportHistorydto(batchId, certificateName, certificateUploadDate, userId);
		}

	}
}
