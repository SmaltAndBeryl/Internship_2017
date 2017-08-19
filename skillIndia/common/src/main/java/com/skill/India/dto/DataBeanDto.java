package com.skill.India.dto;

import org.slf4j.LoggerFactory;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
public class DataBeanDto {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataBeanDto.class);
    private final String trainingPartnerName;
    private final String emailId;
    private final String district;
    private final String state;


    public DataBeanDto(String trainingPartnerName, String emailId, String district, String state) {
        this.trainingPartnerName = trainingPartnerName;
        this.emailId = emailId;
        this.district = district;
        this.state = state;
    }
    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }
    public String getTrainingPartnerName() {
        return trainingPartnerName;
    }

    public String getEmailId() {
        return emailId;
    }
}

