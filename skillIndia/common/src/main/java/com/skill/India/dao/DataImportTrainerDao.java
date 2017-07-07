package com.skill.India.dao;
/*
 * Author 		: Ruchit Jain
 * Description  : DAO for Trainer 
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportTrainerDao extends AbstractTransactionalDao {
	

	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	public int dataImportEmployerForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on trainingPartnerId  column in Training Partner Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("trainingPartnerId",getRecord.get("trainingPartnerId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainingPartnerIdExistsForTrainer(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	
	
	/*
	 * checking for primary key constraint for EmployerId in Employer Table
	 */
	
	public int dataImportEmployerPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
	{
		try{							
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("trainerId",getRecord.get("trainerId"));
			return getJdbcTemplate().queryForObject(dataImportConfigSql.getTrainerIdExistsForTrainer(), parameters,Integer.class );					
		}
			catch(Exception e)
			{
				e.printStackTrace();
				return 2;
			}		
}	
		
	/*
	 * Inserting data in Employer Table
	 */
	
	public int insertDataInEmployer(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoTrainer(), recordToInsert);	
	}
	
	/*
	 * Updating data in Employer Table
	 */
	
	public int updateDataInEmployer(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoTrainer(), recordToInsert);
	}	
	

}
