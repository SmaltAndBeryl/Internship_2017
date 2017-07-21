package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportCertificateDao extends AbstractTransactionalDao {

	
	@Autowired
	private DataImportConfigSql dataImportConfigSql;
	
	
	public int dataImportCertificateForeignKeyConstraintCheck(Map<String,Object> getRecord)
	{
		/*
		 * checking for foreign key constraint on userId & batchId  column in User & Batch Table 
		 */
		try{				
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId",getRecord.get("userId"));
		parameters.put("batchId",getRecord.get("batchId"));
		return getJdbcTemplate().queryForObject(dataImportConfigSql.getUserIdBatchIdExistsForCertificate(), parameters,Integer.class );					
		}	// end of try
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}
		
	/*
	 * Inserting data in certificate Table
	 */
	
	public int insertDataInCertificate(Map<String , Object> recordToInsert)
	{
		return getJdbcTemplate().update(dataImportConfigSql.getInsertIntoCertificate(), recordToInsert);	
	}
}
