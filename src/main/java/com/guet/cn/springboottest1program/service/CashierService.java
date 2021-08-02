package com.guet.cn.springboottest1program.service;

import com.guet.cn.springboottest1program.bean.Project_bill;
import com.guet.cn.springboottest1program.bean.Vip_information;

import java.util.List;

public interface CashierService {
    List<Project_bill> searchTest(String searchTest);
    void insertVip(Vip_information vip);
}
