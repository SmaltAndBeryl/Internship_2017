package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : This file maps the columns of uploaded csv by user with the type of sheet
 * 				  selected by him/her .
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckTypeOfCSVService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckTypeOfCSVService.class);
	
	@Autowired
	private ValidateBatchCSVService validateBatchCSVService;

	@Autowired
	private ValidateCandidateCSVService validateCandidateCSVService;
	
	@Autowired
	private ValidateTrainingPartnerCSVService validateTrainingPartnerCSVService;
	
	@Autowired
	private ValidateCentreCSVService validateCentreCSVService;
	
	@Autowired
	private ValidateTrainerCSVService validateTrainerCSVService;
	
	@Autowired
	private ValidateAssessmentAgencyCSVService validateAssessmentAgencyCSVService;
	
	@Autowired
	private ValidateAssessorCSVService validateAssessorCSVService;
	
	@Autowired
	private ValidateEmployerCSVService validateEmployerCSVService;
	
	
	   public String checkTypeOfCSV(String type,String pathOfUploadedFile,String userId,String fileNameToBeSaved) {
		   
		   	LOGGER.info("Request Received from Service");
			LOGGER.info("In CheckTypeOfCSVService - checkTypeOfCSV");
			LOGGER.info("Parameters Received from Controller are - 'type': "+type+" 'pathOfUploadedFile': "+pathOfUploadedFile+" 'userId': "+userId+" 'fileNameToBeSaved': "+fileNameToBeSaved);
			

	        String line = "";
	        String cvsSplitBy = ",";
	        LOGGER.info("Creating BufferedReader object");
	        try (BufferedReader readColumnsOfCsv = new BufferedReader(new FileReader(pathOfUploadedFile))) {
	        	LOGGER.info("In TRY block");
	        	LOGGER.info("Successfully created and initialized");
	                // use comma as separator
	              	LOGGER.info("Reading CSV line by line");
	                line = readColumnsOfCsv.readLine(); 
	                LOGGER.info("Seperating columns in each line of CSV");
	                String[] columns = line.split(cvsSplitBy);
	                LOGGER.info("Entering into SWITCH block");
	            switch (type){
	            	case "Candidate" :
	            		LOGGER.info("CSV is of type Candidate");
	            	if(columns[0].equals("candidateDetailsId") && columns[1].equals("candidateName") && 
							columns[2].equals("enrollmentNumber") && columns[3].equals("gender")
							&& columns[4].equals("dateOfBirth") && columns[5].equals("nameOfFatherOrHusband") && 
							columns[6].equals("aadharNumber") && columns[7].equals("mobileNumber")
							&& columns[8].equals("emailId") && columns[9].equals("educationLevel")
							&& columns[10].equals("traineeAddress") && columns[11].equals("traineePINCode") && 
							columns[12].equals("marksObtainedTheory") && columns[13].equals("marksObtainedPractical")
							&& columns[14].equals("result") && columns[15].equals("certified") &&
							columns[16].equals("placementStatus") && columns[17].equals("dateOfJoining") &&
							columns[18].equals("employmentType") && columns[19].equals("batchId") &&
							columns[20].equals("employerId") )
	            	{
	            		LOGGER.info("Closing BufferedReader");
	            		readColumnsOfCsv.close();
	            		LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            	return validateCandidateCSVService.validateCandidateCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved); 
	            	}
		        	break;
	            	
				case "Batch":
					LOGGER.info("CSV is of type Batch");
					if(columns[0].equals("batchId") && columns[1].equals("batchName") && 
						columns[2].equals("batchType") && columns[3].equals("trainingPartnerId")
						&& columns[4].equals("centreId") && columns[5].equals("trainerId") && 
						columns[6].equals("totalCandidatesInBatch") && columns[7].equals("batchMode")
						&& columns[8].equals("batchStartDate") && columns[9].equals("batchEndDate")
						&& columns[10].equals("jobRole") && columns[11].equals("jobRoleCode") && 
						columns[12].equals("maximumMarksTheory") && columns[13].equals("maximumMarksPractical")
						&& columns[14].equals("level") && columns[15].equals("resultApproved") &&
						columns[16].equals("resultApprovedOnDate") && columns[17].equals("totalPass") &&
						columns[18].equals("totalFail") && columns[19].equals("totalNotAppeared") &&
						columns[20].equals("totalCertified")
						&& columns[21].equals("batchAssignmentDate") && columns[22].equals("assessmentDate")
						&& columns[23].equals("agencyId") && columns[24].equals("assessorId"))
					{
						LOGGER.info("Closing BufferedReader");
						readColumnsOfCsv.close();
						LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            		return validateBatchCSVService.validateBatchCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved);
					}
						
						
					break;

				case "Training Partner":
					LOGGER.info("CSV is of type Training Partner");
					if(columns[0].equals("trainingPartnerId") && columns[1].equals("applicationId") && 
							columns[2].equals("trainingPartnerName") && columns[3].equals("batchType"))
					{
						LOGGER.info("Closing BufferedReader");
						readColumnsOfCsv.close();
						LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            		return validateTrainingPartnerCSVService.validateTrainingPartnerCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved);
					}
					break;
					
				case "Centre":
					
					LOGGER.info("CSV is of type Centre");
					if(columns[0].equals("centreId") && columns[1].equals("centreName") && 
							columns[2].equals("centrePOCContactName")&& columns[3].equals("centreAddress")
							&& columns[4].equals("district") && columns[5].equals("state") && 
							columns[6].equals("trainingPartnerId"))
					{
						LOGGER.info("Closing BufferedReader");
						readColumnsOfCsv.close();
						LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            		return validateCentreCSVService.validateCentreCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved);
					}
					break;
					
				case "Trainer":
					
					LOGGER.info("CSV is of type Centre");
					if(columns[0].equals("trainerId") && columns[1].equals("trainerName") && 
							columns[2].equals("designation")&& columns[3].equals("trainingPartnerId"))
					{
						LOGGER.info("Closing BufferedReader");
						readColumnsOfCsv.close();
						LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            		return validateTrainerCSVService.validateTrainerCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved);
					}
					
					break;	
					
					
				case "Assessment Agency":
					
					LOGGER.info("CSV is of type Assessment Agency");
