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

	@Autowired
	private DataImportBatchDao dataImportBatchDao;
	
	@Autowired
	private DataImportCSVUploadTableDao dataImportCSVUploadTableDao; 
	
	public String validateBatchCSV(String BatchCSVFileName,String type,String userId,String fileNameToBeSaved) throws IOException{
		CSVReader BatchCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateBatchCSVDto.class);
		String [] BatchCSVColumns=new String[]{"batchId","batchName","batchType",
					"trainingPartnerId","centreId","trainerId","totalCandidatesInBatch","batchMode","batchStartDate","batchEndDate","jobRole","jobRoleCode","maximumMarksTheory","maximumMarksPractical","level","resultApproved","resultApprovedOnDate","totalPass","totalFail","totalNotAppeared","totalCertified","batchAssignmentDate","assessmentDate","agencyId","assessorId"};
		strategy.setColumnMapping(BatchCSVColumns);
		//String BatchCSVFileName = "D:\\EclipseWorkspace\\Batch.csv";
		BatchCSVReader=new CSVReader(new FileReader(BatchCSVFileName),',','"',2);
		CsvToBean<ValidateBatchCSVDto> BatchCSVToBean=new CsvToBean<ValidateBatchCSVDto>();
		List<ValidateBatchCSVDto> BatchCSVDataList= BatchCSVToBean.parse(strategy,BatchCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateBatchCSVDto BatchCSVData :BatchCSVDataList)
		{
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			Map<String ,Object> record=new HashMap<String, Object>();
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String batchId=BatchCSVData.getBatchId();
			String batchName=BatchCSVData.getBatchName();
			String batchType=BatchCSVData.getBatchType();
			String trainingPartnerId=BatchCSVData.getTrainingPartnerId();
			String centreId=BatchCSVData.getCentreId();
			String trainerId=BatchCSVData.getTrainerId();
			String totalCandidatesInBatch=BatchCSVData.getTotalCandidatesInBatch();
			String batchMode=BatchCSVData.getBatchMode();
			String batchStartDate=BatchCSVData.getBatchStartDate();
			String batchEndDate=BatchCSVData.getBatchEndDate();
			String jobRole=BatchCSVData.getJobRole();
			String jobRoleCode=BatchCSVData.getJobRoleCode();
			String maximumMarksTheory=BatchCSVData.getMaximumMarksTheory();
			String maximumMarksPractical=BatchCSVData.getMaximumMarksPractical();
			String level=BatchCSVData.getLevel();
			String resultApproved=BatchCSVData.getResultApproved();
			String resultApprovedOnDate=BatchCSVData.getResultApprovedOnDate();
			String totalPass=BatchCSVData.getTotalPass();
			String totalFail=BatchCSVData.getTotalFail();
			String totalNotAppeared=BatchCSVData.getTotalNotAppeared();
			String totalCertified=BatchCSVData.getTotalCertified();
			String batchAssignmentDate=BatchCSVData.getBatchAssignmentDate();
			String assessmentDate=BatchCSVData.getAssessmentDate();
			String agencyId=BatchCSVData.getAgencyId();
			String assessorId=BatchCSVData.getAssessorId();
			
			
			/*
			 * Checking for error in batchId column
			 */
			
			if(!ValidationUtils.numbersCheck(batchId) || batchId.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchId' column .";
			}
			
			/*
			 * Checking for error in batchName column
			 */
			
			if(batchName.equals(""))
			{
				errorStatus=1;
				errorString=errorString+"Error in 'batchName' column .";
			} 
			
			
			/*
			 * Checking for error in batchType column
			 */
			
			if(ValidationUtils.numbersCheck(batchType) || batchName.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchType' column .";
			}
			
	
			/*
			 * Checking for error in trainingPartnerId column
			 */
			
			
			if(trainingPartnerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainingPartnerId' column .";
			}
			
			/*
			 * Checking for error in centreId column
			 */
			
			if(!ValidationUtils.numbersCheck(centreId) || centreId.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'centreId' column .";
			}
			
			/*
			 * Checking for error in trainerId column
			 */
			
			if(!ValidationUtils.numbersCheck(trainerId) || trainerId.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainerId' column .";
			}
			
			/*
			 * Checking for error in totalCandidatesInBatch column
			 */
			
			if(!ValidationUtils.numbersCheck(totalCandidatesInBatch) || totalCandidatesInBatch.equals(""))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'totalCandidatesInBatch' column .";
			}
			
			/*
			 * Checking for error in batchMode column
			 */
			
			if(ValidationUtils.numbersCheck(batchMode) || batchMode.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchMode' column .";
			}
			
			/*
			 * Checking for error in batchStartDate column
			 */
			
			if(!ValidationUtils.dateFormatCheck(batchStartDate) || batchStartDate.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchStartDate' column .";
			}
			
			/*
			 * Checking for error in batchEndDate column
			 */
			
			if(!ValidationUtils.dateFormatCheck(batchEndDate) || batchEndDate.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchEndDate' column .";
			}
			
			/*
			 * Checking for error in jobRole column
			 */
			
			if(ValidationUtils.numbersCheck(jobRole) || jobRole.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'jobRole' column .";
			}
			/*
			 * Checking for error in jobRoleCode column
			 */
			
			if(jobRoleCode.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'jobRoleCode' column .";
			}
			
			/*
			 * Checking for error in maximumMarksTheory column
			 */
			
			if(!(ValidationUtils.numbersWithDecimalCheck(maximumMarksTheory) || maximumMarksTheory.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'maximunMarksTheory' column .";
			}
			
			/*
			 * Checking for error in maximumMarksPractical column
			 */
			
			if(!(ValidationUtils.numbersWithDecimalCheck(maximumMarksPractical) || maximumMarksPractical.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'maximumMarksPractical' column .";
			}
			
			/*
			 * Checking for error in level column
			 */
			
			if(!ValidationUtils.numbersCheck(level))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'level' column .";
			}
			
			/*
			 * Checking for error in resultApproved column
			 */
			
			if(!(ValidationUtils.lettersCheck(resultApproved) || resultApproved.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'resultApproved' column .";
			}
			
			/*
			 * Checking for error in resultApprovedOnDate column
			 */
			
			if(!(ValidationUtils.dateFormatCheck(resultApprovedOnDate) || resultApprovedOnDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'resultApprovedOndate' column .";
			}
			
			/*
			 * Checking for error in totalPass column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalPass) || totalPass.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalPass' column .";
			}
			
			/*
			 * Checking for error in totalFail column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalFail) || totalFail.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalFail' column .";
			}
			
			/*
			 * Checking for error in totalNotAppeared column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalNotAppeared) || totalNotAppeared.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalNotAppeared' column .";
			}
			
			/*
			 * Checking for error in totalCertified column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalCertified) || totalCertified.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalCertified' column .";
			}
			
			/*
			 * Checking for error in batchAssignmentDate column
			 */
			
			if(!(ValidationUtils.dateFormatCheck(batchAssignmentDate) || batchAssignmentDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchAssignmentDate' column .";
			}
			
			/*
			 * Checking for error in assessmentDate column
			 */
			
			if(!ValidationUtils.dateFormatCheck(assessmentDate) || assessmentDate.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'assessmentDate' column .";
			}
			
			/*
			 * Checking for error in agencyId column
			 */
			
			if(!(ValidationUtils.numbersCheck(agencyId) || agencyId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyId' column .";
			}
			
			/*
			 * Checking for error in assessorId column
			 */
			
			if(!(ValidationUtils.numbersCheck(assessorId) || assessorId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'assessorId' column .";
			}
			
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;	
			}
			else 
			{
				/*
				 * Keeping database consistent by inserting only lowercase values in it
				 */
				
				batchName=batchName.toLowerCase();
				batchType=batchType.toLowerCase();
				batchMode=batchMode.toLowerCase();
				jobRole=jobRole.toLowerCase();
				jobRoleCode=jobRoleCode.toLowerCase();
				trainingPartnerId=trainingPartnerId.toLowerCase();
				
				/*
				 * Setting value of empty fields 
				 */
					
				if(maximumMarksTheory.equals(""))
				{
					maximumMarksTheory="0";
				}
				if(maximumMarksPractical.equals(""))
				{
					maximumMarksPractical="0";
				}
				if(resultApproved.equals(""))
				{
					resultApproved="unknown";
				}
				if(resultApprovedOnDate.equals(""))
				{
					resultApprovedOnDate="1900-01-00";
				}
				if(totalPass.equals(""))
				{
					totalPass="0";
				}
				if(totalFail.equals(""))
				{
					totalFail="0";
				}
				if(totalNotAppeared.equals(""))
				{
					totalNotAppeared="0";
				}
				if(totalCertified.equals(""))
				{
					totalCertified="0";
				}
				if(batchAssignmentDate.equals(""))
				{
					batchAssignmentDate="1900-01-00";
				}
				if(agencyId.equals(""))
				{
					agencyId="0";
				}
				if(assessorId.equals(""))
				{
					assessorId="0";
				}
				
				/*
				 * setting values in HashMap
				 */
				
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
				record.put("resultApprovedOnDate",ValidationUtils.convertUtilToSqlDate(resultApprovedOnDate));
				record.put("totalPass",totalPass);
				record.put("totalFail",totalFail);
				record.put("totalNotAppeared",totalNotAppeared);
				record.put("totalCertified",totalCertified);
				record.put("batchAssignmentDate",ValidationUtils.convertUtilToSqlDate(batchAssignmentDate));
				record.put("assessmentDate",ValidationUtils.convertUtilToSqlDate(assessmentDate));
				record.put("agencyId",agencyId);
				record.put("assessorId",assessorId);
				
				arrayOfRecords.add(record);
			}
			
		}
		
			if(errorExist==1){
				BatchCSVReader.close();
				File deleteUploadedFile = new File(BatchCSVFileName);
			    deleteUploadedFile.delete();
				return errorListAllRecords;	
			}
			
		
		}
		catch(Exception e)
		{
			BatchCSVReader.close();
			File deleteUploadedFile = new File(BatchCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
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
			for(Map<String, Object> getRecord:arrayOfRecords)
			{	
				String errorString="";
				int errorStatus=0;
				recordCount++;
				
				status=dataImportBatchDao.dataImportBatchTrainingPartnerIdCheck(getRecord);
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "trainingPartnerId key mismatch .";
				}
				
				status=dataImportBatchDao.dataImportBatchCentreIdCheck(getRecord);
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "centreId key mismatch .";
				}
				
				status=dataImportBatchDao.dataImportBatchTrainerIdCheck(getRecord);
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "trainerId key mismatch .";
				}
					
				if(!getRecord.get("agencyId").equals("0"))
				{
					status=dataImportBatchDao.dataImportBatchAgencyIdCheck(getRecord);
				if(status==0 || status==2)
				{
					errorStatus=1;
					errorString=errorString+ "agencyId key mismatch .";
				}
				}
				if(!getRecord.get("assessorId").equals("0"))
				{
				status=dataImportBatchDao.dataImportBatchAssessorIdCheck(getRecord);
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
				BatchCSVReader.close();
				File deleteUploadedFile = new File(BatchCSVFileName);
			    deleteUploadedFile.delete();
				return errorListAllRecords;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			File deleteUploadedFile = new File(BatchCSVFileName);
		    deleteUploadedFile.delete();
			return "Error checking Foreign key constraint . Kindly try again .";
			
		}
		
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */
		
			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{			
			    status=dataImportBatchDao.dataImportBatchPrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportBatchDao.insertDataInBatch(getRecord);
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
					int updateDataStatus=dataImportBatchDao.updateDataInBatch(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				
				BatchCSVReader.close();
				
				/*
				 * Inserting data in csvUploaded  Table
				 */		
				Date date=new Date(System.currentTimeMillis());
				
				Map<String,Object> uploadedFileInfo= new HashMap<String, Object>();
				
				uploadedFileInfo.put("csvType",type);
				uploadedFileInfo.put("csvName",fileNameToBeSaved);
				uploadedFileInfo.put("csvUploadDate",date);
				uploadedFileInfo.put("csvUploadUserId",userId);
				
				/*
				 * Checking for valid UserId (Foreign key constraint)
				 */
				
				status=dataImportCSVUploadTableDao.dataImportCSVUploadForeignKeyConstraintCheck(uploadedFileInfo);
				if(status==0 || status==2)
				{
				File deleteUploadedFile = new File(BatchCSVFileName);
				deleteUploadedFile.delete();	
				return "Invalid User Id . Action Aborted";	
				}
				
				int insertDataStatus=dataImportCSVUploadTableDao.insertDataInCSVUpload(uploadedFileInfo);
				if(!(insertDataStatus>0))
				{
				File deleteUploadedFile = new File(BatchCSVFileName);
				deleteUploadedFile.delete();
				return "Some Error occured while inserting data in csvUploaded By details table . Kindly try again ."; 
				}
				
				
				return "Data Successfully inserted in Database .";
				
			  }	// end of try
				catch(Exception e)
				{
					BatchCSVReader.close();
					File deleteUploadedFile = new File(BatchCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		
	
	}
}
