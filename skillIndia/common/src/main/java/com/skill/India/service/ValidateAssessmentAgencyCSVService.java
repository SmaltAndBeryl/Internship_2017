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
import ch.qos.logback.classic.pattern.Util;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dao.DataImportAssessmentAgencyDao;
import com.skill.India.dao.DataImportCSVUploadTableDao;
import com.skill.India.dto.ValidateAssessmentAgencyCSVDto;
import com.skill.India.dto.ValidateCentreCSVDto;

@Service
public class ValidateAssessmentAgencyCSVService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateAssessmentAgencyCSVService.class);
	
	@Autowired
	private DataImportAssessmentAgencyDao dataImportAssessmentAgencyDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao; 
	
	public String validateAssessmentAgencyCSV(String assessmentAgencyCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ValidateAssessmentAgencyCSVService - validateAssessmentAgencyCSV");
		LOGGER.debug("Parameters Received from Controller are - 'assessmentAgencyCSVFileName': "+assessmentAgencyCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
		
		CSVReader assessmentAgencyCSVReader=null;
		/*
		 *Create Array List to store the data of csv read (in Hashmap's) 
		 */
		LOGGER.debug("Creating ArrayList object");
		ArrayList<Map<String,Object>> arrayOfRecords= new ArrayList<Map<String,Object>>();
		LOGGER.debug("Successfully created");
		
		try{
			LOGGER.debug("In TRY block");
			
			LOGGER.debug("Creating ColumnPositionMappingStrategy object");
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("Setting type of object to ValidateAssessmentAgencyCSVDto");
			strategy.setType(ValidateAssessmentAgencyCSVDto.class);
		String [] assessmentAgencyCSVColumns=new String[]{"agencyId","applicationId","agencyName"};
		
		LOGGER.debug("Setting ColumnMapping of object");
		strategy.setColumnMapping(assessmentAgencyCSVColumns);
	//	String assessmentAgencyCSVFileName = "D:\\EclipseWorkspace\\Assessment_Agency.csv";
		
		LOGGER.debug("Creating CSVReader object ");
		assessmentAgencyCSVReader=new CSVReader(new FileReader(assessmentAgencyCSVFileName),',','"',2);
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating CsvToBean object ");
		CsvToBean<ValidateAssessmentAgencyCSVDto> assessmentAgencyCSVToBean=new CsvToBean<ValidateAssessmentAgencyCSVDto>();
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating List object of type ValidateAssessmentAgencyCSVDto");
		List<ValidateAssessmentAgencyCSVDto> assessmentAgencyCSVDataList= assessmentAgencyCSVToBean.parse(strategy,assessmentAgencyCSVReader);
		LOGGER.debug("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";	
		
		LOGGER.debug("Iterating List Object");
		for(ValidateAssessmentAgencyCSVDto assessmentAgencyCSVData :assessmentAgencyCSVDataList)
		{
			/*
			 * Map to store data of each row of csv read and then added to arraylist
			 */
			LOGGER.debug("Creating HashMap object");
			Map<String,Object> record=new HashMap<String, Object>();
			LOGGER.debug("Successfully created");
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			LOGGER.debug("Fetching data from each row");		
			String agencyId=assessmentAgencyCSVData.getAgencyId().trim();
			String agencyName=assessmentAgencyCSVData.getAgencyName().trim();
			String applicationId=assessmentAgencyCSVData.getApplicationId().trim();
			
			/*
			 * Checking for error in agencyId column 
			 */
			LOGGER.debug("Checking Validations of agencyId");
			if(!ValidationUtils.numbersCheck(agencyId) || agencyId.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyId' column ";
			}
			
			/*
			 * checking for error in applicationId column 
			 */
			LOGGER.debug("Checking Validations of applicationId");
			if(!(ValidationUtils.numbersCheck(applicationId)) || applicationId.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'aapplicationId' column ";
			}
			/*
			 * Checking for error in agencyName column 
			 */
			LOGGER.debug("Checking Validations of agencyName");
			if(ValidationUtils.numbersCheck(agencyName) || agencyName.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyName' column ";
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
				LOGGER.debug("Converting all values to lower Case");
				agencyName=agencyName.toLowerCase();
				
				LOGGER.debug("Inserting values into HashMap Object");
				record.put("agencyId",agencyId);
				record.put("agencyName",agencyName);
				record.put("applicationId",applicationId);
				
				LOGGER.debug("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
			}
		}  // end of for 
		
		/*
		 * If error exist then throw error else transport data to DAO to insert into database
		 */
		
		if(errorExist==1)
			{
			LOGGER.debug("Closing CSV reader");
			assessmentAgencyCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.debug("Successfully deleted");
		    
		    LOGGER.debug("returning Error list as String");
			return errorListAllRecords;
			}
		} // end of try 	
		catch(Exception e)
		{
			LOGGER.debug("In CATCH block");
			
			LOGGER.debug("Closing CSV reader");
			assessmentAgencyCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
			LOGGER.debug("Successfully created and initialized");
			
			LOGGER.debug("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.debug("Successfully deleted");
		    
		    LOGGER.debug("returning Error list as String");
//			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		/*
		 * Checking for foreign key constraint of applicationId
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
			status=dataImportAssessmentAgencyDao.dataImportAssessmentAgencyForeignKeyConstraintCheck(getRecord);
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
			assessmentAgencyCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
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
		File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("deleting Saved file from system");
	    deleteUploadedFile.delete();
	    LOGGER.debug("Successfully deleted");
	    
	    LOGGER.debug("returning Error list as String");
	    return "Error checking Foreign key constraint . Kindly try again .";
		
	}
	
		/*
		 * Checking primary key Constraint and performing respective actions
		 */
		
			  try{	
				  LOGGER.debug("In TRY block");
				 
				  LOGGER.debug("Iterating ArrayList object");
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
					LOGGER.debug("Checking for foreign key constraint");
					LOGGER.debug("Making a Request to Dao to get data");
				status=dataImportAssessmentAgencyDao.dataImportAssessmentAgencyPrimaryKeyConstraintCheck(getRecord);
				LOGGER.debug("Response received from Dao");
				
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					LOGGER.debug("Record Doesn't exist in Database");
					LOGGER.debug("Inserting data into Database");
					LOGGER.debug("Making a Request to Dao to get data");
					int insertDataStatus=dataImportAssessmentAgencyDao.insertDataInAssessmentAgency(getRecord);
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
					int updateDataStatus=dataImportAssessmentAgencyDao.updateDataInAssessmentAgency(getRecord);
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
				assessmentAgencyCSVReader.close();
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
					File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
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
					File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
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
					assessmentAgencyCSVReader.close();
					LOGGER.debug("Successfully closed");
					
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
					LOGGER.debug("Successfully created and initialized");;
					
					LOGGER.debug("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.debug("Successfully deleted");
				    
				    LOGGER.debug("returning Error list as String");
//					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		
	
	}
}
