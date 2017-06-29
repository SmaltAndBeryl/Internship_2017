package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class DownloadExcelDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	
	private final String CSVLocation;
	
	public DownloadExcelDto(String CSVLocation)
	{
		super();
		this.CSVLocation=CSVLocation;
	}
	
	public String getCSVLocation() {
        return CSVLocation;
        
    }
}
