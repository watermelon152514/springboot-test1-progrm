package com.guet.cn.springboottest1program.service;

import com.guet.cn.springboottest1program.bean.vip_information;

import java.util.List;

public interface IVipService {
    List<vip_information> selectVip(String VIP_TYPE);
    List<vip_information> viewVips();
    void deleteVip(String VIP_ID);
    vip_information selectVipById(String VIP_ID);
    void modifyVip(String VIP_NAME, String VIP_PHONE,String VIP_ID);
}
