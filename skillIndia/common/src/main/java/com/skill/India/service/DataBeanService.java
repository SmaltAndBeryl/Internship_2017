package com.skill.India.service;

import com.skill.India.dao.*;
import com.skill.India.dto.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

/**
 * Created by Alkesh on 7/13/2017.
 */
@Service
public class DataBeanService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.DataBeanService.class);
    @Autowired
    private DataBeanListDao dataBeanListDao;

    @Autowired
    private InstitutionGrantDao institutionGrantDao;

    @Autowired
    private CenterLevelDao centerLevelDao;

    @Autowired
    private InstitutionRecognitionDao institutionRecognitionDao;

    @Autowired
    private PriorExperienceDao priorExperienceDao;

    @Autowired
    private DirectorDao directorDao;

    public int dataBeanDtoCollection(String trainingPartnerRegistrationId) throws JRException, FileNotFoundException {
        final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.DataBeanService.class);

        LOGGER.info("Reached the inside of DataBeanService...");
        LOGGER.info("Creating collection for storing value from Dtos");
        Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection(trainingPartnerRegistrationId);
        LOGGER.info("Size of Collection dataBeanDtos is " + dataBeanDtos.size());

        Collection<CenterLevelDto> centerLevelDtos = centerLevelDao.centerLevelDtos(trainingPartnerRegistrationId);
        LOGGER.info("Size of Collection centerLevelDtos is " + centerLevelDtos.size());
        Collection<InstitutionGrantDto> institutionGrantDtos = institutionGrantDao.dataBeanDtoCollectionInstitutionGrant(trainingPartnerRegistrationId);
        LOGGER.info("Size of Collection institutionGrantDtos is " + institutionGrantDtos.size());
        Collection<InstitutionRecognitionDto> institutionRecognitionDtos = institutionRecognitionDao.dataBeanDtoCollectionInstitutionRecognition(trainingPartnerRegistrationId);
        LOGGER.info("Size of Collection institutionRecognitionDtos is " + institutionRecognitionDtos.size());
        Collection<PriorExperienceDto> priorExperienceDtos = priorExperienceDao.dataBeanDtoCollectionPriorExperience(trainingPartnerRegistrationId);
        LOGGER.info("Size of Collection priorExperienceDtos is " + priorExperienceDtos.size());
        Collection<DirectorDto> directorDtos = directorDao.dataBeanDtoCollectionDirector(trainingPartnerRegistrationId);
        LOGGER.info("Size of Collection directorDtos is " + directorDtos.size());

        String nameOfOrganization = null;

        if(!dataBeanDtos.isEmpty()){
            LOGGER.info("Fetching the organization name and storing it to use as PDF name");
            for (DataBeanDto beanDto : dataBeanDtos){
                nameOfOrganization = beanDto.getOrganizationName();
            }
            LOGGER.info("The name of pdf file is " + nameOfOrganization);
        }
        else {
            LOGGER.info("The received DataBean is empty");
        }


        LOGGER.info("Creating the data source..");
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataBeanDtos, false);
        JRBeanCollectionDataSource centerLevelDataSource = new JRBeanCollectionDataSource(centerLevelDtos, false);
        JRBeanCollectionDataSource institutionGrantDataSource = new JRBeanCollectionDataSource(institutionGrantDtos, false);
        JRBeanCollectionDataSource institutionRecognitionDataSource = new JRBeanCollectionDataSource(institutionRecognitionDtos, false);
        JRBeanCollectionDataSource priorExperienceDataSource = new JRBeanCollectionDataSource(priorExperienceDtos, false);
        JRBeanCollectionDataSource directorDataSource = new JRBeanCollectionDataSource(directorDtos, false);
        LOGGER.info("Successfully created the JRBeanDataSources");


        //Method to add two JRBeanDataSource
        Map parameters = new HashMap();
        LOGGER.info("Creating HashMap to pass JRBeanDatSource into the PDF as parameters");
        parameters.put("organizationLevel", beanCollectionDataSource);
        parameters.put("centerLevel", centerLevelDataSource);
        parameters.put("institutionGrant", institutionGrantDataSource);
        parameters.put("institutionRecognition", institutionRecognitionDataSource);
        parameters.put("priorExperience", priorExperienceDataSource);
        parameters.put("director", directorDataSource);

        LOGGER.info("Starting pdf generation.....");

        File file = new File("server/src/main/resources/static/January.jasper");
        String sourceFileName = file.getAbsolutePath();
        LOGGER.info("THE SOURCE FILE NAME IS " + sourceFileName);
        File newFile = new File("server/src/main/resources/TrainingPartnerPDF/"+ nameOfOrganization.trim() + ".pdf");
        String destFileName = newFile.getAbsolutePath();
        LOGGER.info("THE DESTINATION FILE NAME IS " + destFileName);

        int success = 0;
        try{
            LOGGER.info("Creating the jrprint file..");
            JasperPrint printFileName = JasperFillManager.fillReport(sourceFileName,parameters, new JREmptyDataSource());
            LOGGER.info("Successfuly created the jrprint file >> " + printFileName);
            OutputStream outputStream = new FileOutputStream(new File(destFileName));


            if(printFileName!=null){
                LOGGER.info("Exporting the file to pdf..");
                JasperExportManager.exportReportToPdfStream(printFileName,outputStream);
                success++;
            }
            else {
                LOGGER.info("jrprint file is empty..");
                success--;
            }

            success++;
            LOGGER.info("Pdf generated successfully....!!!");
            LOGGER.info("Success code = "+ success);
        } catch (JRException e) {
            LOGGER.info("Exception caught.., an error occured in PDF generation");
            e.printStackTrace();
        }
        return success;

    }

    private DirectorDto directorBeans(String name, String designation, String emailId, String contactNumber, String educationalQualification, String experience) {
        DirectorDto directorDto = new DirectorDto(name, designation, emailId, contactNumber, educationalQualification, experience);
        return directorDto;
    }

    private PriorExperienceDto priorExperienceBeans(String courseName, String numberOfBatchesPerYear, String numberOfStudentsInEachBatch) {
        PriorExperienceDto priorExperienceDto = new PriorExperienceDto(courseName, numberOfBatchesPerYear, numberOfStudentsInEachBatch);
        return priorExperienceDto;
    }

    private InstitutionRecognitionDto institutionRecognitionBeans(String nameOfRecognizingBody, String recognitionNumber, String yearOfRecognition, String validityOfRecognition) {
        InstitutionRecognitionDto recognitionDto = new InstitutionRecognitionDto(nameOfRecognizingBody, recognitionNumber, yearOfRecognition, validityOfRecognition);
        return recognitionDto;
    }

    private DataBeanDto produce(String organizationName, String address, String city, String state, String pincode, String sPOCName, String mobileNumber, String alternateMobileNumber, String landlineNumber, String alternateLandlineNumber, String faxNumber, String websites,

                                String yearOfEstablishment, String qualificationPacks, String nSDCFunded, String mediumOfInstructions, String selfOwnedInstitution,
                                String franchiseOwnedInstitution, String mobileTrainingInstitution, String panNumber, String tanNumber, String turnOverOfInstitution,
                                String instituteReceivedAnyGrant, String instituteReceivedAnyRecognition, String priorExperienceOfInstitutionInSkillDevelopment,
                                String anyPriorExperienceOfInstitutionInSkillTraining){

        DataBeanDto dataBeanDto = new DataBeanDto(organizationName, address,city, state, pincode, sPOCName, mobileNumber, alternateMobileNumber, landlineNumber, alternateLandlineNumber, faxNumber, websites,

                yearOfEstablishment, qualificationPacks, nSDCFunded, mediumOfInstructions, selfOwnedInstitution, franchiseOwnedInstitution, mobileTrainingInstitution, panNumber,
                tanNumber, turnOverOfInstitution, instituteReceivedAnyGrant, instituteReceivedAnyRecognition, priorExperienceOfInstitutionInSkillDevelopment,
                anyPriorExperienceOfInstitutionInSkillTraining);

        return dataBeanDto;
    }

    private CenterLevelDto centerLevelDto(String nameOfCenter,
                                          String numberOfPermanentOfficeManager,
                                          String numberOftemporaryOfficeManager,
                                          String numberOfPermanentOfficeStaff,
                                          String numberOfTemporaryOfficeStaff,
                                          String numberOfPermanentLabAssistants,
                                          String numberOfTemporaryLabAssistants,
                                          String ofPermanentLabAssistants,
                                          String ofTemporaryLabAssistants,
                                          String numberOfPermanentSupportStaff,
                                          String numberOfTemporarySupportStaff,
                                          String numberOfPermanentOtherEmployees,
                                          String numberofPermanentOtherEmployees,

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
                                          String remarksOnStudentAdmissionDetails){

        CenterLevelDto levelDto = new CenterLevelDto(
                nameOfCenter,
                numberOfPermanentOfficeManager,
                numberOftemporaryOfficeManager,
                numberOfPermanentOfficeStaff,
                numberOfTemporaryOfficeStaff,
                numberOfPermanentLabAssistants,
                numberOfTemporaryLabAssistants,
                ofPermanentLabAssistants,
                ofTemporaryLabAssistants,
                numberOfPermanentSupportStaff,
                numberOfTemporarySupportStaff,
                numberOfPermanentOtherEmployees,
                numberofPermanentOtherEmployees,

                areaOfInstitute,
                buildingType,
                sizeOfClassrooms,
                numberOfClassrooms,
                sizeOfLabs,
                numberOfLabs,
                sizeOfWorkshops,
                numberOfWorkshops,
                mandatoryToolKitpresent,
                safeDrinkingWater,
                powerBackup,
                separateToilets,
                transportFacility,
                presenceOfLibrary,
                numberOfTechnicalBooks,
                numberOfNonTechnicalBooks,
                numberOfMagazines,
                numberOfDailies,
                remarksOnInfrastructureDetails,

                sufficientClassroomIlluminationLevel,
                sufficientClassroomVentilationLevel,
                sufficientCenterCleanliness,
                centerWeatherProtected,
                remarksOnLearningEnviornment,

                printedBrochureOrProspectus,
                documentedPolicyAndProcedures,
                concessionPolicy,
                safeCustodyOfStudentDocuments,
                studentAgreementWithInstitution,
                remarksOnStudentAdmissionDetails
                );
        return levelDto;
    }

    private InstitutionGrantDto institutionGrantBeans(String nameOfMinistry,String natureOfWork, String remarks ){
        InstitutionGrantDto grantDto = new InstitutionGrantDto(nameOfMinistry, natureOfWork, remarks);
        return grantDto;
    }
}
