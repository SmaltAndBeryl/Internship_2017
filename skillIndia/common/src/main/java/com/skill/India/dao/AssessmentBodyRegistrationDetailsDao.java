package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.AssessmentBodyRegistrationDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AssessmentBodyRegistrationDetailsDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<AssessmentBodyRegistrationDetailsDto> dataBeanDtoCollectionAssessmentBodyRegistrationDetails(String assessmentBodyRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("assessmentBodyRegistrationId",assessmentBodyRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectAssessmentBodyRegistrationDetails(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<AssessmentBodyRegistrationDetailsDto> {
        @Override
        public AssessmentBodyRegistrationDetailsDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String organizationName = resultSet.getString("organizationName");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            String pincode = resultSet.getString("pincode");
            String sPOCName = resultSet.getString("sPOCName");
            String mobileNumber = resultSet.getString("mobileNumber");
            String alternateMobileNumber = resultSet.getString("alternateMobileNumber");
            String landlineNumber = resultSet.getString("landlineNumber");
            String alternateLandlineNumber = resultSet.getString("alternateLandlineNumber");
            String faxNumber = resultSet.getString("faxNumber");
            String websites = resultSet.getString("websites");

            String yearOfEstablishment = resultSet.getString("yearOfEstablishment");
            String priorAssessmentExperience = resultSet.getString("priorAssessmentExperience");
            String panNumber = resultSet.getString("panNumber");
            String tanNumber = resultSet.getString("tanNumber");
            String insituteReceivedAnyRecognition = resultSet.getString("insituteReceivedAnyRecognition");
//            String NameOfRecognitionBody = resultSet.getString("NameOfRecognitionBody");
//            String RecognitionNumber = resultSet.getString("RecognitionNumber");
//            String yearOfRecognition = resultSet.getString("yearOfRecognition");
//            String validityOfRecognition = resultSet.getString("validityOfRecognition");

            String affiliatedToAnySectorSkillCouncil = resultSet.getString("affiliatedToAnySectorSkillCouncil");

            String numberOfTechnicalAssessors = resultSet.getString("numberOfTechnicalAssessors");
            String numberOfNonTechnicalAssessors = resultSet.getString("numberOfNonTechnicalAssessors");

            return new AssessmentBodyRegistrationDetailsDto(
                    organizationName,
                    address,
                    city,
                    state,
                    pincode,
                    sPOCName,
                    mobileNumber,
                    alternateMobileNumber,
                    landlineNumber,
                    alternateLandlineNumber,
                    faxNumber,
                    websites,

                    yearOfEstablishment,
                    priorAssessmentExperience,
                    panNumber,
                    tanNumber,
                    insituteReceivedAnyRecognition,
//                    NameOfRecognitionBody,
//                    RecognitionNumber,
//                    yearOfRecognition,
//                    validityOfRecognition,

                    affiliatedToAnySectorSkillCouncil,

                    numberOfTechnicalAssessors,
                    numberOfNonTechnicalAssessors

            );
        }
    }
}
