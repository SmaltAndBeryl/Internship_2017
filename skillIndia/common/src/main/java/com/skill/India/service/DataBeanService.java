package com.skill.India.service;

import com.skill.India.dao.*;
import com.skill.India.dto.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Timestamp;
import java.time.Instant;
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

    public Collection<DataBeanDto> dataBeanDtoCollection(String trainingPartnerRegistrationId) throws JRException, FileNotFoundException {

        Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection(trainingPartnerRegistrationId);
        Collection<CenterLevelDto> centerLevelDtos = centerLevelDao.centerLevelDtos(trainingPartnerRegistrationId);
        Collection<InstitutionGrantDto> institutionGrantDtos = institutionGrantDao.dataBeanDtoCollectionInstitutionGrant(trainingPartnerRegistrationId);
        Collection<InstitutionRecognitionDto> institutionRecognitionDtos = institutionRecognitionDao.dataBeanDtoCollectionInstitutionRecognition(trainingPartnerRegistrationId);
        Collection<PriorExperienceDto> priorExperienceDtos = priorExperienceDao.dataBeanDtoCollectionPriorExperience(trainingPartnerRegistrationId);
        Collection<DirectorDto> directorDtos = directorDao.dataBeanDtoCollectionDirector(trainingPartnerRegistrationId);

        String nameOfOrganization = null;
        ArrayList<DataBeanDto> organizationArrayList = new ArrayList<>();
        ArrayList<CenterLevelDto> arrayListDto1 = new ArrayList<>();
        ArrayList<InstitutionGrantDto> institutionGrantArrayList = new ArrayList<>();
        ArrayList<InstitutionRecognitionDto> institutionRecognitionDtoArrayList = new ArrayList<>();
        ArrayList<PriorExperienceDto> priorExperienceDtoArrayList = new ArrayList<>();
        ArrayList<DirectorDto> directorDtoArrayList = new ArrayList<>();

        if(!dataBeanDtos.isEmpty()){
            for(DataBeanDto beanDto : dataBeanDtos){
                nameOfOrganization = beanDto.getOrganizationName();
                organizationArrayList.add(produce(beanDto.getOrganizationName(),
                        beanDto.getAddress(),
                        beanDto.getCity(),
                        beanDto.getState(),
                        beanDto.getPincode(),
                        beanDto.getsPOCName(),
                        beanDto.getMobileNumber(),
                        beanDto.getAlternateLandlineNumber(),
                        beanDto.getLandlineNumber(),
                        beanDto.getAlternateLandlineNumber(),
                        beanDto.getFaxNumber(),
                        beanDto.getWebsites(),

                        beanDto.getYearOfEstablishment(),
                        beanDto.getQualificationPacks(),
                        beanDto.getnSDCFunded(),
                        beanDto.getMediumOfInstructions(),
                        beanDto.getSelfOwnedInstitution(),
                        beanDto.getFranchiseOwnedInstitution(),
                        beanDto.getMobileTrainingInstitution(),
                        beanDto.getPanNumber(),
                        beanDto.getTanNumber(),
                        beanDto.getTurnOverOfInstitution(),
                        beanDto.getInstituteReceivedAnyGrant(),
                        beanDto.getInstituteReceivedAnyRecognition(),
                        beanDto.getPriorExperienceOfInstitutionInSkillDevelopment(),
                        beanDto.getAnyPriorExperienceOfInstitutionInSkillTraining()
                        ));
            }
        }

        if(!centerLevelDtos.isEmpty()){
            for (CenterLevelDto beanDto : centerLevelDtos){
                arrayListDto1.add(centerLevelDto(beanDto.getNameOfCenter(),
                        beanDto.getNumberOfPermanentOfficeManager(),
                        beanDto.getNumberOftemporaryOfficeManager(),
                        beanDto.getNumberOfPermanentOfficeStaff(),
                        beanDto.getNumberOfTemporaryOfficeStaff(),
                        beanDto.getNumberOfPermanentLabAssistants(),
                        beanDto.getNumberOfTemporaryLabAssistants(),
                        beanDto.getNumberOfPermanentLabAssistants(),
                        beanDto.getNumberOfTemporaryLabAssistants(),
                        beanDto.getNumberOfPermanentSupportStaff(),
                        beanDto.getNumberOfTemporarySupportStaff(),
                        beanDto.getNumberOfPermanentOtherEmployees(),
                        beanDto.getNumberOfPermanentOtherEmployees(),

                        beanDto.getAreaOfInstitute(),
                        beanDto.getBuildingType(),
                        beanDto.getSizeOfClassrooms(),
                        beanDto.getNumberOfClassrooms(),
                        beanDto.getSizeOfLabs(),
                        beanDto.getNumberOfLabs(),
                        beanDto.getSizeOfWorkshops(),
                        beanDto.getNumberOfWorkshops(),
                        beanDto.getMandatoryToolKitpresent(),
                        beanDto.getSafeDrinkingWater(),
                        beanDto.getPowerBackup(),
                        beanDto.getSeparateToilets(),
                        beanDto.getTransportFacility(),
                        beanDto.getPresenceOfLibrary(),
                        beanDto.getNumberOfTechnicalBooks(),
                        beanDto.getNumberOfNonTechnicalBooks(),
                        beanDto.getNumberOfMagazines(),
                        beanDto.getNumberOfDailies(),
                        beanDto.getRemarksOnInfrastructureDetails(),

                        beanDto.getSufficientClassroomIlluminationLevel(),
                        beanDto.getSufficientClassroomVentilationLevel(),
                        beanDto.getSufficientCenterCleanliness(),
                        beanDto.getCenterWeatherProtected(),
                        beanDto.getRemarksOnLearningEnviornment(),

                        beanDto.getPrintedBrochureOrProspectus(),
                        beanDto.getDocumentedPolicyAndProcedures(),
                        beanDto.getConcessionPolicy(),
                        beanDto.getSafeCustodyOfStudentDocuments(),
                        beanDto.getStudentAgreementWithInstitution(),
                        beanDto.getRemarksOnStudentAdmissionDetails()

                        ));
            }
        }

        if(!institutionGrantDtos.isEmpty()){
            for(InstitutionGrantDto beanDto : institutionGrantDtos){
                LOGGER.info("Instituiton is " + beanDto.getNameOfMinistry());
                institutionGrantArrayList.add(institutionGrantBeans(beanDto.getNameOfMinistry(), beanDto.getNatureOfWork(), beanDto.getRemarks()));
            }
        }

        if(!institutionRecognitionDtos.isEmpty()){
            for (InstitutionRecognitionDto beanDto : institutionRecognitionDtos){
                institutionRecognitionDtoArrayList.add(institutionRecognitionBeans(beanDto.getNameOfRecognizingBody(),beanDto.getRecognitionNumber(), beanDto.getYearOfRecognition(), beanDto.getValidityOfRecognition()));
            }
        }

        if(!priorExperienceDtos.isEmpty()){
            for(PriorExperienceDto beanDto : priorExperienceDtos){
                priorExperienceDtoArrayList.add(priorExperienceBeans(beanDto.getCourseName(), beanDto.getNumberOfBatchesPerYear(), beanDto.getNumberOfStudentsInEachBatch()));
            }
        }

        if(!directorDtos.isEmpty()){
            for(DirectorDto beanDto : directorDtos){
                directorDtoArrayList.add(directorBeans(beanDto.getName(), beanDto.getDesignation(), beanDto.getEmailId(), beanDto.getContactNumber(), beanDto.getEducationalQualification(), beanDto.getExperience()));
            }
        }
        LOGGER.info("The size of the array received is >> " + organizationArrayList.size() + " " + arrayListDto1.size() + " " + institutionGrantArrayList.size()+ " " + priorExperienceDtoArrayList.size());

        //Logic for generating pdf
//        String sourceFileName = "C://Users/Alkesh/JaspersoftWorkspace/Curie/January.jasper";
//        String printFileName = null;
//        String sourceFileName = System.getProperty("user.home");
        File file = new File("server/src/main/resources/static/January.jasper");
        String sourceFileName = file.getAbsolutePath();

        LOGGER.info("THE source file is located at "+ sourceFileName);
        String print = null;

        LOGGER.info("Creating the data source..");


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(organizationArrayList, false);
        JRBeanCollectionDataSource centerLevelDataSource = new JRBeanCollectionDataSource(arrayListDto1, false);
        JRBeanCollectionDataSource institutionGrantDataSource = new JRBeanCollectionDataSource(institutionGrantArrayList, false);
        JRBeanCollectionDataSource institutionRecognitionDataSource = new JRBeanCollectionDataSource(institutionRecognitionDtoArrayList, false);
        JRBeanCollectionDataSource priorExperienceDataSource = new JRBeanCollectionDataSource(priorExperienceDtoArrayList, false);
        JRBeanCollectionDataSource directorDataSource = new JRBeanCollectionDataSource(directorDtoArrayList, false);


        //Method to add two JRBeanDataSource
        Map parameters = new HashMap();
        String r = "test param";
        parameters.put("organizationLevel", beanCollectionDataSource);
        parameters.put("centerLevel", centerLevelDataSource);
        parameters.put("institutionGrant", institutionGrantDataSource);
        parameters.put("institutionRecognition", institutionRecognitionDataSource);
        parameters.put("priorExperience", priorExperienceDataSource);
        parameters.put("director", directorDataSource);

        LOGGER.info("Starting pdf generation.....");

        String rndm = String.valueOf(Math.random()).substring(4,8);

        File newFile = new File("server/src/main/resources/TrainingPartnerPDF/"+ nameOfOrganization.trim() + ".pdf");
        String destFileName = newFile.getAbsolutePath();

        try{
            LOGGER.info("Creating the jrprint file..");
            JasperPrint printFileName = JasperFillManager.fillReport(sourceFileName,parameters, new JREmptyDataSource());
            OutputStream outputStream = new FileOutputStream(new File(destFileName));


            if(printFileName!=null){
                LOGGER.info("Exporting the file to pdf..");
                JasperExportManager.exportReportToPdfStream(printFileName,outputStream);
            }
            else {
                LOGGER.info("jrprint file is empty..");
            }

            LOGGER.info("Pdf generated successfully....!!!");
        } catch (JRException e) {
            LOGGER.info("Exception caught..");
            e.printStackTrace();
        }
        return dataBeanListDao.dataBeanDtoCollection(trainingPartnerRegistrationId);

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
