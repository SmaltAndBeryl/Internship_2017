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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateTrainerCSVService.class);
	
	@Autowired
	private DataImportTrainerDao dataImportTrainerDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao; 
	
	public String validateTrainerCSV(String trainerCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In ValidateTrainerCSVService - validateTrainerCSV");
		LOGGER.info("Parameters Received from Controller are - 'trainerCSVFileName': "+trainerCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': ",fileNameToBeSaved);
		
		CSVReader trainerCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		LOGGER.info("Creating ArrayList object");
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		LOGGER.info("Successfully created");
		try{
			LOGGER.info("In TRY block");
			
			LOGGER.info("Creating ColumnPositionMappingStrategy object");
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("Setting type of object to ValidateTrainerCSVDto");
			strategy.setType(ValidateTrainerCSVDto.class);
			String [] trainerCSVColumns=new String[]{"trainerId","trainerName","designation","trainingPartnerId"};
			
			LOGGER.info("Setting ColumnMapping of object");
			strategy.setColumnMapping(trainerCSVColumns);
			// String trainerCSVFileName = "D:\\EclipseWorkspace\\Trainer.csv";
			
			LOGGER.info("Creating CSVReader object ");
			trainerCSVReader=new CSVReader(new FileReader(trainerCSVFileName),',','"',2);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("Creating CsvToBean object ");
			CsvToBean<ValidateTrainerCSVDto> trainerCSVToBean=new CsvToBean<ValidateTrainerCSVDto>();
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("Creating List object of type ValidateTrainerCSVDto");
			List<ValidateTrainerCSVDto> trainerCSVDataList= trainerCSVToBean.parse(strategy,trainerCSVReader);
			LOGGER.info("Successfully created and initialized");
			
			int recordCount=0;
			int errorExist=0;
			String errorListAllRecords="";
			
			LOGGER.info("Iterating List Object");
			for(ValidateTrainerCSVDto trainerCSVData :trainerCSVDataList)
			{
				/*
				 *  Map to store data of each row of csv read and then added to arraylist
				 */
				LOGGER.info("Creating HashMap object");
				Map<String ,Object> record=new HashMap<String, Object>();
				LOGGER.info("Successfully created");
			
				recordCount++;
				int errorStatus=0;
				String errorString="";
				
				LOGGER.info("Fetching data from each row");		
				String trainerId=trainerCSVData.getTrainerId();
				String trainerName=trainerCSVData.getTrainerName();
				String designation=trainerCSVData.getDesignation();
				String trainingPartnerId=trainerCSVData.getTrainingPartnerId();
	
				/*
				 * Checking for error in trainerId column 
				 */
					
				LOGGER.info("Checking Validations of trainerId");
				if(!ValidationUtils.numbersCheck(trainerId) || trainerId.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'trainerId' column .";
				}
				
				/*
				 * Checking for error in trainerName column 
				 */
			
				LOGGER.info("Checking Validations of trainerName");
				if(ValidationUtils.numbersCheck(trainerName) || trainerName.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'trainerName' column .";
				}
				
				/*
				 * Checking for error in designation column 
				 */
				
				LOGGER.info("Checking Validations of designation");
				if(ValidationUtils.numbersCheck(designation) || designation.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'designation' column .";
				}
			
				/*
				 * Checking for error in trainingPartnerId column 
				 */
				
				LOGGER.info("Checking Validations of trainingPartnerId");
				if(trainingPartnerId.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'trainingPartnerId' column .";
				}
				
				LOGGER.info("Fetching Errors in records and making error String if found any");
				if(errorStatus==1)
				{
					LOGGER.info("Error Exists in CSV");
					errorExist=1;
					errorString="Error in Record "+recordCount + "." + errorString;
					errorListAllRecords=errorListAllRecords+errorString;	
				}
				
			else 
			{
				/*
				 * Keeping database consistent by inserting only lowercase values in it
				 */
				
				LOGGER.info("Converting all values to lower Case");
				trainerName=trainerName.toLowerCase();
				designation=designation.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				 /*
				  * Inserting row wise data in HashMap
				  */
				LOGGER.info("Inserting values into HashMap Object");
				record.put("trainerId",trainerId);
				record.put("trainerName",trainerName);
				record.put("designation",designation);
				record.put("trainingPartnerId",trainingPartnerId);
				
				LOGGER.info("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
			}	
		}
		
		if(errorExist==1)
		{
			LOGGER.info("Closing CSV reader");
			trainerCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(trainerCSVFileName);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.info("Successfully deleted");
		    
		    LOGGER.info("returning Error list as String");
			return errorListAllRecords;
		}
		}
		catch(Exception e)
		{
			LOGGER.info("In CATCH block");
			
			LOGGER.info("Closing CSV reader");
			trainerCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(trainerCSVFileName);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.info("Successfully deleted");
		    
		    LOGGER.info("returning Error list as String");
//			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		
		
		/*
		 * Checking for foreign key constraint of batchId & employerId
		 */
		
		try{
			LOGGER.info("In TRY block");
			
			LOGGER.info("Iterating Array List object"); 
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				LOGGER.info("Checking if record details already exists in database");
				LOGGER.info("Making a Request to Dao to get data");
				int status=dataImportTrainerDao.dataImportEmployerForeignKeyConstraintCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
				throw new Exception();	
				}
				
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				LOGGER.info("In CATCH block");
				
				LOGGER.info("Closing CSV reader");
				trainerCSVReader.close();
				LOGGER.info("Successfully closed");
				
				LOGGER.info("Creating File object");
				File deleteUploadedFile = new File(trainerCSVFileName);
				LOGGER.info("Successfully created and initialized");
				
				LOGGER.info("deleting Saved file from system");
			    deleteUploadedFile.delete();
			    LOGGER.info("Successfully deleted");
			    
			    LOGGER.info("returning Error list as String");
//				e.printStackTrace();
				return "Error in trainingPartnerId column. Kindly recheck the details ."
			+ "trainingPartnerId not found in Training Partner record .";
			}
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */

			  try{				
				  LOGGER.info("In TRY block");
				 
				  LOGGER.info("Iterating ArrayList object");
				for(Map<String, Object> getRecord:arrayOfRecords)
				{	
					LOGGER.info("Checking for foreign key constraint");
					LOGGER.info("Making a Request to Dao to get data");
				int status=dataImportTrainerDao.dataImportEmployerPrimaryKeyConstraintCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					LOGGER.info("Record Doesn't exist in Database");
					LOGGER.info("Inserting data into Database");
					LOGGER.info("Making a Request to Dao to get data");
					int insertDataStatus=dataImportTrainerDao.insertDataInEmployer(getRecord);
					LOGGER.info("Response received from Dao");
					
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
					LOGGER.info("Record exist in Database");
					LOGGER.info("Updating data into Database");
					LOGGER.info("Making a Request to Dao to get data");
					int updateDataStatus=dataImportTrainerDao.updateDataInEmployer(getRecord);
					LOGGER.info("Response received from Dao");
					
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				LOGGER.info("Closing CSV reader");
				trainerCSVReader.close();
				LOGGER.info("Successfully closed");

				/*
				 * Inserting data in csvUploaded  Table
				 */	
				LOGGER.info("Creating date object");
				Date date=new Date(System.currentTimeMillis());
				LOGGER.info("Successfully created and initialized");
				
				LOGGER.info("Creating HashMap object");
				Map<String,Object> uploadedFileInfo= new HashMap<String, Object>();
				LOGGER.info("Successfully created");
				
				LOGGER.info("Initializing HashMap object");
				uploadedFileInfo.put("csvType",type);
				uploadedFileInfo.put("csvName",fileNameToBeSaved);
				uploadedFileInfo.put("csvUploadDate",date);
				uploadedFileInfo.put("csvUploadUserId",userId);
				LOGGER.info("Successfully initialized");
				/*
				 * Checking for valid UserId (Foreign key constraint)
				 */
				
				LOGGER.info("Checking if UserId exists");
				LOGGER.info("Making a Request to Dao to get data");
				int status=dataImportCSVUploadTableDao.dataImportCSVUploadForeignKeyConstraintCheck(uploadedFileInfo);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(trainerCSVFileName);
					LOGGER.info("Successfully created and initialized");
					
					LOGGER.info("deleting Saved file from system");
				    deleteUploadedFile.delete();	
				    LOGGER.info("Successfully deleted");
				    
				    LOGGER.info("returning Error list as String");
					return "Invalid User Id . Action Aborted";	
				}
				
				LOGGER.info("Inserting data in database");
				LOGGER.info("Making a Request to Dao to get data");
				int insertDataStatus=dataImportCSVUploadTableDao.insertDataInCSVUpload(uploadedFileInfo);
				LOGGER.info("Response received from Dao");
				
				if(!(insertDataStatus>0))
				{
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(trainerCSVFileName);
					LOGGER.info("Successfully created and initialized");
					
					LOGGER.info("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.info("Successfully deleted");
				    
				    LOGGER.info("returning Error list as String");
					return "Some Error occured while inserting data in csvUploaded By details table . Kindly try again ."; 
				}
				
				
				return "Data Successfully inserted in Database";
				}	// end of try
				catch(Exception e)
				{
					LOGGER.info("In CATCH block");
		        	
					LOGGER.error("ERROR: Encountered an Exception - ",e);
		   			
					LOGGER.info("Closing CSV reader");
					trainerCSVReader.close();
					LOGGER.info("Successfully closed");
					
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(trainerCSVFileName);
					LOGGER.info("Successfully created and initialized");
					
					LOGGER.info("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.info("Successfully deleted");
				    
				    LOGGER.info("returning Error list as String");
//					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		
		//return "Successfully Uploaded CSV File";
	}
}