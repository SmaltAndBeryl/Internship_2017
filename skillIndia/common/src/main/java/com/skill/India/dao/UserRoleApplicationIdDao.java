package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.UserRoleApplicationIdDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRoleApplicationIdDao extends AbstractTransactionalDao{

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.dao.UserRoleApplicationIdDao.class);
    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<UserRoleApplicationIdDto> dataBeanCollectionUserRoleApplicationId(String applicationId){
    	LOGGER.debug("Trying to get user role based on application id");
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("applicationId", applicationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectUserRoleApplicationId(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<UserRoleApplicationIdDto> {
        @Override
        public UserRoleApplicationIdDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String userRole = resultSet.getString("userRole");
            String applicationId = resultSet.getString("applicationId");

            return new UserRoleApplicationIdDto(userRole, applicationId);
        }
    }
}
