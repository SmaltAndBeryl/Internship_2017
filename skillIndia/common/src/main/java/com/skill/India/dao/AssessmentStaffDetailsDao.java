package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AssessmentStaffDetailsDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<AssessmentStaffDetailsDto> dataBeanDtoCollectionAssessmentStaffDetail(String assessmentBodyRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectAssessmentStaffDetails(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<AssessmentStaffDetailsDto> {
        @Override
        public AssessmentStaffDetailsDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String name = resultSet.getString("name");
            String jobRoleCode = resultSet.getString("jobRoleCode");
            String designation = resultSet.getString("designation");
            String contactNumber = resultSet.getString("contactNumber");
            String emailId = resultSet.getString("emailId");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            String educationalQualification = resultSet.getString("educationalQualification");
            String experience = resultSet.getString("experience");

            return new AssessmentStaffDetailsDto(name, jobRoleCode, designation, contactNumber, emailId, city, state, educationalQualification, experience);
        }
    }
}
