package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.SendTextMessageUtility;

@Service
public class ShareContactDetailsService {

	@Autowired
	private SendTextMessageUtility sendTextMessageUtility;
	
	
	String phoneMessage="SCGJ contact number : 011-41792866. To fix up a meeting, connect at: info@sscgj.in";
	
	public String shareContactDetailsOverText(String receiverNumber) {
		int sendTextStatus = sendTextMessageUtility.sendTextMessage(receiverNumber, phoneMessage);
		if(sendTextStatus==1) {
			return "Done. I have shared the contact details via text message, check it out. What else would you like to know?";
		}
		else {
			return "Oh! I am sorry, I couldn't connect to the internet. Please try again.";
		}
		
	}
}
