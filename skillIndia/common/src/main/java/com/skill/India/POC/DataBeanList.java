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
            LOGGER.debug("The array list received in the DataBeanList is not empty " + arrayList.get(1));
        }

        else {
            LOGGER.debug("Empty");
        }

        int index = 0;
        dataBeanList.add(produce(arrayList.get(index++), arrayList.get(index++),
                arrayList.get(index++),
                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
//                arrayList.get(index++),
                arrayList.get(index)
                )
        );

        return dataBeanList;
    }

    private DataBean produce(String s, String s1, String s2, String s3, String s4) {
        LOGGER.debug("Bean called..");
        DataBean dataBean = new DataBean();
        dataBean.setAddress(s);
        dataBean.setCity(s1);
        dataBean.setNameOfMinistry(s2);
        dataBean.setNatureOfWork(s3);
        dataBean.setRemarks(s4);
//        dataBean.setOfficeStaffT(s2);
//        dataBean.setLabAttendantsP(s3);
//        dataBean.setLabAttendantsT(s4);
//        dataBean.setAccountantsP(s5);
//        dataBean.setAccountantsT(s6);
//        dataBean.setSupportStaffP(s7);
//        dataBean.setSupportStaffT(s8);
//        dataBean.setOthersP(s9);
//        dataBean.setOthersT(s10);
//        dataBean.setAreaOfInstitute(s11);
//        dataBean.setSizeOfClassRoom(s12);
//        dataBean.setSizeOfLabs(s13);
//        dataBean.setNumberOfLabs(s14);
//        dataBean.setSizeOfWorkshops(s15);
//        dataBean.setNumberOfWorkshops(s16);
//        dataBean.setPresenceOfToolkit(s17);
//        dataBean.setSafeDrinkingWater(s18);
//        dataBean.setSeparateToilet(s19);
//        dataBean.setTransportFacility(s20);
//        dataBean.setPresenceOfLibrary(s21);
//        dataBean.setIsIlluminationSufficient(s22);
//        dataBean.setIsVentilated(s23);
//        dataBean.setCleanLiness(s24);
//        dataBean.setWeatherProtected(s25);
//        dataBean.setPrintedBrochure(s26);
//        dataBean.setDocumentedPolicy(s27);
//        dataBean.setConcessionsPolicy(s28);
//        dataBean.setSafeCustodyOfDocuments(s29);
//        dataBean.setStudentAgreement(s30);
//        dataBean.setYearOfEstablishment(s31);
//        dataBean.setMediumOfInstructions(s32);
//        dataBean.setMobileNo(s33);
//        dataBean.setPAN(s34);
//        dataBean.setTAN(s35);
//        dataBean.setTurnover(s36);
//        dataBean.setYearOfRecognition(s37);
//        dataBean.setWebsite(s38);
//        dataBean.setPINcode(s39);
//        dataBean.setDistrict(s40);
//        dataBean.setLandlineNumber(s41);
//        dataBean.setFaxNumber(s42);
//        dataBean.setValidityOfRecognition(s43);
//        dataBean.setIsNSDCfunded(s44);
//        dataBean.setApplicationId(s45);
//        dataBean.setTrainingPartnerName(s46);
//        dataBean.setEmailId(s47);
        return dataBean;
    }
}
