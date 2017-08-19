package com.skill.India.service;

import com.skill.India.POC.DataBean;
import com.skill.India.POC.DataBeanList;
import com.skill.India.dao.DataBeanListDao;
import com.skill.India.dto.DataBeanDto;
import jdk.internal.util.xml.impl.Input;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@Service
public class DataBeanService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.DataBeanService.class);
    @Autowired
    private DataBeanListDao dataBeanListDao;

    public Collection<DataBeanDto> dataBeanDtoCollection() throws JRException{

        ArrayList<String> arrayList = new ArrayList<>();

        Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection();

        if(!dataBeanDtos.isEmpty()){
            for(DataBeanDto beanDto : dataBeanDtos){
                arrayList.add(beanDto.getTrainingPartnerName());
                arrayList.add(beanDto.getEmailId());
                arrayList.add(beanDto.getDistrict());
                arrayList.add(beanDto.getState());
            }
        }

        else {
            LOGGER.info("The DTO received is empty");
        }


        if(!arrayList.isEmpty()){
            for(String s : arrayList){
                LOGGER.info("Printing from inside the generatePdf function /////////// " + s);
            }
        }
        else {
            LOGGER.info("the array list received is empty");
        }

        //Logic for generating pdf

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/July.jrxml");

        String sourceFileName = "D://Jasper/July.jasper";
//        LOGGER.info("Read file successful, name is " + sourceFileName);
        //Call to function that returns the beans
        DataBeanList dataBeanList = new DataBeanList();

        //Pass the arrayList received into the getDataBeanList function to assign them as beans
        ArrayList<DataBean> dataList;
        dataList = dataBeanList.getDataBeanList(arrayList);

        String printFileName = null;

        LOGGER.info("Creating the data source..");
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataList);
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(strings);
        Map parameters = new HashMap();

        LOGGER.info("Starting pdf generation.....");
        String rndm = String.valueOf(Math.random()).substring(4,8);
        String destFileName = "D://Jasper/" + rndm + ".pdf";
        try{
            LOGGER.info("Creating the jrprint file..");
            printFileName = JasperFillManager.fillReportToFile(sourceFileName,parameters,beanCollectionDataSource);

            if(printFileName!=null){
                LOGGER.info("Exporting the file to pdf..");
                JasperExportManager.exportReportToPdfFile(printFileName,destFileName);
            }
            else {
                LOGGER.info("jrprint file is empty..");
            }

            System.out.println("Pdf generated successfully....!!!");
        } catch (JRException e) {
            LOGGER.info("Exception caught..");
        }
        return dataBeanListDao.dataBeanDtoCollection();

    }
}
