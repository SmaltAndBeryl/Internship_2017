package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.CenterLevelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CenterLevelDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<CenterLevelDto> centerLevelDtos(){
        Map<String,Object> parameters = new HashMap<>();
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSqlCenterLevel(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<CenterLevelDto> {
        @Override
        public CenterLevelDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String nameOfCenter = resultSet.getString("nameOfCenter");
            String numberOfPermanentOfficeManager = resultSet.getString("numberOfPermanentOfficeManager");
            String numberOftemporaryOfficeManager = resultSet.getString("numberOftemporaryOfficeManager");
            String numberOfPermanentOfficeStaff = resultSet.getString("numberOfPermanentOfficeStaff");
            String numberOfTemporaryOfficeStaff = resultSet.getString("numberOfTemporaryOfficeStaff");
            String numberOfPermanentLabAssistants = resultSet.getString("numberOfPermanentLabAssistants");
            String numberOfTemporaryLabAssistants = resultSet.getString("numberOfTemporaryLabAssistants");
            String numberOfPermanentAccountants = resultSet.getString("numberOfPermanentAccountants");
            String numberOfTemporaryAccountants = resultSet.getString("numberOfTemporaryAccountants");
            String numberOfPermanentSupportStaff = resultSet.getString("numberOfPermanentSupportStaff");
            String numberOfTemporarySupportStaff = resultSet.getString("numberOfTemporarySupportStaff");
            String numberOfPermanentOtherEmployees = resultSet.getString("numberOfPermanentOtherEmployees");
            String numberOfTemporaryOtherEmployees = resultSet.getString("numberOfTemporaryOtherEmployees");

            String areaOfInstitute = resultSet.getString("areaOfInstitute");
            String buildingType = resultSet.getString("buildingType");
            String sizeOfClassrooms = resultSet.getString("sizeOfClassrooms");
            String numberOfClassrooms = resultSet.getString("numberOfClassrooms");
            String sizeOfLabs = resultSet.getString("sizeOfLabs");
            String numberOfLabs = resultSet.getString("numberOfLabs");
            String sizeOfWorkshops = resultSet.getString("sizeOfWorkshops");
            String numberOfWorkshops = resultSet.getString("numberOfWorkshops");
            String mandatoryToolKitpresent = resultSet.getString("mandatoryToolKitpresent");
            String safeDrinkingWater = resultSet.getString("safeDrinkingWater");
            String powerBackup = resultSet.getString("powerBackup");
            String separateToilets = resultSet.getString("separateToilets");
            String transportFacility = resultSet.getString("transportFacility");
            String presenceOfLibrary = resultSet.getString("presenceOfLibrary");
            String numberOfTechnicalBooks = resultSet.getString("numberOfTechnicalBooks");
            String numberOfNonTechnicalBooks = resultSet.getString("numberOfNonTechnicalBooks");
            String numberOfMagazines = resultSet.getString("numberOfMagazines");
            String numberOfDailies = resultSet.getString("numberOfDailies");
            String remarksOnInfrastructureDetails = resultSet.getString("remarksOnInfrastructureDetails");

            String sufficientClassroomIlluminationLevel = resultSet.getString("sufficientClassroomIlluminationLevel");
            String sufficientClassroomVentilationLevel = resultSet.getString("sufficientClassroomVentilationLevel");
            String sufficientCenterCleanliness = resultSet.getString("sufficientCenterCleanliness");
            String centerWeatherProtected = resultSet.getString("centerWeatherProtected");
            String remarksOnLearningEnviornment = resultSet.getString("remarksOnLearningEnviornment");

            String printedBrochureOrProspectus = resultSet.getString("printedBrochureOrProspectus");
            String documentedPolicyAndProcedures = resultSet.getString("documentedPolicyAndProcedures");
            String concessionPolicy = resultSet.getString("concessionPolicy");
            String safeCustodyOfStudentDocuments = resultSet.getString("safeCustodyOfStudentDocuments");
            String studentAgreementWithInstitution = resultSet.getString("studentAgreementWithInstitution");
            String remarksOnStudentAdmissionDetails = resultSet.getString("remarksOnStudentAdmissionDetails");


            return new CenterLevelDto(
                    nameOfCenter,
                    numberOfPermanentOfficeManager,
                    numberOftemporaryOfficeManager,
                    numberOfPermanentOfficeStaff,
                    numberOfTemporaryOfficeStaff,
                    numberOfPermanentLabAssistants,
                    numberOfTemporaryLabAssistants,
                    numberOfPermanentAccountants,
                    numberOfTemporaryAccountants,
                    numberOfPermanentSupportStaff,
                    numberOfTemporarySupportStaff,
                    numberOfPermanentOtherEmployees,
                    numberOfTemporaryOtherEmployees,

                    areaOfInstitute,
                    buildingType,
                    sizeOfClassrooms,
                    numberOfClassrooms,
                    sizeOfLabs,
                    numberOfLabs,
                    sizeOfWorkshops,
                    numberOfWorkshops,
                    mandatoryToolKitpresent,
                    safeDrinkingWater,
                    powerBackup,
                    separateToilets,
                    transportFacility,
                    presenceOfLibrary,
                    numberOfTechnicalBooks,
                    numberOfNonTechnicalBooks,
                    numberOfMagazines,
                    numberOfDailies,
                    remarksOnInfrastructureDetails,

                    sufficientClassroomIlluminationLevel,
                    sufficientClassroomVentilationLevel,
                    sufficientCenterCleanliness,
                    centerWeatherProtected,
                    remarksOnLearningEnviornment,

                    printedBrochureOrProspectus,
                    documentedPolicyAndProcedures,
                    concessionPolicy,
                    safeCustodyOfStudentDocuments,
                    studentAgreementWithInstitution,
                    remarksOnStudentAdmissionDetails

            );
        }
    }
}
