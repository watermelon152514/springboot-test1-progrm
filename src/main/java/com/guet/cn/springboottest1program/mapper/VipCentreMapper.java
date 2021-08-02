package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.Sanke_information;
import com.guet.cn.springboottest1program.bean.Sms_information;
import com.guet.cn.springboottest1program.bean.Vip_information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VipCentreMapper {
    //viplist
    List<Vip_information> selectVip(@Param("VIP_TYPE") String VIP_TYPE,@Param("CUSTOMER_SEX") String CUSTOMER_SEX, @Param("searchT") String searchT, @Param("searchVip") String searchVip);
    List<Vip_information> viewVips();
    void deleteVip(String VIP_ID);
    Vip_information selectVipById(String VIP_ID);
    void modifyVip(String VIP_NAME, String VIP_PHONE,String VIP_ID);
    List<Vip_information> searchVip(@Param("searchVip")String searchVip);
    //sankelist
    List<Sanke_information> viewSanke();
    List<Sanke_information> selectSanke(@Param("TYPE") String TYPE,@Param("TIME") String TIME, @Param("searchSanke") String searchSanke);
    //SMS
    List<Sms_information> viewSms();
    void deleteSms(String SENDTMIE);
    List<Sms_information> searchSms(@Param("searchSms") String searchSms);
}
