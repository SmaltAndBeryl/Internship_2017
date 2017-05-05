package com.skill.India.common;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractTransactionalDao {
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate
	 */
	protected NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	@Autowired
	@Qualifier(ApplicationDatasource.NAME)
	public void setJdbcTemplate(DataSource applicationDataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(
				applicationDataSource);
	}
	
	
	public void insert(String insertSql, MapSqlParameterSource parameters, String keyColumnName){
		
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(insertSql, parameters, generatedKeyHolder,new String[]{keyColumnName});
	}

	
}
