package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.AssessmentBodyDirectorsDto;
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
public class AssessmentBodyDirectorsDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<AssessmentBodyDirectorsDto> dataBeanDtoCollectionDirectors(String assessmentBodyRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectAssessmentBodyDirectorsAndManagementTeamDetails(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<AssessmentBodyDirectorsDto> {
        @Override
        public AssessmentBodyDirectorsDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String name = resultSet.getString("name");
            String designation = resultSet.getString("designation");
            String contactNumber = resultSet.getString("contactNumber");
            String emailId = resultSet.getString("emailId");
            String educationalQualification = resultSet.getString("educationalQualification");
            String experience = resultSet.getString("experience");

            return new AssessmentBodyDirectorsDto(name, designation, contactNumber, emailId, educationalQualification, experience);
        }
    }
}
