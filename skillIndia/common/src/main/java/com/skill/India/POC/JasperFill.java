package com.skill.India.POC;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/6/2017.
 */
public class JasperFill {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JasperFill.class);

    @SuppressWarnings("unchecked")
    public static void main(String args[]){

        String sourceFileName = "D://Jasper/June.jasper";

        ArrayList<DataBean> dataList = new ArrayList<>();

        DataBeanList dataBeanList = new DataBeanList();
        //Changed the parameters of the getDataBean list temporarily, please revert back to void
//        dataList = dataBeanList.getDataBeanList();
        String printFileName = null;

        LOGGER.info("Creating the data source..");
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataList);

        Map parameters = new HashMap();

        String rndm = String.valueOf(Math.random()).substring(4,8);
        String destFileName = "D://Jasper/" + rndm + ".pdf";
        try{
            LOGGER.info("Creating jrprint file..");
            printFileName = JasperFillManager.fillReportToFile(sourceFileName,parameters,beanCollectionDataSource);

            if(printFileName!=null){
                LOGGER.info("Exporting to pdf..");
                JasperExportManager.exportReportToPdfFile(printFileName,destFileName);
            }


            else {
                LOGGER.info("Exporting failed..");
            }

            System.out.println("Pdf generated successfully....!!!");
        } catch (JRException e) {
            LOGGER.info("Exception caught");
        }
    }
}
