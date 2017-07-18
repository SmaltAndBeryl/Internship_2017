package com.skill.India.dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ApproveRejectTableConfigSql;
import com.skill.India.dto.ApproveRejectTableDto;


@Repository
public class ApproveRejectTableDao extends AbstractTransactionalDao {
    
	@Autowired
	public ApproveRejectTableConfigSql config;

	private static final ApproveRejectSelectRowMapper ROW_MAPPER = new ApproveRejectSelectRowMapper();

	ArrayList<ApproveRejectTableDto> approvedApplications = new ArrayList<ApproveRejectTableDto>();
	ArrayList<ApproveRejectTableDto> rejectedApplications = new ArrayList<ApproveRejectTableDto>();
	ArrayList<ApproveRejectTableDto> submittedApplications = new ArrayList<ApproveRejectTableDto>();
	ArrayList<ApproveRejectTableDto> incompleteApplications = new ArrayList<ApproveRejectTableDto>();
	
	public HashMap<String, ArrayList<ApproveRejectTableDto>> getUpdateRowMapper() {
		Map<String, Object> parameters = new HashMap<>();
		Collection<ApproveRejectTableDto> manageRegistrationsTable =  getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
		for(ApproveRejectTableDto rowWiseData:manageRegistrationsTable)
		{
		
		switch (rowWiseData.getapplicationState())
		{
			case "approved" :
			{
				approvedApplications.add(rowWiseData);
				break;
			}
			case "rejected":
			{
				rejectedApplications.add(rowWiseData);
				break;
			}
			case "submitted":
			{
				submittedApplications.add(rowWiseData);
				break;
			}
			case "incomplete":
			{
				incompleteApplications.add(rowWiseData);
				break;
			}
		}
	}
		HashMap<String,ArrayList<ApproveRejectTableDto>> manageRegistrationsDataMap = new HashMap<String,ArrayList<ApproveRejectTableDto>>();
		manageRegistrationsDataMap.put("submitted", submittedApplications);
		manageRegistrationsDataMap.put("approved", approvedApplications);
		manageRegistrationsDataMap.put("rejected", rejectedApplications);
		manageRegistrationsDataMap.put("incomplete", incompleteApplications);
		return manageRegistrationsDataMap;
	}

 private static class ApproveRejectSelectRowMapper implements RowMapper<ApproveRejectTableDto> {

		@Override
		public ApproveRejectTableDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			Integer applicationId = resultSet.getInt("applicationId");
		    String applicationState= resultSet.getString("applicationState");
		    Boolean activeFlag = resultSet.getBoolean("activeFlag");
			Date dateOfSubmission = resultSet.getDate("dateOfSubmission");
            String userId = resultSet.getString("userId");
            String organisationName = resultSet.getString("organisationName");

			return new ApproveRejectTableDto(applicationId, applicationState, activeFlag, dateOfSubmission,userId,organisationName);
		}

	
 }
}