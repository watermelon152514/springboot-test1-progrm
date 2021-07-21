package com.guet.cn.springboottest1program.controller;

import com.alibaba.fastjson.JSON;
import com.guet.cn.springboottest1program.bean.User;
import com.guet.cn.springboottest1program.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



@Controller
public class UserController {

    @Autowired
    private UserService userServicer;


    @RequestMapping("/test")
    public String test(){
        System.out.println("/Method=/test Init--!!!!");
        List<User> users=userServicer.getAllUsers();
        for (User user:users){
            System.out.println(user);
        }
        return "test";
    }
    @RequestMapping("/message")
    public ModelAndView messageMethod(String account, String password){
        System.out.println("/Method=/message Init--!!!!");
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("用户名："+account);
        System.out.println("密码："+password);
        List<User> users=userServicer.getAllUsers();
        modelAndView.addObject("Users",users);
        modelAndView.setViewName("test1");
        return modelAndView;
    }

    @PostMapping("/setOperation")
    @ResponseBody
    public void setOperation(@ModelAttribute("User") User user,HttpServletResponse httpServletResponse) throws IOException {
        userServicer.setUser(user);

        PrintWriter printWriter =httpServletResponse.getWriter();
        printWriter.println(JSON.toJSONString("完成操作！！！"));
        printWriter.flush();
        printWriter.close();
    }
    @PostMapping("/addOperation")
    @ResponseBody
    public void addOperation(HttpServletResponse httpServletResponse,String name,String address) throws IOException {
        User lastUser=userServicer.getLastInformation();
        int id=lastUser.getId()+1;
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        userServicer.addUser(user);

        PrintWriter printWriter =httpServletResponse.getWriter();
        printWriter.println(JSON.toJSONString("完成操作！！！"));
        printWriter.flush();
        printWriter.close();
    }

    @PostMapping("/deleteOperation")
    @ResponseBody
    public void deleteOperation(HttpServletResponse httpServletResponse,int id) throws IOException {

        userServicer.deleteUser(id);
        PrintWriter printWriter=httpServletResponse.getWriter();
        printWriter.println(JSON.toJSONString("完成操作！！！"));
        printWriter.flush();
        printWriter.close();
    }

    @PostMapping("/lookforOperation")
    @ResponseBody
    public void lookforOperation(HttpServletResponse httpServletResponse,String name) throws IOException {

        List<User> users=userServicer.lookforUser(name);
        System.out.println(users.toString());
        PrintWriter printWriter=httpServletResponse.getWriter();
        printWriter.println(JSON.toJSON(users));
        printWriter.flush();
        printWriter.close();
    }
}
