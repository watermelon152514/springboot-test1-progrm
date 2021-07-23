package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.vip_information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VipMapper {
    List<vip_information> selectVip(@Param("VIP_TYPE") String VIP_TYPE);
    List<vip_information> viewVips();
    void deleteVip(String VIP_ID);
    vip_information selectVipById(String VIP_ID);
    void modifyVip(String VIP_NAME, String VIP_PHONE,String VIP_ID);
}
