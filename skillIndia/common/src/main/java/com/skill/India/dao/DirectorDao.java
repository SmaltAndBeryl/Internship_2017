package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DirectorDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<DirectorDto> dataBeanDtoCollectionDirector(String trainingPartnerRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("trainingPartnerRegistrationId" ,trainingPartnerRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSqlDirector(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<DirectorDto> {
        @Override
        public DirectorDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String name = resultSet.getString("name");
            String designation = resultSet.getString("designation");
            String emailId = resultSet.getString("emailId");
            String contactNumber = resultSet.getString("contactNumber");
            String educationalQualification = resultSet.getString("educationalQualification");
            String experience = resultSet.getString("experience");

            return new DirectorDto(name, designation, emailId, contactNumber, educationalQualification, experience);
        }
    }
}
