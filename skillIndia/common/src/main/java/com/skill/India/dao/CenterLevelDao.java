package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.CenterLevelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CenterLevelDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<CenterLevelDto> centerLevelDtos(){
        Map<String,Object> parameters = new HashMap<>();
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSqlCenterLevel(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<CenterLevelDto> {
        @Override
        public CenterLevelDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String numberOfClassrooms = resultSet.getString("numberOfClassrooms");
            String buildingType = resultSet.getString("buildingType");

            return new CenterLevelDto(
                    numberOfClassrooms,
                    buildingType
            );
        }
    }
}
