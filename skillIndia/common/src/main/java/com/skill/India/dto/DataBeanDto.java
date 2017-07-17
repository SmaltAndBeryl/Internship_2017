package com.skill.India.dto;

import org.slf4j.LoggerFactory;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
public class DataBeanDto {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataBeanDto.class);
    private final String trainingPartnerName;
    private final String isNSDCfunded;
    private final String firstName;
    private final String addressLine1;
    private final String faxNumber;
    private final String emailDirector;
    private final String website;
    private final String yearOfEstablishment;
    private final String priorExposureInSkill;
    private final String medium;
    private final String selfOwnedTC;
    private final String franchiseTC;
    private final String PAN;
    private final String TAN;
    private final String turnover;

    public DataBeanDto(String trainingPartnerName, String isNSDCfunded, String firstName, String addressLine1, String faxNumber, String emailDirector, String website, String yearOfEstablishment, String priorExposureInSkill, String medium, String selfOwnedTC, String franchiseTC, String pan, String tan, String turnover) {
        this.trainingPartnerName = trainingPartnerName;
        this.isNSDCfunded = isNSDCfunded;
        this.firstName = firstName;
        this.addressLine1 = addressLine1;
        this.faxNumber = faxNumber;
        this.emailDirector = emailDirector;
        this.website = website;
        this.yearOfEstablishment = yearOfEstablishment;
        this.priorExposureInSkill = priorExposureInSkill;
        this.medium = medium;
        this.selfOwnedTC = selfOwnedTC;
        this.franchiseTC = franchiseTC;
        //The pan and tan values have been changed
        this.PAN = pan;
        this.TAN = tan;
        this.turnover = turnover;
    }

    public String getTrainingPartnerName() {
        return trainingPartnerName;
    }

    public String getIsNSDCfunded() {
        return isNSDCfunded;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getEmailDirector() {
        return emailDirector;
    }

    public String getWebsite() {
        return website;
    }

    public String getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public String getPriorExposureInSkill() {
        return priorExposureInSkill;
    }

    public String getMedium() {
        return medium;
    }

    public String getSelfOwnedTC() {
        return selfOwnedTC;
    }

    public String getFranchiseTC() {
        return franchiseTC;
    }

    public String getPAN() {
        return PAN;
    }

    public String getTAN() {
        return TAN;
    }

    public String getTurnover() {
        return turnover;
    }


}

