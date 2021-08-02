package com.guet.cn.springboottest1program.bean;

import java.sql.Date;

public class RechargeInformation {
    private String BILL_ID;
    private String CUSTOMER_NAME;
    private String CUSTOMER_SEX;
    private String VIP_TYPE;
    private int RECHARGE_MONEY;
    private int IN_MONEY;
    private Date TIME;
    private Date BILL_TIME;
    private String REMARKS;
    private String EMPLOYEE;
    private String OPERATION;

    @Override
    public String toString() {
        return "RechargeInformation{" +
                "BILL_ID='" + BILL_ID + '\'' +
                ", CUSTOMER_NAME='" + CUSTOMER_NAME + '\'' +
                ", CUSTOMER_SEX='" + CUSTOMER_SEX + '\'' +
                ", VIP_TYPE='" + VIP_TYPE + '\'' +
                ", RECHARGE_MONEY=" + RECHARGE_MONEY +
                ", IN_MONEY=" + IN_MONEY +
                ", TIME=" + TIME +
                ", BILL_TIME=" + BILL_TIME +
                ", REMARKS='" + REMARKS + '\'' +
                ", EMPLOYEE='" + EMPLOYEE + '\'' +
                ", OPERATION='" + OPERATION + '\'' +
                '}';
    }

    public String getBILL_ID() {
        return BILL_ID;
    }

    public void setBILL_ID(String BILL_ID) {
        this.BILL_ID = BILL_ID;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public String getCUSTOMER_SEX() {
        return CUSTOMER_SEX;
    }

    public void setCUSTOMER_SEX(String CUSTOMER_SEX) {
        this.CUSTOMER_SEX = CUSTOMER_SEX;
    }

    public String getVIP_TYPE() {
        return VIP_TYPE;
    }

    public void setVIP_TYPE(String VIP_TYPE) {
        this.VIP_TYPE = VIP_TYPE;
    }

    public int getRECHARGE_MONEY() {
        return RECHARGE_MONEY;
    }

    public void setRECHARGE_MONEY(int RECHARGE_MONEY) {
        this.RECHARGE_MONEY = RECHARGE_MONEY;
    }

    public int getIN_MONEY() {
        return IN_MONEY;
    }

    public void setIN_MONEY(int IN_MONEY) {
        this.IN_MONEY = IN_MONEY;
    }

    public Date getTIME() {
        return TIME;
    }

    public void setTIME(Date TIME) {
        this.TIME = TIME;
    }

    public Date getBILL_TIME() {
        return BILL_TIME;
    }

    public void setBILL_TIME(Date BILL_TIME) {
        this.BILL_TIME = BILL_TIME;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }

    public String getEMPLOYEE() {
        return EMPLOYEE;
    }

    public void setEMPLOYEE(String EMPLOYEE) {
        this.EMPLOYEE = EMPLOYEE;
    }

    public String getOPERATION() {
        return OPERATION;
    }

    public void setOPERATION(String OPERATION) {
        this.OPERATION = OPERATION;
    }
}
