package com.guet.cn.springboottest1program.mapper;


import com.guet.cn.springboottest1program.bean.Employees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsertEmpMapper {
    Integer insertEmp(List<Employees> employees);
    List<Employees> EmpList();
}
