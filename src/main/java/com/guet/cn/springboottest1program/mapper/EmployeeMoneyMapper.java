package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.EmployeeMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeMoneyMapper {
    List<EmployeeMoney> getEmployeeMoneyInformation(String time,String type);
    int zongJiMoney(String time,String type);
}
