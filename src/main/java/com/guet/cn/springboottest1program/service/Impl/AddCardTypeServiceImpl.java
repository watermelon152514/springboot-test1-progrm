package com.guet.cn.springboottest1program.service.Impl;

import com.guet.cn.springboottest1program.bean.Add_cardtype;
import com.guet.cn.springboottest1program.mapper.AddCardTypeMapper;
import com.guet.cn.springboottest1program.service.AddCardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddCardTypeServiceImpl implements AddCardTypeService {
    @Autowired
    private AddCardTypeMapper addCardTypeMapper;
    @Override
    public List<Add_cardtype> viewAddCardType() {
        return addCardTypeMapper.viewAddCardType();
    }

    @Override
    public void deleteVipTypeById(String id) {
        addCardTypeMapper.deleteVipTypeById(id);
    }

    @Override
    public List<Add_cardtype> selectById(String id) {
        return addCardTypeMapper.selectById(id);
    }

    @Override
    public Add_cardtype getVipTypeById(String id) {
        return addCardTypeMapper.getVipTypeById(id);
    }

}
