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
//                assessmentBodyRegistrationDetailsDtoArrayList.add(assessmentBodyRegistrationBeans(beanDto.get))
            }
        }

//        String sourceFileName = "C://Users/Alkesh/JaspersoftWorkspace/Curie/February.jasper";
//        File sourceFileName = new ClassPathResource("Februaury.jasper").getFile();

        File file = new File("server/src/main/resources/static/February.jasper");
        String sourceFileName = file.getAbsolutePath();

        LOGGER.info("THE FILE NAME IS " + sourceFileName);
        JRBeanCollectionDataSource regionalOfficeDataSource = new JRBeanCollectionDataSource(regionalOfficeDetailsDtoArrayList, false);

        Map parameters = new HashMap();
        parameters.put("regionalOffice", regionalOfficeDataSource);

        String rndm = String.valueOf(Math.random()).substring(4,8);
        File newFile = new File("server/src/main/resources/AssessmentBodyPDF/"+ rndm + ".pdf");
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

        return assessmentBodyRegistrationDetailsDao.dataBeanDtoCollectionAssessmentBodyRegistrationDetails();
    }

    private RegionalOfficeDetailsDto regionalOfficeDetailsBeans(String regionalOfficeId, String address, String state, String pincode, String contactNumber, String alternateContactNumber) {
        return new RegionalOfficeDetailsDto(regionalOfficeId, address, state, pincode, contactNumber, alternateContactNumber);
    }
}
