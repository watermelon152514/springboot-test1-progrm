package com.guet.cn.springboottest1program.controller;


import com.guet.cn.springboottest1program.service.Impl.InsertEmpSeviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InsertEmpController {
    @Autowired
    private InsertEmpSeviceimpl insertEmpSeviceimpl;
    // 将excel导入到数据库
    @RequestMapping("insertEmpByExcel")
    @ResponseBody
    public ModelAndView insertEmpByExcel(Model model, @RequestParam("file") MultipartFile multipartFile) {
        System.out.println("ggggggggggg");
        ModelAndView modelAndView = new ModelAndView("redirect:TJYG.html");//要重定向到TJYG.html
        Integer integer = insertEmpSeviceimpl.insertEmpByExcel(multipartFile);

        if (integer > 0) {
            modelAndView.addObject("msg","通过Excel插入成功！");
            return modelAndView;
        }
        modelAndView.addObject("msg", "通过Excel插入失败!");
            return modelAndView;

    }
}
