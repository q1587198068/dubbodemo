package com.athy.controller;

import com.athy.api.Service.MyConsumerService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2022/9/15.
 */
@RestController
@RequestMapping("toconsume")
public class ToConsumeController {

    @DubboReference(check = false, protocol = "dubbo,hessian", loadbalance = "random", retries = 0)
    MyConsumerService myConsumerService;

    //一个服务即当提供者，又可以去消费
    @RequestMapping("toTest")
    public String toTest() {

        return myConsumerService.getMethod();
    }
}
