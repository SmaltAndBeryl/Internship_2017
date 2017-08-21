package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.DataBeanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@Repository
public class DataBeanListDao extends AbstractTransactionalDao{
    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<DataBeanDto> dataBeanDtoCollection(){
        Map<String,Object> parameters = new HashMap<>();
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSql(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<DataBeanDto>{
        @Override
        public DataBeanDto mapRow(ResultSet resultSet, int rowNum)throws SQLException{
            String totalCenters = resultSet.getString("totalCenters");
            String officeStaffP = resultSet.getString("officeStaffP");
            String officeStaffT = resultSet.getString("officeStaffT");
            String labAttendantsP = resultSet.getString("labAttendantsP");
            String labAttendantsT = resultSet.getString("labAttendantsT");
            String accountantsP = resultSet.getString("accountantsP");
            String accountantsT = resultSet.getString("accountantsT");
            String supportStaffP = resultSet.getString("supportStaffP");
            String supportStaffT = resultSet.getString("supportStaffT");
            String othersP = resultSet.getString("othersP");
            String othersT = resultSet.getString("othersT");
            String areaOfInstitute = resultSet.getString("areaOfInstitute");
            String sizeOfClassRoom = resultSet.getString("sizeOfClassRoom");
            String numberOfClassrooms = resultSet.getString("numberOfClassrooms");
            String sizeOfLabs = resultSet.getString("sizeOfLabs");
            String numberOfLabs = resultSet.getString("numberOfLabs");
            String sizeOfWorkshops = resultSet.getString("sizeOfWorkshops");
            String numberOfWorkshops = resultSet.getString("numberOfWorkshops");
            String presenceOfToolkit = resultSet.getString("presenceOfToolkit");
            String safeDrinkingWater = resultSet.getString("safeDrinkingWater");
            String powerBackup = resultSet.getString("powerBackup");
            String separateToilet = resultSet.getString("separateToilet");
            String transportFacility = resultSet.getString("transportFacility");
            String presenceOfLibrary = resultSet.getString("presenceOfLibrary");
            String isIlluminationSufficient = resultSet.getString("isIlluminationSufficient");
            String isVentilated = resultSet.getString("isVentilated");
            String cleanLiness = resultSet.getString("cleanLiness");
            String weatherProtected = resultSet.getString("weatherProtected");
            String printedBrochure = resultSet.getString("printedBrochure");
            String documentedPolicy = resultSet.getString("documentedPolicy");
            String concessionsPolicy = resultSet.getString("concessionsPolicy");
            String safeCustodyOfDocuments = resultSet.getString("safeCustodyOfDocuments");
            String studentAgreement = resultSet.getString("studentAgreement");
            String yearOfEstablishment = resultSet.getString("yearOfEstablishment");
            String mediumOfInstructions = resultSet.getString("mediumOfInstructions");
            String mobileNo = resultSet.getString("mobileNo");
            String PAN = resultSet.getString("PAN");
            String TAN = resultSet.getString("TAN");
            String turnover = resultSet.getString("turnover");
            String yearOfRecognition = resultSet.getString("yearOfRecognition");
            String website = resultSet.getString("website");
            String address = resultSet.getString("address");
            String PINcode = resultSet.getString("PINcode");
            String district = resultSet.getString("district");
            String city = resultSet.getString("city");
            String landlineNumber = resultSet.getString("landlineNumber");
            String faxNumber = resultSet.getString("faxNumber");
            String validityOfRecognition = resultSet.getString("validityOfRecognition");
            String isNSDCfunded = resultSet.getString("modelOfInstitute");
            String applicationId = resultSet.getString("modelOfInstitute");
            String trainingPartnerName = resultSet.getString("modelOfInstitute");
            String emailId = resultSet.getString("modelOfInstitute");


            return new DataBeanDto(
                    totalCenters,
                    officeStaffP,
                    officeStaffT,
                    labAttendantsP,
                    labAttendantsT,
                    accountantsP,
                    accountantsT,
                    supportStaffP,
                    supportStaffT,
                    othersP,
                    othersT,
                    areaOfInstitute,
                    sizeOfClassRoom,
                    numberOfClassrooms,
                    sizeOfLabs,
                    numberOfLabs,
                    sizeOfWorkshops,
                    numberOfWorkshops,
                    presenceOfToolkit,
                    safeDrinkingWater,
                    powerBackup,
                    separateToilet,
                    transportFacility,
                    presenceOfLibrary,
                    isIlluminationSufficient,
                    isVentilated,
                    cleanLiness,
                    weatherProtected,
                    printedBrochure,
                    documentedPolicy,
                    concessionsPolicy,
                    safeCustodyOfDocuments,
                    studentAgreement,
                    yearOfEstablishment,
                    mediumOfInstructions,
                    mobileNo,
                    PAN,
                    TAN,
                    turnover,
                    yearOfRecognition,
                    website,
                    address,
                    PINcode,
                    district,
                    city,
                    landlineNumber,
                    faxNumber,
                    validityOfRecognition,
                    isNSDCfunded,
                    applicationId,
                    trainingPartnerName,
                    emailId
            );
        }
    }
}
