package com.guet.cn.springboottest1program.service;

import com.guet.cn.springboottest1program.bean.Add_cardtype;

import java.util.List;

public interface AddCardTypeService {
    List<Add_cardtype> viewAddCardType();
    void deleteVipTypeById(String id);
    List<Add_cardtype> selectById(String id);
    Add_cardtype getVipTypeById(String id);
}
