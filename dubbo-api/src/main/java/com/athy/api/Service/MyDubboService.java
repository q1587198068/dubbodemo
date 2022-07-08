package com.athy.api.Service;

import com.athy.api.pojo.User;

/**
 * Created by Administrator on 2022/7/7.
 */
public interface MyDubboService {
    String getName(String id);
    User getUser(String id);
}
