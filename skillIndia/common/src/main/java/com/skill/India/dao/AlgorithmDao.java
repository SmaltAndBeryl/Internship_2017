package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AlgorithmConfigSql;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import com.skill.India.dto.AlgorithmDto;
import org.slf4j.LoggerFactory;
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
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AlgorithmDao.class);
    @Autowired
    private NonAssignedBatchesConfigSql nonAssignedBatchesConfigSql;

    private static AlgorithmDaoRowMapper ROW_MAPPER = new AlgorithmDaoRowMapper();

    public Collection<AlgorithmDto> algorithmDtoCollection(int batchId){
        Map<String, Object> parameters = new HashMap<>();
        LOGGER.info("Adding values to arraylist of show interest for batch ID " + batchId);
        parameters.put("batchId", batchId);
        return getJdbcTemplate().query(nonAssignedBatchesConfigSql.getSelectSqlAgencyId(), parameters, ROW_MAPPER);
    }

    private static class AlgorithmDaoRowMapper implements RowMapper<AlgorithmDto>{
        @Override
        public AlgorithmDto mapRow(ResultSet resultSet, int i) throws SQLException {
            int agencyId = resultSet.getInt("agencyId");
            LOGGER.info("The district is >>> " + agencyId);
            return new AlgorithmDto(agencyId);
        }
    }
}
