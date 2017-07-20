package com.skill.India.controller;

//import com.skill.India.POC.JasperFill;
import com.skill.India.dto.DataBeanDto;
import com.skill.India.service.DataBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@RestController
public class DataBeanController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataBeanController.class);

    @Autowired
    private DataBeanService dataBeanService;

    @RequestMapping("/cityData")
    public Collection<DataBeanDto> dataBeanDtoCollection(){
        LOGGER.info("The method to generate PDF has been called...");
        Collection<DataBeanDto> dataBeanDtos = dataBeanService.dataBeanDtoCollection();
        dataBeanService.getDataBeanList();
//        dataBeanService.generatePdf();
        return dataBeanService.dataBeanDtoCollection();
    }

    @RequestMapping("/generatePdf")
    public void pdfBeanArrayList(){
        dataBeanService.generatePdf();
    }
}
