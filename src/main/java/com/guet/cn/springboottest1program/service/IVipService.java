package com.guet.cn.springboottest1program.service;

import com.guet.cn.springboottest1program.bean.Vip_information;

import java.util.List;

public interface IVipService {
    List<Vip_information> selectVip(String VIP_TYPE,String CUSTOMER_SEX,String searchT);
    List<Vip_information> viewVips();
    void deleteVip(String VIP_ID);
    Vip_information selectVipById(String VIP_ID);
    void modifyVip(String VIP_NAME, String VIP_PHONE,String VIP_ID);
}
