package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.AssessmentBodyRegistrationIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AssessmentBodyRegistrationIdDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<AssessmentBodyRegistrationIdDto> assessmentBodyRegistrationIdRegistrationIdDtos(String applicationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("applicationId", applicationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectAssessmentBodyRegistrationId(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<AssessmentBodyRegistrationIdDto> {
        @Override
        public AssessmentBodyRegistrationIdDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String assessmentBodyRegistrationId = resultSet.getString("assessmentBodyRegistrationId");

            return new AssessmentBodyRegistrationIdDto(assessmentBodyRegistrationId);
        }
    }
}
