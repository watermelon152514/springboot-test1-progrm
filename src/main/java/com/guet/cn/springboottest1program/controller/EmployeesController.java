package com.guet.cn.springboottest1program.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guet.cn.springboottest1program.bean.Employees;
import com.guet.cn.springboottest1program.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeesController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("XTSZ.html")
    public String first(){
        return "XTSZ";
    }

    /*进入页面就开始显示数据*/ /*改造此方法成分页*/
   /* @GetMapping("TJYG.html")
    public String viewEmployees(HttpServletRequest request){
        request.setAttribute("employees",iEmployeeService.viewEmployees());
        return "TJYG";
    }*/
    @RequestMapping("TJYG.html")
//    初始页 1  ; 一页数据 4条（行）
    public ModelAndView page(Model model, @RequestParam(value ="pageNum",defaultValue ="1") int pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "4") int pageSize){
        PageHelper.startPage(pageNum,pageSize);//调用PageHelper接口
        List<Employees> employees=iEmployeeService.viewEmployees();
        PageInfo<Employees> pageInfo=new PageInfo<>(employees,4);//调用接口里面的方法
//        for(Employees emp:employees){
//            System.out.println(emp);
//        }
        Map data=new HashMap();
        data.put("total",pageInfo.getTotal());//总记录数 一共多少条
        data.put("pages",pageInfo.getPages());//总页数
        data.put("current",pageInfo.getPageNum());//当前页码
        data.put("alldata",pageInfo.getList());//总数据

        System.out.println("是否是第一页："+pageInfo.isIsFirstPage());
        System.out.println(pageInfo.getNavigatepageNums());
        model.addAttribute("employees",employees);//把从数据库遍历到的数据添加到model
        System.out.println("sssss"+pageInfo.getList());
//        System.out.println(pageInfo.getPageNum());

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("articlePage",data);//将一些页码参数，放入到modelAndView
        modelAndView.setViewName("TJYG");//设置View的名字  类似于跳转 setViewName("redirect:TJYG.html")---重定向

        return modelAndView;    //返回视图
    }

    /*没用上*/
    @GetMapping("selectmsg")
    public String selectmsg(String sex,String jobstatus, HttpServletRequest request){
        List<Employees> employeesList=iEmployeeService.selectmsg(sex,jobstatus);
        System.out.println(employeesList);
        request.setAttribute("selectmsg",employeesList);
        return "redirect:TJYG.html";
    }

    /*删除操作*/
    @GetMapping("deleteEmployee")
    public String deleteEmployee(int id){
        iEmployeeService.deleteEmployee(id);
        return "redirect:TJYG.html";
    }


    @GetMapping("getEmployeeById")
    @ResponseBody
    public Employees getEmployeeById(int id){
        System.out.println("aaaaaaa");
        Employees ByIdInfo= iEmployeeService.getEmployeeById(id);
        System.out.println("sssssssssssssssss"+ByIdInfo.getName());
        return ByIdInfo;//返回json数据
    }
    @GetMapping("updateEmployee")
    public String updateEmployee(int id, String name, String sex, String phone, String lv, Date entrytime, int perobj, String jobstatus, String department, String lable, int ordernum, String workstatus, String open_ports, String tuijian_status){
        iEmployeeService.updateEmployee(id, name, sex, phone, lv, entrytime, perobj,jobstatus,department, lable,ordernum,workstatus, open_ports, tuijian_status);
        return "redirect:TJYG.html";
    }

    @GetMapping("addEmployee")
    public String addEmployee(int id, String name, String sex, String phone, String lv, Date entrytime,String jobstatus, String department, int ordernum, String workstatus, String open_ports, String tuijian_status){
        iEmployeeService.addEmployee(id,name,sex,phone,lv,entrytime,jobstatus,department,ordernum,workstatus,open_ports,tuijian_status);
        return "redirect:TJYG.html";
    }

}
