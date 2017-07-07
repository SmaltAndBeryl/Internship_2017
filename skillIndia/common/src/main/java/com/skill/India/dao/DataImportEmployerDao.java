package com.skill.India.dao;
/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Employer
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportEmployerDao extends AbstractTransactionalDao {
		
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	

	/*
	 * checking for primary key constraint for EmployerId in Employer Table
	 */
	
	public int dataImportEmployerPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		try{							
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("employerId",getRecord.get("employerId"));
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getEmployerIdExistsForEmployer(), parameters,Integer.class );					
		}
			catch(Exception e)
			{
				e.printStackTrace();
				return 2;
			}		
}	
		
	/*
	 * Inserting data in Candidate Table
	 */
	
	public int insertDataInEmployer(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoEmployer(), recordToInsert);	
	}
	
	/*
	 * Updating data in Candidate Table
	 */
	
	public int updateDataInEmployer(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoEmployer(), recordToInsert);
	}	


}
