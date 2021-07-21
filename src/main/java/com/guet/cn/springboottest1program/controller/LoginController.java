package com.guet.cn.springboottest1program.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/HomePage")
    public String HomePage(){

        return "HomePage";
    }

    @RequestMapping("/AjaxToController")
    public void ShouYin(HttpServletResponse httpServletResponse) throws IOException {
        PrintWriter printWriter =httpServletResponse.getWriter();
        printWriter.println(JSON.toJSONString("完成操作！！！"));
        printWriter.flush();
        printWriter.close();
    }

    @RequestMapping("/ShouYinHtml")
    public String ShouYinHtml() {
        return "收银";
    }

    @RequestMapping("/KaiKaHtml")
    public String KaiKaHtml(){
        return "开卡";
    }

    @RequestMapping("/GuaDanHtml")
    public String GuaDanHtml(){
        return "挂单";
    }

    @RequestMapping("/ShuiDanHtml")
    public String ShuiDanHtml(){
        return "水单";
    }

    @RequestMapping("/ShouZhiHtml")
    public String ShouZhiHtml(){
        return "收支";
    }
}
