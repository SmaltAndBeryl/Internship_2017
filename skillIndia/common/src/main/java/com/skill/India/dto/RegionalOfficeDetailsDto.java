package com.skill.India.dto;

public class RegionalOfficeDetailsDto {
    private final String regionalOfficeId;
    private final String address;
    private final String state;
    private final String pincode;
    private final String contactNumber;
    private final String alternateContactNumber;

    public RegionalOfficeDetailsDto(String regionalOfficeId, String address, String state, String pincode, String contactNumber, String alternateContactNumber) {

        this.regionalOfficeId = regionalOfficeId;
        this.address = address;
        this.state = state;
        this.pincode = pincode;
        this.contactNumber = contactNumber;
        this.alternateContactNumber = alternateContactNumber;
    }

    public String getRegionalOfficeId() {
        return regionalOfficeId;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }
}
