package com.skill.India.controller;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.ProfileCreationABTPDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyWrapperDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerWrapperDto;
import com.skill.India.service.ProfileCreationGetDataService;
import com.skill.India.service.ProfileCreationSaveAsDraftAndSubmitService;
import com.skill.India.service.ProfileCreationTrainingPartnerService;
import com.skill.India.service.SaveAsDraftAndSubmitService;


@RestController
public class ProfileCreationController {

	@Autowired
	private ProfileCreationTrainingPartnerService profileCreationTrainingPartnerService;

	@Autowired
	private SaveAsDraftAndSubmitService saveAsDraftAndSubmitService;
	
	@Autowired
	private ProfileCreationGetDataService profileCreationGetDataService;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;

	@Autowired
	private ProfileCreationSaveAsDraftAndSubmitService profileCreationSaveAsDraftAndSubmitService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationController.class);
	
	
	/*
	 * Method to get data for Profile creation of assessment body and training partner
	 * */
	
	@RequestMapping(value="/getDataNewUserProfileCreation")
	public HashMap<String,Object> getData()
	{
		return profileCreationGetDataService.profileCreationGetData(sessionUserUtility
				.getApplicationId(sessionUserUtility
						.getSessionMangementfromSession().getUsername()));
	}
	
	/*
	 * Method to implement save as draft and submit functionalities
	 * */
	
	
	@RequestMapping(value="/saveAsDraftAndSubmit" , method = RequestMethod.POST, consumes =MediaType.ALL_VALUE )
	public void saveAsDraftAndSubmitController(@RequestBody ProfileCreationABTPDto profileCreationABTPDto)
	{
		
		LOGGER.debug("User type received from front end is"+ profileCreationABTPDto.getType().toString());
		LOGGER.debug("User type received from front end is"+ profileCreationABTPDto.getUserData().toString());

		LOGGER.debug("User type received from front end is"+ profileCreationABTPDto.getUserDeletes().toString());
		
		
	}
	
	@RequestMapping(value="/saveAsDraftAndSubmitAB", method = RequestMethod.POST)
	public int saveAsDraftABController(@RequestBody ProfileCreationAssessmentBodyWrapperDto profileCreationAssessmentBodyWrapperDto)
	{
		LOGGER.debug("Response fro organisation as received from front end " + profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegistrationDetailsDto());
		int status = profileCreationSaveAsDraftAndSubmitService.SaveAssessmentBody(profileCreationAssessmentBodyWrapperDto);
		return status;
		
	}
	@RequestMapping(value="/saveAsDraftAndSubmitTP", method = RequestMethod.POST)
	public int saveAsDraftTP(@RequestBody ProfileCreationTrainingPartnerWrapperDto profileCreationTrainingPartnerWrapperDto)
	{
		int status = profileCreationSaveAsDraftAndSubmitService.saveTrainingPartner(profileCreationTrainingPartnerWrapperDto);
		return status;
		
	}
	
	@RequestMapping(value="/fileUploadTPPAN", method = RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	public int saveFilePAN(@RequestParam(value="pan") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("File has been received from front end " + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveTPPAN(file, "pan" );
		return status;
	}
	
	@RequestMapping(value="/fileUploadTPTAN", method = RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	public int saveFileTAN(@RequestParam(value="tan") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("File has been received from front end " + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveTPTAN(file, "tan");
		return status;
	}
	
	@RequestMapping(value="/fileUploadTPNSDC", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileNSDCCertificate(@RequestParam(value="nsdcCertificate") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("Trying to upload nsdc certifiacte" + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveTPNSDCCertificate(file, "nsdcCertificate");
		return status;
	}
	
	@RequestMapping(value="/fileuploadTPSelfOwned", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileSelfOwnedAnnexure(@RequestParam(value = "selfOwnedAnnexure")MultipartFile file , @RequestParam(value = "postvalue") ProfileCreationTrainingPartnerWrapperDto profileCreationTrainingPartnerWrapperDto)
	{
		int status = 0;
		LOGGER.debug("Received file is " + file);
		LOGGER.debug("Received object is" + profileCreationTrainingPartnerWrapperDto );
		//status = profileCreationSaveAsDraftAndSubmitService.saveSelfOwnedAnnexure(file, "selfOwnedAnnexure");
		return status ;
	}
	
	@RequestMapping(value="/fileuploadTPFranchisee", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileFrnachiseeAnnexure(@RequestParam(value = "fileuploadTPFranchisee")MultipartFile file)
	{
		int status = 0;
		status = profileCreationSaveAsDraftAndSubmitService.saveFranchiseeAnnexure(file, "fileuploadTPFranchisee");
		return status ;
	}

	@RequestMapping(value="/fileuploadTPMobile", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileMobileAnnexure(@RequestParam(value = "fileuploadTPMobile")MultipartFile file)
	{
		int status = 0;
		status = profileCreationSaveAsDraftAndSubmitService.saveMobileAnnexure(file, "fileuploadTPMobile");
		return status ;
	}
	/*
	 * Method to upload Education certificates of Training staff*/
	@RequestMapping(value="/fileUploadTpEducationCertificates", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileEducationCertificateTp(@RequestParam(value = "fileuploadTPEducationCertificate")MultipartFile file)
	{
		int status = 0;
		status = profileCreationSaveAsDraftAndSubmitService.saveTrainingStaffEducationCertificate(file, "TrainingStaffEducationCertificate");
		return status ;
	}
	
	/*
	 * Method to upload training staff Cv*/
	
	@RequestMapping(value="/fileUploadTrainingStaffCv", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileTrainingStaffCv(@RequestParam(value = "fileuploadTrainingStaffCv")MultipartFile file)
	{
		int status = 0;
		status = profileCreationSaveAsDraftAndSubmitService.saveTrainingStaffCv(file, "TrainingStaffCv");
		return status ;
	}
	
	/*
	 * Method to upload Training Partner Management Staff*/
	
	@RequestMapping(value= "/fileUploadManagementStaffCv" , method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileManagementStaffCv(@RequestParam(value="fileUploadTpManagementCv") MultipartFile file)
	{
		int status = 0;
		status = profileCreationSaveAsDraftAndSubmitService.saveTrainingPartnerManagementStaff(file, "TrainingPartnerManagementCv");
		return status ;
	}
	
	/*
	 * Method to save Operation Head Cv*/
	@RequestMapping(value="/fileUploadOperationHeadCv", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileOperationHead(@RequestParam(value="operationHeadCv") MultipartFile file)
	{
		int status = 0;
		
		//status = profileCreationSaveAsDraftAndSubmitService.
		return status;
	}
	
	
	/*
	 * Method to save Affiliation Coordinator Cv*/
	@RequestMapping(value="/fileUploadAffiliationCoordinatorCv", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public int saveFileAffiliationcoordinator(@RequestParam(value="affiliationCoordinatorCv")MultipartFile file)
	{
		int status = 0;
		//status = profileCreationSaveAsDraftAndSubmitService.
		return status;
	}
	
	/*
	 * Method to save SPOC Cv*/
	@RequestMapping(value="/fileUploadSPOCCv")
	public int saveFileSPOCCv(@RequestParam(value="SPOCCv")MultipartFile file)
	{
		int status = 0;
		//status = profileCreationSaveAsDraftAndSubmitService.
		return status;
	}
	/*
	 * Method to upload Pan Card pdf of Assessment Body*/
	
	@RequestMapping(value="/fileUploadABPAN", method = RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	public int saveFilePANAB(@RequestParam(value="pan") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("File has been received from front end " + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveABPAN(file, "pan");
		return status;
	}
	
	/*
	 * Method to upload Tan Pdf of Assessment Body*/
	@RequestMapping(value="/fileUploadABTAN", method = RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	public int saveFileTanAB(@RequestParam(value="tan") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("File has been received from front end " + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveABTan(file, "tan");
		return status;
	}
	
		
	//Save Cv of Assessment Body Management Staff
	
	@RequestMapping(value="/fileUploadAbMgmtCv" , method  =RequestMethod.POST , consumes=MediaType.ALL_VALUE)
	public int saveFileAbManagementCv(@RequestParam(value="AssessmentBodyManagementCV") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("File has been received from front end " + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveAbManagementCv(file, "AssessmentBodyManagementStaffCV");
		return status;
	}
	
	//Save CV of Assessment Body Assessment staff cv
	@RequestMapping(value="/fileUploadAbAssessorCv" , method  =RequestMethod.POST , consumes=MediaType.ALL_VALUE)
	public int saveFileAbAssessmentStaffCv(@RequestParam(value="AssessmentBodyAssessmentStaffCV") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("File has been received from front end " + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveAbAssessmentStaffCv(file, "AssessmentBodyAssessmentStaffCV");
		return status;
	}
	
	//Save CV of Assessment Body Assessment staff cv
	@RequestMapping(value="/fileUploadAbAssessorCertificate" , method  =RequestMethod.POST , consumes=MediaType.ALL_VALUE)
	public int saveFileAbAssessmentStaffEducationCertificate(@RequestParam(value="AssessmentBodyAssessmentStaffEducationCertificate") MultipartFile file)
	{
		int status = 0;
		LOGGER.debug("File has been received from front end " + file);
		status = profileCreationSaveAsDraftAndSubmitService.saveAbAssessmentStaffEducationCertificates(file,"AssessmentBodyAssessmentStaffEducationCertificate");
		return status;
	}
}

