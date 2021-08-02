package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.Project_bill;
import com.guet.cn.springboottest1program.bean.Vip_information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CashierMapper {
    List<Project_bill> searchTest(@Param("searchTest") String searchTest);
    void insertVip(Vip_information vip);
}
