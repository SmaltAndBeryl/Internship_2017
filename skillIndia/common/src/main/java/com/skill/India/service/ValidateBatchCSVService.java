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
import com.skill.India.dto.ValidateBatchCSVDto;

@Service
public class ValidateBatchCSVService {

	@Autowired
	private DataImportBatchDao dataImportBatchDao;
	
	public String validateBatchCSV(String BatchCSVFileName) throws IOException{
		CSVReader BatchCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateBatchCSVDto.class);
		String [] BatchCSVColumns=new String[]{"batchId","batchName","batchType",
					"trainingPartnerId","centreId","trainerId","totalCandidatesInBatch","batchMode","batchStartDate","batchEndDate","jobRole","jobRoleCode","maximumMarksTheory","maximumMarksPractical","level","resultApproved","resultApprovedOnDate","totalPass","totalFail","totalNotAppeared","totalCertified","certificateDownloaded","batchAssignmentDate","assessmentDate","agencyId","assessorId"};
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
			String certificateDownloaded=BatchCSVData.getCertificateDownloaded();
			String batchAssignmentDate=BatchCSVData.getBatchAssignmentDate();
			String assessmentDate=BatchCSVData.getAssessmentDate();
			String agencyId=BatchCSVData.getAgencyId();
			String assessorId=BatchCSVData.getAssessorId();
			
			if(batchId.equals("") || batchName.equals("") || batchType.equals("") || 
			trainingPartnerId.equals("") || centreId.equals("") || trainerId.equals("")
			|| totalCandidatesInBatch.equals("") || batchMode.equals("") || 
			batchStartDate.equals("") || jobRole.equals("") || jobRoleCode.equals("") || 
			level.equals("") || certificateDownloaded.equals("")
			) 
			{
				errorStatus=1;
				errorString=errorString+"Mandatory Fields cant be empty";
			}
			
			/*
			 * Checking for error in batchId column
			 */
			
			if(!ValidationUtils.numbersCheck(batchId))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchId' column ";
			}
			
			
			/*
			 * Checking for error in batchType column
			 */
			
			if(ValidationUtils.numbersCheck(batchType))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchType' column ";
			}
			
			/*
			 * Checking for error in trainingPartnerId column
			 */
			
			
			if(!ValidationUtils.numbersCheck(trainingPartnerId))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainingPartnerId' column ";
			}
			
			/*
			 * Checking for error in centreId column
			 */
			
			if(!ValidationUtils.numbersCheck(centreId))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'centreId' column ";
			}
			
			/*
			 * Checking for error in trainerId column
			 */
			
			if(!ValidationUtils.numbersCheck(trainerId))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainerId' column ";
			}
			
			/*
			 * Checking for error in totalCandidatesInBatch column
			 */
			
			if(!ValidationUtils.numbersCheck(totalCandidatesInBatch))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'totalCandidatesInBatch' column ";
			}
			
			/*
			 * Checking for error in batchMode column
			 */
			
			if(ValidationUtils.numbersCheck(batchMode))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchMode' column ";
			}
			
			/*
			 * Checking for error in batchStartDate column
			 */
			
			if(!ValidationUtils.dateFormatCheck(batchStartDate))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchStartDate' column ";
			}
			
			/*
			 * Checking for error in batchEndDate column
			 */
			
			if(!(ValidationUtils.dateFormatCheck(batchEndDate) || batchEndDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchEndDate' column ";
			}
			
			/*
			 * Checking for error in jobRole column
			 */
			
			if(ValidationUtils.numbersCheck(jobRole))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'jobRole' column ";
			}
			
			/*
			 * Checking for error in maximumMarksTheory column
			 */
			
			if(!(ValidationUtils.numbersWithDecimalCheck(maximumMarksTheory) || maximumMarksTheory.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'maximunMarksTheory' column ";
			}
			
			/*
			 * Checking for error in maximumMarksPractical column
			 */
			
			if(!(ValidationUtils.numbersWithDecimalCheck(maximumMarksPractical) || maximumMarksPractical.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'maximumMarksPractical' column ";
			}
			
			/*
			 * Checking for error in level column
			 */
			
			if(!ValidationUtils.numbersCheck(level))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'level' column ";
			}
			
			/*
			 * Checking for error in resultApproved column
			 */
			
			if(!(ValidationUtils.lettersCheck(resultApproved) || resultApproved.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'resultApproved' column ";
			}
			
			/*
			 * Checking for error in resultApprovedOnDate column
			 */
			
			if(!(ValidationUtils.dateFormatCheck(resultApprovedOnDate) || resultApprovedOnDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'resultApprovedOndate' column ";
			}
			
			/*
			 * Checking for error in totalPass column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalPass) || totalPass.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalPass' column ";
			}
			
			/*
			 * Checking for error in totalFail column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalFail) || totalFail.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalFail' column ";
			}
			
			/*
			 * Checking for error in totalNotAppeared column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalNotAppeared) || totalNotAppeared.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalNotAppeared' column ";
			}
			
			/*
			 * Checking for error in totalCertified column
			 */
			
			if(!(ValidationUtils.numbersCheck(totalCertified) || totalCertified.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'totalCertified' column ";
			}
			
			/*
			 * Checking for error in certificateDownloaded column
			 */
			
			if(!ValidationUtils.lettersCheck(certificateDownloaded))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'certificateDownloaded' column ";
			}
			
			/*
			 * Checking for error in batchAssignmentDate column
			 */
			
			if(!(ValidationUtils.dateFormatCheck(batchAssignmentDate) || batchAssignmentDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'batchAssignmentDate' column ";
			}
			
			/*
			 * Checking for error in assessmentDate column
			 */
			
			if(!(ValidationUtils.dateFormatCheck(assessmentDate) || assessmentDate.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'assessmentDate' column ";
			}
			
			/*
			 * Checking for error in agencyId column
			 */
			
			if(!(ValidationUtils.numbersCheck(agencyId) || agencyId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyId' column ";
			}
			
			/*
			 * Checking for error in assessorId column
			 */
			
			if(!(ValidationUtils.numbersCheck(assessorId) || assessorId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'assessorId' column ";
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
				
				/*
				 * Setting value of empty fields 
				 */
				
				if(batchEndDate.equals(""))
				{
					batchEndDate="1900-01-00";
				}	
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
				if(assessmentDate.equals(""))
				{
					assessmentDate="1900-01-00";
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
				record.put("batchStartDate",batchStartDate);
				record.put("batchEndDate",batchEndDate);
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
				record.put("certificateDownloaded",certificateDownloaded);
				record.put("batchAssignmentDate",batchAssignmentDate);
				record.put("assessmentDate",assessmentDate);
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
		
		try{				
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				int status=dataImportBatchDao.dataImportBatchForeignKeyConstraintCheck(getRecord);
				if(status==0 || status==2)
				{
				throw new Exception();	
				}
				
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				BatchCSVReader.close();
				File deleteUploadedFile = new File(BatchCSVFileName);
				deleteUploadedFile.delete();
				e.printStackTrace();
				return "Error in trainerId or trainingPartnerId or centreId or agencyId or AssessorId, column. Kindly recheck the details ."
			+ "either trainerId not found in Trainers record or trainingPartnerId not found in Training Partners record or centreId not found "
			+ "in Centres record or agencyId not found in Agency record or assessorId not found in Assessor record .";
			}
		 
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */
		
			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{			
				int status=dataImportBatchDao.dataImportBatchPrimaryKeyConstraintCheck(getRecord);
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
