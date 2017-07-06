package com.skill.India.service;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dto.ValidateBatchCSVDto;

@Service
public class ValidateBatchCSVService {

	public static String validateBatchCSV(String BatchCSVFileName){
		CSVReader BatchCSVReader=null;
		
		try{
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			strategy.setType(ValidateBatchCSVDto.class);
			String [] BatchCSVColumns=new String[]{"batchID","batchName","batchType",
					"trainingPartnerID","centreID","trainerID","totalCandidatesInBatch","batchMode","batchStartDate","batchEndDate","jobRole","jobRoleCode","maximumMarksTheory","maximumMarksPractical","level","resultApproved","resultApprovedOnDate","totalPass","totalFail","totalNotAppeared","totalCertified","certificateDownloaded","batchAssignmentDate","assessmentDate","agencyID","assessorID"};
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
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String batchID=BatchCSVData.getBatchID();
			String batchName=BatchCSVData.getBatchName();
			String batchType=BatchCSVData.getBatchType();
			String trainingPartnerID=BatchCSVData.getTrainingPartnerID();
			String centreID=BatchCSVData.getCentreID();
			String trainerID=BatchCSVData.getTrainerID();
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
			String agencyID=BatchCSVData.getAgencyID();
			String assessorID=BatchCSVData.getAssessorID();
			
			if(batchID.equals("") || batchName.equals("") || batchType.equals("") || 
			trainingPartnerID.equals("") || centreID.equals("") || trainerID.equals("")
			|| totalCandidatesInBatch.equals("") || batchMode.equals("") || 
			batchStartDate.equals("") || jobRole.equals("") || jobRoleCode.equals("") || 
			level.equals("") || certificateDownloaded.equals("")
			) 
			{
				errorStatus=1;
				errorString=errorString+"Mandatory Fields cant be empty";
			}
			
			/*
			 * Checking for error in batchID column
			 */
			
			if(!ValidationUtils.numbersCheck(batchID))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'batchID' column ";
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
			 * Checking for error in trainingPartnerID column
			 */
			
			
			if(!ValidationUtils.numbersCheck(trainingPartnerID))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainingPartnerID' column ";
			}
			
			/*
			 * Checking for error in centreID column
			 */
			
			if(!ValidationUtils.numbersCheck(centreID))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'centreID' column ";
			}
			
			/*
			 * Checking for error in trainerID column
			 */
			
			if(!ValidationUtils.numbersCheck(trainerID))
			{
				errorStatus=1;
				errorString=errorString +"Error in 'trainerID' column ";
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
			 * Checking for error in agencyID column
			 */
			
			if(!(ValidationUtils.numbersCheck(agencyID) || agencyID.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyID' column ";
			}
			
			/*
			 * Checking for error in assessorID column
			 */
			
			if(!(ValidationUtils.numbersCheck(assessorID) || assessorID.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'assessorID' column ";
			}
			
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;	
			}
		
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;	
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
			e.printStackTrace();
			return "Error parsing Batch CSV File. Kindly try again. ";
		}
		
		return "File Successfully Uploaded";
		
		
}
}
