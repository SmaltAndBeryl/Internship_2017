package com.skill.India.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DataImportConfigSql;

@Repository
public class DataImportAssessmentAgencyDao extends AbstractTransactionalDao {
	@Autowired
	private DataImportConfigSql dataImportConfigSql;

	public String dataImportAssessmentAgency(ArrayList<Map<String,Object>> arrayOfRecords){
		
		System.out.println("In dao");
		try{
		for(Map<String,Object> x:arrayOfRecords)
		{
			System.out.println("In for" + x+dataImportConfigSql.getInsertSql() );
			int status=getJdbcTemplate().update(dataImportConfigSql.getInsertSql(), x);
			System.out.println("In for" + status);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Record Inserted";
	}
}
