package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Employer .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Employer sheet
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
import com.skill.India.dao.DataImportEmployerDao;
import com.skill.India.dto.ValidateEmployerCSVDto;

@Service
public class ValidateEmployerCSVService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateEmployerCSVService.class);
	
	@Autowired
	private DataImportEmployerDao dataImportEmployerDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao;
	
	public String validateEmployerCSV( String employerCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In ValidateEmployerCSVService - validateEmployerCSV");
		LOGGER.info("Parameters Received from Controller are - 'employerCSVFileName': "+employerCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
		
		CSVReader employerCSVReader=null;
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
			
			LOGGER.info("Setting type of object to ValidateEmployerCSVDto");
			strategy.setType(ValidateEmployerCSVDto.class);
		String [] employerCSVColumns=new String[]{"employerId","employerName","locationOfEmployer","locationOfEmployerDistrict","locationOfEmployerState"};
		
		LOGGER.info("Setting ColumnMapping of object");
		strategy.setColumnMapping(employerCSVColumns);
		//String employerCSVFileName = "D:\\EclipseWorkspace\\Employer.csv";

		LOGGER.info("Creating CSVReader object ");
		employerCSVReader=new CSVReader(new FileReader(employerCSVFileName),',','"',2);
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating CsvToBean object ");
		CsvToBean<ValidateEmployerCSVDto> employerCSVToBean=new CsvToBean<ValidateEmployerCSVDto>();
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating List object of type ValidateEmployerCSVDto");
		List<ValidateEmployerCSVDto> employerCSVDataList= employerCSVToBean.parse(strategy,employerCSVReader);
		LOGGER.info("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		
		LOGGER.info("Iterating List Object");
		for(ValidateEmployerCSVDto employerCSVData :employerCSVDataList)
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
			String employerId=employerCSVData.getEmployerId();
			String employerName=employerCSVData.getEmployerName();
			String locationOfEmployer=employerCSVData.getLocationOfEmployer();
			String locationOfEmployerDistrict=employerCSVData.getLocationOfEmployerDistrict();
			String locationOfEmployerState=employerCSVData.getLocationOfEmployerState();
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			LOGGER.info("Checking Validations for mandatory fields");
			if(employerId.equals("") || employerName.equals("") || locationOfEmployer.equals("")
			|| locationOfEmployerDistrict.equals("") || locationOfEmployerState.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty ";
			}
			
			/*
			 * Checking for error in employerId column 
			 */
			
			LOGGER.info("Checking Validations of employerId");
			if(!ValidationUtils.numbersCheck(employerId) || employerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'employerId' column ";
			}
			
			/*
			 * Checking for error in employerName column 
			 */

			LOGGER.info("Checking Validations of employerName");
			if(!ValidationUtils.lettersCheck(employerName) || employerName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'employerName' column ";
			}

			/*
			 * Checking for error in locationOfEmployer column 
			 */

			LOGGER.info("Checking Validations of locationOfEmployer");
			if(locationOfEmployer.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployer' column ";
			}
				
			/*
			 * Checking for error in locationOfEmployerDistrict column 
			 */

			LOGGER.info("Checking Validations of locationOfEmployerDistrict");
			if(!ValidationUtils.lettersCheck(locationOfEmployerDistrict) || locationOfEmployerDistrict.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployerDistrict' column ";
			}
			
			/*
			 * Checking for error in locationOfEmployerState column 
			 */
			
			LOGGER.info("Checking Validations of locationOfEmployerState");
			if(!ValidationUtils.lettersCheck(locationOfEmployerState) || locationOfEmployerState.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployerState' column ";
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
				employerName=employerName.toLowerCase();
				locationOfEmployer=locationOfEmployer.toLowerCase();
				locationOfEmployerDistrict=locationOfEmployerDistrict.toLowerCase();
				locationOfEmployerState=locationOfEmployerState.toLowerCase();
				
				 /*
				  * Inserting row wise data in HashMap
				  */
				
				LOGGER.info("Inserting values into HashMap Object");
				record.put("employerId",employerId);
				record.put("employerName",employerName);
				record.put("locationOfEmployer",locationOfEmployer);
				record.put("locationOfEmployerDistrict",locationOfEmployerDistrict);
				record.put("locationOfEmployerState",locationOfEmployerState);
				
				LOGGER.info("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
				LOGGER.info("Successfully Added");
			}
		}
		if(errorExist==1)
		{
			LOGGER.info("Closing CSV reader");
			employerCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(employerCSVFileName);
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
			employerCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(employerCSVFileName);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.info("Successfully deleted");
		    
		    LOGGER.info("returning Error list as String");
//			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}

		/*
		 * Checking primary key Constraints and performing respective actions  
		 */
			  try{
				  LOGGER.info("In TRY block");
					
				LOGGER.info("Iterating Array List object"); 
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
					LOGGER.info("Checking for foreign key constraint");
					LOGGER.info("Making a Request to Dao to get data");
					int status=dataImportEmployerDao.dataImportEmployerPrimaryKeyConstraintCheck(getRecord);
					LOGGER.info("Response received from Dao");
					
					if(status==0)
					{
						/*
						 * If primary key doesn't exists in DB then run insert query
						 */
						LOGGER.info("Record Doesn't exist in Database");
						LOGGER.info("Inserting data into Database");
						LOGGER.info("Making a Request to Dao to get data");
						int insertDataStatus=dataImportEmployerDao.insertDataInEmployer(getRecord);
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
					int updateDataStatus=dataImportEmployerDao.updateDataInEmployer(getRecord);
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
				employerCSVReader.close();
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
					File deleteUploadedFile = new File(employerCSVFileName);
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
					File deleteUploadedFile = new File(employerCSVFileName);
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
		        	LOGGER.error("ERROR: Encountered an Exception - "+e);
		   			
		        	LOGGER.info("Closing CSV reader");
					employerCSVReader.close();
					LOGGER.info("Successfully closed");
					
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(employerCSVFileName);
					LOGGER.info("Successfully created and initialized");;
					
					LOGGER.info("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.info("Successfully deleted");
				    
				    LOGGER.info("returning Error list as String");
//				    e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}				
		
			}

		}