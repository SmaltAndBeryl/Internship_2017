package com.skill.India.service;

/*
 * Author 		: Ruchit Jain
 * Description  : For Training Partner .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Training Partner sheet
 * 				 2) Validates the data inserted in it by the user
 * 				 3) Checks for foreign key,primary key constraint	 	
 */


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
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
import com.skill.India.dao.DataImportCSVUploadTableDao;
import com.skill.India.dao.DataImportTrainingPartnerDao;
import com.skill.India.dto.ValidateTrainingPartnerCSVDto;

@Service
public class ValidateTrainingPartnerCSVService {

	@Autowired
	private DataImportTrainingPartnerDao dataImportTrainingPartnerDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao;
	
	public String validateTrainingPartnerCSV(String trainingPartnerCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		CSVReader trainingPartnerCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateTrainingPartnerCSVDto.class);
		String [] trainingPartnerCSVColumns=new String[]{"trainingPartnerId","applicationId","trainingPartnerName"};
		strategy.setColumnMapping(trainingPartnerCSVColumns);
		//String trainingPartnerCSVFileName = "D:\\EclipseWorkspace\\Training_Partner.csv";
		trainingPartnerCSVReader=new CSVReader(new FileReader(trainingPartnerCSVFileName),',','"',2);
		CsvToBean<ValidateTrainingPartnerCSVDto> trainingPartnerCSVToBean=new CsvToBean<ValidateTrainingPartnerCSVDto>();
		List<ValidateTrainingPartnerCSVDto> trainingPartnerCSVDataList= trainingPartnerCSVToBean.parse(strategy,trainingPartnerCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateTrainingPartnerCSVDto trainingPartnerCSVData :trainingPartnerCSVDataList)
		{
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			
			Map<String ,Object> record=new HashMap<String, Object>();
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String trainingPartnerId=trainingPartnerCSVData.getTrainingPartnerId();
			String applicationId=trainingPartnerCSVData.getApplicationId();
			String trainingPartnerName=trainingPartnerCSVData.getTrainingPartnerName();
			
			/*
			 * Checking for error in trainingPartnerId column 
			 */
			
			
			if(trainingPartnerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerId column '";
			}
			
			/*
			 * Checking for error in applicationId column 
			 */
			
			if(!ValidationUtils.numbersCheck(applicationId) || applicationId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'applicationId' column ";
			}
			
			/*
			 * Checking for error in trainingPartnerName column 
			 */
			
			if(ValidationUtils.numbersCheck(trainingPartnerName) || trainingPartnerName.equals("") )
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerName' column ";
			}
			
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;
			}
			else
			{	
				/*
				 * Keeping database consistent by inserting only lowercase values in it
				 */
				
				trainingPartnerName=trainingPartnerName.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				
				 /*
				  * Inserting row wise data in HashMap
				  */
				
				 record.put("trainingPartnerId",trainingPartnerId);
				 record.put("applicationId",applicationId);
				 record.put("trainingPartnerName",trainingPartnerName);
				
				 arrayOfRecords.add(record);
			}
		}
		if(errorExist==1)
		{
		trainingPartnerCSVReader.close();
		File deleteUploadedFile = new File(trainingPartnerCSVFileName);
	    deleteUploadedFile.delete();
		return errorListAllRecords;
		}
		}
		catch(Exception e){
			trainingPartnerCSVReader.close();
			File deleteUploadedFile = new File(trainingPartnerCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		
		/*
		 * Checking for foreign key constraint of applictionId in Application record
		 */
				
		int recordCount=0;
		int status=0;
		int errorExist=0;
		String errorListAllRecords="";

	try{
		for(Map<String, Object> getRecord:arrayOfRecords)
		{	
			String errorString="";
			int errorStatus=0;
			recordCount++;
			
			status=dataImportTrainingPartnerDao.dataImportTrainingPartnerForeignKeyConstraintCheck(getRecord);
			if(status==0 || status==2)
			{
				errorStatus=1;
				errorString=errorString+ "applicationId key mismatch .";
			}
			
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;	
			}
			
		}
		if(errorExist==1)
		{
			trainingPartnerCSVReader.close();
			File deleteUploadedFile = new File(trainingPartnerCSVFileName);
		    deleteUploadedFile.delete();
			return errorListAllRecords;
		}
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		File deleteUploadedFile = new File(trainingPartnerCSVFileName);
	    deleteUploadedFile.delete();
		return "Error checking Foreign key constraint . Kindly try again .";
		
	}
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */

			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
														
				status=dataImportTrainingPartnerDao.dataImportTrainingPartnerPrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportTrainingPartnerDao.insertDataInTrainingPartner(getRecord);
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
					int updateDataStatus=dataImportTrainingPartnerDao.updateDataInTrainingPartner(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				trainingPartnerCSVReader.close();
				
				/*
				 * Inserting data in csvUploaded  Table
				 */		
				Date date=new Date(System.currentTimeMillis());
				
				Map<String,Object> uploadedFileInfo= new HashMap<String, Object>();
				
				uploadedFileInfo.put("csvType",type);
				uploadedFileInfo.put("csvName",fileNameToBeSaved);
				uploadedFileInfo.put("csvUploadDate",date);
				uploadedFileInfo.put("csvUploadUserId",userId);
				
				
				/*
				 * Checking for valid UserId (Foreign key constraint)
				 */
				
				status=dataImportCSVUploadTableDao.dataImportCSVUploadForeignKeyConstraintCheck(uploadedFileInfo);
				if(status==0 || status==2)
				{
				File deleteUploadedFile = new File(trainingPartnerCSVFileName);
				deleteUploadedFile.delete();	
				return "Invalid User Id . Action Aborted";	
				}
				
				int insertDataStatus=dataImportCSVUploadTableDao.insertDataInCSVUpload(uploadedFileInfo);
				if(!(insertDataStatus>0))
				{
				File deleteUploadedFile = new File(trainingPartnerCSVFileName);
				deleteUploadedFile.delete();
				return "Some Error occured while inserting data in csvUploaded By details table . Kindly try again ."; 
				}
				
				return "Data Successfully inserted in Database";
				
			  }	// end of try
				
			  catch(Exception e)
				{
					trainingPartnerCSVReader.close();
					File deleteUploadedFile = new File(trainingPartnerCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		

	}
}