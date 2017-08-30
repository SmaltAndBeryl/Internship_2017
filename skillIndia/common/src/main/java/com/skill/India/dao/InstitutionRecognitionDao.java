package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
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
public class InstitutionRecognitionDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<InstitutionRecognitionDto> dataBeanDtoCollectionInstitutionRecognition(String trainingPartnerRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSqlInstitutionRecognition(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<InstitutionRecognitionDto> {
        @Override
        public InstitutionRecognitionDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String nameOfRecognizingBody = resultSet.getString("nameOfRecognizingBody");
            String recognitionNumber = resultSet.getString("recognitionNumber");
            String yearOfRecognition = resultSet.getString("yearOfRecognition");
            String validityOfRecognition = resultSet.getString("validityOfRecognition");

            return new InstitutionRecognitionDto(nameOfRecognizingBody, recognitionNumber, yearOfRecognition, validityOfRecognition);
        }
    }
}
