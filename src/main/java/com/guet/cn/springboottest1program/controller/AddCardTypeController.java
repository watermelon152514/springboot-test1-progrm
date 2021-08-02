package com.guet.cn.springboottest1program.controller;

import com.guet.cn.springboottest1program.bean.Add_cardtype;
import com.guet.cn.springboottest1program.service.AddCardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddCardTypeController {
    @Autowired
    private AddCardTypeService addCardTypeService;

    @GetMapping("tklx_huksz.html")//显示添加卡类型
    public String viewtklx(HttpServletRequest request){
        System.out.println(request.getParameter("card_id"));
        String card_id=request.getParameter("card_id");
        if (card_id==null){
            request.setAttribute("AddCardType",addCardTypeService.viewAddCardType());
        }else {
           List<Add_cardtype> add_cardtype= addCardTypeService.selectById(card_id);
            request.setAttribute("AddCardType",add_cardtype);
        }

        return "tklx_huksz" ;
    }
    @GetMapping("deleteVipTypeById")
    public String  deleteVipTypeById(String card_id,HttpServletRequest request){
        addCardTypeService.deleteVipTypeById(card_id);
        return "redirect:tklx_huksz.html";
    }
    @GetMapping("modifyVipType")
    public String modifyVipCardType(String card_id ,HttpServletRequest request){
        Add_cardtype add_cardtype=addCardTypeService.getVipTypeById(card_id);
        request.setAttribute("modifyVipCardType",add_cardtype);

        return "tklx_huksz";

    }
    @GetMapping("tklx_kkczsz.html")
    public String turntklx_kkczsz(){
        return "tklx_kkczsz";
    }

}
