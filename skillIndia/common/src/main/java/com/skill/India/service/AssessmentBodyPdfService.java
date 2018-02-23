package com.skill.India.service;

import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.dao.*;
import com.skill.India.dto.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
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

    @Autowired AssessmentBodyAffiliationDao assessmentBodyAffiliationDao;
    
    @Autowired
	private ReadApplicationConstants readApplicationConstants;

    public int dataBeanCollection(String assessmentBodyRegistrationId) throws IOException {

        LOGGER.debug("Creating collection for storing value from Dtos");
        Collection<RegionalOfficeDetailsDto> regionalOfficeDetailsDtos = regionalOfficeDetailsDao.dataBeanDtoCollectionRegionalOffice(assessmentBodyRegistrationId);
        LOGGER.debug("Size of Collection regionalOfficeDetailsDto is " + regionalOfficeDetailsDtos.size());
        Collection<AssessmentBodyRegistrationDetailsDto> assessmentBodyRegistrationDetailsDtos = assessmentBodyRegistrationDetailsDao.dataBeanDtoCollectionAssessmentBodyRegistrationDetails(assessmentBodyRegistrationId);
        LOGGER.debug("Size of Collection assessmentBodyRegistrationDetailsDtos is " + assessmentBodyRegistrationDetailsDtos.size());
        Collection<AssessmentBodyDirectorsDto> assessmentBodyDirectorsDtos = assessmentBodyDirectorsDao.dataBeanDtoCollectionDirectors(assessmentBodyRegistrationId);
        LOGGER.debug("Size of Collection assessmentBodyDirectorsDtos is " + assessmentBodyDirectorsDtos.size());
        Collection<AssessmentExperienceInTechnicalDomainDto> assessmentExperienceInTechnicalDomainDtos = assessmentExperienceInTechnicalDomainDao.dataBeanDtoCollectionExperience(assessmentBodyRegistrationId);
        LOGGER.debug("Size of Collection assessmentExperienceInTechnicalDomainDtos is " + assessmentExperienceInTechnicalDomainDtos.size());
        Collection<AssessmentStaffDetailsDto> assessmentStaffDetailsDtos = assessmentStaffDetailsDao.dataBeanDtoCollectionAssessmentStaffDetail(assessmentBodyRegistrationId);
        LOGGER.debug("Size of Collection assessmentStaffDetailsDtos is " + assessmentStaffDetailsDtos.size());
        Collection<AssessmentBodyAffiliationDto> assessmentBodyAffiliationDtos = assessmentBodyAffiliationDao.affiliationDtos(assessmentBodyRegistrationId);
        LOGGER.debug("Size of Collection assessmentBodyAffiliationDtos is " + assessmentBodyAffiliationDtos.size());
        LOGGER.debug("Successfully fetched values in form of collection");

        String organizationName = null;

        for(AssessmentBodyRegistrationDetailsDto beanDto : assessmentBodyRegistrationDetailsDtos){
            LOGGER.debug("Fetching the organization name and storing it to use as PDF name");
            organizationName = beanDto.getOrganizationName();
        }
        LOGGER.debug("The name of pdf file is " + organizationName);

        LOGGER.debug("Creating JRBeanCollectionDataSources for injecting into the PDF");
        JRBeanCollectionDataSource regionalOfficeDataSource = new JRBeanCollectionDataSource(regionalOfficeDetailsDtos, false);
        JRBeanCollectionDataSource assessmentBodyRegistrationDetailsDataSource = new JRBeanCollectionDataSource(assessmentBodyRegistrationDetailsDtos, false);
        JRBeanCollectionDataSource assessmentBodyDirectorsDataSource = new JRBeanCollectionDataSource(assessmentBodyDirectorsDtos, false);
        JRBeanCollectionDataSource assessmentExperienceInTechnicalDomainDataSource = new JRBeanCollectionDataSource(assessmentExperienceInTechnicalDomainDtos, false);
        JRBeanCollectionDataSource assessmentStaffDetailsDataSource = new JRBeanCollectionDataSource(assessmentStaffDetailsDtos, false);
        JRBeanCollectionDataSource assessmentAffiliationDetails = new JRBeanCollectionDataSource(assessmentBodyAffiliationDtos, false);
        LOGGER.debug("Successfully created the JRBeanDataSources");


        Map<String, Object> parameters = new HashMap<>();
        LOGGER.debug("Creating HashMap to pass JRBeanDatSource into the PDF as parameters");
        parameters.put("regionalOffice", regionalOfficeDataSource);
        parameters.put("registrationDetails", assessmentBodyRegistrationDetailsDataSource);
        parameters.put("director", assessmentBodyDirectorsDataSource);
        parameters.put("technicalDomain", assessmentExperienceInTechnicalDomainDataSource);
        parameters.put("assessmentStaff", assessmentStaffDetailsDataSource);
        parameters.put("assessmentAffiliation", assessmentAffiliationDetails);

        LOGGER.debug("Starting PDF injection");
//        File file = new File("server/src/main/resources/static/February.jasper");
//        String sourceFileName = file.getAbsolutePath();
//        LOGGER.debug("THE SOURCE FILE NAME IS " + sourceFileName);

        ClassPathResource resource = new ClassPathResource("/static/February.jasper");
        File desktop = new File(readApplicationConstants.getProfileCreationAssessmentBodyFolder() + File.separator + organizationName + ".pdf");
        String dest = desktop.getAbsolutePath();
        LOGGER.debug("THE OUTPUT FILE IS "+ dest);
        LOGGER.debug("Getting input stream");
        InputStream inputStream = resource.getInputStream();
        LOGGER.debug("Input Stream successfully generated");

        int success = 0;
        try {
            LOGGER.debug("Creating the jrprint file..");
            JasperPrint printFileName = JasperFillManager.fillReport(inputStream, parameters, new JREmptyDataSource());
            LOGGER.debug("Successfuly created the jrprint file >> " + printFileName);
            OutputStream outputStream = new FileOutputStream(new File(dest));

            if (printFileName != null) {
                LOGGER.debug("Exporting the file to pdf..");
                JasperExportManager.exportReportToPdfStream(printFileName, outputStream);
                success = 1;
                LOGGER.debug("PDF generated successfully..!!");
            } else {
                success = -1;
                LOGGER.debug("jrprint file is empty..");
            }

            LOGGER.debug("Pdf generated successfully....!!!");
            
            outputStream.close();
        } catch (JRException e) {
            LOGGER.debug("Exception caught, Error in generating PDF");
            e.printStackTrace();
        }

        return success;
    }
}
