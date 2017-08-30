package com.skill.India.dto;

public class CenterLevelDto {
    private final String nameOfCenter;
    private final String numberOfPermanentOfficeManager;
    private final String numberOftemporaryOfficeManager;
    private final String numberOfPermanentOfficeStaff;
    private final String numberOfTemporaryOfficeStaff;
    private final String numberOfPermanentLabAssistants;
    private final String numberOfTemporaryLabAssistants;
    private final String numberOfPermanentAccountants;
    private final String numberOfTemporaryAccountants;
    private final String numberOfPermanentSupportStaff;
    private final String numberOfTemporarySupportStaff;
    private final String numberOfPermanentOtherEmployees;
    private final String numberOfTemporaryOtherEmployees;


    private final String areaOfInstitute;
    private final String buildingType;
    private final String sizeOfClassrooms;
    private final String numberOfClassrooms;
    private final String sizeOfLabs;
    private final String numberOfLabs;
    private final String sizeOfWorkshops;
    private final String numberOfWorkshops;
    private final String mandatoryToolKitpresent;
    private final String safeDrinkingWater;
    private final String powerBackup;
    private final String separateToilets;
    private final String transportFacility;
    private final String presenceOfLibrary;
    private final String numberOfTechnicalBooks;
    private final String numberOfNonTechnicalBooks;
    private final String numberOfMagazines;
    private final String numberOfDailies;
    private final String remarksOnInfrastructureDetails;

    private final String sufficientClassroomIlluminationLevel;
    private final String sufficientClassroomVentilationLevel;
    private final String sufficientCenterCleanliness;
    private final String centerWeatherProtected;
    private final String remarksOnLearningEnviornment;

    private final String printedBrochureOrProspectus;
    private final String documentedPolicyAndProcedures;
    private final String concessionPolicy;
    private final String safeCustodyOfStudentDocuments;
    private final String studentAgreementWithInstitution;
    private final String remarksOnStudentAdmissionDetails ;

    public CenterLevelDto(String nameOfCenter,
                          String numberOfPermanentOfficeManager,
                          String numberOftemporaryOfficeManager,
                          String numberOfPermanentOfficeStaff,
                          String numberOfTemporaryOfficeStaff,
                          String numberOfPermanentLabAssistants,
                          String numberOfTemporaryLabAssistants,
                          String numberOfPermanentAccountants,
                          String numberOfTemporaryAccountants,
                          String numberOfPermanentSupportStaff,
                          String numberOfTemporarySupportStaff,
                          String numberOfPermanentOtherEmployees,
                          String numberOfTemporaryOtherEmployees,

                          String areaOfInstitute,
                          String buildingType,
                          String sizeOfClassrooms,
                          String numberOfClassrooms,
                          String sizeOfLabs,
                          String numberOfLabs,
                          String sizeOfWorkshops,
                          String numberOfWorkshops,
                          String mandatoryToolKitpresent,
                          String safeDrinkingWater,
                          String powerBackup,
                          String separateToilets,
                          String transportFacility,
                          String presenceOfLibrary,
                          String numberOfTechnicalBooks,
                          String numberOfNonTechnicalBooks,
                          String numberOfMagazines,
                          String numberOfDailies,
                          String remarksOnInfrastructureDetails,

                          String sufficientClassroomIlluminationLevel,
                          String sufficientClassroomVentilationLevel,
                          String sufficientCenterCleanliness,
                          String centerWeatherProtected,
                          String remarksOnLearningEnviornment,

                          String printedBrochureOrProspectus,
                          String documentedPolicyAndProcedures,
                          String concessionPolicy,
                          String safeCustodyOfStudentDocuments,
                          String studentAgreementWithInstitution,
                          String remarksOnStudentAdmissionDetails) {
        this.nameOfCenter = nameOfCenter;
        this.numberOfPermanentOfficeManager = numberOfPermanentOfficeManager;
        this.numberOftemporaryOfficeManager = numberOftemporaryOfficeManager;
        this.numberOfPermanentOfficeStaff = numberOfPermanentOfficeStaff;
        this.numberOfTemporaryOfficeStaff = numberOfTemporaryOfficeStaff;
        this.numberOfPermanentLabAssistants = numberOfPermanentLabAssistants;
        this.numberOfTemporaryLabAssistants = numberOfTemporaryLabAssistants;
        this.numberOfPermanentAccountants = numberOfPermanentAccountants;
        this.numberOfTemporaryAccountants = numberOfTemporaryAccountants;
        this.numberOfPermanentSupportStaff = numberOfPermanentSupportStaff;
        this.numberOfTemporarySupportStaff = numberOfTemporarySupportStaff;
        this.numberOfPermanentOtherEmployees = numberOfPermanentOtherEmployees;
        this.numberOfTemporaryOtherEmployees = numberOfTemporaryOtherEmployees;

        this.areaOfInstitute = areaOfInstitute;
        this.buildingType = buildingType;
        this.sizeOfClassrooms = sizeOfClassrooms;
        this.numberOfClassrooms = numberOfClassrooms;
        this.sizeOfLabs = sizeOfLabs;
        this.numberOfLabs = numberOfLabs;
        this.sizeOfWorkshops = sizeOfWorkshops;
        this.numberOfWorkshops = numberOfWorkshops;
        this.mandatoryToolKitpresent = mandatoryToolKitpresent;
        this.safeDrinkingWater = safeDrinkingWater;
        this.powerBackup = powerBackup;
        this.separateToilets = separateToilets;
        this.transportFacility = transportFacility;
        this.presenceOfLibrary = presenceOfLibrary;
        this.numberOfTechnicalBooks = numberOfTechnicalBooks;
        this.numberOfNonTechnicalBooks = numberOfNonTechnicalBooks;
        this.numberOfMagazines = numberOfMagazines;
        this.numberOfDailies = numberOfDailies;
        this.remarksOnInfrastructureDetails = remarksOnInfrastructureDetails;

        this.sufficientClassroomIlluminationLevel = sufficientClassroomIlluminationLevel;
        this.sufficientClassroomVentilationLevel = sufficientClassroomVentilationLevel;
        this.sufficientCenterCleanliness = sufficientCenterCleanliness;
        this.centerWeatherProtected = centerWeatherProtected;
        this.remarksOnLearningEnviornment = remarksOnLearningEnviornment;

        this.printedBrochureOrProspectus = printedBrochureOrProspectus;
        this.documentedPolicyAndProcedures = documentedPolicyAndProcedures;
        this.concessionPolicy = concessionPolicy;
        this.safeCustodyOfStudentDocuments = safeCustodyOfStudentDocuments;
        this.studentAgreementWithInstitution = studentAgreementWithInstitution;
        this.remarksOnStudentAdmissionDetails = remarksOnStudentAdmissionDetails;

    }


