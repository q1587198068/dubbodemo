package com.athy.Service.Impl;


import com.athy.api.Service.MyDubboService;
import com.athy.api.pojo.User;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;

/**
 * Created by Administrator on 2022/7/7.
 */
//这里直接注入spring并且暴露接口实现类
@Service("myDubboService")
@DubboService(version = "1.0.0",timeout = 3000)
public class MyDubboServiceImpl implements MyDubboService{

    @Override
    public String getName(String id) {
        if(!"".equals(id)){
            return "hello"+id;
        }
        return "hello dubbo";
    }

    @Override
    public User getUser(String id) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "小明", 11));
        users.add(new User("2", "蔡徐坤", 11));
        users.add(new User("3", "打篮球", 11));
        users.add(new User("4", "唱跳", 11));
        users.add(new User("5", "RAP", 11));
        for (int i = 0; i <users.size() ; i++) {
            User user = users.get(i);
            if(id.equals(user.getId())){
                System.out.println(user.toString());
                return user;
            }
        }
        return new User("","查无此人",0);
    }
}
