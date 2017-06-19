package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PetPOCConfigSql;
import com.skill.India.dto.PetDto;

@Repository
public class PetPOCDao extends AbstractTransactionalDao {

	@Autowired
	public PetPOCConfigSql config;

	private static final PetRowSelectRowMapper ROW_MAPPER = new PetRowSelectRowMapper();

	public Collection<PetDto> getPetRowMapper() {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
	}

	public int  insertPOC() {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("lastName", "Chawla");
		parameters.put("firstName", "Achin");
		parameters.put("age", 10);
		return insert(config.getInsertSql(), parameters, "ID");
	}
		

	
	private static class PetRowSelectRowMapper implements RowMapper<PetDto> {

		@Override
		public PetDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String name = resultSet.getString("name");
			String owner = resultSet.getString("owner");
			String species = resultSet.getString("species");
			String sex = resultSet.getString("sex");

			Timestamp birth = resultSet.getTimestamp("birth");
			Timestamp death = resultSet.getTimestamp("death");

			return new PetDto(name, owner, species, birth, death);
		}

	}

}
