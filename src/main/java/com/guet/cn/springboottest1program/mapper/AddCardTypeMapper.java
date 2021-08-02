package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.Add_cardtype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddCardTypeMapper {
    List<Add_cardtype> viewAddCardType();
    void deleteVipTypeById(String id);
    List<Add_cardtype> selectById(String id);
    Add_cardtype getVipTypeById(String id);
}
