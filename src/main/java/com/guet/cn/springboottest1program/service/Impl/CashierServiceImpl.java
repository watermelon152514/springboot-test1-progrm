package com.guet.cn.springboottest1program.service.Impl;

import com.guet.cn.springboottest1program.bean.Project_bill;
import com.guet.cn.springboottest1program.bean.Vip_information;
import com.guet.cn.springboottest1program.mapper.CashierMapper;
import com.guet.cn.springboottest1program.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    private CashierMapper cashierMapper;

    @Override
    public List<Project_bill> searchTest(String searchTest) {
        return cashierMapper.searchTest(searchTest);
    }

    @Override
    public void insertVip(Vip_information vip) {
        cashierMapper.insertVip(vip);
    }
}
