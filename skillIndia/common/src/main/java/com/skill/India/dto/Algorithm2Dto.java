package com.skill.India.dto;

/**
 * Created by Alkesh srivastav on 7/18/2017.
 */
public class Algorithm2Dto {
    public final int agencyId;
    public final int batchId;
    public final String agencyName;


    public Algorithm2Dto(int agencyId, int batchId, String agencyName) {
        this.agencyId = agencyId;
        this.batchId = batchId;
        this.agencyName = agencyName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public int getBatchId() {
        return batchId;
    }

}
