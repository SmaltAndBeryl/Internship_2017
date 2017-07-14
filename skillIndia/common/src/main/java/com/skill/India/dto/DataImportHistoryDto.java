package com.skill.India.dto;

import java.sql.Date;

import com.skill.India.common.BaseDto;

public class DataImportHistoryDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	
	private final String csvName ;

	private final String csvType;

	private final Date csvUploadDate;
	
	private final String csvUploadUserId;

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getCSVName() {
		return csvName;
	}

	public String getCSVType() {
		return csvType;
	}

	
	public Date getCSV_Upload_Date() {
		return csvUploadDate;
	}


	public String getCSV_Upload_UserId() {
		return csvUploadUserId;
	}

	public DataImportHistoryDto(String cSVName,String cSVType, Date cSV_Upload_Date, String cSV_Upload_UserId) {
		super();
		csvName = cSVName;
		csvType = cSVType;
		csvUploadDate =cSV_Upload_Date;
		csvUploadUserId = cSV_Upload_UserId;
	}
	
	

}