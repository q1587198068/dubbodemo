package com.athy.service.impl;

import com.athy.api.Service.MyConsumerService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service("myServiceImpl")
@DubboService()
public class MyServiceImpl implements MyConsumerService {

public String getMethod(){

    return "这是一个调用方法";
}
}
