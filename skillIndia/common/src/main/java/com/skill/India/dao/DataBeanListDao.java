package com.skill.India.dao;

import com.skill.India.POC.DataBeanList;
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
            String trainingPartnerName = resultSet.getString("trainingPartnerName");
            String isNSDCfunded = resultSet.getString("isNSDCfunded");
            String firstName = resultSet.getString("firstName");
            String addressLine1 = resultSet.getString("addressLine1");
            String faxNumber = resultSet.getString("faxNumber");
            String emailDirector = resultSet.getString("emailDirector");
            String website = resultSet.getString("website");
            String yearOfEstablishment = resultSet.getString("yearOfEstablishment");
            String priorExposureInSkill = resultSet.getString("priorExposureInSkill");
            String medium = resultSet.getString("medium");
            String selfOwnedTC = resultSet.getString("selfOwnedTC");
            String franchiseTC = resultSet.getString("franchiseTC");
            String PAN = resultSet.getString("PAN");
            String TAN = resultSet.getString("TAN");
            String turnover =resultSet.getString("turnover");
            return new DataBeanDto(trainingPartnerName,isNSDCfunded,firstName, addressLine1, faxNumber,emailDirector,website,yearOfEstablishment,priorExposureInSkill,medium, selfOwnedTC,franchiseTC,PAN, TAN, turnover);

        }
    }
}
