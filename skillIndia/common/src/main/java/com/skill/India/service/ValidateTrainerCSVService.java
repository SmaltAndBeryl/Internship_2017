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
		
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ValidateTrainerCSVService - validateTrainerCSV");
		LOGGER.debug("Parameters Received from Controller are - 'trainerCSVFileName': "+trainerCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
		
		CSVReader trainerCSVReader=null;
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
			
			LOGGER.debug("Setting type of object to ValidateTrainerCSVDto");
			strategy.setType(ValidateTrainerCSVDto.class);
			String [] trainerCSVColumns=new String[]{"trainerId","trainerName","designation","trainingPartnerId"};
			
			LOGGER.debug("Setting ColumnMapping of object");
			strategy.setColumnMapping(trainerCSVColumns);
			// String trainerCSVFileName = "D:\\EclipseWorkspace\\Trainer.csv";
			
			LOGGER.debug("Creating CSVReader object ");
			trainerCSVReader=new CSVReader(new FileReader(trainerCSVFileName),',','"',2);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("Creating CsvToBean object ");
			CsvToBean<ValidateTrainerCSVDto> trainerCSVToBean=new CsvToBean<ValidateTrainerCSVDto>();
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("Creating List object of type ValidateTrainerCSVDto");
			List<ValidateTrainerCSVDto> trainerCSVDataList= trainerCSVToBean.parse(strategy,trainerCSVReader);
			LOGGER.debug("Successfully created and initialized");
			
			int recordCount=0;
			int errorExist=0;
			String errorListAllRecords="";
			
			LOGGER.debug("Iterating List Object");
			for(ValidateTrainerCSVDto trainerCSVData :trainerCSVDataList)
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
				String trainerId=trainerCSVData.getTrainerId().trim();
				String trainerName=trainerCSVData.getTrainerName().trim();
				String designation=trainerCSVData.getDesignation().trim();
				String trainingPartnerId=trainerCSVData.getTrainingPartnerId().trim();
	
				/*
				 * Checking for error in trainerId column 
				 */
					
				LOGGER.debug("Checking Validations of trainerId");
				if(!ValidationUtils.numbersCheck(trainerId) || trainerId.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'trainerId' column .";
				}
				
				/*
				 * Checking for error in trainerName column 
				 */
			
				LOGGER.debug("Checking Validations of trainerName");
				if(ValidationUtils.numbersCheck(trainerName) || trainerName.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'trainerName' column .";
				}
				
				/*
				 * Checking for error in designation column 
				 */
				
				LOGGER.debug("Checking Validations of designation");
				if(ValidationUtils.numbersCheck(designation) || designation.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'designation' column .";
				}
			
				/*
				 * Checking for error in trainingPartnerId column 
				 */
				
				LOGGER.debug("Checking Validations of trainingPartnerId");
				if(trainingPartnerId.equals(""))
				{
					errorStatus=1;
					errorString=errorString+ "Error in 'trainingPartnerId' column .";
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
				trainerName=trainerName.toLowerCase();
				designation=designation.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				 /*
				  * Inserting row wise data in HashMap
				  */
				LOGGER.debug("Inserting values into HashMap Object");
				record.put("trainerId",trainerId);
				record.put("trainerName",trainerName);
				record.put("designation",designation);
				record.put("trainingPartnerId",trainingPartnerId);
				
				LOGGER.debug("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
			}	
		}
		
		if(errorExist==1)
		{
			LOGGER.debug("Closing CSV reader");
			trainerCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(trainerCSVFileName);
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
			
			LOGGER.debug("Closing CSV reader");
			trainerCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(trainerCSVFileName);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.debug("Successfully deleted");
		    
		    LOGGER.debug("returning Error list as String");
//			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		
		
		/*
		 * Checking for foreign key constraint of batchId & employerId
		 */
		
		try{
			LOGGER.debug("In TRY block");
			
			LOGGER.debug("Iterating Array List object"); 
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				LOGGER.debug("Checking if record details already exists in database");
				LOGGER.debug("Making a Request to Dao to get data");
				int status=dataImportTrainerDao.dataImportEmployerForeignKeyConstraintCheck(getRecord);
				LOGGER.debug("Response received from Dao");
				
				if(status==0 || status==2)
				{
				throw new Exception();	
				}
				
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				LOGGER.debug("In CATCH block");
				
				LOGGER.debug("Closing CSV reader");
				trainerCSVReader.close();
				LOGGER.debug("Successfully closed");
				
				LOGGER.debug("Creating File object");
				File deleteUploadedFile = new File(trainerCSVFileName);
				LOGGER.debug("Successfully created and initialized");
				
				LOGGER.debug("deleting Saved file from system");
			    deleteUploadedFile.delete();
			    LOGGER.debug("Successfully deleted");
			    
			    LOGGER.debug("returning Error list as String");
//				e.printStackTrace();
				return "Error in trainingPartnerId column. Kindly recheck the details ."
			+ "trainingPartnerId not found in Training Partner record .";
			}
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */

			  try{				
				  LOGGER.debug("In TRY block");
				 
				  LOGGER.debug("Iterating ArrayList object");
				for(Map<String, Object> getRecord:arrayOfRecords)
				{	
					LOGGER.debug("Checking for foreign key constraint");
					LOGGER.debug("Making a Request to Dao to get data");
				int status=dataImportTrainerDao.dataImportEmployerPrimaryKeyConstraintCheck(getRecord);
				LOGGER.debug("Response received from Dao");
				
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					LOGGER.debug("Record Doesn't exist in Database");
					LOGGER.debug("Inserting data into Database");
					LOGGER.debug("Making a Request to Dao to get data");
					int insertDataStatus=dataImportTrainerDao.insertDataInEmployer(getRecord);
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
					int updateDataStatus=dataImportTrainerDao.updateDataInEmployer(getRecord);
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
				trainerCSVReader.close();
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
				int status=dataImportCSVUploadTableDao.dataImportCSVUploadForeignKeyConstraintCheck(uploadedFileInfo);
				LOGGER.debug("Response received from Dao");
				
				if(status==0 || status==2)
				{
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(trainerCSVFileName);
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
					File deleteUploadedFile = new File(trainerCSVFileName);
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
					trainerCSVReader.close();
					LOGGER.debug("Successfully closed");
					
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(trainerCSVFileName);
					LOGGER.debug("Successfully created and initialized");
					
					LOGGER.debug("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.debug("Successfully deleted");
				    
				    LOGGER.debug("returning Error list as String");
//					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		
		//return "Successfully Uploaded CSV File";
	}
}