package com.springboot.springbootdemo.contorller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestContorller {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/testTh")
    public String testTh(Model model){
        model.addAttribute("name","Luo");
        return "test";
    }

    @RequestMapping("/update")
    public  String update(){
        return "user/update";
    }

    @RequestMapping("/add")
    public  String add(){
        return "user/add";
    }

    @RequestMapping("/toLogin")
    public  String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String userName, String password, Model model){
        String msg = "";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            subject.login(token);
            return "redirect:/testTh";
        }catch (UnknownAccountException e){
            msg = "用户名不存在";
        }catch (IncorrectCredentialsException e){
            msg="密码错误";
        }
        model.addAttribute("msg",msg);
        return "login";
    }
}
