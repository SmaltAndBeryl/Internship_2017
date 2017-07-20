package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DropdownConfigSql;
import com.skill.India.dto.DropdownDto;
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
public class DropdownDao extends AbstractTransactionalDao{
    @Autowired
    private DropdownConfigSql dropdownConfigSql;

    private static DropdownRowMapper ROW_MAPPER = new DropdownRowMapper();

    public Collection<DropdownDto> getCollection(){
        Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().query(dropdownConfigSql.getSelectSql(), parameters, ROW_MAPPER);
    }
    private static class DropdownRowMapper implements RowMapper<DropdownDto> {
        @Override
        public DropdownDto mapRow(ResultSet resultSet, int rowNum)throws SQLException{
            String agencyName = resultSet.getString("agencyName");
            String agencyId = resultSet.getString("agencyId");
            return new DropdownDto(agencyName, agencyId);
        }
    }
}
