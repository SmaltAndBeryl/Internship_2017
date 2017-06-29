package com.skill.India.dto;

import java.sql.Date;

import com.skill.India.common.BaseDto;


	public class ManageRegistrationDto extends BaseDto{
	    private static final long serialVersionUID = 1L;

	    private final Integer app_id;
	    private final String app_state;
	    private final Integer user_id;
	    private final Boolean active_flag;
	    private final Date date_now;
	   
	    
	    
	    
	    
	    


	    public  ManageRegistrationDto(Integer app_id, String  app_state, Integer user_id, Boolean active_flag, Date date_now) {
	        super();
	        this.app_id = app_id;
	        this.app_state = app_state;
	        this.user_id= user_id;
	        this.active_flag = active_flag;
	        this.date_now = date_now;
	        
	       
	        
	        
	    }

	    public Integer getS_no() {
	        return app_id;
	        
	    }

	    
	    public String getInstitution_name() {
	        return app_state;
	    }
	    
	    public Integer getType() {
	        return user_id;
	    }
	    
	    public Boolean getLocation() {
	        return active_flag;
	    }
	    
	    public Date getDate() {
	        return date_now;
	    }
	    
	    
	    	    
	}
