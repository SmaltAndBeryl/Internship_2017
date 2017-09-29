package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Batch .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Batch sheet
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
import com.skill.India.dao.DataImportBatchDao;
import com.skill.India.dao.DataImportCSVUploadTableDao;
import com.skill.India.dto.ValidateBatchCSVDto;

@Service
public class ValidateBatchCSVService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateBatchCSVService.class);
		
	@Autowired
	private DataImportBatchDao dataImportBatchDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao; 
	
	public String validateBatchCSV(String BatchCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In ValidateBatchCSVService - validateBatchCSV");
		LOGGER.info("Parameters Received from Controller are - 'BatchCSVFileName': "+BatchCSVFileName+" 'type': "+type+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
		
		
		CSVReader BatchCSVReader=null;
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
		
		LOGGER.info("Setting type of object to ValidateBatchCSVDto");
		strategy.setType(ValidateBatchCSVDto.class);
		
		String [] BatchCSVColumns=new String[]{"batchId","batchName","batchType",
					"trainingPartnerId","centreId","trainerId","totalCandidatesInBatch","batchMode","batchStartDate","batchEndDate","jobRole","jobRoleCode","maximumMarksTheory","maximumMarksPractical","level","resultApproved","resultApprovedOnDate","totalPass","totalFail","totalNotAppeared","totalCertified","batchAssignmentDate","assessmentDate","agencyId","assessorId"};
		
		LOGGER.info("Setting ColumnMapping of object");
		strategy.setColumnMapping(BatchCSVColumns);
		
		//String BatchCSVFileName = "D:\\EclipseWorkspace\\Batch.csv";
		
		LOGGER.info("Creating CSVReader object ");
		BatchCSVReader=new CSVReader(new FileReader(BatchCSVFileName),',','"',2);
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating CsvToBean object ");
		CsvToBean<ValidateBatchCSVDto> BatchCSVToBean=new CsvToBean<ValidateBatchCSVDto>();
		LOGGER.info("Successfully created and initialized");
		
		LOGGER.info("Creating List object of type ValidateBatchCSVDto");
		List<ValidateBatchCSVDto> BatchCSVDataList= BatchCSVToBean.parse(strategy,BatchCSVReader);
		LOGGER.info("Successfully created and initialized");
		
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		
		LOGGER.info("Iterating List Object");
		for(ValidateBatchCSVDto BatchCSVData :BatchCSVDataList)
		{
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			
			LOGGER.info("Creating HashMap object");
			Map<String ,Object> record=new HashMap<String, Object>();
			LOGGER.info("Successfully created");
			
			recordCount++;
			int errorStatus=0;
			
			LOGGER.info("Fetching data from each row");		
			String errorString="";
			
			String batchId=BatchCSVData.getBatchId().trim();
			String batchName=BatchCSVData.getBatchName().trim();
			String batchType=BatchCSVData.getBatchType().trim();
			String trainingPartnerId=BatchCSVData.getTrainingPartnerId().trim();
			String centreId=BatchCSVData.getCentreId().trim();
			String trainerId=BatchCSVData.getTrainerId().trim();
			String totalCandidatesInBatch=BatchCSVData.getTotalCandidatesInBatch().trim();
			String batchMode=BatchCSVData.getBatchMode().trim();
			String batchStartDate=BatchCSVData.getBatchStartDate().trim();
			String batchEndDate=BatchCSVData.getBatchEndDate().trim();
			String jobRole=BatchCSVData.getJobRole().trim();
			String jobRoleCode=BatchCSVData.getJobRoleCode().trim();
			String maximumMarksTheory=BatchCSVData.getMaximumMarksTheory().trim();
			String maximumMarksPractical=BatchCSVData.getMaximumMarksPractical().trim();
			String level=BatchCSVData.getLevel().trim();
			String resultApproved=BatchCSVData.getResultApproved().trim();
			String resultApprovedOnDate=BatchCSVData.getResultApprovedOnDate().trim();
			String totalPass=BatchCSVData.getTotalPass().trim();
			String totalFail=BatchCSVData.getTotalFail().trim();
			String totalNotAppeared=BatchCSVData.getTotalNotAppeared().trim();
			String totalCertified=BatchCSVData.getTotalCertified().trim();
			String batchAssignmentDate=BatchCSVData.getBatchAssignmentDate().trim();
			String assessmentDate=BatchCSVData.getAssessmentDate().trim();
			String agencyId=BatchCSVData.getAgencyId().trim();
			String assessorId=BatchCSVData.getAssessorId().trim();
			
			
			/*
			 * Checking for error in batchId column
			 */
			
			LOGGER.info("Checking Validations of batchId");
			if(!ValidationUtils.numbersCheck(batchId) || batchId.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchId' column .";
			}
			
			/*
			 * Checking for error in batchName column
			 */
			
			LOGGER.info("Checking Validations of batchName");
			if(batchName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+"Error in 'batchName' column .";
			} 
			
			/*
			 * Checking for error in batchType column
			 */
			
			LOGGER.info("Checking Validations of batchType");
			if(ValidationUtils.numbersCheck(batchType) || batchName.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchType' column .";
			}
			
			/*
			 * Checking for error in trainingPartnerId column
			 */
			
			LOGGER.info("Checking Validations of trainingPartnerId");
			if(trainingPartnerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainingPartnerId' column .";
			}
			
			/*
			 * Checking for error in centreId column
			 */
			
			LOGGER.info("Checking Validations of centreId");
			if(!ValidationUtils.numbersCheck(centreId) || centreId.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'centreId' column .";
			}
			
			/*
			 * Checking for error in trainerId column
			 */
			
			LOGGER.info("Checking Validations of trainerId");
			if(!(ValidationUtils.numbersCheck(trainerId) || trainerId.equals("")))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainerId' column .";
			}
			
			/*
			 * Checking for error in totalCandidatesInBatch column
			 */
			
			LOGGER.info("Checking Validations of totalCandidatesInBatch");
			if(!ValidationUtils.numbersCheck(totalCandidatesInBatch) || totalCandidatesInBatch.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'totalCandidatesInBatch' column .";
			}
			
			/*
			 * Checking for error in batchMode column
			 */
			
			LOGGER.info("Checking Validations of batchMode");
			if(ValidationUtils.numbersCheck(batchMode) || batchMode.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchMode' column .";
			}
			
			/*
			 * Checking for error in batchStartDate column
			 */
			
			LOGGER.info("Checking Validations of batchStartDate");
			if(!ValidationUtils.dateFormatCheck(batchStartDate) || batchStartDate.equals(""))
			{
				errorStatus=1;
				System.out.println(batchStartDate);
				errorString=errorString + "Error in 'batchStartDate' column .";
			}
			
			/*
			 * Checking for error in batchEndDate column
			 */
			
			LOGGER.info("Checking Validations of batchEndDate");
			if(!ValidationUtils.dateFormatCheck(batchEndDate) || batchEndDate.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchEndDate' column .";
			}
			
			/*
			 * Checking for error in jobRole column
			 */
			
			LOGGER.info("Checking Validations of jobRole");
			if(ValidationUtils.numbersCheck(jobRole) || jobRole.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'jobRole' column .";
			}
			/*
			 * Checking for error in jobRoleCode column
			 */
			
			LOGGER.info("Checking Validations of jobRoleCode (No validations )");

			/*
			 * Checking for error in maximumMarksTheory column
			 */
			
			LOGGER.info("Checking Validations of maximumMarksTheory");
			if(!(ValidationUtils.numbersWithDecimalCheck(maximumMarksTheory) || maximumMarksTheory.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'maximunMarksTheory' column .";
			}
			
			/*
			 * Checking for error in maximumMarksPractical column
			 */
			
			LOGGER.info("Checking Validations of maximumMarksPractical");
			if(!(ValidationUtils.numbersWithDecimalCheck(maximumMarksPractical) || maximumMarksPractical.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'maximumMarksPractical' column .";
			}
			
			/*
			 * Checking for error in level column
			 */
			
			LOGGER.info("Checking Validations of level");
			if(!(ValidationUtils.numbersCheck(level) || level.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'level' column .";
			}
			
			/*
			 * Checking for error in resultApproved column
			 */
			
			LOGGER.info("Checking Validations of resultApproved");
			if(!(ValidationUtils.lettersCheck(resultApproved) || resultApproved.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'resultApproved' column .";
			}
			
			/*
			 * Checking for error in resultApprovedOnDate column
			 */
			
			LOGGER.info("Checking Validations of resultApprovedOnDate");
			if(!(ValidationUtils.dateFormatCheck(resultApprovedOnDate) || resultApprovedOnDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'resultApprovedOndate' column .";
			}
			
			/*
			 * Checking for error in totalPass column
			 */
			
			LOGGER.info("Checking Validations of totalPass");
			if(!(ValidationUtils.numbersCheck(totalPass) || totalPass.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalPass' column .";
			}
			
			/*
			 * Checking for error in totalFail column
			 */
			
			LOGGER.info("Checking Validations of totalFail");
			if(!(ValidationUtils.numbersCheck(totalFail) || totalFail.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalFail' column .";
			}
			
			/*
			 * Checking for error in totalNotAppeared column
			 */
			
			LOGGER.info("Checking Validations of totalNotAppeared");
			if(!(ValidationUtils.numbersCheck(totalNotAppeared) || totalNotAppeared.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalNotAppeared' column .";
			}
			
			/*
			 * Checking for error in totalCertified column
			 */
			
			LOGGER.info("Checking Validations of totalCertified");
			if(!(ValidationUtils.numbersCheck(totalCertified) || totalCertified.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalCertified' column .";
			}
			
			/*
			 * Checking for error in batchAssignmentDate column
			 */
			
			LOGGER.info("Checking Validations of batchAssignmentDate");
			if(!(ValidationUtils.dateFormatCheck(batchAssignmentDate) || batchAssignmentDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchAssignmentDate' column .";
			}
			
			/*
			 * Checking for error in assessmentDate column
			 */
			
			LOGGER.info("Checking Validations of assessmentDate");
			if(!ValidationUtils.dateFormatCheck(assessmentDate) || assessmentDate.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'assessmentDate' column .";
			}
			
			/*
			 * Checking for error in agencyId column
			 */
			
			LOGGER.info("Checking Validations of agencyId");
			if(!(ValidationUtils.numbersCheck(agencyId) || agencyId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyId' column .";
			}
			
			/*
			 * Checking for error in assessorId column
			 */
			
			LOGGER.info("Checking Validations of assessorId");
			if(!(ValidationUtils.numbersCheck(assessorId) || assessorId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'assessorId' column .";
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
				 batchName=batchName.toLowerCase();
				batchType=batchType.toLowerCase();
				batchMode=batchMode.toLowerCase();
				jobRole=jobRole.toLowerCase();
				jobRoleCode=jobRoleCode.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				
				/*
				 * Setting value of empty fields 
				 */
				LOGGER.info("Setting blank fields to null");
				if(trainerId.equals(""))
				{
					trainerId=null;
				}
				if(jobRoleCode.equals(""))
				{
					jobRoleCode=null;
				}
				if(level.equals(""))
				{
					level=null;
				}
				if(maximumMarksTheory.equals(""))
				{
					maximumMarksTheory=null;
				}
				if(maximumMarksPractical.equals(""))
				{
					maximumMarksPractical=null;
				}
				if(resultApproved.equals(""))
				{
					resultApproved=null;
				}
				if(resultApprovedOnDate.equals(""))
				{
					resultApprovedOnDate=null;
				}
				else
				{
					resultApprovedOnDate=ValidationUtils.convertUtilToSqlDate(resultApprovedOnDate);
				}
				if(totalPass.equals(""))
				{
					totalPass=null;
				}
				if(totalFail.equals(""))
				{
					totalFail=null;
				}
				if(totalNotAppeared.equals(""))
				{
					totalNotAppeared=null;
				}
				if(totalCertified.equals(""))
				{
					totalCertified=null;
				}
				if(batchAssignmentDate.equals(""))
				{
					batchAssignmentDate=null;
				}
				else
				{
					batchAssignmentDate=ValidationUtils.convertUtilToSqlDate(batchAssignmentDate);
				}
				if(agencyId.equals(""))
				{
					agencyId=null;
				}
				if(assessorId.equals(""))
				{
					assessorId=null;
				}
				
				/*
				 * setting values in HashMap
				 */
				LOGGER.info("Inserting values into HashMap Object");
				record.put("batchId",batchId);
				record.put("batchName",batchName);
				record.put("batchType",batchType);
				record.put("trainingPartnerId",trainingPartnerId);
				record.put("centreId",centreId);
				record.put("trainerId",trainerId);
				record.put("totalCandidatesInBatch",totalCandidatesInBatch);
				record.put("batchMode",batchMode);
				record.put("batchStartDate",ValidationUtils.convertUtilToSqlDate(batchStartDate));
				record.put("batchEndDate",ValidationUtils.convertUtilToSqlDate(batchEndDate));
				record.put("jobRole",jobRole);
				record.put("jobRoleCode",jobRoleCode);
				record.put("maximumMarksTheory",maximumMarksTheory);
				record.put("maximumMarksPractical",maximumMarksPractical);
				record.put("level",level);
				record.put("resultApproved",resultApproved);
				record.put("resultApprovedOnDate",resultApprovedOnDate);
				record.put("totalPass",totalPass);
				record.put("totalFail",totalFail);
				record.put("totalNotAppeared",totalNotAppeared);
				record.put("totalCertified",totalCertified);
				record.put("batchAssignmentDate",batchAssignmentDate);
				record.put("assessmentDate",ValidationUtils.convertUtilToSqlDate(assessmentDate));
				record.put("agencyId",agencyId);
				record.put("assessorId",assessorId);
				
				LOGGER.info("Adding HashMap object into ArrayList");
				arrayOfRecords.add(record);
			}
			
		}
		
			if(errorExist==1){
				LOGGER.info("Closing CSV reader");
				BatchCSVReader.close();
				LOGGER.info("Successfully closed");
				
				LOGGER.info("Creating File object");
				File deleteUploadedFile = new File(BatchCSVFileName);
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
			BatchCSVReader.close();
			LOGGER.info("Successfully closed");
			
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(BatchCSVFileName);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.info("Successfully deleted");
		    
		    LOGGER.info("returning Error list as String");
//		    e.printStackTrace();
			return "Error parsing Batch CSV File. Kindly try again. ";
		}
		
		
		/*
		 * Checking for foreign key constraint trainerId,centreId,trainerId,assessorId,agencyId
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
				status=dataImportBatchDao.dataImportBatchTrainingPartnerIdCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "trainingPartnerId key mismatch .";
				}
				LOGGER.info("Making a Request to Dao to get data");
				status=dataImportBatchDao.dataImportBatchCentreIdCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
					
					errorStatus=1;
					errorString=errorString+ "centreId key mismatch .";
				}
				
				if(!(getRecord.get("trainerId")==null))
				{
				LOGGER.info("Making a Request to Dao to get data");
				status=dataImportBatchDao.dataImportBatchTrainerIdCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "trainerId key mismatch .";
				}
				}	
				if(!(getRecord.get("agencyId")==null))
				{
					LOGGER.info("Making a Request to Dao to get data");
					status=dataImportBatchDao.dataImportBatchAgencyIdCheck(getRecord);
					LOGGER.info("Response received from Dao");
				
					if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "agencyId key mismatch .";
				}
				}
				if(!(getRecord.get("assessorId")==null))
				{
					LOGGER.info("Making a Request to Dao to get data");
				status=dataImportBatchDao.dataImportBatchAssessorIdCheck(getRecord);
				LOGGER.info("Response received from Dao");
				
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "assessorId key mismatch .";
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
				BatchCSVReader.close();
				LOGGER.info("Successfully closed");
				
				LOGGER.info("Creating File object");
				File deleteUploadedFile = new File(BatchCSVFileName);
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
			
//			e.printStackTrace();
			LOGGER.info("Creating File object");
			File deleteUploadedFile = new File(BatchCSVFileName);
			LOGGER.info("Successfully created and initialized");
			
			LOGGER.info("deleting Saved file from system");
		    deleteUploadedFile.delete();
		    LOGGER.info("Successfully deleted");
		    
		    LOGGER.info("returning Error list as String");
			return "Error checking Foreign key constraint . Kindly try again .";
			
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
			    status=dataImportBatchDao.dataImportBatchPrimaryKeyConstraintCheck(getRecord);
			    LOGGER.info("Response received from Dao");
				
			    if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					LOGGER.info("Record Doesn't exist in Database");
					LOGGER.info("Inserting data into Database");
					LOGGER.info("Making a Request to Dao to get data");
					int insertDataStatus=dataImportBatchDao.insertDataInBatch(getRecord);
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
					int updateDataStatus=dataImportBatchDao.updateDataInBatch(getRecord);
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
				BatchCSVReader.close();
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
				File deleteUploadedFile = new File(BatchCSVFileName);
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
					File deleteUploadedFile = new File(BatchCSVFileName);
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
					BatchCSVReader.close();
					LOGGER.info("Successfully closed");
					
					LOGGER.info("Creating File object");
					File deleteUploadedFile = new File(BatchCSVFileName);
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
