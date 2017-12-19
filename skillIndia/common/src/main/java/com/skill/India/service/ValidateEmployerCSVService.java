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
		
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ValidateEmployerCSVService - validateEmployerCSV");
		LOGGER.debug("Parameters Received from Controller are - 'employerCSVFileName': "+employerCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
		
		CSVReader employerCSVReader=null;
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
			
			LOGGER.debug("Setting type of object to ValidateEmployerCSVDto");
			strategy.setType(ValidateEmployerCSVDto.class);
		String [] employerCSVColumns=new String[]{"employerId","employerName","locationOfEmployer","locationOfEmployerDistrict","locationOfEmployerState"};
		
		LOGGER.debug("Setting ColumnMapping of object");
		strategy.setColumnMapping(employerCSVColumns);
		//String employerCSVFileName = "D:\\EclipseWorkspace\\Employer.csv";

		LOGGER.debug("Creating CSVReader object ");
		employerCSVReader=new CSVReader(new FileReader(employerCSVFileName),',','"',2);
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating CsvToBean object ");
		CsvToBean<ValidateEmployerCSVDto> employerCSVToBean=new CsvToBean<ValidateEmployerCSVDto>();
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating List object of type ValidateEmployerCSVDto");
		List<ValidateEmployerCSVDto> employerCSVDataList= employerCSVToBean.parse(strategy,employerCSVReader);
		LOGGER.debug("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		
		LOGGER.debug("Iterating List Object");
		for(ValidateEmployerCSVDto employerCSVData :employerCSVDataList)
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
			String employerId=employerCSVData.getEmployerId().trim();
			String employerName=employerCSVData.getEmployerName().trim();
			String locationOfEmployer=employerCSVData.getLocationOfEmployer().trim();
			String locationOfEmployerDistrict=employerCSVData.getLocationOfEmployerDistrict().trim();
			String locationOfEmployerState=employerCSVData.getLocationOfEmployerState().trim();
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			LOGGER.debug("Checking Validations for mandatory fields");
			if(employerId.equals("") || employerName.equals("") || locationOfEmployer.equals("")
			|| locationOfEmployerDistrict.equals("") || locationOfEmployerState.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty ";
			}
			
			/*
			 * Checking for error in employerId column 
			 */
			
			LOGGER.debug("Checking Validations of employerId");
			if(!ValidationUtils.numbersCheck(employerId) || employerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'employerId' column ";
			}
			
			/*
			 * Checking for error in employerName column 
			 */

			LOGGER.debug("Checking Validations of employerName");
			if(!ValidationUtils.lettersCheck(employerName) || employerName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'employerName' column ";
			}

			/*
			 * Checking for error in locationOfEmployer column 
			 */

			LOGGER.debug("Checking Validations of locationOfEmployer");
			if(locationOfEmployer.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployer' column ";
			}
				
			/*
			 * Checking for error in locationOfEmployerDistrict column 
			 */

			LOGGER.debug("Checking Validations of locationOfEmployerDistrict");
			if(!ValidationUtils.lettersCheck(locationOfEmployerDistrict) || locationOfEmployerDistrict.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployerDistrict' column ";
			}
			
			/*
			 * Checking for error in locationOfEmployerState column 
			 */
			
			LOGGER.debug("Checking Validations of locationOfEmployerState");
			if(!ValidationUtils.lettersCheck(locationOfEmployerState) || locationOfEmployerState.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployerState' column ";
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
				employerName=employerName.toLowerCase();
				locationOfEmployer=locationOfEmployer.toLowerCase();
				locationOfEmployerDistrict=locationOfEmployerDistrict.toLowerCase();
				locationOfEmployerState=locationOfEmployerState.toLowerCase();
				
				 /*
				  * Inserting row wise data in HashMap
				  */
				
				LOGGER.debug("Inserting values into HashMap Object");
				record.put("employerId",employerId);
				record.put("employerName",employerName);
				record.put("locationOfEmployer",locationOfEmployer);
				record.put("locationOfEmployerDistrict",locationOfEmployerDistrict);
				record.put("locationOfEmployerState",locationOfEmployerState);
				
				LOGGER.debug("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
				LOGGER.debug("Successfully Added");
			}
		}
		if(errorExist==1)
		{
			LOGGER.debug("Closing CSV reader");
			employerCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(employerCSVFileName);
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
			employerCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(employerCSVFileName);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.debug("Successfully deleted");
		    
		    LOGGER.debug("returning Error list as String");
//			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}

		/*
		 * Checking primary key Constraints and performing respective actions  
		 */
			  try{
				  LOGGER.debug("In TRY block");
					
				LOGGER.debug("Iterating Array List object"); 
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
					LOGGER.debug("Checking for foreign key constraint");
					LOGGER.debug("Making a Request to Dao to get data");
					int status=dataImportEmployerDao.dataImportEmployerPrimaryKeyConstraintCheck(getRecord);
					LOGGER.debug("Response received from Dao");
					
					if(status==0)
					{
						/*
						 * If primary key doesn't exists in DB then run insert query
						 */
						LOGGER.debug("Record Doesn't exist in Database");
						LOGGER.debug("Inserting data into Database");
						LOGGER.debug("Making a Request to Dao to get data");
						int insertDataStatus=dataImportEmployerDao.insertDataInEmployer(getRecord);
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
					int updateDataStatus=dataImportEmployerDao.updateDataInEmployer(getRecord);
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
				employerCSVReader.close();
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
					File deleteUploadedFile = new File(employerCSVFileName);
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
					File deleteUploadedFile = new File(employerCSVFileName);
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
					employerCSVReader.close();
					LOGGER.debug("Successfully closed");
					
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(employerCSVFileName);
					LOGGER.debug("Successfully created and initialized");;
					
					LOGGER.debug("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.debug("Successfully deleted");
				    
				    LOGGER.debug("returning Error list as String");
//				    e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}				
		
			}

		}