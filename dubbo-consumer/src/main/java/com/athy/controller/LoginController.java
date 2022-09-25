package com.athy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.SunHints;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("tologin")
    @ResponseBody
    public String tologin(HttpServletRequest request, HttpServletResponse response,String username, String password) throws ServletException, IOException {
        System.out.println("username:"+username+"/password:"+password);

//进行登录验证
        if(null != username && "123456" .equals(password) ) {
            request.getSession().setAttribute("loginUser", "user");
            return "登录success！";
        }
        request.setAttribute("msg","密码错误，请输入123456。");
        request.getRequestDispatcher("/login/loginHTML").forward(request,response);
        return null;
    }

    @RequestMapping(value = {"/","loginHTML"})
        public String loginHTML(){
        return "login";
        }

}
