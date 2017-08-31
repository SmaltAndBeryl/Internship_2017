package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.AssessmentExperienceInTechnicalDomainDto;
import com.skill.India.dto.InstitutionRecognitionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AssessmentExperienceInTechnicalDomainDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<AssessmentExperienceInTechnicalDomainDto> dataBeanDtoCollectionExperience(){
        Map<String,Object> parameters = new HashMap<>();
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectAssessmentsExperienceInTechnicalDomain(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<AssessmentExperienceInTechnicalDomainDto> {
        @Override
        public AssessmentExperienceInTechnicalDomainDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String domain = resultSet.getString("domain");
            String numberOfAssessmentsDone = resultSet.getString("numberOfAssessmentsDone");

            return new AssessmentExperienceInTechnicalDomainDto(domain, numberOfAssessmentsDone);
        }
    }
}
