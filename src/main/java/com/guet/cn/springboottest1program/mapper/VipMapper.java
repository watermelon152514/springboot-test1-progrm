package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.Vip_information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VipMapper {
    List<Vip_information> selectVip(@Param("VIP_TYPE") String VIP_TYPE,@Param("CUSTOMER_SEX") String CUSTOMER_SEX,@Param("searchT")String searchT);
    List<Vip_information> viewVips();
    void deleteVip(String VIP_ID);
    Vip_information selectVipById(String VIP_ID);
    void modifyVip(String VIP_NAME, String VIP_PHONE,String VIP_ID);
}
