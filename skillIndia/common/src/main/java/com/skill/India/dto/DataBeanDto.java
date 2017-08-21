package com.skill.India.dto;

import org.slf4j.LoggerFactory;

/**
 * Created by Alkesh on 7/13/2017.
 */
public class DataBeanDto {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataBeanDto.class);
    private final String totalCenters;
    private final String officeStaffP;
    private final String officeStaffT;
    private final String labAttendantsP;
    private final String labAttendantsT;
    private final String accountantsP;
    private final String accountantsT;
    private final String supportStaffP;
    private final String supportStaffT;
    private final String othersP;
    private final String othersT;
    private final String areaOfInstitute;
    private final String sizeOfClassRoom;
    private final String sizeOfLabs;
    private final String numberOfLabs;
    private final String sizeOfWorkshops;
    private final String numberOfWorkshops;
    private final String presenceOfToolkit;
    private final String safeDrinkingWater;
    private final String separateToilet;
    private final String transportFacility;
    private final String presenceOfLibrary;
    private final String isIlluminationSufficient;
    private final String isVentilated;
    private final String cleanLiness;
    private final String weatherProtected;
    private final String printedBrochure;
    private final String documentedPolicy;
    private final String concessionsPolicy;
    private final String safeCustodyOfDocuments;
    private final String studentAgreement;
    private final String yearOfEstablishment;
    private final String mediumOfInstructions;
    private final String mobileNo;
    private final String PAN;
    private final String TAN;
    private final String turnover;
    private final String yearOfRecognition;
    private final String website;
    private final String PINcode;
    private final String district;
    private final String landlineNumber;
    private final String faxNumber;
    private final String validityOfRecognition;
    private final String isNSDCfunded;
    private final String applicationId;
    private final String trainingPartnerName;
    private final String emailId;

    public DataBeanDto(String centers, String staffP, String staffT, String attendantsP, String totalCenters, String officeStaffP, String officeStaffT, String labAttendantsP, String labAttendantsT, String accountantsP, String accountantsT, String supportStaffP, String supportStaffT, String othersP, String othersT, String areaOfInstitute, String sizeOfClassRoom, String sizeOfLabs, String numberOfLabs, String sizeOfWorkshops, String numberOfWorkshops, String presenceOfToolkit, String safeDrinkingWater, String separateToilet, String transportFacility, String presenceOfLibrary, String isIlluminationSufficient, String isVentilated, String cleanLiness, String weatherProtected, String printedBrochure, String documentedPolicy, String concessionsPolicy, String safeCustodyOfDocuments, String studentAgreement, String yearOfEstablishment, String mediumOfInstructions, String mobileNo, String pan, String tan, String turnover, String yearOfRecognition, String website, String piNcode, String district, String landlineNumber, String faxNumber, String validityOfRecognition, String isNSDCfunded, String applicationId, String trainingPartnerName, String emailId) {
        this.totalCenters = totalCenters;
        this.officeStaffP = officeStaffP;
        this.officeStaffT = officeStaffT;
        this.labAttendantsP = labAttendantsP;
        this.labAttendantsT = labAttendantsT;
        this.accountantsP = accountantsP;
        this.accountantsT = accountantsT;
        this.supportStaffP = supportStaffP;
        this.supportStaffT = supportStaffT;
        this.othersP = othersP;
        this.othersT = othersT;
        this.areaOfInstitute = areaOfInstitute;
        this.sizeOfClassRoom = sizeOfClassRoom;
        this.sizeOfLabs = sizeOfLabs;
        this.numberOfLabs = numberOfLabs;
        this.sizeOfWorkshops = sizeOfWorkshops;
        this.numberOfWorkshops = numberOfWorkshops;
        this.presenceOfToolkit = presenceOfToolkit;
        this.safeDrinkingWater = safeDrinkingWater;
        this.separateToilet = separateToilet;
        this.transportFacility = transportFacility;
        this.presenceOfLibrary = presenceOfLibrary;
        this.isIlluminationSufficient = isIlluminationSufficient;
        this.isVentilated = isVentilated;
        this.cleanLiness = cleanLiness;
        this.weatherProtected = weatherProtected;
        this.printedBrochure = printedBrochure;
        this.documentedPolicy = documentedPolicy;
        this.concessionsPolicy = concessionsPolicy;
        this.safeCustodyOfDocuments = safeCustodyOfDocuments;
        this.studentAgreement = studentAgreement;
        this.yearOfEstablishment = yearOfEstablishment;
        this.mediumOfInstructions = mediumOfInstructions;
        this.mobileNo = mobileNo;
        this.PAN = pan;
        this.TAN = tan;
        this.turnover = turnover;
        this.yearOfRecognition = yearOfRecognition;
        this.website = website;
        this.PINcode = piNcode;
        this.district = district;
        this.landlineNumber = landlineNumber;
        this.faxNumber = faxNumber;
        this.validityOfRecognition = validityOfRecognition;
        this.isNSDCfunded = isNSDCfunded;
        this.applicationId = applicationId;
        this.trainingPartnerName = trainingPartnerName;
        this.emailId = emailId;
    }

    public String getTotalCenters() {
        return totalCenters;
    }

    public String getOfficeStaffP() {
        return officeStaffP;
    }

    public String getOfficeStaffT() {
        return officeStaffT;
    }

    public String getLabAttendantsP() {
        return labAttendantsP;
    }

    public String getLabAttendantsT() {
        return labAttendantsT;
    }

    public String getAccountantsP() {
        return accountantsP;
    }

    public String getAccountantsT() {
        return accountantsT;
    }

    public String getSupportStaffP() {
        return supportStaffP;
    }

    public String getSupportStaffT() {
        return supportStaffT;
    }

    public String getOthersP() {
        return othersP;
    }

    public String getOthersT() {
        return othersT;
    }

    public String getAreaOfInstitute() {
        return areaOfInstitute;
    }

    public String getSizeOfClassRoom() {
        return sizeOfClassRoom;
    }

    public String getSizeOfLabs() {
        return sizeOfLabs;
    }

    public String getNumberOfLabs() {
        return numberOfLabs;
    }

    public String getSizeOfWorkshops() {
        return sizeOfWorkshops;
    }

    public String getNumberOfWorkshops() {
        return numberOfWorkshops;
    }

    public String getPresenceOfToolkit() {
        return presenceOfToolkit;
    }

    public String getSafeDrinkingWater() {
        return safeDrinkingWater;
    }

    public String getSeparateToilet() {
        return separateToilet;
    }

    public String getTransportFacility() {
        return transportFacility;
    }

    public String getPresenceOfLibrary() {
        return presenceOfLibrary;
    }

    public String getIsIlluminationSufficient() {
        return isIlluminationSufficient;
    }

    public String getIsVentilated() {
        return isVentilated;
    }

    public String getCleanLiness() {
        return cleanLiness;
    }

    public String getWeatherProtected() {
        return weatherProtected;
    }

    public String getPrintedBrochure() {
        return printedBrochure;
    }

    public String getDocumentedPolicy() {
        return documentedPolicy;
    }

    public String getConcessionsPolicy() {
        return concessionsPolicy;
    }

    public String getSafeCustodyOfDocuments() {
        return safeCustodyOfDocuments;
    }

    public String getStudentAgreement() {
        return studentAgreement;
    }

    public String getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public String getMediumOfInstructions() {
        return mediumOfInstructions;
    }

    public String getMobileNo() {
        return mobileNo;
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

    public String getYearOfRecognition() {
        return yearOfRecognition;
    }

    public String getWebsite() {
        return website;
    }

    public String getPINcode() {
        return PINcode;
    }

    public String getDistrict() {
        return district;
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getValidityOfRecognition() {
        return validityOfRecognition;
    }

    public String getIsNSDCfunded() {
        return isNSDCfunded;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getTrainingPartnerName() {
        return trainingPartnerName;
    }

    public String getEmailId() {
        return emailId;
    }
}


