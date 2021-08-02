package com.guet.cn.springboottest1program.controller;

import com.guet.cn.springboottest1program.bean.Vip_information;
import com.guet.cn.springboottest1program.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/Cashier")
public class CashierController {
    @Autowired
    private CashierService cashierService;

//    @GetMapping("收银界面.html")
//    public String showCashier(){
//        return "收银界面";
//    }

    @GetMapping("收银.html")
    public String Cashier(){
        return "收银";
    }

    @GetMapping("挂单.html")
    public String hangingOrder(){
        return "挂单";
    }

    @GetMapping("开卡.html")
    public String activateCard(){
        return "开卡";
    }

    @GetMapping("水单.html")
    public String waterBill(){
        return "水单";
    }

    @GetMapping("收支.html")
    public String revenueAndExpenditure(){
        return "收支";
    }

    @GetMapping("searchTestjj")
    public String searchTest(HttpServletRequest request){
        return "收支";
    }

    @GetMapping("modifyVip")  //修改会员信息
    public String modifyVip(Vip_information vip, HttpServletRequest request){
        System.out.println(vip.getVIP_NAME());
        System.out.println(vip.getVIP_PHONE());
        System.out.println(vip.getBIRTHDAY());
        System.out.println(vip.getCUSTOMER_SEX());
        System.out.println(vip.getOPENG_TIME());
        System.out.println(vip.getVIP_ID());
        System.out.println(vip.getVIP_TYPE());
        cashierService.insertVip(vip);
        return "开卡.html";
    }
}
