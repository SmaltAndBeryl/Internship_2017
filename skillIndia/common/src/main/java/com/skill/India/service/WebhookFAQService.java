package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.WebhookFAQDao;

@Service
public class WebhookFAQService {

	@Autowired
	private WebhookFAQDao webhookFAQDao;
	
	public int noOfAssessedCandidatesPmkvy() {
		return webhookFAQDao.numberOfAssessedPmkvyCandidates();
	}
}
