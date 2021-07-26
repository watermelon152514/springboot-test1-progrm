package com.guet.cn.springboottest1program.controller;

import com.guet.cn.springboottest1program.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cashier")
public class CashierController {
    @Autowired
    private CashierService cashierService;

    @GetMapping("收银界面.html")
    public String showCashier(){
        return "收银界面";
    }

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
}
