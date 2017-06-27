package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class DownloadExcelDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	
	private final String CSVLocation;
	
	public DownloadExcelDto(String CSV_Location)
	{
		super();
		this.CSVLocation=CSV_Location;
	}
	
	public String getCSV_Location() {
        return CSVLocation;
        
    }
}
