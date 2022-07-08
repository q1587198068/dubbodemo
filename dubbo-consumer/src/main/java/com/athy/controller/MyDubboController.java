package com.athy.controller;

import com.athy.api.Service.MyDubboService;
import com.athy.api.pojo.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2022/7/8.
 */
@Controller
@RequestMapping("dubbo")

public class MyDubboController {
//check=false时  consumer启动时不会检查是否有provide提供服务，如果没有只会在调用时报错
//check=true时(默认为true) consumer启动是会检测有没有provide提供服务，如果没有启动报错
    @DubboReference(version = "1.0.0",check = true, protocol = "dubbo,hessian", loadbalance = "random",retries = 0)
    MyDubboService myDubboService;


    @RequestMapping("/getname")
    @ResponseBody
    public Object getName(@RequestParam String name) {
        String nameResult = myDubboService.getName(name);
        System.out.println("provide返回-"+nameResult);
        return nameResult;
    }
    @RequestMapping("/getuser")
    @ResponseBody
    public Object getuser(@RequestParam String id) {
        User user = myDubboService.getUser(id);
        System.out.println("provide返回-"+user.toString());
        return user;
    }
}
