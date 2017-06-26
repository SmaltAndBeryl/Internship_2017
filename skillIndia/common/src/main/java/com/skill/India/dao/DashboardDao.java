/*package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DashboardConfigSql;
import com.skill.India.dto.DashboardDto;


@Repository
public class DashboardDao extends AbstractTransactionalDao{

	@Autowired
	public DashboardConfigSql config;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);
	
	private static final DashboardRowMapper ROW_MAPPER = new DashboardRowMapper();
	
//	public Collection<DashboardDto> getDashboardRowMapper() {
	//	Map<String, Object> parameters = new HashMap<>();
	//	return getJdbcTemplate().query(config.getSelectSql1(), parameters,ROW_MAPPER);
	//	return 
//	}
	
	public Collection<DashboardDto> selectCandidatesEnrolled()
	{
		LOGGER.info("Code reached to DashboardDao");
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(config.getSelectSql1(),parameters,ROW_MAPPER);
	}
		
}
	static class DashboardRowMapper implements RowMapper<DashboardDto> 
	{
		@Override
		public DashboardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer totalCandidateEnrolled = rs.getInt("TCE");
			Integer totalCandidateAssessed = rs.getInt("TCA");
			Integer totalCandidateCertified = rs.getInt("TCC");
			Integer totalTrainingPartner = rs.getInt("TTP");
			Integer totalTrainingCenter = rs.getInt("TTC");
			
			return new DashboardDto(totalCandidateEnrolled, totalCandidateAssessed, totalCandidateCertified, totalTrainingPartner, totalTrainingCenter); 
			
			
		}
	}

/*class DashboardRowSelectRowMapper implements RowMapper<DashboardDto> {

	@Override
	public DashboardDto mapRow(ResultSet resultSet, int rowNum)
			throws SQLException {
//		Integer totalCandidateEnrolled = resultSet.getInt(columnLabel);
//		Integer totalCandidateAssessed = resultSet.getInt(columnLabel);
//		Integer totalCandidateCertified = resultSet.getInt(columnLabel);
//		Integer totalTrainingPartner = resultSet.getInt(columnLabel);
//		Integer totalTrainingCenter = resultSet.getInt(columnIndex);
		
	//	return new DashboardDto(totalCandidateEnrolled, totalCandidateAssessed, totalCandidateCertified, totalTrainingPartner, totalTrainingCenter);
		
		return null;
	}

}


*/
package com.skill.India.dao;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DashboardConfigSql;
import com.skill.India.dto.DashboardDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

/**
 * Created by aashish on 6/24/17.
 */
@Repository
public class DashboardDao extends AbstractTransactionalDao{
	
	

    @Autowired
    public DashboardConfigSql dashboardConfigSql;

//    private static final UpdateRowSelectRowMapper ROW_MAPPER = new UpdateRowSelectRowMapper();
    
    
    public Integer getTotalCandidateEnrolled() {
    	Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlCandidatesEnrolled(), parameters, Integer.class);        
        
    }

    public Integer getTotalCandidateAccessed() {
    	Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlCandidatesAccessed(), parameters, Integer.class);        
        
    }
    
    public Integer getTotalCandidateCertified() {
    	Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlCandidatesCertified(), parameters, Integer.class);        
        
    }
    
    public Integer getTotalTrainingPartners() {
    	Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTrainingPartners(), parameters, Integer.class);        
        
    }
    
    public Integer getTotalTrainingCenter() {
    	Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTrainingCenters(), parameters, Integer.class);        
        
    }
    
/*    public Collection<DashboardDto> getStates() {
    	Map<String, Object> parameters = new HashMap<>();
    	return getJdbcTemplate().query(selectConfigSql.getSelectSql6(), parameters, ROW_MAPPER);
    }
*/
}
  

/*    private static class UpdateRowSelectRowMapper implements RowMapper<DashboardDto> {

        @Override
        public DashboardDto mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            String State = resultSet.getString("State");
            Integer Number = resultSet.getInt("NUM");
                       
        	return new DashboardDto(State,Number);
        }


    }
}
    */