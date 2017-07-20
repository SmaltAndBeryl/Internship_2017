package com.skill.India.dto;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
public class DropdownDto {
    private final String agencyName;
    private final String agencyId;

    public String getAgencyName() {
        return agencyName;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public DropdownDto(String agencyName, String agencyId) {
        super();
        this.agencyName = agencyName;
        this.agencyId = agencyId;
    }
}
