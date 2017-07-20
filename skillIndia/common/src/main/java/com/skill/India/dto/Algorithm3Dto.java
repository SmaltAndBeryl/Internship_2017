package com.skill.India.dto;

/**
 * Created by Alkesh srivastav on 7/18/2017.
 */

public class Algorithm3Dto {
    public final String state;
    public final String district;
    public final String agencyName;

    public Algorithm3Dto(String state, String district, String agencyName) {
        this.state = state;
        this.district = district;
        this.agencyName = agencyName;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getAgencyName() {
        return agencyName;
    }
}
