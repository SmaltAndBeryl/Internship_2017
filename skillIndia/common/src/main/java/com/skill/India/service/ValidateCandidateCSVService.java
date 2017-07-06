package com.skill.India.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dto.ValidateCandidateCSVDto;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Service 
public class ValidateCandidateCSVService {
	
	
	public static String validateCandidateCSV(String CandidateCSVFileName) throws IOException{
		CSVReader CandidateCSVReader=null;

		try{
			ColumnPositionMappingStrategy<ValidateCandidateCSVDto> strategy=new ColumnPositionMappingStrategy<ValidateCandidateCSVDto>();
			strategy.setType(ValidateCandidateCSVDto.class);
			String [] CandidateCSVColumns=new String[]{"candidateDetailsID","candidateName","enrollmentNumber","gender","dateOfBirth","nameOfFatherOrHusband","aadharNumber","mobileNumber","emailID","educationLevel","traineeAddress","traineePINCode","marksObtainedTheory","marksObtainedPractical","result","certified","placementStatus","dateOfJoining","employmentType","batchID","employerID"};
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
			recordCount++;
			int errorStatus=0;
			String errorString="";
					
			String candidateDetailsID=CandidateCSVData.getCandidateDetailsID();
			String candidateName=CandidateCSVData.getCandidateName();
		    String enrollmentNumber=CandidateCSVData.getEnrollmentNumber();
			String gender=CandidateCSVData.getGender();
			String dateOfBirth=CandidateCSVData.getDateOfBirth();
		    String nameOfFatherOrHusband=CandidateCSVData.getNameOfFatherOrHusband();
			String aadharNumber=CandidateCSVData.getAadharNumber();
			String mobileNumber=CandidateCSVData.getMobileNumber();
			String emailID=CandidateCSVData.getEmailID();
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
			String batchID=CandidateCSVData.getBatchID();
			String employerID=CandidateCSVData.getEmployerID();
			
			
			
			/*
			 * Validating empty fields 
			 */
			
			if(candidateDetailsID.equals("") || candidateName.equals("") || enrollmentNumber.equals("") || 
				gender.equals("") || dateOfBirth.equals("") || nameOfFatherOrHusband.equals("") || 
				emailID.equals("") || educationLevel.equals("") || traineeAddress.equals("") ||  
				traineePINCode.equals("") || batchID.equals("") || result.equals("") || certified.equals("") 
				||  placementStatus.equals(""))
			{
				errorStatus=1;
				errorString=errorString+"Mandatory Fields cant be empty .";			
			}
										
			/*
			 * No validation done on Trainee Address & Education Level 
			 */
		
		
			/*
			 * Checking for error in candidateDetailsID column
			 */
			if(!ValidationUtils.numbersCheck(candidateDetailsID))
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
			 * Checking for error in emailID column
			 */
			
			if(!ValidationUtils.emailCheck(emailID))
			{
				errorStatus=1;
				errorString=errorString + "Error in  'emailID' column .";
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
			 * Checking for error in batchID column
			 */
			if(!(ValidationUtils.numbersCheck(batchID) || batchID.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'batchID' column .";
			}
			
			/*
			 * Checking for error in employerID column
			 */
			if(!(ValidationUtils.numbersCheck(employerID) || employerID.equals("")))
			{
				errorStatus=1;
				errorString=errorString + "\nError in  'employerID' column .";
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
			return "Error Occurred while Uploading the File";
			
		}
		
		
		
		return "File successfully Uploaded";
	}
	
}
