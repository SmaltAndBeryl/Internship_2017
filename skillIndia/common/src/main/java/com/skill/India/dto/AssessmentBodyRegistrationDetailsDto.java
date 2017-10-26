package com.skill.India.dto;

public class AssessmentBodyRegistrationDetailsDto {
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
    private final String yearOfEstablishment;
    private final String priorAssessmentExperience;
    private final String panNumber;
    private final String tanNumber;
    private final String insituteReceivedAnyRecognition;
//    private final String NameOfRecognitionBody;
//    private final String RecognitionNumber;
//    private final String yearOfRecognition;
//    private final String validityOfRecognition;

    private final String affiliatedToAnySectorSkillCouncil;

    private final String numberOfTechnicalAssessors;
    private final String numberOfNonTechnicalAssessors;

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
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

    public String getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public String getPriorAssessmentExperience() {
        return priorAssessmentExperience;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public String getTanNumber() {
        return tanNumber;
    }

    public String getInsituteReceivedAnyRecognition() {
        return insituteReceivedAnyRecognition;
    }

//    public String getNameOfRecognitionBody() {
//        return NameOfRecognitionBody;
//    }
//
//    public String getRecognitionNumber() {
//        return RecognitionNumber;
//    }
//
//    public String getYearOfRecognition() {
//        return yearOfRecognition;
//    }
//
//    public String getValidityOfRecognition() {
//        return validityOfRecognition;
//    }

    public String getAffiliatedToAnySectorSkillCouncil() {
        return affiliatedToAnySectorSkillCouncil;
    }

    public String getNumberOfTechnicalAssessors() {
        return numberOfTechnicalAssessors;
    }

    public String getNumberOfNonTechnicalAssessors() {
        return numberOfNonTechnicalAssessors;
    }

    public AssessmentBodyRegistrationDetailsDto(String organizationName, String address, String city, String state, String pincode, String sPOCName, String mobileNumber, String alternateMobileNumber, String landlineNumber, String alternateLandlineNumber, String faxNumber, String websites, String yearOfEstablishment, String priorAssessmentExperience, String panNumber, String tanNumber, String insituteReceivedAnyRecognition, String affiliatedToAnySectorSkillCouncil, String numberOfTechnicalAssessors, String numberOfNonTechnicalAssessors) {

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

        this.yearOfEstablishment = yearOfEstablishment;
        this.priorAssessmentExperience = priorAssessmentExperience;
        this.panNumber = panNumber;
        this.tanNumber = tanNumber;
        this.insituteReceivedAnyRecognition = insituteReceivedAnyRecognition;
//        this.NameOfRecognitionBody = NameOfRecognitionBody;
//        this.RecognitionNumber = RecognitionNumber;
//        this.yearOfRecognition = yearOfRecognition;
//        this.validityOfRecognition = validityOfRecognition;

        this.affiliatedToAnySectorSkillCouncil = affiliatedToAnySectorSkillCouncil;

        this.numberOfTechnicalAssessors = numberOfTechnicalAssessors;
        this.numberOfNonTechnicalAssessors = numberOfNonTechnicalAssessors;

    }
}
