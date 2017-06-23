package com.skill.India.dto;

import com.skill.India.common.BaseDto;


public class AssessmentBodyUpcomingBatchDto extends BaseDto{
    private static final long serialVersionUID = 1L;

    private final String batch_id;
    private final String ab_name;
    private final String email;
    private final Integer contact_no;
    private final String assessment_date;
    private final String district;
    private final String state;
    private final String no_of_candidate;
    
    
    
    
    


    public AssessmentBodyUpcomingBatchDto(String batch_id, String ab_name, String email, Integer contact_no, String assessment_date, String district, String state, String no_of_candidate) {
        super();
        this.batch_id = batch_id;
        this.ab_name = ab_name;
        this.email = email;
        this.contact_no = contact_no;
        this.assessment_date = assessment_date;
        this.district = district;
        this.state = state;
        this.no_of_candidate = no_of_candidate;
        
        
    }

    public String getBatch_id() {
        return batch_id;
        
    }

    
    public String getAb_name() {
        return ab_name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Integer getContact_no() {
        return contact_no;
    }
    
    public String getAssessment_date() {
        return assessment_date;
    }
    
    public String getDistrict() {
        return district;
    }
    
    
    public String getState() {
        return state;
    }
    
    public String getNo_of_candidate() {
        return no_of_candidate;
    }
    
}