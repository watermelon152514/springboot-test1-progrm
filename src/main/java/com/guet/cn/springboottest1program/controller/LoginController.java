package com.guet.cn.springboottest1program.controller;


import com.alibaba.fastjson.JSON;
import com.guet.cn.springboottest1program.bean.EmployeeMoney;
import com.guet.cn.springboottest1program.bean.RechargeInformation;
import com.guet.cn.springboottest1program.bean.User;
import com.guet.cn.springboottest1program.service.EmployeeService;
import com.guet.cn.springboottest1program.service.RechargeInformationService;
import com.guet.cn.springboottest1program.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RechargeInformationService rechargeInformationService;

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


    //财务中心--->员工工资表--->员工工资表
    @RequestMapping("/YuanGongGongZiHtml")
    public String YuanGongGongZiHtml(){
        return "员工工资";
    }
    //财务中心--->员工工资表--->员工工资表(查询数据的ajax操作)
    @RequestMapping(value = "/YuanGongGongZiDataOperation")
    public void YuanGongGongZiDataOperation(HttpServletResponse httpServletResponse, String time,String type) throws IOException, ParseException {
        httpServletResponse.setCharacterEncoding("utf-8");
        List<EmployeeMoney> employeeMonies= employeeService.getEmployeeMoneyInformation(time,type);
        String str=JSON.toJSONString(employeeMonies);
        PrintWriter printWriter=httpServletResponse.getWriter();
        printWriter.println(str);
        printWriter.flush();
        printWriter.close();
    }
    //财务中心--->员工工资表--->员工工资表(得到店主总共要发多少工作)
    @RequestMapping("/YuanGongGongZiZongJi")
    public void YuanGongGongZiZongJi(HttpServletResponse httpServletResponse,String time,String type) throws IOException {
        httpServletResponse.setCharacterEncoding("utf-8");
        int zongJiMoney=employeeService.zongJiMoney(time,type);
        String str=JSON.toJSONString(zongJiMoney);
        PrintWriter printWriter=httpServletResponse.getWriter();
        printWriter.println(str);
        printWriter.flush();
        printWriter.close();
    }

    //财务中心--->营业记录--->充值开卡记录
    @RequestMapping("/ChongZhiKaiKaHtml")
    public String ChongZhiKaiKaHtml(){ return "充值开卡记录"; }
    //财务中心--->营业记录--->充值开卡记录表(查询数据的ajax操作)
    @RequestMapping(value = "/ChongZhiKaiKaDataOperation")
    public void ChongZhiKaiKaDataOperation(HttpServletResponse httpServletResponse,String before,String after,String type) throws IOException {
        System.out.println(before);
        System.out.println(after);
        System.out.println(type);
        if(type==null){
            List<RechargeInformation> rechargeInformations=rechargeInformationService.getAllDate(before,after);
            httpServletResponse.setCharacterEncoding("utf-8");

            String str=JSON.toJSONString(rechargeInformations);
            PrintWriter printWriter=httpServletResponse.getWriter();
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();
        }
        else if(type!=null){
            List<RechargeInformation> rechargeInformations=rechargeInformationService.getAllDates(before,after,type);
            httpServletResponse.setCharacterEncoding("utf-8");
            String str=JSON.toJSONString(rechargeInformations);
            PrintWriter printWriter=httpServletResponse.getWriter();
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();
        }

    }
    //财务中心--->营业记录--->充值开卡记录表(Button删除一行信息)
    @RequestMapping(value = "/ButtonDeleteRowOperation")
    public void ButtonDeleteRowOperation(HttpServletResponse httpServletResponse,String BILL_ID) throws IOException {
        httpServletResponse.setCharacterEncoding("utf-8");
        System.out.println(BILL_ID);
        rechargeInformationService.deleteInformation(BILL_ID);
        PrintWriter printWriter=httpServletResponse.getWriter();
        String str=null;
        printWriter.println(str);
        printWriter.flush();
        printWriter.close();
    }

}
