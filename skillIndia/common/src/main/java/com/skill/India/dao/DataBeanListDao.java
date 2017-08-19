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
            String trainingPartnerName = resultSet.getString("trainingPartnerName");
            String emailId = resultSet.getString("emailId");
            String district = resultSet.getString("district");
            String state = resultSet.getString("state");
            return new DataBeanDto(trainingPartnerName, emailId, district, state);
        }
    }
}
