package com.skill.India.service;

/*
 * Author 		: Ruchit Jain
 * Description  : For Candidate .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Candidate sheet
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

import com.skill.India.common.ValidationUtils;
import com.skill.India.dao.DataImportCSVUploadTableDao;
import com.skill.India.dao.DataImportCandidateDao;
import com.skill.India.dto.ValidateCandidateCSVDto;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Service 
public class ValidateCandidateCSVService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateCandidateCSVService.class);
		
	@Autowired
	private DataImportCandidateDao dataImportCandidateDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao;
	
	public String validateCandidateCSV(String CandidateCSVFileName,String type,String  userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In ValidateCandidateCSVService - validateCandidateCSV");
		LOGGER.info("Parameters Received from Controller are - 'CandidateCSVFileName': "+CandidateCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': ",fileNameToBeSaved);
		
		CSVReader CandidateCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		
		LOGGER.info("Creating ArrayList object");
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		LOGGER.info("Successfully created");
		
		try{
			LOGGER.info("In TRY block");
			
			LOGGER.info("Creating ColumnPositionMappingStrategy object of type ValidateCandidateCSVDto");
		ColumnPositionMappingStrategy<ValidateCandidateCSVDto> strategy=new ColumnPositionMappingStrategy<ValidateCandidateCSVDto>();
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Setting type of object to ValidateCandidateCSVDto");
		strategy.setType(ValidateCandidateCSVDto.class);
		String [] CandidateCSVColumns=new String[]{"candidateDetailsId","candidateName","enrollmentNumber","gender","dateOfBirth","nameOfFatherOrHusband","aadharNumber","mobileNumber","emailId","educationLevel","traineeAddress","traineePINCode","marksObtainedTheory","marksObtainedPractical","result","certified","placementStatus","dateOfJoining","employmentType","batchId","employerId"};
		
		LOGGER.info("Setting ColumnMapping of object");
		strategy.setColumnMapping(CandidateCSVColumns);
		//String CandidateCSVFileName = "D:\\EclipseWorkspace\\Candidate.csv";
		
		LOGGER.info("Creating CSVReader object ");
		CandidateCSVReader=new CSVReader(new FileReader(CandidateCSVFileName),',','"',2);
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating CsvToBean object ");
		CsvToBean<ValidateCandidateCSVDto> CandidateCSVToBean=new CsvToBean<ValidateCandidateCSVDto>(); 
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating List object of type ValidateCandidateCSVDto");
		List<ValidateCandidateCSVDto> CandidateCSVDataList= CandidateCSVToBean.parse(strategy,CandidateCSVReader);
		LOGGER.info("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		
		LOGGER.info("Iterating List Object");
		for(ValidateCandidateCSVDto CandidateCSVData :CandidateCSVDataList)
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
			String candidateDetailsId=CandidateCSVData.getCandidateDetailsId();
			String candidateName=CandidateCSVData.getCandidateName();
		    String enrollmentNumber=CandidateCSVData.getEnrollmentNumber();
			String gender=CandidateCSVData.getGender();
			String dateOfBirth=CandidateCSVData.getDateOfBirth();
		    String nameOfFatherOrHusband=CandidateCSVData.getNameOfFatherOrHusband();
			String aadharNumber=CandidateCSVData.getAadharNumber();
			String mobileNumber=CandidateCSVData.getMobileNumber();
			String emailId=CandidateCSVData.getEmailId();
			String educationLevel=CandidateCSVData.getEducationLevel();
			String traineeAddress=CandidateCSVData.getTraineeAddress();
			String traineePINCode=CandidateCSVData.getTraineePINCode();
			String marksObtainedTheory=CandidateCSVData.getMarksObtainedTheory();
			String marksObtainedPractical=CandidateCSVData.getMarksObtainedPractical();
			String result=CandidateCSVData.getResult();
			String certified=CandidateCSVData.getCertified();
			String placementStatus=CandidateCSVData.getPlacementStatus();
			String dateOfJoining=CandidateCSVData.getDateOfJoining();
			String employmentType=CandidateCSVData.getEmploymentType();
			String batchId=CandidateCSVData.getBatchId();
			String employerId=CandidateCSVData.getEmployerId();
	
			/*
			 * Checking for error in candidateDetailsId column
			 */
			LOGGER.info("Checking Validations of candidateDetailsId");
			if(!ValidationUtils.numbersCheck(candidateDetailsId) || candidateDetailsId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+"Error in  'candidateDetailsId' column .";
			}
		
			/*
			 * Checking for error in candidateName column
			 */
			LOGGER.info("Checking Validations of candidateName");
			if(ValidationUtils.numbersCheck(candidateName) || candidateName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+"Error in  'candidateName' column .";
			}
			
			/*
			 * Checking for error in enrollmentNumber column
			 */
			LOGGER.info("Checking Validations of enrollmentNumber");
			if(enrollmentNumber.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in  'enrollmentNumber' column .";
			}
			
			
			/*
			 * Checking for error in gender column
			 */
			LOGGER.info("Checking Validations of gender");
			if(!ValidationUtils.lettersCheck(gender) || gender.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in  'gender' column .";
			}
			
			/*
			 * Checking for error in dateOfBirth column
			 */
			LOGGER.info("Checking Validations of dateOfBirth");
			if(!ValidationUtils.dateFormatCheck(dateOfBirth) || dateOfBirth.equals(""))
			{
				errorStatus=1;
				errorString=errorString+"Error in  'dateOfBirth' column .";
			}
		
			/*
			 * Checking for error in nameOfFatherOrHusband column
			 */
			LOGGER.info("Checking Validations of nameOfFatherOrHusband");
			if(ValidationUtils.numbersCheck(nameOfFatherOrHusband) || nameOfFatherOrHusband.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Error in  'nameOfFatherOrHusband' column .";
			}
			
			/*
			 * Checking for error in aadharNumber column
			 */
			LOGGER.info("Checking Validations of aadharNumber");
			if(!(ValidationUtils.numbersCheck(aadharNumber) || aadharNumber.equals("")) )
			{
				errorStatus=1;
				errorString=errorString+ "Error in  'aadharNumber' column .";
			}
		
			/*
			 * Checking for error in mobileNumber column
			 */
			LOGGER.info("Checking Validations of mobileNumber");
			if(!(ValidationUtils.mobileNumberCheck(mobileNumber) || mobileNumber.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'mobileNumber' column .";
			}
		
			/*
			 * Checking for error in emailId column
			 */
			
			LOGGER.info("Checking Validations of emailId");
			if(!(ValidationUtils.emailCheck(emailId) || emailId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'emailId' column .";
			}
				
			/*
			 * Checking for error in traineePINCode column
			 */
			LOGGER.info("Checking Validations of traineePINCode");
			if(!(ValidationUtils.pincodeNumberCheck(traineePINCode) || traineePINCode.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'traineePINCode' column .";
			}
			
			/*
			 * Checking for error in marksObtainedTheory column
			 */
			LOGGER.info("Checking Validations of marksObtainedTheory");
			if(!(ValidationUtils.numbersWithDecimalCheck(marksObtainedTheory) ||marksObtainedTheory.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'marksObtainedTheory' column .";
			}
			
			/*
			 * Checking for error in marksObtainedPractical column
			 */
			LOGGER.info("Checking Validations of marksObtainedPractical");
			if(!(ValidationUtils.numbersWithDecimalCheck(marksObtainedPractical) || marksObtainedPractical.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'marksObtainedPractical' column .";
			}
			
			/*
			 * Checking for error in result column
			 */
			LOGGER.info("Checking Validations of result");
			if(!(ValidationUtils.lettersCheck(result) || result.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'result' column .";
			}
			
			/*
			 * Checking for error in certified column
			 */
			LOGGER.info("Checking Validations of certified");
			if(!(ValidationUtils.lettersCheck(certified) || certified.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'certified' column .";
			}
			
			/*
			 * Checking for error in placementStatus column
			 */
			LOGGER.info("Checking Validations of placementStatus");
			if(!(ValidationUtils.lettersCheck(placementStatus) || placementStatus.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'placementStatus' column .";
			}
			
			/*
			 * Checking for error in dateOfJoining column
			 */
			LOGGER.info("Checking Validations of dateOfJoining");
			if(!(ValidationUtils.dateFormatCheck(dateOfJoining) || dateOfJoining.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'dateOfJoining' column .";
			}
			
			/*
			 * Checking for error in employmentType column
			 */
			LOGGER.info("Checking Validations of employmentType");
			if(!(ValidationUtils.lettersCheck(employmentType) || employmentType.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'employmentType' column .";
			}
			
			/*
			 * Checking for error in batchId column
			 */
			LOGGER.info("Checking Validations of batchId");
			if(!ValidationUtils.numbersCheck(batchId) || batchId.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'batchId' column .";
			}
			
			/*
			 * Checking for error in employerId column
			 */
			LOGGER.info("Checking Validations of employerId");
			if(!(ValidationUtils.numbersCheck(employerId) || employerId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'employerId' column .";
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
				 candidateName=candidateName.toLowerCase();
				 enrollmentNumber=enrollmentNumber.toLowerCase();
				 gender=gender.toLowerCase();
				 nameOfFatherOrHusband=nameOfFatherOrHusband.toLowerCase();
				 emailId=emailId.toLowerCase();
				 educationLevel=educationLevel.toLowerCase();
				 traineeAddress=traineeAddress.toLowerCase();
				 result=result.toLowerCase();
				 certified=certified.toLowerCase();
				 placementStatus=placementStatus.toLowerCase();
				 employmentType=employmentType.toLowerCase();
				 
			 /*
			  * Setting some default values in fields which were not filled by user 
			  */
				 LOGGER.info("Setting blank fields to null");
					
			 if(aadharNumber.equals(""))
			 {
				 aadharNumber=null;
			 }
			 if(mobileNumber.equals(""))
			 {
				 mobileNumber=null;
			 }
			 if(emailId.equals(""))
			 {
				 emailId=null;
			 }
			 if(educationLevel.equals(""))
			 {
				 educationLevel=null;
			 }
			 if(traineeAddress.equals(""))
			 {
				 traineeAddress=null;
			 }
			 if(traineePINCode.equals(""))
			 {
				 traineePINCode=null;
			 }
			 if(marksObtainedTheory.equals(""))
			 {
				 marksObtainedTheory=null;
			 }
			 if(marksObtainedPractical.equals(""))
			 {
				 marksObtainedPractical=null;
			 }
			 if(result.equals(""))
			 {
				 result=null;
			 }
			 if(certified.equals(""))
			 {
				 certified=null;
			 }
			 if(placementStatus.equals(""))
			 {
				 placementStatus=null;
			 }
			 if(dateOfJoining.equals(""))
			 {
				 dateOfJoining=null;
			 }
			 else
			 {
				 dateOfJoining=ValidationUtils.convertUtilToSqlDate(dateOfJoining);
			 }
			 if(employmentType.equals(""))
			 {
				 employmentType=null;
			 }
			 if(employerId.equals(""))
			 {
				 employerId=null;
			 }
			 
			 /*
			  * Inserting row wise data in HashMap
			  */
			 LOGGER.info("Inserting values into HashMap Object");
			 record.put("candidateDetailsId", candidateDetailsId);
			 record.put("candidateName",candidateName);
			 record.put("enrollmentNumber",enrollmentNumber);
			 record.put("gender",gender);
			 record.put("dateOfBirth",ValidationUtils.convertUtilToSqlDate(dateOfBirth));
			 record.put("nameOfFatherOrHusband",nameOfFatherOrHusband);
			 record.put("aadharNumber",aadharNumber);
			 record.put("mobileNumber",mobileNumber);
			 record.put("emailId",emailId);
			 record.put("educationLevel",educationLevel);
			 record.put("traineeAddress",traineeAddress);
			 record.put("traineePINCode",traineePINCode);
			 record.put("marksObtainedTheory",marksObtainedTheory);
			 record.put("marksObtainedPractical",marksObtainedPractical);
			 record.put("result",result);
			 record.put("certified",certified);
			 record.put("placementStatus",placementStatus);
			 record.put("dateOfJoining",dateOfJoining);
			 record.put("employmentType",employmentType);
			 record.put("batchId",batchId);
			 record.put("employerId",employerId);
			 
			 LOGGER.info("Adding HashMap object into ArrayList");
			 arrayOfRecords.add(record);
			}
			
		}
			if(errorExist==1)
			{
				LOGGER.info("Closing CSV reader");
				CandidateCSVReader.close();
				LOGGER.info("Successfully closed");
				
				LOGGER.info("Creating File object");
				File deleteUploadedFile = new File(CandidateCSVFileName);
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
			CandidateCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(CandidateCSVFileName);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.info("Successfully deleted");
		    
		    LOGGER.info("returning Error list as String");
//			e.printStackTrace();
			return "Error parsing Batch CSV File. Kindly try again. ";
			
		}
		
		/*
		 * Checking for foreign key constraint of batchId & employerId
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
			status=dataImportCandidateDao.dataImportCandidateBatchIdCheck(getRecord);
			LOGGER.info("Response received from Dao");
			
			if(status==0 || status==2)
			{
				errorStatus=1;
				errorString=errorString+ "batchId key mismatch .";
			}
			
			if(!(getRecord.get("employerId")==null))
			{
				LOGGER.info("Making a Request to Dao to get data");
				status=dataImportCandidateDao.dataImportCandidateEmployerIdCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "employerId key mismatch .";
				}
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
			CandidateCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(CandidateCSVFileName);
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
		File deleteUploadedFile = new File(CandidateCSVFileName);
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("deleting Saved file from system");
	    deleteUploadedFile.delete();
	    LOGGER.info("Successfully deleted");
	    
	    LOGGER.info("returning Error list as String");
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
					LOGGER.info("Making a Request to Dao to get data");
					status=dataImportCandidateDao.dataImportCandidatePrimaryKeyConstraintCheck(getRecord);
					LOGGER.info("Response received from Dao");
				
					if(status==0)
					{
						/*
						 * If primary key doesn't exists in DB then run insert query
						 */
						LOGGER.info("Record Doesn't exist in Database");
						LOGGER.info("Inserting data into Database");
						LOGGER.info("Making a Request to Dao to get data");
						int insertDataStatus=dataImportCandidateDao.insertDataInCandidate(getRecord);
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
					int updateDataStatus=dataImportCandidateDao.updateDataInCandidate(getRecord);
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
				CandidateCSVReader.close();
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
							File deleteUploadedFile = new File(CandidateCSVFileName);
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
							File deleteUploadedFile = new File(CandidateCSVFileName);
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
					CandidateCSVReader.close();
					LOGGER.info("Successfully closed");
					
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(CandidateCSVFileName);
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
