package com.skill.India.dto;

import org.slf4j.LoggerFactory;

/**
 * Created by Alkesh on 7/13/2017.
 */
public class DataBeanDto {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataBeanDto.class);

    private final String organizationName;
    private final String address;
    private final String city;
    private final String state;
    private final String pincode;
    private final String sPOCName;
    private final String mobileNumber;
    private final String alternateMobileNumber;
    private final String landlineNumber;
    private final String alternateLandlineNumber;
    private final String faxNumber;
    private final String websites;

    //Organization Level Details
    private final String yearOfEstablishment;
    private final String qualificationPacks;
    private final String nSDCFunded;
    private final String mediumOfInstructions;
    private final String selfOwnedInstitution;
    private final String franchiseOwnedInstitution;
    private final String mobileTrainingInstitution;
    private final String panNumber;
    private final String tanNumber;
    private final String turnOverOfInstitution;
    private final String instituteReceivedAnyGrant;
    private final String instituteReceivedAnyRecognition;
    private final String priorExperienceOfInstitutionInSkillDevelopment;
    private final String anyPriorExperienceOfInstitutionInSkillTraining;



    public String getOrganizationName() {
        return organizationName;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public String getsPOCName() {
        return sPOCName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAlternateMobileNumber() {
        return alternateMobileNumber;
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public String getAlternateLandlineNumber() {
        return alternateLandlineNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getWebsites() {
        return websites;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    //Organization level details


    public String getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public String getQualificationPacks() {
        return qualificationPacks;
    }

    public String getnSDCFunded() {
        return nSDCFunded;
    }

    public String getMediumOfInstructions() {
        return mediumOfInstructions;
    }

    public String getSelfOwnedInstitution() {
        return selfOwnedInstitution;
    }

    public String getFranchiseOwnedInstitution() {
        return franchiseOwnedInstitution;
    }

    public String getMobileTrainingInstitution() {
        return mobileTrainingInstitution;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public String getTanNumber() {
        return tanNumber;
    }

    public String getTurnOverOfInstitution() {
        return turnOverOfInstitution;
    }

    public String getInstituteReceivedAnyGrant() {
        return instituteReceivedAnyGrant;
    }

    public String getInstituteReceivedAnyRecognition() {
        return instituteReceivedAnyRecognition;
    }

    public String getPriorExperienceOfInstitutionInSkillDevelopment() {
        return priorExperienceOfInstitutionInSkillDevelopment;
    }

    public String getAnyPriorExperienceOfInstitutionInSkillTraining() {
        return anyPriorExperienceOfInstitutionInSkillTraining;
    }

    public DataBeanDto(String organizationName, String address, String city, String state, String pincode, String sPOCName, String mobileNumber, String alternateMobileNumber, String landlineNumber, String alternateLandlineNumber, String faxNumber, String websites, String yearOfEstablishment, String qualificationPacks, String nSDCFunded, String mediumOfInstructions, String selfOwnedInstitution, String franchiseOwnedInstitution, String mobileTrainingInstitution, String panNumber, String tanNumber, String turnOverOfInstitution, String instituteReceivedAnyGrant, String instituteReceivedAnyRecognition, String priorExperienceOfInstitutionInSkillDevelopment, String anyPriorExperienceOfInstitutionInSkillTraining) {
        this.organizationName = organizationName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.sPOCName = sPOCName;
        this.mobileNumber = mobileNumber;
        this.alternateMobileNumber = alternateMobileNumber;
        this.landlineNumber = landlineNumber;
        this.alternateLandlineNumber = alternateLandlineNumber;
        this.faxNumber = faxNumber;
        this.websites = websites;

        //Organization Level Details
        this.yearOfEstablishment = yearOfEstablishment;
        this.qualificationPacks = qualificationPacks;
        this.nSDCFunded = nSDCFunded;
        this.mediumOfInstructions = mediumOfInstructions;
        this.selfOwnedInstitution = selfOwnedInstitution;
        this.franchiseOwnedInstitution = franchiseOwnedInstitution;
        this.mobileTrainingInstitution = mobileTrainingInstitution;
        this.panNumber = panNumber;
        this.tanNumber = tanNumber;
        this.turnOverOfInstitution = turnOverOfInstitution;
        this.instituteReceivedAnyGrant = instituteReceivedAnyGrant;
        this.instituteReceivedAnyRecognition = instituteReceivedAnyRecognition;
        this.priorExperienceOfInstitutionInSkillDevelopment = priorExperienceOfInstitutionInSkillDevelopment;
        this.anyPriorExperienceOfInstitutionInSkillTraining = anyPriorExperienceOfInstitutionInSkillTraining;
    }
}


