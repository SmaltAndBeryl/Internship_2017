package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Centre .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Centre sheet
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
import com.skill.India.dao.DataImportCentreDao;
import com.skill.India.dto.ValidateCentreCSVDto;

@Service
public class ValidateCentreCSVService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateCentreCSVService.class);
	
	@Autowired
	private DataImportCentreDao dataImportCentreDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao;
	
	public String validateCentreCSV(String centreCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In ValidateCentreCSVService - validateCentreCSV");
		LOGGER.info("Parameters Received from Controller are - 'centreCSVFileName': "+centreCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': ",fileNameToBeSaved);
		
		CSVReader centreCSVReader=null;
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
		
		LOGGER.info("Setting type of object to ValidateCentreCSVDto");
		strategy.setType(ValidateCentreCSVDto.class);
		String [] centreCSVColumns=new String[]{"centreId","centreName","centrePOCContactname","centreAddress","district","state","trainingPartnerId"};
		
		LOGGER.info("Setting ColumnMapping of object");
		strategy.setColumnMapping(centreCSVColumns);
		//String centreCSVFileName = "D:\\EclipseWorkspace\\Centre.csv";
		
		LOGGER.info("Creating CSVReader object ");
		centreCSVReader=new CSVReader(new FileReader(centreCSVFileName),',','"',2);
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating CsvToBean object ");
		CsvToBean<ValidateCentreCSVDto> centreCSVToBean=new CsvToBean<ValidateCentreCSVDto>();
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating List object of type ValidateCentreCSVDto");
		List<ValidateCentreCSVDto> centreCSVDataList= centreCSVToBean.parse(strategy,centreCSVReader);
		LOGGER.info("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		LOGGER.info("Iterating List Object");
		for(ValidateCentreCSVDto centreCSVData :centreCSVDataList)
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
			String centreId=centreCSVData.getCentreId(); 
			String centreName=centreCSVData.getCentreName();
			String centrePOCContactName=centreCSVData.getCentrePOCContactname();
			String centreAddress=centreCSVData.getCentreAddress();
			String district=centreCSVData.getDistrict();
			String state=centreCSVData.getState();
			String trainingPartnerId=centreCSVData.getTrainingPartnerId();
		
			/*
			 * Checking for error in centreId column 
			 */
			LOGGER.info("Checking Validations of centreId");
			if(!ValidationUtils.numbersCheck(centreId) ||  centreId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centerId' column ";
			}

			/*
			 * Checking for error in centreName column 
			 */
			LOGGER.info("Checking Validations of centreName");
			if(ValidationUtils.numbersCheck(centreName) || centreName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centreName' column ";
			}
			
			/*
			 * Checking for error in centrePOCContactName column 
			 */
			
			LOGGER.info("Checking Validations of centrePOCContactName");
			if(ValidationUtils.numbersCheck(centrePOCContactName) || centrePOCContactName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centrePOCContactName' column ";
			}
			
			/*
			 * Checking for error in district column 
			 */
			
			LOGGER.info("Checking Validations of district");
			if(!ValidationUtils.lettersCheck(district) || district.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'district' column ";
			}

			/*
			 * Checking for error in state column 
			 */
			
			LOGGER.info("Checking Validations of state");
			if(!ValidationUtils.lettersCheck(state) || state.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'state' column ";
			}
			
			/*
			 * Checking for error in trainingPartnerId column 
			 */
			
			LOGGER.info("Checking Validations of trainingPartnerId");
			if(trainingPartnerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerId' column ";
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
				centreName=centreName.toLowerCase();
				centrePOCContactName=centrePOCContactName.toLowerCase();
				centreAddress=centreAddress.toLowerCase();
				district=district.toLowerCase();
				state=state.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				
				/*
				  * Inserting row wise data in HashMap
				  */
				LOGGER.info("Inserting values into HashMap Object");
				record.put("centreId",centreId);
				record.put("centreName",centreName);
				record.put("centrePOCContactName",centrePOCContactName);
				record.put("centreAddress",centreAddress);
				record.put("district",district);
				record.put("state",state);
				record.put("trainingPartnerId",trainingPartnerId);
				
				LOGGER.info("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
			}
		}
	
		if(errorExist==1)
			{
				LOGGER.info("Closing CSV reader");
				centreCSVReader.close();
				LOGGER.info("Successfully closed");
				
				LOGGER.info("Creating File object");
				File deleteUploadedFile = new File(centreCSVFileName);
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
			centreCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(centreCSVFileName);
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
				
				LOGGER.info("Iterating ArrayList object");
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				LOGGER.info("Making a Request to Dao to get data");	
				int status=dataImportCentreDao.dataImportCentreForeignKeyConstraintCheck(getRecord);
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
	        	
				LOGGER.error("ERROR: Encountered an Exception - ",e);
	   			
				LOGGER.info("Closing CSV reader");
	   			centreCSVReader.close();
	   			LOGGER.info("Successfully closed");
				
	   			LOGGER.info("Creating File object");
				File deleteUploadedFile = new File(centreCSVFileName);
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
					LOGGER.info("Making a Request to Dao to get data");
				int status=dataImportCentreDao.dataImportCentrePrimaryKeyConstraintCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					LOGGER.info("Record Doesn't exist in Database");
					LOGGER.info("Inserting data into Database");
					LOGGER.info("Making a Request to Dao to get data");
					int insertDataStatus=dataImportCentreDao.insertDataInCentre(getRecord);
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
					int updateDataStatus=dataImportCentreDao.updateDataInCentre(getRecord);
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
				centreCSVReader.close();
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
					File deleteUploadedFile = new File(centreCSVFileName);
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
					File deleteUploadedFile = new File(centreCSVFileName);
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
					centreCSVReader.close();
					LOGGER.info("Successfully closed");
					
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(centreCSVFileName);
					LOGGER.info("Successfully created and initialized");
					
					LOGGER.info("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.info("Successfully deleted");
				    
				    LOGGER.info("returning Error list as String");
//					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		

	}
}