package com.skill.India.service;

import com.skill.India.dao.*;
import com.skill.India.dto.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AssessmentBodyPdfService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.AssessmentBodyPdfService.class);

    @Autowired
    private AssessmentBodyRegistrationDetailsDao assessmentBodyRegistrationDetailsDao;

    @Autowired
    private AssessmentBodyDirectorsDao assessmentBodyDirectorsDao;

    @Autowired
    private AssessmentExperienceInTechnicalDomainDao assessmentExperienceInTechnicalDomainDao;

    @Autowired
    private AssessmentStaffDetailsDao assessmentStaffDetailsDao;

    @Autowired
    private RegionalOfficeDetailsDao regionalOfficeDetailsDao;

    public Collection<AssessmentBodyRegistrationDetailsDto> dataBeanCollection() throws IOException {

        Collection<RegionalOfficeDetailsDto> regionalOfficeDetailsDtos = regionalOfficeDetailsDao.dataBeanDtoCollectionRegionalOffice();
        Collection<AssessmentBodyRegistrationDetailsDto> assessmentBodyRegistrationDetailsDtos = assessmentBodyRegistrationDetailsDao.dataBeanDtoCollectionAssessmentBodyRegistrationDetails();
        Collection<AssessmentBodyDirectorsDto> assessmentBodyDirectorsDtos = assessmentBodyDirectorsDao.dataBeanDtoCollectionDirectors();
        Collection<AssessmentExperienceInTechnicalDomainDto> assessmentExperienceInTechnicalDomainDtos = assessmentExperienceInTechnicalDomainDao.dataBeanDtoCollectionExperience();
        Collection<AssessmentStaffDetailsDto> assessmentStaffDetailsDtos = assessmentStaffDetailsDao.dataBeanDtoCollectionAssessmentStaffDetail();

        String organizationName = null;
        ArrayList<RegionalOfficeDetailsDto> regionalOfficeDetailsDtoArrayList = new ArrayList<>();
        ArrayList<AssessmentBodyRegistrationDetailsDto> assessmentBodyRegistrationDetailsDtoArrayList = new ArrayList<>();
        ArrayList<AssessmentBodyDirectorsDto> assessmentBodyDirectorsDtoArrayList = new ArrayList<>();
        ArrayList<AssessmentExperienceInTechnicalDomainDto> assessmentExperienceInTechnicalDomainDtoArrayList = new ArrayList<>();
        ArrayList<AssessmentStaffDetailsDto> assessmentStaffDetailsDtoArrayList = new ArrayList<>();

        if(!regionalOfficeDetailsDtos.isEmpty()){
            for(RegionalOfficeDetailsDto beanDto : regionalOfficeDetailsDtos){
                regionalOfficeDetailsDtoArrayList.add(regionalOfficeDetailsBeans(beanDto.getRegionalOfficeId(), beanDto.getAddress(), beanDto.getState(), beanDto.getPincode(), beanDto.getContactNumber(), beanDto.getAlternateContactNumber()));
            }
        }

        if(!assessmentBodyRegistrationDetailsDtos.isEmpty()){
            for(AssessmentBodyRegistrationDetailsDto beanDto : assessmentBodyRegistrationDetailsDtos){
                organizationName = beanDto.getOrganizationName();
                assessmentBodyRegistrationDetailsDtoArrayList.add(assessmentBodyRegistrationBeans(beanDto.getOrganizationName(), beanDto.getAddress(), beanDto.getCity(), beanDto.getState(), beanDto.getPincode(), beanDto.getsPOCName(), beanDto.getMobileNumber(), beanDto.getAlternateMobileNumber(), beanDto.getLandlineNumber(), beanDto.getAlternateLandlineNumber(), beanDto.getFaxNumber(), beanDto.getWebsites(),
                        beanDto.getYearOfEstablishment(), beanDto.getPriorAssessmentExperience(), beanDto.getPanNumber(), beanDto.getTanNumber(), beanDto.getInsituteReceivedAnyRecognition(), beanDto.getNameOfRecognitionBody(), beanDto.getRecognitionNumber(), beanDto.getYearOfRecognition(), beanDto.getValidityOfRecognition(),
                        beanDto.getAffiliatedToAnySectorSkillCouncil(),
                        beanDto.getNumberOfTechnicalAssessors(), beanDto.getNumberOfNonTechnicalAssessors()));
            }
        }

        if(!assessmentBodyDirectorsDtos.isEmpty()){
            for(AssessmentBodyDirectorsDto beanDto : assessmentBodyDirectorsDtos){
                assessmentBodyDirectorsDtoArrayList.add(assessmentBodyDirectorsBeans(beanDto.getName(), beanDto.getDesignation(), beanDto.getContactNumber(), beanDto.getEmailId(), beanDto.getEducationalQualification(), beanDto.getExperience()));
            }
        }

        if(!assessmentExperienceInTechnicalDomainDtos.isEmpty()){
            for(AssessmentExperienceInTechnicalDomainDto beanDto : assessmentExperienceInTechnicalDomainDtos){
                assessmentExperienceInTechnicalDomainDtoArrayList.add(assessmentExperienceInTechnicalDomainBeans(beanDto.getDomain(), beanDto.getNumberOfAssessmentsDone()));
            }
        }

        if(!assessmentStaffDetailsDtos.isEmpty()){
            for(AssessmentStaffDetailsDto beanDto : assessmentStaffDetailsDtos){
                assessmentStaffDetailsDtoArrayList.add(assessmentStaffDetailsBeans(beanDto.getName(), beanDto.getJobRoleCode(), beanDto.getDesignation(), beanDto.getContactNumber(), beanDto.getEmailId(), beanDto.getDistrict(), beanDto.getState(), beanDto.getEducationalQualification(), beanDto.getExperience()));
            }
        }

        File file = new File("server/src/main/resources/static/February.jasper");
        String sourceFileName = file.getAbsolutePath();

        LOGGER.info("THE SOURCE FILE NAME IS " + sourceFileName);

        JRBeanCollectionDataSource regionalOfficeDataSource = new JRBeanCollectionDataSource(regionalOfficeDetailsDtoArrayList, false);
        JRBeanCollectionDataSource assessmentBodyRegistrationDetailsDataSource = new JRBeanCollectionDataSource(assessmentBodyRegistrationDetailsDtoArrayList, false);
        JRBeanCollectionDataSource assessmentBodyDirectorsDataSource = new JRBeanCollectionDataSource(assessmentBodyDirectorsDtoArrayList, false);
        JRBeanCollectionDataSource assessmentExperienceInTechnicalDomainDataSource = new JRBeanCollectionDataSource(assessmentExperienceInTechnicalDomainDtoArrayList, false);
        JRBeanCollectionDataSource assessmentStaffDetailsDataSource = new JRBeanCollectionDataSource(assessmentStaffDetailsDtoArrayList, false);

        Map parameters = new HashMap();
        parameters.put("regionalOffice", regionalOfficeDataSource);
        parameters.put("registrationDetails", assessmentBodyRegistrationDetailsDataSource);
        parameters.put("director", assessmentBodyDirectorsDataSource);
//        parameters.put("technicalDomain",assessmentExperienceInTechnicalDomainDataSource );
        parameters.put("assessmentStaff", assessmentStaffDetailsDataSource);

        String rndm = String.valueOf(Math.random()).substring(4,8);
        File newFile = new File("server/src/main/resources/AssessmentBodyPDF/"+ organizationName.trim() + ".pdf");
        String destFileName = newFile.getAbsolutePath();
        LOGGER.info("THE DESTINATION FILE NAME IS " + sourceFileName);

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

        return assessmentBodyRegistrationDetailsDao.dataBeanDtoCollectionAssessmentBodyRegistrationDetails();
    }

    private AssessmentStaffDetailsDto assessmentStaffDetailsBeans(String name, String jobRoleCode, String designation, String contactNumber, String emailId, String district, String state, String educationalQualification, String experience) {
        return new AssessmentStaffDetailsDto(name, jobRoleCode, designation, contactNumber, emailId, district, state, educationalQualification, experience);
    }

    private AssessmentExperienceInTechnicalDomainDto assessmentExperienceInTechnicalDomainBeans(String domain, String numberOfAssessmentsDone) {
        return new AssessmentExperienceInTechnicalDomainDto(domain, numberOfAssessmentsDone);
    }

    private AssessmentBodyDirectorsDto assessmentBodyDirectorsBeans(String name, String designation, String contactNumber, String emailId, String educationalQualification, String experience) {
        return new AssessmentBodyDirectorsDto(name, designation, contactNumber, emailId, educationalQualification, experience);
    }

    private AssessmentBodyRegistrationDetailsDto assessmentBodyRegistrationBeans(String organizationName, String address, String city, String state, String pincode, String spocName, String mobileNumber, String alternateMobileNumber, String landlineNumber, String alternateLandlineNumber, String faxNumber, String websites, String yearOfEstablishment, String priorAssessmentExperience, String panNumber, String tanNumber, String insituteReceivedAnyRecognition, String NameOfRecognitionBody, String RecognitionNumber, String yearOfRecognition, String validityOfRecognition, String affiliatedToAnySectorSkillCouncil, String numberOfTechnicalAssessors, String numberOfNonTechnicalAssessors) {
        return new AssessmentBodyRegistrationDetailsDto(organizationName,address, city, state, pincode,spocName, mobileNumber, alternateMobileNumber, landlineNumber, alternateLandlineNumber,faxNumber, websites,
                yearOfEstablishment, priorAssessmentExperience, panNumber, tanNumber, insituteReceivedAnyRecognition, NameOfRecognitionBody, RecognitionNumber, yearOfRecognition, validityOfRecognition,
                affiliatedToAnySectorSkillCouncil,
                numberOfTechnicalAssessors, numberOfNonTechnicalAssessors
        );
    }

    private RegionalOfficeDetailsDto regionalOfficeDetailsBeans(String regionalOfficeId, String address, String state, String pincode, String contactNumber, String alternateContactNumber) {
        return new RegionalOfficeDetailsDto(regionalOfficeId, address, state, pincode, contactNumber, alternateContactNumber);
    }
}
