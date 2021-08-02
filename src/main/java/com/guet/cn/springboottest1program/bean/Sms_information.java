package com.guet.cn.springboottest1program.bean;

public class Sms_information {
    private String SENDTMIE;
    private String RESULT;
    private String CUSTOMER_NUMBER;
    private String SMS_NUMBER;
    private String CONTENT;
    private String TIPS;

    public String getSENDTMIE() {
        return SENDTMIE;
    }

    public void setSENDTMIE(String SENDTMIE) {
        this.SENDTMIE = SENDTMIE;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getCUSTOMER_NUMBER() {
        return CUSTOMER_NUMBER;
    }

    public void setCUSTOMER_NUMBER(String CUSTOMER_NUMBER) {
        this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
    }

    public String getSMS_NUMBER() {
        return SMS_NUMBER;
    }

    public void setSMS_NUMBER(String SMS_NUMBER) {
        this.SMS_NUMBER = SMS_NUMBER;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getTIPS() {
        return TIPS;
    }

    public void setTIPS(String TIPS) {
        this.TIPS = TIPS;
    }
}
