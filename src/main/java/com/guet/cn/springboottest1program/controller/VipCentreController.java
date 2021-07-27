package com.guet.cn.springboottest1program.controller;

import com.guet.cn.springboottest1program.bean.Sanke_information;
import com.guet.cn.springboottest1program.bean.Sms_information;
import com.guet.cn.springboottest1program.bean.Vip_information;
import com.guet.cn.springboottest1program.service.IVipCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vip")
public class VipCentreController {
    String vip_type=null;
    String customer_sex=null;
    String Card_id;
    String type=null;
    String time=null;
    @Autowired
    private IVipCentreService vipService;

    @GetMapping("vipCentra.html")
    public String showVipCentra(){
        return "vipCentra";
    }

    ////////////////////////////////////////////////////////////////////////
    //短信记录
    @GetMapping("sendAllChat.html") //查询发送短信记录
    public String showSendAllChat(HttpServletRequest request){
        List<Sms_information> smsList=vipService.viewSms();
        request.setAttribute("sms_information",smsList);
        request.setAttribute("sumSms",smsList.size());
        return "sendAllChat";
    }
    @GetMapping("deleteSms")  //删除短信记录
    public String deleteSms(String SENDTMIE,HttpServletRequest request){
        //不完善，发送时间并不唯一
        vipService.deleteSms(SENDTMIE);
        showSendAllChat(request);
        return "sendAllChat.html";
    }
    @GetMapping("searchSms") //模糊查询（发送时间，内容，备注）
    public String searchSms(HttpServletRequest request){
        String Sms=request.getParameter("searchSms");
        List<Sms_information> smsList=vipService.searchSms(Sms);
        request.setAttribute("sms_information",smsList);
        request.setAttribute("sumSms",smsList.size());
        return "sendAllChat";
    }

    /////////////////////////////////////////////////////////////////////////////
    //会员记录
    @GetMapping("vipList.html")  //跳转到会员列表页面
    public String showVipList(){
        return "vipList";
    }
    @GetMapping("vipList.do")  //搜索框和下拉选择框的查询处理
    public String vipList(String VIP_TYPE,String CUSTOMER_SEX,HttpServletRequest request){
        String searchT=request.getParameter("searchT");
        String searchVip=request.getParameter("searchVip");
        List<Vip_information> vipsList;
        System.out.println(searchVip);
        if (searchVip != null && searchVip != ""){
            vipsList=vipService.selectVip(vip_type,customer_sex,searchT,searchVip);
        }else {
            vipsList=vipService.selectVip(VIP_TYPE,CUSTOMER_SEX,searchT,searchVip);
            vip_type=VIP_TYPE;
            customer_sex=CUSTOMER_SEX;
        }


        //回显数据
        request.setAttribute("vip_information",vipsList);
        request.setAttribute("vip_type",vip_type);
        request.setAttribute("customer_sex",customer_sex);
        request.setAttribute("searchT",searchT);
        //页面tips中要用到的数据
        int card_amount=0;
        int gift_money=0;
        int integral=0;
        int packeage=0;
        int package_amount=0;
        int arrears=0;
        for(int i = 0 ; i < vipsList.size() ; i++) {
            card_amount+= vipsList.get(i).getCARD_MONEY();
            gift_money+=vipsList.get(i).getZENGSONG_MONEY();
            integral+=vipsList.get(i).getJIFEN();
            package_amount+=vipsList.get(i).getTAOCAN_REMAIN();
            arrears+=vipsList.get(i).getQIANKUAN();
            if (!vipsList.get(i).getTAOCAN_NUMBER().equals("无")){
                packeage++;
            }
        }
        request.setAttribute("a",vipsList.size());
        request.setAttribute("card_amount",card_amount);
        request.setAttribute("gift_money",gift_money);
        request.setAttribute("integral",integral);
        request.setAttribute("package_amount",package_amount);
        request.setAttribute("package",packeage);
        request.setAttribute("arrears",arrears);
        request.setAttribute("searchVip",searchVip);
        return "vipList.html";
    }

    @GetMapping("deleteVip")  //删除会员
    public String deleteVip(String VIP_ID,HttpServletRequest request){
        System.out.println(VIP_ID);
        vipService.deleteVip(VIP_ID);
        vipList(vip_type,customer_sex,request);
        return "vipList.html";
    }
    @GetMapping("modifyVip")  //修改会员信息
    public String modifyVip(Vip_information vip, HttpServletRequest request){
        if (vip.getVIP_NAME()!=null && vip.getVIP_PHONE()!=null) {
            System.out.println("修改");
            vipService.modifyVip(vip.getVIP_NAME(),vip.getVIP_PHONE(),Card_id);
            vipList(vip_type,customer_sex,request);
            return "vipList.html";
        }else {
            System.out.println("修改失败");
            return "vipList.html";
        }
    }
    @GetMapping("vipModify.html") //弹出修改框
    public String vipModify(String VIP_ID,HttpServletRequest request){
        Card_id=VIP_ID;
        Vip_information vip=vipService.selectVipById(VIP_ID);
        request.setAttribute("vipModify",vip);
        return "vipModify";
    }

    ////////////////////////////////////////////////////////////
    //散客记录
    @GetMapping("castList.html") //显示散客记录表
    public String showCastList(){
        return "castList";
    }
    @GetMapping("SankeList.do") //散客的选择查询
    public String SankeList(HttpServletRequest request,String TYPE,String TIME){
        String searchSanke=request.getParameter("searchSanke");
        List<Sanke_information> sankeList;

        if (searchSanke != null && searchSanke != ""){
            sankeList=vipService.selectSanke(type,time,searchSanke);
        }else {
            sankeList=vipService.selectSanke(TYPE,TIME,searchSanke);
            type=TYPE;
            time=TIME;
        }

        request.setAttribute("sanke_information",sankeList);
        request.setAttribute("sumSanke",sankeList.size());
        request.setAttribute("TYPE",type);
        request.setAttribute("TIME",time);
        request.setAttribute("searchSanke",searchSanke);
        return "castList.html";
    }

    @GetMapping("sendChat.html")
    public String showSendChat(){
        return "sendChat";
    }
}
