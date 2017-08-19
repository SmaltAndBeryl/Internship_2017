package com.skill.India.POC;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by Alkesh on 7/6/2017.
 */
public class DataBeanList {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataBeanList.class);

    public ArrayList<DataBean> getDataBeanList(ArrayList<String> arrayList){

        ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

        if(!arrayList.isEmpty()){
            LOGGER.info("The array list received in the DataBeanList is not empty " + arrayList.get(1));
        }

        else {
            LOGGER.info("Empty");
        }

        int index = 0;
        dataBeanList.add(produce(arrayList.get(index++), arrayList.get(index++), arrayList.get(index++), arrayList.get(index)));

        return dataBeanList;
    }

    private DataBean produce(String trainingPartnerName, String emailId, String disrict, String state) {
        LOGGER.info("Bean called..");
        DataBean dataBean = new DataBean();
        dataBean.setTrainingPartnerName(trainingPartnerName);
        dataBean.setEmailId(emailId);
        dataBean.setDistrict(disrict);
        dataBean.setState(state);

        return dataBean;
    }
}
