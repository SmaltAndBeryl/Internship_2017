package com.skill.India.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportAssessorDao extends AbstractTransactionalDao {
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	

	public int dataImportAssessorForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on agencyId  column in Assessment Agency Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("agencyId",getRecord.get("agencyId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIdExistsForAssessor(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
	/*
	 * checking for primary key constraint on assessorId  column in Assessor Table 
	 */
	
		public int dataImportAssessorPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
		{
			try{							
				Map<String, Object> parameters = new HashMap<>();
				parameters.put("assessorId",getRecord.get("assessorId"));
				return getJdbcTemplate().queryForObject(dataImportConfigSql.getAssessorIdExistsForAssessor(), parameters,Integer.class );					
			}
				catch(Exception e)
				{
					e.printStackTrace();
					return 2;
				}		
	}	
				
		/*
		 * Inserting data in Assessor Table
		 */
		
		public int insertDataInAssessor(Map<String , Object> recordToInsert)
		{
			return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoAssessorSql(), recordToInsert);	
		}
		
		/*
		 * Updating data in Assessor Table
		 */
		public int updateDataInAssessor(Map<String , Object> recordToInsert)
		{
			return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoAssessorSql(), recordToInsert);
		}
		
		
}
		