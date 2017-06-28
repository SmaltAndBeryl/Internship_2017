package com.skill.India.dto;

import java.sql.Date;



import com.skill.India.common.BaseDto;

public class ApproveRejectTableDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;

	private Integer serial_no;
	
	private final String institution_name ;

	private final String type;

	private final Date date;

	
	
	
	public ApproveRejectTableDto (Integer serial_no, String institution_name, String type, Date date) {
		super();
		this.serial_no = serial_no;
		this.institution_name = institution_name;
		this.type = type;
		this.date = date;
	}

	public Integer getSerial_no() {
		return serial_no;
	}

	public String getInstitution_name() {
		return institution_name;
	}

	public String getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}


}
