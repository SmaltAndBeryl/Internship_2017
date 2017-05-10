package com.skill.India.common;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractTransactionalDao extends AbstractQueryDao {

		public int insert(String insertSql, MapSqlParameterSource parameters,
			String keyColumnName) {

		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		return getJdbcTemplate().update(insertSql, parameters, generatedKeyHolder,
				new String[] { keyColumnName });
	}

}
