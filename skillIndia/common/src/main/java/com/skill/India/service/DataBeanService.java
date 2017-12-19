package com.skill.India.service;

import com.skill.India.dao.*;
import com.skill.India.dto.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
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

    public int dataBeanDtoCollection(String trainingPartnerRegistrationId) throws JRException, IOException {
        final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.DataBeanService.class);

        LOGGER.debug("Reached the inside of DataBeanService...");
        LOGGER.debug("Creating collection for storing value from Dtos");
        Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection(trainingPartnerRegistrationId);
        LOGGER.debug("Size of Collection dataBeanDtos is " + dataBeanDtos.size());

        Collection<CenterLevelDto> centerLevelDtos = centerLevelDao.centerLevelDtos(trainingPartnerRegistrationId);
        LOGGER.debug("Size of Collection centerLevelDtos is " + centerLevelDtos.size());
        Collection<InstitutionGrantDto> institutionGrantDtos = institutionGrantDao.dataBeanDtoCollectionInstitutionGrant(trainingPartnerRegistrationId);
        LOGGER.debug("Size of Collection institutionGrantDtos is " + institutionGrantDtos.size());
        Collection<InstitutionRecognitionDto> institutionRecognitionDtos = institutionRecognitionDao.dataBeanDtoCollectionInstitutionRecognition(trainingPartnerRegistrationId);
        LOGGER.debug("Size of Collection institutionRecognitionDtos is " + institutionRecognitionDtos.size());
        Collection<PriorExperienceDto> priorExperienceDtos = priorExperienceDao.dataBeanDtoCollectionPriorExperience(trainingPartnerRegistrationId);
        LOGGER.debug("Size of Collection priorExperienceDtos is " + priorExperienceDtos.size());
        Collection<DirectorDto> directorDtos = directorDao.dataBeanDtoCollectionDirector(trainingPartnerRegistrationId);
        LOGGER.debug("Size of Collection directorDtos is " + directorDtos.size());

        String nameOfOrganization = null;

        if(!dataBeanDtos.isEmpty()){
            LOGGER.debug("Fetching the organization name and storing it to use as PDF name");
            for (DataBeanDto beanDto : dataBeanDtos){
                nameOfOrganization = beanDto.getOrganizationName();
            }
            LOGGER.debug("The name of pdf file is " + nameOfOrganization);
        }
        else {
            LOGGER.debug("The received DataBean is empty");
        }


        LOGGER.debug("Creating the data source..");
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataBeanDtos, false);
        JRBeanCollectionDataSource centerLevelDataSource = new JRBeanCollectionDataSource(centerLevelDtos, false);
        JRBeanCollectionDataSource institutionGrantDataSource = new JRBeanCollectionDataSource(institutionGrantDtos, false);
        JRBeanCollectionDataSource institutionRecognitionDataSource = new JRBeanCollectionDataSource(institutionRecognitionDtos, false);
        JRBeanCollectionDataSource priorExperienceDataSource = new JRBeanCollectionDataSource(priorExperienceDtos, false);
        JRBeanCollectionDataSource directorDataSource = new JRBeanCollectionDataSource(directorDtos, false);
        LOGGER.debug("Successfully created the JRBeanDataSources");


        //Method to add two JRBeanDataSource
        Map parameters = new HashMap();
        LOGGER.debug("Creating HashMap to pass JRBeanDatSource into the PDF as parameters");
        parameters.put("organizationLevel", beanCollectionDataSource);
        parameters.put("centerLevel", centerLevelDataSource);
        parameters.put("institutionGrant", institutionGrantDataSource);
        parameters.put("institutionRecognition", institutionRecognitionDataSource);
        parameters.put("priorExperience", priorExperienceDataSource);
        parameters.put("director", directorDataSource);

        LOGGER.debug("Starting pdf generation.....");

        //Normal input stream without the need to use ClassPathResource
        //Use this if the below stream doesn't work
//        InputStream inputStream = getClass().getResourceAsStream("/static/January.jasper");


        ClassPathResource resource = new ClassPathResource("/static/January.jasper");

        File desktop = new File("D://SCGJ.SDMS//NewApplicationTPAB" + File.separator + nameOfOrganization + ".pdf");
        String dest2 = desktop.getAbsolutePath();
        LOGGER.debug("the output file on desktop is " + dest2);
        InputStream inputStream = resource.getInputStream();

//        LOGGER.debug("the output file is " + dest);
//
//        File newFile = new File("server/src/main/resources/TrainingPartnerPDF/"+ nameOfOrganization.trim() + ".pdf");
//        String destFileName = newFile.getAbsolutePath();
//        LOGGER.debug("THE DESTINATION FILE NAME IS " + destFileName);

        int success = 0;
        try{
            LOGGER.debug("Creating the jrprint file..");
            JasperPrint printFileName = JasperFillManager.fillReport(inputStream,parameters, new JREmptyDataSource());
            LOGGER.debug("Successfuly created the jrprint file >> " + printFileName);

            OutputStream outputStream = new FileOutputStream(new File(dest2));

            if(printFileName!=null){
                LOGGER.debug("Exporting the file to pdf..");
                JasperExportManager.exportReportToPdfStream(printFileName,outputStream);
                success = 1;
            }
            else {
                LOGGER.debug("jrprint file is empty..");
                success = -1;
            }

//            success++;
            if(success == 1){
                LOGGER.debug("Pdf generated successfully....!!!");
                LOGGER.debug("Success code = "+ success);
            }

            else {
                LOGGER.debug("Error in PDF generation due to error in Jrprint file");
            }
            outputStream.close();



        } catch (JRException e) {
            LOGGER.debug("Exception caught.., an error occured in PDF generation");
            e.printStackTrace();
        }
        return success;

    }
}
