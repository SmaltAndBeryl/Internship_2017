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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateTrainingPartnerCSVService.class);

	@Autowired
	private DataImportTrainingPartnerDao dataImportTrainingPartnerDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao;
	
	public String validateTrainingPartnerCSV(String trainingPartnerCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ValidateCandidateCSVService - validateCandidateCSV");
		LOGGER.debug("Parameters Received from Controller are - 'trainingPartnerCSVFileName': "+trainingPartnerCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
			
		CSVReader trainingPartnerCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		LOGGER.debug("Creating ArrayList object");
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		LOGGER.debug("Successfully created");
		
		try{
			LOGGER.debug("In TRY block");
			
			LOGGER.debug("Creating ColumnPositionMappingStrategy object");
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("Setting type of object to ValidateTrainingPartnerCSVDto");
			strategy.setType(ValidateTrainingPartnerCSVDto.class);
		String [] trainingPartnerCSVColumns=new String[]{"trainingPartnerId","applicationId","trainingPartnerName","batchType"};
		
		LOGGER.debug("Setting ColumnMapping of object");
		strategy.setColumnMapping(trainingPartnerCSVColumns);
		//String trainingPartnerCSVFileName = "D:\\EclipseWorkspace\\Training_Partner.csv";
		
		LOGGER.debug("Creating CSVReader object ");
		trainingPartnerCSVReader=new CSVReader(new FileReader(trainingPartnerCSVFileName),',','"',2);
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating CsvToBean object ");
		CsvToBean<ValidateTrainingPartnerCSVDto> trainingPartnerCSVToBean=new CsvToBean<ValidateTrainingPartnerCSVDto>();
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating List object of type ValidateTrainingPartnerCSVDto");
		List<ValidateTrainingPartnerCSVDto> trainingPartnerCSVDataList= trainingPartnerCSVToBean.parse(strategy,trainingPartnerCSVReader);
		LOGGER.debug("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		
		LOGGER.debug("Iterating List Object");
		for(ValidateTrainingPartnerCSVDto trainingPartnerCSVData :trainingPartnerCSVDataList)
		{
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			LOGGER.debug("Creating HashMap object");
			Map<String ,Object> record=new HashMap<String, Object>();
			LOGGER.debug("Successfully created");
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			LOGGER.debug("Fetching data from each row");		
			String trainingPartnerId=trainingPartnerCSVData.getTrainingPartnerId().trim();
			String applicationId=trainingPartnerCSVData.getApplicationId().trim();
			String trainingPartnerName=trainingPartnerCSVData.getTrainingPartnerName().trim();
			String batchType = trainingPartnerCSVData.getBatchType().trim();
			/*
			 * Checking for error in trainingPartnerId column 
			 */
			
			LOGGER.debug("Checking Validations of trainingPartnerId");
			if(trainingPartnerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerId column '";
			}
			
			/*
			 * Checking for error in applicationId column 
			 */
			LOGGER.debug("Checking Validations of applicationId");
			if(!ValidationUtils.numbersCheck(applicationId) || applicationId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'applicationId' column ";
			}
			
			/*
			 * Checking for error in trainingPartnerName column 
			 */
			LOGGER.debug("Checking Validations of trainingPartnerName");
			if(ValidationUtils.numbersCheck(trainingPartnerName) || trainingPartnerName.equals("") )
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerName' column ";
			}
			
			/*
			 * Checking for error in batchType column
			 */
			
			LOGGER.debug("Checking Validations of batchType");
			if(ValidationUtils.numbersCheck(batchType) || batchType.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchType' column .";
			}
			
			
			LOGGER.debug("Fetching Errors in records and making error String if found any");
			if(errorStatus==1)
			{
				LOGGER.debug("Error Exists in CSV");
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;
			}
			else
			{	
				/*
				 * Keeping database consistent by inserting only lowercase values in it
				 */
				LOGGER.debug("Converting all values to lower Case");
				trainingPartnerName=trainingPartnerName.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				batchType=batchType.toLowerCase();
				 /*
				  * Inserting row wise data in HashMap
				  */
				
				LOGGER.debug("Inserting values into HashMap Object");
				record.put("trainingPartnerId",trainingPartnerId);
				record.put("applicationId",applicationId);
				record.put("trainingPartnerName",trainingPartnerName);
				record.put("batchType",batchType);
				
				LOGGER.debug("Adding HashMap object into ArrayList");
				 arrayOfRecords.add(record);
			}
		}
		if(errorExist==1)
		{
			LOGGER.debug("Closing CSV reader");
			trainingPartnerCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(trainingPartnerCSVFileName);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.debug("Successfully deleted");
		    
		    LOGGER.debug("returning Error list as String");
			return errorListAllRecords;
		}
		}
		catch(Exception e){
			LOGGER.debug("In CATCH block");
			
			LOGGER.debug("Closing CSV reader");
			trainingPartnerCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(trainingPartnerCSVFileName);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.debug("Successfully deleted");
		    
		    LOGGER.debug("returning Error list as String");
//			e.printStackTrace();
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
		LOGGER.debug("In TRY block");
		
		LOGGER.debug("Iterating Array List object"); 
		for(Map<String, Object> getRecord:arrayOfRecords)
		{	
			String errorString="";
			int errorStatus=0;
			recordCount++;
			
			LOGGER.debug("Checking if record details already exists in database");
			LOGGER.debug("Making a Request to Dao to get data");
			status=dataImportTrainingPartnerDao.dataImportTrainingPartnerForeignKeyConstraintCheck(getRecord);
			LOGGER.debug("Response received from Dao");
			
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
			LOGGER.debug("Closing CSV reader");
			trainingPartnerCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(trainingPartnerCSVFileName);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.debug("Successfully deleted");
		    
		    LOGGER.debug("returning Error list as String");
			return errorListAllRecords;
		}
		
		
	}
	catch(Exception e)
	{
		LOGGER.debug("In CATCH block");
		
//		e.printStackTrace();
		LOGGER.debug("Creating File object");
		File deleteUploadedFile = new File(trainingPartnerCSVFileName);
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("deleting Saved file from system");
	    deleteUploadedFile.delete();
	    LOGGER.debug("Successfully deleted");
	    
	    LOGGER.debug("returning Error list as String");
		return "Error checking Foreign key constraint . Kindly try again .";
		
	}
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */

			  try{				
				  LOGGER.debug("In TRY block");
				  
				  LOGGER.debug("Iterating ArrayList object");
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
					LOGGER.debug("Making a Request to Dao to get data");						
					status=dataImportTrainingPartnerDao.dataImportTrainingPartnerPrimaryKeyConstraintCheck(getRecord);
					LOGGER.debug("Response received from Dao");
			
					if(status==0)
					{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					LOGGER.debug("Record Doesn't exist in Database");
					LOGGER.debug("Inserting data into Database");
					LOGGER.debug("Making a Request to Dao to get data");
					int insertDataStatus=dataImportTrainingPartnerDao.insertDataInTrainingPartner(getRecord);
					LOGGER.debug("Response received from Dao");
				
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
					LOGGER.debug("Record exist in Database");
					LOGGER.debug("Updating data into Database");
					LOGGER.debug("Making a Request to Dao to get data");
					int updateDataStatus=dataImportTrainingPartnerDao.updateDataInTrainingPartner(getRecord);
					LOGGER.debug("Response received from Dao");
					
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				LOGGER.debug("Closing CSV reader");
				trainingPartnerCSVReader.close();
				LOGGER.debug("Successfully closed");
				/*
				 * Inserting data in csvUploaded  Table
				 */	
				LOGGER.debug("Creating date object");
				Date date=new Date(System.currentTimeMillis());
				LOGGER.debug("Successfully created and initialized");
				
				LOGGER.debug("Creating HashMap object");		
				Map<String,Object> uploadedFileInfo= new HashMap<String, Object>();
				LOGGER.debug("Successfully created");
				
				LOGGER.debug("Initializing HashMap object");
				uploadedFileInfo.put("csvType",type);
				uploadedFileInfo.put("csvName",fileNameToBeSaved);
				uploadedFileInfo.put("csvUploadDate",date);
				uploadedFileInfo.put("csvUploadUserId",userId);
				LOGGER.debug("Successfully initialized");
				
				/*
				 * Checking for valid UserId (Foreign key constraint)
				 */
				LOGGER.debug("Checking if UserId exists");
				LOGGER.debug("Making a Request to Dao to get data");
				status=dataImportCSVUploadTableDao.dataImportCSVUploadForeignKeyConstraintCheck(uploadedFileInfo);
				LOGGER.debug("Response received from Dao");
				
				if(status==0 || status==2)
				{
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(trainingPartnerCSVFileName);
					LOGGER.debug("Successfully created and initialized");
					
					LOGGER.debug("deleting Saved file from system");
				    deleteUploadedFile.delete();	
				    LOGGER.debug("Successfully deleted");
				    
				    LOGGER.debug("returning Error list as String");
					return "Invalid User Id . Action Aborted";	
				}
				
				LOGGER.debug("Inserting data in database");
				LOGGER.debug("Making a Request to Dao to get data");
				int insertDataStatus=dataImportCSVUploadTableDao.insertDataInCSVUpload(uploadedFileInfo);
				LOGGER.debug("Response received from Dao");
				
				if(!(insertDataStatus>0))
				{
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(trainingPartnerCSVFileName);
					LOGGER.debug("Successfully created and initialized");
					
					LOGGER.debug("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.debug("Successfully deleted");
				    
				    LOGGER.debug("returning Error list as String");
					return "Some Error occured while inserting data in csvUploaded By details table . Kindly try again ."; 
				}
				
				return "Data Successfully inserted in Database";
				
			  }	// end of try
				
			  catch(Exception e)
				{
				  	LOGGER.debug("In CATCH block");
		        	
				  	LOGGER.error("ERROR: Encountered an Exception - "+e);
		   			
				  	LOGGER.debug("Closing CSV reader");
					trainingPartnerCSVReader.close();
					LOGGER.debug("Successfully closed");
					
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(trainingPartnerCSVFileName);
					LOGGER.debug("Successfully created and initialized");
					
					LOGGER.debug("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.debug("Successfully deleted");
				    
				    LOGGER.debug("returning Error list as String");
//					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}
	}
}