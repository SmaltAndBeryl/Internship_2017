package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Agency .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Agency sheet
 * 				 2) Validates the data inserted in it by the user
 * 				 3) Checks for foreign key,primary key constraint	 	
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dao.DataImportAssessmentAgencyDao;
import com.skill.India.dto.ValidateAssessmentAgencyCSVDto;
import com.skill.India.dto.ValidateCentreCSVDto;

@Service
public class ValidateAssessmentAgencyCSVService {
	
	@Autowired
	private DataImportAssessmentAgencyDao dataImportAssessmentAgencyDao;
	
	public String validateAssessmentAgencyCSV(String assessmentAgencyCSVFileName) throws IOException{
		CSVReader assessmentAgencyCSVReader=null;
		/*
		 *Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords= new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateAssessmentAgencyCSVDto.class);
		String [] assessmentAgencyCSVColumns=new String[]{"agencyId","applicationId","agencyName"};
		strategy.setColumnMapping(assessmentAgencyCSVColumns);
	//	String assessmentAgencyCSVFileName = "D:\\EclipseWorkspace\\Assessment_Agency.csv";
		assessmentAgencyCSVReader=new CSVReader(new FileReader(assessmentAgencyCSVFileName),',','"',2);
		CsvToBean<ValidateAssessmentAgencyCSVDto> assessmentAgencyCSVToBean=new CsvToBean<ValidateAssessmentAgencyCSVDto>();
		List<ValidateAssessmentAgencyCSVDto> assessmentAgencyCSVDataList= assessmentAgencyCSVToBean.parse(strategy,assessmentAgencyCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";	
		for(ValidateAssessmentAgencyCSVDto assessmentAgencyCSVData :assessmentAgencyCSVDataList)
		{
			/*
			 * Map to store data of each row of csv read and then added to arraylist
			 */
			Map<String,Object> record=new HashMap<String, Object>();
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String agencyId=assessmentAgencyCSVData.getAgencyId();
			String agencyName=assessmentAgencyCSVData.getAgencyName();
			String applicationId=assessmentAgencyCSVData.getApplicationId();
			/*
			 * Checking for Mandatory fields 
			 */
			
			if(agencyId.equals("") || agencyName.equals("") || applicationId.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Mandatory fields cannot be Empty ";	
			}
			
			/*
			 * Checking for error in agencyId column 
			 */
			
			if(!ValidationUtils.numbersCheck(agencyId))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyId' column ";
			}
			
			/*
			 * checking for error in applicationId column 
			 */
			
			if(!(ValidationUtils.numbersCheck(applicationId)))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'aapplicationId' column ";
			}
			/*
			 * Checking for error in agencyName column 
			 */
			
			if(ValidationUtils.numbersCheck(agencyName))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyName' column ";
			}
			
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;
				
			}
			else 
			{
				agencyName=agencyName.toLowerCase();
				
				record.put("agencyId",agencyId);
				record.put("agencyName",agencyName);
				record.put("applicationId",applicationId);
				
				arrayOfRecords.add(record);
			}
		}  // end of for 
		
		/*
		 * If error exist then throw error else transport data to DAO to insert into database
		 */
		
		if(errorExist==1)
			{
			assessmentAgencyCSVReader.close();
			File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
			deleteUploadedFile.delete();
			return errorListAllRecords;
			}
		} // end of try 	
		catch(Exception e)
		{
			assessmentAgencyCSVReader.close();
			File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		/*
		 * Checking for foreign key constraint of applicationId
		 */
		
		try{				
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				int status=dataImportAssessmentAgencyDao.dataImportAssessmentAgencyForeignKeyConstraintCheck(getRecord);
				if(status==0 || status==2)
				{
				throw new Exception();	
				}
				
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				assessmentAgencyCSVReader.close();
				File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
				deleteUploadedFile.delete();
				e.printStackTrace();
				return "Error in applicationId column. Kindly recheck the details ."
			+ "applicationId not found in  Applications record .";
			}
		 
		/*
		 * Checking primary key Constraint and performing respective actions
		 */
		
			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{				
				int status=dataImportAssessmentAgencyDao.dataImportAssessmentAgencyPrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportAssessmentAgencyDao.insertDataInAssessmentAgency(getRecord);
					if(!(insertDataStatus>0))
					{
						throw new Exception();
					}
				}
				else if(status==1)
				{
					/*
					 * If primary key exists in DB then run update query
					 */
					int updateDataStatus=dataImportAssessmentAgencyDao.updateDataInAssessmentAgency(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				
				return "Data Successfully inserted in Database .";
				}	// end of try
				catch(Exception e)
				{
					assessmentAgencyCSVReader.close();
					File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		
	
	}
}
