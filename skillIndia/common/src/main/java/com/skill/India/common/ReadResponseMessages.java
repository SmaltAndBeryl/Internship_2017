package com.skill.India.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:applicationReadResponses.properties")
@ConfigurationProperties
public class ReadResponseMessages {
	
	private String mailFailed;
	private String mailSuccessful;
	/**
	 * @return the mailFailed
	 */
	public String getMailFailed() {
		return mailFailed;
	}
	/**
	 * @param mailFailed the mailFailed to set
	 */
	public void setMailFailed(String mailFailed) {
		this.mailFailed = mailFailed;
	}
	/**
	 * @return the mailSuccessful
	 */
	public String getMailSuccessful() {
		return mailSuccessful;
	}
	/**
	 * @param mailSuccessful the mailSuccessful to set
	 */
	public void setMailSuccessful(String mailSuccessful) {
		this.mailSuccessful = mailSuccessful;
	}
	
	

}
