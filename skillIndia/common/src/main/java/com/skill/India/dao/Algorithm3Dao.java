package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AlgorithmConfigSql;
import com.skill.India.dto.Algorithm3Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/18/2017.
 */
@Repository
public class Algorithm3Dao extends AbstractTransactionalDao {
    @Autowired
    private AlgorithmConfigSql algorithmConfigSql;


    private static Algorithm3DaoRowMapper ROW_MAPPER = new Algorithm3DaoRowMapper();

    public Collection<Algorithm3Dto> getAssessorIdCollection(){
        Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().query(algorithmConfigSql.getGetAssessorIdSelectSql(), parameters, ROW_MAPPER);
    }

    private static class Algorithm3DaoRowMapper implements RowMapper<Algorithm3Dto>{
        @Override
        public Algorithm3Dto mapRow(ResultSet rs, int rowNum) throws SQLException {
            String state = rs.getString("state");
            String district = rs.getString("district");
            String agencyName = rs.getString("agencyName");
            return new Algorithm3Dto(state, district, agencyName);
        }
    }
}
