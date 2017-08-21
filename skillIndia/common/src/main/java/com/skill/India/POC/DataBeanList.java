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
        dataBeanList.add(produce
                (arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index)
                )
        );

        return dataBeanList;
    }

    private DataBean produce(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15, String s16, String s17, String s18, String s19, String s20, String s21, String s22, String s23, String s24, String s25, String s26, String s27, String s28, String s29, String s30, String s31, String s32, String s33, String s34, String s35, String s36, String s37, String s38, String s39, String s40, String s41, String s42, String s43, String s44, String s45, String s46, String s47) {
        LOGGER.info("Bean called..");
        DataBean dataBean = new DataBean();
        dataBean.setTotalCenters(s);
        dataBean.setOfficeStaffP(s1);
        dataBean.setOfficeStaffT(s2);
        dataBean.setLabAttendantsP(s3);
        dataBean.setLabAttendantsT(s4);
        dataBean.setAccountantsP(s5);
        dataBean.setAccountantsT(s6);
        dataBean.setSupportStaffP(s7);
        dataBean.setSupportStaffT(s8);
        dataBean.setOthersP(s9);
        dataBean.setOthersT(s10);
        dataBean.setAreaOfInstitute(s11);
        dataBean.setSizeOfClassRoom(s12);
        dataBean.setSizeOfLabs(s13);
        dataBean.setNumberOfLabs(s14);
        dataBean.setSizeOfWorkshops(s15);
        dataBean.setNumberOfWorkshops(s16);
        dataBean.setPresenceOfToolkit(s17);
        dataBean.setSafeDrinkingWater(s18);
        dataBean.setSeparateToilet(s19);
        dataBean.setTransportFacility(s20);
        dataBean.setPresenceOfLibrary(s21);
        dataBean.setIsIlluminationSufficient(s22);
        dataBean.setIsVentilated(s23);
        dataBean.setCleanLiness(s24);
        dataBean.setWeatherProtected(s25);
        dataBean.setPrintedBrochure(s26);
        dataBean.setDocumentedPolicy(s27);
        dataBean.setConcessionsPolicy(s28);
        dataBean.setSafeCustodyOfDocuments(s29);
        dataBean.setStudentAgreement(s30);
        dataBean.setYearOfEstablishment(s31);
        dataBean.setMediumOfInstructions(s32);
        dataBean.setMobileNo(s33);
        dataBean.setPAN(s34);
        dataBean.setTAN(s35);
        dataBean.setTurnover(s36);
        dataBean.setYearOfRecognition(s37);
        dataBean.setWebsite(s38);
        dataBean.setPINcode(s39);
        dataBean.setDistrict(s40);
        dataBean.setLandlineNumber(s41);
        dataBean.setFaxNumber(s42);
        dataBean.setValidityOfRecognition(s43);
        dataBean.setIsNSDCfunded(s44);
        dataBean.setApplicationId(s45);
        dataBean.setTrainingPartnerName(s46);
        dataBean.setEmailId(s47);

        return dataBean;
    }
}
