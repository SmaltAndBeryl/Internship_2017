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

        //Normal input stream without the need to use ClassPathResource
        //Use this if the below stream doesn't work
//        InputStream inputStream = getClass().getResourceAsStream("/static/January.jasper");


        ClassPathResource resource = new ClassPathResource("/static/January.jasper");
        InputStream inputStream = resource.getInputStream();

        URL out = resource.getURL();
        String pa = resource.getPath();
        LOGGER.info("the output file is " + out + " AND " + pa);


        File newFile = new File("server/src/main/resources/TrainingPartnerPDF/"+ nameOfOrganization.trim() + ".pdf");
        String destFileName = newFile.getAbsolutePath();
        LOGGER.info("THE DESTINATION FILE NAME IS " + destFileName);


        HashMap<String, Object> map = new HashMap<>();
        int success = 0;
        try{
            LOGGER.info("Creating the jrprint file..");
            JasperPrint printFileName = JasperFillManager.fillReport(inputStream,parameters, new JREmptyDataSource());
            LOGGER.info("Successfuly created the jrprint file >> " + printFileName);
            OutputStream outputStream = new FileOutputStream(new File(destFileName));

            map.put("jrprint", printFileName);
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
            map.put("success", success);
            LOGGER.info("Pdf generated successfully....!!!");
            LOGGER.info("Success code = "+ success);

        } catch (JRException e) {
            LOGGER.info("Exception caught.., an error occured in PDF generation");
            e.printStackTrace();
        }
        return success;

    }
}
