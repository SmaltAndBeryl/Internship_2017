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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dao.DataImportCandidateDao;
import com.skill.India.dto.ValidateCandidateCSVDto;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Service 
public class ValidateCandidateCSVService {
	
	@Autowired
	private DataImportCandidateDao dataImportCandidateDao;
	
	public String validateCandidateCSV(String CandidateCSVFileName) throws IOException{
		CSVReader CandidateCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy<ValidateCandidateCSVDto> strategy=new ColumnPositionMappingStrategy<ValidateCandidateCSVDto>();
		strategy.setType(ValidateCandidateCSVDto.class);
		String [] CandidateCSVColumns=new String[]{"candidateDetailsId","candidateName","enrollmentNumber","gender","dateOfBirth","nameOfFatherOrHusband","aadharNumber","mobileNumber","emailId","educationLevel","traineeAddress","traineePINCode","marksObtainedTheory","marksObtainedPractical","result","certified","placementStatus","dateOfJoining","employmentType","batchId","employerId"};
		strategy.setColumnMapping(CandidateCSVColumns);
		//String CandidateCSVFileName = "D:\\EclipseWorkspace\\Candidate.csv";
		CandidateCSVReader=new CSVReader(new FileReader(CandidateCSVFileName),',','"',2);
		CsvToBean<ValidateCandidateCSVDto> CandidateCSVToBean=new CsvToBean<ValidateCandidateCSVDto>(); 
		List<ValidateCandidateCSVDto> CandidateCSVDataList= CandidateCSVToBean.parse(strategy,CandidateCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateCandidateCSVDto CandidateCSVData :CandidateCSVDataList)
		{
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			Map<String ,Object> record=new HashMap<String, Object>();
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
					
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
			 * Validating empty fields 
			 */
			
			if(candidateDetailsId.equals("") || candidateName.equals("") || enrollmentNumber.equals("") || 
				gender.equals("") || dateOfBirth.equals("") || nameOfFatherOrHusband.equals("") || 
				emailId.equals("") || educationLevel.equals("") || traineeAddress.equals("") ||  
				traineePINCode.equals("") || batchId.equals("") || result.equals("") || certified.equals("") 
				||  placementStatus.equals("") || batchId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+"Mandatory Fields cant be empty .";			
			}
			
			
			/*
			 * No validation done on Trainee Address & Education Level 
			 */
		
		
			/*
			 * Checking for error in candidateDetailsId column
			 */
			if(!ValidationUtils.numbersCheck(candidateDetailsId))
			{
				errorStatus=1;
				errorString=errorString+"Error in  'candidateDetailsId' column .";
			}
		
			/*
			 * Checking for error in candidateName column
			 */
			if(ValidationUtils.numbersCheck(candidateName))
			{
				errorStatus=1;
				errorString=errorString+"Error in  'candidateName' column .";
			}
			
			
			/*
			 * Checking for error in gender column
			 */
			if(!ValidationUtils.lettersCheck(gender))
			{
				errorStatus=1;
				errorString=errorString +"Error in  'gender' column .";
			}
			
			/*
			 * Checking for error in dateOfBirth column
			 */
			if(!ValidationUtils.dateFormatCheck(dateOfBirth))
			{
				errorStatus=1;
				errorString=errorString+"Error in  'dateOfBirth' column .";
			}
		
			/*
			 * Checking for error in nameOfFatherOrHusband column
			 */
			if(ValidationUtils.numbersCheck(nameOfFatherOrHusband))
			{
				errorStatus=1;
				errorString=errorString+ "Error in  'nameOfFatherOrHusband' column .";
			}
			
			/*
			 * Checking for error in aadharNumber column
			 */
			if(!(ValidationUtils.numbersCheck(aadharNumber) || aadharNumber.equals("")) )
			{
				errorStatus=1;
				errorString=errorString+ "Error in  'aadharNumber' column .";
			}
		
			/*
			 * Checking for error in mobileNumber column
			 */
			if(!(ValidationUtils.mobileNumberCheck(mobileNumber) || mobileNumber.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'mobileNumber' column .";
			}
		
			/*
			 * Checking for error in emailId column
			 */
			
			if(!ValidationUtils.emailCheck(emailId))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'emailId' column .";
			}
		
			/*
			 * Checking for error in traineePINCode column
			 */
			if(!ValidationUtils.pincodeNumberCheck(traineePINCode))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'traineePINCode' column .";
			}
			
			/*
			 * Checking for error in marksObtainedTheory column
			 */
			if(!(ValidationUtils.numbersWithDecimalCheck(marksObtainedTheory) ||marksObtainedTheory.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'marksObtainedTheory' column .";
			}
			
			/*
			 * Checking for error in marksObtainedPractical column
			 */
			if(!(ValidationUtils.numbersWithDecimalCheck(marksObtainedPractical) || marksObtainedPractical.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'marksObtainedPractical' column .";
			}
			
			/*
			 * Checking for error in result column
			 */
			if(!ValidationUtils.lettersCheck(result))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'result' column .";
			}
			
			/*
			 * Checking for error in certified column
			 */
			if(!ValidationUtils.lettersCheck(certified))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'certified' column .";
			}
			
			/*
			 * Checking for error in placementStatus column
			 */
			if(!ValidationUtils.lettersCheck(placementStatus))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'placementStatus' column .";
			}
			
