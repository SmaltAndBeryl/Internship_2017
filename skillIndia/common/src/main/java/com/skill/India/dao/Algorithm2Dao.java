package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AlgorithmConfigSql;
import com.skill.India.dto.Algorithm2Dto;
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
public class Algorithm2Dao extends AbstractTransactionalDao{
    @Autowired
    private AlgorithmConfigSql algorithmConfigSql;

    private static Algorithm2DaoRowMapper ROW_MAPPER = new Algorithm2DaoRowMapper();

    public Collection<Algorithm2Dto> getAgencyIdCollection(int batchId){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("batchId", batchId);
        return getJdbcTemplate().query(algorithmConfigSql.getGetAgencyIdSelectSql(), parameters, ROW_MAPPER);
    }


    private static class Algorithm2DaoRowMapper implements RowMapper<Algorithm2Dto>{
        @Override
        public Algorithm2Dto mapRow(ResultSet rs, int rowNum) throws SQLException {
            int agencyId = rs.getInt("agencyId");
            int batchId = rs.getInt("batchId");
            String agencyName = rs.getString("agencyName");
            return new Algorithm2Dto(agencyId, batchId, agencyName);
        }
    }
}
