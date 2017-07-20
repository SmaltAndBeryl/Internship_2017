package com.skill.India.service;

import com.skill.India.POC.DataBean;
import com.skill.India.POC.PdfBean;
import com.skill.India.dao.DataBeanListDao;
import com.skill.India.dto.DataBeanDto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@Service
public class DataBeanService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataBeanService.class);
    @Autowired
    private DataBeanListDao dataBeanListDao;

        public Collection<DataBeanDto> dataBeanDtoCollection(){

//            Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection();
//            Collection<DataBeanDto> dataBeans = dataBeanListDao.dataBeanDtoCollection();
//            for (DataBeanDto s : dataBeans)
//                LOGGER.info("Values are " + s.getTrainingPartnerName());


            LOGGER.info("Starting the process for PDF generation......///");
            String sourceFileName = "D://Jasper/juno.jasper";
            LOGGER.info("Creating an instance of the Service class....");
            DataBeanService dataBeanService = new DataBeanService();
            LOGGER.info("Getting the data in form of beans...");
//        Collection<DataBeanDto> dataBeanDtos = dataBeanService.dataBeanDtoCollection();

            ArrayList<PdfBean> pdfBeans = new ArrayList<>();
            LOGGER.info("Data retrieval successful...!");
            String printFileName = null;
            LOGGER.info("Storing the information in form of beans...");
            Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection();
            ArrayList<String> pdfBeans1 = new ArrayList<>();
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataBeanDtos);
            Map parameters = new HashMap();
            for(DataBeanDto dataBeanDto : dataBeanDtos){
                pdfBeans1.add(dataBeanDto.getFirstName());
                pdfBeans1.add(dataBeanDto.getEmailDirector());
                LOGGER.info("First Name is " + (dataBeanDto.getFirstName()));
            }

            LOGGER.info("Created the dataBeans and initialized the Hash Map");
            String rndm = String.valueOf(Math.random()).substring(4,8);
            String destFileName = "D://Jasper/" + rndm + ".pdf";
            LOGGER.info("Started the PDF generation process.......");
            try{
                LOGGER.info("entered the try catch block...");
                printFileName = JasperFillManager.fillReportToFile(sourceFileName,parameters,beanCollectionDataSource);
                LOGGER.info("Generating PDF.....//////////");
                if(printFileName!=null) {
                    LOGGER.info("print file name created and name not null..");
                    JasperExportManager.exportReportToPdfFile(printFileName, destFileName);
                }
                LOGGER.info("Pdf generated successfully....!!!");
            } catch (JRException e) {
            }
            LOGGER.info("returned the Collection successfully..");
            return dataBeanListDao.dataBeanDtoCollection();
    }


    //Method to return an array List of values from database
    public ArrayList<PdfBean> getDataBeanList(){
        ArrayList<PdfBean> dataBeanList = new ArrayList<>();
        Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection();

        for(DataBeanDto beanDto : dataBeanDtos){
            dataBeanList.add(produce(beanDto.getTrainingPartnerName(), beanDto.getIsNSDCfunded(), beanDto.getFirstName(), beanDto.getAddressLine1(), beanDto.getFaxNumber(), beanDto.getEmailDirector(), beanDto.getWebsite(), beanDto.getYearOfEstablishment(), beanDto.getPriorExposureInSkill(), beanDto.getMedium(), beanDto.getSelfOwnedTC(), beanDto.getFranchiseTC(), beanDto.getPAN(), beanDto.getTAN(), beanDto.getTurnover()));
        }
        return dataBeanList;
    }

    private PdfBean produce(String trainingPartnerName,String isNSDCfunded,String firstName,String addressLine1,String faxNumber,String emailDirector, String website,String yearOfEstablishment,String priorExposureInSkill,String medium,String selfOwnedTC,String franchiseTC,String PAN,String TAN,String turnover) {
        PdfBean pdfBean = new PdfBean();
        pdfBean.setTrainingPartnerName(trainingPartnerName);
        pdfBean.setIsNSDCfunded(isNSDCfunded);
        pdfBean.setFirstName(firstName);
        pdfBean.setAddressLine1(addressLine1);
        pdfBean.setFaxNumber(faxNumber);
        pdfBean.setEmailDirector(emailDirector);
        pdfBean.setWebsite(website);
        pdfBean.setYearOfEstablishment(yearOfEstablishment);
        pdfBean.setPriorExposureInSkill(priorExposureInSkill);
        pdfBean.setMedium(medium);
        pdfBean.setSelfOwnedTC(selfOwnedTC);
        pdfBean.setFranchiseTC(franchiseTC);
        pdfBean.setPAN(PAN);
        pdfBean.setTAN(TAN);
        pdfBean.setTurnover(turnover);
        return pdfBean;
    }

    public void generatePdf(){
        LOGGER.info("Starting the process for PDF generation......///");
        String sourceFileName = "D://Jasper/juno.jasper";
        LOGGER.info("Creating an instance of the Service class....");
        DataBeanService dataBeanService = new DataBeanService();
        LOGGER.info("Getting the data in form of beans...");
//        Collection<DataBeanDto> dataBeanDtos = dataBeanService.dataBeanDtoCollection();

        ArrayList<PdfBean> pdfBeans = dataBeanService.getDataBeanList();
        LOGGER.info("Data retrieval successful...!");
        String printFileName = null;
        LOGGER.info("Storing the information in form of beans...");
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(pdfBeans);
        Map parameters = new HashMap();

        String rndm = String.valueOf(Math.random()).substring(4,8);
        String destFileName = "D://Jasper/" + rndm + ".pdf";
        LOGGER.info("Started the PDF generation process.......");
        try{
            printFileName = JasperFillManager.fillReportToFile(sourceFileName,parameters,beanCollectionDataSource);
            LOGGER.info("Generating PDF.....//////////");
            if(printFileName!=null)
                JasperExportManager.exportReportToPdfFile(printFileName,destFileName);

            LOGGER.info("Pdf generated successfully....!!!");
        } catch (JRException e) {
        }
//        return 1;
    }

}
