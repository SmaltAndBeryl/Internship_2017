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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CertificateImportHistorydao.class);
	
	@Autowired
	public CertificateImportHistoryConfigSql config;
	
	private static final CertificateImportHistoryRowMapper ROW_MAPPER = new CertificateImportHistoryRowMapper();

	public Collection<CertificateImportHistorydto> getUpdateHistory() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In CertificateImportHistorydao - getUpdateHistory");
				   	
		LOGGER.debug("Getting Certificate upload history");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
	}

 private static class CertificateImportHistoryRowMapper implements RowMapper<CertificateImportHistorydto> {

		@Override
		public CertificateImportHistorydto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
		    String batchId = resultSet.getString("BatchID");
		    Date batchEndDate = resultSet.getDate("BatchEndDate");
			String certificateName = resultSet.getString("CertificateName");
			Date certificateUploadDate = resultSet.getDate("CertificateUploadDate");
			String userId = resultSet.getString("UserId");

			return new CertificateImportHistorydto(batchId,batchEndDate, certificateName, certificateUploadDate, userId);
		}

	}
}