//					System.out.println("In agency switch");
					if(columns[0].equals("agencyId") && columns[1].equals("applicationId") && columns[2].equals("agencyName"))
					{
						LOGGER.info("Closing BufferedReader");
						readColumnsOfCsv.close();
						LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            		return validateAssessmentAgencyCSVService.validateAssessmentAgencyCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved);
					}
					
				case "Assessor":
					
					LOGGER.info("CSV is of type Assessor");
					if(columns[0].equals("assessorId") && columns[1].equals("assessorName") && columns[2].equals("district") && 
							columns[3].equals("state")&& columns[4].equals("agencyId"))
					{
						LOGGER.info("Closing BufferedReader");
						readColumnsOfCsv.close();
						LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            		return validateAssessorCSVService.validateAssessorCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved);
					}
					break;	
				
				case "Employer":
				
					LOGGER.info("CSV is of type Employer");
					if(columns[0].equals("employerId") && columns[1].equals("employerName") && 
							columns[2].equals("locationOfEmployer")&& columns[3].equals("locationOfEmployerDistrict")
							&& columns[4].equals("locationOfEmployerState"))
					{
						LOGGER.info("Closing BufferedReader");
						readColumnsOfCsv.close();
						LOGGER.info("Successfully closed");
	            		LOGGER.info("Sending Request to service to validate CSV");
	            		return validateEmployerCSVService.validateEmployerCSV(pathOfUploadedFile,type,userId,fileNameToBeSaved);
					}
					break;	
					
				default:
					LOGGER.info("Inside DEFAULT:");
					LOGGER.info("Closing BufferedReader");
					readColumnsOfCsv.close();
					LOGGER.info("Successfully closed");
            		LOGGER.info("Returning Error message as String");
            		return "Kindly select a valid option";
				
				}   // End of switch
	            LOGGER.info("Closing BufferedReader");
	            readColumnsOfCsv.close();
	            LOGGER.info("Successfully closed");
        		LOGGER.info("Returning Error message as String");
        		LOGGER.info("Creating File object");
        		File deleteUploadedFile = new File(pathOfUploadedFile);
        		LOGGER.info("Successfully created and initialized");
        		LOGGER.info("Deleting Uploaded file from System");
	            deleteUploadedFile.delete();	 
	            LOGGER.info("Successfully deleted");
	            LOGGER.info("Returning Error message as String");
	            return "Error in column mapping!";
	                
	        }    // End of Try 
	        
	        catch (IOException e) {
	        	LOGGER.info("In CATCH block");
	        	LOGGER.error("ERROR: Encountered an Exception - "+e);
	   			e.printStackTrace();
	            LOGGER.info("Creating File object");
        		File deleteUploadedFile = new File(pathOfUploadedFile);
        		LOGGER.info("Successfully created and initialized");
        		LOGGER.info("Deleting Uploaded file from System");
	            deleteUploadedFile.delete();
	            LOGGER.info("Successfully deleted");
	            LOGGER.info("Returning Error message as String");
	            return "Error Uploading CSV File ";
	        }
	      

	    }

	}
	
