package com.guet.cn.springboottest1program.service;

import com.guet.cn.springboottest1program.bean.RechargeInformation;


import java.util.List;


public interface RechargeInformationService {
    List<RechargeInformation> getAllDate(String before,String after);
    List<RechargeInformation> getAllDates(String before,String after,String type);
    void deleteInformation(String BILL_ID);
    void changeInformation(RechargeInformation rechargeInformation);
}
