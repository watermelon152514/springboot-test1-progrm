package com.guet.cn.springboottest1program.service;

import com.guet.cn.springboottest1program.bean.EmployeeMoney;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    List<EmployeeMoney> getEmployeeMoneyInformation(String time,String type) throws ParseException;
    int zongJiMoney(String time,String type);
}
