/**
 * 
 */
package com.skill.India.dto;

import java.sql.Date;

import com.skill.India.common.BaseDto;

/**
 * @author Rachit-PC
 *
 */
public class CertificateImportHistorydto extends BaseDto {
private static final long serialVersionUID = 1L;
	
private final String batchID;

private final Date batchEndDate ;
 
private final String certificateName ;

private final Date certificateUploadDate;

private final String userId;

/**
 * @return the batchID
 */
public String getBatchID() {
	return batchID;
}

/**
 * @return the batchEndDate
 */
public Date getBatchEndDate() {
	return batchEndDate;
}


/**
 * @return the certificateName
 */
public String getCertificateName() {
	return certificateName;
}

/**
 * @return the certificateUploadDate
 */
public Date getCertificateUploadDate() {
	return certificateUploadDate;
}

/**
 * @return the userId
 */
public String getUserId() {
	return userId;
}

/**
 * @param batchID
 * @param certificateName
 * @param certificateUploadDate
 * @param userId
 */
public CertificateImportHistorydto(String batchID, Date batchEndDate ,String certificateName, Date certificateUploadDate,
		String userId) {
	super();
	this.batchID = batchID;
	this.batchEndDate = batchEndDate;
	this.certificateName = certificateName;
	this.certificateUploadDate = certificateUploadDate;
	this.userId = userId;
}

}


