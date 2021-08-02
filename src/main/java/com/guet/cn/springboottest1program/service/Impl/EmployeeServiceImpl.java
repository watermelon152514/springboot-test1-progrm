package com.guet.cn.springboottest1program.service.Impl;

import com.guet.cn.springboottest1program.bean.EmployeeMoney;
import com.guet.cn.springboottest1program.mapper.EmployeeMoneyMapper;
import com.guet.cn.springboottest1program.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMoneyMapper employeeMoneyMapper;

    @Override
    public List<EmployeeMoney> getEmployeeMoneyInformation(String time, String type) throws ParseException {
        return employeeMoneyMapper.getEmployeeMoneyInformation(time,type);
    }

    @Override
    public int zongJiMoney(String time,String type) {
        return employeeMoneyMapper.zongJiMoney(time,type);
    }
}
