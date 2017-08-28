package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DownloadExcelConfigSql;
import com.skill.India.dto.DownloadExcelDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Repository
public class DownloadExcelDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadExcelDao.class);
	
	@Autowired
    public DownloadExcelConfigSql updateConfigSql;
	
	private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
	public Collection<DownloadExcelDto> getUpateRowMapper() {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DownloadExcelDao - getUpateRowMapper");
				   	
		LOGGER.info("getting CSV location stored at machine");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
				
      //return getJdbcTemplate().query
        LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(updateConfigSql.getSelectSql(), parameters, 
        		ROW_MAPPER);
}
	
	private static class UpdateRowSelectRowMapper implements RowMapper<DownloadExcelDto> {

        @Override
        public DownloadExcelDto mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
        	
        	String CSVLocation = resultSet.getString("CSVLocation");
//          CSVLocation = "Random CSV Location";
        	
        	return new DownloadExcelDto(CSVLocation);
        }


    }
}