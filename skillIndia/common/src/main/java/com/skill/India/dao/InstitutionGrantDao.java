package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.PdfDataConfigSql;
import com.skill.India.dto.InstitutionGrantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InstitutionGrantDao extends AbstractTransactionalDao{

    @Autowired
    private PdfDataConfigSql pdfDataConfigSql;

    private static PdfDataDaoRowMapper ROW_MAPPER = new PdfDataDaoRowMapper();

    public Collection<InstitutionGrantDto> dataBeanDtoCollectionInstitutionGrant(String trainingPartnerRegistrationId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("trainingPartnerRegistrationId", trainingPartnerRegistrationId);
        return getJdbcTemplate().query(pdfDataConfigSql.getSelectSqlInstitutionGrant(), parameters, ROW_MAPPER);
    }

    private static class PdfDataDaoRowMapper implements RowMapper<InstitutionGrantDto> {
        @Override
        public InstitutionGrantDto mapRow(ResultSet resultSet, int i) throws SQLException {
            String nameOfMinistry = resultSet.getString("nameOfMinistry");
            String natureOfWork = resultSet.getString("natureOfWork");
            String remarks = resultSet.getString("remarks");

            return new InstitutionGrantDto(
                    nameOfMinistry,
                    natureOfWork,
                    remarks
            );
        }
    }
}
