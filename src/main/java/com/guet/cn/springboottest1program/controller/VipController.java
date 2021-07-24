package com.guet.cn.springboottest1program.controller;

import com.guet.cn.springboottest1program.bean.Vip_information;
import com.guet.cn.springboottest1program.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/vip")
public class VipController {
    String vip_type;
    String customer_sex;
    String Card_id;
    @Autowired
    private IVipService vipService;

    @GetMapping("vipCentra.html")
    public String showVipCentra(){
        return "vipCentra";
    }
    @GetMapping("sendAllChat.html")
    public String showSendAllChat(){
        return "sendAllChat";
    }
    @GetMapping("vipList.html")
    public String showVipList(){
        return "vipList";
    }
    @GetMapping("vipList.do")
    public String vipList(String VIP_TYPE,String CUSTOMER_SEX,HttpServletRequest request){
        String searchT=request.getParameter("searchT");
        vip_type=VIP_TYPE;
        customer_sex=CUSTOMER_SEX;
        List<Vip_information> vipsList=vipService.selectVip(VIP_TYPE,CUSTOMER_SEX,searchT);
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
        return "vipList.html";
    }
    @GetMapping("delete")
    public String deleteVip(String VIP_ID,HttpServletRequest request){
        System.out.println(VIP_ID);
        vipService.deleteVip(VIP_ID);
        vipList(vip_type,customer_sex,request);
        return "vipList.html";
    }
    @GetMapping("modifyVip")
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
    @GetMapping("vipModify.html")
    public String vipModify(String VIP_ID,HttpServletRequest request){
        Card_id=VIP_ID;
        Vip_information vip=vipService.selectVipById(VIP_ID);
        request.setAttribute("vipModify",vip);
        return "vipModify";
    }
    @GetMapping("castList.html")
    public String showCastList(){
        return "castList";
    }
    @GetMapping("sendChat.html")
    public String showSendChat(){
        return "sendChat";
    }
}
