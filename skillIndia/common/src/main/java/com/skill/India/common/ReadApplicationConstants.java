package com.skill.India.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:applicationConstants.properties")
@ConfigurationProperties
	public class ReadApplicationConstants {

	   
	   private String saveCSVAtLocation;
	   private String saveCertificateAtLocation;
	   

	/**
	 * @return the saveCertificateAtLocation
	 */
	public String getSaveCertificateAtLocation() {
		return saveCertificateAtLocation;
	}

	/**
	 * @param saveCertificateAtLocation the saveCertificateAtLocation to set
	 */
	public void setSaveCertificateAtLocation(String saveCertificateAtLocation) {
		this.saveCertificateAtLocation = saveCertificateAtLocation;
	}

	/**
	 * @return the saveCSVAtLocation
	 */
	public String getSaveCSVAtLocation() {
		return saveCSVAtLocation;
	}

	/**
	 * @param saveCSVAtLocation the saveCSVAtLocation to set
	 */
	public void setSaveCSVAtLocation(String saveCSVAtLocation) {
		this.saveCSVAtLocation = saveCSVAtLocation;
	}
	   
	   

 	}

