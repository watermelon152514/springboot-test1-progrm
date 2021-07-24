package com.guet.cn.springboottest1program.service.Impl;


import com.guet.cn.springboottest1program.bean.Employees;
import com.guet.cn.springboottest1program.mapper.EmployeesMapper;
import com.guet.cn.springboottest1program.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired(required = false)
    private EmployeesMapper employeesMapper;

    @Override
    public List<Employees> selectmsg(String sex, String jobstatus) {
        return employeesMapper.selectmsg(sex,jobstatus);
    }

    @Override
    public List<Employees> viewEmployees() {
        return employeesMapper.viewEmployees();
    }

    @Override
    public void deleteEmployee(int id) {
        employeesMapper.deleteEmployee(id);
    }

    @Override
    public Employees getEmployeeById(int id) {
        return employeesMapper.getEmployeeById(id);
    }

    @Override
    public void updateEmployee(int id, String name, String sex, String phone, String lv, Date entrytime, int perobj, String jobstatus, String department, String lable, int ordernum, String workstatus, String open_ports, String tuijian_status) {
        employeesMapper.updateEmployee(id, name, sex, phone, lv, entrytime, perobj,jobstatus,department, lable,ordernum,workstatus, open_ports, tuijian_status);
    }

    @Override
    public void addEmployee(int id, String name, String sex, String phone, String lv, Date entrytime,String jobstatus, String department, int ordernum, String workstatus, String open_ports, String tuijian_status){
        employeesMapper.addEmployee(id, name, sex, phone, lv, entrytime,jobstatus,department,ordernum,workstatus, open_ports, tuijian_status);
    }
}
