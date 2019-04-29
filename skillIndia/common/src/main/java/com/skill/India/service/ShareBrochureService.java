package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.common.ReadResponseMessages;
import com.skill.India.common.SendMailUtility;

@Service
public class ShareBrochureService {
	
	@Autowired
	private SendMailUtility sendMailUtility;
	
	@Autowired
	private ReadResponseMessages readResponseMessages;
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	public String shareBrochureOverMail(String receivermail) {
		
		String emailMessage=null;
		emailMessage="<font color=darkblue>Hi,<br><br>";
		emailMessage += "Please find attached SCGJ Brochure.<br>";
		emailMessage+="Know more about us by saying - Ok google, talk to <b>Skill Council for Green Jobs Voice Portal</b>";
		emailMessage += "<br><br>Have a nice day.<br><br>From,</font><br>";
		emailMessage += "<font color=#c14b7a><b>SCGJ Voice Portal</b></font>";
		
		int mailStatus = sendMailUtility.sendInformationOverMail(receivermail,readApplicationConstants.getPathtobrochure(), emailMessage);
		if(mailStatus==0) {
			return readResponseMessages.getMailFailed();
		}
		else {
			return readResponseMessages.getMailSuccessful();
		}
	}

}
