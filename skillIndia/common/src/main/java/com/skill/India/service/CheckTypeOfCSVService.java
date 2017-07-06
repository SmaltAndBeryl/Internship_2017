package com.skill.India.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckTypeOfCSVService {
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
	
	
	   public String checkTypeOfCSV(String type,String pathOfUploadedFile) {

	        String line = "";
	        String cvsSplitBy = ",";
	        try (BufferedReader readColumnsOfCsv = new BufferedReader(new FileReader(pathOfUploadedFile))) {

	                // use comma as separator
	              
	                line = readColumnsOfCsv.readLine(); 
	                
	                String[] columns = line.split(cvsSplitBy);
	                
	            switch (type){
	            	case "Candidate" :
	            
	            	if(columns[0].equals("candidateDetailsID") && columns[1].equals("candidateName") && 
							columns[2].equals("enrollmentNumber") && columns[3].equals("gender")
							&& columns[4].equals("dateOfBirth") && columns[5].equals("nameOfFatherOrHusband") && 
							columns[6].equals("aadharNumber") && columns[7].equals("mobileNumber")
							&& columns[8].equals("emailID") && columns[9].equals("educationLevel")
							&& columns[10].equals("traineeAddress") && columns[11].equals("traineePINCode") && 
							columns[12].equals("marksObtainedTheory") && columns[13].equals("marksObtainedPractical")
							&& columns[14].equals("result") && columns[15].equals("certified") &&
							columns[16].equals("placementStatus") && columns[17].equals("dateOfJoining") &&
							columns[18].equals("employmentType") && columns[19].equals("batchID") &&
							columns[20].equals("employerID") )
	            	{
	            		readColumnsOfCsv.close();
	            	return validateCandidateCSVService.validateCandidateCSV(pathOfUploadedFile); 
	            	}
		        	break;
	            	
				case "Batch":
				
					if(columns[0].equals("batchesID") && columns[1].equals("batchName") && 
						columns[2].equals("batchType") && columns[3].equals("trainingPartnerID")
						&& columns[4].equals("centreID") && columns[5].equals("trainerID") && 
						columns[6].equals("totalCandidatesInBatch") && columns[7].equals("batchMode")
						&& columns[8].equals("batchStartDate") && columns[9].equals("batchEndDate")
						&& columns[10].equals("jobRole") && columns[11].equals("jobRoleCode") && 
						columns[12].equals("maximumMarksTheory") && columns[13].equals("maximumMarksPractical")
						&& columns[14].equals("level") && columns[15].equals("resultApproved") &&
						columns[16].equals("resultApprovedOnDate") && columns[17].equals("totalPass") &&
						columns[18].equals("totalFail") && columns[19].equals("totalNotAppeared") &&
						columns[20].equals("totalCertified") && columns[21].equals("certificateDownloaded")
						&& columns[22].equals("batchAssignmentDate") && columns[23].equals("assessmentDate")
						&& columns[24].equals("agencyID") && columns[25].equals("assessorID"))
					{
						readColumnsOfCsv.close();
						return validateBatchCSVService.validateBatchCSV(pathOfUploadedFile);
					}
						
						
					break;

				case "Training Partner":
				
					if(columns[0].equals("trainingPartnerID") && columns[1].equals("applicationID") && 
							columns[2].equals("trainingPartnerName"))
					{
						readColumnsOfCsv.close();
						return validateTrainingPartnerCSVService.validateTrainingPartnerCSV(pathOfUploadedFile);
					}
					break;
					
				case "Centre":
				
					if(columns[0].equals("centreID") && columns[1].equals("centreName") && 
							columns[2].equals("centrePOCContactName")&& columns[3].equals("centreAddress")
							&& columns[4].equals("district") && columns[5].equals("state") && 
							columns[6].equals("trainingPartnerID"))
					{
						readColumnsOfCsv.close();
						return validateCentreCSVService.validateCentreCSV(pathOfUploadedFile);
					}
					break;
					
				case "Trainer":
				
					if(columns[0].equals("trainerID") && columns[1].equals("trainerName") && 
							columns[2].equals("designation")&& columns[3].equals("trainingPartnerID"))
					{
						readColumnsOfCsv.close();
						return validateTrainerCSVService.validateTrainerCSV(pathOfUploadedFile);
					}
					
					break;	
					
					
				case "Assessment Agency":
					System.out.println("In agency switch");
					if(columns[0].equals("agencyID") && columns[1].equals("agencyName"))
					{
						readColumnsOfCsv.close();
						System.out.println("In if");
						return validateAssessmentAgencyCSVService.validateAssessmentAgencyCSV(pathOfUploadedFile);
					}
					
				case "Assessor":
				
					if(columns[0].equals("assessorID") && columns[1].equals("assessorName") && columns[2].equals("district") && 
							columns[3].equals("state")&& columns[4].equals("agencyID"))
					{
						readColumnsOfCsv.close();
						return validateAssessorCSVService.validateAssessorCSV(pathOfUploadedFile);
					}
					break;	
				
				case "Employer":
				
					if(columns[0].equals("employerID") && columns[1].equals("employerName") && 
							columns[2].equals("locationOfEmployer")&& columns[3].equals("locationOfEmployerDistrict")
							&& columns[4].equals("locationOfEmployerState"))
					{
						readColumnsOfCsv.close();
						return validateEmployerCSVService.validateEmployerCSV(pathOfUploadedFile);
					}
					break;	
					
				default:
					readColumnsOfCsv.close();
					return "Kindly select a valid option";
				
				}   // End of switch

	            readColumnsOfCsv.close();
	            File deleteUploadedFile = new File(pathOfUploadedFile);
	            deleteUploadedFile.delete();	             
	            return "Error in column mapping ..!";
	                
	        }    // End of Try 
	        
	        catch (IOException e) {
	            e.printStackTrace();
	            File deleteUploadedFile = new File(pathOfUploadedFile);
	            deleteUploadedFile.delete();
	            return "Error Uploading CSV File ";
	        }
	      

	    }

	}
	
