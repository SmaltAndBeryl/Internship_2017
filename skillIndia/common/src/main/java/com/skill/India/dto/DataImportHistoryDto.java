package com.skill.India.dto;

import java.sql.Date;

import com.skill.India.common.BaseDto;

public class DataImportHistoryDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private final Integer SerialNo;
	
	private final String CSVName ;

	private final String CSVType;

	private final Date CSV_Upload_Date;
	
	private final String CSV_Upload_UserId;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the serialNo
	 */
	public Integer getSerialNo() {
		return SerialNo;
	}

	/**
	 * @return the cSVName
	 */
	public String getCSVName() {
		return CSVName;
	}

	/**
	 * @return the cSVType
	 */
	public String getCSVType() {
		return CSVType;
	}

	/**
	 * @return the cSV_Upload_Date
	 */
	public Date getCSV_Upload_Date() {
		return CSV_Upload_Date;
	}

	/**
	 * @return the cSV_Upload_UserId
	 */
	public String getCSV_Upload_UserId() {
		return CSV_Upload_UserId;
	}

	public DataImportHistoryDto(Integer serialNo, String cSVName,
			String cSVType, Date cSV_Upload_Date, String cSV_Upload_UserId) {
		super();
		SerialNo = serialNo;
		CSVName = cSVName;
		CSVType = cSVType;
		CSV_Upload_Date = cSV_Upload_Date;
		CSV_Upload_UserId = cSV_Upload_UserId;
	}
	
	

}