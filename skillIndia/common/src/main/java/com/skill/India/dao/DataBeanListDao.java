package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.DataBeanDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
	private static final Logger LOGGER = LoggerFactory.getLogger(DataBeanListDao.class);
	
	@Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<DataBeanDto> dataBeanDtoCollection(String trainingPartnerRegistrationId){
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DataBeanListDao - dataBeanDtoCollection");
				   	
		LOGGER.debug("getting data for the PDF generation");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSql(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<DataBeanDto>{
        @Override
        public DataBeanDto mapRow(ResultSet resultSet, int rowNum)throws SQLException{
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

            //Organization Level Details
            String yearOfEstablishment = resultSet.getString("yearOfEstablishment");
            String qualificationPacks = resultSet.getString("qualificationPacks");
            String nSDCFunded = resultSet.getString("nSDCFunded");
            String mediumOfInstructions = resultSet.getString("mediumOfInstructions");
            String selfOwnedInstitution = resultSet.getString("selfOwnedInstitution");
            String franchiseOwnedInstitution = resultSet.getString("franchiseOwnedInstitution");
            String mobileTrainingInstitution = resultSet.getString("mobileTrainingInstitution");
            String panNumber = resultSet.getString("panNumber");
            String tanNumber = resultSet.getString("tanNumber");
            String turnOverOfInstitution = resultSet.getString("turnOverOfInstitution");
            String instituteReceivedAnyGrant = resultSet.getString("instituteReceivedAnyGrant");
            String instituteReceivedAnyRecognition = resultSet.getString("instituteReceivedAnyRecognition");
            String priorExperienceOfInstitutionInSkillDevelopment = resultSet.getString("priorExperienceOfInstitutionInSkillDevelopment");
            String anyPriorExperienceOfInstitutionInSkillTraining = resultSet.getString("anyPriorExperienceOfInstitutionInSkillTraining");


            return new DataBeanDto(
                    organizationName, address, city, state, pincode, sPOCName, mobileNumber, alternateMobileNumber, landlineNumber, alternateLandlineNumber, faxNumber, websites,

                    yearOfEstablishment, qualificationPacks, nSDCFunded, mediumOfInstructions, selfOwnedInstitution, franchiseOwnedInstitution,
                    mobileTrainingInstitution, panNumber, tanNumber, turnOverOfInstitution, instituteReceivedAnyGrant, instituteReceivedAnyRecognition,
                    priorExperienceOfInstitutionInSkillDevelopment, anyPriorExperienceOfInstitutionInSkillTraining);
        }
    }
}
