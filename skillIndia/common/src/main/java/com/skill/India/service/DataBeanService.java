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
        	
        	LOGGER.info("Request Received from Controller");
    		LOGGER.info("In DataBeanService - dataBeanDtoCollection");

//            Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection();
//            Collection<DataBeanDto> dataBeans = dataBeanListDao.dataBeanDtoCollection();
//            for (DataBeanDto s : dataBeans)
//                LOGGER.info("Values are " + s.getTrainingPartnerName());


            LOGGER.info("Starting the process for PDF generation......///");
            String sourceFileName = "D://Jasper/juno.jasper";
            LOGGER.info("Creating an instance of the DataBeanService class....");
            DataBeanService dataBeanService = new DataBeanService();
            LOGGER.info("Getting the data in form of beans...");
//        Collection<DataBeanDto> dataBeanDtos = dataBeanService.dataBeanDtoCollection();
            LOGGER.info("Initializing Bean Object");
            ArrayList<PdfBean> pdfBeans = new ArrayList<>();
            LOGGER.info("Successfully initialized");
            LOGGER.info("Data retrieval successful...!");
            String printFileName = null;
            LOGGER.info("Storing the information in form of beans...");
            Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection();
            ArrayList<String> pdfBeans1 = new ArrayList<>();
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataBeanDtos);
            LOGGER.info("Initializing Hash Map Object");
            Map parameters = new HashMap();
            LOGGER.info("Successfully initialized");
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
                LOGGER.info("Inside TRY block");
                printFileName = JasperFillManager.fillReportToFile(sourceFileName,parameters,beanCollectionDataSource);
                LOGGER.info("Generating PDF.....//////////");
                if(printFileName!=null) {
                    LOGGER.info("print file name created and name not null..");
                    JasperExportManager.exportReportToPdfFile(printFileName, destFileName);
                }
                LOGGER.info("Pdf generated successfully....!!!");
            } catch (JRException e) {
            	LOGGER.info("Inside CATCH block ");
            }
            LOGGER.info("returning the Collection");
            LOGGER.info("Sending the Response to Controller");
            return dataBeanListDao.dataBeanDtoCollection();
    }


    //Method to return an array List of values from database
    public ArrayList<PdfBean> getDataBeanList(){
    	LOGGER.info("Initializing ArrayList PdfBean Object");
    	ArrayList<PdfBean> dataBeanList = new ArrayList<>();
    	LOGGER.info("Successfully initialized");
    	LOGGER.info("Initializing Collection DataBeanDto Object");
        Collection<DataBeanDto> dataBeanDtos = dataBeanListDao.dataBeanDtoCollection();
        LOGGER.info("Successfully initialized");
        
        for(DataBeanDto beanDto : dataBeanDtos){
            dataBeanList.add(produce(beanDto.getTrainingPartnerName(), beanDto.getIsNSDCfunded(), beanDto.getFirstName(), beanDto.getAddressLine1(), beanDto.getFaxNumber(), beanDto.getEmailDirector(), beanDto.getWebsite(), beanDto.getYearOfEstablishment(), beanDto.getPriorExposureInSkill(), beanDto.getMedium(), beanDto.getSelfOwnedTC(), beanDto.getFranchiseTC(), beanDto.getPAN(), beanDto.getTAN(), beanDto.getTurnover()));
        }
        LOGGER.info("Sending response");
        return dataBeanList;
    }

    private PdfBean produce(String trainingPartnerName,String isNSDCfunded,String firstName,String addressLine1,String faxNumber,String emailDirector, String website,String yearOfEstablishment,String priorExposureInSkill,String medium,String selfOwnedTC,String franchiseTC,String PAN,String TAN,String turnover) {
        
    	LOGGER.info("Request Received from Controller");
		LOGGER.info("In DataBeanService - produce");
		LOGGER.info("Initializing PdfBean Object");
    	PdfBean pdfBean = new PdfBean();
    	LOGGER.info("Successfully initialized");
    	LOGGER.info("Inserting Data to PdfBean Object");
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
    	LOGGER.info("Request Received from Controller");
		LOGGER.info("In DataBeanService - generatePdf");
		LOGGER.info("Starting the process for PDF generation......///");
        String sourceFileName = "D://Jasper/juno.jasper";
        LOGGER.info("Creating an instance of the Service class....");
        DataBeanService dataBeanService = new DataBeanService();
        LOGGER.info("Successfully initialized");
        LOGGER.info("Getting the data in form of beans...");
//        Collection<DataBeanDto> dataBeanDtos = dataBeanService.dataBeanDtoCollection();

        ArrayList<PdfBean> pdfBeans = dataBeanService.getDataBeanList();
        LOGGER.info("Data retrieval successful...!");
        String printFileName = null;
        LOGGER.info("Storing the information in form of beans...");
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(pdfBeans);
        LOGGER.info("Initializing HashMap object");
        Map parameters = new HashMap();
        LOGGER.info("Successfully initialized");

        String rndm = String.valueOf(Math.random()).substring(4,8);
        String destFileName = "D://Jasper/" + rndm + ".pdf";
        LOGGER.info("Started the PDF generation process.......");
        try{
        	LOGGER.info("Inside TRY block");
            printFileName = JasperFillManager.fillReportToFile(sourceFileName,parameters,beanCollectionDataSource);
            LOGGER.info("Generating PDF.....//////////");
            if(printFileName!=null)
                JasperExportManager.exportReportToPdfFile(printFileName,destFileName);

            LOGGER.info("Pdf generated successfully....!!!");
        } catch (JRException e) {
        	LOGGER.info("Inside CATCH block");
        	LOGGER.info("ERROR: Encountered Exception - ",e);
        }
//        return 1;
    }

}
