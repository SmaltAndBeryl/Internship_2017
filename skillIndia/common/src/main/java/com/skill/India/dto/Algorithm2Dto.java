package com.skill.India.dto;

/**
 * Created by Alkesh srivastav on 7/18/2017.
 */
public class Algorithm2Dto {
    public final int agencyId;
    public final String state;
    public final String district;

    public int getAgencyId() {
        return agencyId;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public Algorithm2Dto(int agencyId, String state, String district) {
        this.agencyId = agencyId;
        this.state = state;
        this.district = district;
    }


}
