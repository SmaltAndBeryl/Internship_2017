package com.skill.India.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.skill.India.service.DashboardService;
import com.skill.India.service.ShareBrochureService;
import com.skill.India.service.ShareContactDetailsService;
import com.skill.India.service.WebhookFAQService;

@Component
public class VoiceIntentController extends DialogflowApp{
	
	@Autowired
	private ShareBrochureService shareBrochureService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private WebhookFAQService webhookFAQService;
	
	@Autowired
	private ShareContactDetailsService shareContactDetailsService;
	
	String shareBrochureResponse;
	String candidateEnrolledResponse;
	String candidateCertifiedResponse;
	String totalTrainingPartnersResponse;
	String totalTrainingCentreResponse;
	String candidatesAssessedInPmkvy;
	String shareContactDetails;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VoiceIntentController.class);
	
	@ForIntent("ShareBrochure")
	public ActionResponse shareBrochure(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		String receiverEmail = (String) request.getParameter("email");
		receiverEmail=receiverEmail.replaceAll("\\s+","");
		shareBrochureResponse= shareBrochureService.shareBrochureOverMail(receiverEmail);
		responseBuilder.add(shareBrochureResponse);
		return responseBuilder.build();
	}
	
	@ForIntent("ShareContactDetails")
	public ActionResponse shareContactDetails(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		
		String receiverNumber = (String) request.getParameter("phone-number");
		LOGGER.debug("Actual number"+receiverNumber);
		int lengthOfContactNumber = receiverNumber.length();
		LOGGER.debug("length of number is "+lengthOfContactNumber);
		if(lengthOfContactNumber<10 || lengthOfContactNumber>10) {
			LOGGER.debug("Passcode is not of digits");
			shareContactDetails="Can only use 10 digits of phone number. Can you please try again?";
		}
		else {
			shareContactDetails= shareContactDetailsService.shareContactDetailsOverText(receiverNumber);
		}
		
		responseBuilder.add(shareContactDetails);
		return responseBuilder.build();
	}
	
	@ForIntent("CandidatesEnrolled")
	public ActionResponse candidatesEnrolled(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		int numberOfCandidateEnrolled = dashboardService.getTotalCandidatesEnrolled();
		candidateEnrolledResponse="There are "+numberOfCandidateEnrolled+" candidates enrolled by Skill Council for Green Jobs. Do you want to know something else?";
		responseBuilder.add(candidateEnrolledResponse);
		return responseBuilder.build();
	}
	
	@ForIntent("CandidatesCertified")
	public ActionResponse candidatesCertified(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		int candidateCertified= dashboardService.getTotalCandidatesCertified();
		candidateCertifiedResponse="Total number of candidates certified are "+candidateCertified+". What else would you like to know";
		responseBuilder.add(candidateCertifiedResponse);
		return responseBuilder.build();
	}
	
	@ForIntent("TotalTC")
	public ActionResponse statewithMaximumTC(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		int totalTrainingCenter=dashboardService.getTotalTrainingCentersInIndia();
		totalTrainingCentreResponse=totalTrainingCenter+", There are total "+totalTrainingCenter+" training centers working with Skill Council for Green Jobs. Would you like to ask something else?";
		responseBuilder.add(totalTrainingCentreResponse);
		return responseBuilder.build();
	}
	
	@ForIntent("CandidatesAssessedPMKVY")
	public ActionResponse candidatesAssessedinPmkvy(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		int noofcandidate=webhookFAQService.noOfAssessedCandidatesPmkvy();
		candidatesAssessedInPmkvy="Under scheme of PMKVY, there are total "+noofcandidate+" candidates assessed by SCGJ. Would you like to know something else?";
		responseBuilder.add(candidatesAssessedInPmkvy);
		return responseBuilder.build();
	}
	
	@ForIntent("TotalTrainingPartners")
	public ActionResponse totalTrainingPartners(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		int totalTrainingPartner = dashboardService.getTotalTrainingPartners();
		totalTrainingPartnersResponse= "There are "+totalTrainingPartner+" training partners affiliated by Skill Council for Green jobs. Can I tell you something else?";
		responseBuilder.add(totalTrainingPartnersResponse);
		return responseBuilder.build();
	}

}