			/*
			 * Checking for error in dateOfJoining column
			 */
			if(!(ValidationUtils.dateFormatCheck(dateOfJoining) || dateOfJoining.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'dateOfJoining' column .";
			}
			
			/*
			 * Checking for error in employmentType column
			 */
			if(!(ValidationUtils.lettersCheck(employmentType) || employmentType.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'employmentType' column .";
			}
			
			/*
			 * Checking for error in batchId column
			 */
			if(!(ValidationUtils.numbersCheck(batchId) || batchId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'batchId' column .";
			}
			
			/*
			 * Checking for error in employerId column
			 */
			if(!(ValidationUtils.numbersCheck(employerId) || employerId.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'employerId' column .";
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
			 if(aadharNumber.equals(""))
			 {
				 aadharNumber="0";
			 }
			 if(mobileNumber.equals(""))
			 {
				 mobileNumber="0";
			 }
			 if(marksObtainedTheory.equals(""))
			 {
				 marksObtainedTheory="0";
			 }
			 if(marksObtainedPractical.equals(""))
			 {
				 marksObtainedPractical="0";
			 }
			 if(dateOfJoining.equals(""))
			 {
				 dateOfJoining="1900-01-00";
			 }
			 if(employmentType.equals(""))
			 {
				 employmentType="unknown";
			 }
			 if(employerId.equals(""))
			 {
				 employerId="0";
			 }
			 
			 /*
			  * Inserting row wise data in HashMap
			  */
			 
			 record.put("candidateDetailsId", candidateDetailsId);
			 record.put("candidateName",candidateName);
			 record.put("enrollmentNumber",enrollmentNumber);
			 record.put("gender",gender);
			 record.put("dateOfBirth",dateOfBirth);
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
			 
			 arrayOfRecords.add(record);
			}
			
		}
			if(errorExist==1)
			{
			CandidateCSVReader.close();
			File deleteUploadedFile = new File(CandidateCSVFileName);
		    deleteUploadedFile.delete();
			return errorListAllRecords;
			}
			
			
		}
		catch(Exception e)
		{	
			CandidateCSVReader.close();
			File deleteUploadedFile = new File(CandidateCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error parsing Batch CSV File. Kindly try again. ";
			
		}
		
		/*
		 * Checking for foreign key constraint of batchId & employerId
		 */
		
		try{				
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				int status=dataImportCandidateDao.dataImportCandidateForeignKeyConstraintCheck(getRecord);
				if(status==0 || status==2)
				{
				throw new Exception();	
				}
				
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				CandidateCSVReader.close();
				File deleteUploadedFile = new File(CandidateCSVFileName);
				deleteUploadedFile.delete();
				e.printStackTrace();
				return "Error in batchId or employerId column. Kindly recheck the details ."
			+ "either batchId not found in Batches record or employerId not found in Employer record .";
			}
	
		/*
		 * Checking primary key Constraint and performing respective actions 
		 */
			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{					
				int status=dataImportCandidateDao.dataImportCandidatePrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportCandidateDao.insertDataInCandidate(getRecord);
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
					int updateDataStatus=dataImportCandidateDao.updateDataInCandidate(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				CandidateCSVReader.close();
				return "Data Successfully inserted in Database .";
				}	// end of try
				catch(Exception e)
				{
					CandidateCSVReader.close();
					File deleteUploadedFile = new File(CandidateCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		
			
	}
	
}
