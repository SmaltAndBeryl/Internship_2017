package com.skill.India.POC;

import java.util.ArrayList;

/**
 * Created by Alkesh srivastav on 7/6/2017.
 */
public class DataBeanList {
    public ArrayList<DataBean> getDataBeanList(){
        ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

        dataBeanList.add(produce("Alkesh", "Sicily"));
        return dataBeanList;
    }

    private DataBean produce(String name, String city) {
        DataBean dataBean = new DataBean();
        dataBean.setName(name);
        dataBean.setCity(city);
        return dataBean;
    }
}
