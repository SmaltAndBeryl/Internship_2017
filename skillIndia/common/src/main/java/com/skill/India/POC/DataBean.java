package com.skill.India.POC;

import com.skill.India.common.BaseDto;

/**
 * Created by Alkesh srivastav on 7/6/2017.
 */
public class DataBean{


    private String trainingPartnerName;
    private String emailId;
    private String district;
    private String state;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTrainingPartnerName() {
        return trainingPartnerName;
    }

    public void setTrainingPartnerName(String trainingPartnerName) {
        this.trainingPartnerName = trainingPartnerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
