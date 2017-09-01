package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Assessor .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Assessor sheet
 * 				 2) Validates the data inserted in it by the user
 * 				 3) Checks for foreign key,primary key constraint	
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
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
import com.skill.India.dao.DataImportAssessorDao;
import com.skill.India.dao.DataImportCSVUploadTableDao;
import com.skill.India.dto.ValidateAssessorCSVDto;
import com.skill.India.dto.ValidateCentreCSVDto;

@Service
public class ValidateAssessorCSVService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateAssessorCSVService.class);
		
	@Autowired
	private DataImportAssessorDao dataImportAssessorDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao;
	
	public String validateAssessorCSV(String assessorCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In ValidateAssessorCSVService - validateAssessorCSV");
		LOGGER.info("Parameters Received from Controller are - 'assessorCSVFileName': "+assessorCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
		
		CSVReader assessorCSVReader=null;
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
			
			LOGGER.info("Setting type of object to ValidateAssessorCSVDto");
			strategy.setType(ValidateAssessorCSVDto.class);
		String [] assessorCSVColumns=new String[]{"assessorId","assessorName","district","state","agencyId"};
		
		LOGGER.info("Setting ColumnMapping of object");
		strategy.setColumnMapping(assessorCSVColumns);
		//String assessorCSVFileName = "D:\\EclipseWorkspace\\Assessor.csv";
		
		LOGGER.info("Creating CSVReader object ");
		assessorCSVReader=new CSVReader(new FileReader(assessorCSVFileName),',','"',2);
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating CsvToBean object ");
		CsvToBean<ValidateAssessorCSVDto> assessorCSVToBean=new CsvToBean<ValidateAssessorCSVDto>();
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating List object of type ValidateAssessorCSVDto");
		List<ValidateAssessorCSVDto> assessorCSVDataList= assessorCSVToBean.parse(strategy,assessorCSVReader);
		LOGGER.info("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		
		LOGGER.info("Iterating List Object");
		for(ValidateAssessorCSVDto assessorCSVData :assessorCSVDataList)
		{
			/*
			 * Map to store data of each row of csv read and then added to arraylist
			 */
			LOGGER.info("Creating HashMap object");
			Map<String ,Object> record=new HashMap<String, Object>();
			LOGGER.info("Successfully created");
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			LOGGER.info("Fetching data from each row");
			String assessorId=assessorCSVData.getAssessorId().trim();
			String assessorName=assessorCSVData.getAssessorName().trim();
			String agencyId=assessorCSVData.getAgencyId().trim();
			String district=assessorCSVData.getDistrict().trim();
			String state=assessorCSVData.getState().trim();
			
			/*
			 * Checking for error in assessorId column 
			 */
			
			LOGGER.info("Checking Validations of assessorId");
			if(!ValidationUtils.numbersCheck(assessorId) || assessorId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'assessorId' column  ";
			}
			
			/*
			 * Checking for error in assessorName column 
			 */
			
			LOGGER.info("Checking Validations of assessorName");
			if(ValidationUtils.numbersCheck(assessorName) || assessorName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'assessorName' column  ";
			}
			
			/*
			 * Checking for error in district column 
			 */
			
			LOGGER.info("Checking Validations of district");
			if(!ValidationUtils.lettersCheck(district) || district.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'district' column  ";
			}
			
			/*
			 * Checking for error in state column 
			 */
			
			LOGGER.info("Checking Validations of state");
			if(!ValidationUtils.lettersCheck(state) || state.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'state' column  ";
			}
			/*
			 * Checking for error in agencyId column 
			 */
			
			LOGGER.info("Checking Validations of agencyId");
			if(!ValidationUtils.numbersCheck(agencyId) || agencyId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'agencyId' column  ";
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
				
				LOGGER.info("Converting all values to lower Case");
				assessorName=assessorName.toLowerCase();
				district=district.toLowerCase();
				state=state.toLowerCase();
				
				LOGGER.info("Inserting values into HashMap Object");
				record.put("assessorId",assessorId);
				record.put("assessorName",assessorName);
				record.put("district",district);
				record.put("state",state);
				record.put("agencyId",agencyId);
				
				LOGGER.info("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
				
			}			
		}
		
		if(errorExist==1)
		{
			LOGGER.info("Closing CSV reader");
			assessorCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(assessorCSVFileName);
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
			assessorCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(assessorCSVFileName);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.info("Successfully deleted");
		    
		    LOGGER.info("returning Error list as String");
//			e.printStackTrace();
			return "Error Occurred while Uploading the File";		
		}
			
		/*
		 * checking for foreign key constraint on agencyId in Assessment Agency
		 */
		
		int recordCount=0;
		int status=0;
		int errorExist=0;
		String errorListAllRecords="";

	try{
		LOGGER.info("In TRY block");
		
		LOGGER.info("Iterating Array List object"); 
		for(Map<String, Object> getRecord:arrayOfRecords)
		{	
			String errorString="";
			int errorStatus=0;
			recordCount++;
			
			LOGGER.info("Checking if record details already exists in database");
			LOGGER.info("Making a Request to Dao to get data");
			status=dataImportAssessorDao.dataImportAssessorForeignKeyConstraintCheck(getRecord);
			LOGGER.info("Response received from Dao");
			
			if(status==0 || status==2)
			{
				errorStatus=1;
				errorString=errorString+ "agencyId key mismatch .";
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
			LOGGER.info("Closing CSV reader");
			assessorCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(assessorCSVFileName);
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
//		e.printStackTrace();
		
		LOGGER.info("Creating File object");
		File deleteUploadedFile = new File(assessorCSVFileName);
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("deleting Saved file from system");
		LOGGER.info("Successfully deleted");
	    
		LOGGER.info("returning Error list as String");
	    deleteUploadedFile.delete();
		return "Error checking Foreign key constraint . Kindly try again .";
		
	}
	

		/*
		 * Checking primary key Constraint and performing respective actions 
		 */
			
			  try{				
				  LOGGER.info("In TRY block");
				  
				  LOGGER.info("Iterating ArrayList object");
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
					LOGGER.info("Checking for foreign key constraint");
					LOGGER.info("Making a Request to Dao to get data");
					status=dataImportAssessorDao.dataImportAssessorPrimaryKeyConstraintCheck(getRecord);
					LOGGER.info("Response received from Dao");
					
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
						LOGGER.info("Record Doesn't exist in Database");
						LOGGER.info("Inserting data into Database");
						LOGGER.info("Making a Request to Dao to get data");
						int insertDataStatus=dataImportAssessorDao.insertDataInAssessor(getRecord);
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
					int updateDataStatus=dataImportAssessorDao.updateDataInAssessor(getRecord);
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
				assessorCSVReader.close();
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
				status=dataImportCSVUploadTableDao.dataImportCSVUploadForeignKeyConstraintCheck(uploadedFileInfo);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(assessorCSVFileName);
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
					File deleteUploadedFile = new File(assessorCSVFileName);
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
					assessorCSVReader.close();
					LOGGER.info("Successfully closed");
					
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(assessorCSVFileName);
					LOGGER.info("Successfully created and initialized");;
					
					LOGGER.info("deleting Saved file from system");
				    deleteUploadedFile.delete();
				    LOGGER.info("Successfully deleted");
				    
				    LOGGER.info("returning Error list as String");
//				    e.printStackTrace();
					return "Error Inserting or Updating data in Assessor table .Kindly try again .";
				}		

	}
}