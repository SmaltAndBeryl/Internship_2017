package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.PriorExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PriorExperienceDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<PriorExperienceDto> dataBeanDtoCollectionPriorExperience(String trainingPartnerRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSqlPriorExperience(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<PriorExperienceDto> {
        @Override
        public PriorExperienceDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String courseName = resultSet.getString("courseName");
            String numberOfBatchesPerYear = resultSet.getString("numberOfBatchesPerYear");
            String numberOfStudentsInEachBatch = resultSet.getString("numberOfStudentsInEachBatch");

            return new PriorExperienceDto(courseName, numberOfBatchesPerYear, numberOfStudentsInEachBatch);
        }
    }
}
