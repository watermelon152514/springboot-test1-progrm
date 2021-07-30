package com.guet.cn.springboottest1program.service;

import com.guet.cn.springboottest1program.bean.Sanke_information;
import com.guet.cn.springboottest1program.bean.Sms_information;
import com.guet.cn.springboottest1program.bean.Vip_information;

import java.util.List;

public interface IVipCentreService {
    //viplist服务
    List<Vip_information> selectVip(String VIP_TYPE,String CUSTOMER_SEX,String searchT,String searchVip);
    List<Vip_information> viewVips();
    void deleteVip(String VIP_ID);
    Vip_information selectVipById(String VIP_ID);
    void modifyVip(String VIP_NAME, String VIP_PHONE,String VIP_ID);
    List<Vip_information> searchVip(String searchVip);
    //sankelist服务
    List<Sanke_information> viewSanke();
    List<Sanke_information> selectSanke(String TYPE,String TIME,String searchSanke);
    //短信记录
    List<Sms_information> viewSms();
    void deleteSms(String SENDTMIE);
    List<Sms_information> searchSms(String searchSms);
}
