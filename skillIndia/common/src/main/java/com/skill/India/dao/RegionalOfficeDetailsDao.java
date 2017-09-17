package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.AssessmentBodyDirectorsDto;
import com.skill.India.dto.AssessmentExperienceInTechnicalDomainDto;
import com.skill.India.dto.InstitutionRecognitionDto;
import com.skill.India.dto.RegionalOfficeDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RegionalOfficeDetailsDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<RegionalOfficeDetailsDto> dataBeanDtoCollectionRegionalOffice(String assessmentBodyRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectRegionalOfficeDetails(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<RegionalOfficeDetailsDto> {
        @Override
        public RegionalOfficeDetailsDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String regionalOfficeId = resultSet.getString("regionalOfficeId");
            String address = resultSet.getString("address");
            String state = resultSet.getString("state");
            String pincode = resultSet.getString("pincode");
            String contactNumber = resultSet.getString("contactNumber");
            String alternateContactNumber = resultSet.getString("alternateContactNumber");

            return new RegionalOfficeDetailsDto(regionalOfficeId, address, state, pincode, contactNumber, alternateContactNumber);
        }
    }
}
