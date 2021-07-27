package com.guet.cn.springboottest1program.service.Impl;

import com.guet.cn.springboottest1program.bean.Sanke_information;
import com.guet.cn.springboottest1program.bean.Sms_information;
import com.guet.cn.springboottest1program.bean.Vip_information;
import com.guet.cn.springboottest1program.mapper.VipCentreMapper;
import com.guet.cn.springboottest1program.service.IVipCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipCentreServiceImpl implements IVipCentreService {

    @Autowired
    private VipCentreMapper vipCentreMapper;

    @Override
    public List<Vip_information> selectVip(String VIP_TYPE,String CUSTOMER_SEX,String searchT,String searchVip) {
        return vipCentreMapper.selectVip(VIP_TYPE,CUSTOMER_SEX,searchT,searchVip);
    }

    @Override
    public List<Vip_information> viewVips() {
        return vipCentreMapper.viewVips();
    }

    @Override
    public void deleteVip(String VIP_ID) {
        vipCentreMapper.deleteVip(VIP_ID);
    }

    @Override
    public Vip_information selectVipById(String VIP_ID) {
        return vipCentreMapper.selectVipById(VIP_ID);
    }

    @Override
    public void modifyVip(String VIP_NAME, String VIP_PHONE, String VIP_ID) {
        vipCentreMapper.modifyVip(VIP_NAME,VIP_PHONE,VIP_ID);
    }

    @Override
    public List<Vip_information> searchVip(String searchVip) {
        return vipCentreMapper.searchVip(searchVip);
    }

    @Override
    public List<Sanke_information> viewSanke() {
        return vipCentreMapper.viewSanke();
    }

    @Override
    public List<Sanke_information> selectSanke(String TYPE, String TIME,String searchSanke) {
        return vipCentreMapper.selectSanke(TYPE,TIME,searchSanke);
    }

    @Override
    public List<Sms_information> viewSms() {
        return vipCentreMapper.viewSms();
    }

    @Override
    public void deleteSms(String SENDTMIE) {
        vipCentreMapper.deleteSms(SENDTMIE);
    }

    @Override
    public List<Sms_information> searchSms(String searchSms) {
        return vipCentreMapper.searchSms(searchSms);
    }

}
