package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="voicewebhooksql",locations="classpath:sql/voiceWebhook.yml")
public class WebhookFAQConfig {

	private String candidatesAssessedPmkvy;

	/**
	 * @return the candidatesAssessedPmkvy
	 */
	public String getCandidatesAssessedPmkvy() {
		return candidatesAssessedPmkvy;
	}

	/**
	 * @param candidatesAssessedPmkvy the candidatesAssessedPmkvy to set
	 */
	public void setCandidatesAssessedPmkvy(String candidatesAssessedPmkvy) {
		this.candidatesAssessedPmkvy = candidatesAssessedPmkvy;
	}
	
}
