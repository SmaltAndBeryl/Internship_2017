package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.AssessmentBodyAffiliationDto;
import com.skill.India.dto.InstitutionRecognitionDto;
import com.skill.India.dto.TrainingPartnerRegistrationIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AssessmentBodyAffiliationDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<AssessmentBodyAffiliationDto> affiliationDtos(String assessmentBodyRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectassessmentbodyaffiliationdetails(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<AssessmentBodyAffiliationDto> {
        @Override
        public AssessmentBodyAffiliationDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String nameOfSectorSkillCouncil = resultSet.getString("nameOfSectorSkillCouncil");

            return new AssessmentBodyAffiliationDto(nameOfSectorSkillCouncil);
        }
    }
}
