package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ProfileCreationTpConfigSql;
import com.skill.India.dto.ProfileCreationTpDto;






@Repository
public class ProfileCreationTpDao extends AbstractTransactionalDao  {

	@Autowired
	public ProfileCreationTpConfigSql config;
	
	public int insert(ProfileCreationTpDto profile){
	Map<String, Object> parameters = new HashMap<>();
	parameters.put("trainingPartnerName",profile.getTrainingPartnerName());
	parameters.put("emailId",profile.getEmailId());
	parameters.put("mobileNumber",profile.getMobileNumber());
	parameters.put("firstName",profile.getFirstName());
//	parameters.put("middleName",profile.getMiddleName());
	parameters.put("lastName",profile.getLastName());
	return insert(config.getInsertSqlOfProfileCreation(), parameters, "ID");	
}
	public Integer checkUserExistence(String emailId){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("emailId",emailId);
	return getJdbcTemplate().queryForObject(config.getInsertSqlOfProfileCreation() , parameters, Integer.class);
}}