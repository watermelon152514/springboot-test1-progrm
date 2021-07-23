package com.guet.cn.springboottest1program.controller;

import com.guet.cn.springboottest1program.bean.vip_information;
import com.guet.cn.springboottest1program.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/vip")
public class vipController {
    String vip_type;
    String Sex;
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
    public String vipList(String VIP_TYPE,HttpServletRequest request){
        vip_type=VIP_TYPE;
        List<vip_information> vipsList=vipService.selectVip(VIP_TYPE);
        request.setAttribute("vip_information",vipService.selectVip(VIP_TYPE));

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
        vipList(vip_type,request);
        return "vipList.html";
    }
    @GetMapping("modifyVip")
    public String modifyVip(vip_information vip,HttpServletRequest request){
        System.out.println("修改");
        System.out.println(vip.getVIP_NAME());
        System.out.println(vip.getVIP_PHONE());
        if (vip.getVIP_NAME()!=null && vip.getVIP_PHONE()!=null) {
            vipService.modifyVip(vip.getVIP_NAME(),vip.getVIP_PHONE(),Card_id);
            vipList(vip_type,request);
            return "vipList.html";
        }else {
            return "vipList.html";
        }
    }
    @GetMapping("vipModify.html")
    public String vipModify(String VIP_ID,HttpServletRequest request){
        Card_id=VIP_ID;
        vip_information vip=vipService.selectVipById(VIP_ID);
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
