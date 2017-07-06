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
	

	public int dataImportAssessorForeignKeyConstraintCheck(ArrayList<Map<String,Object>> arrayOfRecords)
	{
		/*
		 * checking for foreign key constraint on agencyID  column in Assessment Agency Table 
		 */
		try{				
		for(Map<String, Object> x:arrayOfRecords)
		{
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("agencyID",x.get("agencyID"));
		int status= getJdbcTemplate().queryForObject(dataImportConfigSql.getAgencyIDExistsForAssessor(), parameters,Integer.class );					
		if(status==0)
		{
			return 0;
		}
		}	// end of for loop
		return 1;
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
		
		public int dataImportAssessorPrimaryKeyConstraintCheck(Map<String,Object> getRecord)
		{
			try{							
				Map<String, Object> parameters = new HashMap<>();
				parameters.put("assessorID",getRecord.get("assessorID"));
				return getJdbcTemplate().queryForObject(dataImportConfigSql.getAssessorIDExistsForAssessor(), parameters,Integer.class );					
			}
				catch(Exception e)
				{
					e.printStackTrace();
					return 2;
				}		
	}	
			
			
		
		
		public int insertDataInAssessor(Map<String , Object> recordToInsert)
		{
			return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoAssessorSql(), recordToInsert);
			
		}
		
		
		public int updateDataInAssessor(Map<String , Object> recordToInsert)
		{
			return getJdbcTemplate().update(dataImportConfigSql.getUpdateIntoAssessorSql(), recordToInsert);
		}
		
		
}
		