    public String getNameOfCenter() {
        return nameOfCenter;
    }

    public String getNumberOfPermanentOfficeManager() {
        return numberOfPermanentOfficeManager;
    }

    public String getNumberOftemporaryOfficeManager() {
        return numberOftemporaryOfficeManager;
    }

    public String getNumberOfPermanentOfficeStaff() {
        return numberOfPermanentOfficeStaff;
    }

    public String getNumberOfTemporaryOfficeStaff() {
        return numberOfTemporaryOfficeStaff;
    }

    public String getNumberOfPermanentLabAssistants() {
        return numberOfPermanentLabAssistants;
    }

    public String getNumberOfTemporaryLabAssistants() {
        return numberOfTemporaryLabAssistants;
    }

    public String getNumberOfPermanentAccountants() {
        return numberOfPermanentAccountants;
    }

    public String getNumberOfTemporaryAccountants() {
        return numberOfTemporaryAccountants;
    }

    public String getNumberOfPermanentSupportStaff() {
        return numberOfPermanentSupportStaff;
    }

    public String getNumberOfTemporarySupportStaff() {
        return numberOfTemporarySupportStaff;
    }

    public String getNumberOfPermanentOtherEmployees() {
        return numberOfPermanentOtherEmployees;
    }

    public String getNumberOfTemporaryOtherEmployees() {
        return numberOfTemporaryOtherEmployees;
    }

    public String getAreaOfInstitute() {
        return areaOfInstitute;
    }

    public String getSizeOfClassrooms() {
        return sizeOfClassrooms;
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

    public String getMandatoryToolKitpresent() {
        return mandatoryToolKitpresent;
    }

    public String getSafeDrinkingWater() {
        return safeDrinkingWater;
    }

    public String getPowerBackup() {
        return powerBackup;
    }

    public String getSeparateToilets() {
        return separateToilets;
    }

    public String getTransportFacility() {
        return transportFacility;
    }

    public String getPresenceOfLibrary() {
        return presenceOfLibrary;
    }

    public String getNumberOfTechnicalBooks() {
        return numberOfTechnicalBooks;
    }

    public String getNumberOfNonTechnicalBooks() {
        return numberOfNonTechnicalBooks;
    }

    public String getNumberOfMagazines() {
        return numberOfMagazines;
    }

    public String getNumberOfDailies() {
        return numberOfDailies;
    }

    public String getRemarksOnInfrastructureDetails() {
        return remarksOnInfrastructureDetails;
    }

    public String getSufficientClassroomIlluminationLevel() {
        return sufficientClassroomIlluminationLevel;
    }

    public String getSufficientClassroomVentilationLevel() {
        return sufficientClassroomVentilationLevel;
    }

    public String getSufficientCenterCleanliness() {
        return sufficientCenterCleanliness;
    }

    public String getCenterWeatherProtected() {
        return centerWeatherProtected;
    }

    public String getRemarksOnLearningEnviornment() {
        return remarksOnLearningEnviornment;
    }

    public String getPrintedBrochureOrProspectus() {
        return printedBrochureOrProspectus;
    }

    public String getDocumentedPolicyAndProcedures() {
        return documentedPolicyAndProcedures;
    }

    public String getConcessionPolicy() {
        return concessionPolicy;
    }

    public String getSafeCustodyOfStudentDocuments() {
        return safeCustodyOfStudentDocuments;
    }

    public String getStudentAgreementWithInstitution() {
        return studentAgreementWithInstitution;
    }

    public String getRemarksOnStudentAdmissionDetails() {
        return remarksOnStudentAdmissionDetails;
    }

    public String getNumberOfClassrooms() {
        return numberOfClassrooms;
    }

    public String getBuildingType() {
        return buildingType;
    }

}
