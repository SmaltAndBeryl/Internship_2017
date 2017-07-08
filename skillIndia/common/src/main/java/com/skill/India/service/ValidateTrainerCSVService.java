package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Trainer .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Trainer sheet
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
import com.skill.India.dao.DataImportTrainerDao;
import com.skill.India.dto.ValidateTrainerCSVDto;

@Service
public class ValidateTrainerCSVService {
	
	@Autowired
	private DataImportTrainerDao dataImportTrainerDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao; 
	
	public String validateTrainerCSV(String trainerCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		CSVReader trainerCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{		
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateTrainerCSVDto.class);
		String [] trainerCSVColumns=new String[]{"trainerId","trainerName","designation","trainingPartnerId"};
		strategy.setColumnMapping(trainerCSVColumns);
		// String trainerCSVFileName = "D:\\EclipseWorkspace\\Trainer.csv";
		trainerCSVReader=new CSVReader(new FileReader(trainerCSVFileName),',','"',2);
		CsvToBean<ValidateTrainerCSVDto> trainerCSVToBean=new CsvToBean<ValidateTrainerCSVDto>();
		List<ValidateTrainerCSVDto> trainerCSVDataList= trainerCSVToBean.parse(strategy,trainerCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateTrainerCSVDto trainerCSVData :trainerCSVDataList)
		{
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			Map<String ,Object> record=new HashMap<String, Object>();
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String trainerId=trainerCSVData.getTrainerId();
			String trainerName=trainerCSVData.getTrainerName();
			String designation=trainerCSVData.getDesignation();
			String trainingPartnerId=trainerCSVData.getTrainingPartnerId();
		
		
			/*
			 * Checking for Empty fields 
			 */
			if(trainerId.equals("") || trainerName.equals("") || designation.equals("")
					|| trainingPartnerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty ";
			}
			
			/*
			 * Checking for error in trainerId column 
			 */
			
			if(!ValidationUtils.numbersCheck(trainerId))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainerId' column .";
			}
			
			/*
			 * Checking for error in trainerName column 
			 */
			
			if(ValidationUtils.numbersCheck(trainerName))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainerName' column .";
			}
			
			/*
			 * Checking for error in designation column 
			 */
			
			if(ValidationUtils.numbersCheck(designation))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'designation' column .";
			}
			
			/*
			 * Checking for error in trainingPartnerId column 
			 */
			
			if(!ValidationUtils.numbersCheck(trainingPartnerId))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerId' column .";
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
				trainerName=trainerName.toLowerCase();
				designation=designation.toLowerCase();
				
				 /*
				  * Inserting row wise data in HashMap
				  */
				
				record.put("trainerId",trainerId);
				record.put("trainerName",trainerName);
				record.put("designation",designation);
				record.put("trainingPartnerId",trainingPartnerId);
				
				arrayOfRecords.add(record);
			}	
		}
		
		if(errorExist==1)
		{
		trainerCSVReader.close();
		File deleteUploadedFile = new File(trainerCSVFileName);
	    deleteUploadedFile.delete();
		return errorListAllRecords;
		}
		}
		catch(Exception e)
		{
			trainerCSVReader.close();
			File deleteUploadedFile = new File(trainerCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		
		
		/*
		 * Checking for foreign key constraint of batchId & employerId
		 */
		
		try{				
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				int status=dataImportTrainerDao.dataImportEmployerForeignKeyConstraintCheck(getRecord);
				if(status==0 || status==2)
				{
				throw new Exception();	
				}
				
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				trainerCSVReader.close();
				File deleteUploadedFile = new File(trainerCSVFileName);
				deleteUploadedFile.delete();
				e.printStackTrace();
				return "Error in trainingPartnerId column. Kindly recheck the details ."
			+ "trainingPartnerId not found in Training Partner record .";
			}
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */

			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{					
				int status=dataImportTrainerDao.dataImportEmployerPrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportTrainerDao.insertDataInEmployer(getRecord);
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
					int updateDataStatus=dataImportTrainerDao.updateDataInEmployer(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				
				trainerCSVReader.close();
				

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
				
				int status=dataImportCSVUploadTableDao.dataImportCSVUploadForeignKeyConstraintCheck(uploadedFileInfo);
				if(status==0 || status==2)
				{
				File deleteUploadedFile = new File(trainerCSVFileName);
				deleteUploadedFile.delete();	
				return "Invalid User Id . Action Aborted";	
				}
				
				int insertDataStatus=dataImportCSVUploadTableDao.insertDataInCSVUpload(uploadedFileInfo);
				if(!(insertDataStatus>0))
				{
				File deleteUploadedFile = new File(trainerCSVFileName);
				deleteUploadedFile.delete();
				return "Some Error occured while inserting data in csvUploaded By details table . Kindly try again ."; 
				}
				
				
				return "Data Successfully inserted in Database .";
				}	// end of try
				catch(Exception e)
				{
					trainerCSVReader.close();
					File deleteUploadedFile = new File(trainerCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		
		//return "Successfully Uploaded CSV File";
	}
}