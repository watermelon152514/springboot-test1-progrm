package com.guet.cn.springboottest1program.mapper;


import com.guet.cn.springboottest1program.bean.Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface EmployeesMapper {
    List<Employees> selectmsg(@Param("sex") String sex, @Param("jobstatus") String jobstatus);
    void deleteEmployee(int id);
    Employees getEmployeeById(int id);
    void updateEmployee(@Param("id")int id, @Param("name")String name, @Param("sex")String sex, @Param("phone")String phone, @Param("lv")String lv, @Param("entrytime")Date entrytime, @Param("perobj")int perobj, @Param("jobstatus")String jobstatus, @Param("department")String department, @Param("lable")String lable, @Param("ordernum")int ordernum, @Param("workstatus")String workstatus, @Param("open_ports")String open_ports, @Param("tuijian_status")String tuijian_status);
    void addEmployee(@Param("id")int id, @Param("name")String name, @Param("sex")String sex, @Param("phone")String phone, @Param("lv")String lv, @Param("entrytime")Date entrytime, @Param("jobstatus")String jobstatus, @Param("department")String department, @Param("ordernum")int ordernum, @Param("workstatus")String workstatus, @Param("open_ports")String open_ports, @Param("tuijian_status")String tuijian_status);
    List<Employees> searchYG(@Param("sparam") String sparam);
    void setjobstatus(@Param("setjob") int setjob, @Param("id") int id);
    void setworkstatus(@Param("setwork") int setwork, @Param("id") int id);
    void settuijian(@Param("settui") int settui, @Param("id") int id);
    List<Employees> viewEmployees(@Param("sparam") String sparam);
}