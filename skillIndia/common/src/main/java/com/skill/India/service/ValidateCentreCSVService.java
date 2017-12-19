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
		
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ValidateCentreCSVService - validateCentreCSV");
		LOGGER.debug("Parameters Received from Controller are - 'centreCSVFileName': "+centreCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
		
		CSVReader centreCSVReader=null;
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
		
		LOGGER.debug("Setting type of object to ValidateCentreCSVDto");
		strategy.setType(ValidateCentreCSVDto.class);
		String [] centreCSVColumns=new String[]{"centreId","centreName","centrePOCContactname","centreAddress","district","state","trainingPartnerId"};
		
		LOGGER.debug("Setting ColumnMapping of object");
		strategy.setColumnMapping(centreCSVColumns);
		//String centreCSVFileName = "D:\\EclipseWorkspace\\Centre.csv";
		
		LOGGER.debug("Creating CSVReader object ");
		centreCSVReader=new CSVReader(new FileReader(centreCSVFileName),',','"',2);
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating CsvToBean object ");
		CsvToBean<ValidateCentreCSVDto> centreCSVToBean=new CsvToBean<ValidateCentreCSVDto>();
		LOGGER.debug("Successfully created and initialized");
		
		LOGGER.debug("Creating List object of type ValidateCentreCSVDto");
		List<ValidateCentreCSVDto> centreCSVDataList= centreCSVToBean.parse(strategy,centreCSVReader);
		LOGGER.debug("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		LOGGER.debug("Iterating List Object");
		for(ValidateCentreCSVDto centreCSVData :centreCSVDataList)
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
			String centreId=centreCSVData.getCentreId().trim(); 
			String centreName=centreCSVData.getCentreName().trim();
			String centrePOCContactName=centreCSVData.getCentrePOCContactname().trim();
			String centreAddress=centreCSVData.getCentreAddress().trim();
			String district=centreCSVData.getDistrict().trim();
			String state=centreCSVData.getState().trim();
			String trainingPartnerId=centreCSVData.getTrainingPartnerId().trim();
		
			/*
			 * Checking for error in centreId column 
			 */
			LOGGER.debug("Checking Validations of centreId");
			if(!ValidationUtils.numbersCheck(centreId) ||  centreId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centerId' column ";
			}

			/*
			 * Checking for error in centreName column 
			 */
			LOGGER.debug("Checking Validations of centreName");
			if(ValidationUtils.numbersCheck(centreName) || centreName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centreName' column ";
			}
			
			/*
			 * Checking for error in centrePOCContactName column 
			 */
			
			LOGGER.debug("Checking Validations of centrePOCContactName");
			if(ValidationUtils.numbersCheck(centrePOCContactName) || centrePOCContactName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centrePOCContactName' column ";
			}
			
			/*
			 * Checking for error in district column 
			 */
			
			LOGGER.debug("Checking Validations of district");
			if(!ValidationUtils.lettersCheck(district) || district.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'district' column ";
			}

			/*
			 * Checking for error in state column 
			 */
			
			LOGGER.debug("Checking Validations of state");
			if(!ValidationUtils.lettersCheck(state) || state.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'state' column ";
			}
			
			/*
			 * Checking for error in trainingPartnerId column 
			 */
			
			LOGGER.debug("Checking Validations of trainingPartnerId");
			if(trainingPartnerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerId' column ";
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
				centreName=centreName.toLowerCase();
				centrePOCContactName=centrePOCContactName.toLowerCase();
				centreAddress=centreAddress.toLowerCase();
				district=district.toLowerCase();
				state=state.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				
				/*
				  * Inserting row wise data in HashMap
				  */
				LOGGER.debug("Inserting values into HashMap Object");
				record.put("centreId",centreId);
				record.put("centreName",centreName);
				record.put("centrePOCContactName",centrePOCContactName);
				record.put("centreAddress",centreAddress);
				record.put("district",district);
				record.put("state",state);
				record.put("trainingPartnerId",trainingPartnerId);
				
				LOGGER.debug("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
			}
		}
	
		if(errorExist==1)
			{
				LOGGER.debug("Closing CSV reader");
				centreCSVReader.close();
				LOGGER.debug("Successfully closed");
				
				LOGGER.debug("Creating File object");
				File deleteUploadedFile = new File(centreCSVFileName);
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
			centreCSVReader.close();
			LOGGER.debug("Successfully closed");
			
			LOGGER.debug("Creating File object");
			File deleteUploadedFile = new File(centreCSVFileName);
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
				
				LOGGER.debug("Iterating ArrayList object");
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				LOGGER.debug("Making a Request to Dao to get data");	
				int status=dataImportCentreDao.dataImportCentreForeignKeyConstraintCheck(getRecord);
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
	        	
				LOGGER.error("ERROR: Encountered an Exception - ",e);
	   			
				LOGGER.debug("Closing CSV reader");
	   			centreCSVReader.close();
	   			LOGGER.debug("Successfully closed");
				
	   			LOGGER.debug("Creating File object");
				File deleteUploadedFile = new File(centreCSVFileName);
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
					LOGGER.debug("Making a Request to Dao to get data");
				int status=dataImportCentreDao.dataImportCentrePrimaryKeyConstraintCheck(getRecord);
				LOGGER.debug("Response received from Dao");
				
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					LOGGER.debug("Record Doesn't exist in Database");
					LOGGER.debug("Inserting data into Database");
					LOGGER.debug("Making a Request to Dao to get data");
					int insertDataStatus=dataImportCentreDao.insertDataInCentre(getRecord);
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
					int updateDataStatus=dataImportCentreDao.updateDataInCentre(getRecord);
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
				centreCSVReader.close();
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
					File deleteUploadedFile = new File(centreCSVFileName);
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
					File deleteUploadedFile = new File(centreCSVFileName);
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
					centreCSVReader.close();
					LOGGER.debug("Successfully closed");
					
					LOGGER.debug("Creating File object");
					File deleteUploadedFile = new File(centreCSVFileName);
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