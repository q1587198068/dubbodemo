package com.athy.service.impl;

import com.athy.api.Service.MyConsumerService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service("myServiceImpl")
@DubboService()
public class MyServiceImpl implements MyConsumerService {
    //一个服务即当消费者，又可以提供服务
public String getMethod(){

    return "这是一个调用方法";
}
}
