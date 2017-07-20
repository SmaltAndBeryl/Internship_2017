package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AlgorithmConfigSql;
import com.skill.India.dto.AlgorithmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Repository
public class AlgorithmDao extends AbstractTransactionalDao {
    @Autowired
    private AlgorithmConfigSql algorithmConfigSql;

    private static AlgorithmDaoRowMapper ROW_MAPPER = new AlgorithmDaoRowMapper();

    public Collection<AlgorithmDto> getBatchIdCollection(String batchId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("batchId", batchId);
        return getJdbcTemplate().query(algorithmConfigSql.getGetBatchIdSelectSql(), parameters, ROW_MAPPER);
    }

    private static class AlgorithmDaoRowMapper implements RowMapper<AlgorithmDto>{
        @Override
        public AlgorithmDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            int batchId = rs.getInt("batchId");
            String state = rs.getString("state");
            String district = rs.getString("district");


            return new AlgorithmDto(batchId, state, district);
        }
    }
}
